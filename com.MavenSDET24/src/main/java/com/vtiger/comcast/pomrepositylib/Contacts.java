package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {
	//Creating Constructor having webdriver driver as agrument
	
	public  Contacts(WebDriver driver) {
		PageFactory.initElements(driver, this);

		
	}

	public WebElement getCreatecontactbttn() {
		return createcontactbttn;
	}

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createcontactbttn;
	
	
}

