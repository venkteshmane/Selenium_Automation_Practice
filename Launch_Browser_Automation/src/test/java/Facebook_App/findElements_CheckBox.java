package Facebook_App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findElements_CheckBox {

	WebDriver driver = null;

	@BeforeMethod
	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void selectBirthDate_FacebookSignUpTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(2000);
		WebElement date = driver.findElement(By.name("birthday_day"));

		Select select = new Select(date);
		List<WebElement> options = select.getOptions();
		int size = options.size();
		System.out.println("Number of elements present inside the list box are : " + size);

		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}

		select.selectByIndex(0);
		Thread.sleep(1000);
		select.selectByValue("14");
		Thread.sleep(1000);
		select.selectByVisibleText("31");
		Thread.sleep(1000);

		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		int size2 = allSelectedOptions.size();
		System.out.println("Number of items that is selected in the list box is : " + size2);

		System.out.println(" Selected items are printed below ");
		for (WebElement webElement : allSelectedOptions) {
			String text = webElement.getText();
			System.out.println(text);
		}

		System.out.println("check whether it is a multiple select list box or not");
		boolean multiple = select.isMultiple();
		System.out.println(multiple);
	}

	@Test
	public void selectBirthMonth_FacebookSignUpTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(2000);
		WebElement month = driver.findElement(By.name("birthday_month"));

		Select select = new Select(month);
		List<WebElement> options = select.getOptions();
		int size = options.size();
		System.out.println("Number of elements present inside the list box are : " + size);
		// Print all the elements present in the list box
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}

		select.selectByIndex(1);
		Thread.sleep(1000);
		select.selectByValue("2");
		Thread.sleep(1000);
		select.selectByVisibleText("Aug");
		Thread.sleep(1000);

		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		int size2 = allSelectedOptions.size();
		System.out.println("Number of items that is selected in the list box is : " + size2);

		System.out.println(" Selected items are printed below ");
		for (WebElement webElement : allSelectedOptions) {
			String text = webElement.getText();
			System.out.println(text);
		}

		System.out.println("check whether it is a multiple select list box or not");
		boolean multiple = select.isMultiple();
		System.out.println(multiple);

//		  if (multiple) { WebElement firstSelectedOption =
//		  select.getFirstSelectedOption();
//		  System.out.println(firstSelectedOption.getText()+
//		  " is the first selected item in the list box"); select.deselectByIndex(7);
//		  WebElement firstSelectedOption1 = select.getFirstSelectedOption();
//		  System.out.println(firstSelectedOption1.getText()
//		  +" is the first selected item"); WebElement firstSelectedOption2 =
//		  select.getFirstSelectedOption();
//		  System.out.println(firstSelectedOption2.getText()
//		  +" is the first selected item"); select.deselectByIndex(0); }
//		 
	}

	@Test
	public void selectBirthYear_FacebookSignUpTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(2000);
		WebElement year = driver.findElement(By.name("birthday_year"));

		Select select = new Select(year);
		List<WebElement> options = select.getOptions();
		int size = options.size();
		System.out.println("Number of elements present inside the list box are : " + size);

		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}

		select.selectByIndex(1);
		Thread.sleep(1000);
		// select.selectByValue("4");
		// Thread.sleep(1000);
		select.selectByVisibleText("1994");
		Thread.sleep(1000);

		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		int size2 = allSelectedOptions.size();
		System.out.println("Number of items that is selected in the list box is : " + size2);

		System.out.println(" Selected items are printed below ");
		for (WebElement webElement : allSelectedOptions) {
			String text = webElement.getText();
			System.out.println(text);
		}

		System.out.println("check whether it is a multiple select list box or not");
		boolean multiple = select.isMultiple();
		System.out.println(multiple);

//		if (multiple) {
//			WebElement firstSelectedOption = select.getFirstSelectedOption();
//			System.out.println(firstSelectedOption.getText() + " is the first selected item in the list box");
//			select.deselectByIndex(7);
//			WebElement firstSelectedOption1 = select.getFirstSelectedOption();
//			System.out.println(firstSelectedOption1.getText() + " is the first selected item");
//			WebElement firstSelectedOption2 = select.getFirstSelectedOption();
//			System.out.println(firstSelectedOption2.getText() + " is the first selected item");
//			select.deselectByIndex(0);
//		}

	}

	@Test
	public void printListElements_inSortedOrder() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(2000);

		WebElement listElement = driver.findElement(By.name("birthday_month"));
		Select select = new Select(listElement);
		List<WebElement> allOptions = select.getOptions();

		int count = allOptions.size();
		System.out.println(count);
		System.out.println("Print all the element values in the list ");

		ArrayList<String> list = new ArrayList<String>();
		for (WebElement option : allOptions) {
			String text = option.getText();
			System.out.println(text);
			list.add(text);
		}
		Collections.sort(list);
		System.out.println("Print all the element values in sorted order");
		for (String value : list) {
			System.out.println(value);
		}
	}

	@Test
	public void check_UniqueElements_Of_ListBox() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(2000);

		WebElement listElement = driver.findElement(By.name("birthday_month"));
		Select select = new Select(listElement);
		List<WebElement> allOptions = select.getOptions();

		int count = allOptions.size();
		System.out.println(count);
		System.out.println("-----print all the elements in the list ----");

		HashSet<String> allElements = new HashSet<String>();
		for (WebElement option : allOptions) {
			String text = option.getText();
			System.out.println(text);
			allElements.add(text);
		}
		// System.out.println("Unique Elements in the list are: " + allElements);
		System.out.println(allElements);
	}

	@Test
	public void printUniqueElementsOfList_SortedOrder() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(2000);

		WebElement listElement = driver.findElement(By.name("birthday_month"));
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

	@Test
	public void check_ListHasDuplicateElements_HashSet() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(2000);

		WebElement listElement = driver.findElement(By.name("birthday_month"));
		Select select = new Select(listElement);
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

	@Test
	public void print_DuplicateElementsOfList_HashSet() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(2000);

		WebElement listElement = driver.findElement(By.name("birthday_month"));
		Select select = new Select(listElement);
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

	@Test
	public void print_NumberOfOccurrenceOfElement_InListBox() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(2000);

		WebElement list = driver.findElement(By.name("birthday_month"));
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

	@AfterMethod
	public void closeDriver() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		driver.close();
	}

}
