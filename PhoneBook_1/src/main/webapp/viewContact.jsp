<%@page import="java.util.List"%>
<%@page import="com.entity.Contact"%>
<%@page import="com.dao.contactdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: lightgray;
}
</style>


</head>
<body>
	<%@include file="navbar.jsp"%>

	<%
	if (use == null) {
		session.setAttribute("logOut", "Please login");

		response.sendRedirect("login.jsp");
	}
	%>
	<%
	String success = (String) session.getAttribute("success");
	String failed = (String) session.getAttribute("invalid");

	if (success != null) {
	%>
	<div class="alert alert-success" role="alert"><%=success%></div>
	<%
	session.removeAttribute("success");
	}
	if (failed != null) {
	%>
	<h4 class="text-danger text-center"><%=failed%></h4>
	<%
	session.removeAttribute("failed");
	}
	%>
	<div class="container">
		<div class="row p-5">
			<%
			if (use != null) {
				contactdao dao = new contactdao();
				List<Contact> contact = dao.getAllContact(use.getUserId());

				for (Contact cont : contact) {
			%>
			<div class="col-md-3">

				<div class="card crd-ho">
					<div class="card-body">

						<h5>
							Name:
							<%=cont.getContname()%></h5>
						<p>
							Phone no:
							<%=cont.getContphone()%></p>
						<p>
							Email:
							<%=cont.getContemail()%></p>
						<p>
							About:
							<%=cont.getAbout()%></p>
						<div class="text-center">
							<a href="Edit.jsp?cid=<%=cont.getContid()%>"
								class="btn btn-success btn-sm text-white">Edit</a> <a
								href="deleteServlet?cid=<%=cont.getContid()%>"
								class="btn btn-danger btn-sm text-white">Delete</a>

						</div>
					</div>
				</div>

			</div>
			<%
			}
			}
			%>
		</div>

	</div>

</body>
</html>