package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.BaseClass;
import com.util.common.TestUtility;

public class InventoryPage extends BaseClass{
	
	//Initializing the Page Objects:
	public InventoryPage(){
		PageFactory.initElements(driver, this);
	}

	//Page Factory - OR:
	@FindBy(xpath="//*[@class='o_menu_sections']//div[1]/button") 
	public WebElement operationsMenu;
	
	@FindBy(xpath="//*[@class='o_menu_sections']//div[2]/button")
	public WebElement productsMenu;
	
	@FindBy(xpath="(//*[text()='Products'])[2]")
	public WebElement productsSubMenu;

	@FindBy(xpath="//*[@class='o_menu_sections']//div[3]/button")
	public WebElement reportingMenu;
	
	@FindBy(xpath="//*[@class='o_menu_sections']//div[4]/button")
	public WebElement configurationMenu;

	public boolean products() {
		boolean status=false;
		boolean flag1=TestUtility.clickOn(driver, productsMenu);
		if (flag1) {
			status=TestUtility.clickOn(driver, productsSubMenu);
		}
		return status;
	}
	
	public boolean operations() {
		boolean status=false;
		status=TestUtility.clickOn(driver, operationsMenu);
		return status;
	}
	
	public boolean reporting() {
		boolean status=false;
		status=TestUtility.clickOn(driver, reportingMenu);
		return status;
	}
	
	public boolean configuration() {
		boolean status=false;
		status=TestUtility.clickOn(driver, configurationMenu);
		return status;
	}
}








