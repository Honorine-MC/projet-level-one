import java.util.ArrayList;

public class Joueur extends Personnage {
	private ArrayList<Item> inventaire;
	private double xp;
	private double degat;
	
	public Joueur(String nom,int vie,double degat) {
		super(0,nom,vie);
		inventaire = new ArrayList<Item>();
		this.xp = 0;
		this.degat = degat;
	}

	public ArrayList<Item> getInventaire() {
		return inventaire;
	}

	public void setInventaire(ArrayList<Item> inventaire) {
		this.inventaire = inventaire;
	}

	public double getXp() {
		return xp;
	}

	public void setXp(double xp) {
		this.xp = xp;
	}

	public double getDegat() {
		return degat;
	}

	public void setDegat(double degat) {
		this.degat = degat;
	}

	@Override
	public String toString() {
		return "Joueur [inventaire=" + inventaire + ", xp=" + xp + ", degat="
				+ degat + "]";
	}	
}
