package levy.daniel.application.util.differentiateurs.differentiateursfichiers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import levy.daniel.application.util.differentiateurs.differentiateursstrings.CaractereDan;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class DifferentiateurFichiers :<br/>
 * Classe utilitaire spécialisée 
 * dans la détection caractère par caractère et 
 * dans le calcul de la différence entre deux File.<br/>
 * Fournit les données Unicode concernant les caractères.<br/>
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
 * @since 16 mars 2016
 *
 */
public final class DifferentiateurFichiers {

	// ************************ATTRIBUTS************************************/
	/**
	 * CLASSE_DIFFERENTIATEURFICHIERS : String :<br/>
	 * "Classe DifferentiateurFichiers".<br/>
	 */
	public static final String CLASSE_DIFFERENTIATEURFICHIERS 
		= "Classe DifferentiateurFichiers";

	/**
	 * METHODE_DIFFERENCIER : String :<br/>
	 * "Méthode differencier(....)".<br/>
	 */
	public static final String METHODE_DIFFERENCIER 
		= "Méthode differencier(....)";

	
	/**
	 * METHODE_AJOUTER_A_FILE : String :<br/>
	 * "Méthode ajouterAFile(File pFile, String pString)".<br/>
	 */
	public static final String METHODE_AJOUTER_A_FILE 
		= "Méthode ajouterAFile(File pFile, String pString)";
	
	
	/**
	 * METHODE_FOURNIRCHEMINRAPPORTSDANSPROPERTIES : String :<br/>
	 * "Méthode fournirCheminRapportsDansProperties()".<br/>
	 */
	public static final String METHODE_FOURNIRCHEMINRAPPORTSDANSPROPERTIES 
		= "Méthode fournirCheminRapportsDansProperties()";


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
	 * METHODE_FOURNIRFILE : String :<br/>
	 * "méthode fournirFile(String pChemin, Date pDate, String pNomFichier)".<br/>
	 */
	public static final String METHODE_FOURNIRFILE 
		= "méthode fournirFile(String pChemin, Date pDate, String pNomFichier)";


	/**
	 * MESSAGE_FICHIER_NULL : String :<br/>
	 * Message retourné par une méthode
	 * si le fichier est null.<br/>
	 * "Le fichier passé en paramètre est null".<br/>
	 */
	public static final String MESSAGE_FICHIER_NULL 
		= "Le fichier passé en paramètre est null";

	
	/**
	 * MESSAGE_FICHIER_INEXISTANT : String :<br/>
	 * Message retourné par une méthode 
	 * si le fichier est inexistant.<br/>
	 * "Le fichier passé en paramètre est inexistant : "
	 */
	public static final String MESSAGE_FICHIER_INEXISTANT 
		= "Le fichier passé en paramètre est inexistant : ";

	
	/**
	 * MESSAGE_FICHIER_REPERTOIRE : String :<br/>
	 * Message retourné par une méthode
	 * si le fichier est un répertoire.<br/>
	 * "Le fichier passé en paramètre est un répertoire : ".<br/>
	 */
	public static final String MESSAGE_FICHIER_REPERTOIRE 
		= "Le fichier passé en paramètre est un répertoire : ";

	
	/**
	 * MESSAGE_FICHIER_VIDE : String :<br/>
	 * "Le fichier passé en paramètre est un vide : ".<br/>
	 */
	public static final String MESSAGE_FICHIER_VIDE 
		= "Le fichier passé en paramètre est un vide : ";

	
	/**
	 * MESSAGE_EXCEPTION : String :<br/>
	 * "Exception GRAVE : ".<br/>
	 */
	public static final String MESSAGE_EXCEPTION = "Exception GRAVE : ";
	
	
	/**
	 * NEWLINE : String :<br/>
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	public static final String NEWLINE = System.getProperty("line.separator");
	
	
	/**
	 * UNDERSCORE : char :<br/>
	 * '_'.<br/>
	 */
	public static final char UNDERSCORE = '_';
	
	
	/**
	 * POINT : char :<br/>
	 * '.'.<br/>
	 */
	public static final char POINT = '.';
	
	
	/**
	 * SEPARATEUR_FILE : String :<br/>
	 * "\\".<br/>
	 */
	public static final String SEPARATEUR_FILE = "\\";
	
	
	/**
	 * SEP_POINTVIRGULE : String :<br/>
	 * ";".<br/>
	 */
	public static final String SEP_POINTVIRGULE = ";";
	
	
	/**
	 * SEP_MOINS : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEP_MOINS = " - ";
	
	
	/**
	 * SEP_REP : String :<br/>
	 * Séparateur Java pour les répertoires "\\".<br/>
	 */
	public static final String SEP_REP = "\\";
	
	
	/**
	 * BOM_UTF : char :<br/>
	 * BOM UTF-8 pour forcer Excel 2010 à lire en UTF-8.<br/>
	 */
	public static final char BOM_UTF_8 = '\uFEFF';
	
	
	/**
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("fr", "FR").<br/>
	 * "fr" correspond au langage et "FR" au pays.<br/>
	 */
	public static final Locale LOCALE_FR_FR = new Locale("fr", "FR");
	
	
	/**
	 * LOCALE_SYSTEM : Locale :<br/>
	 * Locale de la plateforme.<br/>
	 * Locale.getDefault().<br/>
	 */
	public static final Locale LOCALE_SYSTEM = Locale.getDefault();
	
	
	/**
	 * DF_DATE_LEXICOGRAPHIQUE : DateFormat :<br/>
	 * Format lexicographique des dates 
	 * comme "2012-01-16" pour le
	 * 16 Janvier 2012.<br/>
	 * "yyyy-MM-dd".<br/>
	 */
	public static final DateFormat DF_DATE_LEXICOGRAPHIQUE 
		= new SimpleDateFormat("yyyy-MM-dd", LOCALE_FR_FR);
	
	
	/**
	 * DF_DATETIME_LEXICOGRAPHIQUE : DateFormat :<br/>
	 * Format lexicographique des dates avec time 
	 * comme "2012-01-16_18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 * "yyyy-MM-dd_HH-mm-ss".<br/>
	 */
	public static final DateFormat DF_DATETIME_LEXICOGRAPHIQUE 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", LOCALE_FR_FR);
	
	
	/**
	 * DF_DATETIME_LEXICOGRAPHIQUEMILLI : DateFormat :<br/>
	 * Format lexicographique des dates avec time 
	 * comme "2012-01-16_18-09-55-769" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes,55 secondes et 769 millisecondes.<br/>
	 * "yyyy-MM-dd_HH-mm-ss-SSS".<br/>
	 */
	public static final DateFormat DF_DATETIME_LEXICOGRAPHIQUEMILLI 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", LOCALE_FR_FR);
	
	
	/**
	 * DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE : DateFormat :<br/>
	 * Format concentré des dates avec heures et secondes
	 * comme "2012-01-16_18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	public static final DateFormat DF_DATE_HEURE_MINUTE_SECONDE_UNDERSCORE 
		= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", LOCALE_FR_FR);
	
	
	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	public static final Charset CHARSET_UTF8 
		= Charset.forName("UTF-8");
	
	
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
	 * CHARSET_IBM850 : Charset :<br/>
	 * Charset IBM-850.<br/>
	 * Cp850, MS-DOS Latin-1.<br/>
	 */
	public static final Charset CHARSET_IBM850
		= Charset.forName("IBM-850");
	
	
	
