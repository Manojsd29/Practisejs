package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationInfo {
	public OrganizationInfo(WebDriver driver) {
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
	
	
	
		
	}



	
		
	
	
	
	
	

