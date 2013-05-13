/**
 * Joueur.java                                      13 mai 2013
 * benjaminbercy
 */
package craEtGre.entitee;
import craEtGre.Plateau.CraGre; 

/**
 * @author benjaminbercy
 *
 */
public abstract class Joueur {
    
    /**
     * Type qu'il controle
     */
    private CraGre type;

    /**
     * Donne le tour à un joueur
     * @return TRUE si tout c'est bien passé
     */
    public abstract boolean tour();
    
    /**
     * Controle si le joueur peut jouer
     * @return TRUE si c'est le cas
     */
    public boolean peutJouer(){
    
    }
    
}
