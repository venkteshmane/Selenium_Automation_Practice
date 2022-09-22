package testNG;

import org.testng.annotations.*;

public class depends_on_Methods_Test {
	@Test
	public void WebStudentLogin() {
		System.out.println("Student login through web");
	}

	@Test
	public void MobileStudentLogin() {
		System.out.println("Student login through mobile");
	}

	@Test(dependsOnMethods = { "WebStudentLogin" })
	public void APIStudentLogin() {
		System.out.println("Student login through API");
	}

}
