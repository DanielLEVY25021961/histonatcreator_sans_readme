package levy.daniel.application.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;



/**
 * class HibernateUtil :<br/>
 * - Crée un Singleton de org.hibernate.SessionFactory capable
 * d'ouvrir de nouvelles org.hibernate.Session.<br/>
 * La SessionFactory se charge de lire le fichier hibernate.cfg.xml 
 * et d’initialiser Hibernate pour une utilisation ultérieure.<br/> 
 * La méthode getSession() utilise la sessionFactory pour créer 
 * une nouvelle session Hibernate chargée d' accéder 
 * à la base de données.<br/>
 * Une org.hibernate.Session est une unité de travail simplement 
 * threadée.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <br/>
 *
 * - Mots-clé :<br/>
 * Bloc static,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author Developpement
 * @version 1.0
 * @since 18 avr. 2011
 *
 */
public final class HibernateUtil {

	// ---------------------ATTRIBUTS------------------------------------ /
	
	/**
	 * CLASSE_HIBERNATEUTIL : String :<br/>
	 * "Classe HibernateUtil - ".<br/>
	 */
	public static final String CLASSE_HIBERNATEUTIL 
		= "Classe HibernateUtil - ";

	
	/**
	 * BLOC_STATIC : String :<br/>
	 * "Bloc Static assurant la lecture 
	 * de la configuration Hibernate - ".<br/>
	 */
	public static final String BLOC_STATIC 
		= "Bloc Static assurant la lecture de la configuration Hibernate - ";
	
	
	/**
	 * SESSION_FACTORY : SessionFactory :<br/>
	 * org.hibernate.SessionFactory.<br/>
	 * Lit la configuration d'accès à la base stockée
	 * dans hibernate.config.xml une fois pour toutes
	 * lors du premier accès à la base.<br/>
	 */
	private static final SessionFactory SESSION_FACTORY;

	
	/**
	 * SESSION : ThreadLocal&lt;Session&gt; :<br/>
	 * ThreadLocal encapsulant une org.hibernate.Session.<br/>
	 */
	private static final ThreadLocal<Session> SESSION 
		= new ThreadLocal<Session>();

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(HibernateUtil.class);
	
	
	static {
		
		try {
			
			/* Création d'une SessionFactory 
			 * à partir de Hibernate.cfg.xml. */
			SESSION_FACTORY 
				= new Configuration().configure().buildSessionFactory();
			
		} catch (HibernateException hibEx) {
						
			throw new RuntimeException("Problème de Configuration : " 
					+ hibEx.getMessage(), hibEx);
		
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	} // Fin du bloc static___________________________
	


	// -----------------------METHODES----------------------------------- /

	
	/**
	 * method CONSTRUCTEUR HibernateUtil() :
	 * Constructeur private pour empêcher l'instanciation.
	 *
	 */
	private HibernateUtil() {
		super();
	} // Fin de CONSTRUCTEUR HibernateUtil().________________________________
	
	
	
	/**
	 * method currentSession():<br/>
	 * Retourne la org.hibernate.Session courante
	 * (Singleton) ou en ouvre une nouvelle.<br/>
	 * 
	 * @return mySession : Session.<br/>
	 * 
	 * @throws HibernateException lorsque :
	 * la org.hibernate.Session n'a pu être ouverte.<br/>
	 */
	public static Session currentSession() 
					throws HibernateException {
		
		Session mySession = SESSION.get();
		
		/* Ouvre une nouvelle SESSION si ce Thread n'en  
		 * a aucune.*/
		if (mySession == null) {
			mySession = SESSION_FACTORY.openSession();
			SESSION.set(mySession);
		}
		
		return mySession;
		
	} // Fin de currentSession()._________________________
	

		
	/**
	 * method closeSession() :<br/>
	 * Ferme la org.hibernate.Session courante.<br/>
	 * 
	 * @throws HibernateException lorsque :
	 * la org.hibernate.Session n'a pu être fermée.<br/>
	 */
	public static void closeSession() 
					throws HibernateException {
		
		final Session mySession = SESSION.get();
		SESSION.set(null);
		
		if (mySession != null) {
			mySession.close();
		}
		
	} // Fin de closeSession().____________________________________________


		
	/**
	 * method logStatistics(
	 * Statistics pStatistics) :<br/>
	 * Logge les statistiques Hibernate.<br/>
	 * <br/>
	 *
	 * @param pStatistics : Statistics.<br/>
	 */
	public static void logStatistics(
			final Statistics pStatistics) {
		
		if (pStatistics == null) {
			return;
		}
		
		long sessionOpenedCount = 0;
		long sessionClosedCount = 0;
		
		long transactionCount = 0;
		long transactionSuccessfulCount = 0;
		
		long flushCount = 0;
		
		long prepareStatementCount = 0;
		long closeStatementCount = 0;
		
		
		/* Elaboration des messages. */
		final String messageSessionOpenedCount 
			= "Nombre de sessions Hibernate ouvertes (getSessionOpenCount()) : ";
		final String messageSessionClosedCount 
		= "Nombre de sessions Hibernate fermées (getSessionCloseCount()) : ";
		
		final String messageTransactionCount 
			= "Nombre de transactions démarrées (getTransactionCount()) : ";
		final String messageTransactionSuccessfulCount 
			= "Nombre de transactions committées (getSuccessfulTransactionCount()) : ";
		
		final String messageFlushCount 
			= "Nombre de Flushes (getFlushCount()) : ";
		
		final String messagePreparedStmts 
			= "Nombre de Prepared Statements ouverts (getPrepareStatementCount()) : ";
		final String messageCloseStmts 
			= "Nombre de Prepared Statements fermés (getCloseStatementCount()) : ";
		
		/* Calcul des statistiques Hibernate. */
		sessionOpenedCount = pStatistics.getSessionOpenCount();
		sessionClosedCount = pStatistics.getSessionCloseCount();
		
		transactionCount = pStatistics.getTransactionCount();
		transactionSuccessfulCount = pStatistics.getSuccessfulTransactionCount();
		
		flushCount = pStatistics.getFlushCount();
		
		prepareStatementCount = pStatistics.getPrepareStatementCount();
		closeStatementCount = pStatistics.getCloseStatementCount();
		
		if (LOG.isTraceEnabled()) {
			
			LOG.trace(messageSessionOpenedCount + sessionOpenedCount);
			LOG.trace(messageSessionClosedCount + sessionClosedCount);
			
			LOG.trace(messageTransactionCount + transactionCount);
			LOG.trace(messageTransactionSuccessfulCount + transactionSuccessfulCount);
			
			LOG.trace(messageFlushCount + flushCount);
			
			LOG.trace(messagePreparedStmts + prepareStatementCount);
			LOG.trace(messageCloseStmts + closeStatementCount);
		}
		
		
	} // Fin de logStatistics(
	 // Statistics pStatistics).___________________________________________

	
	
	/**
	 * method getSessionFactory() :<br/>
	 * Getter de la SessionFactory.<br/>
	 * <br/>
	 *
	 * @return SESSION_FACTORY : SessionFactory.<br/>
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	} // Fin de getSessionFactory()._______________________________________

	
		
} // FIN DE LA CLASSE.-----------------------------------------------------
