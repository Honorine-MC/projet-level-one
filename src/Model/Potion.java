package Model;


public class Potion extends Item {
	private double vie_apporte;
	
	//Constructeur
	public Potion(int posX, int posY, String nom,double vie_apporte){
		super(posX, posY,"Vue/potion.png",nom);
		this.vie_apporte = vie_apporte;		
	}

	public double getVie_apporte() {
		return vie_apporte;
	}

	public void setVie_apporte(double vie_apporte) {
		this.vie_apporte = vie_apporte;
	}

	@Override
	public String toString() {
		return "Potion [vie_apporte=" + vie_apporte + "]";
	}
	
}
