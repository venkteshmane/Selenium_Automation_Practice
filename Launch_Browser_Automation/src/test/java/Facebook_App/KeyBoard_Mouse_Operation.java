package Facebook_App;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeyBoard_Mouse_Operation {
	public static WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	// ----------------- Keyboard_Mouse_Operations ------------------------ //
	
	@Test(priority = 1)
	public void robot_class() throws InterruptedException, AWTException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.mouseMove(300, 800);
		Thread.sleep(2000);
		robot.mouseWheel(5000);
		driver.close();
	}

}
