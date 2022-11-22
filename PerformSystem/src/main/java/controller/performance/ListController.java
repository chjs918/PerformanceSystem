package controller.performance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.ListDAO;
import model.dto.ListDTO;

public class ListController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ListDAO dao = new ListDAO();
		List<ListDTO> dtoList = dao.list();
		request.setAttribute("dtoList", dtoList);
		return "/list/list.jsp";
	}
}
