package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtilities.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	
	@FindBy(name="accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getorganizationNameEdt() {
		return organizationNameEdt;
	}
	
	public WebElement getindistryDropDown() {
		return industryDropDown;
	}
	
	public WebElement gettypeDropDown() {
		return typeDropDown;
	}
	
	
	public WebElement getsaveBtn() {
		return saveBtn;
	}
	
	
	//business library for create organizations
	public void createOrg(String orgName) {
		organizationNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	
	//business library for create organization with industry and type
	public void createOrgWithIndustryAndType(String orgName,String industry,String type) {
		organizationNameEdt.sendKeys(orgName);
		industryDropDown.sendKeys(industry);
		typeDropDown.sendKeys(type);
		saveBtn.click();
	}
	
	
	
}
