package br5;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import br5.DBconnection;
import java.sql.PreparedStatement;
import java.sql.Connection;

import br5.dao;
import br5.daoimpl;


public class main {

	public static void main(String[] args) {
	    daoimpl daoimpl = new daoimpl();

	   	 
        //Condidats najib1 = new Condidats ( "rachid" ,  "najib",  "najib@anmoon.com",  "123 new york", "michigan", "usa");

   	    
   		//System.out.println(daoimpl.update(1, najib1));
   //		daoimpl.delete(1);
   		
   		 
   	//	return;
   		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("choisiez votre opération: ");
		System.out.println("1: Save");
	System.out.println("2: UpDate");
		System.out.println("3: Delete");
	    int operation = sc.nextInt();
		
		
	    
    Scanner inputnom = new Scanner(System.in);
	System.out.print("Enter votre nom :  ");
	    String nom = inputnom.nextLine();
		
		Scanner inputprenom = new Scanner(System.in);
		System.out.print("Entrer votre prenom:  ");
		String prenom= inputprenom.nextLine();
		
		Scanner inputville = new Scanner(System.in);
		System.out.print("Entrer votre ville:  ");
		String ville= inputville.nextLine();
		
		
		Scanner inputmail = new Scanner(System.in);
		System.out.print("Entrer votre email:  ");
		String mail= inputmail.nextLine();
	
		Scanner inputadress = new Scanner(System.in);
		System.out.print("Entrer votre adress:  ");
	    String adress= inputadress.nextLine();
		
       Scanner inputpays = new Scanner(System.in);
	   System.out.print("Entrer votre pays:  ");
       String pays= inputpays.nextLine();
		
       
       
		if(operation==1) {
              Condidats condidat = new Condidats (  nom ,  prenom,  mail,  adress, ville, pays);
    	    System.out.println(daoimpl.save(condidat));
       }
     else if(operation==2) {
    	 
    	 
         Condidats najib = new Condidats ( "rachid" ,  "najib",  "najib@anmoon.com",  "123 new york", "michigan", "usa");

    	    System.out.println(daoimpl.update(1, najib));
    	   
       }
        else if(operation==3) {	
   		daoimpl.delete(6);
   		}
   
      }
	
		
	}


