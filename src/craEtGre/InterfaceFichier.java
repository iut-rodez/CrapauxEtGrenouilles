/**
 * InterfaceFichier.java                                      20 mai 2013
 * Bercy
 */
package craEtGre;

import java.io.*;

import craEtGre.Plateau.Etang;
import craEtGre.entitee.Joueur;

/**
 * Classe contenant des méthodes pour lire ou écrire des fichier nécéssaire pour le jeu
 * @author Ben
 *
 */
public class InterfaceFichier {
    
    /**
     * Chemin par défaut des fichiers joueur
     */
    private static final String CHEMINJOUEUR= "data\\joueurs\\";

    /**
     * Chemin par défaut des fichiers plateau
     */
    private static final String CHEMINPLATEAU= ".\\data\\plateau\\";
    
    /**
     * Chemin par défaut du dictionnaire de nom;
     */
    private static final String CHEMINNOM= ".\\data\\nom.txt";
    
    /**
     * Nombre de nom contenu dans le fichier data\nom.txt
     */
    private static final int NBNOM= 20;
    /**
     * genère un nom au hasard pour l'IA à partir d'un dictionaire de NBNOM noms
     * @return un nom
     */
    public static String nomHasard () {
        int choix;
        String nom = null;
        try {
            //Ouverture du fichier texte
            InputStreamReader fichier = new InputStreamReader(
                                        new FileInputStream(CHEMINNOM));
            BufferedReader lecture = new BufferedReader(fichier);
            //tirage au sort d'une ligne du fichier
            choix = (int) (Math.random()*NBNOM);
            for (int indexe = 0;indexe <= choix ; indexe++){
                nom = lecture.readLine();//atteinte et lecture de la ligne
            }
            lecture.close();
            
        } catch (FileNotFoundException e) {
            System.err.println("Une erreur s'est produite lors" +
            		       "de l'ouverture du fichier "
                                + CHEMINNOM );
            return null;
        } catch (IOException e) {
            System.err.println("Une erreur s'est produite " +
            		       "lors de la lecture du fichier"
                                + CHEMINNOM );
            return null;
        }
        
        return nom;
    }
    
    /**
     * Sauvegarde le nombre de victoire d'un joueur 
     * dans un fichier binaire 
     * @param nom Nom du joueur
     * @param score Score du joueur
     * @throws IOException Erreur lors de l'écriture
     */
    public static void sauvegardeJoueur (String nom, int score)
        throws IOException {
        
        FileOutputStream sortie;
        DataOutputStream sortieDonnees;
        
        sortie = new FileOutputStream(CHEMINJOUEUR + nom + ".dat");
        sortieDonnees = new DataOutputStream(sortie);
        
        sortieDonnees.writeInt(score);
        
        sortieDonnees.close();
        sortie.close();
        
    }
    
    /**
     * Sauvegarde la position des crapaux et des grenouilles dans un fichier
     * @param nom Nom du fichier
     * @param etang etang à sauvegarder
     * @throws IOException Erreur lors de l'écriture
     */
    public static void sauvegardePlateau(String nom, Etang etang )
        throws IOException {
        
        FileOutputStream sortie;
        ObjectOutputStream sortieObjet;
            
        sortie = new FileOutputStream(CHEMINPLATEAU + nom + ".dat");
        sortieObjet = new ObjectOutputStream(sortie);
            
        sortieObjet.writeObject(etang);
            
        sortieObjet.close();
        sortie.close();
        
    }
    
    /**
     * Charge le nombre de victoires d'un joueur
     * @param nom Nom du joueur
     * @return Score du joueur
     * @throws IOException Erreur lors de la lecture
     */
    public static int chargerJoueur (String nom)
        throws IOException {
    
        int score;
        
        FileInputStream entree;
        DataInputStream entreeDonnees;
        
        entree = new FileInputStream(CHEMINJOUEUR + nom + ".dat");
        entreeDonnees = new DataInputStream(entree);
        
        score = entreeDonnees.readInt();
        
        entreeDonnees.close();
        entree.close();
        
        return score;
    }
    
    /**
     * Charge un plateau
     * @param nom Nom du plateau à charger
     * @return Plateau chargé depuis le fichier
     * @throws IOException Erreur lors de la lecture
     * @throws ClassNotFoundException Objet invalide
     */
    public static Etang chargerPlateau (String nom)
        throws IOException, ClassNotFoundException {
      
        FileInputStream entree;
        ObjectInputStream entreeObjet;
        
        Etang etang;
        
        entree = new FileInputStream(CHEMINPLATEAU + nom + ".dat");
        entreeObjet = new ObjectInputStream(entree);
        
        etang = (Etang) entreeObjet.readObject();
        
        entreeObjet.close();
        entree.close();
        
        return etang;
        
    }
        
}
