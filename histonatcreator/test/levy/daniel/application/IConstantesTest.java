package levy.daniel.application;

import java.io.File;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



/**
 * Interface IConstantesTest :<br/>
 * Interface contenant toutes les constantes 
 * utiles pour les tests JUnit.<br/>
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
 * @since 25 mars 2016
 *
 */
public interface IConstantesTest {
	
	
	//*************************************************************/
	//********************* LOCALES *******************************/
	//*************************************************************/
	
	/**
	 * LOCALE_SYSTEM : Locale :<br/>
	 * Locale de la plateforme.<br/>
	 * Locale.getDefault().<br/>
	 */
	Locale LOCALE_SYSTEM 
		= Locale.getDefault();
	
	
	/**
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("fr", "FR").<br/>
	 */
	Locale LOCALE_FR_FR 
		= new Locale("fr", "FR");
	
		
	/**
	 * LOCALE_EN_US : Locale :<br/>
	 * new Locale("en", "US").<br/>
	 */
	Locale LOCALE_EN_US 
		= new Locale("en", "US");

	
	/**
	 * LOCALE_EN_GB : Locale :<br/>
	 * new Locale("en", "GB").<br/>
	 */
	Locale LOCALE_EN_GB 
		= new Locale("en", "GB");

	
	//*************************************************************/
	//*********************CHEMINS ********************************/
	//*************************************************************/
	
	/**
	 * CHEMIN_FICHIERS_TEST : String :<br/>
	 * Chemin des fichiers de test 
	 * relativement à la racine du projet courant.<br/>
	 * ".\\test\\ressourcesjunit\\differentstypesfichiers\\".<br/>
	 */
	String CHEMIN_FICHIERS_TEST 
		= ".\\test\\ressourcesjunit\\differentstypesfichiers\\";

	
	/**
	 * CHEMIN_FICHIERS_TRAFIC : String :<br/>
	 * Chemin des fichiers de trafic pour les tests 
	 * relativement à la racine du projet courant.<br/>
	 * ".\\test\\ressourcesjunit\\differentstypesfichiers\\texte\\trafics\\".<br/>
	 */
	String CHEMIN_FICHIERS_TRAFIC 
		= ".\\test\\ressourcesjunit\\differentstypesfichiers\\texte\\trafics\\";

	
	/**
	 * CHEMIN_INEXISTANT : String :<br/>
	 * Chemin d'un fichier inexistant.<br/>
	 * "inexistant.txt".<br/>
	 */
	String CHEMIN_INEXISTANT 
		= "inexistant.txt";
	
	/**
	 * CHEMIN_REPERTOIRE : String :<br/>
	 * Chemin d'un répertoire (pas un simple fichier).<br/>
	 * "dessin"
	 */
	String CHEMIN_REPERTOIRE 
		= "dessin";
		
	/**
	 * CHEMIN_VIDE : String :<br/>
	 * Chemin d'un fichier vide.<br/>
	 * "vide.txt".<br/>
	 */
	String CHEMIN_VIDE 
		= "texte\\vide.txt";
	
	
	/**
	 * CHEMIN_DWG : String :<br/>
	 * Chemin du fichier DWG relativement à la racine des fichiers de test.<br/>
	 * "dessin\\2015-10-20_Studio_Gilbert.dwg".<br/>
	 */
	String CHEMIN_DWG 
		= "dessin\\2015-10-20_Studio_Gilbert.dwg";

	/**
	 * CHEMIN_PPTX : String :<br/>
	 * Chemin du fichier pptx relativement à la racine des fichiers de test.<br/>
	 * "divers\\Séance1.pptx".<br/>
	 */
	String CHEMIN_PPTX 
		= "divers\\Séance 1.pptx";
	
	/**
	 * CHEMIN_MID : String :<br/>
	 * Chemin du fichier .mid relativement à la racine des fichiers de test.<br/>
	 * "divers\\Stride-anatole Majeur.MID"
	 */
	String CHEMIN_MID 
		= "divers\\Stride-anatole Majeur.MID";
		
	/**
	 * CHEMIN_EAP : String :<br/>
	 * Chemin du fichier .eap relativement à la racine des fichiers de test.<br/>
	 * "divers\\Trafic_Statistiques.eap"
	 */
	String CHEMIN_EAP 
		= "divers\\Trafic_Statistiques.eap";
		
	/**
	 * CHEMIN_ICO : String :<br/>
	 * Chemin du fichier .ico relativement à la racine des fichiers de test.<br/>
	 * "icones\\itunes_98708-640.ico".<br/>
	 */
	String CHEMIN_ICO 
		= "icones\\itunes_98708-640.ico";
	
	/**
	 * CHEMIN_PNG : String :<br/>
	 * Chemin du fichier .png relativement à la racine des fichiers de test.<br/>
	 * "images\\iTunes10-300x300.png".<br/>
	 */
	String CHEMIN_PNG 
		= "images\\iTunes10-300x300.png";
	
	/**
	 * CHEMIN_JPG : String :<br/>
	 * Chemin du fichier .jpg relativement à la racine des fichiers de test.<br/>
	 * "images\\Am I Blue Retour.jpg".<br/>
	 */
	String CHEMIN_JPG 
		= "images\\Am I Blue Retour.jpg";
		
