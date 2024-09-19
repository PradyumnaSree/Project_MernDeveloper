<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Mern_Project.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
LoginBean ab=(LoginBean)application.getAttribute("lBean");
out.println("Welcome "+ab.getF_USERNAME());
out.println((String)request.getAttribute("msg"));
%>
<br>
<a href="EDetails.html">Insert Employee Details</a><br>
<a href="Update.html">Update Employee Details</a><br>
<a href="Delete.html">Delete Employee Details</a><br>
<a href="retrieve">Show all Employee</a><br>
<a href="l">Logout</a>
</body>
</html>