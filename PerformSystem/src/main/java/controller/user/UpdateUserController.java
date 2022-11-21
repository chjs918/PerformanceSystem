package controller.Member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.MemberManager;
import model.Community;
import model.Member;

public class UpdateMemberController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateMemberController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
    	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 수정 form 요청	
    		// 원래는 UpdateMemberFormController가 처리하던 작업을 여기서 수행
    		String updateId = request.getParameter("MemberId");

    		log.debug("UpdateForm Request : {}", updateId);
    		
    		MemberManager manager = MemberManager.getInstance();
			Member Member = manager.findMember(updateId);	// 수정하려는 사용자 정보 검색
			request.setAttribute("Member", Member);			

			HttpSession session = request.getSession();
			if (MemberSessionUtils.isLoginMember(updateId, session) ||
				MemberSessionUtils.isLoginMember("admin", session)) {
				// 현재 로그인한 사용자가 수정 대상 사용자이거나 관리자인 경우 -> 수정 가능
								
				List<Community> commList = manager.findCommunityList();	// 커뮤니티 리스트 검색
				request.setAttribute("commList", commList);	
				
				return "/Member/updateForm.jsp";   // 검색한 사용자 정보 및 커뮤니티 리스트를 updateForm으로 전송     
			}    
			
			// else (수정 불가능한 경우) 사용자 보기 화면으로 오류 메세지를 전달
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("타인의 정보는 수정할 수 없습니다."));            
			return "/Member/view.jsp";	// 사용자 보기 화면으로 이동 (forwarding)
	    }	
    	
    	// POST request (회원정보가 parameter로 전송됨)
    	Member updateMember = new Member(
    		request.getParameter("MemberId"),
    		request.getParameter("password"),
    		request.getParameter("name"),
    		request.getParameter("email"),
    		request.getParameter("phone"),
			Integer.parseInt(request.getParameter("commId")));

    	log.debug("Update Member : {}", updateMember);

		MemberManager manager = MemberManager.getInstance();
		manager.update(updateMember);			
        return "redirect:/Member/list";			
    }
}