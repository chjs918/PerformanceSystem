package controller.performance;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.*;
import model.dao.*;

public class ReviewController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int perId = Integer.parseInt((String)request.getParameter("performance_id"));
		ReviewDAO reviewDao = new ReviewDAO();
		List<Review> reviewList = (List<Review>)reviewDao.findReviewList(perId);
		
		request.setAttribute("reviewList", reviewList);
		
		return "/performance/review.jsp";  
	}
}
