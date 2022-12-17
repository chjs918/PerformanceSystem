package controller.member;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.*;
import model.dao.*;
import model.dto.ReviewDTO;

public class MainController implements Controller {
   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response)   throws Exception {

      return "/main.jsp";
   }
}