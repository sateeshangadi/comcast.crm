package com.crm.comcast.contactTest;

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
import com.crm.comcast.pomrepositorylib.ContactInfoPage;
import com.crm.comcast.pomrepositorylib.Contacts;
import com.crm.comcast.pomrepositorylib.CreateNewContacts;
import com.crm.comcast.pomrepositorylib.CreateNewOrganization;
import com.crm.comcast.pomrepositorylib.Home;
import com.crm.comcast.pomrepositorylib.Login;
import com.crm.comcast.pomrepositorylib.OrgInfo;
import com.crm.comcast.pomrepositorylib.Organizations;

public class CreatecontactTest extends BaseClass{
	@Test(groups="smokeTest")
	public  void createcontactTest() throws Throwable {
		
				
				//read the test data from excel
				String orgName = elib.getDataFromExcel("org", 1, 0)+" "+jlib.getRnadomNumber();
				String contactname = elib.getDataFromExcel("contact", 0, 0);
				
				
				//step3 navigate to org page
				Home hp=new Home(driver);
				hp.getOrganizationLink().click();
				
					//step4 navigate to create org page
					Organizations op=new Organizations(driver);
					op.getCreateOrgImg().click();
					
					//step5 create org
					CreateNewOrganization cp=new CreateNewOrganization(driver);
					cp.createOrg(orgName);
					
					OrgInfo oi=new OrgInfo(driver);
			       WebElement ele = oi.getOrgHeaderSucMsg();
			       wlib.waitForElementVisibility(driver, ele);
			       
					//step 6 navigate to contact page
					hp.getContactLink().click();
					
					//step 7 navigate to create contact page
					Contacts cc=new Contacts(driver);
					cc.getCreateContactImg().click();
					
					//step 8 create new contact
					CreateNewContacts cnp=new CreateNewContacts(driver);
					cnp.createContacts(contactname, orgName);
					
					//step 9 verify the contact name created
					ContactInfoPage ci=new ContactInfoPage(driver);
					String actLstname = ci.getOrgheadSucMsg().getText();
					if(actLstname.contains(contactname)){
						System.out.println(contactname+">>Tc is passed");
						}else{
							System.out.println("testcase is fail");
						}						
	}
	
	@Test(groups="regressionTest")
	public void createContactAssignToGroupTest() throws Throwable{
		String contactname = elib.getDataFromExcel("contact", 1, 0);
		Home hp=new Home(driver);
		//wlib.waitandClick(hp.getContactLink());
		hp.getContactLink().click();
		Contacts cs=new Contacts(driver);
		cs.getCreateContactImg().click();
		CreateNewContacts cc=new CreateNewContacts(driver);
		cc.createContactswithDD(contactname, "Support Group");
		ContactInfoPage cp=new ContactInfoPage(driver);
		String actcontmsg = cp.getOrgheadSucMsg().getText();
		if(actcontmsg.contains(contactname)){
			System.out.println(contactname+" sTestcase pass "+actcontmsg);
		}else{
			System.out.println("Testcase fail");
		
		}
	}

}
