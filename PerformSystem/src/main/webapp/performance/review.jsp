<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@page import="java.util.*, model.dao.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	@SuppressWarnings("unchecked") 
	//List<Review> reviewList = (List<Review>)request.getAttribute("reviewList");
	ReviewDAO reviewDao = new ReviewDAO();
	List<Review> reviewList = (List<Review>)reviewDao.findReviewList(1);
%>
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
</head>
<body>
<br>
<table style="width:100%">
  <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
  <tr>
	<td>
	  <table>
		<tr>
		  <td class="title">&nbsp;&nbsp;<b>리뷰 목록</b>&nbsp;&nbsp;</td>
		</tr>
	  </table>  
	  <br>		  
	  <table style="background-color: '#000000'">
		<tr>
			<td width="190" align="center" bgcolor="#D9D9D9" height="22">글 번호</td>
		  <td width="190" align="center" bgcolor="#D9D9D9" height="22">리뷰 작성자</td>
		  <td width="200" align="center" bgcolor="#D9D9D9">제목</td>
		</tr>
<%
	if (reviewList != null) {	
	  Iterator<Review> reviewIter = reviewList.iterator();
	
	  while ( reviewIter.hasNext() ) {
		  Review review = (Review)reviewIter.next();
%>	  	
  		<tr>
		  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	<%=review.getId() %>
		  </td>
		  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	<%=review.getMember_id() %>
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
			<a href="<c:url value='/performance/review_info.jsp'>
			<%
				String review_id = Integer.toString(review.getId());
			%>
					   <c:param name='review_id' value='<%=review_id%>'/>
			 		 </c:url>">	
			<%=review.getTitle() %></a>
		  </td>
		</tr>
<%
	  }
	}
%>		 
	  </table>
	  <br>	  
	  <button type="button" onclick="history.back();">닫기</button>	 
	  <br>   
	  <%-- <a href="<c:url value='/user/register' />">리뷰 추가</a> --%>
	</td>
  </tr>
</table>  
</body>
</html>