package levy.daniel.application.util.detecteurstypefichier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFileChooser;

import levy.daniel.application.IConstantesMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class DetecteurTypeMime :<br/>
 * Classe utilitaire contenant 2 méthodes statiques 
 * pour tenter de deviner le type MIME d'un fichier.<br/>
 * <br/>
 * - getMIMEType(File pFile) utilisant la méthode 
 * getContentType() de java.net.URLConnection.<br/>
 * - devineMIMEType(File pFile) utilisant la méthode 
 * guessContentTypeFromStream(fileInputStream) de java.net.URLConnection 
 * et getMIMEType(File pFile).<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code>
 * // passe une image png au File FILE_PNG.<br/>
 * final File FILE_PNG = new File(".\\images\\fleur.png");<br/>
 * // Invocation de la méthode devineMIMEType(File pFile).<br/>
 * final String typeMIME = DetecteurTypeMime.devineMIMEType(FILE_PNG);<br/>
 * // typeMIME contient 'image/png'.<br/>
 * </code>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Type MIME, mapStringStringtoString(), afficherMapStringStringConsole,<br/>
 * afficher map de String, String.<br/>
 * Set<Entry<String, String>> entrySet = pMap.entrySet();<br/>
 * final Iterator<Entry<String, String>> ite = entrySet.iterator();<br/>
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
public final class DetecteurTypeMime {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * serialVersionUID : long :<br/>
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * CLASSE_DETECTEURTYPEMIME : String :<br/>
	 * "Classe DetecteurTypeMime".<br/>
	 */
	public static final String CLASSE_DETECTEURTYPEMIME 
		= "Classe DetecteurTypeMime";
	
	/**
	 * METHODE_GETMIMETYPE : String :<br/>
	 * "Méthode getMIMEType(File pFile)".<br/>
	 */
	public static final String METHODE_GETMIMETYPE 
		= "Méthode getMIMEType(File pFile)";
	
	/**
	 * METHODE_DEVINEMIMETYPE : String :<br/>
	 * "Méthode devineMIMEType(File pFile)".<br/>
	 */
	public static final String METHODE_DEVINEMIMETYPE 
		= "Méthode devineMIMEType(File pFile)";
	
	/**
	 * MESSAGE_FICHIER_NULL : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * si le fichier est null.<br/>
	 * "Le fichier passé en paramètre est null".<br/>
	 */
	public static final String MESSAGE_FICHIER_NULL 
		= "Le fichier passé en paramètre est null";
	
	/**
	 * MESSAGE_FICHIER_INEXISTANT : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * si le fichier est inexistant.<br/>
	 * "Le fichier passé en paramètre est inexistant : "
	 */
	public static final String MESSAGE_FICHIER_INEXISTANT 
		= "Le fichier passé en paramètre est inexistant : ";
	
