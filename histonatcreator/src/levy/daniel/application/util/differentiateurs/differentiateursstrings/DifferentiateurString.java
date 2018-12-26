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
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class DifferentiateurString :<br/>
 * Classe utilitaire spécialisée 
 * dans la détection caractère par caractère et 
 * dans le calcul de la différence entre deux String.<br/>
 * Fournit les données Unicode concernant les caractères.<br/>
 * <br/>
 * - possède une méthode listerChaineCarParCar(String pString) qui liste 
 * caractère par caractère sur des lignes distinctes 
 * une chaine de caractères pString avec les informations 
 * Unicode concernant les caractères.<br/>
 * <br/>
 * - possède une méthode differencier(String pString1, String pString2) qui :<br/>
 * <ul>
 * <li>Détermine les différences caractère par caractère 
 * entre 2 chaînes pString1 et pString2.</li><br/>
 * <li>Génère un rapport des différences 
 * aux formats textuel (rapportDiff) et csv (rapportDiffCsv).</li><br/>
 * <li>Ecrit dans des fichiers sur disque les rapports des différences 
 * aux formats textuel (fileRapportDiff) et csv (fileRapportDiffCsv).</li><br/>
 * <li>Crée des rapports de création du fichier textuel 
 * (rapportCreationFichierDiff) et csv (rapportCreationFichierDiffCsv).</li><br/>
 * <li>Retourne le rapport textuel.</li><br/>
 * <li>Alimente longueurChaine1 et longueurChaine2.</li><br/>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code>// Application de la méthode differencier(...) du DifferentiateurString.<br/>
 * DifferentiateurString.differencier("mêt", "met", true);<br/>
 * <br/>
 * // récupération du rapport des différences textuel (rapportDiff).<br/>
 * final String rapportTxt1 = DifferentiateurString.getRapportDiff();<br/>
 * // récupération du rapport des différences csv (rapportDiffCsv).<br/>
 * final String rapportCsv1 = DifferentiateurString.getRapportDiffCsv();<br/>
 * // récupération du fichier UTF-8 contenant le rapport des différences textuel (fileRapportDiff).<br/>
 * final File fileRapportTxt1 = DifferentiateurString.getFileRapportDiff();<br/>
 * // récupération du fichier UTF-8 contenant le rapport des différences csv (fileRapportDiffCsv).<br/>
 * final File fileRapportCsv1 = DifferentiateurString.getFileRapportDiffCsv();<br/>
 * // récupération de la longueur de la chaine 1 (longueurChaine1).<br/>
 * final int longueurChaine1 = DifferentiateurString.getLongueurChaine1();<br/>
 * // récupération de la longueur de la chaine 2 (longueurChaine2).<br/>
 * final int longueurChaine2 = DifferentiateurString.getLongueurChaine2();<br/>
 * // récupération du rapport de création de fileRapportDiff.<br/>		
 * final String messageCreationRapportTxt1 = DifferentiateurString.getRapportCreationfichierDiff();<br/>
 * // récupération du rapport de création de fileRapportDiffCsv.<br/>
 * final String messageCreationRapportCsv1 = DifferentiateurString.getRapportCreationfichierDiffCsv();<br/>
 * </code>
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
 * Ecrire String dans File,<br/>
 * ecriture sur disque avec encodage, Charset, ecrireStringDansFile()<br/>
 * FileOutputStream, outputStreamWriter, <br/>
 * mkdir(), création répertoire,<br/> vider arborescence,<br/>
 * APPEL RECURSIF.<br/>
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
	 * MESSAGE_EXCEPTION : String :<br/>
	 * "Exception GRAVE : ".<br/>
	 */
	public static final String MESSAGE_EXCEPTION = "Exception GRAVE : ";
	
	
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
	 * SEP_MOINS : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEP_MOINS = " - ";

	
	/**
	 * SEP_REP : String :<br/>
	 * Séparateur Java pour les répertoires "\\".<br/>
	 */
	public static final String SEP_REP = "\\";
	
	
	/**
	 * BOM_UTF : char :<br/>
	 * BOM UTF-8 pour forcer Excel 2010 à lire en UTF-8.<br/>
	 */
	public static final char BOM_UTF_8 = '\uFEFF';
	

	/**
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("fr", "FR").<br/>
	 * "fr" correspond au langage et "FR" au pays.<br/>
	 */
	public static final Locale LOCALE_FR_FR = new Locale("fr", "FR");

	
	/**
	 * LOCALE_SYSTEM : Locale :<br/>
	 * Locale de la plateforme.<br/>
	 * Locale.getDefault().<br/>
	 */
	public static final Locale LOCALE_SYSTEM = Locale.getDefault();
	

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
	 * rapportDiff : String :<br/>
	 * Rapport textuel comparant les deux chaines de caractères.<br/>
	 * Fourni par la méthode differencier(...).<br/>
	 */
	private static String rapportDiff;
	
	
	/**
	 * rapportDiffCsv : String :<br/>
	 * Rapport au format csv comparant les deux chaines de caractères.<br/>
	 * Fourni par la méthode differencier(...).<br/>
	 */
	private static String rapportDiffCsv;

	
	/**
	 * fileRapportDiff : File :<br/>
	 * File contenant le Rapport textuel 
	 * comparant les deux chaines de caractères.<br/>
	 * Fourni par la méthode differencier(...).<br/>
	 */
	private static File fileRapportDiff;

	
	/**
	 * fileRapportDiffCsv : File :<br/>
	 * File contenant le Rapport au format csv 
	 * comparant les deux chaines de caractères.<br/>
	 * Fourni par la méthode differencier(...).<br/>
	 */
	private static File fileRapportDiffCsv;

	
	/**
	 * longueurChaine : int :<br/>
	 * longueur de la chaîne de caractères transmise à la méthode listerChaineCarParCar(...).<br/>
	 */
	private static int longueurChaine;

	
	/**
	 * longueurChaine1 : int :<br/>
	 * longueur de la première chaîne passée à 
	 * la méthode differencier(String pString1, String pString2, ...).<br/>
	 * Fourni par la méthode differencier(...).<br/>
	 */
	private static int longueurChaine1;
	
	
	/**
	 * longueurChaine2 : int :<br/>
	 * longueur de la deuxième chaîne passée à 
	 * la méthode differencier(String pString1, String pString2, ...).<br/>
	 * Fourni par la méthode differencier(...).<br/>
	 */
	private static int longueurChaine2;

	
	/**
	 * rapportCreationfichierDiff : String :<br/>
	 * rapport de création de fileRapportDiff.<br/>
	 * (le fichier a bien été créé...).<br/>
	 */
	private static String rapportCreationfichierDiff;

	
	/**
	 * rapportCreationfichierDiffCsv : String :<br/>
	 * rapport de création de fileRapportDiffCsv.<br/>
	 * (le fichier a bien été créé...).<br/>
	 */
	private static String rapportCreationfichierDiffCsv;
	
	
	
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
	public static String listerChaineCarParCar(
			final String pString) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurString.class) {
			
			/* retourne null si pString est blank (null ou vide). */
			if (StringUtils.isBlank(pString)) {
				return null;
			}
			
			/* Remise à zéro de longueurChaine. */
			longueurChaine = 0;
			
			/* Détermine la longueur de la chaîne. */
			longueurChaine = pString.length();
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
	 * method differencier(
	 * String pString1
	 * , String pString2) :<br/>
	 * <ul>
	 * <li>Détermine les différences caractère par caractère 
	 * entre 2 chaînes pString1 et pString2.</li><br/>
	 * <li>Génère un rapport des différences 
	 * aux formats textuel (rapportDiff) et csv (rapportDiffCsv).</li><br/>
	 * <li>Ecrit dans des fichiers sur disque les rapports des différences 
	 * aux formats textuel (fileRapportDiff) et csv (fileRapportDiffCsv).</li><br/>
	 * <li>Crée des rapports de création du fichier textuel 
	 * (rapportCreationFichierDiff) et csv (rapportCreationFichierDiffCsv).</li><br/>
	 * <li>Retourne le rapport textuel.</li><br/>
	 * <li>Alimente longueurChaine1 et longueurChaine2.</li><br/>
	 * </ul>
	 * <br/>
	 *
	 * @param pString1 : String : 1ère chaîne à comparer.<br/>
	 * @param pString2 : String : 2ème chaîne à comparer.<br/>
	 * 
	 * @return : String : rapportDiff : Rapport textuel en UTF-8 
	 * comparant les deux chaines de caractères.<br/>
	 */
	public static String differencier(
			final String pString1
				, final String pString2) {
		
		return differencier(pString1, pString2, true);
		
	} // Fin de differencier(
	 // String pString1
	 // , String pString2).________________________________________________
	
	
	
	/**
	 * method differencier(
	 * String pString1
	 * , String pString2
	 * , Boolean pRapportFichier) :<br/>
	 * <ul>
	 * <li>Détermine les différences caractère par caractère 
	 * entre 2 chaînes pString1 et pString2.</li><br/>
	 * <li>Génère un rapport des différences 
	 * aux formats textuel (rapportDiff) et csv (rapportDiffCsv).</li><br/>
	 * <li>Ecrit dans des fichiers sur disque les rapports des différences 
	 * aux formats textuel (fileRapportDiff) et csv (fileRapportDiffCsv) 
	 * si pRapportFichier vaut true.</li><br/>
	 * <li>Crée des rapports de création du fichier textuel 
	 * (rapportCreationFichierDiff) et csv (rapportCreationFichierDiffCsv).</li><br/>
	 * <li>Ajout d'un caractère BOM-UTF-8 au début du rapport csv
	 * pour forcer Excel 2010 à détecter l'UTF-8.</li><br/>
	 * <li>Retourne le rapport textuel.</li><br/>
	 * <li>Alimente longueurChaine1 et longueurChaine2.</li><br/>
	 * </ul>
	 * <br/>
	 *
	 * @param pString1 : String : 1ère chaîne à comparer.<br/>
	 * @param pString2 : String : 2ème chaîne à comparer.<br/>
	 * @param pRapportFichier : Boolean : true si les rapports 
	 * textuel et csv doivent être écrits dans des fichiers.<br/>
	 * 
	 * @return : String : rapportDiff : Rapport textuel en UTF-8 
	 * comparant les deux chaines de caractères.<br/>
	 */
	public static String differencier(
			final String pString1
				, final String pString2
					, final Boolean pRapportFichier) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurString.class) {
			
			/* mise à null des rapports, des file et des longueurs de chaine. */
			rapportDiff = null;
			rapportDiffCsv = null;
			fileRapportDiff = null;
			fileRapportDiffCsv = null;
			longueurChaine1 = 0;
			longueurChaine2 = 0;
			rapportCreationfichierDiff = null;
			rapportCreationfichierDiffCsv = null;
			
			int longueurMax = 0;
			int position = 0;
			Character caractereChaine1 = null;
			Character caractereChaine2 = null;
			String diff = null;
			
			final StringBuilder stbDiff = new StringBuilder();
			final StringBuilder stbDiffCsv = new StringBuilder();
			
			/* Détermine la longueur de la plus longue chaîne. */
			/* Alimente longueurChaine1 et longueurChaine2. */
			longueurChaine1 = pString1.length();
			longueurChaine2 = pString2.length();
			
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
					= c1.toString() + String.format(LOCALE_FR_FR
							, "DIFFERENCE : %-8s", diff)
								+ c2.toString();
				
				final String comparaisonCsv 
					= c1.toCsv() + diff + ";" + c2.toCsv();
				
				/* Ajout dans les StringBuilders pour les rapports. */
				/* rapport textuel. ******/
				stbDiff.append(comparaison);
				stbDiff.append(NEWLINE);
				
				/* rapport csv. ******/				
				/* Ajout d'un caractère BOM-UTF-8 au début du rapport csv
				 * pour forcer Excel 2010 à détecter l'UTF-8. */				
				stbDiffCsv.append(BOM_UTF_8);
				
								
				/* Ajout de l'en-tête pour le rapport Csv. */
				if (position == 1) {
					stbDiffCsv.append(c1.getEnTeteCsv());
					stbDiffCsv.append("DIFFERENCE");
					stbDiffCsv.append(SEP_POINTVIRGULE);
					stbDiffCsv.append(c1.getEnTeteCsv());
					stbDiffCsv.append(NEWLINE);
				}
				stbDiffCsv.append(comparaisonCsv);
				stbDiffCsv.append(NEWLINE);
								
			} // Fin de la boucle sur les caractères._______________
			
			/* Récupération du chemin des file 
			 * contenant les rapports du DifferentiateurString. */
			final String cheminRapports = fournirCheminFichiers();
			
			/* Injection dans le rapport textuel. */
			rapportDiff = stbDiff.toString();
			/* Injection dans le rapport csv. */
			rapportDiffCsv = stbDiffCsv.toString();
			
			/* Ecriture des rapports dans les 
			 * fileRapportDiff et fileRapportDiffCsv 
			 * en UTF_8. */
			if (pRapportFichier) {
				
				if (!StringUtils.isBlank(cheminRapports)) {
					
					/* Récupère les fichiers 
					 * pour écrire les rapports sur le disque. */
					fileRapportDiff 
						= fournirFile(cheminRapports
								, "Rapport_Differentiateur"
									, "UTF8"
										, "txt");
					
					fileRapportDiffCsv 
					= fournirFile(cheminRapports
							, "Rapport_Differentiateur"
								, "UTF8"
									, "csv");
					
					if (fileRapportDiff != null) {
						
						/* Ecriture du rapport textuel 
						 * dans fileRapportDiff en UTF_8. */
						ecrireStringDansFile(
								fileRapportDiff
									, rapportDiff
										, CHARSET_UTF8, NEWLINE);
						
						/* Rapport de création du fichier textuel. */
						rapportCreationfichierDiff 
							= "fichier de rapport textuel des différences entre les chaînes de caractères créé : " 
									+ fileRapportDiff.getAbsolutePath();
					}
					else {
						
						rapportCreationfichierDiff 
						= "PROBLEME - fichier de rapport textuel des différences entre les chaînes de caractères non créé.";
					}
					
					if (fileRapportDiffCsv != null) {
						
						/* Ecriture du rapport csv 
						 * dans fileRapportDiffCsv en UTF-8. */
						ecrireStringDansFile(
								fileRapportDiffCsv
									, rapportDiffCsv
										, CHARSET_UTF8, NEWLINE);
						
						/* Rapport de création du fichier csv. */
						rapportCreationfichierDiffCsv 
						= "fichier de rapport csv des différences entre les chaînes de caractères créé : " 
								+ fileRapportDiffCsv.getAbsolutePath();
					}
					else {
						
						rapportCreationfichierDiffCsv 
						= "PROBLEME - fichier de rapport csv des différences entre les chaînes de caractères non créé."; 
					}
				}								
			}
									
			/* retourne le rapport textuel. */
			return rapportDiff;
						
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de differencier(
	// String pString1
	 // , String pString2
	//, Boolean pRapportFichier).__________________________________________


	
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
	private static File ecrireStringDansFile(
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
				bufferedWriter.flush();
				
				// Retour du fichier. 
				return pFile;
				
			} catch (FileNotFoundException fnfe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_DIFFERENTIATEURSTRING
							, MESSAGE_EXCEPTION				
								, fnfe);
				
				/* retour de null. */
				return null;
				
			} catch (IOException ioe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_DIFFERENTIATEURSTRING
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
								CLASSE_DIFFERENTIATEURSTRING
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
								CLASSE_DIFFERENTIATEURSTRING
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
								CLASSE_DIFFERENTIATEURSTRING
									, MESSAGE_EXCEPTION				
										, ioe3);
					}
				}
				
			} // Fin du finally.____________________________
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de ecrireStringDansFile(...)._________________________________
	

	
	/**
	 * method fournirCheminFichiers() :<br/>
	 * Propose un chemin (arborescence de répertoires) pour stocker 
	 * les fichiers de rapport du DifferentiateurString en utilisant :<br/>
	 * 1 - un chemin des rapports fixé dans 
	 * configurationapplication_fr_FR.properties si il existe.<br/>
	 * 2 - un chemin en dur stocké dans la présente classe 
	 * et fourni par fournirCheminRapportsEnDur().<br/>
	 * <br/>
	 * retourne le chemin des fichiers indiqué 
	 * dans configuration_fr_FR.properties si il existe
	 * , si la clef définie dans fournirCleCheminRapports() 
	 * existe et si cette clef est renseignée,<br/>
	 * - sinon retourne la valeur en dur écrite dans 
	 * fournirCheminRapportsEnDur().<br/>
	 * <br/>
	 *
	 * @return : String : Le chemin des rapports.<br/>
	 */
	private static String fournirCheminFichiers() {
		return fournirCheminFichiers(null);
	} // Fin de fournirCheminFichiers().___________________________________
	
	
	
	/**
	 * method fournirCheminFichiers(
	 * String pCheminFichiers) :<br/>
	 * Propose un chemin (arborescence de répertoires) pour stocker 
	 * les fichiers de rapport du DifferentiateurString en utilisant :<br/>
	 * 1 - pCheminFichiers si il n'est pas blank.<br/>
	 * 2 - un chemin des rapports fixé dans 
	 * configurationapplication_fr_FR.properties si il existe.<br/>
	 * 3 - un chemin en dur stocké dans la présente classe 
	 * et fourni par fournirCheminRapportsEnDur().<br/>
	 * <br/>
	 * - retourne pCheminFichiers si pCheminFichiers n'est pas blank,<br/>
	 * - sinon retourne le chemin des fichiers indiqué 
	 * dans configuration_fr_FR.properties si il existe
	 * , si la clef définie dans fournirCleCheminRapports() 
	 * existe et si cette clef est renseignée,<br/>
	 * - sinon retourne la valeur en dur écrite dans 
	 * fournirCheminRapportsEnDur().<br/>
	 * <br/>
	 *
	 * @param pCheminFichiers : String : 
	 * chemin des rapports proposé par le développeur.<br/>
	 * 
	 * @return : String : Le chemin des rapports.<br/>
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
		if (!StringUtils.isBlank(fournirCheminRapportsDansProperties())) {
			return fournirCheminRapportsDansProperties();
		}
		
		/* sinon, retourne la valeur en dur écrite 
		 * dans fournirCheminRapportsEnDur.*/
		return fournirCheminRapportsEnDur() ;
		
	} // Fin de fournirCheminFichiers(
	 // String pCheminFichiers).___________________________________________
	
	
	
	/**
	 * method fournirCleCheminRapports() :<br/>
	 * Fournit la clé dans configurationapplication_fr_FR.properties 
	 * associée au chemin des rapports du DifferentiateurString.<br/>
	 * <br/>
	 * "DifferentiateurString.fournirCheminFichiers.cheminrapports".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "DifferentiateurString.fournirCheminFichiers.cheminrapports".<br/>
	 */
	private static String fournirCleCheminRapports() {
		return "DifferentiateurString.fournirCheminFichiers.cheminrapports";
	} // Fin de fournirCleCheminRapports().________________________________
	
	
	
	/**
	 * method fournirValeurCheminRapports() :<br/>
	 * retourne la valeur du chemin des rapports associée 
	 * à la clé fournie par fournirCleCheminRapports() 
	 * contenue dans ./bin/configurationapplication_fr_FR.properties.<br/>
	 * retourne null ou "  " si le properties a été oublié
	 * , si la clé est absente dans le properties, 
	 * ou si la valeur associée à la clef est inexistante.<br/>
	 * <br/>
	 * - retourne null si ./bin/configurationapplication_fr_FR.properties 
	 * est manquant.<br/>
	 * - retourne null si ./bin/configurationapplication_fr_FR.properties 
	 * ne contient pas la clef fournie par fournirCleCheminRapports().<br/>
	 * - retourne " " si ./bin/configurationapplication_fr_FR.properties 
	 * contient la clef fournie par fournirCleCheminRapports() 
	 * mais qu'il n'y a pas de valeur associée à cette clé 
	 * dans le properties.<br/>
	 * <br/>
	 *
	 * @return : String :   le chemin des rapports dans 
	 * ./bin/configurationapplication_fr_FR.properties.<br/>
	 */
	private static String fournirCheminRapportsDansProperties() {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurString.class) {
			
			String chemin = null;
			
			try {
				
				/* Charge le ResourceBundle encapsulant 
				 * configurationapplication_fr_FR.properties*/
				final ResourceBundle bundle 
					= ResourceBundle.getBundle(
							"configurationapplication", LOCALE_FR_FR);
				
				chemin = bundle.getString(fournirCleCheminRapports());
				
			} catch (Exception e) {
				
				final String message 
				= "./bin/configurationapplication_fr_FR.properties "
						+ "est manquant ou la clé n'existe pas - Exception : ";
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_DIFFERENTIATEURSTRING
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
		
	} // Fin de fournirCheminRapportsDansProperties()._____________________


	
	/**
	 * method fournirCheminRapportsEnDur() :<br/>
	 * Fournit un chemin (arborescence) en dur au cas où :<br/>
	 * 1 - le developpeur ne propose pas de chemin en paramètre  
	 * dans fournirCheminFichiers(String pCheminFichiers),<br/>
	 * 2 - Il n'existe pas de ./bin/configurationapplication_fr_FR.properties 
	 * (ou pas la clef dans le properties fournie par 
	 * fournirCleCheminRapports(), 
	 * ou pas de valeur associée à cette clef).<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * ".\\data\\temp\\rapports\\rapportsdifferentiateur".<br/>
	 */
	private static String fournirCheminRapportsEnDur() {
		return ".\\data\\temp\\rapports\\rapportsdifferentiateur";
	} // Fin de fournirCheminRapportsEnDur().______________________________
	
	

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
	 * La Date sera formattée sous la forme "yyyy-MM-dd_HH-mm-ss" 
	 * de DF_DATETIMEMILLI_FRANCAISE comme 2012-01-16_18-09-55 <br/>
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
		synchronized (DifferentiateurString.class) {
			
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
							CLASSE_DIFFERENTIATEURSTRING
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
	 * La Date sera formattée sous la forme "yyyy-MM-dd_HH-mm-ss-SSS" 
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
		synchronized (DifferentiateurString.class) {
			
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
		synchronized (DifferentiateurString.class) {
			
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
		synchronized (DifferentiateurString.class) {
			
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
		synchronized (DifferentiateurString.class) {
			
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
						CLASSE_DIFFERENTIATEURSTRING
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
		synchronized (DifferentiateurString.class) {
						
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
							CLASSE_DIFFERENTIATEURSTRING
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
	 * method fournirCaractereDan(
	 * char pChar) :<br/>
	 * Fournit une Encapsulation permettant de calculer et de stocker 
	 * toutes les grandeurs intéressantes d'un caractère.<br/>
	 * "[id = null;Position = 0;Caractère;Unicode;numericValue;
	 * Type de Caractère;Valeur Entière;Point de Code Décimal;
	 * Point de Code HexaDécimal;Nom Unicode;]".<br/>
	 * <br/>
	 *
	 * @param pChar : char : caractère dont on veut 
	 * connaitre les valeurs unicode.<br/>
	 * 
	 * @return : CaractereDan.<br/>
	 */
	public static CaractereDan fournirCaractereDan(
			final char pChar) {
		return new CaractereDan(pChar);
	} // Fin de fournirCaractereDan(
	 // char pChar)._______________________________________________________
	

	
	/**
	 * method afficherTout() :<br/>
	 * Fournit une String pour afficher à la console
	 *  toutes les données calculées par 
	 *  DifferentiateurString.differencier(chaine1, chaine2, true).<br/>
	 * <br/>
	 *
	 * @return : String :  
	 * Affichage à la console.<br/>
	 */
	public static String afficherTout() {
		
		final StringBuffer stb = new StringBuffer();
		stb.append("Rapport textuel (rapportDiff) : ");
		stb.append(NEWLINE);
		stb.append(rapportDiff);
		
		stb.append(NEWLINE);
		
		stb.append("Rapport csv (rapportDiffCsv) : ");
		stb.append(NEWLINE);
		stb.append(rapportDiffCsv);
		
		stb.append(NEWLINE);
		
		stb.append("longueur de la première chaîne (longueurChaine1) : ");
		stb.append(longueurChaine1);
		
		stb.append(NEWLINE);
		
		stb.append("longueur de la deuxième chaîne (longueurChaine2) : ");
		stb.append(longueurChaine2);
		
		stb.append(NEWLINE);
		stb.append(NEWLINE);
		
		stb.append("Message de création du fichier contenant le rapport textuel en UTF-8 (fileRapportDiff) : ");
		stb.append(NEWLINE);
		stb.append(rapportCreationfichierDiff);
		
		stb.append(NEWLINE);
		
		stb.append("Message de création du fichier contenant le rapport csv en UTF-8 (fileRapportDiffCsv) : ");
		stb.append(NEWLINE);
		stb.append(rapportCreationfichierDiffCsv);
		
		return stb.toString();
		
	} // Fin de afficherTout().______________________________________________
	
	
	
	/**
	 * method affichierTableauFiles(
	 * File[] pFiles) :<br/>
	 * Retourne une String pour l'affichage d'un tableau de Files.<br/>
	 * Liste les fichiers contenus dans le tableau sous la forme 
	 * [.\rep_0\file_1_3.txt;.\rep_0\rep_1_1;.\rep_0\rep_1_2].<br/>
	 * <br/>
	 * - retourne null si pFile == null.<br/>
	 * - retourne [] si pFile est vide.<br/>
	 * <br/>
	 * 
	 *
	 * @param pFiles : File[] : tableau de File à afficher.<br/>
	 * @return : String : String pour affichage.<br/>
	 */
	public static String affichierTableauFiles(
			final File[] pFiles) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurString.class) {
			
			/* retourne null si pFile == null. */
			if(pFiles == null) {
				return null;
			}
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append('[');
			
			for(int i = 0; i < pFiles.length; i++) {
				stb.append(pFiles[i].getPath());
				
				if (i < pFiles.length - 1) {
					stb.append(";");
				}				
			}
			
			stb.append(']');
			
			return stb.toString();
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de affichierTableauFiles(
	 // File[] pFiles).____________________________________________________
	
	
	
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
	 * - retourne null si pSautLigne est null.<br/>
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
			
			/* retourne null si pSautLigne est null. */
			if (pSautLigne == null) {
				return null;
			}
			
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
	 * method getRapportDiff() :<br/>
	 * Getter du Rapport textuel 
	 * comparant les deux chaines de caractères.<br/>
	 * Fourni par la méthode differencier(...).<br/>
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
	 * Fourni par la méthode differencier(...).<br/>
	 * <br/>
	 *
	 * @return rapportDiffCsv : String.<br/>
	 */
	public static String getRapportDiffCsv() {
		return rapportDiffCsv;
	} // Fin de getRapportDiffCsv()._______________________________________



	/**
	 * method getFileRapportDiff() :<br/>
	 * Getter du File contenant le Rapport textuel 
	 * comparant les deux chaines de caractères.<br/>
	 * Fourni par la méthode differencier(...).<br/>
	 * <br/>
	 *
	 * @return fileRapportDiff : File.<br/>
	 */
	public static File getFileRapportDiff() {
		return fileRapportDiff;
	} // Fin de getFileRapportDiff().______________________________________



	/**
	 * method getFileRapportDiffCsv() :<br/>
	 * Getter du File contenant le Rapport au format csv 
	 * comparant les deux chaines de caractères.<br/>
	 * Fourni par la méthode differencier(...).<br/>
	 * <br/>
	 *
	 * @return fileRapportDiffCsv : File.<br/>
	 */
	public static File getFileRapportDiffCsv() {
		return fileRapportDiffCsv;
	} // Fin de getFileRapportDiffCsv().___________________________________



	/**
	 * method getLongueurChaine() :<br/>
	 * Getter de la longueur de la chaîne de caractères 
	 * transmise à la méthode listerChaineCarParCar(...).<br/>
	 * <br/>
	 *
	 * @return longueurChaine : int.<br/>
	 */
	public static int getLongueurChaine() {
		return longueurChaine;
	} // Fin de getLongueurChaine()._______________________________________



	/**
	 * method getLongueurChaine1() :<br/>
	 * Getter de la longueur de la première chaîne passée 
	 * à la méthode differencier(String pString1, String pString2, ...).<br/>
	 * Fourni par la méthode differencier(...).<br/>
	 * <br/>
	 *
	 * @return longueurChaine1 : int.<br/>
	 */
	public static int getLongueurChaine1() {
		return longueurChaine1;
	} // Fin de getLongueurChaine1().______________________________________



	/**
	 * method getLongueurChaine2() :<br/>
	 * Getter de la longueur de la deuxième chaîne passée à 
	 * la méthode differencier(String pString1, String pString2, ...).<br/>
	 * Fourni par la méthode differencier(...).<br/>
	 * <br/>
	 *
	 * @return longueurChaine2 : int.<br/>
	 */
	public static int getLongueurChaine2() {
		return longueurChaine2;
	} // Fin de getLongueurChaine2().______________________________________



	/**
	 * method getRapportCreationfichierDiff() :<br/>
	 * Getter du rapport de création de fileRapportDiff.<br/>
	 * (le fichier a bien été créé...).<br/>
	 * <br/>
	 *
	 * @return rapportCreationfichierDiff : String.<br/>
	 */
	public static String getRapportCreationfichierDiff() {
		return rapportCreationfichierDiff;
	} // Fin de getRapportCreationfichierDiff().___________________________



	/**
	 * method getRapportCreationfichierDiffCsv() :<br/>
	 * Getter du rapport de création de fileRapportDiffCsv.<br/>
	 * (le fichier a bien été créé...).<br/>
	 * <br/>
	 *
	 * @return rapportCreationfichierDiffCsv : String.<br/>
	 */
	public static String getRapportCreationfichierDiffCsv() {
		return rapportCreationfichierDiffCsv;
	} // Fin de getRapportCreationfichierDiffCsv().________________________
	
		
	
} // FIN DE LA CLASSE DifferentiateurString.---------------------------------
