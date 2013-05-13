/**
 * ControleurDeJeu.java                                      9 mai 2013
 * Bercy
 */
package craEtGre;
import craEtGre.entitee.Joueur;
import craEtGre.Plateau.Etang;
/**
 * @author Bercy
 * Classe instanciable qui créé une session du jeu et gère sont état (le respect des règles 
 * et détermine le vainqueur)
 */
public class ControleurDeJeu {

    /**
     * Joueur  controlant les grenouilles
     */
    public Joueur joueur1;
    
    /**
     * Joueur controlant les crapaux
     */
    public Joueur joueur2;
    
    /**
     * Plateau de jeu
     */
    public Etang plateau;
    
}