	/**
	 * rapportDiffTxt : String :<br/>
	 * .<br/>
	 */
	private static transient String rapportDiffTxt;
	
	
	/**
	 * rapportDiffCsv : String :<br/>
	 * .<br/>
	 */
	private static transient String rapportDiffCsv;

	/**
	 * rapportExecutionControle : String :<br/>
	 * .<br/>
	 */
	private static transient String rapportExecutionControle;

	
	/**
	 * fileRapportExecutionControle : File :<br/>
	 * .<br/>
	 */
	private static transient File fileRapportExecutionControle; 

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(DifferentiateurFichiers.class);

	// *************************METHODES************************************/
	
	/**
	 * method CONSTRUCTEUR DifferentiateurFichiers() :
	 * Constructeur private pour empêcher l'instanciation.
	 */
	private DifferentiateurFichiers() {
		super();
	} // Fin de CONSTRUCTEUR DifferentiateurFichiers().____________________


	
	/**
	 * method differencier(
	 * File pFile1
	 * , Charset pCharset1
	 * , File pFile2
	 * , Charset pCharset2
	 * , boolean pEnregistrerRapport) :<br/>
	 * .<br/>
	 * <br/>
	 * - Choisit automatiquement le CHARSET_UTF8 si un pCharset == null.<br/>
	 * <br/>
	 * <ul>
	 * <li>retourne false, LOG de niveau INFO et rapport 
	 * si un pFile == null.</li><br/>
	 * <li>retourne false, LOG de niveau INFO et rapport 
	 * si un pFile est inexistant.</li><br/>
	 * <li>retourne false, LOG de niveau INFO et rapport 
	 * si un pFile est un répertoire.</li><br/>
	 * <li>retourne false, LOG de niveau INFO et rapport 
	 * si un pFile est vide.</li><br/>
	 * </ul>
	 *
	 * @param pFile1
	 * @param pCharset1
	 * @param pFile2
	 * @param pCharset2
	 * @param pEnregistrerRapport
	 * @return : boolean :  .<br/>
	 */
	public static boolean differencier(
			final File pFile1
				, final Charset pCharset1
					, final File pFile2
						, final Charset pCharset2
							, final boolean pEnregistrerRapport) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
			// Traitement des mauvais fichiers.************
			final boolean resultatTraitementMauvaisFichier1 
				= traiterMauvaisFile(
						pFile1, pEnregistrerRapport, METHODE_DIFFERENCIER);
			
			/*
			 * Sort de la méthode et retourne false si le fichier est mauvais.
			 */
			if (!resultatTraitementMauvaisFichier1) {
				return false;
			}
			
			// Traitement des mauvais fichiers.************
			final boolean resultatTraitementMauvaisFichier2 
				= traiterMauvaisFile(
						pFile2, pEnregistrerRapport, METHODE_DIFFERENCIER);
			
			/*
			 * Sort de la méthode et retourne false si le fichier est mauvais.
			 */
			if (!resultatTraitementMauvaisFichier2) {
				return false;
			}
			
			boolean resultat = true;
			
			// LECTURE LIGNE PAR LIGNE ***************
			FileInputStream fileInputStream1 = null;
			InputStreamReader inputStreamReader1 = null;
			BufferedReader bufferedReader1 = null;
			
			FileInputStream fileInputStream2 = null;
			InputStreamReader inputStreamReader2 = null;
			BufferedReader bufferedReader2 = null;
			
			int numeroLigne = 0;
			
			String ligneLue1 = null;
			String ligneLue2 = null;
			
			Charset charset1 = null;
			Charset charset2 = null;
			
			/* Choisit automatiquement le CHARSET_UTF8 si pCharset == null. */
			if (pCharset1 == null) {
				charset1 = CHARSET_UTF8;
			} else {
				charset1 = pCharset1;
			}
			
			if (pCharset2 == null) {
				charset2 = CHARSET_UTF8;
			} else {
				charset2 = pCharset2;
			}
			
			try {
				/*
				 * Instancie un flux en lecture 
				 * fileInputStream en lui passant
				 * pFile.
				 */
				fileInputStream1 = new FileInputStream(pFile1);
				fileInputStream2 = new FileInputStream(pFile2);
				
				/*
				 * Instancie un InputStreamReader 
				 * en lui passant le FileReader et le
				 * Charset.
				 */
				inputStreamReader1 
					= new InputStreamReader(fileInputStream1, charset1);
				inputStreamReader2 
				= new InputStreamReader(fileInputStream2, charset2);

				/*
				 * Instancie un tampon de 
				 * flux de caractères en lecture en lui
				 * passant le flux inputStreamReader.
				 */
				bufferedReader1 = new BufferedReader(inputStreamReader1);
				bufferedReader2 = new BufferedReader(inputStreamReader2);
				
				/* Parcours des bufferedReader. */
				while (true) {
					
					/* Incrémentation du numeroLigne. */
					numeroLigne++;
					
					/* Lecture des lignes. */
					ligneLue1 = bufferedReader1.readLine();					
					ligneLue2 = bufferedReader2.readLine();
					
					
					if (ligneLue1 == null || ligneLue2 == null) {
						break;
					}
					
					// SI EGALITE DES STRINGS. ******
					if (StringUtils.equals(ligneLue1, ligneLue2)) {
						
						/* RAPPORT Si les lignes sont égales. */
						/* Message pour le rapport textuel. */
						final StringBuilder stbEgales 
							= fournirMessageLignes(
									numeroLigne
									, "Les lignes sont EGALES : "
									, ligneLue1
									, ligneLue2);
												
						final String messageTxt = stbEgales.toString();
						
						/* Injection dans le rapport textuel. */
						rapportDiffTxt 
							= ajouterString(rapportDiffTxt, messageTxt);
						
						/* Injection dans le rapport Csv. */
						
												
					}
					
					// SI NON-EGALITE DES STRINGS. ******
					else {

						/* RAPPORT Si les lignes sont différentes. */
						/* Message pour le rapport textuel. */
						final StringBuilder stbDifferentes 
							= fournirMessageLignes(numeroLigne
									, "Les lignes sont DIFFERENTES : "
									, ligneLue1
									, ligneLue2);
						
						final String messageTxt = stbDifferentes.toString();

						/* Injection dans le rapport textuel. */
						rapportDiffTxt = ajouterString(rapportDiffTxt,
								messageTxt);

						/* Injection dans le rapport Csv. */
						
						
						/* Calcul de la différence entre les lignes. */
						resultat = differencier(ligneLue1, ligneLue2,
								pEnregistrerRapport, numeroLigne);
						
					} // Fin de NON-EGALITE DES STRINGS.____________
									
				} // Fin de Parcours des bufferedReader._________
				
			} catch (FileNotFoundException fnfe) {
				
				fnfe.printStackTrace();
			} catch (IOException ioe1) {
				
				ioe1.printStackTrace();
			}
			
			finally {
				
				if (bufferedReader1 != null) {
					
					try {
						bufferedReader1.close();
						
					} catch (IOException ioe2) {
						
						ioe2.printStackTrace();
					}
					
				} // Fin de if (bufferedReader1 != null)._____
				
				if (bufferedReader2 != null) {
					
					try {
						bufferedReader2.close();
						
					} catch (IOException ioe3) {
						
						ioe3.printStackTrace();
					}
					
				} // Fin de if (bufferedReader2 != null)._____
				
			} // Fin du finally.__________________
			
