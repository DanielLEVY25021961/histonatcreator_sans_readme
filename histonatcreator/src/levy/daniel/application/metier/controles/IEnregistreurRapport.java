package levy.daniel.application.metier.controles;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

import levy.daniel.application.metier.controles.rapportscontroles.LigneRapport;
import levy.daniel.application.metier.service.enregistreursfichiers.rapportsenregistrements.LigneRapportEnregistrement;


/**
 * Interface IEnregistreurRapport :<br/>
 * Interface centralisant les méthodes 
 * de tous les contrôles susceptibles d'enregistrer 
 * sur disque un rapport de contrôle.<br/>
 * SERVICE CHARGE D'ENREGISTRER UNE RAPPORT DE CONTROLE SUR DISQUE.<br/>
 * Un rapport de Contrôle de fichier
 * est une List&lt;LigneRapport&gt;.<br/>
 * En outre, IEnregistreurRapport fournit un compte-rendu 
 * de l'enregistrement sur disque du rapport de contrôle sous forme de 
 * List&lt;LigneRapportEnregistrement&gt;.<br/>
 * <br/>
 * <ul>
 * comporte essentiellement : <br/>
 * <li>une méthode enregistrerRapportTextuel(
 * List&lt;LigneRapport&gt; pRapportList
 * , Date pDateEnregistrement
 * , String pUserName, String pObjet, File pFichier
 * , Charset pCharset, String pSautLigne) 
 * qui permet d'enregistrer un rapport de contrôle 
 * encodé en pCharset dans pFile au format textuel.<br/>
 * Cette méthode génère 
 * également un compte rendu d'enregistrement 
 * sous forme de List&lt;LigneRapportEnregistrement&gt;.</li><br/>
 * <li>une méthode enregistrerRapportCsv(
 * List&lt;LigneRapport&gt; pRapportList
 * , Date pDateEnregistrement, String pUserName
 * , String pObjet, File pFichier
 * , Charset pCharset, String pSautLigne) 
 * qui permet d'enregistrer un rapport de contrôle 
 * encodé en pCharset dans pFile au format csv.<br/>
 * Cette méthode génère 
 * également un compte rendu d'enregistrement 
 * sous forme de List&lt;LigneRapportEnregistrement&gt;.</li><br/>
 * <li>une méthode getRapportEnregistrement() qui fournit 
 * un compte-rendu de l'enregistrement des rapports de contrôle 
 * sur disque sous forme de List&lt;LigneRapportEnregistrement&gt;.</li><br/>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * enregistrement sur disque, enregistrement de rapport de contrôle,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * levy.daniel.application.metier.controles.rapportscontroles.LigneRapport.<br/>
 * levy.daniel.application.metier.service.enregistreursfichiers.rapportsenregistrements.LigneRapportEnregistrement.<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 6 mars 2016
 *
 */
public interface IEnregistreurRapport {

	
	/**
	 * method enregistrerRapportTextuelANSI(
	 * File pFichier) :<br/>
	 * Enregistre le rapport this.rapport 
	 * au format textuel encodé en ANSI (Windows-1252 = CP1252) 
	 * dans un fichier pFichier sur le disque.<br/>
	 * Fournit un rapport encodé en ANSI 
	 * de l'enregistrement dans le fichier.<br/>
	 * <br/>
	 * - retourne null si pFichier == null.<br/>
	 * - retourne null si pFichier est inexistant.<br/>
	 * - retourne null si pFichier est un répertoire.<br/>
	 * - retourne null si this.rapport == null.<br/>
	 * <br/>
	 * - met automatiquement pDateEnregistrement à la date du contrôle.<br/>
	 * - met automatiquement pUserName à 'Administrateur' 
	 * si this.userName est null.<br/>
	 * - met automatiquement this.nomControle dans l'objet.<br/>
	 * - met automatiquement les sauts de ligne de la plateforme (NEWLINE).<br/>
	 * <br/>
	 *
	 * @param pFichier : File : Fichier dans lequel 
	 * on enregistre le rapport.<br/>
	 * 
	 * @return : File : Fichier contenant le rapport.<br/>
	 */
	File enregistrerRapportTextuelANSI(final File pFichier);
	
	
	
