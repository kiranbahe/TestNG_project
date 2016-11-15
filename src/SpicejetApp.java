

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SpicejetApp {

	@Test
	public void SpicejetOpration(){
		String City="Mumbai (BOM)";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kiran\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://spicejet.com");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		List<WebElement> cities = driver.findElements(By.xpath(".//*[@id='dropdownGroup1']/div/ul[*]/li[*]/a"));
		for (WebElement webElement : cities) {
			//System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase(City)) {
				webElement.click();
			}
		}
		
		String ToCity2="Jammu (IXJ)";
		//driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();
		List<WebElement> tocity=driver.findElements(By.xpath("//*[@id='dropdownGroup1']/div/ul[*]/li[*]/a"));
		
		for (WebElement webElement : tocity) {
			//System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase(ToCity2)) {
				webElement.click();
			}
		}
		
		String monthyear="may 2017";
		//driver.findElement(By.className("ui-datepicker-trigger")).click();
		String month=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[*]/div/div")).getText();
		
		while (!month.equalsIgnoreCase(monthyear)) {
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e'][text()='Next']")).click();
			month=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[*]/div/div")).getText();
		}
	
		String expDate="25";
		String month1="May";
		WebElement monthVal=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]"));
		WebElement monthVal2=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[1]"));
		if (monthVal.getText().equalsIgnoreCase(month1)) {
			
			List<WebElement> dates=driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[*]/td[*]/a"));
			for (WebElement webElement : dates) {
				if (webElement.getText().equalsIgnoreCase(expDate)) {
					webElement.click();
					break;
				}
			}
		}
		else{
			if (monthVal2.getText().equalsIgnoreCase(month1)) {
				List<WebElement> nxtdates=driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[*]/td[*]/a"));
				for (WebElement webElement2 : nxtdates) {
					if (webElement2.getText().equalsIgnoreCase(expDate)) {
						webElement2.click();
						break;
					}
				}
			}
		}
	}
}
		
		





