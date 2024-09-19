<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Mern_Project.*"
    import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String msg = (String) request.getAttribute("msg");   
out.println(msg);
List<CreateAdminBean> list = (List<CreateAdminBean>) request.getAttribute("list");
out.println(list);   
%>
<%@include file= "LoginSuccess.jsp"%>
</body>
</html> 