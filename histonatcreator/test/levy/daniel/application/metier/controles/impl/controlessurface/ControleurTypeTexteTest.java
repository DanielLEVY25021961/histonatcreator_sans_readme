package levy.daniel.application.metier.controles.impl.controlessurface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import levy.daniel.application.ILecteurDecodeurFile;
import levy.daniel.application.metier.controles.AbstractControle;
import levy.daniel.application.metier.controles.IControle;
import levy.daniel.application.metier.controles.rapportscontroles.LigneRapport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * class ControleurTypeTexteTest :<br/>
 * Test JUnit de la classe ControleurTypeTexte.<br/>
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
 * @since 27 févr. 2016
 *
 */
public class ControleurTypeTexteTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("fr", "FR").<br/>
	 */
	public static final Locale LOCALE_FR_FR = new Locale("fr", "FR");

	
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
	 * CHEMIN_FICHIERS_TRAFIC : String :<br/>
	 * Chemin des fichiers de trafic pour les tests 
	 * relativement à la racine du projet courant.<br/>
	 * ".\\test\\ressourcesjunit\\differentstypesfichiers\\texte\\trafics\\".<br/>
	 */
	public static final String CHEMIN_FICHIERS_TRAFIC 
		= ".\\test\\ressourcesjunit\\differentstypesfichiers\\texte\\trafics\\";

	
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
	 * CHEMIN_VIDE : String :<br/>
	 * Chemin d'un fichier vide.<br/>
	 * "vide.txt".<br/>
	 */
	public static final String CHEMIN_VIDE 
		= "texte\\vide.txt";
	
	
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
		= "texte\\eclipse.ini";
	
	
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
	
	
	/**
	 * CHEMIN_ANSI : String :<br/>
	 * Chemin du fichier .txt codé en ANSI 
	 * relativement à la racine des fichiers de test.<br/>
	 * "encodages\\chaàâreéèêëtte_ANSI.txt"
	 */
	public static final String CHEMIN_ANSI 
		= "encodages\\chaàâreéèêëtte_ANSI.txt";
	
	
	/**
	 * CHEMIN_DIACRITIQUES_ISO_8859_2 : String :<br/>
	 * Chemin du fichier .txt codé en ISO-8859-2 
	 * relativement à la racine des fichiers de test.<br/>
	 */
	public static final String CHEMIN_DIACRITIQUES_ISO_8859_2 
		= "encodages\\diacritiques_ISO-8859-2.txt";
	
	
	/**
	 * CHEMIN_DIACRITIQUES_UTF8 : String :<br/>
	 * Chemin du fichier .txt codé en UTF-8 
	 * relativement à la racine des fichiers de test.<br/>
	 */
	public static final String CHEMIN_DIACRITIQUES_UTF8 
		= "encodages\\diacritiques_UTF8.txt";

	/**
	 * CHEMIN_CHARETTE_ANSI : String :<br/>
	 * Chemin du fichier .txt codé en ANSI Windows_1252
	 * relativement à la racine des fichiers de test.<br/>
	 * 1 seule ligne "chaàâreéèêëtte € encodé en ANSI. 47 caractères.".<br/>
	 */
	public static final String CHEMIN_CHARETTE_ANSI 
		= "encodages\\chaàâreéèêëtte_ANSI.txt";
	

	/**
	 * CHEMIN_CHARETTE_OEM : String :<br/>
	 * Chemin du fichier .txt codé en OEM (IBM-850)
	 * relativement à la racine des fichiers de test.<br/>
	 * 1 seule ligne "chaàâreéèêëtte € encodé en UTF-8. 47 caractères.".<br/>
	 */
	public static final String CHEMIN_CHARETTE_OEM 
		= "encodages\\chaàâreéèêëtte_OEM.txt";
	

	/**
	 * CHEMIN_HIT_DIRA_2012 : String :<br/>
	 * "texte\\trafics\\trafics_2012\\2014-08-07_HITDIRA2012".<br/>
	 */
	public static final String CHEMIN_HIT_DIRA_2012 
		= "texte\\trafics\\trafics_2012\\2014-08-07_HITDIRA2012";

	
	/**
	 * CHEMIN_HIT_DIRO_2012 : String :<br/>
	 * "texte\\trafics\\trafics_2012\\2014-08-07_HITDIRO2012".<br/>
	 */
	public static final String CHEMIN_HIT_DIRO_2012 
		= "texte\\trafics\\trafics_2012\\2014-08-07_HITDIRO2012";
	
	
	/**
	 * CHEMIN_HIT_DIRA_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRA2014.txt".<br/>
	 */
	public static final String CHEMIN_HIT_DIRA_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRA2014.txt";
	
	
	/**
	 * CHEMIN_HIT_DIRCE_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRCE2014.txt".<br/>
	 */
	public static final String CHEMIN_HIT_DIRCE_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRCE2014.txt";

	
	/**
	 * CHEMIN_HIT_DIRCO_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRCO2014.txt".<br/>
	 */
	public static final String CHEMIN_HIT_DIRCO_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRCO2014.txt";
	
	/**
	 * CHEMIN_HIT_DIRE_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRE2014.txt".<br/>
	 */
	public static final String CHEMIN_HIT_DIRE_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRE2014.txt";

	
	/**
	 * CHEMIN_HIT_DIRIF_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRIF2014.txt".<br/>
	 */
	public static final String CHEMIN_HIT_DIRIF_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRIF2014.txt";

	
	/**
	 * CHEMIN_HIT_DIRMC_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRMC2014.txt".<br/>
	 */
	public static final String CHEMIN_HIT_DIRMC_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRMC2014.txt";

	
	/**
	 * CHEMIN_HIT_DIRMED_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRMED2014.txt".<br/>
	 */
	public static final String CHEMIN_HIT_DIRMED_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRMED2014.txt";

	/**
	 * CHEMIN_HIT_DIRN_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRN2014.txt".<br/>
	 */
	public static final String CHEMIN_HIT_DIRN_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRN2014.txt";
	
	/**
	 * CHEMIN_HIT_DIRNO_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRNO2014.txt".<br/>
	 */
	public static final String CHEMIN_HIT_DIRNO_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRNO2014.txt";
	
	/**
	 * CHEMIN_HIT_DIRO_2014 : String :<br/>
	 * "texte\\trafics\\trafics2014\\HITDIRO2014.txt".<br/>
	 */
	public static final String CHEMIN_HIT_DIRO_2014 
		= "texte\\trafics\\trafics_2014\\HITDIRO2014.txt";
	
	/**
	 * CHEMIN_HIT_DIRSO_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRSO2014.txt".<br/>
	 */
	public static final String CHEMIN_HIT_DIRSO_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRSO2014.txt";
	
	/**
	 * CHEMIN_DARWIN_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\darwin2014.csv".<br/>
	 */
	public static final String CHEMIN_DARWIN_2014 
		= "texte\\trafics\\trafics_2014\\darwin2014.csv";
	
	
	//*****************************************************************/
	//**************************FICHIERS ******************************/
	//*****************************************************************/
	
	/**
	 * FILE_NULL : File :<br/>
	 * Fichier null.<br/>
	 */
	public static final File FILE_NULL = null;
	
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
	 * FILE_VIDE : File :<br/>
	 * Fichier vide.<br/>
	 */
	public static final File FILE_VIDE 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_VIDE);
	
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
	 * FILE_CHARETTE_ANSI : File :<br/>
	 * Fichier .txt 
	 * contenant "chaàâreéèêëtte € encodé en ANSI. 47 caractères." 
	 * codé en ANSI.<br/>
	 */
	public static final File FILE_CHARETTE_ANSI 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_ANSI);

	
	/**
	 * FILE_CHARETTE_OEM : File :<br/>
	 * Fichier .txt 
	 * contenant "chaàâreéèêëtte € encodé en UTF-8. 47 caractères."
	 * codé en OEM (IBM-850).<br/>
	 */
	public static final File FILE_CHARETTE_OEM 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_CHARETTE_OEM);

	
	/**
	 * FILE_DIACRITIQUES_ISO_8859_2 : File : <br/>
	 * txt codé en ISO_8859_2.<br/>
	 */
	public static final File FILE_DIACRITIQUES_ISO_8859_2 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DIACRITIQUES_ISO_8859_2);
	
	
	/**
	 * FILE_DIACRITIQUES_UTF8 : File : <br/>
	 * txt codé en UTF-8.<br/>
	 */
	public static final File FILE_DIACRITIQUES_UTF8 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DIACRITIQUES_UTF8);
	
	
	/**
	 * FILE_HITDIRA2012 : File :<br/>
	 * "2014-08-07_HITDIRA2012".<br/>
	 */
	public static final File FILE_HITDIRA2012 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRA_2012);
	
	/**
	 * FILE_HITDIRO2012 : File :<br/>
	 * "2014-08-07_HITDIRO2012".<br/>
	 */
	public static final File FILE_HITDIRO2012 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRO_2012);

	
	/**
	 * FILE_HITDIRA2014 : File :<br/>
	 * HITDIRA2014.txt.<br/>
	 */
	public static final File FILE_HITDIRA2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRA_2014);
	
	/**
	 * FILE_HITDIRCE2014 : File :<br/>
	 * HITDIRCE2014.txt.<br/>
	 */
	public static final File FILE_HITDIRCE2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRCE_2014);
	
	/**
	 * FILE_HITDIRCO2014 : File :<br/>
	 * HITDIRCO2014.txt.<br/>
	 */
	public static final File FILE_HITDIRCO2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRCO_2014);

	/**
	 * FILE_HITDIRE2014 : File :<br/>
	 * HITDIRE2014.txt.<br/>
	 */
	public static final File FILE_HITDIRE2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRE_2014);
	
	/**
	 * FILE_HITDIRIF2014 : File :<br/>
	 * HITDIRIF2014.txt.<br/>
	 */
	public static final File FILE_HITDIRIF2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRIF_2014);
	
	
	/**
	 * FILE_HITDIRMC2014 : File :<br/>
	 * HITDIRMC2014.txt.<br/>
	 */
	public static final File FILE_HITDIRMC2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRMC_2014);
	
	/**
	 * FILE_HITDIRMED2014 : File :<br/>
	 * HITDIRMED2014.txt.<br/>	 
	 * */
	public static final File FILE_HITDIRMED2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRMED_2014);

	
	/**
	 * FILE_HITDIRN2014 : File :<br/>
	 * HITDIRN2014.txt.<br/>	 
	 */
	public static final File FILE_HITDIRN2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRN_2014);

	
	/**
	 * FILE_HITDIRNO2014 : File :<br/>
	 * HITDIRNO2014.txt.<br/>
	 */
	public static final File FILE_HITDIRNO2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRNO_2014);

	
	/**
	 * FILE_HITDIRO2014 : File :<br/>
	 * HITDIRO2014.txt.<br/>
	 */
	public static final File FILE_HITDIRO2014 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRO_2014);
	
	/**
	 * FILE_HITDIRSO2014 : File :<br/>
	 * HITDIRSO2014.txt.<br/>
	 */
	public static final File FILE_HITDIRSO2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRSO_2014);
	
	/**
	 * FILE_DARWIN2014 : File :<br/>
	 * "darwin2014.csv".<br/>
	 */
	public static final File FILE_DARWIN2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DARWIN_2014);
	

	/**
	 * LISTEFILES : List<File> :<br/>
	 * Liste contenant tous les File utilisés pour les tests.<br/>
	 */
	public static final List<File> LISTEFILES = new ArrayList<File>();

	
	/**
	 * LISTEFILES_NON_TXT : List<File> :<br/>
	 * Liste contenant tous les File non TXT utilisés pour les tests.<br/>
	 */
	public static final List<File> LISTEFILES_NON_TXT = new ArrayList<File>();

	
	/**
	 * LISTEFILES_TXT : List<File> :<br/>
	 * Liste contenant tous les File TXT utilisés pour les tests.<br/>
	 */
	public static final List<File> LISTEFILES_TXT = new ArrayList<File>();

	
	/**
	 * LISTEFILES_TRAFIC : List<File> :<br/>
	 * Liste contenant tous les File de trafic utilisés pour les tests.<br/>
	 */
	public static final List<File> LISTEFILES_TRAFIC = new ArrayList<File>();


	
	/* Bloc statique pour remplir la liste des Files. */
	static {
		
		LISTEFILES.add(FILE_NULL);
		LISTEFILES.add(FILE_INEXISTANT);
		LISTEFILES.add(FILE_REPERTOIRE);
		LISTEFILES.add(FILE_DWG);
		LISTEFILES.add(FILE_PPTX);
		LISTEFILES.add(FILE_EAP);
		LISTEFILES.add(FILE_ICO);
		LISTEFILES.add(FILE_PNG);
		LISTEFILES.add(FILE_JPG);
		LISTEFILES.add(FILE_GIF);
		LISTEFILES.add(FILE_BMP);
		LISTEFILES.add(FILE_XPS);
		LISTEFILES.add(FILE_MP3);
		LISTEFILES.add(FILE_WAV);
		LISTEFILES.add(FILE_TXT_ISO_8859_15);
		LISTEFILES.add(FILE_CSV_UTF_8);
		LISTEFILES.add(FILE_TXT_UTF_8);
		LISTEFILES.add(FILE_PDF);
		LISTEFILES.add(FILE_XSD);
		LISTEFILES.add(FILE_XML);
		LISTEFILES.add(FILE_INI);
		LISTEFILES.add(FILE_PROPERTIES);
		LISTEFILES.add(FILE_DOCX);
		LISTEFILES.add(FILE_HTML);
		LISTEFILES.add(FILE_MP4);
		LISTEFILES.add(FILE_FLV);
		LISTEFILES.add(FILE_ASF);
		LISTEFILES.add(FILE_GIF_EN_BMP);
		LISTEFILES.add(FILE_GIF_SANS_EXTENSION);
		LISTEFILES.add(FILE_TXT_SANS_EXTENSION);
		LISTEFILES.add(FILE_TXT_FAUSSE_EXTENSION);
		
	}
	
	/* Bloc statique pour remplir la liste des Files non TXT. */
	static {
		
		LISTEFILES_NON_TXT.add(FILE_DWG);
		LISTEFILES_NON_TXT.add(FILE_PPTX);
		LISTEFILES_NON_TXT.add(FILE_EAP);
		LISTEFILES_NON_TXT.add(FILE_ICO);
		LISTEFILES_NON_TXT.add(FILE_PNG);
		LISTEFILES_NON_TXT.add(FILE_JPG);
		LISTEFILES_NON_TXT.add(FILE_GIF);
		LISTEFILES_NON_TXT.add(FILE_BMP);
		LISTEFILES_NON_TXT.add(FILE_XPS);
		LISTEFILES_NON_TXT.add(FILE_MP3);
		LISTEFILES_NON_TXT.add(FILE_WAV);
		LISTEFILES_NON_TXT.add(FILE_PDF);
		LISTEFILES_NON_TXT.add(FILE_DOCX);
		LISTEFILES_NON_TXT.add(FILE_MP4);
		LISTEFILES_NON_TXT.add(FILE_FLV);
		LISTEFILES_NON_TXT.add(FILE_ASF);
		LISTEFILES_NON_TXT.add(FILE_GIF_EN_BMP);
		LISTEFILES_NON_TXT.add(FILE_GIF_SANS_EXTENSION);
		
	}

	
	/* Bloc statique pour remplir la liste des Files TXT. */
	static {
		
		LISTEFILES_TXT.add(FILE_TXT_ISO_8859_15);
		LISTEFILES_TXT.add(FILE_CSV_UTF_8);
		LISTEFILES_TXT.add(FILE_TXT_UTF_8);
		LISTEFILES_TXT.add(FILE_XSD);
		LISTEFILES_TXT.add(FILE_XML);
		LISTEFILES_TXT.add(FILE_INI);
		LISTEFILES_TXT.add(FILE_PROPERTIES);
		LISTEFILES_TXT.add(FILE_HTML);
		LISTEFILES_TXT.add(FILE_TXT_SANS_EXTENSION);
		LISTEFILES_TXT.add(FILE_TXT_FAUSSE_EXTENSION);
		LISTEFILES_TXT.add(FILE_CHARETTE_ANSI);
		LISTEFILES_TXT.add(FILE_CHARETTE_OEM);
		LISTEFILES_TXT.add(FILE_DIACRITIQUES_ISO_8859_2);
		LISTEFILES_TXT.add(FILE_DIACRITIQUES_UTF8);
		
	}


	//*****************************************************************/
	//**************************CHARSETS ******************************/
	//*****************************************************************/

	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	public static final Charset CHARSET_UTF8 
		= Charset.forName("UTF-8");

	
	/**
	 * CHARSET_US_ASCII : Charset :<br/>
	 * Charset.forName("US-ASCII").<br/>
	 * Seven-bit ASCII, a.k.a. ISO646-US, 
	 * a.k.a. the Basic Latin block of the Unicode character set.<br/>
	 * standard américain.<br/>
	 * American Standard Code for Information Interchange.<br/> 
	 * 128 caractères imprimables.<br/> 
	 * Sert à écrire l’anglo-américain.<br/> 
	 * Ne permet pas d’écrire les langues européennes 
	 * qui utilisent des lettres avec diacritiques (accents, cédille, ...).<br/> 
	 * On ne peut pas écrire en français avec de l’ASCII.<br/>
	 */
	public static final Charset CHARSET_US_ASCII 
		= Charset.forName("US-ASCII");
	
	/**
	 * CHARSET_ISO_8859_1 : Charset :<br/>
	 * Charset.forName("ISO-8859-1").<br/>
	 * Latin1.<br/>
	 * 191 caractères imprimables.<br/> 
	 * Permet d’écrire la plupart des langues d’Europe de l’Ouest.<br/> 
	 * Presque tous les caractères du français y sont (manquent le œ et €).<br/>
	 */
	public static final Charset CHARSET_ISO_8859_1 
		= Charset.forName("ISO-8859-1");

	
	/**
	 * CHARSET_LATIN1 : Charset :<br/>
	 * Charset.forName("ISO-8859-1").<br/>
	 * Latin1.<br/>
	 * 191 caractères imprimables.<br/> 
	 * Permet d’écrire la plupart des langues d’Europe de l’Ouest.<br/> 
	 * Presque tous les caractères du français y sont (manquent le œ et €).<br/>
	 */
	public static final Charset CHARSET_LATIN1 
		= Charset.forName("ISO-8859-1");

	
	/**
	 * CHARSET_ISO_8859_2 : Charset :<br/>
	 * Charset.forName("ISO-8859-2").<br/>
	 * <br/>
	 */
	public static final Charset CHARSET_ISO_8859_2 
		= Charset.forName("ISO-8859-2");
	
	
	/**
	 * CHARSET_ISO_8859_9 : Charset :<br/>
	 * Charset.forName("ISO-8859-9").<br/>
	 * Latin Alphabet No. 5<br/>
	 */
	public static final Charset CHARSET_ISO_8859_9 
		= Charset.forName("ISO-8859-9");

	
	/**
	 * CHARSET_ISO_8859_15 : Charset :<br/>
	 * Charset.forName("ISO-8859-15").<br/>
	 * Latin9, Latin Alphabet No. 9.<br/>
	 * modifie légèrement ISO-8859-1.<br/> 
	 * Ajout du caractère œ et du symbole monétaire € (Euro) entre autres.<br/>
	 */
	public static final Charset CHARSET_ISO_8859_15 
		= Charset.forName("ISO-8859-15");
	
	
	/**
	 * CHARSET_LATIN9 : Charset :<br/>
	 * Charset.forName("ISO-8859-15").<br/>
	 * Latin9, Latin Alphabet No. 9.<br/>
	 * modifie légèrement ISO-8859-1.<br/> 
	 * Ajout du caractère œ et du symbole monétaire € (Euro) entre autres.<br/>
	 */
	public static final Charset CHARSET_LATIN9 
		= Charset.forName("ISO-8859-15");
	
	
	/**
	 * CHARSET_WINDOWS_1252 : Charset :<br/>
	 * Charset.forName("windows-1252").<br/>
	 * ANSI, CP1252.<br/>
	 * 218 caractères imprimables.<br/>
	 * extension d’ISO-8859-1, qui rajoute quelques caractères: œ, € (euro), 
	 * guillemets anglais (« »), points de suspension (...)
	 * , signe «pour mille» (‰), 
	 * tirets cadratin (— = \u2014 en unicode ) et demi-cadratin (–), ...<br/>
	 */
	public static final Charset CHARSET_WINDOWS_1252 
		= Charset.forName("windows-1252");

	
	/**
	 * CHARSET_ANSI : Charset :<br/>
	 * Charset.forName("windows-1252").<br/>
	 * ANSI, CP1252.<br/>
	 * 218 caractères imprimables.<br/>
	 * extension d’ISO-8859-1, qui rajoute quelques caractères: œ, € (euro), 
	 * guillemets anglais (« »), points de suspension (...)
	 * , signe «pour mille» (‰), 
	 * tirets cadratin (— = \u2014 en unicode ) et demi-cadratin (–), ...<br/>
	 */
	public static final Charset CHARSET_ANSI
		= Charset.forName("windows-1252");

	
	/**
	 * CHARSET_CP1252 : Charset :<br/>
	 * Charset.forName("windows-1252").<br/>
	 * ANSI, CP1252.<br/>
	 * 218 caractères imprimables.<br/>
	 * extension d’ISO-8859-1, qui rajoute quelques caractères: œ, € (euro), 
	 * guillemets anglais (« »), points de suspension (...)
	 * , signe «pour mille» (‰), 
	 * tirets cadratin (— = \u2014 en unicode ) et demi-cadratin (–), ...<br/>
	 */
	public static final Charset CHARSET_CP1252
		= Charset.forName("windows-1252");

	
	/**
	 * CHARSET_IBM850 : Charset :<br/>
	 * Charset IBM-850.<br/>
	 * Cp850, MS-DOS Latin-1.<br/>
	 */
	public static final Charset CHARSET_IBM850
		= Charset.forName("IBM-850");
	

	//*****************************************************************/
	//**************************** SAUTS ******************************/
	//*****************************************************************/

	/**
	 * SAUTDELIGNE_UNIX : String :<br/>
	 * Saut de ligne généré par les éditeurs Unix.<br/>
	 * "\n" (Retour Ligne = LINE FEED (LF)).
	 */
	public static final String SAUTDELIGNE_UNIX = "\n";

	
	/**
	 * SAUTDELIGNE_MAC : String :<br/>
	 * Saut de ligne généré par les éditeurs Mac.<br/>
	 * "\r" (Retour Chariot RC = CARRIAGE RETURN (CR))
	 */
	public static final String SAUTDELIGNE_MAC = "\r";

	
	/**
	 * SAUTDELIGNE_DOS_WINDOWS : String :<br/>
	 * Saut de ligne généré par les éditeurs DOS/Windows.<br/>
	 * "\r\n" (Retour Chariot RC + Retour Ligne Line Feed LF).
	 */
	public static final String SAUTDELIGNE_DOS_WINDOWS = "\r\n";

	
	/**
	 * NEWLINE : String :<br/>
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	public static final String NEWLINE = System.getProperty("line.separator");


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(ControleurTypeTexteTest.class);
	

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ControleurTypeTexteTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 * - Remplit LISTEFILES_TRAFIC.<br/>
	 * <br/>
	 */
	public ControleurTypeTexteTest() {
		
		super();
		
		/* Remplit LISTEFILES_TRAFIC. */
		remplirListeTrafics();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method remplirListeTrafics() :<br/>
	 * Remplit LISTEFILES_TRAFIC.<br/>
	 * <br/>
	 */
	public static void remplirListeTrafics() {
		
		/* Récupère le répertoire trafics. */
		final File repertoireTrafics = new File(CHEMIN_FICHIERS_TRAFIC);
		
		/* récupère le tableau des enfants de repertoireTrafics. */
		final File[] tableauRepertoires = repertoireTrafics.listFiles();
		
		if (tableauRepertoires == null) {
			return;
		}
		
		/* remplit la liste des sous-répertoires de trafics. */		
		final List<File> listeSousRepertoires 
			= Arrays.asList(tableauRepertoires);
		
		/* Remplit LISTEFILES_TRAFIC. */
		for (final File rep : listeSousRepertoires) {
			
			if (rep.isDirectory()) {
				
				final File[] tabContenuSousRep = rep.listFiles();
				
				if (tabContenuSousRep != null) {
					
					for (int j = 0; j < tabContenuSousRep.length; j++) {
						
						if (!tabContenuSousRep[j].isDirectory()) {
							LISTEFILES_TRAFIC.add(tabContenuSousRep[j]);
						}						
					}
				}
					
			}
			else {
				LISTEFILES_TRAFIC.add(rep);
			}
		}
		
	} // Fin de remplirListeTrafics()._____________________________________
	
	
	
	/**
	 * method testConstructeurAriteNulle() :<br/>
	 * teste le constructeur d'arité nulle.<br/>
	 * <br/>
	 * - Vérifie que bundleControles est bien chargé.<br/>
	 * - Vérifie que la date du contrôle n'est pas null.<br/>
	 * - Vérifie que la date formattée n'est pas null.<br/>
	 * - Vérifie que userName == 'Administrateur'.<br/>
	 * - Vérifie que fichier == null.<br/>
	 * - Vérifie que nomFichier == null.<br/>
	 * - Vérifie que typeControle == "Contrôle de surface".<br/>
	 * - Vérifie que nomControle == "Contrôle fichier texte".<br/>
	 * - Vérifie que nomCritere == "Le fichier ne doit pas comporter 
	 * de caractères indésirables (impossibles à écrire au clavier)".<br/>
	 * - Vérifie que niveauAnomalie == 1.<br/>
	 * - Vérifie que estBloquant prend la bonne valeur.<br/>
	 * - Vérifie que gravite == "1 - anomalie bloquante".<br/>
	 * - Vérifie que setFile() fonctionne.<br/>
	 * <br/>
	 */
	@Test
	public void testConstructeurAriteNulle() {
		
		/* Instanciation d'un ControleurTypeTexte 
		 * avec le constructeur d'arité nulle. */
		final ControleurTypeTexte control = new ControleurTypeTexte();
		
		/* Vérifie que bundleControles est bien chargé. */
		assertNotNull("bundleControles doit être chargé : "
				, AbstractControle.bundleControles);
		
		/* Vérifie que la date du contrôle n'est pas null. */
		assertNotNull("dateControle ne doit pas être null : "
				, control.getDateControle());
		
		/* Vérifie que la date formattée n'est pas null. */
		assertNotNull("dateControleStringFormatee ne doit pas être null : "
				, control.getDateControleStringFormatee());
		
		/* Vérifie que userName == 'Administrateur'. */
		assertEquals("usrName doit valoir 'Administrateur' : "
				, "Administrateur"
					, control.getUserName());
		
		/* Vérifie que fichier == null. */
		assertNull("fichier doit être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier == null. */
		assertNull("nomFichier doit être null : "
				, control.getNomFichier());
		
		/* Vérifie que typeControle == "Contrôle de surface". */
		assertEquals("typeControle doit valoir 'Contrôle de surface' : "
				, "Contrôle de surface"
					, control.getTypeControle());
		
		/* Vérifie que nomControle == "Contrôle fichier texte". */
		assertEquals("nomControle doit valoir 'Contrôle fichier texte' : "
				, "Contrôle fichier texte"
					, control.getNomControle());
		
		/* Vérifie que nomCritere == "Le fichier ne comporte aucun caractère indésirable (impossible à écrire au clavier)". */
		assertEquals("nomCritere doit valoir 'Le fichier ne comporte aucun caractère indésirable (impossible à écrire au clavier)' : "
				, "Le fichier ne comporte aucun caractère indésirable (impossible à écrire au clavier)"
					, control.getNomCritere());
				
		/* Vérifie que niveauAnomalie == 1. */
		assertEquals("niveauAnomalie doit valoir 1 : "
				, "1"
					, control.getNiveauAnomalie());
		
		/* Vérifie que estBloquant prend la bonne valeur. */
		assertTrue("estBloquant doit valoir true : "
				, control.isEstBloquant());
		
		/* Vérifie que gravite == "1 - anomalie bloquante". */
		assertEquals("gravite doit valoir '1 - anomalie bloquante' : "
				, "1 - anomalie bloquante"
					, control.getGravite());
		
		/* Vérifie que setFile() fonctionne. */
		control.setFichier(FILE_TXT_FAUSSE_EXTENSION);
		
		assertNotNull("fichier ne doit pas être null : "
				, control.getFichier());
		
		assertNotNull("nomFichier ne doit pas être null : "
				, control.getNomFichier());
		
	} // Fin de testConstructeurAriteNulle().______________________________
	
	
	
	/**
	 * method testLireFichierNull() :<br/>
	 * teste la méthode lireFichier(File pFile, Charset pCharset).<br/>
	 * <br/>
	 * - vérifie que lireFichier(FILE_NULL, ...) retourne 
	 * ILecteurDecodeurFile.MESSAGE_FICHIER_NULL.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testLireFichierNull() {
		
		/* Instanciation d'un contrôle. */
		final IControle control = new ControleurTypeTexte();
		
		// LECTURE PAR LE CONTROLE.************
		final String resultat = control.lireFichier(FILE_NULL, null);
				
		/* vérifie que lireFichier(FILE_NULL, ...) retourne 
		 * ControleurTypeTexte.MESSAGE_FICHIER_NULL. */
		assertEquals("doit retourner MESSAGE_FICHIER_NULL : "
				, ILecteurDecodeurFile.MESSAGE_FICHIER_NULL
					, resultat);
		
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
		
//		System.out.println(control.afficherRapportTextuel());
		
	} // Fin de testLireFichierNull()._____________________________________
	

	
	/**
	 * method testLireFichierInexistant() :<br/>
	 * teste la méthode lireFichier(File pFile, Charset pCharset).<br/>
	 * <br/>
	 * - vérifie que lireFichier(FILE_INEXISTANT, ...) retourne 
	 * ILecteurDecodeurFile.MESSAGE_FICHIER_INEXISTANT.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testLireFichierInexistant() {
				
		/* Instanciation d'un contrôle. */
		final IControle control = new ControleurTypeTexte();
		
		// LECTURE PAR LE CONTROLE.************
		final String resultat = control.lireFichier(FILE_INEXISTANT, null);
				
		/* vérifie que lireFichier(FILE_INEXISTANT, ...) retourne 
		 * ControleurTypeTexte.MESSAGE_FICHIER_INEXISTANT. */
		assertEquals("doit retourner MESSAGE_FICHIER_INEXISTANT : "
				, ILecteurDecodeurFile.MESSAGE_FICHIER_INEXISTANT
					, resultat);
		
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
		
//		System.out.println(control.afficherRapportTextuel());
			
	} // Fin de testLireFichierInexistant()._______________________________
	

	
	/**
	 * method testLireFichierRepertoire() :<br/>
	 * teste la méthode lireFichier(File pFile, Charset pCharset).<br/>
	 * <br/>
	 * - vérifie que lireFichier(FILE_REPERTOIRE, ...) retourne 
	 * ILecteurDecodeurFile.MESSAGE_FICHIER_REPERTOIRE.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testLireFichierRepertoire() {
		
		/* Instanciation d'un contrôle. */
		final IControle control = new ControleurTypeTexte();
		
		// LECTURE PAR LE CONTROLE.************
		final String resultat = control.lireFichier(FILE_REPERTOIRE, null);
				
		/* vérifie que lireFichier(FILE_REPERTOIRE, ...) retourne 
		 * ControleurTypeTexte.MESSAGE_FICHIER_REPERTOIRE. */
		assertEquals("doit retourner MESSAGE_FICHIER_REPERTOIRE : "
				, ILecteurDecodeurFile.MESSAGE_FICHIER_REPERTOIRE
					, resultat);
		
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
		
