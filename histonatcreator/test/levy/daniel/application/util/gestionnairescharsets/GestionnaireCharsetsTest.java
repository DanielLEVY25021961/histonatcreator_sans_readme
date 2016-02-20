package levy.daniel.application.util.gestionnairescharsets;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * class GestionnaireCharsetsTest :<br/>
 * Test JUNit de la classe GestionnaireCharsets.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * diacritiques, liste des diacritiques, [çôïâàîœêüéûèëŒÉ€ÿùù],<br/>
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
public class GestionnaireCharsetsTest {

	// ************************ATTRIBUTS************************************/

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
	 * CHEMIN_FICHIERS_TEST : String :<br/>
	 * Chemin des fichiers de test 
	 * relativement à la racine du projet courant.<br/>
	 * ".\\test\\ressourcesjunit\\differentstypesfichiers\\".<br/>
	 */
	public static final String CHEMIN_FICHIERS_TEST 
		= ".\\test\\ressourcesjunit\\differentstypesfichiers\\";

	
	/**
	 * CHEMIN_DIACRITIQUES_UTF8 : String :<br/>
	 * Chemin du fichier .txt codé en UTF-8 
	 * relativement à la racine des fichiers de test.<br/>
	 */
	public static final String CHEMIN_DIACRITIQUES_UTF8 
		= "encodages\\diacritiques_UTF8.txt";


