import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossBrowser {

	 WebDriver driver;
	 
	@Test
	@Parameters({"browser"})
	 public void testBroweser(String browser){
		
		if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		 else if(browser.equalsIgnoreCase("chrome")){
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kiran\\Downloads\\chromedriver.exe");
			 driver=new ChromeDriver();
		 }
		 else if(browser.equalsIgnoreCase("IE")){
				 System.setProperty("webdriver.ie.driver", "C:\\Users\\Kiran\\Downloads\\IEDriverServer.exe");
				 driver=new InternetExplorerDriver();
		}
			
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		driver.manage().window().maximize();
		driver.get("http://facebook.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	

}
