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

</head>
<body>
	<%@include file="navbar.jsp"%>
	<%
	if (use == null) {
		session.setAttribute("logOut", "Please login");

		response.sendRedirect("login.jsp");
	}
	%>
<div class="container-fluid">
		<div class="row p-5 mt-5">

			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-dark ">Edit Contact Page</h4>
						<%
						String failed = (String) session.getAttribute("failed");
						String success = (String)session.getAttribute("success");

						if (failed != null) {
						%>
						<h4 class="text-danger text-center"><%=failed%></h4>
						<%
						session.removeAttribute("failed");
						}

						if(success!=null){%>
							<h4 class="text-danger text-center"><%=success%></h4>
							<%session.removeAttribute("success"); }%>
					
						<form action="updateServlet">
							<%
							int cid = Integer.parseInt(request.getParameter("cid"));
							contactdao dao = new contactdao();
							Contact cont = dao.getContactById(cid);
							 %>

							<input type="hidden" value="<%=cid%>" name="cid">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input value="<%=cont.getContname() %>"
									type="text" class="form-control" name="name"
									
									placeholder="Enter name">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input  value="<%=cont.getContemail() %>"
									type="email" class="form-control" name="email"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter mobile number</label> <input   value="<%=cont.getContphone() %>"
									type="number" class="form-control" name="number"
									id="exampleInputnumber" aria-describedby="emailHelp"
									placeholder="Enter mobile number">

							</div>


							<div class="form-group">
								<textarea rows="3" cols="" placeholder="Enter about"  
									name="about" class="form-control"><%=cont.getAbout() %></textarea>
							</div>
							<div class="text-center mt-3 ">
								<button type="submit" class="btn btn-primary">Update</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 11%">
		<%@include file="footer.jsp"%>
	</div></body>
</html>