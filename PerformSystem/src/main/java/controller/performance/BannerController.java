package controller.performance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.BannerDAO;
import model.dto.BannerDTO;

public class BannerController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		BannerDAO dao = new BannerDAO();
		List<BannerDTO> dtoList = dao.listBanner();
		request.setAttribute("dtoList", dtoList);
		return "/banner/rankBanner.jsp";
	}
	
}
