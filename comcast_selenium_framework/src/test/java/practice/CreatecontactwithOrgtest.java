package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreatecontactwithOrgtest {
	public static void main(String[] args) throws Throwable{
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
		String orgname = elib.getDataFromExcel("org",1,0)+ranint;
		String contactname = elib.getDataFromExcel("contact", 0, 0)+ranint;
		
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
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
         Thread.sleep(5000);
		WebElement ele1 = driver.findElement(By.linkText("Contacts"));
		wlib.waitForElementVisibility(driver, ele1);
		ele1.click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactname);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		wlib.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgname)).click();
		wlib.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		
	}

}
