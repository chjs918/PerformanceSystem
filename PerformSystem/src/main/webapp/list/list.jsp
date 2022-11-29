<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath}/search/search">
			<input type="text" name="performanceName">
			<input type="submit" value="검색">
		</form>
	</div>

	<c:forEach var="list" items="${dtoList}" varStatus="status">
		<%-- <p>${banner.bannerImg} : <c:out value="${banner.rank}" /></p> --%>
		<br>
		<br>
		<br>
		
		<table onClick="location.href='${pageContext.request.contextPath}/performance/performance_info.jsp'">
			<tr>
				<th rowspan="3"><img src="../images/${list.img}"
					style="width: 100%"></th>
				<th>공연명: ${list.name}</th>
			</tr>
			<tr>
				<td>카테고리: ${list.category} 시간: ${list.runtime}
					관람연령: ${list.agegroup} 위치: ${list.site_link}</td>
			</tr>
			<tr>
				<td>출연진: ${list.cast}</td>
			</tr>
		</table>
		<hr>
	</c:forEach>
</body>
</html>