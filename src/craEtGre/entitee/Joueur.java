/**
 * Joueur.java                                      13 mai 2013
 * benjaminbercy
 */
package craEtGre.entitee;

import craEtGre.Plateau.Batracien;
import craEtGre.Plateau.CraGre;
import craEtGre.Plateau.Etang;

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
     * Controle si le joueur peut jouer (si au moins un d�placement est
     * possible)
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
    
    /**
     * Sert � initialiser les batracien en d�but de partie
     */
    public void initBatracien(Etang etang){
        mesBatraciens = etang.getBatraciens(type);
    }
    /**
     * sert � attribuer des num�ros aux batraciens du joueur
     */
    public void numeroter() {
        for (int i = 0; i < mesBatraciens.length; i++) {
            mesBatraciens[i].setNumero(i);
            System.out.println("num�ro "+i+" trouv�");
        }

    }
    public void testnumeroter() {
        for(int i = 0 ; i < mesBatraciens.length ;i++) {
            System.out.println(mesBatraciens[i].toString());
        }
    }
}

    