	/**
	 * CHEMIN_GIF : String :<br/>
	 * Chemin du fichier .gif relativement à la racine des fichiers de test.<br/>
	 * "images\\c.gif".<br/>
	 */
	String CHEMIN_GIF 
		= "images\\c.gif";
	
	/**
	 * CHEMIN_BMP : String :<br/>
	 * Chemin du fichier .bmp relativement à la racine des fichiers de test.<br/>
	 * "images\\stickyfix.bmp".<br/>
	 */
	String CHEMIN_BMP 
		= "images\\stickyfix.bmp";
	
	/**
	 * CHEMIN_XPS : String :<br/>
	 * Chemin du fichier .xps relativement à la racine des fichiers de test.<br/>
	 * "images\\Your feet s too big.xps".<br/>
	 */
	String CHEMIN_XPS 
		= "images\\Your feet s too big.xps";
	
	/**
	 * CHEMIN_MP3 : String :<br/>
	 * Chemin du fichier .mp3 relativement à la racine des fichiers de test.<br/>
	 * "musique\\05 Tell It Like It Is.mp3".<br/>
	 */
	String CHEMIN_MP3 
		= "musique\\05 Tell It Like It Is.mp3";
		
	/**
	 * CHEMIN_WAV : String :<br/>
	 * Chemin du fichier .wav relativement à la racine des fichiers de test.<br/>
	 * "musique\\Note1.wav".<br/>
	 */
	String CHEMIN_WAV 
		= "musique\\Note1.wav";
		
	/**
	 * CHEMIN_TXT_ISO_8859_15 : String :<br/>
	 * Chemin du fichier .txt en ISO-8859-15 relativement à la racine des fichiers de test.<br/>
	 * "texte\\2014-08-20_HITDIRA2013_ISO-8859-15.txt".<br/>
	 */
	String CHEMIN_TXT_ISO_8859_15 
		= "texte\\2014-08-20_HITDIRA2013_ISO-8859-15.txt";
		
	/**
	 * CHEMIN_CSV_UTF8 : String :<br/>
	 * Chemin du fichier .csv en UTF-8 relativement à la racine des fichiers de test.<br/>
	 * "texte\\2014-08-20_HITDIRIF2013_UTF-8.csv".<br/>
	 */
	String CHEMIN_CSV_UTF8 
		= "texte\\2014-08-20_HITDIRIF2013_UTF-8.csv";
		
	/**
	 * CHEMIN_TXT_UTF8 : String :<br/>
	 * Chemin du fichier .txt en UTF-8 relativement à la racine des fichiers de test.<br/>
	 * "texte\\2014-08-20_HITDIRIF2013_UTF-8.txt".<br/>
	 */
	String CHEMIN_TXT_UTF8 
		= "texte\\2014-08-20_HITDIRIF2013_UTF-8.txt";
	
	/**
	 * CHEMIN_PDF : String :<br/>
	 * Chemin du fichier .pdf relativement à la racine des fichiers de test.<br/>
	 * "texte\\2015-10-20_Studio_Gilbert.pdf"
	 */
	String CHEMIN_PDF 
		= "texte\\2015-10-20_Studio_Gilbert.pdf";
	
	/**
	 * CHEMIN_XSD : String :<br/>
	 * Chemin du fichier .xsd relativement à la racine des fichiers de test.<br/>
	 * "texte\\bouteilles_schema.xsd".<br/>
	 */
	String CHEMIN_XSD 
		= "texte\\bouteilles_schema.xsd";
	
	/**
	 * CHEMIN_XML : String :<br/>
	 * Chemin du fichier .xml relativement à la racine des fichiers de test.<br/>
	 * "texte\\bouteilles.xml".<br/>
	 */
	String CHEMIN_XML 
		= "texte\\bouteilles.xml";
	
	/**
	 * CHEMIN_INI : String :<br/>
	 * Chemin du fichier .ini relativement à la racine des fichiers de test.<br/>
	 * "texte\\desktop.ini".<br/>
	 */
	String CHEMIN_INI 
		= "texte\\eclipse.ini";
	
	
	/**
	 * CHEMIN_PROPERTIES : String :<br/>
	 * Chemin du fichier .properties relativement à la racine des fichiers de test.<br/>
	 * "texte\\log4j.properties".<br/>
	 */
	String CHEMIN_PROPERTIES 
		= "texte\\log4j.properties";
	
	/**
	 * CHEMIN_DOCX : String :<br/>
	 * Chemin du fichier .docX relativement à la racine des fichiers de test.<br/>
	 * "texte\\Louisiana 1927.docx".<br/>
	 */
	String CHEMIN_DOCX 
		= "texte\\Louisiana 1927.docx";
	
	/**
	 * CHEMIN_HTML : String :<br/>
	 * Chemin du fichier .html relativement à la racine des fichiers de test.<br/>
	 * "texte\\T.html".<br/>
	 */
	String CHEMIN_HTML 
	= "texte\\T.html";
	
