package levy.daniel.application.metier.controles.impl.controlessurface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import levy.daniel.application.metier.controles.AbstractControle;
import levy.daniel.application.metier.controles.rapportscontroles.LigneRapport;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class Transcodeur :<br/>
 * .<br/>
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
 * @author dan Lévy
 * @version 1.0
 * @since 15 mars 2016
 *
 */
public class Transcodeur extends AbstractControle {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_TRANSCODEUR : String :<br/>
	 * "Classe Transcodeur".<br/>
	 */
	public static final String CLASSE_TRANSCODEUR 
		= "Classe Transcodeur";
	
	
	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	public static final Charset CHARSET_UTF8 
		= Charset.forName("UTF-8");

	
	/**
	 * CHARSET_ANSI : Charset :<br/>
	 * Charset.forName("windows-1252").<br/>
	 * ANSI, CP1252.<br/>
	 * 218 caractères imprimables.<br/>
	 * extension d’ISO-8859-1, qui rajoute quelques caractères: œ, € (euro), 
	 * guillemets anglais (« »), points de suspension (...)
	 * , signe «pour mille» (‰), 
	 * tirets cadratin (— = \u2014 en unicode ) et demi-cadratin (–), ...<br/>
	 */
	public static final Charset CHARSET_ANSI
		= Charset.forName("windows-1252");
	
	
	/**
	 * CHARSET_IBM850 : Charset :<br/>
	 * Charset IBM-850.<br/>
	 * Cp850, MS-DOS Latin-1.<br/>
	 */
	public static final Charset CHARSET_IBM850
		= Charset.forName("IBM-850");
	

