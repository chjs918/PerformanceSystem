package controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.MemberManager;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String MemberId = request.getParameter("MemberId");
		String password = request.getParameter("password");
		
		try {
			// 모델에 로그인 처리를 위임
			MemberManager manager = MemberManager.getInstance();
			manager.login(MemberId, password);
	
			// 세션에 사용자 이이디 저장
			HttpSession session = request.getSession();
            session.setAttribute(MemberSessionUtils.Member_SESSION_KEY, MemberId);
            
            return "redirect:/member/list";			
		} catch (Exception e) {
			/* MemberNotFoundException이나 PasswordMismatchException 발생 시
			 * 다시 login form을 사용자에게 전송하고 오류 메세지도 출력
			 */
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
            return "/member/loginForm.jsp";			
		}	
    }
}
