package Crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossBrowserTest {

	WebDriver driver;
	
	@Test
	@Parameters({"browser"})
	public void verifyTitle(String browsername){
		
		
		if(browsername.equalsIgnoreCase("firefox")){
			 driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome")){
			System.setProperty("WebDriver.chrome.driver", "C:\\Users\\Kiran\\Downloads\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("ie")){
			System.setProperty("WebDriver.ie.driver", "C:/Users/Kiran/Downloads/IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.get("http://www.google.com");
		
		System.out.println(driver.getTitle());
		
		driver.quit();
	}
}
