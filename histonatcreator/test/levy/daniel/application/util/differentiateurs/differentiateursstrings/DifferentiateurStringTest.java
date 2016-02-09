package levy.daniel.application.util.differentiateurs.differentiateursstrings;

import static org.junit.Assert.assertEquals;

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
		
		final boolean resultatVidage 
		= DifferentiateurString.viderRepertoireADetruire(new File(".\\data2"));
		
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
