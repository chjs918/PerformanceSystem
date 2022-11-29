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
		<form>
			<input type="text" name="performanceName">
			<button>검색</button>
		</form>
	</div>
	<c:forEach var="searchResult" items="${dtoList}" varStatus="status">
		<%-- <p>${banner.bannerImg} : <c:out value="${banner.rank}" /></p> --%>
		<br>
		<br>
		<br>
		<table onClick="location.href='${pageContext.request.contextPath}/performance/performance_info.jsp'">
			<tr>
				<th rowspan="3"><img src="../images/${searchResult.img}" style="width: 100%"></th>
				<th>공연명: ${searchResult.name}</th>
			</tr>
			<tr>
				<td>카테고리: ${searchResult.category} 시간: ${searchResult.runtime} 관람연령: ${searchResult.agegroup} 위치: ${searchResult.site_link}</td>
			</tr>
			<tr>
				<td>출연진: ${searchResult.cast}</td>
			</tr>
		</table>
		<hr>
	</c:forEach>

</body>
</html>