import java.util.ArrayList;

public class Map {
	
	/*Attributs*/
	/* Supprimer les valeurs pour passer en sur mesure */
	private int nbLig = 20;
	private int nbCol = 20;
	public Case [][] plateau;
	
//	public ArrayList<Case> plateau;
//	private int taille = 32;
	
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
		for(int i = 0; i<nbLig; i++) {
				for(int j = 0; j<nbCol; j++) {
					this.plateau[i][j] = new Case(new Element(i,j),i,j);
				}
		}
		
		/*Placement des elements sur la map*/
		Joueur player = new Joueur("Riyad Mahrez",10,2);
		player.setPositionX(0);
		player.setPositionY(0);
		this.plateau[0][0].setElement(player);
			
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
