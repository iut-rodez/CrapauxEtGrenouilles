/**
 * Joueur.java                                      13 mai 2013
 * benjaminbercy
 */
package craEtGre.entitee;

import craEtGre.Plateau.Batracien;
import craEtGre.Plateau.CraGre;

/**
 * @author benjaminbercy
 * 
 */
public abstract class Joueur {
    
    /**
     * Identifiant du joueur (son nom affich� dans le jeu).
     */
    protected String nom;

    /**
     * Type qu'il controle
     */
    protected CraGre type;

    /**
     * Contient des r�f�rences vers les bactraciens du joueur
     */
    protected Batracien[] mesBatraciens;

    /**
     * Donne le tour à un joueur
     * 
     * @return TRUE si tout c'est bien passé
     */
    public abstract void tour();

    /**
     * Controle si le joueur peut jouer (si au moins un d�placement est possible)
     * 
     * @return TRUE si c'est le cas
     */
    public boolean peutJouer() {
        boolean bouger = true;
        // interrogation des batratiens du joueur pour savoir si il peuvent
        // bouger
        for (int pointeur = 0; pointeur <= mesBatraciens.length; pointeur++) {
            bouger = (bouger || mesBatraciens[pointeur].peutSeDeplacer());
        }
        return bouger;
    }

    /**
     * retourne le batracien portant le num�ro numero
     * 
     * @param numero
     *            numero du batracien
     * @return ref�rence du batracien
     */
    public Batracien getMesBatraciens(int numero) {
        return mesBatraciens[numero];
    }
}
    
