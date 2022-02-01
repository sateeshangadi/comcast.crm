package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddTocartTest {
	@Test(dataProvider="dpforaddtocart")
	
	public void addtocart(String pname,int qty,int size){
		System.out.println("order "+pname+" qunatity "+qty+" size "+size);
	}
   @DataProvider
   public Object[][] dpforaddtocart(){
	   Object[][] objarr=new Object[3][3];
	   objarr[0][0]="puma";
	   objarr[0][1]=5;
	   objarr[0][2]=8;
	   
	   objarr[1][0]="nike";
	   objarr[1][1]=6;
	   objarr[1][2]=9;
	   
	   objarr[2][0]="adidas";
	   objarr[2][1]=10;
	   objarr[2][2]=10;
	   return objarr;
   }
}
