<<<<<<< HEAD
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;
import java.io.PrintWriter;

import dao.implement_dao;


public class User_signin_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	implement_dao implDao = new implement_dao();
	
    public User_signin_Servlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("psw");
		boolean result=implDao.login(username, password);
		PrintWriter out = response.getWriter();

		try {
//			response.sendRedirect("task_List.jsp");
			if(result==true) {
				response.sendRedirect("task_List.jsp");
				
			}
			else {
			       out.println("<script type=\"text/javascript\">");
			       out.println("alert('User or password incorrect');");
			       out.println("location='signin_view.jsp';");
			       out.println("</script>");
			      //response.sendRedirect("signin_view.jsp");

			}
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		login(request, response);
		
	}
	

}
=======
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;
import java.io.PrintWriter;

import dao.implement_dao;


public class User_signin_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	implement_dao implDao = new implement_dao();
	
    public User_signin_Servlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("psw");
		boolean result=implDao.login(username, password);
		PrintWriter out = response.getWriter();

		try {
//			response.sendRedirect("task_List.jsp");
			if(result==true) {
				response.sendRedirect("task_List.jsp");
				
			}
			else {
			       out.println("<script type=\"text/javascript\">");
			       out.println("alert('User or password incorrect');");
			       out.println("location='signin_view.jsp';");
			       out.println("</script>");
			      //response.sendRedirect("signin_view.jsp");

			}
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		login(request, response);
		
	}
	

}
>>>>>>> fbf558e1d5a02f2cb34c27c924b1e54a4f44962a
