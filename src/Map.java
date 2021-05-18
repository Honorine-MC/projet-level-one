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
	 * Method : void -> Initialise une Map en placeant différents élements
	 */
	public void init(){
		/*On place les case vide avec leur positions*/
		System.out.println();
		for(int i = 0; i<nbLig; i++) {
			for(int j = 0; j<nbCol; j++) {
				this.plateau[i][j] = new Case(new Element(i,j),i,j);
				System.out.print(" | " + this.plateau[i][j]); /* TODO Sert uniquement a visualiser la forme */
			}
			System.out.println(" | ");
		}
		System.out.println();
	}
	
	public void add() {

		/*Placement des elements sur la map*/
		Joueur player = new Joueur("Riyad Mahrez",10,2);
		player.setPositionX(0);
		player.setPositionY(0);
//		this.plateau[0][0].setElement(player);
			
		/*Position aléatoire du monstre dans les limites de la map*/
		int posX1 = 0 + (int)(Math.random() * ((nbLig - 0) + 1));
		int posY1 = 0 + (int)(Math.random() * ((nbCol - 0) + 1));

		/*Position aléatoire de l'item dans les limites de la map*/
		int posX2 = 0 + (int)(Math.random() * ((nbLig - 0) + 1));
		int posY2 = 0 + (int)(Math.random() * ((nbCol - 0) + 1));
		
		/*Position aléatoire du PNJ dans les limites de la map*/
		int posX3 = 0 + (int)(Math.random() * ((nbLig - 0) + 1));
		int posY3 = 0 + (int)(Math.random() * ((nbCol - 0) + 1));
		
		if(posX1 != 0 && posX2 != 0 && posX3 != 0 && posY1 != 0 && posY2 != 0 && posY3 != 0) {
			new Monstre(posX1,posY1,"Monstre",10,2);
			new Item(posX2,posY2,"baton");
			new Pnj(posX3,posY3,"Viens deuspi", new Item(posX2, posY2,"mets toi bien"),5);
		}
	}

}
