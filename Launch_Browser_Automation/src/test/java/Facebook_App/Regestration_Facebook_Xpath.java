package Facebook_App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Regestration_Facebook_Xpath {
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
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Venktesh");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Mane");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("venktesh@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("venktesh@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Mane@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='day']")).sendKeys("9");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='month']")).sendKeys("Aug");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='year']")).sendKeys("1994");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='2']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		Thread.sleep(3000);
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
