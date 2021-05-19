package Model;

import java.util.Observable;

public class Element extends Observable{
	private int positionX;
	private int positionY;
	
	/*Constructeur*/
	public Element(int posX, int posY){
		this.positionX = posX;
		this.positionY = posY;
	}

	public Element() {
		
	}

	/*Getter et setter*/
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	/*Getter et setter*/
	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public String toTsring(){
		return "Element de type : ";
	}
	
}
