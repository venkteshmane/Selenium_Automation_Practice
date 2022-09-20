package Facebook_App;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wait_test {
	@Test(priority = 1)
	public void Browser_navigations() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.bridgelabz.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("9404622718");
		driver.findElement(By.name("pass")).sendKeys("Venky@18");
		
		WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/button[1]")));
    }
	
	@Test
    public void explicitWaitTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Create New Account")).click();

        //WebElement firstName = driver.findElement(By.name("firstname"));
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
        firstName.sendKeys("Venktesh");
    }

}
