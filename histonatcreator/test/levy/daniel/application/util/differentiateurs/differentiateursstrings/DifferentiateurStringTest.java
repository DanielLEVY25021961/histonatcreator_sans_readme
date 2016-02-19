package levy.daniel.application.util.differentiateurs.differentiateursstrings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.charset.Charset;

import levy.daniel.application.util.convertisseursencodage.ConvertisseurEncodageTest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * class DifferentiateurStringTest :<br/>
 * Test JUnit de la classe DifferentiateurString.<br/>
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
 * @since 8 févr. 2016
 *
 */
public final class DifferentiateurStringTest {

	// ************************ATTRIBUTS************************************/

	
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
	 * CHAINE_LISTER : String :<br/>
	 * "à b".<br/>
	 */
	public static final String CHAINE_LISTER = "à b";
		
	/**
	 * CHAINE_A_B : String :<br/>
	 * Résultat attendu de 
	 * DifferentiateurString.listerChaineCarParCar(CHAINE_LISTER).<br/>
	 * ATTENTION : il faut échapper les caractères Unicode et rajouter 
	 * un saut de ligne (\r\n sur une plateforme Windows) dans CHAINE_A_B
	 * pour obtenir l'équivalent de ce que délivre la méthode.)
	 */
	public static final String CHAINE_A_B = "Position : 1      Caractère : à     Unicode : \\u00e0  NumericValue : -1    TypeCaractere : 2   valeurEntiere : 224   Point de Code décimal : 224   Point de Code Hexa : e0      Nom : LATIN SMALL LETTER A WITH GRAVE         \r\nPosition : 2      Caractère :       Unicode : \\u0020  NumericValue : -1    TypeCaractere : 12  valeurEntiere : 32    Point de Code décimal : 32    Point de Code Hexa : 20      Nom : SPACE                                   \r\nPosition : 3      Caractère : b     Unicode : \\u0062  NumericValue : 11    TypeCaractere : 2   valeurEntiere : 98    Point de Code décimal : 98    Point de Code Hexa : 62      Nom : LATIN SMALL LETTER B                    \r\n";
	
