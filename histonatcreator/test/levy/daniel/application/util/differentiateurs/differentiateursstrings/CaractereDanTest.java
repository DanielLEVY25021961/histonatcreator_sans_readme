package levy.daniel.application.util.differentiateurs.differentiateursstrings;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * class CaractereDanTest :<br/>
 * Test JUNit de la classe CaractereDan.<br/>
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
 * @since 6 févr. 2016
 *
 */
public final class CaractereDanTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * CARAC_NULL : CaractereDan :<br/>
	 * .<br/>
	 */
	public static final CaractereDan CARAC_NULL 
	= new CaractereDan(null, null, null, null, 0, 0, 0, 0, null, null);
	
	/**
	 * CARAC_D1 : CaractereDan :<br/>
	 * 'd' LATIN SMALL LETTER D.<br/>
	 */
	public static final CaractereDan CARAC_D1 
	= new CaractereDan(2L, 258, 'd', "\\u0064", 13, 2, 100, 100, "64", "LATIN SMALL LETTER D");
	
	/**
	 * CARAC_D2 : CaractereDan :<br/>
	 * 'd' LATIN SMALL LETTER D.<br/>
	 */
	public static final CaractereDan CARAC_D2 
	= new CaractereDan(3L, 264, 'd', "\\u0064", 13, 2, 100, 100, "64", "LATIN SMALL LETTER D");
	
	/**
	 * CARAC_E_AIGU : CaractereDan :<br/>
	 * 'é' LATIN SMALL LETTER E WITH ACUTE.<br/>
	 */
	public static final CaractereDan CARAC_E_AIGU 
	= new CaractereDan(454L, 454, 'é', "\\u00e9", -1, 2, 233, 233, "e9", "LATIN SMALL LETTER E WITH ACUTE");
	
	/**
	 * CARAC_E_GRAVE : CaractereDan :<br/>
	 * 'è' LATIN SMALL LETTER E WITH GRAVE.<br/>
	 */
	public static final CaractereDan CARAC_E_GRAVE 
	= new CaractereDan(454L, 454, 'è', "\\u00e8", -1, 2, 232, 232, "e8", "LATIN SMALL LETTER E WITH GRAVE");
	
	/**
	 * CARAC_POINT : CaractereDan :<br/>
	 * '.' FULL STOP.<br/>
	 */
	public static final CaractereDan CARAC_POINT 
	= new CaractereDan(501L, 501, '.', "\\u002e", -1, 24, 46, 46, "2e", "FULL STOP");
	
	/**
	 * CARAC_REPLACEMENT : CaractereDan :<br/>
	 * REPLACEMENT CHARACTER.<br/>
	 */
	public static final CaractereDan CARAC_REPLACEMENT 
	= new CaractereDan(1L, 259, '�', "\\ufffd", -1, 28, 65533, 65533, "fffd", "REPLACEMENT CHARACTER");
	
	/**
	 * TOSTRING_CARAC_NULL : String :<br/>
	 * toString() de CARAC_NULL.<br/>
	 */
	public static final String TOSTRING_CARAC_NULL = "Caractère : null  Unicode : null    NumericValue : 0     TypeCaractere : 0   valeurEntiere : 0     Point de Code décimal : 0     Point de Code Hexa : null    Nom : null                                    ";
	
	/**
	 * TOCSV_CARAC_NULL : String :<br/>
	 * toCsv() de CARAC_NULL.<br/>
	 * "null;null;null;null;0;0;0;0;null;null;".<br/>
	 */
	public static final String TOCSV_CARAC_NULL = "null;null;null;null;0;0;0;0;null;null;";
	
	
	/**
	 * ENTETE_CARACTEREDAN : String :<br/>
	 * "id;Position;Caractère;Unicode;numericValue;Type de Caractère;
	 * Valeur Entière;Point de Code Décimal;Point de Code HexaDécimal;
	 * Nom Unicode;".<br/>
	 */
	public static final String ENTETE_CARACTEREDAN 
		= "id;Position;Caractère;Unicode;numericValue;Type de Caractère;"
				+ "Valeur Entière;Point de Code Décimal;"
				+ "Point de Code HexaDécimal;Nom Unicode;";
	
	/**
	 * LISTE_COLONNES_CARAC_NULL : List<Object> :<br/>
	 * Liste des valeurs dans les colonnes de CARAC_NULL.<br/>
	 */
	public static final List<Object> LISTE_COLONNES_CARAC_NULL = new ArrayList<Object>();
	
	static {
		
		LISTE_COLONNES_CARAC_NULL.add(null);
		LISTE_COLONNES_CARAC_NULL.add(null);
		LISTE_COLONNES_CARAC_NULL.add(null);
		LISTE_COLONNES_CARAC_NULL.add(null);
		LISTE_COLONNES_CARAC_NULL.add(0);
		LISTE_COLONNES_CARAC_NULL.add(0);
		LISTE_COLONNES_CARAC_NULL.add(0);
		LISTE_COLONNES_CARAC_NULL.add(0);
		LISTE_COLONNES_CARAC_NULL.add(null);
		LISTE_COLONNES_CARAC_NULL.add(null);
		
	}
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(CaractereDanTest.class);
	

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR CaractereDanTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CaractereDanTest() {		
		/* Instanciation de la Super-Classe. */
		super();		
	} // Fin de CaractereDanTest().________________________________________
	

	/**
	 * method testConstructeurAriteNulle() :<br/>
	 * Teste le constructeur d'arite nulle 
	 * pour Vérifier les NullPointerException.<br/>
	 * <br/>
	 * Contrats Java :<br/>
	 * - Si deux objets sont equals, alors même HashCode.<br/>
	 * - Si deux objets ne sont pas equals, alors HashCode différents.<br/>
	 * <br/>
	 * - x.equals(y) ---> x.compareTo(y) == 0.<br/>
	 */
	@Test
	public void testConstructeurAriteNulle() {
		
		final CaractereDan caracAriteNulle1 = new CaractereDan();
		
		final CaractereDan caracNull1 
		= new CaractereDan(1L, null, null, null, 0, 0, 0, 0, null, null);
		
		assertEquals("caracAriteNulle1.toString() equals TOSTRING_CARAC_NULL : "
				, caracAriteNulle1.toString(), TOSTRING_CARAC_NULL);
		
		assertEquals("caracAriteNulle1.toCsv() equals TOCSV_CARAC_NULL : "
				, caracAriteNulle1.toCsv(), TOCSV_CARAC_NULL);
		
		this.assertionsListeColonne(LISTE_COLONNES_CARAC_NULL, caracAriteNulle1);
		
		assertEquals("caracAriteNulle1 equals caracNull1 : "
				, caracAriteNulle1, caracNull1);
		
		assertEquals("caracAriteNulle1 equals caracNull1, donc caracAriteNulle1.hascode == caracNull1.hascode : "
				, caracAriteNulle1.hashCode(), caracNull1.hashCode());
		
		assertEquals("caracAriteNulle1.compareTo(caracNull1) == 0 : "
				, 0, caracAriteNulle1.compareTo(caracNull1));
		
	} // Fin de testConstructeurAriteNulle().______________________________
	
	
	
	/**
	 * method testConstructeurCompletNull() :<br/>
	 * Teste le constructeur complet avec toutes les valeurs à null 
	 * pour Vérifier les NullPointerException.<br/>
	 * <br/>
	 * Contrats Java :<br/>
	 * - Si deux objets sont equals, alors même HashCode.<br/>
	 * - Si deux objets ne sont pas equals, alors HashCode différents.<br/>
	 * <br/>
	 * - x.equals(y) ---> x.compareTo(y) == 0.<br/>
	 */
	@Test
	public void testConstructeurCompletNull() {
		
		final CaractereDan caracNull1 
		= new CaractereDan(1L, null, null, null, 0, 0, 0, 0, null, null);
		
		final CaractereDan caracNull2 
		= new CaractereDan(2L, null, null, null, 0, 0, 0, 0, null, null);
		
		assertEquals("caracNull1 equals caracNull2 : "
				, caracNull1, caracNull2);
		
		assertEquals("caracNull1 equals caracNull2, donc caracNull1.hascode == caracNull2.hascode : "
				, caracNull1.hashCode(), caracNull2.hashCode());
		
		assertEquals("caracNull1.compareTo(caracNull2) == 0 : "
				, 0, caracNull1.compareTo(caracNull2));
		
		final CaractereDan carNullAuto = new CaractereDan(null);
		System.out.println(carNullAuto.toString());
		
	} // Fin de testConstructeurCompletNull()._____________________________
	
	
	
	/**
	 * method testGetEnTeteCsv() :<br/>
	 * Garantit que getEnTeteCsv() de CaractereDan 
	 * retourne l'en-tête csv : <br/> 
	 * "id;Position;Caractère;Unicode;numericValue;Type de Caractère;
	 * Valeur Entière;Point de Code Décimal;
	 * Point de Code HexaDécimal;Nom Unicode;".<br/>
	 * <br/>
	 */
	@Test
	public void testGetEnTeteCsv() {
		
		final CaractereDan carac = new CaractereDan();
		
		assertEquals(
				"Doit retourner le bon en-tête csv : "
					, ENTETE_CARACTEREDAN, carac.getEnTeteCsv());
			
	} // Fin de testGetEnTeteCsv().________________________________________


	
	/**
	 * method testGetEnTeteColonne() :<br/>
	 * Teste les en-tête de colonnes pour les JTable.<br/>
	 * "id;position;caractère;unicode;numericValue;typeCaractere;
	 * valeurEntiere;codePointDecimal;
	 * codePointHexa;nom;".<br/>
	 * <br/>
	 */
	@Test
	public void testGetEnTeteColonne() {
		
		assertEquals("enTete(0) equals id : "
				, "id"
					, CARAC_D1.getEnTeteColonne(0));
		
		assertEquals("enTete(1) equals position : "
				, "position"
					, CARAC_D1.getEnTeteColonne(1));
		
		assertEquals("enTete(2) equals caractère : "
				, "caractère"
					, CARAC_D1.getEnTeteColonne(2));
		
		assertEquals("enTete(3) equals unicode : "
				, "unicode"
					, CARAC_D1.getEnTeteColonne(3));
		
		assertEquals("enTete(4) equals numericValue : "
				, "numericValue"
					, CARAC_D1.getEnTeteColonne(4));
		
		assertEquals("enTete(5) equals typeCaractere : "
				, "typeCaractere"
					, CARAC_D1.getEnTeteColonne(5));
		
		assertEquals("enTete(6) equals valeurEntiere : "
				, "valeurEntiere"
					, CARAC_D1.getEnTeteColonne(6));
		
		assertEquals("enTete(7) equals codePointDecimal : "
				, "codePointDecimal"
					, CARAC_D1.getEnTeteColonne(7));
		
		assertEquals("enTete(8) equals codePointHexa : "
				, "codePointHexa"
					, CARAC_D1.getEnTeteColonne(8));
		
		assertEquals("enTete(9) equals nom : "
				, "nom"
					, CARAC_D1.getEnTeteColonne(9));
		
		assertEquals("enTete(12) equals invalide : "
				, "invalide"
					, CARAC_D1.getEnTeteColonne(12));
		
	} // Fin de testGetEnTeteColonne().____________________________________
	

	
	/**
	 * method assertionsListeColonne() :<br/>
	 * Teste les valeurs dans les colonnes d'une JTable.<br/>
	 * <br/>
	 * "id;position;caractère;unicode;numericValue;typeCaractere;
	 * valeurEntiere;codePointDecimal;
	 * codePointHexa;nom;".<br/>
	 * <br/>
	 *
	 * @param pList : List<Object>.<br/>
	 * @param pCar : CaractereDan.<br/>
	 */
	public void assertionsListeColonne(
			final List<Object> pList
				, final CaractereDan pCar) {
		
		assertEquals("colonne(0) equals id : "
				, pCar.getValeurColonne(0)
					, pList.get(0));
		
		assertEquals("colonne(1) equals position : "
				, pCar.getValeurColonne(1)
					, pList.get(1));
		
		assertEquals("colonne(2) equals caractère : "
				, pCar.getValeurColonne(2)
					, pList.get(2));
		
		assertEquals("colonne(3) equals unicode : "
				, pCar.getValeurColonne(3)
					, pList.get(3));
		
		assertEquals("colonne(4) equals numericValue : "
				, pCar.getValeurColonne(4)
					, pList.get(4));
		
		assertEquals("colonne(5) equals typeCaractere : "
				, pCar.getValeurColonne(5)
					, pList.get(5));
		
		assertEquals("colonne(6) equals valeurEntiere : "
				, pCar.getValeurColonne(6)
					, pList.get(6));
		
		assertEquals("colonne(7) equals codePointDecimal : "
				, pCar.getValeurColonne(7)
					, pList.get(7));
		
		assertEquals("colonne(8) equals codePointHexa : "
				, pCar.getValeurColonne(8)
					, pList.get(8));
		
		assertEquals("colonne(9) equals nom : "
				, pCar.getValeurColonne(9)
					, pList.get(0));
		
		assertEquals("colonne(> 9) equals invalide : "
				, pCar.getValeurColonne(12)
					, "invalide");
		
	} // Fin de assertionsListeColonne().__________________________________
	
	
	
} // FIN DE LA CLASSE CaractereDanTest.--------------------------------------