	/**
	 * fileEnUtf8 : File :<br/>
	 * fichier réencodé en UTF-8.<br/>
	 */
	private transient File fileEnUtf8;
	
	
	/**
	 * fileEnAnsi : File :<br/>
	 * fichier réencodé en ANSI.<br/>
	 */
	private transient File fileEnAnsi;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(Transcodeur.class);

	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR Transcodeur() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 * - Met automatiquement 2 dans this.ordreControle.<br/>
	 * - Met automatiquement dateControle à date système.<br/>
	 * - Met automatiquement userName à "Administrateur".<br/>
	 * - Met automatiquement fichier à null.<br/>
	 * <br/>
	 * - Remplit le nom de la classe concrète this.nomClasseConcrete fourni 
	 * par this.fournirNomClasseConcrete() dans la classe concrète.<br/>
	 * - calcule automatiquement dateControleStringFormattee.<br/>
	 * - calcule automatiquement nomFichier.<br/>
	 * - Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.<br/>
	 * - Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.<br/>
	 * - Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.<br/>
	 * - Remplit gravite (ce qui remplit également niveauAnomalie).<br/>
	 * - Va chercher dans messagescontroles_fr_FR.properties 
	 * si le contrôle doit être effectué et remplit this.aEffectuer.<br/>
	 * <br/>
	 */
	public Transcodeur() {
		
		this(2, null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method CONSTRUCTEUR Transcodeur(
	 * File pFichier) :<br/>
	 * Constructeur avec fichier.<br/>
	 * <br/>
	 * - Met automatiquement 2 dans this.ordreControle.<br/>
	 * - Met automatiquement dateControle à date système.<br/>
	 * - Met automatiquement userName à "Administrateur".<br/>
	 * <br/>
	 * <ul>
	 * <li>Remplit le nom de la classe concrète this.nomClasseConcrete 
	 * fourni par this.fournirNomClasseConcrete() dans la classe concrète.</li><br/>
	 * <li>calcule automatiquement dateControleStringFormattee.</li><br/>
	 * <li>passe pFichier à this.fichier.</li><br/>
	 * <li>calcule automatiquement nomFichier.</li><br/>
	 * <li>Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.</li><br/>
	 * <li>Remplit gravite (ce qui remplit également niveauAnomalie).</li><br/>
	 * <li>Va chercher dans messagescontroles_fr_FR.properties 
	 * si le contrôle doit être effectué et remplit this.aEffectuer.</li><br/>
	 * </ul>
	 * <br/>
	 *
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 */
	public Transcodeur(
			final File pFichier) {
		
		this(2, null, null, pFichier);
		
	} // Fin de Transcodeur(
	 // File pFichier).____________________________________________________

	
	
	 /**
	 * method CONSTRUCTEUR Transcodeur(
	 * String pUserName
	 * , File pFichier) :<br/>
	 * Constructeur avec user et fichier.<br/>
	 * <br/>
	 * - Met automatiquement 2 dans this.ordreControle.<br/>
	 * - Met automatiquement dateControle à date système.<br/>
	 * <br/>
	 * <ul>
	 * <li>initialise éventuellement le bundleControles qui encapsule 
	 * messagescontroles_fr_FR.properties.</li><br/>
	 * <li>Remplit le nom de la classe concrète this.nomClasseConcrete 
	 * fourni par this.fournirNomClasseConcrete() dans la classe concrète.</li><br/>
	 * <li>calcule automatiquement dateControleStringFormattee.</li><br/>
	 * <li>remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.</li><br/>
	 * <li>passe pFichier à this.fichier.</li><br/>
	 * <li>calcule automatiquement nomFichier.</li><br/>
	 * <li>Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.</li><br/>
	 * <li>Remplit gravite (ce qui remplit également niveauAnomalie).</li><br/>
	 * <li>Va chercher dans messagescontroles_fr_FR.properties 
	 * si le contrôle doit être effectué et remplit this.aEffectuer.</li><br/>
	 * </ul>
	 * <br/>
	 *
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/> 
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 */
	public Transcodeur(
			final String pUserName
					, final File pFichier) {
		
		this(2, null, pUserName, pFichier);
		
	} // Fin de Transcodeur(
	 // String pUserName
	 // , File pFichier).__________________________________________________
	

	/**
	 * method CONSTRUCTEUR Transcodeur() :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 * <ul>
	 * <li>initialise éventuellement le bundleControles qui encapsule 
	 * messagescontroles_fr_FR.properties.</li><br/>
	 * <li>Remplit le nom de la classe concrète this.nomClasseConcrete fourni 
	 * par this.fournirNomClasseConcrete() dans la classe concrète.</li><br/>
	 * <li>passe pOrdreControle à this.ordreControle.</li><br/>
	 * <li>Remplit dateControle avec pDateControle si pDateControle != null 
	 * ou la date système sinon.</li><br/>
	 * <li>calcule automatiquement dateControleStringFormattee.</li><br/>
	 * <li>remplit userName avec pUserName si pUserName != null 
	 * ou 'Administrateur' sinon.</li><br/>
	 * <li>passe pFichier à this.fichier.</li><br/>
	 * <li>calcule automatiquement nomFichier.</li><br/>
	 * <li>Remplit le type du contrôle typeControle fourni par 
	 * this.fournirTypeControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du contrôle nomControle fourni par 
	 * this.fournirNomControle() dans la classe concrète.</li><br/>
	 * <li>Remplit le nom du critère nomCritere fourni par 
	 * this.fournirNomCritere() dans la classe concrète.</li><br/>
	 * <li>Remplit gravite (ce qui remplit également niveauAnomalie 
	 * et estBloquant).</li><br/>
	 * <li>Va chercher dans messagescontroles_fr_FR.properties 
	 * si le contrôle doit être effectué et remplit this.aEffectuer.</li><br/>
	 * </ul>
	 * <br/>
	 *
	 * @param pOrdreControle : Integer : ordre d'exécution du contrôle
	 * @param pDateControle : Date : java.util.Date du contrôle.<br/>
	 * @param pUserName : String : nom de l'utilisateur 
	 * qui a déclenché le contrôle.<br/> 
	 * @param pFichier : File : fichier sur lequel s'applique le contrôle.<br/>
	 */
	public Transcodeur(
			final Integer pOrdreControle
			, final Date pDateControle
				, final String pUserName
					, final File pFichier) {
		
		super(pOrdreControle, pDateControle, pUserName, pFichier);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean controler(
			final File pFile) {
		
		return this.controler(pFile, false);
		
	} // Fin de controler(
	 // File pFile)._______________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean controler(
			final File pFile
				, final boolean pEnregistrerRapport) {

		// Traitement des mauvais fichiers.************
		final boolean resultatTraitementMauvaisFichier = this
				.traiterMauvaisFile(pFile, pEnregistrerRapport,
						METHODE_CONTROLER);

		/*
		 * Sort de la méthode et retourne false si le fichier est mauvais.
		 */
		if (!resultatTraitementMauvaisFichier) {
			return false;
		}

		/*
		 * passe pFile à this.fichier et rafraîchit automatiquement
		 * this.nomFichier.
		 */
		this.setFichier(pFile);

		/*
		 * rafraîchit le rapport (en instancie un nouveau à chaque appel de la
		 * méthode controler(File pFile)).
		 */
		this.rapport = new ArrayList<LigneRapport>();

		// TRAITEMENT **********************************************
		// CREATION DES FICHIERS EN UTF-8 et ANSI.
		this.fileEnAnsi = this.creerFileANSI(pFile);
		this.fileEnUtf8 = this.creerFileUTF8(pFile);
				
		// LECTURE LIGNE PAR LIGNE ***************
		/* Lit le fichier ligne par ligne en ANSI 
		 * et remplit this.fichierEnMap. */
		this.lireFichierLigneParLigne(pFile, CHARSET_ANSI);
		
		/* retourne false si this.fichierEnMap == null. */
		if (this.fichierEnMap == null) {
			return false;
		}
		
		final Set<Entry<Integer, String>> set = this.fichierEnMap.entrySet();
		
		if (set == null) {
			return false;
		}
		
		final Iterator<Entry<Integer, String>> ite = set.iterator();
		
		if (ite == null) {
			return false;
		}
		
		boolean resultat = true;
		
		// ECRITURE SUR DISQUE ***************
		FileOutputStream fileOutputStreamAnsi = null;
		OutputStreamWriter outputStreamWriterAnsi = null;
		BufferedWriter bufferedWriterAnsi = null;
		
		FileOutputStream fileOutputStreamUtf8 = null;
		OutputStreamWriter outputStreamWriterUtf8 = null;
		BufferedWriter bufferedWriterUtf8 = null;
							
		try {
			
			/* Ouverture d'un FileOutputStream sur les fichier. */
			fileOutputStreamAnsi = new FileOutputStream(this.fileEnAnsi, true);
			fileOutputStreamUtf8 = new FileOutputStream(this.fileEnUtf8, true);
			/*
			 * Ouverture des OutputStreamWriter sur les FileOutputStream en 
			 * passant les Charsets.
			 */
			outputStreamWriterAnsi = new OutputStreamWriter(fileOutputStreamAnsi,
					CHARSET_ANSI);
			outputStreamWriterUtf8 = new OutputStreamWriter(fileOutputStreamUtf8,
					CHARSET_UTF8);
			/*
			 * Ouverture d'un tampon d'écriture BufferedWriter sur le
			 * OutputStreamWriter.
			 */
			bufferedWriterAnsi = new BufferedWriter(outputStreamWriterAnsi);
			bufferedWriterUtf8 = new BufferedWriter(outputStreamWriterUtf8);
			
			/* Parcours de l'iterator. ****************/
			while (ite.hasNext()) {
				
				final Entry<Integer, String> entry = ite.next();
				
				if (entry == null) {
					return false;
				}
				
				final int numeroLigne = entry.getKey();
				final String ligneLueEnAnsi = entry.getValue();
				
				/* Vérifie que l'encodage ANSI convient pour la ligne. */
				resultat = this.determinerSiEncodagePossible(
						ligneLueEnAnsi, CHARSET_ANSI, numeroLigne);
						
				/* Si la ligne n'est pas encodée en ANSI. */
				if (!resultat) {
					
					/* Transcode la ligne en IBM850. */
					final String ligneLueEnIBM850 
						= this.transcoder(
								ligneLueEnAnsi
									, CHARSET_ANSI
										, CHARSET_IBM850
											, true
												, numeroLigne);
					
					/* Vérifie que l'encodage IBM850 convient pour la ligne. */
					resultat = this.determinerSiEncodagePossible(
							ligneLueEnIBM850, CHARSET_IBM850, numeroLigne);
					
					/* Si la ligne est encodée en IBM850. */
					if (resultat) {
						
						// ECRITURE DANS this.fileEnAnsi.
						bufferedWriterAnsi.write(ligneLueEnIBM850);
						bufferedWriterAnsi.write(NEWLINE);
						bufferedWriterAnsi.flush();
										
						// ECRITURE DANS this.fileEnUtf8.
						if (numeroLigne == 1) {
							/* Ajout du caractère BOM_UTF-8 pour 
							 * forcer Excel 2010 à détecter l'UTF-8. */
							bufferedWriterUtf8.write(BOM_UTF_8);
						}
						bufferedWriterUtf8.write(ligneLueEnIBM850);
						bufferedWriterUtf8.write(NEWLINE);
						bufferedWriterUtf8.flush();
						
					}
					
					/* Si la ligne n'est pas encodée en IBM850. */
					else {
						
						/* Transcode la ligne en UTF-8. */
						final String ligneLueEnUTF8
							= this.transcoder(
									ligneLueEnAnsi
										, CHARSET_IBM850
											, CHARSET_UTF8
												, true
													, numeroLigne);
						
						/* Vérifie que l'encodage UTF-8 convient pour la ligne. */
						resultat = this.determinerSiEncodagePossible(
								ligneLueEnUTF8, CHARSET_UTF8, numeroLigne);
						
						/* Si la ligne est encodée en UTF-8. */
						if (resultat) {
							
							// ECRITURE DANS this.fileEnAnsi.
							bufferedWriterAnsi.write(ligneLueEnUTF8);
							bufferedWriterAnsi.write(NEWLINE);
							bufferedWriterAnsi.flush();
											
							// ECRITURE DANS this.fileEnUtf8.
							if (numeroLigne == 1) {
								/* Ajout du caractère BOM_UTF-8 pour 
								 * forcer Excel 2010 à détecter l'UTF-8. */
								bufferedWriterUtf8.write(BOM_UTF_8);
							}
							bufferedWriterUtf8.write(ligneLueEnUTF8);
							bufferedWriterUtf8.write(NEWLINE);
							bufferedWriterUtf8.flush();
							
						}
						else {
							
							// RAPPORT.**********************************							
							/* Création d'une ligne de rapport 
							 * si le fichier était encodé en ANSI. */
							final LigneRapport ligneRapport = 
									this.creerLigneRapport(null
									, "Le fichier " + pFile.getName() + " n' est encodé ni en ANSI, ni en IBM850, ni en UTF-8"
									, null
									, SANS_OBJET
									, SANS_OBJET
									, false
									, ACTION_FICHIER_REFUSE);
							
							/* Ajout de  la ligne de rapport. */
							this.ajouterLigneRapport(ligneRapport);
							
						}
						
					} // Fin de Si la ligne n'est pas encodée en IBM850.____
									
				} // Fin de Si la ligne n'est pas encodée en ANSI.__________
				
				/* Si la ligne est encodée en ANSI. */
				else {
					
					// ECRITURE DANS this.fileEnAnsi.
					bufferedWriterAnsi.write(ligneLueEnAnsi);
					bufferedWriterAnsi.write(NEWLINE);
					bufferedWriterAnsi.flush();
									
					// ECRITURE DANS this.fileEnUtf8.
					if (numeroLigne == 1) {
						/* Ajout du caractère BOM_UTF-8 pour 
						 * forcer Excel 2010 à détecter l'UTF-8. */
						bufferedWriterUtf8.write(BOM_UTF_8);
					}
					bufferedWriterUtf8.write(ligneLueEnAnsi);
					bufferedWriterUtf8.write(NEWLINE);
					bufferedWriterUtf8.flush();
					
				} // Fin de Si la ligne est encodée en ANSI.____
				
			} // Fin de Parcours de l'iterator.___________
			
			if (this.rapport.isEmpty()) {
				
				/* Création d'une ligne de rapport 
				 * si le fichier était encodé en ANSI. */
				final LigneRapport ligneRapport = 
						this.creerLigneRapport(null
						, "Le fichier " + pFile.getName() + " est encodé entièrement en ANSI"
						, null
						, SANS_OBJET
						, SANS_OBJET
						, true
						, ACTION_FICHIER_ACCEPTE);
				
				/* Ajout de  la ligne de rapport. */
				this.ajouterLigneRapport(ligneRapport);
				
			} // Fin de if (this.rapport.isEmpty()).____________
			
			/* Création d'une ligne de rapport 
			 * pour informer de la création du fichier encodé en ANSI. */
			final LigneRapport ligneRapportAnsi = 
					this.creerLigneRapport(null
					, "Le fichier " + this.fileEnAnsi.getAbsolutePath() + " a été créé et encodé entièrement en ANSI"
					, null
					, SANS_OBJET
					, SANS_OBJET
					, true
					, ACTION_FICHIER_ACCEPTE);
			
			/* Ajout de  la ligne de rapport. */
			this.ajouterLigneRapport(ligneRapportAnsi);
			
			/* Création d'une ligne de rapport 
			 * pour informer de la création du fichier encodé en UTF-8. */
			final LigneRapport ligneRapportUtf8 = 
					this.creerLigneRapport(null
					, "Le fichier " + this.fileEnUtf8.getAbsolutePath() + " a été créé et encodé entièrement en UTF-8"
					, null
					, SANS_OBJET
					, SANS_OBJET
					, true
					, ACTION_FICHIER_ACCEPTE);
			
			/* Ajout de  la ligne de rapport. */
			this.ajouterLigneRapport(ligneRapportUtf8);
			
			
			/* Enregistrement du rapport sur disque. */
			if (pEnregistrerRapport) {
								
				this.enregistrerRapportTextuelUTF8(
						this.fournirFileTxtUTF8());
				this.enregistrerRapportCsvUTF8(
						this.fournirFileCsvUTF8());
				
			} // Fin de if (pEnregistrerRapport).________________
			
			
		} catch (FileNotFoundException fnfe) {
			
			/* LOG de niveau ERROR et rapport. */
			loggerError(
					this.fournirNomClasseConcrete()
						, "EXCEPTION GRAVE : "
							, fnfe);
			
			/* rapport. */
			final LigneRapport ligne 
			= this.creerLigneRapport(
					null
					, "EXCEPTION GRAVE : " + fnfe.getMessage()
					, null
					, SANS_OBJET
					, SANS_OBJET
					, false
					, ACTION_FICHIER_REFUSE);
		
			this.ajouterLigneRapport(ligne);

			/* retour de false. */
			return false;
			
		} catch (IOException ioe1) {
			
			/* LOG de niveau ERROR et rapport. */
			loggerError(
					this.fournirNomClasseConcrete()
						, "EXCEPTION GRAVE : "
							, ioe1);
			
			/* rapport. */
			final LigneRapport ligne 
			= this.creerLigneRapport(
					null
					, "EXCEPTION GRAVE : " + ioe1.getMessage()
					, null
					, SANS_OBJET
					, SANS_OBJET
					, false
					, ACTION_FICHIER_REFUSE);
		
			this.ajouterLigneRapport(ligne);

			/* retour de false. */
			return false;
		}
		
		finally {
			
			if (bufferedWriterAnsi != null) {
				
				try {

					bufferedWriterAnsi.close();

				} catch (IOException ioe2) {

					/* LOG de niveau ERROR. */
					loggerError(
							this.fournirNomClasseConcrete()
								, MESSAGE_EXCEPTION
									, ioe2);					
				}
			} // Fin de if (bufferedWriterAnsi != null).__________
			
			if (bufferedWriterUtf8 != null) {
				
				try {

					bufferedWriterUtf8.close();

				} catch (IOException ioe3) {

					/* LOG de niveau ERROR. */
					loggerError(
							this.fournirNomClasseConcrete()
								, MESSAGE_EXCEPTION
									, ioe3);					
				}
			} // Fin de if (bufferedWriterAnsi != null).__________
			
		} // Fin de finally.________________________________________
		
		return resultat;
		
	} // Fin de controler(
	// File pFile
	// , boolean pEnregistrerRapport)._____________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean controler(
			final String pString
				, final boolean pEnregistrerRapport) {
		return false;
	} // Fin de controler(
	 // String pString
	// , boolean pEnregistrerRapport)._____________________________________


	
	/**
	 * method creerFileUTF8(
	 * File pFile) :<br/>
	 * Crée un fichier pour le transcodage en UTF-8.<br/>
	 * <br/>
	 * - retourne null si pFile est null.<br/>
	 * - retourne null si pFile n'existe pas.<br/>
	 * - retourne null si pFile est un répertoire.<br/>
	 * - retourne null si pFile n'a pas de répertoire parent.<br/>
	 * <br/>
	 *
	 * @param pFile : File.<br/>
	 * 
	 * @return : File.<br/>
	 */
	private File creerFileUTF8(
			final File pFile) {
		
		/* retourne null si pFile est null. */
		if (pFile == null) {
			return null;
		}
		
		/* retourne null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* retourne null si pFile est un répertoire. */
		if (pFile.isDirectory()) {
			return null;
		}
		
		final String repertoireParentString = pFile.getParent();
		
		/* retourne null si pFile n'a pas de répertoire parent. */
		if (repertoireParentString == null) {
			return null;
		}
		
		final String repertoireUtf8 
		= repertoireParentString 
		+ SEPARATEUR_FILE 
		+ "Fichiers_encodés_en_UTF8";
		
		/* Détermination de l'extension du fichier. */
		final String nomFichier = pFile.getName();
		final String[] tokens = StringUtils.split(nomFichier, '.');
		int longueurTableau = 0;
		String nomBase = null;
		String extension = null;
		
		if (tokens != null) {
		
			longueurTableau = tokens.length;
			
			if (longueurTableau > 1) {
				nomBase = tokens[0];
				extension = tokens[longueurTableau -1];
			}
			else {
				nomBase = nomFichier;
				extension = "txt";
			}			
		}
		
		/* - Fabrique éventuellement l'arborescence du chemin des rapports
		 * (".\\data\\temp\\rapports" par exemple)<br/>
		 * - Fabrique le nom du fichier sous la forme 
		 * [date_nom_encodage.extension] 
		 * comme "1961-02-25_14-27-07_RAPPORT_UTF8.txt" par exemple<br/>
		 * - Fabrique et retourne le fichier 
		 * (.\data2\temp\rapports\1961-02-25_14-27-07_RAPPORT_UTF8.txt 
		 * par exemple).<br/>*/
		final File resultat 
			= this.fournirFile(
					repertoireUtf8
						, this.dateControle
							, nomBase + "_Transcodé-en-UTF8"
								, "UTF8"
									, extension);
		
		return resultat;
		
	} // Fin de creerFileUTF8(
	 // File pFile)._______________________________________________________
	
	
	/**
	 * method creerFileANSI(
	 * File pFile) :<br/>
	 * Crée un fichier pour le transcodage en ANSI.<br/>
	 * <br/>
	 * - retourne null si pFile est null.<br/>
	 * - retourne null si pFile n'existe pas.<br/>
	 * - retourne null si pFile est un répertoire.<br/>
	 * - retourne null si pFile n'a pas de répertoire parent.<br/>
	 * <br/>
	 *
	 * @param pFile : File.<br/>
	 * 
	 * @return : File.<br/>
	 */
	private File creerFileANSI(
			final File pFile) {
		
		/* retourne null si pFile est null. */
		if (pFile == null) {
			return null;
		}
		
		/* retourne null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* retourne null si pFile est un répertoire. */
		if (pFile.isDirectory()) {
			return null;
		}
		
		final String repertoireParentString = pFile.getParent();
		
		/* retourne null si pFile n'a pas de répertoire parent. */
		if (repertoireParentString == null) {
			return null;
		}
		
		final String repertoireUtf8 
		= repertoireParentString 
		+ SEPARATEUR_FILE 
		+ "Fichiers_encodés_en_ANSI";
		
		/* Détermination de l'extension du fichier. */
		final String nomFichier = pFile.getName();
		final String[] tokens = StringUtils.split(nomFichier, '.');
		int longueurTableau = 0;
		String nomBase = null;
		String extension = null;
		
		if (tokens != null) {
			
			longueurTableau = tokens.length;
			
			if (longueurTableau > 1) {
				nomBase = tokens[0];
				extension = tokens[longueurTableau -1];				
			}
			else {
				nomBase = nomFichier;
				extension = "txt";
			}			
		}
				
		/* - Fabrique éventuellement l'arborescence du chemin des rapports
		 * (".\\data\\temp\\rapports" par exemple)<br/>
		 * - Fabrique le nom du fichier sous la forme 
		 * [date_nom_encodage.extension] 
		 * comme "1961-02-25_14-27-07_RAPPORT_UTF8.txt" par exemple<br/>
		 * - Fabrique et retourne le fichier 
		 * (.\data2\temp\rapports\1961-02-25_14-27-07_RAPPORT_UTF8.txt 
		 * par exemple).<br/>*/
		final File resultat 
			= this.fournirFile(
					repertoireUtf8
						, this.dateControle
							, nomBase + "_Transcodé-en-ANSI"
								, "ANSI"
									, extension);
		
		return resultat;
		
	} // Fin de creerFileANSI(
	 // File pFile)._______________________________________________________
	
	
	
	/**
	 * "Classe Transcodeur".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirNomClasseConcrete() {
		return CLASSE_TRANSCODEUR;
	} // Fin de fournirNomClasseConcrete().________________________________

	
	
	/**
	 * "Traitement de surface".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirTypeControle() {
		return "Traitement de surface";
	} // Fin de fournirTypeControle()._____________________________________
	
	

	/**
	 * "Traitement d'encodage du fichier en UTF-8 et ANSI".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirNomControle() {
		return "Traitement d'encodage du fichier en UTF-8 et ANSI";
	} // Fin de fournirNomControle().______________________________________
	
	

	/**
	 * "Le fichier doit être encodé en UTF-8".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirNomCritere() {
		return "Le fichier doit être encodé en UTF-8";
	} // Fin de fournirNomCritere()._______________________________________

	
	
	/**
	 * "Transcodeur.niveau.anomalie".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirCleNiveauAnomalie() {
		return "Transcodeur.niveau.anomalie";
	} // Fin de fournirCleNiveauAnomalie().________________________________

	
	
	/**
	 * "1".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirNiveauAnomalieEnDur() {
		return "1";
	} // Fin de fournirNiveauAnomalieEnDur().______________________________
	

	
	/**
	 * "RAPPORT-TRANSCODAGE".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirBaseNomRapport() {
		return "RAPPORT-TRANSCODAGE";
	} // Fin de fournirBaseNomRapport().___________________________________
	
	
	
	/**
	 * "Transcodeur.aEffectuer".<br/>
	 * <br/>
	 * {@inheritDoc}
	 */
	@Override
	protected String fournirCleAEffectuer() {
		return "Transcodeur.aEffectuer";
	} // Fin de fournirCleAEffectuer().____________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean fournirAEffectuerEnDur() {
		return true;
	} // Fin de fournirAEffectuerEnDur().__________________________________
	
	
	
	/**
	 * method getFileEnUtf8() :<br/>
	 * Getter du fichier réencodé en UTF-8.<br/>
	 * <br/>
	 *
	 * @return fileEnUtf8 : File.<br/>
	 */
	public final File getFileEnUtf8() {
		return this.fileEnUtf8;
	} // Fin de getFileEnUtf8().___________________________________________

	
	
	/**
	 * method getFileEnAnsi() :<br/>
	 * Getter du fichier réencodé en ANSI.<br/>
	 * <br/>
	 *
	 * @return fileEnAnsi : File.<br/>
	 */
	public final File getFileEnAnsi() {
		return this.fileEnAnsi;
	} // Fin de getFileEnAnsi().___________________________________________

	
	
} // FIN DE LA CLASSE Transcodeur.-------------------------------------------
