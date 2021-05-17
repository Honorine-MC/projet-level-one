
public class Arme extends Item{
	private double degat_apporte;
	
	public Arme(int position, String nom, double degat_apporte){
		super(position,nom);
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
		return "Arme [degat_apporte=" + degat_apporte + "]";
	}
	
}
