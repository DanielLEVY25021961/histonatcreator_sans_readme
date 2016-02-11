package levy.daniel.application.util.differentiateurs.differentiateursstrings;

import static org.junit.Assert.*;

import java.io.File;

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
		
	} // Fin de testListerChaineCarParCar()._______________________________

	
	
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


	/**
	 * method test() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void test() {
		
//		DifferentiateurString.viderRepertoire(new File(".\\rep_0"));
		final boolean resultatVidage 
		= DifferentiateurString.viderRepertoireADetruire(new File(".\\rep_0"));
		
		System.out.println("resultatVidage : " + resultatVidage);
		
//		final boolean resultDestruction1 = 
//				DifferentiateurString.detruireArborescence(".\\data2");
//		
//		System.out.println("resultDestruction1 : " + resultDestruction1);
//		
//		final String cheminRepRapports 
//		= ".\\data2\\temp\\rapports";
//		
//		final boolean resultatCreation 
//			= DifferentiateurString.creerArborescence(cheminRepRapports);
//		
//		System.out.println("resultatCreation : " + resultatCreation);
				
	}
	
	
} // FIN DE LA CLASSE DifferentiateurStringTest.-----------------------------
