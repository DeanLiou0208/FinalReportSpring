package tw.ispan.eeit168.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DomainTest {
	
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=pet_web;trustServerCertificate=true";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "P@ssw0rd";
	
	
	
	
	public static void main(String[] args) {
		DomainTest domainTest = new DomainTest();
		List<OrderListBean> select = domainTest.select();
		System.out.println("資料:"+select);
		
	}
	
	
	private static final String SELECT_ALL = "select * from order_list";
	
	public List<OrderListBean> select() {
		List<OrderListBean> result = null;
		ResultSet rset = null;
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME,PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);) {
			
			rset = stmt.executeQuery();
			result = new ArrayList<>();
			while(rset.next()) {
				OrderListBean oLB = new OrderListBean();
				oLB.setId(rset.getInt("id"));
				oLB.setFkMemberId(rset.getInt("fk_member_id"));
				oLB.setTotalPrice(rset.getDouble("total_price"));
				oLB.setBonus(rset.getDouble("bonus"));
				oLB.setCreateAt(rset.getTimestamp("create_at"));
				
				result.add(oLB);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return result;
	}
	
	
}
