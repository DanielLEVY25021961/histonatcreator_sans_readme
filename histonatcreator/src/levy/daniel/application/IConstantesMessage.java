package levy.daniel.application;


/**
 * class IConstantesMessage :
 * Factorise toutes les constantes utiles pour les messages
 * de contrôle et les Localisation.
 *
 * - Exemple d'utilisation :
 *
 * - Mots-clé :
 *
 * - Dépendances :
 *
 *
 * @author Dan Lévy
 * @version 1.0
 * @since 16 sept. 2012
 *
 */
public interface IConstantesMessage {
	
	
	/**
	 * SEPTAB : String :<br/>
	 * "\t".<br/>
	 */
	String SEPTAB = "\t";
	

	/**
	 * SEP_POINTV : String :<br/>
	 * ";".<br/>
	 */
	String SEP_POINTV = ";";
	
	
	/**
	 * CHAINE_NULL : String :<br/>
	 * "null".<br/>
	 */
	String CHAINE_NULL = "null";
	

	
	/**
	 * CODE_ERREUR_ROUTE : Integer :<br/>
	 * Code des erreurs portant sur une route 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.route = 3".<br/>
	 */
	Integer CODE_ERREUR_ROUTE 
		= Integer.valueOf(
				IConstantes.BUNDLE_CONTROLE.getString("code.erreur.route"));

	
	/**
	 * LABEL_ERREUR_ROUTE : String : <br/>
	 * Label du Code des erreurs portant sur une route 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.route.label = route".<br/>
	 */
	String LABEL_ERREUR_ROUTE 
		= IConstantes.BUNDLE_CONTROLE.getString("code.erreur.route.label");
	
	
	/**
	 * MESSAGE_ERREUR_ROUTE_NULL : String :<br/>
	 * Message à afficher en cas de nullité 
	 * (null, espaces ou 'null') d'une route 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ROUTE_NULL 
		= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.route.null");

		
	/**
	 * MESSAGE_ERREUR_ROUTE_GEO_DEBUT : String :<br/>
	 * Début du Message à afficher en cas d'erreur 
	 * sur la route non compatible 
	 * avec la route de la Localisation Géographique associée.
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ROUTE_GEO_DEBUT 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.route.geo.debut");

	
	/**
	 * MESSAGE_ERREUR_ROUTE_GEO_FIN : String :<br/>
	 * Fin du Message à afficher en cas d'erreur 
	 * sur la route non compatible 
	 * avec la route de la Localisation Géographique associée 
	 * (stocké dans messagescontroles.properties.<br/>
	 */
	String MESSAGE_ERREUR_ROUTE_GEO_FIN 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.route.geo.fin");
	
	
	/**
	 * MESSAGE_ERREUR_ROUTE_LIN_DEBUT : String :<br/>
	 * Début du Message à afficher en cas d'erreur 
	 * sur la route non compatible 
	 * avec la route de la Localisation Linéaire associée.
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ROUTE_LIN_DEBUT 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.route.lin.debut");
	
	
	/**
	 * MESSAGE_ERREUR_ROUTE_LIN_FIN : String :<br/>
	 * Fin du Message à afficher en cas d'erreur 
	 * sur la route non compatible 
	 * avec la route de la Localisation Linéaire associée.
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ROUTE_LIN_FIN 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.route.lin.fin");

	
	/**
	 * MESSAGE_ERREUR_ROUTES_DIFF : String :<br/>
	 * Message à afficher pour une SECTION si
	 * les routes de début et fin sont différentes.<br/>
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ROUTES_DIFF 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.routes.differentes");
	
	
	/**
	 * CODE_ERREUR_PLO : Integer :<br/>
	 * Code des erreurs portant sur un PLO 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.plo = 9".<br/>
	 */
	Integer CODE_ERREUR_PLO 
		= Integer.valueOf(
				IConstantes.BUNDLE_CONTROLE.getString("code.erreur.plo"));

	
	/**
	 * LABEL_ERREUR_PLO : String : <br/>
	 * Label du Code des erreurs portant sur un PLO 
	 * (stocké dans messagescontroles.properties).<br/>.
	 * "code.erreur.plo.label = plo".<br/>
	 */
	String LABEL_ERREUR_PLO 
		= IConstantes.BUNDLE_CONTROLE
				.getString("code.erreur.plo.label");
	
	
	/**
	 * MESSAGE_ERREUR_PLO_NULL : String :<br/>
	 * Message à afficher en cas de nullité d'un PLO 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_PLO_NULL 
		= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.plo.null");

	
	/**
	 * MESSAGE_ERREUR_PLO_INCOHERENT_PR : String :<br/>
	 * Message à afficher en cas de PLO de TYPE PR 
	 * incompatible avec le PR.<br/> 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_PLO_INCOHERENT_PR 
		= IConstantes.BUNDLE_CONTROLE
				.getString("message.erreur.plo.incoherent.pr");
	
	
	/**
	 * CODE_ERREUR_ABS : Integer :<br/>
	 * Code des erreurs portant sur une ABSCISSE 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.abs = 2".<br/>
	 */
	Integer CODE_ERREUR_ABS 
		= Integer.valueOf(
				IConstantes.BUNDLE_CONTROLE.getString("code.erreur.abs"));

	
	/**
	 * LABEL_ERREUR_ABS : String : <br/>
	 * Label du Code des erreurs portant sur une ABSCISSE 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.abs.label = abscisse".<br/>
	 */
	String LABEL_ERREUR_ABS 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.erreur.abs.label");

	
	/**
	 * MESSAGE_ERREUR_ABS_NULL : String :<br/>
	 * Message à afficher en cas d'abscisse null 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ABS_NULL 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.abs.null");
	
	
	/**
	 * MESSAGE_ERREUR_ABSPR_NULL : String :<br/>
	 * Message à afficher en cas d'abscisse du PR null 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ABSPR_NULL 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.abspr.null");
	
	
	/**
	 * MESSAGE_ERREUR_ABSPLOPR_NULL : String :<br/>
	 * Message à afficher en cas d'abscisse du PLO de TYPE PR null 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ABSPLOPR_NULL 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.absplopr.null");
	
	
	/**
	 * MESSAGE_ERREUR_ABS_NEGATIVE : String :<br/>
	 * Message à afficher en cas d'abscisse négative 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ABS_NEGATIVE 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.abs.negative");

	
	/**
	 * MESSAGE_ERREUR_ABSPR_NEGATIVE : String :<br/>
	 * Message à afficher en cas d'abscisse du PR négative 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ABSPR_NEGATIVE 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.abspr.negative");
	 
	
	/**
	 * MESSAGE_ERREUR_ABS_FORMAT : String :<br/>
	 * Message à afficher en cas d'abscisse de format incorrect 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ABS_FORMAT 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.abs.format");
	
	
	/**
	 * MESSAGE_ERREUR_ABS_PLOPR_PR_DEBUT : String :<br/>
	 * Début du Message à afficher en cas d'erreur 
	 * sur l'abscisse d'un PLO de TYPE PR non compatible 
	 * avec l'abscisse du PR 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ABS_PLOPR_PR_DEBUT 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.absplopr.pr.debut");

	
	/**
	 * MESSAGE_ERREUR_ABS_PLOPR_PR_FIN : String :<br/>
	 * Fin du Message à afficher en cas d'erreur 
	 * sur l'abscisse d'un PLO de TYPE PR non compatible 
	 * avec l'abscisse du PR 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_ABS_PLOPR_PR_FIN 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.absplopr.pr.fin");

	
	/**
	 * CODE_ERREUR_COTE : Integer :<br/>
	 * Code des erreurs portant sur un COTE 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.cote = 12".<br/>
	 */
	Integer CODE_ERREUR_COTE 
		= Integer.valueOf(
				IConstantes.BUNDLE_CONTROLE.getString("code.erreur.cote"));
	
