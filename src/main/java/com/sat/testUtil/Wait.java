package com.sat.testUtil;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	static int TIME_OUT = 40;

	public static void untilPageLoadComplete(WebDriver driver) {
		untilPageLoadComplete(driver, TIME_OUT);
	}

	public static void untilPageLoadComplete(final WebDriver driver, int timeoutInSeconds) {
		until(driver, new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver d) {
				Boolean isPageLoaded = (Boolean) "complete"
						.equals(((JavascriptExecutor) driver).executeScript("return document.readyState"));
				if (!isPageLoaded)
					Log.debug("Document is loading");
				return isPageLoaded;
			}
		}, timeoutInSeconds);
	}

	public static void waitUntilElementVisible(WebDriver waitdriver, WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(waitdriver, TIME_OUT);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition) {
		until(driver, waitCondition, TIME_OUT);
	}

	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, int timeoutInSeconds) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		try {
			webDriverWait.until(waitCondition);
		} catch (Exception e) {
			Log.debug("until, Exception Error message : " + e);
		}
	}

	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
		} catch (Exception e) {
			Log.debug("until, Exception Error message : " + e);
		}
	}

	public static void elementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
		try {
			new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			Log.debug("until, Exception Error message : " + e);
		}

	}
	
	public static void waitUntilElementVisibleList(WebDriver waitdriver, List<WebElement> webElement) {
		WebDriverWait wait = new WebDriverWait(waitdriver, TIME_OUT);
		wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
	}
	public static void waitForPresenceOfElementLocated(WebDriver driver, WebElement ele,int timeoutInSeconds) {
		try {
			new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.presenceOfElementLocated((By) ele));
		} catch (Exception e) {
			Log.debug("until, Exception Error message : " + e);
		}
	}
	public static void waitForInvisibilityOfElement(WebDriver driver, WebElement ele,int timeoutInSeconds) {
		try {
			new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.invisibilityOfAllElements(ele));
		} catch (Exception e) {
			Log.debug("until, Exception Error message : " + e);
		}
	}
	public static void waitForInvisibilityOfElementLocated(WebDriver driver, WebElement ele,int timeoutInSeconds) {
		try {
			new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.invisibilityOfElementLocated((By)ele));
		} catch (Exception e) {
			Log.debug("until, Exception Error message : " + e);
		}
	}
	public static void staleRefresh(WebDriver driver, WebElement ele, int timeoutInSeconds) {
		new WebDriverWait(driver,timeoutInSeconds ).until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(ele)));
	}
	public static void textToBePresent(WebDriver driver, WebElement ele, String str, int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.textToBePresentInElementValue(ele, str));
        } catch (Exception e) {
            Log.debug("until, Exception Error message : " + e);
        }
    }
	public static void scrollToView(WebDriver driver, WebElement ele) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	public static void waitForVisibilityOfElementLocated(WebDriver driver, WebElement ele,int timeoutInSeconds) {
		try {
			new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.visibilityOfElementLocated((By)ele));
		} catch (Exception e) {
			Log.debug("until, Exception Error message : " + e);
		}
	}
	

}