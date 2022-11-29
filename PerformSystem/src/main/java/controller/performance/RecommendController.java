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
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	request.setCharacterEncoding("utf-8");
    	Performance performance = (Performance)request.getAttribute("performance");
    	int perId = performance.getId();
    	PerformanceDAO perDao = new PerformanceDAO();
  
    	//String id = MemberSessionUtils.getLoginUserId(request.getSession());
    	//int member_id = Integer.parseInt(id);
    	int member_id = 13;
    	MemberDAO memberDao = new MemberDAO();
    	
    	
    	Member member = (Member)memberDao.findMember(member_id);
    	Recommend recommend = (Recommend)perDao.findRecommend(perId, member);

		request.setAttribute("recommend", recommend);
		request.setAttribute("member", member);

		return "/UserMan3a/performance/recommend.jsp";        
    }
}
