package controller.performance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class BannerController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("banner controller");
		request.setAttribute("name", "배너");
		return "/banner/rankBanner.jsp";
	}
	
}
