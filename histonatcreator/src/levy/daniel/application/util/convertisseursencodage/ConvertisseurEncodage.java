package levy.daniel.application.util.convertisseursencodage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

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
	 * SEP_MOINS : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEP_MOINS = " - ";


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
					
					/* Passe contientCarIndesirable à true si la chaîne lue contient un caractère indésirable stocké dans CARACTERES_INDESIRABLES_SET. */
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
	 * contient des caractères indésirables.<br/>
	 * (impossibles à écrire simplement au clavier).<br/>
	 * <br/>
	 *
	 * @return contientCarIndesirable : boolean.<br/>
	 */
	public static boolean isContientCarIndesirable() {
		return contientCarIndesirable;
	} // Fin de isContientCarIndesirable().________________________________
	
		
	
} // FIN DE LA CLASSE ConvertisseurEncodage.---------------------------------
