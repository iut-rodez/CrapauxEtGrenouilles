/**
 * IA.java                                      9 mai 2013
 * Ben
 */
package craEtGre.entitee;

import craEtGre.Plateau.Batracien;
import craEtGre.Plateau.CraGre;

/**
 * @author Bercy Classe Instantiable permettent de creer un joureur virtuel et
 *         d�termine sa strat�gie de jeu en fonction de la difficult�.
 */
public class IA extends Joueur {

    /**
     * D�fini le niveau de difficult� de l'IA de 0 � 1 comme �tant la
     * probabilit� d'utiliser la strat�gie gagnante au d�triment d'un coup au
     * hasard
     */
    private double difficulte;

    /**
     * Constructeur par d�faut cr�� une IA de niveau 0 (pas de strat�gie)
     * portant le non R2D2
     */
    public IA() {
        difficulte = 0.0;
        nom = "R2D2";
        type = CraGre.CRAPAUD;
        mesBatraciens = new Batracien[1];

    }

    /**
     * Constructeur ayant pour param�tre le nom de l'IA (sans influence),Le type
     * jou� le nombre de batracien et le niveau de difficult�
     * 
     * @param nom
     *            nom de l'IA
     * @param type
     *            joue les grenouilles ou les crapauds
     * @param nb
     *            nombre de batratien jou�
     * @param difficulte
     *            niveau de l'ia de 0(sans strat�gie) � 1(tout les coups sont
     *            r�fl�chis)
     */
    public IA(String nom, CraGre type, double difficulte) {
        this();
        if (0 <= difficulte && difficulte <= 1) {
            this.difficulte = difficulte;
            this.nom = nom;
            this.type = type;
        } // else { constructeur par d�faut

    }

    public void tour() {
        if (Math.random() > difficulte) { // tirage al�atoire de l'usage ou non
                                          // de l'IA
            // Coup au hazard
            coupHasard();

        } else {
            // IA
            strategie();
        }
        
    }
    /**
     * g�n�re un coup au hasard de la part de l'IA
     */
    private void coupHasard() {
        int choix;
        choix = 0;
        choix = (int) (Math.random() * mesBatraciens.length);
        mesBatraciens[choix].deplacer();
        System.out.println(nom +": J'ai d�plac� "+ choix);
    }
    
    /**
     * g�n�re un coup suivant une strat�gie d'abord offensive puis d�fensive
     */
    private void strategie() {
        coupHasard();        
    }
}
