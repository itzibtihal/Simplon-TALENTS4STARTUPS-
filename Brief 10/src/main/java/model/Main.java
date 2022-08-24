package model;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import dao.*;
import hibernateUtil.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		
		   //System.out.println("Project started ...");
	      
	      // Session session = HibernateUtil.getSessionFactory().openSession();
	      // session.beginTransaction();
	      
	      
	       //  EmployDaoImp em = new EmployDaoImp();
	       //  AdminDaoImp ad = new AdminDaoImp();
	     
	       // -----------------------------Add employe ---------------------------------------
	   
	    	   /*
	    	   em.addEmploye(new Employe("Hebernate", " dima Error", 5000, "Professeur", "CDI"));
		       em.addEmploye(new Employe("KHALIL", "one", 7000, "Professeur", "CDI"));
		       em.addEmploye(new Employe("NAWAN", "two", 9000, "Professeur", "CDI"));
		       em.addEmploye(new Employe("ANASS", "tree", 8000, "Professeur", "CDI"));
	    	 */
	    
	       
	     // ------------------------------update employe   ----------------------------------
	       
	        /*
	       Employe e = em.getEmploye(5L);
	       e.setPrenom("test");
	       em.updateEmploye(e);
	      
	       */
	      // ------------------------------delete employe ------------------------------------
	       
	       // em.deleteEmploye(5L);

	         
	         
	         
	         
	         //-------------------------list employe--------------------------------------------------
	         
	      //   System.out.println(em.listEmploye());
	      //---------------------------------Add Admin   --------------------------------------------
	       
	      // ad.addAdmin(new Admin("MED",123));
	      
	      //--------------------------------Admin update------------------------------------------
	       
	       
	       
	      
	     // HibernateUtil.getSessionFactory().close();
		
		 /*
		        // From Java 10, you can use var instead of declaring the type explicitly
		        var resolver = new ClassLoaderTemplateResolver();
		        resolver.setTemplateMode(TemplateMode.HTML);
		        resolver.setCharacterEncoding("UTF-8");
		        resolver.setPrefix("/templates/");
		        resolver.setSuffix(".html");

		        var context = new Context();
		        context.setVariable("name", "Najib");
		        context.setVariable("date", LocalDateTime.now().toString());

		        var templateEngine = new TemplateEngine();
		        templateEngine.setTemplateResolver(resolver);

		        var result = templateEngine.process("index", context);
		        System.out.println(result);
		        
		        */
	      
	      

	       // EmployDaoImp em = new EmployDaoImp();
	        Employe emp = new Employe();
	      
	      var   resolver = new ClassLoaderTemplateResolver();
			resolver.setTemplateMode(TemplateMode.HTML);
			resolver.setCharacterEncoding("UTF-8");
			resolver.setPrefix("/templates/");
			resolver.setSuffix(".html");
			
			
			var context = new Context();
			var templateEngine = new TemplateEngine();
			templateEngine.setTemplateResolver(resolver);
			
			context.setVariable("Employe.nom",emp.getNom());
			context.setVariable("Employee.prenom", emp.getPrenom());
			context.setVariable("Employee.salaire", emp.getSalaire());
			context.setVariable("Employee.post", emp.getPost());
			context.setVariable("Employee.typeCont",emp.getTypeCont());
			
			var result = templateEngine.process("EmployeList", context);
			System.out.println(result);
			
		    }
	      
	

}
