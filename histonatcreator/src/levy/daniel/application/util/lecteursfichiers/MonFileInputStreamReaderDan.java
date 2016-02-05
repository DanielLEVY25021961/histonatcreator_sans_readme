package levy.daniel.application.util.lecteursfichiers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import levy.daniel.application.IConstantesMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class MonFileInputStreamReaderDan :<br/>
 * Classe utilitaire contenant 2 méthodes statiques 
 * chargées de lire un fichier et de l'encapsuler dans une String.<br/>
 * Ces deux méthodes utilisent un FileInputStreamReader.<br/>
 * <br/>
 * - lireFichier(File) lit n'importe quel type de fichier 
 * même si il ne s'agit pas d'un fichier de caractères.<br/>
 * - lireFichierDeCaracteres(File) ne lit que les fichiers de caractères. 
 * Elle retourne null sinon.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * synchronized, bloc static synchronized, <br/>
 * FileReader, BufferedReader, bufferedReader.read(), <br/>
 * Cast entier en Character, LOG, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 3 févr. 2016
 *
 */
public final class MonFileInputStreamReaderDan {

	// ************************ATTRIBUTS************************************/
	
	
	/**
	 * CLASSE_MONFILEINPUTSTREAMREADERDAN : String :<br/>
	 * "Classe MonFileInputStreamReaderDan".<br/>
	 */
	public static final String CLASSE_MONFILEINPUTSTREAMREADERDAN 
		= "Classe MonFileInputStreamReaderDan";
	
	/**
	 * METHODE_LIREFICHIER : String :<br/>
	 * "Méthode lireFichier(File pFile).<br/>
	 */
	public static final String METHODE_LIREFICHIER 
		= "Méthode lireFichier(File pFile)";
		
	/**
	 * METHODE_LIREFICHIERDECARACTERES : String :<br/>
	 * "Méthode lireFichierDeCaracteres(File pFile)".<br/>
	 */
	public static final String METHODE_LIREFICHIERDECARACTERES 
		= "Méthode lireFichierDeCaracteres(File pFile)";
	
	/**
	 * MESSAGE_FICHIER_NULL : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est null.<br/>
	 * "Le fichier passé en paramètre est null".<br/>
	 */
	public static final String MESSAGE_FICHIER_NULL 
		= "Le fichier passé en paramètre est null";
	
	/**
	 * MESSAGE_FICHIER_INEXISTANT : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est inexistant.<br/>
	 * "Le fichier passé en paramètre est inexistant : "
	 */
	public static final String MESSAGE_FICHIER_INEXISTANT 
		= "Le fichier passé en paramètre est inexistant : ";
	
	/**
	 * MESSAGE_FICHIER_REPERTOIRE : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est un répertoire.<br/>
	 * "Le fichier passé en paramètre est un répertoire : ".<br/>
	 */
	public static final String MESSAGE_FICHIER_REPERTOIRE 
		= "Le fichier passé en paramètre est un répertoire : ";

	
	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 */
	public static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");


	/**
	 * rapportLecture : String :<br/>
	 * rapport de lecture du fichier 
	 * (alimenté si le fichier n'est pas textuel).<br/>
	 */
	private static String rapportLecture;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(MonFileInputStreamReaderDan.class);

	// *************************METHODES************************************/
	
	
	/**
	 * method CONSTRUCTEUR MonFileInputStreamReaderDan() :
	 * Constructeur private pour empêcher l'instanciation.
	 */
	private MonFileInputStreamReaderDan() {
		super();
	} // Fin de CONSTRUCTEUR MonFileInputStreamReaderDan().________________
	

	
	/**
	 * method lireFichier(
	 * File pFile) :<br/>
	 * Lit un fichier pFile et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage nommé 'UTF-8'.<br/>
	 * Lit chaque caractère quoi qu'il arrive 
	 * (même si le fichier n'est pas un fichier texte).<br/>
	 * <br/>
	 * - retourne MESSAGE_FICHIER_NULL si le pFile est null.<br/>
	 * - retourne MESSAGE_FICHIER_INEXISTANT si le pFile est inexistant.<br/>
	 * - retourne MESSAGE_FICHIER_REPERTOIRE si le pFile est un répertoire.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier à lire.<br/>
	 * 
	 * @return : String : Chaine de caractères avec le contenu du fichier.<br/>
	 */
	public static String lireFichier(
			final File pFile) {
		return lireFichier(pFile, "UTF-8");
	} // Fin de lireFichier(
	 // File pFile)._______________________________________________________
	
	
	
