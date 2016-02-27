package levy.daniel.application.util.gestionnairesdates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;



import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class GestionnaireDates :<br/>
 * Classe utillitaire contenant des méthodes statiques permettant :<br/>
 * - de convertir une date d'un format dans un autre : 
 * convertirDateFormattee(...).<br/>
 * - de fournir des dates sous forme de String formattées : 
 * fournirDateFormattee(...) et fournirDateTimeFormatteeInt(...).<br/>
 * - d'instancier des java.util.Date : 
 * fournirDateTimeAvecInt(...) et fournirDateAvecString(...).<br/>
 * - d'extraire des grandeurs (jour, mois, ... d'une Date : 
 * extraireGrandeursDate(...).<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code>
 * // resultat contient "samedi 25 février 1961".<br/>
 * final String resultat = GestionnaireDates.convertirDateFormattee(
 * "25/02/1961", DF_DATE_FRANCAISE, DF_DATE_COMPLETE_FRANCAISE);<br/>
 * <br/>
 * // retourne la date sous forme de String formattée "25/02/1961" 
 * avec maDate java.util.Date calée sur le 25/02/1961.<br/>
 * final String resultat1 = GestionnaireDates.
 * fournirDateFormattee(maDate, DF_DATE_FRANCAISE);<br/>
 * <br/>
 * // retourne une java.util.Date.<br/>
 * final Date resultat1 = GestionnaireDates
 * .fournirDateAvecString("25/02/1961-12:27:07", DF_DATETIME_FRANCAISE);<br/>
 * </code>
 *<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * java.util.Date, convertir formats de dates, DateFormat
 * , SimpleDateFormat, DateFormat.parse(String pS)
 * , DateFormat.format(Date pDate)<br/>
 * DateFormat.setLenient(false), Extraire date de Calendar<br/>
 * fournir date, fournirDate(), <br/>
 * Locale de la plateforme, Locale.getDefault(),<br/>
 * DateFormat.getDateInstance(DateFormat.Constante, Locale),<br/>
 * L'heure normale d'Europe centrale (HNEC) 
 * (en anglais Central European Time : CET) 
 * est l'un des noms du fuseau horaire UTC+1, 
 * en avance d'une heure par rapport au temps universel coordonné (UTC).<br/>
 * formatter millisecondes, SSS, <br/>
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
public final class GestionnaireDates {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * CLASSE_GESTIONNAIRE_DATES : String :<br/>
	 * "Classes GestionnaireDates".<br/>
	 */
	public static final String CLASSE_GESTIONNAIRE_DATES 
		= "Classes GestionnaireDates";

	
	/**
	 * METHODE_CONVERTIRDATEFORMATTEE : String :<br/>
	 * "Méthode convertirDateFormattee(String date, DateFormat entree, DateFormat Sortie)".<br/>
	 */
	public static final String METHODE_CONVERTIRDATEFORMATTEE 
		= "Méthode convertirDateFormattee(String date, DateFormat entree, DateFormat Sortie)";

	
	/**
	 * METHODE_FOURNIRDATEFORMATTEEINT : String :<br/>
	 * "Méthode fournirDateTimeFormatteeInt(....)".<br/>
	 */
	public static final String METHODE_FOURNIRDATEFORMATTEEINT 
		= "Méthode fournirDateTimeFormatteeInt(....)";

	
	/**
	 * METHODE_FOURNIRDATETIMEAVECINT : String :<br/>
	 * "Méthode fournirDateTimeAvecInt(....)".<br/>
	 */
	public static final String METHODE_FOURNIRDATETIMEAVECINT 
		= "Méthode fournirDateTimeAvecInt(....)";
	
	/**
	 * METHODE_FOURNIRDATEAVECSTRING : String :<br/>
	 * "Méthode fournirDateAvecString(
	 * String pString, DateFormat pDateFormat)".<br/>
	 */
	public static final String METHODE_FOURNIRDATEAVECSTRING 
		= "Méthode fournirDateAvecString(String pString, DateFormat pDateFormat)";
	
	/**
	 * METHODE_EXTRAIREGRANDEURSDATE : String :<br/>
	 * "Méthode extraireGrandeursDate(Date pDate, Locale pLocale)".<br/>
	 */
	public static final String METHODE_EXTRAIREGRANDEURSDATE 
		= "Méthode extraireGrandeursDate(Date pDate, Locale pLocale)";
	
	
	/**
	 * MESSAGE_MAUVAIS_DATEFORMAT_ENTREE : String :<br/>
	 * "La date fournie en entrée n'est pas plausible ou ne correspond pas au DateFormat en entrée : ".<br/>
	 */
	public static final String MESSAGE_MAUVAIS_DATEFORMAT_ENTREE 
	= "La date fournie en entrée n'est pas plausible ou ne correspond pas au DateFormat en entrée : ";

	
	/**
	 * MESSAGE_MAUVAISE_DATE_ENTREE : String :<br/>
	 * "La date fournie en entrée ne correspond pas une Date plausible : ".<br/>
	 */
	public static final String MESSAGE_MAUVAISE_DATE_ENTREE 
	= "La date fournie en entrée ne correspond pas une Date plausible : ";
	
	
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
	 * "yyyy-MM-dd".<br/>
	 */
	public static final DateFormat DF_DATE_LEXICOGRAPHIQUE 
		= new SimpleDateFormat("yyyy-MM-dd", LOCALE_SYSTEM);
	
	
	/**
	 * DF_DATETIME_LEXICOGRAPHIQUE : DateFormat :<br/>
	 * Format lexicographique des dates avec time 
	 * comme "2012-01-16_18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 * "yyyy-MM-dd_HH-mm-ss".<br/>
	 */
	public static final DateFormat DF_DATETIME_LEXICOGRAPHIQUE 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", LOCALE_FR_FR);
	

