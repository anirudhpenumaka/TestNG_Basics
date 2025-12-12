package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;
	
	
	//constructor
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//Locators
	
	By username=By.xpath("//input[@placeholder='Username']");
	By password=By.xpath("//input[@placeholder='Password']");
	By login_button=By.xpath("//button[normalize-space()='Login']");
	
	
	//Action methods
	public void setUserName(String user)
	{
		driver.findElement(username).sendKeys(user);
	}
	
	public void setPassword(String pass)
	{
	    driver.findElement(password).sendKeys(pass);
	}
	
	public void clicklogin()
	{
		driver.findElement(login_button).click();;
	}
}
