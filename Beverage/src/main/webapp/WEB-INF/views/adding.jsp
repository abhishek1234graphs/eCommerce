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

<title>adding</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container1">
<div class="page-header">
<div class="container">
<div class="row"> 
<div class="col-md-8">
<div class="panel with-nav-tabs panel-primary">
<div class="panel-heading">
<ul class="nav nav-tabs" >
<li class="active"><a href="#tab1" data-toggle="tab1">Supplier</a></li>
<li><a href="#tab2" data-toggle="tab">Category</a></li>
<li><a href="#tab3" data-toggle="tab">Product</a></li>
</ul>
</div> 

<div class="panel-body" style="border: 2px solid black;">
<div class="tab-content">
<div class="tab-pane fade in active" id=tab1>
<form action="<c:url value="/admin/saveSupp"/>" method="post" class="form-signin" >
<span id="reauth-email" class="reauth-email"></span>
<h4 class="input-title">Supplier ID</h4>
<input class="form-control" type="number" name="sid" required/><br>

<h4 class="input-title">Supplier Name</h4>
<input class="form-control" type="text" name="supplierName" required/><br>

<button class="btn btn-primary" type="submit">Submit</button>
<button class="btn btn-warning" type="reset">Cancel</button>
						 
</form>
</div>
					

<div class="tab-pane fade" id=tab2>
<form action="<c:url value="/admin/saveCat"/>" method="post" class="form-signin">
<span id="reauth-email" class="reauth-email"></span>
<h4 class="input-title">Category ID</h4>
<input class="form-control" type="number" name="cid" required/><br>

<h4 class="input-title">Category Name</h4>
<input class="form-control" type="text" name="name" required/><br>

<button  class="btn btn-primary" type="submit">Submit</button>
<button  class="btn btn-warning" type="reset">Cancel</button>
									
</form>
</div>


<div class="tab-pane fade" id=tab3>
<form action="<c:url value="/admin/saveProduct"/>" method="post" class="form-signin" enctype="multipart/form-data"/>
<span id="reauth-email" class="reauth-email"></span>

<h4 class="input-title">Product Name</h4>
<input class="form-control" type="text" name="pName" required/></td><br>
<h4 class="input-title">Product Price</h4>
<input class="form-control" type="number" name="pPrice" required/></td><br>

<h4 class="input-title">Product Description</h4>
<input class="form-control" type="text" name="pDescription" required/></td><br>

<h4 class="input-title">Product Stock</h4>
<input class="form-control" type="number" name="pStock" required/></td><br>


<div class="from-group">								
<td>Select Category</td>
<td>
<select class="from-control" name="pCategory" required>
<option value="">----Category------</option>
<c:forEach items="${catList }" var="cat">
<option value="${cat.cid }">${cat.name }</option>
</c:forEach>
</select>
</td>
</div><br>

<div class="from-group">								
<td>Select Supplier</td>
<td>
<select class="from-control" name="pSupplier" required>
<option value="">------Supplier------</option>
<c:forEach items="${satList }" var="sat">
<option value="${sat.sid }">${sat.supplierName }</option>
</c:forEach>
</select>
</td>
</div><br>

<tr>
<div class="fileinput fileinput-new" data-provides="fileinput">
<tr>
<td>Product Image</td>
<td><input class="form-control" type="file" name="file" accept="resources/*"></td>
</tr>
</div>
</tr><br><br>
<button role="button" class="btn btn-primary">Submit</button>
<button role="button" class="btn btn-primary">Cancel</button>
</form>
</div>
</div>
</div>
</div>
</div>
</div>
<br>
<br>
<div>
<%@include file= "footer.jsp" %>	
</div>
</body>
</html>