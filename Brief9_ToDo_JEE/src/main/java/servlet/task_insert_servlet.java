<<<<<<< HEAD
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Tache;
import models.User;

import java.io.IOException;
import java.io.PrintWriter;

import dao.implement_dao_task;


public class task_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	implement_dao_task imp = new implement_dao_task();
	Tache tache = new Tache();
	
	
    public task_insert_servlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		Add(request, response);
		
		
	}
	
	protected void Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String statut = request.getParameter("statut");
		String deadline = request.getParameter("deadline");
		String nom_category = request.getParameter("nom_category");
		

		
		tache.setTitre(titre);
		tache.setDescription(description);
		tache.setStatut(statut);
		tache.setDeadline(deadline);
		tache.setNom_category(nom_category);

		
		try {
			imp.insert(tache);
			response.sendRedirect("task_List.jsp");
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		
	}
	

}
=======
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Tache;
import models.User;

import java.io.IOException;
import java.io.PrintWriter;

import dao.implement_dao_task;


public class task_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	implement_dao_task imp = new implement_dao_task();
	Tache tache = new Tache();
	
	
    public task_insert_servlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		Add(request, response);
		
		
	}
	
	protected void Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String statut = request.getParameter("statut");
		String deadline = request.getParameter("deadline");
		String nom_category = request.getParameter("nom_category");
		

		
		tache.setTitre(titre);
		tache.setDescription(description);
		tache.setStatut(statut);
		tache.setDeadline(deadline);
		tache.setNom_category(nom_category);

		
		try {
			imp.insert(tache);
			response.sendRedirect("task_List.jsp");
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		
	}
	

}
>>>>>>> fbf558e1d5a02f2cb34c27c924b1e54a4f44962a
