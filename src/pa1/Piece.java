package pa1;

abstract class Piece{

	private String color;
	private String name;

	abstract void deplacement();

	public Piece(String c, String n){
		this.color = c;
		this.name = n;
	}

	public String getColor(){
		return color;
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
}
