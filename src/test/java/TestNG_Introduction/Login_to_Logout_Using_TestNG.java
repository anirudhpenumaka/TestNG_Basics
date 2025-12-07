package TestNG_Introduction;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Login_to_Logout_Using_TestNG 
{
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait;

    @Test(priority = 1)
    void Openapp()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 2)
    void testlogin()
    {
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")))
                .sendKeys("Admin");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")))
                .sendKeys("admin123");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")))
                .click();
    }

    @Test(priority = 3)
    void testlogo()
    {
        boolean status = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//img[@alt='client brand banner']"))).isDisplayed();

        System.out.println("Logo displayed? → " + status);

        if (status) 
        {
            System.out.println("Logo Present");
        }
        else
        {
            System.out.println("Logo NOT Present");
        }
    }

    @Test(priority = 4)
    void logout()
    {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@class='oxd-userdropdown-tab']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Logout']"))).click();

        System.out.println("Test Passed");

        driver.quit();
    }
}
