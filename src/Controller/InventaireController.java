package Controller;
import java.util.Observable;
import java.util.Observer;

import Model.Item;
import Model.Joueur;
import Model.Map;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class InventaireController implements Observer{
	private GridPane inventaire;
	private Joueur joueur;
	public InventaireController(GridPane inventaire, Joueur joueur){
		this.inventaire = inventaire;
		this.joueur = joueur;
	}
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		/*Partie inventaire*/

		if(joueur.getInventaire().size() > 0){
			for(int i=0; i<joueur.getInventaire().size(); i++){
				Rectangle carreItem = new Rectangle(0,0,30,30);
				carreItem.setFill(Color.WHITE);
				carreItem.setStroke(Color.BLACK);
				Image imageItem = new Image(joueur.getInventaire().get(i).getImage());
				carreItem.setFill(new ImagePattern(imageItem));				
				GridPane caseItem = new GridPane();
				caseItem.getChildren().add(carreItem);
				inventaire.add(caseItem,i,6);
			}
			for(int j= joueur.getInventaire().size() ; j< 5 ; j++){  
				Rectangle carreItem = new Rectangle(0,0,30,30);
				carreItem.setFill(Color.WHITE);
				carreItem.setStroke(Color.BLACK); 
				GridPane caseItem = new GridPane();
				caseItem.getChildren().add(carreItem);
				inventaire.add(caseItem,j,6);
			}
		}
		else{
			for(int i=0; i<5;i++){
				Rectangle carreNo = new Rectangle(0,0,30,30);
				carreNo.setFill(Color.WHITE);
				carreNo.setStroke(Color.BLACK);
				GridPane caseGridPaneNo = new GridPane();
				caseGridPaneNo.getChildren().add(carreNo);
				inventaire.add(caseGridPaneNo, i, 6);
				
			}
		}
	}
}
