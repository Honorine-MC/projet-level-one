public class Obstacle extends Element {
	private boolean ouvert;
	
	/*Constructor*/
	public Obstacle(int pos, boolean ouvert){
		super(pos);
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