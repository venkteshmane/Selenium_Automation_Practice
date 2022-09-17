package actiTIME_App;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class xpath_Actitime {
	@Test(priority = 1)
	public void Xpath_Text_Contains_Function() throws InterruptedException, IOException, AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String xp = "//input[@class='textField'][ @id = 'username']";
		Thread.sleep(2000);
		driver.findElement(By.xpath(xp)).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
		Thread.sleep(2000);
					//xpath using text() function
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		Thread.sleep(2000);
		WebElement clock = driver.findElement(By.xpath("//img[contains(@src,'timer')]"));
		String widthValue = clock.getAttribute("width");
		System.out.println("the width is :" + widthValue);
		System.out.println("the height of the clock element is : " + clock.getAttribute("height"));
					//xpath using contains() function and text() function
		driver.findElement(By.xpath("//a[@id='loginButton']//div[contains(text(),'Login')]")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test(priority = 2)
	public void Independent_Dependent_Xpath() throws InterruptedException, IOException, AWTException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://www.seleniumhq.org/download/");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//td[.='Java']/..//a[.='Download']")).click();
	
	}
	
	@Test(priority = 3)
	public void Xpaths_using_Dependent_independent_setbydefault_GroupIndex() throws InterruptedException, IOException, AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("admin"); 
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='popup_menu_icon'])[2]")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Types of Work']")).click(); 
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[.='testing']/../..//a[.='set by default']")).click(); 
		driver.close();
		
	}
	

}
