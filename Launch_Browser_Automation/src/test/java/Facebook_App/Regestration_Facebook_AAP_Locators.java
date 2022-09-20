package Facebook_App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Regestration_Facebook_AAP_Locators {
	
	public static WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test(priority = 1)
	public void Create_New_Account() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("firstname")).sendKeys("Venktesh");
		Thread.sleep(3000);
		driver.findElement(By.name("lastname")).sendKeys("Mane");
		Thread.sleep(3000);
		driver.findElement(By.name("reg_email__")).sendKeys("venktesh@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("venktesh@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("password_step_input")).sendKeys("Venky@18");
		Thread.sleep(3000);
		driver.findElement(By.id("day")).sendKeys("9");
		Thread.sleep(3000);
		driver.findElement(By.id("month")).sendKeys("Aug");
		Thread.sleep(3000);
		driver.findElement(By.id("year")).sendKeys("1994");
		Thread.sleep(3000);
		driver.findElements(By.name("sex")).get(1).click();
		Thread.sleep(3000);
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(2000);
//		driver.close();
	}
	@Test(priority = 2)

	public void Login() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("venktesh@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='email']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("venky@gmail.com");
		Thread.sleep(3000);  
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Mane123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(3000);
//		driver.close();
	}
}
