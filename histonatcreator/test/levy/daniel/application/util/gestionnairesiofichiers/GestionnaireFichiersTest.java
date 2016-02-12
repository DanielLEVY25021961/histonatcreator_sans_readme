package levy.daniel.application.util.gestionnairesiofichiers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

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
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("FR", "fr").<br/>
	 */
	public static final Locale LOCALE_FR_FR = new Locale("FR", "fr");


	/**
	 * DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE : DateFormat :<br/>
	 * Format concentré des dates avec heures et secondes
	 * comme "2012-01-16_18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	public static final DateFormat DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", LOCALE_FR_FR);

	
	/**
	 * DF_DATE_FRANCAISE : DateFormat :<br/>
	 * Format classique des dates françaises comme
	 * '25/02/1961'.<br/>
	 */
	public static final DateFormat DF_DATE_FRANCAISE 
	= new SimpleDateFormat("dd/MM/yyyy", LOCALE_FR_FR);
	
	
	/**
	 * DF_DATE_COMPLETE_FRANCAISE : DateFormat :<br/>
	 * Format complet des dates françaises comme
	 * 'samedi 25 février 1961'.<br/>
	 */
	public static final DateFormat DF_DATE_COMPLETE_FRANCAISE 
		= new SimpleDateFormat("EEEE' 'dd' 'MMMM' 'yyyy"
			, LOCALE_FR_FR);

	
	/**
	 * DF_MOIS_ANNEE : DateFormat :<br/>
	 * Format des dates françaises avec mois-année comme
	 * 'février 1961'.<br/>
	 */
	public static final DateFormat DF_MOIS_ANNEE 
		= new SimpleDateFormat("MMMM' 'yyyy"
			, LOCALE_FR_FR);

	
	/**
	 * DF_MOIS_ANNEE_SIMPLE : DateFormat :<br/>
	 * Format des dates françaises avec mois simplifié-année comme
	 * '02/1961'.<br/>
	 */
	public static final DateFormat DF_MOIS_ANNEE_SIMPLE 
	= new SimpleDateFormat("MM/yyyy", LOCALE_FR_FR);
	
	
	/**
	 * DF_ANNEE : DateFormat :<br/>
	 * Format des dates avec juste l'année comme "1961".<br/>
	 */
	public static final DateFormat DF_ANNEE 
		= new SimpleDateFormat("yyyy", LOCALE_FR_FR);
	

	/**
	 * DF_DATE_AVEC_HEURE_MINUTE_SECONDE : DateFormat :<br/>
	 * Format classique des dates avec heures et secondes
	 * comme "2012-01-16 à 18 heures,09 minutes,55 secondes" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	public static final DateFormat DF_DATE_AVEC_HEURE_MINUTE_SECONDE 
	= new SimpleDateFormat("yyyy-MM-dd' " 
	+ "à 'HH' heures,'mm' minutes,'ss' secondes'", LOCALE_FR_FR);
	
	 
	/**
	 * DF_DATE_HEURE_MINUTE_SECONDE : DateFormat :<br/>
	 * Format concentré des dates avec heures et secondes
	 * comme "2012-01-16:18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	public static final DateFormat DF_DATE_HEURE_MINUTE_SECONDE 
		= new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss", LOCALE_FR_FR);

	
	/**
	 * sSdfyyyyMMdd : SimpleDateFormat : <br/>
	 * "yyyy-MM-dd" comme "2011-05-26" pour 26 Mai 2011.<br/>
	 */
	public static SimpleDateFormat sSdfyyyyMMdd 
	= new SimpleDateFormat("yyyy-MM-dd", LOCALE_FR_FR);

	
	/**
	 * sSdfyyyyMMddHHmmss : SimpleDateFormat : <br/>
	 * "yyyy-MM-dd HH:mm:ss" comme "2011-05-26 17:41:07"
	 * pour 26 Mai 2011 à 17h 41mn et7s.<br/>
	 */
	public static SimpleDateFormat sSdfyyyyMMddHHmmss 
	= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", LOCALE_FR_FR);

	
	/**
	 * sSdfddMMyyyy : SimpleDateFormat : <br/>
	 * "ddMMyyyy" comme "26052011" pour 26 Mai 2011.<br/>
	 */
	public static SimpleDateFormat sSdfddMMyyyy 
	= new SimpleDateFormat("ddMMyyyy", LOCALE_FR_FR);
	

