package Facebook_App;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Multi_browser_Testing_input_from_console {
		@Test 
		public void main() throws InterruptedException {
			System.out.println("Welcome to Cross Browser Testing");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter \n1: chrome \n2: firefox  \n3: msedgedriver");
			System.out.println("Select the Browser Name : ");
			int option = scanner.nextInt();
			WebDriver driver;
			switch (option) {
			case 1:
				System.out.println("Welcome to chrome Browser");
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.facebook.com/");
				Thread.sleep(3000);
				driver.close();
				break;

			case 2:
				System.out.println("Welcome to Firebox Browser");
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\user\\Downloads\\geckodriver-v0.31.0-win32\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get("https://www.facebook.com/");
				Thread.sleep(3000);
				driver.close();
				break;

			case 3:
				System.out.println("Welcome to MSEdge Browser");
				System.setProperty("webdriver.edgedriver.driver",
						"C:\\Users\\user\\Downloads\\edgedriver_win64\\msedgedriver.exe");
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.facebook.com/");
				Thread.sleep(3000);
				driver.close();
				break;

		}
		}
	}