			/* RAPPORT Si les FICHIERS sont égaux. */
			if (resultat) {
				
				/* RAPPORT D'EXECUTION DU CONTROLE. */
				final String messageExecutionControle 
				= fournirNomClasseConcrete()
				+ SEP_MOINS
				+ METHODE_DIFFERENCIER 
				+ SEP_MOINS
				+ "le contrôle de comparaison entre '" 
				+ pFile1.getName() 
				+ "' lu en " 
				+ charset1.name() 
				+ " et '" 
				+ pFile2.getName() 
				+ "' lu en " 
				+ charset2.name() 
				+ " s'est bien déroulé et est positif (fichiers égaux).";
				
				rapportExecutionControle 
					= ajouterString(rapportExecutionControle
							, messageExecutionControle);
				
				/* RAPPORT DE CONTROLE. */
				final StringBuilder stbEgaux 
					= fournirMessageFichiers(
							"LES FICHIERS SONT EGAUX : '"
							, pFile1
							, charset1
							, pFile2
							, charset2);
								
				final String messageTxt = stbEgaux.toString();

				/* Injection dans le rapport textuel. */
				rapportDiffTxt = ajouterString(rapportDiffTxt, messageTxt);

			}
			
			/* RAPPORT Si les fichiers sont différents. */
			else {
				
				/* RAPPORT D'EXECUTION DU CONTROLE. */
				final String messageExecutionControle 
				= fournirNomClasseConcrete()
				+ SEP_MOINS
				+ METHODE_DIFFERENCIER 
				+ SEP_MOINS
				+ "le contrôle s'est bien déroulé et est négatif (fichiers inégaux).";
				
				rapportExecutionControle 
					= ajouterString(rapportExecutionControle
							, messageExecutionControle);
				
				/* RAPPORT DE CONTROLE. */
				final StringBuilder stbInegaux 
					= fournirMessageFichiers(
							"LES FICHIERS SONT DIFFERENTS : '"
							, pFile1
							, charset1
							, pFile2
							, charset2);
				
				final String messageTxt = stbInegaux.toString();

				/* Injection dans le rapport textuel. */
				rapportDiffTxt = ajouterString(rapportDiffTxt, messageTxt);
				
			}
						
