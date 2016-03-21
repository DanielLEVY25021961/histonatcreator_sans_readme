package levy.daniel.application.metier.controles;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.metier.controles.impl.controlessurface.ControleurEncodage;
import levy.daniel.application.metier.controles.impl.controlessurface.ControleurTypeTexte;
import levy.daniel.application.metier.controles.impl.controlessurface.Transcodeur;
import levy.daniel.application.metier.controles.rapportscontroles.LigneRapport;
import levy.daniel.application.metier.service.enregistreursfichiers.IEnregistreurFichiers;
import levy.daniel.application.metier.service.enregistreursfichiers.impl.EnregistreurFichiers;
import levy.daniel.application.metier.service.enregistreursfichiers.rapportsenregistrements.LigneRapportEnregistrement;


/**
 * class AbstractEnchaineurControles :<br/>
 * Abstraction chargée de centraliser les attributs et les méthodes des 
 * Classe métier non persistante chargée d'enchaîner 
 * tous les contrôles à appliquer aux fichiers en entrée 
 * (HIT, DARWIN, ...).<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Enchainement de contrôles, enchaînement de controles, polymorphisme,<br/>
 * SortedMap, TreeMap,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * levy.daniel.application.IExportateurCsv.<br/>
 * levy.daniel.application.IExportateurJTable.<br/>
 * levy.daniel.application.IResetable.<br/>
 * levy.daniel.application.metier.controles.rapportscontroles.LigneRapport.<br/>
 * levy.daniel.application.metier.controles.IRapporteurControle.<br/>
 * levy.daniel.application.metier.service.enregistreursfichiers.rapportsenregistrements.LigneRapportEnregistrement.<br/>
 * levy.daniel.application.metier.service.enregistreursfichiers.IRapporteurEnregistrement.<br/>
 * levy.daniel.application.metier.service.enregistreursfichiers.IEnregistreurFichiers.<br/>
 * levy.daniel.application.metier.service.enregistreursfichiers.AbstractEnregistreurFichiers.<br/>
 * levy.daniel.application.metier.service.enregistreursfichiers.impl.EnregistreurFichiers.<br/>
 * levy.daniel.application.metier.service.enregistreursfichiers.rapportsenregistrements.LigneRapportEnregistrement.<br/>
 * levy.daniel.application.metier.controles.IEnchaineurControles
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 6 mars 2016
 *
 */
