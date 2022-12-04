package model;

import java.util.ArrayList;
import java.util.List;

public class MyPerformance {
	 private String mname;
	 private String name;
	 private String date; //startDate
	 
	public MyPerformance() {
		super();
	}

	public MyPerformance(String mname, String name, String date) {
		super();
		this.mname = mname;
		this.name = name;
		this.date = date;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	


	
	 
//	 ArrayList<String> addMyPerformance(String name, String date){
//		 ArrayList<String> mypf = new ArrayList<String>();
//		 MyPerformance p = new MyPerformance();
//		 
//		 p.setName(name);
//		 p.setDate(date);
//		 
//		 mypf.add(p);
//	}
//	 
//		 MyPerformance deleteMyPerformance(String name, String date){
//		 MyPerformance<> mp = new MyPerformance(name, date);
//		 mp.delete(mp)
//		 return mp;
//		}
//		 public MyPerformance getMyPerformance() {
//		 MyPerformance<List> mp = new MyPerformance<List>(name, date);
//		 return mp;
//		}
}