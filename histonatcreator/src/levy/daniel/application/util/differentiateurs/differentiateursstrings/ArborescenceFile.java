package levy.daniel.application.util.differentiateurs.differentiateursstrings;

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class ArborescenceFile :<br/>
 * Encapsulation permettant de stocker 
 * toutes les grandeurs intéressantes 
 * de l'arborescence sous un File 'this.file' 
 * (fichiers 'en dessous' de this.file) 
 * dans un système de fichier.<br/>
 * Utile pour détruire des fichiers, renommer des fichiers, ... <br/>
 * On ne peut pas détruire en java 
 * une arborescence si elle n'est pas vide par exemple, 
 * d'où le besoin de connaitre tous les fichiers de l'arborescence.<br/>
 * <br/>
 * Cette encapsulation contient : <br/>
 * - this.file : le file dont on veut connaitre la sous-arborescence.<br/>
 * - this.fileParent : le parent éventuel de this.file 
 * dans l'arborescence à décrire si this.file 
 * n'est pas la racine de l'arborescence à décrire.<br/>
 * - this.niveau : Niveau de this.file dans l'arborescence 
 * à décrire par rapport à la racine de l'arborescence à décrire.<br/>
 * - estRepertoire : boolean qui précise si this.file est un répertoire.<br/>
 * - estVide : boolean qui précise si this.file est vide 
 * (pas de descendants).<br/>
 * - listeSousRepertoires : Liste des sous-répertoires de this.file.<br/>
 * - listeSousFichiersSimples : Liste des sous-fichiers simples 
 * (pas répertoires) de this.file.<br/>
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
 * @since 9 févr. 2016
 *
 */
public class ArborescenceFile {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * serialVersionUID : long :<br/>
	 * 1L.<br/>
	 */
	private static final long serialVersionUID = 1L;
		
	
	/**
	 * id : Long :<br/>
	 * Identifiant en base de l'objet métier
	 */
	private Long id;

	/**
	 * file : File :<br/>
	 * File dont on veut connaitre la sous-arborescence 
	 * (répertoires et fichiers simples en dessous de this.file).<br/>
	 */
	private File file;
	
	/**
	 * fileParent : File :<br/>
	 * File parent de this.file dans l'arborescence à décrire
	 * si this.file n'est pas la racine de l'arborescence à décrire.<br/>
	 */
	private File fileParent;
	
	/**
	 * niveau : int :<br/>
	 * Niveau de this.file dans l'arborescence à décrire 
	 * par rapport à la racine de l'arborescence à décrire.<br/>
	 */
	private int niveau;
		
	/**
	 * estRepertoire : boolean :<br/>
	 * Indicateur du fait que this.file est un répertoire.<br/>
	 * - true si this.file est un répertoire.<br/>
	 */
	private boolean estRepertoire;
	
	/**
	 * estVide : boolean :<br/>
	 * Indicateur du fait que this.file est vide (pas de descendants).<br/>
	 * N'a d'intérêt que si this.file est un répertoire.<br/>
	 * - true si this.file est vide.<br/>
	 */
	private boolean estVide;
	
	
	/**
	 * listeSousRepertoires : List&lt;File&gt; :<br/>
	 * Liste des sous-répertoires de this.file.<br/>
	 */
	private List<File> listeSousRepertoires;
	
	
	/**
	 * listeSousFichiersSimples : List<File> :<br/>
	 * Liste des sous-fichiers simples (pas répertoires) de this.file.<br/>
	 */
	private List<File> listeSousFichiersSimples;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(ArborescenceFile.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ArborescenceFile() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ArborescenceFile() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
} // FIN DE LA CLASSE ArborescenceFile.--------------------------------------
