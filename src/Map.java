import java.util.ArrayList;

public class Map {
	public ArrayList<Case> plateau;
	private int taille = 32;
	
	/*Constructeur*/
	public Map(){
		this.plateau = new ArrayList<Case>();
	}
	
	/**
	 * Method : void -> Initialise une Map en placeant différents élements
	 */
	public void init(){
		/*On place les case vide avec leur positions*/
		for(int i = 0 ; i<this.taille;i++){
			this.plateau.add(new Case(new Element(i),i));
		}
		/*Placement des elements sur la map*/
		Joueur player = new Joueur("Riyad Mahrez",10,2);
		player.setPosition(0);
		this.plateau.get(0).setElement(player);
		
		/*Placement au hazar juste pour tester*/
		for(Case c : this.plateau){
			if(c.getPosition()%2 ==0){
				c.setElement(new Porte(c.getPosition(),true));
			}
			if(c.getPosition()%3==0){
				c.setElement(new Item(c.getPosition(),"La puissance"));
			}
			if(c.getPosition()%4==0){
				c.setElement(new Pnj(c.getPosition(),"Viens deuspi", new Item(c.getPosition(),"mets toi bien"),5));
			}
			else{
				c.setElement(new Monstre(c.getPosition(),"Méchant",10,2));
			}
		}
	}

}
