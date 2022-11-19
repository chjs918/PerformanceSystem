package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Member;


public class MemberDAO {
	private JDBCUtil jdbcUtil = null;
	
	public MemberDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */
	public int create(Member member) throws SQLException {
		String sql = "INSERT INTO MEMBERINFO VALUES (?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {member.getId(), member.getPassword(), member.getGender(), 
	            member.getBirth(), member.getEmail(), member.getPreference()   };				
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
	public int update(Member member) throws SQLException {
	      String sql = "UPDATE MEMBERINFO "
	               + "SET password=?, gender=?, birth=?, email=?, preference=? "
	               + "WHERE member_id=?";
	      Object[] param = new Object[] {member.getId(), member.getPassword(),
	    		  member.getGender(), member.getBirth(), 
	    		  member.getEmail(), member.getPreference()};            
	      jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil에 update문과 매개 변수 설정
	         
	      try {            
	         int result = jdbcUtil.executeUpdate();   // update 문 실행
	         return result;
	      } catch (Exception ex) {
	         jdbcUtil.rollback();
	         ex.printStackTrace();
	      }
	      finally {
	         jdbcUtil.commit();
	         jdbcUtil.close();   // resource 반환
	      }      
	      return 0;
	   }
	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int remove(String member_id) throws SQLException {
		String sql = "DELETE FROM MEMBERINFO WHERE member_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {member_id});	// JDBCUtil에 delete문과 매개 변수 설정

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
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingUser(String member_id) throws SQLException {
		String sql = "SELECT count(*) FROM MEMBERINFO WHERE member_id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {member_id});	// JDBCUtil에 query문과 매개 변수 설정

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
	
//	public List<Member> findMemberList() throws SQLException {
//        String sql = "SELECT userId, name, email, NVL(commId,0) AS commId, cName " 
//        		   + "FROM USERINFO u LEFT OUTER JOIN Community c ON u.commId = c.cId "
//        		   + "ORDER BY userId";
//		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
//					
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
//			List<User> userList = new ArrayList<User>();	// User들의 리스트 생성
//			while (rs.next()) {
//				User user = new User(			// User 객체를 생성하여 현재 행의 정보를 저장
//					rs.getString("userId"),
//					null,
//					rs.getString("name"),
//					rs.getString("email"),
//					null,
//					rs.getInt("commId"),
//					rs.getString("cName"));
//				userList.add(user);				// List에 User 객체 저장
//			}		
//			return userList;					
//			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();		// resource 반환
//		}
//		return null;
//	}

//	   public List<Member> SearchMember(String title) throws SQLException {
//        String sql = "select name, endDate - startDate term, runTime, ageGroup, cast, price, site_link from performance where name = ?"
//      jdbcUtil.setSqlAndParameters(sql, title);   // JDBCUtil에 query문과 매개 변수 설정
//      
//      try {
//         ResultSet rs = jdbcUtil.executeQuery();      // query 실행
//         List<Member> memList = new ArrayList<Member>();   // member들의 리스트 생성
//         while (rs.next()) {
//            User member = new Member(         
//            rs.getString("name"),
//            rs.getString("term"),
//            rs.getString("runTime"),
//            rs.getString("ageGroup"),
//            rs.getString("cast")
//            rs.getString("price")
//            rs.getString("site_link")
//            memList.add(member);        
//         }      
//         return memList;               
//            
//      } catch (Exception ex) {
//         ex.printStackTrace();
//      } finally {
//         jdbcUtil.close();      // resource 반환
//      }
//      return null;
//   }
//	
//	   public List<Member> MemberList() throws SQLException {
//        String sql = "select name, category, runTime, ageGroup, cast from performance"
//      jdbcUtil.setSqlAndParameters(sql, null);   // JDBCUtil에 query문과 매개 변수 설정
//      
//      try {
//         ResultSet rs = jdbcUtil.executeQuery();      // query 실행
//         List<Member> memList = new ArrayList<Member>();   // member들의 리스트 생성
//         while (rs.next()) {
//            User member = new Member(         
//            rs.getString("name"),
//            rs.getString("category"),
//            rs.getString("runTime"),
//            rs.getString("ageGroup"),
//            memList.add(cast);        
//         }      
//         return memList;               
//      } catch (Exception ex) {
//         ex.printStackTrace();
//      } finally {
//         jdbcUtil.close();      // resource 반환
//      }
//      return null;
//   }
}
