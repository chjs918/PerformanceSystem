package controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Member;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Member;
import model.service.ExistingMemberException;
import model.service.MemberManager;

public class RegisterMemberController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterMemberController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 등록 form 요청	
    		log.debug("RegisterForm Request");

			return "/member/registerForm.jsp";   // 검색한 커뮤니티 리스트를 registerForm으로 전송     	
	    }	
    	// POST request (회원정보가 parameter로 전송됨)
    	//시연때문에 잠시 주석처리!
    	/*
       	Member member = new Member(
			request.getParameter("id"),
			request.getParameter("password"),
			request.getParameter("name"),
			request.getParameter("gender"),
			request.getParameter("birth_yy"),
			request.getParameter("birth_mm"),
			request.getParameter("birth_dd"),
			request.getParameter("email"),
			request.getParameter("area"),
			request.getParameter("strength"),
			request.getParameter("type"),
			request.getParameter("view"),
			request.getParameter("stable"));
        log.debug("Create Member : {}", member);

		try {
			MemberManager manager = MemberManager.getInstance();
			manager.create(member);
	        return "redirect:/member/list";	// 성공 시 사용자 리스트 화면으로 redirect
	        
		} catch (ExistingMemberException e) {	// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("member", member);
			return "/member/registerForm.jsp";
		}
		*/
    	return "/member/registerForm.jsp";
    }
}

