package Model;
import java.util.ArrayList;

public class Map {
	
	/*Attributs*/
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
	 * Method : void -> Initialise une Map en placeant différents élements au Hazar
	 */
	public void initHazar(){
		/*On place les case vide avec leur positions*/
		System.out.println();
		for(int i = 0; i<nbLig; i++) {
			for(int j = 0; j<nbCol; j++) {
				Element e = this.addHazar();
				this.plateau[i][j] = new Case(e,i,j);
			}
		}
		/*On place le joueur au debut de la Map*/
		Joueur player = new Joueur("Riyad Mahrez",10,2);
		player.setPositionX(0);
		player.setPositionY(0);
		this.plateau[0][0].setElement(player);
	}
	
	/**
	 * Method : void -> Initialise une Map en placeant différents élements à la main
	 */
	public void init(){
		/*On place les case vide avec leur positions*/
		System.out.println();
		for(int i = 0; i<nbLig; i++) {
			for(int j = 0; j<nbCol; j++) {
				this.plateau[i][j] = new Case(null,i,j);
			}
		}
		/*On place le joueur au debut de la Map*/
		Joueur player = new Joueur("Riyad Mahrez",0,0);
		this.plateau[0][0].setElement(player);
		
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
		this.plateau[7][0].setElement(mur23);
		Obstacle mur25 = new Mur(7,1,false);
		this.plateau[7][1].setElement(mur23);
		Obstacle mur26 = new Mur(7,3,false);
		this.plateau[7][3].setElement(mur23);
		Obstacle mur27 = new Mur(7,5,false);
		this.plateau[7][5].setElement(mur23);
		Obstacle mur28 = new Mur(7,6,false);
		this.plateau[7][6].setElement(mur23);
		
		/*Placement des portes*/
		Obstacle porte1 = new Porte(1,3,false);
		this.plateau[1][3].setElement(porte1);
		Obstacle porte2 = new Porte(2,1,false);
		this.plateau[2][1].setElement(porte2);
		Obstacle porte3 = new Porte(5,2,false);
		this.plateau[5][2].setElement(porte3);
		
		/*Placement des monstres*/
		Personnage monstre1 = new Monstre(4,5,"Muzan",10,2);
		this.plateau[4][5].setElement(monstre1);
		Personnage monstre2 = new Monstre(4,7,"Akaza",10,2);
		this.plateau[4][7].setElement(monstre2);
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
					System.out.print(" | " + "M");
				}
				if(this.plateau[i][j].getElement() instanceof Pnj){
					System.out.print(" | " + "P");
				}
				if(this.plateau[i][j].getElement() instanceof Item){
					System.out.print(" | " + "I");
				}
				if(this.plateau[i][j].getElement() instanceof Joueur){
					System.out.print(" | " + "J");
				}
				if(this.plateau[i][j].getElement() instanceof Obstacle){
					System.out.print(" | " + "O");
					
				}
					
				if(this.plateau[i][j].getElement() instanceof Porte){
						System.out.print(" | " + "PR");
				}
				
				if(this.plateau[i][j].getElement() instanceof Potion){
					System.out.print(" | " + "PO");
					
				}
				
				if(this.plateau[i][j].getElement() instanceof Arme){
					System.out.print(" | " + "AR");
					
				}
				
				if(this.plateau[i][j].getElement() == null){
					System.out.print(" | " + " ");
				}
			}
			System.out.println("|");
		}
		System.out.println();
	}
	
	/** Function :
	 * @return : Renvoi un element au hazar -> Un monstre un pnj ou un item..etc
	 */
	public Element addHazar() {
		
		Element element = new Element() ;	
		/*Position aléatoire de lelement dans les limites de la map*/
		int posX1 = 1 + (int)(Math.random() * (((nbLig-1) - 0) + 1));
		int posY1 = 1 + (int)(Math.random() * (((nbCol-1)- 0) + 1));
		
		/*Choix au hazar de lelement monstre, pnj ou autre*/
		int choixElement = 1 + (int)(Math.random() * ((4 - 1) + 1));
		
		if(choixElement == 1){
			element = new Monstre(posX1,posY1,"Monstre",10,2);
		}
		if(choixElement == 2){
			element = new Pnj(posX1,posY1,"Viens deuspi", new Item(posX1, posY1,"mets toi bien"),5);
		}
		if(choixElement == 3){
			element = new Item(posX1,posY1,"La puissance");
		}
		if(choixElement == 4){
			element = new Obstacle(posX1,posY1,true);
		}
		
		return element;
	}
}
