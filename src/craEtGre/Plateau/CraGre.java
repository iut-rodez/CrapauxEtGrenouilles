/**
 * CraGre.java                                                          16/05/13
 */
package craEtGre.Plateau;

/**
 * Enum�ration permettant de d�finir le type du batracien
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
     * Indique le sens de d�placement du batracien, 1 ou -1
     */
    private int sensDeDeplacement;
    
    private CraGre(int id, int sensDeDeplacement) {
        
        this.id = id;
        this.sensDeDeplacement = sensDeDeplacement;
        
    }
    
    /**
     * Retourne l'identifiant num�rique du personnage
     * 
     * @return Identificateur num�rique du personnage
     */
    public int identifiant() {
        
        return id;
        
    }
    
    /**
     * Retourne le sens de d�placement du personnage:
     * <ul><li>-1 de droite � gauche</li>
     *     <li>+1 de gauche � droite</li></ul>
     *     
     * @return Sens de d�placement du personnage
     */
    public int sens() {
        
        return sensDeDeplacement;
        
    }
    
}