	/**
	 * MESSAGE_FICHIER_REPERTOIRE : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * si le fichier est un répertoire.<br/>
	 * "Le fichier passé en paramètre est un répertoire : ".<br/>
	 */
	public static final String MESSAGE_FICHIER_REPERTOIRE 
		= "Le fichier passé en paramètre est un répertoire : ";

	
	/**
	 * MESSAGE_TYPE_MIME_INCONNU : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * généré par java.net.URLConnection 
	 * si le type MIME est inconnu.<br/>
	 * "content/unknown".<br/>
	 */
	public static final String MESSAGE_TYPE_MIME_INCONNU 
		= "content/unknown";

	
	/**
	 * MESSAGE_TYPE_MIME_PNG : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * généré par java.net.URLConnection 
	 * si le type MIME est png.<br/>
	 * "image/png".<br/>
	 */
	public static final String MESSAGE_TYPE_MIME_PNG 
		= "image/png";

	
	/**
	 * MESSAGE_TYPE_MIME_JPG : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * généré par java.net.URLConnection 
	 * si le type MIME est jpg.<br/>
	 * "image/jpeg".<br/>
	 */
	public static final String MESSAGE_TYPE_MIME_JPG 
		= "image/jpeg";

	
	/**
	 * MESSAGE_TYPE_MIME_GIF : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * généré par java.net.URLConnection 
	 * si le type MIME est gif.<br/>
	 * "image/gif"
	 */
	public static final String MESSAGE_TYPE_MIME_GIF 
		= "image/gif";
	
	
	/**
	 * MESSAGE_TYPE_MIME_BMP : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * généré par java.net.URLConnection 
	 * si le type MIME est bmp.<br/>
	 * "image/bmp".<br/>
	 */
	public static final String MESSAGE_TYPE_MIME_BMP 
		= "image/bmp";

	
	/**
	 * MESSAGE_TYPE_MIME_WAV : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * généré par java.net.URLConnection 
	 * si le type MIME est wav.<br/>
	 * "audio/x-wav".<br/>
	 */
	public static final String MESSAGE_TYPE_MIME_WAV 
		= "audio/x-wav";

	
	/**
	 * MESSAGE_TYPE_MIME_TEXT_PLAIN : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * généré par java.net.URLConnection 
	 * si le type MIME est txt.<br/>
	 * "text/plain".<br/>
	 */
	public static final String MESSAGE_TYPE_MIME_TEXT_PLAIN 
		= "text/plain";
	
	
	/**
	 * MESSAGE_TYPE_MIME_PDF : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * généré par java.net.URLConnection 
	 * si le type MIME est pdf.<br/>
	 * "application/pdf".<br/>
	 */
	public static final String MESSAGE_TYPE_MIME_PDF 
		= "application/pdf";
	
	
	/**
	 * MESSAGE_TYPE_MIME_XML : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * généré par java.net.URLConnection 
	 * si le type MIME est xsd ou xml.<br/>
	 * "application/xml".<br/>
	 */
	public static final String MESSAGE_TYPE_MIME_XML 
		= "application/xml";
	
	
	/**
	 * MESSAGE_TYPE_MIME_HTML : String :<br/>
	 * Message retourné par la méthode getMIMEType(File pFile) 
	 * généré par java.net.URLConnection 
	 * si le type MIME est html.<br/>
	 * "text/html".<br/>
	 */
	public static final String MESSAGE_TYPE_MIME_HTML 
		= "text/html";
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(DetecteurTypeMime.class);

	// *************************METHODES************************************/
	
	/**
	 * method CONSTRUCTEUR DetecteurTypeMime() :
	 * Constructeur private pour empêcher l'instanciation.
	 *
	 */
	private DetecteurTypeMime() {
		super();
	} // Fin de CONSTRUCTEUR DetecteurTypeMime().__________________________
	
	
	
