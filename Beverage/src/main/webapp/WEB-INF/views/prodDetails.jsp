<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body
{
background-color:white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<title>productDetails</title>
</head>


<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
<div class="row">

<div class="col-sm-4 item-photo">
<img style="max-width::100%, margin-top:30px;"
src="${pageContext.request.contextPath }/resources/${prod.imgname}"/>
</div>

<div class="col-sm-5" style="border:0px solid gray">
<h3>${prod.name }</h3>
<h4>${prod.description }</h4>
<h4>${prod.price }</h4>
<h5>${prod.supplier.supplierName }</h5>
<div class="section" style="padding-botton:20px;">

<form action="${pageContext.request.contextPath }/addToCart" method="post">
<input type="hidden" value="${prod.id }" name="pid"/>
<input type="hidden" value="${prod.price }" name="pPrice"/>
<input type="hidden" value="${prod.name }" name="pName"/>
<input type="hidden" value="${prod.stock }" name="quant"/>
<input type="hidden" value="${prod.imgname }" name="imgname"/>

<label>Quantity</label><input type="number" class="form-control" name="qty" require/><br><br>
<input class="btn btn-warning btn-lg" type="submit" value="Add To Cart">
<h6><span class="glyphicon-heart-empty" style="cursor:pointer"></span>Wish List</h6>
</form>
</div>
</div>
<hr>
<div class="col-sm-9">

<ul class="menu-items">
</ul>
</div>

<br><br>

</div>
</div>
</body>
</html>