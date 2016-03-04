package levy.daniel.application.metier.controles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.metier.controles.rapportscontroles.LigneRapport;


/**
 * class AbstractControle :<br/>
 * Abstraction qui garantit que :<br/>
 * - Tout contrôle est effectué à une 'dateContrôle'. 
 * La classe calcule automatiquement 'dateControleStringFormatee' 
 * connaissant dateControle.<br/>
 * - Tout contrôle est effectué par un utilisateur (user) 
 * dont on connait le nom 'userName'. La classe remplit automatiquement 
 * userName avec 'Administrateur' si on ne lui fournit pas de userName.<br/>
 * - Tout contrôle s'applique sur un File 'fichier'. 
 * La classe calcule automatiquement 'nomFichier' connaissant fichier.<br/>
 * - Tout contrôle appartient à un type de contrôle 'typeControle' 
 * comme "contrôle de surface". 
 * 'typeControle' est fourni par chaque classe concrète.<br/>
 * - Tout contrôle a un nom 'nomControle' comme 'contrôle fichier texte'. 
 * 'nomControle' est fourni par chaque classe concrète.<br/>
 * - Tout contrôle vérifie un critère 'nomCritere' comme 
 * 'le fichier ne doit pas comporter de caractères indésirables'. 
 * 'nomCritere' est fourni par chaque classe concrète.<br/>
 * - Tout contrôle a une gravité 'gravite' comme '1 - bloquant'. 
 * Cette gravité est directement liée au niveau d'anomalie du contrôle 
 * 'niveauAnomalie' comme "1" pour bloquant. 
 * Chaque classe concrète fournit le 'niveauAnomalie' du contrôle 
 * via sa méthode fournirCleNiveauAnomalie() qui permet d'aller 
 * chercher la valeur dans messagescontroles_fr_FR.properties 
 * ou via fournirNiveauAnomalieEnDur().<br/>
 * - Tout contrôle sait si il est bloquant via 'estBloquant'. 
 * La classe remplit automatiquement 'estBloquant' 
 * connaissant niveauAnomalie.<br/>
 * - Tout contrôle fournit un rapport de contrôle 
 * sous forme de List&lt;LigneRapport&gt; 'rapport'.<br/>
 * <br/>
 * <br/>
 * Attributs : <br/>
 * [nomClasseConcrete;dateControle;dateControleStringFormatee;userName;
 * fichier;nomFichier;typeControle;nomControle;nomCritere;gravite;
 * niveauAnomalie;estBloquant;rapport].<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Nettoyer chaine de caractères, nettoyer String, <br/>
 * StringUtils.trim(resultat), trim(), nettoyer valeurs dans properties<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * levy.daniel.application.ILecteurDecodeurFile.<br/>
 * levy.daniel.application.IListeurDeCaracteresUnicode.<br/>
 * levy.daniel.application.IExportateurCsv.<br/>
 * levy.daniel.application.IExportateurJTable.<br/>
 * levy.daniel.application.IResetable.<br/>
 * levy.daniel.application.metier.controles.rapportscontroles.LigneRapport.<br/>
 * levy.daniel.application.metier.controles.IRapporteurControle.<br/>
 * levy.daniel.application.metier.controles.IControle.<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 27 févr. 2016
 *
 */
public abstract class AbstractControle implements IControle {

	// ************************ATTRIBUTS************************************/

	/**
	 * nomClasseConcrete : String :<br/>
	 * nom de la classe de contrôle concrète.<br/>
	 */
	protected transient String nomClasseConcrete;

	
	/**
	 * dateControle : Date :<br/>
	 * java.util.Date du contrôle.<br/>
	 */
	protected Date dateControle;

	
	/**
	 * dateControleStringFormatee : String :<br/>
	 * date du contrôle formattée au format dfDatetimemilliFrancaise.<br/>
	 * Format des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 */
	protected transient String dateControleStringFormatee;
	
	
	/**
	 * userName : String :<br/>
	 * nom de l'utilisateur qui a déclenché le contrôle.<br/>
	 */
	protected String userName;

	
	/**
	 * fichier : File :<br/>
	 * fichier sur lequel s'applique le contrôle.<br/>
	 */
	protected File fichier;

	
	/**
	 * nomFichier : String :<br/>
	 * nom du fichier objet du contrôle.<br/>
	 */
	protected transient String nomFichier;
	
	
	/**
	 * typeControle : String :<br/>
	 * type du contrôle ('contrôle de surface' par exemple).<br/>
	 */
	protected transient String typeControle;

	
	/**
	 * nomControle : String :<br/>
	 * nom du contrôle ('contrôle fichier texte' par exemple).<br/>
	 */
	protected transient String nomControle;

	
	/**
	 * nomCritere : String :<br/>
	 * nom du critère appliqué dans le contrôle 
	 * ('le fichier ne doit pas comporter de 
	 * caractères indésirables' par exemple).<br/>
	 */
	protected transient String nomCritere;
	
	
	/**
	 * gravite : String :<br/>
	 * désignation de la gravité de ce contrôle 
	 * (par exemple '1 - bloquant').<br/>
	 */
	protected transient String gravite;

	
	/**
	 * niveauAnomalie : String : <br/>
	 * Niveau de l'anomalie correspondant au Contrôle
	 * dans le messagescontroles_fr_FR.properties.<br/>
	 * Par exemple : "1" pour le ControleurTypeTexte.<br/>
	 */
	protected transient String niveauAnomalie;
	

	/**
	 * estBloquant : boolean :<br/>
	 * boolean qui stipule si le contrôle doit pouvoir 
	 * bloquer le programme.<br/>
	 */
	protected transient boolean estBloquant;
	
	
	/**
	 * rapport : List&lt;LigneRapport&gt; :<br/>
	 * rapport fourni par le contrôle sous forme 
	 * de List&lt;LigneRapport&gt;.<br/>
	 */
	protected transient List<LigneRapport> rapport 
		= new ArrayList<LigneRapport>();
	

	/**
	 * CLASSE_ABSTRACTCONTROLE : String :<br/>
	 * "Classe AbstractControle".<br/>
	 */
	public static final String CLASSE_ABSTRACTCONTROLE 
		= "Classe AbstractControle";
	
