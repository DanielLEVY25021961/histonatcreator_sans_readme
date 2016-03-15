package levy.daniel.application;

import java.io.File;
import java.nio.charset.Charset;
import java.util.SortedMap;


/**
 * class ILecteurDecodeurFile :<br/>
 * Interface centralisant toutes les méthodes des objets 
 * capables de lire un fidhier selon un certain encodage (Charset).<br/>
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
 * @since 2 mars 2016
 *
 */
public interface ILecteurDecodeurFile {
	
	
	/**
	 * METHODE_LIREFICHIER : String :<br/>
	 * "Méthode lireFichier(File pFile, Charset pCharset)".<br/>
	 */
	String METHODE_LIREFICHIER 
		= "Méthode lireFichier(File pFile, Charset pCharset)";

	
	/**
	 * METHODE_LIREFICHIERLIGNE_PAR_LIGNE : String :<br/>
	 * "Méthode lireFichierLigneParLigne(File pFile, Charset pCharset".<br/>
	 */
	String METHODE_LIREFICHIERLIGNE_PAR_LIGNE 
		= "Méthode lireFichierLigneParLigne(File pFile, Charset pCharset";
	
	
	/**
	 * METHODE_LIRELIGNEFICHIER : String :<br/>
	 * "Méthode lireLigneFichier(int pNumeroLigne, File pFile, Charset pCharset)".<br/>
	 */
	String METHODE_LIRELIGNEFICHIER 
	= "Méthode lireLigneFichier(int pNumeroLigne, File pFile, Charset pCharset)";
	
	
	/**
	 * MESSAGE_FICHIER_NULL : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est null.<br/>
	 * "Le fichier passé en paramètre est null".<br/>
	 */
	String MESSAGE_FICHIER_NULL 
		= "Le fichier passé en paramètre est null";

	
	/**
	 * MESSAGE_FICHIER_INEXISTANT : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est inexistant.<br/>
	 * "Le fichier passé en paramètre est inexistant : "
	 */
	String MESSAGE_FICHIER_INEXISTANT 
		= "Le fichier passé en paramètre est inexistant : ";

	
	/**
	 * MESSAGE_FICHIER_REPERTOIRE : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est un répertoire.<br/>
	 * "Le fichier passé en paramètre est un répertoire : ".<br/>
	 */
	String MESSAGE_FICHIER_REPERTOIRE 
		= "Le fichier passé en paramètre est un répertoire : ";

	
	/**
	 * MESSAGE_FICHIER_VIDE : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est vide.<br/>
	 * "Le fichier passé en paramètre est vide : "
	 */
	String MESSAGE_FICHIER_VIDE 
		= "Le fichier passé en paramètre est vide : ";
	
	
	/**
	 * ACTION_LIGNE_A_TRANSCODER : String :<br/>
	 * "LIGNE A TRANSCODER".<br/>
	 */
	String ACTION_LIGNE_A_TRANSCODER 
		= "LIGNE A TRANSCODER";


	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	Charset CHARSET_UTF8 
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
	Charset CHARSET_US_ASCII 
		= Charset.forName("US-ASCII");

	
	/**
	 * CHARSET_ISO_8859_1 : Charset :<br/>
	 * Charset.forName("ISO-8859-1").<br/>
	 * Latin1.<br/>
	 * 191 caractères imprimables.<br/> 
	 * Permet d’écrire la plupart des langues d’Europe de l’Ouest.<br/> 
	 * Presque tous les caractères du français y sont (manquent le œ et €).<br/>
	 */
	Charset CHARSET_ISO_8859_1 
		= Charset.forName("ISO-8859-1");

	
	/**
	 * CHARSET_LATIN1 : Charset :<br/>
	 * Charset.forName("ISO-8859-1").<br/>
	 * Latin1.<br/>
	 * 191 caractères imprimables.<br/> 
	 * Permet d’écrire la plupart des langues d’Europe de l’Ouest.<br/> 
	 * Presque tous les caractères du français y sont (manquent le œ et €).<br/>
	 */
	Charset CHARSET_LATIN1 
		= Charset.forName("ISO-8859-1");

	
	/**
	 * CHARSET_ISO_8859_2 : Charset :<br/>
	 * Charset.forName("ISO-8859-2").<br/>
	 * <br/>
	 */
	Charset CHARSET_ISO_8859_2 
		= Charset.forName("ISO-8859-2");
	
	
	/**
	 * CHARSET_ISO_8859_9 : Charset :<br/>
	 * Charset.forName("ISO-8859-9").<br/>
	 * Latin Alphabet No. 5<br/>
	 */
	Charset CHARSET_ISO_8859_9 
		= Charset.forName("ISO-8859-9");

	
	/**
	 * CHARSET_ISO_8859_15 : Charset :<br/>
	 * Charset.forName("ISO-8859-15").<br/>
	 * Latin9, Latin Alphabet No. 9.<br/>
	 * modifie légèrement ISO-8859-1.<br/> 
	 * Ajout du caractère œ et du symbole monétaire € (Euro) entre autres.<br/>
	 */
	Charset CHARSET_ISO_8859_15 
		= Charset.forName("ISO-8859-15");
	
	
	/**
	 * CHARSET_LATIN9 : Charset :<br/>
	 * Charset.forName("ISO-8859-15").<br/>
	 * Latin9, Latin Alphabet No. 9.<br/>
	 * modifie légèrement ISO-8859-1.<br/> 
	 * Ajout du caractère œ et du symbole monétaire € (Euro) entre autres.<br/>
	 */
	Charset CHARSET_LATIN9 
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
	Charset CHARSET_WINDOWS_1252 
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
	Charset CHARSET_ANSI
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
	Charset CHARSET_CP1252
		= Charset.forName("windows-1252");

	
	/**
	 * CHARSET_IBM850 : Charset :<br/>
	 * Charset IBM-850.<br/>
	 * Cp850, MS-DOS Latin-1.<br/>
	 */
	Charset CHARSET_IBM850
		= Charset.forName("IBM-850");
	


	
	/**
	 * method lireFichierEnUTF8(
	 * File pFile) :<br/>
	 * Lit un fichier pFile en UTF-8 et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage UTF-8.<br/>
	 * Lit chaque caractère quoi qu'il arrive 
	 * (même si le fichier n'est pas un fichier texte).<br/>
	 * Ne modifie pas les sauts de ligne.<br/>
	 * <br/>
	 * - passe pFile à this.fichier et 
	 * rafraîchit automatiquement this.nomFichier.<br/>
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
	String lireFichierEnUTF8(
			final File pFile);


	
	/**
	 * method lireFichierEnAscii(
	 * File pFile) :<br/>
	 * Lit un fichier pFile en US-ASCII et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage US-ASCII.<br/>
	 * Lit chaque caractère quoi qu'il arrive 
	 * (même si le fichier n'est pas un fichier texte).<br/>
	 * Ne modifie pas les sauts de ligne.<br/>
	 * <br/>
	 * - passe pFile à this.fichier et 
	 * rafraîchit automatiquement this.nomFichier.<br/>
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
	String lireFichierEnAscii(
			final File pFile);
	

	
	/**
	 * method lireFichierEnLatin1(
	 * File pFile) :<br/>
	 * Lit un fichier pFile en ISO-8859-1 (LATIN1) et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage  ISO-8859-1.<br/>
	 * Lit chaque caractère quoi qu'il arrive 
	 * (même si le fichier n'est pas un fichier texte).<br/>
	 * Ne modifie pas les sauts de ligne.<br/>
	 * <br/>
	 * - passe pFile à this.fichier et 
	 * rafraîchit automatiquement this.nomFichier.<br/>
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
	String lireFichierEnLatin1(
			final File pFile);
	

	
	/**
	 * method lireFichierEnLatin2(
	 * File pFile) :<br/>
	 * Lit un fichier pFile en ISO-8859-2 (LATIN2) et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage  ISO-8859-2.<br/>
	 * Lit chaque caractère quoi qu'il arrive 
	 * (même si le fichier n'est pas un fichier texte).<br/>
	 * Ne modifie pas les sauts de ligne.<br/>
	 * <br/>
	 * - passe pFile à this.fichier et 
	 * rafraîchit automatiquement this.nomFichier.<br/>
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
	String lireFichierEnLatin2(
			final File pFile);
	
	
	
	/**
	 * method lireFichierEnLatin9(
	 * File pFile) :<br/>
	 * Lit un fichier pFile en ISO-8859-15 (LATIN9) et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage  ISO-8859-15.<br/>
	 * Lit chaque caractère quoi qu'il arrive 
	 * (même si le fichier n'est pas un fichier texte).<br/>
	 * Ne modifie pas les sauts de ligne.<br/>
	 * <br/>
	 * - passe pFile à this.fichier et 
	 * rafraîchit automatiquement this.nomFichier.<br/>
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
	String lireFichierEnLatin9(
			final File pFile);


	
	/**
	 * method lireFichierEnAnsi(
	 * File pFile) :<br/>
	 * Lit un fichier pFile en Windows-1252 (ANSI) et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage  Windows-1252.<br/>
	 * Lit chaque caractère quoi qu'il arrive 
	 * (même si le fichier n'est pas un fichier texte).<br/>
	 * Ne modifie pas les sauts de ligne.<br/>
	 * <br/>
	 * - passe pFile à this.fichier et 
	 * rafraîchit automatiquement this.nomFichier.<br/>
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
	String lireFichierEnAnsi(
			final File pFile);

	
	
	/**
	 * method lireFichierEnIbm850(
	 * File pFile) :<br/>
	 * Lit un fichier pFile en IBM-850 (OEM) et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage  IBM-850.<br/>
	 * Lit chaque caractère quoi qu'il arrive 
	 * (même si le fichier n'est pas un fichier texte).<br/>
	 * Ne modifie pas les sauts de ligne.<br/>
	 * <br/>
	 * - passe pFile à this.fichier et 
	 * rafraîchit automatiquement this.nomFichier.<br/>
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
	String lireFichierEnIbm850(
			final File pFile);
	
	
	
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
	 * - Choisit automatiquement le CHARSET_UTF8 si pCharset == null.<br/>
	 * - passe pFile à this.fichier et 
	 * rafraîchit automatiquement this.nomFichier.<br/>
	 * <br/>
	 * - retourne MESSAGE_FICHIER_NULL, LOG de niveau INFO et rapport 
	 * si pFile est null.<br/>
	 * - retourne MESSAGE_FICHIER_INEXISTANT, LOG de niveau INFO et rapport 
	 * si pFile est inexistant.<br/>
	 * - retourne MESSAGE_FICHIER_REPERTOIRE, LOG de niveau INFO et rapport 
	 * si pFile est un répertoire.<br/>
	 * - retourne MESSAGE_FICHIER_VIDE, LOG de niveau INFO et rapport 
	 * si pFile est vide.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier à lire.<br/>
	 * @param pCharset : Charset : Charset utilisé par l'InputStreamReader 
	 * pour lire dans le fichier.<br/>
	 * 
	 * @return : String : Chaine de caractères avec le contenu du fichier.<br/>
	 */
	String lireFichier(
			final File pFile
				, final Charset pCharset);
	

	
	/**
	 * method lireFichierLigneParLigne(
	 * File pFile
	 * , Charset pCharset) :<br/>
	 * <ul>
	 * <li>Lit ligne par ligne un fichier pFile et 
	 * retourne son contenu dans une chaîne de caractères.</li><br/>
	 * <li>Lit le fichier en utilisant la méthode readLine() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage pCharset.</li><br/>
	 * <li>remplit this.fichierEnMap.</li><br/>
	 * <li>Lit chaque caractère quoi qu'il arrive 
	 * (même si le fichier n'est pas un fichier texte).</li><br/>
	 * <li>Ajoute le numéro de ligne devant chaque ligne.</li><br/>
	 * <li>Remplace les sauts de ligne par NEWLINE.</li><br/>
	 * </ul>
	 * <br/>
	 * - Choisit automatiquement le CHARSET_UTF8 si pCharset == null.<br/>
	 * - rafraîchit this.fichierEnMap.<br/>
	 * - passe pFile à this.fichier et 
	 * rafraîchit automatiquement this.nomFichier.<br/>
	 * <br/>
	 * - retourne MESSAGE_FICHIER_NULL, LOG de niveau INFO et rapport 
	 * si pFile est null.<br/>
	 * - retourne MESSAGE_FICHIER_INEXISTANT, LOG de niveau INFO et rapport 
	 * si pFile est inexistant.<br/>
	 * - retourne MESSAGE_FICHIER_REPERTOIRE, LOG de niveau INFO et rapport 
	 * si pFile est un répertoire.<br/>
	 * - retourne MESSAGE_FICHIER_VIDE, LOG de niveau INFO et rapport 
	 * si pFile est vide.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier à lire.<br/>
	 * @param pCharset : Charset : Charset utilisé par l'InputStreamReader 
	 * pour lire dans le fichier.<br/>
	 * 
	 * @return : String : Chaine de caractères avec le contenu du fichier.<br/>
	 */
	String lireFichierLigneParLigne(
			final File pFile
				, final Charset pCharset);
	
	
	
