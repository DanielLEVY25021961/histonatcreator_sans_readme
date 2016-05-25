package levy.daniel.application.metier.service.enregistreursfichiers.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;

import levy.daniel.application.metier.services.enregistreursfichiers.IEnregistreurFichiers;
import levy.daniel.application.metier.services.enregistreursfichiers.impl.EnregistreurFichiers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * class EnregistreurFichiersTest :<br/>
 * Test JUnit de la classe EnregistreurFichiers.<br/>
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
 * @since 23 mars 2016
 *
 */
public final class EnregistreurFichiersTest {

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
			.getLog(EnregistreurFichiersTest.class);
	
	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR EnregistreurFichiersTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public EnregistreurFichiersTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method testEcrireStringDansFileNull() :<br/>
	 * Teste la méthode ecrireStringDansFile(.....).<br/>
	 * - vérifie que ecrireStringDansFile(null, ...) 
	 * retourne null, LOG de niveau INFO 
	 * et rapport si pFile est null.<br/>
	 * <br/>
	 */
	@Test
	public void testEcrireStringDansFileNull() {
		
		/* Instanciation d'un EnregistreurFichiers. */
		final IEnregistreurFichiers enregistreur 
			= new EnregistreurFichiers(
					new Date(), "Administrateur", "Test", null);
		
		final File resultat 
		= enregistreur.ecrireStringDansFile(
				null, "toto", CHARSET_UTF8, NEWLINE);
		
		/* vérifie que ecrireStringDansFile(null, ...) a retourné null. */
		assertNull("doit retourner null : "
					, resultat);
		
		/* vérifie que ecrireStringDansFile(null, ...) 
		 * a retourné un rapport non null. */
		assertNotNull("le rapport ne doit pas être null : "
					, enregistreur.getRapport());
		
		/* vérifie que ecrireStringDansFile(null, ...) 
		 * a retourné un rapport non vide. */
		assertFalse("le rapport ne doit pas être vide : "
				, enregistreur.getRapport().isEmpty());
		
	} // Fin de testEcrireStringDansFileNull().____________________________
	
	
	
