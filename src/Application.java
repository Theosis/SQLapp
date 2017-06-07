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
		//String sql = "select * from customer limit 9";
		String sql = "select person.first_name, person.last_name, pet.name from person, pet limit 9";
		try{
			Class.forName("com.mysql.jdbc.Driver");
            /* con = DriverManager.getConnection("jdbc:mysql://localhost/Customers?"
                                + "user=root&password=password");
                                */
            con = DriverManager.getConnection("jdbc:mysql://localhost/pets?"
                    + "user=root&password=password");
            
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
/*				System.out.print(rs.getString("FirstName") + "\t");
				System.out.print(rs.getString("LastName"));*/
				
				System.out.print(rs.getString("first_name") + " " + rs.getString("last_name") + "'s pet is:  \t");
				System.out.print(rs.getString("name"));
				
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