/**
 * ControleurDeJeu.java                                      9 mai 2013
 * Bercy
 */
package craEtGre;
import craEtGre.entitee.Humain;
import craEtGre.entitee.IA;
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
    
    /**
     * Constructeur de ControleurDeJeu par défaut créé un jeu d'un couloir et de 5 nénuphar ,
     * un humain contre une IA , chaqu'un on un seul batracien
     */
    public ControleurDeJeu() {
        joueur1= new Humain();
        joueur2= new IA();
        plateau = new Etang(1,5);
    }
    /**
     * Ce constructeur céé un jeu en utilisans les paramètres indiqués 
     * @param plateau plateau de jeu
     * @param joueur1 un joueur (Humain ou IA)
     * @param joueur2 un joueur (Humain ou IA)
     */
    public ControleurDeJeu(Etang plateau , Joueur joueur1 , Joueur joueur2 ) {
        this.joueur1= joueur1;
        this.joueur2= joueur2;
        this.plateau= plateau;
    }
    
    /**
     * méthode controlant le jeu et gérant son déroulemment
     * @return retourne le joueur gagnant 
     */
    public Joueur partie() {
        Joueur gagnant = joueur2;
        do {
            joueur1.tour();//J1 joue
            if (joueur2.peutJouer()) {//J2 peut jouer ?
            joueur2.tour();//J2 joue
            } else {
                gagnant = joueur1;//J1 gagne
            }
        } while(joueur1.peutJouer() && joueur2.peutJouer());//J1 peut jouer ?
        return gagnant;
    }
}
