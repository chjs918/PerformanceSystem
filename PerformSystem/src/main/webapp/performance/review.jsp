<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@page import="java.util.*, model.dao.*" %>
<%@page import="java.util.*, model.dto.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	@SuppressWarnings("unchecked") 
	List<ReviewDTO> reviewList = (List<ReviewDTO>)request.getAttribute("reviewList");
	int performance_id = reviewList.get(0).getPerformance_id();
%>
<html>
<head>
<title>리뷰 리스트</title>
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
	  Iterator<ReviewDTO> reviewIter = reviewList.iterator();
	
	  while ( reviewIter.hasNext() ) {
		  ReviewDTO review = (ReviewDTO)reviewIter.next();
%>	  	
  		<tr>
		  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	<%=review.getId() %>
		  </td>
		  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	<%=review.getMember_name()%>
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
			<a href="<c:url value='/performance/review_info'>
			<%
				String review_id = Integer.toString(review.getId());
			%>
					   <c:param name='review_id' value='<%=review_id%>'/>
					   <c:param name='command' value='info'/>
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
	  <table>
	  	<tr>
	  		<td>
	  			<form name="form" method="POST" action="<c:url value='/performance/review_add.jsp' />">
			  		<table>
						<tr>
							<td align=left>
								<input type="hidden" name="performance_id" value="<%=performance_id%>">
								<input type="hidden" name="command" value="add">
								<input type="button" value="추가" onClick="submit()">
							</td>
						</tr>
					</table>
				</form>
	  		</td>
	  		<td>
	  			<form name="form" method="POST" action="<c:url value='/performance/performance_info.jsp' />">
			  		<table>
						<tr>
							<td align=left>
								<input type="hidden" name="performance_id" value="<%=performance_id%>">
								<input type="hidden" name="command" value="info">
								<input type="button" value="닫기" onClick="submit()">
							</td>
						</tr>
					</table>
				</form>
	  		</td>
	  	</tr>
	  </table>
	  <br> 
	</td>
  </tr>
</table>  
</body>
</html>