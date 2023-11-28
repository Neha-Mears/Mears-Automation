package com.sat.testUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.testbase.TestBase;

public class Testutil extends TestBase {

	private WebDriver driver;

	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 40;
	public static long EXPLICIT_WAIT = 5000;

	public void switchToFrame(String frame) {
		driver.switchTo().frame(frame);
	}

	public void jsclick(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", ele);
	}

	public void selectOptionInDropDownUsingIteration(List<WebElement> dropDownOptions, String optionToBeSelected) {
		boolean isFound = false;
		for (WebElement option : dropDownOptions) {
			if (option.getText().equals(optionToBeSelected)) {
				option.click();
				isFound = true;
				break;
			}
		}
		if (!isFound)
			System.out.println("No matching option found.");
	}

	public void selectOptionUsingValue(WebDriver driver, String valueToBeSelected) {
		String customLoc = "//option[text()='" + valueToBeSelected + "']";
		driver.findElement(By.xpath(customLoc)).click();
	}

	public void actionMethodClick(WebDriver driver, WebElement elementtoclick) {
		Actions action = new Actions(driver);
		Wait.elementToBeClickable(driver, elementtoclick, 2);
		// Wait.waitUntilElementVisible(driver, elementtoclick);
		action.moveToElement(elementtoclick).click().build().perform();
	}

	public boolean isClickable(WebElement ele) {
		boolean flag = true;
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(ele));
			System.out.println("Element is clickable");
		} catch (Exception e) {
			System.out.println("Element isn't clickable");
			flag = false;
		}
		return flag;
	}

	/*
	 * public void switchTab() { //driver.get("http://yahoo.com");
	 * JavascriptExecutor we = ((JavascriptExecutor) driver);
	 * we.executeScript("window.open()"); ArrayList<String> tabs = new
	 * ArrayList<String>(driver.getWindowHandles());
	 * driver.switchTo().window(tabs.get(1)); driver.get("http://google.com");
	 * System.out.println("in new tab method"); } public void switchBackToOriginal()
	 * { driver.switchTo().defaultContent(); }
	 */

	public void validatesuccessmsg(WebDriver driver, List<WebElement> validationpath,List<WebElement> toastecontainer) {
		long startTime = System.currentTimeMillis();// fetch starting time
		System.out.println(startTime);
		boolean condition = true;
		while (condition && (System.currentTimeMillis() - startTime) < 60000) {
			driver.switchTo().defaultContent();
			System.out.println("finding toaste container");
			List<WebElement> toastContainerWE = toastecontainer;
			List<WebElement> val = validationpath;
			if(!toastContainerWE.isEmpty()) {
				System.out.println("found toaste container");
				System.out.println("success message" + val);
				if (!val.isEmpty()) {
					System.out.println("from test util - if block");
					Assert.assertTrue(val.size() != 0, "WebElement not found");
					condition = false;
					System.out.println("successfully validate");
				} else {
					System.out.println("validating else block - didn't found success message");
				}
				condition = false;
			}
		}
	//	driver.switchTo().frame("fullscreen-app-host");
	}

	public void openNewTab(WebDriver driver) {
		driver.get("http://yahoo.com");
		JavascriptExecutor we = ((JavascriptExecutor) driver);
		we.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("http://google.com");
		System.out.println("in new tab method");
	}

	public void switchToTabs() {
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		//  Now iterate using  Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				driver.close();
			}
		}
		// ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		// driver.switchTo().window(tabs2.get(1));
		// driver.close();
		// driver.switchTo().window(tabs2.get(0));
	}
	public void clickOnElement(WebDriver driver,WebElement ele) {
		try {
			if(isClickable(ele)) {
				ele.click();
			}
			else {
				actionMethodClick( driver, ele);
			}
		}
		catch (Exception e) {
			jsclick(driver,  ele);
		}
	}
	
	public void validatesuccessmsg(WebDriver driver, List<WebElement> validationpath) {
		long startTime = System.currentTimeMillis();// fetch starting time
		System.out.println(startTime);
		boolean condition = true;
		while (condition && (System.currentTimeMillis() - startTime) < 300000) {
			driver.switchTo().defaultContent();
			List<WebElement> val = validationpath;
			System.out.println("while " + val);
			if (!val.isEmpty()) {
				System.out.println("from test util - if block");
				Assert.assertTrue(val.size() != 0, "WebElement not found");
				condition = false;
				System.out.println("successfully validate");
			} else {
				System.out.println("validating else block");
			}
		}
		driver.switchTo().frame("fullscreen-app-host");
	}
	// This method takes a WebDriver instance and return a screenshots as byte array
	public static byte[] takesscreenshot(WebDriver driver) {
		if (driver instanceof TakesScreenshot) {
			return((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		}else {
			throw new UnsupportedOperationException("WebDriver does not support taking screenshot");
		}
	}
}
