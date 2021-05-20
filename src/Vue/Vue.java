package Vue;

import javafx.application.Application;
import javafx.stage.Stage;
import Model.Joueur;
import Model.Map;

public class Vue extends Application{
	private Map map = new Map(8,8);
	
	@Override
	public void start(Stage stage) throws Exception{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args) ;
	}
	
	//Joueur j = this.map.plateau[0][0].getElement();
	
	//JoueurController jc = new JoueurController(...)
	
	//j.addObserver(jc);
	
	//this.addListner(jc);
}
