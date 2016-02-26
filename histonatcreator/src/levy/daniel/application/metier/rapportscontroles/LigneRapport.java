package levy.daniel.application.metier.rapportscontroles;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class LigneRapport :<br/>
 * Encapsulation dans laquelle tous les contrôles 
 * (contrôle du fait qu'un fichier est bien un fichier texte
 * , contrôle du fait qu'un fichier est bien en UTF-8, ...) 
 * vont écrire leur résultat de contrôle.<br/>
 * <br/>
 * Cette encapsulation comprend les attributs : <br/>
 * [dateControle;userName;nomFichier;typeControle;nomControle;critere;gravite;numeroLigne;messageControle;ordreChamp;positionChamp;action;]<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 26 févr. 2016
 *
 */
public class LigneRapport {

	// ************************ATTRIBUTS************************************/

	/**
	 * dateControle : String :<br/>
	 * date d'exécution du contrôle.<br/>
	 */
	private String dateControle;

	
	/**
	 * userName : String :<br/>
	 * nom de l'utilisateur qui a déclenché le contrôle.<br/>
	 */
	private String userName;

	
	/**
	 * nomFichier : String :<br/>
	 * nom du fichier objet du contrôle.<br/>
	 */
	private String nomFichier;
	
	
	/**
	 * typeControle : String :<br/>
	 * type du contrôle (contrôle de surface par exemple).<br/>
	 */
	private String typeControle;

	
	/**
	 * nomControle : String :<br/>
	 * nom du contrôle ('contrôle fichier texte' par exemple).<br/>
	 */
	private String nomControle;
	
	
	/**
	 * critere : String :<br/>
	 * désignation du critère vérifié par le contrôle 
	 * comme "une ligne ne doit pas être vide" ou 
	 * "une ligne doit contenir obligatoirement 520 caractères".<br/>
	 */
	private String critere;

	
	/**
	 * gravite : String :<br/>
	 * désignation de la gravité de ce contrôle (par exemple 'bloquant').<br/>
	 */
	private String gravite;
	
	
	/**
	 * numeroLigne : Integer :<br/>
	 * numéro de la ligne dans le fichier qui déclenche le contrôle.<br/>
	 */
	private Integer numeroLigne;
	
	
	/**
	 * messageControle : String :<br/>
	 * message émis par le contrôle.<br/>
	 */
	private String messageControle;

	
	/**
	 * ordreChamp : Integer :<br/>
	 * ordre du champ contrôlé
	 * (dans un fichier 
	 * comportant une liste de champs comme un fichier ASCII HIT).<br/>
	 */
	private Integer ordreChamp;
	
	
	/**
	 * positionChamp : String :<br/>
	 * position du champ contrôlé dans une ligne du fichier 
	 * comme 7 ou [7-12].<br/>
	 */
	private String positionChamp;
	
	
	/**
	 * valeurChamp : String :<br/>
	 * valeur prise par le champ contrôlé.<br/>
	 */
	private String valeurChamp;

	
	/**
	 * action : String :<br/>
	 * action menée après le contrôle comme "ligne éliminée" 
	 * ou "ligne conservée".<br/>
	 */
	private String action;
	
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(LigneRapport.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR LigneRapport() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public LigneRapport() {
		super();
	} // FIn de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	
	 /**
	 * method CONSTRUCTEUR LigneRapport(COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pDateControle : String : date d'exécution du contrôle.<br/>
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/> 
	 * @param pNomFichier : String : nom du fichier 
	 * objet du contrôle.<br/>
	 * @param pTypeControle : String : type du contrôle 
	 * (contrôle de surface par exemple).<br/> 
	 * @param pNomControle : String : nom du contrôle 
	 * ('contrôle fichier texte' par exemple).<br/>
	 * @param pCritere : String : désignation du critère vérifié par le contrôle 
	 * comme "une ligne ne doit pas être vide" ou 
	 * "une ligne doit contenir obligatoirement 520 caractères".<br/>
	 * @param pGravite : String : désignation de la gravité de ce contrôle 
	 * (par exemple 'bloquant').<br/>
	 * @param pNumeroLigne : Integer : numéro de la ligne dans le fichier 
	 * qui déclenche le contrôle.<br/>
	 * @param pMessageControle : String : message émis par le contrôle.<br/>
	 * @param pOrdreChamp : Integer : ordre du champ contrôlé
	 * (dans un fichier 
	 * comportant une liste de champs comme un fichier ASCII HIT).<br/>
	 * @param pPositionChamp : String : position du champ contrôlé 
	 * dans une ligne du fichier 
	 * comme 7 ou [7-12].<br/>
	 * @param pValeurChamp : String : valeur prise par le champ contrôlé.<br/> 
	 * @param pAction : String : action menée après le contrôle 
	 * comme "ligne éliminée" ou "ligne conservée".<br/>
	 */
	public LigneRapport(
			final String pDateControle
			, final String pUserName
			, final String pNomFichier
			, final String pTypeControle
			, final String pNomControle
			, final String pCritere
			, final String pGravite
			, final Integer pNumeroLigne
			, final String pMessageControle
			, final Integer pOrdreChamp
			, final String pPositionChamp
			, final String pValeurChamp
			, final String pAction) {
		
		super();
		
		this.dateControle = pDateControle;
		this.userName = pUserName;
		this.nomFichier = pNomFichier;
		this.typeControle = pTypeControle;
		this.nomControle = pNomControle;
		this.critere = pCritere;
		this.gravite = pGravite;
		this.numeroLigne = pNumeroLigne;
		this.messageControle = pMessageControle;
		this.ordreChamp = pOrdreChamp;
		this.positionChamp = pPositionChamp;
		this.valeurChamp = pValeurChamp;
		this.action = pAction;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________



	/**
	 * method getDateControle() :<br/>
	 * Getter de la date d'exécution du contrôle.<br/>
	 * <br/>
	 *
	 * @return dateControle : String.<br/>
	 */
	public final String getDateControle() {
		return this.dateControle;
	} // Fin de getDateControle()._________________________________________
	
	

	/**
	 * method setDateControle(
	 * String pDateControle) :<br/>
	 * Setter de la date d'exécution du contrôle.<br/>
	 * <br/>
	 *
	 * @param pDateControle : String : 
	 * valeur à passer à dateControle.<br/>
	 */
	public final void setDateControle(
			final String pDateControle) {
		this.dateControle = pDateControle;
	} // Fin de setDateControle(
	 // String pDateControle)._____________________________________________



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
	 * method getCritere() :<br/>
	 * Getter de la désignation du critère vérifié par le contrôle 
	 * comme "une ligne ne doit pas être vide" ou 
	 * "une ligne doit contenir obligatoirement 520 caractères".<br/>
	 * <br/>
	 *
	 * @return critere : String.<br/>
	 */
	public final String getCritere() {
		return this.critere;
	} // Fin de getCritere().______________________________________________



	/**
	 * method setCritere(
	 * String pCritere) :<br/>
	 * Setter de la désignation du critère vérifié par le contrôle 
	 * comme "une ligne ne doit pas être vide" ou 
	 * "une ligne doit contenir obligatoirement 520 caractères".<br/>
	 * <br/>
	 *
	 * @param pCritere : String : valeur à passer à critere.<br/>
	 */
	public final void setCritere(
			final String pCritere) {
		this.critere = pCritere;
	} // Fin de setCritere(
	 // String pCritere).__________________________________________________



	/**
	 * method getGravite() :<br/>
	 * Getter de la désignation de la gravité de ce contrôle 
	 * (par exemple bloquant).<br/>
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
	 * (par exemple bloquant).<br/>
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
	 * method getNumeroLigne() :<br/>
	 * Getter du numéro de la ligne dans le fichier 
	 * qui déclenche le contrôle.<br/>
	 * <br/>
	 *
	 * @return numeroLigne : Integer.<br/>
	 */
	public final Integer getNumeroLigne() {
		return this.numeroLigne;
	} // Fin de getNumeroLigne().__________________________________________



	/**
	 * method setNumeroLigne(
	 * Integer pNumeroLigne) :<br/>
	 * Setter du numéro de la ligne dans le fichier 
	 * qui déclenche le contrôle.<br/>
	 * <br/>
	 *
	 * @param pNumeroLigne : Integer : 
	 * valeur à passer à numeroLigne.<br/>
	 */
	public final void setNumeroLigne(
			final Integer pNumeroLigne) {
		this.numeroLigne = pNumeroLigne;
	} // Fin de setNumeroLigne(
	 // Integer pNumeroLigne)._____________________________________________



	/**
	 * method getMessageControle() :<br/>
	 * Getter du message émis par le contrôle.<br/>
	 * <br/>
	 *
	 * @return messageControle : String.<br/>
	 */
	public final String getMessageControle() {
		return this.messageControle;
	} // Fin de getMessageControle().______________________________________



	/**
	 * method setMessageControle(
	 * String pMessageControle) :<br/>
	 * Setter du message émis par le contrôle.<br/>
	 * <br/>
	 *
	 * @param pMessageControle : String : 
	 * valeur à passer à messageControle.<br/>
	 */
	public final void setMessageControle(
			final String pMessageControle) {
		this.messageControle = pMessageControle;
	} // Fin de setMessageControle(
	 // String pMessageControle).__________________________________________



	/**
	 * method getOrdreChamp() :<br/>
	 * Getter de l'ordre du champ contrôlé (
	 * dans un fichier comportant une liste de champs 
	 * comme un fichier ASCII HIT).<br/>
	 * <br/>
	 *
	 * @return ordreChamp : Integer.<br/>
	 */
	public final Integer getOrdreChamp() {
		return this.ordreChamp;
	} // Fin de getOrdreChamp().___________________________________________



	/**
	 * method setOrdreChamp(
	 * Integer pOrdreChamp) :<br/>
	 * Setter de l'ordre du champ contrôlé (
	 * dans un fichier comportant une liste de champs 
	 * comme un fichier ASCII HIT).<br/>
	 * <br/>
	 *
	 * @param pOrdreChamp : Integer : valeur à passer à ordreChamp.<br/>
	 */
	public final void setOrdreChamp(
			final Integer pOrdreChamp) {
		this.ordreChamp = pOrdreChamp;
	} // Fin de setOrdreChamp(
	 // Integer pOrdreChamp).______________________________________________



	/**
	 * method getPositionChamp() :<br/>
	 * Getter de la position du champ contrôlé dans une ligne du fichier 
	 * comme 7 ou [7-12].<br/>
	 * <br/>
	 *
	 * @return positionChamp : String.<br/>
	 */
	public final String getPositionChamp() {
		return this.positionChamp;
	} // Fin de getPositionChamp().________________________________________



	/**
	 * method setPositionChamp(
	 * String pPositionChamp) :<br/>
	 * Setter de la position du champ contrôlé dans une ligne du fichier 
	 * comme 7 ou [7-12].<br/>
	 * <br/>
	 *
	 * @param pPositionChamp : String : valeur à passer à positionChamp.<br/>
	 */
	public final void setPositionChamp(
			final String pPositionChamp) {
		this.positionChamp = pPositionChamp;
	} // Fin de setPositionChamp(
	 // String pPositionChamp).____________________________________________



	/**
	 * method getValeurChamp() :<br/>
	 * Getter de la valeur prise par le champ contrôlé.<br/>
	 * <br/>
	 *
	 * @return valeurChamp : String.<br/>
	 */
	public final String getValeurChamp() {
		return this.valeurChamp;
	} // Fin de getValeurChamp().__________________________________________



	/**
	 * method setValeurChamp(
	 * String pValeurChamp) :<br/>
	 * Setter de la valeur prise par le champ contrôlé.<br/>
	 * <br/>
	 *
	 * @param pValeurChamp : String : valeur à passer à valeurChamp.<br/>
	 */
	public final void setValeurChamp(
			final String pValeurChamp) {
		this.valeurChamp = pValeurChamp;
	} // Fin de setValeurChamp(
	 // String pValeurChamp).______________________________________________



	/**
	 * method getAction() :<br/>
	 * Getter de l'action menée après le contrôle 
	 * comme "ligne éliminée" ou "ligne conservée".<br/>
	 * <br/>
	 *
	 * @return action : String.<br/>
	 */
	public final String getAction() {
		return this.action;
	} // Fin de getAction()._______________________________________________




	/**
	 * method setAction(
	 * String pAction) :<br/>
	 * Setter de l'action menée après le contrôle 
	 * comme "ligne éliminée" ou "ligne conservée".<br/>
	 * <br/>
	 *
	 * @param pAction : String : valeur à passer à action.<br/>
	 */
	public final void setAction(
			final String pAction) {
		this.action = pAction;
	} // Fin de setAction(
	 // String pAction).___________________________________________________
	
	
	
	
	
	
} // FIN DE LA CLASSE LigneRapport.------------------------------------------
