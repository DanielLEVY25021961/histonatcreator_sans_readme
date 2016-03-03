package levy.daniel.application.metier.service.enregistreursfichiers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Date;

import levy.daniel.application.util.differentiateurs.differentiateursstrings.DifferentiateurString;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class AbstractEnregistreurFichiers :<br/>
 * Abstraction qui centralise les attributs et méthodes de toutes les classes 
 * qui fournissent des services d'enregistrement de fichiers sur disque.<br/>
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
 * @since 3 mars 2016
 *
 */
public abstract class AbstractEnregistreurFichiers implements
		IEnregistreurFichiers {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_ABSTRACT_ENREGISTREUR_FICHIERS : String :<br/>
	 * "Classe AbstractEnregistreurFichiers".<br/>
	 */
	public static final String CLASSE_ABSTRACT_ENREGISTREUR_FICHIERS 
		= "Classe AbstractEnregistreurFichiers";
	
	
	
	/**
	 * METHODE_ECRIRESTRINGDANSFILE : String :<br/>
	 * "méthode ecrireStringDansFile(
	 * File pFile, String pString, Charset pCharset, String pSautLigne)".<br/>
	 */
	public static final String METHODE_ECRIRESTRINGDANSFILE 
		= "méthode ecrireStringDansFile(File pFile, String pString"
				+ ", Charset pCharset, String pSautLigne)";
	

	
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
	 * dateEnregistrement : Date :<br/>
	 * java.util.Date de l'enregistrement du fichier.<br/>
	 */
	protected Date dateEnregistrement;

	
	/**
	 * dateEnregistrementStringFormatee : String :<br/>
	 * date se l'enregistrement du fichier 
	 * formattée au format dfDatetimemilliFrancaise.<br/>
	 * Format des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 */
	protected transient String dateEnregistrementStringFormatee;
	
	
	/**
	 * userName : String :<br/>
	 * nom de l'utilisateur qui a déclenché l'enregistrement du fichier.<br/>
	 */
	protected String userName;

	
	/**
	 * fichier : File :<br/>
	 * fichier enregistré.<br/>
	 */
	protected File fichier;

	
	/**
	 * nomFichier : String :<br/>
	 * nom du fichier objet de l'enregistrement.<br/>
	 */
	protected transient String nomFichier;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(AbstractEnregistreurFichiers.class);
	

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractEnregistreurFichiers() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 */
	public AbstractEnregistreurFichiers() {
		super();
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final File ecrireStringDansFile(
			final File pFile
				, final String pString
					, final Charset pCharset
,
			final String pSautLigne) {

		/* retourne null si le pFile est null. */
		if (pFile == null) {

			/* LOG de niveau INFO. */
			loggerInfo(this.fournirNomClasseConcrete(),
					METHODE_ECRIRESTRINGDANSFILE
						, MESSAGE_FICHIER_NULL);

			/* retour de null. */
			return null;
		}

		/* retourne null si le pFile est inexistant. */
		if (!pFile.exists()) {

			/* LOG de niveau INFO. */
			loggerInfo(this.fournirNomClasseConcrete(),
					METHODE_ECRIRESTRINGDANSFILE
						, MESSAGE_FICHIER_INEXISTANT
							, pFile.getAbsolutePath());

			/* retour de null. */
			return null;
		}

		/* retourne null si le pFile est un répertoire. */
		if (pFile.isDirectory()) {

			/* LOG de niveau INFO. */
			loggerInfo(this.fournirNomClasseConcrete(),
					METHODE_ECRIRESTRINGDANSFILE
						, MESSAGE_FICHIER_REPERTOIRE
							, pFile.getAbsolutePath());

			/* retour de null. */
			return null;
		}

		/* retourne null si pString est blank. */
		if (StringUtils.isBlank(pString)) {

			/* LOG de niveau INFO. */
			loggerInfo(this.fournirNomClasseConcrete(),
					METHODE_ECRIRESTRINGDANSFILE
						, MESSAGE_STRING_BLANK
							, pString);

			return null;
		}

		Charset charset = null;

		/* Passe automatiquement le charset à UTF-8 si pCharset est null. */
		if (pCharset == null) {
			charset = CHARSET_UTF8;
		} else {
			charset = pCharset;
		}

		String sautLigne = null;

		/*
		 * Passe automatiquement le saut de ligne à NEWLINE (saut de ligne de la
		 * plateforme) si pSautLigne est blank.
		 */
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
			fileOutputStream = new FileOutputStream(pFile);

			/*
			 * Ouverture d'un OutputStreamWriter sur le FileOutputStream en lui
			 * passant le Charset.
			 */
			outputStreamWriter = new OutputStreamWriter(fileOutputStream,
					charset);

			/*
			 * Ouverture d'un tampon d'écriture BufferedWriter sur le
			 * OutputStreamWriter.
			 */
			bufferedWriter = new BufferedWriter(outputStreamWriter);

			// ECRITURE.
			/*
			 * Substitue automatiquement sautLigne aux sauts de ligne dans
			 * pString si nécessaire.
			 */
			bufferedWriter.write(substituerSautLigne(pString, sautLigne));

			// Retour du fichier.
			return pFile;

		} catch (FileNotFoundException fnfe) {

			/* LOG de niveau ERROR. */
			loggerError(
					this.fournirNomClasseConcrete()
						, MESSAGE_EXCEPTION
							, fnfe);

			/* retour de null. */
			return null;

		} catch (IOException ioe) {

			/* LOG de niveau ERROR. */
			loggerError(
					this.fournirNomClasseConcrete()
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
							this.fournirNomClasseConcrete()
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
							this.fournirNomClasseConcrete()
							, MESSAGE_EXCEPTION
								, ioe2);
				}
			} // Fin de if (outputStreamWriter != null).______

			if (fileOutputStream != null) {
				try {

					fileOutputStream.close();

				} catch (IOException ioe3) {

					// * LOG de niveau ERROR. */
					loggerError(
							this.fournirNomClasseConcrete()
							, MESSAGE_EXCEPTION
								, ioe3);
				}
			}

		} // Fin du finally.____________________________

	} // Fin de ecrireStringDansFile(...)._________________________________
	

	
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
	public final String substituerSautLignePlateforme(
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
	public final String substituerSautLigne(
			final String pString,
				final String pSautLigne) {

		/* retourne null si pString est blank (null ou vide). */
		if (StringUtils.isBlank(pString)) {
			return null;
		}

		/* retourne null si pSautLigne est blank (null ou vide). */

		/* Recherche des sauts de ligne DOS/Windows. */
		if (StringUtils.contains(pString, SAUTDELIGNE_DOS_WINDOWS)) {

			final String resultat = StringUtils.replace(pString,
					SAUTDELIGNE_DOS_WINDOWS, pSautLigne);

			return resultat;
		}

		/* Recherche des sauts de ligne Mac. */
		if (StringUtils.contains(pString, SAUTDELIGNE_MAC)) {

			final String resultat = StringUtils.replace(pString,
					SAUTDELIGNE_MAC, pSautLigne);

			return resultat;
		}

		/* Recherche des sauts de ligne Unix. */
		if (StringUtils.contains(pString, SAUTDELIGNE_UNIX)) {

			final String resultat = StringUtils.replace(pString,
					SAUTDELIGNE_UNIX, pSautLigne);

			return resultat;
		}

		/*
		 * Retourne la chaîne inchangée si il n'y avait pas de saut de ligne.
		 */
		return pString;

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
		synchronized (DifferentiateurString.class) {
			
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
	 * method fournirNomClasseConcrete() :<br/>
	 * Retourne le nom de la classe concrète.<br/>
	 * <br/>
	 *
	 * @return : String : nom de la classe concrète.<br/>
	 */
	protected abstract String fournirNomClasseConcrete();
	
	
	
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
	private void loggerInfo(
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
	private void loggerInfo(
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
	private void loggerError(
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
	


} // FIN DE LA CLASSE AbstractEnregistreurFichiers.--------------------------
