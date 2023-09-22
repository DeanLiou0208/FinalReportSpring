package tw.ispan.eeit168;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class DataSourceTests {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() throws SQLException {
        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("select * from member");
        ResultSetMetaData md = rset.getMetaData();
        int cc= md.getColumnCount();
        while(rset.next()) {
            Map<String,Object> rowData = new LinkedHashMap<String, Object>();

            for(int i = 1; i <= cc; i++) {
                rowData.put(md.getColumnName(i), rset.getObject(i));
            }
            System.out.println(rowData);
        }
        rset.close();
        stmt.close();
        conn.close();
    }
}
