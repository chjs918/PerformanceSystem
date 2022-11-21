package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Community;
import model.Member;
import model.dao.CommunityDAO;
import model.dao.MemberDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * MemberDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class MemberManager {
	private static MemberManager MemberMan = new MemberManager();
	private MemberDAO MemberDAO;
	private CommunityDAO commDAO;
	private MemberAnalysis MemberAanlysis;

	private MemberManager() {
		try {
			MemberDAO = new MemberDAO();
			commDAO = new CommunityDAO();
			MemberAanlysis = new MemberAnalysis(MemberDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MemberManager getInstance() {
		return MemberMan;
	}
	
	public int create(Member Member) throws SQLException, ExistingMemberException {
		if (MemberDAO.existingMember(Member.getMemberId()) == true) {
			throw new ExistingMemberException(Member.getMemberId() + "는 존재하는 아이디입니다.");
		}
		return MemberDAO.create(Member);
	}

	public int update(Member Member) throws SQLException, MemberNotFoundException {
		int oldCommId = findMember(Member.getMemberId()).getCommId();
		if (Member.getCommId() != oldCommId) { 	// 소속 커뮤티니가 변경됨
			Community comm = commDAO.findCommunity(oldCommId);  // 기존 소속 커뮤니티
			if (comm != null && Member.getMemberId().equals(comm.getChairId())) {
				// 사용자가 기존 소속 커뮤니티의 회장인 경우 -> 그 커뮤니티의 회장을 null로 변경 및 저장
				comm.setChairId(null);
				commDAO.updateChair(comm);
			}
		}
		return MemberDAO.update(Member);
	}	

	public int remove(String MemberId) throws SQLException, MemberNotFoundException {
		int commId = findMember(MemberId).getCommId();
		Community comm = commDAO.findCommunity(commId);  // 소속 커뮤니티
		if (comm != null && MemberId.equals(comm.getChairId())) {
			// 사용자가 소속 커뮤니티의 회장인 경우 -> 그 커뮤니티의 회장을 null로 변경 및 저장
			comm.setChairId(null);
			commDAO.updateChair(comm);
		}
		return MemberDAO.remove(MemberId);
	}

	public Member findMember(String MemberId)
		throws SQLException, MemberNotFoundException {
		Member Member = MemberDAO.findMember(MemberId);
		
		if (Member == null) {
			throw new MemberNotFoundException(MemberId + "는 존재하지 않는 아이디입니다.");
		}		
		return Member;
	}

	public List<Member> findMemberList() throws SQLException {
			return MemberDAO.findMemberList();
	}
	
	public List<Member> findMemberList(int currentPage, int countPerPage)
		throws SQLException {
		return MemberDAO.findMemberList(currentPage, countPerPage);
	}

	public boolean login(String MemberId, String password)
		throws SQLException, MemberNotFoundException, PasswordMismatchException {
		Member Member = findMember(MemberId);

		if (!Member.matchPassword(password)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		return true;
	}

	public List<Member> makeFriends(String MemberId) throws Exception {
		return MemberAanlysis.recommendFriends(MemberId);
	}
	
	public Community createCommunity(Community comm) throws SQLException {
		return commDAO.create(comm);		
	}

	public int updateCommunity(Community comm) throws SQLException {
		return commDAO.update(comm);				
	}
	
	public Community findCommunity(int commId) throws SQLException {
		Community comm = commDAO.findCommunity(commId); 
		
		List<Member> memberList = MemberDAO.findMembersInCommunity(commId);
		comm.setMemberList(memberList);
		
		int numOfMembers = MemberDAO.getNumberOfMembersInCommunity(commId);
		comm.setNumOfMembers(numOfMembers);
		return comm;
	}
	
	public List<Community> findCommunityList() throws SQLException {
		return commDAO.findCommunityList();
	}
	
	public List<Member> findCommunityMembers(int commId) throws SQLException {
		return MemberDAO.findMembersInCommunity(commId);
	}

	public MemberDAO getMemberDAO() {
		return this.MemberDAO;
	}
}
