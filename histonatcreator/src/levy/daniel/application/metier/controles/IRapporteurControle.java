package levy.daniel.application.metier.controles;

import java.util.List;

import levy.daniel.application.metier.controles.rapportscontroles.LigneRapport;


/**
 * Interface IRapporteurControle :<br/>
 * Interface servant à isoler les méthodes 
 * liées aux rapports émis par les Contrôles.<br/>
 * Un rapport de Contrôle de fichier
 * est une List&lt;LigneRapport&gt;.<br/>
 * Un rapport de contrôle doit pouvoir 
 * être affiché sous forme csv ou dans une JTable.<br/>
 * <br/>
 * <ul>
 * comporte essentiellement : <br/>
 * <li>une méthode afficherRapportTextuel(
 * List&lt;LigneRapport&gt; pList) 
 * qui permet d'afficher un rapport de contrôle 
 * sous forme de String.</li><br/>
 * <li>une méthode getEnTeteCsv() qui fournit l'en-tête  
 * d'un rapport de contrôle au format csv.</li><br/>
 * <li>une méthode afficherRapportCsv(
 * List&lt;LigneRapport&gt; pList
 * , boolean pAjouterEntete) qui fournit 
 * un rapport de contrôle au format csv.</li><br/>
 * <li>une méthode getEnTeteRapportJTable(int pI) 
 * qui fournit l'en-tête de la pI-ème colonne (0 - based) 
 * du rapport de contrôle sous forme de String 
 * pour affichage dans une JTable.</li><br/>
 * <li>une méthode getValeurRapportJTable(int pLigne, int pColonne) 
 * qui fournit la valeur d'un rapport de contrôle sous forme d'Object 
 * pour affichage dans une JTable.</li><br/>
 * <li>une méthode getRapport() qui fournit 
 * un rapport de contrôle sous forme de 
 * List&lt;LigneRapport&gt;.</li><br/>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * csv, JTable,<br/> 
 * rapport sur l'exécution d'un contrôle de fichier,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * levy.daniel.application.IExportateurCsv 
 * (sous-entendu, pas d'implémentation directe).<br/>
 * levy.daniel.application.IExportateurJTable 
 * (sous-entendu, pas d'implémentation directe).<br/>
 * levy.daniel.application.IResetable 
 * (sous-entendu, pas d'implémentation directe).<br/>
 * levy.daniel.application.metier.controles.rapportscontroles.LigneRapport.<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 29 févr. 2016
 *
 */
public interface IRapporteurControle {
	
	
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
	String afficherRapportTextuel(List<LigneRapport> pList);
	
	

	/**
	 * retourne : <br/>
	 * "id;ordre d'execution du contrôle;date du contrôle;utilisateur;Fichier;
	 * type de contrôle;Contrôle;Critère;Gravité;
	 * Numéro de Ligne;Message du Contrôle;Ordre du Champ;Position du Champ;
	 * Valeur du Champ;Action;"<br/>
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
	String afficherRapportCsv(
			final List<LigneRapport> pList
				, final boolean pAjouterEntete);
	
	
	
	/**
	 * method getEnTeteRapportJTable() :<br/>
	 * Fournit l'en-tête de la pI-ème colonne 0-based 
	 * pour l'affichage d'un rapport dans une JTable.<br/>
	 * <br/>
	 *
	 * @param pI : int : colonne 0-based.<br/>
	 * 
	 * @return : String : En-tête de la pI-ème 
	 * colonne 0-based d'une JTable.<br/>
	 */
	String getEnTeteRapportJTable(final int pI);
	

	
	/**
	 * method getValeurRapportJTable(
	 * int pLigne
	 * , int pColonne) :<br/>
	 * Fournit la valeur de la cellule située 
	 * à la pLigne-ème ligne 0-based 
	 * et à la pColonne-ème colonne 0-based 
	 * pour l'affichage d'un rapport dans une JTable.<br/>
	 * <br/>
	 * - retourne null si this.rapport == null.<br/>
	 * <br/>
	 *
	 * @param pLigne : int : ligne 0-based.<br/>
	 * @param pColonne : int : colonne 0-based.<br/>
	 * 
	 * @return : Object : Valeur du rapport dans la cellule.<br/>
	 */
	Object getValeurRapportJTable(final int pLigne, final int pColonne);
	


	/**
	 * method getRapport() :<br/>
	 * Getter du rapport fourni par le contrôle sous forme 
	 * de List&lt;LigneRapport&gt;.<br/>
	 * <br/>
	 *
	 * @return rapport : List&lt;LigneRapport&gt;.<br/>
	 */
	List<LigneRapport> getRapport();
	

	

} // FIN DE INTERFACE IRapporteurControle.-----------------------------------
