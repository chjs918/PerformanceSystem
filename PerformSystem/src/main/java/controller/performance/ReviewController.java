package controller.performance;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.*;
import model.dao.*;
import model.dto.ReviewDTO;

public class ReviewController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int reviewId = Integer.parseInt(request.getParameter("review_id"));
		ReviewDAO reviewDao = new ReviewDAO();
		ReviewDTO review = (ReviewDTO)reviewDao.findReview(reviewId);
		
		request.setAttribute("review", review);
		
		if (request.getParameter("command").equals("update")) {
			return "/performance/review_update.jsp";  
		}
		else {
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute(MemberSessionUtils.USER_SESSION_KEY);
	    	MemberDAO memberDao = new MemberDAO();
	    	Member member = (Member)memberDao.findMember(id);
	    	
	    	request.setAttribute("member_id", member.getMember_id());
			return "/performance/review_info.jsp";  
		}
	}
}