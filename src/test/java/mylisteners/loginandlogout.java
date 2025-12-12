package mylisteners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(mylisteners.my_listeners.class)
public class loginandlogout 
{
	WebDriver driver;
	 @BeforeClass
	    void setup() {
		 	driver=new ChromeDriver();
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
