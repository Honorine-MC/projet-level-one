package Model;
import java.util.ArrayList;
import java.util.Observable;

public class Map extends Observable{
	
	/*Attributs*/
	public Joueur joueur;
	public Monstre m;
	public int nbLig;
	public int nbCol;
	public Case [][] plateau;
	public String message = new String("");
	int[] couplePosition = new int[2];
	String[] infoObserver = new String[3];
	
	/*Constructeur*/
	public Map(int n, int p) {
		nbLig = n;
		nbCol = p;
		this.plateau = new Case[nbCol][nbLig];
	}
	
	/**
	 * Method : void -> Initialise une Map en placeant différents élements à la main
	 */
	public void init(){
		/*On place les case vide avec leur positions*/
		System.out.println();
		for(int i = 0; i<nbLig; i++) {
			for(int j = 0; j<nbCol; j++) {
				this.plateau[i][j] = new Case(i,j,null);
			}
		}
		/*On place le joueur au debut de la Map*/
		this.joueur = new Joueur("Riyad Mahrez",3,3);
		this.plateau[this.joueur.getPositionX()][this.joueur.getPositionY()].setElement(this.joueur);
		
		/*Placement des murs*/
		Obstacle mur1 = new Mur(1,0,false);
		this.plateau[1][0].setElement(mur1);
		Obstacle mur2 = new Mur(2,0,false);
		this.plateau[2][0].setElement(mur2);
		Obstacle mur3 = new Mur(4,0,false);
		this.plateau[4][0].setElement(mur3);
		Obstacle mur4 = new Mur(6,0,false);
		this.plateau[6][0].setElement(mur4);
		Obstacle mur5 = new Mur(7,0,false);
		this.plateau[7][0].setElement(mur5);
		Obstacle mur6 = new Mur(1,1,false);
		this.plateau[1][1].setElement(mur6);
		Obstacle mur7 = new Mur(2,1,false);
		this.plateau[2][1].setElement(mur7);
		Obstacle mur8 = new Mur(4,1,false);
		this.plateau[4][1].setElement(mur8);
		Obstacle mur9 = new Mur(4,2,false);
		this.plateau[4][2].setElement(mur9);
		Obstacle mur10 = new Mur(6,2,false);
		this.plateau[6][2].setElement(mur10);
		Obstacle mur11 = new Mur(0,3,false);
		this.plateau[0][3].setElement(mur11);
		Obstacle mur12 = new Mur(1,3,false);
		this.plateau[1][3].setElement(mur12);
		Obstacle mur13 = new Mur(2,3,false);
		this.plateau[2][3].setElement(mur13);
		Obstacle mur14 = new Mur(4,3,false);
		this.plateau[4][3].setElement(mur14);
		Obstacle mur15 = new Mur(6,3,false);
		this.plateau[6][3].setElement(mur15);
		Obstacle mur16 = new Mur(0,4,false);
		this.plateau[0][4].setElement(mur16);
		Obstacle mur17 = new Mur(4,4,false);
		this.plateau[4][4].setElement(mur17);
		Obstacle mur18 = new Mur(6,4,false);
		this.plateau[6][4].setElement(mur18);
		Obstacle mur19 = new Mur(0,5,false);
		this.plateau[0][5].setElement(mur19);
		Obstacle mur20 = new Mur(4,5,false);
		this.plateau[4][5].setElement(mur20);
		Obstacle mur21 = new Mur(6,5,false);
		this.plateau[6][5].setElement(mur21);
		Obstacle mur22 = new Mur(0,6,false);
		this.plateau[0][6].setElement(mur22);
		Obstacle mur23 = new Mur(6,6,false);
		this.plateau[6][6].setElement(mur23);
		Obstacle mur24 = new Mur(0,7,false);
		this.plateau[0][7].setElement(mur24);
		Obstacle mur25 = new Mur(1,7,false);
		this.plateau[1][7].setElement(mur25);
		Obstacle mur26 = new Mur(3,7,false);
		this.plateau[3][7].setElement(mur26);
		Obstacle mur27 = new Mur(5,7,false);
		this.plateau[5][7].setElement(mur27);
		Obstacle mur28 = new Mur(6,7,false);
		this.plateau[6][7].setElement(mur28);
		Obstacle mur29 = new Mur(5,0,false);
		this.plateau[5][0].setElement(mur29);
		
		/*Placement des portes*/
		Obstacle porte1 = new Porte(3,1,true);
		this.plateau[3][1].setElement(porte1);
		Obstacle porte2 = new Porte(2,1,false);
		this.plateau[1][2].setElement(porte2);
		Obstacle porte3 = new Porte(2,5,false);
		this.plateau[2][5].setElement(porte3);
		Obstacle porte4 = new Porte(6,1,false);
		this.plateau[6][1].setElement(porte4);
		
		/*Placement de la clef */
		Item clef = new Clef(2,4,"clef");
		this.plateau[2][4].setElement(clef);
		
		/*Placement des monstres*/
		Personnage monstre1 = new Monstre(5,4,"Muzan",9,2);
		this.plateau[5][4].setElement(monstre1);
		Personnage monstre2 = new Monstre(7,4,"Akaza",9,6);
		this.plateau[7][3].setElement(monstre2);
		Personnage monstre3 = new Monstre(1,7,"Hisoka",9,2);
		this.plateau[1][7].setElement(monstre3);
		
		/*Placement des ITEM*/
		Item potion1 = new Potion(3,5,"popo",10);
		this.plateau[3][5].setElement(potion1);
		
		Item arme1 = new Arme(0,6,"épée",2);
		this.plateau[0][6].setElement(arme1);
		
		/*Placement des PNJ*/
		Personnage pnj1 = new Pnj(3,0,"a",arme1,10);
		this.plateau[3][0].setElement(pnj1);
		Personnage pnj2 = new Pnj(0,0,"b",potion1,10);
		this.plateau[0][0].setElement(pnj2);
		Personnage pnj3 = new Princesse(7,4,"Princesse",potion1,10);
		this.plateau[7][4].setElement(pnj3);		
	}
	
