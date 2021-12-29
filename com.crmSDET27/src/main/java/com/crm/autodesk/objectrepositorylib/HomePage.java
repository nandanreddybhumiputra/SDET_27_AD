package com.crm.autodesk.objectrepositorylib;
//step 1 :- create a seperate class for homepage

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	//step 2 :- Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	//if need we can add all modules here
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	
	//step 3 :-  Initialzation
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//step 4 :- Utilization
	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}
	
	public WebElement getContactsLnk() {
		return contactsLnk;
	}
	
	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}
	
	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	
	//
	
	
	public WebElement getSigOutLnk() {
		return SignOutLnk;
	}
	
	
	//Business Library to click on organizations
	public void organizationsLink() {
		organizationsLnk.click();
	}
	
	//Business Library to click on contacts
	public void clickOnContactsLnk() {
		contactsLnk.click();
	}
	
	//Business Library for logout
	public void logout(WebDriver driver) {
		mouseOverOnElement(driver, administratorImg);
		SignOutLnk.click();
	
	}
		
	}		
		
		

