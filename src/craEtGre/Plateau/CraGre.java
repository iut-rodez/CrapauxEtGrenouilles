/**
 * CraGre.java                                                          16/05/13
 */
package craEtGre.Plateau;

/**
 * Enumération permettant de définir le type du batracien
 * 
 * @author INFO1
 */
public enum CraGre {
    
    /**
     * Grenouille
     */
    GRENOUILLE(0, 1),
    
    /**
     * Crapaud
     */
    CRAPAUD(1, -1);
    
    /**
     * Identifiant du type de personnage
     */
    private int id;
    
    /**
     * Indique le sens de déplacement du batracien, 1 ou -1
     */
    private int sensDeDeplacement;
    
    private CraGre(int id, int sensDeDeplacement) {
        
        this.id = id;
        this.sensDeDeplacement = sensDeDeplacement;
        
    }
    
    /**
     * Retourne l'identifiant numérique du personnage
     * 
     * @return Identificateur numérique du personnage
     */
    public int identifiant() {
        
        return id;
        
    }
    
    /**
     * Retourne le sens de déplacement du personnage:
     * <ul><li>-1 de droite à gauche</li>
     *     <li>+1 de gauche à droite</li></ul>
     *     
     * @return Sens de déplacement du personnage
     */
    public int sens() {
        
        return sensDeDeplacement;
        
    }
    
}
