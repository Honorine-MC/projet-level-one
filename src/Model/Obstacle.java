package Model;

public class Obstacle extends Element {
	private boolean ouvert;
	
	/*Constructor*/
	public Obstacle(int posX, int posY, boolean ouvert){
		super(posX, posY);
		this.ouvert = ouvert;
	}
	
	
	/*Getter*/
	public boolean isOuvert() {
		return ouvert;
	}

	/*Setter*/
	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
	}

}