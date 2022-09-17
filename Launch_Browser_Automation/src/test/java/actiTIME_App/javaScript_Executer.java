package actiTIME_App;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class javaScript_Executer {
	public static WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void Enter_Text_into_Disabled_Textbox() throws InterruptedException {
		driver.get("C://Users//user//Desktop//disabled_Text_Box.html");
				// Typecast the driver object to JavascriptExecutor interface type
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
				// enter "admin" in first textbox using javascript
		js.executeScript("document.getElementById('t1').value='admin'");
		Thread.sleep(2000);
				// clear the value in second textbox using javascript
		js.executeScript("document.getElementById('t2').value=''");
				// enter "manager" in second textbox using javascript
		js.executeScript("document.getElementById('t2').value='manager'");
				// change the second text box to button type using Javascript
		js.executeScript("document.getElementById('t2').type='button'");
	}

	@Test(priority = 2)
	public void navigate_to_bottom_to_thepage() throws InterruptedException {
		driver.get("http://seleniumhq.org/download");
		driver.manage().window().maximize();
		driver.findElement(By.id("close")).click();
				// select an element which is present at the bottom of the page
		WebElement element = driver
				.findElement(By.xpath("//input[@alt='PayPal - The safer, easier way to pay online!']"));
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("X coordinate is :" + x + " and Y coordinate is :" + y);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		Thread.sleep(3000);
		element.click();
	}

	@Test(priority = 3)
	public void Scroll_Up_and_Down_to_specific_Element() throws InterruptedException {
		driver.get("http://seleniumhq.org/download");
		driver.manage().window().maximize();
		driver.findElement(By.id("close")).click();
		WebElement ele = driver.findElement(By.xpath("//img[contains(@src,'applitools')]"));
		int x = ele.getLocation().getX();
		int y = ele.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public static void scrollUpAndDownFBPage() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i < 10; i++) {
			js.executeScript("window.scrollBy(0, 400)");
			Thread.sleep(3000);
		}
		for (int i = 1; i < 10; i++) {
			js.executeScript("window.scrollBy(0, -400)");
			Thread.sleep(3000);
		}
		driver.close();
	}

}
