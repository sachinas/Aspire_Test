package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.BaseClass;
import com.util.common.TestUtility;

public class LoginPage extends BaseClass{
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Page Factory - OR:
	@FindBy(id="login") 
	@CacheLookup
	public WebElement email;
	
	@FindBy(id="password")
	@CacheLookup
	public WebElement password;

	@FindBy(xpath="//button[text()='Log in']")
	@CacheLookup
	public WebElement loginBtn;

	public boolean userLogin(String email,String password) {
		boolean status=false;
		boolean emailFlag=TestUtility.sendKeys(driver, this.email, email);
		if (emailFlag) {
			boolean passwordFlag=TestUtility.sendKeysWithEncryption(driver, this.password, password);
			if (passwordFlag) {
				status=TestUtility.clickOn(driver, loginBtn);
			}
		}
		return status;
	}





}








