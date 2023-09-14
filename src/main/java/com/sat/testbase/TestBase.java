package com.sat.testbase;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sat.testUtil.Testutil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/sat/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebDriver initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			//WebDriverManager.chromedriver().setup();
			// tldriver.set(new ChromeDriver());
			//ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless", "--window-size=1920,1080");
			// driver.manage().window().maximize();
			//options.addArguments("--start-maximized");
			//options.addArguments("Zoom 75%");
			// WebDriver driver = new ChromeDriver(options);
			//tldriver.set(new ChromeDriver(options));
			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			//String Zoom =  "document.body.style.zoom ='50%'";
			//jse.executeScript(Zoom);

			// System.setProperty("webdriver.chrome.driver",
			// "src/test/resources/com.sat.Drivers/chromedriver.exe");
			
			
			WebDriverManager.chromedriver().setup();
			//WebDriver driver = new ChromeDriver();
			//DriverFactory
			//driver.manage().window();
			//Dimension size = new Dimension((int)(driver.manage().window().getSize().getWidth()*0.75), (int)(driver.manage().window().getSize().getHeight()*0.75));
			//JavascriptExecutor executor = (JavascriptExecutor)driver;
			//executor.executeScript("document.body.style.zoom = '1.5'");
			//tldriver.set(driver.manage().window().setSize(size);)
			DesiredCapabilities caps = new DesiredCapabilities();
			//caps.setAcceptInsecureCerts(true);
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.merge(caps);
			WebDriverManager.chromedriver().setup();
		   tldriver.set(new ChromeDriver(options));
			
			
			
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {

		return tldriver.get();
	}

}
