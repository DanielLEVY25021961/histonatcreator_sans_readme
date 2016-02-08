package levy.daniel.application.util.differentiateurs.differentiateursstrings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import levy.daniel.application.IConstantesMessage;
import levy.daniel.application.util.convertisseursencodage.ConvertisseurEncodage;
import levy.daniel.application.util.convertisseursencodage.ConvertisseurEncodageTest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class DifferentiateurString :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Retour à la ligne, saut de ligne,<br/>
 * SAUTDELIGNE_UNIX = "\n", SAUTDELIGNE_MAC = "\r",<br/>
 * SAUTDELIGNE_DOS_WINDOWS = "\r\n",  <br/>
 * Saut de ligne spécifique de la plateforme.<br/>
 * System.getProperty("line.separator").<br/>
 * rapport textuel, rapport csv, ecrire dans fichier,<br/>
 * écrire dans fichier, ecrire String dans File, écrire String dans File,<br/>
 * ecriture sur disque avec encodage, Charset,<br/>
 * FileOutputStream, 
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 5 févr. 2016
 *
 */
public final class DifferentiateurString {

	// ************************ATTRIBUTS************************************/
		
	/**
	 * FILE_DIACRITIQUES_UTF8 : File : <br/>
	 * txt codé en UTF-8.<br/>
	 */
	public static final File FILE_DIACRITIQUES_UTF8 
		= ConvertisseurEncodageTest.FILE_DIACRITIQUES_UTF8;
	
	/**
	 * FILE_DIACRITIQUES_ISO_8859_2 : File : <br/>
	 * txt codé en ISO_8859_2.<br/>
	 */
	public static final File FILE_DIACRITIQUES_ISO_8859_2 
		= ConvertisseurEncodageTest.FILE_DIACRITIQUES_ISO_8859_2;
	
	
	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	public static final Charset CHARSET_UTF8 
		= Charset.forName("UTF-8");
	
	/**
	 * CHARSET_ISO_8859_2 : Charset :<br/>
	 * Charset.forName("ISO-8859-2").<br/>
	 * <br/>
	 */
	public static final Charset CHARSET_ISO_8859_2 
		= Charset.forName("ISO-8859-2");
	

	
	/**
	 * STRING_REF_DIACRITIQUES_UTF8 : String : <br/>
	 */
	public static final String STRING_REF_DIACRITIQUES_UTF8 = ConvertisseurEncodageTest.STRING_REF_DIACRITIQUES_UTF8;
	

	/**
	 * STRING_REF_DIACRITIQUES_ISO_8859_2 : String : <br/>
	 */
	public static final String STRING_REF_DIACRITIQUES_ISO_8859_2 = ConvertisseurEncodageTest.STRING_REF_DIACRITIQUES_ISO_8859_2;
	

	/**
	 * CLASSE_DIFFERENTIATEURSTRING : String :<br/>
	 * "Classe DifferentiateurString".<br/>
	 */
	public static final String CLASSE_DIFFERENTIATEURSTRING 
		= "Classe DifferentiateurString";

	/**
	 * METHODE_DIFFERENCIER : String :<br/>
	 * "méthode differencier(String pString1, String pString2)".<br/>
	 */
	public static final String METHODE_DIFFERENCIER 
		= "méthode differencier(String pString1, String pString2)";
	
	
	/**
	 * METHODE_ECRIRESTRINGDANSFILE : String :<br/>
	 * "méthode ecrireStringDansFile(
	 * File pFile, String pString, Charset pCharset)".<br/>
	 */
	public static final String METHODE_ECRIRESTRINGDANSFILE 
		= "méthode ecrireStringDansFile(File pFile, String pString, Charset pCharset)";
	
	/**
	 * METHODE_FOURNIRFILEPOURRAPPORTTXT : String :<br/>
	 * "méthode fournirFilePourRapportTextuel()".<br/>
	 */
	public static final String METHODE_FOURNIRFILEPOURRAPPORTTXT 
		= "méthode fournirFilePourRapportTextuel()";
	
	
	/**
	 * MESSAGE_FICHIER_NULL : String :<br/>
	 * Message retourné par la METHODE_ECRIRESTRINGDANSFILE 
	 * si le fichier est null.<br/>
	 * "Le fichier passé en paramètre est null".<br/>
	 */
	public static final String MESSAGE_FICHIER_NULL 
		= "Le fichier passé en paramètre est null";
		
	/**
	 * MESSAGE_FICHIER_INEXISTANT : String :<br/>
	 * Message retourné par la METHODE_ECRIRESTRINGDANSFILE 
	 * si le fichier est inexistant.<br/>
	 * "Le fichier passé en paramètre est inexistant : "
	 */
	public static final String MESSAGE_FICHIER_INEXISTANT 
		= "Le fichier passé en paramètre est inexistant : ";
	
	/**
	 * MESSAGE_FICHIER_REPERTOIRE : String :<br/>
	 * Message retourné par la METHODE_ECRIRESTRINGDANSFILE 
	 * si le fichier est un répertoire.<br/>
	 * "Le fichier passé en paramètre est un répertoire : ".<br/>
	 */
	public static final String MESSAGE_FICHIER_REPERTOIRE 
		= "Le fichier passé en paramètre est un répertoire : ";

