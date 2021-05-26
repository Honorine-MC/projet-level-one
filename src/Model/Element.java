package Model;

import java.util.Observable;

public class Element extends Observable{
	private int positionX;
	private int positionY;
	private String image;

	
	/*Constructeur*/
	public Element(int posX, int posY,String image){
		this.positionX = posX;
		this.positionY = posY;
		this.image = image;
	}

	public Element(){
		
	}
	/*Getter et setter*/
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
		this.setChanged();
		this.notifyObservers();
	}
	
	/*Getter et setter*/
	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
		this.setChanged();
		this.notifyObservers();
	}
	
	public String getImage(){
		return image;
	}
	
	public String toTsring(){
		return "Element de type : ";
	}
	
}
