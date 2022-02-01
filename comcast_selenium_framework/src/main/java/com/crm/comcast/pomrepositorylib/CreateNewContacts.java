package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateNewContacts extends WebDriverUtility {
	WebDriver driver;
	public CreateNewContacts(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgLookupImg;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T' ]")
	private WebElement grpRadiobtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement assigToDD;

	public WebElement getAssigToDD() {
		return assigToDD;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgLookupImg() {
		return orgLookupImg;
	}
	public void createContacts(String contactLastname,String orgName){
		lastNameEdt.sendKeys(contactLastname);
		orgLookupImg.click();
		switchToWindow(driver,"Accounts&action");
		Organizations op=new Organizations(driver);
		op.getSearchTxtEdt().sendKeys(orgName);
		op.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
	}
	public void createContactswithDD(String contactLastname,String visibletext ){
		lastNameEdt.sendKeys(contactLastname);
		grpRadiobtn.click();
		waitForElementVisibility(driver, assigToDD);
		select(assigToDD, visibletext);
		saveBtn.click();
	}

	public WebElement getGrpRadiobtn() {
		return grpRadiobtn;
	}
}
