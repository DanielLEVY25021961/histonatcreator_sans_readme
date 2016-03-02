package levy.daniel.application.metier.controles;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import levy.daniel.application.ILecteurDecodeurFile;
import levy.daniel.application.IListeurDeCaracteresUnicode;

/**
 * Interface IControle :<br/>
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
 * Charset de décodage pCharset, lireFichier(File pFile)<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * levy.daniel.application.ILecteurDecodeurFile.<br/>
 * levy.daniel.application.IListeurDeCaracteresUnicode.<br/>
 * levy.daniel.application.metier.controles.IRapporteurControle<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 29 févr. 2016
 *
 */
public interface IControle extends IRapporteurControle
			, ILecteurDecodeurFile, IListeurDeCaracteresUnicode {

	/**
	 * LOCALE_FR_FR : Locale :<br/>
	 * new Locale("fr", "FR").<br/>
	 */
	Locale LOCALE_FR_FR = new Locale("fr", "FR");

	
	/**
	 * DF_DATETIMEMILLI_FRANCAISE : DateFormat :<br/>
	 * Format des dates-heures françaises avec millisecondes comme
	 * '25/02/1961-12:27:07.251'.<br/>
	 * "dd/MM/yyyy-HH:mm:ss.SSS".<br/>
	 */
	DateFormat DF_DATETIMEMILLI_FRANCAISE = new SimpleDateFormat(
			"dd/MM/yyyy-HH:mm:ss.SSS", LOCALE_FR_FR);

	
	/**
	 * NEWLINE : String :<br/>
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	String NEWLINE = System.getProperty("line.separator");
	
		
	/**
	 * CARACTERE_REMPLACEMENT : char :<br/>
	 * Caractère de remplacement introduit lors de la lecture en UTF-8 
	 * d'un fichier texte encodé avec un autre Charset.<br/>
	 * REPLACEMENT CHARACTER."\\ufffd" '�'.<br/> 
	 */
	char CARACTERE_REMPLACEMENT = '\ufffd';
	
	
	/**
	 * SEP_MOINS : String :<br/>
	 * " - ".<br/>
	 */
	String SEP_MOINS = " - ";
	
	
	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	String NULL = "null";
	
	
	/**
	 * SANS_OBJET : String :<br/>
	 * "sans objet".<br/>
	 */
	String SANS_OBJET = "sans objet";
	
	
	/**
	 * TOUS : String :<br/>
	 * "tous".<br/>
	 */
	String TOUS = "tous";
	
	
	/**
	 * METHODE_LIREFICHIER : String :<br/>
	 * "Méthode lireFichier(File pFile, Charset pCharset)".<br/>
	 */
	String METHODE_LIREFICHIER 
		= "Méthode lireFichier(File pFile, Charset pCharset)";

	
	/**
	 * MESSAGE_FICHIER_NULL : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est null.<br/>
	 * "Le fichier passé en paramètre est null".<br/>
	 */
	String MESSAGE_FICHIER_NULL 
		= "Le fichier passé en paramètre est null";

	
	/**
	 * MESSAGE_FICHIER_INEXISTANT : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est inexistant.<br/>
	 * "Le fichier passé en paramètre est inexistant : "
	 */
	String MESSAGE_FICHIER_INEXISTANT 
		= "Le fichier passé en paramètre est inexistant : ";

	
	/**
	 * MESSAGE_FICHIER_REPERTOIRE : String :<br/>
	 * Message retourné par la méthode lireFichier(File pFile) 
	 * si le fichier est un répertoire.<br/>
	 * "Le fichier passé en paramètre est un répertoire : ".<br/>
	 */
	String MESSAGE_FICHIER_REPERTOIRE 
		= "Le fichier passé en paramètre est un répertoire : ";


	/**
	 * ACTION_FICHIER_REFUSE : String :<br/>
	 * "Fichier refusé".<br/>
	 */
	String ACTION_FICHIER_REFUSE = "Fichier refusé";

	
	
	/**
	 * method controler(
	 * File pFile) :<br/>
	 * SERVICE PRINCIPAL.<br/>
	 * Contrôle d'un fichier.<br/>
	 * Vérifie qu'un fichier passe un contrôle.<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier dont on veut savoir 
	 * si il passe le contrôle.<br/>
	 * 
	 * @return : boolean : true si pFile passe le contrôle.<br/>
	 */
	boolean controler(
			final File pFile);
	
	
	
	/**
	 * method controler(
	 * String pString) :<br/>
	 * SERVICE PRINCIPAL.<br/>
	 * Contrôle d'une String.<br/>
	 * Vérifie qu'une String passe un contrôle.<br/>
	 * <br/>
	 *
	 * @param pString : String : chaîne de caractères dont on veut savoir 
	 * si elle passe le contrôle.<br/>
	 * 
	 * @return : boolean : true si pString passe le contrôle.<br/>
	 */
	boolean controler(
			final String pString);
	

	
	/**
	 * method getDateControle() :<br/>
	 * Getter de la java.util.Date du contrôle.<br/>
	 * <br/>
	 *
	 * @return dateControle : Date.<br/>
	 */
	Date getDateControle();
	
	

	/**
	 * method setDateControle(
	 * Date pDateControle) :<br/>
	 * Setter de la java.util.Date du contrôle.<br/>
	 * <br/>
	 * - calcule automatiquement dateControleStringFormattee.<br/>
	 * <br/>
	 *
	 * @param pDateControle : Date : valeur à passer à dateControle.<br/>
	 */
	void setDateControle(Date pDateControle);
	
	

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
	String getDateControleStringFormatee();
	
	

	/**
	 * method getUserName() :<br/>
	 * Getter du nom de l'utilisateur qui a déclenché le contrôle.<br/>
	 * <br/>
	 *
	 * @return userName : String.<br/>
	 */
	String getUserName();
	
	

	/**
	 * method setUserName(
	 * String pUserName) :<br/>
	 * Setter du nom de l'utilisateur qui a déclenché le contrôle.<br/>
	 * <br/>
	 * remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.<br/>
	 * <br/>
	 *
	 * @param pUserName : String : 
	 * valeur à passer à userName.<br/>
	 */
	void setUserName(String pUserName);
	
	

	/**
	 * method getFichier() :<br/>
	 * Getter du fichier sur lequel s'applique le contrôle.<br/>
	 * <br/>
	 *
	 * @return fichier : File.<br/>
	 */
	File getFichier();
	
	

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
	void setFichier(File pFichier);
	
	

	/**
	 * method getNomFichier() :<br/>
	 * Getter du nom du fichier objet du contrôle.<br/>
	 * <br/>
	 *
	 * @return nomFichier : String.<br/>
	 */
	String getNomFichier();

	
	
	/**
	 * method getTypeControle() :<br/>
	 * Getter du type du contrôle ('contrôle de surface' par exemple).<br/>
	 * <br/>
	 *
	 * @return typeControle : String.<br/>
	 */
	String getTypeControle();

	
	
	/**
	 * method getNomControle() :<br/>
	 * Getter du nom du contrôle ('contrôle fichier texte' par exemple).<br/>
	 * <br/>
	 *
	 * @return nomControle : String.<br/>
	 */
	String getNomControle();

	
	
	/**
	 * method getNomCritere() :<br/>
	 * Getter du nom du critère appliqué dans le contrôle 
	 * ('le fichier ne doit pas comporter de 
	 * caractères indésirables' par exemple).<br/>
	 * <br/>
	 *
	 * @return nomCritere : String.<br/>
	 */
	String getNomCritere();
	
	

	/**
	 * method getGravite() :<br/>
	 * Getter de la désignation de la gravité de ce contrôle 
	 * (par exemple '1 - bloquant').<br/>
	 * <br/>
	 *
	 * @return gravite : String.<br/>
	 */
	String getGravite();
	
	

	/**
	 * method getNiveauAnomalie() :<br/>
	 * Getter du Niveau de l'anomalie correspondant au Contrôle
	 * dans le messagescontroles_fr_FR.properties.<br/>
	 * Par exemple : "1" pour le ControleurTypeTexte.<br/>
	 * <br/>
	 *
	 * @return niveauAnomalie : String.<br/>
	 */
	String getNiveauAnomalie();

	
	
	/**
	 * method isEstBloquant() :<br/>
	 * Getter du boolean qui stipule si le contrôle doit pouvoir 
	 * bloquer le programme.<br/>
	 * <br/>
	 *
	 * @return estBloquant : boolean.<br/>
	 */
	boolean isEstBloquant();
	
	

} // FIN DE L'INTERFACE IControle.-------------------------------------------