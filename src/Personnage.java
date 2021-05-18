
public class Personnage extends Element{
	private String nom;
	private double vie;
	
	/*Constructeur*/
	public Personnage(int posX, int posY, String nom, double vie){
		super(posX, posY);
		this.nom = nom;
		this.vie = vie;
	}
	
	/*Getter et setter*/
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getVie() {
		return vie;
	}

	public void setVie(double vie) {
		this.vie = vie;
	}

	/*ToString*/
	public String toString() {
		return "Personnage [nom=" + nom + ", vie=" + vie + "]";
	}
	
	
	

}
