package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.BaseClass;
import com.util.common.TestUtility;

public class DashboardPage extends BaseClass{
	
	//Initializing the Page Objects:
	public DashboardPage(){
		PageFactory.initElements(driver, this);
	}

	//Page Factory - OR:
	@FindBy(xpath="//*[text()='Discuss']") 
	public WebElement discuss;
	
	@FindBy(xpath="//*[text()='Inventory']")
	public WebElement inventory;

	@FindBy(xpath="//*[text()='Manufacturing']")
	public WebElement manufacturing;
	
	@FindBy(xpath="//*[@title='Home menu']")
	public WebElement homeMenuLink;
	
	public boolean homeMenu() {
		boolean status=false;
		status=TestUtility.clickOn(driver, homeMenuLink);
		return status;
	}

	public boolean inventoryModule() {
		boolean status=false;
		status=TestUtility.clickOn(driver, inventory);
		return status;
	}
	
	public boolean discussModule() {
		boolean status=false;
		status=TestUtility.clickOn(driver, discuss);
		return status;
	}
	
	public boolean manufacturingModule() {
		boolean status=false;
		status=TestUtility.clickOn(driver, manufacturing);
		return status;
	}
	





}








