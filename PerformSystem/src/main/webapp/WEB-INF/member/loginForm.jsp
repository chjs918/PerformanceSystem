<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>로그인</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function login() {
	if (form.userId.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.userId.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}		
	form.submit();
}

function memberCreate(targetUri) {
	form.action = targetUri;
	form.method="GET";		// register form 요청
	form.submit();
}
</script>
</head>
<body>
<br>
<!-- login form  -->
<form name="form" method="POST" action="${pageContext.request.contextPath}/member/login">
    <div class="main">
        <div> Performance System </div>
        <div>
            <input type="text" size="30" name="userId">
            <p/>
            <input type="password" size="30" name="password">
            <p/>
            <input type="button" class="btn" value="로그인" onClick="login()">
            <input type="button" class="btn" value="회원가입" onClick="memberCreate('${pageContext.request.contextPath}/member/register')">&nbsp;
        </div>
        <div>(관리자 로그인: admin/admin) </div>
    </div>
</form>
</body>
</html>