	/**
	 * method enregistrerRapportTextuelLatin9(
	 * File pFichier) :<br/>
	 * Enregistre le rapport this.rapport 
	 * au format textuel encodé en LATIN9 (ISO-8859-15) 
	 * dans un fichier pFichier sur le disque.<br/>
	 * Fournit un rapport encodé en LATIN9 
	 * de l'enregistrement dans le fichier.<br/>
	 * <br/>
	 * - retourne null si pFichier == null.<br/>
	 * - retourne null si pFichier est inexistant.<br/>
	 * - retourne null si pFichier est un répertoire.<br/>
	 * - retourne null si this.rapport == null.<br/>
	 * <br/>
	 * - met automatiquement pDateEnregistrement à la date du contrôle.<br/>
	 * - met automatiquement pUserName à 'Administrateur' 
	 * si this.userName est null.<br/>
	 * - met automatiquement this.nomControle dans l'objet.<br/>
	 * - met automatiquement les sauts de ligne de la plateforme (NEWLINE).<br/>
	 * <br/>
	 *
	 * @param pFichier : File : Fichier dans lequel 
	 * on enregistre le rapport.<br/>
	 * 
	 * @return : File : Fichier contenant le rapport.<br/>
	 */
	File enregistrerRapportTextuelLatin9(final File pFichier);
	
	
	
	/**
	 * method enregistrerRapportTextuelUTF8(
	 * File pFichier) :<br/>
	 * Enregistre le rapport this.rapport 
	 * au format textuel encodé en UTF-8 
	 * dans un fichier pFichier sur le disque.<br/>
	 * Fournit un rapport encodé en UTF-8 
	 * de l'enregistrement dans le fichier.<br/>
	 * <br/>
	 * - retourne null si pFichier == null.<br/>
	 * - retourne null si pFichier est inexistant.<br/>
	 * - retourne null si pFichier est un répertoire.<br/>
	 * - retourne null si this.rapport == null.<br/>
	 * <br/>
	 * - met automatiquement pDateEnregistrement à la date du contrôle.<br/>
	 * - met automatiquement pUserName à 'Administrateur' 
	 * si this.userName est null.<br/>
	 * - met automatiquement this.nomControle dans l'objet.<br/>
	 * - met automatiquement les sauts de ligne de la plateforme (NEWLINE).<br/>
	 * <br/>
	 *
	 * @param pFichier : File : Fichier dans lequel 
	 * on enregistre le rapport.<br/>
	 * 
	 * @return : File : Fichier contenant le rapport.<br/>
	 */
	File enregistrerRapportTextuelUTF8(final File pFichier);
	
	
	
	/**
	 * method enregistrerRapportTextuel(
	 * List&lt;LigneRapport&gt; pRapportList
	 * , Date pDateEnregistrement
	 * , String pUserName
	 * , String pObjet
	 * , File pFichier
	 * , Charset pCharset
	 * , String pSautLigne) :<br/>
	 * Enregistre le rapport pRapportList 
	 * au format textuel dans un fichier pFichier sur le disque.<br/>
	 * Fournit un rapport encodé en pCharset 
	 * de l'enregistrement dans le fichier.<br/>
	 * <br/>
	 * - retourne null si pFichier == null.<br/>
	 * - retourne null si pFichier est inexistant.<br/>
	 * - retourne null si pFichier est un répertoire.<br/>
	 * - retourne null si pRapportList == null.<br/>
	 * <br/>
	 * - met automatiquement pDateEnregistrement à la date système 
	 * si pDateEnregistrement == null.<br/>
	 * - met automatiquement pUserName à 'Administrateur' 
	 * si pUserName est null.<br/>
	 * <br/>
	 * 
	 *
	 * @param pRapportList : List&lt;LigneRapport&gt;.<br/>
	 * @param pDateEnregistrement : java.util.Date.<br/>
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/>
	 * @param pObjet : String : nom du contrôle 
	 * ('contrôle fichier texte' par exemple).<br/>
	 * @param pFichier : File : Fichier dans lequel 
	 * on enregistre le rapport.<br/>
	 * @param pCharset : Charset : Charset dans lequel 
	 * on encode le rapport.<br/>
	 * @param pSautLigne : String : Saut de ligne 
	 * à insérer dans le rapport.<br/>
	 * 
	 * @return : File : Fichier contenant le rapport.<br/>
	 */
	File enregistrerRapportTextuel(
			final List<LigneRapport> pRapportList
				, final Date pDateEnregistrement
					, final String pUserName
						, final String pObjet
							, final File pFichier
								, final Charset pCharset
									, final String pSautLigne);

	
	
