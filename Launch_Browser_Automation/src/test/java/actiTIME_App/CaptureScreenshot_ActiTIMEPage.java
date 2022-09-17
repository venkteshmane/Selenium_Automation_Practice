package actiTIME_App;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class CaptureScreenshot_ActiTIMEPage {
	
	@Test(priority = 1)
	public void screenshot() throws InterruptedException, IOException {
		Date d = new Date();
		String date1 = d.toString(); 
		System.out.println(date1);
		String date2 = date1.replaceAll(":", "_"); 
		System.out.println(date2);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".\\Screenshots\\" + "Actitime" + ".png");
		FileHandler.copy(srcFile, destFile);
		driver.close();
	}

}
