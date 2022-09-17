package actiTIME_App;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class webElement_interface_methods {
	@Test
	public void isEnabled_Method_of_webelement() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		WebElement KeepMeLogIN_Checkbox = driver.findElement(By.name("remember"));
		KeepMeLogIN_Checkbox.click();
		if (KeepMeLogIN_Checkbox.isSelected()) {
			System.out.println("keep Me Logged In Section box is selected");
		} else {
			System.out.println("keep Me Logged In Section box is not selected");
		}
	}

	@Test
	public void Print_Version_using_getText() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		String xpathforVersion = "//nobr[contains(text(),'actiTIME')]";
		String version = driver.findElement(By.xpath(xpathforVersion)).getText();
		System.out.println("Version of actitime on login page is : " + version);
	}

	@Test
	public void Diff_ways_of_Clicking_on_Button() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.get("https://demo.vtiger.com");
		String xp = "//button[.='Sign in']";
		// 1. using click() method
		driver.findElement(By.xpath(xp)).click();
		// 2. using sendkeys
		driver.findElement(By.xpath(xp)).sendKeys(Keys.ENTER);
		// 3. using submit() method this method will work only and only if if the
		// element has an attribute called type= 'submit'/
		driver.findElement(By.xpath(xp)).submit();
	}

	@Test
	public void Validate_Errormessage_getCssValue() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		WebElement errMsg = driver.findElement(By.xpath("//span[contains(.,'invalid')]"));
		String errtext = errMsg.getText();
		System.out.println("error message is :" + errtext);
		String c = errMsg.getCssValue("color");
		String ColorasHex = Color.fromString(c).asHex();
		System.out.println("hexadecimal format : " + ColorasHex);
		if (ColorasHex.equals("#ce0100")) {
			System.out.println("Error message is in red color");
		} else {
			System.out.println("Error message is in red color");
		}
		String fontSize = errMsg.getCssValue("font-size");
		String fontWeight = errMsg.getCssValue("font-weight");
		System.out.println("Size of the font is :" + fontSize);
		System.out.println("Weight of the font is :" + fontWeight);
		driver.close();
	}

}
