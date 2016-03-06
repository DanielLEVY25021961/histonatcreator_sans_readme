package levy.daniel.application.metier.controles;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

import levy.daniel.application.metier.controles.rapportscontroles.LigneRapport;
import levy.daniel.application.metier.service.enregistreursfichiers.rapportsenregistrements.LigneRapportEnregistrement;


/**
 * class IEnregistreurRapport :<br/>
 * Interface centralisant les méthodes 
 * de tous les contrôles susceptibles d'enregistrer 
 * sur disque un rapport de contrôle.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
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



} // FIn DE L'INTERFACE IEnregistreurRapport.------------------------------
