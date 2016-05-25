package levy.daniel.application.metier.services.enregistreursfichiers;

import java.util.List;

import levy.daniel.application.metier.services.enregistreursfichiers.rapportsenregistrements.LigneRapportEnregistrement;


/**
 * Interface IRapporteurEnregistrement :<br/>
 * Interface servant à isoler les méthodes 
 * liées aux rapports émis par les EnregistreursFichiers.<br/>
 * Un rapport d'Enregistreur de fichier 
 * est une List&lt;LigneRapportEnregistrement&gt;.<br/>
 * Un rapport d'enregistrement doit pouvoir 
 * être affiché sous forme csv ou dans une JTable.<br/>
 * <br/>
 * <ul>
 * comporte essentiellement : <br/>
 * <li>une méthode afficherRapportTextuel(
 * List&lt;LigneRapportEnregistrement&gt; pList) 
 * qui permet d'afficher un rapport d'enregistrement 
 * sous forme de String.</li><br/>
 * <li>une méthode getEnTeteCsv() qui fournit l'en-tête  
 * d'un rapport d'enregistrement au format csv.</li><br/>
 * <li>une méthode afficherRapportCsv(
 * List&lt;LigneRapportEnregistrement&gt; pList
 * , boolean pAjouterEntete) qui fournit 
 * un rapport d'enregistrement au format csv.</li><br/>
 * <li>une méthode getEnTeteRapportJTable(int pI) 
 * qui fournit l'en-tête de la pI-ème colonne (0 - based) 
 * du rapport d'enregistrement sous forme de String 
 * pour affichage dans une JTable.</li><br/>
 * <li>une méthode getValeurRapportJTable(int pLigne, int pColonne) 
 * qui fournit la valeur d'un rapport d'enregistrement sous forme d'Object 
 * pour affichage dans une JTable.</li><br/>
 * <li>une méthode getRapport() qui fournit 
 * un rapport d'enregistrement sous forme de 
 * List&lt;LigneRapportEnregistrement&gt;.</li><br/>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * csv, JTable,<br/> 
 * rapport sur l'exécution d'un enregistrement de fichier sur disque,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * levy.daniel.application.IExportateurCsv 
 * (sous-entendu, pas d'implémentation directe).<br/>
 * levy.daniel.application.IExportateurJTable 
 * (sous-entendu, pas d'implémentation directe).<br/>
 * levy.daniel.application.IResetable 
 * (sous-entendu, pas d'implémentation directe).<br/>
 * levy.daniel.application.metier.services.enregistreursfichiers.rapportsenregistrements.LigneRapportEnregistrement.<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 3 mars 2016
 *
 */
public interface IRapporteurEnregistrement {
	
	
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
	String afficherRapportTextuel();
	

	
	/**
	 * method afficherRapportTextuel(
	 * List&lt;LigneRapportEnregistrement&gt; pList) :<br/>
	 * Affichage dans la console d'une List&lt;LigneRapportEnregistrement&gt; 
	 * au format textuel.<br/>
	 * <br/>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;LigneRapportEnregistrement&gt;.<br/>
	 * 
	 * @return : String : String pour affichage au format textuel.<br/>
	 */
	String afficherRapportTextuel(
			final List<LigneRapportEnregistrement> pList);
	
	

	/**
	 * retourne : <br/>
	 * "id;date de l'enregistrement;utilisateur;Objet;Fichier;
	 * Message de l'enregistrement;Chemin du fichier enregistré;
	 * Statut de l'enregistrement;".<br/>
	 * <br/>
	 * @return String : en-tête du rapport csv.<br/>
	 */
	String getEnTeteCsv();
	
	

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
	String afficherRapportCsv();
	
	

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
	String afficherRapportCsvAvecEntete();
	
	

	/**
	 * method afficherRapportCsv(
	 * List&lt;LigneRapportEnregistrement&gt; pList
	 * , boolean pAjouterEntete) :<br/>
	 * Affichage dans la console d'une List&lt;LigneRapportEnregistrement&gt; 
	 * au format csv.<br/>
	 * <br/>
	 * - ajoute l'en-tête du rapport csv si pAjouterEntete vaut true.<br/>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;LigneRapportEnregistrement&gt;.<br/>
	 * @param pAjouterEntete 
	 * 
	 * @return : String : String pour affichage au format csv.<br/>
	 */
	String afficherRapportCsv(
			final List<LigneRapportEnregistrement> pList
				, final boolean pAjouterEntete);
	

	
	/**
	 * method getEnTeteRapportJTable(
	 * int pI) :<br/>
	 * Fournit l'en-tête de la pI-ème colonne (0-based) 
	 * pour l'affichage d'un rapport dans une JTable.<br/>
	 * <br/>
	 *
	 * @param pI : int : colonne (0-based).<br/>
	 * 
	 * @return : String : En-tête de la pI-ème 
	 * colonne (0-based) d'une JTable.<br/>
	 */
	String getEnTeteRapportJTable(final int pI);
	

	
	/**
	 * method getValeurRapportJTable(
	 * int pLigne
	 * , int pColonne) :<br/>
	 * Fournit la valeur de la cellule située 
	 * à la pLigne-ème ligne (0-based) 
	 * et à la pColonne-ème colonne (0-based) 
	 * pour l'affichage d'un rapport dans une JTable.<br/>
	 * <br/>
	 * - retourne null si this.rapport == null.<br/>
	 * <br/>
	 *
	 * @param pLigne : int : ligne (0-based).<br/>
	 * @param pColonne : int : colonne (0-based).<br/>
	 * 
	 * @return : Object : Valeur du rapport dans la cellule.<br/>
	 */
	Object getValeurRapportJTable(final int pLigne, final int pColonne);
	

	
	/**
	 * method getRapport() :<br/>
	 * Getter du rapport fourni par l'enregistreur sous forme 
	 * de List&lt;LigneRapportEnregistrement&gt;.<br/>
	 * <br/>
	 *
	 * @return rapport : List&lt;LigneRapportEnregistrement&gt;.<br/>
	 */
	List<LigneRapportEnregistrement> getRapport();
	


} // FIN DE L'INTERFACE IRapporteurEnregistrement.---------------------------
