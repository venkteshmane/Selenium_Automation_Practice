package Facebook_App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Validating_ForgotPassword_ErrorMsg {
	public static WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void Validating_Forgot_Password_Error() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("9404622718");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("S");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(3000);
		WebElement errormsg = driver.findElement(By.partialLinkText("Forgotten "));
		String error = errormsg.getText();
		String color = errormsg.getCssValue("color");
		String fontfamily = errormsg.getCssValue("font-family");
		System.out.println("font family of error is :" + fontfamily);
		System.out.println("error is :" + error);
		String ColorasHex = Color.fromString(color).asHex();
		System.out.println("Color of error is :" + color);
		System.out.println("hexadecimal format : " + ColorasHex);
		if (ColorasHex.equals("#ce0100")) {
			System.out.println("Error message is in red color");
		} else {
			System.out.println("Error message is in red color");
		}
		Thread.sleep(3000);
	}

	
	@Test(priority = 2)
	public void Validating_Facebook_Error() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("9404622718");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("S");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(3000);
		WebElement errormsg = driver.findElement(By.partialLinkText("Forgotten "));
		String error = errormsg.getText();
		String color = errormsg.getCssValue("color");
		String fontfamily = errormsg.getCssValue("font-family");
		System.out.println("font family of error is :" + fontfamily);
		System.out.println("error is :" + error);
		String ColorasHex = Color.fromString(color).asHex();
		System.out.println("Color of error is :" + color);
		System.out.println("hexadecimal format : " + ColorasHex);
		if (ColorasHex.equals("#ce0100")) {
			System.out.println("Error message is in red color");
		} else {
			System.out.println("Error message is in red color");
		}
		Thread.sleep(3000);
	}
}
