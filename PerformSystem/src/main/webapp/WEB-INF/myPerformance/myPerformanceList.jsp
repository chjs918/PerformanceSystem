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
<script>
function MemberRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
</script>
</head>
<body>
  <div>
  	<form action="myPerformanceSave.jsp" method="get">
		<b>MY 공연!!</b> 
	    <br>
	    <table>
	      <tr>
	        <td width="120" align="center" bgcolor="E6ECDE" height="22">공연명</td>
			<td width="470" bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="performance_name">
			</td>
		  </tr>
		  <tr>
		    <td width="120" align="center" bgcolor="E6ECDE" height="22">공연일</td>
			<td width="820" bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="performance_date">
			</td>
		  </tr>
	    </table>
		  <input type="submit" value="등록">
  	</form>
  </div>
<table>
<%
	ArrayList<MyPerformance> list = (ArrayList<MyPerformance>)session.getAttribute("list");
	
	if (list != null) {
		for(int i=0;i<list.size();i++) {
%>
<tr>
  <td><%=list.get(i).getName() %></td>
  <td><%=list.get(i).getDate() %></td>
</tr>
<%
		}
	} else {
%>
	<tr><td>내가 예매한 공연이 없습니다.</td></tr>
<%} %>
</table>
</body>
</html>