package controller.performance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Review;
import model.dao.ReviewDAO;

public class ReviewUpdateController implements Controller {
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Review review = new Review(
    		Integer.parseInt((String)request.getParameter("review_id")),
    		request.getParameter("title"),
			request.getParameter("content"));

			ReviewDAO reviewDao = new ReviewDAO();
			reviewDao.update(review);
			request.setAttribute("performance_id", request.getParameter("performance_id"));
	        return "/performance/review";
    }
}
