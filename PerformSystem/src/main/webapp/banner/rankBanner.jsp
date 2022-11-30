<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/nextTo.css">
<script src="nextTo.js"></script>
<head>

<meta charset="EUC-KR">
<title>rank banner</title>
</head>
<body>
	<div class="row">
	 <c:forEach var="banner" items="${dtoList}" varStatus="status">
			<div class="column">
				<img class="demo cursor" src="../images/${banner.bannerImg}"
					style="width:100%" onclick="currentSlide(${banner.rank})" alt="${banner.rank}">
			</div>
	</c:forEach>
	</div>


  <<!-- div class="row">
    <div class="column">
      <img class="demo cursor" src="../images/공연1.png" style="width:100%" onclick="currentSlide(1)" alt="1">
    </div>
    <div class="column">
      <img class="demo cursor" src="../images/공연2.png" style="width:100%" onclick="currentSlide(2)" alt="2">
    </div>
    <div class="column">
      <img class="demo cursor" src="../images/공연3.png" style="width:100%" onclick="currentSlide(3)" alt="3">
    </div>
    <div class="column">
      <img class="demo cursor" src="../images/공연4.png" style="width:100%" onclick="currentSlide(4)" alt="4">
    </div>
    <div class="column">
      <img class="demo cursor" src="../images/공연5.png" style="width:100%" onclick="currentSlide(5)" alt="5">
    </div>    
    <div class="column">
      <img class="demo cursor" src="../images/공연6.png" style="width:100%" onclick="currentSlide(6)" alt="6">
    </div>
  </div>
</div>  -->

</body>
</html>