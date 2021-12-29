package com.crm.autodesk.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.objectrepositorylib.HomePage;
import com.crm.autodesk.objectrepositorylib.LoginPage;

public class BaseClass {

  //public DataBaseutility=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver;
	
	@BeforeSuite(groups= {"SmokeSuite","RegressionSuite"})
	public void dbConnection() {
		
		//dLib.connectionToDB();
		System.out.println("======Database Connection Successfully======");
	}
	
	@BeforeClass(groups= {"SmokeSuite","RegressionSuite"})
	public void launchBrowser() throws Throwable  {
		//read the data
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		
		wLib.waitForPageToLoad(driver);
		wLib.maximizeWindow(driver);
		driver.get(URL);
		System.out.println("=====Browser Launched=====");
	}
	
	@BeforeMethod(groups= {"SmokeSuite","RegressionSuite"})
	public void loginToApp() throws Throwable {
		//read the data
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("=====Login Successfully=====");
	}
	
	@AfterMethod(groups= {"SmokeSuite","RegressionSuite"})
	public void logoutOfApp() {
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		System.out.println("=====Logout Successfully=====");
	}
	
	@AfterClass(groups= {"SmokeSuite","RegressionSuite"})
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser Closed");
	}
	
	@AfterSuite(groups= {"SmokeSuite","RegressionSuite"})
	public void closeDbConnection() {
		//dlib.closeDB();
		System.out.println("=====DataBase Closed=====");
	}
	
}
