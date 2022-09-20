package Facebook_App;

import java.util.Scanner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class multi_Browser_input_from_console {
	@Test
	public void signUpWithChromeBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("Venktesh@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("pass")).sendKeys("Venky@12345");
		driver.findElement(By.name("login")).click();
	}

	@Test
	public void signInWithFirefoxBrowser() throws InterruptedException {
		System.setProperty("webdriver.firefox.driver",
				"C:\\Users\\user\\Downloads\\geckodriver-v0.31.0-win32\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("Venktesh@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("pass")).sendKeys("Venky@12345");
		driver.findElement(By.name("login")).click();
	}

	@Test
	public void SigninAccountWithEdgeBrowser() throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("Venktesh@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("pass")).sendKeys("Venky@12345");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);
		driver.close();
	}

	@Test
	public void main() throws InterruptedException {
		multi_Browser_input_from_console browser = new multi_Browser_input_from_console();
		WebDriver driver = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Driver for: \n 1: Chrome Browser \n 2: Firefox Browser \n 3: Edge Browser ");
		System.out.println("Enter the choice: ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Browser Launched");
			browser.signUpWithChromeBrowser();
			break;
		case 2:
			System.setProperty("webdriver.firefox.driver",
					"C:\\Users\\user\\Downloads\\geckodriver-v0.31.0-win32\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser Launched");
			browser.signInWithFirefoxBrowser();
			break;
		case 3:
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\user\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge Browser Launched");
			browser.SigninAccountWithEdgeBrowser();
			break;
		}
	}
}
