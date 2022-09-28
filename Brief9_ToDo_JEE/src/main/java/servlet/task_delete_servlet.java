<<<<<<< HEAD
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Tache;

import java.io.IOException;

import dao.implement_dao_task;


public class task_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	implement_dao_task imp = new implement_dao_task();
	Tache tache = new Tache();
       

    public task_delete_servlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		Delete(request, response);
		response.sendRedirect("task_List.jsp");
	}
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		tache.setTitre(request.getParameter("title"));

		try {
			imp.delete(tache);
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

import java.io.IOException;

import dao.implement_dao_task;


public class task_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	implement_dao_task imp = new implement_dao_task();
	Tache tache = new Tache();
       

    public task_delete_servlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		Delete(request, response);
		response.sendRedirect("task_List.jsp");
	}
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		tache.setTitre(request.getParameter("title"));

		try {
			imp.delete(tache);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
>>>>>>> fbf558e1d5a02f2cb34c27c924b1e54a4f44962a
