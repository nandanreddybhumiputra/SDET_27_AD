package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtilities.WebDriverUtility;

//step 1 :- create seperate class
public class LoginPage extends WebDriverUtility {

	//step 2 :-  identify all web elements and declare them as private
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	
	//step 3 :-  initialize the elements using constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//step 4 :-  utilisation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//business library
	public void login(String username,String password) {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
	}
	
}