	/**
	 * DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE : DateFormat :<br/>
	 * Format concentré des dates avec heures et secondes
	 * comme "2012-01-16_18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 * "yyyy-MM-dd_HH-mm-ss".<br/>
	 */
	public static final DateFormat DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", LOCALE_FR_FR);
	

	
	/**
	 * DF_DATE_FRANCAISE : DateFormat :<br/>
	 * Format classique des dates françaises comme
	 * '25/02/1961'.<br/>
	 * "dd/MM/yyyy".<br/>
	 */
	public static final DateFormat DF_DATE_FRANCAISE 
	= new SimpleDateFormat("dd/MM/yyyy", LOCALE_FR_FR);
	
	
	/**
	 * DF_DATETIME_FRANCAISE : DateFormat :<br/>
	 * Format classique des dates-heures françaises comme
	 * '25/02/1961-12:27:07'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss".<br/>
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
	 * DF_DATE_COMPLETE_FRANCAISE : DateFormat :<br/>
	 * Format complet des dates françaises comme
	 * 'samedi 25 février 1961'.<br/>
	 * "EEEE' 'dd' 'MMMM' 'yyyy".<br/>
	 */
	public static final DateFormat DF_DATE_COMPLETE_FRANCAISE 
		= new SimpleDateFormat("EEEE' 'dd' 'MMMM' 'yyyy"
			, LOCALE_FR_FR);

	
	/**
	 * DF_DATE_AMERICAINE : DateFormat :<br/>
	 * Format classique des dates américaines comme 
	 * '02-25-1961'.<br/>
	 * "MM-dd-yyyy".<br/>
	 */
	public static final DateFormat DF_DATE_AMERICAINE 
	= new SimpleDateFormat("MM-dd-yyyy", LOCALE_EN_US);

	
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
	 * "MMMM' 'yyyy".<br/>
	 */
	public static final DateFormat DF_MOIS_ANNEE 
		= new SimpleDateFormat("MMMM' 'yyyy"
			, LOCALE_FR_FR);

	
	/**
	 * DF_MOIS_ANNEE_SIMPLE : DateFormat :<br/>
	 * Format des dates françaises avec mois simplifié-année comme
	 * '02/1961'.<br/>
	 * "MM/yyyy".<br/>
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
	 * "yyyy-MM-dd' à 'HH' heures,'mm' minutes,'ss' secondes'".<br/>
	 */
	public static final DateFormat DF_DATE_AVEC_HEURE_MINUTE_SECONDE 
	= new SimpleDateFormat("yyyy-MM-dd' " 
	+ "à 'HH' heures,'mm' minutes,'ss' secondes'", LOCALE_FR_FR);
	
	 
	/**
	 * DF_DATE_HEURE_MINUTE_SECONDE : DateFormat :<br/>
	 * Format concentré des dates avec heures et secondes
	 * comme "2012-01-16:18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 * "yyyy-MM-dd:HH-mm-ss".<br/>
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
	DF_DATE_LEXICOGRAPHIQUE.setLenient(false);
	DF_DATETIME_LEXICOGRAPHIQUE.setLenient(false);
	DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE.setLenient(false);
	DF_DATE_FRANCAISE.setLenient(false);
	DF_DATETIME_FRANCAISE.setLenient(false);
	DF_DATE_COMPLETE_FRANCAISE.setLenient(false);
	DF_DATE_AMERICAINE.setLenient(false);
	DF_DATE_COMPLETE_AMERICAINE.setLenient(false);
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
	 * SEP_MOINS : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEP_MOINS = " - ";

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(GestionnaireDates.class);
	

	// *************************METHODES************************************/
	
	
	/**
	 * method CONSTRUCTEUR GestionnaireDates() :
	 * Constructeur private pour empêcher l'instanciation.
	 */
	private GestionnaireDates() {
		super();
	} // Fin de CONSTRUCTEUR GestionnaireDates().__________________________


	
	/**
	 * method convertirDateFormattee(
	 * String pDateString
	 * , DateFormat pDateFormatEntree
	 * , DateFormat pDateFormatSortie) :<br/>
	 * Convertit une String pDateString correspondant à une date formattée 
	 * avec le DateFormat pDateFormatEntree 
	 * en une String formattée avec le DateFormat pDateFormatSortie.<br/>
	 * <br/>
	 * La String pDateString doit être une date plausible exprimée 
	 * dans le bon format (pDateFormatEntree). 
	 * Sinon, la méthode retourne null.<br/>
	 * <br/>
	 * Par exemple : <br/>
	 * <code>GestionnaireDates.convertirDateFormattee
	 * ("25/02/1961", DF_DATE_FRANCAISE, DF_ANNEE)</code> retourne "1961".<br/>
	 * "25/02/1961" en entrée correspond à pDateFormatEntree 
	 * = DF_DATE_FRANCAISE (SimpleDateFormat("dd/MM/yyyy", LOCALE_FR_FR)).<br/>
	 * "1961" en sortie correspond à pDateFormatSortie 
	 * = DF_ANNEE (SimpleDateFormat("yyyy", LOCALE_FR_FR)).<br/>
	 * <br/>
	 * Autre exemple : <br/>
	 * <code>GestionnaireDates.convertirDateFormattee(
	 * "25/02/1961", DF_DATE_FRANCAISE, DF_DATE_AMERICAINE)</code> 
	 * retourne 02-25-1961<br/>
	 * <br/>
	 * - retourne null si pDateString est blank.<br/>
	 * - retourne null si pDateFormatEntree == null.<br/>
	 * - retourne null si pDateFormatSortie == null.<br/>
	 * - retourne null si pDateString n'est pas plausible (et LOG INFO).<br/> 
	 * - retourne null si pDateFormatEntree ne peut pas parser pString 
	 * (et LOG INFO).<br/>
	 * <br/>
	 *
	 * @param pDateString : String : String respectant pDateFormatEntree 
	 * comme "25/02/1961" pour le DateFormat DF_DATE_FRANCAISE 
	 * (SimpleDateFormat("dd/MM/yyyy", LOCALE_FR_FR)).<br/>
	 * @param pDateFormatEntree : DateFormat : DateFormat 
	 * conforme à pDateString.<br/>
	 * @param pDateFormatSortie : DateFormat : DateFormat de sortie.<br/>
	 * 
	 * @return : String : String pour affichage formatté de pDate 
	 * selon pDateFormatSortie.<br/>
	 */
	public static String convertirDateFormattee(
			final String pDateString
				, final DateFormat pDateFormatEntree
					, final DateFormat pDateFormatSortie) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireDates.class) {
			
			/* retourne null si pDateString est blank. */
			if(StringUtils.isBlank(pDateString)) {
				return null;
			}
			
			/* retourne null si pDateFormatEntree == null. */
			if (pDateFormatEntree == null) {
				return null;
			}
			
			/* retourne null si pDateFormatSortie == null. */
			if (pDateFormatSortie == null) {
				return null;
			}
			
			Date dateEntree = null;
			String dateConvertie = null;
			
			try {
				
				/* parse pDateString pour obtenir une java.util.Date. */
				dateEntree = pDateFormatEntree.parse(pDateString);
				
				/* convertit la java.util.Date au format pDateFormatSortie. */
				dateConvertie = pDateFormatSortie.format(dateEntree);
				
			} catch (ParseException parseExc) {
								
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_GESTIONNAIRE_DATES
						, METHODE_CONVERTIRDATEFORMATTEE
						, MESSAGE_MAUVAIS_DATEFORMAT_ENTREE
						, "date fournie sous la forme = " 
						+ pDateString 
						+ "   - Exception : " 
						+ parseExc.getMessage());
				
				/* retourne null si pDateFormatEntree 
				 * ne peut pas parser pString (et LOG INFO). */
				return null;
			}
			
			return dateConvertie;
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de convertirDateFormattee(
	 // String pDateString
	 // , DateFormat pDateFormatEntree
	 // , DateFormat pDateFormatSortie).___________________________________
	

	
	/**
	 * method fournirDateCouranteFormatteeFrancais() :<br/>
	 * Retourne une String représentant la java.util.Date date system 
	 * au format DF_DATE_FRANCAISE (dd/MM/yyyy).<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * retourne "14/02/2016".<br/>
	 * <br/>
	 *
	 * @return : String : La date courante au format dd/MM/yyyy.<br/>
	 */
	public static String fournirDateCouranteFormatteeFrancais() {
		return fournirDateFormattee(new Date(), DF_DATE_FRANCAISE);
	} // Fin de fournirDateCouranteFormatteeFrancais().____________________
	

	
	/**
	 * method fournirDateTimeCouranteFormatteeFrancais() :<br/>
	 * Retourne une String représentant la java.util.Date date system 
	 * au format DF_DATETIME_FRANCAISE (dd/MM/yyyy-HH:mm:ss).<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * retourne "14/02/2016-15:32:05".<br/>
	 * <br/>
	 *
	 * @return : String : La date courante au format dd/MM/yyyy-HH:mm:ss.<br/>
	 */
	public static String fournirDateTimeCouranteFormatteeFrancais() {
		return fournirDateFormattee(new Date(), DF_DATETIME_FRANCAISE);
	} // Fin de fournirDateTimeCouranteFormatteeFrancais().________________
	

	
	/**
	 * method fournirDateCouranteFormatteeLexico() :<br/>
	 * Retourne une String représentant la java.util.Date date system 
	 * au format DF_DATE_LEXICOGRAPHIQUE (yyyy-MM-dd).<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * retourne "2016-02-14".<br/>
	 * <br/>
	 *
	 * @return : String : La date courante au format yyyy-MM-dd.<br/>
	 */
	public static String fournirDateCouranteFormatteeLexico() {
		return fournirDateFormattee(new Date(), DF_DATE_LEXICOGRAPHIQUE);
	} // Fin de fournirDateCouranteFormatteeLexico().______________________
	

	
	/**
	 * method fournirDateTimeCouranteFormatteeLexico() :<br/>
	 * Retourne une String représentant la java.util.Date date system 
	 * au format DF_DATETIME_LEXICOGRAPHIQUE (yyyy-MM-dd_HH-mm-ss).<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * retourne "2016-02-14_15-52-50".<br/>
	 * <br/>
	 *
	 * @return : String : La date courante au format yyyy-MM-dd_HH-mm-ss.<br/>
	 */
	public static String fournirDateTimeCouranteFormatteeLexico() {
		return fournirDateFormattee(new Date(), DF_DATETIME_LEXICOGRAPHIQUE);
	} // Fin de fournirDateTimeCouranteFormatteeLexico().__________________
	

	
	/**
	 * method fournirDateFormattee(
	 * Date pDate
	 * , DateFormat pDateFormat) :<br/>
	 * Retourne une String représentant la java.util.Date pDate 
	 * au format pDateFormat.<br/>
	 * Par exemple :<br/>
	 * - Retourne la String "25/02/1961" 
	 * avec une Date au 25/02/1961 et un DateFormat 
	 * DF_DATE_FRANCAISE (
	 * new SimpleDateFormat("dd/MM/yyyy", LOCALE_FR_FR)).<br/>
	 * <br/>
	 * - retourne null si pDate == null.<br/>
	 * - retourne null si pDateFormat == null.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * @param pDateFormat : DateFormat.<br/>
	 * 
	 * @return : String : String pour affichage 
	 * formatté de pDate selon pDateFormat.<br/>
	 */
	public static String fournirDateFormattee(
			final Date pDate
				, final DateFormat pDateFormat) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireDates.class) {
			
			/* retourne null si pDate == null. */
			if(pDate == null) {
				return null;
			}
			
			/* retourne null si pDateFormat == null. */
			if(pDateFormat == null) {
				return null;
			}
			
			pDateFormat.setLenient(false);
			
			return pDateFormat.format(pDate);
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de fournirDateFormattee(
	 // Date pDate
	 // DateFormat pDateFormat).___________________________________________
	

	
	/**
	 * method fournirDateFormatteeInt(
	 * int pJour
	 * , int pMois
	 * , int pAnnee
	 * , DateFormat pDateFormat) :<br/>
	 * Retourne une String représentant une java.util.Date
	 * au format pDateFormat.<br/>
	 * Les paramètres entiers [jour; mois;année] 
	 * en entrée doivent correspondre à une date plausible, par exemple 
	 * [20; 2;2016] pour le 20/03/2016.<br/>
	 * Sinon la méthode retourne null.<br/>
	 * <br/>
	 * - retourne null si pDateFormat == null.<br/>
	 * - retourne null si les paramètres entrés 
	 * ne correspondent pas à une date plausible (et LOG INFO).<br/>
	 * <br/>
	 *
	 * @param pJour : int : le jour du mois (1-based). 
	 * Doit être >= 1 et compatible avec le nombre de jours du mois.<br/> 
	 * (par exemple 2 pour un 2 janvier et 31 pour un 31 janvier).<br/>
	 * @param pMois : int : le mois 0-BASED. 
	 * Doit être >= 0 et compatible avec le nombre 
	 * de jours du mois dans l'année.<br/> 
	 * par exemple 0 pour un mois de janvier, 1 pour un mois de février.<br/>
	 * @param pAnnee : int : l'année (1-based). Doit être >= 1.<br/>
	 * @param pDateFormat : DateFormat : le formatteur 
	 * pour la String en sortie.<br/>
	 * 
	 * @return : String : String pour affichage formatté de pDate 
	 * selon pDateFormat.<br/>
	 */
	public static String fournirDateFormatteeInt(
			final int pJour
				, final int pMois
					, final int pAnnee
						, final DateFormat pDateFormat) {
		
		return fournirDateTimeFormatteeInt(
				pJour, pMois, pAnnee, 0, 0, 0, pDateFormat);
		
	} // Fin de fournirDateFormatteeInt(COMPLET).__________________________

	
		
	/**
	 * method fournirDateTimeFormatteeInt(
	 * int pJour
	 * , int pMois
	 * , int pAnnee
	 * , int pHeures
	 * , int pMinutes
	 * , int pSecondes
	 * , DateFormat pDateFormat) :<br/>
	 * Retourne une String représentant une java.util.Date
	 * au format pDateFormat.<br/>
	 * Les paramètres entiers [jour; mois;année;heures;minutes;secondes] 
	 * en entrée doivent correspondre à une date plausible, par exemple 
	 * [20; 2;2016;10;24;32] pour le 20/03/2016 à 10h 24 mn et 32s.<br/>
	 * Sinon la méthode retourne null.<br/>
	 * <br/>
	 * - retourne null si pDateFormat == null.<br/>
	 * - retourne null si les paramètres entrés 
	 * ne correspondent pas à une date plausible (et LOG INFO).<br/>
	 * <br/>
	 *
	 * @param pJour : int : le jour du mois (1-based). 
	 * Doit être >= 1 et compatible avec le nombre de jours du mois.<br/> 
	 * (par exemple 2 pour un 2 janvier et 31 pour un 31 janvier).<br/>
	 * @param pMois : int : le mois 0-BASED. 
	 * Doit être >= 0 et compatible avec le nombre 
	 * de jours du mois dans l'année.<br/> 
	 * par exemple 0 pour un mois de janvier, 1 pour un mois de février.<br/>
	 * @param pAnnee : int : l'année (1-based). Doit être >= 1.<br/>
	 * @param pHeures : int : l'heure (1-based) avec 0 =< pHeures <24.<br/>
	 * @param pMinutes : int : les minutes (1-based) 
	 * avec 0 =< pMinutes <60.<br/>
	 * @param pSecondes : int : les secondes (1-based) 
	 * avec 0 =< pSecondes <60.<br/>
	 * @param pDateFormat : DateFormat : le formatteur 
	 * pour la String en sortie.<br/>
	 * 
	 * @return : String : String pour affichage formatté de pDate 
	 * selon pDateFormat.<br/>
	 */
	public static String fournirDateTimeFormatteeInt(
			final int pJour
				, final int pMois
					, final int pAnnee
						, final int pHeures
							, final int pMinutes
								, final int pSecondes
									, final DateFormat pDateFormat) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireDates.class) {
			
			/* retourne null si pDateFormat == null. */
			if(pDateFormat == null) {
				return null;
			}
			
			String resultat = null;
			
			try {
				/* Instancie un GregorianCalendar. */
				final Calendar calendar = new GregorianCalendar(LOCALE_FR_FR);
				
				/* Impose au Calendar de ne traiter que des dates compatibles
				 *  avec le calendrier 
				 *  (un 29 ou 30 Février ne doit pas être interprété). */
				calendar.setLenient(false);
				
				/* Positionne le Calendar. */
				calendar.set(
						pAnnee, pMois, pJour, pHeures, pMinutes, pSecondes);
				
				/* Extrait la date du Calendar. */
				final Date maDate = calendar.getTime();
				
				/* Impose au DateFormat de ne traiter que des dates compatibles 
				 * avec le calendrier 
				 * (un 29 ou 30 Février ne doit pas être interprété). */
				pDateFormat.setLenient(false);
				
				/* calcule la date formattée. */
				resultat = pDateFormat.format(maDate);
				
			} catch (IllegalArgumentException iae) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_GESTIONNAIRE_DATES
						, METHODE_FOURNIRDATEFORMATTEEINT
						, MESSAGE_MAUVAISE_DATE_ENTREE
						, "PROBLEME = " + iae.getMessage());
				
				/* retourne null si les paramètres entrés 
				 * ne correspondent pas à une date réelle (et LOG INFO). */
				return null;
				
			}
			
			return resultat;
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de fournirDateTimeFormatteeInt(COMPLET).______________________
	

	
	/**
	 * method fournirDateAvecInt(
	 * int pJour
	 * , int pMois
	 * , int pAnnee) :<br/>
	 * Retourne une java.util.Date
	 * en se basant sur un Gregorian Calendar et une Locale Française.<br/>
	 * Le Time est systématiquement à 00h00'00".<br/>
	 * <br/>
	 * Les paramètres entiers [jour; mois;année] 
	 * en entrée doivent correspondre à une date plausible, par exemple 
	 * [20; 2;2016] pour le 20/03/2016 à 00h 00 mn et 00s.<br/>
	 * Sinon la méthode retourne null (et LOG INFO).<br/>
	 * <br/>
	 * Par exemple :br/>
	 * <code>GestionnaireDates.fournirDateAvecInt(
	 * 25, 1, 1961);</code> 
	 * retourne une java.util.Date calée au 25/02/1961 à 00h00'00".<br/>
	 * <br/>
	 *
	 * @param pJour : int : le jour du mois (1-based). 
	 * Doit être >= 1 et compatible avec le nombre de jours du mois.<br/> 
	 * (par exemple 2 pour un 2 janvier et 31 pour un 31 janvier).<br/>
	 * @param pMois : int : le mois 0-BASED. 
	 * Doit être >= 0 et compatible avec le nombre 
	 * de jours du mois dans l'année.<br/> 
	 * par exemple 0 pour un mois de janvier, 1 pour un mois de février.<br/>
	 * @param pAnnee : int : l'année (1-based). Doit être >= 1.<br/>
	 * 
	 * @return : java.util.Date : la Date voulue.<br/>
	 */
	public static Date fournirDateAvecInt(
			final int pJour
				, final int pMois
					, final int pAnnee) {
		
		return fournirDateTimeAvecInt(pJour, pMois, pAnnee, 0, 0, 0);
		
	} // Fin de fournirDateAvecInt(
	 // int pJour
	 // , int pMois
	 // , int pAnnee)._____________________________________________________
	
	
	
	/**
	 * method fournirDateTimeAvecInt(
	 * int pJour
	 * , int pMois
	 * , int pAnnee
	 * , int pHeures
	 * , int pMinutes
	 * , int pSecondes) :<br/>
	 * Retourne une java.util.Date
	 * en se basant sur un Gregorian Calendar et une Locale Française.<br/>
	 * <br/>
	 * Les paramètres entiers [jour; mois;année;heures;minutes;secondes] 
	 * en entrée doivent correspondre à une date plausible, par exemple 
	 * [20; 2;2016;10;24;32] pour le 20/03/2016 à 10h 24 mn et 32s.<br/>
	 * Sinon la méthode retourne null (et LOG INFO).<br/>
	 * <br/>
	 * Par exemple :br/>
	 * <code>GestionnaireDates.fournirDateTimeAvecInt(
	 * 25, 1, 1961, 12, 27, 7);</code> 
	 * retourne une java.util.Date calée au 25/02/1961 à 12h27'7".<br/>
	 * <br/>
	 *
	 * @param pJour : int : le jour du mois (1-based). 
	 * Doit être >= 1 et compatible avec le nombre de jours du mois.<br/> 
	 * (par exemple 2 pour un 2 janvier et 31 pour un 31 janvier).<br/>
	 * @param pMois : int : le mois 0-BASED. 
	 * Doit être >= 0 et compatible avec le nombre 
	 * de jours du mois dans l'année.<br/> 
	 * par exemple 0 pour un mois de janvier, 1 pour un mois de février.<br/>
	 * @param pAnnee : int : l'année (1-based). Doit être >= 1.<br/>
	 * @param pHeures : int : l'heure (1-based) avec 0 =< pHeures <24.<br/>
	 * @param pMinutes : int : les minutes (1-based) 
	 * avec 0 =< pMinutes <60.<br/>
	 * @param pSecondes : int : les secondes (1-based) 
	 * avec 0 =< pSecondes <60.<br/>
	 * 
	 * @return : java.util.Date : la Date voulue.<br/>
	 */
	public static Date fournirDateTimeAvecInt(
			final int pJour
				, final int pMois
					, final int pAnnee
						, final int pHeures
							, final int pMinutes
								, final int pSecondes) {
		
		return fournirDateTimeAvecInt(
				pJour, pMois, pAnnee, pHeures, pMinutes, pSecondes
					, new GregorianCalendar(LOCALE_FR_FR));
		
	} // Fin de fournirDateTimeAvecInt(COMPLET).___________________________
	

	
	/**
	 * method fournirDateTimeAvecInt(int pJour
	 * , int pMois
	 * , int pAnnee
	 * , int pHeures
	 * , int pMinutes
	 * , int pSecondes
	 * , Calendar pCalendar) :<br/>
	 * Retourne une java.util.Date 
	 * en se basant sur un Calendar pCalendar.<br/>
	 * <br/>
	 * Les paramètres entiers [jour; mois;année;heures;minutes;secondes] 
	 * en entrée doivent correspondre à une date plausible, par exemple 
	 * [20; 2;2016;10;24;32] pour le 20/03/2016 à 10h 24 mn et 32s.<br/>
	 * Sinon la méthode retourne null (et LOG INFO).<br/>
	 * <br/>
	 * Par exemple :br/>
	 * <code>GestionnaireDates.fournirDateTimeAvecInt(
	 * 25, 1, 1961, 12, 27, 7, new GregorianCalendar(LOCALE_FR_FR))</code> 
	 * retourne une java.util.Date calée au 25/02/1961 à 12h27'7".<br/>
	 * <br/>
	 * - Retourne null si pCalendar == null.<br/>
	 * <br/>
	 *
	 * @param pJour : int : le jour du mois (1-based). 
	 * Doit être >= 1 et compatible avec le nombre de jours du mois.<br/> 
	 * (par exemple 2 pour un 2 janvier et 31 pour un 31 janvier).<br/>
	 * @param pMois : int : le mois 0-BASED. 
	 * Doit être >= 0 et compatible avec le nombre 
	 * de jours du mois dans l'année.<br/> 
	 * par exemple 0 pour un mois de janvier, 1 pour un mois de février.<br/>
	 * @param pAnnee : int : l'année (1-based). Doit être >= 1.<br/>
	 * @param pHeures : int : l'heure (1-based) avec 0 =< pHeures <24.<br/>
	 * @param pMinutes : int : les minutes (1-based) 
	 * avec 0 =< pMinutes <60.<br/>
	 * @param pSecondes : int : les secondes (1-based) 
	 * avec 0 =< pSecondes <60.<br/>
	 * @param pCalendar : Calendar.<br/>
	 * 
	 * @return : java.util.Date : la Date voulue.<br/>
	 */
	public static Date fournirDateTimeAvecInt(
			final int pJour
				, final int pMois
					, final int pAnnee
						, final int pHeures
							, final int pMinutes
								, final int pSecondes
									, final Calendar pCalendar) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireDates.class) {
			
			/* Retourne null si pCalendar == null. */
			if (pCalendar == null) {
				return null;
			}
									
			/* Impose au Calendar de ne traiter que des dates compatibles
			 *  avec le calendrier 
			 *  (un 29 ou 30 Février ne doit pas être interprété). */
			pCalendar.setLenient(false);
			
			/* Positionne le Calendar. */
			pCalendar.set(pAnnee, pMois, pJour, pHeures, pMinutes, pSecondes);
			
			/* Extrait et retourne la date du Calendar. */
			try {
				
				return pCalendar.getTime();
				
			} catch (IllegalArgumentException iae) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_GESTIONNAIRE_DATES
						, METHODE_FOURNIRDATETIMEAVECINT
						, MESSAGE_MAUVAISE_DATE_ENTREE
						, "PROBLEME = " + iae.getMessage());
				
				/* retourne null si les paramètres entrés 
				 * ne correspondent pas à une date réelle (et LOG INFO). */
				return null;
				
			}
						
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de fournirDateTimeAvecInt(COMPLET).___________________________
	

	
	/**
	 * method fournirDateAvecString(
	 * String pDateString
	 * , DateFormat pDateFormat) :<br/>
	 * Retourne la java.util.Date pDate fournie 
	 * au format pDateFormat dans pDateString.<br/>
	 * Par exemple :<br/>
	 * <code>GestionnaireDates.fournirDateAvecString(
	 * "25/02/1961-12:27:07", DF_DATETIME_FRANCAISE)</code>
	 * retourne une java.util.Date calée le 25/02/1961 à 12h27'07".<br/>
	 * <br/>
	 * - retourne null si pDateString est blank.<br/>
	 * - retourne null si pDateFormat == null.<br/>
	 * - retourne null si la date pString n'est pas plausible 
	 * ou parsable par pDateFormat (et LOG INFO).<br/>
	 * <br/>
	 *
	 * @param pDateString : String : la date sous forme de String 
	 * à parser en java.util.Date.<br/>
	 * @param pDateFormat : DateFormat : DateFormat ayant servi 
	 * à formatter pDateString.<br/>
	 * 
	 * @return : Date : java.util.Date correspondant à pDateString.<br/>
	 */
	public static Date fournirDateAvecString(
			final String pDateString
				, final DateFormat pDateFormat) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireDates.class) {
			
			/* retourne null si pDateString est blank. */
			if (StringUtils.isBlank(pDateString)) {
				return null;
			}
			
			/* retourne null si pDateFormat == null. */
			if (pDateFormat == null) {
				return null;
			}
			
			try {
				
				/* parse la date et return. */
				return pDateFormat.parse(pDateString);
				
			} catch (ParseException parseExc) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_GESTIONNAIRE_DATES
						, METHODE_FOURNIRDATEAVECSTRING
						, MESSAGE_MAUVAIS_DATEFORMAT_ENTREE
						, "date fournie sous la forme = " 
						+ pDateString 
						+ "   - Exception : " 
						+ parseExc.getMessage());
				
				/* retourne null si la date pString n'est pas plausible 
				 * ou parsable par pDateFormat. */
				return null;
				
			}
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de fournirDateAvecString(
	 // String pString
	 // , DateFormat pDateFormat)._________________________________________
	

	
	/**
	 * method extraireJour(
	 * Date pDate) :<br/>
	 * Extrait le jour du mois d'une date.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * 
	 * @return : int : jour du mois.<br/>
	 */
	public static int extraireJour(
			final Date pDate) {
		return extraireGrandeursDate(pDate)[0];
	} // Fin de extraireJour(
	 // Date pDate)._______________________________________________________

	
	
	/**
	 * method extraireMois(
	 * Date pDate) :<br/>
	 * Extrait le mois d'une date.<br/>
	 * <br/>
	 * Attention, le mois est 1-based (2 pour février).<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * 
	 * @return : int : mois.<br/>
	 */
	public static int extraireMois(
			final Date pDate) {
		return extraireGrandeursDate(pDate)[1];
	} // Fin de extraireMois(
	 // Date pDate)._______________________________________________________
	
	
	
	/**
	 * method extraireAnnee(
	 * Date pDate) :<br/>
	 * Extrait l'année d'une date.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * 
	 * @return : int : année.<br/>
	 */
	public static int extraireAnnee(
			final Date pDate) {
		return extraireGrandeursDate(pDate)[2];
	} // Fin de extraireAnnee(
	 // Date pDate)._______________________________________________________
	
	
	
	/**
	 * method extraireHeure(
	 * Date pDate) :<br/>
	 * Extrait l'heure d'une date.<br/>
	 * <br/>
	 * ATTENTION : l'heure est exprimée sur 24 heures.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * 
	 * @return : int : heure.<br/>
	 */
	public static int extraireHeure(
			final Date pDate) {
		return extraireGrandeursDate(pDate)[3];
	} // Fin de extraireHeure(
	 // Date pDate)._______________________________________________________
	
	
	
	/**
	 * method extraireMinute(
	 * Date pDate) :<br/>
	 * Extrait la minute d'une date.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * 
	 * @return : int : minute.<br/>
	 */
	public static int extraireMinute(
			final Date pDate) {
		return extraireGrandeursDate(pDate)[4];
	} // Fin de extraireMinute(
	 // Date pDate)._______________________________________________________
	
	
	
	/**
	 * method extraireSeconde(
	 * Date pDate) :<br/>
	 * Extrait la seconde d'une date.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * 
	 * @return : int : seconde.<br/>
	 */
	public static int extraireSeconde(
			final Date pDate) {
		return extraireGrandeursDate(pDate)[5];
	} // Fin de extraireSeconde(
	 // Date pDate)._______________________________________________________
	
	
	
	/**
	 * method extraireMilliseconde(
	 * Date pDate) :<br/>
	 * Extrait la milliseconde d'une date.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * 
	 * @return : int : milliseconde.<br/>
	 */
	public static int extraireMilliseconde(
			final Date pDate) {
		return extraireGrandeursDate(pDate)[6];
	} // Fin de extraireMilliseconde(
	 // Date pDate)._______________________________________________________

	
	
	/**
	 * method extraireGrandeursDate(
	 * Date pDate) :<br/>
	 * retourne un tableau d'entiers comprenant 
	 * les grandeurs caractérisant une date selon la LOCALE_FR_FR.<br/>
	 * Tableau sous la forme 
	 * [jour;mois;année;heure;minute;seconde;milliseconde].<br/>
	 * ATTENTION : le mois est 1-based (2 pour février).<br/>
	 * ATTENTION : l'heure est sur 24 heures.<br/>
	 * <br/>
	 * - retourne null si Exception (et LOG INFO).<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * 
	 * @return : int[] : 
	 * [jour;mois;année;heure;minute;seconde;milliseconde].<br/>
	 */
	public static int[] extraireGrandeursDate(
			final Date pDate) {
		
		return extraireGrandeursDate(pDate, LOCALE_FR_FR);
		
	} // Fin de extraireGrandeursDate(
	 // Date pDate)._______________________________________________________
	
	
	
	/**
	 * method extraireGrandeursDate(
	 * Date pDate
	 * , Locale pLocale) :<br/>
	 * retourne un tableau d'entiers comprenant 
	 * les grandeurs caractérisant une date selon la Locale pLocale.<br/>
	 * Tableau sous la forme 
	 * [jour;mois;année;heure;minute;seconde;milliseconde].<br/>
	 * ATTENTION : le mois est 1-based (2 pour février).<br/>
	 * ATTENTION : l'heure est sur 24 heures.<br/>
	 * <br/>
	 * - retourne null si Exception (et LOG INFO).<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * @param pLocale : Locale.<br/>
	 * 
	 * @return : int[] : 
	 * [jour;mois;année;heure;minute;seconde;milliseconde].<br/>
	 */
	public static int[] extraireGrandeursDate(
			final Date pDate
				, final Locale pLocale) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireDates.class) {
			
			try {
				
				/* Récupère une instance de Calendar en fonction de pLocale. */
				final Calendar calendar = Calendar.getInstance(pLocale);
				
				/* Positionne le Calendar à pDate. */
				calendar.setTime(pDate);
				
				/* Extrait les grandeurs. */
				final int jour = calendar.get(Calendar.DAY_OF_MONTH);				
				final int mois = calendar.get(Calendar.MONTH) + 1;
				final int annee = calendar.get(Calendar.YEAR);
				final int heure = calendar.get(Calendar.HOUR_OF_DAY);
				final int minute = calendar.get(Calendar.MINUTE);
				final int seconde = calendar.get(Calendar.SECOND);
				final int milliseconde = calendar.get(Calendar.MILLISECOND);
				
				final int[] resultat = new int[7];
				
				/* Remplit le résultat. */
				resultat[0] = jour;
				resultat[1] = mois;
				resultat[2] = annee;
				resultat[3] = heure;
				resultat[4] = minute;
				resultat[5] = seconde;
				resultat[6] = milliseconde;
				
				/* retourne le résultat. */
				return resultat;
				
			} catch (Exception e) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_GESTIONNAIRE_DATES
						, METHODE_EXTRAIREGRANDEURSDATE
						, "PROBLEME"
						+ "   - Exception : " 
						+ e.getMessage());
				
				/* retourne null si Exception (et LOG INFO). */
				return null;
			}
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de extraireGrandeursDate(
	 // Date pDate
	 // , Locale pLocale)._________________________________________________
	
	
	
	/**
	 * method afficherDateAvecFormat(
	 * Date pDate
	 * , DateFormat pDateFormat) :<br/>
	 * Retourne une String représentant la java.util.Date pDate 
	 * au format pDateFormat.<br/>
	 * Par exemple :<br/>
	 * - Retourne la String "25/02/1961" 
	 * avec une Date au 25/02/1961 et un DateFormat 
	 * DF_DATE_FRANCAISE (
	 * new SimpleDateFormat("dd/MM/yyyy", LOCALE_FR_FR)).<br/>
	 * <br/>
	 * - retourne null si pDate == null.<br/>
	 * - retourne null si pDateFormat == null.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * @param pDateFormat : DateFormat.<br/>
	 * 
	 * @return : String : String pour affichage 
	 * formatté de pDate selon pDateFormat.<br/>
	 */
	public static String afficherDateAvecFormat(
			final Date pDate
				, final DateFormat pDateFormat) {
		
		return fournirDateFormattee(pDate, pDateFormat);
		
	} // Fin de afficherDateAvecFormat(
	 // Date pDate
	 // , DateFormat pDateFormat)._________________________________________
	
	
	
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
	 * method loggerInfo(
	 * String pClasse
	 * , String pMethode
	 * , String pMessage
	 * , String pComplement) :<br/>
	 * Créée un message de niveau INFO dans le LOG.<br/>
	 * <br/>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pMessage : String : Message particulier de la méthode.<br/>
	 * @param pComplement : String : Complément au message de la méthode.<br/>
	 */
	private static void loggerInfo(
			final String pClasse
				, final String pMethode
					, final String pMessage
						, final String pComplement) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null 
				|| pMessage == null || pComplement == null) {
			return;
		}
		
		/* LOG de niveau INFO. */			
		if (LOG.isInfoEnabled()) {
			
			final String message 
			= pClasse 
			+ SEP_MOINS
			+ pMethode
			+ SEP_MOINS
			+ pMessage
			+ pComplement;
			
			LOG.info(message);
		}
		
	} // Fin de loggerInfo(
	 // String pClasse
	 // , String pMethode
	 // , String pMessage
	 // , String pComplement)._____________________________________________
	
		

} // FIN DE LA CLASSE GestionnaireDates.-------------------------------------