static {
	DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE.setLenient(false);
	DF_DATE_FRANCAISE.setLenient(false);
	DF_DATE_COMPLETE_FRANCAISE.setLenient(false);
	DF_MOIS_ANNEE.setLenient(false);
	DF_MOIS_ANNEE_SIMPLE.setLenient(false);
	DF_ANNEE.setLenient(false);
	DF_DATE_AVEC_HEURE_MINUTE_SECONDE.setLenient(false);
	DF_DATE_HEURE_MINUTE_SECONDE.setLenient(false);
	sSdfyyyyMMdd.setLenient(false);
	sSdfddMMyyyy.setLenient(false);
	sSdfyyyyMMddHHmmss.setLenient(false);
}


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
	 * method testEcrireStringDansFileUtf8() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testEcrireStringDansFileUtf8() {
		assertTrue("BIDON : ", 1 == 1);
	} // Fin de testEcrireStringDansFileUtf8().____________________________
	
	
	
	/**
	 * method testEcrireStringDansFile() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testEcrireStringDansFile() {
		assertTrue("BIDON : ", 1 == 1);
	} // Fin de testEcrireStringDansFile().________________________________
	

	
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
	 * - Vérifie que GestionnaireFichiers.creerArborescence(racine inexistante) 
	 * retourne false.<br/>
	 * <br/>
	 * @throws InterruptedException 
	 */
	@Test
	public void testCreerArborescence() throws InterruptedException {
		
		/* DESTRUCTION EVENTUELLE DU REPERTOIRE. */
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
		
		/* Vérifie que GestionnaireFichiers.creerArborescence(racine inexistante) 
		 * retourne false. */
		assertFalse("creerArborescence(racine inexistante) doit retourner false : "
					, GestionnaireFichiers.creerArborescence("totopouetpouet\\trifouilly"));
		
		
		
		/* CREATION DU REPERTOIRE. */
		final boolean resultat 
			= GestionnaireFichiers.creerArborescence(ARBORESCENCE_A_CREER);
		
		assertTrue("GestionnaireFichiers.creerArborescence(ARBORESCENCE_A_CREER) doit retourner true : "
				, resultat);
		
		/* Attente. */
		Thread.sleep(1000);
		
		/* DESTRUCTION EVENTUELLE DU REPERTOIRE. */
		GestionnaireFichiers.detruireArborescence(".\\rep_0");
		
	} // Fin de testCreerArborescence().___________________________________


	
	/**
	 * method testDetruireArborescence() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testDetruireArborescence() {
		assertTrue("BIDON : ", 1 == 1);
	} // Fin de testDetruireArborescence().________________________________
	

	
	/**
	 * method testViderRepertoire() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testViderRepertoire() {
		assertTrue("BIDON : ", 1 == 1);
	} // Fin de testViderRepertoire()._____________________________________
	

	
	/**
	 * method testFournirFile() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testFournirFile() {
		assertTrue("BIDON : ", 1 == 1);
	} // Fin de testFournirFile()._________________________________________
	

	
	/**
	 * method testFournirDateFormattee() :<br/>
	 * Teste la méthode fournirDateFormattee(Date, DateFormat).<br/>
	 * <br/>
	 * - Vérifie que fournirDateFormattee(null,...) retourne null.<br/>
	 * - Vérifie que fournirDateFormattee(..., null) retourne null.<br/>
	 */
	@Test
	public void testFournirDateFormattee() {
		
		/* Vérifie que fournirDateFormattee(null,...) retourne null. */
		assertNull("fournirDateFormattee(null,...) doit retourner null : "
				,  GestionnaireFichiers.fournirDateFormattee(
						null, DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE));
		
		/* Vérifie que fournirDateFormattee(..., null) retourne null. */
		assertNull("fournirDateFormattee(..., null) doit retourner null : "
				,  GestionnaireFichiers.fournirDateFormattee(
						new Date(), null));
		
		final Calendar calendar = new GregorianCalendar(LOCALE_FR_FR);
		calendar.setLenient(false);
		calendar.set(1961, 1, 25);
		final Date maDate = calendar.getTime();
		
		System.out.println(GestionnaireFichiers.fournirDateFormattee(maDate, DF_DATE_FRANCAISE));
	} // Fin de testFournirDateFormattee().________________________________
	
	
	
	/**
	 * method testSubstituerSautLignePlateforme() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testSubstituerSautLignePlateforme() {
		assertTrue("BIDON : ", 1 == 1);
	} // Fin de testSubstituerSautLignePlateforme()._______________________


	
	/**
	 * method testSubstituerSautLigne() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testSubstituerSautLigne() {
		assertTrue("BIDON : ", 1 == 1);
	} // Fin de testSubstituerSautLigne()._________________________________
	

	
	/**
	 * method testAfficherSautLigne() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testAfficherSautLigne() {
		assertTrue("BIDON : ", 1 == 1);
	} // Fin de testAfficherSautLigne().___________________________________
	

	
	/**
	 * method testAffichierTableauFiles() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testAffichierTableauFiles() {
		assertTrue("BIDON : ", 1 == 1);
	} // Fin de testAffichierTableauFiles()._______________________________
	
	
} // FIN DE LA CLASSE GestionnaireFichiersTest.------------------------------
