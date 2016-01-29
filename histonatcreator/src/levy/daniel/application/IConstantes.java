package levy.daniel.application;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


/**
 * class IConstantes :<br/>
 * Interface regroupant toutes les constantes 
 * à mettre à la disposition de toute l'application.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <br/>
 *
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author LEVY Lévy
 * @version 1.0
 * @since 27 déc. 2011
 *
 */
public interface IConstantes {
		
	/**
	 * DIMENSION_ECRAN : Dimension :<br/>
	 * La dimension de l'écran de l'utilisateur.<br/>
	 */
	Dimension DIMENSION_ECRAN 
		= Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * LARGEUR_ECRAN : int :<br/>
	 * Largeur de l'écran de l'utilisateur en pixels.<br/>
	 */
	int LARGEUR_ECRAN = DIMENSION_ECRAN.width;
	
	
	/**
	 * HAUTEUR_ECRAN : int :<br/>
	 * Hauteur de l'écran de l'utilisateur en pixels.<br/>
	 */
	int HAUTEUR_ECRAN = DIMENSION_ECRAN.height;
	

	
	/**
	 * LOCALE_FR : Locale : <br/>
	 * Locale France.<br/>
	 */
	Locale LOCALE_FR = new Locale("fr", "FR");
	
	
	/**
	 * BUNDLE_APPLICATION : ResourceBundle : <br/>
	 * application.properties.<br/>
	 */
	ResourceBundle BUNDLE_APPLICATION 
		= ResourceBundle.getBundle("application", LOCALE_FR);
	
	
	/**
	 * BUNDLE_CONTROLE : ResourceBundle : <br/>
	 * messagescontroles.properties.<br/>
	 */
	ResourceBundle BUNDLE_CONTROLE 
		= ResourceBundle.getBundle("messagescontroles", LOCALE_FR);

	
	/**
	 * BUNDLE_TECHNIQUE : ResourceBundle : <br/>
	 * messagestechniques.properties.<br/>
	 */
	ResourceBundle BUNDLE_TECHNIQUE 
		= ResourceBundle.getBundle("messagestechniques", LOCALE_FR);

	
	/**
	 * BUNDLE_DIFF : ResourceBundle : <br/>
	 * messagesdiff.properties.<br/>
	 */
	ResourceBundle BUNDLE_DIFF 
		= ResourceBundle.getBundle("messagesdiff", LOCALE_FR);
	
	
	/**
	 * STATS_ACTIVEES : Boolean :<br/>
	 * Affiche les Stats Hibernate si true.<br/>
	 */
	Boolean STATS_ACTIVEES 
		= Boolean.valueOf(
		(String) BUNDLE_TECHNIQUE.getObject("abstractdao.statsactivees"));
	
	
	/**
	 * SUCCES : String : <br/>
	 * "success".<br/>
	 */
	String SUCCES = "success";
	
	/**
	 * ECHEC : String : <br/>
	 * "failure".<br/>
	 */
	String ECHEC = "failure";

	
	/**
	 * CHEMIN_SQL_VIDAGE_BASE : String :<br/>
	 * Chemin du Script SQL de vidage de la base 
	 * (stocké dans application_fr_FR.properties).<br/>
	 */
	String CHEMIN_SQL_VIDAGE_BASE 
		= BUNDLE_APPLICATION.getString("chemin.scriptvidagebase");
	
	
	/**
	 * GERER_OPERATIONS : Boolean :<br/>
	 * Boolean qui stipule si on veut gérer les Operation
	 * (CREATION, SUPPRESSION, ...) d'un Objet metier X ou pas.<br/>
	 * <br/>
	 * Annule toute la gestion des Operation si false. 
	 * Sert de commutateur général à la gestion des Operation.<br/>
	 * <br/>
	 * Gère les Operation de X si true <b><br>ET</br></b> si le 
	 * GERER_OPERATION_X vaut true.<br/>
	 * <br/>
	 */
	Boolean GERER_OPERATIONS 
		= Boolean.valueOf((String) IConstantes.BUNDLE_APPLICATION
			.getObject("application.gerer.operations"));

	
	/**
	 * GERER_OPERATIONS_USER : Boolean :<br/>
	 * Boolean qui stipule si on veut gérer les Operation
	 * (CREATION, SUPPRESSION, ...) ou pas pour les User 
	 * (Internautes connectés à l'application).<br/>
	 * <br/>
	 * (stocké dans application_fr_FR.properties).<br/>
	 * <br/>
	 * Gère les Operation relatives au User si true 
	 * <b><br>ET</br></b> si GERER_OPERATIONS vaut true.<br/>
	 * <br/>
	 */
	Boolean GERER_OPERATIONS_USER 
	= Boolean.valueOf((String) IConstantes.BUNDLE_APPLICATION
			.getObject("application.gerer.operations.user"));
	
	
	/**
	 * GERER_OPERATIONS_USER_CREATION : Boolean :<br/>
	 * Boolean qui stipule si on veut gérer les Operation 
	 * de CREATION 
	 * pour les User (Internautes connectés à l'application).<br/>
	 * <br/>
	 * (stocké dans application_fr_FR.properties).<br/>
	 * <br/>
	 * Gère les Operation relatives au User si true 
	 * <b><br>ET</br></b> si GERER_OPERATIONS vaut true.<br/>
	 * <br/>
	 */
	Boolean GERER_OPERATIONS_USER_CREATION 
	= Boolean.valueOf((String) IConstantes.BUNDLE_APPLICATION
			.getObject("application.gerer.operations.user.creation"));
	

