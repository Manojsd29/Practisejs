package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {//create a java class for each page in a application
	
	
public Loginpage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
}
@FindBy(name="user_name")
private WebElement userNameEdt;

@FindBy(name="user_password")
private WebElement userPasswordEdt;

@FindAll({@FindBy(id="submitButton"),@FindBy(xpath ="//input[@type='submit']")})
private WebElement loginBtn;

public WebElement getUserNameEdt() {
	return userNameEdt;
}


public WebElement getUserPasswordEdt() {
	return userPasswordEdt;
}

public WebElement getLoginBtn() {
	return loginBtn;
}
public void loginToApp(String userName,String passWord) {
	userNameEdt.sendKeys(userName);
	userPasswordEdt.sendKeys(passWord);
	loginBtn.click();
}
}


