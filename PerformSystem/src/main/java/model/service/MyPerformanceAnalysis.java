package model.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Member;
import model.dao.MyPerformanceDAO;

// an example business class
public class MyPerformanceAnalysis {
	private MyPerformanceDAO dao;
	
	public MyPerformanceAnalysis() {}
	
	public MyPerformanceAnalysis(MyPerformanceDAO dao) {
		super();
		this.dao = dao;
	}
}