	/**
	 * GERER_OPERATIONS_LOCALISATIONPR : Boolean :<br/>
	 * Boolean qui stipule si on veut gérer les Operation
	 * (CREATION, SUPPRESSION, ...) ou pas pour les 
	 * LocalisationPR.<br/>
	 * <br/>
	 * (stocké dans application_fr_FR.properties).<br/>
	 * <br/>
	 * Gère les Operation relatives au LocalisationPR si true 
	 * <b><br>ET</br></b> si GERER_OPERATIONS vaut true.<br/>
	 * <br/>
	 */
	Boolean GERER_OPERATIONS_LOCALISATIONPR 
		= Boolean.valueOf((String) IConstantes.BUNDLE_APPLICATION
			.getObject("application.gerer.operations.localisationpr"));

	
	/**
	 * GERER_OPERATIONS_LOCALISATION_PLOTYPEPR : Boolean :<br/>
	 * Boolean qui stipule si on veut gérer les Operation
	 * (CREATION, SUPPRESSION, ...) ou pas pour les 
	 * LocalisationPLOTypePR.<br/>
	 * <br/>
	 * (stocké dans application_fr_FR.properties).<br/>
	 * <br/>
	 * Gère les Operation relatives au LocalisationPLOTypePR si true 
	 * <b><br>ET</br></b> si GERER_OPERATIONS vaut true.<br/>
	 * <br/>
	 */
	Boolean GERER_OPERATIONS_LOCALISATION_PLOTYPEPR 
		= Boolean.valueOf((String) IConstantes.BUNDLE_APPLICATION
			.getObject("application.gerer.operations.localisationplotypepr"));
	
	
	/**
	 * GERER_OPERATIONS_LOCALISATIONPLOGENERIQUE : Boolean :<br/>
	 * Boolean qui stipule si on veut gérer les Operation
	 * (CREATION, SUPPRESSION, ...) ou pas pour les 
	 * LocalisationPLOGenerique.<br/>
	 * <br/>
	 * (stocké dans application_fr_FR.properties).<br/>
	 * <br/>
	 * Gère les Operation relatives au LocalisationPLOGenerique si true 
	 * <b><br>ET</br></b> si GERER_OPERATIONS vaut true.<br/>
	 * <br/>
	 */
	Boolean GERER_OPERATIONS_LOCALISATIONPLOGENERIQUE 
		= Boolean.valueOf((String) IConstantes.BUNDLE_APPLICATION
			.getObject("application.gerer.operations.localisationplogenerique"));

	
	/**
	 * GERER_OPERATIONS_LOCALISATIONGEOGRAPHIQUE : Boolean :<br/>
	 * Boolean qui stipule si on veut gérer les Operation
	 * (CREATION, SUPPRESSION, ...) ou pas pour les 
	 * LocalisationGeographique.<br/>
	 * <br/>
	 * Va chercher l'information dans application_fr_FR.properties.<br/>
	 * <br/>
	 * Gère les Operation relatives au LocalisationGeographique si true 
	 * <b><br>ET</br></b> si GERER_OPERATIONS vaut true.<br/>.<br/>
	 * <br/>
	 */
	Boolean GERER_OPERATIONS_LOCALISATIONGEOGRAPHIQUE 
	= Boolean.valueOf((String) IConstantes.BUNDLE_APPLICATION
			.getObject("application.gerer.operations.localisationgeo"));
	
	
	/**
	 * GERER_OPERATIONS_SECTIONTRAFIC : Boolean :<br/>
	 * Boolean qui stipule si on veut gérer les Operation
	 * (CREATION, SUPPRESSION, ...) ou pas pour les 
	 * SectionTrafic.<br/>
	 * <br/>
	 * Va chercher l'information dans application_fr_FR.properties.<br/>
	 * <br/>
	 * Gère les Operation relatives au SectionTrafic si true 
	 * <b><br>ET</br></b> si GERER_OPERATIONS vaut true.<br/>
	 */
	Boolean GERER_OPERATIONS_SECTIONTRAFIC 
		= Boolean.valueOf((String) IConstantes.BUNDLE_APPLICATION
			.getObject("application.gerer.operations.sectiontrafic"));
	
	
	/**
	 * GERER_OPERATIONS_CREATION_SECTIONTRAFIC : Boolean :<br/>
	 * Boolean qui stipule si on veut gérer les Operation CREATION
	 * ou pas pour les SectionTrafic.<br/>
	 * <br/>
	 * Va chercher l'information dans application_fr_FR.properties.<br/>
	 * <br/>
	 * Gère les Operation relatives au SectionTrafic si true 
	 * <b><br>ET</br></b> si GERER_OPERATIONS_SECTIONTRAFIC vaut true
	 * <b><br>ET</br></b> si GERER_OPERATIONS vaut true.<br/>
	 */
	Boolean GERER_OPERATIONS_CREATION_SECTIONTRAFIC 
		= Boolean.valueOf((String) IConstantes.BUNDLE_APPLICATION
			.getObject("application.gerer.operations.sectiontrafic.creation"));
	
	
	/**
	 * SUPPRIMER_REELLEMENT : Boolean :<br/>
	 * Boolean qui stipule si on doit réellement supprimer
	 * les ValueObject ou juste les flager "SUPPRIME".<br/>
	 */
	Boolean SUPPRIMER_REELLEMENT = false;
	
	
	/**
	 * SEP_PV : String :<br/>
	 * Séparateur pour les CSV ";".<br/>
	 */
	String SEP_PV = ";";

    
	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	String SEPARATEUR_MOINS_AERE = " - ";
	
	
	/**
	 * UNDERSCORE : String :<br/>
	 * "_".<br/>
	 */
	String UNDERSCORE = "_";

	
	/**
	 * SAUT_LIGNE : String :<br/>
	 * saut de ligne "\n".<br/>
	 */
	String SAUT_LIGNE = "\n";

	
	/**
	 * TAB : String :<br/>
	 * Tabulation "\t".<br/>
	 */
	String TAB = "\t";
	
	
	/**
	 * DF_DATE_FRANCAISE : DateFormat :<br/>
	 * Format classique des dates françaises comme
	 * '25/02/1961'.<br/>
	 */
	DateFormat DF_DATE_FRANCAISE 
	= new SimpleDateFormat("dd/MM/yyyy", LOCALE_FR);
	
	
	/**
	 * DF_DATE_COMPLETE_FRANCAISE : DateFormat :<br/>
	 * Format complet des dates françaises comme
	 * 'samedi 25 février 1961'.<br/>
	 */
	DateFormat DF_DATE_COMPLETE_FRANCAISE 
		= new SimpleDateFormat("EEEE' 'dd' 'MMMM' 'yyyy"
			, LOCALE_FR);

	
	/**
	 * DF_MOIS_ANNEE : DateFormat :<br/>
	 * Format des dates françaises avec mois-année comme
	 * 'février 1961'.<br/>
	 */
	DateFormat DF_MOIS_ANNEE 
		= new SimpleDateFormat("MMMM' 'yyyy"
			, LOCALE_FR);

	
	/**
	 * DF_MOIS_ANNEE_SIMPLE : DateFormat :<br/>
	 * Format des dates françaises avec mois simplifié-année comme
	 * '02/1961'.<br/>
	 */
	DateFormat DF_MOIS_ANNEE_SIMPLE 
	= new SimpleDateFormat("MM/yyyy", LOCALE_FR);
	
	
	/**
	 * DF_ANNEE : DateFormat :<br/>
	 * Format des dates avec juste l'année comme "1961".<br/>
	 */
	DateFormat DF_ANNEE 
		= new SimpleDateFormat("yyyy", LOCALE_FR);
	

