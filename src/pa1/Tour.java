package pa1;

public class Tour extends Piece{

	public Tour(String couleur, int x, int y, char symbole) {
		super(couleur, "Tour", x, y, symbole);
	}

	boolean execution(int x1, int y1, int x2, int y2, Echequier tableau) {
		if ((x1 == x2 && y1 != y2) || (y1==y2 && x1!=x2) ) {
			// vers la droite		
			if (y2>(y1+1)) {
				
				for (int i = y1+1 ; i < y2 ; i++ ) {
					if(!tableau.caseVide(x2, i)) {
						return false;}}
				
				return true;
			}
			// Vers la gauche
			else if (y1>(y2+1)){
				
				for (int i = y1-1 ; i > y2 ; i-- ) {
					if(!tableau.caseVide(x2, i)) {
						return false;}}
				
				return true;
			}
			//Vers le haut
			else if (x2>(x1+1)){
				
				for (int i = x1+1 ; i < x2 ; i++ ) {
					if(!tableau.caseVide(i, y2)) {
						return false;}}
			
				return true;
			}
			//Vers le bas
			else if (x1>(x2+1)){
				
				for (int i = x1-1 ; i > x2 ; i-- ) {
					if(!tableau.caseVide(i, y2)) {
						return false;}}
					
				return true;	
			}
			
			// A proximité
			
			else if (Math.abs(x2-x1)==1 || Math.abs(y2-y1)==1) {
				return true;
			}
			
		}
		return false;
	}
	@Override
	boolean deplacementValide(int x1, int y1, int x2, int y2, Echequier tableau) {
		// Si la case d'arrivée est vide ou est occupée par une piece adverse
		if (tableau.caseVide(x2, y2)) {
			// Et si la piéce se déplace en ligne droite et que la trajectoire est libre
			if(execution(x1,y1,x2,y2,tableau)) {return true;}
		}	
		else if(tableau.chercherPiece(x2, y2).getColor()!=this.getColor()) {
			if(execution(x1,y1,x2,y2,tableau)) {return true;}
		}
		return false;
	
	}

}
