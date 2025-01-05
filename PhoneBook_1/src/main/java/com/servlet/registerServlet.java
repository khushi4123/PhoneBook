	package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnection;
import com.dao.userdao;
import com.entity.User;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = 0;
		String name  = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		
			User use = new User();
			use.setUserName(name);
			use.setUserEmail(email);
			use.setUserPassword(password);


			userdao dao = new userdao();
			i =  dao.userRegister(use);
			if(i>0)
			{
				session.setAttribute("user", "use");
				response.getWriter().println("<script>alert('Resgister successfully'); location='register.jsp';</script>");
				response.sendRedirect("index.jsp");
				

			}
			else
			{
				//			response.getWriter().println("<script>alert('Fialed to resgister'); location='register.jsp';</script>");

				session.setAttribute("invalid","Failed to register" );
			}
		
	}
}



