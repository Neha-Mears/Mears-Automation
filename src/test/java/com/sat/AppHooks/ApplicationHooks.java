package com.sat.AppHooks;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sat.testbase.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private TestBase driverFactory;
	private WebDriver driver;
	Properties prop;
	
	@Before(order=1)
	public void launchbrowser()
	{
		driverFactory=new TestBase();
		driver=driverFactory.initialization();
		
	}

	@After(order=0)
	public void QuitBrowser() 
	{
       //driver.quit();
	}
	
	@After(order=1)
	public void teardown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenshotname=scenario.getName().replaceAll(" ","_");
			byte[] sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotname);
			}
	}

}
