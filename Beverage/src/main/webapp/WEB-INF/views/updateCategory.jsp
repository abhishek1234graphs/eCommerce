<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../resources/css-file/style.css">
<title>update category</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
<h2>Update Category here...!!</h2>
	<c:url value="/admin/categoryUpdate" var="ctu"></c:url>
	
		<form action="categoryUpdate" method="post">
				<input type="hidden" name="cid" value="${cat.cid }" >
				<br>
				<label>Category ID</label>
				<input type="number" name="cid" value="${cat.cid }" required/>
				<br><br>

				<label>Category Name</label>
				<input type="text" name="name" value="${cat.name }" required/>
				<br><br>
				<div class="wrapper">
					<button role="button" class="btn">Update</button>
					<button role="button" class="btn">Cancel</button>
				</div>
		</form>
		
</div>
</body>
</html>