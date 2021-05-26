package Model;

public class Case{
	
	private int positionX ;
	private int positionY ;
	
	private Element element;
	
	/*Constructeurs*/
	
	public Case(int x, int y){
		this.positionX = x;
		this.positionY = y;
		this.element = null;
	}
	
	
	public Case(int posX, int posY, Element e){
		this.positionX = posX;
		this.positionY = posY;
		this.element = e;
	}
	

	
	/*Getter setter*/
	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	/*toString*/
	@Override
	public String toString() {
		return "Case [element=" + element.toString() + "]";
	}
	
	
}