	/**
	 * method enregistrerRapportCsvANSI(
	 * File pFichier) :<br/>
	 * Enregistre le rapport this.rapport 
	 * au format csv encodé en ANSI (Windows-1252 = CP1252) 
	 * dans un fichier pFichier sur le disque.<br/>
	 * Fournit un rapport encodé en ANSI 
	 * de l'enregistrement dans le fichier.<br/>
	 * <br/>
	 * - retourne null si pFichier == null.<br/>
	 * - retourne null si pFichier est inexistant.<br/>
	 * - retourne null si pFichier est un répertoire.<br/>
	 * - retourne null si this.rapport == null.<br/>
	 * <br/>
	 * - met automatiquement pDateEnregistrement à la date du contrôle.<br/>
	 * - met automatiquement pUserName à 'Administrateur' 
	 * si this.userName est null.<br/>
	 * - met automatiquement this.nomControle dans l'objet.<br/>
	 * - met automatiquement les sauts de ligne de la plateforme (NEWLINE).<br/>
	 * <br/>
	 *
	 * @param pFichier : File : Fichier dans lequel 
	 * on enregistre le rapport.<br/>
	 * 
	 * @return : File : Fichier contenant le rapport.<br/>
	 */
	File enregistrerRapportCsvANSI(final File pFichier);
	
	
	
	/**
	 * method enregistrerRapportCsvLatin9(
	 * File pFichier) :<br/>
	 * Enregistre le rapport this.rapport 
	 * au format csv encodé en LATIN9 (ISO-8859-15) 
	 * dans un fichier pFichier sur le disque.<br/>
	 * Fournit un rapport encodé en LATIN9 
	 * de l'enregistrement dans le fichier.<br/>
	 * <br/>
	 * - retourne null si pFichier == null.<br/>
	 * - retourne null si pFichier est inexistant.<br/>
	 * - retourne null si pFichier est un répertoire.<br/>
	 * - retourne null si this.rapport == null.<br/>
	 * <br/>
	 * - met automatiquement pDateEnregistrement à la date du contrôle.<br/>
	 * - met automatiquement pUserName à 'Administrateur' 
	 * si this.userName est null.<br/>
	 * - met automatiquement this.nomControle dans l'objet.<br/>
	 * - met automatiquement les sauts de ligne de la plateforme (NEWLINE).<br/>
	 * <br/>
	 *
	 * @param pFichier : File : Fichier dans lequel 
	 * on enregistre le rapport.<br/>
	 * 
	 * @return : File : Fichier contenant le rapport.<br/>
	 */
	File enregistrerRapportCsvLatin9(final File pFichier);
	
	
	
	/**
	 * method enregistrerRapportCsvUTF8(
	 * File pFichier) :<br/>
	 * Enregistre le rapport this.rapport 
	 * au format csv encodé en UTF-8 
	 * dans un fichier pFichier sur le disque.<br/>
	 * Fournit un rapport encodé en UTF-8 
	 * de l'enregistrement dans le fichier.<br/>
	 * - Ajout d'un caractère BOM-UTF-8 si le Charset est UTF-8 
	 * pour forcer Excel 2010 à détecter l'UTF-8.<br/>
	 * <br/>
	 * - retourne null si pFichier == null.<br/>
	 * - retourne null si pFichier est inexistant.<br/>
	 * - retourne null si pFichier est un répertoire.<br/>
	 * - retourne null si this.rapport == null.<br/>
	 * <br/>
	 * - met automatiquement pDateEnregistrement à la date du contrôle.<br/>
	 * - met automatiquement pUserName à 'Administrateur' 
	 * si this.userName est null.<br/>
	 * - met automatiquement this.nomControle dans l'objet.<br/>
	 * - met automatiquement les sauts de ligne de la plateforme (NEWLINE).<br/>
	 * <br/>
	 *
	 * @param pFichier : File : Fichier dans lequel 
	 * on enregistre le rapport.<br/>
	 * 
	 * @return : File : Fichier contenant le rapport.<br/>
	 */
	File enregistrerRapportCsvUTF8(final File pFichier);
	
	

