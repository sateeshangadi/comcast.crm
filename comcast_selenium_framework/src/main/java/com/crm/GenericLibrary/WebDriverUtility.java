package com.crm.GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * this method to wait for 20 seconds to page get loaded
	 * @param driver
	 */
	
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * this method is to wait until the element is visible
	 * @param driver
	 * @param ele
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement ele){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	/**
	 * this method is wait for element to be clicked
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitandClick(WebElement element) throws InterruptedException{
		int count=0;
		while(count<20){
			try{
				element.click();
				break;
			}catch(Throwable e){
				Thread.sleep(1000);
				count++;
			}
			}
		}
	/**
	 * this method is to handle the dropdown using visible text
	 * @param element
	 * @param option
	 */
	public void select(WebElement element,String text){
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * this method is to handle the dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index){
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * this method is used to handle the dropdown using value
	 * @param value
	 * @param element
	 */
	public void select(String value,WebElement element){
		Select select=new Select(element);
		select.deselectByValue(value);
	}
	/**
	 * this method is used to do mouseover action 
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method is used to do rightclick on the element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * this method is used to do doubleclick on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * this method is used tro switch from one window to other
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle){
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext()){
			String winid = it.next();
			String title = driver.switchTo().window(winid).getTitle();
			if(title.contains(partialWinTitle)){
				break;
			}
		}
	}
	/**
	 * this method is used to accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver){
		driver.switchTo().alert().accept();
	}
    /**
     * this method is for dismiss the alert popup
     * @param driver
     */
	public void dismissAlert(WebDriver driver){
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method is used to do scrolling action in web page
	 * @param driver
	 * @param element
	 */
	public void scrollToElement(WebDriver driver,WebElement element){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		}
	/**
	 * this method used to switch to other frame using index
	 */
	public void switchFrame(WebDriver driver,int index){
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used to switch to other frame using  element
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element){
		driver.switchTo().frame(element);
	}
	/**
	 * this method is used to switch to other frame using id or name
	 * @param driver
	 * @param idOrName
	 */
	public void switchFrame(WebDriver driver,String idOrName){
		driver.switchTo().frame(idOrName);
	}
	/**
	 * this method is to take screenshot
	 * @param driver
	 * @param screenshotname
	 * @throws IOException
	 */
	public void takeScreenshot(WebDriver driver,String screenshotname) throws IOException{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshotname+".jpg");
		Files.copy(src, dest);
	}
	/**
	 * pass enter key
	 * @param driver
	 */
	public void passEnterkey(WebDriver driver){
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
}
