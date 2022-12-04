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
<link rel=stylesheet href="<c:url value='/css/MyPerformance.css' />" type="text/css">
<script>
function performanceCreate() {
	form.submit();
}
function performanceList(targeri) {
	form.action = targetUri;
	form.submit();
}
</script>
</head>
<body>
  <div>
  	<form name="form" action="<c:url value='/myPerformance/myPerformanceList' />" method="post">
		<b>MY 공연!!</b> 
	    <br>
	    <table class="pTable">
	    <tr>
	        <td width="120" align="center" bgcolor="E6ECDE" height="22">회원명</td>
			<td width="470" bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="member_name">
			</td>
		  </tr>
	     <tr>
	        <td width="120" align="center" bgcolor="E6ECDE" height="22">공연명</td>
			<td width="470" bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="performance_name">
			</td>
		  </tr>
	      <tr>
	        <td width="120" align="center" bgcolor="E6ECDE" height="22">공연일(YYYYMMDD)</td>
			<td width="470" bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="performance_date">
			</td>
		  </tr>
	    </table>
	    <br>
	    <table>
	     <tr>
	      <td>
		   <input type="button" value="등록" onClick="performanceCreate(
			   '<c:url value='/myPerformance/myPerformanceList'/>')">
		  </td>
		 </tr> 
		</table>
  	</form>
  </div>
<table style="background-color: YellowGreen">
		<tr>
		  <td width="190" align="center" bgcolor="E6ECDE" height="22">회원명</td>
		  <td width="200" align="center" bgcolor="E6ECDE">공연명</td>
		  <td width="200" align="center" bgcolor="E6ECDE">공연일</td>
		</tr>
	  <c:forEach var="myPerformance" items="${myPerformanceList}">  			  	
  		<tr>
		  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	${myPerformance.mname}       <%-- <%=user.getUserId()%> --%>
		  </td>
		  <td width="200" bgcolor="ffffff" style="padding-left: 10">
			  ${myPerformance.name}	 <%-- <%=user.getName()%></a> --%>
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
		    ${myPerformance.date}        <%-- <%=user.getEmail()%> --%>
		  </td>
		</tr>
	  </c:forEach>  
</table>

</body>
</html>