package levy.daniel.application.metier.controles;

import java.util.List;

import levy.daniel.application.metier.rapportscontroles.LigneRapport;


/**
 * Interface IRapporteurControle :<br/>
 * Abstraction servant à isoler les méthodes 
 * liées aux rapports émis par les Controles.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * levy.daniel.application.metier.rapportscontroles.LigneRapport.<br/>
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
	 * "id;date du contrôle;utilisateur;Fichier;type de contrôle;
	 * Contrôle;Critère;Gravité;
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
	 * method getRapport() :<br/>
	 * Getter du rapport fourni par le contrôle sous forme 
	 * de List&lt;LigneRapport&gt;.<br/>
	 * <br/>
	 *
	 * @return rapport : List&lt;LigneRapport&gt;.<br/>
	 */
	List<LigneRapport> getRapport();
	

	

} // FIN DE INTERFACE IRapporteurControle.-----------------------------------
