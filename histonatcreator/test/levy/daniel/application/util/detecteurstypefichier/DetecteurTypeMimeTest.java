package levy.daniel.application.util.detecteurstypefichier;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * class DetecteurTypeMimeTest :<br/>
 * Test JUNit de la classe DetecteurTypeMime.<br/>
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
 * @since 1 févr. 2016
 *
 */
public final class DetecteurTypeMimeTest {

	// ************************ATTRIBUTS************************************/
	
	//*************************************************************/
	//*********************CHEMINS ********************************/
	//*************************************************************/
	
	/**
	 * CHEMIN_FICHIERS_TEST : String :<br/>
	 * Chemin des fichiers de test 
	 * relativement à la racine du projet courant.<br/>
	 * ".\\test\\ressourcesjunit\\differentstypesfichiers\\".<br/>
	 */
	public static final String CHEMIN_FICHIERS_TEST 
		= ".\\test\\ressourcesjunit\\differentstypesfichiers\\";

	/**
	 * CHEMIN_INEXISTANT : String :<br/>
	 * Chemin d'un fichier inexistant.<br/>
	 * "inexistant.txt".<br/>
	 */
	public static final String CHEMIN_INEXISTANT 
		= "inexistant.txt";
	
	/**
	 * CHEMIN_REPERTOIRE : String :<br/>
	 * Chemin d'un répertoire (pas un simple fichier).<br/>
	 * "dessin"
	 */
	public static final String CHEMIN_REPERTOIRE 
		= "dessin";
	
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
	 * "musique\\05 Tell It Like It Is.mp3".<br/>
	 */
	public static final String CHEMIN_MP3 
		= "musique\\05 Tell It Like It Is.mp3";
		
	/**
	 * CHEMIN_WAV : String :<br/>
	 * Chemin du fichier .wav relativement à la racine des fichiers de test.<br/>
	 * "musique\\Note1.wav".<br/>
	 */
	public static final String CHEMIN_WAV 
		= "musique\\Note1.wav";
		
	/**
	 * CHEMIN_TXT_ISO_8859_15 : String :<br/>
	 * Chemin du fichier .txt en ISO-8859-15 relativement à la racine des fichiers de test.<br/>
	 * "texte\\2014-08-20_HITDIRA2013_ISO-8859-15.txt".<br/>
	 */
	public static final String CHEMIN_TXT_ISO_8859_15 
		= "texte\\2014-08-20_HITDIRA2013_ISO-8859-15.txt";
		
	/**
	 * CHEMIN_CSV_UTF8 : String :<br/>
	 * Chemin du fichier .csv en UTF-8 relativement à la racine des fichiers de test.<br/>
	 * "texte\\2014-08-20_HITDIRIF2013_UTF-8.csv".<br/>
	 */
	public static final String CHEMIN_CSV_UTF8 
		= "texte\\2014-08-20_HITDIRIF2013_UTF-8.csv";
		
	/**
	 * CHEMIN_TXT_UTF8 : String :<br/>
	 * Chemin du fichier .txt en UTF-8 relativement à la racine des fichiers de test.<br/>
	 * "texte\\2014-08-20_HITDIRIF2013_UTF-8.txt".<br/>
	 */
	public static final String CHEMIN_TXT_UTF8 
		= "texte\\2014-08-20_HITDIRIF2013_UTF-8.txt";
	
	/**
	 * CHEMIN_PDF : String :<br/>
	 * Chemin du fichier .pdf relativement à la racine des fichiers de test.<br/>
	 * "texte\\2015-10-20_Studio_Gilbert.pdf"
	 */
	public static final String CHEMIN_PDF 
		= "texte\\2015-10-20_Studio_Gilbert.pdf";
	
	/**
	 * CHEMIN_XSD : String :<br/>
	 * Chemin du fichier .xsd relativement à la racine des fichiers de test.<br/>
	 * "texte\\bouteilles_schema.xsd".<br/>
	 */
	public static final String CHEMIN_XSD 
		= "texte\\bouteilles_schema.xsd";
	
	/**
	 * CHEMIN_XML : String :<br/>
	 * Chemin du fichier .xml relativement à la racine des fichiers de test.<br/>
	 * "texte\\bouteilles.xml".<br/>
	 */
	public static final String CHEMIN_XML 
		= "texte\\bouteilles.xml";
	
