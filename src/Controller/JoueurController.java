package Controller;

import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import Model.Joueur;

public class JoueurController implements EventHandler<KeyEvent>, Observer{
	private Joueur j;
	public JoueurController(Joueur j){ /* 2eme PAram : ImageView joueurIHM*/
		this.j = j;
	}

	public void update(Observable arg0, Object arg1) {
		// TODO mise des coordonnees de l'IMage View
		
	}

	public void handle(KeyEvent arg0) {
		// TODO methode equivalent de change (press clavier)
		
	}
}
