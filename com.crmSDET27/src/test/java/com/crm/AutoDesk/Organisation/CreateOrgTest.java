package com.crm.AutoDesk.Organisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import com.crm.autodesk.objectrepositorylib.CreateOrganizationPage;
import com.crm.autodesk.objectrepositorylib.HomePage;
import com.crm.autodesk.objectrepositorylib.LoginPage;
import com.crm.autodesk.objectrepositorylib.OrganizationsPage;

public class CreateOrgTest extends BaseClass {
	
	@Test(groups= {"SmokeSuite","RegressionSuite"})
	public void createOrg() throws Throwable {
	
		
	
		//get ranDom Data
		int ranDomNum = jLib.getRanDomNumber();
		
		//read the data from Excel file
		
		String orgName =eLib.getDataFromExcel("Sheet1", 1, 1)+ranDomNum;
		
		
		//step 2 :- navigate to organisation module
		HomePage hp=new HomePage(driver);
		hp.organizationsLink();
		
		
       //step 3 :- click on create organisation button
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		//step 4 :- enter last name and create new organisation
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrg(orgName);
		
		
		//step 5 :- verify organisation name in header of the msg
		String crtdName = driver.findElement(By.className("dvHeaderText")).getText();
		if(crtdName.contains(orgName)) {
		    System.out.println(orgName+"    created successfully");	
		}else {
			System.out.println(orgName+"    not created successfully");
		}
	
		
	}
	
	@Test(groups= {"SmokeSuite","RegressionSuite"})
	public void demo() {
		System.out.println("demo");
	}
	

}
