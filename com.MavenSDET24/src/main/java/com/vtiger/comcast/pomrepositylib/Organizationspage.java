package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationspage {
	public Organizationspage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement neworgbtn;

	
	
	public WebElement getNeworgbtn() {
		return neworgbtn;
	}
}
