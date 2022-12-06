<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="overflow:scroll">
<style>
.class {
 border: thick double #32a1ce;
  width: 400px;
  height: 100px;
}
</style>
<script type="text/javascript">
function myPage(){
    if(confirm("마이 페이지로 이동합니다")){
        location.href = "member/myPage.jsp";
        return true;
    } else {
        return false;
    }
}
function inform(){
    if(confirm("회원 정보로 이동합니다")){
        location.href = "/myPerformance/myPerformanceList.jsp";
        return true;
    } else {
        return false;
    }
}
</script>

<table>
	<tr>
		<td><h1 class="class">안녕</h1></td>
		<td></td>
		<td><iframe src=<%= request.getContextPath()+"/search/search"%>></iframe></td>
	</tr>
	<tr>
		<td class="class">
			<%@ include file="/member/loginForm.jsp"%>  
			<a href="#" onclick="myPage();">회원 정보</a></td>
		<td>
			 <%@ include file="/calendar/calendar.jsp"%> </td>
		<td class="class"><a href="#" onclick="myPage();">My 공연 관리</a></td>
	</tr>
	<tr>
	<td colspan="3"><iframe
				src=<%= request.getContextPath()+"/banner/rankBanner"%> width="100%"></iframe></td>
	</tr>
</table>

</html>