<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*, model.*" %>
<%@page import="java.util.*, model.dao.*" %>
<%@page import="controller.member.MemberSessionUtils" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>좌석 추천</title>
<%
	@SuppressWarnings("unchecked")
	Recommend recommend = (Recommend)request.getAttribute("recommend");
	Member member = (Member)request.getAttribute("member");
%>
</head>
<body>
	<div>
		<h2>[좌석 추천]</h2>
		<h3><%=member.getName()%>님께 추천드리는 좌석입니다.</h3>
		<div>
			<img src="../images/<%=recommend.getRecommend_img()%>" width="500" height="350"/>
			<h3>추천 좌석 : <%=recommend.getRecommend_seat()%></h3>
		</div> 
	</div>
	<div>
			<button type="button" onclick="history.back();">닫기</button>
	</div>
</body>
</html>