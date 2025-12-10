package TestNG_Assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class Assertions 
{
	WebDriver driver = new ChromeDriver();
    WebDriverWait wait;

    @Test(priority = 1)
    void Openapp()
    {
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 2)
    void findlogo()
    {
        WebElement logo=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertEquals(logo.isDisplayed(), true);
    }

    @Test(priority = 3)
    void testlogo()
    {
        String title=driver.getTitle();
        String actual="amazzzoneee";
        
        SoftAssert sa=new SoftAssert();
        
        sa.assertEquals(title, actual);
        sa.assertAll();
    }

    @Test(priority = 4)
    void close()
    {

        driver.quit();
    }
	
	
}
