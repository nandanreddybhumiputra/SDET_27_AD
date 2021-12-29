package com.crm.AutoDesk.Contacts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import com.crm.autodesk.objectrepositorylib.OrganizationsPage;

public class CreateContactWithOrgNameTest extends BaseClass {
	@Test
	public void createContactWithOrgName() throws Throwable {
		
		//get ranDom Data
		int ranDomNum = jLib.getRanDomNumber();
				
				
		//read the data from Excel file
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 1)+ranDomNum;
		String lastName =  eLib.getDataFromExcel("Sheet1", 1, 4)+ranDomNum;
				
				
		//step 2 :- navigate to organisation module
		HomePage hp=new HomePage(driver);
		hp.organizationsLink();
		
		
		//step 3 :- click on create organisation button
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrg();
				
				
		//step 4 :- enter all the details and create new organisation
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//create contact with org name
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
 		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
 		
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName); 

       driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
      
       String parentid=driver.getWindowHandle();
       
       Set<String> child=driver.getWindowHandles();
       child.remove(parentid);
       for(String b:child)
       {
    	   driver.switchTo().window(b);
       }
       driver.findElement(By.linkText(orgName)).click();         
       driver.switchTo().window(parentid);
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       
       Actions act=new Actions(driver);
       
	  
	}		

}