			return resultat;
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de differencier(
	 // File pFile1
	 // , Charset pCharset1
	 // , File pFile2
	 // , Charset pCharset2
	 // , boolean pEnregistrerRapports).___________________________________
	

	/**
	 * method differencier() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pString1
	 * @param pString2
	 * @param pEnregistrerRapportDiff
	 * @param pNumeroLigne
	 * @return : boolean :  .<br/>
	 */
	public static boolean differencier(
			final String pString1
				, final String pString2
					, final Boolean pEnregistrerRapportDiff
						, final int pNumeroLigne) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
			boolean resultat = true;
			
			int longueurChaine1 = 0;
			int longueurChaine2 = 0;
						
			int longueurMax = 0;
			int position = 0;
			Character caractereChaine1 = null;
			Character caractereChaine2 = null;
			String diff = null;
						
			final StringBuilder stbDiffTxt = new StringBuilder();
			final StringBuilder stbDiffCsv = new StringBuilder();
			
			/* Détermine la longueur de la plus longue chaîne. */
			/* Alimente longueurChaine1 et longueurChaine2. */
			longueurChaine1 = pString1.length();
			longueurChaine2 = pString2.length();
			
			if (longueurChaine1 > longueurChaine2) {
				longueurMax = longueurChaine1;
			}
			else {
				longueurMax = longueurChaine2;
			}
			
			/* Parcours des chaînes caractère par caractère. */
			for(int index = 0; index < longueurMax; index++) {
				
				/* L'index est 0-based. */
				position = index + 1;
				
				/* détermination du caractère dans la chaine 1. */
				try {
					caractereChaine1 = pString1.charAt(index);
				} catch (IndexOutOfBoundsException e1) {
					caractereChaine1 = null;
				}
				
				/* Instanciation d'un CaractereDan. */
				final CaractereDan c1 
					= new CaractereDan(position, caractereChaine1);
				
				/* détermination du caractère dans la chaine 2. */
				try {
					caractereChaine2 = pString2.charAt(index);
				} catch (IndexOutOfBoundsException e1) {
					caractereChaine2 = null;
				}
				
				/* Instanciation d'un CaractereDan. */
				final CaractereDan c2 
					= new CaractereDan(position, caractereChaine2);
				
				/* Détermination d'une éventuelle différence. */
				if (caractereChaine1 == null) {
					
					if (caractereChaine2 != null) {
						diff = "DIFF";
						resultat = false;
					} else {
						diff = "equals";
					}
					
				} else {
					if (caractereChaine2 != null) {
						if (!caractereChaine1.equals(caractereChaine2)) {
							diff = "DIFF";
							resultat = false;
						}
						else {
							diff = "equals";
						}
						
					} else {
						diff = "DIFF";
						resultat = false;
					}					
				}
				
				// ETABLISSEMENT DU RAPPORT DE COMPARAISON.****
				final String comparaisonTxt 
					= String.format(LOCALE_FR_FR
								, "Ligne : %-8d", pNumeroLigne)
							+ c1.toString() 
							+ String.format(LOCALE_FR_FR
									, "DIFFERENCE : %-8s", diff)
							+ c2.toString();
				
				final String comparaisonCsv 
					= pNumeroLigne + ";" + c1.toCsv() + diff + ";" + c2.toCsv();
				
				/* Ajout dans les StringBuilders pour les rapports. */
				/* rapport textuel. ******/
				/* N'ajoute que les différences. */
				if (StringUtils.equals("DIFF", diff)) {
					stbDiffTxt.append(comparaisonTxt);
					stbDiffTxt.append(NEWLINE);
				}
				
				
				/* rapport csv. ******/				
				/* Ajout d'un caractère BOM-UTF-8 au début du rapport csv
				 * pour forcer Excel 2010 à détecter l'UTF-8. */				
				stbDiffCsv.append(BOM_UTF_8);
				
								
				/* Ajout de l'en-tête pour le rapport Csv. */
				/* N'ajoute que les différences. */
				if (StringUtils.equals("DIFF", diff)) {
					
					if (position == 1) {
						stbDiffCsv.append("Ligne numéro");
						stbDiffCsv.append(SEP_POINTVIRGULE);
						stbDiffCsv.append(c1.getEnTeteCsv());
						stbDiffCsv.append("DIFFERENCE");
						stbDiffCsv.append(SEP_POINTVIRGULE);
						stbDiffCsv.append(c1.getEnTeteCsv());
						stbDiffCsv.append(NEWLINE);
					}
					
					stbDiffCsv.append(comparaisonCsv);
					stbDiffCsv.append(NEWLINE);
					
				}
				
								
			} // Fin de la boucle sur les caractères._______________
			
			
			// INJECTION DANS LES RAPPORTS.***************
			/* Injection dans le rapport textuel. */
			rapportDiffTxt = ajouterString(rapportDiffTxt, stbDiffTxt.toString());
			
			/* Injection dans le rapport csv. */
			rapportDiffCsv = ajouterString(rapportDiffCsv, stbDiffCsv.toString());
			
			
			
			/* Ecriture des rapports dans les 
			 * fileRapportDiffTxt et fileRapportDiffCsv 
			 * en UTF_8. */
			if (pEnregistrerRapportDiff) {
				/**/
												
			}
									
			/* retourne le boolean. */
			return resultat;
						
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de differencier(
	// String pString1
	 // , String pString2
	//, Boolean pRapportFichier).__________________________________________


	
	/**
	 * method traiterMauvaisFile(
	 * File pFile
	 * , boolean pEnregistrerRapport
	 * , String pMethode) :<br/>
	 * Centralise le traitement des fichiers incorrects.<br/>
	 * Traite le cas des fichiers null, inexistants, répertoires ou vide.<br/>
	 * - retourne false si c'est le cas.<br/>
	 * - Génère un rapport en cas de mauvais fichier.<br/>
	 * - Ecrit le rapport sur disque si pEnregistrerRapport vaut true.<br/>
	 * <br/>
	 * <ul>
	 * <li>retourne false, LOG de niveau INFO et rapport 
	 * si pFile == null.</li><br/>
	 * <li>retourne false, LOG de niveau INFO et rapport 
	 * si pFile est inexistant.</li><br/>
	 * <li>retourne false, LOG de niveau INFO et rapport 
	 * si pFile est un répertoire.</li><br/>
	 * <li>retourne false, LOG de niveau INFO et rapport 
	 * si pFile est vide.</li><br/>
	 * </ul>
	 * <br/>
	 *  Retourne true si le fichier n'est pas :<br/>
	 * - null.<br/>
	 * - inexistant.<br/>
	 * - répertoire.<br/>
	 * - vide.<br/>
	 * <br/>
	 *
	 * @param pFile : File.<br/>
	 * @param pEnregistrerRapport : boolean : 
	 * true si on veut enregistrer le rapport dans un fichier sur disque.<br/>
	 * @param pMethode : String : Méthode qui appelle la présente.<br/>
	 * 
	 * @return : boolean : false si pFile est mauvais.<br/>
	 */
	private static boolean traiterMauvaisFile(
			final File pFile
				, final boolean pEnregistrerRapport
					, final String pMethode) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
			/* retourne false, LOG de niveau INFO 
			 * et rapport si pFile == null. */
			if (pFile == null) {
				
				final String message 
				= fournirNomClasseConcrete() 
				+ SEP_MOINS 
				+ pMethode 
				+ SEP_MOINS 
				+ MESSAGE_FICHIER_NULL;
				
				/* LOG de niveau INFO. */
				loggerInfo(
						fournirNomClasseConcrete()
							, pMethode
								, MESSAGE_FICHIER_NULL);
				
				/* rapport. */
				rapportExecutionControle 
					= ajouterString(rapportExecutionControle, message);
				
				
				/* Enregistrement du rapport sur disque. */
				if (pEnregistrerRapport) {
					
					/* Ajout de la ligne au fichier sur disque. */
					ajouterAFile(
							fournirFileRapportExecutionControle(), message);
										
				}
				
				/* retourne false, LOG de niveau INFO 
				 * et rapport si pFile == null. */
				return false;
				
			} // Fin de if (pFile == null)._______________
			
			/* retourne false, LOG de niveau INFO 
			 * et rapport si pFile est inexistant. */
			if (!pFile.exists()) {
				
				final String message 
				= fournirNomClasseConcrete() 
				+ SEP_MOINS 
				+ pMethode 
				+ SEP_MOINS 
				+ MESSAGE_FICHIER_INEXISTANT 
				+ pFile.getAbsolutePath();
				
				/* LOG de niveau INFO. */
				loggerInfo(
						fournirNomClasseConcrete()
							, pMethode
								, MESSAGE_FICHIER_INEXISTANT 
								+ pFile.getAbsolutePath());
				
				/* rapport. */
				rapportExecutionControle 
					= ajouterString(rapportExecutionControle, message);
				
				
				/* Enregistrement du rapport sur disque. */
				if (pEnregistrerRapport) {
					
					ajouterAFile(
							fournirFileRapportExecutionControle(), message);
					
				}
				
				/* retourne false, LOG de niveau INFO 
				 * et rapport si pFile == null. */
				return false;
				
			} // Fin de if (!pFile.exists())._______________________
			
			/* retourne false, LOG de niveau INFO 
			 * et rapport si pFile est un répertoire. */
			if (pFile.isDirectory()) {
				
				final String message 
				= fournirNomClasseConcrete() 
				+ SEP_MOINS 
				+ pMethode 
				+ SEP_MOINS 
				+ MESSAGE_FICHIER_REPERTOIRE 
				+ pFile.getAbsolutePath();
				
				/* LOG de niveau INFO. */
				loggerInfo(
						fournirNomClasseConcrete()
							, pMethode
								, MESSAGE_FICHIER_REPERTOIRE 
								+ pFile.getAbsolutePath());
				
				/* rapport. */
				rapportExecutionControle = 
						ajouterString(rapportExecutionControle, message);
				
				
				/* Enregistrement du rapport sur disque. */
				if (pEnregistrerRapport) {
					
					ajouterAFile(
							fournirFileRapportExecutionControle(), message);
					
				}
				
				/* retourne false, LOG de niveau INFO 
				 * et rapport si pFile == null. */
				return false;
				
			} // Fin de if (pFile.isDirectory()).________________
			
			/* retourne false, LOG de niveau INFO 
			 * et rapport si pFile est vide. */
			if (pFile.length() == 0) {
				
				final String message 
				= fournirNomClasseConcrete() 
				+ SEP_MOINS 
				+ pMethode 
				+ SEP_MOINS 
				+ MESSAGE_FICHIER_VIDE 
				+ pFile.getAbsolutePath();
				
				/* LOG de niveau INFO. */
				loggerInfo(
						fournirNomClasseConcrete()
							, pMethode
								, MESSAGE_FICHIER_VIDE 
								+ pFile.getAbsolutePath());
				
				/* rapport. */
				rapportExecutionControle 
					= ajouterString(rapportExecutionControle, message);
				
				
				/* Enregistrement du rapport sur disque. */
				if (pEnregistrerRapport) {
					
					ajouterAFile(
							fournirFileRapportExecutionControle(), message);
					
				}
				
				/* retourne false, LOG de niveau INFO 
				 * et rapport si pFile == null. */
				return false;
				
			} // Fin de if (pFile.length() == 0).________________
			
			return true;
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de traiterMauvaisFile(
	 // File pFile
	// , boolean pEnregistrerRapport
	// , String pMethode)._________________________________________________
	

	
	/**
	 * method fournirMessageLignes(
	 * int pNumeroLigne
	 * , String pMessage
	 * , String pLigneLue1
	 * , String pLigneLue2) :<br/>
	 * Fournit un message pour les rapports sur les 
	 * lignes égales ou différentes entre 2 fichiers.<br/>
	 * <br/>
	 * Par exemple : <br/>
	 * <code>
	 * <pre>
	 * Ligne : 1       Les lignes sont DIFFERENTES :
	 * Ligne du fichier1 : UTF-8. Tous français inscrit au rôle, naïf ou râleur, à Nîmes, carbœuf ou même Capharnaüm, aura payé son dû dès avant Noël. ligne de 148 caractères.
	 * Ligne du fichier2 : UTF-8. Tous franÃ§ais inscrit au rÃ´le, naÃ¯f ou rÃ¢leur, Ã  NÃ®mes, carbÅ“uf ou mÃªme CapharnaÃ¼m, aura payÃ© son dÃ» dÃ¨s avant NoÃ«l. ligne de 148 caractÃ¨res.
	 * 
	 * Longueur de la ligne1 : 148
	 * Longueur de la ligne2 : 162
	 * </pre>
	 * </code>
	 * <br/>
	 *
	 * @param pNumeroLigne : int : numéro des lignes 
	 * comparées entre deux fichiers.<br/>
	 * @param pMessage : String : le message à éditer 
	 * comme "Les lignes sont EGALES : " par exemple.<br/>
	 * @param pLigneLue1 : String : la ligne pNumeroLigne 
	 * lue dans le premier fichier.<br/>
	 * @param pLigneLue2 : String : la ligne pNumeroLigne 
	 * lue dans le premier fichier.<br/>
	 * 
	 * @return : StringBuilder.<br/>
	 */
	private static StringBuilder fournirMessageLignes(
			final int pNumeroLigne
				, final String pMessage
					, final String pLigneLue1
						, final String pLigneLue2) {
		
		final StringBuilder stb = new StringBuilder();
		
		stb.append(String.format(LOCALE_FR_FR,
				"Ligne : %-8d", pNumeroLigne));
		stb.append(pMessage);
		
		stb.append(NEWLINE);
		
		stb.append("Ligne du fichier1 : ");
		if (pLigneLue1 != null) {
			stb.append(StringUtils.abbreviate(pLigneLue1, 600));
			stb.append(NEWLINE);
		}
		else {
			stb.append("null");
			stb.append(NEWLINE);
		}
		
		stb.append("Ligne du fichier2 : ");
		if (pLigneLue1 != null) {
			stb.append(StringUtils.abbreviate(pLigneLue2, 600));
			stb.append(NEWLINE);
		}
		else {
			stb.append("null");
			stb.append(NEWLINE);
		}
		
		stb.append(NEWLINE);
		
		stb.append("Longueur de la ligne1 : ");
		if (pLigneLue1 != null) {
			stb.append(pLigneLue1.length());
			stb.append(NEWLINE);
		}
		else {
			stb.append(0);
			stb.append(NEWLINE);
		}
		
		stb.append("Longueur de la ligne2 : ");
		if (pLigneLue2 != null) {
			stb.append(pLigneLue2.length());
			stb.append(NEWLINE);
		}
		else {
			stb.append(0);
			stb.append(NEWLINE);
		}
		
		return stb;
		
	} // Fin de fournirMessageLignes(
	 // int pNumeroLigne
	 // , String pMessage
	 // , String pLigneLue1
	 // , String pLigneLue2).______________________________________________
	

	
	/**
	 * method fournirMessageFichiers(
	 * String pMessage
	 * , File pFile1
	 * , Charset pCharset1
	 * , File pFile2
	 * , Charset pCharset2) :<br/>
	 * Fournit un message pour les rapports sur les 
	 * fichiers égaux ou différents.<br/>
	 * <br/>
	 * Par exemple : <br/>
	 * <code>
	 * <pre>
	 * LES FICHIERS SONT DIFFERENTS : 'diacritiques_UTF8.txt' Lu en UTF-8 ET 'diacritiques_UTF8.txt' Lu en windows-1252.<br/>
	 * </pre>
	 * </code>
	 *
	 * @param pMessage : String : le message à éditer 
	 * comme "LES FICHIERS SONT DIFFERENTS : " par exemple.<br/>
	 * @param pFile1 : File.<br/>
	 * @param pCharset1 : Charset : Charset de lecture de pFile1.<br/>
	 * @param pFile2 : File.<br/>
	 * @param pCharset2 : Charset : Charset de lecture de pFile2.<br/>
	 * 
	 * 
	 * @return : StringBuilder.<br/>
	 */
	private static StringBuilder fournirMessageFichiers(
			final String pMessage
				, final File pFile1
					, final Charset pCharset1
						, final File pFile2
							, final Charset pCharset2) {
		
		final StringBuilder stb = new StringBuilder();
		
		stb.append(pMessage);
		stb.append(pFile1.getAbsolutePath());
		stb.append("' Lu en ");
		stb.append(pCharset1.name());
		stb.append(" ET '");
		stb.append(pFile2.getAbsolutePath());
		stb.append("' Lu en ");
		stb.append(pCharset2.name());
		
		return stb;
		
	} // Fin de fournirMessageFichiers(
	// String pMessage
	 // File pFile1
	 // , Charset pCharset1
	 // , File pFile2
	 // , Charset pCharset2).______________________________________________
	

	
	/**
	 * method getEnTeteCsv() :<br/>
	 * Fournit l'en-tête Csv pour rapportDiffCsv.<br/>
	 * [Ligne numéro;id;Position;Caractère;Unicode;numericValue;
	 * Type de Caractère; Valeur Entière;Point de Code Décimal;
	 * Point de Code HexaDécimal;Nom Unicode;DIFFERENCE;id;Position;
	 * Caractère;Unicode;numericValue;Type de Caractère; Valeur Entière;
	 * Point de Code Décimal;Point de Code HexaDécimal;Nom Unicode;".
	 * <br/>
	 *
	 * @return : String : En tête pour le rapport csv.<br/>
	 */
	public static String getEnTeteCsv() {
		
		final StringBuilder stb = new StringBuilder();
		final CaractereDan caractereDan = new CaractereDan();
		
		stb.append("Numéro de la Ligne");
		stb.append(SEP_POINTVIRGULE);
		stb.append(caractereDan.getEnTeteCsv());
		stb.append("DIFFERENCE");
		stb.append(SEP_POINTVIRGULE);
		stb.append(caractereDan.getEnTeteCsv());
		
		return stb.toString();
		
	} // Fin de getEnTeteCsv().____________________________________________
	
	
	
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
			+ SEP_MOINS
			+ pMethode
			+ SEP_MOINS
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
			+ SEP_MOINS
			+ pMethode
			+ SEP_MOINS
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
			+ SEP_MOINS
			+ pMethode
			+ SEP_MOINS 
			+ pException.getMessage();
			
			LOG.error(message, pException);
			
		}
		
	} // Fin de loggerError(
	 // String pClasse
	 // , String pMethode
	 // , Exception pException).___________________________________________
	

	
	/**
	 * method fournirNomClasseConcrete() :<br/>
	 * "Classe DifferentiateurFichiers".<br/>
	 * <br/>
	 *
	 * @return : String : "Classe DifferentiateurFichiers".<br/>
	 */
	private static String fournirNomClasseConcrete() {
		return CLASSE_DIFFERENTIATEURFICHIERS;
	} // Fin de fournirNomClasseConcrete().________________________________
	

	
	/**
	 * method ajouterString(
	 * String pStringOrigine
	 * , String pStringAAjouter) :<br/>
	 * Ajoute pStringAAjouter à la ligne à la suite de pStringOrigine.<br/>
	 * <br/>
	 * - retourne pStringOrigine si pStringAAjouter == null.<br/>
	 * <br/>
	 *
	 * @param pStringOrigine : String : String à 
	 * laquelle on veut ajouter à la ligne.<br/>
	 * @param pStringAAjouter : String : String à ajouter.<br/>
	 * 
	 * @return : String : Résultat de la concaténation.<br/>
	 */
	private static String ajouterString(
			final String pStringOrigine
				, final String pStringAAjouter) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
			/* retourne pStringOrigine si pStringAAjouter == null. */
			if (pStringAAjouter == null) {
				return pStringOrigine;
			}
			
			final StringBuilder stb = new StringBuilder();
			
			if (!StringUtils.isBlank(pStringOrigine)) {
				stb.append(pStringOrigine);
				stb.append(NEWLINE);
			}
			
			stb.append(pStringAAjouter);
			
			return stb.toString();
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de ajouterString(
	 // String pStringOrigine
	 // , String pStringAAjouter)._________________________________________
	

	
	/**
	 * method ajouterAFile(
	 * File pFile
	 * , String pString) :<br/>
	 * Ajoute pString à la fin du fichier pFile.<br/>
	 * <br/>
	 *
	 * @param pFile : File.<br/>
	 * @param pString : String.<br/>
	 * 
	 * 
	 * @return : boolean : true si l'ajout a été effectué.<br/>
	 */
	private static boolean ajouterAFile(
			final File pFile
				, final String pString) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
			// Traitement des mauvais fichiers.************
			final boolean resultatTraitementMauvaisFichier 
				= traiterMauvaisFile(
						pFile, true, METHODE_AJOUTER_A_FILE);
			
			/*
			 * Sort de la méthode et retourne false si le fichier est mauvais.
			 */
			if (!resultatTraitementMauvaisFichier) {
				return false;
			}
			
			// ECRITURE SUR DISQUE ***************
			FileOutputStream fileOutputStreamUtf8 = null;
			OutputStreamWriter outputStreamWriterUtf8 = null;
			BufferedWriter bufferedWriterUtf8 = null;
			
			
			try {
				
				/* Ouverture d'un FileOutputStream sur le fichier 
				 * en utilisant le boolean avec true 
				 * pour ajout de la ligne à la fin si pFile existe. */
				fileOutputStreamUtf8 = new FileOutputStream(pFile, true);
				
				/*
				 * Ouverture d'un OutputStreamWriter sur le FileOutputStream en 
				 * passant le Charset.
				 */
				outputStreamWriterUtf8 
					= new OutputStreamWriter(
							fileOutputStreamUtf8, CHARSET_UTF8);
				
				/*
				 * Ouverture d'un tampon d'écriture BufferedWriter sur le
				 * OutputStreamWriter.
				 */
				bufferedWriterUtf8 
					= new BufferedWriter(outputStreamWriterUtf8);
				
				// ECRITURE DE LA LIGNE A LA FIN DE pFile.
				bufferedWriterUtf8.write(pString);
				bufferedWriterUtf8.write(NEWLINE);
				bufferedWriterUtf8.flush();
				
				return true;
				
			} catch (FileNotFoundException fnfe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						fournirNomClasseConcrete()
							, MESSAGE_EXCEPTION
								, fnfe);
				
				return false;
				
			} catch (IOException ioe1) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						fournirNomClasseConcrete()
							, MESSAGE_EXCEPTION
								, ioe1);
				
