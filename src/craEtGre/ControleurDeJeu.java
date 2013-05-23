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
 * Classe instanciable qui cr�� une session du jeu et g�re sont �tat (le respect des r�gles 
 * et d�termine le vainqueur)
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
     * Constructeur de ControleurDeJeu par d�faut cr�� un jeu d'un couloir et de 5 n�nuphar ,
     * un humain contre une IA , chaqu'un on un seul batracien
     */
    public ControleurDeJeu() {
        joueur1= new Humain();
        joueur2= new IA();
        plateau = new Etang(1,5);
    }
    /**
     * Ce constructeur c�� un jeu en utilisans les param�tres indiqu�s 
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
     * m�thode controlant le jeu et g�rant son d�roulemment
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
