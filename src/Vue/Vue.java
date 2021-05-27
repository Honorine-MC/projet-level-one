package Vue;

import Controller.InventaireController;
import Controller.MapController;
import Model.Case;
import Model.Element;
import Model.Joueur;
import Model.Map;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Vue extends Application{
	private Map map = new Map(8,8);
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		try{
			VBox root = new VBox();
			Scene scene = new Scene(root,1000,900);
			scene.setFill(Color.CADETBLUE);
			
			map.init();
			
			/* Affichage du Joueur, de son nom, de sa vie, de son xp */
			BorderPane bp = new BorderPane();
			bp.setPadding(new Insets(0, 0, 0, 700));
			root.getChildren().add(bp);

			Text t= new Text();
			t.setText(this.map.joueur.getNom());
			t.setFont(Font.font ("Verdana", 40));
			t.setFill(Color.WHITE);
			bp.setTop(t);
			
			Text vieText= new Text();
			double vie = this.map.joueur.getVie();
			vieText.setText("Vie : "+String.valueOf(vie));
			vieText.setFont(Font.font ("Verdana", 20));
			vieText.setFill(Color.BLACK);
			bp.setLeft(vieText);
			
			Text xpText= new Text();
			double xp = this.map.joueur.getXp();
			xpText.setText("Xp : "+String.valueOf(xp));
			xpText.setFont(Font.font ("Verdana", 20));
			xpText.setFill(Color.BLACK);
			bp.setBottom(xpText);
			
			
			Rectangle icone = new Rectangle(0,0,30,30);
			icone.setStroke(Color.BLACK);
			Image imageicone = new Image(this.map.joueur.getImage());
			icone.setFill(new ImagePattern(imageicone));
			bp.setCenter(icone);
			
			
			
			/* Affichage de la "console" */
			
			BorderPane b = new BorderPane();
			b.setPadding(new Insets(20, 0, 0, 700));
			root.getChildren().add(b);
			
			Text consoleText= new Text();
			consoleText.setText("bienvenu");
			consoleText.setFont(Font.font ("Verdana", 20));
			consoleText.setFill(Color.WHITE);
			b.setTop(consoleText);
			
		
			/*Affichage de la Map */
			GridPane plateau = new GridPane();
			plateau.setPadding(new Insets(0, 0, 0, 20));
			plateau.setMinSize(300, 300);
			 
			root.getChildren().add(plateau);
			
			
			Case[][] plateauTab = map.plateau;
			
			final Joueur joueur = map.joueur;
		
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
					inventaire.add(caseGridPane,i,6);
					
					Text text= new Text();
					text.setText(Integer.toString(i));
					text.setFont(Font.font("Verdana",20));
					text.setFill(Color.WHITE);
					inventaire.add(text,i,7);
									
				}
			}
			else{
				for(int i=0; i<5;i++){
					Rectangle carre = new Rectangle(0,0,30,30);
					carre.setFill(Color.WHITE);
					carre.setStroke(Color.BLACK);
					GridPane caseGridPane = new GridPane();
					caseGridPane.getChildren().add(carre);
					inventaire.add(caseGridPane, i, 6);
					
					Text text= new Text();
					text.setText(Integer.toString(i));
					text.setFont(Font.font("Verdana",20));
					text.setFill(Color.WHITE);
					inventaire.add(text,i,7);
				}
			}
						
			/*Controller*/
			MapController mc = new MapController(plateau,this.map);
			this.map.addObserver(mc);
			
			InventaireController ic = new InventaireController(inventaire,this.map.joueur);
			this.map.joueur.addObserver(ic);
			
			/*Fin Controller*/
			
			primaryStage.setTitle("LEVEL ONE");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			/*Partie lecture clavier*/
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            
	            public void handle(KeyEvent event) {
	                if (event.getCode() == KeyCode.RIGHT) {
	                    map.deplacerJoueur(joueur.getPositionX()+1,joueur.getPositionY());
	                }
	                if (event.getCode() == KeyCode.LEFT) {
	                    map.deplacerJoueur(joueur.getPositionX()-1,joueur.getPositionY());
	                }
	                if (event.getCode() == KeyCode.UP) {
	                    map.deplacerJoueur(joueur.getPositionX(),joueur.getPositionY()-1);
	                }
	                if (event.getCode() == KeyCode.DOWN) {
	                    map.deplacerJoueur(joueur.getPositionX(),joueur.getPositionY()+1);
	                }
	                if(event.getCode() == KeyCode.NUMPAD0){
	                	joueur.utiliser(joueur.getInventaire().get(0));
	                	System.out.println("Objet utiliser");
	                }
	                if(event.getCode() == KeyCode.NUMPAD1){
	                	joueur.utiliser(joueur.getInventaire().get(1));
	                	System.out.println("Objet utiliser");
	                }
	                if(event.getCode() == KeyCode.NUMPAD2){
	                	joueur.utiliser(joueur.getInventaire().get(2));
	                	System.out.println("Objet utiliser");
	                }
	                if(event.getCode() == KeyCode.NUMPAD3){
	                	joueur.utiliser(joueur.getInventaire().get(3));
	                	System.out.println("Objet utiliser");
	                }
	                if(event.getCode() == KeyCode.NUMPAD4){
	                	joueur.utiliser(joueur.getInventaire().get(4));
	                	System.out.println("Objet utiliser");
	                }
	                
	                
	            }
	        });
			/*Fin Partie lecture clavier*/
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args) ;
	}
}
