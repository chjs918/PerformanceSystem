package controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.MemberManager;
import model.service.MemberNotFoundException;
import model.Member;

public class ViewMemberController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// 로그인 여부 확인
    	if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/Member/login/form";		// login form 요청으로 redirect
        }
    	
		MemberManager manager = MemberManager.getInstance();
		String MemberId = request.getParameter("MemberId");
		
    	Member Member = null;
		try {
			Member = manager.findMember(MemberId);	// 사용자 정보 검색
		} catch (MemberNotFoundException e) {				
	        return "redirect:/Member/list";
		}	
		
		request.setAttribute("Member", Member);		// 사용자 정보 저장				
		return "/Member/view.jsp";				// 사용자 보기 화면으로 이동
    }
}
