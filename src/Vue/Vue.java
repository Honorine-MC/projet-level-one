package Vue;

import Controller.InventaireController;
import Controller.JoueurController;
import Controller.MapController;
import Controller.TexteController;
import Model.Case;
import Model.Element;
import Model.Joueur;
import Model.Map;
import Model.Porte;
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
			bp.setRight(icone);
			
			Text degatText= new Text();
			double degat = this.map.joueur.getDegat();
			degatText.setText("Degat : "+String.valueOf(degat));
			degatText.setFont(Font.font ("Verdana", 20));
			degatText.setFill(Color.BLACK);
			bp.setCenter(degatText);
			
			
			
			
			/* Affichage de la "console" */
			
			BorderPane b = new BorderPane();
			b.setPadding(new Insets(20, 0, 0, 700));
			root.getChildren().add(b);
			
			Text consoleText= new Text();
			consoleText.setText("bienvenue");
			consoleText.setFont(Font.font ("Verdana", 20));
			consoleText.setFill(Color.WHITE);
			b.setTop(consoleText);
			
		
			/*Affichage de la Map */
			final GridPane plateau = new GridPane();
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
						if(plateauTab[i][j].getElement() instanceof Porte){
							Porte p = (Porte)plateauTab[i][j].getElement();
							if(p.isOuvert()){
								Image imagePorteOuverte = new Image("Vue/porte_ouverte.png");
								carre.setFill(new ImagePattern(imagePorteOuverte));
							}
						}
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
			MapController mc = new MapController(plateau,this.map,bp);
			this.map.addObserver(mc);
			
			InventaireController ic = new InventaireController(inventaire,this.map.joueur);
			this.map.joueur.addObserver(ic);
			
			JoueurController jc = new JoueurController(this.map.joueur,bp);
			this.map.joueur.addObserver(jc);
			
			TexteController tc = new TexteController(b);
