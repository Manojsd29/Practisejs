package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {

	public ContactInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement successfulmsg;
	

	

	public WebElement getSuccessfulmsg() {

		return successfulmsg;
	
		}
	
	public String title() {
		String text = successfulmsg.getText();
		return text;
		
	}
	

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorimg ;

	@FindBy(linkText ="Sign Out")
	private WebElement signoutlink;

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public WebElement getAdminstratorimg() {
		return adminstratorimg;
	}
	
	
}
