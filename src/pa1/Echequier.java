package pa1;

public class Echequier {

	Piece tableau[][];

	public Echequier(){
		tableau = new Piece[8][8];
		initialisation();
	}
	
	private void initialisation(){
		tableau[0][0] = new Tour("Blanc");
		tableau[0][7] = new Tour("Blanc");
		tableau[7][0] = new Tour("Noir");
		tableau[7][7] = new Tour("Noir");
		
		tableau[0][1] = new Cavalier("Blanc");
		tableau[0][6] = new Cavalier("Blanc");
		tableau[7][1] = new Cavalier("Noir");
		tableau[7][6] = new Cavalier("Noir");
		
		tableau[0][2] = new Fou("Blanc");
		tableau[0][5] = new Fou("Blanc");
		tableau[7][2] = new Fou("Noir");
		tableau[7][5] = new Fou("Noir");
		
		tableau[0][3] = new Reine("Blanc");
		tableau[0][4] = new Roi("Blanc");
		
		tableau[7][3] = new Reine("Noir");
		tableau[7][4] = new Roi("Noir");
		for(int i=0; i<tableau.length; i++){
			tableau[1][i] = new Pion("Blanc");
			tableau[6][i] = new Pion("Noir");
		}
	}
}
