package levy.daniel.application.util.gestionnairesiofichiers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import levy.daniel.application.IConstantesMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class GestionnaireFichiers :<br/>
 * .<br/>
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
 * @since 11 févr. 2016
 *
 */
public final class GestionnaireFichiers {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_GESTIONNAIRE_FICHIERS : String :<br/>
	 * "Classe GestionnaireFichiers".<br/>
	 */
	public static final String CLASSE_GESTIONNAIRE_FICHIERS 
		= "Classe GestionnaireFichiers";
	
	
	/**
	 * METHODE_ECRIRESTRINGDANSFILE : String :<br/>
	 * "méthode ecrireStringDansFile(
	 * File pFile, String pString, Charset pCharset)".<br/>
	 */
	public static final String METHODE_ECRIRESTRINGDANSFILE 
		= "méthode ecrireStringDansFile(File pFile, ....)";
	
	
	/**
	 * METHODE_FOURNIRFILE : String :<br/>
	 * "méthode fournirFile(String pChemin, Date pDate, String pNomFichier)".<br/>
	 */
	public static final String METHODE_FOURNIRFILE 
		= "méthode fournirFile(String pChemin, Date pDate, String pNomFichier)";

	
	/**
	 * METHODE_DETRUIRE_ARBORESCENCE : String :<br/>
	 * "méthode detruireArborescence(String pChemin)".<br/>
	 */
	public static final String METHODE_DETRUIRE_ARBORESCENCE 
		= "méthode detruireArborescence(String pChemin)";

	
	/**
	 * METHODE_VIDER_REPERTOIRE : String :<br/>
	 * "méthode viderRepertoireADetruire(File pFile)".<br/>
	 */
	public static final String METHODE_VIDER_REPERTOIRE 
		= "méthode viderRepertoireADetruire(File pFile)";

	
	/**
	 * MESSAGE_FICHIER_NULL : String :<br/>
	 * Message retourné par la METHODE_ECRIRESTRINGDANSFILE 
	 * si le fichier est null.<br/>
	 * "Le fichier passé en paramètre est null".<br/>
	 */
	public static final String MESSAGE_FICHIER_NULL 
		= "Le fichier passé en paramètre est null";
		
	/**
	 * MESSAGE_FICHIER_INEXISTANT : String :<br/>
	 * Message retourné par la METHODE_ECRIRESTRINGDANSFILE 
	 * si le fichier est inexistant.<br/>
	 * "Le fichier passé en paramètre est inexistant : "
	 */
	public static final String MESSAGE_FICHIER_INEXISTANT 
		= "Le fichier passé en paramètre est inexistant : ";
	
	/**
	 * MESSAGE_FICHIER_REPERTOIRE : String :<br/>
	 * Message retourné par la METHODE_ECRIRESTRINGDANSFILE 
	 * si le fichier est un répertoire.<br/>
	 * "Le fichier passé en paramètre est un répertoire : ".<br/>
	 */
	public static final String MESSAGE_FICHIER_REPERTOIRE 
		= "Le fichier passé en paramètre est un répertoire : ";

