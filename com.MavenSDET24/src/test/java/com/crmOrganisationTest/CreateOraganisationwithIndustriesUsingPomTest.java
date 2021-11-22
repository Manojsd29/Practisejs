package com.crmOrganisationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepositylib.CreateNewOrganizationpage;
import com.vtiger.comcast.pomrepositylib.Homepage;
import com.vtiger.comcast.pomrepositylib.Loginpage;
import com.vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.vtiger.comcast.pomrepositylib.Organizationspage;
import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOraganisationwithIndustriesUsingPomTest {
	@Test
public void createOrganizationWithIndus() throws Throwable {
		
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
		
		Loginpage lop=new Loginpage(driver);
		
		//implictly wait passing parameters
		wlib.waitUntilPageLoad(driver, 20);
		
		//calling the method and passing username and password parameters
		lop.loginToApp(userName, passWord);
		Homepage hop=new Homepage(driver);
		hop.getOrglink().click();
		
		//creating an object of orangnisation and clicking the create new organisation button
		Organizationspage org=new Organizationspage(driver);
		org.getNeworgbtn().click();
		
		//creating an object of createneworaganizationpage and adding organization name ,industry,type
		CreateNewOrganizationpage cno=new CreateNewOrganizationpage(driver);
		cno.createOrg(orgname);
		wlib.select(cno.getIndus(), "Energy");
		wlib.select(cno.getType(), "Press");
		//click on save button
		cno.getSavebttn().click();
	//create an Object of Organizationinfo page
		OrganizationInfo orginfo=new OrganizationInfo(driver);
		String msg=orginfo.title();
		if(msg.contains("Organization Information")) {
			System.out.println("Organization is created===>>pass");
		}
		else {
			System.out.println("Organization not created==>>fail");
			
		}
		
		
}
}