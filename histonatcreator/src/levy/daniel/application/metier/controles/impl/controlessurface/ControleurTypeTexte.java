package levy.daniel.application.metier.controles.impl.controlessurface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import levy.daniel.application.metier.controles.AbstractControle;
import levy.daniel.application.metier.controles.CaractereDan;
import levy.daniel.application.metier.rapportscontroles.LigneRapport;


/**
 * class ControleurTypeTexte :<br/>
 * - typeControle = Contrôle de surface.<br/>
 * - nomControle = Contrôle fichier texte.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * levy.daniel.application.metier.controles.AbstractControle.<br/>
 * levy.daniel.application.metier.controles.CaractereDan.<br/>
 * levy.daniel.application.metier.rapportscontroles.LigneRapport.<br/>
 * <br/>
 *
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
	 * METHODE_LIREFICHIER : String :<br/>
	 * "Méthode lireFichier(File pFile, Charset pCharset)".<br/>
	 */
	public static final String METHODE_LIREFICHIER 
		= "Méthode lireFichier(File pFile, Charset pCharset)";
	

	/**
	 * METHODE_CONTROLER : String :<br/>
	 * "Méthode controler(File pFile)".<br/>
	 */
	public static final String METHODE_CONTROLER 
		= "Méthode controler(File pFile)";
	
	
	/**
	 * MESSAGE_FICHIER_NULL : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est null.<br/>
	 * "Le fichier passé en paramètre est null".<br/>
	 */
	public static final String MESSAGE_FICHIER_NULL 
		= "Le fichier passé en paramètre est null";

	
	/**
	 * MESSAGE_FICHIER_INEXISTANT : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est inexistant.<br/>
	 * "Le fichier passé en paramètre est inexistant : "
	 */
	public static final String MESSAGE_FICHIER_INEXISTANT 
		= "Le fichier passé en paramètre est inexistant : ";

	
	/**
	 * MESSAGE_FICHIER_REPERTOIRE : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est un répertoire.<br/>
	 * "Le fichier passé en paramètre est un répertoire : ".<br/>
	 */
	public static final String MESSAGE_FICHIER_REPERTOIRE 
		= "Le fichier passé en paramètre est un répertoire : ";

	
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
		/* ZERO WIDTH NO-BREAK SPACE ' ' */
		CARACTERES_INDESIRABLES_SET.add('\ufeff');
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
	 * <br/>
	 */
	public ControleurTypeTexte() {
		
		this(null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method CONSTRUCTEUR ControleurTypeTexte(
	 * File pFichier) :<br/>
	 * Constructeur avec fichier.<br/>
	 * <br/>
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
	 * <br/>
	 *
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 */
	public ControleurTypeTexte(
			final File pFichier) {
		
		this(null, null, pFichier);
		
	} // Fin de ControleurTypeTexte(
	 // File pFichier).____________________________________________________

	
	
	 /**
	 * method CONSTRUCTEUR ControleurTypeTexte(
	 * String pUserName
	 * , File pFichier) :<br/>
	 * Constructeur avec user et fichier.<br/>
	 * <br/>
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
	 * <br/>
	 *
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/> 
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 */
	public ControleurTypeTexte(
			final String pUserName
					, final File pFichier) {
		
		this(null, pUserName, pFichier);
		
	} // Fin de ControleurTypeTexte(
	 // String pUserName
	 // , File pFichier).__________________________________________________
	
	

	/**
	 * method CONSTRUCTEUR ControleurTypeTexte(COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 * - Remplit le nom de la classe concrète this.nomClasseConcrete fourni 
	 * par this.fournirNomClasseConcrete() dans la classe concrète.<br/>
	 * - Remplit dateControle avec pDateControle si pDateControle != null 
	 * ou la date système sinon.<br/>
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
	 * <br/>
	 *
	 * @param pDateControle : Date : java.util.Date du contrôle.<br/>
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/> 
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 */
	public ControleurTypeTexte(
			final Date pDateControle
				, final String pUserName
					, final File pFichier) {
		
		super(pDateControle, pUserName, pFichier);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	/**
	 * method controler(
	 * File pFile) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pFile
	 * @return : boolean :  .<br/>
	 */
	public boolean controler(final File pFile) {
		
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
			 * Charset.
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

				/* Teste si le fichier contient un caractère indésirable 
				 * et retourne false si c'est le cas. */
				if (CARACTERES_INDESIRABLES_SET.contains(character)) {
					System.out.println(new CaractereDan(position, character).toString());
					return false;
				}

			} // Fin du parcours du bufferedReader._________

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
	// File pFile).________________________________________________________


		
	/**
	 * method lireFichier(
	 * File pFile
	 * , Charset pCharset) :<br/>
	 * Lit un fichier pFile et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage pCharset.<br/>
	 * Lit chaque caractère quoi qu'il arrive 
	 * (même si le fichier n'est pas un fichier texte).<br/>
	 * Ne modifie pas les sauts de ligne.<br/>
	 * <br/>
	 * - passe pFile à this.fichier - 
	 * rafraîchit automatiquement this.nomFichier.<br/>
	 * <br/>
	 * - retourne MESSAGE_FICHIER_NULL si le pFile est null.<br/>
	 * - retourne MESSAGE_FICHIER_INEXISTANT si le pFile est inexistant.<br/>
	 * - retourne MESSAGE_FICHIER_REPERTOIRE si le pFile est un répertoire.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier à lire.<br/>
	 * @param pCharset : Charset : Charset utilisé par l'InputStreamReader 
	 * pour lire dans le fichier.<br/>
	 * 
	 * @return : String : Chaine de caractères avec le contenu du fichier.<br/>
	 */
	public String lireFichier(
			final File pFile
				, final Charset pCharset) {
		
		/* passe pFile à this.fichier - 
		 * rafraîchit automatiquement this.nomFichier. */
		this.setFichier(pFile);
		
		/* retourne MESSAGE_FICHIER_NULL 
		 * si le pFile est null. */
		if (pFile == null) {
			
			/* LOG de niveau INFO. */
			loggerInfo(
					CLASSE_CONTROLEURTYPETEXTE
						, METHODE_LIREFICHIER
							, MESSAGE_FICHIER_NULL);
			
			/* rapport. */
			final LigneRapport ligneRapport 
				= new LigneRapport(
						this.dateControleStringFormatee
						, this.userName
						, this.nomFichier
						, this.typeControle
						, this.nomControle
						, this.nomCritere
						, this.gravite
						, null
						, MESSAGE_FICHIER_NULL
						, null
						, SANS_OBJET
						, SANS_OBJET
						, ACTION_FICHIER_REFUSE);
			
			this.ajouterLigneRapport(ligneRapport);
			
			/* retour de MESSAGE_FICHIER_NULL. */
			return MESSAGE_FICHIER_NULL;
		}
		
		/* retourne MESSAGE_FICHIER_INEXISTANT 
		 * si le pFile est inexistant. */
		if (!pFile.exists()) {
							
			/* LOG de niveau INFO. */
			loggerInfo(
					CLASSE_CONTROLEURTYPETEXTE
						, METHODE_LIREFICHIER
							, MESSAGE_FICHIER_INEXISTANT
								, pFile.getAbsolutePath());
			
			/* rapport. */
			final LigneRapport ligneRapport 
				= new LigneRapport(
						this.dateControleStringFormatee
						, this.userName
						, this.nomFichier
						, this.typeControle
						, this.nomControle
						, this.nomCritere
						, this.gravite
						, null
						, MESSAGE_FICHIER_INEXISTANT + pFile.getAbsolutePath()
						, null
						, SANS_OBJET
						, SANS_OBJET
						, ACTION_FICHIER_REFUSE);
			
			this.ajouterLigneRapport(ligneRapport);
			
			/* retour de MESSAGE_FICHIER_INEXISTANT. */
			return MESSAGE_FICHIER_INEXISTANT;
		}
		
		
		/* retourne MESSAGE_FICHIER_REPERTOIRE 
		 * si le pFile est un répertoire. */
		if (pFile.isDirectory()) {
			
			/* LOG de niveau INFO. */
			loggerInfo(
					CLASSE_CONTROLEURTYPETEXTE
						, METHODE_LIREFICHIER
							, MESSAGE_FICHIER_REPERTOIRE
								, pFile.getAbsolutePath());
			
			/* rapport. */
			final LigneRapport ligneRapport 
				= new LigneRapport(
						this.dateControleStringFormatee
						, this.userName
						, this.nomFichier
						, this.typeControle
						, this.nomControle
						, this.nomCritere
						, this.gravite
						, null
						, MESSAGE_FICHIER_REPERTOIRE + pFile.getAbsolutePath()
						, null
						, SANS_OBJET
						, SANS_OBJET
						, ACTION_FICHIER_REFUSE);
			
			this.ajouterLigneRapport(ligneRapport);
			
			/* retour de MESSAGE_FICHIER_REPERTOIRE. */
			return MESSAGE_FICHIER_REPERTOIRE;
		}


		// LECTURE ***************
		FileInputStream fileInputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;

		int characterEntier = 0;
		Character character = null;
		
		final StringBuilder stb = new StringBuilder();

		Charset charset = null;

		/* Choisit automatiquement le CHARSET_UTF8 si pCharset == null. */
		if (pCharset == null) {
			charset = CHARSET_UTF8;
		} else {
			charset = pCharset;
		}

		try {

			/*
			 * Instancie un flux en lecture fileInputStream en lui passant
			 * pFile.
			 */
			fileInputStream = new FileInputStream(pFile);

			/*
			 * Instancie un InputStreamReader en lui passant le FileReader et le
			 * Charset.
			 */
			inputStreamReader = new InputStreamReader(fileInputStream, charset);

			/*
			 * Instancie un tampon de flux de caractères en lecture en lui
			 * passant le flux inputStreamReader.
			 */
			bufferedReader = new BufferedReader(inputStreamReader);
			
			/* Parcours du bufferedReader. */
			while (true) {
				
				/* Lecture de chaque caractère. */
				characterEntier = bufferedReader.read();
				
				/* Arrêt de la lecture si fin de fichier. */
				if (characterEntier < 0) {
					break;
				}
				
				/* Conversion de l'entier en caractère. */
				character = (char) characterEntier;
								
				/* Ajout du caractère au StringBuilder. */
				stb.append(character);
				
			} // Fin du parcours du bufferedReader._________

		} catch (FileNotFoundException fnfe) {
			
			/* LOG de niveau ERROR. */
			loggerError(
					CLASSE_CONTROLEURTYPETEXTE
						, METHODE_LIREFICHIER
							, fnfe);
			
			/* retourne le message de l'exception. */
			return fnfe.getMessage();
			
		} catch (IOException ioe) {
			
			/* LOG de niveau ERROR. */
			loggerError(
					CLASSE_CONTROLEURTYPETEXTE
						, METHODE_LIREFICHIER
							, ioe);
			
			/* retourne le message de l'exception. */
			return ioe.getMessage();
		}
		
		finally {
			
			/* fermeture du flux BufferedReader. */
			if (bufferedReader != null) {
				
				try {
					
					bufferedReader.close();
					
				} catch (IOException ioe2) {
					
					/* LOG de niveau ERROR. */
					loggerError(
							CLASSE_CONTROLEURTYPETEXTE
								, METHODE_LIREFICHIER
									, ioe2);
					
				}
				
			} // Fin de if (bufferedReader != null).____
			
			/* fermeture du flux inputStreamReader. */
			if (inputStreamReader != null) {
				
				try {
					
					inputStreamReader.close();
					
				} catch (IOException ioe4) {
					
					/* LOG de niveau ERROR. */
					loggerError(
							CLASSE_CONTROLEURTYPETEXTE
								, METHODE_LIREFICHIER
									, ioe4);
				}
				
			} // Fin de if (inputStreamReader != null).______
			
			/* fermeture du flux fileInputStream. */
			if (fileInputStream != null) {
				
				try {
					
					fileInputStream.close();
					
				} catch (IOException ioe3) {
					
					/* LOG de niveau ERROR. */
					loggerError(
							CLASSE_CONTROLEURTYPETEXTE
								, METHODE_LIREFICHIER
									, ioe3);
					
				}
				
			} // Fin de if (fileInputStream != null).________
			
		} // Fin du finally._____________________________
		
		return stb.toString();
		
	} // Fin de lireFichier(
	 // File pFile
	 // , Charset pCharset)._______________________________________________

	
	
	/**
	 * method listerChaineCarParCar(
	 * String pString) :<br/>
	 * - Retourne une String permettant l'affichage 
	 * caractère par caractère sur des lignes distinctes 
	 * d'une chaine de caractères pString 
	 * avec les informations 
	 * Unicode concernant les caractères.<br/>
	 * - Alimente longueurChaine.<br/>
	 * <br/>
	 * Par exemple : <br/>
	 * <code>DifferentiateurString.listerChaineCarParCar("à b")</code> 
	 * retourne : <br/>
	 * Position : 1      Caractère : à     Unicode : \u00e0  NumericValue : -1    TypeCaractere : 2   valeurEntiere : 224   Point de Code décimal : 224   Point de Code Hexa : e0      Nom : LATIN SMALL LETTER A WITH GRAVE         <br/>
	 * Position : 2      Caractère :       Unicode : \u0020  NumericValue : -1    TypeCaractere : 12  valeurEntiere : 32    Point de Code décimal : 32    Point de Code Hexa : 20      Nom : SPACE                                   <br/>
	 * Position : 3      Caractère : b     Unicode : \u0062  NumericValue : 11    TypeCaractere : 2   valeurEntiere : 98    Point de Code décimal : 98    Point de Code Hexa : 62      Nom : LATIN SMALL LETTER B                    <br/>
	 * <br/>
	 * - retourne null si pString est blank (null ou vide).<br/>
	 * <br/>
	 *
	 * @param pString : String : String à afficher 
	 * caractère par caractère.<br/>
	 * 
	 * @return : String : Affichage caractère 
	 * par caractère sur des lignes distinctes.<br/>
	 */
	public String listerChaineCarParCar(
			final String pString) {
		
			
			/* retourne null si pString est blank (null ou vide). */
			if (StringUtils.isBlank(pString)) {
				return null;
			}
						
			/* Détermine la longueur de la chaîne. */
			final int longueurChaine = pString.length();
			int position = 0;
			Character caractereChaine = null;
			final StringBuilder stb = new StringBuilder();
			
			/* Parcours de la chaîne caractère par caractère. */
//			for(int index = 0; index < longueurChaine; index++) {
			
			int l = 0;
			if (longueurChaine < 1000) {
				l = longueurChaine;
			}
			else {
				l = 1000;
			}
			
			for(int index = 0; index < l; index++) {
				
				/* L'index est 0-based. */
				position = index + 1;
				
				/* détermination du caractère dans la chaine. */
				try {
					caractereChaine = pString.charAt(index);
				} catch (IndexOutOfBoundsException e1) {
					caractereChaine = null;
				}
				
				/* Instanciation d'un CaractereDan. */
				final CaractereDan carDan 
					= new CaractereDan(position, caractereChaine);
				
				stb.append(carDan.toString());
				stb.append(NEWLINE);
				
			} // Fin du parcours de la chaîne._______________
			
			/* Retour du résultat. */
			return stb.toString();
					
	} // Fin de listerChaineCarParCar(
	 // String pString).___________________________________________________
	


	/**
	 * "Classe ControleurTypeTexte".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirNomClasseConcrete() {
		return CLASSE_CONTROLEURTYPETEXTE;
	} // Fin de fournirNomClasseConcrete().________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirTypeControle() {
		return "Contrôle de surface";
	} // Fin de fournirTypeControle()._____________________________________


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirNomControle() {
		return "Contrôle fichier texte";
	} // Fin de fournirNomControle().______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirNomCritere() {
		return "Le fichier ne doit pas comporter de caractères "
				+ "indésirables (impossibles à écrire au clavier)";
	} // Fin de fournirNomCritere()._______________________________________



	/**
	 * "ControleurTypeTexte.niveau.anomalie".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirCleNiveauAnomalie() {
		return "ControleurTypeTexte.niveau.anomalie";
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

	
	
} // FIN DE LA CLASSE ControleurTypeTexte.-----------------------------------
