package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;

public class CreateNewContact<CreateOranizationWithContactUsingPomTest> {

	public CreateNewContact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="firstname")
	private WebElement fname;
	

	@FindBy(name="lastname")
	private WebElement lname;
	
	@FindBy(xpath="//input[@name=\"account_name\"]/following-sibling::img")
	private WebElement orglukupicon;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebutton;
	
	
	
	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getOrglukupicon() {
		return orglukupicon;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	
	
	
	 
	
	
}
