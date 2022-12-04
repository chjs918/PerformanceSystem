package model.service;

import java.sql.SQLException;
import java.util.List;

import model.MyPerformance;
import model.dao.MyPerformanceDAO;

public class MyPerformanceManager {
	private static MyPerformanceManager myPerformanceMan = new MyPerformanceManager();
	private MyPerformanceDAO myPerformanceDAO;
	private MyPerformanceAnalysis myPerformanceAanlysis;

	private MyPerformanceManager() {
		try {
			myPerformanceDAO = new MyPerformanceDAO();
			myPerformanceAanlysis = new MyPerformanceAnalysis(myPerformanceDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MyPerformanceManager getInstance() {
		return myPerformanceMan;
	}
	
	public int create(MyPerformance myPerformance) throws SQLException {
		return myPerformanceDAO.create(myPerformance);
	}
	
	
	public MyPerformanceDAO getMyPerformanceDAO() {
		return this.myPerformanceDAO;
	}

	public List<MyPerformance> findMyPerformanceList() throws SQLException {
		return myPerformanceDAO.findMyPerformanceList();
	}
}