	/**
	 * DF_DATE_AVEC_HEURE_MINUTE_SECONDE : DateFormat :<br/>
	 * Format classique des dates avec heures et secondes
	 * comme "2012-01-16 à 18 heures,09 minutes,55 secondes" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	DateFormat DF_DATE_AVEC_HEURE_MINUTE_SECONDE 
	= new SimpleDateFormat("yyyy-MM-dd' " 
	+ "à 'HH' heures,'mm' minutes,'ss' secondes'", LOCALE_FR);
	
	 
	/**
	 * DF_DATE_HEURE_MINUTE_SECONDE : DateFormat :<br/>
	 * Format concentré des dates avec heures et secondes
	 * comme "2012-01-16:18-09-55" pour le
	 * 16 Janvier 2012 à 18 heures 9 minutes et 55 secondes.<br/>
	 */
	DateFormat DF_DATE_HEURE_MINUTE_SECONDE 
		= new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss", LOCALE_FR);


	
	/**
	 * MOTIF_NOM_LATIN : String : <br/>
	 * motif pour le java.util.regex.Pattern 
	 * décrivant un nom latin de taxon 
	 * (par exemple Amanita virosa).<br/>
	 * <br/>
	 * - Lettre de début : Groupe capturant 1 : ([a-zA-Z]{1}) : 
	 * une seule fois ({1}) une lettre prise 
	 * dans l'ensemble ([a-z ou A-Z])<br/>
	 * A transformer en majuscule.<br/>
	 * <br/>
	 * - une ou plusieurs minuscules : Groupe capturant 2 : ([a-zA-Z]+).<br/>
	 * C'est la suite du genre (après la majuscule). 
	 * Doit être mis en minuscules.<br/>
	 * <br/>
	 * - Espaces : Groupe capturant 3 : 
	 * (\\s+) : 1 ou plusieurs (+) espaces (\\s)<br/>
	 * <br/>
	 * - une ou plusieurs lettres : Groupe capturant 4 : ([a-zA-Z]+).<br/>
	 * A mettre tout en minuscules.<br/>
	 */
	String MOTIF_NOM_LATIN 
	= "([a-zA-Z]{1})([a-zA-Z]+)(\\s+)([a-zA-Z]+)";

	
	/**
	 * MOTIF_TYPE_ROUTE : String :<br/>
	 * motif pour le java.util.regex.Pattern 
	 * décrivant le type d'une route 
	 * (N pour Nationale, A pour Autoroute, ...).<br/>
	 */
	String MOTIF_TYPE_ROUTE = "([[N][n][A][a][C][c][D][d]])";

	
	/**
	 * MOTIF_ROUTE_ISIDOR : String :<br/>
	 * Motif pour le java.util.regex.Pattern décrivant une route ISIDOR 
	 * (N0020 ou A0386b2)
	 * avec : <br/>
	 * - la lettre A, a, n, N, C, c, D, d au début 
	 * ([[N][n][A][a][C][c][D][d]]).<br/>
	 * - 4 chiffres ([0-9]{4}).<br/>
	 * - 1 ou 0 indice lettre ([a-z]?).<br/>
	 * - 1 ou 0 indice chiffre ([1-9]?).<br/>
	 */
	String MOTIF_ROUTE_ISIDOR 
		= "([[N][n][A][a][C][c][D][d]])([0-9]{4})([a-z]?)([1-9]?)";
	
	
	
