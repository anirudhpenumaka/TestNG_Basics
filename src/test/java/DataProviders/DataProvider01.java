package DataProviders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
public class DataProvider01 
{
	 WebDriver driver;

	    @BeforeClass
	    void setup() {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
	    }

	    @Test(dataProvider="dp")
	    void testLogin(String email,String pwd) throws InterruptedException {

	        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	        driver.manage().window().maximize();

	        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
	        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
	        driver.findElement(By.xpath("//input[@value='Login']")).click();

	        Thread.sleep(2000);

	        boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();

	        if (status == true) {
	            driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
	            Assert.assertTrue(true);
	        } else {
	            Assert.fail();
	        }
	    }

	    @AfterClass
	    void tearDown() {
	        driver.close();
	    }
	
	
	
	@DataProvider(name="dp")
	Object[][] logindata(){
		Object data[][]=
			{
					{"abc51@gmail.com","test46165123"},
					{"abc451@gmail.com","test123"},
					{"abc4615@gmail.com","test123589632147"}
			};
		
		return data;
	}
}
