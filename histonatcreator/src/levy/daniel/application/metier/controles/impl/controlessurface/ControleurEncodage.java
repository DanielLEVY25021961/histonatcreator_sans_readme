package levy.daniel.application.metier.controles.impl.controlessurface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.metier.controles.AbstractControle;
import levy.daniel.application.metier.controles.CaractereDan;
import levy.daniel.application.metier.controles.rapportscontroles.LigneRapport;


/**
 * class ControleurEncodage :<br/>
 * Classe chargée de détecter si un fichier texte est encodé 
 * avec this.charset.<br/>
 * Contrôle dans sa méthode controler(File pFile) 
 * si le fichier pFile est encodé avec this.charset 
 * et retourne true si c'est le cas.<br/>
 * Utilise pour celà le critère ' ' ( ).<br/> 
 * <br/>
 * - retourne false et rapporte si .<br/>
 * - retourne true et génère un rapport favorable si pFile 
 * a été encodé avec this.charset.<br/>
 * - Peut écrire le rapport de contrôle sous forme textuelle 
 * et csv sur disque.<br/> 
 * <br/>
 * - typeControle = Contrôle de surface.<br/>
 * - nomControle = Contrôle d'encodage du fichier.<br/>
 * - critere =  .<br/>
 * - gravite = '1 - Bloquant'.<br/>
 * - niveauAnomalie = "1".<br/>
 * - estBloquant = true.<br/>
 * <br/>
 * <br/>
 * Attributs hérités de AbstractControle : <br/>
 * [nomClasseConcrete;ordreControle;dateControle
 * ;dateControleStringFormatee;userName;
 * fichier;nomFichier;typeControle;nomControle;nomCritere;gravite;
 * niveauAnomalie;estBloquant;aEffectuer;rapport;rapportEnregistrement;].<br/>
 * <br/>
 * Attributs de la classe :<br/>
 * charset<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 11 mars 2016
 *
 */
public class ControleurEncodage extends AbstractControle {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * CLASSE_CONTROLEURENCODAGE : String :<br/>
	 * "Classe ControleurEncodage".<br/>
	 */
	public static final String CLASSE_CONTROLEURENCODAGE 
		= "Classe ControleurEncodage";
	
	
	/**
	 * charset : Charset :<br/>
	 * Charset à tester sur le fichier 
	 * pour savoir si il a été encodé avec ce Charset.<br/>
	 */
	private Charset charset;
	
	
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
		/* LATIN CAPITAL LETTER U WITH CIRCUMFLEX 'Û' */
		CARACTERES_INDESIRABLES_SET.add('\u00db');
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
		
