<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, intial-scale=1">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<title>updateProduct</title>

</head>
<body>

<div class="container">

<c:url value="/productUpdate" var="pru"></c:url>
<form action="productUpdate" method="post" class="form-signin" enctype="multipart/form-data">
<span id="reauth-email" class="reauth-email"></span>

<input type="hidden" name="pid" value="${prod.id}">

<h4 class="input-title">Product Name</h4>
<input value="${prod.name}" type="text" name="pName" required/></td><br>

<h4 class="input-title">Product Price</h4>
<input value="${prod.price }" type="number" name="pPrice" required/></td><br>

<h4 class="input-title">Product Description</h4>
<input value="${prod.description}" type="text" name="pDescription" required/></td><br>

<h4 class="input-title">Product Stock</h4>
<input value="${prod.stock}" type="number" name="pStock" required/></td><br>


<div class="from-group">
<table>
<tr>							
<td>Select Category</td>
<td>
<select class="from-control" name="pCategory" required>
<option value="">----Category------</option>
<c:forEach items="${catList }" var="cat">
<option value="${cat.cid }">${cat.name }</option>
</c:forEach>
</select>
</td>
</tr>
</table>
</div><br>

<div class="from-group">
<table>								
<td>Select Supplier</td>
<td>
<select class="from-control" name="pSupplier" required>
<option value="">------Supplier------</option>
<c:forEach items="${satList }" var="sat">
<option value="${sat.sid }">${sat.supplierName }</option>
</c:forEach>
</select>
</td>
</table>
</div><br>

<div class="fileinput fileinput-new" data-provides="fileinput">

<td>Product Image</td>
<td><input class="form-control" type="file" name="file" accept="resources/*"></td>

</div>
<br><br>
<button role="button" class="btn btn-primary">Update</button>
<button role="button" class="btn btn-primary">Cancel</button>
</form>
</div>
</body>
</html>