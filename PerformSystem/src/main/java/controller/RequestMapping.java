package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Member.*;
import controller.comm.*;
import controller.performance.BannerController;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/Member/login/form", new ForwardController("/Member/loginForm.jsp"));
        mappings.put("/Member/login", new LoginController());
        mappings.put("/Member/logout", new LogoutController());
        mappings.put("/Member/list", new ListMemberController());
        mappings.put("/Member/view", new ViewMemberController());
        
        // 회원 가입 폼 요청과 가입 요청 처리 병합 (폼에 커뮤니티 선택 메뉴 추가를 위함)
//      mappings.put("/Member/register/form", new ForwardController("/Member/registerForm.jsp"));
//      mappings.put("/Member/register", new RegisterMemberController());
        mappings.put("/Member/register", new RegisterMemberController());

        // 사용자 정보 수정 폼 요청과 수정 요청 처리 병합
//      mappings.put("/Member/update/form", new UpdateMemberFormController());
//      mappings.put("/Member/update", new UpdateMemberController());        
        mappings.put("/Member/update", new UpdateMemberController());
        
        mappings.put("/Member/delete", new DeleteMemberController());
        
        // 커뮤니티 관련 request URI 추가
        // 커뮤니티 리스트 요청 처리 컨트롤러 변경
//		mappings.put("/community/list", new ListCommunityController());
		mappings.put("/community/list", new ListAndViewCommunityController());
        mappings.put("/community/view", new ViewCommunityController());
        mappings.put("/community/create/form", new ForwardController("/community/creationForm.jsp"));
        mappings.put("/community/create", new CreateCommunityController());
        mappings.put("/community/update", new UpdateCommunityController());
        
        // 커뮤니티 리스트 및 상세정보 검색 request mapping 추가 (JSON 결과 생성)    
        mappings.put("/community/list/json", new ListCommunityJsonController());
        mappings.put("/community/view/json", new ViewCommunityJsonController());
        
        mappings.put("/banner/rankBanner.do", new BannerController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}
