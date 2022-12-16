<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="overflow:scroll">
<style>
.class {
 border: thick double #32a1ce;
  width: 400px;
  height: 100px;
}
.square{
      width: 400px;
      height: 100px;
      background: #32a1ce;
}
.calendar{
      width: 1000px;
      height: 100px;
}
</style>
<script type="text/javascript">
function myPage(){
    if(confirm("마이 페이지로 이동합니다")){
        location.href = "<%= request.getContextPath() +"/member/myPage"%>";
        return true;
    } else {
        return false;
    }
}
function inform(){
    if(confirm("회원 정보로 이동합니다")){
        location.href = "<%= request.getContextPath() +"/myPerformance/myPerformanceList"%>";
        return true;
    } else {
        return false;
    }
}
</script>

<table>
	<tr>
		<td><h1 class="square">PerformSystem</h1></td>
		<td></td>
		<td><iframe src=<%= request.getContextPath()+"/search/search"%>></iframe></td>
		<td class="class">
			<%@ include file="/performance/dDay.jsp"%>  
		</td>
		
	</tr>
	<tr>
		<td class="class">
			<%@ include file="/member/loginForm.jsp"%>  
			<a href="#" onclick="myPage();">회원 정보</a></td>
		<td class="calendar">
			 <%@ include file="/calendar/calendar.jsp"%> </td>
		<td class="class"><a href="#" onclick="inform();">My 공연 관리</a></td>
	</tr>
	<tr>
	<td colspan="3"><iframe
				src=<%= request.getContextPath()+"/banner/rankBanner"%> width="100%"></iframe></td>
	</tr>
</table>

</html>