package levy.daniel.application.metier.controles;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import levy.daniel.application.metier.controles.rapportscontroles.LigneRapport;
import levy.daniel.application.metier.service.enregistreursfichiers.rapportsenregistrements.LigneRapportEnregistrement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class AbstractEnchaineurControles :<br/>
 * Abstraction chargée de centraliser les attributs et les méthodes des 
 * Classe métier non persistante chargée d'enchaîner 
 * tous les contrôles à appliquer aux fichiers en entrée 
 * (HIT, DARWIN, ...).<br/>
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
public abstract class AbstractEnchaineurControles 
						implements IEnchaineurControles {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * dateControle : Date :<br/>
	 * java.util.Date de l'enchaînement de contrôles.<br/>
	 */
	protected Date dateControle;

	
	/**
	 * dateControleStringFormatee : String :<br/>
	 * date de l'enchaînement de contrôles 
	 * formattée au format dfDatetimemilliFrancaiseLexico.<br/>
	 * Format des dates-heures françaises lexicographique 
	 * avec millisecondes comme
	 * '1961-01-25_12-27-07-251'.<br/>
	 * "yyyy-MM-dd_HH-mm-ss-SSS".<br/>
	 */
	protected transient String dateControleStringFormatee;
	

	/**
	 * userName : String :<br/>
	 * nom de l'utilisateur qui a déclenché l'enchaînement de contrôles.<br/>
	 */
	protected String userName;

	
	/**
	 * fichier : File :<br/>
	 * fichier sur lequel s'applique l'enchaînement de contrôles.<br/>
	 */
	protected File fichier;

	
	/**
	 * nomFichier : String :<br/>
	 * nom du fichier objet de l'enchaînement de contrôles.<br/>
	 */
	protected transient String nomFichier;
	
	
	/**
	 * rapport : List&lt;LigneRapport&gt; :<br/>
	 * rapport fourni par l'enchaînement de contrôles sous forme 
	 * de List&lt;LigneRapport&gt;.<br/>
	 */
	protected transient List<LigneRapport> rapport 
		= new ArrayList<LigneRapport>();
	
	
	/**
	 * rapportEnregistrement : List&lt;LigneRapportEnregistrement&gt; :<br/>
	 * rapport d'enregistrement sur disque des fichiers 
	 * fourni par l'enregistreur du rapport 
	 * de l'enchaîneur de contrôle  sous forme 
	 * de List&lt;LigneRapportEnregistrement&gt;.<br/>
	 */
	protected transient List<LigneRapportEnregistrement> rapportEnregistrement 
		= new ArrayList<LigneRapportEnregistrement>();



	/**
	 * dfDatetimemilliFrancaiseLexico : DateFormat :<br/>
	 * Format des dates-heures françaises lexicographique 
	 * avec millisecondes comme
	 * '1961-01-25_12-27-07-251'.<br/>
	 * "yyyy-MM-dd_HH-mm-ss-SSS".<br/>
	 */
	public final transient DateFormat dfDatetimemilliFrancaiseLexico 
	= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", LOCALE_FR_FR);


	/**
	 * bundleControles : ResourceBundle :<br/>
	 * Encapsulation de messagescontroles_fr_FR.properties.<br/>
	 */
	public static ResourceBundle bundleControles;
	


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(AbstractEnchaineurControles.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractEnchaineurControles() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractEnchaineurControles() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method fournirDateFormattee(
	 * Date pDate) :<br/>
	 * Fournit une date sous forme de String formattée 
	 * au format dfDatetimemilliFrancaiseLexico.<br/>
	 * Format des dates-heures françaises lexicographique 
	 * avec millisecondes comme
	 * '1961-01-25_12-27-07-251'.<br/>
	 * "yyyy-MM-dd_HH-mm-ss-SSS".<br/>
	 * <br/>
	 * - retourne null si pDate == null.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * 
	 * @return : String : "yyyy-MM-dd_HH-mm-ss-SSS".<br/>
	 */
	private String fournirDateFormattee(
			final Date pDate) {
		
		/* retourne null si pDate == null. */
		if (pDate == null) {
			return null;
		}
		
		final String dateFormattee 
			= this.dfDatetimemilliFrancaiseLexico.format(pDate);
		
		return dateFormattee;
		
	} // Fin de fournirDateFormattee(
	 // Date pDate)._______________________________________________________
	
	
	
	/**
	 * method fournirUserName(
	 * String pUserName) :<br/>
	 * - retourne 'Administrateur' si pUsername == null.<br/>
	 * - retourne pUserName sinon.<br/>
	 * <br/>
	 *
	 * @param pUserName : String.<br/>
	 * 
	 * @return : String : pUserName si pas null ou 'Administrateur .<br/>
	 */
	private String fournirUserName(
			final String pUserName) {
		
		/* retourne 'Administrateur' si pUsername == null. */
		if (pUserName == null) {
			return "Administrateur";
		}
		
		/* retourne pUserName sinon. */
		return pUserName;
		
	} // Fin de fournirUserName(
	 // String pUserName)._________________________________________________
	

	
	/**
	 * method fournirNomFichier(
	 * File pFile) :<br/>
	 * retourne le nom court (sans tout le chemin) de pFile.<br/>
	 * <br/>
	 * - retourne null si pFile == null.<br/>
	 * <br/>
	 *
	 * @param pFile : File.<br/>
	 * 
	 * @return : String : nom du fichier.<br/>
	 */
	private String fournirNomFichier(
			final File pFile) {
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* retourne le nom court (sans tout le chemin) de pFile. */
		return pFile.getName();
		
	} // Fin de fournirNomFichier(
	 // File pFile)._______________________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Date getDateControle() {
		return this.dateControle;
	} // Fin de getDateControle()._________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setDateControle(
			final Date pDateControle) {
		
		this.dateControle = pDateControle;
		
		/* calcule automatiquement dateControleStringFormattee. */
		this.dateControleStringFormatee 
			= this.fournirDateFormattee(this.dateControle);
		
	} // Fin de setDateControle(
	 // Date pDateControle)._______________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getDateControleStringFormatee() {
		return this.dateControleStringFormatee;
	} // Fin de getDateControleStringFormatee().___________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getUserName() {
		return this.userName;
	} // Fin de getUserName()._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setUserName(
			final String pUserName) {
		this.userName = this.fournirUserName(pUserName);
	} // Fin de setUserName(
	 // String pUserName)._________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final File getFichier() {
		return this.fichier;
	} // Fin de getFichier().______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setFichier(
			final File pFichier) {
		
		this.fichier = pFichier;
		
		/* calcule automatiquement nomFichier. */
		this.nomFichier = this.fournirNomFichier(this.fichier);
		
	} // Fin de setFichier(
	 // File pFichier).____________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getNomFichier() {
		return this.nomFichier;
	} // Fin de getNomFichier().___________________________________________


	
} // FIN DE LA CLASSE AbstractEnchaineurControles.---------------------------
