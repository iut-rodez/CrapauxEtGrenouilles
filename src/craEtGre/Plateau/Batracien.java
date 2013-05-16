/**
 * Batracien.java                                                       09/05/13
 */
package craEtGre.Plateau;

/**
 * Représentation d'un personnage
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
     * Nénuphar sur lequel se trouve le batracien
     */
    private int nenuphar;
    
    /**
     * Crée un batracien d'un type donné 
     * 
     * @param type Type de batracien
     */
    public Batracien(CraGre type) {
        
        this.type = type;
        
    }
    
    /**
     * Methode permettent de dÃ©placer le batracien
     * (saut ou avancer suivant la situation)
     */
    public void deplacer(){
    
    }
    
    /**
     * Teste la possibilitÃ© de dÃ©placement 
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
