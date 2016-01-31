package levy.daniel.application.util.controleurstypefichier.controleurstypefichiertexte;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * class ControleurFichierTexteTest :<br/>
 * Tests JUnit de la Classe ControleurFichierTexte.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * ".", Chemin des fichiers de test relativement 
 * à la racine du projet actuel.<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 29 janv. 2016
 *
 */
public final class ControleurFichierTexteTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * CHEMIN_FICHIERS_TEST : String :<br/>
	 * Chemin des fichiers de test 
	 * relativement à la racine du projet actuel.<br/>
	 */
	public static final String CHEMIN_FICHIERS_TEST 
		= ".\\test\\ressourcesjunit\\differentstypesfichiers\\";

	/**
	 * CHEMIN_INEXISTANT : String :<br/>
	 * Chemin d'un fichier inexistant.<br/>
	 * "inexistant.txt".<br/>
	 */
	public static final String CHEMIN_INEXISTANT = "inexistant.txt";
	
	/**
	 * CHEMIN_REPERTOIRE : String :<br/>
	 * Chemin d'un répertoire.<br/>
	 * "dessin"
	 */
	public static final String CHEMIN_REPERTOIRE = "dessin";
	
	/**
	 * CHEMIN_DWG : String :<br/>
	 * Chemin du fichier DWG relativement à la racine des fichiers de test.<br/>
	 * "dessin\\2015-10-20_Studio_Gilbert.dwg".<br/>
	 */
	public static final String CHEMIN_DWG 
		= "dessin\\2015-10-20_Studio_Gilbert.dwg";

	/**
	 * CHEMIN_PPTX : String :<br/>
	 * Chemin du fichier pptx relativement à la racine des fichiers de test.<br/>
	 * "divers\\Séance1.pptx".<br/>
	 */
	public static final String CHEMIN_PPTX 
		= "divers\\Séance 1.pptx";

	
	/**
	 * CHEMIN_MID : String :<br/>
	 * Chemin du fichier .mid relativement à la racine des fichiers de test.<br/>
	 * "divers\\Stride-anatole Majeur.MID"
	 */
	public static final String CHEMIN_MID 
		= "divers\\Stride-anatole Majeur.MID";
	
	
	/**
	 * CHEMIN_EAP : String :<br/>
	 * Chemin du fichier .eap relativement à la racine des fichiers de test.<br/>
	 * "divers\\Trafic_Statistiques.eap"
	 */
	public static final String CHEMIN_EAP 
		= "divers\\Trafic_Statistiques.eap";
	
	
	
	
	/**
	 * FILE_INEXISTANT : File :<br/>
	 * Fichier inexistant.<br/>
	 */
	public static final File FILE_INEXISTANT 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_INEXISTANT);
	
	/**
	 * FILE_REPERTOIRE : File :<br/>
	 * Répertoire.<br/>
	 */
	public static final File FILE_REPERTOIRE 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_REPERTOIRE);
	
	/**
	 * FILE_DWG : File :<br/>
	 * Fichier Autocad .dwg.<br/>
	 */
	public static final File FILE_DWG 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DWG);
	
	/**
	 * FILE_PPTX : File :<br/>
	 * Fichier PowerPoint pptx.<br/>
	 */
	public static final File FILE_PPTX 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_PPTX);
	
	/**
	 * FILE_MID : File :<br/>
	 * Fichier Midi .mid.<br/>
	 */
	public static final File FILE_MID 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_MID);
	
	/**
	 * FILE_EAP : File :<br/>
	 * Fichier Enterprise Architect .eap.<br/>
	 */
	public static final File FILE_EAP 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_EAP); 
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(ControleurFichierTexteTest.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ControleurFichierTexteTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ControleurFichierTexteTest() {
		
		/* Instanciation de la Super-Classe. */
		super();
		
	} // Fin de ControleurFichierTexteTest().______________________________
	
	

	/**
	 * method testGetMIMETypeFichierNull() :<br/>
	 * Garantit que getMIMEType(null) retourne 
	 * ControleurFichierTexte.MESSAGE_FICHIER_NULL.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeFichierNull() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un fichier null. */
		final String resultat = control.getMIMEType(null);
		
		assertEquals("Retourne MESSAGE_FICHIER_NULL : "
				, ControleurFichierTexte.MESSAGE_FICHIER_NULL, resultat);
		
	} // Fin de testGetMIMETypeFichierNull().______________________________
	

	
	/**
	 * method testGetMIMETypeFichierInexistant() :<br/>
	 * Garantit que getMIMEType(fichier inexistant) retourne 
	 * ControleurFichierTexte.MESSAGE_FICHIER_INEXISTANT.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeFichierInexistant() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un fichier inexistant. */
		final String resultat = control.getMIMEType(FILE_INEXISTANT);
		
		assertEquals("Retourne MESSAGE_FICHIER_INEXISTANT : "
				, ControleurFichierTexte.MESSAGE_FICHIER_INEXISTANT, resultat);
		
	} // Fin de testGetMIMETypeFichierInexistant().________________________
	
	
	
	/**
	 * method testGetMIMETypeFichierRepertoire() :<br/>
	 * Garantit que getMIMEType(fichier repertoire) retourne 
	 * ControleurFichierTexte.MESSAGE_FICHIER_REPERTOIRE.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeFichierRepertoire() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un répertoire. */
		final String resultat = control.getMIMEType(FILE_REPERTOIRE);
		
		assertEquals("Retourne MESSAGE_FICHIER_REPERTOIRE : "
				, ControleurFichierTexte.MESSAGE_FICHIER_REPERTOIRE, resultat);
		
	} // Fin de testGetMIMETypeFichierRepertoire().________________________

	
	
	/**
	 * method testGetMIMETypeDWG() :<br/>
	 * Garantit que getMIMEType(fichier .dwg) retourne 
	 * ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeDWG() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .dwg. */
		final String resultat = control.getMIMEType(FILE_DWG);
				
		assertEquals("Retourne MESSAGE_TYPE_MIME_INCONNU : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeDWG().______________________________________

	
		
	/**
	 * method testGetMIMETypePPTX() :<br/>
	 * Garantit que getMIMEType(fichier .pptx) retourne 
	 * ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypePPTX() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .pptx. */
		final String resultat = control.getMIMEType(FILE_PPTX);
		
		assertEquals("Retourne MESSAGE_TYPE_MIME_INCONNU : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypePPTX()._____________________________________
	

	
	/**
	 * method testGetMIMETypeMID() :<br/>
	 * Garantit que getMIMEType(fichier .mid) retourne 
	 * ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeMID() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .mid. */
		final String resultat = control.getMIMEType(FILE_MID);
		
		assertEquals("Retourne MESSAGE_TYPE_MIME_INCONNU : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeMID().______________________________________
	

	
	/**
	 * method testGetMIMETypeEAP() :<br/>
	 * Garantit que getMIMEType(fichier .eap) retourne 
	 * ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeEAP() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .eap. */
		final String resultat = control.getMIMEType(FILE_EAP);
		
		assertEquals("Retourne MESSAGE_TYPE_MIME_INCONNU : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeEAP().______________________________________
	
	
	
	/**
	 * method testGetMIMEType() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMEType() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		final String resultat = control.getMIMEType(FILE_MID);
		System.out.println(resultat);
		assertTrue("bidon", 1 == 1);
	}


} // FIN DE LA CLASSE ControleurFichierTexteTest.----------------------------