	/**
	 * Function -> Affichage console de la map
	 */
	public void affiche(){
		for(int i =0; i<this.nbLig ; i++){
			for(int j=0; j<this.nbCol; j++){
				if(this.plateau[i][j].getElement() instanceof Monstre){
					System.out.print(" | " + "Mon");
				}
				if(this.plateau[i][j].getElement() instanceof Pnj){
					System.out.print(" | " + "pnj");
				}
				if(this.plateau[i][j].getElement() instanceof Item){
					System.out.print(" | " + "Ite");
				}
				if(this.plateau[i][j].getElement() instanceof Joueur){
					System.out.print(" | " + "Toi");
				}
				if(this.plateau[i][j].getElement() instanceof Mur){
					System.out.print(" | " + "Mur");
				}
				if(this.plateau[i][j].getElement() instanceof Porte){
					System.out.print(" | " + "Por");
				}
				if(this.plateau[i][j].getElement() instanceof Potion){
					System.out.print(" | " + "Pot");	
				}
				if(this.plateau[i][j].getElement() instanceof Arme){
					System.out.print(" | " + "Arm");	
				}
				if(this.plateau[i][j].getElement() == null){
					System.out.print(" | " + "   ");
				}
			}
			System.out.println(" | ");
		}
		System.out.println();
	}
	
