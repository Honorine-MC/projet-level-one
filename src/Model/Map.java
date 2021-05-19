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
		Joueur player = new Joueur("Riyad Mahrez",10,2);
		this.plateau[0][0].setElement(player);
		
		/*Placement des murs*/
		Obstacle mur1 = new Mur(0,3,false);
		this.plateau[0][3].setElement(mur1);
		Obstacle mur2 = new Mur(0,3,false);
		this.plateau[2][3].setElement(mur2);
		
		/*Placement des portes*/
		
		/*Placement des monstres*/
		
		/*Placement des PNJ*/
		
		/*Placement des ITEM*/
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
