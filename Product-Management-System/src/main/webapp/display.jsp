<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% LocalDateTime dateTime = (LocalDateTime)request.getAttribute("time"); %>

	<h1><%= dateTime.toString()%></h1>

</body>
</html>