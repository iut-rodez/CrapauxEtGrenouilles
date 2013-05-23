/**
 * CrapauxEtGrenouilles.java                                      9 mai 2013
 * Bercy
 */
package craEtGre;

import java.util.Scanner;

/**
 * @author Bercy
 * Programme principal du jeu des Crapaux et des Grenouilles
 */
public class CrapauxEtGrenouilles {

    /**
     * Méthode principale contient uniquement un menu principal
     * @param args non utilisé
     */
    public static void main(String[] args) {
        char choix;
        
        Scanner entree = new Scanner(System.in);
        System.out.println("\n"+
                           "Crapauds et Grenouilles\n"+
                           "       o  o   o  o\n"+
                           "       |\\/ \\^/ \\/|\n"+
                           "       |,-------.|\n"+
                           "     ,-.(|)   (|),-.\n"+
                           "     \\_*._ ' '_.* _/\n"+
                           "      /`-.`--' .-'\\\n"+
                           " ,--./    `---'    \\,--.\n"+
                           " \\   |(  )     (  )|   /\n"+
                           "  \\  | ||       || |  /\n"+
                           "   \\ | /|\\     /|\\ | /\n"+
                           "   /  \\-._     _,-/  \\\n"+
                           "  //| \\\\  `---'  // |\\\\\n"+
                           " /,-.,-.\\       /,-.,-.\\\n"+
                           " o   o   o     o   o   o\n");//ascii art 
                                                         //sympa de bienvenue

        // saisie avec controle d'erreur du type de jeu

        do {
            System.out.print("Menu Principal \n\n"+
                               "(J)Jeu Simple\n"+
                               "(C)Casse-Tete\n"+
                               "(E)Editeur de carte\n"+
                               "(Q)Quitter\n\n"+
                               "Votre choix : ");
            // connvertie la saisie en minuscule si besoin est , puis en prend
            // la première lettre
            choix = entree.next().toLowerCase().charAt(0);
            entree.nextLine();
            if (!(choix == 'j' || choix == 'c' || choix == 'e' || choix == 'q')) {
                System.err.println("erreur veuillez resaisir votre choix");
            }
        } while (!(choix == 'j' || choix == 'c' || choix == 'e' || choix == 'q'));
        switch (choix) {
        case 'j' : partieSimple();
                   break;
        case 'c' : partieCasseTete();
                   break;
        case 'e' : //editeurDeCarte();
                   break;
        case 'q' : {
                    //quitter le jeu
                    System.out.println("a Bientot !");
                    return;
                    }

        }

    }
    
    /**
     *  Méthode permettant d'initialiser et de commencer
     *  un casse-tete
     */
    private static void partieCasseTete() {
    Scanner entree = new Scanner(System.in);
    String jnom;//nom du joueur
    //seul un humain peut jouer au casse tête
    System.out.println("entrez votre nom (utilise pour charger " +
                        "vos statistiques) :");
    jnom = entree.nextLine();
    System.out.println("bonne chance "+jnom+ " !");
    }
    

    /**
     * Méthode permettant d'initialiser et de commancer 
     * une partie simple (2 joueurs)
     */
    public static void partieSimple() {
        
        char j1;//type de joueur 1
        char j2;//type de joueur 2
        String j1nom;//nom du joueur 1
        String j2nom;//nom du joueur 2
        int j1niveau;//niveau du joueur 1 si c'est une IA
        int j2niveau;//niveau du joueur 2 si c'est une IA
        
        Scanner entree = new Scanner(System.in);
        do {
            System.out
                    .println("J1 est : \n      une(I)IA\n       un (H)Humain");
            // connvertie la saisie en minuscule si besoin est , puis en prend
            // la première lettre
            j1 = entree.next().toLowerCase().charAt(0);
            entree.nextLine();
            if (!(j1 == 'i' || j1 == 'h')) {
                System.err.println("erreur veuillez resaisir votre choix");
            }
        } while (!(j1 == 'i' || j1 == 'h'));

        do {
            System.out
                    .println("J2 est : \n      une(I)IA\n       un (H)Humain");
            // connvertie la saisie en minuscule si besoin est , puis en prend
            // la première lettre
            j2 = entree.next().toLowerCase().charAt(0);
            entree.nextLine();
            if (!(j2 == 'i' || j2 == 'h')) {
                System.err.println("erreur veuillez resaisir votre choix");
            }
        } while (!(j2 == 'i' || j2 == 'h'));

        // saisie des informations relatives aux joueurs
        if (j1 == 'i') {

            // si j1 est une IA
            j1nom = InterfaceFichier.nomHasard();
            do {
                System.out.println("Entrez le niveau de l'IA (de 0 à 100) : ");
                if (!entree.hasNextInt()) {
                    System.out.println("Erreur lors de la " +
                            		"saisie veuillez recommencer");
                    j1niveau = -1;
                } else {
                    j1niveau = entree.nextInt();
                }
                entree.nextLine();
                if (j1niveau < 0 || j1niveau > 100) {
                    System.out.println("Veuillez entrez un " +
                    		       "nombre entre 0 et 100");
                }
            } while (j1niveau < 0 || j1niveau > 100);

        } else {
            // si j1 est un humain
            System.out.println("entrez votre nom (utilise pour charger " +
                    		"vos statistiques) :");
            j1nom = entree.nextLine();
        }

        if (j2 == 'i') {
            // si j2 est une IA
            j2nom = InterfaceFichier.nomHasard();
            do {
                System.out.println("Entrez le niveau de l'IA (de 0 à 100) : ");
                if (!entree.hasNextInt()) {
                    System.out
                            .println("Erreur lors de la saisie veuillez recommencer");
                    j2niveau = -1;
                } else {
                    j2niveau = entree.nextInt();
                }
                entree.nextLine();
                if (j2niveau < 0 || j2niveau > 100) {
                    System.out
                            .println("Veuillez entrez un nombre entre 0 et 100");
                }
            } while (j2niveau < 0 || j2niveau > 100);

        } else {
            // si j2 est un humain
            System.out
                    .println("entrez votre nom (utilise pour charger vos statistiques) :");
            j2nom = entree.nextLine();
        }
        
        
        //affichage du tableau des joueurs
        System.out.println(j1nom + " vs " + j2nom);
    }
}
 

