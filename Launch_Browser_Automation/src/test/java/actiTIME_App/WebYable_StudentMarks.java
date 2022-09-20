package actiTIME_App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebYable_StudentMarks {

	@Test(priority = 1)
	public void WebTable() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\user\\Desktop\\Html_Pages\\WebTable_StudentMarks.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		// Count Total number of rows present in the table
		List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
		int totalRows = allRows.size();
		System.out.println("total number of rows present in the table is :" + totalRows);
		// count total number of columns
		List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
		int totalColumns = allColumns.size();
		System.out.println("Total number of columns in the table is :" + totalColumns);
		// Count number of cells present in the table
		List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
		int totalCells = allCells.size();
		System.out.println("Total number of cells present in the table is :" + totalCells);
		// Print ONLY the numbers
		int countNumberValue = 0;
		int sum = 0;
		for (WebElement cell : allCells) {
			String cellValue = cell.getText();
			try {
				int number = Integer.parseInt(cellValue);
				System.out.print(" " + number);
				countNumberValue++;
				sum = sum + number;
			} catch (Exception e) {

			}
		}
		System.out.println("Total count of numeric values is :" + countNumberValue);
		System.out.println("Total sum of all the numeric values is :" + sum);
		// close the browser
//		driver.close();
	}
	
	@Test(priority = 2)
	public void PrintListValues_SortedOrder() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("C:\\Users\\user\\Desktop\\Html_Pages\\WebTable_StudentMarks.html");
		WebElement listElement = driver.findElement(By.id("mtr"));
		Select select = new Select(listElement);
		List<WebElement> allOptions = select.getOptions();

		int count = allOptions.size();
		System.out.println(count);
		System.out.println("-----print the elements in the list ----");
		ArrayList<String> list = new ArrayList<String>();
		for (WebElement option : allOptions) {
			String text = option.getText();
			System.out.println(text);
			list.add(text);
		}
		Collections.sort(list);
		System.out.println("-----print the elements of list in sorted order----");
		for (String value : list) {
			System.out.println(value);
		}
	}

	


}
