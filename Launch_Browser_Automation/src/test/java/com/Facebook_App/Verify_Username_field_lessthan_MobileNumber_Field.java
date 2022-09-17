package com.Facebook_App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Verify_Username_field_lessthan_MobileNumber_Field {
	@Test
	public void Validate_Username_field_lessthan_MobileNumber_Field() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement unTB = driver.findElement(By.id("email"));
		int username_width = unTB.getSize().getWidth();
		System.out.println(username_width);
		// Identify the mobile number text box
		WebElement mobileNumTB = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Mobile number or email address')]"));
		int mobNumWidth = mobileNumTB.getSize().getWidth();
		System.out.println(mobNumWidth);
		// Compare the width of both username and mobilenumber text box
		if (username_width == mobNumWidth) {
			System.out.println(
					"Size of Both username and password fields are same" + username_width + " = " + mobNumWidth);
		} else {
			System.out.println("Size of username and password fields are NOT same that is : " + username_width
					+ " Not equals to " + mobNumWidth);
		}

	}

}
