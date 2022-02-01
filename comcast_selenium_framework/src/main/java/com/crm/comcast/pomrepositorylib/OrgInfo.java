package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfo {
	public OrgInfo(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
   @FindBy(xpath="//span[@class='dvHeaderText']")
   private WebElement OrgHeaderSucMsg;
   
public WebElement getOrgHeaderSucMsg() {
	return OrgHeaderSucMsg;
}
}
