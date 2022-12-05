<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
	@SuppressWarnings("unchecked") 
	List<Member> userList = (List<Member>)request.getAttribute("userList");
	String curMemberId = (String)request.getAttribute("curMemberId");
--%>
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
</head>
<body>
<<<<<<< HEAD
<br>
<table style="width:100%">
  <tr>
  	<td width="20"></td>
    <td><a href="<c:url value='/member/logout' />">로그아웃(&nbsp;${curMemberId}&nbsp;)</a></td>
  </tr>
  <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
  <tr>
	<td width="20"></td>
	<td>
	  <table>
		<tr>
		  <td class="title">&nbsp;&nbsp;<b>사용자 관리 - 리스트</b>&nbsp;&nbsp;</td>
		</tr>
	  </table>  
	  <br>		  
	  <table style="background-color: YellowGreen">
		<tr>
		  <td width="190" align="center" bgcolor="E6ECDE" height="22">사용자 ID</td>
		  <td width="200" align="center" bgcolor="E6ECDE">이름</td>
		  <td width="200" align="center" bgcolor="E6ECDE">이메일</td>
		</tr>
<%-- 
	if (userList != null) {	
	  Iterator<User> userIter = userList.iterator();
	
	  //사용자 리스트를 클라이언트에게 보여주기 위하여 출력.
	  while ( userIter.hasNext() ) {
		User user = (User)userIter.next();
--%>	  	
	  <c:forEach var="member" items="${memberList}">  			  	
  		<tr>
		  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	${member.id}       <%-- <%=user.getUserId()%> --%>
		  </td>
		  <td width="200" bgcolor="ffffff" style="padding-left: 10">
			  ${member.name}	 <%-- <%=user.getName()%></a> --%>
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
		    ${member.email}        <%-- <%=user.getEmail()%> --%>
		  </td>
		</tr>
	  </c:forEach> 
<%--
	  }
	}
--%>	 
	  </table>	  	 
	  <br>   
	  <a href="<c:url value='/member/register' />">사용자 추가</a>
	  <br>   
	</td>
  </tr>
</table>  
=======
	<div>
		<form action="${pageContext.request.contextPath}/search/search">
			<input type="text" name="performanceName">
			<input type="submit" value="검색">
		</form>
	</div>

	<c:forEach var="list" items="${dtoList}" varStatus="status">
		<%-- <p>${banner.bannerImg} : <c:out value="${banner.rank}" /></p> --%>
		<br>
		<br>
		<br>
		
		<table onClick="location.href='${pageContext.request.contextPath}/performance/performance_info.jsp?performance_id=${list.PERFORMANCE_ID}'">
			<tr>
				<th rowspan="3"><img src="${list.img}"
					style="width: 30%"></th>
				<th>공연명: ${list.name}</th>
			</tr>
			<tr>
				<td>카테고리: ${list.category} 시간: ${list.runtime}
					관람연령: ${list.agegroup} 위치: ${list.site_link}</td>
			</tr>
			<tr>
				<td>출연진: ${list.cast}</td>
			</tr>
		</table>
		<hr>
	</c:forEach>
>>>>>>> branch 'main' of https://github.com/chjs918/PerformanceSystem.git
</body>
</html>