	/**
	 * method lireLigneFichier(
	 * int pNumeroLigne
	 * , File pFile
	 * , Charset pCharset) :<br/>
	 * Lit avec l'encodage pCharset la pNumeroLigne-ème 
	 * ligne d'un fichier pFile.<br/>
	 * - Retourne la ligne lue ou null si la ligne n'existe pas.<br/>
	 * <br/>
	 * <ul>
	 * <li>retourne MESSAGE_FICHIER_NULL, LOG de niveau INFO et rapport 
	 * si pFile == null.</li><br/>
	 * <li>retourne MESSAGE_FICHIER_INEXISTANT, LOG de niveau INFO et rapport 
	 * si pFile est inexistant.</li><br/>
	 * <li>retourne MESSAGE_FICHIER_REPERTOIRE, LOG de niveau INFO et rapport 
	 * si pFile est un répertoire.</li><br/>
	 * <li>retourne MESSAGE_FICHIER_VIDE, LOG de niveau INFO et rapport 
	 * si pFile est vide.</li><br/>
	 * </ul>
	 * <br/>
	 * - Choisit automatiquement le CHARSET_UTF8 si pCharset == null.<br/>
	 * - passe pFile à this.fichier et 
	 * rafraîchit automatiquement this.nomFichier.<br/>
	 * <br/>
	 * 
	 *
	 * @param pNumeroLigne : int : numéro de la ligne que l'on veut lire.<br/>
	 * @param pFile : File : le fichier dans lequel on veut lire la ligne.<br/>
	 * @param pCharset : Charset : Charset avec lequel on lit la ligne.<br/>
	 * 
	 * @return : String : la pNumeroLigne-ème ligne.<br/>
	 */
	String lireLigneFichier(
			final int pNumeroLigne
				, final File pFile
					, final Charset pCharset);
	

	
	/**
	 * method afficherFichierEnMap() :<br/>
	 * Affiche this.fichierEnMap.<br/>
	 * - Rajoute les numéros de ligne.<br/>
	 * <br/>
	 *
	 * @return : String.<br/>
	 */
	String afficherFichierEnMap();

	
	
