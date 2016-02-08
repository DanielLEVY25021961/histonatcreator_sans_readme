package levy.daniel.application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;


/**
 * class IConstantesMessage :
 * Factorise toutes les constantes utiles pour les messages
 * de contrôle et les Localisation.
 *
 * - Exemple d'utilisation :
 *
 * - Mots-clé :
 *
 * - Dépendances :
 *
 *
 * @author Dan Lévy
 * @version 1.0
 * @since 16 sept. 2012
 *
 */
public interface IConstantesMessage {
	
	
	/**
	 * LOCALE_FR : Locale : <br/>
	 * Locale France avec langage français.<br/>
	 */
	Locale LOCALE_FR = new Locale("fr", "FR");
	

	/**
	 * SEPTAB : String :<br/>
	 * "\t".<br/>
	 */
	String SEPTAB = "\t";
	

	/**
	 * SEP_POINTVIRGULE : String :<br/>
	 * ";".<br/>
	 */
	String SEP_POINTVIRGULE = ";";

	
	/**
	 * SEP_2POINTS : String :<br/>
	 * .<br/>
	 */
	String SEP_2POINTS = " : ";
	
	
	/**
	 * CHAINE_NULL : String :<br/>
	 * "null".<br/>
	 */
	String CHAINE_NULL = "null";

	
	/**
	 * SEP_MOINS : String :<br/>
	 * " - ".<br/>
	 */
	String SEP_MOINS = " - ";
	
	
	/**
	 * SAUT_DE_LIGNE : Character :<br/>
	 * Saut de ligne Java.<br/>
	 * '\n'.<br/>
	 */
	Character SAUT_DE_LIGNE = '\n';
	
	
	/**
	 * DF_DATE_FRANCAISE : DateFormat :<br/>
	 * Format classique des dates françaises comme
	 * '25/02/1961'.<br/>
	 */
	DateFormat DF_DATE_FRANCAISE 
	= new SimpleDateFormat("dd/MM/yyyy", LOCALE_FR);
	
	
	/**
	 * DF_DATE_COMPLETE_FRANCAISE : DateFormat :<br/>
	 * Format complet des dates françaises comme
	 * 'samedi 25 février 1961'.<br/>
	 */
	DateFormat DF_DATE_COMPLETE_FRANCAISE 
		= new SimpleDateFormat("EEEE' 'dd' 'MMMM' 'yyyy"
			, LOCALE_FR);

	
	/**
	 * DF_MOIS_ANNEE : DateFormat :<br/>
	 * Format des dates françaises avec mois-année comme
	 * 'février 1961'.<br/>
	 */
	DateFormat DF_MOIS_ANNEE 
		= new SimpleDateFormat("MMMM' 'yyyy"
			, LOCALE_FR);

	
	/**
	 * DF_MOIS_ANNEE_SIMPLE : DateFormat :<br/>
	 * Format des dates françaises avec mois simplifié-année comme
	 * '02/1961'.<br/>
	 */
	DateFormat DF_MOIS_ANNEE_SIMPLE 
	= new SimpleDateFormat("MM/yyyy", LOCALE_FR);
	
	
	/**
	 * DF_ANNEE : DateFormat :<br/>
	 * Format des dates avec juste l'année comme "1961".<br/>
	 */
	DateFormat DF_ANNEE 
		= new SimpleDateFormat("yyyy", LOCALE_FR);
	

	/**
	 * DF_DATE_AVEC_HEURE_MINUTE_SECONDE : DateFormat :<br/>
	 * Format classique des dates avec heures et secondes
	 * comme "2012-01-16 à 18 heures,09 minutes,55 secondes" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	DateFormat DF_DATE_AVEC_HEURE_MINUTE_SECONDE 
	= new SimpleDateFormat("yyyy-MM-dd' " 
	+ "à 'HH' heures,'mm' minutes,'ss' secondes'", LOCALE_FR);
	
	 
	/**
	 * DF_DATE_HEURE_MINUTE_SECONDE : DateFormat :<br/>
	 * Format concentré des dates avec heures et secondes
	 * comme "2012-01-16:18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	DateFormat DF_DATE_HEURE_MINUTE_SECONDE 
		= new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss", LOCALE_FR);


	

} // FIN DE L'INTERFACE IConstantesMessage.----------------------------------
