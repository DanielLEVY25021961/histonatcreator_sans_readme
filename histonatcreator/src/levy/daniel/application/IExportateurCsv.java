package levy.daniel.application;

import javax.persistence.Transient;

/**
 * Interface IExportateurCsv :<br/>
 * Interface qui garantit que tous les objets qui 
 * l'implémentent pourront être exportés au format csv 
 * afin d'être affichés dans n'importe quel tableur (Excel, Calc, ...).<br/>
 * <br/>
 * <ul>
 * comporte : <br/>
 * <li>une méthode getEnTeteCsv() qui fournit 
 * la ligne d'en-tête csv de l'objet.</li><br/>
 * <li>une méthode toCsv() qui fournit la ligne des valeurs  
 * de l'objet au format csv.</li><br/>
 * </ul>
 * <br/>
 * 
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * csv,<br/>
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
public interface IExportateurCsv {
	
	
	/**
	 * method getEnTeteCsv() :<br/>
	 * Fournit l'en-tête des lignes csv.<br/>
	 * <br/>
	 * Pourrait être static dans l'absolu, 
	 * mais ne pourrait alors plus figurer dans l'interface. 
	 * L'idée est de pouvoir demander à n'importe quel objet métier 
	 * de fournir son en-tête de fichier csv.<br/>
	 *
	 * @return : String : en-tête de l'objet en csv.<br/>
	 */
	@Transient
	String getEnTeteCsv();

	
	
	/**
	 * method toCsv() :<br/>
	 * Fournit le ValueObject sous forme de ligne Csv.<br/>
	 * <br/>
	 *
	 * @return : String.<br/>
	 */
	@Transient
	String toCsv();



} // FIN DE L'INTERFACE IExportateurCsv.-------------------------------------
