package pa1;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {

		Echequier echec = new Echequier();
		System.out.println("Veuillez saisir un mot :");
		Scanner sc = new Scanner(System.in);
		int str = sc.nextInt();
		System.out.println("Vous avez saisi : " + str);
	}
}
