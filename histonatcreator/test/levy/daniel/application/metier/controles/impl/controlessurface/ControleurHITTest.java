package levy.daniel.application.metier.controles.impl.controlessurface;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import levy.daniel.application.IConstantesTest;
import levy.daniel.application.metier.controles.IControle;
import levy.daniel.application.metier.controles.rapportscontroles.LigneRapport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * class ControleurHITTest :<br/>
 * Test JUnit de la Classe ControleurHIT.<br/>
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
 * @since 28 mars 2016
 *
 */
public class ControleurHITTest implements IConstantesTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(ControleurHITTest.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ControleurHITTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 * - Remplit LISTEFILES_TRAFIC.<br/>
	 * <br/>
	 */
	public ControleurHITTest() {
		
		super();
		
		/* Remplit LISTEFILES_TRAFIC. */
		remplirListeTrafics();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method remplirListeTrafics() :<br/>
	 * Remplit LISTEFILES_TRAFIC.<br/>
	 * <br/>
	 */
	public static void remplirListeTrafics() {
		
		/* Récupère le répertoire trafics. */
		final File repertoireTrafics = new File(CHEMIN_FICHIERS_TRAFIC);
		
		/* récupère le tableau des enfants de repertoireTrafics. */
		final File[] tableauRepertoires = repertoireTrafics.listFiles();
		
		if (tableauRepertoires == null) {
			return;
		}
		
		/* remplit la liste des sous-répertoires de trafics. */		
		final List<File> listeSousRepertoires 
			= Arrays.asList(tableauRepertoires);
		
		/* Remplit LISTEFILES_TRAFIC. */
		for (final File rep : listeSousRepertoires) {
			
			if (rep.isDirectory()) {
				
				final File[] tabContenuSousRep = rep.listFiles();
				
				if (tabContenuSousRep != null) {
					
					for (int j = 0; j < tabContenuSousRep.length; j++) {
						
						if (!tabContenuSousRep[j].isDirectory()) {
							LISTEFILES_TRAFIC.add(tabContenuSousRep[j]);
						}						
					}
				}
					
			}
			else {
				LISTEFILES_TRAFIC.add(rep);
			}
		}
		
	} // Fin de remplirListeTrafics()._____________________________________
	

	

	/**
	 * method testControlerFileNull() :<br/>
	 * Teste la méthode controler(File null).<br/>
	 * <br/>
	 * - Vérifie que la méthode retourne false.<br/>
	 * - Vérifie que fichier == null.<br/>
	 * - Vérifie que nomFichier == null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileNull() {
		
		/* Instanciation d'un ControleurHIT 
		 * avec le constructeur d'arité nulle. */
		final IControle control = new ControleurHIT();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_NULL);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_NULL, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
		/* Affichage du rapport d'enregistrement des rapports. */
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que la méthode retourne false. */
		assertFalse("controler(null) doit retourner false : "
				, resultat);
		
		/* Vérifie que fichier == null. */
		assertNull("fichier doit être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier == null. */
		assertNull("nomFichier doit être null : "
				, control.getNomFichier());
		
	
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
				
	} // Fin de testControlerFileNull().___________________________________
	

	
	/**
	 * method testControlerFileInexistant() :<br/>
	 * Teste la méthode controler(File inexistant).<br/>
	 * <br/>
	 * - Vérifie que la méthode retourne false.<br/>
	 * - Vérifie que fichier == null.<br/>
	 * - Vérifie que nomFichier == null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileInexistant() {
		
		/* Instanciation d'un ControleurHIT 
		 * avec le constructeur d'arité nulle. */
		final IControle control = new ControleurHIT();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_INEXISTANT);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_INEXISTANT, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
		/* Affichage du rapport d'enregistrement des rapports. */
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que la méthode retourne false. */
		assertFalse("controler(inexistant) doit retourner false : "
				, resultat);
		
		/* Vérifie que fichier == null. */
		assertNull("fichier doit être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier == null. */
		assertNull("nomFichier doit être null : "
				, control.getNomFichier());
		
	
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
				
	} // Fin de testControlerFileInexistant()._____________________________
	

	
	/**
	 * method testControlerFileRepertoire() :<br/>
	 * Teste la méthode controler(File repertoire).<br/>
	 * <br/>
	 * - Vérifie que la méthode retourne false.<br/>
	 * - Vérifie que fichier == null.<br/>
	 * - Vérifie que nomFichier == null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileRepertoire() {
		
		/* Instanciation d'un ControleurHIT 
		 * avec le constructeur d'arité nulle. */
		final IControle control = new ControleurHIT();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_REPERTOIRE);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_REPERTOIRE, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
		/* Affichage du rapport d'enregistrement des rapports. */
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que la méthode retourne false. */
		assertFalse("controler(repertoire) doit retourner false : "
				, resultat);
		
		/* Vérifie que fichier == null. */
		assertNull("fichier doit être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier == null. */
		assertNull("nomFichier doit être null : "
				, control.getNomFichier());
		
	
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
		
	} // Fin de testControlerFileRepertoire()._____________________________


	
	/**
	 * method testControlerFileVide() :<br/>
	 * Teste la méthode controler(File vide).<br/>
	 * <br/>
	 * - Vérifie que la méthode retourne false.<br/>
	 * - Vérifie que fichier == null.<br/>
	 * - Vérifie que nomFichier == null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerFileVide() {
		
		/* Instanciation d'un ControleurHIT 
		 * avec le constructeur d'arité nulle. */
		final IControle control = new ControleurHIT();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_VIDE);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_REPERTOIRE, true);
		
