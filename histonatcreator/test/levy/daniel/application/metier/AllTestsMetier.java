package levy.daniel.application.metier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * class AllTestsMetier :<br/>
 * Enchaînements de tous les tests JUnit des classes metier.<br/>
 * <br/>
 * Mettre les chemin complets des classes de test 
 * dans l'annotation /@SuiteClasses({ }) et 
 * appeler le .class pour l'introspection.<br/>
 * <br/>
 * Par exemple : <br/>
 * levy.daniel.application.metier.controles.impl.controlessurface.ControleurTypeTexteTest.class<br/>
 * , ..............<br/>
 * <br/>
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
 * @since 29 févr. 2016
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	levy.daniel.application.metier.service.enregistreursfichiers.impl.EnregistreurFichiersTest.class
	, levy.daniel.application.metier.controles.impl.controlessurface.ControleurTypeTexteTest.class
	, levy.daniel.application.metier.controles.impl.controlessurface.ControleurEncodageTest.class
	, levy.daniel.application.metier.controles.impl.controlessurface.ControleurHITTest.class
	, levy.daniel.application.metier.controles.impl.controlessurface.ControleurDARWINcsvTest.class
})
public final class AllTestsMetier {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(AllTestsMetier.class);
	

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AllTestsMetier() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AllTestsMetier() {		
		/* Instanciation de la Super-Classe. */
		super();		
	} // Fin de AllTestsMetier().__________________________________________

	
	
} // FIN DE LA CLASSE AllTestsMetier.----------------------------------------
