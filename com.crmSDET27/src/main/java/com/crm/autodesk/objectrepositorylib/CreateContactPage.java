package com.crm.autodesk.objectrepositorylib;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	//declaration
	@FindBy(name="lastname")
	private WebElement contactLastName;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameLookUpImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//declaration
	public WebElement getcontactLastName() {
		return contactLastName;
	}
	
	public WebElement getorgNameLookUpImg() {
		return orgNameLookUpImg;
	}
	
	
	public WebElement getsaveBtn() {
		return saveBtn;
	}
	
	
	//business logic for create contact with lastName
		public void createContactWithLastName(String lastName) {
			contactLastName.sendKeys(lastName);
			saveBtn.click();
		}
	
	
	
	
	
	
	
	

}
