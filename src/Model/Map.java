package Model;
import java.util.ArrayList;
import java.util.Observable;

public class Map extends Observable{
	
	/*Attributs*/
	public Joueur joueur;
	public int nbLig;
	public int nbCol;
	public Case [][] plateau;
	
	/*Constructeur*/
	public Map(int n, int p) {
		nbLig = n;
		nbCol = p;
		this.plateau = new Case[nbLig][nbCol];
	}
	
	
	/**
	 * Method : void -> Initialise une Map en placeant diff�rents �lements � la main
	 */
	public void init(){
		/*On place les case vide avec leur positions*/
		System.out.println();
		for(int i = 0; i<nbLig; i++) {
			for(int j = 0; j<nbCol; j++) {
				this.plateau[i][j] = new Case(i,j,null);
			}
		}
		/*On place le joueur au debut de la Map*/
		this.joueur = new Joueur("Riyad Mahrez",3,3);
		this.plateau[3][3].setElement(this.joueur);
		
		/*Placement des murs*/
		Obstacle mur1 = new Mur(0,1,false);
		this.plateau[0][1].setElement(mur1);
		Obstacle mur2 = new Mur(0,2,false);
		this.plateau[0][2].setElement(mur2);
		Obstacle mur3 = new Mur(0,4,false);
		this.plateau[0][4].setElement(mur3);
		Obstacle mur4 = new Mur(0,6,false);
		this.plateau[0][6].setElement(mur4);
		Obstacle mur5 = new Mur(0,7,false);
		this.plateau[0][7].setElement(mur5);
		Obstacle mur6 = new Mur(1,1,false);
		this.plateau[1][1].setElement(mur6);
		Obstacle mur7 = new Mur(1,2,false);
		this.plateau[1][2].setElement(mur7);
		Obstacle mur8 = new Mur(1,4,false);
		this.plateau[1][4].setElement(mur8);
		Obstacle mur9 = new Mur(2,4,false);
		this.plateau[2][4].setElement(mur9);
		Obstacle mur10 = new Mur(2,6,false);
		this.plateau[2][6].setElement(mur10);
		Obstacle mur11 = new Mur(3,0,false);
		this.plateau[3][0].setElement(mur11);
		Obstacle mur12 = new Mur(3,1,false);
		this.plateau[3][1].setElement(mur12);
		Obstacle mur13 = new Mur(3,2,false);
		this.plateau[3][2].setElement(mur13);
		Obstacle mur14 = new Mur(3,4,false);
		this.plateau[3][4].setElement(mur14);
		Obstacle mur15 = new Mur(3,6,false);
		this.plateau[3][6].setElement(mur15);
		Obstacle mur16 = new Mur(4,0,false);
		this.plateau[4][0].setElement(mur16);
		Obstacle mur17 = new Mur(4,4,false);
		this.plateau[4][4].setElement(mur17);
		Obstacle mur18 = new Mur(4,6,false);
		this.plateau[4][6].setElement(mur18);
		Obstacle mur19 = new Mur(5,0,false);
		this.plateau[5][0].setElement(mur19);
		Obstacle mur20 = new Mur(5,4,false);
		this.plateau[5][4].setElement(mur20);
		Obstacle mur21 = new Mur(5,6,false);
		this.plateau[5][6].setElement(mur21);
		Obstacle mur22 = new Mur(6,0,false);
		this.plateau[6][0].setElement(mur22);
		Obstacle mur23 = new Mur(6,6,false);
		this.plateau[6][6].setElement(mur23);
		Obstacle mur24 = new Mur(7,0,false);
		this.plateau[7][0].setElement(mur24);
		Obstacle mur25 = new Mur(7,1,false);
		this.plateau[7][1].setElement(mur25);
		Obstacle mur26 = new Mur(7,3,false);
		this.plateau[7][3].setElement(mur26);
		Obstacle mur27 = new Mur(7,5,false);
		this.plateau[7][5].setElement(mur27);
		Obstacle mur28 = new Mur(7,6,false);
		this.plateau[7][6].setElement(mur28);
		
		/*Placement des portes*/
		Obstacle porte1 = new Porte(1,3,true);
		this.plateau[1][3].setElement(porte1);
		Obstacle porte2 = new Porte(2,1,false);
		this.plateau[2][1].setElement(porte2);
		Obstacle porte3 = new Porte(5,2,false);
		this.plateau[5][2].setElement(porte3);
		
		/*Placement des monstres*/
		Personnage monstre1 = new Monstre(4,5,"Muzan",10,2);
		this.plateau[4][5].setElement(monstre1);
		Personnage monstre2 = new Monstre(4,7,"Akaza",10,2);
		this.plateau[3][7].setElement(monstre2);
		Personnage monstre3 = new Monstre(7,1,"Hisoka",10,2);
		this.plateau[7][1].setElement(monstre3);
		
		/*Placement des ITEM*/
		Item potion1 = new Potion(5,3,"popo",10);
		this.plateau[5][3].setElement(potion1);
		
		Item arme1 = new Arme(6,0,"arc",5);
		this.plateau[6][0].setElement(arme1);
		
		/*Placement des PNJ*/
		Personnage pnj1 = new Pnj(0,3,"a",arme1,10);
		this.plateau[0][3].setElement(pnj1);
		Personnage pnj2 = new Pnj(0,5,"b",arme1,10); // autre arme
		this.plateau[0][5].setElement(pnj2);
		Personnage pnj3 = new Pnj(4,7,"Gojo",potion1,10);
		this.plateau[4][7].setElement(pnj3);
		
		
	}
	
