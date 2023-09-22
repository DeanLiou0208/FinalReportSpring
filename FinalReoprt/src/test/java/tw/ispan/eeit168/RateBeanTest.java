package tw.ispan.eeit168;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class RateBeanTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void test() throws SQLException {
		Connection conn = dataSource.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rest = stat.executeQuery("SELECT * FROM rate ORDER BY id");
		ResultSetMetaData md = rest.getMetaData();
//		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int col = md.getColumnCount();
		while(rest.next()) {
			
			HashMap<String, Object> rowData = new HashMap<String , Object>();
			for(int i = 1; i <= col; i++ ) {
				rowData.put(md.getColumnName(i), rest.getObject(i));
			}
			System.out.println(rowData);
//			list.add(rowData);
		}	
	}
}