//			this.map.addObserver(tc);
//			this.map.joueur.addObserver(tc);
			/*Fin Controller*/
			
			primaryStage.setTitle("LEVEL ONE");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			/*Partie lecture clavier*/
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            
	            public void handle(KeyEvent event) {
	            	/*Lecture Clavier pour deplacement*/
	                if (event.getCode() == KeyCode.RIGHT) {
	    				if(joueur.getPositionX() != 7) {
	    					/*Verifie si il y a une porte*/
	    					if(map.plateau[joueur.getPositionX()+1][joueur.getPositionY()].getElement() instanceof Porte){
	    						Porte p = (Porte)map.plateau[joueur.getPositionX()+1][joueur.getPositionY()].getElement();
	    						/*On verifie mtn si la porte est ouverte*/
	    						if(p.isOuvert()==true){
	    							map.deplacerJoueur(joueur.getPositionX()+2,joueur.getPositionY());//saute 2 case
	    						}
	    						/*Si on possede une clef*/
	    						else if(p.isOuvert()==false && map.joueur.haveKey()){
	    							/*Mise a jour graphique : ouvrir porte*/
	    							Rectangle carre = new Rectangle(0,0,80,80);
	    							carre.setFill(Color.WHITE);
	    							carre.setStroke(Color.BLACK);
	    							Image imagePorteOuverte = new Image("Vue/porte_ouverte.png");
									carre.setFill(new ImagePattern(imagePorteOuverte));
									GridPane caseGridPane = new GridPane();
									caseGridPane.getChildren().add(carre);
	    							plateau.add(caseGridPane,joueur.getPositionX()+1,joueur.getPositionY());
	    							
	    							/*Mise a jour Model : ouvrir porte*/
	    							p.setOuvert(true);
	    							map.plateau[joueur.getPositionX()+1][joueur.getPositionY()].setElement(p);
	    							map.deplacerJoueur(joueur.getPositionX()+2,joueur.getPositionY());
	    						}
	    					}
	    					else{
	    						map.deplacerJoueur(joueur.getPositionX()+1,joueur.getPositionY());
	    					}
	    				}
	                }
	                if (event.getCode() == KeyCode.LEFT) {
	    				if(joueur.getPositionX() != 0) {
	    					if(map.plateau[joueur.getPositionX()-1][joueur.getPositionY()].getElement() instanceof Porte){
	    						Porte p = (Porte)map.plateau[joueur.getPositionX()-1][joueur.getPositionY()].getElement();
	    						if(p.isOuvert()==true){
	    							map.deplacerJoueur(joueur.getPositionX()-2,joueur.getPositionY());
	    						}
	    						else if(p.isOuvert()==false && map.joueur.haveKey()){
	    							/*Mise a jour graphique : ouvrir porte*/
	    							Rectangle carre = new Rectangle(0,0,80,80);
	    							carre.setFill(Color.WHITE);
	    							carre.setStroke(Color.BLACK);
	    							Image imagePorteOuverte = new Image("Vue/porte_ouverte.png");
									carre.setFill(new ImagePattern(imagePorteOuverte));
									GridPane caseGridPane = new GridPane();
									caseGridPane.getChildren().add(carre);
	    							plateau.add(caseGridPane,joueur.getPositionX()-1,joueur.getPositionY());
	    							
	    							/*Mise a jour Model : ouvrir porte*/
	    							p.setOuvert(true);
	    							map.plateau[joueur.getPositionX()-1][joueur.getPositionY()].setElement(p);
	    							map.deplacerJoueur(joueur.getPositionX()-2,joueur.getPositionY());
	    						}
	    					}
	    					else{
	    						map.deplacerJoueur(joueur.getPositionX()-1,joueur.getPositionY());
	    					}
	    				}
	    			}
	                if (event.getCode() == KeyCode.UP) {
	    				if(joueur.getPositionY() != 0) {
	    					if(map.plateau[joueur.getPositionX()][joueur.getPositionY()-1].getElement() instanceof Porte){
	    						Porte p = (Porte)map.plateau[joueur.getPositionX()][joueur.getPositionY()-1].getElement();
	    						if(p.isOuvert()==true){
	    							map.deplacerJoueur(joueur.getPositionX(),joueur.getPositionY()-2);
	    						}
	    						else if(p.isOuvert()==false && map.joueur.haveKey()){
	    							/*Mise a jour graphique : ouvrir porte*/
	    							Rectangle carre = new Rectangle(0,0,80,80);
	    							carre.setFill(Color.WHITE);
	    							carre.setStroke(Color.BLACK);
	    							Image imagePorteOuverte = new Image("Vue/porte_ouverte.png");
									carre.setFill(new ImagePattern(imagePorteOuverte));
									GridPane caseGridPane = new GridPane();
									caseGridPane.getChildren().add(carre);
	    							plateau.add(caseGridPane,joueur.getPositionX(),joueur.getPositionY()-1);
	    							
	    							/*Mise a jour Model : ouvrir porte*/
	    							p.setOuvert(true);
	    							map.plateau[joueur.getPositionX()][joueur.getPositionY()-1].setElement(p);
			    					map.deplacerJoueur(joueur.getPositionX(),joueur.getPositionY()-2);
	    						}
	    					}
	    					else{
		    					map.deplacerJoueur(joueur.getPositionX(),joueur.getPositionY()-1);
	    					}
	    				}
	                }
	                if (event.getCode() == KeyCode.DOWN) {
	    				if(joueur.getPositionY() != 7) {
	    					if(map.plateau[joueur.getPositionX()][joueur.getPositionY()+1].getElement() instanceof Porte){
	    						Porte p = (Porte)map.plateau[joueur.getPositionX()][joueur.getPositionY()+1].getElement();
	    						if(p.isOuvert()==true){
	    							map.deplacerJoueur(joueur.getPositionX(),joueur.getPositionY()+2);
	    						}
	    						else if(p.isOuvert()==false && map.joueur.haveKey()){
	    							/*Mise a jour graphique : ouvrir porte*/
	    							Rectangle carre = new Rectangle(0,0,80,80);
	    							carre.setFill(Color.WHITE);
	    							carre.setStroke(Color.BLACK);
	    							Image imagePorteOuverte = new Image("Vue/porte_ouverte.png");
									carre.setFill(new ImagePattern(imagePorteOuverte));
									GridPane caseGridPane = new GridPane();
									caseGridPane.getChildren().add(carre);
	    							plateau.add(caseGridPane,joueur.getPositionX(),joueur.getPositionY()+1);
	    							
	    							/*Mise a jour Model : ouvrir porte*/
	    							p.setOuvert(true);
	    							map.plateau[joueur.getPositionX()][joueur.getPositionY()+1].setElement(p);
			    					map.deplacerJoueur(joueur.getPositionX(),joueur.getPositionY()+2);
	    						}
	    					}
	    					else{
		    					map.deplacerJoueur(joueur.getPositionX(),joueur.getPositionY()+1);
	    					}
	    				}
	                }
	                
	                /*Lecture Clavier pour inventaire*/
	                if(event.getCode() == KeyCode.NUMPAD0){
	                	joueur.utiliser(joueur.getInventaire().get(0));
	                }
	                if(event.getCode() == KeyCode.NUMPAD1){
	                	joueur.utiliser(joueur.getInventaire().get(1));
	                }
	                if(event.getCode() == KeyCode.NUMPAD2){
	                	joueur.utiliser(joueur.getInventaire().get(2));
	                }
	                if(event.getCode() == KeyCode.NUMPAD3){
	                	joueur.utiliser(joueur.getInventaire().get(3));
	                }
	                if(event.getCode() == KeyCode.NUMPAD4){
	                	joueur.utiliser(joueur.getInventaire().get(4));
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