	/**
	 * CHEMIN_INI : String :<br/>
	 * Chemin du fichier .ini relativement à la racine des fichiers de test.<br/>
	 * "texte\\desktop.ini".<br/>
	 */
	public static final String CHEMIN_INI 
		= "texte\\desktop.ini";
	
	
	/**
	 * CHEMIN_PROPERTIES : String :<br/>
	 * Chemin du fichier .properties relativement à la racine des fichiers de test.<br/>
	 * "texte\\log4j.properties".<br/>
	 */
	public static final String CHEMIN_PROPERTIES 
		= "texte\\log4j.properties";
	
	/**
	 * CHEMIN_DOCX : String :<br/>
	 * Chemin du fichier .docX relativement à la racine des fichiers de test.<br/>
	 * "texte\\Louisiana 1927.docx".<br/>
	 */
	public static final String CHEMIN_DOCX 
		= "texte\\Louisiana 1927.docx";
	
	/**
	 * CHEMIN_HTML : String :<br/>
	 * Chemin du fichier .html relativement à la racine des fichiers de test.<br/>
	 * "texte\\T.html".<br/>
	 */
	public static final String CHEMIN_HTML 
	= "texte\\T.html";
	
	/**
	 * CHEMIN_MP4 : String :<br/>
	 * Chemin du fichier .mp4 relativement à la racine des fichiers de test.<br/>
	 * "video\\2-video2brain-Définir Cubase.mp4".<br/>
	 */
	public static final String CHEMIN_MP4 
		= "video\\2-video2brain-Définir Cubase.mp4";
	
	/**
	 * CHEMIN_FLV : String :<br/>
	 * Chemin du fichier .flv relativement à la racine des fichiers de test.<br/>
	 * "video\\Pinophilus.flv".<br/>
	 */
	public static final String CHEMIN_FLV 
		= "video\\Pinophilus.flv";
	
	/**
	 * CHEMIN_ASF : String :<br/>
	 * Chemin du fichier .asf relativement à la racine des fichiers de test.<br/>
	 * "video\\Travail_Diminues_2010-07-27.ASF".<br/>
	 */
	public static final String CHEMIN_ASF 
		= "video\\Travail_Diminues_2010-07-27.ASF";
	
	/**
	 * CHEMIN_GIF_EN_BMP : String :<br/>
	 * Chemin du fichier .gif renommé en bmp 
	 * relativement à la racine des fichiers de test.<br/>
	 * "faussesextensions\\cgifrenommebmp.bmp".<br/>
	 */
	public static final String CHEMIN_GIF_EN_BMP 
		= "faussesextensions\\cgifrenommebmp.bmp";
	
	/**
	 * CHEMIN_GIF_SANS_EXTENSION : String :<br/>
	 * Chemin du fichier .gif sans extension 
	 * relativement à la racine des fichiers de test.<br/>
	 * "faussesextensions\\cgifsansextension".<br/>
	 */
	public static final String CHEMIN_GIF_SANS_EXTENSION
		= "faussesextensions\\cgifsansextension";
	
	/**
	 * CHEMIN_TXT_SANS_EXTENSION : String :<br/>
	 * Chemin du fichier .txt sans extension 
	 * relativement à la racine des fichiers de test.<br/>
	 * "faussesextensions\\2014-08-20_HITDIRIF2013_UTF-8".<br/>
	 */
	public static final String CHEMIN_TXT_SANS_EXTENSION
		= "faussesextensions\\2014-08-20_HITDIRIF2013_UTF-8";
	
