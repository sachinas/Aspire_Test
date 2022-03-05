package com.global;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.report.Reporter;
import com.util.common.TestUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 5;
	public static String ProductName="SachinProduct424";
	public static int productqtyTxt=15;
	public static String email;
	public static String pass;

	public BaseClass(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\config.properties");
			prop.load(ip);
			
			
			email=prop.getProperty("Account");
			pass=prop.getProperty("Password");
			
		} catch (Exception e) {
			Reporter.error(e.getMessage());
		} 
	}
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println(" Before Suite");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\resources\\Log4j.properties");
		ProductName="SahinProduct"+TestUtility.randomeNum();
	}

	public static void initializeFramework(String url) throws InterruptedException{
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "");	
			driver = new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(2);
		TestUtility.BrowserAndOSDetails();
		driver.get(url);
		TimeUnit.SECONDS.sleep(2);
	}

}
