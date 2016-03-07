package levy.daniel.application.metier.controles;

import java.io.File;
import java.util.Date;
import java.util.Locale;


/**
 * class IEnchaineurControles :<br/>
 * Abstraction qui garantit que :<br/>
 * - Tout enchaînement de contrôles est effectué à une 'dateContrôle'. 
 * La classe calcule automatiquement 'dateControleStringFormatee' 
 * connaissant dateControle.<br/>
 * - Tout enchaînement de contrôles est effectué par un utilisateur (user) 
 * dont on connait le nom 'userName'. La classe remplit automatiquement 
 * userName avec 'Administrateur' si on ne lui fournit pas de userName.<br/>
 * - Tout enchaînement de contrôles s'applique sur un File 'fichier'. 
 * La classe calcule automatiquement 'nomFichier' connaissant fichier.<br/>
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
 * @since 6 mars 2016
 *
 */
public interface IEnchaineurControles {
	

	/**
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("fr", "FR").<br/>
	 */
	Locale LOCALE_FR_FR = new Locale("fr", "FR");


	/**
	 * method getDateControle() :<br/>
	 * Getter de la java.util.Date de l'enchaînement de contrôles.<br/>
	 * <br/>
	 *
	 * @return dateControle : Date.<br/>
	 */
	Date getDateControle();
	
	

	/**
	 * method setDateControle(
	 * Date pDateControle) :<br/>
	 * Setter de la java.util.Date de l'enchaînement de contrôles.<br/>
	 * <br/>
	 * - calcule automatiquement dateControleStringFormattee.<br/>
	 * <br/>
	 *
	 * @param pDateControle : Date : valeur à passer à dateControle.<br/>
	 */
	void setDateControle(final Date pDateControle);
	
	

	/**
	 * method getDateControleStringFormatee() :<br/>
	 * Getter de la date de l'enchaînement de contrôles formattée 
	 * au format dfDatetimemilliFrancaiseLexico.<br/>
	 * Format des dates-heures françaises lexicographique 
	 * avec millisecondes comme
	 * '1961-01-25_12-27-07-251'.<br/>
	 * "yyyy-MM-dd_HH-mm-ss-SSS".<br/>
	 * <br/>
	 *
	 * @return dateControleStringFormatee : String.<br/>
	 */
	String getDateControleStringFormatee();
	
	

	/**
	 * method getUserName() :<br/>
	 * Getter du nom de l'utilisateur qui a déclenché 
	 * l'enchaînement de contrôles.<br/>
	 * <br/>
	 *
	 * @return userName : String.<br/>
	 */
	String getUserName();
	
	

	/**
	 * method setUserName(
	 * String pUserName) :<br/>
	 * Setter du nom de l'utilisateur qui a déclenché 
	 * l'enchaînement de contrôles.<br/>
	 * <br/>
	 * remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.<br/>
	 * <br/>
	 *
	 * @param pUserName : String : 
	 * valeur à passer à userName.<br/>
	 */
	void setUserName(final String pUserName);
	
	

	/**
	 * method getFichier() :<br/>
	 * Getter du fichier sur lequel s'applique 
	 * l'enchaînement de contrôles.<br/>
	 * <br/>
	 *
	 * @return fichier : File.<br/>
	 */
	File getFichier();
	
	

	/**
	 * method setFichier(
	 * File pFichier) :<br/>
	 * Setter du fichier sur lequel s'applique 
	 * l'enchaînement de contrôles.<br/>
	 * <br/>
	 * - calcule automatiquement nomFichier.<br/>
	 * <br/>
	 *
	 * @param pFichier : File : valeur à passer à fichier.<br/>
	 */
	void setFichier(final File pFichier);
	
	

	/**
	 * method getNomFichier() :<br/>
	 * Getter du nom du fichier objet 
	 * de l'enchaînement de contrôles.<br/>
	 * <br/>
	 *
	 * @return nomFichier : String.<br/>
	 */
	String getNomFichier();

	
	
} // FIN DE L'INTERFACE IEnchaineurControles.--------------------------------
