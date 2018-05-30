package pa1;

public class Cavalier extends Piece{

	public Cavalier(String couleur, int x, int y) {
		super(couleur, "Cavalier", x, y);
	}

	@Override
	boolean deplacementValide(int x1, int y1, int x2, int y2, Echequier tableau) {
		// Si la case d'arrivée est vide ou occupée par une piece adverse
		if (tableau.caseVide(x2, y2)|tableau.chercherPiece(x2, y2).getColor()!=this.getColor()){
			// Si le cavalier se déplace en L
			if ((Math.abs(x2-x1)==2 & Math.abs(y2-y1)==1) | (Math.abs(x2-x1)==1 & Math.abs(y2-y1)==2))  {
				return true;
			}
		}
		return false;
	}
	
}