	/**
	 * CHEMIN_MP4 : String :<br/>
	 * Chemin du fichier .mp4 relativement à la racine des fichiers de test.<br/>
	 * "video\\2-video2brain-Définir Cubase.mp4".<br/>
	 */
	String CHEMIN_MP4 
		= "video\\2-video2brain-Définir Cubase.mp4";
	
	/**
	 * CHEMIN_FLV : String :<br/>
	 * Chemin du fichier .flv relativement à la racine des fichiers de test.<br/>
	 * "video\\Pinophilus.flv".<br/>
	 */
	String CHEMIN_FLV 
		= "video\\Pinophilus.flv";
	
	/**
	 * CHEMIN_ASF : String :<br/>
	 * Chemin du fichier .asf relativement à la racine des fichiers de test.<br/>
	 * "video\\Travail_Diminues_2010-07-27.ASF".<br/>
	 */
	String CHEMIN_ASF 
		= "video\\Travail_Diminues_2010-07-27.ASF";
	
	/**
	 * CHEMIN_GIF_EN_BMP : String :<br/>
	 * Chemin du fichier .gif renommé en bmp 
	 * relativement à la racine des fichiers de test.<br/>
	 * "faussesextensions\\cgifrenommebmp.bmp".<br/>
	 */
	String CHEMIN_GIF_EN_BMP 
		= "faussesextensions\\cgifrenommebmp.bmp";
	
	/**
	 * CHEMIN_GIF_SANS_EXTENSION : String :<br/>
	 * Chemin du fichier .gif sans extension 
	 * relativement à la racine des fichiers de test.<br/>
	 * "faussesextensions\\cgifsansextension".<br/>
	 */
	String CHEMIN_GIF_SANS_EXTENSION
		= "faussesextensions\\cgifsansextension";
	
	/**
	 * CHEMIN_TXT_SANS_EXTENSION : String :<br/>
	 * Chemin du fichier .txt sans extension 
	 * relativement à la racine des fichiers de test.<br/>
	 * "faussesextensions\\2014-08-20_HITDIRIF2013_UTF-8".<br/>
	 */
	String CHEMIN_TXT_SANS_EXTENSION
		= "faussesextensions\\2014-08-20_HITDIRIF2013_UTF-8";
	
	/**
	 * CHEMIN_TXT_FAUSSE_EXTENSION : String :<br/>
	 * Chemin du fichier .txt renommé en csv 
	 * relativement à la racine des fichiers de test.<br/>
	 * "faussesextensions\\2014-08-20_HITDIRIF2013_UTF-8txt.csv".<br/>
	 */
	String CHEMIN_TXT_FAUSSE_EXTENSION
	= "faussesextensions\\2014-08-20_HITDIRIF2013_UTF-8txt.csv";
	
	
	/**
	 * CHEMIN_ANSI : String :<br/>
	 * Chemin du fichier .txt codé en ANSI 
	 * relativement à la racine des fichiers de test.<br/>
	 * "encodages\\chaàâreéèêëtte_ANSI.txt"
	 */
	String CHEMIN_ANSI 
		= "encodages\\chaàâreéèêëtte_ANSI.txt";
	
	
	/**
	 * CHEMIN_DIACRITIQUES_ISO_8859_2 : String :<br/>
	 * Chemin du fichier .txt codé en ISO-8859-2 
	 * relativement à la racine des fichiers de test.<br/>
	 */
	String CHEMIN_DIACRITIQUES_ISO_8859_2 
		= "encodages\\diacritiques_ISO-8859-2.txt";
	
	
	/**
	 * CHEMIN_DIACRITIQUES_UTF8 : String :<br/>
	 * Chemin du fichier .txt codé en UTF-8 
	 * relativement à la racine des fichiers de test.<br/>
	 */
	String CHEMIN_DIACRITIQUES_UTF8 
		= "encodages\\diacritiques_UTF8.txt";

	/**
	 * CHEMIN_CHARETTE_ANSI : String :<br/>
	 * Chemin du fichier .txt codé en ANSI Windows_1252
	 * relativement à la racine des fichiers de test.<br/>
	 * 1 seule ligne "chaàâreéèêëtte € encodé en ANSI. 47 caractères.".<br/>
	 */
	String CHEMIN_CHARETTE_ANSI 
		= "encodages\\chaàâreéèêëtte_ANSI.txt";
	

	/**
	 * CHEMIN_CHARETTE_OEM : String :<br/>
	 * Chemin du fichier .txt codé en OEM (IBM-850)
	 * relativement à la racine des fichiers de test.<br/>
	 * 1 seule ligne "chaàâreéèêëtte € encodé en UTF-8. 47 caractères.".<br/>
	 */
	String CHEMIN_CHARETTE_OEM 
		= "encodages\\chaàâreéèêëtte_OEM.txt";
	

