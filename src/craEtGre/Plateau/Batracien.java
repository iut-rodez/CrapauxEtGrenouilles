/**
 * Batracien.java                                                       09/05/13
 */
package craEtGre.Plateau;

/**
 * Repr�sentation d'un personnage
 * 
 * @author INFO1
 */
public class Batracien {

    /**
     * Type de bactracien
     */
    private CraGre type;
    
    /**
     * Couloir du batratien (il ne peut pas en changer)
     */
    private int couloir;
    
    /**
     * N�nuphar sur lequel se trouve le batracien
     */
    private int nenuphar;
    
    /**
     * Cr�e un batracien d'un type donn� 
     * 
     * @param type Type de batracien
     */
    public Batracien(CraGre type) {
        
        this.type = type;
        
    }
    
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