//		System.out.println(control.afficherRapportTextuel());
		
	} // Fin de testLireFichierRepertoire()._______________________________
	

	
	/**
	 * method testLireFichierVide() :<br/>
	 * teste la méthode lireFichier(File pFile, Charset pCharset).<br/>
	 * <br/>
	 * - vérifie que lireFichier(FILE_VIDE, ...) retourne 
	 * ILecteurDecodeurFile.MESSAGE_FICHIER_REPERTOIRE.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testLireFichierVide() {
		
		/* Instanciation d'un contrôle. */
		final IControle control = new ControleurTypeTexte();
		
		// LECTURE PAR LE CONTROLE.************
		final String resultat = control.lireFichier(FILE_VIDE, null);
				
		/* vérifie que lireFichier(FILE_VIDE, ...) retourne 
		 * ControleurTypeTexte.MESSAGE_FICHIER_VIDE. */
		assertEquals("doit retourner MESSAGE_FICHIER_VIDE : "
				, ILecteurDecodeurFile.MESSAGE_FICHIER_VIDE
					, resultat);
		
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
		
//		System.out.println(control.afficherRapportTextuel());

	} // Fin de testLireFichierVide()._____________________________________

	
	
	/**
	 * method testLireFichier() :<br/>
	 * Utile pour tester la méthode lireFichier(File pFile, Charset pCharset).<br/>
	 * (Réactiver l'annotation @Test).<br/>
	 * <br/>
	 */
