package com.crm.AutoDesk.Contacts;

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
import com.crm.autodesk.objectrepositorylib.ContactPage;
import com.crm.autodesk.objectrepositorylib.CreateContactPage;
import com.crm.autodesk.objectrepositorylib.HomePage;
import com.crm.autodesk.objectrepositorylib.LoginPage;

public class CreateContactTest extends BaseClass {
	@Test(groups= {"SmokeSuite","RegressionSuite"})
	public void createContactTest() throws Throwable {

		//get ranDom Data
		int ranDomNum = jLib.getRanDomNumber();


		//read the data from Excel file
		String lastName =  eLib.getDataFromExcel("Sheet1", 1, 4)+ranDomNum;


		//click on contacts link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLnk();

		//step 3 :- click on create contact button
		ContactPage cp=new ContactPage(driver);
		cp.cliclOncreateContactImg();


		//step 4: enter all the details & create new contact
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContactWithLastName(lastName);
		//step 5: verify the contact name in header of the msg

		String actualsuc_msg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actualsuc_msg.contains(lastName))
		{
			System.out.println("contact is successfully....pass");
		}
		else 
		{
			System.out.println("contact is not created....fail");
		}


	}

}
