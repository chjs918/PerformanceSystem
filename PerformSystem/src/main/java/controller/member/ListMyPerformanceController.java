package controller.member;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Member;
import model.MyPerformance;
import model.service.MemberManager;
import model.service.MyPerformanceManager;

public class ListMyPerformanceController implements Controller {
	// private static final int countPerPage = 100;	// 한 화면에 출력할 사용자 수

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		// 로그인 여부 확인
//    	if (!MemberSessionUtils.hasLogined(request.getSession())) {
//            return "redirect:/member/login/form";		// login form 요청으로 redirect
//        }
    	
    	/*
    	String currentPageStr = request.getParameter("currentPage");	
		int currentPage = 1;
		if (currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}		
    	*/
    	
    	MyPerformanceManager manager = MyPerformanceManager.getInstance();
		//시연때문에 잠시 주석처리!
		List<MyPerformance> myPerformanceList = manager.findMyPerformanceList();
		

		// userList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
		//시연때문에 잠시 주석처리!
		request.setAttribute("myPerformanceList", myPerformanceList);				
//		request.setAttribute("curMemberId", 
//				MemberSessionUtils.getLoginMemberId(request.getSession()));		

		// 사용자 리스트 화면으로 이동(forwarding)
		return "/myPerformance/myPerformanceList.jsp";        
    }
}