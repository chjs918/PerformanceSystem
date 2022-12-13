package model.dao.mybatis.mapper;

import java.util.List;

import model.Calendar;
import model.Performance;

public interface CalendarMapper {
	public List<Calendar> selectAllPerformance();
}