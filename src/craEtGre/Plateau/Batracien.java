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
     * Etang dans lequel existe le batracien
     */
    private Etang etang;
    
    /**
     * Couloir du batratien (il ne peut pas en changer)
     */
    private int couloir;
    
    /**
     * N�nuphar sur lequel se trouve le batracien
     */
    private int feuille;
        
    /**
     * Cr�e un batracien d'un type donn� 
     * 
     * @param type Type de batracien
     */
    public Batracien(Etang etang, CraGre type) {
        
    	this.etang = etang;
        this.type = type;
        
    }
    
    /**
     * D�place le batracien
     * 
     * @return Vrai si le batracien a pu �tre d�plac�, false si aucun mouvement
     *         n'�tait possible.
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
     * Teste la possibilit� de d�placement
     * 
     * @return Vrai si un d�placement est possible
     */
    public boolean peutSeDeplacer() {
        
    	return peutAvancer() || peutSauter();
    	
    }
    
    /**
     * Teste la possibilit� d'avancer � la feuille suivante
     * 
     * @return Vrai si le batracien peut avancer
     */
    public boolean peutAvancer() {
    	
    	return (suivant() == null);
    	
    }
    
    /**
     * Teste la possibilit� de sauter une feuille
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
     * Retourne une r�f�rence vers le batracien situ� sur la feuille suivante
     * (dans le sens de d�placement du batracien)
     * 
     * @return R�f�rence vers un batracien, ou null si aucun batracien n'a pu
     *         �tre trouv�.
     */
    public Batracien suivant() {
    	
    	return etang.getBatracien(couloir, feuille + type.sens());
    	
    }
    
    /**
     * Retourne une r�f�rence vers le batracien situ� sur la feuille pr�c�dente
     * (dans le sens de d�placement du batracien)
     * 
     * @return R�f�rence vers un batracien, ou null si aucun batracien n'a pu
     *         �tre trouv�.
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
     * Retourne le n�nuphar sur lequel se trouve le batracien
     * 
     * @return N�nuphar sur lequel se trouve le batracien
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