	/**
	 * Function -> Affichage console de la map
	 */
	public void affiche(){
		for(int i =0; i<this.nbLig ; i++){
			for(int j=0; j<this.nbCol; j++){
				if(this.plateau[i][j].getElement() instanceof Monstre){
					System.out.print(" | " + "Mon");
				}
				if(this.plateau[i][j].getElement() instanceof Pnj){
					System.out.print(" | " + "pnj");
				}
				if(this.plateau[i][j].getElement() instanceof Item){
					System.out.print(" | " + "Ite");
				}
				if(this.plateau[i][j].getElement() instanceof Joueur){
					System.out.print(" | " + "Toi");
				}
				if(this.plateau[i][j].getElement() instanceof Mur){
					System.out.print(" | " + "Mur");
				}
				if(this.plateau[i][j].getElement() instanceof Porte){
					System.out.print(" | " + "Por");
				}
				if(this.plateau[i][j].getElement() instanceof Potion){
					System.out.print(" | " + "Pot");	
				}
				if(this.plateau[i][j].getElement() instanceof Arme){
					System.out.print(" | " + "Arm");	
				}
				if(this.plateau[i][j].getElement() == null){
					System.out.print(" | " + "   ");
				}
			}
			System.out.println(" | ");
		}
		System.out.println();
	}
	
	/**
	 * Function -> Autorise au non un deplacement du joueur
	 */
	public boolean deplacement_valide(int x, int y){
		boolean res = true;
		/*On verifie si la porte ou le mur est traversable*/
		if(this.plateau[x][y].getElement() instanceof Mur || this.plateau[x][y].getElement() instanceof Porte){
			Obstacle o = (Obstacle)this.plateau[x][y].getElement();
			if(!o.isOuvert()){
				res = false;
				System.out.println("Vous ne pouvez pas passer cet obstacle !");
			}
		}
		/*On verifie si le monstre a �t� battu*/
		if(this.plateau[x][y].getElement() instanceof Monstre){
			Monstre m = (Monstre)this.plateau[x][y].getElement();
			if(!m.estVaincu()){
				res=false;
			}
		}
		return res;
	}
	
	/**
	 * Function -> D�place le joueur et met � jour la Map
	 */
	public void deplacerJoueur(int x, int y){
		if(this.deplacement_valide(x, y)){
			/*On recupere la position actuelle du joueur*/
			int currentPositionX = this.joueur.getPositionX();
			int currentPositionY = this.joueur.getPositionY();
			/*Mise a jour de la map*/
			this.plateau[currentPositionX][currentPositionY].setElement(null);
			this.joueur.avancer(x, y);//deplacement joueur
			this.plateau[x][y].setElement(this.joueur);
		}
		else{
			System.out.println("Deplacement invalide");
		}
		
	}
	
	public void deplaceJoueur(int deplace) {
		int currentPositionX = this.joueur.getPositionX();
		int currentPositionY = this.joueur.getPositionY();
		switch (deplace) {
		case 8 :
			if(currentPositionX != 0 ) {
				if(this.deplacement_valide(currentPositionX-1, currentPositionY)) {
					this.plateau[currentPositionX][currentPositionY].setElement(null);
					this.joueur.avancer(currentPositionX-1, currentPositionY);//deplacement joueur
					this.plateau[currentPositionX-1][currentPositionY].setElement(this.joueur);
					this.setChanged();
					this.notifyObservers();
				}
			}
			else {
				System.out.println("Vous ne pouvez pas vous d�placer vers le haut !");
			}
		break;
		case 2 :
			if(currentPositionX != 7) {
				if(this.deplacement_valide(currentPositionX+1, currentPositionY)) {
					this.plateau[currentPositionX][currentPositionY].setElement(null);
					this.joueur.avancer(currentPositionX+1, currentPositionY);//deplacement joueur
					this.plateau[currentPositionX+1][currentPositionY].setElement(this.joueur);
					this.setChanged();
					this.notifyObservers();
				}
			}
			else {
				System.out.println("Vous ne pouvez pas vous d�placer vers le bas !");
			}
		break;
		case 6 :
			if(currentPositionY != 7) {
				if(this.deplacement_valide(currentPositionX, currentPositionY+1)) {
					this.plateau[currentPositionX][currentPositionY].setElement(null);
					this.joueur.avancer(currentPositionX, currentPositionY+1);//deplacement joueur
					this.plateau[currentPositionX][currentPositionY+1].setElement(this.joueur);
					this.setChanged();
					this.notifyObservers();
				}
			}
			else {
				System.out.println("Vous ne pouvez pas vous d�placer vers la droite !");
			}
		break;
		case 4 :
			if(currentPositionY != 0) {
				if(this.deplacement_valide(currentPositionX, currentPositionY-1)) {
					this.plateau[currentPositionX][currentPositionY].setElement(null);
					this.joueur.avancer(currentPositionX, currentPositionY-1);//deplacement joueur
					this.plateau[currentPositionX][currentPositionY-1].setElement(this.joueur);
					this.setChanged();
					this.notifyObservers();
				}
			}
			else {
				System.out.println("Vous ne pouvez pas vous d�placer vers la gauche !");
			}
		break;
		default :
			System.out.println("Vers o� voulez-vous vous d�placer ? (6 = droite, 4 = gauche, 2 = bas, 8 = haut");
		}
	}
	
}