		/* REPLACEMENT CHARACTER '�' */
		CARACTERES_INDESIRABLES_SET.add('\ufffd');
		/* LATIN CAPITAL LETTER A WITH TILDE 'Ã' */
		CARACTERES_INDESIRABLES_SET.add('\u00c3');
		/* COPYRIGHT SIGN '©' */
		CARACTERES_INDESIRABLES_SET.add('\u00a9');
		/* DIAERESIS '¨' */
		CARACTERES_INDESIRABLES_SET.add('\u00a8');
		/* CHARACTER TABULATION WITH JUSTIFICATION ' ' */
		CARACTERES_INDESIRABLES_SET.add('\u0089');
		/* LINE TABULATION SET ' ' */
		CARACTERES_INDESIRABLES_SET.add('\u008a');
		/* PER MILLE SIGN '‰' */
		CARACTERES_INDESIRABLES_SET.add('\u2030');
		/* LATIN CAPITAL LETTER S WITH CARON 'Š' */
		CARACTERES_INDESIRABLES_SET.add('\u0160');
		/* SINGLE LOW-9 QUOTATION MARK '‚' */
		CARACTERES_INDESIRABLES_SET.add('\u201a');
		/* BREAK PERMITTED HERE ' ' */
		CARACTERES_INDESIRABLES_SET.add('\u0082');
	}
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(ControleurEncodage.class);

	
	
	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR ControleurEncodage() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 * - Met automatiquement 3 dans this.ordreControle.<br/>
	 * - Met automatiquement dateControle à date système.<br/>
	 * - Met automatiquement userName à "Administrateur".<br/>
	 * - Met automatiquement this.file à null.<br/>
	 * - Met automatiquement this.charset à CHARSET_UTF8.<br/>
	 * <br/>
	 * <ul>
	 * <li>initialise éventuellement le bundleControles qui encapsule 
	 * messagescontroles_fr_FR.properties.</li><br/>
	 * <li>Remplit le nom de la classe concrète this.nomClasseConcrete 
	 * fourni par this.fournirNomClasseConcrete() dans la classe concrète.</li><br/>
	 * <li>calcule automatiquement dateControleStringFormattee.</li><br/>
	 * <li>remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.</li><br/>
	 * <li>passe null à this.fichier.</li><br/>
	 * <li>calcule automatiquement nomFichier.</li><br/>
	 * <li>Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.</li><br/>
	 * <li>Remplit gravite (ce qui remplit également niveauAnomalie).</li><br/>
	 * <li>Va chercher dans messagescontroles_fr_FR.properties 
	 * si le contrôle doit être effectué et remplit this.aEffectuer.</li><br/>
	 * <li>passe CHARSET_UTF8 à this.charset.</li><br/>
	 * </ul>
	 * <br/>
	 */
	public ControleurEncodage() {
		
		this(3, null, null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	 /**
	 * method CONSTRUCTEUR ControleurEncodage(
	 * File pFichier
	 * , Charset pCharset) :<br/>
	 * Constructeur avec fichier et charset.<br/>
	 * <br/>
	 * - Met automatiquement 3 dans this.ordreControle.<br/>
	 * - Met automatiquement dateControle à date système.<br/>
	 * - Met automatiquement userName à "Administrateur".<br/>
	 * <br/>
	 * <ul>
	 * <li>initialise éventuellement le bundleControles qui encapsule 
	 * messagescontroles_fr_FR.properties.</li><br/>
	 * <li>Remplit le nom de la classe concrète this.nomClasseConcrete 
	 * fourni par this.fournirNomClasseConcrete() dans la classe concrète.</li><br/>
	 * <li>calcule automatiquement dateControleStringFormattee.</li><br/>
	 * <li>remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.</li><br/>
	 * <li>passe pFichier à this.fichier.</li><br/>
	 * <li>calcule automatiquement nomFichier.</li><br/>
	 * <li>Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.</li><br/>
	 * <li>Remplit gravite (ce qui remplit également niveauAnomalie).</li><br/>
	 * <li>Va chercher dans messagescontroles_fr_FR.properties 
	 * si le contrôle doit être effectué et remplit this.aEffectuer.</li><br/>
	 * <li>passe pCharset à this.charset si pCharset n'est pas null. 
	 * CHARSET_UTF8 sinon.</li><br/>
	 * </ul>
	 * <br/>
	 *
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 * @param pCharset : Charset : Charset à tester sur le fichier 
	 * pour savoir si il a été encodé avec ce Charset.<br/>
	 */
	public ControleurEncodage(
				final File pFichier
					, final Charset pCharset) {
	
		this(3, null, null, pFichier, pCharset);
	
	} // Fin de ControleurEncodage(
	 // File pFichier
	 // , Charset pCharset)._______________________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ControleurEncodage(
	 * String pUserName
	 * , File pFichier
	 * , Charset pCharset) :<br/>
	 * Constructeur avec user, fichier et charset.<br/>
	 * <br/>
	 * - Met automatiquement 3 dans this.ordreControle.<br/>
	 * - Met automatiquement dateControle à date système.<br/>
	 * <br/>
	 * <ul>
	 * <li>initialise éventuellement le bundleControles qui encapsule 
	 * messagescontroles_fr_FR.properties.</li><br/>
	 * <li>Remplit le nom de la classe concrète this.nomClasseConcrete 
	 * fourni par this.fournirNomClasseConcrete() dans la classe concrète.</li><br/>
	 * <li>calcule automatiquement dateControleStringFormattee.</li><br/>
	 * <li>remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.</li><br/>
	 * <li>passe pFichier à this.fichier.</li><br/>
	 * <li>calcule automatiquement nomFichier.</li><br/>
	 * <li>Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.</li><br/>
	 * <li>Remplit gravite (ce qui remplit également niveauAnomalie).</li><br/>
	 * <li>Va chercher dans messagescontroles_fr_FR.properties 
	 * si le contrôle doit être effectué et remplit this.aEffectuer.</li><br/>
	 * <li>passe pCharset à this.charset si pCharset n'est pas null. 
	 * CHARSET_UTF8 sinon.</li><br/>
	 * </ul>
	 * <br/>
	 *
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/> 
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 * @param pCharset : Charset : Charset à tester sur le fichier 
	 * pour savoir si il a été encodé avec ce Charset.<br/>
	 */
	public ControleurEncodage(
				final String pUserName
					, final File pFichier
						, final Charset pCharset) {
		
		this(3, null, pUserName, pFichier, pCharset);
		
	} // Fin de ControleurEncodage(
	 // String pUserName
	 // , File pFichier
	 // , Charset pCharset)._______________________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ControleurEncodage() :<br/>
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
	 * <li>passe pFichier à this.fichier.</li><br/>
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
	 * <li>passe pCharset à this.charset si pCharset n'est pas null. 
	 * CHARSET_UTF8 sinon.</li><br/>
	 * </ul>
	 * <br/>
	 *
	 * @param pOrdreControle : Integer : ordre d'exécution du contrôle
	 * @param pDateControle : Date : java.util.Date du contrôle.<br/>
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/> 
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 * @param pCharset : Charset : Charset à tester sur le fichier 
	 * pour savoir si il a été encodé avec ce Charset.<br/>
	 */
	public ControleurEncodage(
			final Integer pOrdreControle
			, final Date pDateControle
				, final String pUserName
					, final File pFichier
						, final Charset pCharset) {
		
		super(pOrdreControle, pDateControle, pUserName, pFichier);
		
		/* passe pCharset à this.charset si pCharset n'est pas null. 
		 * CHARSET_UTF8 sinon. */
		this.charset = this.fournirCharset(pCharset);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	

	
	/**
	 * method fournirCharset(
	 * Charset pCharset) :<br/>
	 * - retourne pCharset si pCharset n'est pas null.<br/>
	 * - retourne CHARSET_UTF8 si pCharset est null.<br/>
	 * <br/>
	 *
	 * @param pCharset : Charset.<br/>
	 * 
	 * @return : Charset : pCharset ou CHARSET_UTF8.<br/>
	 */
	private Charset fournirCharset(
			final Charset pCharset) {

		/* retourne CHARSET_UTF8 si pCharset est null. */
		if (pCharset == null) {
			return CHARSET_UTF8;
		}

		return pCharset;

	} // Fin de fournirCharset(
	 // Charset pCharset)._________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean controler(
			final File pFile) {
		
		return this.controler(pFile, false);
		
	} // Fin de controler(
	 // File pFile)._______________________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean controler(
			final File pFile
				, final boolean pEnregistrerRapport) {
		
		// Traitement des mauvais fichiers.************
		final boolean resultatTraitementMauvaisFichier 
			= this.traiterMauvaisFile(
					pFile, pEnregistrerRapport, METHODE_CONTROLER);
		
		/* Sort de la méthode et retourne false si le fichier est mauvais. */
		if (!resultatTraitementMauvaisFichier) {
			return false;
		}

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

		Character caractere = null;
		int numeroLigne = 0;
		boolean resultat = true;
		

		try {

			// LECTURE DU FICHIER LIGNE PAR LIGNE. *******************.
			/*
			 * Instancie un flux en lecture fileInputStream en lui passant
			 * pFile.
			 */
			fileInputStream = new FileInputStream(pFile);

			/*
			 * Instancie un InputStreamReader en lui passant le FileReader 
			 * et this.charset
			 */
			inputStreamReader = new InputStreamReader(fileInputStream,
					this.charset);

			/*
			 * Instancie un tampon de flux de caractères en lecture en lui
			 * passant le flux inputStreamReader.
			 */
			bufferedReader = new BufferedReader(inputStreamReader);

			// LECTURE LIGNE PAR LIGNE.*******************************
			/* Parcours du bufferedReader. */
			while (true) {
				
				/* incrémente le numéro de la ligne lue. */
				numeroLigne ++;
				
				/* Lecture ligne par ligne. */
				final String ligneLue = bufferedReader.readLine();
				
				/* Arrêt de la lecture si fin de fichier. */
				if (ligneLue == null) {
					break;
				}
				
				int positionCarDansLigne = 0;
				
				// LECTURE DES CARACTERES DE LA LIGNE.******************
				final int longueurLigne = ligneLue.length();
				
				/* Parcours de la ligne. */
				for (int i = 0; i < longueurLigne; i++) {
					
					/* incrémente la position du caractère 
					 * dans la ligne lue. */
					positionCarDansLigne++;
					
					/* Lecture du caractère à la i-ème position 
					 * dans la ligneLue. */
					caractere = ligneLue.charAt(i);
					
					// TEST DU CRITERE ****************************************
					/* Teste si le fichier contient un caractère indésirable 
					 * et met le réesultat à false si c'est le cas. */
					if (CARACTERES_INDESIRABLES_SET.contains(caractere)) {
						
						/* Constitution du message pour le rapport. */
						final String message 
							= new CaractereDan(
									positionCarDansLigne, caractere).toString();
						
						/* rapport. */
						final LigneRapport ligneRapport 
							= creerLigneRapport(
									numeroLigne
									, message
									, null
									, String.valueOf(positionCarDansLigne)
									, String.valueOf(caractere)
									, false
									, ACTION_FICHIER_REFUSE);
						
						/* Ajoute une ligne au rapport 
						 * pour le caractère déficient. */
						this.ajouterLigneRapport(ligneRapport);
						
						/* Passe le resultat à false. */
						resultat = false;
						
					} // Fin de if (CARACTERES_INDESIRABLES_SET
					// .contains(character)).______________________
					
				} // Fin du Parcours de la ligne.__________________________
								
			} // Fin du parcours du bufferedReader.__________________________
			
			if (resultat) {	
				
				/* rapport. ********/
				/* Création du message du rapport de contrôle. */
				final String message 
					= "Le fichier '" 
							+ pFile.getName() 
							+ "' est bien un fichier texte encodé en " 
							+ this.charset.name();
				
				/* Création d'une ligne de rapport. */
				final LigneRapport ligneRapport 
					= creerLigneRapport(
							null
							, message
							, null
							, SANS_OBJET
							, SANS_OBJET
							, true
							, ACTION_FICHIER_ACCEPTE);
				
				/* Ajout de la ligne de rapport au rapport de contrôle. */
				this.ajouterLigneRapport(ligneRapport);
			}
			else {
				
				/* rapport. ********/
				/* Création du message du rapport de contrôle. */
				final String message 
					= "Le fichier '" 
							+ pFile.getName() 
							+ "' n'est pas un fichier texte encodé en " 
							+ this.charset.name();
				
				/* Création d'une ligne de rapport. */
				final LigneRapport ligneRapport 
					= creerLigneRapport(
							null
							, message
							, null
							, SANS_OBJET
							, SANS_OBJET
							, false
							, ACTION_FICHIER_REFUSE);
				
				/* Ajout de la ligne de rapport au rapport de contrôle. */
				this.ajouterLigneRapport(ligneRapport);
				
			}
			
			
			/* Enregistrement du rapport sur disque. */
			if (pEnregistrerRapport) {
				
				this.enregistrerRapportTextuelUTF8(
						this.fournirFileTxtUTF8());
				this.enregistrerRapportCsvUTF8(
						this.fournirFileCsvUTF8());
				
			} // Fin de if (pEnregistrerRapport).________________
						
			/* retourne false et rapporte si 
			 * CARACTERES_INDESIRABLES_SET contient 
			 * un des caractères de pFile. */
			/* retourne true et rapporte si 
			 * le fichier a bien été encodé avec this.charset. */
			return resultat;

		} catch (FileNotFoundException fnfe) {

			/* LOG de niveau ERROR. */
			loggerError(
					this.fournirNomClasseConcrete(), METHODE_CONTROLER, fnfe);

			/* retourne false si exception. */
			return false;

		} catch (IOException ioe) {

			/* LOG de niveau ERROR. */
			loggerError(
					this.fournirNomClasseConcrete(), METHODE_CONTROLER, ioe);

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
					loggerError(
							this.fournirNomClasseConcrete()
								, METHODE_CONTROLER, ioe2);

				}

			} // Fin de if (bufferedReader != null).____

			/* fermeture du flux inputStreamReader. */
			if (inputStreamReader != null) {

				try {

					inputStreamReader.close();

				} catch (IOException ioe4) {

					/* LOG de niveau ERROR. */
					loggerError(this.fournirNomClasseConcrete(),
							METHODE_CONTROLER, ioe4);
				}

			} // Fin de if (inputStreamReader != null).______

			/* fermeture du flux fileInputStream. */
			if (fileInputStream != null) {

				try {

					fileInputStream.close();

				} catch (IOException ioe3) {

					/* LOG de niveau ERROR. */
					loggerError(this.fournirNomClasseConcrete(),
							METHODE_CONTROLER, ioe3);

				}

			} // Fin de if (fileInputStream != null).________

		} // Fin du finally._____________________________

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
	 * "Classe ControleurEncodage".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirNomClasseConcrete() {
		return CLASSE_CONTROLEURENCODAGE;
	} // Fin de fournirNomClasseConcrete().________________________________
	
	

	/**
	 * "Contrôle de surface".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirTypeControle() {
		return "Contrôle de surface";
	} // Fin de fournirTypeControle()._____________________________________
	
	

	/**
	 * "Contrôle d'encodage du fichier".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirNomControle() {
		return "Contrôle d'encodage du fichier";
	} // Fin de fournirNomControle().______________________________________

	
	
	/**
	 * "Un fichier doit être uniformément encodé avec un même charset".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirNomCritere() {
		return "Un fichier doit être uniformément encodé avec un même charset";
	} // Fin de fournirNomCritere()._______________________________________

	
	
	/**
	 * "ControleurEncodage.niveau.anomalie".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirCleNiveauAnomalie() {
		return "ControleurEncodage.niveau.anomalie";
	} // Fin de fournirCleNiveauAnomalie().________________________________

	
	
	/**
	 * "1".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirNiveauAnomalieEnDur() {
		return "1";
	} // Fin de fournirNiveauAnomalieEnDur().______________________________
	
	
	
	/**
	 * "RAPPORT-CONTROLE-ENCODAGE-EN-" + this.charset.name()<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirBaseNomRapport() {
		return "RAPPORT-CONTROLE-ENCODAGE-EN-" + this.charset.name();
	} // Fin de fournirBaseNomRapport().___________________________________

	
	
	/**
	 * "ControleurEncodage.aEffectuer".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirCleAEffectuer() {
		return "ControleurEncodage.aEffectuer";
	} // Fin de fournirCleAEffectuer().____________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean fournirAEffectuerEnDur() {
		return true;
	} // Fin de fournirAEffectuerEnDur().__________________________________



	/**
	 * method getCharset() :<br/>
	 * Getter du Charset à tester sur le fichier 
	 * pour savoir si il a été encodé avec ce Charset.<br/>
	 * <br/>
	 *
	 * @return charset : Charset.<br/>
	 */
	public final Charset getCharset() {
		return this.charset;
	} // Fin de getCharset().______________________________________________



	/**
	 * method setCharset(
	 * Charset pCharset) :<br/>
	 * Setter du Charset à tester sur le fichier 
	 * pour savoir si il a été encodé avec ce Charset.<br/>
	 * <br/>
	 * - Remplit automatiquement this.charset avec pCharset 
	 * si pCharset n'est pas null. CHARSET_UTF8 sinon.<br/>
	 * <br/>
	 *
	 * @param pCharset : Charset : valeur à passer à charset.<br/>
	 */
	public final void setCharset(
			final Charset pCharset) {
		
		this.charset = this.fournirCharset(pCharset);
		
	} // Fin de setCharset(
	 // Charset pCharset)._________________________________________________


	
	/**
	 * this.fichier.<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	public final File getFichierTraite() {
		return this.fichier;
	} // Fin de getFichierTraite().________________________________________
	
	
	
} // FIN DE LA CLASSE ControleurEncodage.------------------------------------
