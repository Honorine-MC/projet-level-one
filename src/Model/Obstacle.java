package Model;

public class Obstacle extends Element {
	private boolean ouvert;
	
	/*Constructor*/
	public Obstacle(int posX, int posY,String image,boolean ouvert){
		super(posX, posY,image);
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