//	@Test
	public void testLireFichier() {
		
		final ControleurTypeTexte control = new ControleurTypeTexte();
		final String resultat = control.lireFichier(FILE_PROPERTIES, null);
		final String listeCaract = control.listerChaineCarParCar(resultat);
		System.out.println(listeCaract);
		
	} // Fin de testLireFichier()._________________________________________

	

	/**
	 * method testControlerFileNull() :<br/>
	 * Teste la méthode controler(File null).<br/>
	 * <br/>
	 * - Vérifie que la méthode retourne false.<br/>
	 * - Vérifie que fichier == null.<br/>
	 * - Vérifie que nomFichier == null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileNull() {
		
		/* Instanciation d'un ControleurTypeTexte 
		 * avec le constructeur d'arité nulle. */
		final ControleurTypeTexte control = new ControleurTypeTexte();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_NULL);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_NULL, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
		/* Affichage du rapport d'enregistrement des rapports. */
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que la méthode retourne false. */
		assertFalse("controler(null) doit retourner false : "
				, resultat);
		
		/* Vérifie que fichier == null. */
		assertNull("fichier doit être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier == null. */
		assertNull("nomFichier doit être null : "
				, control.getNomFichier());
		
	
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
				
	} // Fin de testControlerFileNull().___________________________________
	

	
	/**
	 * method testControlerFileInexistant() :<br/>
	 * Teste la méthode controler(File inexistant).<br/>
	 * <br/>
	 * - Vérifie que la méthode retourne false.<br/>
	 * - Vérifie que fichier == null.<br/>
	 * - Vérifie que nomFichier == null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileInexistant() {
		
		/* Instanciation d'un ControleurTypeTexte 
		 * avec le constructeur d'arité nulle. */
		final ControleurTypeTexte control = new ControleurTypeTexte();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_INEXISTANT);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_INEXISTANT, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
		/* Affichage du rapport d'enregistrement des rapports. */
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que la méthode retourne false. */
		assertFalse("controler(inexistant) doit retourner false : "
				, resultat);
		
		/* Vérifie que fichier == null. */
		assertNull("fichier doit être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier == null. */
		assertNull("nomFichier doit être null : "
				, control.getNomFichier());
		
	
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
				
	} // Fin de testControlerFileInexistant()._____________________________
	

	
	/**
	 * method testControlerFileRepertoire() :<br/>
	 * Teste la méthode controler(File repertoire).<br/>
	 * <br/>
	 * - Vérifie que la méthode retourne false.<br/>
	 * - Vérifie que fichier == null.<br/>
	 * - Vérifie que nomFichier == null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileRepertoire() {
		
		/* Instanciation d'un ControleurTypeTexte 
		 * avec le constructeur d'arité nulle. */
		final ControleurTypeTexte control = new ControleurTypeTexte();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_REPERTOIRE);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_REPERTOIRE, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
		/* Affichage du rapport d'enregistrement des rapports. */
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que la méthode retourne false. */
		assertFalse("controler(repertoire) doit retourner false : "
				, resultat);
		
		/* Vérifie que fichier == null. */
		assertNull("fichier doit être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier == null. */
		assertNull("nomFichier doit être null : "
				, control.getNomFichier());
		
	
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
		
	} // Fin de testControlerFileRepertoire()._____________________________


	
	/**
	 * method testControlerFileVide() :<br/>
	 * Teste la méthode controler(File vide).<br/>
	 * <br/>
	 * - Vérifie que la méthode retourne false.<br/>
	 * - Vérifie que fichier == null.<br/>
	 * - Vérifie que nomFichier == null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileVide() {
		
		/* Instanciation d'un ControleurTypeTexte 
		 * avec le constructeur d'arité nulle. */
		final ControleurTypeTexte control = new ControleurTypeTexte();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_VIDE);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_REPERTOIRE, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
		/* Affichage du rapport d'enregistrement des rapports. */
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que la méthode retourne false. */
		assertFalse("controler(vide) doit retourner false : "
				, resultat);
		
		/* Vérifie que fichier == null. */
		assertNull("fichier doit être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier == null. */
		assertNull("nomFichier doit être null : "
				, control.getNomFichier());
		
	
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
		
	} // Fin de testControlerFileVide().___________________________________


	
	/**
	 * method testControlerFileNonTextuel() :<br/>
	 * Teste la méthode controler(File non textuel).<br/>
	 * <br/>
	 * - Vérifie que la méthode retourne false.<br/>
	 * - Vérifie que fichier n'est pas null.<br/>
	 * - Vérifie que nomFichier n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileNonTextuel() {
		
		/* Instanciation d'un ControleurTypeTexte 
		 * avec le constructeur d'arité nulle. */
		final ControleurTypeTexte control = new ControleurTypeTexte();
		
		/* invocation de la méthode controler(File non textuel). */
		final boolean resultat = control.controler(FILE_GIF);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_REPERTOIRE, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
		/* Affichage du rapport d'enregistrement des rapports. */
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que la méthode retourne false. */
		assertFalse("controler(non textuel) doit retourner false : "
				, resultat);
		
		/* Vérifie que fichier != null. */
		assertNotNull("fichier ne doit pas être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier != null. */
		assertNotNull("nomFichier ne doit pas être null : "
				, control.getNomFichier());
		
	
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
		
	} // Fin de testControlerFileNonTextuel()._____________________________

	
	
	/**
	 * method testControlerFileAnsi() :<br/>
	 * Teste la méthode controler(File pFile ANSI).<br/>
	 * <br/>
	 * - Vérifie que controler(ANSI) retourne true.<br/>
	 * - Vérifie que fichier n'est pas null.<br/>
	 * - Vérifie que nomFichier n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileAnsi() {
		
		/* Instanciation d'un ControleurTypeTexte 
		 * avec le constructeur d'arité nulle. */
		final ControleurTypeTexte control = new ControleurTypeTexte();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_CHARETTE_ANSI);
		
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_CHARETTE_ANSI, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
		/* Affichage du rapport d'enregistrement des rapports. */
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que controler(ANSI) retourne true. */
		assertTrue("La méthode controler(ANSI) doit retourner true : "
					, resultat);
		
		/* Vérifie que fichier != null. */
		assertNotNull("fichier ne doit pas être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier != null. */
		assertNotNull("nomFichier ne doit pas être null : "
				, control.getNomFichier());
		
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport est non vide. */
		assertFalse("Le rapport doit être non vide : "
				, rapport.isEmpty());
		
	} // Fin de testControlerFileAnsi().___________________________________


	
	/**
	 * method testControlerFileOem() :<br/>
	 * Teste la méthode controler(File pFile OEM).<br/>
	 * <br/>
	 * - Vérifie que controler(OEM) retourne true.<br/>
	 * - Vérifie que fichier n'est pas null.<br/>
	 * - Vérifie que nomFichier n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileOem() {
		
		/* Instanciation d'un ControleurTypeTexte 
		 * avec le constructeur d'arité nulle. */
		final ControleurTypeTexte control = new ControleurTypeTexte();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_CHARETTE_OEM);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_CHARETTE_OEM, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
		/* Affichage du rapport d'enregistrement des rapports. */
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que controler(OEM) retourne true. */
		assertTrue("La méthode controler(OEM) doit retourner true : "
					, resultat);
		
		/* Vérifie que fichier != null. */
		assertNotNull("fichier ne doit pas être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier != null. */
		assertNotNull("nomFichier ne doit pas être null : "
				, control.getNomFichier());
		
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport est non vide. */
		assertFalse("Le rapport doit être non vide : "
				, rapport.isEmpty());
		
	} // Fin de testControlerFileOem().____________________________________
	
	
	
	/**
	 * method testControlerFileLatin2() :<br/>
	 * Teste la méthode controler(File pFile LATIN2).<br/>
	 * <br/>
	 * - Vérifie que controler(LATIN2) retourne true.<br/>
	 * - Vérifie que fichier n'est pas null.<br/>
	 * - Vérifie que nomFichier n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileLatin2() {
		
		/* Instanciation d'un ControleurTypeTexte 
		 * avec le constructeur d'arité nulle. */
		final ControleurTypeTexte control = new ControleurTypeTexte();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_DIACRITIQUES_ISO_8859_2);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_DIACRITIQUES_ISO_8859_2, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
		/* Affichage du rapport d'enregistrement des rapports. */
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que controler(LATIN2) retourne true. */
		assertTrue("La méthode controler(LATIN2) doit retourner true : "
					, resultat);
		
		/* Vérifie que fichier != null. */
		assertNotNull("fichier ne doit pas être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier != null. */
		assertNotNull("nomFichier ne doit pas être null : "
				, control.getNomFichier());
		
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport est non vide. */
		assertFalse("Le rapport doit être non vide : "
				, rapport.isEmpty());
		
	} // Fin de testControlerFileLatin2()._________________________________
	
	
	
	/**
	 * method testControlerFileUtf8() :<br/>
	 * Teste la méthode controler(File pFile UTF-8).<br/>
	 * <br/>
	 * - Vérifie que controler(UTF-8) retourne true.<br/>
	 * - Vérifie que fichier n'est pas null.<br/>
	 * - Vérifie que nomFichier n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileUtf8() {
		
		/* Instanciation d'un ControleurTypeTexte 
		 * avec le constructeur d'arité nulle. */
		final ControleurTypeTexte control = new ControleurTypeTexte();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_DIACRITIQUES_UTF8);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_DIACRITIQUES_UTF8, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que controler(UTF-8) retourne true. */
		assertTrue("La méthode controler(UTF-8) doit retourner true : "
					, resultat);
		
		/* Vérifie que fichier != null. */
		assertNotNull("fichier ne doit pas être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier != null. */
		assertNotNull("nomFichier ne doit pas être null : "
				, control.getNomFichier());
		
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport est non vide. */
		assertFalse("Le rapport doit être non vide : "
				, rapport.isEmpty());
		
	} // Fin de testControlerFileUtf8().___________________________________
	
	
	
	/**
	 * method testControler() :<br/>
	 * Test de la méthode controler(File pFile).<br/>
	 * <br/>
	 * - vérifie que la méthode détecte correctement les fichiers texte.<br/>
	 * Utilise un jeu de fichiers texte encodés 
	 * avec divers Charsets (UTF-8, ANSI, ...) 
	 * et un jeu de fichiers non texte (.wav, . mp3, ..).<br/>
	 * <br/>
	 */
	@Test
	public void testControler() {
		
		/* Instanciation d'un ControleurTypeTexte 
		 * avec le constructeur d'arité nulle. */
		final ControleurTypeTexte control = new ControleurTypeTexte();
		
		for (final File fichier : LISTEFILES_TXT) {
			
			/* invocation de la méthode controler(File pFile). */
			assertTrue(
					"fichier texte doit retourner true : "
						, control.controler(fichier));
			
//			System.out.println();
//			System.out.println(control.afficherRapportEnregistrementTextuel());
//			System.out.println();
//			System.out.println(control.afficherRapportEnregistrementCsv());
			
		}
		
		for (final File fichier : LISTEFILES_NON_TXT) {
			assertFalse(
					"fichier non texte doit retourner false : "
						, control.controler(fichier));
			
//			System.out.println();
//			System.out.println(control.afficherRapportEnregistrementTextuel());
//			System.out.println();
//			System.out.println(control.afficherRapportEnregistrementCsv());
		}
		
		for (final File fichier : LISTEFILES_TRAFIC) {
			assertTrue(
					"fichier texte doit retourner true : "
						, control.controler(fichier));
			
//			System.out.println();
//			System.out.println(control.afficherRapportEnregistrementTextuel());
//			System.out.println();
//			System.out.println(control.afficherRapportEnregistrementCsv());
		}
		
	} // Fin de testControler().___________________________________________
	
	
	
} // FIN DE LA CLASSE ControleurTypeTexteTest.-------------------------------
