package tw.ispan.eeit168;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyShopeViewTest {
	
	@Autowired
	private DataSource dataSource; 
	
	@Test
	public void test() throws SQLException  {
		
		Connection conn = dataSource.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rest = stat.executeQuery("SELECT * FROM my_shop");
		
		while(rest.next()){
			
			String col1 = rest.getString(1);
			String col2 = rest.getString(2);
			String col3 = rest.getString(3);
			String col4 = rest.getString(4);
			String col5 = rest.getString(5);
			String col6 = rest.getString(6);
			
			System.out.println(col1+" "+col2+" "+col3+" "+col4+" "+col5+" "+col6);
			
		}
		rest.close();
		stat.close();
		conn.close();
		
	}
	
	
}