	/**
	 * Function -> Autorise au non un deplacement du joueur
	 */
	public boolean deplacement_valide(int x, int y){
		boolean res = true;
		/*On verifie si la porte ou le mur est traversable*/
		if(this.plateau[x][y].getElement() instanceof Mur || this.plateau[x][y].getElement() instanceof Porte){
			Obstacle o = (Obstacle)this.plateau[x][y].getElement();
			if(!o.isOuvert()){
				res = false;
				System.out.println("Vous ne pouvez pas passer cet obstacle !");
				this.message = "Vous ne pouvez pas passer cet obstacle !";
				this.infoObserver[2] = this.message;
				this.setChanged();
				this.notifyObservers(this.infoObserver);
			}
		}
		
		if(this.plateau[x][y].getElement() instanceof Porte){
			
			Porte p = (Porte) this.plateau[x][y].getElement();
			boolean haveKey = false;
			for(Item i : this.joueur.getInventaire()){
				if(i instanceof Clef){
					haveKey = true;
				}
			}
			if(!p.isOuvert() && haveKey==false){
				res = false;
				System.out.println("Il te faut une clef Ryad");
				this.message = "Il te faut une clef Ryad !";
				this.infoObserver[2] = this.message;
				this.setChanged();
				this.notifyObservers(this.infoObserver);
			}
		}
		/*On verifie si le monstre a été battu*/
		if(this.plateau[x][y].getElement() instanceof Monstre){
			Monstre m = (Monstre)this.plateau[x][y].getElement();
			System.out.println("Vous vous faites attaquer par " + m.getNom());
			combat(m);		
			this.message = "Vous vous faites attaquer par " + m.getNom() +"!";
			this.infoObserver[2] = this.message;
			this.setChanged();
			this.notifyObservers(this.infoObserver);
			if(!m.estVaincu()){
				res=false;
			}
		}
		/* TODO CONDITION DE VICTOIRE 
		 * Etre sur la position X = 7 et Y = 4
		 * Avoir battu tous les ennemis => être niveau supérieur à 3
		 * */
		if((this.joueur.getPositionX() == 7 && this.joueur.getPositionY() == 4) && (this.joueur.getNiveau() >= 2)) {
			javax.swing.JOptionPane.showMessageDialog(null,"Bravo tu as gagné !");
			System.exit(0);
		}
		return res;
		
	}
	
	public void combat (Monstre m) {
		boolean combatEnCours = true;
		do {	
			m.attaquer(joueur);
			System.out.println(m.getNom() + " inflige " + m.getDegat_inflige() + " points de dégats à " + joueur.getNom());
			this.message = m.getNom() + " inflige " + m.getDegat_inflige() + " points de dégats à " + joueur.getNom();
			this.infoObserver[2] = this.message;
			this.setChanged();
			this.notifyObservers(this.infoObserver);
			System.out.println("Il reste " + this.joueur.getVie() + " PV à " + joueur.getNom());
			/* Vérifie si un des deux personnages est mort */
			if (m.estVaincu()) {
				System.out.println("Vous avez vaincu " + m.getNom());
				this.joueur.setXp(this.joueur.getXp() + m.getXp_apporte());
				System.out.println("Vous gagnez " + m.getXp_apporte() + " points d'expérience !");
				this.joueur.monterNiveau();
				combatEnCours = false;
			}
			else if (joueur.estVaincu()) {
				combatEnCours = false;
				javax.swing.JOptionPane.showMessageDialog(null,"Vous n'avez plus de points de vie, vous avez perdu !");
				System.exit(0);
			}
			this.joueur.attaquer(m);
			System.out.println(joueur.getNom() + " inflige " + joueur.getDegat() + " points de dégats à " + m.getNom());
			System.out.println("Il reste " + m.getVie() + " PV à " + m.getNom());
			/* Vérifie si un des deux personnages est mort */
			if (m.estVaincu()) {
				System.out.println("Vous avez vaincu " + m.getNom());
				this.joueur.setXp(this.joueur.getXp() + m.getXp_apporte());
				System.out.println("Vous gagnez " + m.getXp_apporte() + " points d'expérience !");
				this.joueur.monterNiveau();
				combatEnCours = false;
			}
			else if (joueur.estVaincu()) {
				combatEnCours = false;
				javax.swing.JOptionPane.showMessageDialog(null,"Vous n'avez plus de points de vie, vous avez perdu !");
				System.exit(0);
			}
		}while (combatEnCours == true);
	}
	
