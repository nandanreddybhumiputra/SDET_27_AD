package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	//declaration
	
	
	
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	
	//initialization
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	
	

	
	//Utilization
	
	
	
	
	
	public WebElement getcontactHeaderText() {
		return contactHeaderText;
	}
	
	
	//
	
	
	
	
	
	

}
