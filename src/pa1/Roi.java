package pa1;

public class Roi extends Piece{

	public Roi(String couleur, int x, int y) {
		super(couleur,"Roi", x, y);
	}

	@Override
	boolean deplacementValide(int x1, int y1, int x2, int y2, Echequier tableau) {
		
		// Si la case d'arrivée est vide ou qu'elle contient une piece de couleur différente et que la pièce se déplace 
		// et que la case d'arrivée n'est pas menacé par une piéce adverse
		if ( (tableau.caseVide(x2, y2)|tableau.chercherPiece(x2, y2).getColor()!=this.getColor()) & (x2!=x1|y2!=y1) & !tableau.caseAttaque(x2, y2, tableau, this.getColorAdv())){
			// Si la piece se déplace de 1 en ligne ou en colonne
			if (Math.abs(x2-x1)==1|Math.abs(y2-y1)==1) {
				return true;
			}
		}
		// alors le déplacement est valide, sinon il ne l'est pas :
		
		return false;
	
	}	


}
