package Model;

public class Clef extends Item{

	public Clef(int posX, int posY, String nom) {
		super(posX, posY, "Vue/clef.png", nom);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "une clé qui te permettra d'ouvrir toutes les portes";
	}
}
