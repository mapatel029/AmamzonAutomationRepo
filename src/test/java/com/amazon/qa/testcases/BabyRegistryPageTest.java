package com.amazon.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.BabyRegistryPage;
import com.amazon.qa.pages.CustomerServicePage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.utility.TestUtil;

public class BabyRegistryPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CustomerServicePage customerservicePage;
	TestUtil testUtil;
	BabyRegistryPage babyRegistryPage;

	String sheetName = "Sheet1";

	public BabyRegistryPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();

		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getAmazonTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getAmazonData")
	public void validatesearchBabyRegistry(String name, String city, String province, String month, String year) {
		homePage.clickOnBabyRegistryLink();
		// babyRegistryPage.searchBabyRegistry("Mital", "Brampton", "Ontario",
		// "January", 2020);
		babyRegistryPage.searchBabyRegistry(name, city, province, month, 0);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
