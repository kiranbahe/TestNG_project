import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utility 
{

	public static void screenShot(WebDriver driver, String srnShot ){
		
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(source, new File("./ScreenShot/"+srnShot+".png"));
		} 
		
		catch (Exception e) 
		{
			System.out.println("Exception while SreenShot"+e.getMessage());
		} 
		
		
	}
	
	/*public void m2(){
		WebDriver driver=new FirefoxDriver();
	}*/
	
}
