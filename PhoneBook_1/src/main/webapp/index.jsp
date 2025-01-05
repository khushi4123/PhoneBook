<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss.jsp"%>
<style>
.back-img {
	background-image:
		url("https://media.istockphoto.com/id/1811047120/vector/set-of-hands-holding-smartphone-flat-vector-illustration-people-use-smartphones-surfing-in.jpg?s=612x612&w=0&k=20&c=wDM3vIk9Y-yh3SLw2ytzqbrVEn0VXBxXHt98YgBvkxI=");
	height: 85vh;
	background-repeat: no-repeat;
	background-size: 100%;
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	
	<div class="container-fluid back-img text-center text-success  ">
		<h1 class="m-1">Welcome to PhoneBook App</h1>
	</div>
	<%

	%>

	<%@include file="footer.jsp"%>


</body>
</html>