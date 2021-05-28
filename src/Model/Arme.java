package Model;


public class Arme extends Item{
	private double degat_apporte;
	
	//Constructeur
	public Arme(int posX, int posY, String nom, double degat_apporte){
		super(posX, posY,"Vue/arme.png",nom);
		this.degat_apporte=degat_apporte;
	}

	public double getDegat_apporte() {
		return degat_apporte;
	}

	public void setDegat_apporte(double degat_apporte) {
		this.degat_apporte = degat_apporte;
	}

	@Override
	public String toString() {
		return "arme qui te donne " + degat_apporte +" de degat en plus";
	}
	
}
