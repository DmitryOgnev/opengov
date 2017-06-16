package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest
{  
	protected WebDriver driver;

	@Before
	public void BaseTestsetUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dmitry Ognev\\Desktop\\Java\\Selenium\\Selenium_files\\Drivers\\16_1\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void basetearDown() throws Exception
	{
	 
		 driver.quit();
	}
    
	

}
