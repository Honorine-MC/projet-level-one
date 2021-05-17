
public class Pnj extends Personnage{
	private Item i;
	private double xp_apporte;
	
	/*Constructeur*/
	public Pnj(int position, String nom,double vie,Item i, double xp_apporte){
	  super(position,nom,vie);
	  this.i = i;
	  this.xp_apporte = xp_apporte;
	}

	/*Getter et setter*/
	public Item getI() {
		return i;
	}

	public void setI(Item i) {
		this.i = i;
	}

	public double getXp_apporte() {
		return xp_apporte;
	}

	public void setXp_apporte(double xp_apporte) {
		this.xp_apporte = xp_apporte;
	}

	/*ToString*/
	@Override
	public String toString() {
		return "Pnj [i=" + i + ", xp_apporte=" + xp_apporte + "]";
	}
	
}
