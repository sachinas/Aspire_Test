package aspire_test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.global.BaseClass;
import com.qa.pages.DashboardPage;
import com.qa.pages.InventoryPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ManufacturingOrdersPage;
import com.qa.pages.ProductsPage;
import com.util.common.TestUtility;


public class Aspire_TestCases extends BaseClass {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	InventoryPage inventorypage;
	ProductsPage productpage;
	ManufacturingOrdersPage manufacturingpage;
	SoftAssert s_assert;

	public Aspire_TestCases()
	{
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp() throws InterruptedException{
		System.out.println("@BeforeMethod HomePageTest");
		initializeFramework(prop.getProperty("url"));
		
		loginpage = new LoginPage();
		dashboardpage=new DashboardPage();
		inventorypage=new InventoryPage();
		productpage=new ProductsPage();
		manufacturingpage=new ManufacturingOrdersPage();
		
		
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown(){
		driver.close();
	}


	@Test(priority=1)
	public void verifyInventoryFeature(){
		s_assert = new SoftAssert();
		boolean loginflag=loginpage.userLogin(email,pass);
		if (loginflag) {
			boolean inventoryFlag=dashboardpage.inventoryModule();
			if (inventoryFlag) {
				boolean productFlag=inventorypage.products();
				if (productFlag) {
					boolean newproductFlag=productpage.createNewProduct(ProductName);
					if (newproductFlag) {
						System.out.println("");
						boolean updateQuantityFlag=productpage.updateQuantity(productqtyTxt);
						if (updateQuantityFlag) {
							boolean homeMenuFlag=dashboardpage.homeMenu();
							s_assert.assertTrue(homeMenuFlag, "Home Menu link not working");
						}
						s_assert.assertTrue(updateQuantityFlag, "update Quantity not working");
					}
					s_assert.assertTrue(newproductFlag, "New product not create");
				}
				s_assert.assertTrue(productFlag, "product link not open");
			}
			s_assert.assertTrue(inventoryFlag, "Inventory module not open");
		}
		s_assert.assertTrue(loginflag, "User not logging");
		s_assert.assertAll();	
	}

	@Test(priority=2)
	public void verifyManufacturingFeature(){
		s_assert = new SoftAssert();
		boolean loginflag=loginpage.userLogin(email,pass);
		if (loginflag) {
			boolean manufacturingFlag=dashboardpage.manufacturingModule();
			if (manufacturingFlag) {
				boolean creatnewFlag=manufacturingpage.createNewOrder(ProductName, productqtyTxt,productqtyTxt);
				s_assert.assertTrue(creatnewFlag, "creat new order not working");
			}
			s_assert.assertTrue(manufacturingFlag, "manufacturing module not open");
		}
		s_assert.assertTrue(loginflag, "User not logging");
		s_assert.assertAll();	
	}
	
	@Test(priority=3)
	public void verifyProductState(){
		s_assert = new SoftAssert();
		boolean loginflag=loginpage.userLogin(email,pass);
		if (loginflag) {
			boolean manufacturingFlag=dashboardpage.manufacturingModule();
			if (manufacturingFlag) {
				manufacturingpage.filter();
				String state=TestUtility.dynamicXpath(ProductName);
				System.out.println("Product State ::"+state);
				s_assert.assertEquals(state, "Done");
			}
			s_assert.assertTrue(manufacturingFlag, "manufacturing module not open");
		}
		s_assert.assertTrue(loginflag, "User not logging");
		s_assert.assertAll();	
	}




}








