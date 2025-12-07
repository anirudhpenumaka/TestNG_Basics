package TestNG_Annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Before_After_Methods 
{
	@BeforeMethod
	void setup() {
	    System.out.println("Runs BEFORE every @Test");
	}

	@Test
	void test1() {
	    System.out.println("Test 1 executing...");
	}

	@Test
	void test2() {
	    System.out.println("Test 2 executing...");
	}

	@AfterMethod
	void teardown() {
	    System.out.println("Runs AFTER every @Test");
	}
}
