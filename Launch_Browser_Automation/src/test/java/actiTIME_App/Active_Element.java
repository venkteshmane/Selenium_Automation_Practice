package actiTIME_App;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Active_Element {
	@Test(priority = 1)
	public void EnterTextintoFocussedElement() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.switchTo().activeElement().sendKeys("admin");
	}

	@Test(priority = 2)
	public void RemoveValue_fromText_using_ClearMethod_clear() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("ajit");
		Thread.sleep(2000);
		String value = driver.findElement(By.id("username")).getAttribute("value");
		System.out.println("Value present inside the text box is : " + value);
		driver.findElement(By.id("username")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("againEnteredAjit");
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		// this line will actually delete the value if there is no space in the text
		// entered
		// if there is a space between two words in the username field, we have to use
		// the below lines of code
		driver.findElement(By.id("username")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("username")).sendKeys(Keys.DELETE);
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void RemoveValue_fromText_using_Clearmethod_Send_keys() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("ajit");
		Thread.sleep(2000);
		String value = driver.findElement(By.id("username")).getAttribute("value");
		System.out.println("Value present inside the text box is : " + value);
		driver.findElement(By.id("username")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("againEnteredAjit");
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		Thread.sleep(2000);
	}
	@Test(priority = 4)
	public void tool_Tip() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		WebElement Checkbox = driver.findElement(By.id("keepLoggedInCheckBox")); 
		//get the tooltip text using getAttribute() method and store in a variable 
		String tooltipText = Checkbox.getAttribute("title"); 
		System.out.println(tooltipText); 
//		driver.close(); 
		}
	

}
