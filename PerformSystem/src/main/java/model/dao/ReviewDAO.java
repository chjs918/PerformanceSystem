package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class ReviewDAO {

	private JDBCUtil jdbcUtil = null;

	public ReviewDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 리뷰 관리 테이블에 새로운 리뷰 생성.
	 */
	public int create(Review review) throws SQLException {
		String sql = "INSERT INTO REVIEW VALUES (?, ?, ?, ?, ?) ";		
		Object[] param = new Object[] {review.getId(), review.getTitle(), 
						review.getPerformance_id(), review.getMember_id(), review.getContent() };				
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
	 * 기존의 리뷰 정보를 수정. / 리뷰 제목과 내용만 수정 가능
	 */
	public int update(Review review) throws SQLException {
		String sql = "UPDATE REVIEW "
					+ "SET title=?, content=? "
					+ "WHERE review_id=?";
		Object[] param = new Object[] {review.getTitle(), review.getContent(), review.getId()};				
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
	}

	/**
	 * 리뷰 ID에 해당하는 리뷰를 삭제.
	 */
	public int remove(String review_id) throws SQLException {
		String sql = "DELETE FROM REVIEW WHERE review_id=? ";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {review_id});	// JDBCUtil에 delete문과 매개 변수 설정

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
	 * 주어진 리뷰 ID에 해당하는 리뷰 정보를 데이터베이스에서 찾아 Review 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public Review findReview(int review_id) throws SQLException {
        String sql = "SELECT * "
        			+ "FROM REVIEW "
        			+ "WHERE review_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {review_id});

		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {	
				Review review = new Review(
						review_id,
					rs.getString("title"),
					rs.getInt("performance_id"),
					rs.getInt("member_id"),
					rs.getString("content"));
				return review;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 주어진 Performance ID에 해당하는 리뷰들의 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Review> findReviewList(int performance_id) throws SQLException {
        String sql = "SELECT * " 
	        		+ "FROM REVIEW "
	    			+ "WHERE performance_id=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {performance_id});
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Review> reviewList = new ArrayList<Review>();	// Review들의 리스트 생성
			while (rs.next()) {
				Review review = new Review(
					rs.getInt("review_id"),
					rs.getString("title"),
					rs.getInt("performance_id"),
					rs.getInt("member_id"),
					rs.getString("content"));
				reviewList.add(review);				// List에 Review 객체 저장
			}		
			return reviewList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
}
