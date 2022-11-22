package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.ListDTO;

public class ListDAO {
	JDBCUtil jdbcUtil;
	public ListDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	public List<ListDTO> list(){
		List<ListDTO> list = new ArrayList<ListDTO>();
		try {    
			String sql = "select name, PERFORMANCE_IMG, PERFORMANCE_ID, category, runtime,agegroup,site_link, cast from performance";
			jdbcUtil.setSqlAndParameters(sql, null);
		   	ResultSet rs = jdbcUtil.executeQuery();
		   	
		   	while(rs.next()) {
		   		String name = rs.getString("name");
		   		String category = rs.getString("CATEGORY");
		   		String img = rs.getString("PERFORMANCE_IMG");
		   		String runtime = rs.getString("RUNTIME");
		   		String agegroup = rs.getString("AGEGROUP");
		   		String site_link = rs.getString("SITE_LINK");
		   		String cast = rs.getString("CAST");
		   		String PERFORMANCE_ID = rs.getString("PERFORMANCE_ID");
		   		ListDTO dto = new ListDTO(name, img, category, runtime, agegroup, site_link, cast,PERFORMANCE_ID);
		   		list.add(dto);
		   	}
		   	  	
		   	
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}
		return list;		
		
	}
}
