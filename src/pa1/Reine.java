package pa1;

public class Reine extends Piece{

	public Reine(String couleur, int x, int y, char symbole) {
		super(couleur,"Reine", x, y, symbole);
	}

	boolean execution(int x1, int y1, int x2, int y2, Echequier tableau) {
		// Si la piéce se déplace en diagonal et que la trajectoire est libre (cf fou)
		if ((Math.abs(x2-x1)==Math.abs(y2-y1)))  {
			if (y2>(y1+1)) {
				if(x2>x1) {
					for (int i = y1+1 , j=x1+1; i < y2 ; i++ , j++ ) {
						if(!tableau.caseVide(j, i)) {
							return false;}}
						
					return true;
					
				}
				else if(x1>x2) {
					for (int i = y1+1 , j=x1-1; i < y2 ; i++ , j-- ) {
						if(!tableau.caseVide(j, i)) {
							return false;}}
						
					return true;
				}
			}
			else if (y1>(y2+1)) {
				if(x2>x1) {
					for (int i = y1-1 , j=x1+1; i > y2 ; i-- , j++ ) {
						if(!tableau.caseVide(j, i)) {
							return false;}}
						return true;
				}
				else if(x1>x2) {
					for (int i = y1-1 , j=x1-1; i > y2 ; i-- , j-- ) {
						if(!tableau.caseVide(j, i)) {
							return false;}}
						return true;
				}
			}
			else if (Math.abs(y2-y1)==1) {
				return true;
			}
		}
		// Si elle se déplace en ligne droite et que la trajectoire est libre (cf tour)
		else if ((x1 == x2 & y1 != y2)|(y1==y2 & x1!=x2) ) {
			
			if (y2>(y1+1)) {
				for (int i = y1+1 ; i < y2 ; i++ ) {
					if(!tableau.caseVide(x2, i)) {
						return false;}}
					return true;
			}
			else if (y1>(y2+1)){
				for (int i = y1-1 ; i > y2 ; i-- ) {
					if(!tableau.caseVide(x2, i)) {
						return false;}}
					return true;
				
			}
			else if (x2>(x1+1)){
				for (int i = x1+1 ; i < x2 ; i++ ) {
					if(!tableau.caseVide(i, y2)) {
						return false;}}
					return true;
				
			}
			else if (x1>(x2+1)){
				for (int i = x1-1 ; i > x2 ; i-- ) {
					if(!tableau.caseVide(i, y2)) {
						return false;}}
				return true;
			}
			
			else if (Math.abs(x2-x1)==1|Math.abs(y2-y1)==1) {
				return true;
			}
			
		}
		
		return false;
		
	}
	@Override
	boolean deplacementValide(int x1, int y1, int x2, int y2, Echequier tableau) {
		
		// Si la case d'arrivée est vide 
		if(tableau.caseVide(x2, y2)){
			if(execution(x1,y1,x2,y2,tableau)) {return true;}
		}
		//ou qu'elle contient une piece de couleur différente et que la pièce se déplace
		
		else if(tableau.chercherPiece(x2, y2).getColor()!=this.getColor() && (x2!=x1|y2!=y1)){
			if(execution(x1,y1,x2,y2,tableau)) {return true;}
		}
		// alors le déplacement est valide, sinon il ne l'est pas :
		
		return false;
	
	}	

}
