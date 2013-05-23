/**
 * Etang.java                                                           16/05/13
 */
package craEtGre.Plateau;

import java.util.ArrayList;

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
     * Retourne l'ensemble des batraciens
     * 
     * @return Tableau de batraciens
     */
    public Batracien[] getBatraciens() {
    	
    	ArrayList<Batracien> liste = new ArrayList<Batracien>();
    	
    	for (int i = 0; i < hauteur; ++i) {
    		
    		for (int j = 0; j < largeur; ++j) {
    			
    			if (etang[i][j] != null) {
    				
    				liste.add(etang[i][j]);
    				
    			}
    			
    		}
    		
    	}
    	
    	return (Batracien[]) liste.toArray();
    	
    }
    
    /**
     * Retourne l'ensemble des batraciens d'un type donn�
     * 
     * @param type Type de batracien
     * @return Tableau de batraciens
     */
    public Batracien[] getBatraciens(CraGre type) {
    	
    	ArrayList<Batracien> liste = new ArrayList<Batracien>();
    	
    	for (int i = 0; i < hauteur; ++i) {
    		
    		for (int j = 0; j < largeur; ++j) {
    			
    			if (etang[i][j] != null && etang[i][j].getType() == type) {
    				
    				liste.add(etang[i][j]);
    				
    			}
    			
    		}
    		
    	}
    	
    	return (Batracien[]) liste.toArray();
    	
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

    /**
     * Retourne une repr�sentation de l'�tang sous forme de chaine
     */
    @Override
    public String toString() {
        String chaine = "";
        //parcours du tableau dans sa hauteur
        for (int i = 0; i <= hauteur; i++) {
            //g�n�rer un trait horizontal de s�paration 
            for (int j = 0; j <= largeur; j++) {
                chaine = chaine + "----";
            }
            chaine = chaine + "-\n";
            //completer une ligne du tableau
            for (int j = 0; j <= largeur; j++) {
                chaine = chaine + "|";
                if (etang[i][j] == null) {
                    chaine = chaine + "   ";
                } else {
                    chaine = chaine + etang[i][j].toString();
                }
                chaine = chaine + "|\n";
            }
            //fermer le tableau avec un trait horizontal
            for (int j = 0; j <= largeur; j++) {
                chaine = chaine + "----";
            }
            chaine = chaine + "-\n";
        }
        return chaine;
    }

}
