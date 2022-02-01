package Practice2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
@Test
public class SampleSc extends BaseClass {
	public void abc() throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./screenshot/"+".png");
		FileUtils.copyFile(srcfile, destfile);
	}
}
