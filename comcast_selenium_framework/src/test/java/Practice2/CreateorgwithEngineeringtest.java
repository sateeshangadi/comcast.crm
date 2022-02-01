package Practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateorgwithEngineeringtest {
	public static void main(String[] args) throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		int ranint = jlib.getRnadomNumber();
		
		//common data
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER=flib.getPropertyKeyValue("browser");
		
		//test script data from excel
		String orgname = elib.getDataFromExcel("org",2,0)+ranint;
		
		
		//launch browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
		}else{
			System.out.println("browser does not match");
		}
		wlib.waitUntilPageLoad(driver);
		driver.get(URL);
		
		//login to vtiger
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		WebElement ele = driver.findElement(By.name("industry"));
		wlib.select(ele, "Engineering");
		WebElement ele1 = driver.findElement(By.name("accounttype"));
		wlib.select(ele1, "Customer");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseOver(driver, ele2);
		driver.findElement(By.linkText("Sign Out")).click();
		
	}

}
