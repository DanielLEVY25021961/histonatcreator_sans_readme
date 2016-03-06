package levy.daniel.application.util.gestionnairesdates;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * class GestionnaireDatesTest :<br/>
 * Test JUnit de la classe GestionnaireDates.<br/>
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
 * @since 12 févr. 2016
 *
 */
public class GestionnaireDatesTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * LOCALE_SYSTEM : Locale :<br/>
	 * Locale de la plateforme.<br/>
	 * Locale.getDefault().<br/>
	 */
	public static final Locale LOCALE_SYSTEM = Locale.getDefault();
	
	
	/**
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("fr", "FR").<br/>
	 */
	public static final Locale LOCALE_FR_FR = new Locale("fr", "FR");

	
	/**
	 * LOCALE_EN_US : Locale :<br/>
	 * new Locale("en", "US").<br/>
	 */
	public static final Locale LOCALE_EN_US = new Locale("en", "US");

	
	/**
	 * LOCALE_EN_GB : Locale :<br/>
	 * new Locale("en", "GB").<br/>
	 */
	public static final Locale LOCALE_EN_GB = new Locale("en", "GB");

	
	/**
	 * DF_DATE_LEXICOGRAPHIQUE : DateFormat :<br/>
	 * Format lexicographique des dates 
	 * comme "2012-01-16" pour le
	 * 16 Janvier 2012.<br/>
	 */
	public static final DateFormat DF_DATE_LEXICOGRAPHIQUE 
		= new SimpleDateFormat("yyyy-MM-dd", LOCALE_SYSTEM);

	
	/**
	 * DF_DATETIME_LEXICOGRAPHIQUE : DateFormat :<br/>
	 * Format lexicographique des dates avec time 
	 * comme "2012-01-16_18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	public static final DateFormat DF_DATETIME_LEXICOGRAPHIQUE 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", LOCALE_FR_FR);
	
	
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
	 * DF_DATETIME_FRANCAISE : DateFormat :<br/>
	 * Format classique des dates-heures françaises comme
	 * '25/02/1961-12:27:07'.<br/>
	 */
	public static final DateFormat DF_DATETIME_FRANCAISE 
	= new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss", LOCALE_FR_FR);
	
	
	/**
	 * DF_DATETIMEMILLI_FRANCAISE : DateFormat :<br/>
	 * Format des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 */
	public static final DateFormat DF_DATETIMEMILLI_FRANCAISE 
	= new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss.SSS", LOCALE_FR_FR);
	

	/**
	 * DF_DATE_AMERICAINE : DateFormat :<br/>
	 * Format classique des dates américaines comme 
	 * '02-25-1961'.<br/>
	 */
	public static final DateFormat DF_DATE_AMERICAINE 
	= new SimpleDateFormat("MM-dd-yyyy", LOCALE_EN_US);
	
	
	/**
	 * DF_DATE_COMPLETE_FRANCAISE : DateFormat :<br/>
	 * Format complet des dates françaises comme
	 * 'samedi 25 février 1961'.<br/>
	 */
	public static final DateFormat DF_DATE_COMPLETE_FRANCAISE 
		= new SimpleDateFormat("EEEE' 'dd' 'MMMM' 'yyyy"
			, LOCALE_FR_FR);

	
	/**
	 * DF_DATE_COMPLETE_AMERICAINE : DateFormat :<br/>
	 * Format complet des dates américaines comme
	 * 'Saturday, February 25, 1961'.<br/>
	 */
	public static final DateFormat DF_DATE_COMPLETE_AMERICAINE 
		= DateFormat.getDateInstance(DateFormat.FULL, LOCALE_EN_US);

	
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
	 * DF_JOUR_MOIS_ANNEE_ECRITS_HEURE_MINUTE_SECONDE : DateFormat :<br/>
	 * .<br/>
	 */
	public static final DateFormat DF_JOUR_MOIS_ANNEE_ECRITS_HEURE_MINUTE_SECONDE 
		= new SimpleDateFormat("EEEE' 'dd' 'MMMM' 'yyyy:HH-mm-ss", LOCALE_FR_FR);

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
			.getLog(GestionnaireDatesTest.class);
	
	// *************************METHODES************************************/

	 /**
	 * method CONSTRUCTEUR GestionnaireDatesTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public GestionnaireDatesTest() {		
		/* Instanciation de la Super-Classe. */
		super();		
	} // Fin de GestionnaireDatesTest().___________________________________
	

	
	/**
	 * method testConvertirDateFormattee() :<br/>
	 * Teste la méthode convertirDateFormattee(...).<br/>
	 * <br/>
	 * - Vérifie que convertirDateFormattee(null,..., ...) retourne null.<br/>
	 * - Vérifie que convertirDateFormattee(blank,..., ...) retourne null.<br/>
	 * - Vérifie que convertirDateFormattee(..., null, ...) retourne null.<br/>
	 * - Vérifie que convertirDateFormattee(dateString non plausible, ..., ...) 
	 * retourne null.<br/>
	 * - Vérifie que la méthode retourne 
	 * la bonne date convenablement formattée.<br/>
	 * <br/>
	 */
	@Test
	public void testConvertirDateFormattee() {
		
		/* Vérifie que convertirDateFormattee(null,..., ...) retourne null. */
		assertNull("convertirDateFormattee(null,...,...) doit retourner null : "
				,  GestionnaireDates.convertirDateFormattee(
						null, DF_ANNEE, DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE));
		
		/* Vérifie que convertirDateFormattee(blank,..., ...) retourne null. */
		assertNull("convertirDateFormattee(blank,...,...) doit retourner null : "
				,  GestionnaireDates.convertirDateFormattee(
						" ", DF_ANNEE, DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE));
		
		/* Vérifie que convertirDateFormattee(..., null, ...) retourne null. */
		assertNull("convertirDateFormattee(..., null,...) doit retourner null : "
				,  GestionnaireDates.convertirDateFormattee(
						"25/02/1961", null, DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE));
		
		/* Vérifie que convertirDateFormattee(dateString, mauvais formatteur entrée, ...) retourne null. */
		assertNull("convertirDateFormattee(dateString, mauvais formatteur entrée,...) doit retourner null : "
				,  GestionnaireDates.convertirDateFormattee(
						"25/02/1961", DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE, DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE));
		
		/* Vérifie que convertirDateFormattee(dateString non plausible, ..., ...) retourne null. */
		assertNull("convertirDateFormattee(dateString non plausible, ..., ...) doit retourner null : "
				,  GestionnaireDates.convertirDateFormattee(
						"30/02/1961", DF_DATE_FRANCAISE, DF_DATE_COMPLETE_FRANCAISE));
		
		/* Vérifie que la méthode retourne la bonne date. */
		final String resultat1 
		= GestionnaireDates.convertirDateFormattee(
				"25/02/1961", DF_DATE_FRANCAISE, DF_DATE_COMPLETE_FRANCAISE);
		
		assertEquals("25/02/1961, DF_DATE_FRANCAISE, DF_DATE_COMPLETE_FRANCAISE) doit retourner samedi 25 février 1961 : "
				, "samedi 25 février 1961"
					, resultat1);
		
		final String resultat2 
		= GestionnaireDates.convertirDateFormattee(
				"25/02/1961", DF_DATE_FRANCAISE, DF_ANNEE);
		
		assertEquals("25/02/1961, DF_DATE_FRANCAISE, DF_ANNEE) doit retourner 1961 : "
				, "1961"
					, resultat2);
		
		final String resultat3 
		= GestionnaireDates.convertirDateFormattee(
				"02-25-1961", DF_DATE_AMERICAINE, DF_DATE_COMPLETE_AMERICAINE);
		
		assertEquals("02-25-1961, DF_DATE_AMERICAINE, DF_DATE_COMPLETE_AMERICAINE) doit retourner Saturday, February 25, 1961 : "
				, "Saturday, February 25, 1961"
					, resultat3);
		
		final String resultat4 
		= GestionnaireDates.convertirDateFormattee(
				"25/02/1961", DF_DATE_FRANCAISE, DF_DATE_AMERICAINE);
		
		assertEquals("25/02/1961, DF_DATE_FRANCAISE, DF_DATE_AMERICAINE) doit retourner 02-25-1961 : "
				, "02-25-1961"
					, resultat4);
				
	} // Fin de convertirDateFormattee.____________________________________
	
	
	
	/**
	 * method testFournirDateFormattee() :<br/>
	 * Teste la méthode fournirDateFormattee(Date, DateFormat).<br/>
	 * <br/>
	 * - Vérifie que fournirDateFormattee(null,...) retourne null.<br/>
	 * - Vérifie que fournirDateFormattee(..., null) retourne null.<br/>
	 * - Vérifie que la méthode retourne la bonne date 
	 * convenablement formattée.<br/>
	 */
	@Test
	public void testFournirDateFormattee() {
		
		/* Vérifie que fournirDateFormattee(null,...) retourne null. */
		assertNull("fournirDateFormattee(null,...) doit retourner null : "
				,  GestionnaireDates.fournirDateFormattee(
						null, DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE));
		
		/* Vérifie que fournirDateFormattee(..., null) retourne null. */
		assertNull("fournirDateFormattee(..., null) doit retourner null : "
				,  GestionnaireDates.fournirDateFormattee(
						new Date(), null));
		
		/* fournit une Date (ATTENTION, le mois est 0-based). */
		final Calendar calendar = new GregorianCalendar(LOCALE_FR_FR);
		calendar.setLenient(false);
		calendar.set(1961, 1, 25);
		final Date maDate = calendar.getTime();
		
		/* Vérifie que la méthode retourne la bonne date. */
		final String resultat1 
			= GestionnaireDates.fournirDateFormattee(maDate, DF_DATE_FRANCAISE);
		assertEquals("doit retourner 25/02/1961 :"
				, "25/02/1961"
					, resultat1);
		
		final String resultat2 
		= GestionnaireDates.fournirDateFormattee(maDate, sSdfyyyyMMdd);
		assertEquals("doit retourner 1961-02-25 : "
				, "1961-02-25"
					, resultat2);
		
		final String resultat3 
		= GestionnaireDates.fournirDateFormattee(maDate, DF_DATE_AMERICAINE);
		assertEquals("doit retourner 02-25-1961 : "
				, "02-25-1961"
					, resultat3);
		
	} // Fin de testFournirDateFormattee().________________________________
	
	

	/**
	 * method testFournirDateFormatteeInt() :<br/>
	 * Teste la méthode fournirDateFormatteeInt(....).<br/>
	 * <br/>
	 * - Vérifie que fournirDateFormatteeInt(......., DateFormat null) 
	 * retourne null.<br/>
	 * - Vérifie que fournirDateFormatteeInt(jour = 0,......, ...) 
	 * retourne null.<br/>
	 * Vérifie que fournirDateFormatteeInt(25, 1, 2016, 22, 59, 59, DateFormat) 
	 * retourne le bon résultat.<br/>
	 * <br/>
	 */
	@Test
	public void testFournirDateFormatteeInt() {
		
		/* Vérifie que fournirDateFormatteeInt(......., DateFormat null) retourne null. */
		assertNull("fournirDateFormatteeInt(......., DateFormat null) doit retourner null : "
				,  GestionnaireDates
					.fournirDateTimeFormatteeInt(0, 0, 0, 0, 0, 0, null));
		
		/* Vérifie que fournirDateFormatteeInt(jour = 0,......, ...) retourne null. */
		final String resultat1 
		= GestionnaireDates.fournirDateTimeFormatteeInt(
				0, 01, 3, 0, 0, 0
					, DF_JOUR_MOIS_ANNEE_ECRITS_HEURE_MINUTE_SECONDE);		
		assertNull(
				"fournirDateFormatteeInt(jour = 0,......, ...) doit retourner null : "
					, resultat1);
		
		/* Vérifie que fournirDateFormatteeInt(jour = 30, mois=février, ...., ...) retourne null. */
		final String resultat2 
		= GestionnaireDates.fournirDateTimeFormatteeInt(
				30, 01, 3, 0, 0, 0
					, DF_JOUR_MOIS_ANNEE_ECRITS_HEURE_MINUTE_SECONDE);		
		assertNull(
				"fournirDateFormatteeInt(jour = 0,  mois=février, ......, ...) doit retourner null : "
					, resultat2);
		
		/* Vérifie que fournirDateFormatteeInt(25, 1, 2016, 22, 59, 59, DateFormat) retourne le bon résultat. */
		final String resultat3 
			= GestionnaireDates.fournirDateTimeFormatteeInt(
					25, 1, 2016, 22, 59, 59
						, DF_JOUR_MOIS_ANNEE_ECRITS_HEURE_MINUTE_SECONDE);		
		assertEquals("doit retourner jeudi 25 février 2016:22-59-59 : "
				, "jeudi 25 février 2016:22-59-59"
					, resultat3);
		
		final String resultat4 = 
					GestionnaireDates.fournirDateTimeFormatteeInt(
							25, 1, 2016, 22, 59, 59
								, DF_DATE_AMERICAINE);
		assertEquals("doit retourner 02-25-2016 : "
				, "02-25-2016"
					, resultat4);
		
	} // Fin de testFournirDateFormatteeInt()._____________________________


	
	/**
	 * method testFournirDateTimeAvecInt() :<br/>
	 * - Vérifie que fournirDateTimeAvecInt(date non plausible, ...., ...) 
	 * retourne null.<br/>
	 * - Vérifie que fournirDateTimeAvecInt(25, 1, 1961, 12, 27, 7) 
	 * retourne la bonne date.<br/>
	 * <br/>
	 */
	@Test
	public void testFournirDateTimeAvecInt() {
		
		/* Vérifie que fournirDateTimeAvecInt(date non plausible, ...., ...) retourne null. */
		final Date resultat1 
			= GestionnaireDates.fournirDateTimeAvecInt(31, 1, 1961, 0, 0, 0);
		assertNull(
				"fournirDateTimeAvecInt(31, 1, 1961, 0, 0, 0) doit retourner null : "
					, resultat1);
		
		/* Vérifie que fournirDateTimeAvecInt(25, 1, 1961, 12, 27, 7) retourne la bonne date. */
		final Date resultat2 
		= GestionnaireDates.fournirDateTimeAvecInt(25, 1, 1961, 12, 27, 7);
		final String resultat2Formatte 
		= GestionnaireDates.fournirDateFormattee(
				resultat2, DF_DATETIME_LEXICOGRAPHIQUE);
		assertEquals("bonne date : "
				, "1961-02-25_12-27-07"
					, resultat2Formatte);
		
		final Date resultat3 
		= GestionnaireDates.fournirDateAvecInt(25, 1, 1961);
		final String resultat3Formatte 
		= GestionnaireDates.fournirDateFormattee(
				resultat3, DF_DATETIME_LEXICOGRAPHIQUE);
		assertEquals("bonne date : "
				, "1961-02-25_00-00-00"
					, resultat3Formatte);
		
	} // Fin de testFournirDateTimeAvecInt().______________________________

	
	
	/**
	 * method testFournirDateAvecString() :<br/>
	 * Teste la méthode fournirDateAvecString(...).<br/>
	 * <br/>
	 * - Vérifie que fournirDateAvecString(null, ...) retourne null.<br/>
	 * - Vérifie que fournirDateAvecString(blank, ...) retourne null.<br/>
	 * - Vérifie que fournirDateAvecString(..., null) retourne null.<br/>
	 * - Vérifie que fournirDateAvecString(dateString, mauvais formatteur entrée) retourne null.<br/>
	 * - Vérifie que fournirDateAvecString(dateString non plausible, ...) retourne null.<br/>
	 * - - Vérifie que fournirDateAvecString("25/02/1961-12:27:7") 
	 * retourne la bonne date.<br/>
	 */
	@Test
	public void testFournirDateAvecString() {
		
		/* Vérifie que fournirDateAvecString(null, ...) retourne null. */
		assertNull("fournirDateAvecString(null, ...) doit retourner null : "
				,  GestionnaireDates.fournirDateAvecString(
						null, DF_ANNEE));
		
		/* Vérifie que fournirDateAvecString(blank, ...) retourne null. */
		assertNull("fournirDateAvecString(blank, ...) doit retourner null : "
				,  GestionnaireDates.fournirDateAvecString(
						" ", DF_ANNEE));
		
		/* Vérifie que fournirDateAvecString(..., null) retourne null. */
		assertNull("fournirDateAvecString(..., null) doit retourner null : "
				,  GestionnaireDates.fournirDateAvecString(
						"25/02/1961", null));
		
		/* Vérifie que fournirDateAvecString(dateString, mauvais formatteur entrée) retourne null. */
		assertNull("fournirDateAvecString(dateString, mauvais formatteur entrée) doit retourner null : "
				,  GestionnaireDates.fournirDateAvecString(
						"25/02/1961", DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE));
		
		/* Vérifie que fournirDateAvecString(dateString non plausible, ...) retourne null. */
		assertNull("fournirDateAvecString(dateString non plausible, ..., ...) doit retourner null : "
				,  GestionnaireDates.fournirDateAvecString(
						"30/02/1961", DF_DATE_FRANCAISE));
		
		/* Vérifie que la méthode retourne la bonne date. */
		final Date resultat1 
			= GestionnaireDates.fournirDateAvecString(
					"25/02/1961-12:27:07", DF_DATETIME_FRANCAISE);
		assertEquals("doit être equals à 25/02/1961-12:27:07 : "
				, "25/02/1961-12:27:07"
				, GestionnaireDates.afficherDateAvecFormat(resultat1, DF_DATETIME_FRANCAISE));
		
	} // Fin de testFournirDateAvecString()._______________________________
	

	
	/**
	 * method testExtraireGrandeurs() :<br/>
	 * Teste la méthode extraireGrandeursDate(...).<br/>
	 * <br/>
	 * - vérifie que la méthode fournit les bonnes valeurs.<br/>
	 */
	@Test
	public void testExtraireGrandeurs() {
		
		final Date date 
		= GestionnaireDates.fournirDateAvecString(
				"25/02/1961-14:27:07.251", DF_DATETIMEMILLI_FRANCAISE);
		
		final int jour = GestionnaireDates.extraireJour(date);
		final int mois = GestionnaireDates.extraireMois(date);
		final int annee = GestionnaireDates.extraireAnnee(date);
		final int heure = GestionnaireDates.extraireHeure(date);
		final int minute = GestionnaireDates.extraireMinute(date);
		final int seconde = GestionnaireDates.extraireSeconde(date);
		final int milliseconde = GestionnaireDates.extraireMilliseconde(date);
		
		/* vérifie que la méthode fournit les bonnes valeurs. */
		assertEquals("jour == 25 : ", 25, jour);
		assertEquals("mois == 2 : ", 2, mois);
		assertEquals("annee == 1961 : ", 1961, annee);
		assertEquals("heure == 14 : ", 14, heure);
		assertEquals("minute == 27 : ", 27, minute);
		assertEquals("seconde == 7 : ", 7, seconde);
		assertEquals("milliseconde == 251 : ", 251, milliseconde);
		
	} // Fin de testExtraireGrandeurs().___________________________________
	
	
	
} // FIN DE LA CLASSE GestionnaireDatesTest.---------------------------------
