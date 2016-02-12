package levy.daniel.application.util.gestionnairesiofichiers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * class GestionnaireFichiersTest :<br/>
 * Test JUnit de la classe GestionnaireFichiers.<br/>
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
 * @since 11 févr. 2016
 *
 */
public class GestionnaireFichiersTest {

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
	 * ARBORESCENCE_A_CREER : String :<br/>
	 * ".\\rep_0\\rep_1_1\\rep_2_1".<br/>
	 */
	public static final String ARBORESCENCE_A_CREER 
		= ".\\rep_0\\rep_1_1\\rep_2_1";
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(GestionnaireFichiersTest.class);

	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR GestionnaireFichiersTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public GestionnaireFichiersTest() {		
		/* Instanciation de la Super-Classe. */
		super();		
	} // Fin de GestionnaireFichiersTest().________________________________
	

	
	
	/**
	 * method testCreerArborescence() :<br/>
	 * teste la méthode creerArborescence.<br/>
	 * <br/>
	 * - Vérifie que GestionnaireFichiers.creerArborescence(null) 
	 * retourne false.<br/>
	 * - Vérifie que GestionnaireFichiers.creerArborescence(blank) 
	 * retourne false.<br/>
	 * - Vérifie que GestionnaireFichiers.creerArborescence(existant) 
	 * retourne false.<br/>
	 * - Vérifie que GestionnaireFichiers.creerArborescence 
	 * avec un des répertoires du chemin blank retourne false.<br/>
	 * <br/>
	 * @throws InterruptedException 
	 */
	@Test
	public void testCreerArborescence() throws InterruptedException {
				
		GestionnaireFichiers.detruireArborescence(".\\rep_0");
		
		/* Attente. */
		Thread.sleep(1000);
		
		/* Vérifie que GestionnaireFichiers.creerArborescence(null) 
		 * retourne false. */
		assertFalse("creerArborescence(null) doit retourner false : "
				, GestionnaireFichiers.creerArborescence(null));
		
		/* Vérifie que GestionnaireFichiers.creerArborescence(blank) 
		 * retourne false. */
		assertFalse("creerArborescence(blank) doit retourner false : "
					, GestionnaireFichiers.creerArborescence("  "));
		
		/* Vérifie que GestionnaireFichiers.creerArborescence(existant) 
		 * retourne false. */
		assertFalse("creerArborescence(existant) doit retourner false : "
					, GestionnaireFichiers.creerArborescence(".\\data\\temp"));
		
		/* Vérifie que GestionnaireFichiers.creerArborescence(sans \\) 
		 * retourne false. */
		assertFalse("creerArborescence(sans \\) doit retourner false : "
					, GestionnaireFichiers.creerArborescence("data"));
		
		/* Vérifie que GestionnaireFichiers.creerArborescence 
		 * avec un des répertoires du chemin blank retourne false. */
		assertFalse("creerArborescence(avec rep blank) doit retourner false : "
					, GestionnaireFichiers.creerArborescence("data\\ \\temp"));
		
		final boolean resultat 
			= GestionnaireFichiers.creerArborescence(ARBORESCENCE_A_CREER);
		
		System.out.println(resultat);
		
	} // Fin de testCreerArborescence().___________________________________




} // FIN DE LA CLASSE GestionnaireFichiersTest.------------------------------
