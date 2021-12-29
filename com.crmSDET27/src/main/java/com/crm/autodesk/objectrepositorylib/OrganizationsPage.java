package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//
public class OrganizationsPage {
	//step 2 :-  	
		@FindBy(xpath="//img[@alt='Create Organization...']")
		private WebElement createOrgLookUpImg;
		
		@FindBy(name="search_text")
		private WebElement searchTextEdt;
		
		@FindBy(name="submit")
		private WebElement searchNowBtn;
		
		
		//step 3 :-  
		public OrganizationsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//step 4 :-  
		public WebElement getCreateOrgLookUpImg() {
			return createOrgLookUpImg;
		}
		
		
		public WebElement getsearchTextEdt() {
			return searchTextEdt;
		}
		
		public WebElement getsearchNowBtn() {
			return searchNowBtn;
		}
		
		
		//Business Library
		public void clickOnCreateOrg() {
			createOrgLookUpImg.click();
		}
		
}
