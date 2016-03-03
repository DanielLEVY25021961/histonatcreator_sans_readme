package levy.daniel.application.metier.service.enregistreursfichiers.impl;

import levy.daniel.application.metier.service.enregistreursfichiers.AbstractEnregistreurFichiers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class EnregistreurFichiers :<br/>
 * Classe utilitaire concrète qui fournit un service d'enregistrement 
 * de fichiers sur disque.<br/>
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
 * @since 3 mars 2016
 *
 */
public class EnregistreurFichiers extends AbstractEnregistreurFichiers {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_ENREGISTREUR_FICHIERS : String :<br/>
	 * "Classe EnregistreurFichiers".<br/>
	 */
	public static final String CLASSE_ENREGISTREUR_FICHIERS 
		= "Classe EnregistreurFichiers";

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(EnregistreurFichiers.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR EnregistreurFichiers() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 */
	public EnregistreurFichiers() {
		super();
	}
	

	/**
	 * ""Classe EnregistreurFichiers"".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected final String fournirNomClasseConcrete() {
		return CLASSE_ENREGISTREUR_FICHIERS;
	} // Fin de fournirNomClasseConcrete().________________________________
	

	
} // Fin DE LA CLASSE EnregistreurFichiers.----------------------------------
