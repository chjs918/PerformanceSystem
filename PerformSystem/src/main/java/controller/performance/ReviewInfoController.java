package controller.performance;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.*;
import model.dao.*;

public class ReviewInfoController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int reviewId = (int)request.getAttribute("review_id");
		ReviewDAO reviewDao = new ReviewDAO();
		Review review = (Review)reviewDao.findReview(reviewId);
		
		request.setAttribute("review", review);
		
		return "/performance/review_info.jsp";  
	}
}