	/**
	 * method lireFichier(
	 * File pFile
	 * , String pCharsetName) :<br/>
	 * Lit un fichier pFile et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage nommé pCharsetName.<br/>
	 * Lit chaque caractère quoi qu'il arrive 
	 * (même si le fichier n'est pas un fichier texte).<br/>
	 * <br/>
	 * - Choisit automatiquement le CHARSET_UTF8 si pCharset == null.<br/>
	 * <br/>
	 * - retourne MESSAGE_FICHIER_NULL si le pFile est null.<br/>
	 * - retourne MESSAGE_FICHIER_INEXISTANT si le pFile est inexistant.<br/>
	 * - retourne MESSAGE_FICHIER_REPERTOIRE si le pFile est un répertoire.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier à lire.<br/>
	 * @param pCharsetName : String : le nom du Charset utilisé 
	 * par l'InputStreamReader.<br/>
	 *  
	 * @return : String : Chaine de caractères avec le contenu du fichier.<br/>
	 */
	public static String lireFichier(
			final File pFile, final String pCharsetName) {
		
		/* block static synchronized. */
		synchronized (MonFileInputStreamReaderDan.class) {
			
			/* retourne MESSAGE_FICHIER_NULL 
			 * si le pFile est null. */
			if (pFile == null) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_MONFILEINPUTSTREAMREADERDAN
							, METHODE_LIREFICHIER
								, MESSAGE_FICHIER_NULL);
				
				/* retour de MESSAGE_FICHIER_NULL. */
				return MESSAGE_FICHIER_NULL;
			}
			
			/* retourne MESSAGE_FICHIER_INEXISTANT 
			 * si le pFile est inexistant. */
			if (!pFile.exists()) {
								
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_MONFILEINPUTSTREAMREADERDAN
							, METHODE_LIREFICHIER
								, MESSAGE_FICHIER_INEXISTANT
									, pFile.getAbsolutePath());
				
