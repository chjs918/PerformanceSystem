<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.*" %>
<html>
<head>
<title>D-DAY!!!</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
  window.onload = function() {
	  var today = new Date();
	  var anniversary = new Date(2022, 11, 20);
	  var count = today.getTime() - anniversary.getTime();
	  count = Math.ceil(count/(24*60*60*1000));
	  var anni = ducument.getElementById("anni");
	  anni.innerHTML = "<FONT size='2'>" + count + </font>";
  }
</script>
</head>
<body>
<span id = "anni" style=";"></span>
</body>
</html>