package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {

	/* author mital patel
	 * 
	 * 
	 */
	
	
	
	
	//Page Factory - OR
	@FindBy(name= "email")
	WebElement email;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueButton;
	
	@FindBy(name= "password")
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signInButton;
	
	@FindBy(id= "createAccountSubmit")
	WebElement createaccount;
	
	@FindBy(xpath= "//i[@class='a-icon a-icon-logo']")
	WebElement amazonLogo;
	
	//Initializing the Page Objects;
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	public boolean validateAmazonImage() {
		return amazonLogo.isDisplayed();
	}
	public HomePage login(String e, String pwd) throws InterruptedException {
		email.sendKeys(e);
		continueButton.click();
		password.sendKeys(pwd);
		signInButton.click();
		Thread.sleep(3000);
		return  new HomePage();
		
	}
	
	
	
	
	
	
	
	
	
	
}