				return false;
			}
			
			finally {
				
				if (bufferedWriterUtf8 != null) {
					
					try {
						
						bufferedWriterUtf8.close();
						
					} catch (IOException ioe2) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								fournirNomClasseConcrete()
									, MESSAGE_EXCEPTION
										, ioe2);	
					}
					
				} // Fin de if (bufferedWriterUtf8 != null).___
				
			} // Fin du finally.___________________________
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de ajouterAFile(
	 // File pFile
	 // , String pString)._________________________________________________
	
	
	
	/**
	 * method fournirFileRapportExecutionControle() :<br/>
	 * Fournit un File pour le stockage sur 
	 * disque de rapportExecutionControle.<br/>
	 * <br/>
	 *
	 * @return : File : File pour le stockage sur 
	 * disque de rapportExecutionControle.<br/>
	 */
	private static File fournirFileRapportExecutionControle() {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
			return fournirFile(
					fournirCheminFichiers()
					, new Date()
					, "RAPPORT-EXECUTION-DIFFERENTIATEUR-FICHIERS"
					, "UTF8"
					, "txt");
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de fournirFileRapportExecutionControle()._____________________
	
	
	
	/**
	 * method fournirCheminFichiers() :<br/>
	 * Propose un chemin (arborescence de répertoires) pour stocker 
	 * les fichiers de rapport en utilisant :<br/>
	 * 1 - un chemin des rapports fixé dans 
	 * configurationapplication_fr_FR.properties si il existe.<br/>
	 * 2 - un chemin en dur stocké dans la présente classe 
	 * et fourni par fournirCheminRapportsEnDur().<br/>
	 * <br/>
	 * retourne le chemin des fichiers indiqué 
	 * dans configuration_fr_FR.properties si il existe
	 * , si la clef définie dans fournirCleCheminRapports() 
	 * existe et si cette clef est renseignée,<br/>
	 * - sinon retourne la valeur en dur écrite dans 
	 * fournirCheminRapportsEnDur().<br/>
	 * <br/>
	 *
	 * @return : String : Le chemin des rapports.<br/>
	 */
	private static String fournirCheminFichiers() {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
			return fournirCheminFichiers(null);
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de fournirCheminFichiers().___________________________________
	
	
	
	/**
	 * method fournirCheminFichiers(
	 * String pCheminFichiers) :<br/>
	 * Propose un chemin (arborescence de répertoires) pour stocker 
	 * les fichiers de rapport en utilisant :<br/>
	 * 1 - pCheminFichiers si il n'est pas blank.<br/>
	 * 2 - un chemin des rapports fixé dans 
	 * configurationapplication_fr_FR.properties si il existe.<br/>
	 * 3 - un chemin en dur stocké dans la présente classe 
	 * et fourni par fournirCheminRapportsEnDur().<br/>
	 * <br/>
	 * - retourne pCheminFichiers si pCheminFichiers n'est pas blank,<br/>
	 * - sinon retourne le chemin des fichiers indiqué 
	 * dans configuration_fr_FR.properties si il existe
	 * , si la clef définie dans fournirCleCheminRapports() 
	 * existe et si cette clef est renseignée,<br/>
	 * - sinon retourne la valeur en dur écrite dans 
	 * fournirCheminRapportsEnDur().<br/>
	 * <br/>
	 *
	 * @param pCheminFichiers : String : 
	 * chemin des rapports proposé par le développeur.<br/>
	 * 
	 * @return : String : Le chemin des rapports.<br/>
	 */
	private static String fournirCheminFichiers(
			final String pCheminFichiers) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
			/* retourne pCheminFichiers si pCheminFichiers n'est pas blank. */
			if (!StringUtils.isBlank(pCheminFichiers)) {
				return pCheminFichiers;
			}
			
			/* sinon, retourne le chemin des fichiers indiqué 
			 * dans configuration_fr_FR.properties si il existe
			 * , si la clef définie dans fournirCleCheminRapports() existe 
			 * et si cette clef est renseignée. */
			if (!StringUtils.isBlank(fournirCheminRapportsDansProperties())) {
				return fournirCheminRapportsDansProperties();
			}
			
			/* sinon, retourne la valeur en dur écrite 
			 * dans fournirCheminRapportsEnDur.*/
			return fournirCheminRapportsEnDur() ;
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de fournirCheminFichiers(
	 // String pCheminFichiers).___________________________________________
	
	
	
	/**
	 * method fournirCleCheminRapports() :<br/>
	 * Fournit la clé dans configurationapplication_fr_FR.properties 
	 * associée au chemin des rapports.<br/>
	 * <br/>
	 * "AbstractControle.fournirCheminFichiers.cheminrapports".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "AbstractControle.fournirCheminFichiers.cheminrapports".<br/>
	 */
	private static String fournirCleCheminRapports() {					
		return "AbstractControle.fournirCheminFichiers.cheminrapports";			
	} // Fin de fournirCleCheminRapports().________________________________
	
	
	
	/**
	 * method fournirValeurCheminRapports() :<br/>
	 * retourne la valeur du chemin des rapports associée 
	 * à la clé fournie par fournirCleCheminRapports() 
	 * contenue dans ./bin/configurationapplication_fr_FR.properties.<br/>
	 * retourne null ou "  " si le properties a été oublié
	 * , si la clé est absente dans le properties, 
	 * ou si la valeur associée à la clef est inexistante.<br/>
	 * <br/>
	 * - retourne null si ./bin/configurationapplication_fr_FR.properties 
	 * est manquant.<br/>
	 * - retourne null si ./bin/configurationapplication_fr_FR.properties 
	 * ne contient pas la clef fournie par fournirCleCheminRapports().<br/>
	 * - retourne " " si ./bin/configurationapplication_fr_FR.properties 
	 * contient la clef fournie par fournirCleCheminRapports() 
	 * mais qu'il n'y a pas de valeur associée à cette clé 
	 * dans le properties.<br/>
	 * <br/>
	 *
	 * @return : String :   le chemin des rapports dans 
	 * ./bin/configurationapplication_fr_FR.properties.<br/>
	 */
	private static String fournirCheminRapportsDansProperties() {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
			String chemin = null;
			
			try {
				
				/* Charge le ResourceBundle encapsulant 
				 * configurationapplication_fr_FR.properties*/
				final ResourceBundle bundle 
					= ResourceBundle.getBundle(
							"configurationapplication", LOCALE_FR_FR);
				
				chemin = bundle.getString(fournirCleCheminRapports());
				
			} catch (Exception e) {
				
				final String message 
				= "./bin/configurationapplication_fr_FR.properties "
						+ "est manquant ou la clé n'existe pas - Exception : ";
				
				/* LOG de niveau INFO. */
				loggerInfo(
						fournirNomClasseConcrete()
						, METHODE_FOURNIRCHEMINRAPPORTSDANSPROPERTIES
						, message
						, e.getMessage());
				
				/* retourne null si 
				 * ./bin/configurationapplication_fr_FR.properties 
				 * est manquant. */
				return null;
			}
			
			return chemin;
			
		} // Fin du bloc static synchronized.________________________
					
	} // Fin de fournirCheminRapportsDansProperties()._____________________


	
	/**
	 * method fournirCheminRapportsEnDur() :<br/>
	 * Fournit un chemin (arborescence) en dur au cas où :<br/>
	 * 1 - le developpeur ne propose pas de chemin en paramètre  
	 * dans fournirCheminFichiers(String pCheminFichiers),<br/>
	 * 2 - Il n'existe pas de ./bin/configurationapplication_fr_FR.properties 
	 * (ou pas la clef dans le properties fournie par 
	 * fournirCleCheminRapports(), 
	 * ou pas de valeur associée à cette clef).<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * ".\\data\\temp\\rapports\\rapportscontroles".<br/>
	 */
	private static String fournirCheminRapportsEnDur() {		
		return ".\\data\\temp\\rapports\\rapportscontroles";			
	} // Fin de fournirCheminRapportsEnDur().______________________________
	
	
	
	/**
	 * method fournirFile(
	 * String pChemin
	 * , Date pDate
	 * , String pNomFichier
	 * , String pEncodage
	 * , String pExtension) :<br/>
	 * Fabrique éventuellement l'arborescence pChemin 
	 * (".\\data\\temp\\rapports" par exemple)<br/>
	 * , fabrique le nom du fichier sous la forme 
	 * [date_nom_encodage.extension] 
	 * comme "1961-02-25_14-27-07_RAPPORT_UTF8.txt" par exemple<br/>
	 * , fabrique et retourne le fichier 
	 * (.\data2\temp\rapports\1961-02-25_14-27-07_RAPPORT_UTF8.txt 
	 * par exemple).<br/>
	 * <br/>
	 * - crée un répertoire (ou toute l'arborescence) 
	 * pour le fichier si il n'existe pas.<br/>
	 * - Prend automatiquement la date système si pDate est null.<br/>
	 * <br/>
	 * Par exemple : <br/>
	 * <code>
	 * final String chemin1 = ".\\data2\\temp\\rapports";<br/>
	 * final Date date1 = GestionnaireDates.fournirDateAvecString(
	 * "25/02/1961-14:27:07.251", dfDatetimemilliFrancaiseLexico);<br/>
	 * // Crée le fichier 
	 * .\data2\temp\rapports\1961-02-25_14-27-07_RAPPORT_UTF8.txt<br/>
	 * final File resultat = controle.fournirFile(
	 * chemin1, date1, "RAPPORT", "UTF8", "txt");<br/>
	 * </code>
	 * <br/>
	 * - retourne null si pChemin est blank.<br/>
	 * - retourne null si pNomFichier est blank.<br/>
	 * - retourne null (et LOG ERROR) si il se produit une Exception 
	 * lors de la création du fichier.<br/>
	 * <br/>
	 * 
	 * @param pChemin : String : chemin (arborescence de répertoires) 
	 * pour le fichier.<br/>
	 * @param pDate : Date : Date pour préfixer le nom du fichier. 
	 * La Date sera formattée sous la forme "yyyy-MM-dd_HH-mm-ss" 
	 * de dfDatetimemilliFrancaiseLexico comme 2012-01-16_18-09-55 <br/>
	 * @param pNomFichier : String : nom de base du fichier.<br/>
	 * @param pEncodage : String : encodage pour suffixer 
	 * le nom du fichier.<br/>
	 * @param pExtension : String : extension du fichier.<br/>
	 * 
	 * @return : File : Le File créé.<br/>
	 */
	private static  File fournirFile(
			final String pChemin
				, final Date pDate
					, final String pNomFichier
						, final String pEncodage
							, final String pExtension) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
			/* retourne null si pChemin est blank. */
			if (StringUtils.isBlank(pChemin)) {
				return null;
			}
			
			/* retourne null si pNomFichier est blank. */
			if (StringUtils.isBlank(pNomFichier)) {
				return null;
			}
						
			/* crée un répertoire pour le fichier si il n'existe pas. */
			creerArborescence(pChemin);
			
			/* crée le chemin complet du fichier en nommant le fichier. */
			final String cheminFichier 
				= pChemin 
				+ SEPARATEUR_FILE 
				+ fournirNomFichier(pDate, pNomFichier, pEncodage, pExtension);
			
			final File resultatFile = new File(cheminFichier);
			
			/* Création du fichier si il n'existe pas. */
			if (!resultatFile.exists()) {
				try {
					
					resultatFile.createNewFile();
					
				} catch (IOException ioe) {
					
					/* LOG de niveau ERROR. */
					loggerError(
							fournirNomClasseConcrete()
								, METHODE_FOURNIRFILE
									, ioe);
					
					/* retourne null (et LOG ERROR) si il se produit 
					 * une Exception lors de la création du fichier. */
					return null;
					
				}
			}
			
			return resultatFile;
							
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de fournirFile()._____________________________________________


	
	/**
	 * method fournirNomFichier(
	 * Date pDate
	 * , String pNom
	 * , String pEncodage
	 * , String pExtension) :<br/>
	 * Fournit un nom pour un fichier 
	 * de la forme [date_nom_encodage.extension].<br/>
	 * Par exemple : <br/>
	 * <code>final Date date1 = controle.fournirDateAvecString(
	 * "25/02/1961-14:27:07.251", DF_DATETIME_LEXICOGRAPHIQUEMILLI);</code> 
	 * instancie une date calée le 25/02/1961 à 14h27'07" 
	 * et 251 millisecondes.<br/>
	 * <code>GestionnaireFichiers.fournirNomFichier(
	 * date1, "RAPPORT", "UTF8", "txt");</code> 
	 * retourne "1961-02-25_14-27-07-789_RAPPORT_UTF8.txt".<br/>
	 * <br/>
	 * - passe automatiquement la date à la date système si pDate == null.<br/>
	 * - retourne null si pNom est blank.<br/>
	 * <br/>
	 *
	 * @param pDate : Date : Date pour préfixer le chemin. 
	 * La Date sera formattée sous la forme "yyyy-MM-dd_HH-mm-ss-SSS" 
	 * de dfDatetimemilliFrancaiseLexico comme 2012-01-16_18-09-55-789 <br/>
	 * @param pNom : String : nom de base du fichier.<br/>
	 * @param pEncodage : String : encodage pour suffixer 
	 * le nom du fichier.<br/>
	 * @param pExtension : String : extension du fichier.<br/>
	 * 
	 * @return : String : Nom pour le fichier.<br/>
	 */
	private static String fournirNomFichier(
			final Date pDate
				, final String pNom
					, final String pEncodage
						, final String pExtension) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
			Date date = null;
			
			/* passe automatiquement la date 
			 * à la date système si pDate == null. */
			if (pDate == null) {
				date = new Date();
			}
			else {
				date = pDate;
			}
			
			/* retourne null si pNom est blank. */
			if(StringUtils.isBlank(pNom)) {
				return null;
			}
			
			/* Récupère la date  
			 * formattée sous la forme 2012-01-16_18-09-55-759. */
			final String dateFormatteeString 
				= fournirDateFormattee(date, DF_DATETIME_LEXICOGRAPHIQUEMILLI);
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(dateFormatteeString);
			stb.append(UNDERSCORE);
			stb.append(pNom);
			
			if (!StringUtils.isBlank(pEncodage)) {
				stb.append(UNDERSCORE);
				stb.append(pEncodage);
			}
			
			if (!StringUtils.isBlank(pExtension)) {
				stb.append(POINT);
				stb.append(pExtension);
			}
			
			return stb.toString();
						
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de fournirNomFichier(...).____________________________________
	
	
	
	/**
	 * method fournirDateFormattee(
	 * Date pDate
	 * , DateFormat pDateFormat) :<br/>
	 * Retourne une String représentant la java.util.Date pDate 
	 * au format pDateFormat.<br/>
	 * Par exemple :<br/>
	 * - Retourne la String "25/02/1961" 
	 * avec une Date au 25/02/1961 et un DateFormat 
	 * DF_DATE_FRANCAISE (
	 * new SimpleDateFormat("dd/MM/yyyy", LOCALE_FR_FR)).<br/>
	 * <br/>
	 * - retourne null si pDate == null.<br/>
	 * - retourne null si pDateFormat == null.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * @param pDateFormat : DateFormat.<br/>
	 * 
	 * @return : String : String pour affichage 
	 * formatté de pDate selon pDateFormat.<br/>
	 */
	private static String fournirDateFormattee(
			final Date pDate
				, final DateFormat pDateFormat) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
			/* retourne null si pDate == null. */
			if(pDate == null) {
				return null;
			}
			
			/* retourne null si pDateFormat == null. */
			if(pDateFormat == null) {
				return null;
			}
			
			pDateFormat.setLenient(false);
			
			return pDateFormat.format(pDate);
			
		} // Fin du bloc static synchronized.________________________
								
	} // Fin de fournirDateFormattee(
	 // Date pDate
	 // DateFormat pDateFormat).___________________________________________
	


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
	private static boolean creerArborescence(
			final String pChemin) {
		
		/* bloc static synchronized. */
		synchronized (DifferentiateurFichiers.class) {
			
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
				stb.append(SEP_REP);
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
	 * SERVICE ACCESSOIRE.<br/>
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
		synchronized (DifferentiateurFichiers.class) {
			
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
						fournirNomClasseConcrete()
							, METHODE_DETRUIRE_ARBORESCENCE
								, e.getMessage());
				
				return false;
				
			}
			
		} // Fin du bloc static synchronized.________________________
						
	} // Fin de detruireArborescence(
	 // String pChemin).___________________________________________________
	
	

	/**
	 * method viderRepertoireADetruire(
	 * File pRep) :<br/>
	 * SERVICE ACCESSOIRE.<br/>
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
		synchronized (DifferentiateurFichiers.class) {
			
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
			
			/* Récupération des File dans pRep. */
			final File[] filesContenus = pRep.listFiles();
			
			if (filesContenus == null) {
				return true;
			}
			
			/* Sort Si pRep est vide. */
			if (filesContenus.length == 0) {
				return true;
			}
			
			/* Si pRep non vide. */
			/* ForEach (boucle) sur les File de pRep. ******/
			for(final File file : filesContenus) {
				
				/* Appel récursif si file est un répertoire. */
				if (file.isDirectory()) {
					
					/* APPEL RECURSIF. */
					viderRepertoireADetruire(file);
					
					
				} // Fin de if (!file.isDirectory()).___________
				
				/* Destruction du file dans tous les cas. */					
				try {
					
					file.delete();
					
				} catch (Exception e) {
					
					/* LOG de niveau INFO. */
					loggerInfo(
							fournirNomClasseConcrete()
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
	 * method getRapportDiffTxt() :<br/>
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return rapportDiffTxt : String.<br/>
	 */
	public static String getRapportDiffTxt() {
		return rapportDiffTxt;
	}



	/**
	 * method getRapportDiffCsv() :<br/>
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return rapportDiffCsv : String.<br/>
	 */
	public static String getRapportDiffCsv() {
		return rapportDiffCsv;
	}



	/**
	 * method getRapportExecutionControle() :<br/>
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return rapportExecutionControle : String.<br/>
	 */
	public static String getRapportExecutionControle() {
		return rapportExecutionControle;
	}



	/**
	 * method getFileRapportExecutionControle() :<br/>
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return fileRapportExecutionControle : File.<br/>
	 */
	public static File getFileRapportExecutionControle() {
		return fileRapportExecutionControle;
	}
	

	

} // FIN DE LA CLASSE DifferentiateurFichiers.-------------------------------
