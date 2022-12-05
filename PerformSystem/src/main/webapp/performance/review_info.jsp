<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@page import="java.util.*, model.dao.*" %>
<%@page import="java.util.*, model.dto.*" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	ReviewDTO review = (ReviewDTO)request.getAttribute("review");
	int member_id = (int)request.getAttribute("member_id");
%>
<html>
<head>
<title>리뷰 상세 보기</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function reviewUpdate() {
	if (<%=member_id%> != <%=review.getMember_id()%>) {
		alert("회원님의 글이 아닙니다.");
		return false;
	}
	form.submit();
}
function reviewRemove() {
	if (<%=member_id%> != <%=review.getMember_id()%>) {
		alert("회원님의 글이 아닙니다.");
		return false;
	}
	if (confirm("정말 삭제하시겠습니까?") == false) {
		return false;
	}
	form2.submit();
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
	  	<table style="background-color: '#000000'">
	  	  <tr>
			<td width="120" align="center" bgcolor="#D9D9D9" height="22">리뷰 작성자</td>
			<td width="400" bgcolor="ffffff" style="padding-left: 5">
				<%=review.getMember_name()%>
			</td>
		  </tr>
		  <tr>
			<td width="120" align="center" bgcolor="#D9D9D9" height="22">제목</td>
			<td width="400" bgcolor="ffffff" style="padding-left: 5">
				<%=review.getTitle()%>
			</td>
		  </tr>
		  <tr>
			<td width="120" align="center" bgcolor="#D9D9D9" height="22">내용</td>
			<td width="400" height="300" bgcolor="ffffff" style="padding-left: 10">
				<%=review.getContent()%>
			</td>
		  </tr>
	 	</table>
	    <br>
	    <div>
	    	<table>
	    		<tr>
	    			<td>
	    				<form name="form" method="POST" action="<c:url value='/performance/review_updateForm' />">
			  				<table>
								<tr>
									<td align=left>
									<input type="hidden" name="review_id" value="<%=review.getId()%>">
									<input type="hidden" name="command" value="update">
									<input type="button" value="수정" onClick="reviewUpdate()">
									</td>
								</tr>
							</table>
						</form>
	    			</td>
	    			<td>
	    				<form name="form2" method="POST" action="<c:url value='/performance/review_delete' />">
			  				<table>
								<tr>
									<td align=left>
									<input type="hidden" name="review_id" value="<%=review.getId()%>">
									<input type="hidden" name="performance_id" value="<%=review.getPerformance_id()%>">
									<input type="button" value="삭제" onClick="reviewRemove()">
									</td>
								</tr>
							</table>
						</form>
	    			</td>
	    			<td>
	    				<button type="button" onclick="history.back();">목록</button>
	    			</td>
	    		</tr>
	    	</table>
		</div>
 	    <!-- 수정 또는 삭제가  실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${updateFailed || deleteFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>    
	  </td>
	</tr>
  </table>  
</body>
</html>