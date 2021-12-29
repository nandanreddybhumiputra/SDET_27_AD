package com.crm.AutoDesk.Organisation;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtilities.BaseClass;
import com.crm.autodesk.genericUtilities.ExcelUtility;
import com.crm.autodesk.genericUtilities.FileUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;
import com.crm.autodesk.genericUtilities.WebDriverUtility;
import com.crm.autodesk.objectrepositorylib.HomePage;
import com.crm.autodesk.objectrepositorylib.LoginPage;

public class CreateOrgWithShippingAddressTest extends BaseClass{
	@Test
	public void createOrgWithShippingAddressTest() throws Throwable {
		
		//get ranDom Data
		int ranDomNum = jLib.getRanDomNumber();
			
		//read the data from Excel file
		String orgName =eLib.getDataFromExcel("Sheet1", 1, 1)+ranDomNum;
		String shpAddress =eLib.getDataFromExcel("Sheet1", 1, 7);
		
	
				//step 2 :- navigate to organisation module
				HomePage hp=new HomePage(driver);
				hp.organizationsLink();
				
				
		       //step 3 :- click on create organisation button
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				//organisation name
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				//enter shipping address
				driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(shpAddress);
				//validation
				//click save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
				
				//shipping address capture and store
				String crShpAddress = driver.findElement(By.xpath("//td[@id='mouseArea_Shipping Address']")).getText();
				//compare
				if(crShpAddress.contains(shpAddress)) {
					System.out.println("PASS");
				}else {
					System.out.println("FAIL");
				}
				
	}
}
