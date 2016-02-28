package levy.daniel.application.metier.controles;

import java.io.File;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import levy.daniel.application.IConstantesMessage;
import levy.daniel.application.metier.rapportscontroles.LigneRapport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class AbstractControle :<br/>
 * Abstraction qui garantit que :<br/>
 * - Tout contrôle est effectué à une 'dateContrôle'.<br/>
 * - Tout contrôle est effectué par un utilisateur (user) 
 * dont on connait le nom 'userName'.<br/>
 * - Tout contrôle s'applique sur un File 'fichier'.<br/>
 * - Tout contrôle appartient à un type de contrôle 'typeControle' 
 * comme "contrôle de surface".<br/>
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
 * @since 27 févr. 2016
 *
 */
public abstract class AbstractControle {

	// ************************ATTRIBUTS************************************/

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
	protected String dateControleStringFormatee;
	
	
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
	protected String nomFichier;
	
	
	/**
	 * typeControle : String :<br/>
	 * type du contrôle (contrôle de surface par exemple).<br/>
	 */
	protected String typeControle;

	
	/**
	 * nomControle : String :<br/>
	 * nom du contrôle ('contrôle fichier texte' par exemple).<br/>
	 */
	protected String nomControle;

	
	/**
	 * nomCritere : String :<br/>
	 * nom du critère appliqué dans le contrôle.<br/>
	 */
	protected String nomCritere;
	
	
	/**
	 * gravite : String :<br/>
	 * désignation de la gravité de ce contrôle 
	 * (par exemple '1 - bloquant').<br/>
	 */
	protected String gravite;

	
	/**
	 * rapport : List<LigneRapport> :<br/>
	 * rapport fourni par le contrôle.<br/>
	 */
	protected List<LigneRapport> rapport = new ArrayList<LigneRapport>();
	

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
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("fr", "FR").<br/>
	 */
	public static final Locale LOCALE_FR_FR = new Locale("fr", "FR");


	/**
	 * dfDatetimemilliFrancaise : DateFormat :<br/>
	 * Format des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 */
	public final transient DateFormat dfDatetimemilliFrancaise 
	= new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss.SSS", LOCALE_FR_FR);
	
	/**
	 * DF_DATETIMEMILLI_FRANCAISE : DateFormat :<br/>
	 * Format des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 */
	public static final DateFormat DF_DATETIMEMILLI_FRANCAISE 
	= new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss.SSS", LOCALE_FR_FR);

	/**
	 * NEWLINE : String :<br/>
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	public static final String NEWLINE = System.getProperty("line.separator");

	
	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 */
	public static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");


	/**
	 * CARACTERE_REMPLACEMENT : char :<br/>
	 * Caractère de remplacement introduit lors de la lecture en UTF-8 
	 * d'un fichier texte encodé avec un autre Charset.<br/>
	 * REPLACEMENT CHARACTER."\\ufffd" '�'.<br/> 
	 */
	public static final char CARACTERE_REMPLACEMENT = '\ufffd';


	/**
	 * SEP_MOINS : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEP_MOINS = " - ";


	/**
	 * nomClasseConcrete : String :<br/>
	 * nom de la classe de contrôle concrète.<br/>
	 */
	protected transient String nomClasseConcrete;

	
	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	public static final String NULL = "null";

	
	/**
	 * SANS_OBJET : String :<br/>
	 * "sans objet".<br/>
	 */
	public static final String SANS_OBJET = "sans objet";

	
	/**
	 * TOUS : String :<br/>
	 * "tous".<br/>
	 */
	public static final String TOUS = "tous";

	
	 /**
	 * ACTION_FICHIER_REFUSE : String :<br/>
	 * "Fichier refusé".<br/>
	 */
	public static final String ACTION_FICHIER_REFUSE = "Fichier refusé";
	
	
	/**
	 * bundleControles : ResourceBundle :<br/>
	 * Encapsulation de messagescontroles_fr_FR.properties.<br/>
	 */
	public static ResourceBundle bundleControles;
	
	
	
	/**
	 * niveauAnomalie : String : <br/>
	 * Niveau de l'anomalie correspondant au Contrôle
	 * dans le messagescontroles_fr_FR.properties.<br/>
	 * Par exemple : "1" pour le ControleurTypeTexte.<br/>
	 */
	protected String niveauAnomalie;
	

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
	 * - Remplit gravite (ce qui remplit également niveauAnomalie).<br/>
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
	 * - Remplit gravite (ce qui remplit également niveauAnomalie).<br/>
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
	 * - Remplit gravite (ce qui remplit également niveauAnomalie).<br/>
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
	 * - Remplit gravite (ce qui remplit également niveauAnomalie).<br/>
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
		
