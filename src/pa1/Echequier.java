package pa1;

public class Echequier {

	Piece tableau[] = new Piece[32];
	char  grille[][] = new char[19][19];

	

	public Echequier(){
		initialisation();
	}
	//place les pieces
	private void initialisation(){
		tableau[0] = new Tour("blanc",1,1,'t');
		tableau[1] = new Tour("blanc",1,8,'t');
		tableau[2] = new Tour("noir",8,1,'T');
		tableau[3] = new Tour("noir",8,8,'T');
		
		tableau[4] = new Cavalier("blanc",1,2,'c');
		tableau[5] = new Cavalier("blanc",1,7,'c');
		tableau[6] = new Cavalier("noir",8,2,'C');
		tableau[7] = new Cavalier("noir",8,7,'C');
		
		tableau[8] = new Fou("blanc",1,3,'f');
		tableau[9] = new Fou("blanc",1,6,'f');
		tableau[10] = new Fou("noir",8,3,'F');
		tableau[11] = new Fou("noir",8,6,'F');
		
		tableau[12] = new Reine("blanc",1,5,'q');
		tableau[13] = new Roi("blanc",1,4,'k');
		
		tableau[14] = new Reine("noir",8,5,'Q');
		tableau[15] = new Roi("noir",8,4,'K');
	
		tableau[16] = new Pion("blanc",2,1,'p');
		tableau[17] = new Pion("blanc",2,2,'p');
		tableau[18] = new Pion("blanc",2,3,'p');
		tableau[19] = new Pion("blanc",2,4,'p');
		tableau[20] = new Pion("blanc",2,5,'p');
		tableau[21] = new Pion("blanc",2,6,'p');
		tableau[22] = new Pion("blanc",2,7,'p');
		tableau[23] = new Pion("blanc",2,8,'p');

		tableau[24] = new Pion("noir",7,1,'P');
		tableau[25] = new Pion("noir",7,2,'P');
		tableau[26] = new Pion("noir",7,3,'P');
		tableau[27] = new Pion("noir",7,4,'P');
		tableau[28] = new Pion("noir",7,5,'P');
		tableau[29] = new Pion("noir",7,6,'P');
		tableau[30] = new Pion("noir",7,7,'P');
		tableau[31] = new Pion("noir",7,8,'P');

		

		for(int i=0 ; i<19 ; i++) {
			for(int j=0 ; j<19 ; j++) {
				if (i==0 && j!=0 && j<16 && j%2==0) {
					grille[i][j]=9516;
				}
				else if (i==16 && j!=0 && j<16 && j%2==0) {
					grille[i][j]=9524;
				}
				else if(i%2==0 && j!=0 && j<16 && j%2!=0 && i<17) {
					grille[i][j]=9472;
				}
				else if(j==0 && i!=0 && i<16 && i%2==0) {
					grille[i][j]=9500;
				}
				else if(j%2==0  && i!=0 && i<16 && i%2!=0 && j<17) {
					grille[i][j]=9474;
				}
				else if(j==16 && i!=0 && i<16 && i%2==0) {
					grille[i][j]=9508;
				}
				else if (i%2 ==0 && j%2 == 0 && i!=0 && j!=0 && j<17 && i<17) {
					grille[i][j]=9532;
				}
				else if (i==0 && j==0) {
					grille[i][j]=9484;
				}
				else if (i==0 && j==16) {
					grille[i][j]=9488;
				}
				else if (i==16 && j==0) {
					grille[i][j]=9492;
				}
				else if (i==16 && j==16) {
					grille[i][j]=9496;
				}
				else if (i== 17 && j%2!=0 && j!=0 && j!=17) {
					grille[i][j]=(char) ((j+1)/2+48);
				}
				else if (j== 17 && i%2!=0 &&  i!=17) {
					grille[i][j]=(char) ((i+1)/2+48);
				}
				else {
					grille[i][j]=' ';
				}
			}
		}
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
		
		
	
	for (int i = 0 ; i<32 ; i++) {
		if (tableau[i].getX()== x && tableau[i].getY() == y) {
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
	
		
		if (this.caseVide(x1, y1)) { System.out.println("la case est vide");
		}
		
		else if (!this.chercherPiece(x1, y1).deplacementValide(x1, y1, x2, y2, this)) {System.out.println("déplacement invalide");}
		else if (this.caseVide(x2, y2)) {
			if(this.chercherPiece(x1, y1).getName()=="Pion") {this.chercherPiece(x1, y1).setPremierDeplacement(false);}
			this.chercherPiece(x1, y1).deplacePiece(x2, y2);
			grille[x1*2-1][y1*2-1]=' ';

		}
		else {
			System.out.println("ATTAQUE !");
			if(this.chercherPiece(x1, y1).getName()=="Pion") {this.chercherPiece(x1, y1).setPremierDeplacement(false);}
			this.chercherPiece(x2, y2).setOut(true);
			this.chercherPiece(x2, y2).deplacePiece(0, 0);
			this.chercherPiece(x1, y1).deplacePiece(x2, y2);
			grille[x1*2-1][y1*2-1]=' ';

		}

	}

	// renvoie vrai si aucune piece n'occupe la case (x,y)
	public boolean caseVide (int x, int y) {
		for (int i = 0 ; i<32 ; i++) {
			if (tableau[i].getX() == x & tableau[i].getY() == y) {
				return false;
			}
						
		}
		
		return true;

	}

	//renvoie vrai si la case (x,y) est menacé par une piéce de la couleur donnée en argument
	public boolean caseAttaque(int x, int y, Echequier monEchequier, String couleur) {
		for(int i=0 ; i<32;i++) {
			if(tableau[i].getColor()==couleur && tableau[i].deplacementValide(tableau[i].getX(), tableau[i].getY(), x, y, monEchequier)) {
				return true;
			}}
		
		return false;
	}

	public void affichageGrille() {
		for (int i = 0 ; i<32 ; i++) {
			if(tableau[i].getOut()==false) {
			grille[tableau[i].getX()*2-1][tableau[i].getY()*2-1]=(tableau[i].getSymbole());}
		
		}
		for (int i =0;i<19;i++) {
				System.out.println(grille[i]);	
		}
	}
	
	// si echec (true) => renvoie true si le roi blanc est en echec ; si echec(false) => renvoie true si le roi noir est en échec
	public boolean echec(boolean blanc) {
		for(int i=0 ; i<32;i++) {
			if(tableau[i].getSymbole()=='k' && this.caseAttaque(tableau[i].getX(), tableau[i].getY(), this, "noir") && blanc)
			{System.out.println("Echec au roi blanc!");return true;}
			else if(tableau[i].getSymbole()=='K' && this.caseAttaque(tableau[i].getX(), tableau[i].getY(), this, "blanc") && !blanc)
			{System.out.println("Echec au roi noir!");return true;}
	}
		return false;
	}
}
	
	
