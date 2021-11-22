package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
WebDriver driver;
public Homepage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(linkText ="Organizations")
private WebElement Orglink;

@FindBy(linkText ="Contacts")
private WebElement Contactslink;

public WebElement getOrglink() {
	return Orglink;
}

public WebElement getContactslink() {
	return Contactslink;
}

public WebElement getHomelink() {
	return homelink;
}

public WebElement getAdminstratorimg() {
	return adminstratorimg;
}

public WebElement getSignoutlink() {
	return signoutlink;
}
@FindBy(xpath = "//a[@class='hdrLink']")
private WebElement homelink ;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement adminstratorimg ;

@FindBy(linkText ="Sign Out")
private WebElement signoutlink;


}