	/**
	 * method afficherLigneDeFichierEnMap(
	 * int pNumeroLigne) :<br/>
	 * affiche la pNumeroLigne-ième ligne de this.fichierEnMap.<br/>
	 * - Rajoute les numéros de ligne.<br/>
	 * <br/>
	 * - retourne null si la ligne n'existe pas.<br/>
	 * <br/>
	 *
	 * @param pNumeroLigne
	 * 
	 * @return : String : la pNumeroLigne-ième ligne de this.fichierEnMap.<br/>
	 */
	String afficherLigneDeFichierEnMap(
			final int pNumeroLigne);

	
	
	/**
	 * method afficherMapIntegerString(
	 * SortedMap&lt;Integer, String&gt; pMap :<br/>
	 * Affiche l'ensemble des lignes 
	 * d'une SortedMap&lt;Integer, String&gt;.<br/>
	 * - Rajoute les numéros de ligne.<br/>
	 * <br/>
	 * - retourne null si pMap == null.<br/>
	 * <br/>
	 *
	 * @param pMap : SortedMap&lt;Integer, String&gt;.<br/>
	 * 
	 * @return : String : Affichage de la Map.<br/>
	 */
	String afficherMapIntegerString(
			final SortedMap<Integer, String> pMap);
	

	
	/**
	 * method afficherLignedeMapIntegerString(
	 * SortedMap&lt;Integer, String&gt; pMap
	 * , int pNumeroLigne) :<br/>
	 * Affiche la pNumeroLigne-ième ligne 
	 * dans une SortedMap&lt;Integer, String&gt;.<br/>
	 * - Rajoute les numéros de ligne.<br/>
	 * <br/>
	 * - retourne null si pMap == null.<br/>
	 * - retourne null si la ligne n'existe pas.<br/>
	 * <br/>
	 *
	 * @param pMap : SortedMap&lt;Integer, String&gt;.<br/>
	 * @param pNumeroLigne : int : numéro (1-based) de la ligne à lire.<br/>
	 * 
	 * @return : String : la pNumeroLigne-ième ligne.<br/>
	 */
	String afficherLignedeMapIntegerString(
			final SortedMap<Integer, String> pMap
				, final int pNumeroLigne);
	

	
	/**
	 * method listerFichierEnMap() :<br/>
	 * Affiche this.fichierEnMap.<br/>
	 * - Ne Rajoute PAS les numéros de ligne.<br/>
	 * <br/>
	 *
	 * @return : String.<br/>
	 */
	String listerFichierEnMap();

	
	