		/* remplissage de fichier. */
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
		
		/* Remplit gravite (ce qui remplit également niveauAnomalie). */
		this.gravite = this.fournirGravite();
		
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________



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
								+ "sous la racine du projet : " 
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


	
	protected void calculerValeurs() {
		
		/* Remplit le nom de la classe concrète. */
		this.nomClasseConcrete = this.fournirNomClasseConcrete();
		
		/* remplit la dateControle. */
		this.dateControle = this.fournirDate(null);
		
		/* remplit la dateControleStringFormattee. */
		this.dateControleStringFormatee 
			= this.fournirDateFormattee(this.dateControle);
		
		/* remplit le userName. */
		this.userName = this.fournirUserName(null);
		
		/* remplit le nomFichier. */
		this.nomFichier = this.fournirNomFichier(this.fichier);
		
		/* remplit le type du contrôle. */
		this.typeControle = this.fournirTypeControle();
		
		/* remplit le nom du contrôle. */
		this.nomControle = this.fournirNomControle();
		
		/* remplit le nom du critère. */
		this.nomCritere = this.fournirNomCritere();
		
		/* remplit la gravité. */
		this.gravite = this.fournirGravite();
		
	}
	
	/**
	 * method fournirDateSystemeFormattee() :<br/>
	 * Retourne la date système au format 
	 * des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>.<br/>
	 * <br/>
	 *
	 * @return : String :   la date système au format 
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 */
	public static String fournirDateSystemeFormattee() {
		
		/* Bloc static synchronized. */
		synchronized (AbstractControle.class) {
			
			return DF_DATETIMEMILLI_FRANCAISE.format(new Date());
			
		} // Fin du bloc static synchronized.___________
		
	} // Fin de fournirDateSystemeFormattee()._____________________________

	
	
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
	 * @return : String :  .<br/>
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
	 * method recupererNiveauAnomalieDansProperties() :<br/>
	 * récupère le niveau d'anomalie du contrôle dans 
	 * messagescontroles_fr_FR.properties.<br/>
	 * <br/>
	 * - retourne null, LOG de niveau INFO et rapport 
	 * si bundleControles est null.<br/>
	 * - retourne null, LOG de niveau INFO et rapport 
	 * si messagescontroles_fr_FR.properties est manquant.<br/>
	 * - retourne null, LOG de niveau INFO et rapport 
	 * si messagescontroles_fr_FR.properties ne contient pas la clé 
	 * (ou pas de valeur pour cette clé).
	 * <br/>
	 *
	 * @return : String : niveauAnomalie.<br/>
	 */
	private String recupererNiveauAnomalieDansProperties() {

		String resultat = null;
		
		try {
						
			/* récupère le niveau d'anomalie du contrôle 
			 * dans messagescontroles_fr_FR.properties. */
			if (bundleControles != null) {
				resultat 
				= bundleControles.getString(
						this.fournirCleNiveauAnomalie());
			}
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
			
			final String message 
				= "messagescontroles_fr_FR.properties manquant "
						+ "sous la racine du projet : " 
						+ mre.getMessage();
			
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
						, "pas de messagescontroles_fr_FR.properties"
						, SANS_OBJET
						, null
						, message
						, null
						, SANS_OBJET
						, SANS_OBJET
						, SANS_OBJET);
			
			this.ajouterLigneRapport(ligneRapport);
			
			/* retourne null, LOG de niveau INFO et rapport 
			 * si messagescontroles_fr_FR.properties est manquant. */
			return null;
			
		} catch (Exception e) {
			
			final String message 
			= "La clé : " + this.fournirCleNiveauAnomalie()
					+ " n'existe pas dans  messagescontroles_fr_FR.properties "
					+ "ou n'a pas de valeur : " 
					+ e.getMessage();
		
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
					, "pas de clé ou valeur dans messagescontroles_fr_FR.properties"
					, SANS_OBJET
					, null
					, message
					, null
					, SANS_OBJET
					, SANS_OBJET
					, SANS_OBJET);
		
		this.ajouterLigneRapport(ligneRapport);
		
