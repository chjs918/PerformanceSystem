package model.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Calendar;
import model.Performance;
import model.dao.mybatis.mapper.CalendarMapper;

public class CalendarDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public CalendarDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	
	/**
	 * 전체 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Calendar> findPerformanceList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//return sqlSession.selectList("Calendar.calendarList");
			return sqlSession.getMapper(CalendarMapper.class).selectAllPerformance();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Calendar> getCalendar() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Calendar> calendar = null;
		calendar = sqlSession.selectList("Calendar.selectAllPerformance");
		return calendar;
		
	}
	
}