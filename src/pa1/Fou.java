package pa1;
import java.lang.Math;

public class Fou extends Piece{

	public Fou(String couleur, int x, int y, char symbole) {
		super(couleur, "Fou", x, y, symbole);
	}

	boolean execution(int x1, int y1, int x2, int y2, Echequier tableau) {
		//Si la pièce se déplace en diagonale et que la trajectoire est libre
		if ((Math.abs(x2-x1)==Math.abs(y2-y1)) && y2!=y1)  {
			
			// Vers la droite
			if (y2>(y1+1)) {				
				// En haut
				if(x2>x1) {for (int i = y1+1 , j=x1+1; i < y2 ; i++ , j++ ) {
					if(!tableau.caseVide(j, i)) {
						return false;}}
					return true;
				}
				//en bas
				else if(x1>x2) {
					for (int i = y1+1 , j=x1-1; i < y2 ; i++ , j-- ) {
						if(!tableau.caseVide(j, i)) {
							return false;}}
					return true;}							
			}
			
			// Vers la gauche
			else if (y1>(y2+1)) {
				//en Haut
				if(x2>x1) {
					for (int i = y1-1 , j=x1+1; i > y2 ; i-- , j++ ) {
						if(!tableau.caseVide(j, i)) {
							return false;}}
					return true;}				
				//En bas
				else if(x1>x2) {
					for (int i = y1-1 , j=x1-1; i > y2 ; i-- , j-- ) {
						if(!tableau.caseVide(j, i)) {
							return false;}}
					return true;}	
			}
			
			// A proximitée
			else if (Math.abs(y2-y1)==1) {
				return true;}		
			
		}	
	
	return false;
	
	}
	@Override
	boolean deplacementValide(int x1, int y1, int x2, int y2, Echequier tableau) {
		// Si la case d'arrivée est vide et que la pièce se déplace
		if (tableau.caseVide(x2, y2) && (x2!=x1 || y2!=y1)){
			if(execution(x1,y1,x2,y2,tableau)) {return true;}}
		// ou occupée par une piece adverse et que la pièce se déplace
		else if (tableau.chercherPiece(x2, y2).getColor()!=this.getColor() && (x2!=x1 || y2!=y1)) {
			if(execution(x1,y1,x2,y2,tableau)) {return true;}
		}
			
	return false;
	}	
	
}
