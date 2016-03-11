package levy.daniel.application.metier.controles.impl.controlessurface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import levy.daniel.application.metier.controles.AbstractControle;
import levy.daniel.application.metier.controles.CaractereDan;
import levy.daniel.application.metier.controles.rapportscontroles.LigneRapport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class ControleurTypeTexte :<br/>
 * Classe chargée de détecter si un fichier peut être un fichier texte 
 * (donc pas un .wav, .mp3, ...).<br/>
 * Contrôle dans sa méthode controler(File pFile) 
 * si le fichier pFile est de type texte 
 * et retourne true si c'est le cas.<br/>
 * Utilise pour celà le critère 'le fichier ne doit pas comporter de 
 * caractères indésirables' (aucun caractère du fichier ne 
 * doit être contenu dans CARACTERES_INDESIRABLES_SET).<br/> 
 * <br/>
 * - retourne false et rapporte si CARACTERES_INDESIRABLES_SET 
 * contient un des caractères de pFile.<br/>
 * - retourne true et génère un rapport favorable si pFile 
 * ne contient pas de caractères indésirables.<br/>
 * - Peut écrire le rapport de contrôle sous forme textuelle 
 * et csv sur disque.<br/> 
 * <br/>
 * - typeControle = Contrôle de surface.<br/>
 * - nomControle = Contrôle fichier texte.<br/>
 * - critere = Le fichier ne doit pas comporter de caractères indésirables 
 * (impossibles à écrire au clavier).<br/>
 * - gravite = '1 - Bloquant'.<br/>
 * - niveauAnomalie = "1".<br/>
 * - estBloquant = true.<br/>
 * <br/>
 * <br/>
 * Attributs : <br/>
 * [nomClasseConcrete;dateControle;dateControleStringFormatee;userName;
 * fichier;nomFichier;typeControle;nomControle;nomCritere;gravite;
 * niveauAnomalie;estBloquant;rapport].<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code>
 *  // Instanciation d'un ControleurTypeTexte.<br/>
 *  final ControleurTypeTexte control = new ControleurTypeTexte();<br/>
 *  // Invocation de la méthode controler(...) en demandant 
 *  l'écriture des rapports textuels et csv sur disque.<br/>
 *  final boolean resultat = control.controler(FILE_CHARETTE_ANSI, true);<br/>
 *  // resultat = true FILE_CHARETTE_ANSI est un fichier textuel.<br/>
 *  control.afficherRapportTextuel() // Pour voir le 
 *  rapport de contrôle sous forme textuelles.<br/>
 *  control.afficherRapportCsvAvecEntete() // Pour voir le 
 *  rapport de contrôle sous forme csv.<br/>
 *  // id;date du contrôle;utilisateur;Fichier;type de contrôle;Contrôle;
 *  Critère du Contrôle;Gravité du Contrôle;Numéro de Ligne;
 *  Message du Contrôle;Ordre du Champ;Position du Champ;
 *  Valeur du Champ;Action;<br/>
 *  // null;2016-03-06_19-08-55-259;Administrateur;
 *  chaàâreéèêëtte_ANSI.txt;Contrôle de surface;Contrôle fichier texte;
 *  Le fichier ne doit pas comporter de caractères indésirables 
 *  (impossibles à écrire au clavier);1 - anomalie bloquante;
 *  null;Le fichier 'chaàâreéèêëtte_ANSI.txt' est bien un fichier texte;
 *  null;sans objet;sans objet;OK - Fichier accepté;<br/> 
 *  control.afficherRapportEnregistrementTextuel() // Pour voir le compte-rendu 
 *  de l'enregistrement du rapport de contrôle sous forme textuelle.<br/>
 *  control.afficherRapportEnregistrementCsv() // Pour voir le compte-rendu 
 *  de l'enregistrement du rapport de contrôle sous forme csv.<br/>
 * </code>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * rapport, FileInputStream, rafraîchir le rapport, rafraichir le rapport<br/>
 * InputStreamReader, lecture caractère par caractère,<br/>
 * BufferedReader, <br/>
 * Conversion entier en caractère, cast entier en caractère, <br/>
 * boucle while (true),<br/> 
 * <br/>
 *
 * - Dépendances :<br/>
 * levy.daniel.application.ILecteurDecodeurFile.<br/>
 * levy.daniel.application.IListeurDeCaracteresUnicode.<br/>
 * levy.daniel.application.IExportateurCsv.<br/>
 * levy.daniel.application.IExportateurJTable.<br/>
 * levy.daniel.application.IResetable.<br/>
 * levy.daniel.application.metier.controles.rapportscontroles.LigneRapport.<br/>
 * levy.daniel.application.metier.service.enregistreursfichiers.rapportsenregistrements.LigneRapportEnregistrement.<br/>
 * levy.daniel.application.metier.controles.IEnregistreurRapport.<br/>
 * levy.daniel.application.metier.controles.IRapporteurControle.<br/>
 * levy.daniel.application.metier.controles.IControle.<br/>
 * levy.daniel.application.metier.controles.CaractereDan.<br/>
 * levy.daniel.application.metier.controles.AbstractControle.<br/>
 * <br/>
 *
 * - Identifiant Enterprise Architect : CONTROLE_SURFACE_01.<br/>
 * <br/>
 *
 * @author dan Lévy
 * @version 1.0
 * @since 27 févr. 2016
 *
 */
