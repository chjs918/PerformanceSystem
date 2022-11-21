<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/nextTo.css">
<script src="nextTo.js"></script>
<head>

<meta charset="EUC-KR">
<title>rank banner</title>
</head>
<body>


<div class="container">
  <div class="mySlides">
    <div class="numbertext">1 / 6</div>
    <img src="../images/공연1.png" style="width:100%">
  </div>

  <div class="mySlides">
    <div class="numbertext">2 / 6</div>
    <img src="../images/공연2.png" style="width:100%">
  </div>

  <div class="mySlides">
    <div class="numbertext">3 / 6</div>
    <img src="../images/공연3.png" style="width:100%">
  </div>
    
  <div class="mySlides">
    <div class="numbertext">4 / 6</div>
    <img src="../images/공연4.png" style="width:100%">
  </div>

  <div class="mySlides">
    <div class="numbertext">5 / 6</div>
    <img src="../images/공연5.png" style="width:100%">
  </div>
    
  <div class="mySlides">
    <div class="numbertext">6 / 6</div>
    <img src="../images/공연6.png" style="width:100%">
  </div>
    
  <a class="prev" onclick="plusSlides(-1)"><</a>
  <a class="next" onclick="plusSlides(1)">></a>

  <div class="caption-container">
    <p id="caption"></p>
  </div>

  <div class="row">
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
</div>

</body>
</html>