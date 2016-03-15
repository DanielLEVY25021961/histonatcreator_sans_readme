package levy.daniel.application.metier.controles.impl.controlessurface;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * class ControleurEncodageTest :<br/>
 * Test JUnit de la classe ControleurEncodage.<br/>
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
 * @since 11 mars 2016
 *
 */
public class ControleurEncodageTest {

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
	public static final String CHEMIN_VIDE = "texte\\vide.txt";
	
	
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
	 * CHEMIN_HTML : String :<br/>
	 * Chemin du fichier .html relativement à la racine des fichiers de test.<br/>
	 * "texte\\T.html".<br/>
	 */
	public static final String CHEMIN_HTML 
	= "texte\\T.html";

	
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
	 * CHEMIN_HIT_DIRO_2014 : String :<br/>
	 * "texte\\trafics\\trafics2014\\HITDIRO2014.txt".<br/>
	 */
	public static final String CHEMIN_HIT_DIRO_2014 
		= "texte\\trafics\\trafics_2014\\HITDIRO2014.txt";
	
	
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
	 * FILE_HTML : File :<br/>
	 * Document HTML .html.<br/>
	 */
	public static final File FILE_HTML
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HTML);

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
	 * FILE_HITDIRO2014 : File :<br/>
	 * HITDIRO2014.txt.<br/>
	 */
	public static final File FILE_HITDIRO2014 
		= new File(CHEMIN_FICHIERS_TEST + CHEMIN_HIT_DIRO_2014);
	
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
	
	
	/**
	 * LISTE_CHARSETS : List<Charset> :<br/>
	 * Liste contenant tous les Charsets utilisés pour les tests.<br/>
	 */
	public static final List<Charset> LISTE_CHARSETS = new ArrayList<Charset>();

	
	/* Bloc statique pour remplir la liste des Charsets. */
	static {
		
		LISTE_CHARSETS.add(CHARSET_UTF8);
		LISTE_CHARSETS.add(CHARSET_US_ASCII);
		LISTE_CHARSETS.add(CHARSET_ISO_8859_1);
		LISTE_CHARSETS.add(CHARSET_ISO_8859_2);
		LISTE_CHARSETS.add(CHARSET_ISO_8859_9);
		LISTE_CHARSETS.add(CHARSET_ISO_8859_15);
		LISTE_CHARSETS.add(CHARSET_ANSI);
		LISTE_CHARSETS.add(CHARSET_IBM850);
		
	}
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(ControleurEncodageTest.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR ControleurEncodageTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 * - Remplit LISTEFILES_TRAFIC.<br/>
	 * <br/>
	 */
	public ControleurEncodageTest() {
		
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
	 * method testControlerTousEncodages() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testControlerTousEncodages() {
		
		/* Instanciation d'un ControleurTypeTexte 
		 * avec le constructeur d'arité nulle. */
		final ControleurEncodage controle = new ControleurEncodage();
		
		/* Parcours de tous les fichiers trafics. */
		for (final File fichier : LISTEFILES_TRAFIC) {
			
			/* Parcours de tous les charsets. */
			for (final Charset charset : LISTE_CHARSETS) {
				
				/* Passe charset au controle. */
				controle.setCharset(charset);
				
				/* Controle du fait que fichier est encodé en charset. */
				final boolean resultat = controle.controler(fichier, false);
				
				System.out.println("Fichier " + fichier.getName() + " est encodé en " + charset.name() + " : " + resultat);
				
			} // Fin de Parcours de tous les charsets.____________		
			
			System.out.println();
			
		} // Fin de Parcours de tous les fichiers trafics._______________
		
	} // Fin de testControlerTousEncodages().______________________________
	

	
	/**
	 * method testControlerHitDirA2012() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testControlerHitDirA2012() {
		
		/* Instanciation d'un ControleurEncodage 
		 * avec le constructeur d'arité nulle. */
		final ControleurEncodage controle = new ControleurEncodage();
		
		/* ******************************************************************/
		/* Détermination du fichier, du charset et de la ligna à lire. ******/
		final File fichier = FILE_CHARETTE_ANSI;
		final Charset charset = CHARSET_IBM850;
		final int numeroLigne = 1;
		/* ******************************************************************/
		
		/* Passe charset au controle. */
		controle.setCharset(charset);
		
		/* résultat du contrôle d'encodage. */
		final boolean resultat 
			= controle.controler(fichier, false);
		
		/* Lit le fichier ligne par ligne dans le fichier avec charset. */
		/* Remplit la SortedMap qui encapsule le fichier 
		 * sous forme de lignes. */
		final String lectureLigneParLigne 
			= controle.lireFichierLigneParLigne(fichier, charset);
		
		/* Lit une ligne donnée dans le fichier avec charset. */
		final String lectureLigne 
			= controle.lireLigneFichier(numeroLigne, fichier, charset);
		
		/* Liste la ligne donnée caractère par caractère 
		 * en éditant les valeurs unicode. */
		final String caracteres 
			= controle.listerChaineCarParCar(lectureLigne);
		
		/* résultat du contrôle de bonnes longueurs des lignes. */
		final boolean bonneLongueurs 
			= this.controlerLongueursLignes(controle.getFichierEnMap(), 520);
		

		
		// AFFICHAGES. ********************
		/* Résultat de la lecture par le Charset*/
		System.out.println();
		System.out.println("Fichier écrit dans l'encodage " 
				+ charset.name() + " : " + resultat);
		
		/* Affichage de l'enregistrement sur disque du rapport de contrôle. */
		System.out.println();
		System.out.println("Un rapport de contrôle a été enregistré : \n" 
				+ controle.afficherRapportEnregistrementTextuel());
		
		/* Affichage de la ligne désignée par son numéro. */
		System.out.println();
		System.out.println(lectureLigne);
		
		/* Affichage du fichier ligne par ligne lu par charset. */
		System.out.println();
		System.out.println(lectureLigneParLigne);
		
		System.out.println();
		System.out.println(caracteres);
		
		
		System.out.println();
		System.out.println("Fichier a de bonnes longueurs de ligne : " 
				+ bonneLongueurs);
		
	} // Fin de testControlerHitDirA2012().________________________________
	

	
	/**
	 * method testControler() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testControler() {
		
		/* Instanciation d'un ControleurEncodage 
		 * avec le constructeur d'arité nulle. */
		final ControleurEncodage controle = new ControleurEncodage();
		
		/* ******************************************************************/
		/* Détermination du fichier, du charset et de la ligna à lire. ******/
		final File fichier = FILE_HITDIRO2014;
		final Charset charset = CHARSET_IBM850;
		final int numeroLigne = 594;
		/* ******************************************************************/
		
		/* Passe charset au controle. */
		controle.setCharset(charset);
		
		/* résultat du contrôle d'encodage. */
		final boolean resultat = controle.controler(fichier, true);
		
		/* Lit une ligne donnée dans le fichier avec charset. */
		final String lectureLigne 
			= controle.lireLigneFichier(numeroLigne, fichier, charset);
		
		
		/* Lit le fichier ligne par ligne dans le fichier avec charset. */
		/* Remplit la SortedMap qui encapsule le fichier sous forme de lignes. */
		final String lectureLigneParLigne 
			= controle.lireFichierLigneParLigne(fichier, charset);
		
		/* Liste la ligne donnée caractère par caractère en éditant les valeurs unicode. */
		final String caracteres 
			= controle.listerChaineCarParCar(lectureLigne);
		
		
		/* résultat du contrôle de bonnes longueurs des lignes. */
		final boolean bonneLongueurs 
			= this.controlerLongueursLignes(controle.getFichierEnMap(), 520);
		
		// AFFICHAGES. ********************
		/* Résultat de la lecture par le Charset*/
		System.out.println();
		System.out.println("Fichier écrit dans l'encodage " + charset.name() + " : " + resultat);
		
		/* Affichage de l'enregistrement sur disque du rapport de contrôle. */
		System.out.println();
		System.out.println("Un rapport de contrôle a été enregistré : \n" + controle.afficherRapportEnregistrementTextuel());
		
		/* Affichage de la ligne désignée par son numéro. */
		System.out.println();
		System.out.println("ligne numéro " + numeroLigne + " : " + lectureLigne);
		
		/* Affichage du fichier ligne par ligne lu par charset. */
		System.out.println();
		System.out.println(lectureLigneParLigne);
		
		
		System.out.println();
		System.out.println(caracteres);
		
		
		System.out.println();
		System.out.println("Fichier a de bonnes longueurs de ligne : " + bonneLongueurs);
		
		
//		System.out.println();
//		System.out.println("Nombre de caractères imprimables : " + this.donnerNombreCaracteresImprimables(lectureLigne, charset));
		
	} // Fin de testControler().___________________________________________


	
	/**
	 * method controlerLongueursLignes(
	 * Map<Integer, String> pMap
	 * , int pLongueur) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pMap
	 * @param pLongueur
	 * @return : boolean :  .<br/>
	 */
	public final boolean controlerLongueursLignes(
			final Map<Integer, String> pMap
				, final int pLongueur) {
		
		boolean resultat = true;
		
		final Set<Entry<Integer, String>> set = pMap.entrySet();
		
		final Iterator<Entry<Integer, String>> ite = set.iterator();
		
		while (ite.hasNext()) {
			
			final Entry<Integer, String> entry = ite.next();
			
			final int numeroLigne = entry.getKey();
			final String ligne = entry.getValue();
			
			final int longueurLigne = ligne.length();
			
			if (longueurLigne != pLongueur) {
				System.out.println("la ligne " + numeroLigne + " a une mauvaise longueur de " + longueurLigne);
				resultat = false;
			}
		}
		
		return resultat;
		
	} // Fin de controlerLongueursLignes(
	 // Map<Integer, String> pMap
	 // , int pLongueur).__________________________________________________
	

	
	/**
	 * method donnerNombreCaracteresImprimables(
	 * String pString
	 * , Charset pCharset) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pString
	 * @param pCharset
	 * 
	 * @return : int :  .<br/>
	 */
	public final int donnerNombreCaracteresImprimables(
			final String pString
				, final Charset pCharset) {

		final StringBuilder builderOriginal = new StringBuilder();
		final StringBuilder builderPlateforme = new StringBuilder();
		
		String decodeeOriginal = null;
		String decodeePlateforme = null;
		
		try {
			
			/* Transforme pString en tableau byte[] décodé 
			 * avec le Charset d'origine. */
			final byte[] originalBytes 
				= pString.getBytes(pCharset);
			/* Transforme pString en tableau byte[] décodé 
			 * avec le Charset de la plateforme. */
			final byte[] plateformeBytes 
				= pString.getBytes(System.getProperty("file.encoding"));
			
			
			/* Met le byte[] décodé avec le Charset d'origine 
			 * dans un InputStream. */
			final InputStream inputStreamOriginal 
				= new ByteArrayInputStream(originalBytes);
			/* Met le byte[] décodé avec le Charset de la plateforme
			 * dans un InputStream. */
			final InputStream inputStreamPlateforme 
				= new ByteArrayInputStream(plateformeBytes);

			/* Crée un buffer ne contenant qu'un seul caractère pour la chaîne originale. */
			final byte[] bufferCaractereOriginal = new byte[1];
			
			/* Crée un buffer ne contenant qu'un seul caractère pour la chaîne lue par la plateforme. */
			final byte[] bufferCaracterePlateforme = new byte[1];

			/* Parcours de la chaîne de caractères. */
			while (true) {

				// Lecture de chaque caractère dans le Buffer de 1 byte dans la chaîne original.
				final int caractereEntierOriginal 
					= inputStreamOriginal.read(bufferCaractereOriginal);
				
				// Lecture de chaque caractère dans le Buffer de 1 byte dans la chaîne original.
				final int caractereEntierPlateforme 
					= inputStreamPlateforme.read(bufferCaracterePlateforme);

				/* Sort de la lecture à la fin de la String. */
				if (caractereEntierOriginal < 0 || caractereEntierPlateforme < 0) {
					break;
				}
				
				final char caractereLuOriginal = (char) bufferCaractereOriginal[0];
				final char caractereLuPlateforme = (char) bufferCaracterePlateforme[0];
				

				
//				final String data = new String(buffer, 0, caractereEntier,
//						pCharset);
//				builder.append(data);
				
				builderOriginal.append(caractereLuOriginal);
				builderPlateforme.append(caractereLuPlateforme);
				
				decodeeOriginal = builderOriginal.toString();
				decodeePlateforme = builderPlateforme.toString();
				
				System.out.println("decodeeOriginal   : " + decodeeOriginal);
				System.out.println("decodeePlateforme : " + decodeePlateforme);
				
				if (caractereLuOriginal != caractereLuPlateforme) {
					System.out.println("ATTENTION - CARACTERES DIFFERENTS : " + "original : " + caractereLuOriginal + " - plateforme : " + caractereLuPlateforme);
				}

			} // Fin de Parcours de la chaîne de caractères.____________
			
			
			decodeeOriginal = builderOriginal.toString();
			System.out.println("decodeeOriginal   : " + decodeeOriginal);
			
			decodeePlateforme = builderOriginal.toString();
			System.out.println("decodeePlateforme : " + decodeePlateforme);
			
			if (decodeeOriginal.length() != decodeePlateforme.length()) {
				System.out.println("ATTENTION DECALAGE");
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}

		
		return decodeeOriginal.length();

	}
	
	
	
} // FIN DE LA CLASSE ControleurEncodageTest.--------------------------------
