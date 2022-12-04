package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.MyPerformance;

//DAO는 테이블에 데이터를 넣는 클래스이기때문에 table을 만들었으면 dao도 만들 수 있음
public class MyPerformanceDAO {
	
	//의존성 주입(객체를 생성함에 동시에 초기화)
	private Connection conn = null;
	private JDBCUtil jdbcUtil = null;
	
	public MyPerformanceDAO(Connection conn) {
		this.conn = conn;
	}
	public MyPerformanceDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	public int create(MyPerformance myPerformance) throws SQLException {
		String sql = "INSERT INTO NEWMYPERFORMANCELIST VALUES (?, ?, ?)";		
		Object[] param = new Object[] {myPerformance.getMname(), myPerformance.getName(), myPerformance.getDate()};				
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
	public List<MyPerformance> findMyPerformanceList() throws SQLException {
        String sql = "SELECT member_name, performance_name, performance_date" 
        		   + "FROM NEWMYPERFORMANCELIST";
//        		   + "ORDER BY name";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<MyPerformance> myPerformanceList = new ArrayList<MyPerformance>();	// User들의 리스트 생성
			while (rs.next()) {
				MyPerformance myPerformance = new MyPerformance(			// User 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("member_name"),
						rs.getString("performance_name"),
						rs.getString("performance_date"));
				myPerformanceList.add(myPerformance);				// List에 User 객체 저장
			}		
			return myPerformanceList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
}
