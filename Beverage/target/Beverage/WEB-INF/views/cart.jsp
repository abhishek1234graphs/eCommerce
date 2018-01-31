<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body
{
background-image: url("resources/images/wall2.jpg");
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<title>Cart</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
	<h1>CART</h1>
	<table class="table table-hover table-condenced" id="cart">
<thead>
<tr>
<th>Product Name</th>
<th>Quantity</th>
<th>Price</th>
<th>Image</th>
<th>Total</th>
<th>Action</th>
</tr> 
</thead>
		
<tbody>
<c:if test="${empty cartInfo}">
<tr>
<td colspan="9" align="center">No Records Exists</td>
</tr>
</c:if>

<c:forEach var="c" varStatus="st" items="${cartInfo }" >
<tr>
<td><c:out value="${c.cartProductName }"></c:out></td>
<td><c:out value="${c.cartStock}"></c:out></td>
<td><c:out value="${c.cartPrice }"></c:out></td>
		
<td><img src="${pageContext.request.contextPath}/resources/<c:out value='${c.cartImage}'></c:out>"height="50px" width="50px"></td>
		
<td><c:out value="${c.cartStock * c.cartPrice }"></c:out></td>
		
<td><a href="${pageContext.request.contextPath}/deleteCart/${c.cartId}" class="btn btn-danger"><i class="fa fa-trash-o" aria-hidden="true" ></i>Delete</a></td>
<c:set var="gtot" value="${gtot + c.cartPrice * c.cartStock}"></c:set>
				</tr>
</c:forEach>

<tr>
				
<td>
				
<span class="col-lg-9" align="right"><b>Grand Total: </b><c:out value="${gtot}"></c:out></span>		<!--show grand total  -->
</td>
</tr>
</tbody>
			
<tfoot>
<tr>
<td><a href="${pageContext.request.contextPath}/index" class="btn btn-warning">
<i class="fa fa-angle-double-left" aria-hidden="true"></i> Continue Shopping</a>
</td>
<c:if test="${not empty cartInfo}">
<td><a href="${pageContext.request.contextPath}/checkout" class="btn btn-success btn-block">Checkout
<i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
					</td>
				</c:if>
			</tr>
		</tfoot>
	</table>
</div>	
</body>
</html>