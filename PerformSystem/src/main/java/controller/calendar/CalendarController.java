package controller.calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.*;
import model.dao.*;
import model.dao.mybatis.CalendarDAO;
import model.service.*;

public class CalendarController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {  
		
		CalendarManager manager = CalendarManager.getInstance();
		//CalendarDAO calendarDao = new CalendarDAO();
		List<Calendar> calendar = manager.findPerformanceList();
		//List<Calendar> calendar = calendarDao.getCalendar();
		request.setAttribute("calendarList", calendar);
		return "/calendar/calendar.jsp";  
	}
}