	/**
	 * CHAINE_DOS : String :<br/>
	 * String avec un saut de ligne DOS/Windows (\r\n).<br/>
	 * "j'arrivât.\r\nelle-même aussi."<br/>
	 */
	public static final String CHAINE_DOS 
		= "j'arrivât.\r\nelle-même aussi.";
	
	
	/**
	 * CHAINE_MAC : String :<br/>
	 * String avec un saut de ligne Mac (\r).<br/>
	 * "j'arrivât.\relle-même aussi."<br/>
	 */
	public static final String CHAINE_MAC = "j'arrivât.\relle-même aussi.";
	
	
	/**
	 * CHAINE_UNIX : String :<br/>
	 * String avec un saut de ligne Mac (\n).<br/>
	 * "j'arrivât.\nelle-même aussi."
	 */
	public static final String CHAINE_UNIX = "j'arrivât.\nelle-même aussi.";

	
	/**
	 * CHAINE_REFERENCE : String :<br/>
	 * String avec le saut de ligne de la plateforme.<br/>
	 * "j'arrivât." + NEWLINE + "elle-même aussi."<br/>
	 */
	public static final String CHAINE_REFERENCE 
		= "j'arrivât." + NEWLINE + "elle-même aussi.";
	
	
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
 * STRING_REF_DIACRITIQUES_UTF8 : String : <br/>
 */
public static final String STRING_REF_DIACRITIQUES_UTF8 
	= ConvertisseurEncodageTest.STRING_REF_DIACRITIQUES_UTF8;


/**
 * STRING_REF_DIACRITIQUES_ISO_8859_2 : String : <br/>
 */
public static final String STRING_REF_DIACRITIQUES_ISO_8859_2 
	= ConvertisseurEncodageTest.STRING_REF_DIACRITIQUES_ISO_8859_2;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(DifferentiateurStringTest.class);

	
	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR DifferentiateurStringTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DifferentiateurStringTest() {		
		/* Instanciation de la Super-Classe. */
		super();		
	} // Fin de DifferentiateurStringTest()._______________________________
	

	
	/**
	 * method testListerChaineCarParCar() :<br/>
	 * teste la méthode listerChaineCarParCar(String pString).<br/>
	 * <br/>
	 * - Vérifie que DifferentiateurString.listerChaineCarParCar(null) 
	 * retourne null.<br/>
	 * - Vérifie que DifferentiateurString.listerChaineCarParCar("    ") 
	 * retourne null.<br/>
	 * - Vérifie que DifferentiateurString.listerChaineCarParCar(CHAINE_LISTER) 
	 * retourne CHAINE_A_B.<br/>
	 * - Vérifie que DifferentiateurString.getLongueurChaine() 
	 * retourne la bonne longueur.<br/>
	 */
	@Test
	public void testListerChaineCarParCar() {
		
		/* Vérifie que DifferentiateurString.listerChaineCarParCar(null) 
		 * retourne null. */
		final String stringNull = null;
		final String resultatNull 
		= DifferentiateurString.listerChaineCarParCar(stringNull);		
		assertNull(
				"DifferentiateurString.listerChaineCarParCar(null) doit retourne null : "
					, resultatNull);
		
		/* Vérifie que DifferentiateurString.listerChaineCarParCar("    ") 
		 * retourne null. */
		final String stringBlank = "   ";
		final String resultatBlank 
		= DifferentiateurString.listerChaineCarParCar(stringBlank);		
		assertNull(
				"DifferentiateurString.listerChaineCarParCar('   ') doit retourne null : "
					, resultatBlank);
		
		/* Vérifie que DifferentiateurString.listerChaineCarParCar(CHAINE_LISTER) 
		 * retourne CHAINE_A_B. */
		final String resultat 
			= DifferentiateurString.listerChaineCarParCar(CHAINE_LISTER);		
		assertEquals("DifferentiateurString.listerChaineCarParCar(CHAINE_LISTER) doit retourne CHAINE_A_B : "
				, CHAINE_A_B
					, resultat);
		
		final int longueurChaine = DifferentiateurString.getLongueurChaine();
		
		/* Vérifie que DifferentiateurString.getLongueurChaine() 
		 * retourne la bonne longueur. */
		assertEquals("DifferentiateurString.getLongueurChaine() doit retourner 3 : "
				, 3
					, longueurChaine);
		
	} // Fin de testListerChaineCarParCar()._______________________________


	
	/**
	 * method testDifferencier() :<br/>
	 * Teste la méthode differencier(
	 * String pString1, String pString2, Boolean pRapportFichier).<br/>
	 * <br/>
	 * - vérifie que rapportDiff existe.<br/>
	 * - vérifie que rapportCsvDiff existe.<br/>
	 * - vérifie que fileRapportDiff existe.<br/>
	 * - vérifie que fileRapportDiffCsv existe.<br/>
	 * - vérifie la bonne longueur de longueurChaine1.<br/>
	 * - vérifie la bonne longueur de longueurChaine2.<br/>
	 * - vérifie que rapportCreationfichierDiff existe.<br/>
	 * - vérifie que rapportCreationfichierDiffCsv existe.<br/>
	 * - vérifie que le DifferentiateurString fonctionne correctement 
	 * en cas d'appels successifs.<br/>
	 * <br/>
	 * @throws InterruptedException 
	 */
	@Test
	public void testDifferencier() throws InterruptedException {
		
		final String chaine1 = "mêt";
		final String chaine2 = "met";
		
		// Application de la méthode differencier(...) du DifferentiateurString.
		DifferentiateurString.differencier(chaine1, chaine2, true);
		
		final String rapportTxt1 = DifferentiateurString.getRapportDiff();
		final String rapportCsv1 = DifferentiateurString.getRapportDiffCsv();
		final File fileRapportTxt1 = DifferentiateurString.getFileRapportDiff();
		final File fileRapportCsv1 = DifferentiateurString.getFileRapportDiffCsv();
		final int longueurChaine1 = DifferentiateurString.getLongueurChaine1();
		final int longueurChaine2 = DifferentiateurString.getLongueurChaine2();		
		final String messageCreationRapportTxt1 
			= DifferentiateurString.getRapportCreationfichierDiff();
		final String messageCreationRapportCsv1 
		= DifferentiateurString.getRapportCreationfichierDiffCsv();
		
		
		/* vérifie que rapportDiff existe. */
		assertNotNull("le rapportDiff doit exister :  ", rapportTxt1);
		
		/* vérifie que rapportCsvDiff existe. */
		assertNotNull("le rapportDiffCsv doit exister :  ", rapportCsv1);
		
		/* vérifie que fileRapportDiff existe. */
		assertTrue("fileRapportDiff doit exister : ", fileRapportTxt1.exists());
		
		/* vérifie que fileRapportDiffCsv existe. */
		assertTrue("fileRapportDiffCsv doit exister : ", fileRapportCsv1.exists());
		
		/* vérifie la bonne longueur de longueurChaine1. */
		assertEquals("longueurChaine1 doit valoir 3 : ", 3, longueurChaine1);
		
		/* vérifie la bonne longueur de longueurChaine2. */
		assertEquals("longueurChaine2 doit valoir 3 : ", 3, longueurChaine2);
		
		/* vérifie que rapportCreationfichierDiff existe. */
		assertNotNull("le rapportCreationfichierDiff doit exister :  ", messageCreationRapportTxt1);
		
		/* vérifie que rapportCreationfichierDiffCsv existe. */
		assertNotNull("le rapportCreationfichierDiffCsv doit exister :  ", messageCreationRapportCsv1);
		
		/* Attente d'une milliseconde. */
		Thread.sleep(1);
		
		/* vérifie que le DifferentiateurString fonctionne correctement en cas d'appels successifs. */
		final String chaine3 = "bâte";
		final String chaine4 = "bas";
		
		// Application du DifferentiateurString.
		DifferentiateurString.differencier(chaine3, chaine4, true);
		
		final String rapportTxt2 = DifferentiateurString.getRapportDiff();
		final String rapportCsv2 = DifferentiateurString.getRapportDiffCsv();
		final File fileRapportTxt2 = DifferentiateurString.getFileRapportDiff();
		final File fileRapportCsv2 = DifferentiateurString.getFileRapportDiffCsv();
		final int longueurChaine3 = DifferentiateurString.getLongueurChaine1();
		final int longueurChaine4 = DifferentiateurString.getLongueurChaine2();		
		final String messageCreationRapportTxt2 
			= DifferentiateurString.getRapportCreationfichierDiff();
		final String messageCreationRapportCsv2 
		= DifferentiateurString.getRapportCreationfichierDiffCsv();
		
		/* vérifie que rapportDiff existe. */
		assertNotNull("le rapportDiff existe :  ", rapportTxt2);
		
		/* vérifie que rapportCsvDiff existe. */
		assertNotNull("le rapportDiffCsv doit exister :  ", rapportCsv2);
		
		/* vérifie que fileRapportDiff existe. */
		assertTrue("fileRapportDiff doit exister : ", fileRapportTxt2.exists());
		
		/* vérifie que fileRapportDiffCsv existe. */
		assertTrue("fileRapportDiffCsv doit exister : ", fileRapportCsv2.exists());
		
		/* vérifie la bonne longueur de longueurChaine1. */
		assertEquals("longueurChaine3 doit valoir 4 : ", 4, longueurChaine3);
		
		/* vérifie la bonne longueur de longueurChaine2. */
		assertEquals("longueurChaine4 doit valoir 3 : ", 3, longueurChaine4);
		
		/* vérifie que rapportCreationfichierDiff existe. */
		assertNotNull("le rapportCreationfichierDiff doit exister :  ", messageCreationRapportTxt2);
		
		/* vérifie que rapportCreationfichierDiffCsv existe. */
		assertNotNull("le rapportCreationfichierDiffCsv doit exister :  ", messageCreationRapportCsv2);
		
		/* test de la méthode afficherTout(). */
//		System.out.println(DifferentiateurString.afficherTout());
		
	} // Fin de testDifferencier().________________________________________
	

	
	/**
	 * method testFournirCaractereDan() :<br/>
	 * Teste la méthode fournirCaractereDan(char pChar).<br/>
	 * <br/>
	 */
	@Test
	public void testFournirCaractereDan() {
		
		final CaractereDan carDan 
			= DifferentiateurString.fournirCaractereDan('é');
		
		final String resultat = carDan.toCsv();
		
		assertEquals("Doit retourner un csv : "
				, "null;null;é;\\u00e9;-1;2;233;233;e9;LATIN SMALL LETTER E WITH ACUTE;"
					, resultat);
		
	} // Fin de testFournirCaractereDan()._________________________________
	
	
	
