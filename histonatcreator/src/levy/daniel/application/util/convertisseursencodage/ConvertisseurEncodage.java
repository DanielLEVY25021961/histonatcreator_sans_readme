package levy.daniel.application.util.convertisseursencodage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class ConvertisseurEncodage :<br/>
 * Classe utilitaire spécialisée dans la lecture du contenu de fichiers.<br/>
 * <br/>
 * - possède une méthode lireDepuisFichier(File pFile, Charset pCharset) qui :
 * <ul>
 * <li>lit un fichier pFile et retourne son contenu 
 * dans une chaîne de caractères.</li><br/>
 * <li>Lit le fichier en utilisant la méthode read() 
 * de BufferedReader appliqué à un InputStreamReader 
 * avec le Charset de décodage pCharset.</li><br/>
 * <li>Lit chaque caractère quoi qu'il arrive 
 * (même si le fichier n'est pas un fichier texte).</li><br/>
 * <li>Ne modifie pas les sauts de ligne.</li><br/>
 * <li>Alimente l'attribut longueur qui contient 
 * la longueur en caractères de la chaîne lue.</li><br/>
 * <li>Passe contientCarRemplacement à true si la chaine lue 
 * contient un caractère de remplacement.</li><br/>
 * <li>Passe contientCarIndesirable à true si la chaîne lue contient 
 * un caractère indésirable stocké dans CARACTERES_INDESIRABLES_SET.</li><br/>
 * </ul>
 * <br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * synchronized, bloc static synchronized, <br/>
 * FileReader, BufferedReader, bufferedReader.read(), <br/>
 * Cast entier en Character, LOG, <br/>
 * Caractère de remplacement, replacement caracter, "\\ufffd", '�', <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 4 févr. 2016
 *
 */
public final class ConvertisseurEncodage {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * CLASSE_CONVERTISSEUR_ENCODAGE : String :<br/>
	 * "Classe ConvertisseurEncodage".<br/>
	 */
	public static final String CLASSE_CONVERTISSEUR_ENCODAGE 
		= "Classe ConvertisseurEncodage";
	
	/**
	 * METHODE_LIRE_DEPUIS_FICHIER : String :<br/>
	 * "Méthode lireDepuisFichier(File pFile, Charset pCharset)".<br/>
	 */
	public static final String METHODE_LIRE_DEPUIS_FICHIER 
		= "Méthode lireDepuisFichier(File pFile, Charset pCharset)";
	
	
	/**
	 * METHODE_ECRIRESTRINGDANSFILE : String :<br/>
	 * "méthode ecrireStringDansFile(
	 * File pFile, String pString, Charset pCharset)".<br/>
	 */
	public static final String METHODE_ECRIRESTRINGDANSFILE 
		= "méthode ecrireStringDansFile(File pFile, String pString, Charset pCharset)";

	
	/**
	 * METHODE_DETRUIRE_ARBORESCENCE : String :<br/>
	 * "méthode detruireArborescence(String pChemin)".<br/>
	 */
	public static final String METHODE_DETRUIRE_ARBORESCENCE 
		= "méthode detruireArborescence(String pChemin)";
	
	/**
	 * METHODE_VIDER_REPERTOIRE : String :<br/>
	 * "méthode viderRepertoireADetruire(File pFile)".<br/>
	 */
	public static final String METHODE_VIDER_REPERTOIRE 
		= "méthode viderRepertoireADetruire(File pFile)";
	
	
	/**
	 * METHODE_FOURNIRFILE : String :<br/>
	 * "méthode fournirFile(String pChemin, Date pDate, String pNomFichier)".<br/>
	 */
	public static final String METHODE_FOURNIRFILE 
		= "méthode fournirFile(String pChemin, Date pDate, String pNomFichier)";


	/**
	 * METHODE_FOURNIRCHEMINRAPPORTSDANSPROPERTIES : String :<br/>
	 * "Méthode fournirCheminRapportsDansProperties()".<br/>
	 */
	public static final String METHODE_FOURNIRCHEMINRAPPORTSDANSPROPERTIES 
		= "Méthode fournirCheminRapportsDansProperties()";

	
	/**
	 * MESSAGE_FICHIER_NULL : String :<br/>
	 * Message retourné par les méthodes prenant un File en paramètre 
	 * si le fichier est null.<br/>
	 * "Le fichier passé en paramètre est null".<br/>
	 */
	public static final String MESSAGE_FICHIER_NULL 
		= "Le fichier passé en paramètre est null";
	
	/**
	 * MESSAGE_FICHIER_INEXISTANT : String :<br/>
	 * Message retourné par les méthodes prenant un File en paramètre 
	 * si le fichier est inexistant.<br/>
	 * "Le fichier passé en paramètre est inexistant : "
	 */
	public static final String MESSAGE_FICHIER_INEXISTANT 
		= "Le fichier passé en paramètre est inexistant : ";
	
	/**
	 * MESSAGE_FICHIER_REPERTOIRE : String :<br/>
	 * Message retourné par les méthodes prenant un File en paramètre 
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
	 * MESSAGE_EXCEPTION : String :<br/>
	 * "Exception GRAVE : ".<br/>
	 */
	public static final String MESSAGE_EXCEPTION = "Exception GRAVE : ";
	

	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/>
	 */
	public static final Charset CHARSET_UTF8 
		= Charset.forName("UTF-8");

	
	/**
	 * CHARSET_US_ASCII : Charset :<br/>
	 * Charset.forName("US-ASCII").<br/>
	 * Seven-bit ASCII, a.k.a. ISO646-US, 
	 * a.k.a. the Basic Latin block of the Unicode character set.<br/>
	 * standard américain.<br/>
	 * American Standard Code for Information Interchange.<br/> 
	 * 128 caractères imprimables.<br/> 
	 * Sert à écrire l’anglo-américain.<br/> 
	 * Ne permet pas d’écrire les langues européennes 
	 * qui utilisent des lettres avec diacritiques (accents, cédille, ...).<br/> 
	 * On ne peut pas écrire en français avec de l’ASCII.<br/>
	 */
	public static final Charset CHARSET_US_ASCII 
		= Charset.forName("US-ASCII");
	
		
	/**
	 * CHARSET_ISO_8859_1 : Charset :<br/>
	 * Charset.forName("ISO-8859-1").<br/>
	 * Latin1.<br/>
	 * 191 caractères imprimables.<br/> 
	 * Permet d’écrire la plupart des langues d’Europe de l’Ouest.<br/> 
	 * Presque tous les caractères du français y sont (manquent le œ et €).<br/>
	 */
	public static final Charset CHARSET_ISO_8859_1 
		= Charset.forName("ISO-8859-1");
	
	
	/**
	 * CHARSET_LATIN1 : Charset :<br/>
	 * Charset.forName("ISO-8859-1").<br/>
	 * Latin1.<br/>
	 * 191 caractères imprimables.<br/> 
	 * Permet d’écrire la plupart des langues d’Europe de l’Ouest.<br/> 
	 * Presque tous les caractères du français y sont (manquent le œ et €).<br/>
	 */
	public static final Charset CHARSET_LATIN1 
		= Charset.forName("ISO-8859-1");

	
	/**
	 * CHARSET_ISO_8859_15 : Charset :<br/>
	 * Charset.forName("ISO-8859-15").<br/>
	 * Latin9, Latin Alphabet No. 9.<br/>
	 * modifie légèrement ISO-8859-1.<br/> 
	 * Ajout du caractère œ et du symbole monétaire € (Euro) entre autres.<br/>
	 */
	public static final Charset CHARSET_ISO_8859_15 
		= Charset.forName("ISO-8859-15");

	
	/**
	 * CHARSET_LATIN9 : Charset :<br/>
	 * Charset.forName("ISO-8859-15").<br/>
	 * Latin9, Latin Alphabet No. 9.<br/>
	 * modifie légèrement ISO-8859-1.<br/> 
	 * Ajout du caractère œ et du symbole monétaire € (Euro) entre autres.<br/>
	 */
	public static final Charset CHARSET_LATIN9 
		= Charset.forName("ISO-8859-15");
	
	
	/**
	 * CHARSET_WINDOWS_1252 : Charset :<br/>
	 * Charset.forName("windows-1252").<br/>
	 * ANSI, CP1252.<br/>
	 * 218 caractères imprimables.<br/>
	 * extension d’ISO-8859-1, qui rajoute quelques caractères: œ, € (euro), 
	 * guillemets anglais (« »), points de suspension (...)
	 * , signe «pour mille» (‰), 
	 * tirets cadratin (— = \u2014 en unicode ) et demi-cadratin (–), ...<br/>
	 */
	public static final Charset CHARSET_WINDOWS_1252 
		= Charset.forName("windows-1252");

	
	/**
	 * CHARSET_ANSI : Charset :<br/>
	 * Charset.forName("windows-1252").<br/>
	 * ANSI, CP1252.<br/>
	 * 218 caractères imprimables.<br/>
	 * extension d’ISO-8859-1, qui rajoute quelques caractères: œ, € (euro), 
	 * guillemets anglais (« »), points de suspension (...)
	 * , signe «pour mille» (‰), 
	 * tirets cadratin (— = \u2014 en unicode ) et demi-cadratin (–), ...<br/>
	 */
	public static final Charset CHARSET_ANSI
		= Charset.forName("windows-1252");

	
	/**
	 * CHARSET_CP1252 : Charset :<br/>
	 * Charset.forName("windows-1252").<br/>
	 * ANSI, CP1252.<br/>
	 * 218 caractères imprimables.<br/>
	 * extension d’ISO-8859-1, qui rajoute quelques caractères: œ, € (euro), 
	 * guillemets anglais (« »), points de suspension (...)
	 * , signe «pour mille» (‰), 
	 * tirets cadratin (— = \u2014 en unicode ) et demi-cadratin (–), ...<br/>
	 */
	public static final Charset CHARSET_CP1252
		= Charset.forName("windows-1252");

	
	
	/**
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("fr", "FR").<br/>
	 * "fr" correspond au langage et "FR" au pays.<br/>
	 */
	public static final Locale LOCALE_FR_FR = new Locale("fr", "FR");

	
	/**
	 * DF_DATE_LEXICOGRAPHIQUE : DateFormat :<br/>
	 * Format lexicographique des dates 
	 * comme "2012-01-16" pour le
	 * 16 Janvier 2012.<br/>
	 * "yyyy-MM-dd".<br/>
	 */
	public static final DateFormat DF_DATE_LEXICOGRAPHIQUE 
		= new SimpleDateFormat("yyyy-MM-dd", LOCALE_FR_FR);
	
	
	/**
	 * DF_DATETIME_LEXICOGRAPHIQUE : DateFormat :<br/>
	 * Format lexicographique des dates avec time 
	 * comme "2012-01-16_18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 * "yyyy-MM-dd_HH-mm-ss".<br/>
	 */
	public static final DateFormat DF_DATETIME_LEXICOGRAPHIQUE 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", LOCALE_FR_FR);
	

	/**
	 * DF_DATETIME_LEXICOGRAPHIQUEMILLI : DateFormat :<br/>
	 * Format lexicographique des dates avec time 
	 * comme "2012-01-16_18-09-55-769" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes,55 secondes et 769 millisecondes.<br/>
	 * "yyyy-MM-dd_HH-mm-ss-SSS".<br/>
	 */
	public static final DateFormat DF_DATETIME_LEXICOGRAPHIQUEMILLI 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", LOCALE_FR_FR);

	
	/**
	 * DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE : DateFormat :<br/>
	 * Format concentré des dates avec heures et secondes
	 * comme "2012-01-16_18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	public static final DateFormat DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", LOCALE_FR_FR);
	
	


	/**
	 * SEP_MOINS : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEP_MOINS = " - ";

	
	/**
	 * UNDERSCORE : char :<br/>
	 * '_'.<br/>
	 */
	public static final char UNDERSCORE = '_';
	
	
	/**
	 * POINT : char :<br/>
	 * '.'.<br/>
	 */
	public static final char POINT = '.';
	
	
	/**
	 * SEPARATEUR_FILE : String :<br/>
	 * "\\".<br/>
	 */
	public static final String SEPARATEUR_FILE = "\\";
	

	/**
	 * SEP_POINTVIRGULE : String :<br/>
	 * ";".<br/>
	 */
	public static final String SEP_POINTVIRGULE = ";";

	
	/**
	 * SEP_REP : String :<br/>
	 * Séparateur Java pour les répertoires "\\".<br/>
	 */
	public static final String SEP_REP = "\\";
	

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
	 * "\r\n" (Retour Chariot RC + Retour Ligne Line Feed LF).
	 */
	public static final String SAUTDELIGNE_DOS_WINDOWS = "\r\n";

	
	/**
	 * NEWLINE : String :<br/>
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	public static final String NEWLINE = System.getProperty("line.separator");


	/**
	 * CARACTERE_REMPLACEMENT : char :<br/>
	 * Caractère de remplacement introduit lors de la lecture en UTF-8 
	 * d'un fichier texte encodé avec un autre Charset.<br/>
	 * REPLACEMENT CHARACTER."\\ufffd" '�'.<br/> 
	 */
	public static final char CARACTERE_REMPLACEMENT = '\ufffd';

	
	/**
	 * CARACTERES_INDESIRABLES_SET : Set&lt;Character&gt; :<br/>
	 * Set contenant des caractères indésirables 
	 * (impossibles à écrire simplement au clavier).<br/>
	 */
	public static final Set<Character> CARACTERES_INDESIRABLES_SET 
		= new HashSet<Character>();
	
	
	/**
	 * longueur : int :<br/>
	 * longueur en caractères de la chaîne lue par 
	 * lireDepuisFichier(File pFile, Charset pCharset).<br/>
	 */
	private static int longueur;

	
	/**
	 * contientCarRemplacement : boolean :<br/>
	 * boolean qui précise si la chaîne lue par 
	 * lireDepuisFichier(File pFile, Charset pCharset) 
	 * contient des caractères de remplacement 
	 * (REPLACEMENT CHARACTER "\\ufffd").<br/>
	 */
	private static boolean contientCarRemplacement;

	
	/**
	 * contientCarIndesirable : boolean :<br/>
	 * boolean qui précise si la chaîne lue par 
	 * lireDepuisFichier(File pFile, Charset pCharset) 
	 * contient des caractères indésirables.<br/>
	 * (impossibles à écrire simplement au clavier).<br/>
	 */
	private static boolean contientCarIndesirable;
	
	
	static {
		
		/* ACUTE ACCENT '´' */
		CARACTERES_INDESIRABLES_SET.add('\u00b4');
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
		
	}
	
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(ConvertisseurEncodage.class);

	// *************************METHODES************************************/
	
	
	/**
	 * method CONSTRUCTEUR ConvertisseurEncodage() :
	 * Constructeur private pour empêcher l'instanciation.
	 */
	private ConvertisseurEncodage() {
		super();
	} // Fin de CONSTRUCTEUR ConvertisseurEncodage().______________________
	

	
	/**
	 * method lireDepuisFichierEnUtf8(
	 * File pFile) :<br/>
	 * Lit un fichier pFile et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage UTF-8.<br/>
	 * Lit chaque caractère quoi qu'il arrive 
	 * (même si le fichier n'est pas un fichier texte).<br/>
	 * Ne modifie pas les sauts de ligne.<br/>
	 * Alimente l'attribut longueur qui contient 
	 * la longueur en caractères de la chaîne lue.<br/>
	 * - Passe contientCarRemplacement à true si la chaine 
	 * lue contient un caractère de remplacement.<br/>
	 * - Passe contientCarIndesirable à true si la chaîne lue contient un caractère indésirable stocké dans CARACTERES_INDESIRABLES_SET.<br/>
	 * <br/>
	 * - Choisit automatiquement le CHARSET_UTF8 
	 * pour décoder le contenu du fichier.<br/>
	 * <br/>
	 * - retourne MESSAGE_FICHIER_NULL si le pFile est null.<br/>
	 * - retourne MESSAGE_FICHIER_INEXISTANT si le pFile est inexistant.<br/>
	 * - retourne MESSAGE_FICHIER_REPERTOIRE si le pFile est un répertoire.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier à lire.<br/>
	 * 
	 * @return : String : Chaine de caractères avec le contenu du fichier.<br/>
	 */
	public static String lireDepuisFichierEnUtf8(
			final File pFile) {
		
		return lireDepuisFichier(pFile, null);
		
	} // Fin de lireDepuisFichierEnUtf8(
	 // File pFile)._______________________________________________________
	

	
	/**
	 * method lireDepuisFichier(
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
	 * Alimente l'attribut longueur qui contient 
	 * la longueur en caractères de la chaîne lue.<br/>
	 * - Passe contientCarRemplacement à true si la chaine 
	 * lue contient un caractère de remplacement.<br/>
	 * Passe contientCarIndesirable à true si la chaîne lue contient un caractère indésirable stocké dans CARACTERES_INDESIRABLES_SET.<br/>
	 * <br/>
	 * - Choisit automatiquement le CHARSET_UTF8 si pCharset == null.<br/>
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
	public static String lireDepuisFichier(
			final File pFile
				, final Charset pCharset) {
		
		/* block static synchronized. */
		synchronized (ConvertisseurEncodage.class) {
			
			/* remise à zéro de la longueur. */
			longueur = 0;
			
			/* remise à false des booléens. */
			contientCarRemplacement = false;
			contientCarIndesirable = false;
			
			/* retourne MESSAGE_FICHIER_NULL 
			 * si le pFile est null. */
			if (pFile == null) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, METHODE_LIRE_DEPUIS_FICHIER
								, MESSAGE_FICHIER_NULL);
				
				/* retour de MESSAGE_FICHIER_NULL. */
				return MESSAGE_FICHIER_NULL;
			}
			
			/* retourne MESSAGE_FICHIER_INEXISTANT 
			 * si le pFile est inexistant. */
			if (!pFile.exists()) {
								
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, METHODE_LIRE_DEPUIS_FICHIER
								, MESSAGE_FICHIER_INEXISTANT
									, pFile.getAbsolutePath());
				
				/* retour de MESSAGE_FICHIER_INEXISTANT. */
				return MESSAGE_FICHIER_INEXISTANT;
			}
			
			
			/* retourne MESSAGE_FICHIER_REPERTOIRE 
			 * si le pFile est un répertoire. */
			if (pFile.isDirectory()) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, METHODE_LIRE_DEPUIS_FICHIER
								, MESSAGE_FICHIER_REPERTOIRE
									, pFile.getAbsolutePath());
				
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
			if(pCharset == null) {
				charset = CHARSET_UTF8;
			}
			else {
				charset = pCharset;
			}
			
						
			try {
				
				/* Instancie un flux en lecture fileInputStream 
				 * en lui passant pFile. */
				fileInputStream = new FileInputStream(pFile);
				
				/* Instancie un InputStreamReader 
				 * en lui passant le FileReader et le Charset. */
				inputStreamReader 
					= new InputStreamReader(fileInputStream, charset);
				
				/* Instancie un tampon de flux de caractères en lecture 
				 * en lui passant le flux inputStreamReader. */
				bufferedReader 
					= new BufferedReader(inputStreamReader);
				
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
					
					/* Passe contientCarRemplacement à true 
					 * si la chaine lue contient un caractère 
					 * de remplacement. */
					if (character == CARACTERE_REMPLACEMENT) {
						contientCarRemplacement = true;
					}
					
					/* Passe contientCarIndesirable à true si la chaîne lue 
					 * contient un caractère indésirable stocké dans 
					 * CARACTERES_INDESIRABLES_SET. */
					if (CARACTERES_INDESIRABLES_SET.contains(character)) {
						contientCarIndesirable = true;
					}
					
					/* Ajout du caractère au StringBuilder. */
					stb.append(character);
					
				} // Fin du parcours du bufferedReader._________
				
				
				final String resultat = stb.toString();
				
				/* Alimentation de longueur. */
				if (resultat != null) {
					longueur = resultat.length();
				}
				
				/* Retour de la chaine de caractères. ***********/
				return resultat;
				
			} catch (FileNotFoundException fnfe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, METHODE_LIRE_DEPUIS_FICHIER
								, fnfe);
				
				/* retourne le message de l'exception. */
				return fnfe.getMessage();
				
			} catch (IOException ioe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, METHODE_LIRE_DEPUIS_FICHIER
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
								CLASSE_CONVERTISSEUR_ENCODAGE
									, METHODE_LIRE_DEPUIS_FICHIER
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
								CLASSE_CONVERTISSEUR_ENCODAGE
									, METHODE_LIRE_DEPUIS_FICHIER
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
								CLASSE_CONVERTISSEUR_ENCODAGE
									, METHODE_LIRE_DEPUIS_FICHIER
										, ioe3);
						
					}
					
				} // Fin de if (fileInputStream != null).________
				
			} // Fin du finally._____________________________
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de lireDepuisFichier(
	 // File pFile
	 // , Charset pCharset).______________________________________________
	

	
	/**
	 * method convertirFichier(File pFile, Charset pCharsetDecodage, Charset pCharsetEncodage, String pSautLigne) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pFile
	 * @param pCharsetDecodage
	 * @param pCharsetEncodage
	 * @param pSautLigne
	 * @return : File :  .<br/>
	 */
	public static File convertirFichier(
			final File pFile
				, final Charset pCharsetDecodage
					, final Charset pCharsetEncodage
						, final String pSautLigne) {
		
		/* Récupère la String à encoder en décodant le contenu de pFile avec pCharsetDecodage. */
		final String stringAConvertir = ConvertisseurEncodage.lireDepuisFichier(pFile, pCharsetDecodage);
		
		/* Récupération du chemin des fichiers transcodés fourni par fournirCheminFichiers(). */
		final String cheminTranscodes = fournirCheminFichiers();
		
		/* Création du nom du fichier transcodé à créer. */
		final String nomFichier = pFile.getName() + "_Fichier_Transcode_Depuis_" + pCharsetDecodage.displayName(LOCALE_FR_FR) + "_vers";
		
		/* Récupération du File vide pour le fichier transcodé créé par fournirFile(...). */
		final File file = fournirFile(cheminTranscodes, nomFichier, pCharsetEncodage.displayName(LOCALE_FR_FR), "txt");
		
		/* Ecriture de la String à encoder dans le fichier transcodé en encodant avec pCharsetEncodage et en substituant les sauts de ligne par pSautLigne. */
		return ecrireStringDansFile(file, stringAConvertir, pCharsetEncodage, pSautLigne);
	}

	
	
	/**
	 * method ecrireStringDansFile(
	 * String pString
	 * , Charset pCharsetDecodage
	 * , Charset pCharsetEncodage
	 * , String pSautLigne) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pString
	 * @param pCharsetDecodage
	 * @param pCharsetEncodage
	 * @param pSautLigne
	 * @return : File :  .<br/>
	 */
	public static File ecrireStringDansFile(
				final String pString
					, final Charset pCharsetDecodage
					, final Charset pCharsetEncodage
						, final String pSautLigne) {
		
		/* Récupération du chemin des fichiers transcodés fourni par fournirCheminFichiers(). */
		final String cheminTranscodes = fournirCheminFichiers();
		
		final String nomFichier = "Fichier_Transcode_Depuis_" + pCharsetDecodage.displayName(LOCALE_FR_FR) + "_vers";
		
		final File file = fournirFile(cheminTranscodes, nomFichier, pCharsetEncodage.displayName(LOCALE_FR_FR), "txt");
		
		return ecrireStringDansFile(file, pString, pCharsetEncodage, pSautLigne);
		
	} // Fin de ecrireStringDansFile(
	 // String pString
	 // , Charset pCharsetDecodage
	 // , Charset pCharsetEncodage
	 // , String pSautLigne).______________________________________________
	
	
	
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
		synchronized (ConvertisseurEncodage.class) {
			
			/* retourne null si le pFile est null. */
			if (pFile == null) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, METHODE_ECRIRESTRINGDANSFILE
								, MESSAGE_FICHIER_NULL);
				
				/* retour de null. */
				return null;
			}
			
			/* retourne null si le pFile est inexistant. */
			if (!pFile.exists()) {
								
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_CONVERTISSEUR_ENCODAGE
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
						CLASSE_CONVERTISSEUR_ENCODAGE
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
						CLASSE_CONVERTISSEUR_ENCODAGE
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
				bufferedWriter.flush();
				
				// Retour du fichier. 
				return pFile;
				
			} catch (FileNotFoundException fnfe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, MESSAGE_EXCEPTION				
								, fnfe);
				
				/* retour de null. */
				return null;
				
			} catch (IOException ioe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, MESSAGE_EXCEPTION				
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
								CLASSE_CONVERTISSEUR_ENCODAGE
									, MESSAGE_EXCEPTION				
										, ioe1);
					}
				} // Fin de if (bufferedWriter != null).__________
				
				if (outputStreamWriter != null) {
					try {
						
						outputStreamWriter.close();
						
					} catch (IOException ioe2) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_CONVERTISSEUR_ENCODAGE
									, MESSAGE_EXCEPTION				
										, ioe2);
					}
				} // Fin de if (outputStreamWriter != null).______
				
				if (fileOutputStream != null) {
					try {
						
						fileOutputStream.close();
						
					} catch (IOException ioe3) {
						
						//* LOG de niveau ERROR. */
						loggerError(
								CLASSE_CONVERTISSEUR_ENCODAGE
									, MESSAGE_EXCEPTION				
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
		synchronized (ConvertisseurEncodage.class) {
			
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
		synchronized (ConvertisseurEncodage.class) {
			
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
	 * method fournirCheminFichiers() :<br/>
	 * Propose un chemin (arborescence de répertoires) pour stocker 
	 * les fichiers transcodés du ConvertisseurEncodage en utilisant :<br/>
	 * 1 - un chemin des rapports fixé dans 
	 * configurationapplication_fr_FR.properties si il existe.<br/>
	 * 2 - un chemin en dur stocké dans la présente classe 
	 * et fourni par <code>fournirCheminFichiersTranscodesEnDur()</code>.<br/>
	 * <br/>
	 * - retourne le chemin des fichiers indiqué 
	 * dans configuration_fr_FR.properties si il existe
	 * , si la clef définie dans 
	 * <code>fournirCleCheminFichiersTranscodes()</code> 
	 * existe dans ce properties et si cette clef y est renseignée.<br/>
	 * - sinon retourne la valeur en dur écrite dans 
	 * <code>fournirCheminFichiersTranscodesEnDur()</code>.<br/>
	 * <br/>
	 *
	 * @return : String : Le chemin des fichiers transcodés.<br/>
	 */
	private static String fournirCheminFichiers() {
		return fournirCheminFichiers(null);
	} // Fin de fournirCheminFichiers().___________________________________
	
	
	
	/**
	 * method fournirCheminFichiers(
	 * String pCheminFichiers) :<br/>
	 * Propose un chemin (arborescence de répertoires) pour stocker 
	 * les fichiers transcodés du ConvertisseurEncodage en utilisant :<br/>
	 * 1 - pCheminFichiers si il n'est pas blank.<br/>
	 * 2 - un chemin des rapports fixé dans 
	 * configurationapplication_fr_FR.properties si il existe.<br/>
	 * 3 - un chemin en dur stocké dans la présente classe 
	 * et fourni par <code>fournirCheminFichiersTranscodesEnDur()</code>.<br/>
	 * <br/>
	 * - retourne pCheminFichiers si pCheminFichiers n'est pas blank,<br/>
	 * - sinon le chemin des fichiers indiqué 
	 * dans configuration_fr_FR.properties si il existe
	 * , si la clef définie dans 
	 * <code>fournirCleCheminFichiersTranscodes()</code> 
	 * existe dans ce properties et si cette clef y est renseignée.<br/>
	 * - sinon retourne la valeur en dur écrite dans 
	 * <code>fournirCheminFichiersTranscodesEnDur()</code>.<br/>
	 * <br/>
	 *
	 * @param pCheminFichiers : String : 
	 * chemin des fichiers transcodés proposé par le développeur.<br/>
	 * 
	 * @return : String : Le chemin des fichiers transcodés.<br/>
	 */
	private static String fournirCheminFichiers(
			final String pCheminFichiers) {
		
		/* retourne pCheminFichiers si pCheminFichiers n'est pas blank. */
		if (!StringUtils.isBlank(pCheminFichiers)) {
			return pCheminFichiers;
		}
		
		/* sinon, retourne le chemin des fichiers indiqué 
		 * dans configuration_fr_FR.properties si il existe
		 * , si la clef définie dans fournirCleCheminRapports() existe 
		 * et si cette clef est renseignée. */
		if (!StringUtils.isBlank(
				fournirCheminFichiersTranscodesDansProperties())) {
			
			return fournirCheminFichiersTranscodesDansProperties();
		}
		
		/* sinon, retourne la valeur en dur écrite 
		 * dans fournirCheminRapportsEnDur.*/
		return fournirCheminFichiersTranscodesEnDur() ;
		
	} // Fin de fournirCheminFichiers(
	 // String pCheminFichiers).___________________________________________
	
	
	
	/**
	 * method fournirCleCheminFichiersTranscodes() :<br/>
	 * Fournit la clé dans configurationapplication_fr_FR.properties 
	 * associée au chemin des fichiers transcodés du ConvertisseurEncodage.<br/>
	 * <br/>
	 * "ConvertisseurEncodage.fournirCheminFichiers.chemintranscodage".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "ConvertisseurEncodage.fournirCheminFichiers.chemintranscodage".<br/>
	 */
	private static String fournirCleCheminFichiersTranscodes() {
		return "ConvertisseurEncodage.fournirCheminFichiers.chemintranscodage";
	} // Fin de fournirCleCheminFichiersTranscodes().______________________
	
	
	
	/**
	 * method fournirCheminFichiersTranscodesDansProperties() :<br/>
	 * retourne la valeur du chemin des fichiers transcodés associée 
	 * à la clé fournie par <code>fournirCleCheminFichiersTranscodes()</code> 
	 * contenue dans ./bin/configurationapplication_fr_FR.properties.<br/>
	 * retourne null ou "  " si le properties a été oublié
	 * , si la clé est absente dans le properties, 
	 * ou si la valeur associée à la clef est inexistante.<br/>
	 * <br/>
	 * - retourne null si ./bin/configurationapplication_fr_FR.properties 
	 * est manquant.<br/>
	 * - retourne null si ./bin/configurationapplication_fr_FR.properties 
	 * ne contient pas la clef fournie par 
	 * <code>fournirCleCheminFichiersTranscodes()</code>.<br/>
	 * - retourne " " si ./bin/configurationapplication_fr_FR.properties 
	 * contient la clef fournie par 
	 * <code>fournirCleCheminFichiersTranscodes()</code> 
	 * mais qu'il n'y a pas de valeur associée à cette clé 
	 * dans le properties.<br/>
	 * <br/>
	 *
	 * @return : String :   le chemin des fichiers transcodés dans 
	 * ./bin/configurationapplication_fr_FR.properties.<br/>
	 */
	private static String fournirCheminFichiersTranscodesDansProperties() {
		
		/* bloc static synchronized. */
		synchronized (ConvertisseurEncodage.class) {
			
			String chemin = null;
			
			try {
				
				/* Charge le ResourceBundle encapsulant 
				 * configurationapplication_fr_FR.properties*/
				final ResourceBundle bundle 
					= ResourceBundle.getBundle(
							"configurationapplication", LOCALE_FR_FR);
				
				chemin = bundle.getString(fournirCleCheminFichiersTranscodes());
				
			} catch (Exception e) {
				
				final String message 
				= "./bin/configurationapplication_fr_FR.properties "
						+ "est manquant ou la clé n'existe pas - Exception : ";
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_CONVERTISSEUR_ENCODAGE
						, METHODE_FOURNIRCHEMINRAPPORTSDANSPROPERTIES
						, message
						, e.getMessage());
				
				/* retourne null si 
				 * ./bin/configurationapplication_fr_FR.properties 
				 * est manquant. */
				return null;
			}
			
			return chemin;
			
		} // Fin du bloc static synchronized.__________________________
		
	} // Fin de fournirCheminFichiersTranscodesDansProperties().___________


	
	/**
	 * method fournirCheminFichiersTranscodesEnDur() :<br/>
	 * Fournit un chemin (arborescence) en dur au cas où :<br/>
	 * 1 - le developpeur ne propose pas de chemin en paramètre  
	 * dans fournirCheminFichiers(String pCheminFichiers),<br/>
	 * 2 - Il n'existe pas de ./bin/configurationapplication_fr_FR.properties 
	 * (ou pas la clef dans le properties fournie par 
	 * <code>fournirCleCheminFichiersTranscodes()</code>, 
	 * ou pas de valeur associée à cette clef).<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * ".\\data\\temp\\fichierstranscodes".<br/>
	 */
	private static String fournirCheminFichiersTranscodesEnDur() {
		return ".\\data\\temp\\fichierstranscodes";
	} // Fin de fournirCheminFichiersTranscodesEnDur().____________________
	
	

	/**
	 * method fournirFile(
	 * String pChemin
	 * , String pNomFichier
	 * , String pEncodage
	 * , String pExtension) :<br/>
	 * Insère automatiquement la date courante.<br/>
	 * Fabrique éventuellement l'arborescence pChemin 
	 * (".\\data\\temp\\rapports" par exemple)<br/>
	 * , fabrique le nom du fichier sous la forme 
	 * [dateCourante_nom_encodage.extension] 
	 * comme "2016-02-25_14-27-07_RAPPORT_UTF8.txt" par exemple<br/>
	 * , fabrique et retourne le fichier 
	 * (.\data2\temp\rapports\2016-02-25_14-27-07_RAPPORT_UTF8.txt 
	 * par exemple).<br/>
	 * <br/>
	 * - crée un répertoire (ou toute l'arborescence) 
	 * pour le fichier si il n'existe pas.<br/>
	 * - Prend automatiquement la date système.<br/>
	 * <br/>
	 * Par exemple : <br/>
	 * <code>
	 * final String chemin1 = ".\\data2\\temp\\rapports";<br/>
	 * // Crée le fichier 
	 * .\data2\temp\rapports\2016-02-25_14-27-07_RAPPORT_UTF8.txt<br/>
	 * final File resultat = GestionnaireFichiers.fournirFile(
	 * chemin1,"RAPPORT", "UTF8", "txt");<br/>
	 * </code>
	 * <br/>
	 * - retourne null si pChemin est blank.<br/>
	 * - retourne null si pNomFichier est blank.<br/>
	 * - retourne null (et LOG ERROR) si il se produit une Exception 
	 * lors de la création du fichier.<br/>
	 * <br/>
	 *
	 *  @param pChemin : String : chemin (arborescence de répertoires) 
	 * pour le fichier.<br/>
	 *  @param pNomFichier : String : nom de base du fichier.<br/>
	 * @param pEncodage : String : encodage pour suffixer 
	 * le nom du fichier.<br/>
	 * @param pExtension : String : extension du fichier.<br/>
	 * 
	 * @return : File : Le File créé.<br/>
	 */
	private static File fournirFile(
			final String pChemin
				, final String pNomFichier
					, final String pEncodage
						, final String pExtension) {
		
		return fournirFile(pChemin, null, pNomFichier, pEncodage, pExtension);
		
	} // Fin de fournirFile(date courante).________________________________
	
	
	
	/**
	 * method fournirFile(
	 * String pChemin
	 * , Date pDate
	 * , String pNomFichier
	 * , String pEncodage
	 * , String pExtension) :<br/>
	 * Fabrique éventuellement l'arborescence pChemin 
	 * (".\\data\\temp\\rapports" par exemple)<br/>
	 * , fabrique le nom du fichier sous la forme 
	 * [date_nom_encodage.extension] 
	 * comme "1961-02-25_14-27-07_RAPPORT_UTF8.txt" par exemple<br/>
	 * , fabrique et retourne le fichier 
	 * (.\data2\temp\rapports\1961-02-25_14-27-07_RAPPORT_UTF8.txt 
	 * par exemple).<br/>
	 * <br/>
	 * - crée un répertoire (ou toute l'arborescence) 
	 * pour le fichier si il n'existe pas.<br/>
	 * - Prend automatiquement la date système si pDate est null.<br/>
	 * <br/>
	 * Par exemple : <br/>
	 * <code>
	 * final String chemin1 = ".\\data2\\temp\\rapports";<br/>
	 * final Date date1 = GestionnaireDates.fournirDateAvecString(
	 * "25/02/1961-14:27:07.251", DF_DATETIMEMILLI_FRANCAISE);<br/>
	 * // Crée le fichier 
	 * .\data2\temp\rapports\1961-02-25_14-27-07_RAPPORT_UTF8.txt<br/>
	 * final File resultat = GestionnaireFichiers.fournirFile(
	 * chemin1, date1, "RAPPORT", "UTF8", "txt");<br/>
	 * </code>
	 * <br/>
	 * - retourne null si pChemin est blank.<br/>
	 * - retourne null si pNomFichier est blank.<br/>
	 * - retourne null (et LOG ERROR) si il se produit une Exception 
	 * lors de la création du fichier.<br/>
	 * <br/>
	 * 
	 * @param pChemin : String : chemin (arborescence de répertoires) 
	 * pour le fichier.<br/>
	 * @param pDate : Date : Date pour préfixer le nom du fichier. 
	 * La Date sera formattée sous la forme "yyyy-MM-dd_HH-mm-ss-SSS" 
	 * de DF_DATETIME_LEXICOGRAPHIQUEMILLI comme 2012-01-16_18-09-55-729 <br/>
	 * @param pNomFichier : String : nom de base du fichier.<br/>
	 * @param pEncodage : String : encodage pour suffixer 
	 * le nom du fichier.<br/>
	 * @param pExtension : String : extension du fichier.<br/>
	 * 
	 * @return : File : Le File créé.<br/>
	 */
	private static File fournirFile(
			final String pChemin
				, final Date pDate
					, final String pNomFichier
						, final String pEncodage
							, final String pExtension) {
		
		/* bloc static synchronized. */
		synchronized (ConvertisseurEncodage.class) {
			
			/* retourne null si pChemin est blank. */
			if (StringUtils.isBlank(pChemin)) {
				return null;
			}
			
			/* retourne null si pNomFichier est blank. */
			if (StringUtils.isBlank(pNomFichier)) {
				return null;
			}
						
			/* crée un répertoire pour le fichier si il n'existe pas. */
			creerArborescence(pChemin);
			
			/* crée le chemin complet du fichier en nommant le fichier. */
			final String cheminFichier 
				= pChemin 
				+ SEPARATEUR_FILE 
				+ fournirNomFichier(pDate, pNomFichier, pEncodage, pExtension);
			
			final File resultatFile = new File(cheminFichier);
			
			/* Création du fichier si il n'existe pas. */
			if (!resultatFile.exists()) {
				try {
					
					resultatFile.createNewFile();
					
				} catch (IOException ioe) {
					
					/* LOG de niveau ERROR. */
					loggerError(
							CLASSE_CONVERTISSEUR_ENCODAGE
								, METHODE_FOURNIRFILE
									, ioe);
					
					/* retourne null (et LOG ERROR) si il se produit 
					 * une Exception lors de la création du fichier. */
					return null;
					
				}
			}
			
			return resultatFile;
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de fournirFile()._____________________________________________


	
	/**
	 * method fournirNomFichier(
	 * Date pDate
	 * , String pNom
	 * , String pEncodage
	 * , String pExtension) :<br/>
	 * Fournit un nom pour un fichier 
	 * de la forme [date_nom_encodage.extension].<br/>
	 * Par exemple : <br/>
	 * <code>final Date date1 = GestionnaireDates.fournirDateAvecString(
	 * "25/02/1961-14:27:07.251", DF_DATETIMEMILLI_FRANCAISE);</code> 
	 * instancie une date calée le 25/02/1961 à 14h27'07" 
	 * et 251 millisecondes.<br/>
	 * <code>GestionnaireFichiers.fournirNomFichier(
	 * date1, "RAPPORT", "UTF8", "txt");</code> 
	 * retourne "1961-02-25_14-27-07-789_RAPPORT_UTF8.txt".<br/>
	 * <br/>
	 * - passe automatiquement la date à la date système si pDate == null.<br/>
	 * - retourne null si pNom est blank.<br/>
	 * <br/>
	 *
	 * @param pDate : Date : Date pour préfixer le chemin. 
	 * La Date sera formattée sous la forme "yyyy-MM-dd_HH-mm-ss" 
	 * de DF_DATETIME_LEXICOGRAPHIQUEMILLI comme 2012-01-16_18-09-55-789 <br/>
	 * @param pNom : String : nom de base du fichier.<br/>
	 * @param pEncodage : String : encodage pour suffixer 
	 * le nom du fichier.<br/>
	 * @param pExtension : String : extension du fichier.<br/>
	 * 
	 * @return : String : Nom pour le fichier.<br/>
	 */
	private static String fournirNomFichier(
			final Date pDate
				, final String pNom
					, final String pEncodage
						, final String pExtension) {
		
		/* bloc static synchronized. */
		synchronized (ConvertisseurEncodage.class) {
			
			Date date = null;
			
			/* passe automatiquement la date 
			 * à la date système si pDate == null. */
			if (pDate == null) {
				date = new Date();
			}
			else {
				date = pDate;
			}
			
			/* retourne null si pNom est blank. */
			if(StringUtils.isBlank(pNom)) {
				return null;
			}
			
			/* Récupère la date  
			 * formattée sous la forme 2012-01-16_18-09-55-759. */
			final String dateFormatteeString 
				= fournirDateFormattee(date, DF_DATETIME_LEXICOGRAPHIQUEMILLI);
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(dateFormatteeString);
			stb.append(UNDERSCORE);
			stb.append(pNom);
			
			if (!StringUtils.isBlank(pEncodage)) {
				stb.append(UNDERSCORE);
				stb.append(pEncodage);
			}
			
			if (!StringUtils.isBlank(pExtension)) {
				stb.append(POINT);
				stb.append(pExtension);
			}
			
			return stb.toString();
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de fournirNomFichier(...).____________________________________
	
	
	
	/**
	 * method fournirDateFormattee(
	 * Date pDate
	 * , DateFormat pDateFormat) :<br/>
	 * Retourne une String représentant la java.util.Date pDate 
	 * au format pDateFormat.<br/>
	 * Par exemple :<br/>
	 * - Retourne la String "25/02/1961" 
	 * avec une Date au 25/02/1961 et un DateFormat 
	 * DF_DATE_FRANCAISE (
	 * new SimpleDateFormat("dd/MM/yyyy", LOCALE_FR_FR)).<br/>
	 * <br/>
	 * - retourne null si pDate == null.<br/>
	 * - retourne null si pDateFormat == null.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * @param pDateFormat : DateFormat.<br/>
	 * 
	 * @return : String : String pour affichage 
	 * formatté de pDate selon pDateFormat.<br/>
	 */
	private static String fournirDateFormattee(
			final Date pDate
				, final DateFormat pDateFormat) {
		
		/* bloc static synchronized. */
		synchronized (ConvertisseurEncodage.class) {
			
			/* retourne null si pDate == null. */
			if(pDate == null) {
				return null;
			}
			
			/* retourne null si pDateFormat == null. */
			if(pDateFormat == null) {
				return null;
			}
			
			pDateFormat.setLenient(false);
			
			return pDateFormat.format(pDate);
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de fournirDateFormattee(
	 // Date pDate
	 // DateFormat pDateFormat).___________________________________________
	


	/**
	 * method creerArborescence(
	 * String pChemin) :<br/>
	 * Créée en une seule fois toute l'arborescence passée en paramètre.<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * - creerArborescence("C:\\NewRep1\\NewRep2\\NewRep3") 
	 * va créer toute cette arborescence sur le disque d'un seul coup.<br/>
	 * - creerArborescence(".\\data2\\temp\\rapports") 
	 * va créer cette arborescence à partir 
	 * du répertoire courant d'un seul coup.<br/>
	 * <br/>
	 * - retourne false si pChemin est blank.<br/>
	 * - retourne false si l'arborescence existe déjà.<br/>
	 * - retourne false si pChemin ne contient pas '\\'.<br/>
	 * - retourne false si un des répertoires du chemin est blank.<br/>
	 * - retourne false si la racine du chemin n'existe pas.<br/>
	 * - retourne false si la racine du chemin n'est pas un répertoire.<br/>
	 * - retourne false si un répertoire a créer n'a pas été créé.<br/>
	 * <br/>
	 *
	 * @param pChemin : String : Chemin de l'arborescence à créer.<br/>
	 * 
	 * @return boolean : true si l'arborescence a été créée.<br/>
	 */
	private static boolean creerArborescence(
			final String pChemin) {
		
		/* bloc static synchronized. */
		synchronized (ConvertisseurEncodage.class) {
			
			/* retourne false si pChemin est blank. */
			if (StringUtils.isBlank(pChemin)) {
				return false;
			}
			
			final File cheminFile = new File(pChemin);
			
			/* retourne false si l'arborescence existe déjà. */
			if (cheminFile.exists()) {
				return false;
			}
			
			/* retourne false si pChemin ne contient pas '\\'. */
			if (!StringUtils.contains(pChemin, "\\")) {
				return false;
			}
			
			/* Récupération des répertoires par découpage de la chaine. */
			final String[] repertoires = StringUtils.split(pChemin, "\\");
			final int nombreRep = repertoires.length;
			
			/* retourne false si un des répertoires du chemin est blank. */
			for(final String rep : repertoires) {
				if (StringUtils.isBlank(rep)) {
					return false;
				}
			}
			
			/* Extraction de la racine. */
			final String repRacineString = repertoires[0];
			
			final File repRacine = new File(repRacineString);
			
			/* retourne false si la racine du chemin n'existe pas. */
			if (!repRacine.exists()) {
				return false;
			}
			
			/* retourne false si la racine du chemin n'est pas un répertoire. */
			if (!repRacine.isDirectory()) {
				return false;
			}
			
			final StringBuffer stb = new StringBuffer();
			
			stb.append(repRacineString);
			
			/* Boucle sur les répertoires du chemin. */
			for (int i = 1; i < nombreRep; i++) {
				
				/* Création du chemin du répertoire à créer. */
				stb.append(SEP_REP);
				stb.append(repertoires[i]);
				
				final File repertoireFile = new File(stb.toString());
				
				/* Créée le répertoire au chemin de création 
				 * si il n'existait pas.*/
				if (!repertoireFile.exists()) {
					
					if (!repertoireFile.mkdir()) {
						/* retourne false si un répertoire 
						 * a créer n'a pas été créé. */
						return false;
					}
				}
				
			} // Fin de boucle.________________________
			
			/* retourne true si l'arborescence a été créée. */
			return true;
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de creerArborescence(
	 // String pChemin).___________________________________________________
	
	
	
	/**
	 * method detruireArborescence(
	 * String pChemin) :<br/>
	 * Détruit le répertoire situé au chemin pChemin.<br/>
	 * Vide le contenu du répertoire si nécessaire avant de le supprimer.<br/>
	 * <br/>
	 * - retourne false si pChemin est blank.<br/>
	 * - retourne false si le répertoire à détruire n'existe pas.<br/>
	 * - retourne false si le File à détruire n'est pas un répertoire.
	 * <br/>
	 *
	 * @param pChemin : String : Chemin du répertoire à détruire.<br/>
	 * 
	 * @return : boolean : true si le répertoire a été détruit.<br/>
	 */
	public static boolean detruireArborescence(
			final String pChemin) {
		
		/* bloc static synchronized. */
		synchronized (ConvertisseurEncodage.class) {
			
			/* retourne false si pChemin est blank. */
			if (StringUtils.isBlank(pChemin)) {
				return false;
			}
						
			final File repADetruire = new File(pChemin);
			
			/* retourne false si le répertoire à détruire n'existe pas. */
			if (!repADetruire.exists()) {
				return false;
			}
			
			/* retourne false si le File à détruire n'est pas un répertoire. */
			if (!repADetruire.isDirectory()) {
				return false;
			}
						
			/* Détruit le répertoire et retourne le boolean. */				
			try {
				
				/* Vide d'abord le contenu du répertoire. */
				viderRepertoireADetruire(repADetruire);
				
				/* Détruit le répertoire. */
				return repADetruire.delete();
				
			} catch (Exception e) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, METHODE_DETRUIRE_ARBORESCENCE
								, e.getMessage());
				
				return false;
				
			}
				
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de detruireArborescence(
	 // String pChemin).___________________________________________________
	
	

	/**
	 * method viderRepertoireADetruire(
	 * File pRep) :<br/>
	 * Vide tout le contenu du répertoire pRep sans écraser pRep.<br/>
	 * méthode récursive.<br/>
	 * Il est indispensable de vider tout le contenu d'un répertoire 
	 * avant de pouvoir supprimer celui-ci en Java.<br/>
	 * <br/>
	 * Retourne un boolean à true si le 
	 * contenu du répertoire a bien été effacé.<br/>
	 * <br/>
	 * - retourne false si pRep == null.<br/>
	 * - retourne false si pRep n'existe pas.<br/>
	 * - retourne false si pRep n'est pas un répertoire.<br/>
	 * <br/>
	 *
	 * @param pRep : File : Répertoire dont on veut vider 
	 * tout le contenu le contenu tout en le conservant.<br/>
	 * 
	 * @return : boolean : true si le contenu du répertoire a été vidé.<br/>
	 */
	private static boolean viderRepertoireADetruire(
			final File pRep) {
				
		/* bloc static synchronized. */
		synchronized (ConvertisseurEncodage.class) {
						
			/* retourne false si pRep == null. */
			if (pRep == null) {
				return false;
			}
			
			/* retourne false si pRep n'existe pas. */
			if (!pRep.exists()) {
				return false;
			}
			
			/* retourne false si pRep n'est pas un répertoire. */
			if(!pRep.isDirectory()) {
				return false;
			}
			
			/* Récupération des File dans pRep. */
			final File[] filesContenus = pRep.listFiles();
			
			if (filesContenus == null) {
				return true;
			}
			
			/* Sort Si pRep est vide. */
			if (filesContenus.length == 0) {
				return true;
			}
			
			/* Si pRep non vide. */
			/* ForEach (boucle) sur les File de pRep. ******/
			for(final File file : filesContenus) {
				
				/* Appel récursif si file est un répertoire. */
				if (file.isDirectory()) {
					
					/* APPEL RECURSIF. */
					viderRepertoireADetruire(file);
					
					
				} // Fin de if (!file.isDirectory()).___________
				
				/* Destruction du file dans tous les cas. */					
				try {
					
					file.delete();
					
				} catch (Exception e) {
					
					/* LOG de niveau INFO. */
					loggerInfo(
							CLASSE_CONVERTISSEUR_ENCODAGE
								, METHODE_VIDER_REPERTOIRE
									, e.getMessage());
					return false;
					
				}
									
			} // Fin du ForEach (boucle) sur les File de pRep.___
			
			return true;
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de viderRepertoireADetruire(
	 // File pRep).________________________________________________________
	

	
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
			+ SEP_MOINS
			+ pMethode
			+ SEP_MOINS
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
			+ SEP_MOINS
			+ pMethode
			+ SEP_MOINS
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
			+ SEP_MOINS
			+ pMethode
			+ SEP_MOINS 
			+ pException.getMessage();
			
			LOG.error(message, pException);
			
		}
		
	} // Fin de loggerError(
	 // String pClasse
	 // , String pMethode
	 // , Exception pException).___________________________________________



	/**
	 * method getLongueur() :<br/>
	 * Getter de la longueur en caractères de la chaîne lue par 
	 * lireDepuisFichier(File pFile, Charset pCharset).<br/>
	 * <br/>
	 *
	 * @return longueur : int.<br/>
	 */
	public static int getLongueur() {
		return longueur;
	} // Fin de getLongueur()._____________________________________________



	/**
	 * method isContientCarRemplacement() :<br/>
	 * Getter du boolean qui précise si la chaîne lue par 
	 * lireDepuisFichier(File pFile, Charset pCharset) 
	 * contient des caractères de remplacement 
	 * (REPLACEMENT CHARACTER "\\ufffd" '�').<br/>
	 * <br/>
	 *
	 * @return contientCarRemplacement : boolean.<br/>
	 */
	public static boolean isContientCarRemplacement() {
		return contientCarRemplacement;
	} // Fin de isContientCarRemplacement()._______________________________



	/**
	 * method isContientCarIndesirable() :<br/>
	 * Getter du boolean qui précise si la chaîne lue par 
	 * lireDepuisFichier(File pFile, Charset pCharset) 
	 * contient des caractères indésirables contenus dans 
	 * CARACTERES_INDESIRABLES_SET (impossibles à 
	 * écrire simplement au clavier).<br/>
	 * <br/>
	 *
	 * @return contientCarIndesirable : boolean.<br/>
	 */
	public static boolean isContientCarIndesirable() {
		return contientCarIndesirable;
	} // Fin de isContientCarIndesirable().________________________________
	
		
	
} // FIN DE LA CLASSE ConvertisseurEncodage.---------------------------------
