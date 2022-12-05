package controller.calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.*;
import model.dao.*;
import model.service.*;

public class CalendarController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		PerformanceDAO performanceDao = new PerformanceDAO();
		List<Performance> pCalendar = performanceDao.list();
		request.setAttribute("calendarList", pCalendar);
		return "/calendar/calendar.jsp";  
	}
}
