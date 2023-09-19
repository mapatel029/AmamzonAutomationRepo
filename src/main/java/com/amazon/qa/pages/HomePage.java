package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase  {

	@FindBy(xpath= "//span[@id='nav-link-accountList-nav-line-1']")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath= "//span[contains(text(),'Baby Registry')]")
	WebElement babyRegistryLink;
	
	@FindBy(xpath= "//div[@id='nav-xshop']")
	WebElement customerServiceLink;
	
	@FindBy(xpath= "//a[contains(text(),'Deals Store')] ")
	WebElement dealsStoreLink;
	
	@FindBy(xpath= "//div[@id='nav-xshop']")
		WebElement couponsLink;
	
	
	
	//Initializing the Page Objects;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
		
		
	}
	public CouponsPage clickOnCouponsLink() {
		couponsLink.click();
		return new CouponsPage();
		
	}
	public DealsStorePage clickOnDealsStoreLink() {
		dealsStoreLink.click();
		return new DealsStorePage();
	}	
	public CustomerServicePage clickOnCustomerServiceLink() {
		customerServiceLink.click();
		return new CustomerServicePage();
	}	
	public void clickOnBabyRegistryLink() {
		Actions action= new Actions(driver);
		action.moveToElement(userNameLabel).build().perform();
		babyRegistryLink.click();
		
	}
	
	
}

