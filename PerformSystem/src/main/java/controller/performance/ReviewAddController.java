package controller.performance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.Member;
import model.Review;
import model.dao.MemberDAO;
import model.dao.ReviewDAO;

public class ReviewAddController implements Controller {
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();
    	String id = (String)session.getAttribute(MemberSessionUtils.USER_SESSION_KEY);
    	MemberDAO memberDao = new MemberDAO();

    	Member member = (Member)memberDao.findMember(id);
    	
    	Review review = new Review(
       		request.getParameter("title"),
       		Integer.parseInt((String)request.getParameter("performance_id")),
			member.getMember_id(),
			request.getParameter("content"));

			ReviewDAO reviewDao = new ReviewDAO();
			reviewDao.create(review);
			request.setAttribute("performance_id", request.getParameter("performance_id"));
	        return "/performance/review";
    }
}