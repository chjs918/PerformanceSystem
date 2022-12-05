<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@page import="java.util.*, model.dto.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	ReviewDTO review = (ReviewDTO)request.getAttribute("review");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>리뷰 수정</title>
<script>
function reviewUpdate() {
	if (form.title.value == "") {
		alert("제목을 입력하십시오.");
		form.title.focus();
		return false;
	} 
	if (form.content.value == "") {
		alert("내용을 입력하십시오.");
		form.content.focus();
		return false;
	}
	form.submit();
}
</script>
</head>
<body>
<form name="form" method="POST" action="<c:url value='/performance/review_update' />">
  <table style="width:100%">
    <tr>
	  <td width="20"></td>
	  <td>
	    <table>
		  <tr>
			<td class="title">&nbsp;&nbsp;<b>리뷰 수정</b>&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
	    <br>	  	    
	  	<table style="background-color: #000000">
	  	  <tr>
			<td width="120" align="center" bgcolor="#D9D9D9" height="22">리뷰 작성자</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 2">
				<input type="text" style="width: 400px;" name="name" value="<%=review.getMember_name()%>" readonly>
			</td>
		  </tr>
		  <tr>
			<td width="120" align="center" bgcolor="#D9D9D9" height="22">제목</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 2">
				<input type="text" style="width: 400px;" name="title" value="<%=review.getTitle()%>">
			</td>
		  </tr>
		  <tr>
			<td width="120" align="center" bgcolor="#D9D9D9" height="22">내용</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 2">
				<textarea rows="20" cols="49" name="content"><%=review.getContent()%></textarea>
			</td>
		  </tr>
		  <tr>
		  	<td>
		  		<input type="hidden" name="performance_id" value="<%=review.getPerformance_id()%>">
		  		<input type="hidden" name="review_id" value="<%=review.getId()%>">
		  	</td>
		  </tr>
	 	</table>
	    <br>
	    <table style="width: 100%">
		  <tr>
			<td align="left">
			<input type="button" value="저장" onClick="reviewUpdate()"> &nbsp;
			<button type="button" onclick="history.back();">닫기</button>
			</td>
		  </tr>
	    </table>
	   </td>
    </tr>
  </table>
</form>
</body>
</html>