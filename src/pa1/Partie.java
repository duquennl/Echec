package pa1;

import javax.swing.JOptionPane;

public class Partie {
	Echequier echec = new Echequier();
	String joueur1 = new String();
	String joueur2 = new String();
	boolean joueur =true ;

	/**
	 * Methode d'initialisation du jeu :
	 * 	- Choix des noms de joueurs ?
	 *  - Choix des couleurs
	 *  - Methode de jeu (avec/sans temps limite par exemple)
	 *  - ...
	 */
	public void init() {
		// TODO Auto-generated method stub
		String joueur1 = JOptionPane.showInputDialog("rentrez le nom du joueur 1");
		String joueur2 = JOptionPane.showInputDialog("rentrez le nom du joueur 2");
		this.joueur1=joueur1;
		this.joueur2=joueur2;
		
		this.echec.affichageGrille();

	}

	/**
	 * Methode de detection de fin de partie
	 * @return Vrai si il y a un echec et mat ou si il y a un abandon
	 */
	public boolean estFini() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Methode principale ou le jeu se passe
	 */
	public void jouer() {
		String posDeb = null;
		String posArr = null;
		boolean deplace = false;
		
		int x1=0, x2=0, y1=0, y2=0;

		
		// TODO Auto-generated method stub
		if(joueur) {System.out.println("Au joueur " +joueur1 +" de jouer");}
		else {System.out.println("Au joueur " +joueur2 +" de jouer");}
		 do{
		posDeb = JOptionPane.showInputDialog("rentrez la position de la pièce à bouger  : X;Y (avec X num de la ligne et Y num de la colonne)");
		}while(!verifEntreeUtilisateur(posDeb) && !this.echec.caseVide(x1, y1));
		do {
		posArr = JOptionPane.showInputDialog("rentrez la position d'arrivée  : X;Y (avec X num de la ligne et Y num de la colonne)");
		}while(!verifEntreeUtilisateur(posArr));
		

		
		x1 = Integer.parseInt(posDeb.substring(0,1));
		y1 = Integer.parseInt(posDeb.substring(2));
		x2 = Integer.parseInt(posArr.substring(0,1));
		y2 = Integer.parseInt(posArr.substring(2));
		
		if((this.echec.chercherPiece(x1, y1).getColor()=="blanc" && joueur) || (this.echec.chercherPiece(x1, y1).getColor()=="noir" && !joueur) ) {
		
			// deplacer piece ssi le deplacement et valide et ( joueur pas en echec ou la piece à bouger est un roi)
			if(this.echec.chercherPiece(x1, y1).deplacementValide(x1, y1, x2, y2, this.echec) 
					&& (!this.echec.echec(joueur) || this.echec.chercherPiece(x1, y1).getSymbole()=='k' || this.echec.chercherPiece(x1, y1).getSymbole()=='K')) 
					{ this.echec.deplacerPiece(x1, y1, x2, y2);deplace=true;joueur = !joueur;}
			else {System.out.println("déplacement impossible"); }
		}
		else {System.out.println("mauvaise couleur");}
		if (deplace) {this.echec.affichageGrille();}

		}

	/**
	 * Methode de fin de jeu :
	 *  - Annonce des gagnants
	 *  - PossibilitÃ© de stats
	 *  - PossibilitÃ© de regarder les coups de la partie
	 */
	
	public boolean verifEntreeUtilisateur(String s) {
		if (s.length()!=3) {
			System.out.println("nombre caractére rentrés incorrect");return false;}
		try {Integer.parseInt(s.substring(0,1));}catch(NumberFormatException e) { System.out.println("X et Y doivent être des entiers");return false;}
		try {Integer.parseInt(s.substring(2));}catch(NumberFormatException e) { System.out.println("X et Y doivent être des entiers");return false;}
		
		int nb1 = Integer.parseInt(s.substring(0,1));
		int nb2 = Integer.parseInt(s.substring(2));
		if (!s.substring(1,2).equals(";")) {System.out.println("entrée incorrect, ; missing : "+s.substring(1,2));return false;}
		else if (nb1<1 | nb1>8 | nb2<1 | nb2>8) {System.out.println("entrée incorrect, position n'est pas sur l'échequier");return false;}
		
		
		return true;
	}
	public void finDeJeu() {
		// TODO Auto-generated method stub
		
	}

}
