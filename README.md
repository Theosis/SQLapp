# SQLapp
Connecting to MySQL from Eclipse

Create a Java Application and add the following code as a class. This will illustrate how to connect to Java from Eclipse. Make sure it works as shown below. Then modify the SQL Statement to retrieve the people and pets.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from customers";
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Customers?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.print(rs.getString("FirstName") + "\t");
				System.out.print(rs.getString("LastName"));
				System.out.println();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
