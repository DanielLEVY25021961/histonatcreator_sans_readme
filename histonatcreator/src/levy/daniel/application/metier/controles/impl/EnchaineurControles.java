package levy.daniel.application.metier.controles.impl;

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
	 *
	 */
	public EnchaineurControles() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	

} // FIN DE LA CLASSE EnchaineurControles.-----------------------------------
