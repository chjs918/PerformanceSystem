<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Member member = (Member)request.getAttribute("member");
%>

<html>
<head>
<title>MY 공연</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/Member.css' />" type="text/css">
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	

	ArrayList<MyPerformance> list = (ArrayList<MyPerformance>)session.getAttribute("list");
	
	if (list == null) {
		list = new ArrayList<>();
	}
	 
	String name = request.getParameter("performance_name");
	String date = request.getParameter("performance_date");
	
	MyPerformance mp = new MyPerformance();
	
	mp.setName(name);
	mp.setDate(date);
	
	list.add(mp);
	session.setAttribute("list", mp);
	response.sendRedirect("myPerformanceList.jsp");
%>
</body>
</html>