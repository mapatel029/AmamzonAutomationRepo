package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class CustomerServicePage extends TestBase  {

	@FindBy(xpath="//h1[@class='fs-heading bolded']")
	WebElement customerServiceHeading;

	//Initializing the Page Objects;
	public CustomerServicePage() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyCustomerServiceHeading() {
		return customerServiceHeading.isDisplayed();
		
	}
	public void clickAccessibilty() {
		driver.findElement(By.xpath("//div[contains(text(),'Accessibility')]")).click();
		
	}
	
}
