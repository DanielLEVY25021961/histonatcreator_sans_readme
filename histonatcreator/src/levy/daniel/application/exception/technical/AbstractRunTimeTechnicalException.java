package levy.daniel.application.exception.technical;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class AbstractRunTimeTechnicalException :<br/>
 * CLASSE ABSTRAITE factorisant tous les comportements des
 * Exceptions Techniques que l'on ne veut pas catcher
 * et qui ne seront lancées qu'à l'execution.<br/>
 * Toutes ces Exceptions doivent partager un conteneur
 * unique (List&lt;String&gt;) pour leurs messages afin de pouvoir 
 * afficher en une seule fois à l'internaute la liste des 
 * Exceptions non catchées.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <br/>
 *
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author Levy Lévy
 * @version 1.0
 * @since 24 juin 2011
 *
 */
public abstract class AbstractRunTimeTechnicalException extends
		RuntimeException {


	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * listeExceptions : List<String> : 
	 * Liste de messages de violation de règles techniques.<br />
	 * Utile pour afficher en une seule fois l'ensemble des règles violées.
	 */
	protected static List<String> listeExceptions;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(AbstractRunTimeTechnicalException.class);

	// *************************METHODES************************************/
	

	/**
	 * method CONSTRUCTEUR AbstractTechnicalException() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * Permet de construire une AbstractTechnicalException
	 * sans message ni propagation d'exception cause.<br/>
	 *
	 */
	public AbstractRunTimeTechnicalException() {
		
		super();
		
		/* N'instancie la listeExceptions que
		 * si ce n'est pas déjà fait. */
		if (listeExceptions == null) {
			listeExceptions = new ArrayList<String>();
		}
		
		/* Ajout de la présente Exception
		 * dans la liste listeExceptions. */
		this.addException();
		
	} // Fin de AbstractRunTimeTechnicalException(.________________________
	


	/**
	 * method CONSTRUCTEUR AbstractRunTimeTechnicalException(
	 * String pMessage) :<br/>
	 * Constructeur d'arité 1.<br/>
	 * Permet de construire une AbstractRunTimeTechnicalException
	 * qui propage un message.<br/>
	 *
	 * @param pMessage : String : le message à propager.
	 */
	public AbstractRunTimeTechnicalException(final String pMessage) {
		
		super(pMessage);
		
		/* N'instancie la listeExceptions que
		 * si ce n'est pas déjà fait. */
		if (listeExceptions == null) {
			listeExceptions = new ArrayList<String>();
		}
		
		/* Ajout de la présente Exception
		 * dans la liste listeExceptions. */
		this.addException();
		
	} // Fin de CONSTRUCTEUR AbstractRunTimeTechnicalException(
	// String pMessage).___________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR AbstractRunTimeTechnicalException(
	 * Throwable pCause) :<br/>
	 * Constructeur d'arité 1.<br/>
	 * Permet de construire une AbstractRunTimeTechnicalException
	 * qui propage un Throwable qui a causé la présente
	 * exception.<br/>
	 *
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public AbstractRunTimeTechnicalException(final Throwable pCause) {
		
		super(pCause);
		
		/* N'instancie la listeExceptions que
		 * si ce n'est pas déjà fait. */
		if (listeExceptions == null) {
			listeExceptions = new ArrayList<String>();
		}
		
		/* Ajout de la présente Exception
		 * dans la liste listeExceptions. */
		this.addException();
		
	} // Fin de CONSTRUCTEUR AbstractRunTimeTechnicalException(
	// Throwable pCause).__________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR AbstractRunTimeTechnicalException(
	 * String pMessage
	 * , Throwable pCause) :<br/>
	 * Constructeur d'arité 2.<br/>
	 * Permet de construire une AbstractRunTimeTechnicalException
	 * qui propage :<br/>
	 * - un message,<br/>
	 * - un Throwable qui a causé la présente
	 * exception.<br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public AbstractRunTimeTechnicalException(
			final String pMessage, final Throwable pCause) {
		
		super(pMessage, pCause);
		
		/* N'instancie la listeExceptions que
		 * si ce n'est pas déjà fait. */
		if (listeExceptions == null) {
			listeExceptions = new ArrayList<String>();
		}
		
		/* Ajout de la présente Exception
		 * dans la liste listeExceptions. */
		this.addException();
		
	} // Fin de CONSTRUCTEUR AbstractRunTimeTechnicalException(
	 // String pMessage, Throwable pCause).________________________________

	
	
	/**
	 * method CONSTRUCTEUR AbstractRunTimeTechnicalException(
	 * String pMessage
	 * , Throwable pCause
	 * , List<String> pListeExceptions) :<br/>
	 * Constructeur d'arité 3.<br/>
	 * Permet de construire une AbstractRunTimeTechnicalException
	 * qui propage :<br/>
	 * - un message,<br/>
	 * - un Throwable qui a causé la présente
	 * exception.<br/>
	 * - Une liste de String susceptible d'encapsuler
	 * le message de la présente Exception.<br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 * @param pListeExceptions : Liste dans laquelle on veut
	 * insérer le message de la présente Exception.<br/>
	 */
	public AbstractRunTimeTechnicalException(
			final String pMessage
				, final Throwable pCause
					, final List<String> pListeExceptions) {
		
		this(pMessage, pCause);
		
		/* Ne passe la pListeExceptions en paramètre que
		 * si listeExceptions n'existait pas déjà en attribut. */
		if (listeExceptions == null) {
			listeExceptions = pListeExceptions;
		}
		
		/* Ajout de la présente Exception
		 * dans la liste listeExceptions. */
		this.addException();
		
	} // Fin de CONSTRUCTEUR AbstractRunTimeTechnicalException(
	 // String pMessage
	 // , Throwable pCause
	 // , List<String> pListeExceptions).__________________________________
	
	
	
	/**
	 * method addException() :<br/>
	 * Ajoute le message de la présente Exception
	 * à la liste des Exceptions.<br/>
	 * 
	 */
	public final void addException() {

		if (listeExceptions != null) {

			final StringBuffer stb = new StringBuffer();

			stb.append("\nprésente Exception : ");
			stb.append(this.getClass());
			if (this.getCause() != null) {
				stb.append("\ncausée par : ");
				stb.append(this.getCause().getClass());
			}
			stb.append("\n - ");
			stb.append(this.getMessage());

			listeExceptions.add(stb.toString());
		}
		
	} // Fin de addException().____________________________________________
	
	
	
	/**
	 * method getListeExceptions() :<br/>
	 * Retourne la liste des Exceptions.<br/>
	 * 
	 * @return listeExceptions : List&lt;String&gt;<br/>
	 */
	public final List<String> getListeExceptions() {
		return listeExceptions;
	} // Fin de getListeExceptions().______________________________________


	
	/**
	 * method listeExceptionsToString() :<br/>
	 * Construit une String pour l'affichage de
	 * la liste des messages des Exceptions avec
	 * passages à la ligne.<br/>
	 * - Retourne une String vide si la liste est null
	 * ou vide.<br/>
	 * 
	 * @return String
	 */
	public final String listeExceptionsToString() {
		
		if (listeExceptions == null 
				|| listeExceptions.isEmpty()) {
			return "";
		}
					
		final StringBuffer stb = new StringBuffer();
		stb.append('\n');
		
		for (final String message : listeExceptions) {
			
			stb.append(message);
			stb.append('\n');
		
		}
		
		return stb.toString();
					
	} // Fin de listeExceptionsToString()._________________________________
	

	
} // FIN DE LA CLASSE AbstractRunTimeTechnicalException.---------------------