	/**
	 * MESSAGE_STRING_BLANK : String :<br/>
	 * Message retourné par la METHODE_ECRIRESTRINGDANSFILE 
	 * si la String passée en paramètre est blank.<br/>
	 * "La chaine de caractères passée en paramètre est blank (null ou vide) : "
	 */
	public static final String MESSAGE_STRING_BLANK 
	= "La chaine de caractères passée en paramètre est blank (null ou vide) : ";
	
	/**
	 * SAUTDELIGNE_UNIX : String :<br/>
	 * Saut de ligne généré par les éditeurs Unix.<br/>
	 * "\n" (Retour Ligne = LINE FEED (LF)).
	 */
	public static final String SAUTDELIGNE_UNIX = "\n";

	
	/**
	 * SAUTDELIGNE_MAC : String :<br/>
	 * Saut de ligne généré par les éditeurs Mac.<br/>
	 * "\r" (Retour Chariot RC = CARRIAGE RETURN (CR))
	 */
	public static final String SAUTDELIGNE_MAC = "\r";

	
	/**
	 * SAUTDELIGNE_DOS_WINDOWS : String :<br/>
	 * Saut de ligne généré par les éditeurs DOS/Windows.<br/>
	 * "\r\n" (Retour Chariot RC + Retour Ligne LF).
	 */
	public static final String SAUTDELIGNE_DOS_WINDOWS = "\r\n";

	
	/**
	 * NEWLINE : String :<br/>
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	public static final String NEWLINE = System.getProperty("line.separator");

	
	/**
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("FR", "fr").<br/>
	 */
	public static final Locale LOCALE_FR_FR = new Locale("FR", "fr");

	
	/**
	 * DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE : DateFormat :<br/>
	 * Format concentré des dates avec heures et secondes
	 * comme "2012-01-16_18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	public static final DateFormat DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", LOCALE_FR_FR);
	
	
	/**
	 * rapportDiff : String :<br/>
	 * Rapport textuel comparant les deux chaines de caractères.<br/>
	 */
	private static String rapportDiff;
	
	
	/**
	 * rapportDiffCsv : String :<br/>
	 * Rapport au format csv comparant les deux chaines de caractères.<br/>
	 */
	private static String rapportDiffCsv;

	
	/**
	 * fileRapportDiff : File :<br/>
	 * File contenant le Rapport textuel 
	 * comparant les deux chaines de caractères.<br/>
	 */
	private static File fileRapportDiff;

	
	/**
	 * fileRapportDiffCsv : File :<br/>
	 * File contenant le Rapport au format csv 
	 * comparant les deux chaines de caractères.<br/>
	 */
	private static File fileRapportDiffCsv;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(DifferentiateurString.class);

