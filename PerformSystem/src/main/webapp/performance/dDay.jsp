<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.*" %>
<html>
<head>
<title>D-DAY</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
	var dday = new Date("March 20, 2023, 0:00:00").getTime();

	setInterval(function() {
  		var today = new Date().getTime();
  		var gap = dday - today;
  		var day = Math.ceil(gap / (1000 * 60 * 60 * 24));
  		var hour = Math.ceil((gap % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  		var min = Math.ceil((gap % (1000 * 60 * 60)) / (1000 * 60));
  		var sec = Math.ceil((gap % (1000 * 60)) / 1000);

 		document.getElementById("count").innerHTML = "해리 스타일스 내한공연 D-DAY까지 " + day + "일 남았습니다.";
	}, 1000);
</script>
</head>
<body>
<div id="count">

</div>
</body>
</html>