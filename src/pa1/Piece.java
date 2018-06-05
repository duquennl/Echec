package pa1;

abstract class Piece{

	private String color;
	private String name;
	public int x;
	public int y;
	public char symbole;
	public boolean premierDeplacement=true;
	public boolean out=false;

	// regarde si le deplacement est valide sur un echequier infini
	abstract boolean deplacementValide(int x1, int y1, int x2, int y2, Echequier tableau);

	public Piece(String c, String n, int x, int y, char symbole){
		this.color = c;
		this.name = n;
		this.x = x;
		this.y = y;
		this.symbole = symbole;
	}
	public boolean getOut() {
		return out;
	}
	
	public void setOut(boolean o) {
		this.out =o;
	}
	
	public void setPremierDeplacement(boolean b) {
		this.premierDeplacement=b;
	}

	public String getColor(){
		return color;
	}
	public char getSymbole() {
		return symbole;
	}
	
	public String getColorAdv() {
		if (color=="blanc") {return "noir";}
		else {return "blanc";}
	}

	public void setColor(String c){
		color = c;
	}

	public String getName(){
		return name;
	}

	public void setName(String n){
		name = n;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void deplacePiece(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
