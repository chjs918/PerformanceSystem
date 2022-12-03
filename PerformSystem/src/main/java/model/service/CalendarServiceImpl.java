package model.service;

import java.util.List;
import java.util.ArrayList;

import model.Performance;
import model.dao.PerformanceDAO;

public class CalendarServiceImpl implements CalendarService  {

	private PerformanceDAO performancedao;
	
	public List<Performance> getCalendar() throws Exception {
		return performancedao.getCalendar();
	}
}