	/**
	 * MESSAGE_STRING_BLANK : String :<br/>
	 * Message retourné par la METHODE_ECRIRESTRINGDANSFILE 
	 * si la String passée en paramètre est blank.<br/>
	 * "La chaine de caractères passée en paramètre est blank (null ou vide) : "
	 */
	public static final String MESSAGE_STRING_BLANK 
	= "La chaine de caractères passée en paramètre est blank (null ou vide) : ";
	
	
	/**
	 * MESSAGE_EXCEPTION : String :<br/>
	 * "Exception GRAVE : ".<br/>
	 */
	public static final String MESSAGE_EXCEPTION = "Exception GRAVE : ";
	

	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	public static final Charset CHARSET_UTF8 
		= Charset.forName("UTF-8");
	
	
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
	 * "\r\n" (Retour Chariot RC + Retour Ligne LF).
	 */
	public static final String SAUTDELIGNE_DOS_WINDOWS = "\r\n";

	
	/**
	 * NEWLINE : String :<br/>
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	public static final String NEWLINE = System.getProperty("line.separator");

	
	/**
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("FR", "fr").<br/>
	 */
	public static final Locale LOCALE_FR_FR = new Locale("FR", "fr");

	
	/**
	 * DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE : DateFormat :<br/>
	 * Format concentré des dates avec heures et secondes
	 * comme "2012-01-16_18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	public static final DateFormat DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", LOCALE_FR_FR);
	


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(GestionnaireFichiers.class);

	// *************************METHODES************************************/
	
	
	/**
	 * method CONSTRUCTEUR GestionnaireFichiers() :
	 * Constructeur private pour empêcher l'instanciation.
	 */
	private GestionnaireFichiers() {
		super();
	} // Fin de CONSTRUCTEUR GestionnaireFichiers()._______________________


	
	/**
	 * method ecrireStringDansFileUtf8(
	 * String pString) :<br/>
	 * Ecrit la String pString dans le File fourni par 
	 * fournirFile(null) avec un encodage UTF-8 
	 * et les sauts de ligne NEWLINE de la plateforme.<br/>
	 * Utilise FileOutputStream, 
	 * new OutputStreamWriter(fileOutputStream, charset) 
	 * et BufferedWriter pour écrire.<br/>
	 * Ecriture dans un fichier, écriture sur disque.<br/>
	 * <br/>
	 * - Passe automatiquement le Charset à CHARSET_UTF8.<br/>
	 * - Passe automatiquement le saut de ligne à NEWLINE 
	 * (saut de ligne de la plateforme).<br/>
	 * - Substitue automatiquement NEWLINE (saut de ligne de la plateforme) 
	 * aux sauts de ligne dans pString si nécessaire.<br/>
	 * <br/>
	 * - retourne null en cas d'Exception loggée 
	 * (FileNotFoundException, IOException).<br/>
	 * - retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString : String : String que l'on copie dans pFile.<br/>
	 * 
	 * @return : File : Le fichier dans lequel on a écrit pString.<br/>
	 */
	public static File ecrireStringDansFileUtf8(final String pString) {
		
		final File file = fournirFile(null, null, null, null, null);
		
		return ecrireStringDansFile(file, pString, CHARSET_UTF8, NEWLINE);
		
	} // Fin de ecrireStringDansFileUtf8(
	 // String pString).___________________________________________________
	

	
	/**
	 * method ecrireStringDansFile(
	 * File pFile
	 * , String pString
	 * , Charset pCharset
	 * , String pSautLigne) :<br/>
	 * Ecrit la String pString dans le File pFile avec un encodage pCharset.<br/>
	 * Substitue automatiquement pSautLigne aux sauts de ligne 
	 * dans pString si nécessaire.<br/>
	 * Utilise FileOutputStream, 
	 * new OutputStreamWriter(fileOutputStream, charset) 
	 * et BufferedWriter pour écrire.<br/>
	 * Ecriture dans un fichier, écriture sur disque.<br/>
	 * <br/>
	 * - Passe automatiquement le Charset à CHARSET_UTF8 
	 * si pCharset est null.<br/>
	 * - Passe automatiquement le saut de ligne à NEWLINE 
	 * (saut de ligne de la plateforme) si pSautLigne est blank.<br/>
	 * <br/>
	 * - retourne null si le pFile est null.<br/>
	 * - retourne null si le pFile est inexistant.<br/>
	 * - retourne null si le pFile est un répertoire.<br/>
	 * - retourne null en cas d'Exception loggée 
	 * (FileNotFoundException, IOException).<br/>
	 * - retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier dans lequel on écrit.<br/>
	 * @param pString : String : String que l'on copie dans pFile.<br/>
	 * @param pCharset : Charset : Charset pour encoder le fichier.<br/>
	 * @param pSautLigne : String : Saut de ligne que l'on veut 
	 * dans pFile de sortie 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix).<br/>
	 * 
	 * @return : File : Le fichier dans lequel on a écrit pString.<br/>
	 */
	public static File ecrireStringDansFile(
			final File pFile
				, final String pString
					, final Charset pCharset
						, final String pSautLigne) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireFichiers.class) {
			
			/* retourne null si le pFile est null. */
			if (pFile == null) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_GESTIONNAIRE_FICHIERS
							, METHODE_ECRIRESTRINGDANSFILE
								, MESSAGE_FICHIER_NULL);
				
				/* retour de null. */
				return null;
			}
			
			/* retourne null si le pFile est inexistant. */
			if (!pFile.exists()) {
								
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_GESTIONNAIRE_FICHIERS
							, METHODE_ECRIRESTRINGDANSFILE
								, MESSAGE_FICHIER_INEXISTANT
									, pFile.getAbsolutePath());
				
				/* retour de null. */
				return null;
			}
			
			/* retourne null si le pFile est un répertoire. */
			if (pFile.isDirectory()) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_GESTIONNAIRE_FICHIERS
							, METHODE_ECRIRESTRINGDANSFILE
								, MESSAGE_FICHIER_REPERTOIRE
									, pFile.getAbsolutePath());
				
				/* retour de null. */
				return null;
			}
			
			/* retourne null si pString est blank. */
			if (StringUtils.isBlank(pString)) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_GESTIONNAIRE_FICHIERS
							, METHODE_ECRIRESTRINGDANSFILE
								, MESSAGE_STRING_BLANK
									, pString);
				
				return null;
			}
			
			
			Charset charset = null;
			
			/* Passe automatiquement le charset à UTF-8 si pCharset est null. */
			if (pCharset == null) {
				charset = CHARSET_UTF8;
			}
			else {
				charset = pCharset;
			}
			
			String sautLigne = null;
			
			/* Passe automatiquement le saut de ligne à NEWLINE 
			 * (saut de ligne de la plateforme) si pSautLigne est blank. */
			if (StringUtils.isBlank(pSautLigne)) {
				sautLigne = NEWLINE;
			} else {
				sautLigne = pSautLigne;
			}
			
			// ECRITURE SUR DISQUE ***************
			FileOutputStream fileOutputStream = null;
			OutputStreamWriter outputStreamWriter = null;
			BufferedWriter bufferedWriter = null;
			
			try {
				
				/* Ouverture d'un FileOutputStream sur le fichier. */
				fileOutputStream 
					= new FileOutputStream(pFile);
				
				/* Ouverture d'un OutputStreamWriter 
				 * sur le FileOutputStream en lui passant le Charset. */
				outputStreamWriter 
					= new OutputStreamWriter(fileOutputStream, charset);
				
				/* Ouverture d'un tampon d'écriture 
				 * BufferedWriter sur le OutputStreamWriter. */
				bufferedWriter 
					= new BufferedWriter(outputStreamWriter);
				
				// ECRITURE.
				/* Substitue automatiquement sautLigne aux sauts de ligne 
				 * dans pString si nécessaire. */
				bufferedWriter.write(substituerSautLigne(pString, sautLigne));
				
				// Retour du fichier. 
				return pFile;
				
			} catch (FileNotFoundException fnfe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_GESTIONNAIRE_FICHIERS
							, MESSAGE_EXCEPTION				
								, fnfe);
				
				/* retour de null. */
				return null;
				
			} catch (IOException ioe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_GESTIONNAIRE_FICHIERS
							, MESSAGE_EXCEPTION				
								, ioe);
				
				/* retour de null. */
				return null;
			}
			
			finally {
				
				if (bufferedWriter != null) {
					try {
						
						bufferedWriter.close();
						
					} catch (IOException ioe1) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_GESTIONNAIRE_FICHIERS
									, MESSAGE_EXCEPTION				
										, ioe1);
					}
				} // Fin de if (bufferedWriter != null).__________
				
				if (outputStreamWriter != null) {
					try {
						
						outputStreamWriter.close();
						
					} catch (IOException ioe2) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_GESTIONNAIRE_FICHIERS
									, MESSAGE_EXCEPTION				
										, ioe2);
					}
				} // Fin de if (outputStreamWriter != null).______
				
				if (fileOutputStream != null) {
					try {
						
						fileOutputStream.close();
						
					} catch (IOException ioe3) {
						
						//* LOG de niveau ERROR. */
						loggerError(
								CLASSE_GESTIONNAIRE_FICHIERS
									, MESSAGE_EXCEPTION				
										, ioe3);
					}
				}
				
			} // Fin du finally.____________________________
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de ecrireStringDansFile(...)._________________________________
	

	
	/**
	 * method creerArborescence(
	 * String pChemin) :<br/>
	 * Créée en une seule fois toute l'arborescence passée en paramètre.<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * - creerArborescence("C:\\NewRep1\\NewRep2\\NewRep3") 
	 * va créer toute cette arborescence sur le disque d'un seul coup.<br/>
	 * - creerArborescence(".\\data2\\temp\\rapports") 
	 * va créer cette arborescence à partir 
	 * du répertoire courant d'un seul coup.<br/>
	 * <br/>
	 * - retourne false si pChemin est blank.<br/>
	 * - retourne false si l'arborescence existe déjà.<br/>
	 * - retourne false si pChemin ne contient pas '\\'.<br/>
	 * - retourne false si un des répertoires du chemin est blank.<br/>
	 * - retourne false si la racine du chemin n'existe pas.<br/>
	 * - retourne false si la racine du chemin n'est pas un répertoire.<br/>
	 * - retourne false si un répertoire a créer n'a pas été créé.<br/>
	 * <br/>
	 *
	 * @param pChemin : String : Chemin de l'arborescence à créer.<br/>
	 * 
	 * @return boolean : true si l'arborescence a été créée.<br/>
	 */
	public static boolean creerArborescence(
			final String pChemin) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireFichiers.class) {
			
			/* retourne false si pChemin est blank. */
			if (StringUtils.isBlank(pChemin)) {
				return false;
			}
			
			final File cheminFile = new File(pChemin);
			
			/* retourne false si l'arborescence existe déjà. */
			if (cheminFile.exists()) {
				return false;
			}
			
			/* retourne false si pChemin ne contient pas '\\'. */
			if (!StringUtils.contains(pChemin, "\\")) {
				return false;
			}
			
			/* Récupération des répertoires par découpage de la chaine. */
			final String[] repertoires = StringUtils.split(pChemin, "\\");
			final int nombreRep = repertoires.length;
			
			/* retourne false si un des répertoires du chemin est blank. */
			for(final String rep : repertoires) {
				if (StringUtils.isBlank(rep)) {
					return false;
				}
			}
			
			/* Extraction de la racine. */
			final String repRacineString = repertoires[0];
			
			final File repRacine = new File(repRacineString);
			
			/* retourne false si la racine du chemin n'existe pas. */
			if (!repRacine.exists()) {
				return false;
			}
			
			/* retourne false si la racine du chemin n'est pas un répertoire. */
			if (!repRacine.isDirectory()) {
				return false;
			}
			
			final StringBuffer stb = new StringBuffer();
			
			stb.append(repRacineString);
			
			/* Boucle sur les répertoires du chemin. */
			for (int i = 1; i < nombreRep; i++) {
				
				/* Création du chemin du répertoire à créer. */
				stb.append(IConstantesMessage.SEP_REP);
				stb.append(repertoires[i]);
				
				final File repertoireFile = new File(stb.toString());
				
				/* Créée le répertoire au chemin de création 
				 * si il n'existait pas.*/
				if (!repertoireFile.exists()) {
					
					if (!repertoireFile.mkdir()) {
						/* retourne false si un répertoire 
						 * a créer n'a pas été créé. */
						return false;
					}
				}
				
			} // Fin de boucle.________________________
			
			/* retourne true si l'arborescence a été créée. */
			return true;
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de creerArborescence(
	 // String pChemin).___________________________________________________
	
	
	
	/**
	 * method detruireArborescence(
	 * String pChemin) :<br/>
	 * Détruit le répertoire situé au chemin pChemin.<br/>
	 * Vide le contenu du répertoire si nécessaire avant de le supprimer.<br/>
	 * <br/>
	 * - retourne false si pChemin est blank.<br/>
	 * - retourne false si le répertoire à détruire n'existe pas.<br/>
	 * - retourne false si le File à détruire n'est pas un répertoire.
	 * <br/>
	 *
	 * @param pChemin : String : Chemin du répertoire à détruire.<br/>
	 * 
	 * @return : boolean : true si le répertoire a été détruit.<br/>
	 */
	public static boolean detruireArborescence(
			final String pChemin) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireFichiers.class) {
			
			/* retourne false si pChemin est blank. */
			if (StringUtils.isBlank(pChemin)) {
				return false;
			}
						
			final File repADetruire = new File(pChemin);
			
			/* retourne false si le répertoire à détruire n'existe pas. */
			if (!repADetruire.exists()) {
				return false;
			}
			
			/* retourne false si le File à détruire n'est pas un répertoire. */
			if (!repADetruire.isDirectory()) {
				return false;
			}
						
			/* Détruit le répertoire et retourne le boolean. */				
			try {
				
				/* Vide d'abord le contenu du répertoire. */
				viderRepertoireADetruire(repADetruire);
				
				/* Détruit le répertoire. */
				return repADetruire.delete();
				
			} catch (Exception e) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_GESTIONNAIRE_FICHIERS
							, METHODE_DETRUIRE_ARBORESCENCE
								, e.getMessage());
				
				return false;
				
			}
				
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de detruireArborescence(
	 // String pChemin).___________________________________________________
	


	/**
	 * method viderRepertoire(
	 * File pRep) :<br/>
	 * Vide tout le contenu du répertoire pRep sans écraser pRep.<br/>
	 * méthode récursive.<br/>
	 * Il est indispensable de vider tout le contenu d'un répertoire 
	 * avant de pouvoir supprimer celui-ci en Java.<br/>
	 * <br/>
	 *
	 * @param pRep : File : Répertoire dont on veut vider 
	 * tout le contenu le contenu tout en le conservant.<br/>
	 */
	public static void viderRepertoire(
			final File pRep) {

		/* bloc static synchronized. */
		synchronized (GestionnaireFichiers.class) {
			
			/* retourne false si pRep == null. */
			if (pRep == null) {
				return;
			}
			
			System.out.println();
			System.out.println("DEBUT METHODE viderRepertoire(File pRep) - pRep = " + pRep.getPath());
			
			
			
			/* retourne false si pRep n'existe pas. */
			if (!pRep.exists()) {
				System.out.println("METHODE viderRepertoire(File pRep) - pRep = " + pRep.getPath() + "     !pRep.exists()) RETURN");
				return;
			}
			
			/* retourne false si pRep n'est pas un répertoire. */
			if(!pRep.isDirectory()) {
				System.out.println("METHODE viderRepertoire(File pRep) - pRep = " + pRep.getPath() + "     !pRep.isDirectory()) RETURN");
				return;
			}
			
			/* Récupération des File dans pRep. */
			final File[] filesContenus = pRep.listFiles();
			System.out.println("filesContenus dans pRep = " + pRep.getPath() + " : " + affichierTableauFiles(pRep.listFiles()));
			
			System.out.println();
			System.out.println("BOUCLE DE NIVEAU pRep = " + pRep.getPath());
			/* ForEach (boucle) sur les File de pRep. ******/
			for (final File file : filesContenus) {
				
				/* Sort Si pRep est vide. */
				if (filesContenus.length == 0) {
					System.out.println("if (filesContenus.length == 0) RETURN pour pRep = " + pRep.getPath());
					return;
				}
				
				System.out.println();
				System.out.println("file dans la boucle : " + file.getPath() + "   alors que pRep = " + pRep.getPath());
				
				if (file.isDirectory()) {
					System.out.println("APPEL RECURSIF emptyDirectory(file) - file est Directory : " + file.getPath());
					viderRepertoire(file);
				}
				
				System.out.println("*************Destruction de file : " + file.getPath() + "   alors que pRep = " + pRep.getPath());
				file.delete();
				
			} // Fin de ForEach (boucle) sur les File de pRep. ******__
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de viderRepertoire(
	 // File pRep).________________________________________________________
	
	

	/**
	 * method viderRepertoireADetruire(
	 * File pRep) :<br/>
	 * Vide tout le contenu du répertoire pRep sans écraser pRep.<br/>
	 * méthode récursive.<br/>
	 * Il est indispensable de vider tout le contenu d'un répertoire 
	 * avant de pouvoir supprimer celui-ci en Java.<br/>
	 * <br/>
	 * Retourne un boolean à true si le 
	 * contenu du répertoire a bien été effacé.<br/>
	 * <br/>
	 * - retourne false si pRep == null.<br/>
	 * - retourne false si pRep n'existe pas.<br/>
	 * - retourne false si pRep n'est pas un répertoire.<br/>
	 * <br/>
	 *
	 * @param pRep : File : Répertoire dont on veut vider 
	 * tout le contenu le contenu tout en le conservant.<br/>
	 * 
	 * @return : boolean : true si le contenu du répertoire a été vidé.<br/>
	 */
	public static boolean viderRepertoireADetruire(
			final File pRep) {
				
		/* bloc static synchronized. */
		synchronized (GestionnaireFichiers.class) {
						
			/* retourne false si pRep == null. */
			if (pRep == null) {
				return false;
			}
			
			/* retourne false si pRep n'existe pas. */
			if (!pRep.exists()) {
				return false;
			}
			
			/* retourne false si pRep n'est pas un répertoire. */
			if(!pRep.isDirectory()) {
				return false;
			}
			
			System.out.println();
			System.out.println("pRep = " + pRep.getPath());
			
			/* Récupération des File dans pRep. */
			final File[] filesContenus = pRep.listFiles();
			
			System.out.println("filesContenus dans pRep = " + pRep.getPath() + " : " + affichierTableauFiles(pRep.listFiles()));
			
			/* Sort Si pRep est vide. */
			if (filesContenus.length == 0) {
				System.out.println("if (filesContenus.length == 0) return true pour pRep = " + pRep.getPath());
				return true;
			}
			
			System.out.println();
			System.out.println("BOUCLE DE NIVEAU pRep = " + pRep.getPath());
			/* Si pRep non vide. */
			/* ForEach (boucle) sur les File de pRep. ******/
			for(final File file : filesContenus) {
				
				System.out.println("file dans la boucle : " + file.getPath() + "   alors que pRep = " + pRep.getPath());
				
				/* Appel récursif si file est un répertoire. */
				if (file.isDirectory()) {
					
					System.out.println("APPEL RECURSIF viderRepertoireADetruire(file) : " + file.getPath());
					/* APPEL RECURSIF. */
					viderRepertoireADetruire(file);
					
					
				} // Fin de if (!file.isDirectory()).___________
				
				/* Destruction du file dans tous les cas. */					
				try {
					
					System.out.println("*******Destruction de file : " + file.getPath() + "   alors que pRep = " + pRep.getPath());
					file.delete();
					
				} catch (Exception e) {
					
					/* LOG de niveau INFO. */
					loggerInfo(
							CLASSE_GESTIONNAIRE_FICHIERS
								, METHODE_VIDER_REPERTOIRE
									, e.getMessage());
					return false;
					
				}
									
			} // Fin du ForEach (boucle) sur les File de pRep.___
			
			return true;
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de viderRepertoireADetruire(
	 // File pRep).________________________________________________________
	
	

	/**
	 * method fournirFile(String pChemin, Date pDate, String pNomFichier, String pEncodage, String pExtension) :<br/>
	 * .<br/>
	 * <br/>
	 * - crée un répertoire pour le fichier si il n'existe pas.<br/>
	 * <br/>
	 * - retourne null si pChemin est blank.<br/>
	 * - retourne null si il est impossible 
	 * de créer le répertoire pChemin.<br/>
	 * <br/>
	 * 
	 * @param pChemin : String : chemin (arborescence) pour le fichier.<br/>
	 * @param pDate : Date : Date pour préfixer le nom du fichier.<br/>
	 * @param pNomFichier : String : nom pour suffixer le nom du ficher.<br/>
	 * @param pEncodage : String : encodage du fichier.<br/>
	 * @param pExtension : String : extension du fichier.<br/>
	 * 
	 * @return : File :  .<br/>
	 */
	public static File fournirFile(
			final String pChemin
				, final Date pDate
					, final String pNomFichier
						, final String pEncodage
							, final String pExtension) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireFichiers.class) {
			
			/* retourne null si pChemin est blank. */
			if (StringUtils.isBlank(pChemin)) {
				return null;
			}
			
			
			/* Tentative de lecture du chemin du fichier. */
			final File repertoireFichier 
				= new File(pChemin);
			
			/* crée un répertoire pour le fichier si il n'existe pas. */
			if (!repertoireFichier.exists()) {
				
				boolean repertoireCree = false;
				
				try {
					
					/* Création du répertoire. */
					repertoireCree = repertoireFichier.mkdir();
					
				} catch (Exception mkdirExc) {
					
					/* LOG de niveau ERROR. */
					loggerError(
							CLASSE_GESTIONNAIRE_FICHIERS
								, METHODE_FOURNIRFILE
									, mkdirExc);
					
					/* retourne null. */
					return null;
				}
				
				if (!repertoireCree) {
					
					/* LOG de niveau ERROR. */
					if (LOG.isErrorEnabled()) {
						
						final String message 
						= CLASSE_GESTIONNAIRE_FICHIERS 
						+ IConstantesMessage.SEP_MOINS 
						+ METHODE_FOURNIRFILE
						+ IConstantesMessage.SEP_MOINS 
						+ "Impossible de créer le répertoire : " 
						+ pChemin;
						
						LOG.error(message);
						
					}
					
					/* retourne null. */
					return null;
				}
			} // Fin de if (!repertoireRapports.exists())._____________
			
			
			
			/* Récupère la date courante dans le système. */
			final Date maintenantDate = new Date();
			
			/* Récupère la date formattée sous forme 2012-01-16_18-09-55. */
			final String dateFormatteeString 
				= DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE
					.format(maintenantDate);
			
			String cheminFichier = null;
			
			cheminFichier = pChemin + "\\" + dateFormatteeString + "_RapportDIFFERENCES_TXT_UTF8.txt";
			
			final File resultatFile = new File(cheminFichier);
			
			/* Création du fichier si il n'existe pas. */
			if (!resultatFile.exists()) {
				try {
					resultatFile.createNewFile();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			System.out.println(resultatFile.getAbsolutePath());
			
			return resultatFile;
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de fournirFilePourRapportTextuel().___________________________


	/**
	 * method substituerSautLignePlateforme(
	 * String pString) :<br/>
	 * Substitue les sauts de ligne dans pString 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix) 
	 * par les sauts de ligne de la plate-forme
	 * sur laquelle le programme s'exécute.<br/>
	 * <br/>
	 * - retourne null si pString est blank (null ou vide).<br/>
	 * <br/>
	 *
	 * @param pString : String : String à corriger.<br/>
	 * 
	 * @return : String : La String dans laquelle les sauts de ligne 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix) 
	 * ont été substitués par les sauts de ligne de la plate-forme.<br/>
	 */
	public static String substituerSautLignePlateforme(
			final String pString) {
		
		return substituerSautLigne(pString, NEWLINE);
		
	} // Fin de method substituerSautLignePlateforme(
	 // String pString).___________________________________________________
	

	
	/**
	 * method substituerSautLigne(
	 * String pString
	 * , String pSautLigne) :<br/>
	 * Substitue les sauts de ligne dans pString 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix) 
	 * par les sauts de ligne pSautLigne.<br/>
	 * <br/>
	 * - retourne null si pString est blank (null ou vide).<br/>
	 * - retourne null si pSautLigne est blank (null ou vide).
	 * <br/>
	 *
	 * @param pString : String : String à corriger.<br/>
	 * @param pSautLigne : String : saut de ligne à substituer.<br/>
	 * 
	 * @return : String : La String dans laquelle les sauts de ligne 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix) 
	 * ont été substitués par les sauts de ligne pSautLigne.<br/>
	 */
	public static String substituerSautLigne(
			final String pString
				, final String pSautLigne) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireFichiers.class) {
			
			/* retourne null si pString est blank (null ou vide). */
			if (StringUtils.isBlank(pString)) {
				return null;
			}
			
			/* retourne null si pSautLigne est blank (null ou vide). */
			
			/* Recherche des sauts de ligne DOS/Windows. */
			if (StringUtils.contains(pString, SAUTDELIGNE_DOS_WINDOWS)) {
				
				final String resultat 
					= StringUtils.replace(
							pString, SAUTDELIGNE_DOS_WINDOWS, pSautLigne);
				
				return resultat;
			}
			
			/* Recherche des sauts de ligne Mac. */
			if (StringUtils.contains(pString, SAUTDELIGNE_MAC)) {
				
				final String resultat 
					= StringUtils.replace(
							pString, SAUTDELIGNE_MAC, pSautLigne);
				
				return resultat;
			}
			
			/* Recherche des sauts de ligne Unix. */
			if (StringUtils.contains(pString, SAUTDELIGNE_UNIX)) {
				
				final String resultat 
					= StringUtils.replace(
							pString, SAUTDELIGNE_UNIX, pSautLigne);
				
				return resultat;
			}
			
			/* Retourne la chaîne inchangée 
			 * si il n'y avait pas de saut de ligne. */
			return pString;
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de substituerSautLigne(
	 // String pString
	 // , String pSautLigne).______________________________________________
	
	
	
	/**
	 * method afficherSautLigne(
	 * String pSautLigne) :<br/>
	 * Affiche les caractères non imprimables 
	 * saut de ligne (\n ou \r ou \r\n).<br/>
	 * <br/>
	 * - retourne null si pSautLigne est null.<br/>
	 * - retourne null si pSautLigne n'est pas un saut de ligne 
	 * (\n ou \r ou \r\n).<br/>
	 * <br/>
	 *
	 * @param pSautLigne : String : \n ou \r ou \r\n.<br/>
	 * 
	 * @return : String : Affichage des caractères non imprimables 
	 * saut de ligne (\n ou \r ou \r\n).<br/>
	 */
	public static String afficherSautLigne(
			final String pSautLigne) {
		
		/* block static synchronized. */
		synchronized (GestionnaireFichiers.class) {
			
			/* retourne null si pSautLigne est null. */
			if (pSautLigne == null) {
				return null;
			}
			
			final StringBuilder stb = new StringBuilder();
			
			final char[] newLineChars = pSautLigne.toCharArray();
			
			for (final char caractere : newLineChars) {
				
				if (caractere == '\n') {
					stb.append("\\n");
				}
				else if (caractere == '\r') {
					stb.append("\\r");
				}
				/* retourne null si pSautLigne n'est pas un saut de ligne. */
				else {
					return null;
				}
				
			}
			
			return stb.toString();
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de afficherSautLigne(
	 // String pSautLigne).________________________________________________
	


	/**
	 * method affichierTableauFiles(
	 * File[] pFiles) :<br/>
	 * Retourne une String pour l'affichage d'un tableau de Files.<br/>
	 * Liste les fichiers contenus dans le tableau sous la forme 
	 * [.\rep_0\file_1_3.txt;.\rep_0\rep_1_1;.\rep_0\rep_1_2].<br/>
	 * <br/>
	 * - retourne null si pFile == null.<br/>
	 * - retourne [] si pFile est vide.<br/>
	 * <br/>
	 * 
	 *
	 * @param pFiles : File[] : tableau de File à afficher.<br/>
	 * @return : String : String pour affichage.<br/>
	 */
	public static String affichierTableauFiles(
			final File[] pFiles) {
		
		/* bloc static synchronized. */
		synchronized (GestionnaireFichiers.class) {
			
			/* retourne null si pFile == null. */
			if(pFiles == null) {
				return null;
			}
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append('[');
			
			for(int i = 0; i < pFiles.length; i++) {
				stb.append(pFiles[i].getPath());
				
				if (i < pFiles.length - 1) {
					stb.append(";");
				}				
			}
			
			stb.append(']');
			
			return stb.toString();
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de affichierTableauFiles(
	 // File[] pFiles).____________________________________________________
	
	

	/**
	 * method loggerInfo(
	 * String pClasse
	 * , String pMethode
	 * , String pMessage) :<br/>
	 * Créée un message de niveau INFO dans le LOG.<br/>
	 * <br/>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pMessage : String : Message particulier de la méthode.<br/>
	 */
	private static void loggerInfo(
			final String pClasse
				, final String pMethode
					, final String pMessage) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null || pMessage == null) {
			return;
		}
		
		/* LOG de niveau INFO. */			
		if (LOG.isInfoEnabled()) {
			
			final String message 
			= pClasse 
			+ IConstantesMessage.SEP_MOINS
			+ pMethode
			+ IConstantesMessage.SEP_MOINS
			+ pMessage;
			
			LOG.info(message);
		}
		
	} // Fin de la classe loggerInfo(
	 // String pClasse
	 // , String pMethode
	 // , String pMessage).________________________________________________
	

	
	/**
	 * method loggerInfo(
	 * String pClasse
	 * , String pMethode
	 * , String pMessage
	 * , String pComplement) :<br/>
	 * Créée un message de niveau INFO dans le LOG.<br/>
	 * <br/>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pMessage : String : Message particulier de la méthode.<br/>
	 * @param pComplement : String : Complément au message de la méthode.<br/>
	 */
	private static void loggerInfo(
			final String pClasse
				, final String pMethode
					, final String pMessage
						, final String pComplement) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null 
				|| pMessage == null || pComplement == null) {
			return;
		}
		
		/* LOG de niveau INFO. */			
		if (LOG.isInfoEnabled()) {
			
			final String message 
			= pClasse 
			+ IConstantesMessage.SEP_MOINS
			+ pMethode
			+ IConstantesMessage.SEP_MOINS
			+ pMessage
			+ pComplement;
			
			LOG.info(message);
		}
		
	} // Fin de loggerInfo(
	 // String pClasse
	 // , String pMethode
	 // , String pMessage
	 // , String pComplement)._____________________________________________
	
	
	
	/**
	 * method loggerError(
	 * String pClasse
	 * , String pMethode
	 * , Exception pException) :<br/>
	 * Créée un message de niveau ERROR dans le LOG.<br/>
	 * <br/>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pException : Exception : Exception transmise 
	 * par la méthode appelante.<br/>
	 */
	private static void loggerError(
			final String pClasse
				, final String pMethode
					, final Exception pException) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null || pException == null) {
			return;
		}
		
		/* LOG de niveau ERROR. */			
		if (LOG.isErrorEnabled()) {
			
			final String message 
			= pClasse 
			+ IConstantesMessage.SEP_MOINS
			+ pMethode
			+ IConstantesMessage.SEP_MOINS 
			+ pException.getMessage();
			
			LOG.error(message, pException);
			
		}
		
	} // Fin de loggerError(
	 // String pClasse
	 // , String pMethode
	 // , Exception pException).___________________________________________
	
	

	
} // FIN DE LA CLASSE GestionnaireFichiers.----------------------------------
