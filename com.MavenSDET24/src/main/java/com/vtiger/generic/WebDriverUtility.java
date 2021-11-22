package com.vtiger.generic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * 
	 * @param driver
	 * @param time
	 */
	public void waitUntilPageLoad(WebDriver driver,int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	public void waitForElementVisiblity(WebDriver driver,int seconds,WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method enables user to handle dropdown using visible text
	 * @param element
	 * @param option
	 */
	public void select(WebElement element, String option) {

		Select select =new Select( element);
		select.selectByVisibleText(option);
	}
	/**
	 *  This method enables user to handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select select =new Select( element);
		select.selectByIndex(index);
	}
	/**
	 * This method 
	 * @param element
	 * @throws InterruptedException 
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			}
			catch (Throwable e) {
				Thread.sleep(1000);
				count++;
				// TODO: handle exception
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param msg
	 */
	public void swtichwindowchild(WebDriver driver,String wintitle) {
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> it=allwh.iterator();
		while(it.hasNext()) {
			String wh = it.next();
		String title=	driver.switchTo().window(wh).getTitle();
			
			if(title.contains(wintitle)) {
				break;
			}
		}
	}

}


