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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtilities.BaseClass;
import com.crm.autodesk.genericUtilities.ExcelUtility;
import com.crm.autodesk.genericUtilities.FileUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;
import com.crm.autodesk.genericUtilities.WebDriverUtility;
import com.crm.autodesk.objectrepositorylib.CreateOrganizationPage;
import com.crm.autodesk.objectrepositorylib.HomePage;
import com.crm.autodesk.objectrepositorylib.LoginPage;
import com.crm.autodesk.objectrepositorylib.OrganizationsPage;

public class CreateOrgWithIndustryAndtypeTest extends BaseClass {
	@Test
	public void createOrgWithIndustryAndType() throws Throwable {
		
		//get ranDom Data
		int ranDomNum = jLib.getRanDomNumber();
		//read the data from Excel file
		
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 1)+ranDomNum;
		String industry = eLib.getDataFromExcel("Sheet1", 1, 5);
		String type =eLib.getDataFromExcel("Sheet1", 1, 6);
		
		
		//step 2 :- navignisation module
		HomePage hp=new HomePage(driver);
		hp.organizationsLink();
		
		
       //step 3 :- click on create organisation button
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		
		//enter lastName,industry,type and click on save
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.createOrgWithIndustryAndType(orgName, industry,type);
		
		//verification
	    //industry 
	   String crIndustry = driver.findElement(By.xpath("//td[@id='mouseArea_Industry']")).getText();
		System.out.println(crIndustry);
		System.out.println(industry);
	  if(crIndustry.contains(industry)) {
		   System.out.println(industry+"  added successfully");
		}else {
	        System.out.println(industry+"  not added");
		}
	  
	  //type
	  String crType = driver.findElement(By.xpath("//td[@id='mouseArea_Type']")).getText();
	  System.out.println(crType);
	  System.out.println(type);
	 if (crType.contains(type)) {
		 System.out.println(type+"  added successfully");
	 }else {
		 System.out.println(type+"  not added");
	 }
	
}


}