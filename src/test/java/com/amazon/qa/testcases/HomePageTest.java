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

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CustomerServicePage customerservicePage;
	TestUtil testUtil;
	
	

	public HomePageTest() {
		super();
	}
//test cases should be separated---independent with each other
//before each test cases---launch the browser and login
	//@test--- execute test case
	//after each test cases--- close the browser
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		customerservicePage= new CustomerServicePage();
		
	}

	@Test(priority= 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items",
				"Home page title not matched");
	}
	@Test(priority= 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	@Test(priority= 3)
	public void verifyCustomerServiceLink() {
		 customerservicePage= homePage.clickOnCustomerServiceLink();
	
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
