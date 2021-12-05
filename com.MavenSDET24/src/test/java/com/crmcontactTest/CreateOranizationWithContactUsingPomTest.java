package com.crmcontactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepositylib.Contacts;
import com.vtiger.comcast.pomrepositylib.CreateNewContact;
import com.vtiger.comcast.pomrepositylib.CreateNewOrganizationpage;
import com.vtiger.comcast.pomrepositylib.Homepage;
import com.vtiger.comcast.pomrepositylib.Loginpage;
import com.vtiger.comcast.pomrepositylib.Organizationspage;
import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOranizationWithContactUsingPomTest {
	
	@Test
	public void CreateOranizationWithContactUsingPom() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		FileUtility flib =new FileUtility();
		ExcelUtility elib =new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		JavaUtility jlib =new JavaUtility();
		String browserurl = flib.getvalues("url");
		String userName = flib.getvalues("un");
		String passWord = flib.getvalues("pwd");
		String browser = flib.getvalues("browser");
		String orgname = elib.getExcelValue("createorg", 3, 2)+"_"+jlib.getRandomValue();
		String fname = elib.getExcelValue("newcontact", 2, 0)+"_1"+jlib.getRandomValue();
		String lname = elib.getExcelValue("newcontact", 2, 1)+"_2"+jlib.getRandomValue();
		WebDriver driver;
		driver=null;
		if(browser.equals("chrome")) {
			
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			
			driver=new FirefoxDriver();
		}
		driver.get(browserurl);
		driver.manage().window().maximize();
		wlib.waitUntilPageLoad(driver, 20);
		//Login to the application using valid credential(test data)
		Loginpage loginpage=new Loginpage(driver);
		loginpage.getUserNameEdt().sendKeys(userName);
		loginpage.getUserPasswordEdt().sendKeys(passWord);
		loginpage.getLoginBtn().click();
		
		//click on organization module
		
		Homepage homepage=new Homepage(driver);
		homepage.getOrglink().click();
		
		//click on new oragnization button
		Organizationspage org =new Organizationspage(driver);
		org.getNeworgbtn().click();
		
		//Enter the oragnization name
		
		CreateNewOrganizationpage crnewog =new CreateNewOrganizationpage(driver);
		crnewog.createOrg(orgname);
		crnewog.getSavebttn();
		
		//Click on contacts module
		
		homepage.getContactslink().click();
		//click on new contact button
		Contacts contacts=new Contacts(driver);
		contacts.getCreatecontactbttn().click();
		
		//Enter the fname, lname and select the contacts organization
		
		CreateNewContact cnewcon= new CreateNewContact(driver);
		cnewcon.getFname().sendKeys(fname);
		cnewcon.getLname().sendKeys(lname);
		cnewcon.getOrglukupicon().click();
		//switch to child window
		
		wlib.swtichwindowchild(driver, "Accounts&action");
		WebElement wait = driver.findElement(By.xpath("//a[text()='"+orgname+"']"));
		wlib.waitForElementVisiblity(driver, 25, wait);
		wait.click();
		driver.quit();
		
		
	
		
		
		
		
		
	
		
	
	
}
}
