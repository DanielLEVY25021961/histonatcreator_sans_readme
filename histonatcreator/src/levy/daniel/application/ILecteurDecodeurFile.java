package levy.daniel.application;

import java.io.File;
import java.nio.charset.Charset;


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
	 * SERVICE ANNEXE.<br/>
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
	 * SERVICE ANNEXE.<br/>
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
	 * SERVICE ANNEXE.<br/>
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
	 * SERVICE ANNEXE.<br/>
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
	 * SERVICE ANNEXE.<br/>
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
	 * SERVICE ANNEXE.<br/>
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
	 * SERVICE ANNEXE.<br/>
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
	String lireFichier(
			final File pFile
				, final Charset pCharset);
	


} // FIN DE L'INTERFACE ILecteurDecodeurFile.--------------------------------
