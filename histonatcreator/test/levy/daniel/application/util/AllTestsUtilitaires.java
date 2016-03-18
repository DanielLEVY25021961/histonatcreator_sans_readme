package levy.daniel.application.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * class AllTestsUtilitaires :<br/>
 * Enchaînements de tous les tests JUnit des classes utilitaires.<br/>
 * <br/>
 * Mettre les chemin complets des classes de test 
 * dans l'annotation /@SuiteClasses({ }) et 
 * appeler le .class pour l'introspection.<br/>
 * <br/>
 * Par exemple : <br/>
 * levy.daniel.application.util.controleurstypefichier.controleurstypefichiertexte.ControleurFichierTexteTest.class<br/>
 * , levy.daniel.application.util.convertisseursencodage.ConvertisseurEncodageTest.class<br/>
 * , levy.daniel.application.util.detecteurstypefichier.DetecteurTypeMimeTest.class<br/>
 * , ..............<br/>
 * <br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Enchaînements de tests unitaires, Enchainements de tests unitaires,
 * enchainement de tests Junit, lier des Junit, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 9 févr. 2016
 *
 */
@RunWith(Suite.class)

@SuiteClasses({
	
	levy.daniel.application.util.controleurstypefichier.controleurstypefichiertexte.ControleurFichierTexteTest.class
	, levy.daniel.application.util.convertisseursencodage.ConvertisseurEncodageTest.class
	, levy.daniel.application.util.detecteurstypefichier.DetecteurTypeMimeTest.class
	, levy.daniel.application.util.differentiateurs.differentiateursstrings.CaractereDanTest.class
	, levy.daniel.application.util.differentiateurs.differentiateursfichiers.DifferentiateurFichiersTest.class
	, levy.daniel.application.util.differentiateurs.differentiateursstrings.DifferentiateurStringTest.class
	, levy.daniel.application.util.gestionnairesdates.GestionnaireDatesTest.class
	, levy.daniel.application.util.gestionnairesiofichiers.GestionnaireFichiersTest.class
	, levy.daniel.application.util.lecteursfichiers.MonFileInputStreamReaderDanTest.class
	, levy.daniel.application.util.lecteursfichiers.MonFileReaderDanTest.class
	
})

public final class AllTestsUtilitaires {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(AllTestsUtilitaires.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AllTestsUtilitaires() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AllTestsUtilitaires() {		
		/* Instanciation de la Super-Classe. */
		super();		
	} // Fin de AllTestsUtilitaires()._____________________________________
	


	
} // FIN DE LA CLASSE AllTestsUtilitaires.-----------------------------------
