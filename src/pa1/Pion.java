package pa1;

public class Pion extends Piece{
	
	public boolean premierDeplacement = true;

	public Pion(String couleur, int x, int y) {
		super(couleur, "Pion", x, y);
	}

// Renvoie vrai si la pi�ce n'a pas encore boug�e
	public void setPremierDeplacement(boolean premierDeplacement) {
		this.premierDeplacement = premierDeplacement;
	}



	@Override
	boolean deplacementValide(int x1, int y1, int x2, int y2, Echequier tableau) {
			// si le pion est blanc
			if (this.getColor() == "blanc") { 
				// Si il se d�place de 2 en avant et si il ne s'est pas d�plac� auparavant
				if (x2-x1==2 & this.premierDeplacement) {
					//Si les cases sur la trajectoire sont vide
					if (y2 == y1 & tableau.caseVide(x2, y2) & tableau.caseVide(x2-1, y2)) {
						return true;
					}
				}
				// Si il se d�place de un en avant 
				else if (x2-x1 == 1) {
					//Si la case d'arriv�e est vide 
					if (y2 == y1 & tableau.caseVide(x2, y2)) {
						return true;
					}
					//Ou si il se d�place de 1 sur le cot� aussi et que la case est occup� par une pi�ce adverse
					else if ((y2-y1 == 1 | y2-y1 == -1) & tableau.caseVide(x2, y2)==false) {
						if (tableau.chercherPiece(x2, y2).getColor()=="noir") {
							return true;
						}
					}
				}
			}
			// Si le pion est noir	
			else if (this.getColor() == "noir") { 
				// Si il se d�place de 2 en avant et si il ne s'est pas d�plac� auparavant
				if (x2-x1==-2 & this.premierDeplacement) {
					//Si les cases sur la trajectoire sont vide
					if (y2 == y1 & tableau.caseVide(x2, y2) & tableau.caseVide(x2+1, y2)) {
							return true;
						}
					}
				// Si il se d�place de un en avant 
				else if (x2-x1 == -1) {
					//Si la case d'arriv�e est vide 
					if (y2 == y1 & tableau.caseVide(x2, y2)) {
							return true;
						}
					//Ou si il se d�place de 1 sur le cot� aussi et que la case est occup� par une pi�ce adverse
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
