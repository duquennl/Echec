package pa1;

public class Echequier {

	Piece tableau[];

	public Echequier(){
		tableau = new Piece[24];
		initialisation();
	}
	
	//place les pieces
	private void initialisation(){
		tableau[0] = new Tour("blanc",1,1);
		tableau[1] = new Tour("blanc",1,8);
		tableau[2] = new Tour("noir",8,1);
		tableau[3] = new Tour("noir",8,8);
		
		tableau[4] = new Cavalier("blanc",1,2);
		tableau[5] = new Cavalier("blanc",1,7);
		tableau[6] = new Cavalier("noir",8,2);
		tableau[7] = new Cavalier("noir",8,7);
		
		tableau[8] = new Fou("blanc",1,3);
		tableau[9] = new Fou("blanc",1,6);
		tableau[10] = new Fou("noir",8,3);
		tableau[11] = new Fou("noir",8,6);
		
		tableau[12] = new Reine("blanc",1,6);
		tableau[13] = new Roi("blanc",1,5);
		
		tableau[14] = new Reine("noir",8,6);
		tableau[15] = new Roi("noir",8,5);
	
		tableau[16] = new Pion("blanc",2,1);
		tableau[17] = new Pion("blanc",2,2);
		tableau[18] = new Pion("blanc",2,3);
		tableau[19] = new Pion("blanc",2,4);
		tableau[20] = new Pion("blanc",2,5);
		tableau[21] = new Pion("blanc",2,6);
		tableau[22] = new Pion("blanc",2,7);
		tableau[24] = new Pion("blanc",2,8);

		tableau[16] = new Pion("noir",7,1);
		tableau[17] = new Pion("noir",7,2);
		tableau[18] = new Pion("noir",7,3);
		tableau[19] = new Pion("noir",7,4);
		tableau[20] = new Pion("noir",7,5);
		tableau[21] = new Pion("noir",7,6);
		tableau[22] = new Pion("noir",7,7);
		tableau[23] = new Pion("noir",7,8);

		}
	
	// renvoie vrai si la position est hors de l'echequier
	private boolean positionInvalide (int x, int y) {
		boolean verif = true;
		if ( x >= 1 & x <= 8 & y >= 1 & y <= 8 ) { verif = false;}
		return verif;
	}
	
	// cherche la piece se trouvant aux coordonnées donnees en arguments
	public Piece chercherPiece(int x, int y) {
		if (positionInvalide(x,y)) { System.out.println("position de départ invalide");
		return null;
		}
		
		
	
	for (int i = 0 ; i<33 ; i++) {
		if (tableau[i].getX()== x & tableau[i].getY() == y) {
			return tableau[i];
		}
	}
	return null;
		
	}

	// deplace la piece qui se trouve en (x1,y1) en (x2,y2)
	public void deplacerPiece(int x1 , int y1 , int x2 , int y2) {
		if (positionInvalide(x1,y1)) { System.out.println("position de départ invalide");
		return;
		}
		if (positionInvalide(x2,y2)) { System.out.println("position d'arrivée invalide");
		return;
		}
		boolean verif = false;
		for (int i = 0 ; i<33 ; i++) {
			if (tableau[i].getX()== x1 & tableau[i].getY() == y1) {
				 tableau[i].setX(x2);
				 tableau[i].setY(y2);
				 verif = true;
			}	
		}
		
		if (verif == false) { System.out.println("la case est vide");
		}

	}

	// renvoie vrai si aucune piece n'occupe la case (x,y)
	public boolean caseVide (int x, int y) {
		for (int i = 0 ; i<33 ; i++) {
			if (tableau[i].getX() == x & tableau[i].getY() == y) {
				return false;
			}
						
		}
		
		return true;

	}

	//renvoie vrai si la case (x,y) est menacé par une piéce de la couleur donnée en argument
	public boolean caseAttaque(int x, int y, Echequier monEchequier, String couleur) {
		for(int i=0 ; i<33;i++) {
			if(tableau[i].deplacementValide(tableau[i].getX(), tableau[i].getY(), x, y, monEchequier) & tableau[i].getColor()==couleur) {
				return true;
			}
		}
		return false;
	}
	
}
	
	
