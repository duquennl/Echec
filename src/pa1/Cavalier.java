package pa1;

public class Cavalier extends Piece{

	public Cavalier(String couleur, int x, int y, char symbole) {
		super(couleur, "Cavalier", x, y, symbole);
	}

	boolean execution(int x1, int y1, int x2, int y2, Echequier tableau) {
			// Si le cavalier se déplace en L
			if ((Math.abs(x2-x1)==2 & Math.abs(y2-y1)==1) || (Math.abs(x2-x1)==1 & Math.abs(y2-y1)==2))  {
				return true;
			}
		
		return false;
	}
	@Override
	boolean deplacementValide(int x1, int y1, int x2, int y2, Echequier tableau) {
		// Si la case d'arrivée est vide 
		if (tableau.caseVide(x2, y2)) {
			if(execution(x1, y1, x2, y2, tableau)) {return true;}
		}
		// ou occupée par une piece adverse
			else if(tableau.chercherPiece(x2, y2).getColor()!=this.getColor()) {
				if(execution(x1, y1, x2, y2, tableau)) {return true;}

			}

		return false;
	}
	
}
