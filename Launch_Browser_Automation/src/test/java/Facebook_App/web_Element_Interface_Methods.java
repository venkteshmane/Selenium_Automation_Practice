package Facebook_App;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class web_Element_Interface_Methods {
	@Test(priority=1)
	public void clearMethodofwebelement() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("9527872718");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("Venky@gmail.com");
		Thread.sleep(2000);
		driver.close();
	}
	@Test(priority=2)
	public void clickMethodofwebelement() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("9527872718");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Venky@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(2000);
		driver.close();
	}

	@Test(priority=3)
	public static void getText() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		Boolean bool = login.isDisplayed();
		System.out.println(bool);
		String text = login.getText();
		System.out.println(text);
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test(priority=4)
	public static void submitMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys("Prashi");
		Thread.sleep(2000);
		driver.findElement(By.name("lastname")).sendKeys("Rane");
		Thread.sleep(2000);
		driver.findElement(By.name("reg_email__")).sendKeys("8446251018");
		Thread.sleep(2000);
		driver.findElement(By.name("reg_passwd__")).sendKeys("Prashi@123");
		Thread.sleep(2000);
		driver.findElement(By.name("birthday_day")).sendKeys("28");
		Thread.sleep(2000);
		driver.findElement(By.name("birthday_month")).sendKeys("Aug");
		Thread.sleep(2000);
		driver.findElement(By.name("birthday_year")).sendKeys("1997");
		Thread.sleep(2000);
		driver.findElements(By.name("sex")).get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.name("websubmit")).submit();
		Thread.sleep(2000);
		driver.close();
	}


	@Test(priority=5)
	public static void getAttribute() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		Boolean bool = login.isDisplayed();
		System.out.println(bool);
		String attribute = login.getAttribute("name");
		System.out.println(attribute);
		Thread.sleep(2000);
		driver.close();
	}

	@Test(priority=6)
	public static void getCSSValue() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		Boolean bool = login.isDisplayed();
		System.out.println(bool);
		String css = login.getCssValue("#");
		System.out.println(css);
		Thread.sleep(2000);
		driver.close();
	}

	@Test(priority=7)
	public void getLocationMethodofwebelement() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.id("email"));
		int mailx = email.getLocation().getX();
		int maily = email.getLocation().getY();
		System.out.println("email x coordinate :" + mailx);
		System.out.println("email y coordinate :" + maily);
		driver.findElement(By.id("pass"));
		int passx = email.getLocation().getX();
		int passy = email.getLocation().getY();
		System.out.println("password x coordinate :" + passx);
		System.out.println("password y coordinate :" + passy);
		driver.close();
	}

	@Test(priority=8)
	public void getSize_Methodofwebelement() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.id("email"));
		int mailH = email.getSize().getHeight();
		int mailW = email.getSize().getWidth();
		System.out.println("email Height :" + mailH);
		System.out.println("email Width :" + mailW);
		driver.findElement(By.id("pass"));
		int passH = email.getSize().getHeight();
		int passW = email.getSize().getWidth();
		System.out.println("password Height :" + passH);
		System.out.println("password Width :" + passW);
		driver.close();
	}
	
	@Test(priority = 9)
	public void get_isEnabled_or_Disabled() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.id("email"));
		if (email.isEnabled()) { 
			System.out.println("email text box is enabled");
		} else {
			System.out.println("email text box is disabled");
		}
		WebElement password = driver.findElement(By.id("pass"));
		if (password.isEnabled()) {
			System.out.println("password text box is enabled");
		} else {
			System.out.println("password text box is disabled");
		}
	}
	
	@Test(priority=10)
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

	@Test(priority=11)
	public static void getTagName() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		Boolean bool = login.isDisplayed();
		System.out.println(bool);
		String tag = login.getTagName();
		System.out.println(tag);
		Thread.sleep(2000);
		driver.close();
	}

	@Test(priority=12)
	public static void getRect() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		Boolean bool = login.isDisplayed();
		System.out.println(bool);
		Dimension rect = login.getRect().getDimension();
		System.out.println(rect);
		Thread.sleep(2000);
		driver.close();
	}

}
