package controller.performance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.SearchDAO;
import model.dto.SearchDTO;


public class SearchController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		SearchDAO dao = new SearchDAO();
		String name = request.getParameter("performanceName");
		List<SearchDTO> dtoList = dao.search(name);
		for(SearchDTO d: dtoList) {
			System.out.print(d);
		}
		System.out.print(name);
		request.setAttribute("dtoList", dtoList);
		return "/search/search.jsp";
	}
}	