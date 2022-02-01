package com.crm.comcast.OrganizationTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.comcast.pomrepositorylib.CreateNewOrganization;
import com.crm.comcast.pomrepositorylib.Home;
import com.crm.comcast.pomrepositorylib.Login;
import com.crm.comcast.pomrepositorylib.OrgInfo;
import com.crm.comcast.pomrepositorylib.Organizations;

public class CreateOrginazationTest extends BaseClass {
	@Test(groups="smokeTest")
	public  void createOrginazationTest() throws Throwable {
		
	     
		String orgName = elib.getDataFromExcel("org", 1, 0)+" "+jlib.getRnadomNumber();
	
		Home hp=new Home(driver);
			hp.getOrganizationLink().click();
			
			Organizations op=new Organizations(driver);
					op.getCreateOrgImg().click();
			
					CreateNewOrganization cp=new CreateNewOrganization(driver);
					cp.createOrg(orgName);
					
					OrgInfo oo=new OrgInfo(driver);
					wlib.waitForElementVisibility(driver, oo.getOrgHeaderSucMsg());
					String actual = oo.getOrgHeaderSucMsg().getText();
					if(actual.contains(orgName)){
						System.out.println("orginazation created successfully");
					}else{
						System.out.println("orginazation created  not successfull");
					}					
	}
	@Test(groups="regressionTest")
  	public void searchOrgwithPhonenoTest(){
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();
		
		Organizations op=new Organizations(driver);
	wlib.select(op.getContentsDD(), "Phone");
		op.getSearchmainBtn().click();
		System.out.println("====phone number gor selected from dropdown ");		
			
	}

}
