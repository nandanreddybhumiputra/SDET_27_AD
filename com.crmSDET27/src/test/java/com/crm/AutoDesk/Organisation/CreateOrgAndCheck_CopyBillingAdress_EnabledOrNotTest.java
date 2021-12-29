package com.crm.AutoDesk.Organisation;
/**
 * @author Nanda
 */
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
import com.crm.autodesk.objectrepositorylib.OrganizationsPage;

public class CreateOrgAndCheck_CopyBillingAdress_EnabledOrNotTest extends BaseClass {
	@Test
	public void createOrgCheckWithBillAdd() throws Throwable {
		
		//get ranDom Data
		int ranDomNum = jLib.getRanDomNumber();
		//get excel data
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 1)+ranDomNum;
		String address = eLib.getDataFromExcel("Sheet1", 1, 7)+ranDomNum;

		
				
				//step 2 :- navigate to organisation module
				HomePage hp=new HomePage(driver);
				hp.organizationsLink();
				
				
				 //step 3 :- click on create organisation button
				OrganizationsPage op=new OrganizationsPage(driver);
				op.clickOnCreateOrg();
				
				
				//organisation name
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				
				
				//enter address
				driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(address);
				//select checkbox
				driver.findElement(By.xpath("//input[@onclick='return copyAddressRight(EditView)']")).click();
				
				
				//validation
				//click save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				String billAdd = driver.findElement(By.xpath("//span[@id='dtlview_Shipping Address']")).getText();
				if(billAdd.contains(address)) {
					System.out.println("PASS");
				}else {
					System.out.println("FAIL");
				}
				
	}

}
