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

	// an example business method
	public List<Member> recommendFriends(String MemberId) throws Exception {
		Member thisMember = dao.findMember(MemberId);
		if (thisMember == null) {
			throw new Exception("invalid Member ID!");
		}
		int m1 = MemberId.indexOf('@');
		if (m1 == -1) return null;
		String mserver1 = thisMember.getEmail().substring(m1);
		
		List<Member> friends = new ArrayList<Member>();
		
		List<Member> MemberList = dao.findMemberList(1, 10000);
		Iterator<Member> MemberIter = MemberList.iterator();		
		while (MemberIter.hasNext()) {
			Member Member = (Member)MemberIter.next();
			
			if (Member.getMemberId().equals(MemberId)) continue;
			int m2 = Member.getEmail().indexOf('@');
			if (m2 == -1) continue;
			String mserver2 = Member.getEmail().substring(m2);

			if (mserver1.equals(mserver2)) 
				friends.add(Member);		
		}
		return friends;
	}

}