	/**
	 * CHEMIN_HIT_DIRA_2012 : String :<br/>
	 * "texte\\trafics\\trafics_2012\\2014-08-07_HITDIRA2012".<br/>
	 */
	String CHEMIN_HIT_DIRA_2012 
		= "texte\\trafics\\trafics_2012\\2014-08-07_HITDIRA2012";

	
	/**
	 * CHEMIN_HIT_DIRO_2012 : String :<br/>
	 * "texte\\trafics\\trafics_2012\\2014-08-07_HITDIRO2012".<br/>
	 */
	String CHEMIN_HIT_DIRO_2012 
		= "texte\\trafics\\trafics_2012\\2014-08-07_HITDIRO2012";
	
	
	/**
	 * CHEMIN_HIT_DIRA_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRA2014.txt".<br/>
	 */
	String CHEMIN_HIT_DIRA_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRA2014.txt";
	
	
	/**
	 * CHEMIN_HIT_DIRCE_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRCE2014.txt".<br/>
	 */
	String CHEMIN_HIT_DIRCE_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRCE2014.txt";

	
	/**
	 * CHEMIN_HIT_DIRCO_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRCO2014.txt".<br/>
	 */
	String CHEMIN_HIT_DIRCO_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRCO2014.txt";
	
	/**
	 * CHEMIN_HIT_DIRE_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRE2014.txt".<br/>
	 */
	String CHEMIN_HIT_DIRE_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRE2014.txt";

	
	/**
	 * CHEMIN_HIT_DIRIF_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRIF2014.txt".<br/>
	 */
	String CHEMIN_HIT_DIRIF_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRIF2014.txt";

	
	/**
	 * CHEMIN_HIT_DIRMC_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRMC2014.txt".<br/>
	 */
	String CHEMIN_HIT_DIRMC_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRMC2014.txt";

	
	/**
	 * CHEMIN_HIT_DIRMED_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRMED2014.txt".<br/>
	 */
	String CHEMIN_HIT_DIRMED_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRMED2014.txt";

	/**
	 * CHEMIN_HIT_DIRN_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRN2014.txt".<br/>
	 */
	String CHEMIN_HIT_DIRN_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRN2014.txt";
	
	/**
	 * CHEMIN_HIT_DIRNO_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRNO2014.txt".<br/>
	 */
	String CHEMIN_HIT_DIRNO_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRNO2014.txt";
	
	/**
	 * CHEMIN_HIT_DIRO_2014 : String :<br/>
	 * "texte\\trafics\\trafics2014\\HITDIRO2014.txt".<br/>
	 */
	String CHEMIN_HIT_DIRO_2014 
		= "texte\\trafics\\trafics_2014\\HITDIRO2014.txt";
	
	/**
	 * CHEMIN_HIT_DIRSO_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\HITDIRSO2014.txt".<br/>
	 */
	String CHEMIN_HIT_DIRSO_2014 
	= "texte\\trafics\\trafics_2014\\HITDIRSO2014.txt";
	
	/**
	 * CHEMIN_DARWIN_2014 : String :<br/>
	 * "texte\\trafics\\trafics_2014\\darwin2014.csv".<br/>
	 */
	String CHEMIN_DARWIN_2014 
		= "texte\\trafics\\trafics_2014\\darwin2014.csv";
	
	
	/**
	 * CHEMIN_NON_HIT_UTF8 : String :<br/>
	 * "File_Non_HIT_UTF8.txt".<br/>
	 */
	String CHEMIN_NON_HIT_UTF8 = "texte\\File_Non_HIT_UTF8.txt";

	
	/**
	 * CHEMIN_HIT_UTF8 : Sring :<br/>
	 * "FILE_HIT_UTF8.txt".<br/>
	 */
	String CHEMIN_HIT_UTF8 = "texte\\FILE_HIT_UTF8.txt";

	
	/**
	 * CHEMIN_NON_DARWIN_UTF8 : String :<br/>
	 * "FILE_Non_DARWIN_UTF8.csv".<br/>
	 */
	String CHEMIN_NON_DARWIN_UTF8 = "texte\\FILE_Non_DARWIN_UTF8.csv";
	
	
	/**
	 * CHEMIN_DARWIN_UTF8 : String :<br/>
	 * "texte\\FILE_DARWIN_UTF8.csv".<br/>
	 */
	String CHEMIN_DARWIN_UTF8 = "texte\\FILE_DARWIN_UTF8.csv";
	
	
	//*****************************************************************/
	//**************************FICHIERS ******************************/
	//*****************************************************************/
	
	/**
	 * FILE_NULL : File :<br/>
	 * Fichier null.<br/>
	 */
	File FILE_NULL = null;
	
