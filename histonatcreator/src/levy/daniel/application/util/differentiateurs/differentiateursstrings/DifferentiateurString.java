package levy.daniel.application.util.differentiateurs.differentiateursstrings;

import java.io.File;
import java.nio.charset.Charset;

import levy.daniel.application.util.convertisseursencodage.ConvertisseurEncodage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class DifferentiateurString :<br/>
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
 * @since 5 févr. 2016
 *
 */
public final class DifferentiateurString {

	// ************************ATTRIBUTS************************************/
	
	
	/**
	 * CHEMIN_FICHIERS_TEST : String :<br/>
	 * Chemin des fichiers de test 
	 * relativement à la racine du projet courant.<br/>
	 * ".\\test\\ressourcesjunit\\differentstypesfichiers\\".<br/>
	 */
	public static final String CHEMIN_FICHIERS_TEST 
		= ".\\test\\ressourcesjunit\\differentstypesfichiers\\";

	/**
	 * CHEMIN_DIACRITIQUES_UTF8 : String :<br/>
	 * Chemin du fichier .txt codé en UTF-8 
	 * relativement à la racine des fichiers de test.<br/>
	 */
	public static final String CHEMIN_DIACRITIQUES_UTF8 
		= "encodages\\diacritiques_UTF8.txt";

	
	/**
	 * FILE_DIACRITIQUES_UTF8 : File : <br/>
	 * txt codé en UTF-8.<br/>
	 */
	public static final File FILE_DIACRITIQUES_UTF8 
	= new File(CHEMIN_FICHIERS_TEST + CHEMIN_DIACRITIQUES_UTF8);

	
	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	public static final Charset CHARSET_UTF8 
		= Charset.forName("UTF-8");

	
	/**
	 * STRING_REF_DIACRITIQUES_UTF8 : String : <br/>
	 */
	public static final String STRING_REF_DIACRITIQUES_UTF8 = "UTF-8. Tous français inscrit au rôle, naïf ou râleur, à Nîmes, carbœuf ou même Capharnaüm, aura payé son dû dès avant Noël. ligne de 148 caractères.\nUTF-8. Œdipe de Capharnaüm et Éric de Nîmes étaient français, drôles, naïfs et râleurs mais ils ont dû être pris à l’œil dès Noël. ligne de 155 caractères.\nUTF-8. Mon châton est évalué à 15 € sur le marché de Noël de Faÿ-lès-Nemours. Où ça ? Là bas. ligne de 118 caractères.\nUTF-8. ligne de 074 caractères et 495 caractères au total dans ce fichier.";
	
	

	/**
	 * CLASSE_DIFFERENTIATEURSTRING : String :<br/>
	 * "Classe DifferentiateurString".<br/>
	 */
	public static final String CLASSE_DIFFERENTIATEURSTRING 
		= "Classe DifferentiateurString";

	
	/**
	 * rapportDiff : String :<br/>
	 * Rapport textuel contenant les différences 
	 * entre deux chaines de caractères.<br/>
	 * null si les deux chaines sont equals.<br/>
	 */
	private static String rapportDiff;
	
	/**
	 * rapportDiffCsv : String :<br/>
	 * Rapport au format csv contenant les différences 
	 * entre deux chaines de caractères.<br/>
	 * null si les deux chaines sont equals.<br/>
	 */
	private static String rapportDiffCsv;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(DifferentiateurString.class);

	// *************************METHODES************************************/
	
	
	/**
	 * method CONSTRUCTEUR DifferentiateurString() :
	 * Constructeur private pour empêcher l'instanciation.
	 */
	private DifferentiateurString() {
		super();
	} // Fin de CONSTRUCTEUR DifferentiateurString().______________________


	
	/**
	 * method differencier(String pString1
	 * , String pString2) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pString1 : String : 
	 * @param pString2 : String :
	 * 
	 * @return : String :  .<br/>
	 */
	public static String differencier(
			final String pString1, final String pString2) {
		
		/* block static synchronized. */
		synchronized (DifferentiateurString.class) {
			
			/* mise à null des rapports. */
			rapportDiff = null;
			rapportDiffCsv = null;
			
			
			int longueurMax = 0;
			int position = 0;
			Character caractereChaine1 = null;
			Character caractereChaine2 = null;
			String diff = null;
			
			/* Détermine la longueur de la plus longue chaîne. */
			final int longueurChaine1 = pString1.length();
			final int longueurChaine2 = pString2.length();
			
			if (longueurChaine1 > longueurChaine2) {
				longueurMax = longueurChaine1;
			}
			else {
				longueurMax = longueurChaine2;
			}
			
			/* Parcours des chaînes caractère par caractère. */
			for(int index = 0; index < longueurMax; index++) {
				
				/* L'index est 0-based. */
				position = index + 1;
				
				/* détermination du caractère dans la chaine 1. */
				try {
					caractereChaine1 = pString1.charAt(index);
				} catch (IndexOutOfBoundsException e1) {
					caractereChaine1 = null;
				}
				
				/* détermination du caractère dans la chaine 2. */
				try {
					caractereChaine2 = pString2.charAt(index);
				} catch (IndexOutOfBoundsException e1) {
					caractereChaine2 = null;
				}
				
				/* Détermination d'une éventuelle différence. */
				if (caractereChaine1 == null) {
					
					if (caractereChaine2 != null) {
						diff = "DIFF";
					} else {
						diff = "equals";
					}
					
				} else {
					if (caractereChaine2 != null) {
						if (!caractereChaine1.equals(caractereChaine2)) {
							diff = "DIFF";
						}
						else {
							diff = "equals";
						}
						
					} else {
						diff = "DIFF";
					}					
				}
				
				
				System.out.println("Position : " + position + "\t\tcaractère1 : " + caractereChaine1 + "\t\tcaractère2 : " + caractereChaine2 + "\t\tDIFFERENCE : " + diff);
			}
			
			return null;
			
			
		} // Fin du bloc static synchronized.________________________
		
		
	} // Fin de differencier(String pString1
	 // , String pString2).________________________________________________

	
	/**
	 * method main() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pArgs : void :  .<br/>
	 */
	public static void main(final String[] pArgs) {
		differencier(ConvertisseurEncodage.lireDepuisFichier(FILE_DIACRITIQUES_UTF8, CHARSET_UTF8), STRING_REF_DIACRITIQUES_UTF8);
	}
} // FIN DE LA CLASSE DifferentiateurString.---------------------------------
