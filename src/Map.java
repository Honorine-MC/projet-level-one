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
				Element e = this.add();
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
	 * Function -> Affichage console de la map
	 */
	public void affiche(){
		for(int i =0; i<this.nbLig ; i++){
			for(int j=0; j<this.nbCol; j++){
				if(this.plateau[i][j].getElement() instanceof Monstre){
					System.out.print(" | " + "Monstre");
				}
				if(this.plateau[i][j].getElement() instanceof Pnj){
					System.out.print(" | " + "Bicraveur");
				}
				if(this.plateau[i][j].getElement() instanceof Item){
					System.out.print(" | " + "du biff");
				}
				if(this.plateau[i][j].getElement() instanceof Joueur){
					System.out.print(" | " + "Mahrez");
				}
				if(this.plateau[i][j].getElement() instanceof Obstacle){
					System.out.print(" | " + "Obstacle");
				}
			}
			System.out.println("|");
		}
		System.out.println();
	}
	
	/** Function :
	 * @return : Renvoi un element au hazar -> Un monstre un pnj ou un item..etc
	 */
	public Element add() {
		
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