	/**
	 * METHODE_INITIALISER_BUNDLE_CONTROLES : String :<br/>
	 * "méthode initialiserBundleControles()".<br/>
	 */
	public static final String METHODE_INITIALISER_BUNDLE_CONTROLES 
		= "méthode initialiserBundleControles()";
	
	
	/**
	 * METHODE_RECUPERERNIVEAUANOMALIEDANSPROPERTIES : String :<br/>
	 * "Méthode recupererNiveauAnomalieDansProperties()".<br/>
	 */
	public static final String METHODE_RECUPERERNIVEAUANOMALIEDANSPROPERTIES 
		= "Méthode recupererNiveauAnomalieDansProperties()";

	
	/**
	 * METHODE_FOURNIRDATEAPARTIRDESTRING : String :<br/>
	 * "Méthode fournirDateAPartirDeStringFormattee(String pStringFormattee)".<br/>
	 */
	public static final String METHODE_FOURNIRDATEAPARTIRDESTRING 
		= "Méthode fournirDateAPartirDeStringFormattee(String pStringFormattee)";
	
	
	/**
	 * dfDatetimemilliFrancaise : DateFormat :<br/>
	 * Format des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 */
	public final transient DateFormat dfDatetimemilliFrancaise 
	= new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss.SSS", LOCALE_FR_FR);

	
	/**
	 * bundleControles : ResourceBundle :<br/>
	 * Encapsulation de messagescontroles_fr_FR.properties.<br/>
	 */
	public static ResourceBundle bundleControles;
	
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(AbstractControle.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractControle() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 * - Met automatiquement dateControle à date système.<br/>
	 * - Met automatiquement userName à "Administrateur".<br/>
	 * - Met automatiquement fichier à null.<br/>
	 * <br/>
	 * - Remplit le nom de la classe concrète this.nomClasseConcrete fourni 
	 * par this.fournirNomClasseConcrete() dans la classe concrète.<br/>
	 * - calcule automatiquement dateControleStringFormattee.<br/>
	 * - calcule automatiquement nomFichier.<br/>
	 * - Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.<br/>
	 * - Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.<br/>
	 * - Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.<br/>
	 * - Remplit gravite (ce qui remplit également niveauAnomalie 
	 * et estBloquant).<br/>
	 * <br/>
	 */
	public AbstractControle() {
		
		this(null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	 /**
	 * method CONSTRUCTEUR AbstractControle(
	 * File pFichier) :<br/>
	 * Constructeur avec fichier.<br/>
	 * <br/>
	 * - Met automatiquement dateControle à date système.<br/>
	 * - Met automatiquement userName à "Administrateur".<br/>
	 * <br/>
	 * - Remplit le nom de la classe concrète this.nomClasseConcrete 
	 * fourni par this.fournirNomClasseConcrete() dans la classe concrète.<br/>
	 * - calcule automatiquement dateControleStringFormattee.<br/>
	 * - calcule automatiquement nomFichier.<br/>
	 * - Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.<br/>
	 * - Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.<br/>
	 * - Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.<br/>
	 * - Remplit gravite (ce qui remplit également niveauAnomalie 
	 * et estBloquant).<br/>
	 * <br/>
	 *
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 */
	public AbstractControle(
			final File pFichier) {
		
		this(null, null, pFichier);
		
	} // Fin de AbstractControle(
	 // File pFichier).____________________________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractControle(
	 * String pUserName
	 * , File pFichier) :<br/>
	 * Constructeur avec user et fichier.<br/>
	 * <br/>
	 * - Met automatiquement dateControle à date système.<br/>
	 * <br/>
	 * - Remplit le nom de la classe concrète this.nomClasseConcrete 
	 * fourni par this.fournirNomClasseConcrete() dans la classe concrète.<br/>
	 * - calcule automatiquement dateControleStringFormattee.<br/>
	 * - remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.<br/>
	 * - calcule automatiquement nomFichier.<br/>
	 * - Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.<br/>
	 * - Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.<br/>
	 * - Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.<br/>
	 * - Remplit gravite (ce qui remplit également niveauAnomalie 
	 * et estBloquant).<br/>
	 * <br/>
	 *
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/> 
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 */
	public AbstractControle(
			final String pUserName
					, final File pFichier) {
		
		this(null, pUserName, pFichier);
		
	} // Fin de AbstractControle(
	 // String pUserName
	 // , File pFichier).__________________________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractControle(COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 * - Remplit le nom de la classe concrète this.nomClasseConcrete fourni 
	 * par this.fournirNomClasseConcrete() dans la classe concrète.<br/>
	 * - Remplit dateControle avec pDateControle si pDateControle != null 
	 * ou la date système sinon.<br/>
	 * - calcule automatiquement dateControleStringFormattee.<br/>
	 * - remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.<br/>
	 * - calcule automatiquement nomFichier.<br/>
	 * - Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.<br/>
	 * - Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.<br/>
	 * - Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.<br/>
	 * - Remplit gravite (ce qui remplit également niveauAnomalie 
	 * et estBloquant).<br/>
	 * <br/>
	 *
	 * @param pDateControle : Date : java.util.Date du contrôle.<br/>
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/> 
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 */
	public AbstractControle(
			final Date pDateControle
				, final String pUserName
					, final File pFichier) {
		
		super();
		
		/* initialise le bundleControles qui encapsule 
		 * messagescontroles_fr_FR.properties. */
		initialiserBundleControles();
		
		/* Remplit le nom de la classe concrète this.nomClasseConcrete 
		 * fourni par this.fournirNomClasseConcrete() 
		 * dans la classe concrète. */
		this.nomClasseConcrete = this.fournirNomClasseConcrete();
		
		/* Remplit dateControle avec pDateControle si pDateControle != null 
		 * ou la date système sinon. */
		this.dateControle = this.fournirDate(pDateControle);
		
		/* calcule automatiquement dateControleStringFormattee. */
		this.dateControleStringFormatee 
			= this.fournirDateFormattee(this.dateControle);
		
		/* remplit userName avec pUserName si pUserName != null 
		 * ou 'Administrateur' sinon. */
		this.userName = this.fournirUserName(pUserName);
		
		/* passe pFichier à this.fichier. */
		this.fichier = pFichier;
		
		/* calcule automatiquement nomFichier. */
		this.nomFichier = this.fournirNomFichier(this.fichier);
		
		/* Remplit le type du contrôle typeControle fourni 
		 * par this.fournirTypeControle() dans la classe concrète. */
		this.typeControle = this.fournirTypeControle();
		
		/* Remplit le nom du contrôle nomControle fourni 
		 * par this.fournirNomControle() dans la classe concrète. */
		this.nomControle = this.fournirNomControle();
		
		/* Remplit le nom du critère nomCritere fourni 
		 * par this.fournirNomCritere() dans la classe concrète. */
		this.nomCritere = this.fournirNomCritere();
		
		/* Remplit gravite (ce qui remplit également niveauAnomalie 
		 * et estBloquant). */
		this.gravite = this.fournirGravite();
				
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean controler(
			final File pFile);

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean controler(
			final String pString);
	
	

	/**
	 * method initialiserBundleControles() :<br/>
	 * Initialise bundleControles qui encapsule 
	 * messagescontroles_fr_FR.properties.<br/>
	 * <br/>
	 * - retourne sans rien faire et LOG de niveau INFO 
	 * si messagescontroles_fr_FR.properties est manquant.<br/>
	 * <br/>
	 */
	private static void initialiserBundleControles() {
		
		/* Bloc static synchronized. */
		synchronized (AbstractControle.class) {
			
			if (bundleControles == null) {
				
				try {
					
					/*
					 * Charge le ResourceBundle encapsulant
					 * messagescontroles_fr_FR.properties
					 */
					bundleControles = ResourceBundle.getBundle(
							"messagescontroles", LOCALE_FR_FR);
					
					
				} catch (MissingResourceException mre) {
					
					final String message 
						= "messagescontroles_fr_FR.properties manquant "
								+ "sous la racine du projet (bin) : " 
								+ mre.getMessage();
					
					/* LOG de niveau INFO. */
					if (LOG.isInfoEnabled()) {
						
						final String messageLog = CLASSE_ABSTRACTCONTROLE 
								+ SEP_MOINS 
								+ METHODE_INITIALISER_BUNDLE_CONTROLES 
								+ SEP_MOINS 
								+ message;
						
						LOG.info(messageLog, mre);
					}
									
					/* retourne sans rien faire et LOG de niveau INFO 
					 * si messagescontroles_fr_FR.properties est manquant. */
					return;
					
				} 
				
			} // Fin de if (bundleControles == null).____________________
						
		} // Fin du bloc static synchronized.___________
				
	} // Fin de initialiserBundleControles().______________________________


	
	/**
	 * method fournirDateSystemeFormattee() :<br/>
	 * Retourne la date système au format DF_DATETIMEMILLI_FRANCAISE
	 * des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>.<br/>
	 * <br/>
	 *
	 * @return : String : la date système au format 
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 */
	public static String fournirDateSystemeFormattee() {
		
		return fournirDateStringFormattee(new Date());
		
	} // Fin de fournirDateSystemeFormattee()._____________________________


	
	/**
	 * method fournirDateStringFormattee(
	 * Date pDate) :<br/>
	 * Retourne la date pDate au format DF_DATETIMEMILLI_FRANCAISE 
	 * des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 * <br/>
	 * - retourne null si pDate == null.<br/>
	 * <br/>
	 * 
	 * @param pDate : java.util.Date.<br/>
	 *
	 * @return : String : la date pDate au format 
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 */
	public static String fournirDateStringFormattee(
			final Date pDate) {
				
		/* Bloc static synchronized. */
		synchronized (AbstractControle.class) {
			
			/* retourne null si pDate == null. */
			if (pDate == null) {
				return null;
			}
			
			return DF_DATETIMEMILLI_FRANCAISE.format(pDate);
			
		} // Fin du bloc static synchronized.___________
		
	} // Fin de fournirDateStringFormattee(
	 // Date pDate)._______________________________________________________
	

	
	/**
	 * method fournirDateAPartirDeStringFormattee(
	 * String pDateFormattee) :<br/>
	 * Retourne une Java.util.Date à partir d'une String formattée 
	 * selon le format DF_DATETIMEMILLI_FRANCAISE
	 * des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 * <br/>
	 * - retourne null si pDateFormattee est blank.<br/>
	 * - retourne null et LOG de niveau INFO si
	 * la date passée en paramètre ne respecte pas le format 
	 * 'dd/MM/yyyy-HH:mm:ss.SSS'.<br/>
	 * <br/>
	 *
	 * @param pDateFormattee : String : String formattée 
	 * selon le format DF_DATETIMEMILLI_FRANCAISE
	 * des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * 
	 * @return : Date : java.util.Date.<br/>
	 */
	public static Date fournirDateAPartirDeStringFormattee(
			final String pDateFormattee) {
		
		/* Bloc static synchronized. */
		synchronized (AbstractControle.class) {
			
			/* retourne null si pDateFormattee est blank. */
			if (StringUtils.isBlank(pDateFormattee)) {
				return null;
			}
			
			Date resultat = null;
			
			try {
				
				resultat = DF_DATETIMEMILLI_FRANCAISE.parse(pDateFormattee);
				
			} catch (ParseException parseExc) {

				final String message 
				= "la date passée en paramètre ne respecte pas "
						+ "le format 'dd/MM/yyyy-HH:mm:ss.SSS' "
						+ pDateFormattee
						+ " - Exception : "
						+ parseExc.getMessage();

				/* LOG de niveau INFO. */
				if (LOG.isInfoEnabled()) {

					final String messageLog = CLASSE_ABSTRACTCONTROLE
							+ SEP_MOINS + METHODE_FOURNIRDATEAPARTIRDESTRING
							+ SEP_MOINS + message;

					LOG.info(messageLog, parseExc);
				}

				/*
				 * retourne null et LOG de niveau INFO si
				 * la date passée en paramètre ne respecte pas le format 
				 * 'dd/MM/yyyy-HH:mm:ss.SSS'.
				 */
				return null;
			}
			
			return resultat;
			
		} // Fin du bloc static synchronized.___________
		
	} // Fin de fournirDateAPartirDeStringFormattee(
	 // String pDateFormattee).____________________________________________
	
	
	
	/**
	 * method fournirNomClasseConcrete() :<br/>
	 * Retourne le nom de la classe concrète de contrôle.<br/>
	 * <br/>
	 *
	 * @return : String : nom de la classe concrète de contrôle.<br/>
	 */
	protected abstract String fournirNomClasseConcrete();
	

	
	/**
	 * method fournirDate(
	 * Date pDate) :<br/>
	 * - retourne la date système si pDate == null.<br/>
	 * - retourne pDate sinon.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * @return : Date : date système ou pDate.<br/>
	 */
	private Date fournirDate(
			final Date pDate) {
		
		/* retourne la date système si pDate == null. */
		if (pDate == null) {
			return new Date();
		}
		
		/* retourne pDate sinon. */
		return pDate;
		
	} // Fin de fournirDate(
	 // Date pDate)._______________________________________________________
	

	
	/**
	 * method fournirDateFormattee(
	 * Date pDate) :<br/>
	 * Fournit une date sous forme de String formattée 
	 * au format dfDatetimemilliFrancaise.<br/>
	 * Format des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 * <br/>
	 * - retourne null si pDate == null.<br/>
	 * <br/>
	 *
	 * @param pDate
	 * @return : String : "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 */
	private String fournirDateFormattee(
			final Date pDate) {
		
		/* retourne null si pDate == null. */
		if (pDate == null) {
			return null;
		}
		
		final String dateFormattee 
			= this.dfDatetimemilliFrancaise.format(pDate);
		
		return dateFormattee;
		
	} // Fin de fournirDateFormattee(
	 // Date pDate)._______________________________________________________
	
	
	
	/**
	 * method fournirUserName(
	 * String pUserName) :<br/>
	 * - retourne 'Administrateur' si pUsername == null.<br/>
	 * - retourne pUserName sinon.<br/>
	 * <br/>
	 *
	 * @param pUserName
	 * @return : String :  .<br/>
	 */
	private String fournirUserName(
			final String pUserName) {
		
		/* retourne 'Administrateur' si pUsername == null. */
		if (pUserName == null) {
			return "Administrateur";
		}
		
		/* retourne pUserName sinon. */
		return pUserName;
		
	} // Fin de fournirUserName(
	 // String pUserName)._________________________________________________
	

	
	/**
	 * method fournirNomFichier(
	 * File pFile) :<br/>
	 * retourne le nom de pFile.<br/>
	 * <br/>
	 * - retourne null si pFile == null.<br/>
	 * <br/>
	 *
	 * @param pFile : File.<br/>
	 * 
	 * @return : String : nom du fichier.<br/>
	 */
	private String fournirNomFichier(
			final File pFile) {
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* retourne le nom de pFile. */
		return pFile.getName();
		
	} // Fin de fournirNomFichier(
	 // File pFile)._______________________________________________________
	
	
	
	/**
	 * method fournirTypeControle() :<br/>
	 * Assure que toutes les classes concrètes fourniront un typeControle.<br/>
	 * <br/>
	 *
	 * @return : String : typeControle.<br/>
	 */
	protected abstract String fournirTypeControle();

	
	
	/**
	 * method fournirNomControle() :<br/>
	 * Assure que toutes les classes concrètes fourniront un nomControle.<br/>
	 * <br/>
	 *
	 * @return : String : nomControle.<br/>
	 */
	protected abstract String fournirNomControle();
	
	
	/**
	 * method fournirNomCritere() :<br/>
	 * Assure que toutes les classes concrètes fourniront un nomCritere.<br/>
	 * <br/>
	 *
	 * @return : String : nomCritere.<br/>
	 */
	protected abstract String fournirNomCritere();

	
	
	/**
	 * method fournirGravite() :<br/>
	 * - remplit this.niveauAnomalie.<br/>
	 * - remplit this.estBloquant.
	 * - Constitue la clé de la gravité (label) 
	 * de l'anomalie dans messagescontroles_fr_FR.properties 
	 * comme "label.niveau1".<br/>
	 * Retourne le label associé au niveau d'anomalie
	 * dans messagescontroles_fr_FR.properties.<br/>
	 * Par exemple :<br/>
	 * - label.niveau0 = 0 - indéfini,<br/>
	 * - label.niveau1 = 1 - anomalie bloquante<br/>
	 * <br/>
	 * - retourne null si la clé n'est pas trouvée.<br/>
	 * <br/>
	 *
	 * @return : String : la gravité (label du niveau de l'anomalie).<br/>
	 */
	private String fournirGravite() {
		
		/* remplit this.niveauAnomalie. */
		this.niveauAnomalie = this.fournirNiveauAnomalie(null);
		
		/* remplit this.estBloquant. */
		this.estBloquant = this.fournirEstBloquant(this.niveauAnomalie);
		
		/* Constitue la clé de la gravité (label) 
		 * de l'anomalie dans messagescontroles_fr_FR.properties. */
		final String cleLabelAnomalie = "label.niveau" + this.niveauAnomalie;
		
		/* Retourne le label associé au niveau d'anomalie
		 * dans messagescontroles_fr_FR.properties si il existe.*/
		if (bundleControles.containsKey(cleLabelAnomalie)) {
			return bundleControles.getString(cleLabelAnomalie);
		}
		
		/* retourne null si la clé n'est pas trouvée. */
		return null;		
		
	} // Fin de fournirGravite().__________________________________________

	
	
	/**
	 * method fournirNiveauAnomalie(
	 * String pNiveauAnomalie) :<br/>
	 * - retourne pNiveauAnomalie si pNiveauAnomalie != null.<br/>
	 * - Sinon, récupère niveauAnomalie dans 
	 * messagescontroles_fr_FR.properties et le retourne si il existe.<br/>
	 * - Sinon, retourne le niveau d'anomalie du contrôle 
	 * stocké en dur dans la classe concrète.<br/>
	 * <br/>
	 *
	 * @param pNiveauAnomalie : String : niveau d'anomalie 
	 * comme "1" pour bloquant.<br/>
	 * 
	 * @return : String : le niveau d'anomalie du contrôle.<br/>
	 */
	private String fournirNiveauAnomalie(
			final String pNiveauAnomalie) {
		
		/* retourne pNiveauAnomalie si pNiveauAnomalie != null. */
		if (pNiveauAnomalie != null) {
			return pNiveauAnomalie;
		}
		
		/* Sinon, récupère niveauAnomalie dans 
		 * messagescontroles_fr_FR.properties et le retourne si il existe. */
		final String niveauAnomalieDansProperties 
			= this.recupererNiveauAnomalieDansProperties();
		
		if (niveauAnomalieDansProperties != null) {
			return niveauAnomalieDansProperties;
		}
		
		/* Sinon, retourne le niveau d'anomalie du contrôle 
		 * stocké en dur dans la classe concrète. */
		return this.fournirNiveauAnomalieEnDur();
		
	} // Fin de fournirNiveauAnomalie(
	 // String pNiveauAnomalie).___________________________________________
	

	
	/**
	 * method fournirEstBloquant(
	 * String pNiveauAnomalie) :<br/>
	 * Décide si le contrôle est bloquant 
	 * en fonction de son niveauAnomalie.<br/>
	 * <br/>
	 * - retourne true si pNiveauAnomalie nettoyé vaut "1".<br/>
	 * - retourne false sinon.<br/>
	 * <br/>
	 * - retourne false si pNiveauAnomalie est blank.<br/>
	 * <br/>
	 *
	 * @param pNiveauAnomalie : String : "1" pour bloquant.<br/>
	 * 
	 * @return : boolean : true si le contrôle est bloquant.<br/>
	 */
	private boolean fournirEstBloquant(
			final String pNiveauAnomalie) {
		
		/* retourne false si pNiveauAnomalie est blank. */
		if (StringUtils.isBlank(pNiveauAnomalie)) {
			return false;
		}
		
		/* retourne true si pNiveauAnomalie nettoyé vaut "1". */
		if (StringUtils.equals("1", StringUtils.trim(pNiveauAnomalie))) {
			return true;
		}
		
		/* retourne false sinon. */
		return false;
		
	} // Fin de fournirEstBloquant(
	 // String pNiveauAnomalie).___________________________________________
	
	
	
	/**
	 * method recupererNiveauAnomalieDansProperties() :<br/>
	 * récupère le niveau d'anomalie du contrôle dans 
	 * messagescontroles_fr_FR.properties.<br/>
	 * <br/>
	 * - Nettoie le niveau d'anomalie lu dans 
	 * messagescontroles_fr_FR.properties en retirant les éventuels blancs.<br/>
	 * <br/>
	 * - retourne null, LOG de niveau INFO et rapport 
	 * si bundleControles est null.<br/>
	 * - retourne null, LOG de niveau INFO et rapport 
	 * si messagescontroles_fr_FR.properties est manquant.<br/>
	 * - retourne null, LOG de niveau INFO et rapport 
	 * si messagescontroles_fr_FR.properties ne contient pas la clé.<br/>
	 * - retourne null, LOG de niveau INFO et rapport si
	 * messagescontroles_fr_FR.properties ne contient pas la valeur 
	 * associée à la clé.<br/>
	 * <br/>
	 *
	 * @return : String : niveauAnomalie.<br/>
	 */
	private String recupererNiveauAnomalieDansProperties() {

		String resultat = null;
		String resultatNettoye = null;
		
		try {
						
			/* récupère le niveau d'anomalie du contrôle 
			 * dans messagescontroles_fr_FR.properties. */
			if (bundleControles != null) {
				
				resultat 
				= bundleControles.getString(
						this.fournirCleNiveauAnomalie());
				
				/* Nettoie le niveau d'anomalie lu dans 
				 * messagescontroles_fr_FR.properties en retirant 
				 * les éventuels blancs. */
				resultatNettoye = StringUtils.trim(resultat);
				
			}
			
			/* retourne null, LOG de niveau INFO et rapport 
			 * si bundleControles est null.*/
			else {
				
				final String message 
					= "bundleControles est null (non initialisé)";
			
			/* LOG de niveau INFO. */
			loggerInfo(
					this.fournirNomClasseConcrete()
					, METHODE_RECUPERERNIVEAUANOMALIEDANSPROPERTIES
					, message);
			
			/* rapport. */
			final LigneRapport ligneRapport 
				= new LigneRapport(
						this.dateControleStringFormatee
						, this.userName
						, NULL
						, TOUS
						, TOUS
						, "bundleControles non initialisé"
						, SANS_OBJET
						, null
						, message
						, null
						, SANS_OBJET
						, SANS_OBJET
						, SANS_OBJET);
			
			this.ajouterLigneRapport(ligneRapport);
			
			/* retourne null, LOG de niveau INFO et rapport 
			 * si bundleControles est null. */
			return null;
			
			}
			
			
		} catch (MissingResourceException mre) {

			final String message = "La clé '"
					+ this.fournirCleNiveauAnomalie()
					+ "' n'existe pas dans  messagescontroles_fr_FR.properties : "
					+ mre.getMessage();

			/* LOG de niveau INFO. */
			loggerInfo(this.fournirNomClasseConcrete(),
					METHODE_RECUPERERNIVEAUANOMALIEDANSPROPERTIES, message);

			/* rapport. */
			final LigneRapport ligneRapport = new LigneRapport(
					this.dateControleStringFormatee,
					this.userName,
					NULL,
					this.typeControle,
					this.nomControle,
					"pas de clé ou valeur dans messagescontroles_fr_FR.properties",
					SANS_OBJET, null, message, null, SANS_OBJET, SANS_OBJET,
					SANS_OBJET);

			this.ajouterLigneRapport(ligneRapport);

			/*
			 * retourne null, LOG de niveau INFO et rapport si
			 * messagescontroles_fr_FR.properties ne contient pas la clé.
			 */
			return null;

		} 
		
		if (StringUtils.isBlank(resultatNettoye)) {
			
			final String message = "La valeur associée à La clé '"
					+ this.fournirCleNiveauAnomalie()
					+ "' n'existe pas dans  messagescontroles_fr_FR.properties";

			/* LOG de niveau INFO. */
			loggerInfo(this.fournirNomClasseConcrete(),
					METHODE_RECUPERERNIVEAUANOMALIEDANSPROPERTIES, message);

			/* rapport. */
			final LigneRapport ligneRapport = new LigneRapport(
					this.dateControleStringFormatee,
					this.userName,
					NULL,
					this.typeControle,
					this.nomControle,
					"pas de clé ou valeur dans messagescontroles_fr_FR.properties",
					SANS_OBJET, null, message, null, SANS_OBJET, SANS_OBJET,
					SANS_OBJET);

			this.ajouterLigneRapport(ligneRapport);

			/*
			 * retourne null, LOG de niveau INFO et rapport si
			 * messagescontroles_fr_FR.properties ne contient 
			 * pas la valeur associée à la clé.
			 */
			return null;
		}
		
		/* retourne le niveau d'anomalie 
		 * dans messagescontroles_fr_FR.properties. */
		return resultatNettoye;
		
	} // Fin de recupererNiveauAnomalieDansProperties().___________________
	

	
	/**
	 * method fournirCleNiveauAnomalie() :<br/>
	 * Retourne la clé du niveau d'anomalie du contrôle 
	 * dans messagescontroles_fr_FR.properties.<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * "ControleurTypeTexte.niveau.anomalie".<br/>
	 * <br/>
	 *
	 * @return : String : clé du niveau d'anomalie du contrôle 
	 * dans messagescontroles_fr_FR.properties.<br/>
	 */
	protected abstract String fournirCleNiveauAnomalie();
	

	
	/**
	 * method fournirNiveauAnomalieEnDur() :<br/>
	 * Retourne le niveau d'anomalie du contrôle 
	 * stocké en dur dans la classe concrète.<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * "1" pour un contrôle bloquant.<br/>
	 * <br/>
	 *
	 * @return : String : niveau d'anomalie du contrôle stocké en dur 
	 * dans la classe concrète.<br/>
	 */
	protected abstract String fournirNiveauAnomalieEnDur();
	
	
	
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
	protected final void loggerInfo(
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
	protected final void loggerInfo(
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
	protected final void loggerError(
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
	 * method ajouterLigneRapport(
	 * LigneRapport pLigneRapport) :<br/>
	 * Ajoute une LigneRapport au rapport du contrôle.<br/>
	 * <br/>
	 * - retourne false si pLigneRapport == null.<br/>
	 * - retourne false si rapport == null.<br/>
	 * <br/>
	 *
	 * @param pLigneRapport : LigneRapport.<br/>
	 * 
	 * @return : boolean : true si la ligne de rapport 
	 * a été ajoutée au rapport.<br/>
	 */
	protected final boolean ajouterLigneRapport(
			final LigneRapport pLigneRapport) {
		
		/* retourne false si pLigneRapport == null. */
		if (pLigneRapport == null) {
			return false;
		}
		
		/* retourne false si rapport == null. */
		if (this.rapport == null) {
			return false;
		}
		
		/* Ajout de la ligne de rapport. */
		return this.rapport.add(pLigneRapport);
		
	} // Fin de ajouterLigneRapport(
	 // LigneRapport pLigneRapport)._______________________________________
	

	
	/**
	 * method retirerLigneRapport(
	 * LigneRapport pLigneRapport) :<br/>
	 * Retire une LigneRapport au rapport du contrôle.<br/>
	 * <br/>
	 * - retourne false si pLigneRapport == null.<br/>
	 * - retourne false si rapport == null.<br/>
	 * <br/>
	 *
	 * @param pLigneRapport : LigneRapport.<br/>
	 * 
	 * @return : boolean : true si la ligne de rapport
	 *  a été retirée du rapport.<br/>
	 */
	protected final boolean retirerLigneRapport(
			final LigneRapport pLigneRapport) {
		
		/* retourne false si pLigneRapport == null. */
		if (pLigneRapport == null) {
			return false;
		}
		
		/* retourne false si rapport == null. */
		if (this.rapport == null) {
			return false;
		}
		
		return this.rapport.remove(pLigneRapport);
		
	} // Fin de retirerLigneRapport(
	 // LigneRapport pLigneRapport)._______________________________________
	

	
	/**
	 * method creerLigneRapport(
	 * Integer pNumeroLigne
	 * , String pMessageControle
	 * , Integer pOrdreChamp
	 * , String pPositionChamp
	 * , String pValeurChamp
	 * , String pAction) :<br/>
	 * Crée et retourne une ligne de rapport LigneRapport 
	 * avec des attributs pré-remplis et les valeurs passées en paramètre.<br/>
	 * <br/>
	 * Liste des attributs pré-remplis : <br/>
	 * - Met automatiquement this.dateControleStringFormatee 
	 * dans la date d'exécution du contrôle 'dateControle'.<br/>
	 * - Met automatiquement this.userName dans le nom 
	 * de l'utilisateur qui a déclenché le contrôle 'userName'.<br/>
	 * - Met automatiquement this.nomFichier dans le nom du fichier 
	 * objet du contrôle 'nomFichier'.<br/>
	 * - Met automatiquement this.typeControle dans le type du contrôle 
	 * ('contrôle de surface' par exemple) 'typeControle'.<br/>
	 * - Met automatiquement this.nomControle dans le nom du contrôle 
	 * ('contrôle fichier texte' par exemple) 'nomControle'.<br/>
	 * - Met automatiquement this.nomCritere dans la désignation 
	 * du critère vérifié par le contrôle 
	 * ('une ligne ne doit pas être vide' par exemple) 'critere'.<br/>
	 * - Met automatiquement this.gravite dans la désignation 
	 * de la gravité de ce contrôle (par exemple '1 - bloquant') 'gravité'.<br/>
	 * <br/>
	 *
	 * @param pNumeroLigne : Integer : numéro de la ligne dans le fichier 
	 * qui déclenche le contrôle.<br/>
	 * @param pMessageControle : String : message émis par le contrôle.<br/>
	 * @param pOrdreChamp : Integer : ordre du champ contrôlé
	 * (dans un fichier comportant une liste de champs comme un fichier 
	 * ASCII HIT).<br/>
	 * @param pPositionChamp : String : position du champ contrôlé 
	 * dans une ligne du fichier comme 7 ou [7-12].<br/>
	 * @param pValeurChamp : String : valeur prise par le champ contrôlé 
	 * exprimée sous forme de String.<br/>
	 * @param pAction : String : action menée après le contrôle 
	 * comme "ligne éliminée" ou "ligne conservée".<br/>
	 * <br/>
	 * 
	 * @return : LigneRapport : Une ligne de rapport.<br/>
	 */
	protected final LigneRapport creerLigneRapport(
			final Integer pNumeroLigne
			, final String pMessageControle
			, final Integer pOrdreChamp
			, final String pPositionChamp
			, final String pValeurChamp
			, final String pAction) {
		
		return new LigneRapport(
				this.dateControleStringFormatee
				, this.userName
				, this.nomFichier
				, this.typeControle
				, this.nomControle
				, this.nomCritere
				, this.gravite
				, pNumeroLigne
				, pMessageControle
				, pOrdreChamp
				, pPositionChamp, pValeurChamp, pAction);
		
	} // Fin de creerLigneRapport(
	 // Integer pNumeroLigne
	 // , String pMessageControle
	 // , Integer pOrdreChamp
	 // , String pPositionChamp
	 // , String pValeurChamp
	 // , String pAction)._________________________________________________

	
	
	 /**
	 * {@inheritDoc}
	 */
	@Override
	public final String lireFichierEnUTF8(
			final File pFile) {
		return this.lireFichier(pFile, CHARSET_UTF8);
	} // Fin de lireFichierEnUTF8(
	// File pFile).________________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String lireFichierEnAscii(
			final File pFile) {
		return this.lireFichier(pFile, CHARSET_US_ASCII);
	} // Fin de lireFichierEnAscii(
	// File pFile).________________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String lireFichierEnLatin1(
			final File pFile) {
		return this.lireFichier(pFile, CHARSET_ISO_8859_1);
	} // Fin de lireFichierEnLatin1(
	// File pFile).________________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String lireFichierEnLatin2(
			final File pFile) {
		return this.lireFichier(pFile, CHARSET_ISO_8859_2);
	} // Fin de lireFichierEnLatin2(
	// File pFile).________________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String lireFichierEnLatin9(
			final File pFile) {
		return this.lireFichier(pFile, CHARSET_ISO_8859_15);
	} // Fin de lireFichierEnLatin9(
	// File pFile).________________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String lireFichierEnAnsi(
			final File pFile) {
		return this.lireFichier(pFile, CHARSET_WINDOWS_1252);
	} // Fin de lireFichierEnAnsi(
	// File pFile).________________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String lireFichierEnIbm850(
			final File pFile) {
		return this.lireFichier(pFile, CHARSET_IBM850);
	} // Fin de lireFichierEnIbm850(
	// File pFile).________________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String lireFichier(
			final File pFile
				, final Charset pCharset) {
		
		/* retourne MESSAGE_FICHIER_NULL 
		 * si le pFile est null. */
		if (pFile == null) {
			
			/* LOG de niveau INFO. */
			loggerInfo(
					this.fournirNomClasseConcrete()
						, METHODE_LIREFICHIER
							, MESSAGE_FICHIER_NULL);
			
			/* rapport. */
			final LigneRapport ligneRapport 
				= creerLigneRapport(
						null
						, MESSAGE_FICHIER_NULL
						, null
						, SANS_OBJET
						, SANS_OBJET
						, ACTION_FICHIER_REFUSE);
			
			this.ajouterLigneRapport(ligneRapport);
			
			/* retour de MESSAGE_FICHIER_NULL. */
			return MESSAGE_FICHIER_NULL;
			
		} // Fin de if (pFile == null).__________________________
		
		/* retourne MESSAGE_FICHIER_INEXISTANT 
		 * si le pFile est inexistant. */
		if (!pFile.exists()) {
							
			/* LOG de niveau INFO. */
			loggerInfo(
					this.fournirNomClasseConcrete()
						, METHODE_LIREFICHIER
							, MESSAGE_FICHIER_INEXISTANT
								, pFile.getAbsolutePath());
			
			/* rapport. */
			final LigneRapport ligneRapport 
				= creerLigneRapport(
						null
						, MESSAGE_FICHIER_INEXISTANT + pFile.getAbsolutePath()
						, null
						, SANS_OBJET
						, SANS_OBJET
						, ACTION_FICHIER_REFUSE);
			
			this.ajouterLigneRapport(ligneRapport);
			
			/* retour de MESSAGE_FICHIER_INEXISTANT. */
			return MESSAGE_FICHIER_INEXISTANT;
			
		} // Fin de if (!pFile.exists()).___________________________
		
		
		/* retourne MESSAGE_FICHIER_REPERTOIRE 
		 * si le pFile est un répertoire. */
		if (pFile.isDirectory()) {
			
			/* LOG de niveau INFO. */
			loggerInfo(
					this.fournirNomClasseConcrete()
						, METHODE_LIREFICHIER
							, MESSAGE_FICHIER_REPERTOIRE
								, pFile.getAbsolutePath());
			
			/* rapport. */
			final LigneRapport ligneRapport 
				= creerLigneRapport(
						null
						, MESSAGE_FICHIER_REPERTOIRE + pFile.getAbsolutePath()
						, null
						, SANS_OBJET
						, SANS_OBJET
						, ACTION_FICHIER_REFUSE);
			
			this.ajouterLigneRapport(ligneRapport);
			
			/* retour de MESSAGE_FICHIER_REPERTOIRE. */
			return MESSAGE_FICHIER_REPERTOIRE;
			
		} // Fin de if (pFile.isDirectory())._______________________

		
		/* passe pFile à this.fichier et 
		 * rafraîchit automatiquement this.nomFichier. */
		this.setFichier(pFile);
		
		/* rafraîchit le rapport. */
		this.rapport = new ArrayList<LigneRapport>();
		
		// LECTURE ***************
		FileInputStream fileInputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;

		int characterEntier = 0;
		Character character = null;
		
		final StringBuilder stb = new StringBuilder();

		Charset charset = null;

		/* Choisit automatiquement le CHARSET_UTF8 si pCharset == null. */
		if (pCharset == null) {
			charset = CHARSET_UTF8;
		} else {
			charset = pCharset;
		}

		try {

			/*
			 * Instancie un flux en lecture fileInputStream en lui passant
			 * pFile.
			 */
			fileInputStream = new FileInputStream(pFile);

			/*
			 * Instancie un InputStreamReader en lui passant le FileReader et le
			 * Charset.
			 */
			inputStreamReader = new InputStreamReader(fileInputStream, charset);

			/*
			 * Instancie un tampon de flux de caractères en lecture en lui
			 * passant le flux inputStreamReader.
			 */
			bufferedReader = new BufferedReader(inputStreamReader);
			
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

		} catch (FileNotFoundException fnfe) {
			
			/* LOG de niveau ERROR. */
			loggerError(
					this.fournirNomClasseConcrete()
						, METHODE_LIREFICHIER
							, fnfe);
			
			/* retourne le message de l'exception. */
			return fnfe.getMessage();
			
		} catch (IOException ioe) {
			
			/* LOG de niveau ERROR. */
			loggerError(
					this.fournirNomClasseConcrete()
						, METHODE_LIREFICHIER
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
							this.fournirNomClasseConcrete()
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
							this.fournirNomClasseConcrete()
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
							this.fournirNomClasseConcrete()
								, METHODE_LIREFICHIER
									, ioe3);
					
				}
				
			} // Fin de if (fileInputStream != null).________
			
		} // Fin du finally._____________________________
		
		return stb.toString();
		
	} // Fin de lireFichier(
	 // File pFile
	 // , Charset pCharset)._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String listerChaineCarParCar(
			final String pString) {
		
		return this.listerChaineCarParCar(pString, null);
		
	} // Fin de listerChaineCarParCar(
	 // String pString).___________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String listerChaineCarParCar(
			final String pString
			, final Integer pNombreMaxiCaracteres) {
		
			
			/* retourne null si pString est blank (null ou vide). */
			if (StringUtils.isBlank(pString)) {
				return null;
			}
			
			int longueurALire = 0;
			
			/* Détermine la longueur de la chaîne. */
			final int longueurChaine = pString.length();
			int position = 0;
			Character caractereChaine = null;
			final StringBuilder stb = new StringBuilder();
			
			/* Calcul de longueurALire. */
			/* si pNombreMaxiCaracteres == null, 
			 * lit les 1000 premiers caractères. */
			if (pNombreMaxiCaracteres == null) {
				longueurALire = 1000;
			}
			/* si pNombreMaxiCaracteres == 0, lit toute la chaîne. */
			else if (pNombreMaxiCaracteres == 0) {
				longueurALire = longueurChaine;
			}
			/* si la longueur de pString <= pNombreMaxiCaracteres
			 * , lit toute la chaîne.  */
			else if (longueurChaine <= pNombreMaxiCaracteres) {
				longueurALire = longueurChaine;
			}
			/* si la longueur de pString > pNombreMaxiCaracteres
			 * , lit pNombreMaxiCaracteres.  */
			else {
				longueurALire = pNombreMaxiCaracteres;
			}
			
			/* Parcours de longueurALire de la chaîne 
			 * caractère par caractère. */
			for(int index = 0; index < longueurALire; index++) {
				
				/* L'index est 0-based. */
				position = index + 1;
				
				/* détermination du caractère dans la chaine. */
				try {
					caractereChaine = pString.charAt(index);
				} catch (IndexOutOfBoundsException e1) {
					caractereChaine = null;
				}
				
				/* Instanciation d'un CaractereDan. */
				final CaractereDan carDan 
					= new CaractereDan(position, caractereChaine);
				
				stb.append(carDan.toString());
				stb.append(NEWLINE);
				
			} // Fin du parcours de la chaîne._______________
			
			/* Retour du résultat. */
			return stb.toString();
					
	} // Fin de listerChaineCarParCar(
	 // String pString
	// , Integer pNombreMaxiCaracteres).___________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherRapportTextuel() {
		
		/* retourne null si this.rapport == null. */
		if (this.rapport == null) {
			return null;
		}
		
		return this.afficherRapportTextuel(this.rapport);
		
	} // Fin de afficherRapportTextuel().__________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherRapportTextuel(
			final List<LigneRapport> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final LigneRapport ligne : pList) {
			stb.append(ligne.toString());
			stb.append(NEWLINE);
		}
		
		return stb.toString();
		
	} // Fin de afficherRapportTextuel(
	 // List<LigneRapport> pList)._________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getEnTeteCsv() {
		
		final StringBuilder stb = new StringBuilder();
		
		stb.append("id;");
		stb.append("date du contrôle;");
		stb.append("utilisateur;");
		stb.append("Fichier;");
		stb.append("type de contrôle;");
		stb.append("Contrôle;");
		stb.append("Critère;");
		stb.append("Gravité;");
		stb.append("Numéro de Ligne;");
		stb.append("Message du Contrôle;");
		stb.append("Ordre du Champ;");
		stb.append("Position du Champ;");
		stb.append("Valeur du Champ;");
		stb.append("Action;");
		
		return stb.toString();
		
	} // Fin de getEnTeteCsv().____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherRapportCsv() {
		
		/* retourne null si this.rapport == null. */
		if (this.rapport == null) {
			return null;
		}
		
		return this.afficherRapportCsv(this.rapport, false);
		
	} // Fin de afficherRapportCsv().______________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherRapportCsvAvecEntete() {
		
		/* retourne null si this.rapport == null. */
		if (this.rapport == null) {
			return null;
		}
		
		return this.afficherRapportCsv(this.rapport, true);
		
	} // Fin de afficherRapportCsvAvecEntete().____________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherRapportCsv(
			final List<LigneRapport> pList
				, final boolean pAjouterEntete) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		int compteur = 0;
		
		for (final LigneRapport ligne : pList) {
			
			compteur++;
			
			/* Ajout de l'en-tête. */
			if (compteur == 1 && pAjouterEntete) {
				stb.append(this.getEnTeteCsv());
				stb.append(NEWLINE);
			}
			
			stb.append(ligne.toCsv());
			stb.append(NEWLINE);
		}
		
		return stb.toString();
				
	} // Fin de afficherRapportCsv(
	 // List<LigneRapport> pList
	// , boolean pAjouterEntete).__________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Date getDateControle() {
		return this.dateControle;
	} // Fin de getDateControle()._________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setDateControle(
			final Date pDateControle) {
		
		this.dateControle = pDateControle;
		
		/* calcule automatiquement dateControleStringFormattee. */
		this.dateControleStringFormatee 
			= this.fournirDateFormattee(this.dateControle);
		
	} // Fin de setDateControle(
	 // Date pDateControle)._______________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getDateControleStringFormatee() {
		return this.dateControleStringFormatee;
	} // Fin de getDateControleStringFormatee().___________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getUserName() {
		return this.userName;
	} // Fin de getUserName()._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setUserName(
			final String pUserName) {
		this.userName = this.fournirUserName(pUserName);
	} // Fin de setUserName(
	 // String pUserName)._________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final File getFichier() {
		return this.fichier;
	} // Fin de getFichier().______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setFichier(
			final File pFichier) {
		
		this.fichier = pFichier;
		
		/* calcule automatiquement nomFichier. */
		this.nomFichier = this.fournirNomFichier(this.fichier);
		
	} // Fin de setFichier(
	 // File pFichier).____________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getNomFichier() {
		return this.nomFichier;
	} // Fin de getNomFichier().___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTypeControle() {
		return this.typeControle;
	} // Fin de getTypeControle()._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getNomControle() {
		return this.nomControle;
	} // Fin de getNomControle().__________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getNomCritere() {
		return this.nomCritere;
	} // Fin de getNomCritere().___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getGravite() {
		return this.gravite;
	} // Fin de getGravite().______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getNiveauAnomalie() {
		return this.niveauAnomalie;
	} // Fin de getNiveauAnomalie()._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean isEstBloquant() {
		return this.estBloquant;
	} // Fin de isEstBloquant().___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<LigneRapport> getRapport() {
		return this.rapport;
	} // Fin de getRapport().______________________________________________


	
} // FIN DE LA CLASSE AbstractControle.--------------------------------------
