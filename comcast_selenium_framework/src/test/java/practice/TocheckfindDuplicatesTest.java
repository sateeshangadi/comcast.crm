package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TocheckfindDuplicatesTest {
	public static void main(String[] args) throws IOException, InterruptedException {
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
		driver.findElement(By.xpath("//img[@src='themes/images/findduplicates.gif']")).click();
		driver.findElement(By.xpath("//option=[.='Organization Name']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Button']")).click();
		driver.findElement(By.xpath("//input[@name='save&merge']")).click();
		String msg = driver.findElement(By.className("genHeaderSmall")).getText();
		System.out.println(msg);
		
	}

}
