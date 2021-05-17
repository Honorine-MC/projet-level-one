
public abstract class Element {
	private double position;
	
	/*Constructeur*/
	public Element(double pos){
		this.position = pos;
	}

	/*Getter et setter*/
	public double getPosition() {
		return position;
	}

	public void setPosition(double position) {
		this.position = position;
	}
	
}
