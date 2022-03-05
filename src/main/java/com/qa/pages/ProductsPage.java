package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.BaseClass;
import com.util.common.TestUtility;

public class ProductsPage extends BaseClass{
	
	//Initializing the Page Objects:
	public ProductsPage(){
		PageFactory.initElements(driver, this);
	}

	//Page Factory - OR:
	@FindBy(xpath="//*[contains(text(),'Create')]") 
	public WebElement createBtn;
	
	@FindBy(xpath="//*[@name='name']")
	public WebElement productNameTxt;
	
	@FindBy(xpath="//*[@title='Save record']")
	public WebElement saveBtn;

	@FindBy(xpath="//*[text()='Update Quantity']")
	public WebElement updateQuantityLink;
	
	@FindBy(name="inventory_quantity")
	public WebElement countedQuantity;

	public boolean createNewProduct(String productName) {
		boolean status=false;
		boolean flag1=TestUtility.clickOn(driver, createBtn);
		if (flag1) {
			boolean productFlag=TestUtility.sendKeys(driver, productNameTxt, productName);
			if (productFlag) {
				status=TestUtility.clickOn(driver, saveBtn);
			}
		}
		return status;
	}
	
	public boolean updateQuantity(int countedQuantityNo) {
		boolean status=false;
		boolean updatequantityFlag=TestUtility.clickOn(driver, updateQuantityLink);
		if (updatequantityFlag) {
			boolean creatFlag=TestUtility.clickOn(driver, createBtn);
			if (creatFlag) {
				TestUtility.sendKeysClean(driver, countedQuantity);
				boolean countedQuantityNoFlag=TestUtility.sendKeys(driver, countedQuantity, Integer.toString(countedQuantityNo));
				if (countedQuantityNoFlag) {
					status=TestUtility.clickOn(driver, saveBtn);
				}
			}
		}
		return status;
	}
	
	
	
		
}








