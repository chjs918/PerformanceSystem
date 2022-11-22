package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.*;
public class BannerDAO {
	public static void main(String[] args) throws SQLException {
		BannerDAO dao = new BannerDAO();
		List<BannerDTO> dtoList = dao.listBanner();
		for(BannerDTO d: dtoList) {
			System.out.print(d);
		}
	}
	JDBCUtil jdbcUtil;
	public BannerDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	public List<BannerDTO> listBanner(){
		List<BannerDTO> list = new ArrayList<BannerDTO>();
		try {    
			String sql = "select PERFORMANCE_IMG, rank from PERFORMANCE where rank < 10 order by rank";
			jdbcUtil.setSqlAndParameters(sql, null);
		   	ResultSet rs = jdbcUtil.executeQuery();
		   	
		   	while(rs.next()) {
		   		String img = rs.getString("PERFORMANCE_IMG");
		   		int rank = rs.getInt("rank");
		   		BannerDTO dto = new BannerDTO(img, rank);
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
