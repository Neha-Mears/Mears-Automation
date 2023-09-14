package com.sat.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;

public class BookingAppLoginPage {
	private WebDriver driver;

	@FindBy(xpath = "//*[@name='loginfmt']")
	private WebElement UserName;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement NextButton;

	@FindBy(xpath = "//*[@type='password']")
	private WebElement Password;

	@FindBy(xpath = "//*[@id='idSIButton9']") // *[@type='submit']
	private WebElement Signin;

	@FindBy(xpath = "//*[@name='DontShowAgain']")
	private WebElement DontShowAgain;

	@FindBy(xpath = "//*[@id='idSIButton9']")
	private WebElement Yes;
	
	Testutil testutil = new Testutil();
	
	public BookingAppLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//enter user name in the booking app or admin tool app
	public void EnterUserName(String userId) {
		UserName.click();
		UserName.sendKeys(userId);
		//NextButton.click();
		testutil.actionMethodClick(driver, NextButton);
	}
	// enter password in the password entry field
	public void EnterPassword(String userPassword) {
		Wait.untilPageLoadComplete(driver, 5);
		Wait.elementToBeClickable(driver, Password, 5);
		Password.click();
		Password.sendKeys(userPassword);
		Wait.elementToBeClickable(driver, Signin, 5);
		Wait.untilPageLoadComplete(driver, 5);
		Wait.waitUntilElementVisible(driver, Signin);
		Wait.elementToBeClickable(driver, Signin, 5);
		//Signin.click();
		testutil.actionMethodClick(driver, Signin);
		// Wait.waitUntilElementVisible(driver, DontShowAgain);
		// DontShowAgain.click();
		// Yes.click();
		System.out.println("logged in");
		Wait.untilPageLoadComplete(driver);
		driver.switchTo().frame("fullscreen-app-host");
	}
	//switching to the frame 
	public void switchToFrame() {
		driver.switchTo().frame("fullscreen-app-host");
	}

}