package brief6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DaoImp daoimpl = new DaoImp();

		Scanner sc = new Scanner(System.in);
		System.out.println("Choisissez a quoi vous allez effectuer des operations : ");
		System.out.println("1: Categories.");
		System.out.println("2: Produits.");
		System.out.println("3: Ou bien lister les produits d'une categorie.");
		int operation = sc.nextInt();

		if (operation == 1) {
			System.out.println("Veuillez choisir l'operation que vous voullez effectuer sur une categorie : ");
			System.out.println("1: Ajouter une categorie.");
			System.out.println("2: lister une categorie.");
			System.out.println("3: Modifier une categorie.");
			System.out.println("4: supprimer une categorie.");
			int categorie = sc.nextInt();

			if (categorie == 1) {
				System.out.print("Entrer le nom de la categorie :  ");
				String name = sc.next();

				Categories categorie1 = new Categories(name);

				System.out.println(daoimpl.save(categorie1));
			} else if (categorie == 2) {
				System.out.print("Entrer l'Id de la categorie a lister:  ");
				int id = sc.nextInt();
				System.out.println(daoimpl.getById(id));
			} else if (categorie == 3) {
				System.out.print("Entrer l'Id de la categorie a modifier:  ");
				int id = sc.nextInt();

				System.out.print("Entrer le nouveau nom de cette categorie :  ");
				String name = sc.next();

				Categories categorie2 = new Categories(name);

				daoimpl.update(id, categorie2);
			} else if (categorie == 4) {
				System.out.print("Warning : Si une categorie est supprimee,tous les produits qui appartiennent a cette categorie seront supprimes!! ");
				System.out.print("Entrer l'Id de la categorie a supprimer :  ");
				int id = sc.nextInt();

				daoimpl.delete(id);
				
			}
		} else if (operation == 2) {
			System.out.println("Veuillez choisir l'operation que vous voullez effectuer sur un produit : ");
			System.out.println("1: Ajouter un produit.");
			System.out.println("2: lister un produit.");
			System.out.println("3: Modifier un produit.");
			System.out.println("4: supprimer un produit.");
			int produit = sc.nextInt();

			if (produit == 1) {
				System.out.print("Entrer le nom du produit :  ");
				String name = sc.next();
				
				System.out.print("Entrer le prix du produit :  ");
				String prix = sc.next();
				
				System.out.print("Entrer l'Id de la categorie du produit :  ");
				int categoriesid = sc.nextInt();

				Produits produit1 = new Produits(name, prix, categoriesid);

				System.out.println(daoimpl.save(produit1));

			} else if (produit == 2) {
				System.out.print("Entrer l'Id du produit a lister:  ");
				int produitsid = sc.nextInt();

				System.out.println(daoimpl.getById1(produitsid));

			} else if (produit == 3) {
				System.out.print("Entrer l'Id du produit a modifier:  ");
				int produitsid = sc.nextInt();

				System.out.print("Entrer le nouveau nom de ce produit :  ");
				String name = sc.next();

				System.out.print("Entrer le nouveau prix de ce produit :  ");
				String prix = sc.next();

				System.out.print("Entrer le Id de la nouvelle categorie de ce produit :  ");
				int categoriesid = sc.nextInt();

				Produits produit2 = new Produits(name, prix, categoriesid);

				daoimpl.update(produitsid, produit2);

			} else if (produit == 4) {
				System.out.print("Entrer l'Id du produit a supprimer :  ");
				int produitsid = sc.nextInt();

				daoimpl.delete1(produitsid);
			}
		} else if (operation == 3) {
			System.out.print("Entrer l'Id de la categorie a fin de lister ses produits:  ");
			int id = sc.nextInt();
			System.out.println(daoimpl.getById2(id));
		}

	}

}
