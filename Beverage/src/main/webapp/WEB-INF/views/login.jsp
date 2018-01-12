<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, intial-scale=1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="resources/css-file/login.css">
<title>Login</title>

</head>
<body>
<%@include file="header.jsp" %>
<h2 style="text-align: center;"><b>Login!!</b></h2>
<div class="container">
<form action="${pageContext.request.contextPath}/login" class="form-signin" metod="post">
<h3><lable>Email:</lable></h3>
<input type="text" name="username" class="login-box" required>

<h3><lable>Password</lable></h3>
<input type="password" name="password" class="login-box" required>

<button class="btn btn-lg btn-primary" type="submit">Login</button>
<button class="btn btn-lg btn-primary" type="reset">Cancel</button>

</form>
</div>
<div>
<%@include file= "footer.jsp" %>
</div>	
</body>
</html>