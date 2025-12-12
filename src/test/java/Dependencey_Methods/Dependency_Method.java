package Dependencey_Methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dependency_Method 
{
	WebDriver driver;
	
	@Test(priority=1)
	void openapp()
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=2,dependsOnMethods={"openapp"})
	void login()
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).click();
	}
	
	@Test(priority=3,dependsOnMethods={"login"})
	void search()
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
	}
	
	@Test(priority=4,dependsOnMethods={"login"})
	void quit()
	{
		driver.quit();
	}

}
