package actiTIME_App;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Actions_Class {
	public static WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void Context_Click_Using_Open_New_Window() throws InterruptedException, AWTException {
		driver.get("https://demo.actitime.com/login.do");
		WebElement link = driver.findElement(By.linkText("actiTIME Inc."));
		// right click (context click) on actitime link
		Actions actions = new Actions(driver);
		actions.contextClick(link).perform();
		Thread.sleep(3000);
		// press 'w' from the keyboard for opening in a new window
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_W);
		// quit() method closes all the browsers opened by Selenium
		driver.quit();
	}
	
	@Test(priority = 2)
	public void Context_Click_Archieve_Mail() throws InterruptedException, AWTException {
		driver.get("https://www.gmail.com"); 
			//enter email id 
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Venktesh.mane18@gmail.com"); 
			//click on Next button 
		driver.findElement(By.xpath("//span[.='Next']")).click(); 
		Thread.sleep(3000); 
		//enter password id 
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Venky@18"); 
			//click on Next button 
		driver.findElement(By.xpath("//span[.='Next']")).click(); 
		Thread.sleep(10000); 
			//Write xpath expression for the mail item based on a subject 
		String xp = "(//b[contains(.,'Following Openings (for Bangalore)')])[2]"; 
			//get the address of the mail item which you want to archive 
		WebElement mail = driver.findElement(By.xpath(xp)); 
			//print the subject of the mail 
		System.out.println(mail.getText());
			//Creating an object of Actions class 
		Actions actions = new Actions(driver); 
			//using Actions class object and contextClick() method, right click on the mail item 
		actions.contextClick(mail).perform(); 
		Thread.sleep(6000); 
			//click on Archive to archive the mail 
		driver.findElement(By.xpath("(//div[@class='J-N-JX aDE aDD'])[1]")).click();
	}

	@Test(priority = 3)
	public void Mouse_Hover_Cloud_App() throws InterruptedException {

		driver.get("http://www.actimind.com/");
		Actions action = new Actions(driver);
		// movetoElement - used for mouse hover
		// Mouse hover on “AREAS OF EXPERTISE” menu
		WebElement AreaOfExpertise = driver.findElement(By.xpath("//a[contains(text(),'AREAS OF EXPERTISE')]"));
		action.moveToElement(AreaOfExpertise).perform();
		// Click on “AREAS OF EXPERTISE” menu
		WebElement cloudApp = driver.findElement(By.linkText("Cloud Applications"));
		action.moveToElement(cloudApp).click().perform();
		// composite multiple actions can be achieved using the below statement
		// action.moveToElement(AreaOfExpertise).moveToElement(cloudApp).click().build().perform();
	}

	@Test(priority = 4)
	public void Drag_And_Drop_Features_on_webpage() throws InterruptedException {
		driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html");
		String xp1 = "//h1[.='Block 1']";
		WebElement block1 = driver.findElement(By.xpath(xp1));
		String xp2 = "//h1[.='Block 3']";
		WebElement block3 = driver.findElement(By.xpath(xp2));
		Actions actions = new Actions(driver);
		// drag block 1 element and drop it on block 2 element
		actions.dragAndDrop(block1, block3).perform();
	}

	@Test(priority = 5)
	public void Drag_And_Drop_Features_by_Offset() throws InterruptedException {
		driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html");
		// write xpath for Block 1
		String xp1 = "//h1[.='Block 1']";
		WebElement block1 = driver.findElement(By.xpath(xp1));
		// write xpath for Block 3
		String xp2 = "//h1[.='Block 3']";
		WebElement block3 = driver.findElement(By.xpath(xp2));
		// Create an object of Actions class and pass driver object as an argument
		Actions actions = new Actions(driver);
		// call the dragAndDropBy() method of Actions class
		actions.dragAndDropBy(block1, block3.getLocation().getX() + 10, block3.getSize().getHeight() + 10).perform();
	}
	
	@Test(priority = 6)
	public void Drag_And_Drop_Menu() throws InterruptedException {
		driver.get("http://www.istqb.in/"); 
		WebElement foundation = driver.findElement(By.xpath("//span[.='FOUNDATION']")); 
		Actions actions = new Actions(driver); 
			//mouse hover on Foundation tab 
		actions.moveToElement(foundation).perform(); 
		Thread.sleep(3000); 
		WebElement enrollment = driver.findElement(By.xpath("(//span[text()='ENROLLMENT'])[1]")); 
			//mouse hover on Enrollment 
		actions.moveToElement(enrollment).perform(); 
		Thread.sleep(3000); 
		WebElement corporateEnrol = driver.findElement(By.xpath("//span[text()='CORPORATE ENROLLMENT']")); 
			//mouse hover on Corporate Enrollment 
		actions.moveToElement(corporateEnrol).perform(); 
		Thread.sleep(3000); 
			//click on Corporate Enrollment 
		driver.findElement(By.xpath("//span[text()='ONLINE ENROLLMENT']")).click(); 
		driver.close();
	}
	
}