				/* retour de MESSAGE_FICHIER_INEXISTANT. */
				return MESSAGE_FICHIER_INEXISTANT;
			}
			
			
			/* retourne MESSAGE_FICHIER_REPERTOIRE 
			 * si le pFile est un répertoire. */
			if (pFile.isDirectory()) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_MONFILEINPUTSTREAMREADERDAN
							, METHODE_LIREFICHIER
								, MESSAGE_FICHIER_REPERTOIRE
									, pFile.getAbsolutePath());
				
				/* retour de MESSAGE_FICHIER_REPERTOIRE. */
				return MESSAGE_FICHIER_REPERTOIRE;
			}
			
			// LECTURE ***************
			FileInputStream fileInputStream = null;
			InputStreamReader inputStreamReader = null;
			BufferedReader bufferedReader = null;
			
			int characterEntier = 0;
			Character character = null;
			final StringBuilder stb = new StringBuilder();
			
			Charset charset = null;
			
			/* Choisit automatiquement le CHARSET_UTF8 si pCharset == null. */
			if(pCharsetName == null) {
				charset = CHARSET_UTF8;
			}
			else {
				charset = Charset.forName(pCharsetName);
			}
			
			try {
				
				/* Instancie un flux en lecture fileInputStream 
				 * en lui passant pFile. */
				fileInputStream = new FileInputStream(pFile);
				
				/* Instancie un InputStreamReader 
				 * en lui passant le FileReader et le Charset. */
				inputStreamReader 
					= new InputStreamReader(fileInputStream, charset);
								
				/* Instancie un tampon de flux de caractères en lecture 
				 * en lui passant le flux FileReader. */
				bufferedReader 
					= new BufferedReader(inputStreamReader);
				
				/* Lecture dans le tampon de flux de caractères. */
				while((characterEntier = bufferedReader.read()) != -1) {
					
					try {
						
						/* Conversion de l'entier en caractère. */
						character = (char) characterEntier;
						
						/* Ajout du caractère au StringBuilder. */
						stb.append(character);
						
					} catch (Exception exceptionConversion) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_MONFILEINPUTSTREAMREADERDAN
									, METHODE_LIREFICHIER
										, exceptionConversion);
												
						return exceptionConversion.getMessage();
					}
					
				} // Fin de lecture dans le tampon.______________
				
				/* Retour de la chaine de caractères. ***********/
				return stb.toString();
				
			} catch (FileNotFoundException fnfe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_MONFILEINPUTSTREAMREADERDAN
							, METHODE_LIREFICHIER
								, fnfe);
				
				/* retourne le message de l'exception. */
				return fnfe.getMessage();
				
			} catch (UnsupportedEncodingException unsEncodingExc) {
			
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_MONFILEINPUTSTREAMREADERDAN
							, METHODE_LIREFICHIER
								, unsEncodingExc);
				
				/* retourne le message de l'exception. */
				return unsEncodingExc.getMessage();
						
			} catch (IOException ioe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_MONFILEINPUTSTREAMREADERDAN
							, METHODE_LIREFICHIER
								, ioe);
				
				return ioe.getMessage();
			}
			
			finally {
				
				/* fermeture du flux BufferedReader. */
				if (bufferedReader != null) {
					
					try {
						
						bufferedReader.close();
						
					} catch (IOException ioe2) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_MONFILEINPUTSTREAMREADERDAN
									, METHODE_LIREFICHIER
										, ioe2);
						
					}
					
				} // Fin de if (bufferedReader != null).____
				
				/* fermeture du flux inputStreamReader. */
				if (inputStreamReader != null) {
					
					try {
						
						inputStreamReader.close();
						
					} catch (IOException ioe4) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_MONFILEINPUTSTREAMREADERDAN
									, METHODE_LIREFICHIER
										, ioe4);
					}
					
				} // Fin de if (inputStreamReader != null).______
				
				/* fermeture du flux fileInputStream. */
				if (fileInputStream != null) {
					
					try {
						
						fileInputStream.close();
						
					} catch (IOException ioe3) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_MONFILEINPUTSTREAMREADERDAN
									, METHODE_LIREFICHIER
										, ioe3);
						
					}
					
				} // Fin de if (fileInputStream != null).________
				
			} // Fin du finally._____________________________
			
			
		} // Fin du bloc static synchronized.________________________		
				
	} // Fin de lireFichier(
	 // File pFile
	// String pCharsetName)._______________________________________________
	

	
	/**
	 * method lireFichierDeCaracteres(
	 * File pFile) :<br/>
	 * Lit un fichier pFile et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage nommé "UTF-8".<br/>
	 * Lit chaque caractère et tente de détecter si il 
	 * s'agit d'un caractère humainement utilisable 
	 * (que l'on peut taper au clavier).<br/>
	 * <br/>
	 * - retourne null si un caractère non humain est détecté.<br/>
	 * <br/>
	 * - retourne MESSAGE_FICHIER_NULL si le pFile est null.<br/>
	 * - retourne MESSAGE_FICHIER_INEXISTANT si le pFile est inexistant.<br/>
	 * - retourne MESSAGE_FICHIER_REPERTOIRE si le pFile est un répertoire.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier à lire.<br/>
	 * 
	 * @return : String : La chaine de caractères avec le contenu du fichier 
	 * ou null si un caractère non humain est détecté.<br/>
	 */
	public static String lireFichierDeCaracteres(
			final File pFile) {
		return lireFichierDeCaracteres(pFile, "UTF-8");
	} // Fin de lireFichierDeCaracteres(
	 // File pFile)._______________________________________________________
	
	
	
	/**
	 * method lireFichierDeCaracteres(
	 * File pFile
	 * , String pCharsetName) :<br/>
	 * Lit un fichier pFile et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage nommé pCharsetName.<br/>
	 * Lit chaque caractère et tente de détecter si il 
	 * s'agit d'un caractère humainement utilisable 
	 * (que l'on peut taper au clavier).<br/>
	 * <br/>
	 * - retourne null si un caractère non humain est détecté.<br/>
	 * <br/>
	 * - Choisit automatiquement le CHARSET_UTF8 si pCharset == null.<br/>
	 * <br/>
	 * - retourne MESSAGE_FICHIER_NULL si le pFile est null.<br/>
	 * - retourne MESSAGE_FICHIER_INEXISTANT si le pFile est inexistant.<br/>
	 * - retourne MESSAGE_FICHIER_REPERTOIRE si le pFile est un répertoire.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier à lire.<br/>
	 * @param pCharsetName : String : le nom du Charset utilisé 
	 * par l'InputStreamReader.<br/>
	 *  
	 * @return : String : La chaine de caractères avec le contenu du fichier 
	 * ou null si un caractère non humain est détecté.<br/>
	 */
	public static String lireFichierDeCaracteres(
			final File pFile, final String pCharsetName) {
		
		/* block static synchronized. */
		synchronized (MonFileInputStreamReaderDan.class) {
			
			/* Réinitialise le rapport au cas où. */
			rapportLecture = null;
			
			/* retourne MESSAGE_FICHIER_NULL 
			 * si le pFile est null. */
			if (pFile == null) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_MONFILEINPUTSTREAMREADERDAN
							, METHODE_LIREFICHIERDECARACTERES
								, MESSAGE_FICHIER_NULL);
				
				/* retour de MESSAGE_FICHIER_NULL. */
				return MESSAGE_FICHIER_NULL;
			}
			
			/* retourne MESSAGE_FICHIER_INEXISTANT 
			 * si le pFile est inexistant. */
			if (!pFile.exists()) {
								
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_MONFILEINPUTSTREAMREADERDAN
							, METHODE_LIREFICHIERDECARACTERES
								, MESSAGE_FICHIER_INEXISTANT
									, pFile.getAbsolutePath());
				
				/* retour de MESSAGE_FICHIER_INEXISTANT. */
				return MESSAGE_FICHIER_INEXISTANT;
			}
			
			
			/* retourne MESSAGE_FICHIER_REPERTOIRE 
			 * si le pFile est un répertoire. */
			if (pFile.isDirectory()) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_MONFILEINPUTSTREAMREADERDAN
							, METHODE_LIREFICHIERDECARACTERES
								, MESSAGE_FICHIER_REPERTOIRE
									, pFile.getAbsolutePath());
				
				/* retour de MESSAGE_FICHIER_REPERTOIRE. */
				return MESSAGE_FICHIER_REPERTOIRE;
			}
			
			// LECTURE ***************
			FileInputStream fileInputStream = null;
			InputStreamReader inputStreamReader = null;
			BufferedReader bufferedReader = null;
			
			int characterEntier = 0;
			Character character = null;
			final StringBuilder stb = new StringBuilder();
			int compteur = 0;
			
			Charset charset = null;
			
			/* Choisit automatiquement le CHARSET_UTF8 si pCharset == null. */
			if(pCharsetName == null) {
				charset = CHARSET_UTF8;
			}
			else {
				charset = Charset.forName(pCharsetName);
			}
			
			try {
				
				/* Instancie un flux en lecture fileInputStream 
				 * en lui passant pFile. */
				fileInputStream = new FileInputStream(pFile);
				
				/* Instancie un InputStreamReader 
				 * en lui passant le FileReader et le Charset. */
				inputStreamReader 
					= new InputStreamReader(fileInputStream, charset);
								
				/* Instancie un tampon de flux de caractères en lecture 
				 * en lui passant le flux inputStreamReader. */
				bufferedReader 
					= new BufferedReader(inputStreamReader);
				
				/* Lecture dans le tampon de flux de caractères. */
				while((characterEntier = bufferedReader.read()) != -1) {
					
					/* Incrémentation du compteur. */
					compteur++;
					
					try {
						
						/* Conversion de l'entier en caractère. */
						character = (char) characterEntier;
						
						/* DETECTION DES CARACTERES NON HUMAINS. */
						if (!detecterCaractere(characterEntier, character)) {
							
							final String message 
							= "Le caractère lu à la position : " 
							+ compteur 
							+ " ne semble pas être un caractère humain : " 
							+ character 
							+ "\nNuméro du caractère : " 
							+ characterEntier 
							+ "\tType du caractère : " 
							+ Character.getType(character);
							
							/* LOG de niveau INFO. */
							if (LOG.isInfoEnabled()) {
								
								loggerInfo(
										CLASSE_MONFILEINPUTSTREAMREADERDAN
											, METHODE_LIREFICHIERDECARACTERES
												, message);
							}
							
							/* Rapport. */
							rapportLecture = message;
							
							/* retourne null. */
							return null;
						}
						
						/* Ajout du caractère au StringBuilder. */
						stb.append(character);
						
					} catch (Exception exceptionConversion) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_MONFILEINPUTSTREAMREADERDAN
									, METHODE_LIREFICHIERDECARACTERES
										, exceptionConversion);
												
						return exceptionConversion.getMessage();
					}
					
				} // Fin de lecture dans le tampon.______________
				
				/* Retour de la chaine de caractères. ***********/
				return stb.toString();
				
			} catch (FileNotFoundException fnfe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_MONFILEINPUTSTREAMREADERDAN
							, METHODE_LIREFICHIERDECARACTERES
								, fnfe);
				
				/* retourne le message de l'exception. */
				return fnfe.getMessage();
				
			} catch (UnsupportedEncodingException unsEncodingExc) {
			
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_MONFILEINPUTSTREAMREADERDAN
							, METHODE_LIREFICHIERDECARACTERES
								, unsEncodingExc);
				
				/* retourne le message de l'exception. */
				return unsEncodingExc.getMessage();
						
			} catch (IOException ioe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_MONFILEINPUTSTREAMREADERDAN
							, METHODE_LIREFICHIERDECARACTERES
								, ioe);
				
				/* retourne le message de l'exception. */
				return ioe.getMessage();
			}
			
			finally {
				
				/* fermeture du flux BufferedReader. */
				if (bufferedReader != null) {
					
					try {
						
						bufferedReader.close();
						
					} catch (IOException ioe2) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_MONFILEINPUTSTREAMREADERDAN
									, METHODE_LIREFICHIERDECARACTERES
										, ioe2);
						
					}
					
				} // Fin de if (bufferedReader != null).____
				
				/* fermeture du flux inputStreamReader. */
				if (inputStreamReader != null) {
					
					try {
						
						inputStreamReader.close();
						
					} catch (IOException ioe4) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_MONFILEINPUTSTREAMREADERDAN
									, METHODE_LIREFICHIERDECARACTERES
										, ioe4);
					}
					
				} // Fin de if (inputStreamReader != null).______
				
				/* fermeture du flux fileInputStream. */
				if (fileInputStream != null) {
					
					try {
						
						fileInputStream.close();
						
					} catch (IOException ioe3) {
						
						/* LOG de niveau ERROR. */
						loggerError(
								CLASSE_MONFILEINPUTSTREAMREADERDAN
									, METHODE_LIREFICHIERDECARACTERES
										, ioe3);
						
					}
					
				} // Fin de if (fileInputStream != null).________
				
			} // Fin du finally._____________________________
			
			
		} // Fin du bloc static synchronized.________________________		
				
	} // Fin de lireFichierDeCaracteres(
	 // File pFile
	// String pCharsetName)._______________________________________________
	

	
	
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
	
	
	
	/**
	 * method detecterCaractere(
	 * int pCharacterEntier
	 * , Character pCharacter) :<br/>
	 * Méthode expérimentale cherchant à déterminer 
	 * si un caractère est "humain", 
	 * c'est à dire peut avoir été tapé au clavier.<br/>
	 * Utilise le numéro entier du caractère et Character.getType(pCharacter)
	 * pour tenter de déterminer si le caractère est humain.<br/> 
	 * <br/>
	 * Retourne true si le caractère semble humain.<br/>
	 * <br/>
	 * - retourne false si pCharacter == null.<br/>
	 * <br/>
	 *
	 * @param pCharacterEntier : int : le numéro du caractère.<br/>
	 * @param pCharacter : Character : le caractère lu.<br/>
	 * 
	 * @return : boolean : true si le caractère semble humain.<br/>
	 */
	private static boolean detecterCaractere(
			final int pCharacterEntier
				, final Character pCharacter) {
		
		/* retourne false si pCharacter == null. */
		if (pCharacter == null) {
			return false;
		}
		
		/* Détection du caractère  . */
		/* characterEntier : 10   Character.getType(character) : 15 est un saut de ligne. */
		/* characterEntier : 13   Character.getType(character) : 15 est un saut de ligne. */
		/* characterEntier : 65533   Character.getType(character) : 28 est un saut de ligne. */
		if (pCharacterEntier > 0
				&& pCharacterEntier != 9
					&& pCharacterEntier != 10 
						&& pCharacterEntier != 13 
							&& Character.getType(pCharacter) == 15) {
			return false;
		}
	
		return true;
		
	} // Fin de detecterCaractere(
	 // int pCharacterEntier
	 // , Character pCharacter).___________________________________________



	/**
	 * method getRapportLecture() :<br/>
	 * Getter du rapport de lecture du fichier 
	 * (alimenté si le fichier n'est pas textuel).<br/>
	 * <br/>
	 *
	 * @return rapportLecture : String.<br/>
	 */
	public static String getRapportLecture() {
		return rapportLecture;
	} // Fin de getRapportLecture()._______________________________________



	/**
	 * method setRapportLecture(
	 * String pRapportLecture) :<br/>
	 * Setter du rapport de lecture du fichier 
	 * (alimenté si le fichier n'est pas textuel).<br/>
	 * <br/>
	 *
	 * @param pRapportLecture : String : 
	 * valeur à passer à rapportLecture.<br/>
	 */
	public static void setRapportLecture(
			final String pRapportLecture) {
		rapportLecture = pRapportLecture;
	} // Fin de setRapportLecture(
	 // String pRapportLecture).___________________________________________
	
	
		
	
} // FIN DE LA CLASSE MonFileInputStreamReaderDan.---------------------------
