package ParallelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class paralleltesting 
{
	WebDriver driver;
	
	 @BeforeClass
	 @Parameters({"browser"})
	    void setup(String br) {
		 	
		 switch(br.toLowerCase())
		 {
		     case "chrome" : driver = new ChromeDriver(); break; 
		     case "edge" : driver = new EdgeDriver(); break;
		     default: System.out.println("Invalid broswer"); return;
		 }
		 	
		 
	        
	        driver.manage().window().maximize();
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    }

	    @Test(priority = 1)
	    void testLogo() {
	        boolean status = driver.findElement(By.xpath("//div[@class='orangehrm-login-logo']//img[@alt='orangehrm-logo']")).isDisplayed();
	        Assert.assertEquals(status, true);
	    }

	    @Test(priority = 2)
	    void testTitle() {
	        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	    }

	    @Test(priority = 3)
	    void testURL() {
	        Assert.assertEquals(
	                driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    }

	    @AfterClass
	    void tearDown() {
	        driver.close();
	    }
}
