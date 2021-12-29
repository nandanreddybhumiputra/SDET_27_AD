package com.rmgyantra.testScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectAndCheckInDataBase {
public static void main(String[] args) throws Throwable  {
String expectedProjectName="nanda5" ;
	//launch the browser
    System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//login to application
	driver.get("http://localhost:8084/");
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
	
	//click on projects
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	
	//click on create project
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	
	//enter mandatry flds
	driver.findElement(By.name("projectName")).sendKeys("nanda5");
	driver.findElement(By.name("createdBy")).sendKeys("Nanda");
	WebElement projectStatus=driver.findElement(By.xpath("//label[text()='Project Status ']/../select"));
	Select s=new Select(projectStatus);
	s.selectByIndex(1);
	
	//click on add project
	driver.findElement(By.cssSelector("input[type='submit']")).click();
	
	
	
	//establish the connection with database
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	
	//issue the statement
	Statement statement = connection.createStatement();
	
	//execute querry
	ResultSet result = statement.executeQuery("select*from project;");
	while(result.next()) {
		if(result.getString(4).equals(expectedProjectName)){
		System.out.println("yes");
		}
	}
//close the connection
	connection.close();
	
}
}
