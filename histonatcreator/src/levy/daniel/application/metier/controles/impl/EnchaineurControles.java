package levy.daniel.application.metier.controles.impl;

import java.io.File;
import java.util.Date;

import levy.daniel.application.metier.controles.AbstractEnchaineurControles;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class EnchaineurControles :<br/>
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
public class EnchaineurControles extends AbstractEnchaineurControles {

	// ************************ATTRIBUTS************************************/
	
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(EnchaineurControles.class);

	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR EnchaineurControles() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public EnchaineurControles() {
		this(null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	
	 /**
	 * method CONSTRUCTEUR EnchaineurControles(
	 * Date pDateControle
	 * , String pUserName
	 * , File pFichier) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 * <ul>
	 * <li>initialise le bundleControles qui encapsule 
	 * messagescontroles_fr_FR.properties.</li><br/>
	 * <li>remplit dateControle avec pDateControle si pDateControle != null 
	 * ou la date système sinon.</li><br/>
	 * <li>calcule automatiquement this.dateControleStringFormattee.</li><br/>
	 * <li>remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.</li><br/>
	 * <li>passe pFichier à this.fichier.</li><br/>
	 * <li>calcule automatiquement this.nomFichier.</li><br/>
	 * <li>remplit la SortedMap des contrôles à enchaîner.</li><br/>
	 * </ul>
	 * <br/>
	 *
	 * @param pDateControle : Date : java.util.Date de 
	 * l'enchaînement des contrôles.<br/>
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché l'enchaînement des contrôles.<br/> 
	 * @param pFichier : File : fichier sur lequel 
	 * s'applique l'enchaînement des contrôles.<br/>
	 */
	public EnchaineurControles(
			final Date pDateControle
			, final String pUserName
				, final File pFichier) {
		
		super(pDateControle, pUserName, pFichier);
		
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	

} // FIN DE LA CLASSE EnchaineurControles.-----------------------------------
