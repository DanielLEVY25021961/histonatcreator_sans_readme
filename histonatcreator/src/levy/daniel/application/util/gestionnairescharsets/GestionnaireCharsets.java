package levy.daniel.application.util.gestionnairescharsets;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class GestionnaireCharsets :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * CharsetEncoder, CharsetDecoder,<br/>
 * Transformer caractère en byte, conversion char byte,<br/>
 * ByteBuffer, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 20 févr. 2016
 *
 */
public final class GestionnaireCharsets {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * CLASSE_GESTIONNAIRE_CHARSETS : String :<br/>
	 * "Classe GestionnaireCharsets".<br/>
	 */
	public static final String CLASSE_GESTIONNAIRE_CHARSETS 
		= "Classe GestionnaireCharsets";

	
	/**
	 * METHODE_SAVOIRSICHARSETPEUTENCODERCHAR : String :<br/>
	 * "Méthode savoirSiCharsetPeutEncoderChar(Charset pCharset, char pChar)".<br/>
	 */
	public static final String METHODE_SAVOIRSICHARSETPEUTENCODERCHAR 
		= "Méthode savoirSiCharsetPeutEncoderChar(Charset pCharset, char pChar)";


	/**
	 * METHODE_SAVOIRSICHARSETPEUTDECODERCHAR : String :<br/>
	 * "Méthode savoirSiCharsetPeutDecoderChar(Charset pCharset, char pChar)".<br/>
	 */
	public static final String METHODE_SAVOIRSICHARSETPEUTDECODERCHAR 
		= "Méthode savoirSiCharsetPeutDecoderChar(Charset pCharset, char pChar)";
	
	
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
	 * CHARSET_ISO_8859_2 : Charset :<br/>
	 * Charset.forName("ISO-8859-2").<br/>
	 * <br/>
	 */
	public static final Charset CHARSET_ISO_8859_2 
		= Charset.forName("ISO-8859-2");
	
	
	/**
	 * CHARSET_ISO_8859_9 : Charset :<br/>
	 * Charset.forName("ISO-8859-9").<br/>
	 * Latin Alphabet No. 5<br/>
	 */
	public static final Charset CHARSET_ISO_8859_9 
		= Charset.forName("ISO-8859-9");

	
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
	 * CHARSET_IBM850 : Charset :<br/>
	 * Charset IBM-850.<br/>
	 * Cp850, MS-DOS Latin-1.<br/>
	 */
	public static final Charset CHARSET_IBM850
		= Charset.forName("IBM-850");
	
	
	/**
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("fr", "FR").<br/>
	 * "fr" correspond au langage et "FR" au pays.<br/>
	 */
	public static final Locale LOCALE_FR_FR = new Locale("fr", "FR");


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
	 * rapportEncodagePossibleTxt : String :<br/>
	 * rapport textuel qui précise si l'encodage 
	 * d'un caractère est possible avec pCharset.<br/>
	 */
	private static String rapportEncodagePossibleTxt;
	
	
	/**
	 * rapportEncodagePossibleCsv : String :<br/>
	 * rapport csv qui précise si l'encodage 
	 * d'un caractère est possible avec pCharset.<br/>
	 */
	private static String rapportEncodagePossibleCsv;

	
	/**
	 * rapportDecodagePossibleTxt : String :<br/>
	 * rapport textuel qui précise si le décodage 
	 * d'un caractère est possible avec pCharset.<br/>
	 */
	private static String rapportDecodagePossibleTxt;

	
	/**
	 * rapportDecodagePossibleCsv : String :<br/>
	 * rapport csv qui précise si le décodage 
	 * d'un caractère est possible avec pCharset.<br/>
	 */
	private static String rapportDecodagePossibleCsv;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(GestionnaireCharsets.class);
	

