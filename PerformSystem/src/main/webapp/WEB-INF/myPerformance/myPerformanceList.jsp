<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Member member = (Member)request.getAttribute("member");
%>
<html>
<head>
<title>MY 공연</title>
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
			<td class="title">&nbsp;&nbsp;<b>MY 공연</b>&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
	    <br>
	    <table>
	      <tr>
	        <td width="120" align="center" bgcolor="E6ECDE" height="22">공연명</td>
			<!-- 여기에 공연명과 공연일 입력 -->
			<td width="470" bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="performance_name">
			</td>
			<td width="820" bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="performance_day">
			</td>
	      </tr>
	    </table>  	    
	  	<table style="background-color: YellowGreen">
	  	<!-- for each로 내 공연 정보 출력하기 -->
	  	  <c:forEach var="item" items="${list} varStatus="vs">
	  	    <tr>
	  	       <td><c:out value="${item.name}"/></td>
	  	       <td><c:out value="${item.startDate }"/></td>
	  	       <td><c:out value="${item.endDate }"/></td>
	  	    </tr>
	  	  </c:forEach>
	 	</table>
	    <br>
	    <a href="<c:url value='/user/update'>
	     		   <c:param name='userId' value='<%=user.getUserId()%>'/>
			 	 </c:url>">수정</a> &nbsp;
 	    <a href="<c:url value='/user/delete'>
				   <c:param name='userId' value='<%=user.getUserId()%>'/>
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