public class ControleurTypeTexte extends AbstractControle {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * CLASSE_CONTROLEURTYPETEXTE : String :<br/>
	 * "Classe ControleurTypeTexte".<br/>
	 */
	public static final String CLASSE_CONTROLEURTYPETEXTE 
		= "Classe ControleurTypeTexte";
	

	/**
	 * METHODE_CONTROLER : String :<br/>
	 * "Méthode controler(File pFile)".<br/>
	 */
	public static final String METHODE_CONTROLER 
		= "Méthode controler(File pFile)";
	
	
	/**
	 * CARACTERES_INDESIRABLES_SET : Set&lt;Character&gt; :<br/>
	 * Set contenant des caractères indésirables 
	 * (impossibles à écrire simplement au clavier).<br/>
	 */
	public static final Set<Character> CARACTERES_INDESIRABLES_SET 
		= new HashSet<Character>();
	
	
	static {
		
		/* ACUTE ACCENT '´' */
		CARACTERES_INDESIRABLES_SET.add('\u00b4');
		/* ACUTE ACCENT '`' */
		CARACTERES_INDESIRABLES_SET.add('\u0060');
		/* CIRCUMFLEX ACCENT '^' */
		CARACTERES_INDESIRABLES_SET.add('\u005e');
		/* BOX DRAWINGS DOUBLE DOWN AND LEFT '╗' */
		CARACTERES_INDESIRABLES_SET.add('\u2557');
		/* BOX DRAWINGS LIGHT DOWN AND LEFT '┐' */
		CARACTERES_INDESIRABLES_SET.add('\u2510');
		/* LATIN CAPITAL LETTER U WITH ACUTE 'Ú' */
		CARACTERES_INDESIRABLES_SET.add('\u00da');
		/* RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK '»' */
		CARACTERES_INDESIRABLES_SET.add('\u00bb');
		/* INVERTED QUESTION MARK '¿' */
		CARACTERES_INDESIRABLES_SET.add('\u00bf');		
		/* LATIN SMALL LETTER D WITH CARON 'ď' */
		CARACTERES_INDESIRABLES_SET.add('\u010f');
		/* LATIN SMALL LETTER T WITH CARON 'ť' */
		CARACTERES_INDESIRABLES_SET.add('\u0165');
		/* LATIN SMALL LETTER Z WITH DOT ABOVE 'ż' */
		CARACTERES_INDESIRABLES_SET.add('\u017c');
		/* LATIN 1 SUPPLEMENT 80 ' ' */
		CARACTERES_INDESIRABLES_SET.add('\u0080');		
		/* LATIN SMALL LETTER R WITH ACUTE 'ŕ' */
		CARACTERES_INDESIRABLES_SET.add('\u0155');
		/* LATIN SMALL LETTER C WITH CARON 'č' */
		CARACTERES_INDESIRABLES_SET.add('\u010d');
		/* LATIN SMALL LETTER E WITH OGONEK 'ę' */
		CARACTERES_INDESIRABLES_SET.add('\u0119');		
		/* LATIN CAPITAL LETTER O WITH ACUTE 'Ó' */
		CARACTERES_INDESIRABLES_SET.add('\u00d3');
		/* LATIN CAPITAL LETTER O WITH CIRCUMFLEX 'Ô' */
		CARACTERES_INDESIRABLES_SET.add('\u00d4');
		/* LATIN CAPITAL LETTER THORN 'Þ' */
		CARACTERES_INDESIRABLES_SET.add('\u00de');		
		/* LATIN CAPITAL LETTER U WITH GRAVE 'Ù' */
		CARACTERES_INDESIRABLES_SET.add('\u00d9');
		/* LATIN CAPITAL LETTER C WITH CEDILLA 'Ç' */
		CARACTERES_INDESIRABLES_SET.add('\u00c7');
		/* NKO LETTER HA 'ߤ' */
		CARACTERES_INDESIRABLES_SET.add('\u07e4');
		/* SYNCHRONOUS IDLE '' */
		CARACTERES_INDESIRABLES_SET.add('\u0016');
		/* INFORMATION SEPARATOR THREE ' ' */
		CARACTERES_INDESIRABLES_SET.add('\u001d');
		/* SYRIAC END OF PARAGRAPH '܀' */
		CARACTERES_INDESIRABLES_SET.add('\u0700');
		/* HEBREW LETTER HE 'ה' */
		CARACTERES_INDESIRABLES_SET.add('\u05d4');
		/* ARABIC LETTER REH WITH SMALL V BELOW 'ה' */
		CARACTERES_INDESIRABLES_SET.add('\u0695');
		/* ARABIC KASRATAN ' ٍ' */
		CARACTERES_INDESIRABLES_SET.add('\u064d');
		/* COPTIC SMALL LETTER GANGIA 'ϫ' */
		CARACTERES_INDESIRABLES_SET.add('\u03eb');
		
		/* NULL ' ' */
		CARACTERES_INDESIRABLES_SET.add('\u0000');
		/* null '޷' */
		CARACTERES_INDESIRABLES_SET.add('\u07b7');
		/* ACKNOWLEDGE '' */
		CARACTERES_INDESIRABLES_SET.add('\u0006');
		/* END OF TEXT '' */
		CARACTERES_INDESIRABLES_SET.add('\u0003');
		/* START OF HEADING '' */
		CARACTERES_INDESIRABLES_SET.add('\u0001');
		/* DEVICE CONTROL TWO '' */
		CARACTERES_INDESIRABLES_SET.add('\u0012');
		/* END OF TRANSMISSION '' */
		CARACTERES_INDESIRABLES_SET.add('\u0004');
		/* DEVICE CONTROL FOUR '' */
		CARACTERES_INDESIRABLES_SET.add('\u0014');
		/* BACKSPACE '' */
		CARACTERES_INDESIRABLES_SET.add('\u0008');
		/* ENQUIRY '' */
		CARACTERES_INDESIRABLES_SET.add('\u0005');
		/* BELL '' */
		CARACTERES_INDESIRABLES_SET.add('\u0007');
		/* CANCEL '' */
		CARACTERES_INDESIRABLES_SET.add('\u0018');
				
	}
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(ControleurTypeTexte.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ControleurTypeTexte() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 * - Met automatiquement 1 dans this.ordreControle.<br/>
	 * - Met automatiquement dateControle à date système.<br/>
	 * - Met automatiquement userName à "Administrateur".<br/>
	 * - Met automatiquement fichier à null.<br/>
	 * <br/>
	 * - Remplit le nom de la classe concrète this.nomClasseConcrete fourni 
	 * par this.fournirNomClasseConcrete() dans la classe concrète.<br/>
	 * - calcule automatiquement dateControleStringFormattee.<br/>
	 * - calcule automatiquement nomFichier.<br/>
	 * - Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.<br/>
	 * - Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.<br/>
	 * - Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.<br/>
	 * - Remplit gravite (ce qui remplit également niveauAnomalie).<br/>
	 * - Va chercher dans messagescontroles_fr_FR.properties 
	 * si le contrôle doit être effectué et remplit this.aEffectuer.<br/>
	 * <br/>
	 */
	public ControleurTypeTexte() {
		
		this(1, null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method CONSTRUCTEUR ControleurTypeTexte(
	 * File pFichier) :<br/>
	 * Constructeur avec fichier.<br/>
	 * <br/>
	 * - Met automatiquement 1 dans this.ordreControle.<br/>
	 * - Met automatiquement dateControle à date système.<br/>
	 * - Met automatiquement userName à "Administrateur".<br/>
	 * <br/>
	 * - Remplit le nom de la classe concrète this.nomClasseConcrete 
	 * fourni par this.fournirNomClasseConcrete() dans la classe concrète.<br/>
	 * - calcule automatiquement dateControleStringFormattee.<br/>
	 * - calcule automatiquement nomFichier.<br/>
	 * - Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.<br/>
	 * - Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.<br/>
	 * - Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.<br/>
	 * - Remplit gravite (ce qui remplit également niveauAnomalie).<br/>
	 * - Va chercher dans messagescontroles_fr_FR.properties 
	 * si le contrôle doit être effectué et remplit this.aEffectuer.<br/>
	 * <br/>
	 *
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 */
	public ControleurTypeTexte(
			final File pFichier) {
		
		this(1, null, null, pFichier);
		
	} // Fin de ControleurTypeTexte(
	 // File pFichier).____________________________________________________

	
	
	 /**
	 * method CONSTRUCTEUR ControleurTypeTexte(
	 * String pUserName
	 * , File pFichier) :<br/>
	 * Constructeur avec user et fichier.<br/>
	 * <br/>
	 * - Met automatiquement 1 dans this.ordreControle.<br/>
	 * - Met automatiquement dateControle à date système.<br/>
	 * <br/>
	 * - Remplit le nom de la classe concrète this.nomClasseConcrete 
	 * fourni par this.fournirNomClasseConcrete() dans la classe concrète.<br/>
	 * - calcule automatiquement dateControleStringFormattee.<br/>
	 * - remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.<br/>
	 * - calcule automatiquement nomFichier.<br/>
	 * - Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.<br/>
	 * - Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.<br/>
	 * - Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.<br/>
	 * - Remplit gravite (ce qui remplit également niveauAnomalie).<br/>
	 * - Va chercher dans messagescontroles_fr_FR.properties 
	 * si le contrôle doit être effectué et remplit this.aEffectuer.<br/>
	 * <br/>
	 *
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/> 
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 */
	public ControleurTypeTexte(
			final String pUserName
					, final File pFichier) {
		
		this(1, null, pUserName, pFichier);
		
	} // Fin de ControleurTypeTexte(
	 // String pUserName
	 // , File pFichier).__________________________________________________
	
	

	/**
	 * method CONSTRUCTEUR ControleurTypeTexte(COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 * <ul>
	 * <li>initialise éventuellement le bundleControles qui encapsule 
	 * messagescontroles_fr_FR.properties.</li><br/>
	 * <li>Remplit le nom de la classe concrète this.nomClasseConcrete fourni 
	 * par this.fournirNomClasseConcrete() dans la classe concrète.</li><br/>
	 * <li>passe pOrdreControle à this.ordreControle.</li><br/>
	 * <li>Remplit dateControle avec pDateControle si pDateControle != null 
	 * ou la date système sinon.</li><br/>
	 * <li>calcule automatiquement dateControleStringFormattee.</li><br/>
	 * <li>remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.</li><br/>
	 * <li>calcule automatiquement nomFichier.</li><br/>
	 * <li>Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.</li><br/>
	 * <li>Remplit gravite (ce qui remplit également niveauAnomalie 
	 * et estBloquant).</li><br/>
	 * <li>Va chercher dans messagescontroles_fr_FR.properties 
	 * si le contrôle doit être effectué et remplit this.aEffectuer.</li><br/>
	 * <ul>
	 * <br/>
	 *
	 * @param pOrdreControle : Integer : ordre d'exécution du contrôle
	 * @param pDateControle : Date : java.util.Date du contrôle.<br/>
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/> 
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 */
	public ControleurTypeTexte(
			final Integer pOrdreControle
			, final Date pDateControle
				, final String pUserName
					, final File pFichier) {
		
		super(pOrdreControle, pDateControle, pUserName, pFichier);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	

	
	/**
	 * method controler(
	 * File pFile) :<br/>
	 * Contrôle si le fichier pFile est de type texte 
	 * et retourne true si c'est le cas.<br/>
	 * Utilise pour celà le critère 'le fichier ne doit pas comporter de 
	 * caractères indésirables' (aucun caractère du fichier ne 
	 * doit être contenu dans CARACTERES_INDESIRABLES_SET).<br/>
	 * Lit le fichier caractère par caractère en UTF-8 en utilisant 
	 * un BufferedReader(InputStreamReader(fileInputStream, CHARSET_UTF8)) 
	 * et détecte les caractères indésirables.<br/> 
	 * <br/>
	 * - N'enregistre pas de rapport sur le disque.<br/>
	 * <br/>
	 * - retourne false et rapporte si CARACTERES_INDESIRABLES_SET 
	 * contient un des caractères de pFile.<br/>
	 * - retourne true et ne remplit pas de rapport si pFile 
	 * ne contient pas de caractères indésirables. 
	 * Le rapport est alors vide (pas null).<br/>
	 * <br/>
	 * - passe pFile à this.fichier et 
	 * rafraîchit automatiquement this.nomFichier.<br/>
	 * - rafraîchit le rapport (en instancie un nouveau 
	 * à chaque appel de la méthode controler(File pFile)).<br/>
	 * <br/>
	 * - retourne false, LOG de niveau INFO et rapport si pFile == null.<br/>
	 * - retourne false, LOG de niveau INFO et rapport si pFile 
	 * est inexistant.<br/>
	 * - retourne false, LOG de niveau INFO et rapport si pFile 
	 * est un répertoire.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier dont on veut savoir 
	 * si il est un fichier texte.<br/>
	 */
	@Override
	public final boolean controler(
			final File pFile) {
		
		return this.controler(pFile, false);
		
	} // Fin de controler(
	 // File pFile)._______________________________________________________
	
	
	
	/**
	 * method controler(
	 * File pFile
	 * , boolean pEnregistrerRapport) :<br/>
	 * Contrôle si le fichier pFile est de type texte 
	 * et retourne true si c'est le cas.<br/>
	 * Utilise pour celà le critère 'le fichier ne doit pas comporter de 
	 * caractères indésirables' (aucun caractère du fichier ne 
	 * doit être contenu dans CARACTERES_INDESIRABLES_SET).<br/>
	 * Lit le fichier caractère par caractère en UTF-8 en utilisant 
	 * un BufferedReader(InputStreamReader(fileInputStream, CHARSET_UTF8)) 
	 * et détecte les caractères indésirables.<br/> 
	 * <br/>
	 * - retourne false et rapporte si CARACTERES_INDESIRABLES_SET 
	 * contient un des caractères de pFile.<br/>
	 * - retourne true et remplit un rapport favorable si pFile 
	 * ne contient pas de caractères indésirables. <br/>
	 * <br/>
	 * - passe pFile à this.fichier et 
	 * rafraîchit automatiquement this.nomFichier.<br/>
	 * - rafraîchit le rapport (en instancie un nouveau 
	 * à chaque appel de la méthode controler(File pFile)).<br/>
	 * <br/>
	 * - retourne false, LOG de niveau INFO et rapport si pFile == null.<br/>
	 * - retourne false, LOG de niveau INFO et rapport si pFile 
	 * est inexistant.<br/>
	 * - retourne false, LOG de niveau INFO et rapport si pFile 
	 * est un répertoire.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier dont on veut savoir 
	 * si il est un fichier texte.<br/>
	 * @param pEnregistrerRapport : boolean : 
	 * true si on veut enregistrer le rapport dans un fichier sur disque.<br/>
	 * 
	 * @return : boolean : true si pFile est un fichier texte.<br/>
	 */
	@Override
	public final boolean controler(
			final File pFile
				, final boolean pEnregistrerRapport) {
		
		/* retourne false, LOG de niveau INFO 
		 * et rapport si pFile == null. */
		if (pFile == null) {
			
			/* LOG de niveau INFO. */
			loggerInfo(
					CLASSE_CONTROLEURTYPETEXTE
						, METHODE_CONTROLER
							, MESSAGE_FICHIER_NULL);
			
			/* rapport. */
			final LigneRapport ligneRapport 
				= creerLigneRapport(
						null
						, MESSAGE_FICHIER_NULL
						, null
						, SANS_OBJET
						, SANS_OBJET
						, false
						, ACTION_FICHIER_REFUSE);
			
			this.ajouterLigneRapport(ligneRapport);
			
			/* Enregistrement du rapport sur disque. */
			if (pEnregistrerRapport) {
				
				this.enregistrerRapportTextuelUTF8(this.fournirFileTxtUTF8());
				this.enregistrerRapportCsvUTF8(this.fournirFileCsvUTF8());
				
			}
			
			/* retourne false, LOG de niveau INFO 
			 * et rapport si pFile == null. */
			return false;
			
		} // Fin de if (pFile == null)._______________
		
		/* retourne false, LOG de niveau INFO 
		 * et rapport si pFile est inexistant. */
		if (!pFile.exists()) {
			
			/* LOG de niveau INFO. */
			loggerInfo(
					CLASSE_CONTROLEURTYPETEXTE
						, METHODE_CONTROLER
							, MESSAGE_FICHIER_INEXISTANT
								, pFile.getAbsolutePath());
			
			/* rapport. */
			final LigneRapport ligneRapport 
				= creerLigneRapport(
						null
						, MESSAGE_FICHIER_INEXISTANT + pFile.getAbsolutePath()
						, null
						, SANS_OBJET
						, SANS_OBJET
						, false
						, ACTION_FICHIER_REFUSE);
						
			this.ajouterLigneRapport(ligneRapport);
			
			/* Enregistrement du rapport sur disque. */
			if (pEnregistrerRapport) {
				
				this.enregistrerRapportTextuelUTF8(this.fournirFileTxtUTF8());
				this.enregistrerRapportCsvUTF8(this.fournirFileCsvUTF8());
				
			}
			
			/* retourne false, LOG de niveau INFO 
			 * et rapport si pFile est inexistant. */
			return false;
			
		} // Fin de if (!pFile.exists())._________________________
		
		/* retourne false, LOG de niveau INFO 
		 * et rapport si pFile est un répertoire. */
		if (pFile.isDirectory()) {
			
			/* LOG de niveau INFO. */
			loggerInfo(
					CLASSE_CONTROLEURTYPETEXTE
						, METHODE_LIREFICHIER
							, MESSAGE_FICHIER_REPERTOIRE
								, pFile.getAbsolutePath());
			
			/* rapport. */
			final LigneRapport ligneRapport 
				= creerLigneRapport(
						null
						, MESSAGE_FICHIER_REPERTOIRE + pFile.getAbsolutePath()
						, null
						, SANS_OBJET
						, SANS_OBJET
						, false
						, ACTION_FICHIER_REFUSE);
						
			this.ajouterLigneRapport(ligneRapport);
			
			/* Enregistrement du rapport sur disque. */
			if (pEnregistrerRapport) {
				
				this.enregistrerRapportTextuelUTF8(this.fournirFileTxtUTF8());
				this.enregistrerRapportCsvUTF8(this.fournirFileCsvUTF8());
				
			}
			
			/* retourne false, LOG de niveau INFO 
			 * et rapport si pFile est un répertoire. */
			return false;
			
		} // Fin de if (pFile.isDirectory())._______________________


		/* passe pFile à this.fichier et 
		 * rafraîchit automatiquement this.nomFichier. */
		this.setFichier(pFile);
		
		/* rafraîchit le rapport (en instancie un nouveau à chaque appel 
		 * de la méthode controler(File pFile)). */
		this.rapport = new ArrayList<LigneRapport>();
		
		
		// LECTURE ***************
		FileInputStream fileInputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;

		int characterEntier = 0;
		Character character = null;
		int position = 0;

		try {

			// LECTURE DU FICHIER CARACTERE PAR CARACTERE **************.
			/*
			 * Instancie un flux en lecture fileInputStream en lui passant
			 * pFile.
			 */
			fileInputStream = new FileInputStream(pFile);

			/*
			 * Instancie un InputStreamReader en lui passant le FileReader et le
			 * Charset UTF-8.
			 */
			inputStreamReader = new InputStreamReader(fileInputStream,
					CHARSET_UTF8);

			/*
			 * Instancie un tampon de flux de caractères en lecture en lui
			 * passant le flux inputStreamReader.
			 */
			bufferedReader = new BufferedReader(inputStreamReader);

			/* Parcours du bufferedReader. */
			while (true) {
				
				position++;
				
				/* Lecture de chaque caractère. */
				characterEntier = bufferedReader.read();

				/* Arrêt de la lecture si fin de fichier. */
				if (characterEntier < 0) {
					break;
				}

				/* Conversion de l'entier en caractère. */
				character = (char) characterEntier;

				// TEST DU CRITERE ****************************************
				/* Teste si le fichier contient un caractère indésirable 
				 * et retourne false si c'est le cas. */
				if (CARACTERES_INDESIRABLES_SET.contains(character)) {
					
					/* Constitution du message pour le rapport. */
					final String message 
						= new CaractereDan(position, character).toString();
					
					/* rapport. */
					final LigneRapport ligneRapport 
						= creerLigneRapport(
								null
								, message
								, position
								, String.valueOf(position)
								, String.valueOf(character)
								, false
								, ACTION_FICHIER_REFUSE);
								
					this.ajouterLigneRapport(ligneRapport);
					
					/* Enregistrement du rapport sur disque. */
					if (pEnregistrerRapport) {
						
						this.enregistrerRapportTextuelUTF8(
								this.fournirFileTxtUTF8());
						this.enregistrerRapportCsvUTF8(
								this.fournirFileCsvUTF8());
						
					}
					
					/* retourne false et rapporte si 
					 * CARACTERES_INDESIRABLES_SET contient 
					 * un des caractères de pFile. */
					return false;
					
				} // Fin de if (CARACTERES_INDESIRABLES_SET
				// .contains(character)).______________________

			} // Fin du parcours du bufferedReader._________
			
			
			/* rapport. */
			
			final String message 
				= "Le fichier '" 
						+ pFile.getName() 
						+ "' est bien un fichier texte";
			
			final LigneRapport ligneRapport 
				= creerLigneRapport(
						null
						, message
						, null
						, SANS_OBJET
						, SANS_OBJET
						, true
						, ACTION_FICHIER_ACCEPTE);
						
			this.ajouterLigneRapport(ligneRapport);
			
			/* Enregistrement du rapport sur disque. */
			if (pEnregistrerRapport) {
				
				this.enregistrerRapportTextuelUTF8(
						this.fournirFileTxtUTF8());
				this.enregistrerRapportCsvUTF8(
						this.fournirFileCsvUTF8());
				
			}

		} catch (FileNotFoundException fnfe) {

			/* LOG de niveau ERROR. */
			loggerError(CLASSE_CONTROLEURTYPETEXTE, METHODE_LIREFICHIER, fnfe);

			/* retourne false si exception. */
			return false;

		} catch (IOException ioe) {

			/* LOG de niveau ERROR. */
			loggerError(CLASSE_CONTROLEURTYPETEXTE, METHODE_LIREFICHIER, ioe);

			/* retourne false si exception. */
			return false;
		}

		finally {

			/* fermeture du flux BufferedReader. */
			if (bufferedReader != null) {

				try {

					bufferedReader.close();

				} catch (IOException ioe2) {

					/* LOG de niveau ERROR. */
					loggerError(CLASSE_CONTROLEURTYPETEXTE,
							METHODE_LIREFICHIER, ioe2);

				}

			} // Fin de if (bufferedReader != null).____

			/* fermeture du flux inputStreamReader. */
			if (inputStreamReader != null) {

				try {

					inputStreamReader.close();

				} catch (IOException ioe4) {

					/* LOG de niveau ERROR. */
					loggerError(CLASSE_CONTROLEURTYPETEXTE,
							METHODE_LIREFICHIER, ioe4);
				}

			} // Fin de if (inputStreamReader != null).______

			/* fermeture du flux fileInputStream. */
			if (fileInputStream != null) {

				try {

					fileInputStream.close();

				} catch (IOException ioe3) {

					/* LOG de niveau ERROR. */
					loggerError(CLASSE_CONTROLEURTYPETEXTE,
							METHODE_LIREFICHIER, ioe3);

				}

			} // Fin de if (fileInputStream != null).________

		} // Fin du finally._____________________________

		return true;
		
	} // Fin de controler(
	// File pFile
	// , boolean pEnregistrerRapport)._____________________________________


	
	/**
	 * method controler(
	 * String pString
	 * , boolean pEnregistrerRapport) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pString : String :
	 * @param pEnregistrerRapport : boolean : 
	 * true si on veut enregistrer le rapport dans un fichier sur disque.<br/>
	 * 
	 * @return : boolean :  .<br/>
	 */
	@Override
	public final boolean controler(
			final String pString
				, final boolean pEnregistrerRapport) {
		return false;
	} // Fin de controler(
	 // String pString
	// , boolean pEnregistrerRapport)._____________________________________
	



	/**
	 * "Classe ControleurTypeTexte".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected final String fournirNomClasseConcrete() {
		return CLASSE_CONTROLEURTYPETEXTE;
	} // Fin de fournirNomClasseConcrete().________________________________
	
	

	/**
	 * "Contrôle de surface".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected final String fournirTypeControle() {
		return "Contrôle de surface";
	} // Fin de fournirTypeControle()._____________________________________


	/**
	 * "Contrôle fichier texte".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected final String fournirNomControle() {
		return "Contrôle fichier texte";
	} // Fin de fournirNomControle().______________________________________



	/**
	 * "Le fichier ne doit pas comporter de caractères 
	 * indésirables (impossibles à écrire au clavier)".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected final String fournirNomCritere() {
		return "Le fichier ne doit pas comporter de caractères "
				+ "indésirables (impossibles à écrire au clavier)";
	} // Fin de fournirNomCritere()._______________________________________



	/**
	 * "ControleurTypeTexte.niveau.anomalie".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected final String fournirCleNiveauAnomalie() {
		return "ControleurTypeTexte.niveau.anomalie";
	} // Fin de fournirCleNiveauAnomalie().________________________________



	/**
	 * "1".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected final String fournirNiveauAnomalieEnDur() {
		return "1";
	} // Fin de fournirNiveauAnomalieEnDur().______________________________

	
	
	/**
	 * "RAPPORT-CONTROLE-FICHIER-TEXTE".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected final String fournirBaseNomRapport() {
		return "RAPPORT-CONTROLE-FICHIER-TEXTE";
	} // Fin de fournirBaseNomRapport().___________________________________



	/**
	 * "ControleurTypeTexte.aEffectuer".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirCleAEffectuer() {
		return "ControleurTypeTexte.aEffectuer";
	} // Fin de fournirCleAEffectuer().____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean fournirAEffectuerEnDur() {
		return true;
	} // Fin de fournirAEffectuerEnDur().__________________________________
	
	
	
} // FIN DE LA CLASSE ControleurTypeTexte.-----------------------------------
