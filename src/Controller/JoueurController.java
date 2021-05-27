package Controller;

import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import Model.Joueur;

public class JoueurController implements Observer{
	private Joueur joueur;
	private BorderPane bp ;
	public JoueurController(Joueur j, BorderPane bp){
		this.joueur = j;
		this.bp=bp;
	}

	public void update(Observable arg0, Object arg1) {
		/*Partie maj vie et degat et xp*/
		Text vieText= new Text();
		double vie = this.joueur.getVie();
		vieText.setText("Vie : "+String.valueOf(vie));
		vieText.setFont(Font.font ("Verdana", 20));
		vieText.setFill(Color.BLACK);
		bp.setLeft(vieText);
		
		Text xpText= new Text();
		double xp = this.joueur.getXp();
		xpText.setText("Xp : "+String.valueOf(xp));
		xpText.setFont(Font.font ("Verdana", 20));
		xpText.setFill(Color.BLACK);
		bp.setBottom(xpText);
		
		Text degatText= new Text();
		double degat = this.joueur.getDegat();
		degatText.setText("Degat : "+String.valueOf(degat));
		degatText.setFont(Font.font ("Verdana", 20));
		degatText.setFill(Color.BLACK);
		bp.setCenter(degatText);
		
	}

}