	/**
	 * method listerLigneDeFichierEnMap(
	 * int pNumeroLigne) :<br/>
	 * affiche la pNumeroLigne-ième ligne de this.fichierEnMap.<br/>
	 * - Ne Rajoute PAS les numéros de ligne.<br/>
	 * <br/>
	 * - retourne null si la ligne n'existe pas.<br/>
	 * <br/>
	 *
	 * @param pNumeroLigne
	 * 
	 * @return : String : la pNumeroLigne-ième ligne de this.fichierEnMap.<br/>
	 */
	String listerLigneDeFichierEnMap(
			final int pNumeroLigne);

	
	
	/**
	 * method listerMapIntegerString(
	 * SortedMap&lt;Integer, String&gt; pMap :<br/>
	 * Affiche l'ensemble des lignes 
	 * d'une SortedMap&lt;Integer, String&gt;.<br/>
	 * - Ne Rajoute PAS les numéros de ligne.<br/>
	 * <br/>
	 * - retourne null si pMap == null.<br/>
	 * <br/>
	 *
	 * @param pMap : SortedMap&lt;Integer, String&gt;.<br/>
	 * 
	 * @return : String : Affichage de la Map.<br/>
	 */
	String listerMapIntegerString(
			final SortedMap<Integer, String> pMap);
	

	
	/**
	 * method listerLignedeMapIntegerString(
	 * SortedMap&lt;Integer, String&gt; pMap
	 * , int pNumeroLigne) :<br/>
	 * Affiche la pNumeroLigne-ième ligne 
	 * dans une SortedMap&lt;Integer, String&gt;.<br/>
	 * - Ne Rajoute PAS les numéros de ligne.<br/>
	 * <br/>
	 * - retourne null si pMap == null.<br/>
	 * - retourne null si la ligne n'existe pas.<br/>
	 * <br/>
	 *
	 * @param pMap : SortedMap&lt;Integer, String&gt;.<br/>
	 * @param pNumeroLigne : int : numéro (1-based) de la ligne à lire.<br/>
	 * 
	 * @return : String : la pNumeroLigne-ième ligne.<br/>
	 */
	String listerLignedeMapIntegerString(
			final SortedMap<Integer, String> pMap
				, final int pNumeroLigne);
	

