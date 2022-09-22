package testNG;

import org.testng.annotations.Test;

public class priority {
	@Test(priority = 3)
	public void Car() {
		System.out.println("My Car Name is Hyundai i20 grand");
	}

	@Test(priority = 2)
	public void Dog() {
		System.out.println("My dog Name is PUBG");
	}

	@Test(priority = 1)
	public void name() {
		System.out.println("my name is Venktesh");
	}
	
	@Test(priority = 0)
	public void waterBottle() {
		System.out.println("This is mineral water bottle");
	}

	@Test(priority = 4)
	public void college() {
		System.out.println("my college name is JSPM");
	}

}
