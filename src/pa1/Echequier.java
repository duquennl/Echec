package pa1;

public class Echequier {
	
	Piece tableau[][];
	String couleur;
	Vide vide;
	Roi roi;
	Reine reine;
	Tour tour;
	Fou fou;
	Cavalier cavalier;
	Pion("blanc") pion;
	
	public Echequier()
	
	{	
	tableau = tableau[8][8];
		for(int i=0; i<tableau.length; i++)
			for(int j=0; j<tableau[i].length;i++)
			{
				if(i>=2 && i<=5)
					tableau[i][j]=vide;
				else if(i=10)
					tableau[i][j]=pion("blanc");
			}
				
	}

