package pa1;

public class Echequier {

	Piece tableau[][];

	public Echequier(){
		tableau = new Piece[8][8];
		tableau[0][0] = new Tour("Blanc");
		tableau[0][7] = new Tour("Blanc");
		tableau[7][0] = new Tour("Noir");
		tableau[7][7] = new Tour("Noir");
		for(int i=0; i<tableau.length; i++){
			tableau[1][i] = new Pion("Blanc");
			tableau[6][i] = new Pion("Noir");
		}
	}
}
