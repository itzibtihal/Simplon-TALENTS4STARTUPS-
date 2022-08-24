package model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import DaoImpl.AdminDaoImpl;
import DaoImpl.CoursDaoImpl;
import DaoImpl.EtudDaoImpl;
import DaoImpl.ProfDaoImpl;
import hibernateUtil.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("=========================Project started============================= ");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    
	      ProfDaoImpl prof = new ProfDaoImpl();
	      CoursDaoImpl cou = new CoursDaoImpl();
	    //AdminDaoImpl ad= new AdminDaoImpl();
	      EtudDaoImpl  etud = new EtudDaoImpl();
	    
	    //------------------------------ ADD Prof- done---------------------------------------------
	      
	    //prof.addProf(new Prof("Khalil","Delegué","khalil@",15000,new ArrayList<Cours>()));
	      
	    //----------------------------------ADD etudiant done!!!!-----------------------------------
	      
	   // etud.addEtudiant(new Etudiant("Anas","anass","BAC", 12,new ArrayList<Cours>()));
	     
	   //--------------------------------Add Cours- done--------------------------------------------
	     
	    cou.addCours(new Cours("Java ee","patforme entreprise edition",prof.getProf(1L),etud.getEtudiant(3L)));
       //---------------------------------cours delete------------
	   // cou.deleteCours(3L);
	   
	  //-----------cours update done-------------------    
//	      Cours c = cou.getCours(2);
//	      c.setCoursNom("Hibernate");
//	      c.setType("java framework");
//	      cou.updateCours(c);
	      
	    HibernateUtil.getSessionFactory().close();
   
		
	}

}
