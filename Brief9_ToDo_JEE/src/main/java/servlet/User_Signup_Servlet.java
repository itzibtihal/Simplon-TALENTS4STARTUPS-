<<<<<<< HEAD
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.implement_dao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

public class User_Signup_Servlet extends HttpServlet {
	
	implement_dao implDao = new implement_dao();	
	
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
	}

	public User_Signup_Servlet() {
		//this.imp_dao = new implement_dao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Registre(request,response);
		doGet(request,response);
	}

	protected void Registre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String password = request.getParameter("psw");
		
		User user = new User();
		
		user.setUsername(username);
		user.setName(name);
		user.setPassword(password);
		
		try {
			implDao.insert(user);
			response.sendRedirect("signin_view.jsp");
		}
		catch(Exception e){
			e.printStackTrace(); 
		}		
		 

	}
	
	

	
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  response.getWriter();
	 
  
  }
 
=======
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.implement_dao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

public class User_Signup_Servlet extends HttpServlet {
	
	implement_dao implDao = new implement_dao();	
	
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
	}

	public User_Signup_Servlet() {
		//this.imp_dao = new implement_dao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Registre(request,response);
		doGet(request,response);
	}

	protected void Registre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String password = request.getParameter("psw");
		
		User user = new User();
		
		user.setUsername(username);
		user.setName(name);
		user.setPassword(password);
		
		try {
			implDao.insert(user);
			response.sendRedirect("signin_view.jsp");
		}
		catch(Exception e){
			e.printStackTrace(); 
		}		
		 

	}
	
	

	
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  response.getWriter();
	 
  
  }
 
>>>>>>> fbf558e1d5a02f2cb34c27c924b1e54a4f44962a
}