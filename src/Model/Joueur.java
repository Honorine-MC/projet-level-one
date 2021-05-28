package Model;
import java.util.ArrayList;

public class Joueur extends Personnage {
	private ArrayList<Item> inventaire;
	private double xp;
	private double degat;
	private int niveau;
	
	//constructeur
	public Joueur(String nom,double vie,double degat) {
		super(3,3,"Vue/joueur.png",nom,vie);
		inventaire = new ArrayList<Item>();
		this.xp = 0;
		this.degat = degat;
		this.niveau = niveau;
	}

	//getteurs
	public ArrayList<Item> getInventaire() {
		return inventaire;
	}
	
	public double getXp() {
		return xp;
	}
	
	public double getDegat() {
		return degat;
	}
	
	public int getNiveau() {
		return niveau;
	}
	//setteurs
	public void setInventaire(ArrayList<Item> inventaire) {
		this.inventaire = inventaire;
	}

	public void setXp(double xp) {
		this.xp = xp;
	}

	public void setDegat(double degat) {
		this.degat = degat;
	}
	
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	@Override
	public String toString() {
		return "Joueur [inventaire=" + inventaire + ", xp=" + xp + ", degat="
				+ degat + "]";
	}
	
	//permet d'avancer d'un certain nombre de case; 
//	public void avancer(int nombre){
//		this.setPositionX(this.getPositionX()+ nombre);
//	}
	
	//permet d'attaquer un monstre
	public void attaquer(Monstre m){
		m.setVie(m.getVie()-this.getDegat());
	}
	
	//prendre un item à un pnj
	public void prendre(Pnj pnj){
		this.inventaire.add(pnj.getItem());
		this.setChanged();
		this.notifyObservers();
		
	}
	
	//ramasser un item qui est au sol 
	public void ramasser(Item i){
		this.inventaire.add(i);
		this.setChanged();
		this.notifyObservers();
	}
	
	//utiliser un item de son inventaire.
	public void utiliser(Item i){
		if( i instanceof Arme){
			Arme a = (Arme)i;
			this.inventaire.remove(i);
			this.setDegat(this.getDegat() + a.getDegat_apporte());
			this.setChanged();
			this.notifyObservers();
		}
		else if ( i instanceof Potion){
			Potion p = (Potion)i;
			this.inventaire.remove(i);
			this.setVie(this.getVie() + p.getVie_apporte());
			this.setChanged();
			this.notifyObservers();
		}
		else{
			System.out.println("error"); // créer une exception
		}
	}
	
	//ranger l'arme dans son inventaire.	
	public void ranger(Arme a){
		this.ramasser(a);
	}
	
	public void ouvrirPorte(Porte p) {
		p.setOuvert(true);
	}
	
	public void avancer(int x, int y){
		this.setPositionX(x);
		this.setPositionY(y);
		//appeler setChange
		//Appeler NotifyObserver
	}
	
	/**
	 * Function -> return boolean : joueur possede ou non une clef
	 */
	public boolean haveKey(){
		boolean res = false;
		for(Item i : this.getInventaire()){
			if(i instanceof Clef){
				res = true;
			}
		}
		return res;
	}
	
	public boolean estVaincu(){
		boolean res = false;
		if(this.getVie() <=0){
			this.setVie(0);
			res = true;
		}
		return res;
	}
	
	public void monterNiveau() {
		if (this.getXp() >= 10) {
			this.setXp(this.getXp() - 10);
			this.setNiveau(this.getNiveau() + 1);
			System.out.println("Vous gagnez un niveau !" + this.getNiveau());
			this.setDegat(this.getDegat() + 2);
			System.out.println("Votre force augmente : " + this.getDegat());
			this.setVie(this.getVie() + 2);
			System.out.println("Votre vie augmente : " + this.getVie());
		}
	}
}
