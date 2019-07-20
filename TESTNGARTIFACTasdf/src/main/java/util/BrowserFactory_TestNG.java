package util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory_TestNG {
	
		static WebDriver driver;
		public static WebDriver startBrowser(String browsername,String url)
		{
			if (browsername.equalsIgnoreCase("chrome"))
				{
				System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
				driver= new ChromeDriver();
								}
			driver.get(url);
			return driver;
		}
			
		}


