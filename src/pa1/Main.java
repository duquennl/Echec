package pa1;

public class Main {
	public static void main(String[] args) {
		Partie p = new Partie();
		p.init();
		while(p.estFini()){
			p.jouer();
		}
		p.finDeJeu();
//		Echequier echec = new Echequier();
//		System.out.println("Veuillez saisir un mot :");
//		Scanner sc = new Scanner(System.in);
//		int str = sc.nextInt();
//		System.out.println("Vous avez saisi : " + str);
	}
}
