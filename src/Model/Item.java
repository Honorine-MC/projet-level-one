package Model;


public class Item extends Element{
	private String nom;
	
	public Item(int posX, int posY, String image,String nom){
		super(posX, posY,image);
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return " Item [nom=" + nom + "]";
	}
	
}
