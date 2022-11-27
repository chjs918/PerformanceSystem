<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@page import="java.util.*, model.dao.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Review review = (Review)request.getAttribute("review");
%>
<html>
<head>
<title>리뷰 상세 보기</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function reviewRemove() {
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
			<td class="title">&nbsp;&nbsp;<b>리뷰</b>&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
	    <br>	  	    
	  	<table style="background-color: YellowGreen">
	  	  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">리뷰 작성자</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=review.getMember_id()%>
			</td>
		  </tr>
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">제목</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=review.getTitle()%>
			</td>
		  </tr>
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">이메일 주소</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=review.getContent()%>
			</td>
		  </tr>
	 	</table>
	    <br>
	    <!--
	    <a href="<c:url value='/performance/reviewUpdate'>
	     		   <c:param name='review_id' value='<%=review.getId()%>'/>
			 	 </c:url>">수정</a> &nbsp;
 	    <a href="<c:url value='/performance/reviewDelete'>
				   <c:param name='review_id' value='<%=review.getId()%>'/>
			 	 </c:url>" onclick="return reviewRemove();">삭제</a> &nbsp;
 	    <a href="<c:url value='/performance/review' />">리뷰 목록</a> 	    
 	    <br><br>
 	    -->	   
 	    
 	    <!-- 수정 또는 삭제가  실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${updateFailed || deleteFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>    
	  </td>
	</tr>
  </table>  
</body>
</html>