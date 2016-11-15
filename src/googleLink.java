import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class googleLink {

	@Test
	public void google() throws IOException{
		
		int rc;
		
		XSSFRow row;
		String lname,exppgTitle,actpgTitle;
		
		FileInputStream fi=new FileInputStream("D:\\workspace\\UsingTestNG\\Testdata\\gmaildatasheet.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("googleLink");
		
		 rc=ws.getLastRowNum();
		 
		 //WebDriver driver=new FirefoxDriver();
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kiran\\Downloads\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("http://google.co.in");
		 for(int i=1;i<=rc;i++){
			 row=ws.getRow(i);
			 lname=row.getCell(0).getStringCellValue();
			 
			 driver.findElement(By.linkText(lname)).click();
			 actpgTitle=driver.getTitle();
			 driver.navigate().back();
			 row.createCell(2).setCellValue(actpgTitle);
			 
			 exppgTitle=row.getCell(1).getStringCellValue();
			 
			 if (exppgTitle.equalsIgnoreCase(actpgTitle)) {
				row.createCell(3).setCellValue("Pass");
				
			}
			 else{
				 row.createCell(3).setCellValue("Fail");
			 }
		 }
		
		
		
		FileOutputStream fo=new FileOutputStream("D:\\workspace\\UsingTestNG\\Testdata\\gmaildatasheet.xlsx");
		wb.write(fo);
		wb.close();
	}
	
	
}
