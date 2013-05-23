/**
 * IA.java                                      9 mai 2013
 * Ben
 */
package craEtGre.entitee;

import craEtGre.Plateau.Batracien;
import craEtGre.Plateau.CraGre;

/**
 * @author Bercy Classe Instantiable permettent de creer un joureur virtuel et
 *         détermine sa stratégie de jeu en fonction de la difficulté.
 */
public class IA extends Joueur {

    /**
     * Défini le niveau de difficulté de l'IA de 0 à 1 comme étant la
     * probabilité d'utiliser la stratégie gagnante au détriment d'un coup au
     * hasard
     */
    private double difficulte;

    /**
     * Constructeur par défaut créé une IA de niveau 0 (pas de stratégie)
     * portant le non R2D2
     */
    public IA() {
        difficulte = 0.0;
        nom = "R2D2";
        type = CraGre.CRAPAUD;
        mesBatraciens = new Batracien[1];

    }

    /**
     * Constructeur ayant pour paramètre le nom de l'IA (sans influence),Le type
     * joué le nombre de batracien et le niveau de difficulté
     * 
     * @param nom
     *            nom de l'IA
     * @param type
     *            joue les grenouilles ou les crapauds
     * @param nb
     *            nombre de batratien joué
     * @param difficulte
     *            niveau de l'ia de 0(sans stratégie) à 1(tout les coups sont
     *            réfléchis)
     */
    public IA(String nom, CraGre type, double difficulte) {
        this();
        if (0 <= difficulte && difficulte <= 1) {
            this.difficulte = difficulte;
            this.nom = nom;
            this.type = type;
        } // else { constructeur par défaut

    }

    public void tour() {
        if (Math.random() > difficulte) { // tirage aléatoire de l'usage ou non
                                          // de l'IA
            // Coup au hazard
            coupHasard();

        } else {
            // IA
            strategie();
        }
        
    }
    /**
     * génère un coup au hasard de la part de l'IA
     */
    private void coupHasard() {
        int choix;
        choix = 0;
        choix = (int) (Math.random() * mesBatraciens.length);
        mesBatraciens[choix].deplacer();
        System.out.println(nom +": J'ai déplacé "+ choix);
    }
    
    /**
     * génère un coup suivant une stratégie d'abord offensive puis défensive
     */
    private void strategie() {
        coupHasard();        
    }
}
