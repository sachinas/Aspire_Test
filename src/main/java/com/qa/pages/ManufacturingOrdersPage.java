package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.BaseClass;
import com.util.common.TestUtility;

public class ManufacturingOrdersPage extends BaseClass{
	
	//Initializing the Page Objects:
	public ManufacturingOrdersPage(){
		PageFactory.initElements(driver, this);
	}

	//Page Factory - OR:

	@FindBy(xpath="//*[contains(text(),'Create')]") 
	public WebElement createBtn;
	
	@FindBy(xpath="//*[@name='product_id']/div//input")
	public WebElement productName;
	
	@FindBy(xpath="(//*[@name='product_qty'])[1]")
	public WebElement productqtyTxt;

	@FindBy(name="action_confirm")
	public WebElement confirmBtn;
	
	@FindBy(xpath="(//*[@name='qty_producing'])[1]") 
	public WebElement quantityTxt;

	@FindBy(xpath="(//*[text()='Mark as Done'])[2]")
	public WebElement makeAsDoneBtn;
	
	@FindBy(xpath="//*[text()='Ok']")
	public WebElement okBtn;
	
	@FindBy(xpath="//*[@title='Save record']")
	public WebElement saveBtn;
	
	@FindBy(xpath="//*[@title='Search for records']")
	public WebElement searchText;
	
	public void filter() {
		TestUtility.explicitWait(1);
		TestUtility.sendKeysClean(driver, searchText);
		TestUtility.explicitWait(2);
	}
	
	public boolean createNewOrder(String prodName,int productqtyNo,int quantityTxtNo) {
		boolean status=false;
		boolean createflag1=TestUtility.clickOn(driver, createBtn);
		if (createflag1) {
			boolean prodnameFlag=TestUtility.sendKeys(driver, productName, prodName);
			if (prodnameFlag) {
				TestUtility.explicitWait(2);
				TestUtility.sendKeysClean(driver, productqtyTxt);
				boolean quantityNoFlag=TestUtility.sendKeys(driver, productqtyTxt, Integer.toString(productqtyNo));
				if (quantityNoFlag) {
					boolean confirmFlag=TestUtility.clickOn(driver, confirmBtn);
					TestUtility.explicitWait(3);
					if (confirmFlag) {
						TestUtility.sendKeysClean(driver, quantityTxt);
						boolean makeasDoneFlag=TestUtility.sendKeys(driver, quantityTxt, Integer.toString(quantityTxtNo));
						if (makeasDoneFlag) {
							boolean makefalge=TestUtility.clickOn(driver, makeAsDoneBtn);
							if (makefalge) {
								boolean okFlag=TestUtility.clickOn(driver, okBtn);
								if (okFlag) {
									status=TestUtility.clickOn(driver, saveBtn);
								}
							}
							
						}
					}
				}
				
			}
			
		}
		return status;
	}
	
	
}








