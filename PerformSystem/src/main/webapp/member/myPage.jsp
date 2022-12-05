<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Member member = (Member)request.getAttribute("member");
%>
<html>
<head>
<title>MY PAGE</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
</head>
<body>
  <br>
  <table style="width:100%">
    <tr>
	  <td width="20"></td>
	  <td>
	    <table>
		  <tr>
			<td class="title">&nbsp;&nbsp;<b>MY PAGE</b>&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
	    <br>	  	    
	  	<table style="background-color: YellowGreen">
	  	  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">아이디</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getId()%>
			</td>
		  </tr>
		  <tr><!-- 마이페이지에서 비밀번호 변경 뿐만 아니라 사용자의 모든 정보를 변경할 수 있다. -->
			<td width="120" align="center" bgcolor="E6ECDE" height="22">비밀번호</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getPassword()%>
			</td>
		  </tr>
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">성별</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getGender()%>
			</td>
		  </tr>
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">이메일</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getEmail()%>
			</td>
		  </tr>
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">구역</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getArea()%>
			</td>
		  </tr>	
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">체력</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getStrength()%>
			</td>
		  </tr>	
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">스탠딩/지정석</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getTypes()%>
			</td>
		  </tr>	
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">가까이</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getViews()%>
			</td>
		  </tr>	
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">안정적</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getStable()%>
			</td>
		  </tr>	  		  	  
	 	</table>
	    <br>
 	    <br><br>	   
	  </td>
	</tr>
  </table>  
</body>

</html>