/**
 * Batracien.java                                      9 mai 2013
 * Ben
 */
package craEtGre.Plateau;

/**
 * @author Bercy
 * Classe permettent de cr�er et de g�rer un batratien.
 */
public class Batracien {

    /**
     * Type de bactracien
     */
    private CraGre type;
    
    /**
     * Couloir du batratien (il ne peut pas en changer)
     */
    public int couloir;
    
    /**
     * n�nuphar sur lequel se trouve le batracien
     */
    public int nenuphar;
    
    /**
     * Methode permettent de déplacer le batracien
     * (saut ou avancer suivant la situation)
     */
    public void deplacer(){
    
    }
    
    /**
     * Teste la possibilité de déplacement 
     */
    public boolean peutSeDeplacer() {
        
    }

    /**
     * Retourne le type 
     * @return the type
     */
    public CraGre getType() {
        return type;
    }

    /**
     * retourne le couloir 
     * @return the couloir
     */
    public int getCouloir() {
        return couloir;
    }

    /**
     * retourne le nenuphar
     * @return the nenuphar
     */
    public int getNenuphar() {
        return nenuphar;
    }
    
}
