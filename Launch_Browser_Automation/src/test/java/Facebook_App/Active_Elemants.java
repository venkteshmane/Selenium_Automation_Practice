package Facebook_App;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Active_Elemants {
	@Test
	public void Enter_Text_into_FocussedElement() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.switchTo().activeElement().sendKeys("username");
	}

	@Test(priority = 2)
	public void RemoveValue_fromText_using_ClearMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("Venktesh Mane");
		Thread.sleep(2000);
		String value = driver.findElement(By.id("email")).getAttribute("value");
		System.out.println("Value present inside the text box is : " + value);
		driver.findElement(By.id("email")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("againEntered_Venktesh");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		// this line will actually delete the value if there is no space in the text
		// entered
		// if there is a space between two words in the username field, we have to use
		// the below lines of code
		driver.findElement(By.id("email")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("email")).sendKeys(Keys.DELETE);
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void Tool_Tip() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement Checkbox = driver.findElement(By.xpath("//a[@title='Er Venktesh Mane']"));
		// get the tooltip text using getAttribute() method and store in a variable
		String tooltipText = Checkbox.getAttribute("title");
		System.out.println(tooltipText);
//		driver.close(); 
	}

}