	/**
	 * CHEMIN_DESCRIPTIONS : String :<br/>
	 * Chemin des descriptions de fichier 
	 * stocké dans application.properties.<br/>
	 * ".\\ressources\\descriptions\\".<br/>
	 */
	String CHEMIN_DESCRIPTIONS 
		= BUNDLE_APPLICATION.getString(
				"application.repertoire.ressources.descriptions");

	
	/**
	 * NOM_DESCRIPTION_HIT : String :<br/>
	 * Nom du fichier de description du HIT
	 * stocké dans application.properties.<br/>
	 * "2014-07-19_Description_HIT_Utf8.csv".<br/>
	 */
	String NOM_DESCRIPTION_HIT 
		= BUNDLE_APPLICATION.getString(
				"application.repertoire.ressources.descriptions.hit");
	
	
	/**
	 * NOM_DESCRIPTION_HISTONAT : String :<br/>
	 * Nom du fichier de description du HistoF07 
	 * stocké dans application.properties.<br/>
	 * "2014-07-19_Description_HistoF07_Utf8.csv".<br/>
	 */
	String NOM_DESCRIPTION_HISTONAT 
		= BUNDLE_APPLICATION.getString(
			"application.repertoire.ressources.descriptions.histof07");

	
	/**
	 * NOM_DESCRIPTION_DARWINCSV : String :<br/>
	 * Nom du fichier de description du Darwin.csv
	 * stocké dans application.properties.<br/>
	 * "Description_DarwinCsv.csv".<br/>
	 */
	String NOM_DESCRIPTION_DARWINCSV 
		= BUNDLE_APPLICATION.getString(
			"application.repertoire.ressources.descriptions.darwincsv");
	
