package actiTIME_App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class findElement_checkBox_WebTable {

	@Test(priority = 1)
	public void find_the_total_number_of_links_number_of_visible_links_and_number_of_hidden_links_present()
			throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		// get the total number of link elements
		int totalLinks = allLinks.size();
		System.out.println("total number of links present on the web page is : " + totalLinks);
		int visibleLinkCount = 0;
		int hiddenLinkCount = 0;
		// using foreach loop, iterate through all the links
		for (WebElement link : allLinks) {
			// if the link is displayed, then print the text of the link
			if (link.isDisplayed()) {
				visibleLinkCount++;
				System.out.println(visibleLinkCount + " --> " + link.getText());
			} else {
				hiddenLinkCount++;
			}
		}
		System.out.println("Total number of visible links :" + visibleLinkCount);
		System.out.println("Total number of hidden links :" + hiddenLinkCount);
		driver.close();
	}

	@Test(priority = 2)
	public void WebTable() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\user\\Desktop\\Html_Pages\\WebTable.html");
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
		driver.close();
	}

	@Test(priority = 3)
	public void Google_Search_Auto_Suggestions() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("selenium");
		Thread.sleep(2000);

		List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));
		int count = allOptions.size();
		System.out.println("Number of Auto suggestion values found in the  dropdown are : " + count);
		String expectedValue = "selenium download";

		for (WebElement option : allOptions) {
			String text = option.getText();
			System.out.println(" " + text);
			if (text.equalsIgnoreCase(expectedValue)) {
				option.click();
				break;
			}
		}
	}

	@Test(priority = 4)
	public void ListBox() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("C:\\Users\\user\\Desktop\\Html_Pages\\ListBox_Breakfast.html");

		WebElement list = driver.findElement(By.id("mtr"));
		Select select = new Select(list); // passing the address of list box as an argument
		List<WebElement> options = select.getOptions();

		int size = options.size();
		System.out.println("Number of elements present inside the list box are : " + size);

		// Printing all the elements present in the list box
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}

		select.selectByIndex(0);
		Thread.sleep(1000);
		select.selectByValue("d");
		Thread.sleep(1000);
		select.selectByVisibleText("POORI");

		System.out.println("************Print all selected options***********");
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();

		int size2 = allSelectedOptions.size();
		System.out.println("Number of items that is selected in the list box are : " + size2);
		System.out.println(" Selected items are printed below --->");

		for (WebElement webElement : allSelectedOptions) {
			System.out.println(webElement.getText());
		}

		// check whether it is a multiple select list box or not
		boolean multiple = select.isMultiple();
		System.out.println(multiple + " yes , it is multi select");
		if (multiple) {
			WebElement firstSelectedOption1 = select.getFirstSelectedOption();
			System.out.println(firstSelectedOption1.getText() + " is the first selected item in the list box");
			select.deselectByIndex(0);

			WebElement firstSelectedOption2 = select.getFirstSelectedOption();
			System.out.println(firstSelectedOption2.getText() + " is the first selected item");
			select.deselectByValue("d");

			WebElement firstSelectedOption3 = select.getFirstSelectedOption();
			System.out.println(firstSelectedOption3.getText() + " is the first selected item");
			select.deselectByVisibleText("POORI");
		}
	}

	@Test(priority = 5)
	public void PrintListValues_SortedOrder() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("C:\\Users\\user\\Desktop\\Html_Pages\\ListBox_Breakfast.html");
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

	@Test(priority = 6)
	public void printUniqueElementinthelistbox() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("C:\\Users\\user\\Desktop\\Html_Pages\\ListBox_Breakfast.html");
		WebElement listElement = driver.findElement(By.id("mtr"));
		Select s = new Select(listElement);
		List<WebElement> allOptions = s.getOptions();
		int count = allOptions.size();
		System.out.println(count);
		System.out.println("-----print the values in the list ----");
		HashSet<String> allElements = new HashSet<String>();
		for (WebElement option : allOptions) {
			String text = option.getText();
			System.out.println(text);
			allElements.add(text);
		}
		System.out.println(allElements);
	}

	@Test(priority = 7)
	public void printUniqueElement_Sorted() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("C:\\Users\\user\\Desktop\\Html_Pages\\ListBox_Breakfast.html");
		WebElement listElement = driver.findElement(By.id("mtr"));
		Select select = new Select(listElement);
		List<WebElement> allOptions = select.getOptions();

		int count = allOptions.size();
		System.out.println(count);
		System.out.println("-----print the elements in the list ----");

		TreeSet<String> allElements = new TreeSet<String>();
		for (WebElement option : allOptions) {
			String text = option.getText();
			System.out.println(text);
			allElements.add(text);
		}
		System.out.println(allElements);
	}

	@Test(priority = 8)
	public void checklisthasDUPLICATEvalues_HashSet() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("C:\\Users\\user\\Desktop\\Html_Pages\\ListBox_Breakfast.html");
		WebElement listBox = driver.findElement(By.id("mtr"));
		Select select = new Select(listBox);
		List<WebElement> allOptions = select.getOptions();

		int count1 = allOptions.size();
		System.out.println("Number of elements in the list are :" + count1);

		HashSet<String> allElementText = new HashSet<String>();
		for (int i = 0; i < count1; i++) {
			String text = allOptions.get(i).getText();
			System.out.println(text);
			allElementText.add(text);
		}
		int count2 = allElementText.size();
		System.out.println("Number of elements in the hashset are :" + count2);
		if (count1 == count2) {
			System.out.println("list box has NO duplicate elements");
		} else {
			System.out.println("list box has duplicate Elements");
		}
		System.out.println("Unique Elements of List box are: " + allElementText);
	}

	@Test(priority = 9)
	public void PrinttheDUPLICATEItem_intheList_HashSet() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("C:\\Users\\user\\Desktop\\Html_Pages\\ListBox_Breakfast.html");
		WebElement listBox = driver.findElement(By.id("mtr"));
		Select select = new Select(listBox);
		List<WebElement> allOptions = select.getOptions();

		int count = allOptions.size();
		System.out.println("Number of elements in the list is :" + count);

		HashSet<String> allElementText = new HashSet<String>();
		for (int i = 0; i < count; i++) {
			String text = allOptions.get(i).getText();

			if (!allElementText.add(text)) {
				System.out.println(text + " is the duplicate element in the list box");
			}
		}
		// System.out.println(allElementText);
		System.out.println(allElementText.size());
	}

	@Test(priority = 10)
	public void print_NumberOfOccurrenceOfElement_InListBox() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("C:\\Users\\user\\Desktop\\Html_Pages\\ListBox_Breakfast.html");
		WebElement list = driver.findElement(By.id("mtr"));
		Select select = new Select(list);
		List<WebElement> allElements = select.getOptions();

		HashMap<String, Integer> hashMapObj = new HashMap<String, Integer>();

		for (WebElement element : allElements) {
			String text = element.getText();
			if (hashMapObj.containsKey(text)) {
				Integer value = hashMapObj.get(text);
				value++;
				hashMapObj.put(text, value);
			} else {
				hashMapObj.put(text, 1);
			}
		}

		Set<String> allKeys = hashMapObj.keySet();
		for (String key : allKeys) {
			Integer value = hashMapObj.get(key);
			System.out.println(key + " -->" + value);
			if (value > 1) {
				System.out.println("Occurrence of " + key + " is :" + value);
			}
		}
	}

}
