package Vue;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CaseVue extends GridPane{
	Rectangle carre = new Rectangle(0,0,80,80);
	carre.setFill(Color.WHITE);
	carre.setStroke(Color.BLACK);
	this.getChildren().add(carre);

}
