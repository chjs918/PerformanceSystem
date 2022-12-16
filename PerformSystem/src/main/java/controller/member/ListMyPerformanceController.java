package controller.member;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.*;
import model.dao.*;
import model.Member;
import model.MyPerformance;
import model.dao.MemberDAO;
import model.service.MemberManager;
import model.service.MyPerformanceManager;

public class ListMyPerformanceController implements Controller {
	// private static final int countPerPage = 100;	// 한 화면에 출력할 사용자 수
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

    	MyPerformanceDAO myPerformanceDao = new MyPerformanceDAO();

    	MyPerformanceManager manager = MyPerformanceManager.getInstance();
		List<MyPerformance> myPerformanceList = manager.findMyPerformanceList();
		// userList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
		request.setAttribute("myPerformanceList", myPerformanceList);					

		// 사용자 리스트 화면으로 이동(forwarding)
		return "/myPerformance/myPerformanceSave.jsp";        
    }
}