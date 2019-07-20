package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.LoginPage;
import util.BrowserFactory_TestNG;

public class Logintest {
	@Test
	public void llogin()
	{
		WebDriver driver= BrowserFactory_TestNG.startBrowser("chrome","http://techfios.com/test/billing/?ng=login/");
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.Login("techfiosdemo@123.com", "abc123");
		driver.close();
		driver.quit();
		
		
	}
	

}