	/**
	 * CHEMIN_TXT_FAUSSE_EXTENSION : String :<br/>
	 * Chemin du fichier .txt renommé en csv 
	 * relativement à la racine des fichiers de test.<br/>
	 * "faussesextensions\\2014-08-20_HITDIRIF2013_UTF-8txt.csv".<br/>
	 */
	public static final String CHEMIN_TXT_FAUSSE_EXTENSION
	= "faussesextensions\\2014-08-20_HITDIRIF2013_UTF-8txt.csv";
	
	
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
	 * FILE_TXT_ISO_8859_15 : File :<br/>
	 * Fichier texte en ISO-8859-15 .txt.<br/>
	 */
	public static final File FILE_TXT_ISO_8859_15
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_TXT_ISO_8859_15);
	
	/**
	 * FILE_CSV_UTF_8 : File :<br/>
	 * Fichier csv en UTF-8 .csv.<br/>
	 */
	public static final File FILE_CSV_UTF_8
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_CSV_UTF8);
	
	/**
	 * FILE_TXT_UTF_8 : File :<br/>
	 * Fichier texte en UTF-8 .txt.<br/>
	 */
	public static final File FILE_TXT_UTF_8
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_TXT_UTF8);

	/**
	 * FILE_PDF : File :<br/>
	 * Fichier Adobe Acrobat .pdf.<br/>
	 */
	public static final File FILE_PDF
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_PDF);
	
	/**
	 * FILE_XSD : File :<br/>
	 * Fichier schéma XML .xsd.<br/>
	 */
	public static final File FILE_XSD
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_XSD);
	
	/**
	 * FILE_XML : File :<br/>
	 * Document XML .xml.<br/>
	 */
	public static final File FILE_XML
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_XML);
	
	/**
	 * FILE_INI : File :<br/>
	 * Document ini .ini.<br/>
	 */
	public static final File FILE_INI
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_INI);
	
	/**
	 * FILE_PROPERTIES : File :<br/>
	 * Document properties .properties.<br/>
	 */
	public static final File FILE_PROPERTIES
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_PROPERTIES);
		
	/**
	 * FILE_DOCX : File :<br/>
	 * Document Word .docX.<br/>
	 */
	public static final File FILE_DOCX
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DOCX);
	
	/**
	 * FILE_HTML : File :<br/>
	 * Document HTML .html.<br/>
	 */
	public static final File FILE_HTML
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HTML);
	
	/**
	 * FILE_MP4 : File :<br/>
	 * Film .mp4.<br/>
	 */
	public static final File FILE_MP4
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_MP4);
	
	/**
	 * FILE_FLV : File :<br/>
	 * Film .flv.<br/>
	 */
	public static final File FILE_FLV
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_FLV);
	
	/**
	 * FILE_ASF : File :<br/>
	 * Film .asf.<br/>
	 */
	public static final File FILE_ASF
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_ASF);
	
	/**
	 * FILE_GIF_EN_BMP : File :<br/>
	 * Fichier .gif renommé en .bmp.<br/>
	 */
	public static final File FILE_GIF_EN_BMP 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_GIF_EN_BMP);
	
	/**
	 * FILE_GIF_SANS_EXTENSION : File :<br/>
	 * Fichier .gif sqns extension.<br/>
	 */
	public static final File FILE_GIF_SANS_EXTENSION 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_GIF_SANS_EXTENSION);
		
	/**
	 * FILE_TXT_SANS_EXTENSION : File :<br/>
	 * Fichier .txt sans extension.<br/>
	 */
	public static final File FILE_TXT_SANS_EXTENSION 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_TXT_SANS_EXTENSION);
	
	/**
	 * FILE_TXT_FAUSSE_EXTENSION : File :<br/>
	 * Fichier .txt renommé en .csv.<br/>
	 */
	public static final File FILE_TXT_FAUSSE_EXTENSION 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_TXT_FAUSSE_EXTENSION);
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(DetecteurTypeMimeTest.class);



	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR DetecteurTypeMimeTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DetecteurTypeMimeTest() {		
		/* Instanciation de la Super-Classe. */
		super();		
	} // Fin de DetecteurTypeMimeTest().___________________________________
	
	
	//*********************************************************************/
	// TESTS JAVA
	//*********************************************************************/
	
	/**
	 * method testGetMIMETypeFichierNull() :<br/>
	 * Garantit que getMIMEType(null) retourne 
	 * DetecteurTypeMime.MESSAGE_FICHIER_NULL.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeFichierNull() {
			
		/* Test avec un fichier null. */
		final String resultat = DetecteurTypeMime.getMIMEType(null);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_FICHIER_NULL : "
				, DetecteurTypeMime.MESSAGE_FICHIER_NULL, resultat);
		
	} // Fin de testGetMIMETypeFichierNull().______________________________
	

	
	/**
	 * method testGetMIMETypeFichierInexistant() :<br/>
	 * Garantit que getMIMEType(fichier inexistant) retourne 
	 * DetecteurTypeMime.MESSAGE_FICHIER_INEXISTANT.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeFichierInexistant() {
		
		/* Test avec un fichier inexistant. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_INEXISTANT);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_FICHIER_INEXISTANT : "
				, DetecteurTypeMime.MESSAGE_FICHIER_INEXISTANT, resultat);
		
	} // Fin de testGetMIMETypeFichierInexistant().________________________
	
	
	
	/**
	 * method testGetMIMETypeFichierRepertoire() :<br/>
	 * Garantit que getMIMEType(fichier repertoire) retourne 
	 * DetecteurTypeMime.MESSAGE_FICHIER_REPERTOIRE.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeFichierRepertoire() {

		/* Test avec un répertoire. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_REPERTOIRE);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_FICHIER_REPERTOIRE : "
				, DetecteurTypeMime.MESSAGE_FICHIER_REPERTOIRE, resultat);
		
	} // Fin de testGetMIMETypeFichierRepertoire().________________________

	
	
	//*********************************************************************/
	// TESTS FICHIERS DESSIN
	//*********************************************************************/

	/**
	 * method testGetMIMETypeDWG() :<br/>
	 * Garantit que getMIMEType(fichier .dwg) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeDWG() {
		
		/* Test avec un .dwg. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_DWG);
				
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeDWG().______________________________________

	
	
	//*********************************************************************/
	// TESTS FICHIERS DIVERS
	//*********************************************************************/
	
	/**
	 * method testGetMIMETypePPTX() :<br/>
	 * Garantit que getMIMEType(fichier .pptx) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypePPTX() {
		
		/* Test avec un .pptx. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_PPTX);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypePPTX()._____________________________________
	

	
	/**
	 * method testGetMIMETypeMID() :<br/>
	 * Garantit que getMIMEType(fichier .mid) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeMID() {
		
		/* Test avec un .mid. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_MID);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeMID().______________________________________
	

	
	/**
	 * method testGetMIMETypeEAP() :<br/>
	 * Garantit que getMIMEType(fichier .eap) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeEAP() {
		
		/* Test avec un .eap. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_EAP);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeEAP().______________________________________
	
	
	
	//*********************************************************************/
	// TESTS FICHIERS ICONE
	//*********************************************************************/

	/**
	 * method testGetMIMETypeICO() :<br/>
	 * Garantit que getMIMEType(fichier .ico) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeICO() {
		
		/* Test avec un .ico. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_ICO);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeICO().______________________________________
	

	
	//*********************************************************************/
	// TESTS FICHIERS IMAGE
	//*********************************************************************/

	/**
	 * method testGetMIMETypePNG() :<br/>
	 * Garantit que getMIMEType(fichier .png) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_PNG.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypePNG() {
		
		/* Test avec un .png. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_PNG);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_PNG : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_PNG, resultat);
		
	} // Fin de testGetMIMETypePNG().______________________________________
	
	
	
	/**
	 * method testGetMIMETypeJPG() :<br/>
	 * Garantit que getMIMEType(fichier .jpg) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_JPG.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeJPG() {
		
		/* Test avec un .jpg. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_JPG);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_JPG : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_JPG, resultat);
		
	} // Fin de testGetMIMETypeJPG().______________________________________
	

	
	/**
	 * method testGetMIMETypeGIF() :<br/>
	 * Garantit que getMIMEType(fichier .gif) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_GIF.<br/>
	 */
	@Test
	public void testGetMIMETypeGIF() {
		
		/* Test avec un .gif. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_GIF);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_GIF : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_GIF, resultat);
		
	} // Fin de testGetMIMETypeGIF().______________________________________
	
	
	
	/**
	 * method testGetMIMETypeBMP() :<br/>
	 * Garantit que getMIMEType(fichier .bmp) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_BMP.<br/>
	 */
	@Test
	public void testGetMIMETypeBMP() {
		
		/* Test avec un .bmp. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_BMP);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_BMP : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_BMP, resultat);
		
	} // Fin de testGetMIMETypeBMP().______________________________________
	

	
	/**
	 * method testGetMIMETypeXPS() :<br/>
	 * Garantit que getMIMEType(fichier .xps) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 */
	@Test
	public void testGetMIMETypeXPS() {
		
		/* Test avec un .xps. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_XPS);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeXPS().______________________________________
	
	
	
	//*********************************************************************/
	// TESTS MUSIQUE
	//*********************************************************************/

	/**
	 * method testGetMIMETypeMP3() :<br/>
	 * Garantit que getMIMEType(fichier .mp3) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 */
	@Test
	public void testGetMIMETypeMP3() {
		
		/* Test avec un .mp3. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_MP3);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeMP3().______________________________________
	
	
	
	/**
	 * method testGetMIMETypeWAV() :<br/>
	 * Garantit que getMIMEType(fichier .wav) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_WAV.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeWAV() {
		
		/* Test avec un .wav. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_WAV);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_WAV : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_WAV, resultat);
		
	} // Fin de testGetMIMETypeWAV().______________________________________
	

	
	//*********************************************************************/
	// TESTS TEXTE
	//*********************************************************************/

	/**
	 * method testGetMIMETypeTXTISO885915() :<br/>
	 * Garantit que getMIMEType(fichier .txt) encodé en ISO-8859-15 retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_TEXT_PLAIN.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeTXTISO885915() {
		
		/* Test avec un .txt encodé en ISO-8859-15. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_TXT_ISO_8859_15);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_TEXT_PLAIN : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_TEXT_PLAIN, resultat);
		
	} // Fin de testGetMIMETypeTXTISO885915()._____________________________
	
	
	
	/**
	 * method testGetMIMETypeCSVUTF8() :<br/>
	 * Garantit que getMIMEType(fichier .csv) encodé en UTF-8 retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMETypeCSVUTF8() {
		
		/* Test avec un .csv encodé en UTF-8. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_CSV_UTF_8);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeCSVUTF8().__________________________________
	
	
	
	/**
	 * method testGetMIMETypeTXTUTF8() :<br/>
	 * Garantit que getMIMEType(fichier .txt) encodé en UTF-8 retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_TEXT_PLAIN.<br/>
	 */
	@Test
	public void testGetMIMETypeTXTUTF8() {
		
		/* Test avec un .txt encodé en UTF-8. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_TXT_UTF_8);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_TEXT_PLAIN : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_TEXT_PLAIN, resultat);
		
	} // Fin de testGetMIMETypeTXTUTF8().__________________________________
	
	
	
	/**
	 * method testGetMIMETypePDF() :<br/>
	 * Garantit que getMIMEType(fichier .pdf) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_PDF.<br/>
	 */
	@Test
	public void testGetMIMETypePDF() {
		
		/* Test avec un .pdf. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_PDF);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_PDF : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_PDF, resultat);
		
	} // Fin de testGetMIMETypePDF().______________________________________
	

	
	/**
	 * method testGetMIMETypeXSD() :<br/>
	 * Garantit que getMIMEType(fichier .xsd) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_XML.<br/>
	 */
	@Test
	public void testGetMIMETypeXSD() {
		
		/* Test avec un .xsd. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_XSD);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_XML : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_XML, resultat);
		
	} // Fin de testGetMIMETypeXSD().______________________________________
	
	
	
	/**
	 * method testGetMIMETypeXML() :<br/>
	 * Garantit que getMIMEType(fichier .xml) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_XML.<br/>
	 */
	@Test
	public void testGetMIMETypeXML() {
		
		/* Test avec un .xml. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_XML);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_XML : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_XML, resultat);
		
	} // Fin de testGetMIMETypeXML().______________________________________
	

	
	/**
	 * method testGetMIMETypeINI() :<br/>
	 * Garantit que getMIMEType(fichier .ini) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 */
	@Test
	public void testGetMIMETypeINI() {
		
		/* Test avec un .ini. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_INI);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeINI().______________________________________
	
	
	
	/**
	 * method testGetMIMETypePROPERTIES() :<br/>
	 * Garantit que getMIMEType(fichier .properties) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 */
	@Test
	public void testGetMIMETypePROPERTIES() {
		
		/* Test avec un .properties. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_PROPERTIES);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypePROPERTIES()._______________________________
	
	
	
	/**
	 * method testGetMIMETypeDOCX() :<br/>
	 * Garantit que getMIMEType(fichier .docX) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 */
	@Test
	public void testGetMIMETypeDOCX() {
		
		/* Test avec un .docX. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_DOCX);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeDOCX()._____________________________________

	
	
	/**
	 * method testGetMIMETypeHTML() :<br/>
	 * Garantit que getMIMEType(fichier .html) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_HTML.<br/>
	 */
	@Test
	public void testGetMIMETypeHTML() {
		
		/* Test avec un .html. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_HTML);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_HTML : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_HTML, resultat);
		
	} // Fin de testGetMIMETypeHTML()._____________________________________
	
	
	//*********************************************************************/
	// TESTS VIDEO
	//*********************************************************************/
	
	/**
	 * method testGetMIMETypeMP4() :<br/>
	 * Garantit que getMIMEType(fichier .mp4) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 */
	@Test
	public void testGetMIMETypeMP4() {
		
		/* Test avec un .mp4. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_MP4);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeMP4().______________________________________
	
	
	
	/**
	 * method testGetMIMETypeFLV() :<br/>
	 * Garantit que getMIMEType(fichier .flv) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 */
	@Test
	public void testGetMIMETypeFLV() {
		
		/* Test avec un .flv. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_FLV);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeFLV().______________________________________
	

	
	/**
	 * method testGetMIMETypeASF() :<br/>
	 * Garantit que getMIMEType(fichier .asf) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 */
	@Test
	public void testGetMIMETypeASF() {
		
		/* Test avec un .asf. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_ASF);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeASF().______________________________________
	
	
	//*********************************************************************/
	// TESTS FAUSSES EXTENSIONS
	//*********************************************************************/
	
	
	/**
	 * method testGetMIMETypeGIFEnBMP() :<br/>
	 * Garantit que getMIMEType(fichier .gif renommé en .bmp) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_BMP.<br/>
	 */
	@Test
	public void testGetMIMETypeGIFEnBMP() {
		
		/* Test avec un .gif renommé en .bmp. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_GIF_EN_BMP);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_BMP : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_BMP, resultat);
		
	} // Fin de testGetMIMETypeGIFEnBMP()._________________________________
	
	
	
	/**
	 * method testGetMIMETypeGIFSansEXTENSION() :<br/>
	 * Garantit que getMIMEType(fichier .gif) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_GIF.<br/>
	 */
	@Test
	public void testGetMIMETypeGIFSansEXTENSION() {
		
		/* Test avec un .gif sans extension. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_GIF_SANS_EXTENSION);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_GIF : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_GIF, resultat);
		
	} // Fin de testGetMIMETypeGIFSansEXTENSION()._________________________
	
	
	
	/**
	 * method testGetMIMETypeTXTSansExtension() :<br/>
	 * Garantit que getMIMEType(fichier .txt sans extension) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 */
	@Test
	public void testGetMIMETypeTXTSansExtension() {
		
		/* Test avec un .txt sans extension. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_TXT_SANS_EXTENSION);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeTXTSansExtension()._________________________
	
	
	
	/**
	 * method testGetMIMETypeTXTFausseExtension() :<br/>
	 * Garantit que getMIMEType(fichier .txt avec une fausse extension) retourne 
	 * DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU.<br/>
	 */
	@Test
	public void testGetMIMETypeTXTFausseExtension() {
		
		/* Test avec un .txt renommé en .csv. */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_TXT_FAUSSE_EXTENSION);
		
		assertEquals("Doit retourner DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU : "
				, DetecteurTypeMime.MESSAGE_TYPE_MIME_INCONNU, resultat);
		
	} // Fin de testGetMIMETypeTXTFausseExtension()._______________________
	
	
	
	/**
	 * method testGetMIMEType() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testGetMIMEType() {
		
		/* Test avec un . . */
		final String resultat = DetecteurTypeMime.getMIMEType(FILE_TXT_FAUSSE_EXTENSION);
		System.out.println(resultat);
		assertTrue("bidon", 1 == 1);
	} // Fin de testGetMIMEType()._________________________________________

	
	
} // FIN DE LA CLASSE DetecteurTypeMimeTest.---------------------------------
