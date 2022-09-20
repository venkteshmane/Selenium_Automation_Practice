package actiTIME_App;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class handling_popup {
	private static final DesiredCapabilities DesiredCapabilities = null;

	@Test(priority = 1)
	public void Javascripts_Alert_Promptpopup() throws InterruptedException, IOException, AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.tizag.com/javascriptT/javascriptprompt.php");
		// find this button : "Say my name"
		driver.findElement(By.xpath("//input[@value='Say my name!']")).click();
		Thread.sleep(2000);
		// Switch to alert pop up Alert
		WebElement alert = (WebElement) driver.switchTo().alert();
		Thread.sleep(2000);
		// print the text present on the alert pop up
		System.out.println(alert.getText());
		Thread.sleep(2000);
		// enter your name in the text box present on the alert pop up
		alert.sendKeys("ajit");
		Thread.sleep(2000);
		// click on OK button
		((Alert) alert).accept();
		Thread.sleep(2000);
		// print the text present on the second alert pop up
		System.out.println(alert.getText());
		// click on Cancel button
		((Alert) alert).dismiss();
	}

	@Test
	public void javascriptPopUpAlert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		// 1. Alert popup --> alert window with OK button
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		// 2. confirmation popup --> alert window with OK & Cancel button
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		Thread.sleep(1000);
		// driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);

		// 3. prompt popup --> alert window with input text and print the message
		// displayed
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		System.out.println("Message displayed on pop up alert window: " + alert.getText());
		Thread.sleep(2000);

		alert.sendKeys("hi");
		Thread.sleep(1000);
		alert.accept();
	}

	@Test
	public void HiddenDivisionPopup_CalendarPopup_cleartrip_selectTodaysDate() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Object option = null;
		((ChromiumOptions<ChromeOptions>) option).addArguments("--disable-notifications");
