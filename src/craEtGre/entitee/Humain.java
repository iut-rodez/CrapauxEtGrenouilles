/**
 * Joueur.java                                      9 mai 2013
 * Bercy
 */
package craEtGre.entitee;

import java.util.Scanner;

import craEtGre.Plateau.Batracien;
import craEtGre.Plateau.CraGre;

/**
 * @author Bercy Classe instanciable permettant de creer des joueurs humain ou
 *         virtuel.
 */
public class Humain extends Joueur{

    private Scanner clavier = new Scanner(System.in);

    
    /**
     * Constructeur par défaut l'humain n'as qu'une grenouille et porte
     * le nom anonyme
     */
    public Humain()
    {
        nom = "Anonyme";
        type = CraGre.GRENOUILLE;
        mesBatraciens = new Batracien[1]; 
    }
    
    /**
     * Le Joueur humain sera créé suivant les paramètres
     * @param nom nom du joueur
     * @param type joue t'il les crapaux ou les grenouilles
     * @param nb nombre de batraciens sur le plateau
     */
    public Humain(String nom ,CraGre type) {
        this.nom = nom;
        this.type = type;
    }

    public void tour() {
        int choix = -1;
        do {
            System.out.println("Entrez le numéro du batracien à déplacer : ");
            if (clavier.hasNextInt()) {
                choix = clavier.nextInt();
            } else {
                System.out.println("Veuillez entrer un entier");
            }
            if (choix > mesBatraciens.length) {
                System.out.println("veuillez entrer le numéro d'un "
                                   +"batracien sur le plateau");
                choix = -1;// valeur forcant une nouvelle saisie
            }
        } while (choix < 0);
        mesBatraciens[choix].deplacer();
    }

}
