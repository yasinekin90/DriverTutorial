package temp;

import org.testng.annotations.Test;
import utils.MyConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MyConnectionTest {
    @Test
    public void test01() throws SQLException {
        MyConnection myConnection=new MyConnection("jdbc:mysql://127.0.0.1:3306/sakila",
                "root",
                "");

        ResultSet resultSet =myConnection.getResultSet("SELECT * FROM actor;");

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int rowNum = rsmd.getColumnCount();

        for (int i = 1; i <= rowNum ; i++) {
            System.out.printf("%-30s", rsmd.getColumnName(i));
        }
        System.out.println();
        while (resultSet.next()){
            for (int i = 1; i <= rowNum; i++) {
                System.out.printf("%-30s", resultSet.getString(i));
            }
            System.out.println();
        }

  myConnection.tearDown();
    }
}
