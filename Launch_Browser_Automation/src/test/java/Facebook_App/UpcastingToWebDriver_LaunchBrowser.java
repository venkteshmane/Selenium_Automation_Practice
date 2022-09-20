package Facebook_App;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/* This program demonstrates Upcasting concept 
   (FirefoxDriver class object to WebDriver interface) and accessing various methods of WebDriver interface */

public class UpcastingToWebDriver_LaunchBrowser {
	@Test(priority = 1)
	public void launch_Browser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bridgelabz.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String source = driver.getPageSource();
		System.out.println("The Page source Code :" + source);
		String url = driver.getCurrentUrl();
		System.out.println("The Page source Code :" + url);
		String title = driver.getTitle();
		System.out.println("The Page source Code :" + title);
		Thread.sleep(2000);
		driver.close();
	}
}
