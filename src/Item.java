
public class Item extends Element{
	private String nom;
	
	public Item(int position, String nom){
		super(position);
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
		return "Item [nom=" + nom + "]";
	}
	
}
