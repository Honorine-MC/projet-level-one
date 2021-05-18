import java.util.ArrayList;


public class Pnj extends Personnage{
	private Item item;
	private double xp_apporte;
	
	/*Constructeur*/
	public Pnj(int posX, int posY, String nom,Item i, double xp_apporte){
	  super(posX,posY,nom,10);
	  this.item = i;
	  this.xp_apporte = xp_apporte;
	}

	/*Getter et setter*/
	public Item getItem() {
		return item;
	}

	public void setItem(Item i) {
		this.item = i;
	}

	public double getXp_apporte() {
		return xp_apporte;
	}

	public void setXp_apporte(double xp_apporte) {
		this.xp_apporte = xp_apporte;
	}

	/*ToString*/
	@Override
	public String toString() {
		return "Pnj [i=" + item + ", xp_apporte=" + xp_apporte + "]";
	}
	
	public void donnerUnItem(Item i, Joueur j) {
		ArrayList<Item> inventaire = j.getInventaire();
		inventaire.add(this.getItem());	
		j.setInventaire(inventaire);
	}
	
}
