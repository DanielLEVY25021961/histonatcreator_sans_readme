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
	
	//*************************************************************/
	//*********************CHEMINS ********************************/
	//*************************************************************/
	
	/**
	 * CHEMIN_FICHIERS_TEST : String :<br/>
	 * Chemin des fichiers de test 
	 * relativement à la racine du projet actuel.<br/>
	 * ".\\test\\ressourcesjunit\\differentstypesfichiers\\".<br/>
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
	 * CHEMIN_ICO : String :<br/>
	 * Chemin du fichier .ico relativement à la racine des fichiers de test.<br/>
	 * "icones\\itunes_98708-640.ico".<br/>
	 */
	public static final String CHEMIN_ICO 
		= "icones\\itunes_98708-640.ico";

	
	/**
	 * CHEMIN_PNG : String :<br/>
	 * Chemin du fichier .png relativement à la racine des fichiers de test.<br/>
	 * "images\\iTunes10-300x300.png".<br/>
	 */
	public static final String CHEMIN_PNG 
		= "images\\iTunes10-300x300.png";

	
	/**
	 * CHEMIN_JPG : String :<br/>
	 * Chemin du fichier .jpg relativement à la racine des fichiers de test.<br/>
	 * "images\\Am I Blue Retour.jpg".<br/>
	 */
	public static final String CHEMIN_JPG 
		= "images\\Am I Blue Retour.jpg";
	
	
	/**
	 * CHEMIN_GIF : String :<br/>
	 * Chemin du fichier .gif relativement à la racine des fichiers de test.<br/>
	 * "images\\c.gif".<br/>
	 */
	public static final String CHEMIN_GIF 
		= "images\\c.gif";

	
	/**
	 * CHEMIN_BMP : String :<br/>
	 * Chemin du fichier .bmp relativement à la racine des fichiers de test.<br/>
	 * "images\\stickyfix.bmp".<br/>
	 */
	public static final String CHEMIN_BMP 
		= "images\\stickyfix.bmp";

	
	/**
	 * CHEMIN_XPS : String :<br/>
	 * Chemin du fichier .xps relativement à la racine des fichiers de test.<br/>
	 * "images\\Your feet s too big.xps".<br/>
	 */
	public static final String CHEMIN_XPS 
		= "images\\Your feet s too big.xps";

	
	/**
	 * CHEMIN_MP3 : String :<br/>
	 * Chemin du fichier .mp3 relativement à la racine des fichiers de test.<br/>
	 */
	public static final String CHEMIN_MP3 
		= "musique\\05 Tell It Like It Is.mp3";
	
	
	/**
	 * CHEMIN_WAV : String :<br/>
	 * Chemin du fichier .wav relativement à la racine des fichiers de test.<br/>
	 */
	public static final String CHEMIN_WAV 
		= "musique\\Note1.wav";
	
	
	
	
	//*****************************************************************/
	//**************************FICHIERS ******************************/
	//*****************************************************************/
	
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
	 * FILE_ICO : File :<br/>
	 * Fichier icône .ico.<br/>
	 */
	public static final File FILE_ICO 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_ICO);
	
	/**
	 * FILE_PNG : File :<br/>
	 * Fichier image PNG .png.<br/>
	 */
	public static final File FILE_PNG 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_PNG);

	/**
	 * FILE_JPG : File :<br/>
	 * Fichier image JPG .jpg.<br/>
	 */
	public static final File FILE_JPG 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_JPG);
	
	/**
	 * FILE_GIF : File :<br/>
	 * Fichier image Gif .gif.<br/>
	 */
	public static final File FILE_GIF 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_GIF);
	
	/**
	 * FILE_BMP : File :<br/>
	 * Fichier image Bmp .bmp.<br/>
	 */
	public static final File FILE_BMP 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_BMP);
	
	/**
	 * FILE_XPS : File :<br/>
	 * Fichier image xps .xps.<br/>
	 */
	public static final File FILE_XPS 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_XPS);
	
	/**
	 * FILE_MP3 : File :<br/>
	 * Fichier musical mp3 .mp3.<br/>
	 */
	public static final File FILE_MP3 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_MP3);
	
	/**
	 * FILE_WAV : File :<br/>
	 * Fichier musical Wave .wav.<br/>
	 */
	public static final File FILE_WAV 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_WAV);
	
	
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
	
	
	//*********************************************************************/
	// TESTS JAVA
	//*********************************************************************/
	
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
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_FICHIER_NULL : "
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
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_FICHIER_INEXISTANT : "
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
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_FICHIER_REPERTOIRE : "
				, ControleurFichierTexte.MESSAGE_FICHIER_REPERTOIRE, resultat);
		
	} // Fin de testGetMIMETypeFichierRepertoire().________________________

	
	
	//*********************************************************************/
	// TESTS FICHIERS DESSIN
	//*********************************************************************/

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
				
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeDWG().______________________________________

	
	
	//*********************************************************************/
	// TESTS FICHIERS DIVERS
	//*********************************************************************/
	
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
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU : "
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
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU : "
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
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeEAP().______________________________________
	
	
	
	//*********************************************************************/
	// TESTS FICHIERS ICONE
	//*********************************************************************/

	/**
	 * method testGetMIMETypeICO() :<br/>
	 * Garantit que getMIMEType(fichier .ico) retourne 
	 * ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeICO() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .ico. */
		final String resultat = control.getMIMEType(FILE_ICO);
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeICO().______________________________________
	

	
	//*********************************************************************/
	// TESTS FICHIERS IMAGE
	//*********************************************************************/

	/**
	 * method testGetMIMETypePNG() :<br/>
	 * Garantit que getMIMEType(fichier .png) retourne 
	 * ControleurFichierTexte.MESSAGE_TYPE_MIME_PNG.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypePNG() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .png. */
		final String resultat = control.getMIMEType(FILE_PNG);
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_TYPE_MIME_PNG : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_PNG, resultat);
		
	} // Fin de testGetMIMETypePNG().______________________________________
	
	
	
	/**
	 * method testGetMIMETypeJPG() :<br/>
	 * Garantit que getMIMEType(fichier .jpg) retourne 
	 * ControleurFichierTexte.MESSAGE_TYPE_MIME_JPG.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeJPG() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .jpg. */
		final String resultat = control.getMIMEType(FILE_JPG);
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_TYPE_MIME_JPG : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_JPG, resultat);
		
	} // Fin de testGetMIMETypeJPG().______________________________________
	

	
	/**
	 * method testGetMIMETypeGIF() :<br/>
	 * Garantit que getMIMEType(fichier .gif) retourne 
	 * ControleurFichierTexte.MESSAGE_TYPE_MIME_GIF.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeGIF() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .gif. */
		final String resultat = control.getMIMEType(FILE_GIF);
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_TYPE_MIME_GIF : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_GIF, resultat);
		
	} // Fin de testGetMIMETypeGIF().______________________________________
	
	
	
	/**
	 * method testGetMIMETypeBMP() :<br/>
	 * Garantit que getMIMEType(fichier .bmp) retourne 
	 * ControleurFichierTexte.MESSAGE_TYPE_MIME_BMP.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeBMP() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .bmp. */
		final String resultat = control.getMIMEType(FILE_BMP);
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_TYPE_MIME_BMP : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_BMP, resultat);
		
	} // Fin de testGetMIMETypeBMP().______________________________________
	

	
	/**
	 * method testGetMIMETypeXPS() :<br/>
	 * Garantit que getMIMEType(fichier .xps) retourne 
	 * ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 */
	@Test
	public void testGetMIMETypeXPS() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .xps. */
		final String resultat = control.getMIMEType(FILE_XPS);
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeXPS().______________________________________
	
	
	
	//*********************************************************************/
	// TESTS MUSIQUE
	//*********************************************************************/

	/**
	 * method testGetMIMETypeMP3() :<br/>
	 * Garantit que getMIMEType(fichier .mp3) retourne 
	 * ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 */
	@Test
	public void testGetMIMETypeMP3() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .mp3. */
		final String resultat = control.getMIMEType(FILE_MP3);
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeMP3().______________________________________
	
	
	
	/**
	 * method testGetMIMETypeWAV() :<br/>
	 * Garantit que getMIMEType(fichier .wav) retourne 
	 * ControleurFichierTexte.MESSAGE_TYPE_MIME_WAV.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeWAV() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .wav. */
		final String resultat = control.getMIMEType(FILE_WAV);
		
		assertEquals("Doit retourner ControleurFichierTexte.MESSAGE_TYPE_MIME_WAV : String : "
				, ControleurFichierTexte.MESSAGE_TYPE_MIME_WAV, resultat);
		
	} // Fin de testGetMIMETypeWAV().______________________________________
	
	
	
	/**
	 * method testGetMIMEType() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMEType() {
		
		/* Instanciation d'un ControleurFichierTexte. */
		final ControleurFichierTexte control = new ControleurFichierTexte();
		
		/* Test avec un .png. */
		final String resultat = control.getMIMEType(FILE_WAV);
		System.out.println(resultat);
		assertTrue("bidon", 1 == 1);
	}


} // FIN DE LA CLASSE ControleurFichierTexteTest.----------------------------
