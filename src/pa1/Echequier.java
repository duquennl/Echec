package pa1;

public class Echequier {

	Piece tableau[][];

	public Echequier(){
		tableau = new Piece[8][8];
		initialisation();
	}
	
	//place les pieces
	private void initialisation(){
		tableau[0][0] = new Tour("blanc",0,0);
		tableau[0][1] = new Cavalier("blanc",0,1);
		tableau[0][2] = new Fou("blanc",0,2);
		tableau[0][3] = new Roi("blanc",0,3);
		tableau[0][4] = new Reine("blanc",0,4);
		tableau[0][5] = new Fou("blanc",0,5);
		tableau[0][6] = new Cavalier("blanc",0,6);
		tableau[0][7] = new Tour("blanc",0,7);

		
		tableau[7][0] = new Tour("noir",7,0);
		tableau[7][1] = new Cavalier("noir",7,1);
		tableau[7][2] = new Fou("noir",7,2);
		tableau[7][3] = new Reine("noir",7,3);
		tableau[7][4] = new Roi("noir",7,4);
		tableau[7][5] = new Fou("noir",7,5);
		tableau[7][6] = new Cavalier("noir",7,6);
		tableau[7][7] = new Tour("noir",7,7);
		
		for(int i=0; i<8; i++){
			tableau[1][i] = new Pion("blanc",1,i);
			tableau[6][i] = new Pion("blanc",6,i);
		}
	}
	
	// renvoie vrai si la position est hors de l'echequier
	private boolean positionInvalide (int x, int y) {
		return x < 0 || x > 7 || y < 0 || y > 7;
	}
	
	// cherche la piece se trouvant aux coordonn�es donnees en arguments
	public Piece chercherPiece(int x, int y) {
		if (positionInvalide(x,y)) { 
			System.out.println("position de d�part invalide");
			return null;
		}
	
		return tableau[x][y];
		
	}

	// deplace la piece qui se trouve en (x1,y1) en (x2,y2)
	public void deplacerPiece(int x1 , int y1 , int x2 , int y2) {
		if (positionInvalide(x1,y1)) { 
			System.out.println("position de d�part invalide");
			return;
		}
		if (positionInvalide(x2,y2)) { 
			System.out.println("position d'arriv�e invalide");
			return;
		}
		Piece p;
		if ((p = tableau[x1][y1]) != null){
			p.setX(x2);
			p.setY(y2);
			tableau[x2][y2] = p;
			tableau[x1][y1] = null;
		}
		else { 
			System.out.println("la case est vide");
		}

	}

	// renvoie vrai si aucune piece n'occupe la case (x,y)
	public boolean caseVide (int x, int y) {
		return tableau[x][y] == null;

	}

	//renvoie vrai si la case (x,y) est menac� par une pi�ce de la couleur donn�e en argument
	public boolean caseAttaque(int x, int y, Echequier monEchequier, String couleur) {
		for(Piece[] l : tableau){
			for(Piece p : l){
				if (p.getColor()==couleur && p.deplacementValide(p.x, p.y, x, y, this)){
					return true;
				}
			}
		}
		return false;
	}
	
}
	
	
