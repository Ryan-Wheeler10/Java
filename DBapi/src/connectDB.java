import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
*
* @author Ryan Wheeler
*/

public class connectDB {

	public static void main(String[] args) {
		connectDB connectDB = new connectDB();
		connectDB.connectToDB().toString();
		System.out.println("My connect to DB variable:"+ connectDB.connectToDB().toString());
	}
	public String connectToDB() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String Payload = null;

		System.out.println("Connecting database...");

		try {
			 connection = 
		        DriverManager.getConnection("jdbc:mysql://localhost/myDB", "name", "password");
			 System.out.println("Connect to database");
			} catch (SQLException e) {
				System.out.println("Unable to connect to database");
			}
		if(connection != null) {
		    try {
		       statement = connection.createStatement();
		    } catch (SQLException e) {
		       System.out.println("Unable to create statement");
		    }
		}
		if(statement != null) {
			   try {
			        resultSet = statement.executeQuery("SELECT * FROM mytable");
			   } catch (SQLException e) {
			        System.out.println("Unable to run statement");
			   }
		        }
		if(resultSet != null) {
			   try {
				while(resultSet.next()) {
					Payload = resultSet.getString(1);
					//System.out.println(resultSet.getString(1));
				}
			   } catch (SQLException e) {
			        System.out.println("Unable to show resultset");
			   }
			}
		try {
		     resultSet.close();
		     statement.close();
		     connection.close();
		     System.out.println("Disconnected from the database");
		} catch (SQLException e) {
		     e.printStackTrace();
		}
		return Payload;
	}
	
}