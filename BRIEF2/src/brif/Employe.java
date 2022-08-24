package brif;
import java.util.Scanner;
public class Employe {
	public static void main(String[] args) {
		int TH ;
		int HP;
		int salairnet;
		int tmin = 20;
	    
		
		Scanner sc = new Scanner(System.in);
				do {
			System.out.print("Entrer Le  taux horaire : ");
			TH = sc.nextInt();
			if (TH < tmin) {
				// plus 25 DH par hour
				System.out.print(" Le tarif par heure ne doit pas etre inferieur a " + tmin + "\r\n");
			}
		}           while (TH < tmin);
				  System.out.println(" Entrer votre nombre d'heure de travail");
				  HP = sc.nextInt();
				    if (HP < 180) {
						salairnet = TH * HP;
						System.out.println( "m/mme" +non+ +prenom+ "ne(e) le " +date+ " vous etes un employer horaire votre salairnet  est " + salairnet + "DHs");
					} 
					else if (HP> 180 ) {
						salairnet = (180 * TH) + ((HP-180) * (TH + TH / 2));
						System.out.println(  "m/mme" +non+ +prenom+ "ne(e) le " +date+ " vous etes un employer horaire votre  salairnet est" + salairnet + " DHs");
					} 				
	}
}
