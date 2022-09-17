package actiTIME_App;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UpcastingToWebDriver_LaunchBrowser {
	@Test
	public void Browser_navigations() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://www.google.com");
	String title = driver.getTitle(); 
	System.out.println("the title of the page is :"+ title);
	String currentUrl = driver.getCurrentUrl(); 
	System.out.println("the URL of the page is :"+ currentUrl);
	String pageSource = driver.getPageSource(); 
	System.out.println("the source code of the page is :"+ pageSource);
	Thread.sleep(2000);
	driver.close();
	
	}
}
