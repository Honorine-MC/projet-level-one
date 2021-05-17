
public class Monstre extends Personnage {
	private double xp_apporte;
	private double degat_inflige;
	
	/*Constructeur*/
	public Monstre(int position,String nom, double xp_apporte, double degat_inflige){
		super(position,nom,10);
		this.xp_apporte =xp_apporte;
		this.degat_inflige = degat_inflige;
	}

	/*Getter et setter*/
	public double getXp_apporte() {
		return xp_apporte;
	}

	public void setXp_apporte(double xp_apporte) {
		this.xp_apporte = xp_apporte;
	}

	public double getDegat_inflige() {
		return degat_inflige;
	}

	public void setDegat_inflige(double degat_inflige) {
		this.degat_inflige = degat_inflige;
	}

	@Override
	/*ToString*/
	public String toString() {
		return "Monstre [xp_apporte=" + xp_apporte + ", degat_inflige="
				+ degat_inflige + "]";
	}
	
}
