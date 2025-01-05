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
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = 0;
		int  cid = Integer.parseInt(request.getParameter("cid"));
		String name = request.getParameter("name");
		String emial = request.getParameter("email");
		String number = request.getParameter("number");
		String about = request.getParameter("about");

		Contact cont = new Contact();
		cont.setContid(cid);
		cont.setContname(name);
		cont.setContemail(emial);
		cont.setContphone(number);
		cont.setAbout(about);

		contactdao dao = new contactdao();
		i = dao.updateContact(cont);
		HttpSession session = request.getSession();

		if(i>0)
		{
			session.setAttribute("success", "Contact Updates successfully");
			response.sendRedirect("viewContact.jsp");


		}else
		{
			session.setAttribute("failed", "Failed to update");
			response.sendRedirect("Edit.jsp?cid"+cid);
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
