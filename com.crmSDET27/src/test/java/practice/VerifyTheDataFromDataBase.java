package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheDataFromDataBase {
	public static void main(String[] args) throws Throwable {
		
		
		//register the database
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				
				//establish the connection with the database
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				
				//issue the statement
				Statement statement = connection.createStatement();
				
				//execute querry
				ResultSet result = statement.executeQuery("select*from studentinfo;");
				
				String name="nandan" ;
				
				while(result.next()) {
					if(result.getString(2).equals(name)) {
						System.out.println("name is there");
					}else {
						System.out.println("name not there");
					}
				}
				//close the connection
				connection.close();
	}

}
