package model.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Member;
import model.dao.MemberDAO;

// an example business class
public class MemberAnalysis {
	private MemberDAO dao;
	
	public MemberAnalysis() {}
	
	public MemberAnalysis(MemberDAO dao) {
		super();
		this.dao = dao;
	}
}