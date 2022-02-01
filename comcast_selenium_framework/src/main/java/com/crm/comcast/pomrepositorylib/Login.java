package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login { //Rule1 create separate class for every page in the application
	public Login(WebDriver driver){
		PageFactory.initElements(driver,this); //Rule3 Execute all the elements and initialize the elements Pagefactory.initelements[initilization]
	}
	@FindBy(name="user_name")
	private WebElement userNameEdt;     // Rule2 Identify all the elements using @findby, @findbys, @findall[Declaration]
	
     @FindBy(name="user_password")
     private WebElement userPasswordEdt;
     
     @FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@id='submitButton']")})
     private WebElement loginBtn;
     //Declare all the members as private and provide getters method,business method for utilization

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void logintoApp(String userName,String password){
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
	}
}