	/**
	 * FILE_INEXISTANT : File :<br/>
	 * Fichier inexistant.<br/>
	 */
	File FILE_INEXISTANT 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_INEXISTANT);
	
	/**
	 * FILE_REPERTOIRE : File :<br/>
	 * Répertoire.<br/>
	 */
	File FILE_REPERTOIRE 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_REPERTOIRE);

	/**
	 * FILE_VIDE : File :<br/>
	 * Fichier vide.<br/>
	 */
	File FILE_VIDE 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_VIDE);
	
	/**
	 * FILE_DWG : File :<br/>
	 * Fichier Autocad .dwg.<br/>
	 */
	File FILE_DWG 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DWG);
	
	/**
	 * FILE_PPTX : File :<br/>
	 * Fichier PowerPoint pptx.<br/>
	 */
	File FILE_PPTX 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_PPTX);
	
	/**
	 * FILE_MID : File :<br/>
	 * Fichier Midi .mid.<br/>
	 */
	File FILE_MID 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_MID);
	
	/**
	 * FILE_EAP : File :<br/>
	 * Fichier Enterprise Architect .eap.<br/>
	 */
	File FILE_EAP 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_EAP);
	
	/**
	 * FILE_ICO : File :<br/>
	 * Fichier icône .ico.<br/>
	 */
	File FILE_ICO 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_ICO);
	
	/**
	 * FILE_PNG : File :<br/>
	 * Fichier image PNG .png.<br/>
	 */
	File FILE_PNG 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_PNG);

	/**
	 * FILE_JPG : File :<br/>
	 * Fichier image JPG .jpg.<br/>
	 */
	File FILE_JPG 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_JPG);
	
	/**
	 * FILE_GIF : File :<br/>
	 * Fichier image Gif .gif.<br/>
	 */
	File FILE_GIF 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_GIF);
	
	/**
	 * FILE_BMP : File :<br/>
	 * Fichier image Bmp .bmp.<br/>
	 */
	File FILE_BMP 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_BMP);
	
	/**
	 * FILE_XPS : File :<br/>
	 * Fichier image xps .xps.<br/>
	 */
	File FILE_XPS 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_XPS);
	
	/**
	 * FILE_MP3 : File :<br/>
	 * Fichier musical mp3 .mp3.<br/>
	 */
	File FILE_MP3 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_MP3);
	
	/**
	 * FILE_WAV : File :<br/>
	 * Fichier musical Wave .wav.<br/>
	 */
	File FILE_WAV 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_WAV);
	
	/**
	 * FILE_TXT_ISO_8859_15 : File :<br/>
	 * Fichier texte en ISO-8859-15 .txt.<br/>
	 */
	File FILE_TXT_ISO_8859_15
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_TXT_ISO_8859_15);
	
	/**
	 * FILE_CSV_UTF_8 : File :<br/>
	 * Fichier csv en UTF-8 .csv.<br/>
	 */
	File FILE_CSV_UTF_8
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_CSV_UTF8);
	
	/**
	 * FILE_TXT_UTF_8 : File :<br/>
	 * Fichier texte en UTF-8 .txt.<br/>
	 */
	File FILE_TXT_UTF_8
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_TXT_UTF8);

	/**
	 * FILE_PDF : File :<br/>
	 * Fichier Adobe Acrobat .pdf.<br/>
	 */
	File FILE_PDF
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_PDF);
	
	/**
	 * FILE_XSD : File :<br/>
	 * Fichier schéma XML .xsd.<br/>
	 */
	File FILE_XSD
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_XSD);
	
	/**
	 * FILE_XML : File :<br/>
	 * Document XML .xml.<br/>
	 */
	File FILE_XML
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_XML);
	
	/**
	 * FILE_INI : File :<br/>
	 * Document ini .ini.<br/>
	 */
	File FILE_INI
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_INI);
	
	/**
	 * FILE_PROPERTIES : File :<br/>
	 * Document properties .properties.<br/>
	 */
	File FILE_PROPERTIES
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_PROPERTIES);
		
	/**
	 * FILE_DOCX : File :<br/>
	 * Document Word .docX.<br/>
	 */
	File FILE_DOCX
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DOCX);
	
	/**
	 * FILE_HTML : File :<br/>
	 * Document HTML .html.<br/>
	 */
	File FILE_HTML
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HTML);
	
	/**
	 * FILE_MP4 : File :<br/>
	 * Film .mp4.<br/>
	 */
	File FILE_MP4
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_MP4);
	
	/**
	 * FILE_FLV : File :<br/>
	 * Film .flv.<br/>
	 */
	File FILE_FLV
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_FLV);
	
	/**
	 * FILE_ASF : File :<br/>
	 * Film .asf.<br/>
	 */
	File FILE_ASF
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_ASF);
	
	/**
	 * FILE_GIF_EN_BMP : File :<br/>
	 * Fichier .gif renommé en .bmp.<br/>
	 */
	File FILE_GIF_EN_BMP 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_GIF_EN_BMP);
	
	/**
	 * FILE_GIF_SANS_EXTENSION : File :<br/>
	 * Fichier .gif sqns extension.<br/>
	 */
	File FILE_GIF_SANS_EXTENSION 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_GIF_SANS_EXTENSION);
		
	/**
	 * FILE_TXT_SANS_EXTENSION : File :<br/>
	 * Fichier .txt sans extension.<br/>
	 */
	File FILE_TXT_SANS_EXTENSION 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_TXT_SANS_EXTENSION);
	
	/**
	 * FILE_TXT_FAUSSE_EXTENSION : File :<br/>
	 * Fichier .txt renommé en .csv.<br/>
	 */
	File FILE_TXT_FAUSSE_EXTENSION 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_TXT_FAUSSE_EXTENSION);

	
	/**
	 * FILE_CHARETTE_ANSI : File :<br/>
	 * Fichier .txt 
	 * contenant "chaàâreéèêëtte € encodé en ANSI. 47 caractères." 
	 * codé en ANSI.<br/>
	 */
	File FILE_CHARETTE_ANSI 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_ANSI);

	
	/**
	 * FILE_CHARETTE_OEM : File :<br/>
	 * Fichier .txt 
	 * contenant "chaàâreéèêëtte € encodé en UTF-8. 47 caractères."
	 * codé en OEM (IBM-850).<br/>
	 */
	File FILE_CHARETTE_OEM 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_CHARETTE_OEM);

	
	/**
	 * FILE_DIACRITIQUES_ISO_8859_2 : File : <br/>
	 * txt codé en ISO_8859_2.<br/>
	 */
	File FILE_DIACRITIQUES_ISO_8859_2 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DIACRITIQUES_ISO_8859_2);
	
	
	/**
	 * FILE_DIACRITIQUES_UTF8 : File : <br/>
	 * txt codé en UTF-8.<br/>
	 */
	File FILE_DIACRITIQUES_UTF8 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DIACRITIQUES_UTF8);
	
	
	/**
	 * FILE_HITDIRA2012 : File :<br/>
	 * "2014-08-07_HITDIRA2012".<br/>
	 */
	File FILE_HITDIRA2012 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRA_2012);
	
	/**
	 * FILE_HITDIRO2012 : File :<br/>
	 * "2014-08-07_HITDIRO2012".<br/>
	 */
	File FILE_HITDIRO2012 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRO_2012);

	
	/**
	 * FILE_HITDIRA2014 : File :<br/>
	 * HITDIRA2014.txt.<br/>
	 */
	File FILE_HITDIRA2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRA_2014);
	
	/**
	 * FILE_HITDIRCE2014 : File :<br/>
	 * HITDIRCE2014.txt.<br/>
	 */
	File FILE_HITDIRCE2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRCE_2014);
	
	/**
	 * FILE_HITDIRCO2014 : File :<br/>
	 * HITDIRCO2014.txt.<br/>
	 */
	File FILE_HITDIRCO2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRCO_2014);

	/**
	 * FILE_HITDIRE2014 : File :<br/>
	 * HITDIRE2014.txt.<br/>
	 */
	File FILE_HITDIRE2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRE_2014);
	
	/**
	 * FILE_HITDIRIF2014 : File :<br/>
	 * HITDIRIF2014.txt.<br/>
	 */
	File FILE_HITDIRIF2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRIF_2014);
	
	
	/**
	 * FILE_HITDIRMC2014 : File :<br/>
	 * HITDIRMC2014.txt.<br/>
	 */
	File FILE_HITDIRMC2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRMC_2014);
	
	/**
	 * FILE_HITDIRMED2014 : File :<br/>
	 * HITDIRMED2014.txt.<br/>	 
	 * */
	File FILE_HITDIRMED2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRMED_2014);

	
	/**
	 * FILE_HITDIRN2014 : File :<br/>
	 * HITDIRN2014.txt.<br/>	 
	 */
	File FILE_HITDIRN2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRN_2014);

	
	/**
	 * FILE_HITDIRNO2014 : File :<br/>
	 * HITDIRNO2014.txt.<br/>
	 */
	File FILE_HITDIRNO2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRNO_2014);

	
	/**
	 * FILE_HITDIRO2014 : File :<br/>
	 * HITDIRO2014.txt.<br/>
	 */
	File FILE_HITDIRO2014 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRO_2014);
	
	/**
	 * FILE_HITDIRSO2014 : File :<br/>
	 * HITDIRSO2014.txt.<br/>
	 */
	File FILE_HITDIRSO2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRSO_2014);
	
	/**
	 * FILE_DARWIN2014 : File :<br/>
	 * "darwin2014.csv".<br/>
	 */
	File FILE_DARWIN2014 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DARWIN_2014);
	

	/**
	 * FILE_NON_HIT_UTF8 : File :<br/>
	 * "File_Non_HIT_UTF8.txt".<br/>
	 */
	File FILE_NON_HIT_UTF8 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_NON_HIT_UTF8);

	
	/**
	 * FILE_HIT_UTF8 : File :<br/>
	 * "FILE_HIT_UTF8.txt".<br/>
	 */
	File FILE_HIT_UTF8 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_UTF8);
	
	
	/**
	 * FILE_NON_DARWIN_UTF8 : File :<br/>
	 * "FILE_Non_DARWIN_UTF8.csv".<br/>
	 */
	File FILE_NON_DARWIN_UTF8 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_NON_DARWIN_UTF8);

	
	/**
	 * FILE_DARWIN_UTF8 : File :<br/>
	 * "FILE_DARWIN_UTF8.csv".<br/>
	 */
	File FILE_DARWIN_UTF8 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DARWIN_UTF8);
	
	
	/**
	 * LISTEFILES : List<File> :<br/>
	 * Liste contenant tous les File utilisés pour les tests.<br/>
	 */
	List<File> LISTEFILES = new ArrayList<File>();

	
	/**
	 * LISTEFILES_NON_TXT : List<File> :<br/>
	 * Liste contenant tous les File non TXT utilisés pour les tests.<br/>
	 */
	List<File> LISTEFILES_NON_TXT = new ArrayList<File>();

	
	/**
	 * LISTEFILES_TXT : List<File> :<br/>
	 * Liste contenant tous les File TXT utilisés pour les tests.<br/>
	 */
	List<File> LISTEFILES_TXT = new ArrayList<File>();

	
	/**
	 * LISTEFILES_TRAFIC : List<File> :<br/>
	 * Liste contenant tous les File de trafic utilisés pour les tests.<br/>
	 */
	List<File> LISTEFILES_TRAFIC = new ArrayList<File>();



	//*****************************************************************/
	//**************************CHARSETS ******************************/
	//*****************************************************************/

	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	Charset CHARSET_UTF8 
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
	Charset CHARSET_US_ASCII 
		= Charset.forName("US-ASCII");
	
	/**
	 * CHARSET_ISO_8859_1 : Charset :<br/>
	 * Charset.forName("ISO-8859-1").<br/>
	 * Latin1.<br/>
	 * 191 caractères imprimables.<br/> 
	 * Permet d’écrire la plupart des langues d’Europe de l’Ouest.<br/> 
	 * Presque tous les caractères du français y sont (manquent le œ et €).<br/>
	 */
	Charset CHARSET_ISO_8859_1 
		= Charset.forName("ISO-8859-1");

	
	/**
	 * CHARSET_LATIN1 : Charset :<br/>
	 * Charset.forName("ISO-8859-1").<br/>
	 * Latin1.<br/>
	 * 191 caractères imprimables.<br/> 
	 * Permet d’écrire la plupart des langues d’Europe de l’Ouest.<br/> 
	 * Presque tous les caractères du français y sont (manquent le œ et €).<br/>
	 */
	Charset CHARSET_LATIN1 
		= Charset.forName("ISO-8859-1");

	
	/**
	 * CHARSET_ISO_8859_2 : Charset :<br/>
	 * Charset.forName("ISO-8859-2").<br/>
	 * <br/>
	 */
	Charset CHARSET_ISO_8859_2 
		= Charset.forName("ISO-8859-2");
	
	
	/**
	 * CHARSET_ISO_8859_9 : Charset :<br/>
	 * Charset.forName("ISO-8859-9").<br/>
	 * Latin Alphabet No. 5<br/>
	 */
	Charset CHARSET_ISO_8859_9 
		= Charset.forName("ISO-8859-9");

	
	/**
	 * CHARSET_ISO_8859_15 : Charset :<br/>
	 * Charset.forName("ISO-8859-15").<br/>
	 * Latin9, Latin Alphabet No. 9.<br/>
	 * modifie légèrement ISO-8859-1.<br/> 
	 * Ajout du caractère œ et du symbole monétaire € (Euro) entre autres.<br/>
	 */
	Charset CHARSET_ISO_8859_15 
		= Charset.forName("ISO-8859-15");
	
	
	/**
	 * CHARSET_LATIN9 : Charset :<br/>
	 * Charset.forName("ISO-8859-15").<br/>
	 * Latin9, Latin Alphabet No. 9.<br/>
	 * modifie légèrement ISO-8859-1.<br/> 
	 * Ajout du caractère œ et du symbole monétaire € (Euro) entre autres.<br/>
	 */
	Charset CHARSET_LATIN9 
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
	Charset CHARSET_WINDOWS_1252 
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
	Charset CHARSET_ANSI
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
	Charset CHARSET_CP1252
		= Charset.forName("windows-1252");

	
	/**
	 * CHARSET_IBM850 : Charset :<br/>
	 * Charset IBM-850.<br/>
	 * Cp850, MS-DOS Latin-1.<br/>
	 */
	Charset CHARSET_IBM850
		= Charset.forName("IBM-850");
	

	//*****************************************************************/
	//**************************** SAUTS ******************************/
	//*****************************************************************/

	/**
	 * SAUTDELIGNE_UNIX : String :<br/>
	 * Saut de ligne généré par les éditeurs Unix.<br/>
	 * "\n" (Retour Ligne = LINE FEED (LF)).
	 */
	String SAUTDELIGNE_UNIX = "\n";

	
	/**
	 * SAUTDELIGNE_MAC : String :<br/>
	 * Saut de ligne généré par les éditeurs Mac.<br/>
	 * "\r" (Retour Chariot RC = CARRIAGE RETURN (CR))
	 */
	String SAUTDELIGNE_MAC = "\r";

	
	/**
	 * SAUTDELIGNE_DOS_WINDOWS : String :<br/>
	 * Saut de ligne généré par les éditeurs DOS/Windows.<br/>
	 * "\r\n" (Retour Chariot RC + Retour Ligne Line Feed LF).
	 */
	String SAUTDELIGNE_DOS_WINDOWS = "\r\n";

	
	/**
	 * NEWLINE : String :<br/>
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	String NEWLINE = System.getProperty("line.separator");
	
	


	//*****************************************************************/
	//**************************DATEFORMAT ****************************/
	//*****************************************************************/


	/**
	 * DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE : DateFormat :<br/>
	 * Format concentré des dates avec heures et secondes
	 * comme "2012-01-16_18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	DateFormat DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", LOCALE_FR_FR);

	
	/**
	 * DF_DATE_FRANCAISE : DateFormat :<br/>
	 * Format classique des dates françaises comme
	 * '25/02/1961'.<br/>
	 */
	DateFormat DF_DATE_FRANCAISE 
	= new SimpleDateFormat("dd/MM/yyyy", LOCALE_FR_FR);
	
	
	/**
	 * DF_DATE_COMPLETE_FRANCAISE : DateFormat :<br/>
	 * Format complet des dates françaises comme
	 * 'samedi 25 février 1961'.<br/>
	 */
	DateFormat DF_DATE_COMPLETE_FRANCAISE 
		= new SimpleDateFormat("EEEE' 'dd' 'MMMM' 'yyyy"
			, LOCALE_FR_FR);

	
	/**
	 * DF_MOIS_ANNEE : DateFormat :<br/>
	 * Format des dates françaises avec mois-année comme
	 * 'février 1961'.<br/>
	 */
	DateFormat DF_MOIS_ANNEE 
		= new SimpleDateFormat("MMMM' 'yyyy"
			, LOCALE_FR_FR);

	
	/**
	 * DF_DATETIMEMILLI_FRANCAISE : DateFormat :<br/>
	 * Format des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 */
	DateFormat DF_DATETIMEMILLI_FRANCAISE 
	= new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss.SSS", LOCALE_FR_FR);

	
	/**
	 * DF_MOIS_ANNEE_SIMPLE : DateFormat :<br/>
	 * Format des dates françaises avec mois simplifié-année comme
	 * '02/1961'.<br/>
	 */
	DateFormat DF_MOIS_ANNEE_SIMPLE 
	= new SimpleDateFormat("MM/yyyy", LOCALE_FR_FR);
	
	
	/**
	 * DF_ANNEE : DateFormat :<br/>
	 * Format des dates avec juste l'année comme "1961".<br/>
	 */
	DateFormat DF_ANNEE 
		= new SimpleDateFormat("yyyy", LOCALE_FR_FR);
	

	/**
	 * DF_DATE_AVEC_HEURE_MINUTE_SECONDE : DateFormat :<br/>
	 * Format classique des dates avec heures et secondes
	 * comme "2012-01-16 à 18 heures,09 minutes,55 secondes" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	DateFormat DF_DATE_AVEC_HEURE_MINUTE_SECONDE 
	= new SimpleDateFormat("yyyy-MM-dd' " 
	+ "à 'HH' heures,'mm' minutes,'ss' secondes'", LOCALE_FR_FR);
	
	 
	/**
	 * DF_DATE_HEURE_MINUTE_SECONDE : DateFormat :<br/>
	 * Format concentré des dates avec heures et secondes
	 * comme "2012-01-16:18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	DateFormat DF_DATE_HEURE_MINUTE_SECONDE 
		= new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss", LOCALE_FR_FR);
	
	
	/**
	 * DF_DATE_LEXICOGRAPHIQUE : DateFormat :<br/>
	 * Format lexicographique des dates 
	 * comme "2012-01-16" pour le
	 * 16 Janvier 2012.<br/>
	 */
	DateFormat DF_DATE_LEXICOGRAPHIQUE 
		= new SimpleDateFormat("yyyy-MM-dd", LOCALE_SYSTEM);

	
	/**
	 * DF_DATETIME_LEXICOGRAPHIQUE : DateFormat :<br/>
	 * Format lexicographique des dates avec time 
	 * comme "2012-01-16_18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	DateFormat DF_DATETIME_LEXICOGRAPHIQUE 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", LOCALE_FR_FR);
	
	
	/**
	 * DF_DATETIME_FRANCAISE : DateFormat :<br/>
	 * Format classique des dates-heures françaises comme
	 * '25/02/1961-12:27:07'.<br/>
	 */
	DateFormat DF_DATETIME_FRANCAISE 
	= new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss", LOCALE_FR_FR);
	

	/**
	 * DF_DATE_AMERICAINE : DateFormat :<br/>
	 * Format classique des dates américaines comme 
	 * '02-25-1961'.<br/>
	 */
	DateFormat DF_DATE_AMERICAINE 
	= new SimpleDateFormat("MM-dd-yyyy", LOCALE_EN_US);
	
	
	/**
	 * DF_DATE_COMPLETE_AMERICAINE : DateFormat :<br/>
	 * Format complet des dates américaines comme
	 * 'Saturday, February 25, 1961'.<br/>
	 */
	DateFormat DF_DATE_COMPLETE_AMERICAINE 
		= DateFormat.getDateInstance(DateFormat.FULL, LOCALE_EN_US);


	/**
	 * DF_JOUR_MOIS_ANNEE_ECRITS_HEURE_MINUTE_SECONDE : DateFormat :<br/>
	 * .<br/>
	 */
	DateFormat DF_JOUR_MOIS_ANNEE_ECRITS_HEURE_MINUTE_SECONDE 
		= new SimpleDateFormat(
				"EEEE' 'dd' 'MMMM' 'yyyy:HH-mm-ss", LOCALE_FR_FR);

	


} // Fin de IConstantesTest.-------------------------------------------------
