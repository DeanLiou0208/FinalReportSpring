package tw.ispan.eeit168;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class DomainBeanTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void test() throws SQLException {
		String str ="my_shop";
		//請在字串內改你要測的Table名稱
		Connection conn = dataSource.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rest = stat.executeQuery("SELECT * FROM " + str);
		
		ResultSetMetaData metaData = rest.getMetaData();
		int col = metaData.getColumnCount();
		while(rest.next()) {
		LinkedHashMap<String, Object> rowData = new LinkedHashMap<String , Object>();
		for(int i = 1; i <= col; i ++) {
			rowData.put(metaData.getColumnName(i), rest.getObject(i));
			//透過for迴圈 以LinKHaspMap的方式 每跑一次迴圈抓一次(K,V),K是欄位數 V是資料庫撈出來的值
		}
		System.out.println(rowData);
		}
		rest.close();
		stat.close();
		conn.close();
	}
}
