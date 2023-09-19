package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
	 loginPage = new LoginPage();
	}
	@Test(priority= 1)
	public void loginPageTitelTest() {
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"dir=\"ltr\">Amazon Sign In" );
	}
	@Test(priority= 2)
	public void amazonLogoImageTest() {
		boolean flag= loginPage.validateAmazonImage();
		Assert.assertTrue(flag);
		
	}
	@Test(priority= 3)
	public void loginTest() throws InterruptedException {
		homePage= loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
    public void tearDown() {
		   driver.quit();	
	}

	
}

	