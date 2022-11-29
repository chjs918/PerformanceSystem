package controller.performance;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.member.*;
import model.*;
import model.dao.*;

public class RecommendController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	PerformanceDAO perDao = new PerformanceDAO();
    	//int performance_id = (int)request.getAttribute("performance_id");
    	//Performance performance = (Performance)request.getAttribute("performance");
  
    	//HttpSession session = request.getSession();
    	//String id = (String)session.getAttribute(MemberSessionUtils.USER_SESSION_KEY);
    	String id = "admin";
    	MemberDAO memberDao = new MemberDAO();

    	Member member = (Member)memberDao.findMember(id);
    	Recommend recommend = (Recommend)perDao.findRecommend(1, member);

		request.setAttribute("recommend", recommend);
		request.setAttribute("member", member);

		return "/performance/recommend.jsp";        
    }
}
