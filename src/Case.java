
public class Case {
	private Element element;
	private int position ;
	
	/*Constructeur*/
	public Case(Element e, int pos){
		this.element = e;
		this.position = pos;
		this.element.setPosition(this.getPosition());
		
	}
	
	/*Getter setter*/
	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	/*toString*/
	@Override
	public String toString() {
		return "Case [element=" + element.toString() + "]";
	}
	
	
}
