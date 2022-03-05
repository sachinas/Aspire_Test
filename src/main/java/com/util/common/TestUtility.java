package com.util.common;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.global.BaseClass;
import com.report.Reporter;

public class TestUtility extends BaseClass {
	public static int timeout=3;
	public static Select select;

	public static boolean clickOn(WebDriver driver, WebElement element) 
	{
		boolean flag=false;
		try {
			if(element.isDisplayed()) {
				new WebDriverWait(driver, 4).until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				explicitWait(3);
				try {
				Reporter.pass("Click on WebElement "+element.getText()); //+element.getText()
				}catch (Exception e) {
					
				}
				flag=true;
			}
		}catch (Exception  e) {
			Reporter.error("Failed due to >>> "+element+" REASON >>"+e.getMessage());
		}
		return flag;
	}


	public static boolean sendKeys(WebDriver driver, WebElement element, String value) 
	{
		boolean flag=false;
		try {
			if(element.isDisplayed()) {
				new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOf(element));
				element.sendKeys(value);
				Reporter.pass("Entered Test Data "+value);
				flag=true;
			}
		}catch (Exception  e) {
			Reporter.error("Failed due to >>> "+element+" REASON >>"+e.getMessage());
		}
		return flag;
	}
	
	public static boolean sendKeysClean(WebDriver driver, WebElement element) 
	{
		boolean flag=false;
		try {
			if(element.isDisplayed()) {
				new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOf(element));
				for (int i = 0; i <10; i++) {
					element.sendKeys(Keys.BACK_SPACE);
				}
				flag=true;
			}
		}catch (Exception  e) {
			Reporter.error("Failed due to >>> "+element+" REASON >>"+e.getMessage());
		}
		return flag;
	}
	
	public static boolean sendKeysWithEncryption(WebDriver driver, WebElement element, String value) 
	{
		boolean flag=false;
		try {
			if(element.isDisplayed()) {
				new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOf(element));
				element.sendKeys(value);
				Reporter.pass("Entered password ************ ");
				flag=true;
			}
		}catch (Exception  e) {
			Reporter.error("Failed due to >>> "+element+" REASON >>"+e.getMessage());
		}
		return flag;
	}
	
	public static String getText(WebElement element) {
		String gettext=null;
		try {
			if(element.isDisplayed()) {
				gettext=element.getText();
				Reporter.pass("Get Actual Text >> WebElement "+gettext);
			}
		}catch (Exception  e) {
			Reporter.error("Failed due to >>> "+element+" REASON >>"+e.getMessage());
		}
		return gettext;
	}

	public static boolean selectValueFromDropDownByText(WebElement element, String text) 
	{
		boolean flag=false;
		try {
			if(element.isDisplayed()) {
				select = new Select(element);
				select.selectByVisibleText(text);
				Reporter.pass(element.getText()+" Element is displayed and Select dropDown text >>"+text);
				flag=true;
			}
		}catch (Exception  e) {
			Reporter.error("Failed due to >>> "+element+" REASON >>"+e.getMessage());
		}
		return flag;
	}

	public static void explicitWait(int timeSeconds) {
		try {
			TimeUnit.SECONDS.sleep(timeSeconds);
		} catch (Exception e) {
			Reporter.warn("Error in TimeUnit wait");
		}
	}
	public static void BrowserAndOSDetails() {
		Reporter.pass("Get Brower Details");
		try {
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			String browserName = cap.getBrowserName().toLowerCase();
			System.out.println(browserName);
			String os = cap.getPlatform().toString();
			Reporter.pass(os);
			String v = cap.getVersion().toString();
			Reporter.pass(v);
			Reporter.pass("OS = " + os + ", Browser = " + browserName + " "+ v);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String dynamicXpath(String element) {
        String status = "";
       boolean flag = driver.findElements(By.xpath("//*[text()='"+element+"']")).size() != 0;
        if (flag) {
        	status =driver.findElement(By.xpath("(//*[text()='"+element+"']//parent::td[1]/following-sibling::td[6])[1]")).getText();
        }
        else {
        	status="No element found";
        }

        return status;
    }
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(3);
		return (generatedString2);
	}


}

