
public class Potion extends Item {
	private double vie_apporte;
	
	public Potion(int position, String nom,double vie_apporte){
		super(position,nom);
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
