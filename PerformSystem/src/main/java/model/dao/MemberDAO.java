package model.dao;

public class MemberDAO {
	public List<Member> MemberList() throws SQLException {
        String sql = "select name, category, runTime, ageGroup, cast from performance"
      jdbcUtil.setSqlAndParameters(sql, null);   // JDBCUtil에 query문과 매개 변수 설정
      
      try {
         ResultSet rs = jdbcUtil.executeQuery();      // query 실행
         List<Member> memList = new ArrayList<Member>();   // member들의 리스트 생성
         while (rs.next()) {
            User member = new Member(         
            rs.getString("name"),
            rs.getString("category"),
            rs.getString("runTime"),
            rs.getString("ageGroup"),
            memList.add(cast);        
         }      
         return memList;               
            
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close();      // resource 반환
      }
      return null;
   }
}
