package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	public static void main(String[] args) throws SQLException {
		JDBCUtil j = new JDBCUtil();
		j.setSqlAndParameters("select * from tab", null);
		ResultSet rs = j.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
	}
}
