package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.pomrepositorylib.Home;
import com.crm.comcast.pomrepositorylib.Login;

public class BaseClass {
	// create objects
			public JavaUtility jlib=new JavaUtility();
			public ExcelUtility elib=new ExcelUtility();
			public WebDriverUtility wlib=new WebDriverUtility();
			public FileUtility flib=new FileUtility();
			public WebDriver driver;
			public static WebDriver sDriver;
			/**
			 * This method  for connect to the database
			 */
			@BeforeSuite(groups={"smokeTest","regressionTest"})
			public void configBS(){
				System.out.println("=====connect to database=====");
			}
			//@Parameters("browser")
			@BeforeClass(groups={"smokeTest","regressionTest"})
			/**
			 * this method for launch the browser
			 * @throws Throwable
			 */
			public void configBC() throws Throwable{
				System.out.println("====launch the browser====");
				String BROWSER = flib.getPropertyKeyValue("browser");
				if(BROWSER.equalsIgnoreCase("firefox"))
				{
					driver=new FirefoxDriver();
				}else if(BROWSER.equalsIgnoreCase("chrome")){
					driver=new ChromeDriver();
				}else{
					System.out.println("no matching browser");
				}
				wlib.waitUntilPageLoad(driver);
				driver.manage().window().maximize();
			}
			
			@BeforeMethod(groups={"smokeTest","regressionTest"})
			/**
			 * this method for login to application
			 * @throws Throwable
			 */
			public void configBM() throws Throwable{
				System.out.println("=====login to application====");
				String USERNAME = flib.getPropertyKeyValue("username");
				String PASSWORD = flib.getPropertyKeyValue("password");
				String URL = flib.getPropertyKeyValue("url");
				driver.get(URL);
				Login lp=new Login(driver);
				lp.logintoApp(USERNAME, PASSWORD);
				
			}
			/**
			 * this method for loggingout from application
			 */
			@AfterMethod(groups={"smokeTest","regressionTest"})
			public void configAM(){
				Home hp=new Home(driver);
				hp.logout();
				
			}
			/**
			 * this method for quit the launched browser
			 */
			@AfterClass(groups={"smokeTest","regressionTest"})
			public void configAC(){
				driver.quit();
			
			}
			/**
			 * this method for disconnect the database connection
			 */
			@AfterSuite(groups={"smokeTest","regressionTest"})
			public void configAS(){
				System.out.println("====disconnect to database====");
			}

}
