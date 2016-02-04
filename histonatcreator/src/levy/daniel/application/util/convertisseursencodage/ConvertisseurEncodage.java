package levy.daniel.application.util.convertisseursencodage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import levy.daniel.application.IConstantesMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class ConvertisseurEncodage :<br/>
 * .<br/>
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
 * @since 4 févr. 2016
 *
 */
public final class ConvertisseurEncodage {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * CLASSE_CONVERTISSEUR_ENCODAGE : String :<br/>
	 * "Classe ConvertisseurEncodage".<br/>
	 */
	public static final String CLASSE_CONVERTISSEUR_ENCODAGE 
		= "Classe ConvertisseurEncodage";
	
	/**
	 * METHODE_LIRE_DEPUIS_FICHIER : String :<br/>
	 * "Méthode lireDepuisFichier(File pFile, Charset pCharset)".<br/>
	 */
	public static final String METHODE_LIRE_DEPUIS_FICHIER 
		= "Méthode lireDepuisFichier(File pFile, Charset pCharset)";
	
	/**
	 * MESSAGE_FICHIER_NULL : String :<br/>
	 * Message retourné par les méthodes prenant un File en paramètre 
	 * si le fichier est null.<br/>
	 * "Le fichier passé en paramètre est null".<br/>
	 */
	public static final String MESSAGE_FICHIER_NULL 
		= "Le fichier passé en paramètre est null";
	
	/**
	 * MESSAGE_FICHIER_INEXISTANT : String :<br/>
	 * Message retourné par les méthodes prenant un File en paramètre 
	 * si le fichier est inexistant.<br/>
	 * "Le fichier passé en paramètre est inexistant : "
	 */
	public static final String MESSAGE_FICHIER_INEXISTANT 
		= "Le fichier passé en paramètre est inexistant : ";
	
	/**
	 * MESSAGE_FICHIER_REPERTOIRE : String :<br/>
	 * Message retourné par les méthodes prenant un File en paramètre 
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
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(ConvertisseurEncodage.class);

	// *************************METHODES************************************/
	
	
	/**
	 * method CONSTRUCTEUR ConvertisseurEncodage() :
	 * Constructeur private pour empêcher l'instanciation.
	 */
	private ConvertisseurEncodage() {
		super();
	} // Fin de CONSTRUCTEUR ConvertisseurEncodage().______________________
	

	
	/**
	 * method lireDepuisFichier(
	 * File pFile
	 * , Charset pCharset) :<br/>
	 * Lit un fichier pFile et 
	 * retourne son contenu dans une chaîne de caractères.<br/>
	 * Lit le fichier en utilisant la méthode read() 
	 * de BufferedReader appliqué à un InputStreamReader 
	 * avec le Charset de décodage pCharset.<br/>
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
	 * @param pCharset : Charset : Charset utilisé par l'InputStreamReader 
	 * pour lire dans le fichier.<br/>
	 * 
	 * @return : String : Chaine de caractères avec le contenu du fichier.<br/>
	 */
	public static String lireDepuisFichier(
			final File pFile
				, final Charset pCharset) {
		
		/* block static synchronized. */
		synchronized (ConvertisseurEncodage.class) {
			
			/* retourne MESSAGE_FICHIER_NULL 
			 * si le pFile est null. */
			if (pFile == null) {
				
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, METHODE_LIRE_DEPUIS_FICHIER
								, MESSAGE_FICHIER_NULL);
				
				/* retour de MESSAGE_FICHIER_NULL. */
				return MESSAGE_FICHIER_NULL;
			}
			
			/* retourne MESSAGE_FICHIER_INEXISTANT 
			 * si le pFile est inexistant. */
			if (!pFile.exists()) {
								
				/* LOG de niveau INFO. */
				loggerInfo(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, METHODE_LIRE_DEPUIS_FICHIER
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
						CLASSE_CONVERTISSEUR_ENCODAGE
							, METHODE_LIRE_DEPUIS_FICHIER
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
			if(pCharset == null) {
				charset = CHARSET_UTF8;
			}
			else {
				charset = pCharset;
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
				
				/* Parcours du bufferedReader. */
				while (true) {
					
					/* Lecture de chaque caractère. */
					characterEntier = bufferedReader.read();
					
					/* Arrêt de la lecture si fin de fichier. */
					if (characterEntier < 0) {
						break;
					}
					
					/* Conversion de l'entier en caractère. */
					character = (char) characterEntier;
					
					/* Ajout du caractère au StringBuilder. */
					stb.append(character);
					
				} // Fin du parcours du bufferedReader._________
				
				/* Retour de la chaine de caractères. ***********/
				return stb.toString();
				
			} catch (FileNotFoundException fnfe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, METHODE_LIRE_DEPUIS_FICHIER
								, fnfe);
				
				/* retourne le message de l'exception. */
				return fnfe.getMessage();
				
			} catch (IOException ioe) {
				
				/* LOG de niveau ERROR. */
				loggerError(
						CLASSE_CONVERTISSEUR_ENCODAGE
							, METHODE_LIRE_DEPUIS_FICHIER
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
								CLASSE_CONVERTISSEUR_ENCODAGE
									, METHODE_LIRE_DEPUIS_FICHIER
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
								CLASSE_CONVERTISSEUR_ENCODAGE
									, METHODE_LIRE_DEPUIS_FICHIER
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
								CLASSE_CONVERTISSEUR_ENCODAGE
									, METHODE_LIRE_DEPUIS_FICHIER
										, ioe3);
						
					}
					
				} // Fin de if (fileInputStream != null).________
				
			} // Fin du finally._____________________________
			
		} // Fin du bloc static synchronized.________________________
		
	} // Fin de lireDepuisFichier(
	 // File pFile
	 // , Charset pCharset).______________________________________________
	

	
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
	
	

	
} // FIN DE LA CLASSE ConvertisseurEncodage.---------------------------------
