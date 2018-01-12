<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
   <%--  <%@include file="header.jsp" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body
{
background-image: url("../resources/images/wall2.jpg");
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<title>categoryList</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container" align="center">
<h2 style="text-align: center; color:#4B0082;"><b>Category List</b></h2>
<table class="table table-hover" id="category" class="display" border="1" width="80" align="center">
<tr>
<th>Sr.No.</th>
<th>CID</th>
<th>Category Name</th>
<th class="span2">Action</th>
</tr> 

<c:if test="${empty catList }">
	<tr>
		<td colspan="3" align="center">No Records Exists</td>
</c:if>

<c:forEach var="c" varStatus="st" items="${catList }" >
	<tr>
		<td><c:out value="${st.count }"></c:out></td>

		<td><c:out value="${c.cid }"></c:out></td>

		<td><c:out value="${c.name }"></c:out></td>

		<td><c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
		<a class="btn btn-info" role="button" style="color: red;" 
		href="<c:url value="/admin/deleteCategory/${c.cid }"></c:url>"></i>Delete</a>
		<a class="btn btn-info" role="button" style="color: green;" 
		href="${contextRoot }/admin/updateCategory?cid=<c:out value="${c.cid }"></c:out>"></i>Edit</a>
		</td> 
	</tr>
</c:forEach>
</table>
</div>
<%@include file="footer.jsp" %> 
</body>
</html>