	/**
	 * FILE_DIACRITIQUES_UTF8 : File : <br/>
	 * txt codé en UTF-8.<br/>
	 */
	public static final File FILE_DIACRITIQUES_UTF8 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DIACRITIQUES_UTF8);
	
	
	/**
	 * STRING_REF_DIACRITIQUES_UTF8 : String : <br/>
	 */
	public static final String STRING_REF_DIACRITIQUES_UTF8 = "UTF-8. Tous français inscrit au rôle, naïf ou râleur, à Nîmes, carbœuf ou même Capharnaüm, aura payé son dû dès avant Noël. ligne de 148 caractères.\r\nUTF-8. Œdipe de Capharnaüm et Éric de Nîmes étaient français, drôles, naïfs et râleurs mais ils ont dû être pris à l’œil dès Noël. ligne de 155 caractères.\r\nUTF-8. Mon châton est évalué à 15 € sur le marché de Noël de Faÿ-lès-Nemours. Où ça ? Là bas. ligne de 118 caractères.\r\nUTF-8. ligne de 074 caractères et 495 caractères au total dans ce fichier.";
	

	/**
	 * LISTE_CHARSETS : List<Charset> :<br/>
	 * Liste contenant tous les Charsets utilisés pour les tests.<br/>
	 */
	public static final List<Charset> LISTE_CHARSETS = new ArrayList<Charset>();

	
	/* Bloc statique pour remplir la liste des Charsets. */
	static {
		
		LISTE_CHARSETS.add(CHARSET_UTF8);
		LISTE_CHARSETS.add(CHARSET_US_ASCII);
		LISTE_CHARSETS.add(CHARSET_ISO_8859_1);
		LISTE_CHARSETS.add(CHARSET_ISO_8859_2);
		LISTE_CHARSETS.add(CHARSET_ISO_8859_9);
		LISTE_CHARSETS.add(CHARSET_ISO_8859_15);
		LISTE_CHARSETS.add(CHARSET_ANSI);
		LISTE_CHARSETS.add(CHARSET_IBM850);
		
	}

	
	/**
	 * DIACRITIQUES_LIST : List<Character> :<br/>
	 * Liste des caractères diacritiques français [çôïâàîœêüéûèëŒÉ€ÿùù].<br/>
	 */
	public static final List<Character> DIACRITIQUES_LIST 
		= new ArrayList<Character>();

	/* Bloc statique pour remplir la liste des diacritiques. */
	static {
		
		/* ç */
		DIACRITIQUES_LIST.add('\u00e7');
		/* ô */
		DIACRITIQUES_LIST.add('\u00f4');
		/* ï */
		DIACRITIQUES_LIST.add('\u00ef');
		/* â */
		DIACRITIQUES_LIST.add('\u00e2');
		/* à */
		DIACRITIQUES_LIST.add('\u00e0');
		/* î */
		DIACRITIQUES_LIST.add('\u00ee');
		/* œ */
		DIACRITIQUES_LIST.add('\u0153');
		/* ê */
		DIACRITIQUES_LIST.add('\u00ea');
		/* ü */
		DIACRITIQUES_LIST.add('\u00fc');
		/* é */
		DIACRITIQUES_LIST.add('\u00e9');
		/* û */
		DIACRITIQUES_LIST.add('\u00fb');
		/* è */
		DIACRITIQUES_LIST.add('\u00e8');
		/* ë */
		DIACRITIQUES_LIST.add('\u00eb');
		/* Œ */
		DIACRITIQUES_LIST.add('\u0152');
		/* É */
		DIACRITIQUES_LIST.add('\u00c9');
		/* € */
		DIACRITIQUES_LIST.add('\u20ac');
		/* ÿ */
		DIACRITIQUES_LIST.add('\u00ff');
		/* ù */
		DIACRITIQUES_LIST.add('\u00f9');
		/* ù */
		DIACRITIQUES_LIST.add('\u00f9');
				
	}
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(GestionnaireCharsetsTest.class);
	

	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR GestionnaireCharsetsTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public GestionnaireCharsetsTest() {		
		/* Instanciation de la Super-Classe. */
		super();		
	} // Fin de GestionnaireCharsetsTest().________________________________


	
	/**
	 * method testSavoirSiCharsetPeutEncoderChar() :<br/>
	 * Teste la méthode savoirSiCharsetPeutEncoderChar(
	 * Charset pCharset, char pCher).<br/>
	 * <br/>
	 * - Vérifie que savoirSiCharsetPeutEncoderChar(null, ...) retourne false.<br/>
	 * - Vérifie que la méthode retourne le bon résultat.<br/>
	 * - Vérifie que la méthode crée un rapport textuel.<br/>
	 * - Vérifie que la méthode crée un rapport csv.<br/>
	 * - Vérifie que la méthode retourne le bon entête csv.<br/>
	 * - Vérifie que plusieurs appels successifs fonctionnent.<br/>
	 */
	@Test
	public void testSavoirSiCharsetPeutEncoderChar() {
		
		/* Vérifie que savoirSiCharsetPeutEncoderChar(null, ...) retourne false. */
		assertFalse("savoirSiCharsetPeutEncoderChar(null, 'ë') doit retourner false : "
				, GestionnaireCharsets.savoirSiCharsetPeutEncoderChar(null, 'ë'));
		
		final boolean resultat1 
		= GestionnaireCharsets
			.savoirSiCharsetPeutEncoderChar(CHARSET_IBM850, 'ë');
		
		/* Vérifie que la méthode retourne le bon résultat. */
		assertTrue("CHARSET_IBM850 peut encoder ë : ", resultat1);
		
		/* Vérifie que la méthode crée un rapport textuel. */
		assertEquals("doit retourner IBM850 peut encoder le caractère ë : "
				, "IBM850 peut encoder le caractère ë"
					, GestionnaireCharsets.getRapportEncodagePossibleTxt());
		
		/* Vérifie que la méthode crée un rapport csv. */
		assertEquals("doit retourner IBM850;PEUT encoder;ë; : "
				, "IBM850;PEUT encoder;ë;"
					, GestionnaireCharsets.getRapportEncodagePossibleCsv());
		
		/* Vérifie que la méthode retourne le bon entête csv. */
		assertEquals("doit retourner Charset;possibilité d'encodage;Caractère; : "
				, "Charset;possibilité d'encodage;Caractère;"
					, GestionnaireCharsets.getEnteteCsvEncodage());
		
		/* Vérifie que plusieurs appels successifs fonctionnent. */
		final boolean resultat2 
		= GestionnaireCharsets
			.savoirSiCharsetPeutEncoderChar(CHARSET_IBM850, '\u0152');
		
		/* Vérifie que la méthode retourne le bon résultat. */
		assertFalse("CHARSET_IBM850 ne peut pas encoder Œ : ", resultat2);
		
		/* Vérifie que la méthode crée un rapport textuel. */
		assertEquals("doit retourner IBM850 ne peut PAS encoder le caractère Œ : "
				, "IBM850 ne peut PAS encoder le caractère Œ"
					, GestionnaireCharsets.getRapportEncodagePossibleTxt());
		
		/* Vérifie que la méthode crée un rapport csv. */
		assertEquals("doit retourner IBM850;NE PEUT PAS encoder;Œ; : "
				, "IBM850;NE PEUT PAS encoder;Œ;"
					, GestionnaireCharsets.getRapportEncodagePossibleCsv());
		
	} // Fin de testSavoirSiCharsetPeutEncoderChar().______________________


	
	/**
	 * method testSavoirSiCharsetPeutDecoderChar() :<br/>
	 * .<br/>
	 * <br/>
	 * : void :  .<br/>
	 */
	@Test
	public void testSavoirSiCharsetPeutDecoderChar() {
		
		for(final char car : DIACRITIQUES_LIST) {
			
			final boolean resultat 
			= GestionnaireCharsets.savoirSiCharsetPeutDecoderChar(
					CHARSET_IBM850, car);
			
			System.out.println(resultat);
			
			System.out.println(GestionnaireCharsets.getRapportDecodagePossibleTxt());
			System.out.println(GestionnaireCharsets.getRapportDecodagePossibleCsv());
			
		}
		
	}
	
} // FIN DE LA CLASSE GestionnaireCharsetsTest.------------------------------
