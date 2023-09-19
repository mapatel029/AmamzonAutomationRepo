package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CustomerServicePage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.utility.TestUtil;



public class CustomerServicePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	CustomerServicePage customerservicePage;
	TestUtil testUtil;
	
	public CustomerServicePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil= new TestUtil();
		customerservicePage= new CustomerServicePage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		customerservicePage= homePage.clickOnCustomerServiceLink();
	}
	@Test(priority= 1)
	public void verifyCustomerServiceHeading() {
		Assert.assertTrue(customerservicePage.verifyCustomerServiceHeading(), "CustomerServiceHeading is msiing on the top");
		
	}
	@Test(priority= 2)
	public void clickAccessibilty() {
		customerservicePage.clickAccessibilty();
		
	}
	
	
	@AfterMethod
    public void tearDown() {
		   driver.quit();	
	}
}
