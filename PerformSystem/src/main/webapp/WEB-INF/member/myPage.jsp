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
<script>
function userRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
</script>
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
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">이름</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getName()%>
			</td>
		  </tr>	
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">비밓번호</td>
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
<%-- 		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">생년원일</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getBirth()%>
			</td>
		  </tr>	 --%>
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
	    <a href="<c:url value='/user/update'>
	     		   <c:param name='userId' value='<%=member.getId()%>'/>
			 	 </c:url>">수정</a> &nbsp;
 	    <a href="<c:url value='/user/delete'>
				   <c:param name='userId' value='<%=member.getId()%>'/>
			 	 </c:url>" onclick="return userRemove();">삭제</a> &nbsp;
 	    <a href="<c:url value='/user/list' />">목록</a> 	    
 	    <br><br>	   
 	    
 	    <!-- 수정 또는 삭제가  실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${updateFailed || deleteFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>    
	  </td>
	</tr>
  </table>  
</body>

</html>