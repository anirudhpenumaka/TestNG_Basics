package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage01 
{
	//Page Factorry - find element and it's method
	
	WebDriver driver;
	
	//constructor
	LoginPage01(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="//input[@placeholder='Username']") WebElement username01;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password01;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement login_button01;
	
	//Action Methods
	public void setUserName01()
	{
		username01.sendKeys("Admin");
	}
	
	public void setPassword01()
	{
		password01.sendKeys("admin123");
	}
	
	public void clicklogin01()
	{
		login_button01.click();
	}
	
}
