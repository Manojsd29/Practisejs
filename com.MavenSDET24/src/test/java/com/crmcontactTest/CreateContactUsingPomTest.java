package com.crmcontactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepositylib.ContactInformation;
import com.vtiger.comcast.pomrepositylib.Contacts;
import com.vtiger.comcast.pomrepositylib.CreateNewContact;
import com.vtiger.comcast.pomrepositylib.Loginpage;
import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactUsingPomTest {
@Test

	public void createContactPom() throws Throwable {
		//launching the driver
		WebDriverManager.chromedriver().setup();
		
		//creating utility classes 
		FileUtility flib =new FileUtility();
		ExcelUtility elib =new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		JavaUtility jlib =new JavaUtility();
		String browserurl = flib.getvalues("url");
		String userName = flib.getvalues("un");
		String passWord = flib.getvalues("pwd");
		String browser = flib.getvalues("browser");
		String lastname = elib.getExcelValue("newcontact", 2, 0)+"_"+jlib.getRandomValue();
		String firstname=elib.getExcelValue("newcontact", 2, 1)+"_"+jlib.getRandomValue();
		
		//selecting the browser to launch
		WebDriver driver;
		driver=null;
		if(browser.equals("chrome")) {
			
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			
			driver=new FirefoxDriver();
		}
		//get to Url
		driver.get(browserurl);
		//maximize the 	window
		driver.manage().window().maximize();
		//Implicity waiting condition
		wlib.waitUntilPageLoad(driver, 20);
		
		//create an object of login page and perform functions
		Loginpage loginpage=new Loginpage(driver);
		loginpage.getUserNameEdt().sendKeys(userName);
		loginpage.getUserPasswordEdt().sendKeys(passWord);
		loginpage.getLoginBtn().click();
		//click on contacts module
		Contacts contact=new Contacts(driver);
		contact.getCreatecontactbttn().click();
		
		//Enter the Fname and lastname ,click on save button
		CreateNewContact createnewcontact=new CreateNewContact(driver);
		createnewcontact.getFname().sendKeys(firstname);
		createnewcontact.getLname().sendKeys(lastname);
		createnewcontact.getSavebutton().click();
		
		//verify the title if contact created
		ContactInformation coninfo=new ContactInformation(driver);
		String msg = coninfo.title();
		if(msg.contains("Contact Information")) {
			System.out.println("Contact is created ==>>pass");
		}
		else {
			System.out.println("contact is not created =>>fail");
		}
		//logging out of Vtiger application
		coninfo.getAdminstratorimg().click();
		coninfo.getSignoutlink().click();
		driver.close();
		
	
		
		
	}	
	}

