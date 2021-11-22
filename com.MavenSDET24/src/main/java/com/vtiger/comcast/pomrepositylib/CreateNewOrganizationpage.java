package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationpage {
	public CreateNewOrganizationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebttn;
	
	@FindBy(name="industry")
	private WebElement indus;
	
	@FindBy(name="accounttype")
	private WebElement type;
	
	
	public void createOrg(String orgname) {
		orgName.sendKeys(orgname);
	
	}
	

	public WebElement getIndus() {
		return indus;

}

	public WebElement getType() {
		return type;
	}


	public WebElement getSavebttn() {
		return savebttn;
	}
	
	
}