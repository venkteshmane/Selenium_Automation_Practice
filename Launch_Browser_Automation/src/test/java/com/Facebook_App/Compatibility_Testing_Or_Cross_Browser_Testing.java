package com.Facebook_App;

import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Compatibility_Testing_Or_Cross_Browser_Testing {
	public static void main(String[] args) {
		System.out.println("Welcome to Testing Selenium by different browsers");
		Options();
	}

	public static void Options() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.testing with geckodriver");
		System.out.println("2.testing with chromedriver");
		System.out.println("3.testing with msedgedriver");
		System.out.println("4.exit");
		System.out.println("Enter Your choice:");
//		int input;
		int choice = scanner.nextInt();
		scanner.nextLine();
		while (choice != 0 && choice <= 4)
			switch (choice) {
			case 1:
				while (choice == 1) {
					try {
						geckodriver();

					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				break;
			case 2:
				while (choice == 2) {
					try {
						chromedriver();
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				break;
			case 3:
				while (choice == 3) {
					try {
						msedgedriver();
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				break;
			}
	}

	public static void geckodriver() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\user\\Downloads\\geckodriver-v0.31.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("venky@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Mane123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(3000);
//		driver.close();
	}

	public static void chromedriver() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("venky@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Mane123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(3000);
//		driver.close();
	}

	public static void msedgedriver() throws InterruptedException {

		System.setProperty("webdriver.edgedriver.driver",
				"C:\\Users\\user\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("venky@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Mane123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(3000);
//		driver.close();
	}
}