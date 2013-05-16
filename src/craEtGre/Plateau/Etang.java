/**
 * Etang.java                                                           16/05/13
 */
package craEtGre.Plateau;

/**
 * Repr�sentation de la zone de jeu
 * 
 * @author INFO1
 */
public class Etang {

	/**
	 * Nombre maximum de couloirs
	 */
	private final int HAUTEUR_MAX = 10;
	
	/**
	 * Nombre maximum de feuilles par couloir
	 */
	private final int LARGEUR_MAX = 20;
	
    /**
     * Tableau bidimensionnel repr�sentant la position des batraciens
     */
    private Batracien[][] etang;
    
    /**
     * Nombre de couloirs
     */
    private int hauteur;
    
    /**
     * Nombre de feuilles par couloir
     */
    private int largeur;
    
    /**
     * Construit un �tant � partir des dimensions donn�es
     * 
     * @param hauteur Nombre de couloirs
     * @param largeur Feuilles par couloir
     */
    public Etang(int hauteur, int largeur) {
    	
    	// Si la hauteur ou la largeur est invalide, les valeurs maximums sont
    	// utilis�es par d�faut
    	
    	if (hauteur < 1 || hauteur > HAUTEUR_MAX) {
    		
    		hauteur = HAUTEUR_MAX;
    		
    	}
    	
    	if (largeur < 1 || largeur > LARGEUR_MAX) {
    		
    		largeur = LARGEUR_MAX;
    		
    	}
    	
    	this.hauteur = hauteur;
    	this.largeur = largeur;
    	
    	etang = new Batracien[hauteur][largeur];
    	
    }
    
    /**
     * Retourne une r�f�rence vers un batracien � une position donn�e
     * 
     * @param couloir Couloir � �xaminer
     * @param feuille Feuille � �xaminer
     * @return Batracien situ� sur {@code feuille}, dans {@code couloir}; ou
     *         null si aucun batracien n'a pu �tre trouv�.
     */
    public Batracien getBatracien(int couloir, int feuille) {
    	
    	if ((couloir >= 0 && couloir < hauteur)
    			&& (feuille >= 0 && feuille < largeur)) {
    		
    		return etang[couloir][feuille];
    		
    	}
    	
    	return null;
    	
    }
    
    /**
     * Positionne un batracien � une position donn�e
     * 
     * @param feuille Nouvelle position
     * @param Batracien � placer
     */
    void setBatracien(int feuille, Batracien batracien) {
    	
    	if (feuille >= 0 && feuille < largeur) {
    		
	    	etang[batracien.getCouloir()][feuille] = batracien;
	    	batracien.setNenuphar(feuille);
	    	
    	}
    	
    }
    
}
