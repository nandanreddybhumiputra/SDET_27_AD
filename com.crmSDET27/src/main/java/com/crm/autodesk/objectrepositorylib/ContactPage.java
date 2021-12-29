package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	//step 2 :-  Declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
	
	//step 3 :-  Initialization
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//step 4 :-  Utilization
	
	
	
	public WebElement getcreateContactLookUpImg() {
		return createContactLookUpImg;
	}
	
	
	public WebElement getsearchTextEdt() {
		return searchTextEdt;
	}
	
	
	
	public WebElement getsearchNowBtn() {
		return searchNowBtn;
	}
	
	
	//business library for click on createNewImg
	public void cliclOncreateContactImg() {
		createContactLookUpImg.click();
	}
	
	
	
	
	

}
