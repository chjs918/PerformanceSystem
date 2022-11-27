<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*, model.*" %>
<%@page import="java.util.*, model.dao.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
	@SuppressWarnings("unchecked")
	Recommend recommend = (Recommend)session.getAttribute("recommend");
	Member member = (Member)session.getAttribute("member");
%>
</head>
<body>
	<div>
		<h1>좌석 추천</h1>
		<h3><%=member.getName()%>님께 추천드리는 좌석입니다.</h3>
		<div>
			<img src="<%=recommend.getRecommend_img()%>" width="220" height="430"/>
			<h2><%=recommend.getRecommend_seat()%></h2>
		</div>
	</div>
	<div>
			<button type="button" onclick="history.back();">닫기</button>
	</div>
</body>
</html>