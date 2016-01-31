package levy.daniel.application.util.controleurstypefichier.controleurstypefichiertexte;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import levy.daniel.application.IConstantesMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class ControleurFichierTexte :<br/>
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
 * @since 29 janv. 2016
 *
 */
public class ControleurFichierTexte {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * CLASSE_CONTROLEURFICHIERTEXTE : String :<br/>
	 * "Classe ControleurFichierTexte".<br/>
	 */
	public static final String CLASSE_CONTROLEURFICHIERTEXTE 
		= "Classe ControleurFichierTexte";
	
	/**
	 * METHODE_GETMIMETYPE : String :<br/>
	 * "Méthode getMIMEType(File pFile)".<br/>
	 */
	public static final String METHODE_GETMIMETYPE 
		= "Méthode getMIMEType(File pFile)";
	
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
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(ControleurFichierTexte.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ControleurFichierTexte() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ControleurFichierTexte() {
		
		/* Instanciation de la Super-Classe. */
		super();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method getMIMEType(
	 * File pFile) :<br/>
	 * Tente de détecter (en lisant les premiers bits) 
	 * et retourne le type MIME d'un fichier.<br/>
	 * <br/>
	 * - retourne MESSAGE_TYPE_MIME_PNG ('image/png') si le fichier est une image png.<br/>
	 * - retourne MESSAGE_TYPE_MIME_JPG ('image/jpeg') si le fichier est une image jpg.<br/>
	 * - retourne MESSAGE_TYPE_MIME_GIF ('image/gif') si le fichier est une image gif.<br/>
	 * - retourne MESSAGE_TYPE_MIME_BMP ('image/bmp') si le fichier est une image bmp.<br/>
	 * - retourne MESSAGE_TYPE_MIME_WAV ('audio/x-wav') si le fichier est un son wav.<br/>
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
	 * <br/>
	 *
	 * @param pFile : File : 
	 * le fichier dont on veut connaitre le type MIME.<br/>
	 * @return : String : le type MIME.<br/>
	 */
	public String getMIMEType(
			final File pFile) {
		
		/* retourne MESSAGE_FICHIER_NULL si le pFile est null. */
		if (pFile == null) {
			
			/* LOG de niveau INFO. */
			final String message 
			= CLASSE_CONTROLEURFICHIERTEXTE 
			+ IConstantesMessage.SEP_MOINS
			+ METHODE_GETMIMETYPE
			+ IConstantesMessage.SEP_MOINS
			+ MESSAGE_FICHIER_NULL;
			
			if (LOG.isInfoEnabled()) {
				LOG.info(message);
			}
			
			return MESSAGE_FICHIER_NULL;
		}
		
		/* retourne MESSAGE_FICHIER_INEXISTANT si le pFile est inexistant. */
		if (!pFile.exists()) {
			
			/* LOG de niveau INFO. */
			final String message 
			= CLASSE_CONTROLEURFICHIERTEXTE 
			+ IConstantesMessage.SEP_MOINS
			+ METHODE_GETMIMETYPE
			+ IConstantesMessage.SEP_MOINS
			+ MESSAGE_FICHIER_INEXISTANT 
			+ pFile.getAbsolutePath();
			
			if (LOG.isInfoEnabled()) {
				LOG.info(message);
			}
			
			return MESSAGE_FICHIER_INEXISTANT;
		}
		
		
		/* retourne MESSAGE_FICHIER_REPERTOIRE si le pFile est un répertoire. */
		if (pFile.isDirectory()) {
			
			/* LOG de niveau INFO. */
			final String message 
			= CLASSE_CONTROLEURFICHIERTEXTE 
			+ IConstantesMessage.SEP_MOINS
			+ METHODE_GETMIMETYPE
			+ IConstantesMessage.SEP_MOINS
			+ MESSAGE_FICHIER_REPERTOIRE 
			+ pFile.getAbsolutePath();
			
			if (LOG.isInfoEnabled()) {
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
			return malformedURLExc.getMessage();
			
		} catch (IOException ioe) {
			return ioe.getMessage();
		}
		
	} // Fin de getMIMEType(
	 // File pFile)._______________________________________________________
	

} // FIN DE LA CLASSE ControleurFichierTexte.--------------------------------
