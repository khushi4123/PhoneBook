package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.contactdao;
import com.entity.Contact;

/**
 * Servlet implementation class contactServlet
 */
@WebServlet("/contactServlet")
public class contactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  i = 0;
		int userid = Integer.parseInt(request.getParameter("userid"));
		String name = request.getParameter("name");
		String emial = request.getParameter("email");
		String number = request.getParameter("number");
		String about = request.getParameter("about");
	
		Contact cont = new Contact( name, emial, number, about, userid);
		contactdao dao = new contactdao();
		i = dao.saveContact(cont);
		HttpSession session = request.getSession();
		
		if(i>0)
		{
			session.setAttribute("success", "Contact saved successfully");
			response.sendRedirect("addContact.jsp");


		}else
		{
			session.setAttribute("failed", "Something went wrong");
			response.sendRedirect("addContact.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
