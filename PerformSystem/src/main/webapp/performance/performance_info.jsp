<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@page import="java.util.*, model.dao.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<%
	@SuppressWarnings("unchecked")
	//Performance performance = (Performance)request.getAttribute("performance");
	int performance_id = 2;
	PerformanceDAO performanceDao = new PerformanceDAO();
	Performance performance = (Performance)performanceDao.findPerformance(performance_id);
	//request.setAttribute("performance_id", performance_id);
%>
<title>공연 상세 정보 페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/performance.css' />" type="text/css">
<script>
function recommend() {
	form.submit();
}
</script>
</head>
<body>
	<div>
		<div>
			<h1><%=performance.getName()%></h1>
		</div>
		<div>
			<img src="<%=performance.getImg()%>" width="220" height="430"/>
		</div>
		<div>
			<p><b>공연 기간 : </b> <%=performance.getStartDate()%> ~ <%=performance.getEndDate()%></p>
			<p><b>공연 시간 : </b> <%=performance.getRunTime()%>분</p>
			<p><b>관람 연령 : </b> 만 <%=performance.getAgeGroup()%>세 이상 관람가</p>
			<p><b>출연진 : </b> <%=performance.getCast()%></p>
			<p><b>장소 : </b> <%=performance.getVenue()%></p>
			<p><b>가격 : </b> <%=performance.getPrice()%></p>
			<p><b>예매처 : </b> <%=performance.getLink()%></p>
			<p>
		</div>
		<div>
			<form name="form" method="POST" action="<c:url value='/performance/recommend' />">
  				<table>
					<tr>
						<td align=left>
						<input type="hidden" name="performance_id" value="<%=performance.getId()%>">
						<input type="button" value="좌석 추천" onClick="recommend()">
						</td>
					</tr>
				</table>
			</form>
			<button type="button" onclick="location.href='/performance/review'">리뷰 보기</button>
		</div>
	</div>
</body>
</html>