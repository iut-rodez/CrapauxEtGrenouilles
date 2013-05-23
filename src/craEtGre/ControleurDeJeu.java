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
     * Ce constructeur créé un jeu dans le cas du casse tête
     * @param plateau
     * @param joueur1
     */
    public ControleurDeJeu(Etang plateau , Joueur joueur1) {
        this.joueur1= joueur1;
        //this.joueur2 non utilisé
        this.plateau=plateau;
    }
    /**
     * méthode controlant le jeu simple et gérant son déroulement
     * @return retourne le joueur gagnant ou null si match nul
     */
    public Joueur partieSimple() {
        Joueur gagnant = joueur2;
        do {
            System.out.println(plateau.toString());
            joueur1.tour();//J1 joue
            if (joueur2.peutJouer()) {//J2 peut jouer ?
            System.out.println(plateau.toString());                
            joueur2.tour();//J2 joue
            } else {
                gagnant = joueur1;//J1 gagne
            }
        } while(joueur1.peutJouer() && joueur2.peutJouer());//J1 peut jouer ?
        //est ce que c'est un match nul?
        if (!joueur1.peutJouer() && !joueur2.peutJouer()) {
            return null; 
        }
        return gagnant;
    }
    
    /**
     * méthode controlant le casse tête et gérant son déroulement
     */
    public void casseTete() {
        do {
            System.out.println(plateau.toString());
            joueur1.tour();
        } while(joueur1.peutJouer());
    }
    
    /**
     * méthode pour initialiser une partie qui à été généré aléatoirement
     */
    public void initialiser(int densite) {
        plateau.initBatracienHasard(densite);
        joueur1.initBatracien(plateau);
        joueur1.numeroter();
        joueur2.initBatracien(plateau);
        joueur2.numeroter();
    }
}
