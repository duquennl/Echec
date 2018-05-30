package pa1;

abstract class Piece{

	private String color;
	private String name;
	public int x;
	public int y;

	// regarde si le deplacement est valide sur un echequier infini
	abstract boolean deplacementValide(int x1, int y1, int x2, int y2, Echequier tableau);

	public Piece(String c, String n, int x, int y){
		this.color = c;
		this.name = n;
		this.x = x;
		this.y = y;
	}

	public String getColor(){
		return color;
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
	
}