	/**
	 * NOM_DESCRIPTION_MAPPING : String :<br/>
	 * Nom du fichier de description du Mapping Histo-Hit-Darwin-Isidor 
	 * stocké dans application.properties.<br/>
	 * "Description_MAPPING_HistoF07_Hit_Darwin_Isidor.csv".<br/>
	 */
	String NOM_DESCRIPTION_MAPPING 
		= BUNDLE_APPLICATION.getString(
			"application.repertoire.ressources.descriptions.mapping");
	

	// NOMENCLATURES.*******************************
	// HIT.*********************
	/**
	 * CHEMIN_NOMENCLATURES_HIT_UTF8 : String :<br/>
	 * Chemin des nomenclatures en UTF-8 des champs pour les HIT
	 * stocké dans application.properties.<br/>
	 * ".\\ressources\\Nomenclatures\\Hit\\Nomenclatures en UTF-8\\".<br/>
	 */
	String CHEMIN_NOMENCLATURES_HIT_UTF8 
	= BUNDLE_APPLICATION.getString(
			"application.repertoire.ressources.nomenclatures.chemin.hit.utf8");
	
	
	/**
	 * NOM_NOMENCLATURE_HIT_SENS : String :<br/>
	 * Nom du fichier de nomenclature du sens pour les HIT en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Sens_Hit_Utf8.csv".<br/>
	 */
	String NOM_NOMENCLATURE_HIT_SENS = BUNDLE_APPLICATION.getString(
			"application.repertoire.ressources.nomenclatures.sens.hit");
	
	/**
	 * NOM_NOMENCLATURE_HIT_NATURE : String :<br/>
	 * Nom du fichier de nomenclature de la nature pour les HIT en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Nature_Hit_Utf8.csv".<br/>
	 */
	String NOM_NOMENCLATURE_HIT_NATURE = BUNDLE_APPLICATION.getString(
			"application.repertoire.ressources.nomenclatures.nature.hit");
	
	
	// HISTOF07.
	/**
	 * CHEMIN_NOMENCLATURES_HISTOF07_UTF8 : String :<br/>
	 * Chemin des nomenclatures en UTF-8 des champs pour les HISTONATF07
	 * stocké dans application.properties.<br/>
	 * ".\\ressources\\Nomenclatures\\HistonatF07\\Nomenclatures en UTF-8\\".<br/>
	 */
	String CHEMIN_NOMENCLATURES_HISTOF07_UTF8 
	= BUNDLE_APPLICATION.getString(
			"application.repertoire.ressources.nomenclatures.chemin.histof07.utf8");
	
	
	/**
	 * NOM_NOMENCLATURE_HISTOF07_SENS : String :<br/>
	 * Nom du fichier de nomenclature du sens pour les HISTONATF07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Sens_Histof07_Utf8.csv".<br/>
	 */
	String NOM_NOMENCLATURE_HISTOF07_SENS = BUNDLE_APPLICATION.getString(
			"application.repertoire.ressources.nomenclatures.sens.histof07");
	
	
	/**
	 * NOM_NOMENCLATURE_HISTOF07_NATURE : String :<br/>
	 * Nom du fichier de nomenclature de la nature pour les HISTONATF07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Nature_Histof07_Utf8.csv".<br/>
	 */
	String NOM_NOMENCLATURE_HISTOF07_NATURE = BUNDLE_APPLICATION.getString(
			"application.repertoire.ressources.nomenclatures.nature.histof07");
	
	
	// DARWIN.
	/**
	 * CHEMIN_NOMENCLATURES_DARWIN_UTF8 : String :<br/>
	 * Chemin des nomenclatures en UTF-8 des champs pour les DARWIN
	 * stocké dans application.properties.<br/>
	 * ".\\ressources\\Nomenclatures\\Darwin\\Nomenclatures en UTF-8\\".<br/>
	 */
	String CHEMIN_NOMENCLATURES_DARWIN_UTF8 
	= BUNDLE_APPLICATION.getString(
			"application.repertoire.ressources.nomenclatures.chemin.darwin.utf8");
	
	
	/**
	 * NOM_NOMENCLATURE_DARWIN_SENS : String :<br/>
	 * Nom du fichier de nomenclature du sens pour les DARWIN en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Sens_Darwin_Utf8.csv".<br/>
	 */
	String NOM_NOMENCLATURE_DARWIN_SENS = BUNDLE_APPLICATION.getString(
			"application.repertoire.ressources.nomenclatures.sens.darwin");
	

