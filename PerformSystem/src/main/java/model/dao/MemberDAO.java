package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Member;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * MemberINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class MemberDAO {
	private JDBCUtil jdbcUtil = null;
	
	public MemberDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */
	public int create(Member Member) throws SQLException {
		String sql = "INSERT INTO MemberINFO VALUES (?, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {Member.getId(), Member.getPassword(), 
						Member.getGender(), Member.getBirth(), Member.getEmail(), 
						Member.getMyPerformances(), Member.getMyPreferences() };				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}

	/**
	 * 기존의 사용자 정보를 수정.
	 */
	/*public int update(Member Member) throws SQLException {
		String sql = "UPDATE MemberINFO "
					+ "SET password=?, name=?, email=?, phone=?, commId=? "
					+ "WHERE Memberid=?";
		Object[] param = new Object[] {Member.getPassword(), Member.getName(), 
					Member.getEmail(), Member.getPhone(), 
					(Member.getCommId()!=0) ? Member.getCommId() : null, 
					Member.getMemberId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}*/

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int remove(String MemberId) throws SQLException {
		String sql = "DELETE FROM MemberINFO WHERE Memberid=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {MemberId});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 Member 도메인 클래스에 
	 * 저장하여 반환.
	 */
	/*
	public Member findMember(String MemberId) throws SQLException {
        String sql = "SELECT password, name, email, phone, commId, cName "
        			+ "FROM MemberINFO u LEFT OUTER JOIN Community c ON u.commId = c.cId "
        			+ "WHERE Memberid=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {MemberId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				Member Member = new Member(		// Member 객체를 생성하여 학생 정보를 저장
					MemberId,
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getInt("commId"),					
					rs.getString("cName"));
				return Member;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	*/
	/**
	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
	 */
	/*
	public List<Member> findMemberList() throws SQLException {
        String sql = "SELECT MemberId, name, email, NVL(commId,0) AS commId, cName " 
        		   + "FROM MemberINFO u LEFT OUTER JOIN Community c ON u.commId = c.cId "
        		   + "ORDER BY MemberId";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Member> MemberList = new ArrayList<Member>();	// Member들의 리스트 생성
			while (rs.next()) {
				Member Member = new Member(			// Member 객체를 생성하여 현재 행의 정보를 저장
					rs.getString("MemberId"),
					null,
					rs.getString("name"),
					rs.getString("email"),
					null,
					rs.getInt("commId"),
					rs.getString("cName"));
				MemberList.add(Member);				// List에 Member 객체 저장
			}		
			return MemberList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	*/
	/**
	 * 전체 사용자 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
	 * 해당하는 사용자 정보만을 List에 저장하여 반환.
	 */
	/*
	public List<Member> findMemberList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT MemberId, name, email, NVL(commId, 0) AS commId, cName " 
					+ "FROM MemberINFO u LEFT OUTER JOIN Community c ON u.commId = c.cId "
					+ "ORDER BY MemberId";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<Member> MemberList = new ArrayList<Member>();	// Member들의 리스트 생성
				do {
					Member Member = new Member(			// Member 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("MemberId"),
						null,
						rs.getString("name"),
						rs.getString("email"),
						null,
						rs.getInt("commId"),
						rs.getString("cName"));
					MemberList.add(Member);							// 리스트에 Member 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return MemberList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
*/

	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingMember(String MemberId) throws SQLException {
		String sql = "SELECT count(*) FROM MemberINFO WHERE Memberid=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {MemberId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}

}