	/**
	 * method testEcrireStringDansFileInexistant() :<br/>
	 * Teste la méthode ecrireStringDansFile(.....).<br/>
	 * - vérifie que ecrireStringDansFile(inexistant, ...) 
	 * retourne null, LOG de niveau INFO 
	 * et rapport si pFile est inexistant.<br/>
	 * <br/>
	 */
	@Test
	public void testEcrireStringDansFileInexistant() {
		
		/* Instanciation d'un EnregistreurFichiers. */
		final IEnregistreurFichiers enregistreur 
			= new EnregistreurFichiers(
					new Date(), "Administrateur", "Test", null);
		
		final File resultat 
		= enregistreur.ecrireStringDansFile(
				FILE_INEXISTANT, "toto", CHARSET_UTF8, NEWLINE);
		
		/* vérifie que ecrireStringDansFile(inexistant, ...) a retourné null. */
		assertNull("doit retourner null : "
					, resultat);
		
		/* vérifie que ecrireStringDansFile(inexistant, ...) 
		 * a retourné un rapport non null. */
		assertNotNull("le rapport ne doit pas être null : "
					, enregistreur.getRapport());
		
		/* vérifie que ecrireStringDansFile(inexistant, ...) 
		 * a retourné un rapport non vide. */
		assertFalse("le rapport ne doit pas être vide : "
				, enregistreur.getRapport().isEmpty());
		
//		System.out.println(enregistreur.afficherRapportCsvAvecEntete());
		
	} // Fin de testEcrireStringDansFileInexistant().______________________
	

	
	/**
	 * method testEcrireStringDansFileRepertoire() :<br/>
	 * Teste la méthode ecrireStringDansFile(.....).<br/>
	 * - vérifie que ecrireStringDansFile(repertoire, ...) 
	 * retourne null, LOG de niveau INFO 
	 * et rapport si pFile est un répertoire.<br/>
	 * <br/>
	 */
	@Test
	public void testEcrireStringDansFileRepertoire() {
		
		/* Instanciation d'un EnregistreurFichiers. */
		final IEnregistreurFichiers enregistreur 
			= new EnregistreurFichiers(
					new Date(), "Administrateur", "Test", null);
		
		final File resultat 
		= enregistreur.ecrireStringDansFile(
				FILE_REPERTOIRE, "toto", CHARSET_UTF8, NEWLINE);
		
		/* vérifie que ecrireStringDansFile(repertoire, ...) a retourné null. */
		assertNull("doit retourner null : "
					, resultat);
		
		/* vérifie que ecrireStringDansFile(repertoire, ...) 
		 * a retourné un rapport non null. */
		assertNotNull("le rapport ne doit pas être null : "
					, enregistreur.getRapport());
		
		/* vérifie que ecrireStringDansFile(repertoire, ...) 
		 * a retourné un rapport non vide. */
		assertFalse("le rapport ne doit pas être vide : "
				, enregistreur.getRapport().isEmpty());

//		System.out.println(enregistreur.afficherRapportCsvAvecEntete());
		
	} // Fin de testEcrireStringDansFileRepertoire().______________________
	

	
	/**
	 * method testEcrireStringDansFileStringBlank() :<br/>
	 * Teste la méthode ecrireStringDansFile(.....).<br/>
	 * - vérifie que ecrireStringDansFile(fichier, String blank, ...) 
	 * retourne null, LOG de niveau INFO 
	 * et rapport si pFile est un répertoire.<br/>
	 * <br/>
	 */
	@Test
	public void testEcrireStringDansFileStringBlank() {
		
		/* Instanciation d'un fichier. */
		final File fileADetruire 
			= new File(
					".\\test\\ressourcesjunit\\repertoire a detruire\\enregistreurFichier.txt");
		
		/* Création du fichier. */
		try {
			fileADetruire.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* Instanciation d'une String blank à écrire dans le fichier. */
		final String aEcrire = "   ";
		
		/* Instanciation d'un EnregistreurFichiers. */
		final IEnregistreurFichiers enregistreur 
			= new EnregistreurFichiers(
					new Date(), "Administrateur", "Test", null);
		
		final File resultat 
		= enregistreur.ecrireStringDansFile(
				fileADetruire, aEcrire, CHARSET_UTF8, NEWLINE);
		
		/* vérifie que ecrireStringDansFile(fichier, String blank, ...) 
		 * a retourné null. */
		assertNull("doit retourner null : "
					, resultat);
		
		/* vérifie que ecrireStringDansFile(fichier, String blank, ...) 
		 * a retourné un rapport non null. */
		assertNotNull("le rapport ne doit pas être null : "
					, enregistreur.getRapport());
		
		/* vérifie que ecrireStringDansFile(fichier, String blank, ...) 
		 * a retourné un rapport non vide. */
		assertFalse("le rapport ne doit pas être vide : "
				, enregistreur.getRapport().isEmpty());

//		System.out.println(enregistreur.afficherRapportCsvAvecEntete());
		
	} // Fin de testEcrireStringDansFileStringBlank()._____________________
	
	
	
	/**
	 * method testEcrireStringDansFile() :<br/>
	 * Teste la méthode ecrireStringDansFile(.....).<br/>
	 * - vérifie que ecrireStringDansFile(fichier, String, ...) 
	 * enregistre convenablement la String dans le fichier, LOG de niveau INFO 
	 * et rapport si pFile est un fichier valide.<br/>
	 * <br/>
	 */
	@Test
	public void testEcrireStringDansFile() {
		
		/* Instanciation d'un fichier. */
		final File fileADetruire 
			= new File(
					".\\test\\ressourcesjunit\\repertoire a detruire\\enregistreurFichier.txt");
		
		/* Création du fichier. */
		try {
			fileADetruire.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* Instanciation d'une String à écrire dans le fichier. */
		final String aEcrire = "bien joué cher être, c'est incroyable ce manque d'idées";
		
		/* Instanciation d'un EnregistreurFichiers. */
		final IEnregistreurFichiers enregistreur 
			= new EnregistreurFichiers(
					new Date(), "Administrateur", "Test", null);
		
		/* Récupération du fichier écrit sur disque. */
		final File resultat 
		= enregistreur.ecrireStringDansFile(
				fileADetruire, aEcrire, CHARSET_UTF8, NEWLINE);
		
		assertNotNull("Le fichier enregistré ne doit pas être null : "
				, resultat);
		
		/* vérifie que ecrireStringDansFile(fichier, String, ...) 
		 * a retourné un rapport non null. */
		assertNotNull("le rapport ne doit pas être null : "
					, enregistreur.getRapport());
		
		/* vérifie que ecrireStringDansFile(fichier, String, ...) 
		 * a retourné un rapport non vide. */
		assertFalse("le rapport ne doit pas être vide : "
				, enregistreur.getRapport().isEmpty());
		
//		System.out.println(enregistreur.afficherRapportCsvAvecEntete());
		
	} // Fin de testEcrireStringDansFile().________________________________


} // FIN DE LA CLASSE EnregistreurFichiersTest.------------------------------
