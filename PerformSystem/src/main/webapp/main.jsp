<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="overflow:scroll">
<script type="text/javascript">
function myPage(){
    if(confirm("마이 페이지로 이동합니다")){
        location.href = "member/myPage.jsp";
        return true;
    } else {
        return false;
    }
}
</script>

<table>
	<tr>
		<td></td>
		<td></td>
		<td><iframe src=<%= request.getContextPath()+"/search/search"%>></iframe></td>
	</tr>
	<tr>
		<td>
			<%@ include file="/member/loginForm.jsp"%>  <a href="#"
			onclick="myPage();">회원 정보</a></td>
		<td><
			 <%@ include file="/calendar/calendar.jsp"%> </td>
		<td></td>
	</tr>
	<tr>
	<td colspan="3"><iframe
				src=<%= request.getContextPath()+"/banner/rankBanner"%> width="100%"></iframe></td>
	</tr>
</table>

</html>