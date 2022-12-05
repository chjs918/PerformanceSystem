package controller.performance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.ReviewDAO;

public class ReviewDeleteController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int reviewId = Integer.parseInt(request.getParameter("review_id"));
		ReviewDAO reviewDao = new ReviewDAO();
		
		reviewDao.remove(reviewId);
		
		request.setAttribute("performance_id", request.getParameter("performance_id"));
        return "/performance/review";
	}
}