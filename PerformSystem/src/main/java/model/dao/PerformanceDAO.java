package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class PerformanceDAO {
	private JDBCUtil jdbcUtil = null;
	
	public PerformanceDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 공연 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	 */
	public Performance create(Performance performance) throws SQLException {
		String sql = "INSERT INTO Performance VALUES (Sequence_211.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {performance.getName(), performance.getEndDate(), performance.getStartDate()
				, performance.getAgeGroup(), performance.getRunTime()
				, performance.getCast(), performance.getPrice(), performance.getCategory(), performance.getLink()
				, performance.getImg(), performance.getRank()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		String key[] = {"performance_id"};	// PK 컬럼의 이름     
		try {    
			jdbcUtil.executeUpdate(key);  // insert 문 실행
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);   // 생성된 PK 값
		   		performance.setId(generatedKey); 	// id필드에 저장  
		   	}
		   	return performance;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return null;			
	}

	/**
	 * 기존의 공연 정보를 수정 (가격과 순위만 수정 가능)
	 */
	public int update(Performance performance) throws SQLException {
		String sql = "UPDATE Performance "
					+ "SET price=?, rank=? "
					+ "WHERE performance_id=?";
		Object[] param = new Object[] {performance.getPrice(), performance.getRank()};				
		jdbcUtil.setSqlAndParameters(sql, param);
			
		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}
	
	/**
	 * 공연 ID에 해당하는 공연을 삭제.
	 */
	public int remove(String performance_id) throws SQLException {
		String sql = "DELETE FROM PERFORMANCE WHERE performance_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {performance_id});

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
	 * 주어진 공연 ID에 해당하는 공연 정보를 데이터베이스에서 찾아 Performance 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public Performance findPerformance(int performance_id) throws SQLException {
        String sql = "SELECT * "
        			+ "FROM PERFORMANCE "
        			+ "WHERE performance_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {performance_id});

		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {	
				Performance performance = new Performance(
						performance_id,
					rs.getString("performance_img"),
					rs.getString("name"),
					rs.getString("startDate"),
					rs.getString("endDate"),
					rs.getString("ageGroup"),
					rs.getInt("runTime"),
					rs.getString("cast"),
					rs.getString("venue"),
					rs.getInt("price"),
					rs.getString("category"),
					rs.getString("site_link"),
					rs.getInt("rank"));
				return performance;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	public Recommend findRecommend(int performance_id, Member member) throws SQLException {
        String sql = "SELECT * "
        			+ "FROM Recommend "
        			+ "WHERE performance_id=? and area=? and strength=? and types=? and views=? and stable=? ";             
		jdbcUtil.setSqlAndParameters(sql, new Object[] {performance_id, member.getArea(), member.getStrength(), member.getTypes()
														,member.getViews(), member.getStable()});	// JDBCUtil에 query문과 매개 변수 설정
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {	
				Recommend recommend = new Recommend(
						rs.getInt("recommend_id"),
						performance_id,
						rs.getString("recommend_img"),
						rs.getString("recommend_seat"),
						rs.getString("area"),
						rs.getString("strength"),
						rs.getString("types"),
						rs.getString("views"),
						rs.getString("stable"));
				
				return recommend;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * member_id를 검색하여 myPerformanceList에 저장 및 반환
	 */

	public List<Performance> findMyPerformanceList() throws SQLException {
        String sql = "SELECT name, startDate, endDate "
                 + "FROM MyPerformance mp LEFT OUTER JOIN Performance p ON mp.member_id = p.member_id "
                 + "WHERE member_id=?";        
      jdbcUtil.setSqlAndParameters(sql, null);
               
      try {
         ResultSet rs = jdbcUtil.executeQuery();      
         List<Performance> mpList = new ArrayList<Performance>();
         while (rs.next()) {
            Performance mp = new Performance(   
                  rs.getString("name"),
                  rs.getString("startDate"),
                  rs.getString("endDate"));
            mpList.add(mp);
         }
         return mpList;
         
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close();   
      }
      return null;
   }
	
	/**
	 *  오늘이 공연이 있는 날(첫 공연과 마지막 공연 사이)인지 검사
	 *    yyyymmdd 형식
	 */
	public boolean existPerformance(String startDate, String endDate) throws SQLException {
	    if(startDate.length() != 8 || endDate.length() != 8){
	           return false;
	       }      
	   
	    String sql = "SELECT count(*)"
	              + "FROM Performance"
	              + "WHERE startDate <= TO_CHAR(SYSDATE, 'YYYYMMDD') and endDate >= TO_CHAR(SYSDATE, 'YYYYMMDD') ";        
	   jdbcUtil.setSqlAndParameters(sql, null);
	            
	   try {
	      ResultSet rs = jdbcUtil.executeQuery();      
	      if (rs.next()) {
	         int count = rs.getInt(1);
	         return (count == 1 ? true : false);
	      }
	   } catch (Exception ex) {
	      ex.printStackTrace();
	   } finally {
	      jdbcUtil.close();
	   }
	   return false;
	}
	
}