	/**
	 * DEFAULT_CHARSET : Charset :<br/>
	 * Charset de la plateforme.<br/>
	 */
	Charset DEFAULT_CHARSET 
		= Charset.forName(System.getProperty("file.encoding"));
	
	
	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset UTF-8.<br/>
	 */
	Charset CHARSET_UTF8 = Charset.forName("UTF-8");
	
	
	/**
	 * CHARSETENCODER_UTF8 : CharsetEncoder :<br/>
	 * charsetEncoderUtf8.<br/>
	 */
	CharsetEncoder CHARSETENCODER_UTF8 
		= CHARSET_UTF8.newEncoder();
	
	
	/**
	 * CHARSETDECODER_UTF8 : CharsetDecoder :<br/>
	 * charsetDecoderUtf8.<br/>
	 */
	CharsetDecoder CHARSETDECODER_UTF8 
		= CHARSET_UTF8.newDecoder();
	
	
	/**
	 * CHARSET_WINDOWS1252 : Charset :<br/>
	 * Charset Windows-1252.<br/>
	 */
	Charset CHARSET_WINDOWS1252 = Charset.forName("Windows-1252");
	
	
	/**
	 * CHARSETENCODER_WINDOWS1252 : CharsetEncoder :<br/>
	 * charsetEncoderWindows-1252.<br/>
	 */
	CharsetEncoder CHARSETENCODER_WINDOWS1252 
		= CHARSET_WINDOWS1252.newEncoder();
	
	
	/**
	 * CHARSETDECODER_WINDOWS1252 : CharsetDecoder :<br/>
	 * charsetDecoderWindows-1252.<br/>
	 */
	CharsetDecoder CHARSETDECODER_WINDOWS1252
		= CHARSET_WINDOWS1252.newDecoder();
	

	/**
	 * CHARSET_IBM850 : Charset :<br/>
	 * Charset IBM850.<br/>
	 */
	Charset CHARSET_IBM850 = Charset.forName("IBM850");
	
	
	/**
	 * CHARSETENCODER_IBM850 : CharsetEncoder :<br/>
	 * charsetEncoder IBM850.<br/>
	 */
	CharsetEncoder CHARSETENCODER_IBM850 
			= CHARSET_IBM850.newEncoder();
	
	
	/**
	 * CHARSETDECODER_IBM850 : CharsetDecoder :<br/>
	 * charsetDecoder IBM850.<br/>
	 */
	CharsetDecoder CHARSETDECODER_IBM850
		= CHARSET_IBM850.newDecoder();

		
	/**
	 * CHARSET_LATIN9 : Charset :<br/>
	 * Charset ISO-8859-15.<br/>
	 */
	Charset CHARSET_LATIN9 = Charset.forName("ISO-8859-15");
	
	
	/**
	 * CHARSETENCODER_LATIN9 : CharsetEncoder :<br/>
	 * charsetEncoder ISO-8859-15.<br/>
	 */
	CharsetEncoder CHARSETENCODER_LATIN9 
		= CHARSET_LATIN9.newEncoder();
	
	
	/**
	 * CHARSETDECODER_LATIN9 : CharsetDecoder :<br/>
	 * charsetDecoder ISO-8859-15.<br/>
	 */
	CharsetDecoder CHARSETDECODER_LATIN9
		= CHARSET_LATIN9.newDecoder();
	

	
	/**
	 * PATTERN_SEPARATEUR_CSV : Pattern :<br/>
	 * Pattern pour casser les lignes csv avec séparateur ';' 
	 * en String[] tokens.<br/>
	 */
	Pattern PATTERN_SEPARATEUR_CSV = Pattern.compile(";");
	
	
	
} // FIN DE IConstantes.-----------------------------------------------------