	// *************************METHODES************************************/
	
	
	/**
	 * method CONSTRUCTEUR GestionnaireCharsets() :
	 * Constructeur private pour empêcher l'instanciation.
	 */
	private GestionnaireCharsets() {
		super();
	} // Fin de CONSTRUCTEUR GestionnaireCharsets()._______________________
	

	
	/**
	 * method savoirSiCharsetPeutEncoderChar(
	 * Charset pCharset
	 * , char pChar) :<br/>
	 * retourne un boolean stipulant si pCharset peut encoder pChar.<br/>
	 * Constitue des rapports textuels (rapportEncodagePossibleTxt)  
	 * et Csv (rapportEncodagePossibleCsv).<br/>
	 * Utilise la méthode charsetEncoder.canEncode(pChar).<br/>
	 * <br/>
	 * - retourne false si pCharset est null 
	 * (et rapportEncodagePossibleTxt et LOG INFO).<br/>
	 * - retourne false si pCharset ne peut encoder 
	 * (et rapportEncodagePossibleTxt et LOG INFO).<br/>
	 * - retourne false si un encodage est déjà en cours 
	 * (et rapportEncodagePossibleTxt et LOG INFO).<br/>
	 * <br/>
	 * 
	 *
	 * @param pCharset : Charset.<br/>
	 * @param pChar : char.<br/>
	 * 
	 * @return : boolean : true si pCharset peut encoder pChar.<br/>
	 */
	public static boolean savoirSiCharsetPeutEncoderChar(
			final Charset pCharset
				, final char pChar) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireCharsets.class) {
			
			/* Remise à null des rapports. */
			rapportEncodagePossibleTxt = null;
			rapportEncodagePossibleCsv = null;
			
			/* retourne false si pCharset est null 
			 * (et rapportEncodagePossibleTxt et LOG INFO). */
			if (pCharset == null) {
				
				final String message = "pCharset passé en paramètre est null.";
				
				/* LOG de niveau INFO. */
				loggerInfo(CLASSE_GESTIONNAIRE_CHARSETS
						, METHODE_SAVOIRSICHARSETPEUTENCODERCHAR
						, message);
				
				/* Rapport. */
				rapportEncodagePossibleTxt = message;
				
				/* retourne false. */
				return false;
			}
			
			try {
				
				/* Obtention d'un CharsetEncoder auprès du Charset. */
				final CharsetEncoder charsetEncoder = pCharset.newEncoder();
				
				/* Vérifie que le Charset peut encoder ce caractère. */
				final boolean resultat = charsetEncoder.canEncode(pChar);
				
				/* Constitue des rapports textuels 
				 * (rapportEncodagePossibleTxt)  
				 * et Csv (rapportEncodagePossibleCsv). */
				if (resultat) {
					
					/* Rapport textuel. */
					final String messageTxt 
					= pCharset.displayName(LOCALE_FR_FR) 
					+ " peut encoder le caractère " 
							+ pChar;
					
					rapportEncodagePossibleTxt = messageTxt;
					
					/* Rapport csv. */
					final String messageCsv 
					= pCharset.displayName(LOCALE_FR_FR) 
					+ SEP_POINTVIRGULE
					+ "PEUT encoder" 
					+ SEP_POINTVIRGULE 
					+ pChar 
					+ SEP_POINTVIRGULE;
					
					rapportEncodagePossibleCsv = messageCsv;
					
				}
				else {
					
					/* Rapport textuel. */
					final String messageTxt 
					= pCharset.displayName(LOCALE_FR_FR) 
					+ " ne peut PAS encoder le caractère " 
							+ pChar;
					
					rapportEncodagePossibleTxt = messageTxt;
					
					/* Rapport csv. */
					final String messageCsv 
					= pCharset.displayName(LOCALE_FR_FR) 
					+ SEP_POINTVIRGULE
					+ "NE PEUT PAS encoder" 
					+ SEP_POINTVIRGULE 
					+ pChar 
					+ SEP_POINTVIRGULE;
					
					rapportEncodagePossibleCsv = messageCsv;
					
				}
				
				/* retourne un boolean stipulant 
				 * si pCharset peut encoder pChar. */
				return resultat;
				
				/* retourne false si pCharset ne peut encoder 
				 * (et rapportEncodagePossibleTxt et LOG INFO). */
			} catch (UnsupportedOperationException uoe) {
				
				final String message 
				= pCharset.displayName(LOCALE_FR_FR) 
				+ " passé en paramètre n'a pas de CharsetEncoder. "
				+ "Il ne peut donc pas encoder. Exception : " 
				+ uoe.getMessage();
				
				/* LOG de niveau INFO. */
				loggerInfo(CLASSE_GESTIONNAIRE_CHARSETS
						, METHODE_SAVOIRSICHARSETPEUTENCODERCHAR
						, message);
				
				/* Rapport. */
				rapportEncodagePossibleTxt = message;
				
				/* retourne false. */
				return false;
				
				/* retourne false si un encodage est déjà en cours 
				 * (et rapportEncodagePossibleTxt et LOG INFO). */
			} catch (IllegalStateException ise) {
				
				final String message 
				= "PROBLEME avec le Charset passé en paramètre : " 
				+ pCharset.displayName(LOCALE_FR_FR) 
				+ " - Exception : " 
				+ ise.getMessage();
				
				/* LOG de niveau INFO. */
				loggerInfo(CLASSE_GESTIONNAIRE_CHARSETS
						, METHODE_SAVOIRSICHARSETPEUTENCODERCHAR
						, message);
				
				/* Rapport. */
				rapportEncodagePossibleTxt = message;
				
				/* retourne false. */
				return false;
				
			}
			
		} // Fin du bloc static synchronized.__________________________
						
	} // Fin de savoirSiCharsetPeutEncoderChar(
	 // Charset pCharset
	 // , char pChar)._____________________________________________________
	

	
	/**
	 * method savoirSiCharsetPeutDecoderChar() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pCharset
	 * @param pChar
	 * @return : boolean :  .<br/>
	 */
	public static boolean savoirSiCharsetPeutDecoderChar(
			final Charset pCharset
				, final char pChar) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireCharsets.class) {

			/* Remise à null des rapports. */
			rapportDecodagePossibleTxt = null;
			rapportDecodagePossibleCsv = null;

			/*
			 * retourne false si pCharset est null (et
			 * rapportDecodagePossibleTxt et LOG INFO).
			 */
			if (pCharset == null) {

				final String message = "pCharset passé en paramètre est null.";

				/* LOG de niveau INFO. */
				loggerInfo(CLASSE_GESTIONNAIRE_CHARSETS,
						METHODE_SAVOIRSICHARSETPEUTDECODERCHAR
							, message);

				/* Rapport. */
				rapportDecodagePossibleTxt = message;

				/* retourne false. */
				return false;
			}

			boolean resultat = false;
			
			try {
				
				/* Obtention d'un CharsetDecoder auprès du Charset. */
				final CharsetDecoder charsetDecoder = pCharset.newDecoder();
				
				/* Met pChar dans un char[]. */
				final char[] caractereTableau = {pChar};
				
				/* Met le char[] dans un CharBuffer. */
				final CharBuffer caractereBuffer 
					= CharBuffer.wrap(caractereTableau);
				
				/* Création d'un ByteBuffer en encodant 
				 * le CharBuffer avec pCharset . */
				/* Permet de récupérer les octets associées au caractère 
				 * (1 seul caractère peut être codé sur plusieurs octets). */
				final ByteBuffer byteBuffer 
					= pCharset.newEncoder().encode(caractereBuffer);
				
				/* Vérifie que le Charset peut decoder ce caractère. */
				final CharBuffer charbuffer = charsetDecoder.decode(byteBuffer);
				
				System.out.println();
				System.out.println(charbuffer.array()[0]);
				
				/* Rapport textuel. */
				final String messageTxt 
				= pCharset.displayName(LOCALE_FR_FR) 
				+ " peut décoder le caractère " 
						+ pChar;
				
				rapportDecodagePossibleTxt = messageTxt;
				
				/* Rapport csv. */
				final String messageCsv 
				= pCharset.displayName(LOCALE_FR_FR) 
				+ SEP_POINTVIRGULE
				+ "PEUT decoder" 
				+ SEP_POINTVIRGULE 
				+ pChar 
				+ SEP_POINTVIRGULE;
				
				rapportDecodagePossibleCsv = messageCsv;
				
				resultat = true;

			} catch (CharacterCodingException cce) {
				
				/* Rapport textuel. */
				final String messageTxt 
				= pCharset.displayName(LOCALE_FR_FR) 
				+ " ne peut PAS decoder le caractère " 
						+ pChar;
				
				rapportDecodagePossibleTxt = messageTxt;
				
				/* Rapport csv. */
				final String messageCsv 
				= pCharset.displayName(LOCALE_FR_FR) 
				+ SEP_POINTVIRGULE
				+ "NE PEUT PAS decoder" 
				+ SEP_POINTVIRGULE 
				+ pChar 
				+ SEP_POINTVIRGULE + cce.getMessage();
				
				rapportDecodagePossibleCsv = messageCsv;
				
				resultat = false;
			}

			return resultat;

		} // Fin du bloc static synchronized.__________________________
						
	}
	
	
	/**
	 * method getEnteteCsvEncodage() :<br/>
	 * Retourne l'en-tête du rapport csv d'encodage.<br/>
	 * <br/>
	 * "Charset;possibilité d'encodage;Caractère;".<br/>
	 * <br/>
	 *
	 * @return : String : "Charset;possibilité d'encodage;Caractère;".<br/>
	 */
	public static String getEnteteCsvEncodage() {
		return "Charset;possibilité d'encodage;Caractère;";
	} // Fin de getEnteteCsvEncodage().____________________________________
	

	
	/**
	 * method getEnteteCsvDecodage() :<br/>
	 * Retourne l'en-tête du rapport csv de décodage.<br/>
	 * <br/>
	 * "Charset;possibilité de décodage;Caractère;".<br/>
	 * <br/>
	 *
	 * @return : String : "Charset;possibilité de décodage;Caractère;".<br/>
	 */
	public static String getEnteteCsvDecodage() {
		return "Charset;possibilité de décodage;Caractère;";
	} // Fin de getEnteteCsvDecodage().____________________________________

	
	
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
	 * method getRapportEncodagePossibleTxt() :<br/>
	 * Getter du rapport textuel qui précise si l'encodage 
	 * d'un caractère est possible avec pCharset.<br/>
	 * <br/>
	 *
	 * @return rapportEncodagePossibleTxt : String.<br/>
	 */
	public static String getRapportEncodagePossibleTxt() {
		return rapportEncodagePossibleTxt;
	} // Fin de getRapportEncodagePossibleTxt().___________________________



	/**
	 * method getRapportEncodagePossibleCsv() :<br/>
	 * Getter du rapport csv qui précise si l'encodage 
	 * d'un caractère est possible avec pCharset.<br/>
	 * <br/>
	 *
	 * @return rapportEncodagePossibleCsv : String.<br/>
	 */
	public static String getRapportEncodagePossibleCsv() {
		return rapportEncodagePossibleCsv;
	} // Fin de getRapportEncodagePossibleCsv().___________________________



	/**
	 * method getRapportDecodagePossibleTxt() :<br/>
	 * Getter du rapport textuel qui précise 
	 * si le décodage d'un caractère est possible avec pCharset.<br/>
	 * <br/>
	 *
	 * @return rapportDecodagePossibleTxt : String.<br/>
	 */
	public static String getRapportDecodagePossibleTxt() {
		return rapportDecodagePossibleTxt;
	} // Fin de getRapportDecodagePossibleTxt().___________________________



	/**
	 * method getRapportDecodagePossibleCsv() :<br/>
	 * Getter du rapport csv qui précise si le décodage 
	 * d'un caractère est possible avec pCharset.<br/>
	 * <br/>
	 *
	 * @return rapportDecodagePossibleCsv : String.<br/>
	 */
	public static String getRapportDecodagePossibleCsv() {
		return rapportDecodagePossibleCsv;
	} // Fin de getRapportDecodagePossibleCsv().___________________________

	
	
} // FIN DE LA CLASSE GestionnaireCharsets.----------------------------------
