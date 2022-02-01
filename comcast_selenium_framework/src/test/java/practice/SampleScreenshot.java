package practice;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import com.crm.GenericLibrary.BaseClass;
@Listeners(com.crm.GenericLibrary.LisImpClass.class)
public class SampleScreenshot extends BaseClass{
	@Test
	public void abc(){
		System.out.println("======test start====");
		Assert.assertEquals(false, true);
		System.out.println("=====test ends====");
	}


}
