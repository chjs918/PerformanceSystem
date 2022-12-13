package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Calendar;
import model.dao.mybatis.CalendarDAO;

public class CalendarManager {
	private static CalendarManager calendarMan = new CalendarManager();
	private CalendarDAO CalendarDAO;

	private CalendarManager() {
		try {
			CalendarDAO = new CalendarDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static CalendarManager getInstance() {
		return calendarMan;
	}
	
	public CalendarDAO getCalendarDAO() {
		return this.CalendarDAO;
	}

	public List<Calendar> findPerformanceList() throws SQLException {
		return CalendarDAO.findPerformanceList();
	}
}
