package levy.daniel.application.util.differentiateurs.differentiateursstrings;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Locale;

import levy.daniel.application.util.convertisseursencodage.ConvertisseurEncodage;
import levy.daniel.application.util.convertisseursencodage.ConvertisseurEncodageTest;

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
	 * rapportDiff : String :<br/>
	 * Rapport textuel contenant les différences 
	 * entre deux chaines de caractères.<br/>
	 * null si les deux chaines sont equals.<br/>
	 */
	private static String rapportDiff;
	
	/**
	 * rapportDiffCsv : String :<br/>
	 * Rapport au format csv contenant les différences 
	 * entre deux chaines de caractères.<br/>
	 * null si les deux chaines sont equals.<br/>
	 */
	private static String rapportDiffCsv;
	
	
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
		
		/* block static synchronized. */
		synchronized (DifferentiateurString.class) {
			
			/* mise à null des rapports. */
			rapportDiff = null;
			rapportDiffCsv = null;
			
			
			int longueurMax = 0;
			int position = 0;
			Character caractereChaine1 = null;
			Character caractereChaine2 = null;
			String diff = null;
			
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
				
				System.out.println(c1.toString() + " DIFF : " + diff + c2.toString());
				//("Position : " + position + "\t\tcaractère1 : " + caractereChaine1 + "\t\tcaractère2 : " + caractereChaine2 + "\t\tDIFFERENCE : " + diff + "\t\tcode Hexadecimal Unicode : " + getCodeUnicodeHexaDecimal(caractereChaine2) + "\t\tNumericValue : " + getNumericValue(caractereChaine2) + "\t\tCode Point Décimal : " + getCodePointDecimal(caractereChaine2) + "\t\tCode Point Hexa : " + getCodePointHexaDecimal(caractereChaine2) + "\t\tNom : " + getNameUnicodeChar(caractereChaine2));
//				System.out.printf(
//						LOCALE_FR_FR
//						, "Pos : %-7d car1 : %-4s  Unicode1 : %-6s    NumericValue1 : %-6d  Type1 : %-3d  intValue1 : %-6d  CodePoint1 : %-6d  CodePointHexa1 : %-8s  Nom1 : %-40s  DELTA : %-8s   car2 : %-4s  Unicode2 : %6s    NumericValue2 : %-6d    CodePoint2 : %-6d    CodePointHexa2 : %-8s    Nom2 : %s.%n" , position, caractereChaine1, getCodeUnicodeHexaDecimal(caractereChaine1), getNumericValue(caractereChaine1), getTypeCharacter(caractereChaine1), getIntValue(caractereChaine1), getCodePointDecimal(caractereChaine1), getCodePointHexaDecimal(caractereChaine1), getNameUnicodeChar(caractereChaine1), diff, caractereChaine2, getCodeUnicodeHexaDecimal(caractereChaine2), getNumericValue(caractereChaine2), getCodePointDecimal(caractereChaine2), getCodePointHexaDecimal(caractereChaine2), getNameUnicodeChar(caractereChaine2));
			}
			
			return null;
			
			
		} // Fin du bloc static synchronized.________________________
		
		
	} // Fin de differencier(String pString1
	 // , String pString2).________________________________________________



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
		System.out.println(creerCodePointDecimalfromCodePointHexa(0x49));
		differencier(ConvertisseurEncodage.lireDepuisFichier(FILE_DIACRITIQUES_ISO_8859_2, CHARSET_UTF8), STRING_REF_DIACRITIQUES_UTF8);
	}
	
	
	
} // FIN DE LA CLASSE DifferentiateurString.---------------------------------
