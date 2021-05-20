package Model;


public class Case {
	private Element element;
	private int positionX ;
	private int positionY ;
	
	/*Constructeur*/
	public Case(Element e, int posX, int posY){
		this.element = e;
		this.positionX = posX;
		this.positionY = posY;
		//this.element.setPositionX(this.getPositionX());
		//this.element.setPositionY(this.getPositionY());
		
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
