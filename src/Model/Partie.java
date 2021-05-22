package Model;

import java.util.Scanner;
public class Partie {

	public static void main(String[] args) {
		Map map = new Map(8,8);
		map.init();
		
		/**
		 * Test des fonctions du jeu en version console *
		 */
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Pour jouer tappez 1");
		System.out.println("Pour quitter tappez 0");

		int choix = scan.nextInt();
		
		while(choix != 0){
			map.affiche();
//			System.out.println("Entrez position x");
//			int x = scan.nextInt();
//			System.out.println("Entrez position y");
//			int y = scan.nextInt();
			System.out.println("Vers où voulez-vous vous déplacer ? (6 = droite, 4 = gauche, 2 = bas, 8 = haut");
			int deplacement = scan.nextInt();
			/*Test pour voir si il peut traverser une porte ouverte*/
			Porte p = (Porte)map.plateau[2][1].getElement();
			p.setOuvert(true);
//			map.deplacerJoueur(x, y);
			map.deplaceJoueur(deplacement);
		}
	}
}