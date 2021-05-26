package Vue;

import java.awt.Label;
import java.util.ArrayList;

import Controller.MapController;
import Model.Case;
import Model.Element;
import Model.Item;
import Model.Joueur;
import Model.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Vue extends Application{
	private Map map = new Map(8,8);
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		try{
			VBox root = new VBox();
			Scene scene = new Scene(root,1000,800);
			scene.setFill(Color.CADETBLUE);
			
			GridPane plateau = new GridPane();
			plateau.setPadding(new Insets(40, 40, 40, 40));
			plateau.setMinSize(300, 300);
//			plateau.setVgap(5);
//			plateau.setHgap(5);
			 
			root.getChildren().add(plateau);
			
			map.init();
			
			Case[][] plateauTab = map.plateau;
			
			
			for(int i=0; i<8; i++){
				for(int j=0; j<8;j++){
					Rectangle carre = new Rectangle(0,0,80,80);
					
					carre.setFill(Color.WHITE);
					carre.setStroke(Color.BLACK);
									
					if(plateauTab[i][j].getElement() instanceof Element){
						Image image = new Image(plateauTab[i][j].getElement().getImage());
						carre.setFill(new ImagePattern(image));
					}
					GridPane caseGridPane = new GridPane();
					caseGridPane.getChildren().add(carre);
					plateau.add(caseGridPane, i, j);
				}
			}
					
			
			
	
			/* Affichage de l'inventaire*/

			Joueur joueur = map.joueur;
			GridPane inventaire = new GridPane();
			root.getChildren().add(inventaire);
			inventaire.setPadding(new Insets(40, 40, 40, 800));
			
			if(joueur.getInventaire().size() > 0){
				for(int i=0 ; i< joueur.getInventaire().size(); i++ ){
					Rectangle carre = new Rectangle(0,0,30,30);
					carre.setFill(Color.WHITE);
					carre.setStroke(Color.BLACK);
					Image image = new Image(joueur.getInventaire().get(i).getImage());
					carre.setFill(new ImagePattern(image));				
					GridPane caseGridPane = new GridPane();
					caseGridPane.getChildren().add(carre);
					inventaire.add(caseGridPane,i,10);
	
				}
			}
			else{
				for(int i=0; i<5;i++){
					Rectangle carre = new Rectangle(0,0,30,30);
					carre.setFill(Color.WHITE);
					carre.setStroke(Color.BLACK);
					GridPane caseGridPane = new GridPane();
					caseGridPane.getChildren().add(carre);
					inventaire.add(caseGridPane, i, 10);
					
				}
			}
			
			/*Controller*/
			MapController mc = new MapController(this.map);
			this.map.addObserver(mc);
			//this.addListner(mc);
			
			
			primaryStage.setTitle("LEVEL ONE");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args) ;
	}
	
	//Joueur j = this.map.plateau[0][0].getElement();
	
	//JoueurController jc = new JoueurController(...)
	
	//j.addObserver(jc);
	
	//this.addListner(mc);
}
