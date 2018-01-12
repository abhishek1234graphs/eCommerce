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

<title>focus</title>

</head>
<body>
<%@include file="header.jsp" %>


<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
<ol class="carousel-indicators">
<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
<li data-target="#myCarousel" data-slide-to="1" class="active"></li>
<li data-target="#myCarousel" data-slide-to="2" class="active"></li>
<li data-target="#myCarousel" data-slide-to="3" class="active"></li>
</ol>

<div class="carousel-inner">
<div class="carousel-inner" role="listbox" style=" width:100%; height: 500px !important;">
<div class="item active">
<img src="resources/pic1.jpg" style="width:100%; height:50%">

</div>
<div class="item">
<img src="resources/pic2.jpg" style="width:100%;height:50%">

</div>
<div class="item">
<img src="resources/pic3.jpg" style="width:100%;height:20%">
</div>

<div class="item">
<img src="resources/pic4.jpg" style="width:100%;height:20%">
</div>
</div>
</div>
<a class="left carousel-control" href="#myCarousel" data-slide="prev">
<span class="glyphicon glyphicon-chevron-left"></span>
<span class="sr-only">Previous</span>
</a>
<a class="right carousel-control" href="#myCarousel" data-slide="next">
<span class="glyphicon glyphicon-chevron-right"></span>
<span class="sr-only">Next</span>
</a>
</div>
</div>
<br><br>

<div class="container">
<div style="overflow:auto; background-color: white">
<div class= "col-lg-4">

<img src="resources/img1.jpg" width="350" height="250"/></div>
<div class= "col-lg-4">
<img src="resources/img2.jpg" width="350" height="250"/></div>
<div class= "col-lg-4">
<img src="resources/img3.jpg" width="350" height="250"/></div>
</div> 
</div>

<br>
<br>
<br>
<div>
 <%@include file="footer.jsp" %> 
</div>
</body>
</html>