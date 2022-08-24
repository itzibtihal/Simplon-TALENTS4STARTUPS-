package brif;

import java.util.Scanner;

public class employecom {
	int vente;
	int commi;
	int salairnet;
	Scanner sc = new Scanner(System.in);
	do {
		System.out.print("Entrer Le nombre de ventes : ");
		vente = sc.nextInt();
		if (vente == 0 ) {
			// vente doit etre sup a 0
			System.out.print("m/mme" +non+" "+prenom+ "ne(e) le " +date+ " vous etes un employer horaire votre salairnet  est  " +salairf + " DHs\r\n");
		}
	}  while (vente == 0);
	               if (vente >= 0) {
		
		salairnet = salairf + (vente * commi);
		System.out.println("m/mme" +non+" "+prenom+ "ne(e) le " +date+ " vous etes un employer horaire votre salair est" + salairnet + " DHs");
	}
}	

	
	