	/**
	 * method enregistrerRapportCsv(
	 * List&lt;LigneRapport&gt; pRapportList
	 * , Date pDateEnregistrement
	 * , String pUserName
	 * , String pObjet
	 * , File pFichier
	 * , Charset pCharset
	 * , String pSautLigne) :<br/>
	 * Enregistre le rapport pRapportList 
	 * au format csv dans un fichier pFichier sur le disque.<br/>
	 * Fournit un rapport encodé en pCharset 
	 * de l'enregistrement dans le fichier.<br/>
	 * - Ajout d'un caractère BOM-UTF-8 si le Charset est UTF-8 
	 * pour forcer Excel 2010 à détecter l'UTF-8.<br/>
	 * <br/>
	 * - retourne null si pFichier == null.<br/>
	 * - retourne null si pFichier est inexistant.<br/>
	 * - retourne null si pFichier est un répertoire.<br/>
	 * - retourne null si pRapportList == null.<br/>
	 * <br/>
	 * - met automatiquement pDateEnregistrement à la date système 
	 * si pDateEnregistrement == null.<br/>
	 * - met automatiquement pUserName à 'Administrateur' 
	 * si pUserName est null.<br/>
	 * <br/>
	 * 
	 *
	 * @param pRapportList : List&lt;LigneRapport&gt;.<br/>
	 * @param pDateEnregistrement : java.util.Date.<br/>
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/>
	 * @param pObjet : String : nom du contrôle 
	 * ('contrôle fichier texte' par exemple).<br/>
	 * @param pFichier : File : Fichier dans lequel 
	 * on enregistre le rapport.<br/>
	 * @param pCharset : Charset : Charset dans lequel 
	 * on encode le rapport.<br/>
	 * @param pSautLigne : String : Saut de ligne 
	 * à insérer dans le rapport.<br/>
	 * @param pEnteteCsv : boolean : true si on veut ajouter l'en-ête csv.<br/>
	 * 
	 * @return : File : Fichier contenant le rapport.<br/>
	 */
	File enregistrerRapportCsv(
			final List<LigneRapport> pRapportList
				, final Date pDateEnregistrement
					, final String pUserName
						, final String pObjet
							, final File pFichier
								, final Charset pCharset
									, final String pSautLigne
										, final boolean pEnteteCsv);


	
	/**
	 * method getRapportEnregistrement() :<br/>
	 * Getter du rapport fourni par l'enregistreur sous forme 
	 * de List&lt;LigneRapportEnregistrement&gt;.<br/>
	 * <br/>
	 *
	 * @return rapportEnregistrement : 
	 * List&lt;LigneRapportEnregistrement&gt;.<br/>
	 */
	List<LigneRapportEnregistrement> getRapportEnregistrement();


	
	/**
	 * method getMessagesEnregistrementsRapports() :<br/>
	 * agrége les messages de création de rapport de contrôle sur disque 
	 * et retourne une String pour l'affichage des messages 
	 * de création/refus de création des rapports de contrôle uniquement 
	 * (pas de tout this.rapportEnregistrement).<br/>
	 * <br/>
	 *
	 * @return : String : Affichage à la console.<br/>
	 */
	String getMessagesEnregistrementsRapports();
	
	
	
	/**
	 * method afficherRapportEnregistrementTextuel() :<br/>
	 * Retourne une String pour afficher à la console au format textuel 
	 * this.rapportEnregistrement.<br/>
	 * <br/>
	 * - retourne null si pList est null.<br/>
	 * <br/>
	 *
	 * @return : String : Affichage à la console.<br/>
	 */
	String afficherRapportEnregistrementTextuel();
	

	
	/**
	 * method afficherRapportEnregistrementTextuel(
	 * List&lt;LigneRapportEnregistrement&gt; pList) :<br/>
	 * Retourne une String pour afficher à la console au format textuel 
	 * une List&lt;LigneRapportEnregistrement&gt;.<br/>
	 * <br/>
	 * - retourne null si pList est null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;LigneRapportEnregistrement&gt;.<br/>
	 * 
	 * @return : String : Affichage à la console.<br/>
	 */
	String afficherRapportEnregistrementTextuel(
			final List<LigneRapportEnregistrement> pList);


	
	/**
	 * method afficherRapportEnregistrementCsv() :<br/>
	 * Retourne une String pour afficher à la console au format csv 
	 * this.rapportEnregistrement.<br/>
	 * <br/>
	 * - retourne null si pList est null.<br/>
	 * <br/>
	 *
	 * @return : String : Affichage à la console.<br/>
	 */
	String afficherRapportEnregistrementCsv();
	

	
	/**
	 * method afficherRapportEnregistrementCsv(
	 * List<LigneRapportEnregistrement> pList
	 * , boolean pEnTete) :<br/>
	 * Retourne une String pour afficher à la console au format csv 
	 * une List&lt;LigneRapportEnregistrement&gt;.<br/>
	 * - Ajout d'un caractère BOM-UTF-8 pour forcer Excel 2010 
	 * à détecter l'UTF-8.<br/>
	 * <br/>
	 * - retourne null si pList est null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;LigneRapportEnregistrement&gt;.<br/>
	 * @param pEnTete : boolean : true si on veut 
	 * rajouter l'en-tête au rapport csv.<br/>
	 * 
	 * @return : String : Affichage à la console.<br/>
	 */
	String afficherRapportEnregistrementCsv(
			final List<LigneRapportEnregistrement> pList
				, final boolean pEnTete);

	
	
} // FIn DE L'INTERFACE IEnregistreurRapport.------------------------------
