package Model;


public class Monstre extends Personnage {
	private double xp_apporte;
	private double degat_inflige;
	
	/*Constructeur*/
	public Monstre(int posX, int posY,String nom, double xp_apporte, double degat_inflige){
		super(posX, posY,"Vue/monstre.png",nom,10);
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
		return super.toString() + "Monstre [xp_apporte=" + xp_apporte + ", degat_inflige="
				+ degat_inflige + "]";
	}
	
	/**
	 * Function -> Attaquer un joueur
	 * @param j : represente le joueur attaqu?
	 */
	public void attaquer( Joueur j){
		j.setVie(j.getVie()-this.getDegat_inflige());
	}
	
	/**
	 * Function : boolean -> Renvois true si le monstre est battu
	 */
	public boolean estVaincu(){
		boolean res = false;
		if(this.getVie()<=0){
			res = true;
		}
		return res;
	}
	
}
