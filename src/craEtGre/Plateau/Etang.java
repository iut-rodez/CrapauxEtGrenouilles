/**
 * Etang.java                                                           16/05/13
 */
package craEtGre.Plateau;

import java.util.ArrayList;

/**
 * Représentation de la zone de jeu
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
     * Tableau bidimensionnel représentant la position des batraciens
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
     * Construit un étant à partir des dimensions données
     * 
     * @param hauteur Nombre de couloirs
     * @param largeur Feuilles par couloir
     */
    public Etang(int hauteur, int largeur) {
    	
    	// Si la hauteur ou la largeur est invalide, les valeurs maximums sont
    	// utilisées par défaut
    	
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
     * Retourne une référence vers un batracien à une position donnée
     * 
     * @param couloir Couloir à éxaminer
     * @param feuille Feuille à éxaminer
     * @return Batracien situé sur {@code feuille}, dans {@code couloir}; ou
     *         null si aucun batracien n'a pu être trouvé.
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
     * Retourne l'ensemble des batraciens d'un type donné
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
     * Positionne un batracien à une position donnée
     * 
     * @param feuille Nouvelle position
     * @param Batracien à placer
     */
    void setBatracien(int feuille, Batracien batracien) {
    	
    	if (feuille >= 0 && feuille < largeur) {
    		
	    	etang[batracien.getCouloir()][feuille] = batracien;
	    	batracien.setNenuphar(feuille);
	    	
    	}
    	
    }

    /**
     * Retourne une représentation de l'étang sous forme de chaine
     */
    @Override
    public String toString() {
        String chaine = "";
        //parcours du tableau dans sa hauteur
        for (int i = 0; i <= hauteur; i++) {
            //générer un trait horizontal de séparation 
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
