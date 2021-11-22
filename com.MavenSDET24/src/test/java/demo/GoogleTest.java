package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		String text = driver.getTitle();
		System.out.println(text);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String wh = driver.getWindowHandle();
		System.out.println(wh);
		
		
	}
}
