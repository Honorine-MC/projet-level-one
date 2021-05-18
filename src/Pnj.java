
public class Pnj extends Personnage{
	private Item item;
	private double xp_apporte;
	
	/*Constructeur*/
	public Pnj(int position, String nom,Item i, double xp_apporte){
	  super(position,nom,10);
	  this.item = i;
	  this.xp_apporte = xp_apporte;
	}

	/*Getter et setter*/
	public Item getItem() {
		return item;
	}

	public void setItem(Item i) {
		this.item = i;
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
		return "Pnj [i=" + item + ", xp_apporte=" + xp_apporte + "]";
	}
	
}