		/* retourne null, LOG de niveau INFO et rapport 
		 * si messagescontroles_fr_FR.properties ne contient pas la clé 
		 * (ou pas de valeur pour cette clé). */
		return null;
		
		}
		
		/* retourne le niveau d'anomalie 
		 * dans messagescontroles_fr_FR.properties. */
		return resultat;
		
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
	protected void loggerInfo(
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
	protected void loggerInfo(
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
	protected void loggerError(
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
	protected boolean ajouterLigneRapport(
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
	protected boolean retirerLigneRapport(
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
	 * method afficherRapportTextuel() :<br/>
	 * Affichage au format textuel de this.rapport.<br/>
	 * <br/>
	 * - retourne null si this.rapport == null.<br/>
	 * <br/>
	 *
	 * @return : String : String pour affichage de this.rapport 
	 * au format textuel.<br/>
	 */
	public String afficherRapportTextuel() {
		
		/* retourne null si this.rapport == null. */
		if (this.rapport == null) {
			return null;
		}
		
		return this.afficherRapportTextuel(this.rapport);
		
	} // Fin de afficherRapportTextuel().__________________________________
	

	
	/**
	 * method afficherRapportTextuel(
	 * List&lt;LigneRapport&gt; pList) :<br/>
	 * Affichage dans la console d'une List&lt;LigneRapport&gt; 
	 * au format textuel.<br/>
	 * <br/>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;LigneRapport&gt;.<br/>
	 * 
	 * @return : String : String pour affichage au format textuel.<br/>
	 */
	public String afficherRapportTextuel(
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
	 * retourne : <br/>
	 * "id;date du contrôle;utilisateur;Fichier;type de contrôle;
	 * Contrôle;Critère;Gravité;
	 * Numéro de Ligne;Message du Contrôle;Ordre du Champ;Position du Champ;
	 * Valeur du Champ;Action;"<br/>
	 * <br/>
	 * @return String : en-tête du rapport csv.<br/>
	 */
	public String getEnTeteCsv() {
		
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
	 * method afficherRapportCsv() :<br/>
	 * Affichage au format csv de this.rapport.<br/>
	 * <br/>
	 * - n'ajoute pas l'en-tête du rapport csv.<br/>
	 * - retourne null si this.rapport == null.<br/>
	 * <br/>
	 *
	 * @return : String : String pour affichage de this.rapport 
	 * au format csv.<br/>
	 */
	public String afficherRapportCsv() {
		
		/* retourne null si this.rapport == null. */
		if (this.rapport == null) {
			return null;
		}
		
		return this.afficherRapportCsv(this.rapport, false);
		
	} // Fin de afficherRapportCsv().______________________________________
	

	
	/**
	 * method afficherRapportCsvAvecEntete() :<br/>
	 * Affichage au format csv de this.rapport.<br/>
	 * <br/>
	 * - Ajoute l'en-tête du rapport csv.<br/>
	 * - retourne null si this.rapport == null.<br/>
	 * <br/>
	 *
	 * @return : String : String pour affichage de this.rapport 
	 * au format csv.<br/>
	 */
	public String afficherRapportCsvAvecEntete() {
		
		/* retourne null si this.rapport == null. */
		if (this.rapport == null) {
			return null;
		}
		
		return this.afficherRapportCsv(this.rapport, true);
		
	} // Fin de afficherRapportCsvAvecEntete().____________________________



	/**
	 * method afficherRapportCsv(
	 * List&lt;LigneRapport&gt; pList
	 * , boolean pAjouterEntete) :<br/>
	 * Affichage dans la console d'une List&lt;LigneRapport&gt; 
	 * au format csv.<br/>
	 * <br/>
	 * - ajoute l'en-tête du rapport csv si pAjouterEntete vaut true.<br/>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;LigneRapport&gt;.<br/>
	 * @param pAjouterEntete 
	 * 
	 * @return : String : String pour affichage au format csv.<br/>
	 */
	public String afficherRapportCsv(
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
	 * method getDateControle() :<br/>
	 * Getter de la java.util.Date du contrôle.<br/>
	 * <br/>
	 *
	 * @return dateControle : Date.<br/>
	 */
	public Date getDateControle() {
		return this.dateControle;
	} // Fin de getDateControle()._________________________________________
	
	

	/**
	 * method setDateControle(
	 * Date pDateControle) :<br/>
	 * Setter de la java.util.Date du contrôle.<br/>
	 * <br/>
	 *
	 * @param pDateControle : Date : valeur à passer à dateControle.<br/>
	 */
	public void setDateControle(
			final Date pDateControle) {
		this.dateControle = pDateControle;
	} // Fin de setDateControle(
	 // Date pDateControle)._______________________________________________
	
	

	/**
	 * method getDateControleStringFormatee() :<br/>
	 * Getter de la date du contrôle formattée 
	 * au format dfDatetimemilliFrancaise.<br/>
	 * Format des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 * <br/>
	 *
	 * @return dateControleStringFormatee : String.<br/>
	 */
	public String getDateControleStringFormatee() {
		return this.dateControleStringFormatee;
	} // Fin de getDateControleStringFormatee().___________________________



	/**
	 * method setDateControleStringFormatee(
	 * String pDateControleStringFormatee) :<br/>
	 * Setter de la date du contrôle formattée 
	 * au format dfDatetimemilliFrancaise.<br/>
	 * Format des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 * <br/>
	 *
	 * @param pDateControleStringFormatee : String : 
	 * valeur à passer à dateControleStringFormatee.<br/>
	 */
	public void setDateControleStringFormatee(
			final String pDateControleStringFormatee) {
		this.dateControleStringFormatee = pDateControleStringFormatee;
	} // Fin de setDateControleStringFormatee(
	 // String pDateControleStringFormatee)._______________________________



	/**
	 * method getUserName() :<br/>
	 * Getter du nom de l'utilisateur qui a déclenché le contrôle.<br/>
	 * <br/>
	 *
	 * @return userName : String.<br/>
	 */
	public final String getUserName() {
		return this.userName;
	} // Fin de getUserName()._____________________________________________



	/**
	 * method setUserName(
	 * String pUserName) :<br/>
	 * Setter du nom de l'utilisateur qui a déclenché le contrôle.<br/>
	 * <br/>
	 *
	 * @param pUserName : String : 
	 * valeur à passer à userName.<br/>
	 */
	public final void setUserName(
			final String pUserName) {
		this.userName = pUserName;
	} // Fin de setUserName(
	 // String pUserName)._________________________________________________



	/**
	 * method getFichier() :<br/>
	 * Getter du fichier sur lequel s'applique le contrôle.<br/>
	 * <br/>
	 *
	 * @return fichier : File.<br/>
	 */
	public File getFichier() {
		return this.fichier;
	} // Fin de getFichier().______________________________________________



	/**
	 * method setFichier(
	 * File pFichier) :<br/>
	 * Setter du fichier sur lequel s'applique le contrôle.<br/>
	 * <br/>
	 * - calcule automatiquement nomFichier.<br/>
	 * <br/>
	 *
	 * @param pFichier : File : valeur à passer à fichier.<br/>
	 */
	public void setFichier(
			final File pFichier) {
		
		this.fichier = pFichier;
		
		/* calcule automatiquement nomFichier. */
		this.nomFichier = this.fournirNomFichier(this.fichier);
		
	} // Fin de setFichier(
	 // File pFichier).____________________________________________________



	/**
	 * method getNomFichier() :<br/>
	 * Getter du nom du fichier objet du contrôle.<br/>
	 * <br/>
	 *
	 * @return nomFichier : String.<br/>
	 */
	public final String getNomFichier() {
		return this.nomFichier;
	} // Fin de getNomFichier().___________________________________________



	/**
	 * method setNomFichier(
	 * String pNomFichier) :<br/>
	 * Setter du nom du fichier objet du contrôle.<br/>
	 * <br/>
	 *
	 * @param pNomFichier : String : 
	 * valeur à passer à nomFichier.<br/>
	 */
	public final void setNomFichier(
			final String pNomFichier) {
		this.nomFichier = pNomFichier;
	} // Fin de setNomFichier(
	 // String pNomFichier)._______________________________________________



	/**
	 * method getTypeControle() :<br/>
	 * Getter du type du contrôle (contrôle de surface par exemple).<br/>
	 * <br/>
	 *
	 * @return typeControle : String.<br/>
	 */
	public final String getTypeControle() {
		return this.typeControle;
	} // Fin de getTypeControle()._________________________________________



	/**
	 * method setTypeControle(
	 * String pTypeControle) :<br/>
	 * Setter du type du contrôle (contrôle de surface par exemple).<br/>
	 * <br/>
	 *
	 * @param pTypeControle : String : 
	 * valeur à passer à typeControle.<br/>
	 */
	public final void setTypeControle(
			final String pTypeControle) {
		this.typeControle = pTypeControle;
	} // Fin de setTypeControle(
	 // String pTypeControle)._____________________________________________


	
	/**
	 * method getNomControle() :<br/>
	 * Getter du nom du contrôle (contrôle fichier texte par exemple).<br/>
	 * <br/>
	 *
	 * @return nomControle : String.<br/>
	 */
	public final String getNomControle() {
		return this.nomControle;
	} // Fin de getNomControle().__________________________________________



	/**
	 * method setNomControle(
	 * String pNomControle) :<br/>
	 * Setter du nom du contrôle (contrôle fichier texte par exemple).<br/>
	 * <br/>
	 *
	 * @param pNomControle : String : 
	 * valeur à passer à nomControle.<br/>
	 */
	public final void setNomControle(
			final String pNomControle) {
		this.nomControle = pNomControle;
	} // Fin de setNomControle(
	 // String pNomControle).______________________________________________



	/**
	 * method getNomCritere() :<br/>
	 * Getter du nom du critère appliqué dans le contrôle.<br/>
	 * <br/>
	 *
	 * @return nomCritere : String.<br/>
	 */
	public String getNomCritere() {
		return this.nomCritere;
	} // Fin de getNomCritere().___________________________________________



	/**
	 * method setNomCritere(
	 * String pNomCritere) :<br/>
	 * Setter du nom du critère appliqué dans le contrôle.<br/>
	 * <br/>
	 *
	 * @param pNomCritere : String : 
	 * valeur à passer à nomCritere.<br/>
	 */
	public void setNomCritere(
			final String pNomCritere) {
		this.nomCritere = pNomCritere;
	} // Fin de setNomCritere(
	 // String pNomCritere)._______________________________________________



	/**
	 * method getRapport() :<br/>
	 * Getter du rapport fourni par le contrôle.<br/>
	 * <br/>
	 *
	 * @return rapport : List&lt;LigneRapport&gt;.<br/>
	 */
	public List<LigneRapport> getRapport() {
		return this.rapport;
	} // Fin de getRapport().______________________________________________



	/**
	 * method setRapport(
	 * List&lt;LigneRapport&gt; pRapport) :<br/>
	 * Setter du rapport fourni par le contrôle.<br/>
	 * <br/>
	 *
	 * @param pRapport : List&lt;LigneRapport&gt; : 
	 * valeur à passer à rapport.<br/>
	 */
	public void setRapport(
			final List<LigneRapport> pRapport) {
		this.rapport = pRapport;
	} // Fin de setRapport(
	 // List<LigneRapport> pRapport).______________________________________



	/**
	 * method getGravite() :<br/>
	 * Getter de la désignation de la gravité de ce contrôle 
	 * (par exemple '1 - bloquant').<br/>
	 * <br/>
	 *
	 * @return gravite : String.<br/>
	 */
	public final String getGravite() {
		return this.gravite;
	} // Fin de getGravite().______________________________________________



	/**
	 * method setGravite(
	 * String pGravite) :<br/>
	 * Setter de la désignation de la gravité de ce contrôle 
	 * (par exemple '1 - bloquant').<br/>
	 * <br/>
	 *
	 * @param pGravite : String : valeur à passer à gravite.<br/>
	 */
	public final void setGravite(
			final String pGravite) {
		this.gravite = pGravite;
	} // Fin de setGravite(
	 // String pGravite).__________________________________________________



	/**
	 * method getNiveauAnomalie() :<br/>
	 * Getter du Niveau de l'anomalie correspondant au Contrôle
	 * dans le messagescontroles_fr_FR.properties.<br/>
	 * Par exemple : "1" pour le ControleurTypeTexte.<br/>
	 * <br/>
	 *
	 * @return niveauAnomalie : String.<br/>
	 */
	public String getNiveauAnomalie() {
		return this.niveauAnomalie;
	} // Fin de getNiveauAnomalie()._______________________________________



	/**
	 * method setNiveauAnomalie(
	 * String pNiveauAnomalie) :<br/>
	 * Setter du Niveau de l'anomalie correspondant au Contrôle
	 * dans le messagescontroles_fr_FR.properties.<br/>
	 * Par exemple : "1" pour le ControleurTypeTexte.<br/>
	 * <br/>
	 *
	 * @param pNiveauAnomalie : String : valeur à passer à niveauAnomalie.<br/>
	 */
	public void setNiveauAnomalie(
			final String pNiveauAnomalie) {
		this.niveauAnomalie = pNiveauAnomalie;
	} // Fin de setNiveauAnomalie(
	 // String pNiveauAnomalie).___________________________________________



	
} // FIN DE LA CLASSE AbstractControle.--------------------------------------