	/**
	 * method transcoder(
	 * String pString
	 * , Charset pCharsetEncodage
	 * , Charset pCharsetDecodage
	 * , boolean pRapporte
	 * , Integer pNumeroLigne) :<br/>
	 * Transcode la ligne pString initialement encodée 
	 * en pCharsetEncodage en pCharsetDecodage.<br/>
	 * - Crée un rapport de transcodage si pRapporte vaut true.<br/>
	 * <br/>
	 * - retourne null si pString == null.<br/>
	 * - passe automatiquement le charsetEncodage à CHARSET_ANSI 
	 * si pCharsetEncodage == null. pCharsetEncodage sinon.<br/>
	 * - passe automatiquement le charsetDecodage à CHARSET_IBM850 
	 * si pCharsetDecodage == null. pCharsetDecodage sinon.<br/>
	 * <br/>
	 *
	 * @param pString : String : ligne à encoder en pCharsetDecodage
	 * @param pCharsetEncodage : Charset : charset ayant servi 
	 * initialement à lire pString.<br/>
	 * @param pCharsetDecodage : Charset : charset dans lequel 
	 * on veut transcoder pString.<br/>
	 * @param pRapporte : boolean : true si on veut que 
	 * la méthode rapporte.<br/>
	 * @param pNumeroLigne  : Integer : NUméro de la ligne dans un fichier.<br/>
	 * 
	 * @return : String : String transcodée en pCharsetDecodage.<br/>
	 */
	String transcoder(
			final String pString
				, final Charset pCharsetEncodage
					, final Charset pCharsetDecodage
						, final boolean pRapporte
							, final Integer pNumeroLigne);
	
	
	