//			option.addArguments("--disable-geolocation"); 
//			option.addArguments("--ignore-certificate-errors"); 
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://www.cleartrip.com/");
		Thread.sleep(3000);
		driver1.findElement(By.xpath("(//input[@placeholder='Pick a date'])[1]")).click();
		Thread.sleep(3000);
		driver1.findElement(By.linkText("24")).click();
	}

	@Test
	public void fileUpload() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@multiple='']")).sendKeys("C:\\Users\\user\\Downloads\\Venky.txt");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@ng-click=\"item.upload()\"]")).click();
		Thread.sleep(3000);
	}

	@Test
	public void fileUpload_autoIT() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freepdfconvert.com/pdf-to-word");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[normalize-space()='Choose PDF file']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\user\\Desktop\\CFP_176\\FileUploadScript.exe");
		Thread.sleep(3000);
	}

	@Test
	public void file_Download() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\user\\Downloads\\geckodriver-v0.31.0-win32\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		String key = "browser.helperApps.neverAsk.saveToDisk";
		// Set the type of file which you want to download
		String value = "application/zip";
		FirefoxProfile profile = null;
		// using setPreference() method, change the setting
		profile.setPreference(key, value);
		// 0 - save to desktop, 1 - save to download folder( default), 2 - save to any
		// other //location
		profile.setPreference("browser.download.folderList", 2);
		// save the file to the given folder location
		profile.setPreference("browser.download.dir", "D:\\Ajit\\Others");
		// Use DesiredCapabilities class to modify the firefox settings as shown below
		DesiredCapabilities cap = DesiredCapabilities;
		cap.setCapability(FirefoxDriver.PROFILE, profile);
		// Launch the firefox browser with the above modified settings
		WebDriver driver1 = new FirefoxDriver(cap);
		// Enter selenium official website url
		driver1.get("http://www.seleniumhq.org/download/");
		// Use following-sibling axes in Xpath to find the download link for selenium
		// java
		driver1.findElement(By.xpath("//td[text()='Java']//following-sibling::td[3]/a")).click();
		Thread.sleep(3000);
	}

	@Test
	public void file_Download1() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\user\\Downloads\\geckodriver-v0.31.0-win32\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.selenium.dev/downloads/");

		driver.findElement(By.linkText("4.2.1")).click();
	}

	@Test
	public void FileDownloadInChromeBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", "F:\\");
		// Assign this chromePrefs object with ChromeOptions object
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		// Create Capability object and assign the option object
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver1 = new ChromeDriver(cap);
		driver1.get("http://www.seleniumhq.org/download/");
		Thread.sleep(3000);
		String xp = "//a[@href='https://github.com/SeleniumHQ/selenium/blob/trunk/java/CHANGELOG']";
		driver1.findElement(By.xpath(xp)).click();
	}

	@Test
	public void ChildBrowserPopUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath(
				"//button[@aria-label='Confirmation. Get your favourite food at your train seat through <a class=\"txt-msg-info\" target=\"_blank\" href=\"https://www.ecatering.irctc.co.in/\">e-Catering</a> available at selected stations.<br/><br/>COVID 19 Alert:<br/><br/><i class=\"fa fa-circle\" ></i> All passengers are advised to wear face covers/masks at the entry/exit and during travel.<br/><br/><i class=\"fa fa-circle\" ></i> All passengers are advised that on arrival at their destination, the travelling passenger shall follow the Covid protocol/guidelines issued by Ministry of Home affairs, Ministry of Health and Family Welfare and concerned State/UTs on the subject from time to time.<br/><br/><i class=\"fa fa-circle\" ></i><a class=\"txt-msg-info\"target=\"_blank\"href=\"http://contents.irctc.co.in/en/CovidVaccinationInfoEng.pdf\"> Information on Covid 19 Vaccination Programme</a>. Press OK to confirm']"))
				.click();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@aria-label='Menu BUSES. Website will be opened in new tab']")).click();
		// using getWindowHandles(), get a set of window handle IDs
		Set<String> allWindowHandles = driver.getWindowHandles();
		// using size(), get the count of total number of browser windows
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : " + count);
		for (String windowHandle : allWindowHandles) {
			// switch to each browser window
			driver.switchTo().window(windowHandle);
			String title = driver.getTitle();
			// print the window handle id of each browser window
			System.out.println("Window handle id of page -->" + title + " --> is : " + windowHandle);
			// close all the browsers one by one
//			driver.close();
		}
	}

	@Test
	public void CloseMainBrowserOnly() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath(
				"//button[@aria-label='Confirmation. Get your favourite food at your train seat through <a class=\"txt-msg-info\" target=\"_blank\" href=\"https://www.ecatering.irctc.co.in/\">e-Catering</a> available at selected stations.<br/><br/>COVID 19 Alert:<br/><br/><i class=\"fa fa-circle\" ></i> All passengers are advised to wear face covers/masks at the entry/exit and during travel.<br/><br/><i class=\"fa fa-circle\" ></i> All passengers are advised that on arrival at their destination, the travelling passenger shall follow the Covid protocol/guidelines issued by Ministry of Home affairs, Ministry of Health and Family Welfare and concerned State/UTs on the subject from time to time.<br/><br/><i class=\"fa fa-circle\" ></i><a class=\"txt-msg-info\"target=\"_blank\"href=\"http://contents.irctc.co.in/en/CovidVaccinationInfoEng.pdf\"> Information on Covid 19 Vaccination Programme</a>. Press OK to confirm']"))
				.click();
		driver.manage().window().maximize();
		Thread.sleep(2000);

		String parentWindowhandleId = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[@aria-label='Menu BUSES. Website will be opened in new tab']")).click();

		Set<String> allCurrentWindowHandles = driver.getWindowHandles();

		int count = allCurrentWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : " + count);
		for (String windowHandle : allCurrentWindowHandles) {
			driver.switchTo().window(windowHandle);
			/*
			 * compare the window id with the Parent browser window id, if both are equal,
			 * then only close the main browser window.
			 */
			if (windowHandle.equals(parentWindowhandleId)) {
				driver.close();
				System.out.println("Main Browser window with title --> " + driver.getTitle() + " --> is closed");
			}
		}
	}

	@Test
	public void CloseALLChildbrowsersONLY() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath(
				"//button[@aria-label='Confirmation. Get your favourite food at your train seat through <a class=\"txt-msg-info\" target=\"_blank\" href=\"https://www.ecatering.irctc.co.in/\">e-Catering</a> available at selected stations.<br/><br/>COVID 19 Alert:<br/><br/><i class=\"fa fa-circle\" ></i> All passengers are advised to wear face covers/masks at the entry/exit and during travel.<br/><br/><i class=\"fa fa-circle\" ></i> All passengers are advised that on arrival at their destination, the travelling passenger shall follow the Covid protocol/guidelines issued by Ministry of Home affairs, Ministry of Health and Family Welfare and concerned State/UTs on the subject from time to time.<br/><br/><i class=\"fa fa-circle\" ></i><a class=\"txt-msg-info\"target=\"_blank\"href=\"http://contents.irctc.co.in/en/CovidVaccinationInfoEng.pdf\"> Information on Covid 19 Vaccination Programme</a>. Press OK to confirm']"))
				.click();
		driver.manage().window().maximize();
		Thread.sleep(2000);

		String parentWindowHandleId = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[@aria-label='Menu BUSES. Website will be opened in new tab']")).click();
		driver.findElement(By.xpath("//a[@aria-label='Menu Hotels. Website will be opened in new tab']")).click();

		Set<String> allChildWindowHandles = driver.getWindowHandles();

		int count = allChildWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : " + count);

		for (String windowHandle : allChildWindowHandles) {
			driver.switchTo().window(windowHandle); // switch to each browser window
			String title = driver.getTitle();
			/*
			 * compare the window id of all the browsers with the Parent browser window id,
			 * if it is not equal, then only close the child browser windows.
			 */
			if (!windowHandle.equals(parentWindowHandleId)) {
				driver.close();
				System.out.println("Child Browser window with title -->" + title + " --> is closed");
			}
		}
	}

	@Test
	public void CloseAnySpecifiedBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String expected_title = "Tech Mahindra";
		Set<String> allChildWindowHandles = driver.getWindowHandles();
		int count = allChildWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : " + count);
		for (String windowHandle : allChildWindowHandles) {
			driver.switchTo().window(windowHandle);
			String actual_title = driver.getTitle();

			if (actual_title.contains(expected_title)) { // Checking whether the actual title contains the specified
															// expected title
				driver.close();
				System.out.println("Specified Browser window with title -->" + actual_title + " --> is closed");
			}
		}
	}

	@Test
	public void navigate_between_multiple_tabs_and_perform_some_action() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String parentwindowHandle = driver.getWindowHandle();
		// enter username
		driver.findElement(By.id("username")).sendKeys("admin");
		// enter password
		driver.findElement(By.name("pwd")).sendKeys("manager");
		// click on actiTIME INC link
		driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();
		// get the number of windows currently opened on the system
		Set<String> allwhs = driver.getWindowHandles();
		// switch to all the browser windows
		for (String wh : allwhs) {
			driver.switchTo().window(wh);
		}
		// get the title of the tab
		String childtitle = driver.getTitle();
		System.out.println("Title of the child tab is :" + childtitle);
		// close the child tab
		driver.close();
		// switch back to the main browser window
		driver.switchTo().window(parentwindowHandle);
		// close the main browser window
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		// closing the parent window
		driver.close();
	}

}
