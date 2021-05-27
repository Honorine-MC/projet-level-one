package Controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TexteController implements Observer{
	private BorderPane b;
	public TexteController(BorderPane b){
		this.b=b;
	}
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		BorderPane b = this.b;
		Text consoleText= new Text();
		consoleText.setText((String) arg1);
		consoleText.setFont(Font.font ("Verdana", 20));
		consoleText.setFill(Color.WHITE);
		b.setTop(consoleText);
		
	}

}
