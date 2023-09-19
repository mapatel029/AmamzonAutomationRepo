package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class BabyRegistryPage extends TestBase {

	Select select;
	@FindBy(id="a-autoid-4")
	WebElement submit;
	
	@FindBy(id="nameOrEmailField")
	WebElement enterName;
	
	@FindBy(id="search-submit-button")
	WebElement searchButton;

	@FindBy(id="cityField")
	WebElement cityName;
	
	@FindBy(id="stateField")
	WebElement provinceName;
	

	
public void searchBabyRegistry(String name, String city, String province, String month, int i) {
	
enterName.sendKeys("name");
searchButton.click();

enterName.sendKeys("name");
cityName.sendKeys("city");
provinceName.sendKeys("province");

driver.findElement(By.id("a-autoid-2-announce"));
select.selectByVisibleText("month");
driver.findElement(By.id("a-autoid-3-announce"));
select.selectByVisibleText("year");

submit.click();
	
}
	
	}
	
	
	
		
		
	
	
	

