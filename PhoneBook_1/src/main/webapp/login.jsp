<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #d9dadb">
<%@include file="navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-5 mt-5">

			<div class="col-md-5 offset-md-3 ">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-dark ">Login form</h4>
					
					<% String logOut = (String)session.getAttribute("logOut");
					if(logOut!=null)
					{
					%>
					<p class="text-danger text-center"><%= logOut %></p> 
					
					<% session.removeAttribute("logOut");
					} %>
					
						<form action="loginservlet">
						<%String invalid = (String)session.getAttribute("invalid");

						if (invalid != null) {
						%>
						<h4 class="text-danger text-center"><%=invalid%></h4>
						<%
						session.removeAttribute("invalid");
						}%>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" name="emai" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email">
								
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" name="passwor"class="form-control" id="exampleInputPassword1"
									placeholder="Password">
							</div>
							
							<div class="text-center mt-3 ">
							<button type="submit" class="btn btn-primary">Login</button></div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top:16%">
	<%@include file="footer.jsp" %>
	</div>
</body>
</html>