	/**
	 * LABEL_ERREUR_COTE : String : <br>
	 * Label du Code des erreurs portant sur un COTE 
	 * (stocké dans messagescontroles.properties).<br/>.
	 * "code.erreur.cote.label = cote".<br/>
	 */
	String LABEL_ERREUR_COTE 
		= IConstantes.BUNDLE_CONTROLE.getString("code.erreur.cote.label");
	
	
	/**
	 * MESSAGE_ERREUR_COTE_FORMAT : String :<br/>
	 * Message à afficher en cas d'erreur sur un Côté (chaussée) 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_COTE_FORMAT 
		= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.cote.format");

	
	/**
	 * MESSAGE_ERREUR_COTE_PLO_DEBUT : String :<br/>
	 * Début du Message à afficher en cas d'erreur 
	 * sur un Côté (chaussée) non compatible avec le PLO 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_COTE_PLO_DEBUT 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.cote.plo.debut");

	
	/**
	 * MESSAGE_ERREUR_COTE_PLO_FIN : String :<br/>
	 * Fin du Message à afficher en cas d'erreur 
	 * sur un Côté (chaussée) non compatible avec le PLO 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_COTE_PLO_FIN 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.cote.plo.fin");
	
	
	/**
	 * MESSAGE_ERREUR_COTE_GEO_DEBUT : String :<br/>
	 * Début du Message à afficher en cas d'erreur 
	 * sur un Côté (chaussée) non compatible avec 
	 * le Côté de la Localisation Géographique 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_COTE_GEO_DEBUT 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.cote.geo.debut");

	
	/**
	 * MESSAGE_ERREUR_COTE_GEO_FIN : String :<br/>
	 * Fin du Message à afficher en cas d'erreur 
	 * sur un Côté (chaussée) non compatible avec 
	 * le Côté de la Localisation Géographique 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_COTE_GEO_FIN 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.cote.geo.fin");
	
	
	/**
	 * MESSAGE_ERREUR_COTE_LIN_DEBUT : String :<br/>
	 * Début du Message à afficher en cas d'erreur 
	 * sur un Côté (chaussée) d'une Localisation Géographique 
	 * non compatible avec le Côté de la Localisation Linéaire
	 * associée.<br/>  
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_COTE_LIN_DEBUT 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.cote.lin.debut");

	
	/**
	 * MESSAGE_ERREUR_COTE_LIN_FIN : String :<br/>
	 * Fin du Message à afficher en cas d'erreur 
	 * sur un Côté (chaussée) d'une Localisation Géographique 
	 * non compatible avec le Côté de la Localisation Linéaire
	 * associée.<br/> 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_COTE_LIN_FIN 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.cote.lin.fin");
	
	
	/**
	 * MESSAGE_ERREUR_COTES_DIFF : String :<br/>
	 * Message à afficher pour une SECTION si
	 * les Côtés de début et fin sont différents.<br/>
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_COTES_DIFF 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.cotes.differents");
	
	
	/**
	 * CODE_ERREUR_CUMUL : Integer :<br/>
	 * Code des erreurs portant sur une abscisse cumulée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.cumul = 13".<br/>
	 */
	Integer CODE_ERREUR_CUMUL 
		= Integer.valueOf(
				IConstantes.BUNDLE_CONTROLE.getString("code.erreur.cumul"));

	
	/**
	 * LABEL_ERREUR_CUMUL : String : <br/>
	 * Label du Code des erreurs portant sur une abscisse cumulée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.cumul.label = abscisse cumulée".<br/>
	 */
	String LABEL_ERREUR_CUMUL 
		= IConstantes.BUNDLE_CONTROLE
				.getString("code.erreur.cumul.label");
	
	
	/**
	 * MESSAGE_ERREUR_CUMUL_NEGATIF : String :<br/>
	 * Message à afficher en cas de cumul négatif 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_CUMUL_NEGATIF 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.cumul.negatif");
	
	
	/**
	 * MESSAGE_ERREUR_CUMUL_GEO_DEBUT : String :<br/>
	 * Début du message à afficher lorsque le cumul
	 * dans la Localisation Linéaire diffère du cumul dans la
	 * Localisation Géographique associée.<br/>
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_CUMUL_GEO_DEBUT 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.cumul.geo.debut");
	
	
	/**
	 * MESSAGE_ERREUR_CUMUL_GEO_FIN : String :<br/>
	 * Fin du message à afficher lorsque le cumul
	 * dans la Localisation Linéaire diffère du cumul dans la
	 * Localisation Géographique associée.<br/>
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_CUMUL_GEO_FIN 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.cumul.geo.fin");
	
	
	/**
	 * MESSAGE_ERREUR_CUMUL_LIN_DEBUT : String :<br/>
	 * Début du message à afficher lorsque le cumul
	 * dans la Localisation Géographique diffère du cumul dans la
	 * Localisation Linéaire associée.<br/>
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_CUMUL_LIN_DEBUT 
	= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.cumul.lin.debut");

	
	/**
	 * MESSAGE_ERREUR_CUMUL_LIN_FIN : String :<br/>
	 * Fin du message à afficher lorsque le cumul
	 * dans la Localisation Géographique diffère du cumul dans la
	 * Localisation Linéaire associée.<br/>
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_CUMUL_LIN_FIN 
	= IConstantes.BUNDLE_CONTROLE
		.getString("message.erreur.cumul.lin.fin");
	
	
	/**
	 * MESSAGE_ERREUR_CUMULS_INVERSES : String :<br/>
	 * Message à afficher pour une SECTION si
	 * les Cumuls de début et fin sont inversés 
	 * (cumulDebut >= CumulFin).<br/>
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_CUMULS_INVERSES 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.cumuls.inverses");
	
	
	/**
	 * CODE_ERREUR_IDBASE : Integer :<br/>
	 * Code des erreurs portant sur une erreur de format de IdBase 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.idbase = 7".<br/>
	 */
	Integer CODE_ERREUR_IDBASE 
		= Integer.valueOf(
				IConstantes.BUNDLE_CONTROLE.getString("code.erreur.idbase"));

	
	/**
	 * LABEL_ERREUR_IDBASE : String :<br/> 
	 * Code des erreurs portant sur une erreur de format de IdBase 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.idbase.label = idbase".<br/>
	 */
	String LABEL_ERREUR_IDBASE 
			= IConstantes.BUNDLE_CONTROLE
				.getString("code.erreur.idbase.label");
	
	
	/**
	 * CODE_ERREUR_DEP : Integer :<br/>
	 * Code des erreurs portant sur un DEPARTEMENT 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.departement = 1".<br/>
	 */
	Integer CODE_ERREUR_DEP 
		= Integer.valueOf(
				IConstantes.BUNDLE_CONTROLE.getString(
						"code.erreur.departement"));

	
	/**
	 * LABEL_ERREUR_DEP : String : 
	 * Label du Code des erreurs portant sur un DEPARTEMENT 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.departement.label = département".<br/>
	 */
	String LABEL_ERREUR_DEP 
		= IConstantes.BUNDLE_CONTROLE
				.getString("code.erreur.departement.label");
	
	
	/**
	 * MESSAGE_ERREUR_DEPT_NULL : String :<br/>
	 * Message à afficher en cas de département non renseigné
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_DEPT_NULL 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.departement.null");
	
	
	/**
	 * MESSAGE_ERREUR_DEPT_FORMAT : String :<br/>
	 * Message à afficher en cas de département mal formatté
	 * (non homogène à un entier)
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_DEPT_FORMAT 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.departement.format");
	
	
	/**
	 * MESSAGE_ERREUR_DEP_PLO_DEBUT : String :<br/>
	 * Début du Message à afficher en cas de département 
	 * incohérent avec le département du PLO 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_DEP_PLO_DEBUT 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.departement.plo.debut");

	
	/**
	 * MESSAGE_ERREUR_DEP_PLO_FIN : String :<br/>
	 * Fin du Message à afficher en cas de département 
	 * incohérent avec le département du PLO 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_DEP_PLO_FIN 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.departement.plo.fin");

	
	/**
	 * CODE_ERREUR_CONC : Integer :<br/>
	 * Code des erreurs portant sur un CODE CONCESSION 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.concession = 4".<br/>
	 */
	Integer CODE_ERREUR_CONC 
		= Integer.valueOf(
				IConstantes.BUNDLE_CONTROLE.getString(
						"code.erreur.concession"));

	
	/**
	 * LABEL_ERREUR_CONC : String :<br/> 
	 * Label du Code des erreurs portant sur un CODE CONCESSION 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.concession.label = concession".<br/>
	 */
	String LABEL_ERREUR_CONC 
		= IConstantes.BUNDLE_CONTROLE
						.getString("code.erreur.concession.label");

	
	/**
	 * MESSAGE_ERREUR_CONC_FORMAT : String :<br/>
	 * Message à afficher en cas de Code Concession de mauvais format.<br/>
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_CONC_FORMAT 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.concession.format");
	
	
	/**
	 * MESSAGE_ERREUR_CONC_PLO_DEBUT : String :<br/>
	 * Début du Message à afficher en cas de Code concession
	 * incohérent avec le Code Concession du PLO 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_CONC_PLO_DEBUT 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.concession.plo.debut");

		
	/**
	 * MESSAGE_ERREUR_CONC_PLO_FIN : String :<br/>
	 * Fin du Message à afficher en cas de Code concession
	 * incohérent avec le Code Concession du PLO 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_CONC_PLO_FIN 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.concession.plo.fin");

	
	/**
	 * CODE_ERREUR_PR : Integer :<br/>
	 * Code des erreurs portant sur un PR 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.pr = 10".<br/>
	 */
	Integer CODE_ERREUR_PR 
		= Integer.valueOf(
				IConstantes.BUNDLE_CONTROLE.getString("code.erreur.pr"));

	
	/**
	 * LABEL_ERREUR_PR : String : <br/>
	 * Label du Code des erreurs portant sur un PR 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.pr.label = PR".<br/>
	 */
	String LABEL_ERREUR_PR 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.erreur.pr.label");

	
	/**
	 * MESSAGE_ERREUR_PR_NULL : String :<br/>
	 * Message à afficher en cas de nullité d'un PR 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_PR_NULL 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.pr.null");
	
	
	/**
	 * MESSAGE_ERREUR_PR_NEGATIF : String :<br/>
	 * Message à afficher en cas de PR négatif 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_PR_NEGATIF 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.pr.negatif");
	
	
	/**
	 * MESSAGE_ERREUR_PR_PLO_DEBUT : String :<br/>
	 * Début du Message à afficher en cas de pr 
	 * incohérent avec le pr du PLO 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_PR_PLO_DEBUT 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.pr.plo.debut");

	
	/**
	 * MESSAGE_ERREUR_PR_PLO_FIN : String :<br/>
	 * Fin du Message à afficher en cas de pr 
	 * incohérent avec le pr du PLO 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_PR_PLO_FIN 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.pr.plo.fin");

	
	/**
	 * MESSAGE_ERREUR_PR_INCOHERENTS : String :<br/>
	 * Message à afficher lorsque le PR DEBUT > PR FIN
	 * dans une Localisation.<br/>
	 */
	String MESSAGE_ERREUR_PR_INCOHERENTS 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.pr.incoherents");
	
	
	/**
	 * CODE_ERREUR_PLOTYPEPR : Integer :<br/>
	 * Code des erreurs portant sur un PLO de TYPE PR 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.plotypepr = 14".<br/>
	 */
	Integer CODE_ERREUR_PLOTYPEPR 
		= Integer.valueOf(
				IConstantes.BUNDLE_CONTROLE.getString(
						"code.erreur.plotypepr"));

		
	/**
	 * LABEL_ERREUR_PLOTYPEPR : String : <br/>
	 * Label du Code des erreurs portant sur un PLO de TYPE PR 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.plotypepr.label = Plo de Type PR".<br/>
	 */
	String LABEL_ERREUR_PLOTYPEPR 
	= IConstantes.BUNDLE_CONTROLE
			.getString("code.erreur.plotypepr.label");
	
	
	/**
	 * MESSAGE_ERREUR_PLOPR : String :<br/>
	 * Message à afficher en cas de PLO PAS DE TYPE PR 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_PLOPR 
		= IConstantes.BUNDLE_CONTROLE.getString("message.erreur.plotypepr");


	/**
	 * CODE_ERREUR_COORDONNEES : Integer :<br/>
	 * Code des erreurs portant sur une COORDONNEE 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.coordonnee = 11".<br/>
	 */
	Integer CODE_ERREUR_COORDONNEES
		= Integer.valueOf(
				IConstantes.BUNDLE_CONTROLE.getString(
						"code.erreur.coordonnee"));
	
	
	/**
	 * LABEL_ERREUR_COORDONNEES : String : 
	 * Code des erreurs portant sur une COORDONNEE 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.coordonnee.label = coordonnée".<br/>
	 */
	String LABEL_ERREUR_COORDONNEES 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.erreur.coordonnee.label");
	
	
	/**
	 * MESSAGE_ERREUR_COORDX_NULL : String :<br/>
	 * Message à afficher lorsque la coordonnée X
	 * n'est pas renseignée 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_COORDX_NULL 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.coordonnee.x.null");

	
	/**
	 * MESSAGE_ERREUR_COORDY_NULL : String :<br/>
	 * Message à afficher lorsque la coordonnée Y
	 * n'est pas renseignée 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_COORDY_NULL 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.coordonnee.y.null");

	
	/**
	 * MESSAGE_ERREUR_COORDZ_NULL : String :<br/>
	 * Message à afficher lorsque la coordonnée Z
	 * n'est pas renseignée 
	 * (stocké dans messagescontroles.properties).<br/>
	 */
	String MESSAGE_ERREUR_COORDZ_NULL 
		= IConstantes.BUNDLE_CONTROLE
			.getString("message.erreur.coordonnee.z.null");

	
	/**
	 * CODE_ERREUR_LONGUEUR : Integer : <br/>
	 * Code des erreurs portant sur une LONGUEUR 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.longueur = 5".<br/>
	 */
	Integer CODE_ERREUR_LONGUEUR
	= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString(
					"code.erreur.longueur"));

	
	/**
	 * LABEL_ERREUR_LONGUEUR : String : <br/>
	 * Label du Code des erreurs portant sur une LONGUEUR 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.longueur.label = longueur".<br/>
	 */
	String LABEL_ERREUR_LONGUEUR 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.erreur.longueur.label");
	
	/**
	 * CODE_ERREUR_INCONNUE : Integer : <br/>
	 * Code des erreurs portant sur une variable diverse 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.inconnue = 6".<br/>
	 */
	Integer CODE_ERREUR_INCONNUE
	= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString(
					"code.erreur.inconnue"));

	
	/**
	 * LABEL_ERREUR_INCONNUE : String : <br/>
	 * Label du Code des erreurs portant sur une variable diverse 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.inconnue.label = erreur diverse".<br/>
	 */
	String LABEL_ERREUR_INCONNUE 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.erreur.inconnue.label");
	
	/**
	 * CODE_ERREUR_RECOUVREMENT : Integer : <br/>
	 * Code des erreurs portant sur un RECOUVREMENT 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.recouvrement = 8".<br/>
	 */
	Integer CODE_ERREUR_RECOUVREMENT
	= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString(
					"code.erreur.recouvrement"));

	
	/**
	 * LABEL_ERREUR_RECOUVREMENT : String : <br/>
	 * Label du Code des erreurs portant sur un RECOUVREMENT 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.erreur.recouvrement.label = recouvrement".<br/>
	 */
	String LABEL_ERREUR_RECOUVREMENT 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.erreur.recouvrement.label");
	
	
	/**
	 * CODE_TYPE_NULLITE : Integer :<br/>
	 * Code des erreurs portant sur la nullité (null) 
	 * d'une donnée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.nullite = 1".<br/>
	 */
	Integer CODE_TYPE_NULLITE 
		= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString("code.typerr.nullite"));

	
	/**
	 * LABEL_TYPE_NULLITE : String : <br/>
	 * Label du Code des erreurs portant sur la nullité d'une donnée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.nullite.label = nullité".<br/>
	 */
	String LABEL_TYPE_NULLITE 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.typerr.nullite.label");

	
	/**
	 * CODE_TYPE_BLANK : Integer :<br/>
	 * Code des erreurs portant sur la blankité d'une donnée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.blank = 2".<br:>
	 */
	Integer CODE_TYPE_BLANK 
		= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString("code.typerr.blank"));

	
	/**
	 * LABEL_TYPE_BLANK : String : <br/>
	 * Label du Code des erreurs portant sur la blankité d'une donnée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.blank.label = blank".<br/>
	 */
	String LABEL_TYPE_BLANK 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.typerr.blank.label");

	
	/**
	 * CODE_TYPE_NULL : Integer :<br/>
	 * Code des erreurs portant sur la nullité 
	 * (espaces ou "null") 
	 * d'une donnée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.null = 3".<br/>
	 */
	Integer CODE_TYPE_NULL 
		= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString("code.typerr.null"));

	
	/**
	 * LABEL_TYPE_NULL : String : <br/>
	 * Label du Code des erreurs portant sur la valeur "null" d'une donnée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.null.label = 'null'".<br/>
	 */
	String LABEL_TYPE_NULL 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.typerr.null.label");
	
	
	/**
	 * CODE_TYPE_NEGATIF : Integer :<br/>
	 * Code des erreurs portant sur le signe d'une donnée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.negatif = 4".<br/>
	 */
	Integer CODE_TYPE_NEGATIF 
		= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString("code.typerr.negatif"));
	
	
	/**
	 * LABEL_TYPE_NEGATIF : String : <br/>
	 * Label du Code des erreurs portant sur le signe d'une donnée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.negatif.label = negatif".<br/>
	 */
	String LABEL_TYPE_NEGATIF 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.typerr.negatif.label");

	
	/**
	 * CODE_TYPE_FORMAT : Integer :<br/>
	 * Code des erreurs portant sur le format d'une donnée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.format = 5".<br/>
	 */
	Integer CODE_TYPE_FORMAT 
		= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString("code.typerr.format"));
	
	
	/**
	 * LABEL_TYPE_FORMAT : String : <br/>
	 * Label du Code des erreurs portant sur le format d'une donnée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.format.label = format".<br/>
	 */
	String LABEL_TYPE_FORMAT = IConstantes.BUNDLE_CONTROLE
		.getString("code.typerr.format.label");

	
	/**
	 * CODE_TYPE_LOC_LIN : Integer :<br/>
	 * Code des erreurs portant sur l'incohérence 
	 * d'une Localisation Géographique avec une Localisation Linéaire 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.loclin = 6".<br/>
	 */
	Integer CODE_TYPE_LOC_LIN 
		= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString("code.typerr.loclin"));
	
	
	/**
	 * LABEL_TYPE_LOC_LIN : String : <br/>
	 * Label du Code des erreurs portant sur sur l'incohérence 
	 * d'une Localisation Géographique avec une Localisation Linéaire 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.loclin.label = 
	 * incohérence avec Localisation Lin\u00E9aire".<br/>
	 */
	String LABEL_TYPE_LOC_LIN = IConstantes.BUNDLE_CONTROLE
		.getString("code.typerr.loclin.label");
	
	
	/**
	 * CODE_TYPE_LOC_GEO : Integer :<br/>
	 * Code des erreurs portant sur l'incohérence 
	 * d'une Localisation Linéaire avec une Localisation Géographique 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.locgeo = 7".<br:>
	 */
	Integer CODE_TYPE_LOC_GEO 
		= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString("code.typerr.locgeo"));
	
	
	/**
	 * LABEL_TYPE_LOC_GEO : String : <br/>
	 * Label du Code des erreurs portant sur l'incohérence 
	 * d'une Localisation Linéaire avec une Localisation Géographique
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.locgeo.label 
	 * = incohérence avec Localisation Géographique".<br/>
	 */
	String LABEL_TYPE_LOC_GEO 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.typerr.locgeo.label");
	
	
	/**
	 * CODE_TYPE_PLO : Integer :<br/>
	 * Code des erreurs portant sur l'incohérence 
	 * d'un PR avec un PLO de type PR
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.plo = 8".<br/>
	 */
	Integer CODE_TYPE_PLO 
		= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString("code.typerr.plo"));


	/**
	 * LABEL_TYPE_PLO : String : <br/>
	 * Label du Code des erreurs portant sur une 
	 * incohérence d'un PR avec un PLO de type PR
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.plo.label = incohérence avec un plo".<br/>
	 */
	String LABEL_TYPE_PLO = IConstantes.BUNDLE_CONTROLE
			.getString("code.typerr.plo.label");
	
		
	/**
	 * CODE_TYPE_PLO_PAS_PR : Integer :<br/>
	 * Code des erreurs portant sur un PLO pas PR 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.plopaspr = 9".<br/>
	 */
	Integer CODE_TYPE_PLO_PAS_PR 
		= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString("code.typerr.plopaspr"));

	
	/**
	 * LABEL_TYPE_PLO_PAS_PR : String : <br/>
	 * Label du Code des erreurs portant sur un PLO
	 * PAS DE TYPE PR 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.plopaspr.label = plo pas de type pr".<br/>
	 */
	String LABEL_TYPE_PLO_PAS_PR 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.typerr.plopaspr.label");
	
	
	/**
	 * CODE_TYPE_PLOPR : Integer :<br/>
	 * Code des erreurs portant sur un PLO de TYPE PR 
	 * incohérent avec une Localisation en PR 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.plopr = 10".<br/>
	 */
	Integer CODE_TYPE_PLOPR 
		= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString("code.typerr.plopr"));

	
	/**
	 * LABEL_TYPE_PLOPR : String : <br/>
	 * Label du Code des erreurs portant sur un PLO de TYPE PR 
	 * incohérent avec une Localisation en PR 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.plopr.label 
	 * = incohérence du Plo de type PR avec le PR".<br/>
	 */
	String LABEL_TYPE_PLOPR 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.typerr.plopr.label");
	
	
	/**
	 * CODE_TYPE_CASSE : Integer :<br/>
	 * Code des erreurs portant sur une mauvaise casse 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.casse = 11".<br/>
	 */
	Integer CODE_TYPE_CASSE 
		= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString("code.typerr.casse"));

	
	/**
	 * LABEL_TYPE_CASSE : String : <br/>
	 * Label du Code des erreurs portant sur la casse d'une donnée 
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.casse.label = mauvaise casse".<br/>
	 */
	String LABEL_TYPE_CASSE 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.typerr.casse.label");
	
	
	/**
	 * CODE_TYPE_INCOHERENCE : Integer :<br/>
	 * Code des erreurs portant sur une incohérence entre deux
	 * variables.<br/>
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.incoh = 12".<br/>
	 */
	Integer CODE_TYPE_INCOHERENCE 
		= Integer.valueOf(
			IConstantes.BUNDLE_CONTROLE.getString("code.typerr.incoh"));
	
	
	/**
	 * LABEL_TYPE_INCOH : String :<br/>
	 * Label des erreurs portant sur une incohérence entre deux
	 * variables.<br/>
	 * (stocké dans messagescontroles.properties).<br/>
	 * "code.typerr.incoh.label = incohérence entre 2 valeurs".<br/>
	 */
	String LABEL_TYPE_INCOH 
		= IConstantes.BUNDLE_CONTROLE
			.getString("code.typerr.incoh.label");
	

} // FIN DE L'INTERFACE IConstantesMessage.----------------------------------