	/**
	 * method testSubstituerSautLignePlateforme() :<br/>
	 * test de la méthode substituerSautLignePlateforme(String).<br/>
	 * <br/>
	 */
	@Test
	public void testSubstituerSautLignePlateforme() {
		
		final String resultatDOS = DifferentiateurString.substituerSautLignePlateforme(CHAINE_DOS);
//		System.out.println(resultatDOS);
//		System.out.println(DifferentiateurString.listerChaineCarParCar(resultatDOS));
		
		assertEquals("resultatDOS equals CHAINE_REFERENCE : "
				, CHAINE_REFERENCE
					, resultatDOS);
		
		final String resultatMAC = DifferentiateurString.substituerSautLignePlateforme(CHAINE_MAC);
//		System.out.println(resultatMAC);
//		System.out.println(DifferentiateurString.listerChaineCarParCar(resultatMAC));
		
		assertEquals("resultatDOS equals CHAINE_REFERENCE : "
				, CHAINE_REFERENCE
					, resultatMAC);
		
		final String resultatUNIX = DifferentiateurString.substituerSautLignePlateforme(CHAINE_UNIX);
//		System.out.println(resultatUNIX);
//		System.out.println(DifferentiateurString.listerChaineCarParCar(resultatUNIX));
		
		assertEquals("resultatDOS equals CHAINE_REFERENCE : "
				, CHAINE_REFERENCE
					, resultatUNIX);
		
	} // Fin de testSubstituerSautLignePlateforme()._______________________
	
	
} // FIN DE LA CLASSE DifferentiateurStringTest.-----------------------------
