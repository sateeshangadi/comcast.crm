package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SearchtheOrganizationbyAssignedTotest {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("./data/commdata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USER = pro.getProperty("username");
		String PWD = pro.getProperty("password");
		String BRO = pro.getProperty("browser");
		WebDriver driver=null;
		if(BRO.equals("chrome")){
			driver=new ChromeDriver();
		}else if(BRO.equals("firefox")){
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USER);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		WebElement ele = driver.findElement(By.id("bas_searchfield"));
		ele.click();
		Select s=new Select(ele);
		s.selectByVisibleText("Assigned To");
		Thread.sleep(2000);
		System.out.println("assigned");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);
		System.out.println("done");
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele2).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		
		
		
		
	}

}
