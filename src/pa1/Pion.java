package pa1;

public class Pion extends Piece{
	
	public boolean premierDeplacement = true;

	public Pion(String couleur, int x, int y) {
		super(couleur, "Pion", x, y);
	}

// Renvoie vrai si la piéce n'a pas encore bougée
	public void setPremierDeplacement(boolean premierDeplacement) {
		this.premierDeplacement = premierDeplacement;
	}



	@Override
	boolean deplacementValide(int x1, int y1, int x2, int y2, Echequier tableau) {
			// si le pion est blanc
			if (this.getColor() == "blanc") { 
				// Si il se déplace de 2 en avant et si il ne s'est pas déplacé auparavant
				if (x2-x1==2 & this.premierDeplacement) {
					//Si les cases sur la trajectoire sont vide
					if (y2 == y1 & tableau.caseVide(x2, y2) & tableau.caseVide(x2-1, y2)) {
						return true;
					}
				}
				// Si il se déplace de un en avant 
				else if (x2-x1 == 1) {
					//Si la case d'arrivée est vide 
					if (y2 == y1 & tableau.caseVide(x2, y2)) {
						return true;
					}
					//Ou si il se déplace de 1 sur le coté aussi et que la case est occupé par une piéce adverse
					else if ((y2-y1 == 1 | y2-y1 == -1) & tableau.caseVide(x2, y2)==false) {
						if (tableau.chercherPiece(x2, y2).getColor()=="noir") {
							return true;
						}
					}
				}
			}
			// Si le pion est noir	
			else if (this.getColor() == "noir") { 
				// Si il se déplace de 2 en avant et si il ne s'est pas déplacé auparavant
				if (x2-x1==-2 & this.premierDeplacement) {
					//Si les cases sur la trajectoire sont vide
					if (y2 == y1 & tableau.caseVide(x2, y2) & tableau.caseVide(x2+1, y2)) {
							return true;
						}
					}
				// Si il se déplace de un en avant 
				else if (x2-x1 == -1) {
					//Si la case d'arrivée est vide 
					if (y2 == y1 & tableau.caseVide(x2, y2)) {
							return true;
						}
					//Ou si il se déplace de 1 sur le coté aussi et que la case est occupé par une piéce adverse
					else if ((y2-y1 == 1 | y2-y1 == -1) & tableau.caseVide(x2, y2)==false) {
							if (tableau.chercherPiece(x2, y2).getColor()=="blanc") {
								return true;
							}
					}
				}
			}

		return false;
	}
}
