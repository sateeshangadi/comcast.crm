package Practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateorgTest {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		//read commdata from property file
		FileInputStream fis=new FileInputStream("./data/commdata.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		String BROWSER=pobj.getProperty("browser");
		
		//read random number
		Random ran=new Random();
		int randomnum = ran.nextInt(10000);
		
		//read data from excel
		FileInputStream fis2=new FileInputStream("./data/testdata1.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet s = wb.getSheet("org");
		Row row = s.getRow(0);
		Cell cell = row.getCell(0);
		String value = cell.getStringCellValue();
		
		
		
		
		
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome")){
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")){
			driver=new FirefoxDriver();
		}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(value);
		driver.findElement(By.name("button")).click();
		String header = driver.findElement(By.className("dvHeaderText")).getText();
		if(header.contains("QSPIDERS")){
			System.out.println("title contains"+header+"test case pass");
		}
		else{
			System.out.println("title does't contains fail");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		}
		
		
		
		
		
	}