public abstract class AbstractEnchaineurControles 
						implements IEnchaineurControles {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_ABSTRACT_ENCHAINEUR_CONTROLES : String :<br/>
	 * "Classe AbstractEnchaineurControles".<br/>
	 */
	public static final String CLASSE_ABSTRACT_ENCHAINEUR_CONTROLES 
		= "Classe AbstractEnchaineurControles";
	
		
	/**
	 * METHODE_INITIALISER_BUNDLE_CONTROLES : String :<br/>
	 * "méthode initialiserBundleControles()".<br/>
	 */
	public static final String METHODE_INITIALISER_BUNDLE_CONTROLES 
		= "méthode initialiserBundleControles()";

	
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
	 * dateControle : Date :<br/>
	 * java.util.Date de l'enchaînement de contrôles.<br/>
	 */
	protected Date dateControle;

	
	/**
	 * dateControleStringFormatee : String :<br/>
	 * date de l'enchaînement de contrôles 
	 * formattée au format dfDatetimemilliFrancaiseLexico.<br/>
	 * Format des dates-heures françaises lexicographique 
	 * avec millisecondes comme
	 * '1961-01-25_12-27-07-251'.<br/>
	 * "yyyy-MM-dd_HH-mm-ss-SSS".<br/>
	 */
	protected transient String dateControleStringFormatee;
	

	/**
	 * userName : String :<br/>
	 * nom de l'utilisateur qui a déclenché l'enchaînement de contrôles.<br/>
	 */
	protected String userName;

	
	/**
	 * fichier : File :<br/>
	 * fichier sur lequel s'applique l'enchaînement de contrôles.<br/>
	 */
	protected File fichier;

	
	/**
	 * nomFichier : String :<br/>
	 * nom du fichier objet de l'enchaînement de contrôles.<br/>
	 */
	protected transient String nomFichier;
	
	
	/**
	 * rapport : List&lt;LigneRapport&gt; :<br/>
	 * rapport fourni par l'enchaînement de contrôles sous forme 
	 * de List&lt;LigneRapport&gt;.<br/>
	 */
	protected transient List<LigneRapport> rapport 
		= new ArrayList<LigneRapport>();
	
	
	/**
	 * rapportEnregistrement : List&lt;LigneRapportEnregistrement&gt; :<br/>
	 * rapport d'enregistrement sur disque des fichiers 
	 * fourni par l'enregistreur du rapport 
	 * de l'enchaîneur de contrôle  sous forme 
	 * de List&lt;LigneRapportEnregistrement&gt;.<br/>
	 */
	protected transient List<LigneRapportEnregistrement> rapportEnregistrement 
		= new ArrayList<LigneRapportEnregistrement>();


	/**
	 * estBloquant : boolean :<br/>
	 * boolean qui stipule si l'enchaînement de contrôles 
	 * bloque le programme.<br/>
	 * true si l'enchaînement de contrôles bloque le programme.<br/>
	 */
	protected transient boolean estBloquant;
	
	
	
	/**
	 * mapControles : SortedMap<Integer,IControle> :<br/>
	 * Collection contenant l'ensemble des contrôles 
	 * à enchaîner sur un fichier.<br/>
	 */
	protected transient SortedMap<Integer, IControle> mapControles = new TreeMap<Integer, IControle>();
		

	
	/**
	 * dfDatetimemilliFrancaiseLexico : DateFormat :<br/>
	 * Format des dates-heures françaises lexicographique 
	 * avec millisecondes comme
	 * '1961-01-25_12-27-07-251'.<br/>
	 * "yyyy-MM-dd_HH-mm-ss-SSS".<br/>
	 */
	public final transient DateFormat dfDatetimemilliFrancaiseLexico 
	= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", LOCALE_FR_FR);


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
	private static final Log LOG = LogFactory
			.getLog(AbstractEnchaineurControles.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractEnchaineurControles() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractEnchaineurControles() {
		this(null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
		
	 /**
	 * method CONSTRUCTEUR AbstractEnchaineurControles(
	 * Date pDateControle
	 * , String pUserName
	 * , File pFichier) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 * <ul>
	 * <li>initialise le bundleControles qui encapsule 
	 * messagescontroles_fr_FR.properties.</li><br/>
	 * <li>remplit dateControle avec pDateControle si pDateControle != null 
	 * ou la date système sinon.</li><br/>
	 * <li>calcule automatiquement this.dateControleStringFormattee.</li><br/>
	 * <li>remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.</li><br/>
	 * <li>passe pFichier à this.fichier.</li><br/>
	 * <li>calcule automatiquement this.nomFichier.</li><br/>
	 * <li>remplit la SortedMap des contrôles à enchaîner.</li><br/>
	 * </ul>
	 * <br/>
	 *
	 * @param pDateControle : Date : java.util.Date de 
	 * l'enchaînement des contrôles.<br/>
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché l'enchaînement des contrôles.<br/> 
	 * @param pFichier : File : fichier sur lequel 
	 * s'applique l'enchaînement des contrôles.<br/>
	 */
	public AbstractEnchaineurControles(
			final Date pDateControle
				, final String pUserName
					, final File pFichier) {
		
		/* Instancie la super-classe*/
		super();
		
		/* initialise le bundleControles qui encapsule 
		 * messagescontroles_fr_FR.properties. */
		initialiserBundleControles();
		
		/* remplit dateControle avec pDateControle si pDateControle != null 
		 * ou la date système sinon. */
		this.dateControle = this.fournirDate(pDateControle);
		
		/* calcule automatiquement this.dateControleStringFormattee. */
		this.dateControleStringFormatee 
			= this.fournirDateFormattee(this.dateControle);
		
		/* remplit userName avec pUserName si pUserName != null 
		 * ou 'Administrateur' sinon. */
		this.userName = this.fournirUserName(pUserName);
		
		/* passe pFichier à this.fichier. */
		this.fichier = pFichier;
		
		/* calcule automatiquement this.nomFichier. */
		this.nomFichier = this.fournirNomFichier(this.fichier);
		
		/* remplit la SortedMap des contrôles à enchaîner. */
		this.remplirMapControles();

	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean controler(
			final File pFile) {
		
		return this.controler(pFile, true);
		
	} // Fin de controler(
	 // File pFile)._______________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean controler(
			final File pFile, final boolean pEnregistrerRapport) {
		
		/* retourne false si this.mapControles == null. */
		if (this.mapControles == null) {
			return false;
		}
		
		boolean resultat = true;
		
		/* passe pFile à this.fichier et 
		 * rafraîchit automatiquement this.nomFichier. */
		this.setFichier(pFile);
		
		/* rafraîchit le rapport (en instancie un nouveau à chaque appel 
		 * de la méthode controler(File pFile, boolean pEnregistrerRapport)). */
		this.rapport = new ArrayList<LigneRapport>();
		
		// PARCOURS DE LA SORTEDMAP DES CONTROLES.***************************
		/* récupère un Set<Entry<Integer, IControle>> 
		 * auprès de la SortedMap. */
		final Set<Entry<Integer, IControle>> set 
			= this.mapControles.entrySet();
		
		if (set == null) {
			return false;
		}
		
		/* Récupère un Iterator<Entry<Integer, IControle>> 
		 * auprès du Set<Entry<Integer, IControle>>. */
		final Iterator<Entry<Integer, IControle>> ite = set.iterator();
		
		if (ite == null) {
			return false;
		}
		
		int numeroControleEffectue = 0;
		File fichierAControler = null;
		
		/* Parcours de l'Iterator. */
		while (ite.hasNext()) {
			
			/* Incrémentation du numeroControleEffectue. */
			numeroControleEffectue++;
			
			/* Récupération de Entry<Integer, IControle> 
			 * auprès de l'Iterator. */
			final Entry<Integer, IControle> entry = ite.next();
			
			if (entry != null) {
				
				/* Récupération du contrôle dans l'Entry<Integer, IControle>. */
				final IControle controle = entry.getValue();
				
				if (controle != null) {
					
					/* N'exécute un contrôle que si son aEffectuer 
					 * vaut true (contrôles paramétrables). */
					if (controle.isaEffectuer()) {
												
						if (numeroControleEffectue == 1) {
							fichierAControler = pFile;
						}
						
						/* EXECUTION DE CHAQUE CONTROLE. ************/
						/* récupération du résultat du contrôle 
						 * (true si le contrôle est favorable). */
						final boolean resultatControle 
							= controle.controler(fichierAControler);
						
						/* récupération de estBloquant 
						 * (true si le contrôle est bloquant). */
						final boolean estBloquantInterne 
							= controle.isEstBloquant();
						
						/* Ajoute chaque rapport d'un contrôle 
						 * à this.rapport. */
						this.rapport.addAll(controle.getRapport());
						
						/* Si le contrôle est défavorable. */
						if (!resultatControle) {
							
							/* passe le résultat de la méthode à false 
							 * si un seul contrôle n'est pas favorable. */
							resultat = false;
							
							/* Enregistre le rapport de contrôle sur disque 
							 * si pEnregistrerRapport vaut true 
							 * et que le contrôle est défavorable. */
							if (pEnregistrerRapport) {
								
								this.enregistrerRapportTextuelUTF8(
										this.fournirFileTxtUTF8());
								this.enregistrerRapportCsvUTF8(
										this.fournirFileCsvUTF8());
								
							}
							
							/* retourne false, met this.estBloquant à true 
							 * et sort de la méthode 
							 * si un contrôle défavorable est bloquant. */
							if (estBloquantInterne) {
								
								this.estBloquant = true;
								
								return false;
								
							} // Fin de if (estBloquant)._______
							
						} // Fin de Si le contrôle est défavorable.__
						
						
						/* Passe le fichier résultat d'un contrôle 
						 * ou d'un traitement comme fichierAControler. */
						fichierAControler = controle.getFichierTraite();
												
					} // Fin de if (controle.isaEffectuer()).______
					
				} // Fin de if (controle != null)._______
				
			} // Fin de if (entry != null)._________
			
		} // Fin du Parcours de l'Iterator._____________________
		
		/* Enregistre le rapport de contrôle sur disque 
		 * si pEnregistrerRapport vaut true 
		 * et que le rapport est favorable. */
		if (pEnregistrerRapport) {
			
			this.enregistrerRapportTextuelUTF8(
					this.fournirFileTxtUTF8());
			this.enregistrerRapportCsvUTF8(
					this.fournirFileCsvUTF8());
			
		} // Fin de if (pEnregistrerRapport).____
		
		/* Retourne le boolean résultat. */
		return resultat;
		
	} // Fin de controler(
	// File pFile
	// , boolean pEnregistrerRapport)._____________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean controler(
			final String pString, final boolean pEnregistrerRapport) {
		return false;
	} // Fin de controler(
	 // String pString
	// , boolean pEnregistrerRapport)._____________________________________
	
	
	
	/**
	 * method remplirMapControles() :<br/>
	 * <ul>
	 * <li>Instancie chaque contrôle.</li><br/>
	 * <li>Remplit la SortedMap des Controles.</li><br/>
	 * </ul>
	 * <br/>
	 */
	private void remplirMapControles() {
		
		// Instancie chaque contrôle.*********************
		/* Instanciation d'un ControleurTypeTexte. */
		final IControle controleTypeTexte 
			= new ControleurTypeTexte(
					1, this.dateControle, this.userName, this.fichier);
		
		/* Instanciation d'un Transcodeur. */
		final IControle transcodeur 
			= new Transcodeur(
					2, this.dateControle, this.userName, this.fichier);
		
		final IControle controleurEncodage 
			= new ControleurEncodage(
					3, this.dateControle, this.userName, this.fichier
						, CHARSET_UTF8);
		
		/* Remplit la SortedMap des Controles. ***************/
		this.mapControles.put(1, controleTypeTexte);
		this.mapControles.put(2, transcodeur);
		this.mapControles.put(3, controleurEncodage);
		
	} // Fin de remplirMapControles()._____________________________________
	

		
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
						
						final String messageLog 
						= CLASSE_ABSTRACT_ENCHAINEUR_CONTROLES 
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
	 * method fournirDate(
	 * Date pDate) :<br/>
	 * - retourne la date système si pDate == null.<br/>
	 * - retourne pDate sinon.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * 
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
	 * au format dfDatetimemilliFrancaiseLexico.<br/>
	 * Format des dates-heures françaises lexicographique 
	 * avec millisecondes comme
	 * '1961-01-25_12-27-07-251'.<br/>
	 * "yyyy-MM-dd_HH-mm-ss-SSS".<br/>
	 * <br/>
	 * - retourne null si pDate == null.<br/>
	 * <br/>
	 *
	 * @param pDate : java.util.Date.<br/>
	 * 
	 * @return : String : "yyyy-MM-dd_HH-mm-ss-SSS".<br/>
	 */
	private String fournirDateFormattee(
			final Date pDate) {
		
		/* retourne null si pDate == null. */
		if (pDate == null) {
			return null;
		}
		
		final String dateFormattee 
			= this.dfDatetimemilliFrancaiseLexico.format(pDate);
		
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
	 * @param pUserName : String.<br/>
	 * 
	 * @return : String : pUserName si pas null ou 'Administrateur .<br/>
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
	 * retourne le nom court (sans tout le chemin) de pFile.<br/>
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
		
		/* retourne le nom court (sans tout le chemin) de pFile. */
		return pFile.getName();
		
	} // Fin de fournirNomFichier(
	 // File pFile)._______________________________________________________
	

	
	/**
	 * SERVICE ANNEXE.<br/>
	 * <br/>
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
	 * SERVICE ANNEXE.<br/>
	 * <br/>
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
		stb.append("ordre d'execution du contrôle;");
		stb.append("date du contrôle;");
		stb.append("utilisateur;");
		stb.append("Fichier;");
		stb.append("type de contrôle;");
		stb.append("Contrôle;");
		stb.append("Critère du Contrôle;");
		stb.append("Gravité du Contrôle;");
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
			
			/* Ajout du caractère BOM_UTF-8 pour 
			 * forcer Excel 2010 à détecter l'UTF-8. */
			stb.append(BOM_UTF_8);
			
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
	public final String getEnTeteRapportJTable(final int pI) {
		
		final LigneRapport ligne 
			= new LigneRapport();
				
		return ligne.getEnTeteColonne(pI);
		
	} // Fin de getEnTeteRapportJTable(
	// int pI).____________________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Object getValeurRapportJTable(
			final int pLigne
				, final int pColonne) {
		
		/* retourne null si this.rapport == null. */
		if (this.rapport == null) {
			return null;
		}
		
		return this.rapport.get(pLigne).getValeurColonne(pColonne);
		
	} // Fin de getValeurRapportJTable(
	// int pLigne
	// , int pColonne).____________________________________________________
	

	
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
		
		/* retrait de la ligne de rapport. */
		return this.rapport.remove(pLigneRapport);
		
	} // Fin de retirerLigneRapport(
	 // LigneRapport pLigneRapport)._______________________________________
	

	
	/**
	 * SERVICE ACCESSOIRE.<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	public final File enregistrerRapportTextuelANSI(
			final File pFichier) {
		
		return this.enregistrerRapportTextuel(
				this.rapport
				, this.dateControle
				, this.userName
				, "Enchaînement des Contrôles", pFichier, CHARSET_ANSI, NEWLINE);
		
	} // Fin de enregistrerRapportTextuelANSI(
	 // File pFichier).____________________________________________________
	
	
	
	/**
	 * SERVICE ACCESSOIRE.<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	public final File enregistrerRapportTextuelLatin9(
			final File pFichier) {
		
		return this.enregistrerRapportTextuel(
				this.rapport
				, this.dateControle
				, this.userName
				, "Enchaînement des Contrôles", pFichier, CHARSET_LATIN9, NEWLINE);
		
	} // Fin de enregistrerRapportTextuelLatin9(
	 // File pFichier).____________________________________________________
	
	
	
	/**
	 * SERVICE ACCESSOIRE.<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	public final File enregistrerRapportTextuelUTF8(
			final File pFichier) {
		
		return this.enregistrerRapportTextuel(
				this.rapport
				, this.dateControle
				, this.userName
				, "Enchaînement des Contrôles", pFichier, CHARSET_UTF8, NEWLINE);
		
	} // Fin de enregistrerRapportTextuelUTF8(
	 // File pFichier).____________________________________________________
	
	
	
	/**
	 * SERVICE ACCESSOIRE.<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	public final File enregistrerRapportTextuel(
			final List<LigneRapport> pRapportList
				, final Date pDateEnregistrement
					, final String pUserName
						, final String pObjet
							, final File pFichier
								, final Charset pCharset
									, final String pSautLigne) {
		
		/* retourne null si pFichier == null. */
		if (pFichier == null) {
			return null;
		}
		
		/* retourne null si pFichier est inexistant. */
		if (!pFichier.exists()) {
			return null;
		}
		
		/* retourne null si pFichier est un répertoire. */
		if (pFichier.isDirectory()) {
			return null;
		}
		
		/* retourne null si pRapportList == null. */
		if (pRapportList == null) {
			return null;
		}
		
		final EnregistreurFichiers enregistreur 
			= new EnregistreurFichiers(
					pDateEnregistrement, pUserName, pObjet, pFichier);
		
		String aEcrire = null;
		
		final StringBuilder stb = new StringBuilder();
		
		/* Constitution de la String à ecrire dans le fichier. */
		for (final LigneRapport ligne : pRapportList) {
			stb.append(ligne.toString());
			stb.append(pSautLigne);
		}
		
		aEcrire = stb.toString();
		
		final File resultat = enregistreur.ecrireStringDansFile(
				pFichier, aEcrire, pCharset, pSautLigne);
		
		/* Ajout du rapport d'enregistrement 
		 * de l'enregistreur à this.rapportEnregistrement. */
		this.ajouterARapportEnregistrement(enregistreur.getRapport());
		
		return resultat;
		
	} // Fin de enregistrerRapportTextuel(....).___________________________
	

	
	/**
	 * SERVICE ACCESSOIRE.<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	public final File enregistrerRapportCsvANSI(
			final File pFichier) {
		
		return this.enregistrerRapportCsv(
				this.rapport
				, this.dateControle
				, this.userName
				, "Enchaînement des Contrôles", pFichier, CHARSET_ANSI, NEWLINE
				, true);
		
	} // Fin de enregistrerRapportCsvANSI(
	// File pFichier)._____________________________________________________
	

	
	/**
	 * SERVICE ACCESSOIRE.<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	public final File enregistrerRapportCsvLatin9(
			final File pFichier) {
		
		return this.enregistrerRapportCsv(
				this.rapport
				, this.dateControle
				, this.userName
				, "Enchaînement des Contrôles", pFichier, CHARSET_LATIN9, NEWLINE
				, true);
		
	} // Fin de enregistrerRapportCsvLatin9(
	// File pFichier)._____________________________________________________
	

	
	/**
	 * SERVICE ACCESSOIRE.<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	public final File enregistrerRapportCsvUTF8(
			final File pFichier) {
		
		return this.enregistrerRapportCsv(
				this.rapport
				, this.dateControle
				, this.userName
				, "Enchaînement des Contrôles", pFichier, CHARSET_UTF8, NEWLINE
				, true);
		
	} // Fin de enregistrerRapportCsvUTF8(
	// File pFichier)._____________________________________________________
	
	
	
	/**
	 * SERVICE ACCESSOIRE.<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	public final File enregistrerRapportCsv(
			final List<LigneRapport> pRapportList
				, final Date pDateEnregistrement
					, final String pUserName
						, final String pObjet
							, final File pFichier
								, final Charset pCharset
									, final String pSautLigne
										, final boolean pEnteteCsv) {
		
		/* retourne null si pFichier == null. */
		if (pFichier == null) {
			return null;
		}
		
		/* retourne null si pFichier est inexistant. */
		if (!pFichier.exists()) {
			return null;
		}
		
		/* retourne null si pFichier est un répertoire. */
		if (pFichier.isDirectory()) {
			return null;
		}
		
		/* retourne null si pRapportList == null. */
		if (pRapportList == null) {
			return null;
		}
		
		/* Instanciation d'un service d'enregistrement 
		 * des fichiers sur disque. */
		final IEnregistreurFichiers enregistreur 
			= new EnregistreurFichiers(
					pDateEnregistrement, pUserName, pObjet, pFichier);
		
		String aEcrire = null;
		
		final StringBuilder stb = new StringBuilder();
		
		/* Constitution de la String à ecrire dans le fichier. */
		int compteur = 0;
		
		for (final LigneRapport ligne : pRapportList) {
			
			compteur++;
			
			/* Ajout d'un caractère BOM-UTF-8 si le Charset est UTF-8 
			 * pour forcer Excel 2010 à détecter l'UTF-8. */
			if (pCharset == CHARSET_UTF8) {
				stb.append(BOM_UTF_8);
			}
			
			/* Ajout de l'en-tête csv. */
			if (pEnteteCsv) {
				if (compteur == 1) {
					stb.append(ligne.getEnTeteCsv());
					stb.append(pSautLigne);
				}
			}
			
			
			stb.append(ligne.toCsv());
			stb.append(pSautLigne);
		}
		
		aEcrire = stb.toString();
		
		/* Ecriture du rapport de controle dans pFichier. */
		final File resultat = enregistreur.ecrireStringDansFile(
				pFichier, aEcrire, pCharset, pSautLigne);
		
		/* Ajout du rapport d'enregistrement 
		 * de l'enregistreur à this.rapportEnregistrement. */
		this.ajouterARapportEnregistrement(enregistreur.getRapport());
		
		return resultat;
		
	} // Fin de enregistrerRapportCsv(....)._______________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<LigneRapportEnregistrement> getRapportEnregistrement() {
		return this.rapportEnregistrement;
	} // Fin de getRapportEnregistrement().________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherRapportEnregistrementTextuel() {
		return this.afficherRapportEnregistrementTextuel(
				this.rapportEnregistrement);
	} // Fin de afficherRapportEnregistrementTextuel().____________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getMessagesEnregistrementsRapports() {
		
		/* retourne null si this.rapportEnregistrement == null. */
		if (this.rapportEnregistrement == null) {
			return null;
		}
		
		/* Instanciation d'un StringBuilder. */
		final StringBuilder stb = new StringBuilder();
		
		/* Parcours de this.rapportEnregistrement. */
		for (final LigneRapportEnregistrement ligne : this.rapportEnregistrement) {
			
			/* agrége les messages de création de rapport 
			 * de contrôle sur disque. */
			if (ligne != null) {
				
				stb.append(ligne.getMessage());
				stb.append(NEWLINE);	
				
			} // Fin de if (ligne != null).__________________
			
		} // Fin de Parcours de this.rapportEnregistrement.___________
		
		/* retour du résultat. */
		return stb.toString();
		
	} // Fin de getMessagesEnregistrementsRapports().______________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherRapportEnregistrementTextuel(
			final List<LigneRapportEnregistrement> pList) {
		
		/* retourne null si pList est null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final LigneRapportEnregistrement ligne : pList) {
			stb.append(ligne.toString());
			stb.append(NEWLINE);
		}
		
		return stb.toString();
		
	} // Fin de afficherRapportEnregistrementTextuel(
	 // List<LigneRapportEnregistrement> pList).___________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherRapportEnregistrementCsv() {
		return this.afficherRapportEnregistrementCsv(
				this.rapportEnregistrement, true);
	} // Fin de afficherRapportEnregistrementCsv().________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherRapportEnregistrementCsv(
			final List<LigneRapportEnregistrement> pList
				, final boolean pEnTete) {
		
		/* retourne null si pList est null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		int compteur = 0;
		
		for (final LigneRapportEnregistrement ligne : pList) {
			
			compteur++;
			
			/* Ajout d'un caractère BOM-UTF-8
			 * pour forcer Excel 2010 à détecter l'UTF-8. */
			stb.append(BOM_UTF_8);
			
			if (pEnTete) {
				if (compteur == 1) {
					stb.append(ligne.getEnTeteCsv());
					stb.append(NEWLINE);
				}
			}
			
			stb.append(ligne.toCsv());
			stb.append(NEWLINE);
		}
		
		return stb.toString();
		
	} // Fin de afficherRapportEnregistrementCsv(
	 // List<LigneRapportEnregistrement> pList
	 // , boolean pEnTete).________________________________________________

	
	
	/**
	 * method ajouterARapportEnregistrement(
	 * List&lt;LigneRapportEnregistrement&gt; pList) :<br/>
	 * Ajoute une List&lt;LigneRapportEnregistrement&gt; 
	 * à this.rapportEnregistrement.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;LigneRapportEnregistrement&gt;.<br/>
	 * 
	 * @return : boolean : true si pList à été ajoutée.<br/>
	 */
	private boolean ajouterARapportEnregistrement(
			final List<LigneRapportEnregistrement> pList) {
		
		if (this.rapportEnregistrement == null) {
			return false;
		}
		
		return this.rapportEnregistrement.addAll(pList);
		
	} // Fin de ajouterARapportEnregistrement(
	 // List<LigneRapportEnregistrement> pList).___________________________
	

	
	/**
	 * method fournirFileTxtUTF8() :<br/>
	 * Fournit un fichier pour enregistrer le rapport au 
	 * format textuel en UTF-8.<br/>
	 * <br/>
	 * - Récupère le chemin des rapports stocké dans 
	 * configurationapplication_fr_FR.properties si il existe
	 * , sinon, récupère le chemin en dur fourni 
	 * par this.fournirCheminRapportsEnDur().<br/>
	 * - Fabrique éventuellement l'arborescence du chemin des rapports
	 * (".\\data\\temp\\rapports" par exemple)<br/>
	 * - Fabrique le nom du fichier sous la forme 
	 * [date_nom_encodage.extension] 
	 * comme "1961-02-25_14-27-07_RAPPORT_UTF8.txt" par exemple<br/>
	 * - Fabrique et retourne le fichier 
	 * (.\data2\temp\rapports\1961-02-25_14-27-07_RAPPORT_UTF8.txt 
	 * par exemple).<br/>
	 * <br/>
	 *
	 * @return : File : Contient this.rapport au format textuel en UTF-8.<br/>
	 */
	protected final File fournirFileTxtUTF8() {
		
		/* Récupère le chemin des rapports stocké dans 
		 * configurationapplication_fr_FR.properties si il existe
		 * , sinon, récupère le chemin en dur fourni par 
		 * this.fournirCheminRapportsEnDur(). */
		final String cheminRapports = this.fournirCheminFichiers();
		
		if (StringUtils.isBlank(cheminRapports)) {
			return null;
		}
		
		/* - Fabrique éventuellement l'arborescence du chemin des rapports
		 * (".\\data\\temp\\rapports" par exemple)<br/>
		 * - Fabrique le nom du fichier sous la forme 
		 * [date_nom_encodage.extension] 
		 * comme "1961-02-25_14-27-07_RAPPORT_UTF8.txt" par exemple<br/>
		 * - Fabrique et retourne le fichier 
		 * (.\data2\temp\rapports\1961-02-25_14-27-07_RAPPORT_UTF8.txt 
		 * par exemple).<br/>*/
		final File resultat 
			= this.fournirFile(
					cheminRapports
						, this.dateControle
							, this.fournirBaseNomRapport() + UNDERSCORE + this.nomFichier
								, "UTF8"
									, "txt");
		
		return resultat;
		
	} // Fin de fournirFileTxtUTF8().______________________________________
	
	
	
	/**
	 * method fournirFileCsvUTF8() :<br/>
	 * Fournit un fichier pour enregistrer le rapport au 
	 * format csv en UTF-8.<br/>
	 * <br/>
	 * - Récupère le chemin des rapports stocké dans 
	 * configurationapplication_fr_FR.properties si il existe
	 * , sinon, récupère le chemin en dur fourni 
	 * par this.fournirCheminRapportsEnDur().<br/>
	 * - Fabrique éventuellement l'arborescence du chemin des rapports
	 * (".\\data\\temp\\rapports" par exemple)<br/>
	 * - Fabrique le nom du fichier sous la forme 
	 * [date_nom_encodage.extension] 
	 * comme "1961-02-25_14-27-07_RAPPORT_UTF8.txt" par exemple<br/>
	 * - Fabrique et retourne le fichier 
	 * (.\data2\temp\rapports\1961-02-25_14-27-07_RAPPORT_UTF8.txt 
	 * par exemple).<br/>
	 * <br/>
	 *
	 * @return : File : Contient this.rapport au format textuel en UTF-8.<br/>
	 */
	protected final File fournirFileCsvUTF8() {
		
		/* Récupère le chemin des rapports stocké dans 
		 * configurationapplication_fr_FR.properties si il existe
		 * , sinon, récupère le chemin en dur fourni par 
		 * this.fournirCheminRapportsEnDur(). */
		final String cheminRapports = this.fournirCheminFichiers();
		
		if (StringUtils.isBlank(cheminRapports)) {
			return null;
		}
		
		/* - Fabrique éventuellement l'arborescence du chemin des rapports
		 * (".\\data\\temp\\rapports" par exemple)<br/>
		 * - Fabrique le nom du fichier sous la forme 
		 * [date_nom_encodage.extension] 
		 * comme "1961-02-25_14-27-07_RAPPORT_UTF8.txt" par exemple<br/>
		 * - Fabrique et retourne le fichier 
		 * (.\data2\temp\rapports\1961-02-25_14-27-07_RAPPORT_UTF8.txt 
		 * par exemple).<br/>*/
		final File resultat 
			= this.fournirFile(
					cheminRapports
						, this.dateControle
							, this.fournirBaseNomRapport()+ UNDERSCORE + this.nomFichier
								, "UTF8"
									, "csv");
		
		return resultat;
		
	} // Fin de fournirFileTxtUTF8().______________________________________
	
	
		
	/**
	 * method fournirBaseNomRapport() :<br/>
	 * Fournit la base du nom pour créer 
	 * les fichiers de stockage des rapports.<br/>
	 * Par exemple : <br/>
	 * "RAPPORT_TOUS_CONTROLES".<br/>
	 * <br/>
	 *
	 * @return : String : Nom de base des fichiers de rapport.<br/>
	 */
	protected final String fournirBaseNomRapport() {
		return "RAPPORT_TOUS_CONTROLES";
	} // Fin de fournirBaseNomRapport().___________________________________
	
	
	
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
	private String fournirCheminFichiers() {
		return fournirCheminFichiers(null);
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
	private String fournirCheminFichiers(
			final String pCheminFichiers) {
		
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
		
	} // Fin de fournirCheminFichiers(
	 // String pCheminFichiers).___________________________________________
	
	
	
	/**
	 * method fournirCleCheminRapports() :<br/>
	 * Fournit la clé dans configurationapplication_fr_FR.properties 
	 * associée au chemin des rapports.<br/>
	 * <br/>
	 * "AbstractEnchaineurControles.fournirCheminFichiers.cheminrapports".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "AbstractEnchaineurControles.fournirCheminFichiers.cheminrapports".<br/>
	 */
	private String fournirCleCheminRapports() {
		return "AbstractEnchaineurControles.fournirCheminFichiers.cheminrapports";
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
	private String fournirCheminRapportsDansProperties() {
	
		String chemin = null;
		
		try {
			
			/* Charge le ResourceBundle encapsulant 
			 * configurationapplication_fr_FR.properties*/
			final ResourceBundle bundle 
				= ResourceBundle.getBundle(
						"configurationapplication", LOCALE_FR_FR);
			
			/* retourne null si bundle == null. */
			if (bundle == null) {
				return null;
			}
			
			chemin = bundle.getString(this.fournirCleCheminRapports());
			
		} catch (Exception e) {
			
			final String message 
			= "./bin/configurationapplication_fr_FR.properties "
					+ "est manquant ou la clé n'existe pas - Exception : ";
			
			/* LOG de niveau INFO. */
			loggerInfo(
					CLASSE_ABSTRACT_ENCHAINEUR_CONTROLES
					, METHODE_FOURNIRCHEMINRAPPORTSDANSPROPERTIES
					, message
					, e.getMessage());
			
			/* retourne null si 
			 * ./bin/configurationapplication_fr_FR.properties 
			 * est manquant. */
			return null;
		}
		
		return chemin;
				
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
	private String fournirCheminRapportsEnDur() {
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
	private File fournirFile(
			final String pChemin
				, final Date pDate
					, final String pNomFichier
						, final String pEncodage
							, final String pExtension) {
		
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
						CLASSE_ABSTRACT_ENCHAINEUR_CONTROLES
							, METHODE_FOURNIRFILE
								, ioe);
				
				/* retourne null (et LOG ERROR) si il se produit 
				 * une Exception lors de la création du fichier. */
				return null;
				
			}
		}
		
		return resultatFile;
			
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
	 * "25/02/1961-14:27:07.251", dfDatetimemilliFrancaiseLexico);</code> 
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
	private String fournirNomFichier(
			final Date pDate
				, final String pNom
					, final String pEncodage
						, final String pExtension) {
		
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
			= fournirDateFormattee(date, this.dfDatetimemilliFrancaiseLexico);
		
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
	private String fournirDateFormattee(
			final Date pDate
				, final DateFormat pDateFormat) {
					
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
	private boolean creerArborescence(
			final String pChemin) {
		
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
	public final boolean detruireArborescence(
			final String pChemin) {
		
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
					CLASSE_ABSTRACT_ENCHAINEUR_CONTROLES
						, METHODE_DETRUIRE_ARBORESCENCE
							, e.getMessage());
			
			return false;
			
		}
				
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
	public final boolean viderRepertoireADetruire(
			final File pRep) {
				
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
						CLASSE_ABSTRACT_ENCHAINEUR_CONTROLES
							, METHODE_VIDER_REPERTOIRE
								, e.getMessage());
				return false;
				
			}
								
		} // Fin du ForEach (boucle) sur les File de pRep.___
		
		return true;
		
	} // Fin de viderRepertoireADetruire(
	 // File pRep).________________________________________________________
	

	
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


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final SortedMap<Integer, IControle> getMapControles() {
		return this.mapControles;
	} // Fin de getMapControles()._________________________________________


	
} // FIN DE LA CLASSE AbstractEnchaineurControles.---------------------------
