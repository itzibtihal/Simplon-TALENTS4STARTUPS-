package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employe;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import dao.EmployDaoImp;

public class EmployeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  EmployDaoImp em = new EmployDaoImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employe> listEmp = em.listEmploye();
        request.setAttribute("Employe", listEmp);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeList.html");
        dispatcher.forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
      
        Employe emp = new Employe();
        
		
		var resolver = new ClassLoaderTemplateResolver();
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
		
		
	}

}
