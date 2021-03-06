package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {
	public Contacts(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactImg;
	
	
	public WebElement getCreateContactImg() {
		return createContactImg;
	}

}
