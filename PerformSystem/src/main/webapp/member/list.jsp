<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
   @SuppressWarnings("unchecked") 
   List<Member> userList = (List<Member>)request.getAttribute("userList");
--%>
<% 
   String name = (String)request.getAttribute("name");
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
  <tr>
     <td width="20"></td>
    <td><a href="<c:url value='/member/logout' />">로그아웃(&nbsp;${curMemberId}&nbsp;)</a></td>
    <td><button type="button" onclick="location.href='/PerformSystem/main'">홈</button></td>
     <td><a href="<c:url value='/member/myPage'><c:param name='id' value='admin'/></c:url>">마이페이지(&nbsp;${curMemberId}&nbsp;)</a></td>
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
           ${member.name}    <%-- <%=user.getName()%></a> --%>
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
</body>
</html>