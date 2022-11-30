package controller.performance;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import controller.member.MemberSessionUtils;
import model.*;
import model.dao.*;
import model.service.*;

public class RecommendController implements Controller {
	// private static final int countPerPage = 100;	// 한 화면에 출력할 사용자 수

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		// 로그인 여부 확인
    	if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
    	
    	Performance performance = (Performance)request.getAttribute("performance");
    	int perId = performance.getId();
    	PerformanceDAO perDao = new PerformanceDAO();
  
    	String member_id = MemberSessionUtils.getLoginUserId(request.getSession());
    	MemberDAO memberDao = new MemberDAO();
    	
    	//수정필요!!!
    	//Member member = (Member)memberDao.findMember(member_id);
    	Member member = new Member();
    	Recommend recommend = (Recommend)perDao.findRecommend(perId, member);

		request.setAttribute("recommend", recommend);
		request.setAttribute("member", member);

		return "/performance/recommend.jsp";        
    }
}
