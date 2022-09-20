package Facebook_App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class verify_Username_and_Password_alignment {
	@Test
	public void Validate_username_password_Alignment() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.id("email"));
		int mailX = email.getLocation().getX();
		int mailH = email.getSize().getHeight();
		int mailW = email.getSize().getWidth();
		System.out.println("email X-Cordinates :" + mailX);
		System.out.println("email Height :" + mailH);
		System.out.println("email Width :" + mailW);
		WebElement pass = driver.findElement(By.id("pass"));
		int passx = pass.getLocation().getX();
		int passh = pass.getSize().getHeight();
		int passw = pass.getSize().getWidth();
		System.out.println("password X-Cordinates :" + passh);
		System.out.println("password Height :" + passh);
		System.out.println("password Width :" + passw);
		if (mailX == passx && mailH == passh && mailW == passw) {
			System.out.println("Username and password text box are aligned");
		} else {
			System.out.println("Username and password text box are NOT aligned");
		}
		driver.close();
	}

	@Test
	public void Validate_username_password_Alignment_Cordinates() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement unTB = driver.findElement(By.id("email"));
		// get the y-coordinate of username field
		int username_Ycordinate = unTB.getLocation().getY();
		System.out.println(username_Ycordinate);
		WebElement pwdTB = driver.findElement(By.name("pass"));
		// get the y-coordinate of password field
		int password_Ycordinate = pwdTB.getLocation().getY();
		System.out.println(password_Ycordinate);
		// check whether the Y-coordinate of username and password field are same
		if (username_Ycordinate == password_Ycordinate) {
			System.out.println("Both username and password fields are displayed in the same row");
		} else {
			System.out.println("username and password fields are NOT aligned in the same row");
		}

	}
}