//		System.out.println(control.afficherRapportTextuel());
		
		/* Affichage du rapport d'enregistrement des rapports. */
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementTextuel());
//		System.out.println();
//		System.out.println(control.afficherRapportEnregistrementCsv());
		
		/* Vérifie que la méthode retourne false. */
		assertFalse("controler(vide) doit retourner false : "
				, resultat);
		
		/* Vérifie que fichier == null. */
		assertNull("fichier doit être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier == null. */
		assertNull("nomFichier doit être null : "
				, control.getNomFichier());
		
	
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
		
	} // Fin de testControlerFileVide().___________________________________


	
	/**
	 * method testControlerNonHit() :<br/>
	 * Teste la méthode controler(File pFile NON HIT).<br/>
	 * <br/>
	 * <br/>
	 * - Vérifie que controler(non HIT) retourne false.<br/>
	 * - Vérifie que fichier n'est pas null.<br/>
	 * - Vérifie que nomFichier n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerNonHit() {
		
		/* Instanciation d'un ControleurHIT 
		 * avec le constructeur d'arité nulle. */
		final IControle control = new ControleurHIT();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_NON_HIT_UTF8);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_NON_HIT_UTF8, true);

		
		// AFFICHAGES. **************************************************
//		System.out.println("RAPPORT DE CONTROLE TEXTUEL : \n" 
//				+ control.afficherRapportTextuel());
		
		/* Affichage du compte-rendu d'enregistrement 
		 * sur disque du rapport de contrôle au format textuel. */
//		System.out.println();
//		System.out.println(
//				"RAPPORT D'ENREGISTREMENT DES RAPPORTS DE CONTROLE TEXTUEL : \n" 
//				+ control.afficherRapportEnregistrementTextuel());
		
		/* Affichage du du compte-rendu d'enregistrement 
		 * sur disque du rapport de contrôle au format csv. */
//		System.out.println();
//		System.out.println(
//				"RAPPORT D'ENREGISTREMENT DES RAPPORTS DE CONTROLE CSV : \n" 
//				+ control.afficherRapportEnregistrementCsv());

		
		// ASSERTIONS. **************************************************
		/* Vérifie que la méthode retourne false. */
		assertFalse("controler(Non HIT) doit retourner false : "
				, resultat);
		
		/* Vérifie que fichier != null. */
		assertNotNull("fichier ne doit pas être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier != null. */
		assertNotNull("nomFichier ne doit pas être null : "
				, control.getNomFichier());
		
	
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
		
	} // Fin de testControlerNonHit()._____________________________________

	
	
	/**
	 * method testControlerHit() :<br/>
	 * Teste la méthode controler(File pFile HIT).<br/>
	 * <br/>
	 * <br/>
	 * - Vérifie que controler(HIT) retourne true.<br/>
	 * - Vérifie que fichier n'est pas null.<br/>
	 * - Vérifie que nomFichier n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas null.<br/>
	 * - vérifie que le rapport n'est pas vide.<br/>
	 * <br/>
	 */
	@Test
	public void testControlerHit() {
		
		/* Instanciation d'un ControleurHIT 
		 * avec le constructeur d'arité nulle. */
		final IControle control = new ControleurHIT();
		
		/* invocation de la méthode controler(File pFile). */
		final boolean resultat = control.controler(FILE_HIT_UTF8);
		
		/* Avec enregistrement sur disque du rapport de contrôle. */
//		final boolean resultat = control.controler(FILE_HIT_UTF8, true);

		
		// AFFICHAGES. **************************************************
//		System.out.println("RAPPORT DE CONTROLE TEXTUEL : \n" 
//				+ control.afficherRapportTextuel());
		
		/* Affichage du compte-rendu d'enregistrement 
		 * sur disque du rapport de contrôle au format textuel. */
//		System.out.println();
//		System.out.println(
//				"RAPPORT D'ENREGISTREMENT DES RAPPORTS DE CONTROLE TEXTUEL : \n" 
//				+ control.afficherRapportEnregistrementTextuel());
		
		/* Affichage du du compte-rendu d'enregistrement 
		 * sur disque du rapport de contrôle au format csv. */
//		System.out.println();
//		System.out.println(
//				"RAPPORT D'ENREGISTREMENT DES RAPPORTS DE CONTROLE CSV : \n" 
//				+ control.afficherRapportEnregistrementCsv());

		
		// ASSERTIONS. **************************************************
		/* Vérifie que la méthode retourne true. */
		assertTrue("controler(HIT) doit retourner true : "
				, resultat);
		
		/* Vérifie que fichier != null. */
		assertNotNull("fichier ne doit pas être null : "
				, control.getFichier());
		
		/* Vérifie que nomFichier != null. */
		assertNotNull("nomFichier ne doit pas être null : "
				, control.getNomFichier());
		
	
		/* récupération du rapport. */
		final List<LigneRapport> rapport = control.getRapport();
		
		/* vérifie que le rapport n'est pas null. */
		assertNotNull("Le rapport ne doit pas être null : ", rapport);
		
		/* vérifie que le rapport n'est pas vide. */
		assertFalse("Le rapport ne doit pas être vide : "
				, rapport.isEmpty());
	} // Fin de testControlerHit().________________________________________

	
	
} // FIN DE LA CLASSE ControleurHITTest.-------------------------------------
