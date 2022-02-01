package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	public Organizations(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindAll({@FindBy(xpath="//img[@title='Create Organization...']"),@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")})
	private WebElement createOrgImg;
	
	@FindBy(name="search_text")
	private WebElement searchTxtEdt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	
	@FindBy(name="submit")
	private WebElement searchmainBtn;
	
	public WebElement getSearchmainBtn() {
		return searchmainBtn;
	}
	@FindBy(id="bas_searchfield")
	WebElement contentsDD;
	
	public WebElement getContentsDD() {
		return contentsDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchTxtEdt() {
		return searchTxtEdt;
	}

	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}

}
