package Controller;

import java.util.Observable;
import java.util.Observer;

import Model.Joueur;
import Model.Map;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class MapController implements EventHandler<KeyEvent>, Observer{
	private Map map;
	private Joueur joueur;
	private String imageJoueur;
	public MapController(Map m){
		this.map = m;
//		this.joueur=j;
//		this.imageJoueur = imageJoueur;
	}
	
	
	public void update(Observable arg0, Object arg1) {
		// TODO mise des coordonnees de l'IMage View
		
	}

	public void handle(KeyEvent arg0) {
		// TODO methode equivalent de change (press clavier)
		
	}

}