	/**
	 * method determinerSiEncodagePossible(
	 * String pString
	 * , Charset pCharset
	 * , int pNumeroLigne) :<br/>
	 * Détermine si la ligne pString a pu être encodée 
	 * avec le Charset pCharset.<br/>
	 * La ligne ne doit contenir aucun caractère indésirable 
	 * si c'est la cas.<br/>
	 * - retourne true si la ligne pString a pu être encodée 
	 * avec le Charset pCharset.<br/>
	 * <br/>
	 * - retourne false si pString == null.<br/>
	 * - retourne false si pCharset est null.<br/>
	 * <br/>
	 *
	 * @param pString : String.<br/>
	 * @param pCharset : Charset.<br/>
	 * @param pNumeroLigne : int : numéro de la ligne.<br/>
	 * 
	 * @return : boolean : true si la ligne pString a pu être encodée 
	 * avec le Charset pCharset.<br/>
	 */
	boolean determinerSiEncodagePossible(
			final String pString
				, final Charset pCharset
					, final int pNumeroLigne);
	
	
	
	/**
	 * method getFichierEnMap() :<br/>
	 * Getter de la SortedMap&lt;Integer,String&gt; 
	 * encapsulant un Fichier texte avec :<br/>
	 * <ul>
	 * <li>Integer : le numéro de la ligne.</li><br/>
	 * <li>String : la ligne.</li><br/>
	 * </ul>
	 * <br/>
	 *
	 * @return fichierEnMap : SortedMap<Integer,String>.<br/>
	 */
	SortedMap<Integer, String> getFichierEnMap();
	
	

} // FIN DE L'INTERFACE ILecteurDecodeurFile.--------------------------------
