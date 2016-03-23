package levy.daniel.application;

import javax.persistence.Transient;

/**
 * Interface IExportateurJTable :<br/>
 * Interface qui garantit que tous les objets qui 
 * l'implémentent pourront être exportés dans des JTable.<br/>
 * <br/>
 * <ul>
 * comporte : <br/>
 * <li>une méthode getEnTeteColonne(int pI) qui fournit 
 * l'en-tête de la pI-ème colonne (0-based) de l'objet.</li><br/>
 * <li>une méthode getValeurColonne(int pI) qui fournit la valeur 
 * de la pI-ème colonne (0-based) de l'objet.</li><br/>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * JTable, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * .\lib\javax.persistence.Transient pour l'annotation Transient 
 * provenant de hibernate-jpa-2.0-api-1.0.0.Final.jar.<br/>
 * .\lib_doc\hibernate-jpa-2.0-api-1.0.1.Final-sources.jar 
 * pour la documentation de javax.persistence.Transient pour 
 * l'annotation Transient provenant 
 * de hibernate-jpa-2.0-api-1.0.0.Final.jar.<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 17 juin 2014
 *
 */
public interface IExportateurJTable {
	
		
	/**
	* method getEnTeteColonne(
	* int pI) :<br/>
	* Fournit l'en-tête de la pIème colonne (0-based) 
	* pour affichage dans une JTable par exemple.<br/>
	* <br/>
	* Suit l'ordre défini dans le csv.<br/>
	* <br/>
	*
	* @param pI : int : pIème colonne (0 - based).<br/>
	* 
	* @return : String : En-tête de la pIème colonne (0 - based).<br/>
	*/
	@Transient
	String getEnTeteColonne(
					final int pI);
	
	
	
	/**
	* method getValeurColonne(
	* int pI) :<br/>
	* Fournit la valeur de la pIème colonne (0-based) 
	* pour affichage dans une JTable par exemple.<br/>
	* <br/>
	* Suit l'ordre défini dans le csv.<br/>
	* <br/>
	*
	* @param pI : int : pIème colonne (0 - based).<br/>
	* 
	* @return : Object : valeur de la pIème colonne (0 - based).<br/>
	*/
	@Transient
	Object getValeurColonne(
			final int pI);
	
	
	
} // FIN DE L'INTERFACE IExportateurJTable.----------------------------------
