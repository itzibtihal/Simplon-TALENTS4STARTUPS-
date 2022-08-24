package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("login.html").forward(request, response);
  }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    
	    if(username.equals("med") && password.equals("med")) {
	    	
	    	 response.sendRedirect("EmployeList.html");
	    	 
		} else {
			
			response.sendRedirect("login.html");
		
		}
		//doGet(request, response);
	}

}
