import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class facebook {
	
	WebDriver driver;	
	@Test
	public void facebookChat() throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kiran\\Downloads\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://facebook.com");
		
		
		
		
		driver.findElement(By.id("email")).sendKeys("9503711652");
		driver.findElement(By.id("pass")).sendKeys("krehab91@31");
		driver.findElement(By.id("loginbutton")).click();
		Runtime.getRuntime().exec("C:/Users/Kiran/Desktop/AutiExe_File/facebkpopUp.exe");
		Thread.sleep(6000);
		System.out.println("login successfully");
		//Alert alert = driver.switchTo().alert();
		//alert.dismiss();
		
		//Explicit Wait Code***********

		
		//WebDriverWait wait=new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'_42fz')]//div[contains(@class,'55lr')]")));
		
		List<WebElement> chatName=driver.findElements(By.xpath("//li[contains(@class,'_42fz')]//div[contains(@class,'55lr')]"));
		for (WebElement webElement : chatName) {
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase("Bajrangi Varma")) {
				webElement.click();
				Thread.sleep(4000);
			}
			
		}
		
		
		
		
		//For Screen-Shot Code
		
		//Utility.screenShot(driver, "facebookmsg");
		
		String mainwindow = driver.getWindowHandle();
        for (String popup : driver.getWindowHandles()){
            driver.switchTo().window(popup);
            }
            
		driver.findElement(By.xpath(".//*[@id='js_q']")).click();
		
		
		
		
	}
	
	// code for ScreenShot if TestCase got Fail*************
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		if (ITestResult.FAILURE==result.getStatus()) {
			
			Utility.screenShot(driver, result.getName());
		}
	
		driver.findElement(By.xpath(".//*[@id='pageLoginAnchor']")).click();
		driver.findElement(By.xpath(".//*[@id='BLUE_BAR_ID_DO_NOT_USE']/div/div/div[1]/div/div/ul/li[12]/a/span/span")).click();
	
		driver.quit();
	}

	
}
