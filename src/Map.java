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
		
		/*Placement au hazar juste pour tester*/
//		for(Case c : this.plateau){
//			if((c.getPositionX()%2 ==0) || (c.getPositionY()%2 ==0)){
//				c.setElement(new Porte(c.getPositionX(), c.getPositionY(),true));
//			}
//			if((c.getPositionX()%3==0) || (c.getPositionY()%3==0)){
//				c.setElement(new Item(c.getPositionX(), c.getPositionY(),"La puissance"));
//			}
//			if((c.getPositionX()%4==0) || (c.getPositionY()%4==0)){
//				c.setElement(new Pnj(c.getPositionX(), c.getPositionY(),"Viens deuspi", new Item(c.getPositionX(), c.getPositionY(),"mets toi bien"),5));
//			}
//			else{
//				c.setElement(new Monstre(c.getPositionX(), c.getPositionY(),"Méchant",10,2));
//			}
//		}
	}

}