	/**
	 * Function -> Déplace le joueur et met à jour la Map
	 */
	public void deplacerJoueur(int x, int y){
		if(this.deplacement_valide(x, y)){
			/*On recupere la position actuelle du joueur*/
			int currentPositionX = this.joueur.getPositionX();
			int currentPositionY = this.joueur.getPositionY();
			
			if(this.plateau[x][y].getElement() instanceof Item){
				this.joueur.ramasser((Item)this.plateau[x][y].getElement());
				System.out.println("item récupéré");
			}
			if(this.plateau[x][y].getElement() instanceof Pnj){
				Pnj pnj = (Pnj)this.plateau[x][y].getElement();
				this.joueur.prendre(pnj);
			}
			
			/*Mise a jour de la map*/
			this.plateau[currentPositionX][currentPositionY].setElement(null);
			this.joueur.avancer(x, y);//deplacement joueur
			this.plateau[x][y].setElement(this.joueur);
			couplePosition[0]=currentPositionX;
			couplePosition[1]=currentPositionY;
			/*Conversion coordonnee en String pour envoyer au controller*/
			this.infoObserver[0] = Integer.toString(currentPositionX);
			this.infoObserver[1] = Integer.toString(currentPositionY);
			this.setChanged();
			this.notifyObservers(this.infoObserver);
			
		}
		
		else{
			System.out.println("Deplacement invalide");
		}
		
	}
	
	public void deplaceJoueur(int deplace) {
		int currentPositionX = this.joueur.getPositionX();
		int currentPositionY = this.joueur.getPositionY();
		switch (deplace) {
		case 8 :
			if(currentPositionX != 0 ) {
				if(this.deplacement_valide(currentPositionX-1, currentPositionY)) {
					this.plateau[currentPositionX][currentPositionY].setElement(null);
					this.joueur.avancer(currentPositionX-1, currentPositionY);//deplacement joueur
					this.plateau[currentPositionX-1][currentPositionY].setElement(this.joueur);
					this.setChanged();
					this.notifyObservers();
				}
			}
			else {
				System.out.println("Vous ne pouvez pas vous déplacer vers le haut !");
			}
		break;
		case 2 :
			if(currentPositionX != 7) {
				if(this.deplacement_valide(currentPositionX+1, currentPositionY)) {
					this.plateau[currentPositionX][currentPositionY].setElement(null);
					this.joueur.avancer(currentPositionX+1, currentPositionY);//deplacement joueur
					this.plateau[currentPositionX+1][currentPositionY].setElement(this.joueur);
					this.setChanged();
					this.notifyObservers();
				}
			}
			else {
				System.out.println("Vous ne pouvez pas vous déplacer vers le bas !");
			}
		break;
		case 6 :
			if(currentPositionY != 7) {
				if(this.deplacement_valide(currentPositionX, currentPositionY+1)) {
					this.plateau[currentPositionX][currentPositionY].setElement(null);
					this.joueur.avancer(currentPositionX, currentPositionY+1);//deplacement joueur
					this.plateau[currentPositionX][currentPositionY+1].setElement(this.joueur);
					this.setChanged();
					this.notifyObservers();
				}
			}
			else {
				System.out.println("Vous ne pouvez pas vous déplacer vers la droite !");
			}
		break;
		case 4 :
			if(currentPositionY != 0) {
				if(this.deplacement_valide(currentPositionX, currentPositionY-1)) {
					this.plateau[currentPositionX][currentPositionY].setElement(null);
					this.joueur.avancer(currentPositionX, currentPositionY-1);//deplacement joueur
					this.plateau[currentPositionX][currentPositionY-1].setElement(this.joueur);
					this.setChanged();
					this.notifyObservers();
				}
			}
			else {
				System.out.println("Vous ne pouvez pas vous déplacer vers la gauche !");
			}
		break;
		default :
			System.out.println("Vers où voulez-vous vous déplacer ? (6 = droite, 4 = gauche, 2 = bas, 8 = haut");
		}
	}
	
}
