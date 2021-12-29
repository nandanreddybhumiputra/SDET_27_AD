package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VeryfyDataByTryCatch {
public static void main(String[] args) throws Throwable {
		Connection connection = null;
		try {
		//register the database
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				
				//establish the connection with the database
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				
				//issue the statement
				Statement statement = connection.createStatement();
				
				//execute querry
				ResultSet result = statement.executeQuery("select*from studentinfo;");
				
				String name="nandan" ;
				
				while(result.next()) {
					
						System.out.println(result.getString(2));
				}
		} catch(Exception e) {
			e.printStackTrace();
			
		}finally {
				
				
				//close the connection
				connection.close();
		}
	}

}
