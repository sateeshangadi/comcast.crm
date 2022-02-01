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
import org.openqa.selenium.interactions.Actions;

public class OpenthecreatedOrgfromOrglistTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./data/commdata.properties");
		Properties poj=new Properties();
		poj.load(fis);
		String URL = poj.getProperty("url");
		String USER = poj.getProperty("username");
		String PWD = poj.getProperty("password");
		String BRO = poj.getProperty("browser");
		WebDriver driver=null;
		if(BRO.equals("firefox")){
			driver=new FirefoxDriver();
		}else if(BRO.equals("chrome")){
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USER);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		WebElement ele = driver.findElement(By.xpath("(//a[.='MVJCE'])[2]"));
		ele.click();
		String msg = driver.findElement(By.className("dvHeaderText")).getText();
		String msg2 = driver.findElement(By.xpath("//span[@class='small']")).getText();
		System.out.println(msg+"\t"+msg2);
		Actions act=new Actions(driver);
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(ele2).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		System.out.println("logged out successfully");
	}

}
