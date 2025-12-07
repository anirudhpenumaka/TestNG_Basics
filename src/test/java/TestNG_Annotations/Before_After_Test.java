package TestNG_Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Before_After_Test 
{	
	@BeforeClass
	void BeforeClass() {
	    System.out.println("Runs BEFORE every class");
	}
	
	@BeforeMethod
	void BeforeMethod() {
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
	void AfterMethod() {
	    System.out.println("Runs AFTER every @Test");
	}
	
	@AfterClass
	void AfterClass() {
	    System.out.println("Runs AFTER every class");
	}
}