	// *************************METHODES************************************/
	
	
	/**
	 * method CONSTRUCTEUR DifferentiateurString() :
	 * Constructeur private pour empêcher l'instanciation.
	 */
	private DifferentiateurString() {
		super();
	} // Fin de CONSTRUCTEUR DifferentiateurString().______________________


	
	/**
	 * method listerChaineCarParCar(
	 * String pString) :<br/>
	 * Retourne une String permettant l'affichage 
	 * caractère par caractère de pString.<br/>
	 * <br/>
	 * - retourne null si pString est blank (null ou vide).<br/>
	 * <br/>
	 *
	 * @param pString : String : String à afficher 
	 * caractère par caractère.<br/>
	 * 
	 * @return : String : Affichage caractère par caractère.<br/>
	 */
	public static String listerChaineCarParCar(
			final String pString) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurString.class) {
			
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
			for(int index = 0; index < longueurChaine; index++) {
				
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
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de listerChaineCarParCar(
	 // String pString).___________________________________________________
	

	
	/**
	 * method differencier(String pString1
	 * , String pString2) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pString1 : String : 
	 * @param pString2 : String :
	 * 
	 * @return : String :  .<br/>
	 */
	public static String differencier(
			final String pString1, final String pString2) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurString.class) {
			
			/* mise à null des rapports. */
			rapportDiff = null;
			rapportDiffCsv = null;
			
			
			int longueurMax = 0;
			int position = 0;
			Character caractereChaine1 = null;
			Character caractereChaine2 = null;
			String diff = null;
			
			final StringBuilder stbDiff = new StringBuilder();
			final StringBuilder stbDiffCsv = new StringBuilder();
			
			/* Détermine la longueur de la plus longue chaîne. */
			final int longueurChaine1 = pString1.length();
			final int longueurChaine2 = pString2.length();
			
			if (longueurChaine1 > longueurChaine2) {
				longueurMax = longueurChaine1;
			}
			else {
				longueurMax = longueurChaine2;
			}
			
			/* Parcours des chaînes caractère par caractère. */
			for(int index = 0; index < longueurMax; index++) {
				
				/* L'index est 0-based. */
				position = index + 1;
				
				/* détermination du caractère dans la chaine 1. */
				try {
					caractereChaine1 = pString1.charAt(index);
				} catch (IndexOutOfBoundsException e1) {
					caractereChaine1 = null;
				}
				
				/* Instanciation d'un CaractereDan. */
				final CaractereDan c1 
					= new CaractereDan(position, caractereChaine1);
				
				/* détermination du caractère dans la chaine 2. */
				try {
					caractereChaine2 = pString2.charAt(index);
				} catch (IndexOutOfBoundsException e1) {
					caractereChaine2 = null;
				}
				
				/* Instanciation d'un CaractereDan. */
				final CaractereDan c2 
					= new CaractereDan(position, caractereChaine2);
				
				/* Détermination d'une éventuelle différence. */
				if (caractereChaine1 == null) {
					
					if (caractereChaine2 != null) {
						diff = "DIFF";
					} else {
						diff = "equals";
					}
					
				} else {
					if (caractereChaine2 != null) {
						if (!caractereChaine1.equals(caractereChaine2)) {
							diff = "DIFF";
						}
						else {
							diff = "equals";
						}
						
					} else {
						diff = "DIFF";
					}					
				}
				
				final String comparaison 
					= c1.toString() + "   DIFFERENCE = " 
								+ diff + "     " + c2.toString();
				
				final String comparaisonCsv 
					= c1.toCsv() + diff + ";" + c2.toCsv();
				
				/* Ajout dans les StringBuilders pour les rapports. */
				/* rapport textuel. */
				stbDiff.append(comparaison);
				stbDiff.append(NEWLINE);
				
				/* rapport csv. */
				/* Ajout de l'en-tête pour le rapport Csv. */
				if (position == 1) {
					stbDiffCsv.append(c1.getEnTeteCsv());
					stbDiffCsv.append("DIFFERENCE");
					stbDiffCsv.append(IConstantesMessage.SEP_POINTVIRGULE);
					stbDiffCsv.append(c1.getEnTeteCsv());
					stbDiffCsv.append(NEWLINE);
				}
				stbDiffCsv.append(comparaisonCsv);
				stbDiffCsv.append(NEWLINE);
								
			} // Fin de la boucle sur les caractères._______________
			
//			System.out.println(stbDiff.toString());
			/* Injection dans le rapport. */
			rapportDiff = stbDiff.toString();
			ecrireStringDansFile(rapportDiff);
			
//			System.out.println();
			/* Injection dans le rapport csv. */
			rapportDiffCsv = stbDiffCsv.toString();
//			System.out.println(stbDiffCsv.toString());
			
			return stbDiff.toString();
						
		} // Fin du bloc static synchronized.________________________
		
		
	} // Fin de differencier(String pString1
	 // , String pString2).________________________________________________


	
	/**
	 * method ecrireStringDansFile(
	 * String pString) :<br/>
	 * Ecrit la String pString dans le File pFile avec un encodage UTF-8 
	 * et les sauts de ligne NEWLINE de la plateforme.<br/>
	 * Utilise FileOutputStream, 
	 * new OutputStreamWriter(fileOutputStream, charset) 
	 * et BufferedWriter pour écrire.<br/>
	 * Ecriture dans un fichier, écriture sur disque.<br/>
	 * <br/>
	 * - Passe automatiquement le Charset à CHARSET_UTF8.<br/>
	 * - Passe automatiquement le saut de ligne à NEWLINE 
	 * (saut de ligne de la plateforme).<br/>
	 * - Substitue automatiquement NEWLINE (saut de ligne de la plateforme) 
	 * aux sauts de ligne dans pString si nécessaire.<br/>
	 * <br/>
	 * - retourne null en cas d'Exception loggée 
	 * (FileNotFoundException, IOException).<br/>
	 * - retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString : String : String que l'on copie dans pFile.<br/>
	 * 
	 * @return : File : Le fichier dans lequel on a écrit pString.<br/>
	 */
	public static File ecrireStringDansFile(final String pString) {
		
		final File file = fournirFilePourRapportTextuel();
		
		return ecrireStringDansFile(file, pString, CHARSET_UTF8, NEWLINE);
		
	} // Fin de ecrireStringDansFile(
	 // String pString).___________________________________________________
	

	
	/**
	 * method fournirFilePourRapportTextuel() :<br/>
	 * .<br/>
	 * <br/>
	 * - crée un répertoire pour les rapports textuels si il n'existe pas.<br/>
	 * <br/>
	 * - retourne null si il est impossible 
	 * de créer le répertoire des rapports.<br/>
	 * <br/>
	 * 
	 *
	 * @return : File :  .<br/>
	 */
	private static File fournirFilePourRapportTextuel() {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurString.class) {
			
			final String cheminRepRapports 
				= ".\\data\\temp\\rapports";
			
			String cheminFichier = null;

			/* Tentative de lecture du chemin des rapports. */
			final File repertoireRapports 
				= new File(cheminRepRapports);
			
			/* crée un répertoire pour les rapports textuels si il n'existe pas. */
			if (!repertoireRapports.exists()) {
				
				boolean repertoireCree = false;
				
				try {
					
					/* Création du répertoire. */
					repertoireCree = repertoireRapports.mkdir();
					
				} catch (Exception mkdirExc) {
					
					/* LOG de niveau ERROR. */
					loggerError(
							CLASSE_DIFFERENTIATEURSTRING
								, METHODE_FOURNIRFILEPOURRAPPORTTXT
									, mkdirExc);
					
					/* retourne null. */
					return null;
				}
				
				if (!repertoireCree) {
					
					/* LOG de niveau ERROR. */
					if (LOG.isErrorEnabled()) {
						
						final String message 
						= CLASSE_DIFFERENTIATEURSTRING 
						+ IConstantesMessage.SEP_MOINS 
						+ METHODE_FOURNIRFILEPOURRAPPORTTXT
						+ IConstantesMessage.SEP_MOINS 
						+ "Impossible de créer le répertoire : " 
						+ cheminRepRapports;
						
						LOG.error(message);
						
					}
					
					/* retourne null. */
					return null;
				}
			} // Fin de if (!repertoireRapports.exists())._____________
			
			/* Récupère la date courante dans le système. */
			final Date maintenantDate = new Date();
			
			/* Récupère la date formattée sous forme 2012-01-16_18-09-55. */
			final String dateFormatteeString 
				= DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE
					.format(maintenantDate);
			
			cheminFichier = cheminRepRapports + "\\" + dateFormatteeString + "_RapportDIFFERENCES_TXT_UTF8.txt";
			
			final File resultatFile = new File(cheminFichier);
			
			/* Création du fichier si il n'existe pas. */
			if (!resultatFile.exists()) {
				try {
					resultatFile.createNewFile();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			System.out.println(resultatFile.getAbsolutePath());
			
			return resultatFile;
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de fournirFilePourRapportTextuel().___________________________

	

	/**
	 * method ecrireStringDansFile(
	 * File pFile
	 * , String pString
	 * , Charset pCharset
	 * , String pSautLigne) :<br/>
	 * Ecrit la String pString dans le File pFile avec un encodage pCharset.<br/>
	 * Substitue automatiquement pSautLigne aux sauts de ligne 
	 * dans pString si nécessaire.<br/>
	 * Utilise FileOutputStream, 
	 * new OutputStreamWriter(fileOutputStream, charset) 
	 * et BufferedWriter pour écrire.<br/>
	 * Ecriture dans un fichier, écriture sur disque.<br/>
	 * <br/>
	 * - Passe automatiquement le Charset à CHARSET_UTF8 
	 * si pCharset est null.<br/>
	 * - Passe automatiquement le saut de ligne à NEWLINE 
	 * (saut de ligne de la plateforme) si pSautLigne est blank.<br/>
	 * <br/>
	 * - retourne null si le pFile est null.<br/>
	 * - retourne null si le pFile est inexistant.<br/>
	 * - retourne null si le pFile est un répertoire.<br/>
	 * - retourne null en cas d'Exception loggée 
	 * (FileNotFoundException, IOException).<br/>
	 * - retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier dans lequel on écrit.<br/>
	 * @param pString : String : String que l'on copie dans pFile.<br/>
	 * @param pCharset : Charset : Charset pour encoder le fichier.<br/>
	 * @param pSautLigne : String : Saut de ligne que l'on veut 
	 * dans pFile de sortie 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix).<br/>
	 * 
	 * @return : File : Le fichier dans lequel on a écrit pString.<br/>
	 */
	public static File ecrireStringDansFile(
			final File pFile
				, final String pString
					, final Charset pCharset
						, final String pSautLigne) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurString.class) {
			
			/* retourne null si le pFile est null. */
			if (pFile == null) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_DIFFERENTIATEURSTRING
							, METHODE_ECRIRESTRINGDANSFILE
								, MESSAGE_FICHIER_NULL);
				
				/* retour de null. */
				return null;
			}
			
			/* retourne null si le pFile est inexistant. */
			if (!pFile.exists()) {
								
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_DIFFERENTIATEURSTRING
							, METHODE_ECRIRESTRINGDANSFILE
								, MESSAGE_FICHIER_INEXISTANT
									, pFile.getAbsolutePath());
				
				/* retour de null. */
				return null;
			}
			
			/* retourne null si le pFile est un répertoire. */
			if (pFile.isDirectory()) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_DIFFERENTIATEURSTRING
							, METHODE_ECRIRESTRINGDANSFILE
								, MESSAGE_FICHIER_REPERTOIRE
									, pFile.getAbsolutePath());
				
				/* retour de null. */
				return null;
			}
			
			/* retourne null si pString est blank. */
			if (StringUtils.isBlank(pString)) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_DIFFERENTIATEURSTRING
							, METHODE_ECRIRESTRINGDANSFILE
								, MESSAGE_STRING_BLANK
									, pString);
				
				return null;
			}
			
			
			Charset charset = null;
			
			/* Passe automatiquement le charset à UTF-8 si pCharset est null. */
			if (pCharset == null) {
				charset = CHARSET_UTF8;
			}
			else {
				charset = pCharset;
			}
			
			String sautLigne = null;
			
			/* Passe automatiquement le saut de ligne à NEWLINE 
			 * (saut de ligne de la plateforme) si pSautLigne est blank. */
			if (StringUtils.isBlank(pSautLigne)) {
				sautLigne = NEWLINE;
			} else {
				sautLigne = pSautLigne;
			}
			
			// ECRITURE SUR DISQUE ***************
			FileOutputStream fileOutputStream = null;
			OutputStreamWriter outputStreamWriter = null;
			BufferedWriter bufferedWriter = null;
			
			try {
				
				/* Ouverture d'un FileOutputStream sur le fichier. */
				fileOutputStream 
					= new FileOutputStream(pFile);
				
				/* Ouverture d'un OutputStreamWriter 
				 * sur le FileOutputStream en lui passant le Charset. */
				outputStreamWriter 
					= new OutputStreamWriter(fileOutputStream, charset);
				
				/* Ouverture d'un tampon d'écriture 
				 * BufferedWriter sur le OutputStreamWriter. */
				bufferedWriter 
					= new BufferedWriter(outputStreamWriter);
				
				// ECRITURE.
				/* Substitue automatiquement sautLigne aux sauts de ligne 
				 * dans pString si nécessaire. */
				bufferedWriter.write(substituerSautLigne(pString, sautLigne));
				
				// Retour du fichier. 
				return pFile;
				
			} catch (FileNotFoundException fnfe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_DIFFERENTIATEURSTRING
							, MESSAGE_FICHIER_REPERTOIRE				
								, fnfe);
				
				/* retour de null. */
				return null;
				
			} catch (IOException ioe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_DIFFERENTIATEURSTRING
							, MESSAGE_FICHIER_REPERTOIRE				
								, ioe);
				
				/* retour de null. */
				return null;
			}
			
			finally {
				
				if (bufferedWriter != null) {
					try {
						
						bufferedWriter.close();
						
					} catch (IOException ioe1) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_DIFFERENTIATEURSTRING
									, MESSAGE_FICHIER_REPERTOIRE				
										, ioe1);
					}
				} // Fin de if (bufferedWriter != null).__________
				
				if (outputStreamWriter != null) {
					try {
						
						outputStreamWriter.close();
						
					} catch (IOException ioe2) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_DIFFERENTIATEURSTRING
									, MESSAGE_FICHIER_REPERTOIRE				
										, ioe2);
					}
				} // Fin de if (outputStreamWriter != null).______
				
				if (fileOutputStream != null) {
					try {
						
						fileOutputStream.close();
						
					} catch (IOException ioe3) {
						
						//* LOG de niveau ERROR. */
						loggerError(
								CLASSE_DIFFERENTIATEURSTRING
									, MESSAGE_FICHIER_REPERTOIRE				
										, ioe3);
					}
				}
				
			} // Fin du finally.____________________________
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de ecrireStringDansFile(...)._________________________________
	

	
	/**
	 * method substituerSautLignePlateforme(
	 * String pString) :<br/>
	 * Substitue les sauts de ligne dans pString 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix) 
	 * par les sauts de ligne de la plate-forme
	 * sur laquelle le programme s'exécute.<br/>
	 * <br/>
	 * - retourne null si pString est blank (null ou vide).<br/>
	 * <br/>
	 *
	 * @param pString : String : String à corriger.<br/>
	 * 
	 * @return : String : La String dans laquelle les sauts de ligne 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix) 
	 * ont été substitués par les sauts de ligne de la plate-forme.<br/>
	 */
	public static String substituerSautLignePlateforme(
			final String pString) {
		
		return substituerSautLigne(pString, NEWLINE);
		
	} // Fin de method substituerSautLignePlateforme(
	 // String pString).___________________________________________________
	

	
	/**
	 * method substituerSautLigne(
	 * String pString
	 * , String pSautLigne) :<br/>
	 * Substitue les sauts de ligne dans pString 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix) 
	 * par les sauts de ligne pSautLigne.<br/>
	 * <br/>
	 * - retourne null si pString est blank (null ou vide).<br/>
	 * - retourne null si pSautLigne est blank (null ou vide).
	 * <br/>
	 *
	 * @param pString : String : String à corriger.<br/>
	 * @param pSautLigne : String : saut de ligne à substituer.<br/>
	 * 
	 * @return : String : La String dans laquelle les sauts de ligne 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix) 
	 * ont été substitués par les sauts de ligne pSautLigne.<br/>
	 */
	public static String substituerSautLigne(
			final String pString, final String pSautLigne) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurString.class) {
			
			/* retourne null si pString est blank (null ou vide). */
			if (StringUtils.isBlank(pString)) {
				return null;
			}
			
			/* retourne null si pSautLigne est blank (null ou vide). */
			
			/* Recherche des sauts de ligne DOS/Windows. */
			if (StringUtils.contains(pString, SAUTDELIGNE_DOS_WINDOWS)) {
				
				final String resultat 
					= StringUtils.replace(
							pString, SAUTDELIGNE_DOS_WINDOWS, pSautLigne);
				
				return resultat;
			}
			
			/* Recherche des sauts de ligne Mac. */
			if (StringUtils.contains(pString, SAUTDELIGNE_MAC)) {
				
				final String resultat 
					= StringUtils.replace(
							pString, SAUTDELIGNE_MAC, pSautLigne);
				
				return resultat;
			}
			
			/* Recherche des sauts de ligne Unix. */
			if (StringUtils.contains(pString, SAUTDELIGNE_UNIX)) {
				
				final String resultat 
					= StringUtils.replace(
							pString, SAUTDELIGNE_UNIX, pSautLigne);
				
				return resultat;
			}
			
			/* Retourne la chaîne inchangée 
			 * si il n'y avait pas de saut de ligne. */
			return pString;
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de substituerSautLigne(
	 // String pString
	 // , String pSautLigne).______________________________________________
	
	
	
	/**
	 * method afficherSautLigne(
	 * String pSautLigne) :<br/>
	 * Affiche les caractères non imprimables 
	 * saut de ligne (\n ou \r ou \r\n).<br/>
	 * <br/>
	 * - retourne null si pSautLigne est null.<br/>
	 * - retourne null si pSautLigne n'est pas un saut de ligne 
	 * (\n ou \r ou \r\n).<br/>
	 * <br/>
	 *
	 * @param pSautLigne : String : \n ou \r ou \r\n.<br/>
	 * 
	 * @return : String : Affichage des caractères non imprimables 
	 * saut de ligne (\n ou \r ou \r\n).<br/>
	 */
	public static String afficherSautLigne(
			final String pSautLigne) {
		
		/* block static synchronized. */
		synchronized (DifferentiateurString.class) {
			
			/* retourne null si pSautLigne est null. */
			if (pSautLigne == null) {
				return null;
			}
			
			final StringBuilder stb = new StringBuilder();
			
			final char[] newLineChars = pSautLigne.toCharArray();
			
			for (final char caractere : newLineChars) {
				
				if (caractere == '\n') {
					stb.append("\\n");
				}
				else if (caractere == '\r') {
					stb.append("\\r");
				}
				/* retourne null si pSautLigne n'est pas un saut de ligne. */
				else {
					return null;
				}
				
			}
			
			return stb.toString();
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de afficherSautLigne(
	 // String pSautLigne).________________________________________________
	

	
	/**
	 * method loggerInfo(
	 * String pClasse
	 * , String pMethode
	 * , String pMessage) :<br/>
	 * Créée un message de niveau INFO dans le LOG.<br/>
	 * <br/>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pMessage : String : Message particulier de la méthode.<br/>
	 */
	private static void loggerInfo(
			final String pClasse
				, final String pMethode
					, final String pMessage) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null || pMessage == null) {
			return;
		}
		
		/* LOG de niveau INFO. */			
		if (LOG.isInfoEnabled()) {
			
			final String message 
			= pClasse 
			+ IConstantesMessage.SEP_MOINS
			+ pMethode
			+ IConstantesMessage.SEP_MOINS
			+ pMessage;
			
			LOG.info(message);
		}
		
	} // Fin de la classe loggerInfo(
	 // String pClasse
	 // , String pMethode
	 // , String pMessage).________________________________________________
	

	
	/**
	 * method loggerInfo(
	 * String pClasse
	 * , String pMethode
	 * , String pMessage
	 * , String pComplement) :<br/>
	 * Créée un message de niveau INFO dans le LOG.<br/>
	 * <br/>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pMessage : String : Message particulier de la méthode.<br/>
	 * @param pComplement : String : Complément au message de la méthode.<br/>
	 */
	private static void loggerInfo(
			final String pClasse
				, final String pMethode
					, final String pMessage
						, final String pComplement) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null 
				|| pMessage == null || pComplement == null) {
			return;
		}
		
		/* LOG de niveau INFO. */			
		if (LOG.isInfoEnabled()) {
			
			final String message 
			= pClasse 
			+ IConstantesMessage.SEP_MOINS
			+ pMethode
			+ IConstantesMessage.SEP_MOINS
			+ pMessage
			+ pComplement;
			
			LOG.info(message);
		}
		
	} // Fin de loggerInfo(
	 // String pClasse
	 // , String pMethode
	 // , String pMessage
	 // , String pComplement)._____________________________________________
	
	
	
	/**
	 * method loggerError(
	 * String pClasse
	 * , String pMethode
	 * , Exception pException) :<br/>
	 * Créée un message de niveau ERROR dans le LOG.<br/>
	 * <br/>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pException : Exception : Exception transmise 
	 * par la méthode appelante.<br/>
	 */
	private static void loggerError(
			final String pClasse
				, final String pMethode
					, final Exception pException) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null || pException == null) {
			return;
		}
		
		/* LOG de niveau ERROR. */			
		if (LOG.isErrorEnabled()) {
			
			final String message 
			= pClasse 
			+ IConstantesMessage.SEP_MOINS
			+ pMethode
			+ IConstantesMessage.SEP_MOINS 
			+ pException.getMessage();
			
			LOG.error(message, pException);
			
		}
		
	} // Fin de loggerError(
	 // String pClasse
	 // , String pMethode
	 // , Exception pException).___________________________________________
	
	

	/**
	 * method getCodePointDecimal(
	 * Character pChar) :<br/>
	 * Retourne le codePoint d'un caractère exprimé en décimal.<br/>
	 * par exemple : <br/>
	 * - 'à' retourne 224.<br/>
	 * - 'è' retourne 232.<br/>
	 * <br/>
	 * - retourne 0 si pChar == null.<br/>
	 * <br/>
	 * une caractère Unicode = un “codepoint”.<br/>
	 * un char Java = un “codeunit”.<br/>
	 * un “codepoint” est consitué de un “codeunit” 
	 * dans la zone Basic Multilingual Plane (BMP) 
	 * et de deux “codeunits” pour les caractères supplémentaires.<br/>
	 * Par exemple, un caractère gothique (ahsa) 
	 * a pour code Unicode U+10330 (plus grand que 65535). 
	 * Il sera donc représenté de façon interne 
	 * par une paire de char java (“codeunits”) : \uD800,\uDF30.<br/>
	 * <br/>
	 * A code point is a value that can be used in a coded character set.<br/> 
	 * A code point is a 32-bit int data type, 
	 * where the lower 21 bits represent a valid code point value 
	 * and the upper 11 bits are 0.<br/>
	 * <br/>
	 * A coded character set is a set of characters 
	 * for which a unique number has been assigned to each character.<br/> 
	 * Units of a coded character set are known as code points.<br/> 
	 * A code point value represents the position of a character 
	 * in the coded character set. <br/>
	 * For example, the code point for the letter à in the Unicode 
	 * coded character set is 225 in decimal, 
	 * or E1 in hexadecimal notation.<br/>
	 *
	 * @param pChar : Character : le caractère 
	 * dont on veut connaitre le point de code.<br/>
	 * 
	 * @return : int : le point de code en valeur décimale.<br/>
	 */
	public static int getCodePointDecimal(
			final Character pChar) {
		
		/* retourne 0 si pChar == null. */
		if (pChar == null) {
			return 0;
		}
		
		final char[] tabcar = new char[1];
		tabcar[0] = pChar;
		
		final int codePoint = Character.codePointAt(tabcar, 0);
		
		return codePoint;
		
	} // Fin de getCodePointDecimal(
	 // Character pChar).__________________________________________________
	

	
	/**
	 * method getCodePointHexaDecimal(
	 * Character pChar) :<br/>
	 * Retourne le codePoint d'un caractère exprimé en hexadécimal.<br/>
	 * par exemple : <br/>
	 * - 'à' retourne e0.<br/>
	 * - 'è' retourne e8.<br/>
	 * <br/>
	 * - retourne null si pChar == null.<br/>
	 * <br/>
	 * une caractère Unicode = un “codepoint”.<br/>
	 * un char Java = un “codeunit”.<br/>
	 * un “codepoint” est consitué de un “codeunit” 
	 * dans la zone Basic Multilingual Plane (BMP) 
	 * et de deux “codeunits” pour les caractères supplémentaires.<br/>
	 * Par exemple, un caractère gothique (ahsa) 
	 * a pour code Unicode U+10330 (plus grand que 65535). 
	 * Il sera donc représenté de façon interne 
	 * par une paire de char java (“codeunits”) : \uD800,\uDF30.<br/>
	 * <br/>
	 * A code point is a value that can be used in a coded character set.<br/> 
	 * A code point is a 32-bit int data type, 
	 * where the lower 21 bits represent a valid code point value 
	 * and the upper 11 bits are 0.<br/>
	 * <br/>
	 * A coded character set is a set of characters 
	 * for which a unique number has been assigned to each character.<br/> 
	 * Units of a coded character set are known as code points.<br/> 
	 * A code point value represents the position of a character 
	 * in the coded character set. <br/>
	 * For example, the code point for the letter à in the Unicode 
	 * coded character set is 225 in decimal, 
	 * or E1 in hexadecimal notation.<br/>
	 * <br/>
	 *
	 *  @param pChar : Character : le caractère 
	 * dont on veut connaitre le point de code.<br/>
	 * 
	 * @return : String : le point de code en valeur hexadécimale.<br/>
	 */
	public static String getCodePointHexaDecimal(
			final Character pChar) {
		
		/* retourne null si pChar == null. */
		if (pChar == null) {
			return null;
		}
		
		return Integer.toHexString(getCodePointDecimal(pChar));
		
	} // Fin de getCodePointHexaDecimal(
	 // Character pChar).__________________________________________________


	
	/**
	 * method getIntValue(
	 * Character pChar) :<br/>
	 * Retourne la valeur entière d'un caractère retournée 
	 * par la méthode read() d'un Reader.<br/>
	 * <br/>
	 * Cette valeur est la même que celle que 
	 * l'on optient en castant le char en int : (int) pChar.<br/>
	 * Il semblerait que cette valeur soit égale au point de code décimal.<br/>
	 * <br/>
	 * Par exemple : <br/>
	 * - 'à' retourne 224.<br/>
	 * - 'è' retourne 232.<br/>
	 * <br/>
	 * - retourne 0 si pChar == null.<br/>
	 * <br/>
	 *
	 * @param pChar : Character : le caractère dont on veut 
	 * donner la valeur entière retournée par la méthode 
	 * read() d'un Reader.<br/>
	 * 
	 * @return : int : la valeur entière retournée 
	 * par la méthode read() d'un Reader.<br/>
	 */
	public static int getIntValue(
			final Character pChar) {
		
		/* retourne 0 si pChar == null. */
		if (pChar == null) {
			return 0;
		}
		
		return (int) pChar;
		
	} // Fin de getIntValue(
	 // Character pChar).__________________________________________________
	

	
	/**
	 * method getNumericValue(
	 * Character pChar) :<br/>
	 * Retourne la valeur entière que le caractère Unicode représente.<br/>
	 * Utilise Character.getNumericValue(pChar).<br/>
	 * <br/>
	 * - retourne 0 si pChar == null.<br/>
	 * <br/>
	 *
	 * @param pChar : Character.<br/>
	 * 
	 * @return : int : la valeur du caractère Unicode.<br/>
	 */
	public static int getNumericValue(
			final Character pChar) {
		
		/* retourne 0 si pChar == null. */
		if (pChar == null) {
			return 0;
		}
		
		return Character.getNumericValue(pChar);
		
	} // Fin de getNumericValue(
	 // Character pChar).__________________________________________________


	
	/**
	 * method getTypeCharacter(
	 * Character pChar) :<br/>
	 * Retourne une valeur entière indiquant 
	 * la catégorie générale d'un caractère.<br/>
	 * <br/>
	 * Par exemple : <br/>
	 * - 'à' retourne 2.<br/>
	 * - 'è' retourne 2.<br/>
	 * - '.' retourne 24.<br/>
	 * - ' ' retourne 12.<br/>
	 * <br/>
	 * - retourne 0 si pChar == null.<br/>
	 * <br/>
	 *
	 * @param pChar : Character : le caractère 
	 * dont on veut connaitre la catégorie générale.<br/>
	 * 
	 * @return : int : la catégorie générale d'un caractère.<br/>
	 */
	public static int getTypeCharacter(
			final Character pChar) {
		
		/* retourne 0 si pChar == null. */
		if (pChar == null) {
			return 0;
		}
		
		final int pointCode = getCodePointDecimal(pChar);
		
		return Character.getType(pointCode);
		
	} // Fin de getTypeCharacter(
	 // Character pChar).__________________________________________________
	

	
	/**
	 * method getCodeUnicodeHexaDecimal(
	 * Character pCharacter) :<br/>
	 * Retourne le code Unicode (de la forme \\uxxxx) d'un caractère.<br/>
	 * <br/>
	 * - Par exemple : <br/> 
	 * '-' retourne \u002d.<br/>
	 * 'ï' retourne \u00ef.<br/>
	 * ' ' retourne \u0020.<br/>
	 * 'é' retourne \u00e9.<br/>
	 * 'è' retourne \u00e8.<br/>
	 * '\r' retourne \u000d.br/>
	 * '\n' retourne \u000a.<br/>
	 * '’' retourne \u2019.<br/>
	 * <br/>
	 * - retourne null si pCharacter == null.<br/>
	 * <br/>
	 *
	 * @param pCharacter : Character : le caractère 
	 * dont on veut connaitre le code Unicode.<br/>
	 * 
	 * @return : String : Le code Unicode.<br/>
	 */
	public static String getCodeUnicodeHexaDecimal(
			final Character pCharacter) {
		
		String codeUnicodeHexaDecimal;
		
		/* retourne null si pCharacter == null. */
		if (pCharacter == null) {
			return null;
		}
		
		
		try {
			
			/* Récupère le code hexadecimal unicode du caractère. */
			final int nombreUnicodeHexaDecimal = (int) pCharacter;
			
			/* Construit le code unicode hexa de la forme \u002d. */
			codeUnicodeHexaDecimal 
				= String.format(
						LOCALE_FR_FR, "\\u%04x", nombreUnicodeHexaDecimal);
			
		} catch (Exception e) {
			return e.getMessage();
		}
	    
	    return codeUnicodeHexaDecimal;
	    
	} // Fin de getCodeUnicodeHexaDecimal(
	 // Character pCharacter)._____________________________________________


	
	/**
	 * method getNameUnicodeChar(
	 * Character pChar) :<br/>
	 * Retourne le nom Unicode d'un Character.<br/>
	 * <br/>
	 * Exemples :<br/>
	 * - LATIN CAPITAL LETTER E<br/>
	 * - LATIN SMALL LETTER O<br/>
	 * - SPACE<br/>
	 * - REPLACEMENT CHARACTER<br/>
	 * <br/>
	 * - retourne null si pChar == null.<br/>
	 * <br/>
	 *
	 * @param pChar : Character.<br/>
	 * 
	 * @return : String : Nom unicode.<br/>
	 */
	public static String getNameUnicodeChar(
			final Character pChar) {
		
		/* retourne null si pChar == null. */
		if (pChar == null) {
			return null;
		}
		
		char[] tabcar = new char[1];
		tabcar[0] = pChar;
		
		return Character.getName(Character.codePointAt(tabcar, 0));
		
	} // Fin de getNameUnicodeChar(
	 // Character pChar).__________________________________________________


	
	/**
	 * method creerCodePointDecimalfromCodePointHexa(
	 * int pCodePointHexa) :<br/>
	 * Retourne le code point décimal sous forme de String 
	 * à partir du code point hexadécimal.<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * creerCodePointDecimalfromCodePointHexa(0x2d) retourne 45 (caractère '-').<br/>
	 * creerCodePointDecimalfromCodePointHexa(0x4f) retourne 79 (caractère 'O').<br/>
	 * creerCodePointDecimalfromCodePointHexa(0x49) retourne 73 (caractère 'I').<br/>
	 * <br/>
	 *
	 * @param pCodePointHexa : int : code point hexadécimal d'un caractère.<br/>
	 * 
	 * @return : String : le code point décimal sous forme de String.<br/>
	 */
	public static String creerCodePointDecimalfromCodePointHexa(
			final int pCodePointHexa) {
		
		/* Bloc static synchronized. */
		synchronized (DifferentiateurString.class) {
			
			if (Character.charCount(pCodePointHexa) == 1) {
		        return String.valueOf(pCodePointHexa);
		    } 
		        
		    return new String(Character.toChars(pCodePointHexa));
		    
		} // Fin du bloc static.______________________________
	    
	} // Fin de creerCodePointDecimalfromCodePointHexa(
	 // int pCodePointHexa)._______________________________________________
	
	
	
	/**
	 * method main() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pArgs : void :  .<br/>
	 */
	public static void main(final String[] pArgs) {
		
		differencier(ConvertisseurEncodage.lireDepuisFichier(FILE_DIACRITIQUES_UTF8, CHARSET_UTF8), STRING_REF_DIACRITIQUES_UTF8);
	}



	/**
	 * method getRapportDiff() :<br/>
	 * Getter du Rapport textuel 
	 * comparant les deux chaines de caractères.<br/>
	 * <br/>
	 *
	 * @return rapportDiff : String.<br/>
	 */
	public static String getRapportDiff() {
		return rapportDiff;
	} // Fin de getRapportDiff().__________________________________________



	/**
	 * method getRapportDiffCsv() :<br/>
	 * Getter du Rapport au format csv 
	 * comparant les deux chaines de caractères.<br/>
	 * <br/>
	 *
	 * @return rapportDiffCsv : String.<br/>
	 */
	public static String getRapportDiffCsv() {
		return rapportDiffCsv;
	} // Fin de getRapportDiffCsv()._______________________________________


	
} // FIN DE LA CLASSE DifferentiateurString.---------------------------------
