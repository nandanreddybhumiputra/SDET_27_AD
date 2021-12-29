package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertTheDataIntoDataBase {
	public static void main(String[] args) throws Throwable {
		//register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//establish the connection with the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		
		//issue the statement
		Statement statement = connection.createStatement();
		
		//execute querry
		int result = statement.executeUpdate("insert into studentinfo(fname,lname,address)value('nandan','reddi','india');");
		
		//verification
		if(result==1) {
			System.out.println("data added");
		}else {
			System.out.println("data not added");
		}
		
		//close the connection
		connection.close();
		
	}

}