	/**
	 * method getMIMEType(
	 * File pFile) :<br/>
	 * Tente de détecter (en lisant les premiers bits) 
	 * et retourne le type MIME d'un fichier 
	 * en utilisant la méthode getContentType() de java.net.URLConnection.<br/>
	 * <br/>
	 * ATTENTION : Il est facile de "leurrer" cette méthode 
	 * en retirant l'extension de fichier 
	 * ou en indiquant une fausse extension.<br/> 
	 * Par exemple, si on renomme artificiellement une image .gif en .bmp, 
	 * la méthode retourne MESSAGE_TYPE_MIME_BMP.<br/>
	 * En revanche, la méthode retourne bien MESSAGE_TYPE_MIME_GIF 
	 * si on lui soumet une image .gif sans extension.<br/>
	 * Autre exemple, un fichier .txt sans extension 
	 * ou avec une fausse extension comme .csv 
	 * retournera MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 * - retourne MESSAGE_TYPE_MIME_PNG ('image/png') si le fichier est une image png.<br/>
	 * - retourne MESSAGE_TYPE_MIME_JPG ('image/jpeg') si le fichier est une image jpg.<br/>
	 * - retourne MESSAGE_TYPE_MIME_GIF ('image/gif') si le fichier est une image gif.<br/>
	 * - retourne MESSAGE_TYPE_MIME_BMP ('image/bmp') si le fichier est une image bmp.<br/>
	 * - retourne MESSAGE_TYPE_MIME_WAV ('audio/x-wav') si le fichier est un son wav.<br/>
	 * - retourne MESSAGE_TYPE_MIME_TEXT_PLAIN ('text/plain') si le fichier est un texte txt.<br/>
	 * - retourne MESSAGE_TYPE_MIME_PDF ('application/pdf') si le fichier est un pdf.<br/>
	 * - retourne MESSAGE_TYPE_MIME_XML ('application/xml') si le fichier est un xsd.<br/>
	 * - retourne MESSAGE_TYPE_MIME_XML ('application/xml') si le fichier est un xml.<br/>
	 * - retourne MESSAGE_TYPE_MIME_HTML ('text/html') si le fichier est un html.<br/>
	 * <br/>
	 * - retourne MESSAGE_FICHIER_NULL si le pFile est null.<br/>
	 * - retourne MESSAGE_FICHIER_INEXISTANT si le pFile est inexistant.<br/>
	 * - retourne MESSAGE_FICHIER_REPERTOIRE si le pFile est un répertoire.<br/>
	 * <br/>
	 * - retourne MESSAGE_TYPE_MIME_INCONNU ('content/unknown') si le type MIME 
	 * du fichier passé en paramètre n'est pas détecté.<br/>
	 * C'est le cas (non-détection) avec les fichiers :<br/>
	 * - .dwg d'Autocad.<br/>
	 * - .pptx de PowerPoint.<br/>
	 * - .mid (fichiers Midi).<br/>
	 * - .eap d'Enterprise Architect.<br/>
	 * - .ico (fichiers icône).<br/>
	 * - .mp3 (fichiers musicaux compressés).<br/>
	 * - .csv.<br/>
	 * - .ini.<br/>
	 * - .properties.<br/>
	 * - .docX (Word).<br/>
	 * - .mp4 (film).<br/>
	 * - .flv (film).<br/>
	 * - .asf (film).<br/>
	 * <br/>
	 *
	 * @param pFile : File : 
	 * le fichier dont on veut connaitre le type MIME.<br/>
	 * @return : String : le type MIME.<br/>
	 */
	public static String getMIMEType(
			final File pFile) {
		
		/* block static synchronized. */
		synchronized (DetecteurTypeMime.class) {
			
			/* retourne MESSAGE_FICHIER_NULL si le pFile est null. */
			if (pFile == null) {
				
				/* LOG de niveau INFO. */			
				if (LOG.isInfoEnabled()) {
					
					final String message 
					= CLASSE_DETECTEURTYPEMIME 
					+ IConstantesMessage.SEP_MOINS
					+ METHODE_GETMIMETYPE
					+ IConstantesMessage.SEP_MOINS
					+ MESSAGE_FICHIER_NULL;
					
					LOG.info(message);
				}
				
				return MESSAGE_FICHIER_NULL;
			}
			
			/* retourne MESSAGE_FICHIER_INEXISTANT si le pFile est inexistant. */
			if (!pFile.exists()) {
				
				
				/* LOG de niveau INFO. */
				if (LOG.isInfoEnabled()) {
									
					final String message 
					= CLASSE_DETECTEURTYPEMIME 
					+ IConstantesMessage.SEP_MOINS
					+ METHODE_GETMIMETYPE
					+ IConstantesMessage.SEP_MOINS
					+ MESSAGE_FICHIER_INEXISTANT 
					+ pFile.getAbsolutePath();
					
					LOG.info(message);
				}
				
				return MESSAGE_FICHIER_INEXISTANT;
			}
			
			
			/* retourne MESSAGE_FICHIER_REPERTOIRE si le pFile est un répertoire. */
			if (pFile.isDirectory()) {
				
				/* LOG de niveau INFO. */			
				if (LOG.isInfoEnabled()) {
					
					final String message 
					= CLASSE_DETECTEURTYPEMIME 
					+ IConstantesMessage.SEP_MOINS
					+ METHODE_GETMIMETYPE
					+ IConstantesMessage.SEP_MOINS
					+ MESSAGE_FICHIER_REPERTOIRE 
					+ pFile.getAbsolutePath();
					
					LOG.info(message);
				}
				
				return MESSAGE_FICHIER_REPERTOIRE;
			}

			
			try {
				
				/* Création d'une URL vers pFile. */
				final URL url = pFile.toURI().toURL();
				
				/* Création d'une connexion vers l'URL. */
				final URLConnection connection = url.openConnection();
				
				/* Returns the value of the content-type header field. */
				return connection.getContentType();
				
			} catch (MalformedURLException malformedURLExc) {
				
				/* LOG de niveau ERROR. */
				if (LOG.isErrorEnabled()) {
					
					final String message 
					= CLASSE_DETECTEURTYPEMIME 
					+ IConstantesMessage.SEP_MOINS
					+ METHODE_GETMIMETYPE
					+ IConstantesMessage.SEP_MOINS 
					+ malformedURLExc.getMessage();
					
					LOG.error(message, malformedURLExc);
					
				}
				
				return malformedURLExc.getMessage();
				
			} catch (IOException ioe) {
				
				/* LOG de niveau ERROR. */
				if (LOG.isErrorEnabled()) {
					
					final String message 
					= CLASSE_DETECTEURTYPEMIME 
					+ IConstantesMessage.SEP_MOINS
					+ METHODE_GETMIMETYPE
					+ IConstantesMessage.SEP_MOINS 
					+ ioe.getMessage();
					
					LOG.error(message, ioe);
					
				}
				
				return ioe.getMessage();
			}
			
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de getMIMEType(
	 // File pFile)._______________________________________________________
	

	
	/**
	 * method devineMIMEType(
	 * File pFile) :<br/>
	 * Tente de détecter (en lisant les premiers bits) 
	 * et retourne le type MIME d'un fichier 
	 * en utilisant la méthode guessContentTypeFromStream(fileInputStream)
	 *  de java.net.URLConnection.<br/>
	 *  Utilise également la méthode getMIMEType(File) 
	 *  si guessContentTypeFromStream(fileInputStream) 
	 *  n'a pas deviné le type MIME.<br/>
	 * <br/>
	 * ATTENTION : Il est facile de "leurrer" cette méthode 
	 * en retirant l'extension de fichier 
	 * ou en indiquant une fausse extension.<br/> 
	 * Par exemple, si on renomme artificiellement une image .gif en .bmp, 
	 * la méthode retourne MESSAGE_TYPE_MIME_BMP.<br/>
	 * En revanche, la méthode retourne bien MESSAGE_TYPE_MIME_GIF 
	 * si on lui soumet une image .gif sans extension.<br/>
	 * Autre exemple, un fichier .txt sans extension 
	 * ou avec une fausse extension comme .csv 
	 * retournera MESSAGE_TYPE_MIME_INCONNU.<br/>
	 * <br/>
	 * - retourne MESSAGE_TYPE_MIME_PNG ('image/png') si le fichier est une image png.<br/>
	 * - retourne MESSAGE_TYPE_MIME_JPG ('image/jpeg') si le fichier est une image jpg.<br/>
	 * - retourne MESSAGE_TYPE_MIME_GIF ('image/gif') si le fichier est une image gif.<br/>
	 * - retourne MESSAGE_TYPE_MIME_BMP ('image/bmp') si le fichier est une image bmp.<br/>
	 * - retourne MESSAGE_TYPE_MIME_WAV ('audio/x-wav') si le fichier est un son wav.<br/>
	 * - retourne MESSAGE_TYPE_MIME_TEXT_PLAIN ('text/plain') si le fichier est un texte txt.<br/>
	 * - retourne MESSAGE_TYPE_MIME_PDF ('application/pdf') si le fichier est un pdf.<br/>
	 * - retourne MESSAGE_TYPE_MIME_XML ('application/xml') si le fichier est un xsd.<br/>
	 * - retourne MESSAGE_TYPE_MIME_XML ('application/xml') si le fichier est un xml.<br/>
	 * - retourne MESSAGE_TYPE_MIME_HTML ('text/html') si le fichier est un html.<br/>
	 * <br/>
	 * - retourne MESSAGE_FICHIER_NULL si le pFile est null.<br/>
	 * - retourne MESSAGE_FICHIER_INEXISTANT si le pFile est inexistant.<br/>
	 * - retourne MESSAGE_FICHIER_REPERTOIRE si le pFile est un répertoire.<br/>
	 * <br/>
	 * - retourne MESSAGE_TYPE_MIME_INCONNU ('content/unknown') si le type MIME 
	 * du fichier passé en paramètre n'est pas détecté.<br/>
	 * C'est le cas (non-détection) avec les fichiers :<br/>
	 * - .dwg d'Autocad.<br/>
	 * - .pptx de PowerPoint.<br/>
	 * - .mid (fichiers Midi).<br/>
	 * - .eap d'Enterprise Architect.<br/>
	 * - .ico (fichiers icône).<br/>
	 * - .mp3 (fichiers musicaux compressés).<br/>
	 * - .csv.<br/>
	 * - .ini.<br/>
	 * - .properties.<br/>
	 * - .docX (Word).<br/>
	 * - .mp4 (film).<br/>
	 * - .flv (film).<br/>
	 * - .asf (film).<br/>
	 * <br/>
	 *
	 * @param pFile : File : 
	 * le fichier dont on veut connaitre le type MIME.<br/>
	 * @return : String : le type MIME.<br/>
	 */
	public static String devineMIMEType(
			final File pFile) {
		
		/* block static synchronized. */
		synchronized (DetecteurTypeMime.class) {
			
			/* retourne MESSAGE_FICHIER_NULL 
			 * si le pFile est null. */
			if (pFile == null) {
				
				/* LOG de niveau INFO. */			
				if (LOG.isInfoEnabled()) {
					
					final String message 
					= CLASSE_DETECTEURTYPEMIME 
					+ IConstantesMessage.SEP_MOINS
					+ METHODE_DEVINEMIMETYPE
					+ IConstantesMessage.SEP_MOINS
					+ MESSAGE_FICHIER_NULL;
					
					LOG.info(message);
				}
				
				return MESSAGE_FICHIER_NULL;
			}
			
			/* retourne MESSAGE_FICHIER_INEXISTANT 
			 * si le pFile est inexistant. */
			if (!pFile.exists()) {
				
				
				/* LOG de niveau INFO. */
				if (LOG.isInfoEnabled()) {
									
					final String message 
					= CLASSE_DETECTEURTYPEMIME 
					+ IConstantesMessage.SEP_MOINS
					+ METHODE_DEVINEMIMETYPE
					+ IConstantesMessage.SEP_MOINS
					+ MESSAGE_FICHIER_INEXISTANT 
					+ pFile.getAbsolutePath();
					
					LOG.info(message);
				}
				
				return MESSAGE_FICHIER_INEXISTANT;
			}
			
			
			/* retourne MESSAGE_FICHIER_REPERTOIRE 
			 * si le pFile est un répertoire. */
			if (pFile.isDirectory()) {
				
				/* LOG de niveau INFO. */			
				if (LOG.isInfoEnabled()) {
					
					final String message 
					= CLASSE_DETECTEURTYPEMIME 
					+ IConstantesMessage.SEP_MOINS
					+ METHODE_DEVINEMIMETYPE
					+ IConstantesMessage.SEP_MOINS
					+ MESSAGE_FICHIER_REPERTOIRE 
					+ pFile.getAbsolutePath();
					
					LOG.info(message);
				}
				
				return MESSAGE_FICHIER_REPERTOIRE;
			}
			
			FileInputStream fileInputStream = null;
			
			try {
				
				/* Instanciation du flux en lui passant le fichier. */
				fileInputStream = new FileInputStream(pFile);
				
				/* Interprétation du type MIME après lecture du flux. */
				final String resultat 
					= URLConnection.guessContentTypeFromStream(fileInputStream);
				
				/* Retour du type MIME deviné. */
				if (resultat == null) {
					
					/* Tente de calculer le type MIME 
					 * par la méthode getMIMEType(File). */
					final String resultatGetMIMEType = getMIMEType(pFile);
					
					/* Si getMIMEType(File) a matché, retourne le resultat. */
					if (!StringUtils.equals(
							resultatGetMIMEType, MESSAGE_TYPE_MIME_INCONNU)) {
						return resultatGetMIMEType;
					}
					
					/* Sinon, retourne 'content/unknown'. */
					return MESSAGE_TYPE_MIME_INCONNU;
				}
				
				return resultat;
				
			} catch (FileNotFoundException fnfe) {
				
				/* LOG de niveau ERROR. */
				if (LOG.isErrorEnabled()) {
					
					final String message 
					= CLASSE_DETECTEURTYPEMIME 
					+ IConstantesMessage.SEP_MOINS
					+ METHODE_DEVINEMIMETYPE
					+ IConstantesMessage.SEP_MOINS 
					+ fnfe.getMessage();
					
					LOG.error(message, fnfe);
					
				}
				
				return fnfe.getMessage();
				
			} catch (IOException ioe) {
				
				/* LOG de niveau ERROR. */
				if (LOG.isErrorEnabled()) {
					
					final String message 
					= CLASSE_DETECTEURTYPEMIME 
					+ IConstantesMessage.SEP_MOINS
					+ METHODE_DEVINEMIMETYPE
					+ IConstantesMessage.SEP_MOINS 
					+ ioe.getMessage();
					
					LOG.error(message, ioe);
					
				}
				
				return ioe.getMessage();
			}
			
			finally {
				
				if (fileInputStream != null) {
					
						try {
							
							/* Fermeture du flux. */
							fileInputStream.close();
							
						} catch (IOException ioe2) {
							
							/* LOG de niveau ERROR. */
							if (LOG.isErrorEnabled()) {
								
								final String message 
								= CLASSE_DETECTEURTYPEMIME 
								+ IConstantesMessage.SEP_MOINS
								+ METHODE_DEVINEMIMETYPE
								+ IConstantesMessage.SEP_MOINS 
								+ ioe2.getMessage();
								
								LOG.error(message, ioe2);
								
							}
												
						}
					
				} // Fin de if (fileInputStream != null).__________
				
			} // Fin du finally.___________________________________
			
		} // Fin du bloc static synchronized.________________________		
				
	} // Fin de devineMIMEType(
	 // File pFile)._______________________________________________________
	
	
		
	/**
	 * method getDescriptionExtension(
	 * File pFile) :<br/>
	 * Retourne la description du type MIME fournie par Windows.<br/>
	 * <br/>
	 * ATTENTION : cette méthode se base uniquement 
	 * sur l'extension du fichier qui doit donc être juste.<br/>
	 * <br/>
	 * - retourne 'Document texte' pour un .txt.<br/>
	 * - retourne 'Paramètres de configuration' pour un .ini.<br/>
	 * - retourne 'Fichier DWG' pour un .dwg d'Autocad.<br/>
	 * - retourne 'MS Office PowerPoint OpenXML' pour un .pptx.<br/>
	 * - retourne 'Séquence MIDI' pour un .mid.<br/>
	 * <br/>
	 * - retourne null si pFile et null.<br/>
	 * - retourne 'Fichier générique' si pFile est inexistant.<br/>
	 * - retourne 'Dossier de fichiers' si pFile est un répertoire.<br/>
	 * <br/>
	 *
	 * @param pFile : File : 
	 * le fichier dont on veut connaitre la description.<br/>
	 * @return : String : la description du fichier.<br/>
	 */
	public static String getDescriptionExtension(
			final File pFile) {
		
		/* block static synchronized. */
		synchronized (DetecteurTypeMime.class) {
			
			/* Instanciation d'un JFileChooser. */
			final JFileChooser chooser = new JFileChooser();
			
			String resultat = null;
			
			try {
				
				/* Récupération de la description 
				 * du type MIME fournie par Windows.*/
				resultat = chooser.getTypeDescription(pFile);
				
			} catch (Exception e) {
				
				/* ne rien faire ici. 
				 * Exception while removing reference catchée ici car
				 * sans intérêt. Elle ne laisse aucune trace. */
				if (LOG.isInfoEnabled()) {
					LOG.info(e);
				}
				
			}
			
			/* Retourne la description du type MIME. */
	        return resultat;
	        
	        
		} // Fin du bloc static synchronized.________________________
                
		
    } // Fin de getDescriptionExtension.___________________________________
	
	
	
	/**
	 * method getMapDescriptionsExtensions(
	 * List&lt;File&gt; pList) :<br/>
	 * Fournit une Map&lt;String,String&gt; comportant 
	 * les noms des fichiers compris dans la List&lt;File&gt; pList 
	 * et leur description Windows de leur type MIME :<br/>
	 * - key : le nom d'un fichier dans la liste pList.<br/>
	 * - value : la description du type MIME du fichier fournie par 
	 * chooser.getTypeDescription(file).<br/>
	 * <br/>
	 * - retourne null si pList == null.<br/>
	 * - retourne null si pList.isEmpty().<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;File&gt; : Liste des fichiers dont 
	 * on veut connaitre la description du type MIME.<br/>
	 * @return : Map&lt;String,String&gt;.<br/>
	 */
	public static Map<String, String> getMapDescriptionsExtensions(
			final List<File> pList) {
		
		/* block static synchronized. */
		synchronized (DetecteurTypeMime.class) {
						
			/* retourne null si pList == null. */
			if (pList == null) {
				return null;
			}
			
			/* retourne null si pList.isEmpty(). */
			if (pList.isEmpty()) {
				return null;
			}
			
			/* Instanciation d'un JFileChooser. */
			final JFileChooser chooser = new JFileChooser();
			
			/* Instanciation de la Map*/
			final Map<String, String> resultatMap 
				= new HashMap<String, String>();
			
			/* parcours foreach sur chaque File de pList. */
			for(final File file : pList) {
				
				String nomFichier = null;
				String descriptionFichier = null;
				
				/* Extraction du nom du fichier 
				 * et de la description du type MIME. */
				if (file != null) {
					nomFichier = file.getName();
					descriptionFichier = chooser.getTypeDescription(file);
				}
				else {
					nomFichier = "null";
					descriptionFichier = getDescriptionExtension(file);
				}
				
				
				/* Ajout dans la Map. */
				resultatMap.put(nomFichier, descriptionFichier);
			}
			
			/* Retourne la Map resultat. */
			return resultatMap;
			
		} // Fin du bloc static synchronized.________________________

		
	} // Fin de getMapDescriptionsExtensions(
	 // List<File> pList)._________________________________________________

	
	
	/**
	 * method mapStringStringtoString(
	 * Map<String, String> pMap) :<br/>
	 * Retourne une chaîne de caractères pour l'affichage 
	 * du contenu d'une Map&lt;String,String&gt; à la console.<br/>
	 * <br/>
	 * - retourne null si pMap == null.<br/>
	 * - retourne null si pMap.isEmpty().<br/>
	 * <br/>
	 *
	 * @param pMap : Map&lt;String,String&gt; : la Map à afficher.<br/>
	 * @return : String : La chaîne de caractères pour l'affichage 
	 * du contenu de la Map&lt;String,String&gt;.<br/>
	 */
	public static String mapStringStringtoString(
			final Map<String, String> pMap) {
		
		/* block static synchronized. */
		synchronized (DetecteurTypeMime.class) {
			
			/* retourne null si pMap == null. */
			if (pMap == null) {
				return null;
			}
			
			/* retourne null si pMap.isEmpty(). */
			if (pMap.isEmpty()) {
				return null;
			}
			
			final StringBuffer stb = new StringBuffer();
			
			/* Récupère un Set<Entry<String, String>> auprès de la Map. */
			final Set<Entry<String, String>> entrySet = pMap.entrySet();
			
			/* Récupère un Iterator<Entry<String, String>> 
			 * auprès du Set<Entry<String, String>> */
			final Iterator<Entry<String, String>> ite = entrySet.iterator();
			
			/* Parcours de l'Iterator. */
			while (ite.hasNext()) {
				
				/* Récupération de chaque Entry<String, String> 
				 * auprès de l'Iterator. */
				final Entry<String, String> entry = ite.next();
				
				/* Récupération de la key et de la value dans l'Entry. */
				final String key = entry.getKey();
				final String value = entry.getValue();
				
				/* Remplissage du StringBuffer. */
				/* key. */
				stb.append(key);
				/* tabulation. */
				stb.append(IConstantesMessage.SEPTAB);
				stb.append(IConstantesMessage.SEPTAB);
				/* value. */
				stb.append(value);
				/* Saut de ligne. */
				stb.append(IConstantesMessage.SAUT_DE_LIGNE);
				
			} // Fin du while.___________________
			
			/* Retour de la String résultante. */
			return stb.toString();
			
		} // Fin du bloc static synchronized.________________________
				
	} // Fin de mapStringStringtoString(
	 // Map<String, String> pMap)._________________________________________
	
	
	
} // FIN DE LA CLASSE DetecteurTypeMime.-------------------------------------
