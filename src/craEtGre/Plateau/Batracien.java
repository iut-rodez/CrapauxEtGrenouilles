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
     * Etang dans lequel existe le batracien
     */
    private Etang etang;
    
    /**
     * Couloir du batratien (il ne peut pas en changer)
     */
    private int couloir;
    
    /**
     * Nénuphar sur lequel se trouve le batracien
     */
    private int feuille;
        
    /**
     * Crée un batracien d'un type donné 
     * 
     * @param type Type de batracien
     */
    public Batracien(Etang etang, CraGre type) {
        
    	this.etang = etang;
        this.type = type;
        
    }
    
    /**
     * Déplace le batracien
     * 
     * @return Vrai si le batracien a pu être déplacé, false si aucun mouvement
     *         n'était possible.
     */
    public boolean deplacer() {
    
    	if (peutAvancer()) {
    		
    		etang.setBatracien(feuille + type.sens(), this);
    		return true;
    		
    	}
    	
    	if (peutSauter()) {
    		
    		etang.setBatracien(feuille + (type.sens() * 2), this);
    		return true;
    		
    	}
    	
    	return false;
    	
    }
    
    /**
     * Teste la possibilité de déplacement
     * 
     * @return Vrai si un déplacement est possible
     */
    public boolean peutSeDeplacer() {
        
    	return peutAvancer() || peutSauter();
    	
    }
    
    /**
     * Teste la possibilité d'avancer à la feuille suivante
     * 
     * @return Vrai si le batracien peut avancer
     */
    public boolean peutAvancer() {
    	
    	return (suivant() == null);
    	
    }
    
    /**
     * Teste la possibilité de sauter une feuille
     * 
     * @return Vrai si le batracien peut sauter
     */
    public boolean peutSauter() {
    	
    	Batracien suivant;
    	
    	suivant = suivant();
    	
    	if (suivant != null && suivant.type != type) {
    		
    		return (suivant.precedent() == null);
    		
    	}
    	
    	return false;
    	
    }
    
    /**
     * Retourne une référence vers le batracien situé sur la feuille suivante
     * (dans le sens de déplacement du batracien)
     * 
     * @return Référence vers un batracien, ou null si aucun batracien n'a pu
     *         être trouvé.
     */
    public Batracien suivant() {
    	
    	return etang.getBatracien(couloir, feuille + type.sens());
    	
    }
    
    /**
     * Retourne une référence vers le batracien situé sur la feuille précédente
     * (dans le sens de déplacement du batracien)
     * 
     * @return Référence vers un batracien, ou null si aucun batracien n'a pu
     *         être trouvé.
     */
    public Batracien precedent() {
    	
    	return etang.getBatracien(couloir, feuille - type.sens());
    	
    }

    /**
     * Retourne le type du batracien
     * 
     * @return Type de batracien
     */
    public CraGre getType() {
    	
        return type;
        
    }

    /**
     * Retourne le couloir dans lequel se trouve le batracien
     * 
     * @return Couloir dans lequel se trouve le batracien
     */
    public int getCouloir() {
    	
        return couloir;
        
    }

    /**
     * Retourne le nénuphar sur lequel se trouve le batracien
     * 
     * @return Nénuphar sur lequel se trouve le batracien
     */
    public int getNenuphar() {
    	
        return feuille;
        
    }
    
    /**
     * Change la feuille sur laquelle se trouve le batracien
     * 
     * @param feuille Nouvelle position
     */
    public void setNenuphar(int feuille) {
    	
    	this.feuille = feuille;
    	
    }
    
}
