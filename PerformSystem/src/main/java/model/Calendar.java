package model;

import java.util.List;

public class Calendar {
	private int calendarNo;
	private String calendarTitle;
	private String calendarMemo;
	private String calendarStart;
	private String calendarEnd;
	
	public int getCalendarNo() {
		return calendarNo;
	}
	public void setCalendarNo(int calendarNo) {
		this.calendarNo = calendarNo;
	}
	public String getCalendarTitle() {
		return calendarTitle;
	}
	public void setCalendarTitle(String calendarTitle) {
		this.calendarTitle = calendarTitle;
	}
	public String getCalendarMemo() {
		return calendarMemo;
	}
	public void setCalendarMemo(String calendarMemo) {
		this.calendarMemo = calendarMemo;
	}
	public String getCalendarStart() {
		return calendarStart;
	}
	public void setCalendarStart(String calendarStart) {
		this.calendarStart = calendarStart;
	}
	public String getCalendarEnd() {
		return calendarEnd;
	}
	public void setCalendarEnd(String calendarEnd) {
		this.calendarEnd = calendarEnd;
	}
	
}