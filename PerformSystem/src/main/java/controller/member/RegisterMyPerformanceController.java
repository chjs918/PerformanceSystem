package controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Member;
import model.MyPerformance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Member;
import model.service.ExistingMemberException;
import model.service.ExistingPerformanceException;
import model.service.MemberManager;
import model.service.MyPerformanceManager;

public class RegisterMyPerformanceController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterMyPerformanceController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 등록 form 요청	
    		log.debug("MyPerfromanceList Request");

			return "/myPerformance/myPerformanceList.jsp";   // 검색한 커뮤니티 리스트를 registerForm으로 전송     	
	    }	
    	// POST request (회원정보가 parameter로 전송됨)
    	//시연때문에 잠시 주석처리!
    
       	MyPerformance myPerformance = new MyPerformance(
       		request.getParameter("member_name"),
			request.getParameter("performance_name"),
			request.getParameter("performance_date"));
       	
       	
        log.debug("Create MyPerformance : {}", myPerformance);

		
		MyPerformanceManager manager = MyPerformanceManager.getInstance();
		manager.create(myPerformance);
		return "redirect:/myPerformance/myPerformanceList";	// 성공 시 사용자 리스트 화면으로 redirect
	        
	
    }
}