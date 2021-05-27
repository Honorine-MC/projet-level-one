package Controller;

import java.util.Observable;
import java.util.Observer;

import Model.Map;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MapController implements Observer{
	Map map;
	private GridPane gp;
	private BorderPane bp;
	public MapController(GridPane grid, Map map,BorderPane bp){
		this.gp = grid;
		this.map=map;
		this.bp = bp;
	}
	
	
	public void update(Observable arg0, Object arg1) {
		// TODO mise des coordonnees de l'IMage View
		int[] currentPos = (int[]) arg1;
	
		/*Effacer joueur de case precedente*/
		Rectangle carre = new Rectangle(0,0,80,80);
		carre.setFill(Color.WHITE);
		carre.setStroke(Color.BLACK);
		
		GridPane caseGridPane = new GridPane();
		caseGridPane.getChildren().add(carre);
		this.gp.add(caseGridPane, currentPos[0], currentPos[1]);
		
		/*Replacer joueur sur case suivante*/
		Rectangle carreArrivee = new Rectangle(0,0,80,80);
		carreArrivee.setStroke(Color.BLACK);
		
		GridPane caseGridPaneArrivee = new GridPane();
		Image image = new Image(this.map.joueur.getImage());
		carreArrivee.setFill(new ImagePattern(image));
		
		caseGridPaneArrivee.getChildren().add(carreArrivee);
		this.gp.add(caseGridPaneArrivee, this.map.joueur.getPositionX(),this.map.joueur.getPositionY());
		
		
		
	}
}
