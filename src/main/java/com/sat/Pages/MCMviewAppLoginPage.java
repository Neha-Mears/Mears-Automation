package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.Assertions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;



public class MCMviewAppLoginPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//*[text()='click here.']")
	private WebElement Click_here;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement UserName;
	
	@FindBy(xpath = "//input[@id='input_1']")
	private WebElement HomeUserName;
	
	@FindBy(xpath = "//*[@id='input_2']")
	private WebElement HomePassword;
	@FindBy(xpath = "//*[@value='Sign In']") 
	private WebElement Sign_In;

	@FindBy(xpath = "//*[@id='Password']")
	private WebElement Password;

	@FindBy(xpath = "//*[@value='Log In']") 
	private WebElement Login;
	
	@FindBy(xpath = "//*[@class='mears-logo']") 
	private WebElement MearsLogo;
	@FindBy(xpath = "//*[contains(@id,'mainMenuButton')]") 
	private WebElement MainMenuexpbtn;
	
	@FindBy(xpath = "//*[@id='mat-input-1']") 
	private WebElement Aggravatingtxt;
	
	@FindBy(xpath = "//*[@id='mat-input-3']") 
	private WebElement Incidenttxt;
	
	@FindBy(xpath = "//button[@id='add-edit-risk-assessment-form__save-button']") 
	private WebElement addriskassSavebtn;
	
	
	@FindBy(xpath = "//span[normalize-space()='Save']") 
	private WebElement Savebtn;
	@FindBy(xpath = "//span[normalize-space()='Cancel']") 
	private WebElement Cancelbtn;
	
	@FindBy(xpath = "(//*[starts-with(@class,'mat-icon notranslate mat-icon-no-color ng-star-inserted')])[1]") 
	private WebElement EditIconbtn;
	@FindBy(xpath = "(//*[starts-with(@class,'mat-icon notranslate mat-icon-no-color ng-star-inserted')])[last()]") 
	private WebElement plusIconbtn;
	
	@FindBy(xpath = "//*[@aria-label='Open calendar']") 
	private WebElement gettingDate;
	
	@FindBy(xpath = "//*[@aria-label='Next month']") 
	private WebElement calenderNextDate;
	
	@FindBy(xpath = "//*[@class='notification__body--success']") 
	private List<WebElement> usertoastmsg;
	
	@FindBy(xpath = "//*[@class='notification__body--success']") 
	private List<WebElement> toastercontainer;
	
	@FindBy(xpath = "//*[contains(text(),'Vulnerability Flags')]") 
	private List<WebElement>  warningmsg;
	
	@FindBy(xpath = "//*[contains(text(),'Tenancy Warnings ')]") 
	private List<WebElement>  toastwarningmsg;
	
	@FindBy(xpath = "//*[@id='mat-expansion-panel-header-2']//*[text()=' Risk Details ']") 
	private WebElement RiskDetail;
	
	@FindBy(xpath = "//*[@class='risks-list__column']") 
	private WebElement Demotest;
	
	@FindBy(xpath = "((//*[@class='mat-table cdk-table mat-sort mears-table'])[1]//*[@data-mat-icon-name='more_vert'])[1]") 
	private WebElement threedotsserviceuser;
	
	//@FindBy(xpath = "//*[starts-with(@class,'cdk-overlay-pane')]//*[starts-with(@class,'drop-box')]") 
	@FindBy(xpath = "//span[@class='noborder']") 
	private WebElement uploadDocument;
	
	@FindBy(xpath = "//*[starts-with(@class,'cdk-overlay-pane')]//*[contains(text(),'Tenancy Warnings ')]") 
	private WebElement warningpopupwindow;
	
	Testutil testutil = new Testutil();
	Wait waits = new Wait();
	Testutil util = new Testutil();
    Assertions assertion = new Assertions(driver);

    private static String randomstr;
	public MCMviewAppLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	
	//enter user name in the booking app or admin tool app
	public void EnterUserName(String userId) {
		UserName.click();
		UserName.sendKeys(userId);
		
	}
	public void HomeUserName(String userId) {
		Click_here.click();
		HomeUserName.click();
		HomeUserName.sendKeys(userId);
	}
	public void HomePassword(String userPassword) {
		Wait.untilPageLoadComplete(driver, 1);
		//Wait.elementToBeClickable(driver, Password, 5);
		HomePassword.click();
		HomePassword.sendKeys(userPassword);
		Wait.elementToBeClickable(driver, Sign_In, 2);
		Wait.untilPageLoadComplete(driver, 5);
		Wait.waitUntilElementVisible(driver, Sign_In);
		Wait.elementToBeClickable(driver, Sign_In, 2);
		//Signin.click();
		testutil.actionMethodClick(driver, Sign_In);
		// Wait.waitUntilElementVisible(driver, DontShowAgain);
		// DontShowAgain.click();
		// Yes.click();
		System.out.println("logged in");
		Wait.untilPageLoadComplete(driver);
	}
	// enter password in the password entry field
	public void EnterPassword(String userPassword) {
		Wait.untilPageLoadComplete(driver, 5);
		Wait.elementToBeClickable(driver, Password, 5);
		Password.click();
		Password.sendKeys(userPassword);
	}
	
	public void User_login_MCMview(String userid,String pwd)
	{
		//UserName.click();
		UserName.sendKeys(userid);
		Password.sendKeys(pwd);
	}
	
	public void ClickOnLogIn()
	{
		Login.click();
		System.out.println("logged in");
		Wait.untilPageLoadComplete(driver);
		

	}
	public void ClickOnMearLogo()
	{   
		Wait.untilPageLoadComplete(driver);
		 try {
				
			 MearsLogo.click();
			}catch(Exception e) {
				util.actionMethodClick(driver, MearsLogo);
			}
		System.out.println("Clicked On Mears Logo in Home Page");
		
		

	}
	public void MainMenuExpansionbtn()
	{
		Wait.untilPageLoadComplete(driver);
		//MainMenuexpbtn.click();
		
		System.out.println("clicked on Main Menu Expansion Button");
		 Wait.elementToBeClickable(driver, MainMenuexpbtn, 2);
		 try {
			
			 MainMenuexpbtn.click();
			}catch(Exception e) {
				util.actionMethodClick(driver, MainMenuexpbtn);
			}
	}
	
	public void validateRedTriangle()
	{
		WebElement svgWarningIcon=null;
		try {
		 svgWarningIcon = driver.findElement(By.xpath("//*[starts-with(@class,'tenancy-summary-panel__wrapper')]//*[contains(@svgicon,'warning')]"));
		}
		catch(org.openqa.selenium.NoSuchElementException e){
			System.out.println("SVG warning Icon is not visible");
		}
		if(svgWarningIcon!=null)
		{
		boolean isIconVisible= svgWarningIcon.isDisplayed();
		System.out.println(isIconVisible);
		if(isIconVisible)
		{
			System.out.println("SVG warning Icon is visible");
		}
		else {
			System.out.println("SVG warning Icon is not visible");
		}
		}
	}
	//switching to the frame 
	public void switchToFrame() {
		driver.switchTo().frame("fullscreen-app-host");
	}
	public void switchTab() {
		// driver.get("http://yahoo.com");
		JavascriptExecutor we = ((JavascriptExecutor) driver);
		we.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		// driver.close();
		// driver.get("http://google.com");
		// System.out.println("in new tab method");

	}
	
	public void click_navapp(String navname)
	{
		Boolean flag = false;
		while (!flag) {
			List<WebElement> Service = driver.findElements(By.xpath("//*[contains(text(),'" + navname + "')]"));
			System.out.println(Service.size());
			//System.out.println(Service);
			if(Service.size() != 0) {
				for (int i = 0; i < Service.size(); i++){
					if (isClickable(Service.get(i))) {
						testutil.actionMethodClick(driver, Service.get(i));
						//testutil.jsclick(driver, Service.get(i));
						flag = true;
						i = Service.size();
					}
					else {
						System.out.println("element is not clickable so executing else");
					}
				}
				}
			}		
	}
	
	public void ClickAllService(String Option, String value) {
		Wait.untilPageLoadComplete(driver,1000);
		//Wait.elementToBeClickable(driver, driver.findElement(By.xpath("//*[contains(text(),'" + Option + "')]")), 0);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(By.xpath("//*[contains(text(),'" + Option + "')]"));
			System.out.println(ele.size());
			//System.out.println(ele);
			if(ele.size() != 0) {
				for (int i = 0; i < ele.size(); i++){
					if (isClickable(ele.get(i))) {
						testutil.actionMethodClick(driver, ele.get(i));
						//testutil.jsclick(driver, ele.get(i));
						flag = true;
						i = ele.size();
					}
					else {
						System.out.println("element is not clickable so executing else");
					}
				}
				}
			String actualtext=value;
			String expectedtxt = driver.findElement(By.xpath("//*[contains(text(),'" + value + "')]")).getText();
			if(actualtext.contains(expectedtxt)) {
				System.out.println("Text valiadtion successful. The expected text is present");
			}
			else {
				System.out.println("Text valiadtion failed. The expected text is not present");
			}
			}		
	}
	
	
	public void Clickthesite(String value) {
		Wait.untilPageLoadComplete(driver,1000);
		WebElement dropdownsite = driver.findElement(By.xpath("//*[starts-with(@class,'mat-select ng-tns')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownsite );
		dropdownsite.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Wait.elementToBeClickable(driver, dropdownsite, 2);
		testutil.actionMethodClick(driver, dropdownsite);
		//Wait.elementToBeClickable(driver, driver.findElement(By.xpath("//*[contains(text(),'" + Option + "')]")), 0);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(By.xpath("//*[starts-with(@class,'cdk-overlay-pane')]//*[contains(text(),'" + value + "')]"));
			System.out.println(ele.size());
			if(ele.size() != 0) {
				for (int i = 0; i < ele.size(); i++){
					if (isClickable(ele.get(i))) {
						testutil.actionMethodClick(driver, ele.get(i));
						//testutil.jsclick(driver, ele.get(i));
						flag = true;
						i = ele.size();
					}
					else {
						System.out.println("element is not clickable so executing else");
					}
				}
			}
		}
				}
	
	
	public void AddCommunication() throws InterruptedException {
		Wait.untilPageLoadComplete(driver,1000);
		//Wait.elementToBeClickable(driver, driver.findElement(By.xpath("//*[contains(text(),'" + Option + "')]")), 0);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(By.xpath("//*[contains(text(),'Add Communication')]"));
			if(ele.size() != 0) {
				for (int i = 0; i < ele.size(); i++){
					if (isClickable(ele.get(i))) {
						testutil.actionMethodClick(driver, ele.get(i));
						//testutil.jsclick(driver, ele.get(i));
						flag = true;
						i = ele.size();
					}
					else {
						System.out.println("element is not clickable so executing else");
					}
				}
				//////////////////Type Dropdown///////////////////////////////////
		WebElement dropdownservice = driver.findElement(By.xpath("//*[contains(@data-placeholder,'Type') or contains(@placeholder,'Type')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownservice );
		dropdownservice.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Wait.elementToBeClickable(driver, dropdownservice, 2);
		testutil.actionMethodClick(driver, dropdownservice);
		//////select the value of dropdown email1////////////////////////
		Wait.untilPageLoadComplete(driver,200);
		Boolean flag1 = false;
		while (!flag1) {
			List<WebElement> dropvalues = driver.findElements(By.xpath("//*[starts-with(@class,'mat')]//*[contains(text(),'Email1')]"));
			for (int i = 0; i < dropvalues.size(); i++) {

				if (isClickable(dropvalues.get(i))) {
					System.out.println("click on save");
					// ele.get(i).click();
					// testutil.jsclick(driver,ele.get(i));
					util.actionMethodClick(driver, dropvalues.get(i));
					System.out.println("clicked on save");
					flag1 = true;
					i = dropvalues.size();
		
	}
			}
		
		}
	////////////////////////////////////////emailtxtbox//////////////////////////
		try {
			//System.out.println("Field : " + field );
			//System.out.println("Value : " + field );
			WebElement txtval = driver.findElement(By.xpath("//*[contains(text(),'Detail')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",txtval );
			System.out.println(txtval.getText());
			WebElement txt1 = driver.findElement(By.xpath("//*[@data-placeholder='Detail']"));
			txt1.sendKeys(Keys.CONTROL + "a");
			txt1.sendKeys(Keys.DELETE);
			txt1.click();
			txt1.sendKeys("Scotland@gmail.com");
			}
		  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
		}
	//click on save////////////////////////
		WebElement savecom = driver.findElement(By.xpath("(//span[normalize-space()='Save'])[2]"));
		 try {
			  //  Savebtn.click();
				util.actionMethodClick(driver, savecom);
			}catch(Exception e) {
				testutil.jsclick(driver, savecom);
				// Savebtn.click();
			}

	}
	public void ClickAddressname(String name) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-placeholder='enter any part of an address']")).sendKeys(name,Keys.ENTER);
		WebElement we = driver.findElement(By.xpath("//*[contains(text(),'"+name+"')]"));
		Wait.elementToBeClickable(driver, we, 3);
		//testutil.jsclick(driver, we);
		util.actionMethodClick(driver, we);
		//Actions actions = new Actions(driver);
		//actions.doubleClick(we).perform();
	}
	public void ClickAddressnamenewVerion(String partaddress,String name) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-placeholder='enter any part of an address']")).sendKeys(partaddress,Keys.ENTER);
		WebElement we = driver.findElement(By.xpath("(//*[contains(text(),'"+name+"')])[1]"));
		Wait.elementToBeClickable(driver, we, 3);
		//testutil.jsclick(driver, we);
		//util.actionMethodClick(driver, we);
		try {
			   Wait.elementToBeClickable(driver, we, 3);
				util.actionMethodClick(driver, we);
			}catch(Exception e) {
				testutil.jsclick(driver, we);
				// Savebtn.click();
			}
		//Actions actions = new Actions(driver);
		//actions.doubleClick(we).perform();
	}
	
	public void ClickOnRedWarningButton() throws InterruptedException {
		Thread.sleep(1000);
		WebElement redbtn = driver.findElement(By.xpath("//*[starts-with(@class,'tenancy-summary-panel__wrapper')]//*[@data-mat-icon-name='warning']"));
		Wait.elementToBeClickable(driver, redbtn, 3);
		//testutil.jsclick(driver, redbtn);
		util.actionMethodClick(driver, redbtn);
	}
	public void validatefieldCommunication( ) throws InterruptedException {
		/*
		WebElement savebtn = driver.findElement(By.xpath("(//span[normalize-space()='Save'])[2]"));
		 try {
			  //  Savebtn.click();
				util.actionMethodClick(driver, savebtn);
			}catch(Exception e) {
				testutil.jsclick(driver, savebtn);
				// Savebtn.click();
			}
			*/
		WebElement expansionbtn = driver.findElement(By.xpath("//*[starts-with(@class,'mat-icon notranslate mat-menu')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",expansionbtn );
		Wait.elementToBeClickable(driver, expansionbtn, 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		util.actionMethodClick(driver, expansionbtn);
	try {
		WebElement addbtn = driver.findElement(By.xpath("//*[contains(text(),'Add Communication')]"));
		WebElement editdbtn = driver.findElement(By.xpath("(//*[starts-with(@class,'mat-cell ')]//*[starts-with(@class,'mat-focus-indicator')])[1]"));
		WebElement deletebtn = driver.findElement(By.xpath("(//*[starts-with(@class,'mat-cell cdk-cell mears-table__cell cdk-column-delete mat-column-delete')]//*[starts-with(@class,'mat-focus-indicator')])[1]"));
	
		boolean isAddBtnPresent=addbtn.isDisplayed();
		boolean isEditBtnPresent=editdbtn.isDisplayed();
		boolean isDeleteBtnPresent=deletebtn.isDisplayed();
		//perform assertion to validate the presence
		if(isAddBtnPresent && isEditBtnPresent && isDeleteBtnPresent )
		{
			System.out.println("add edit and delete  buttons are present");
		}
		else
		{
			System.out.println("add edit and delete buttons are not present");
		}
	}catch(NoSuchElementException e)
	{
		System.err.println("Error: Delete and/or Edit button is not present, While Add button is present");
		System.err.println("It can be reported as bug");
	}
	}
	public void validatecommunicationmsg(String msg ) throws InterruptedException 
		{
		
		// try {
			 
			// Thread.sleep(1000);
			// WebElement noCommunicationMsg = driver.findElement(By.xpath("//*[starts-with(@class,'communications-detail-list__container')]//*[contains(text(),'-- No communication details found --')]"));
			//String textmsg= noCommunicationMsg.getText();
			//if(noCommunicationMsg.isDisplayed() && noCommunicationMsg.getText().contains(msg)) {
			// System.out.println(textmsg+ " is present");	
			//Assert.assertTrue(textmsg.contains(msg),"status is same");
			// if msg found click on expansion button
			WebElement expansionbtn = driver.findElement(By.xpath("//*[starts-with(@class,'mat-icon notranslate mat-menu')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",expansionbtn );
			Wait.elementToBeClickable(driver, expansionbtn, 2);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			util.actionMethodClick(driver, expansionbtn);
		
		 
		 
		
		}
	public void validatecommunicatiotest(String msg ) throws InterruptedException 
	{
	
	 try {
		 WebElement noCommunicationMsg = driver.findElement(By.xpath("//*[starts-with(@class,'communications-detail-list__container')]//*[contains(text(),'-- No communication details found --')]"));
			String textmsg= noCommunicationMsg.getText();
		if(noCommunicationMsg.isDisplayed()) {
			System.out.println("No communication details found. Adding new communication....");
			validatecommunicationmsg(msg);
			AddCommunication();
			validatefieldCommunication();
			
		}
	
	 }
	 catch(Exception e) {
			System.out.println("Communication details are present");	
			validatefieldCommunication();
		}
		}
		
	
	
	public void ValidateWarningMsg() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait= new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.visibilityOf(warningpopupwindow));
		String expectedtxt= toastwarningmsg.get(0).getText();
		String actualtxt="Tenancy Warnings";
	
		//testutil.validatesuccessmsg(driver, warningmsg,toastwarningmsg);
		try {
		Assert.assertTrue(expectedtxt.contains(actualtxt),"status is same");
		}  
		catch(Exception e) {
			Assert.assertTrue(expectedtxt.contains(actualtxt),"Status is not same");	
		}
	//	driver.findElement(By.xpath("//*[contains(@svgicon,'close')]")).click();
		driver.findElement(By.xpath("//*[starts-with(@class,'mat-icon notranslate close')]")).click();
	}
	public void Scroll_down_to_click_delete(String btn) throws InterruptedException {
		Thread.sleep(1000);
		try {
			Wait.untilPageLoadComplete(driver);
			driver.findElement(By.xpath("//*[text()='"+btn+"']")).click();
			  Wait.untilPageLoadComplete(driver,200);
		        driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);
		    }catch(Exception e) {};
		        
		
		WebElement deletebtn = driver.findElement(By.xpath("(//*[@svgicon='delete'])[1]"));
		Wait.elementToBeClickable(driver, deletebtn, 3);
		testutil.jsclick(driver, deletebtn);
	}
	public void scrolldown() {
		try {
			Wait.untilPageLoadComplete(driver);
			driver.findElement(By.xpath("//*[text()=' Service User Support ']")).click();
			  Wait.untilPageLoadComplete(driver,200);
		        driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);
		    }catch(Exception e) {};
		        }
		public void click_expansionpanel()
		{
			WebElement expansionbtn = driver.findElement(By.xpath("//*[starts-with(@class,'service-users-support-panel__wrapper')]//*[contains(@class,'mat-icon notranslate mat-menu-trigger plus')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",expansionbtn );
			Wait.elementToBeClickable(driver, expansionbtn, 2);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			util.actionMethodClick(driver, expansionbtn);
		}
		public void click_TenancyDetailexpamsionbtn()
		{
			WebElement expansionbtn = driver.findElement(By.xpath("//*[starts-with(@class,'tenancy-summary-panel__wrapper')]//*[contains(@class,'mat-icon notranslate mat-menu-trigger plus')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",expansionbtn );
			Wait.elementToBeClickable(driver, expansionbtn, 2);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			util.actionMethodClick(driver, expansionbtn);
		}
		public void click_EditServiceUserexpansionpanel()
		{
			WebElement expansionEditbtn = driver.findElement(By.xpath("//*[starts-with(@class,'service-user-panel__wrapper')]//*[starts-with(@class,'mat-icon notranslate mat-menu-trigger plus-icon mat-icon-no-color')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",expansionEditbtn );
			Wait.elementToBeClickable(driver, expansionEditbtn, 2);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			util.actionMethodClick(driver, expansionEditbtn);
		}
		public void click_ExpansionButtonAllUser(String option)
		{
			WebElement expansionEditbtn = driver.findElement(By.xpath("//*[starts-with(@class,'"+option+"')]//*[starts-with(@class,'mat-icon notranslate mat-menu-trigger plus-icon mat-icon-no-color')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",expansionEditbtn );
			Wait.elementToBeClickable(driver, expansionEditbtn, 2);
			try {
				Thread.sleep(5000);
				util.actionMethodClick(driver, expansionEditbtn);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				util.actionMethodClick(driver, expansionEditbtn);
				e.printStackTrace();
			}
			
		}
		public void click_AASCHM_panel(String option)
		{
			
			 try {
				 Thread.sleep(5000);
				// MCMviewAppLogin.scrolldown();
				 switch(option)
					{
					case "Service Users":
						WebElement expansionbtn = driver.findElement(By.xpath("//*[contains(@class,'expansion-panel__header-buttons service-users-panel__buttons ng-star-inserted') or contains(@class,'expansion-panel__header-buttons panel__buttons ng-tns')]"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",expansionbtn );
						Wait.elementToBeClickable(driver, expansionbtn, 2);
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						util.actionMethodClick(driver, expansionbtn);
						    break;
					case "Service User Support":
					    Thread.sleep(1000);
					    WebElement expansionSupportbtn = driver.findElement(By.xpath("//*[starts-with(@class,'service-users-support-panel__wrapper')]//*[contains(@class,'mat-icon notranslate mat-menu-trigger plus')]"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",expansionSupportbtn );
						Wait.elementToBeClickable(driver, expansionSupportbtn, 2);
						try {
							Thread.sleep(1000);
							util.actionMethodClick(driver, expansionSupportbtn);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							expansionSupportbtn.click();
							e.printStackTrace();
						}
						
					    break;
					case "RLAPMearEditServiceUser":
					    Thread.sleep(1000);
					
					    break;  
				
			 }
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		}
		public void click_LivingHO_expansionpanel()
		{
			WebElement expansionbtn = driver.findElement(By.xpath("//*[contains(@class,'mat-icon notranslate mat-menu-trigger plus-icon mat-icon-no-color ng-star-inserted')]"));
			//WebElement expansionbtn = driver.findElement(By.xpath("//div[contains(@class,'expansion-panel__header-buttons service-users-panel__buttons ng-star-inserted')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",expansionbtn );
			Wait.elementToBeClickable(driver, expansionbtn, 2);
			try {
				Thread.sleep(5000);
				util.actionMethodClick(driver, expansionbtn);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				util.actionMethodClick(driver, expansionbtn);
			}
		
		}
		public void click_CommunicationDetail_expansionpanel()
		{
			WebElement expansionbtn = driver.findElement(By.xpath("//*[contains(@class,'expansion-panel__header-buttons')]"));
			//WebElement expansionbtn = driver.findElement(By.xpath("//div[contains(@class,'expansion-panel__header-buttons service-users-panel__buttons ng-star-inserted')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",expansionbtn );
			Wait.elementToBeClickable(driver, expansionbtn, 2);
			try {
				Thread.sleep(5000);
				util.actionMethodClick(driver, expansionbtn);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				util.actionMethodClick(driver, expansionbtn);
			}
		
		}
		public void ApplicationDetailexpbtn()
		{
			WebElement ApplicationDetailexpbtn = driver.findElement(By.xpath("//*[starts-with(@title,'Application Details')]//*[starts-with(@class,'mat-icon notranslate mat-menu-trigger plus-icon mat-icon-no-color')]"));
			//WebElement expansionbtn = driver.findElement(By.xpath("//div[contains(@class,'expansion-panel__header-buttons service-users-panel__buttons ng-star-inserted')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ApplicationDetailexpbtn );
			Wait.elementToBeClickable(driver, ApplicationDetailexpbtn, 2);
			try {
				Thread.sleep(5000);
				util.actionMethodClick(driver, ApplicationDetailexpbtn);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				util.actionMethodClick(driver, ApplicationDetailexpbtn);
			}
		
		}
		public void click_expansionpaneltenancy()
		{
			WebElement expansionbtntenancy = driver.findElement(By.xpath("(//*[starts-with(@class,'mat-icon notranslate mat-menu')])[2]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",expansionbtntenancy );
			Wait.elementToBeClickable(driver, expansionbtntenancy, 2);
			try {
				Thread.sleep(5000);
				util.actionMethodClick(driver, expansionbtntenancy);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				util.actionMethodClick(driver, expansionbtntenancy);
				e.printStackTrace();
			}
			
		}
		public void click_expansionPropertyDetails()
		{
			WebElement expansionbtnproperty = driver.findElement(By.xpath("(//*[starts-with(@class,'expansion-panel__header-buttons')]//*[starts-with(@class,'mat-icon notranslate mat-menu-trigger plus-icon')])[last()]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",expansionbtnproperty );
			Wait.elementToBeClickable(driver, expansionbtnproperty, 2);
			try {
				Thread.sleep(1000);
				util.actionMethodClick(driver, expansionbtnproperty);
			} catch (InterruptedException e) {
				//util.actionMethodClick(driver, expansionbtnproperty);
				expansionbtnproperty.click();
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void click_threedotTenancy()
		{
			WebElement tenancythreedots = driver.findElement(By.xpath("(//*[starts-with(@class,'mat-icon notranslate mat-menu-trigger more_vert')])[1]"));
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",tenancythreedots );
			Wait.elementToBeClickable(driver, tenancythreedots, 2);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			util.actionMethodClick(driver, tenancythreedots);
		}
		public void click_Riskassesmentexpansionbtn()
		{
			WebElement riskexpbtn = driver.findElement(By.xpath("//*[contains(@class,'plus-icon mat-icon-no-color')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",riskexpbtn );
			Wait.elementToBeClickable(driver, riskexpbtn, 2);
			try {
				Thread.sleep(5000);
				util.actionMethodClick(driver, riskexpbtn);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				util.actionMethodClick(driver, riskexpbtn);
				e.printStackTrace();
			}
			
		}
		public void service_userexpansionbtn()
		{
			WebElement serviceuserbtn =driver.findElement(By.xpath("//div[contains(@class,'expansion-panel__header-buttons service-users-panel__buttons ng-star-inserted')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",serviceuserbtn );
			Wait.elementToBeClickable(driver, serviceuserbtn, 2);
			try {
				Thread.sleep(5000);
				util.actionMethodClick(driver, serviceuserbtn);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				util.actionMethodClick(driver, serviceuserbtn);
				e.printStackTrace();
			}
			
		}
		public void Incidentexpansionbtn()
		{
			WebElement serviceuserbtn =driver.findElement(By.xpath("//div[contains(@class,'expansion-panel__header-buttons ng-star-inserted')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",serviceuserbtn );
			Wait.elementToBeClickable(driver, serviceuserbtn, 2);
			try {
				Thread.sleep(5000);
				util.actionMethodClick(driver, serviceuserbtn);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				util.actionMethodClick(driver, serviceuserbtn);
				e.printStackTrace();
			}
			
		}
		
		public void click_Riskexpansionbtn()
		{
			WebElement riskexpbtn = driver.findElement(By.xpath("(//*[contains(@class,'plus-icon mat-icon-no-color')])[2]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",riskexpbtn );
			Wait.elementToBeClickable(driver, riskexpbtn, 2);
			try {
				Thread.sleep(5000);
				util.actionMethodClick(driver, riskexpbtn);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				util.actionMethodClick(driver, riskexpbtn);
				e.printStackTrace();
			}
			
			
		}
		public void Notesxpansionbtn()
		{
			WebElement notesbtn =driver.findElement(By.xpath("(//*[contains(@class,'expansion-panel__header-buttons ng-star-inserted')])[2]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",notesbtn );
			Wait.elementToBeClickable(driver, notesbtn, 2);
			
				try {
								Thread.sleep(1000);
								Wait.untilPageLoadComplete(driver,200);
								testutil.actionMethodClick(driver, notesbtn);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								testutil.jsclick(driver, notesbtn);
								e.printStackTrace();
							}

	
		}
		public void NoteDocumentsxpansionbtn()
		{
			WebElement notesbtn =driver.findElement(By.xpath("//*[contains(@class,'note-documents-list-panel__wrapper')]//*[contains(@class,'expansion-panel__header-buttons ng-star-inserted')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",notesbtn );
			Wait.elementToBeClickable(driver, notesbtn, 2);
			
				try {
								Thread.sleep(1000);
								Wait.untilPageLoadComplete(driver,200);
								testutil.actionMethodClick(driver, notesbtn);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								testutil.jsclick(driver, notesbtn);
								e.printStackTrace();
							}

	
		}

		public void validate_risk_ass_popuppage(DataTable datatable) throws InterruptedException
		{
			List<List<String>> actual = datatable.cells();
			List<String> expectedTexts = new ArrayList<>();
			expectedTexts.addAll(actual.get(0));
			 System.out.println(expectedTexts);
		 for(String exptext:expectedTexts) {
			 
			 WebElement element= driver.findElement(By.xpath("//*[contains(text(),'"+exptext+"') or contains(@title,'"+exptext+"')]"));
			 String actualtext =element.getText();
			 if (actualtext.contains(exptext))
			 {
				 System.out.println("Text Validation passed! The text ' "+exptext+"' is present on the page" );
			 }
			 else {
				 System.out.println("Text Validation failed! The text ' "+exptext+"' is not present on the page" );
			 }
		 }
		 System.out.println("Button  "+addriskassSavebtn.getText());
		 Thread.sleep(3000);
			if(addriskassSavebtn.isDisplayed()) {
				System.out.println("Save Button is present");
				addriskassSavebtn.click();
				testutil.actionMethodClick(driver, addriskassSavebtn);
				System.out.println("Clicked on the save button");
			}
				else {
					System.out.println("Save Button not present");
				}
			}
		
		public void Validate_risk_assessment_page(DataTable datatable)
		{
			List<List<String>> actual = datatable.cells();
			List<String> expectedTexts = new ArrayList<>();
			expectedTexts.addAll(actual.get(0));
			 System.out.println(expectedTexts);
			 for(String exptext:expectedTexts) {
				 
				 WebElement element= driver.findElement(By.xpath("//*[starts-with(@class,'risk-assessments-panel__wrapper')]//*[contains(text(),'"+exptext+"')]"));
				 String actualtext =element.getText();
				 if (actualtext.contains(exptext))
				 {
					 System.out.println("Text Validation passed! The text ' "+exptext+"' is present on the page" );
				 }
				
			 }
		
			 WebElement chkbox =driver.findElement(By.xpath("(//*[@class='mat-checkbox mat-accent mat-checkbox-checked'])[1]"));
			 if(chkbox.isEnabled()) {
				 System.out.println("Active dropdown is enabled");
			 }
				 else {
					 System.out.println("Active dropdown is disabled");
				 }
			 
			 WebElement addele =driver.findElement(By.xpath("(//*[@class='mat-cell cdk-cell mears-table__cell cdk-column-address mat-column-address ng-star-inserted'])[1]"));
			 String actualaddress =addele.getText();
			 System.out.println("Text Validation passed! The text under '"+expectedTexts.get(1)+"' is '"+actualaddress+"'  " );
			 WebElement date =driver.findElement(By.xpath("(//*[@class='mat-cell cdk-cell mears-table__cell cdk-column-createdOn mat-column-createdOn ng-star-inserted'])[1]"));
			 String actualdate =date.getText();
			
				 System.out.println("Text Validation passed! The text under '"+expectedTexts.get(2)+"' is '"+actualdate+"'  " );
			
				 
			
			 WebElement email =driver.findElement(By.xpath("(//*[@class='mat-cell cdk-cell mears-table__cell cdk-column-createdBy mat-column-createdBy ng-star-inserted'])[1]"));
			 String actualemail =email.getText();
			
				 System.out.println("Text Validation passed! The text under '"+expectedTexts.get(3)+"' is '"+actualemail+"'  " );
			 
				 
			
			 WebElement compon =driver.findElement(By.xpath("(//*[@class='mat-cell cdk-cell mears-table__cell cdk-column-completedOn mat-column-completedOn ng-star-inserted'])[1]"));
			 String actualcomplon =compon.getText();
			
				 System.out.println("Text Validation passed! Completed On '"+expectedTexts.get(4)+"' is '"+actualcomplon+"'  " );
			
				 
			 
			 WebElement compBy =driver.findElement(By.xpath("(//*[@class='mat-cell cdk-cell mears-table__cell cdk-column-completedBy mat-column-completedBy ng-star-inserted'])[1]"));
			 String actualcomplBy =compBy.getText();
			 
				 System.out.println("Text Validation passed! Completed By '"+expectedTexts.get(5)+"' is '"+actualcomplBy+"'  " );
			
			 }
			 
		public void selectAddNewRisk(String field, String value) throws InterruptedException{
			
			try {
				//System.out.println("Field : " + field );
				//System.out.println("Value : " + field );
				WebElement txtval = driver.findElement(By.xpath("//*[contains(text(),'" + field + "')]"));
				Wait.elementToBeClickable(driver, txtval, 5);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",txtval );
				System.out.println(txtval.getText());
				WebElement txt1 = driver.findElement(By.xpath("//*[@data-placeholder='"+field+"']"));
				Wait.elementToBeClickable(driver, txt1, 3);
				txt1.sendKeys(Keys.CONTROL + "a");
				txt1.sendKeys(Keys.DELETE);
				txt1.click();
				txt1.sendKeys(value);
				}
			  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
public void generatePasswordValue(String field, String value) throws InterruptedException{
			
			try {
				//System.out.println("Field : " + field );
				//System.out.println("Value : " + field );
					
					//////////////////////////////////////////
				WebElement txtval = driver.findElement(By.xpath("//*[contains(text(),'" + field + "')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",txtval );
				System.out.println(txtval.getText());
				WebElement txt1 = driver.findElement(By.xpath("//*[@data-placeholder='"+field+"']"));
				txt1.sendKeys(Keys.CONTROL + "a");
				txt1.sendKeys(Keys.DELETE);
				txt1.click();
				Faker faker = new Faker();
				String password = faker.regexify("[A-Za-z0-9]{8}");
				txt1.sendKeys(password);
				}
			  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
public void generateRandomtxt(String field, String value) throws InterruptedException{
	
	try {
		//System.out.println("Field : " + field );
		//System.out.println("Value : " + field );
			
			//////////////////////////////////////////
		WebElement txtval = driver.findElement(By.xpath("//*[contains(text(),'" + field + "')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",txtval );
		System.out.println(txtval.getText());
		WebElement txt1 = driver.findElement(By.xpath("//*[@data-placeholder='"+field+"']"));
		txt1.sendKeys(Keys.CONTROL + "a");
		txt1.sendKeys(Keys.DELETE);
		txt1.click();
		Faker faker = new Faker();
	 randomstr = faker.lorem().sentence();
		txt1.sendKeys(randomstr);
		}
	  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void ValidateKeyAsNotes(String Tab,String elementID) throws InterruptedException {
		
		
 	
 	boolean found=false;
 	String expectedval="Notes: "+ randomstr;
 	System.out.println("Random notes is in string: "+expectedval);
 		List<WebElement> cells = driver.findElements(By.xpath("//*[@title='"+Tab+"']//*[ contains(@class,'mat-cell cdk-cell cdk-column-notes mat-column-notes ng-star-inserted')]"));
 		System.out.println("Number of Row present in Table : "+cells.size());
 		for(int i=0;i<=cells.size()-1;i++)
 		{
 			Thread.sleep(7000);
 			//String actualtext=cells.get(i).getText();
 			
 			//System.out.println(actualtext);
 			if(cells.get(i).getText().equals(expectedval))
 			{
 				System.out.println("\u001B[32mNotes is added as .\u001B[0m "+expectedval);
 				System.out.println("\u001B[32mNotes is added at index .\u001B[0m "+cells.indexOf(cells.get(i).getText()));
 				List<WebElement> cellVal = driver.findElements(By.xpath("//*[@title='"+Tab+"']//*[ contains(@class,'mat-row cdk-row mears-table__data-row ng-star-inserted')]"));
				
				String cell1value= cellVal.get(i).getText();
				String[] substring = cell1value.split(" ");
 	
 			System.out.println("Date :"+substring[0]);
 			System.out.println("Key :"+substring[1]+substring[2]+substring[3]+substring[4]);
 			System.out.println("Who has key :"+substring[5]);
 			System.out.println("Booked Out By :"+substring[6]);
 		//System.out.println("Returned By :" +substring[8]);
 			  List<WebElement> checkboxes= driver.findElements(By.xpath("(//*[contains(@title,'"+Tab+"')]//*[contains(@class,'mat-checkbox-checked')])[last()]"));
 		    	if(!checkboxes.isEmpty())
 		    	{
 		    		System.out.println("\u001B[32mCheckbox is checked.\u001B[0m");
 		    		
 		    	}
 		    	else
 		    	{
 		    		System.out.println("\u001B[32mCheckbox is not checked.\u001B[0m");
 		    	}
 			}
 			else
 			{
 			//	System.out.println("\u001B[32mNotes is not added.\u001B[0m");
 			}
 		
 		}
 			}
 			
 		
		public void validate_message_in_textbox(String msg1,String msg2) throws InterruptedException
	
		{   Thread.sleep(2000);
			String Actual=msg1;
			String Expected=driver.findElement(By.xpath("//*[contains(text(),'"+msg1+"')]")).getText();
			System.out.println("Actual : " + msg1 );
			System.out.println("Expected : " + Expected );
			assertion.CheckAssertionTrue(Actual.contains(Expected), Expected);
			String Actual1=msg2;
			String Expected1=driver.findElement(By.xpath("//*[contains(text(),'"+msg2+"')]")).getText();
			System.out.println("Actual : " + msg2 );
			System.out.println("Expected : " + Expected1 );
			assertion.CheckAssertionTrue(Actual1.contains(Expected1), Expected1);
		}
		public void clickOnSave(String option)throws InterruptedException
		{   
			WebElement val = driver.findElement(By.xpath("//span[normalize-space()='"+option+"']"));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",val );
			 Boolean flag = false;
				while (!flag) {
					//*[contains(@svgicon,'edit')]
					List<WebElement> saveval = driver.findElements(By.xpath("//span[normalize-space()='"+option+"']"));
					for (int i = 0; i < saveval.size(); i++) {
						if (isClickable(saveval.get(i))) {
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",saveval.get(i) );
							//util.actionMethodClick(driver, saveval.get(i));
							 try {
								 saveval.get(i).click();
									//util.actionMethodClick(driver, Savebtn);
								}catch(Exception e) {
									testutil.jsclick(driver,  saveval.get(i));
									// Savebtn.click();
								}
							flag = true;
							i = saveval.size();
							
				System.out.println("User select option: Save");
				
			}
					}
				}
		}
		public void validate_lst_chkbox_isselected()throws InterruptedException
		{
			
			
			try {
				WebElement defaulttable=driver.findElement(By.xpath("(//*[@class='mat-table cdk-table mat-sort mears-table'])[1]"));
				List<WebElement> rows=defaulttable.findElements(By.xpath("//*[@class='mat-row cdk-row mears-table__data-row ng-star-inserted']"));
				//boolean isdatedisabled=fromDate.getAttribute("class").contains("disabled");
			   // boolean isNewRowChecked= false;
				for(WebElement row:rows)
			    {
			    	WebElement defaultchk=row.findElement(By.xpath("//*[contains(@class,'checked')]"));
			    	WebDriverWait wait=new WebDriverWait(driver,10);
			    	boolean isNewRowChecked=(Boolean)((JavascriptExecutor) driver).executeScript("return arguments[0].checked", defaultchk);
			    	System.out.println(isNewRowChecked);
			    	//System.out.println("Checkbox is"+defaultchk.isSelected());
			    	//System.out.println("Checkbox is"+defaultchk.isEnabled());
			    	//System.out.println("Checkbox is"+defaultchk.isDisplayed());
			    	if(isNewRowChecked)
			    	{
			    		System.out.println("Checkbox is selected in the row: " +row.getText());
			    	}
			    	else {
			    		System.out.println("Checkbox in other row unexpectly checked");
			    		break;
			    	}
			    	
			    }
			
			}catch(Exception e)
			{
				System.out.println("An error occured: " +e.getMessage());
			}
			
			
		}
		public void clickOntxt(String txtval)throws InterruptedException
		{
			WebElement txt=driver.findElement(By.xpath("//*[contains(text(),'"+txtval+"')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",txt );
			// testutil.jsclick(driver, Savebtn);
			
			 try {
				   // Savebtn.click();
					util.actionMethodClick(driver, txt);
				}catch(Exception e) {
					testutil.jsclick(driver, txt);
					// Savebtn.click();
				}

			 
		}
		public void deletetxtvalue(String txtval)throws InterruptedException
		{
			WebElement dropdownserviceuser = driver.findElement(By.xpath("//*[contains(@data-placeholder,'"+txtval+"') or contains(@placeholder,'"+txtval+"')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownserviceuser );
			dropdownserviceuser.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			WebElement txt=driver.findElement(By.xpath("//*[contains(text(),'"+txtval+"')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",txt );
			// testutil.jsclick(driver, Savebtn);
			
			 try {
				   // Savebtn.click();
					util.actionMethodClick(driver, txt);
				}catch(Exception e) {
					testutil.jsclick(driver, txt);
					// Savebtn.click();
				}

			/*
			WebElement txt1 = driver.findElement(By.xpath("//*[contains(@class,'mat-input-element mat-form-field-autofill')]"));
		System.out.println("Text value "+txt1.getText()) ;
		String value= txt1.getAttribute("value");
		int vallen=value.length();
		System.out.println("val length "+vallen) ;
		txt1.sendKeys(Keys.CONTROL,"a");
	//	txt1.sendKeys(Keys.DELETE);
		
	//Actions actions= new Actions(driver);
	//	actions.sendKeys(Keys.CONTROL,"a").perform();
	//	System.out.println("ctrl all") ;
	//	actions.sendKeys(Keys.DELETE).perform();
	//	System.out.println("Delete") ;
	//	WebElement txt = driver.findElement(By.xpath("//*[contains(text(),'" + txtval + "')]"));
	//	txt.click();
	//	actions.moveByOffset(300, 300).click().perform();
	//	System.out.println("click outside") ;
		//actions.sendKeys(Keys.BACK_SPACE);
		//txt1.sendKeys(Keys.DELETE);
		
		*/
		}
		public void deleteContent(String txtval)throws InterruptedException
		{
			WebElement txt=driver.findElement(By.xpath("//*[contains(text(),'"+txtval+"')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",txt );
			// testutil.jsclick(driver, Savebtn);
			
			 try {
				   // Savebtn.click();
					util.actionMethodClick(driver, txt);
				}catch(Exception e) {
					testutil.jsclick(driver, txt);
					// Savebtn.click();
				}

			 
		}
		public void clickOnCancel()throws InterruptedException
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Cancelbtn );
			// testutil.jsclick(driver, Savebtn);
			
			 try {
				  // Savebtn.click();
					util.actionMethodClick(driver, Cancelbtn);
				}catch(Exception e) {
					testutil.jsclick(driver, Cancelbtn);
					//Cancelbtn.click();
				}
			//span[normalize-space()='Close']
			// WebElement Closebtn = driver.findElement(By.xpath("//span[normalize-space()='Close']"));
			//	util.actionMethodClick(driver, Closebtn);
				
		}
		
		public void clickOnClose(String ExpectedStr)throws InterruptedException
		{
			 WebElement Closebtn = driver.findElement(By.xpath("//span[normalize-space()='Close']"));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Closebtn );
				util.actionMethodClick(driver, Closebtn);
				System.out.println("clicked on close button");
				//Alert alert = driver.switchTo().alert();
				String mainWindowHandle = driver.getWindowHandle();
				Set<String> windowHandles = driver.getWindowHandles();
				for(String Handle:windowHandles)
					if(!Handle.equals(mainWindowHandle))
				{
				 driver.switchTo().window(Handle)	;
				}
			
				 WebElement Msgbtn = driver.findElement(By.xpath("//*[starts-with(@class,'mat-dialog-content dialog-content')]//*[contains(text(),'"+ExpectedStr+"')]"));
				String popUpMessage= Msgbtn.getText();
				String[] parts=popUpMessage.split("Please");
				
				String ExpectedMessage=ExpectedStr;
				System.out.println("Text present Actual 1 "+ parts[0].trim());
				//System.out.println("Text present Actual 2 "+ parts[1]);	
				System.out.println("Text present Expected"+ ExpectedMessage);	
				
				if (parts[0].trim().equals(ExpectedMessage))
				{
					System.out.println("Pop Up Message Validation successfully");	
				}
				else {
					System.out.println("Pop Up Message Validation failed");
				}
		}
		public void deleteContentverifySavebtnEnable(String value)throws InterruptedException
		{
			
			WebElement txtdetails = driver.findElement(By.xpath("//*[@data-placeholder='"+value+"']"));
			//txtdetails.clear();
			txtdetails.sendKeys(Keys.CONTROL + "a");
			txtdetails.sendKeys(Keys.DELETE);
			System.out.println("The value got deleted for "+value);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Savebtn );
			// testutil.jsclick(driver, Savebtn);
			
			if(Savebtn.isEnabled() && Savebtn.isDisplayed()) {
				System.out.println("Save button is enable and clickable");
			}
			else {
				System.out.println("Save button is not enable or clickable");
			}

			 
		}
		public void clickOnEditIconRisk(String str)throws InterruptedException
		{
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",EditIconbtn );
			int maxRetries=3;
			int retryCount=0;
			boolean clicked=false;
			while(retryCount<maxRetries && !clicked)
			
			 try {
				// EditIconbtn.click();
				 Wait.elementToBeClickable(driver, EditIconbtn, 3);
					util.actionMethodClick(driver, EditIconbtn);
					//EditIconbtn.click();
					clicked=true;
				}catch(Exception e) {
					//util.actionMethodClick(driver, EditIconbtn);
					retryCount++;
					Thread.sleep(1000);
				//	EditIconbtn.click();
				}

			 System.out.println("Selected the edit button under: "+str +retryCount);
		}
		public void clickOnplusIconRisk(String str)throws InterruptedException
		{
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",plusIconbtn );
			int maxRetries=3;
			int retryCount=0;
			boolean clicked=false;
			while(retryCount<maxRetries && !clicked)
			
			 try {
				// EditIconbtn.click();
				 Wait.elementToBeClickable(driver, plusIconbtn, 3);
					util.actionMethodClick(driver, plusIconbtn);
					//EditIconbtn.click();
					clicked=true;
				}catch(Exception e) {
					//util.actionMethodClick(driver, EditIconbtn);
					retryCount++;
					Thread.sleep(1000);
				//	EditIconbtn.click();
				}

			 System.out.println("Selected the edit button under: "+str +retryCount);
		}
		public void selectSlotDate(String setMonth, String setYear, String setDate) {
			/*
			gettingDate.click();
			String month = driver.findElement(By.xpath("//*[@aria-label='Choose month and year']")).getText();
			if(!month.equals(setMonth))
			{
				calenderNextDate.click();
			}
		   WebElement date= driver.findElement(By.xpath("//div[contains(text(),'"+setDate+"')]"));
		   date.click();
		   */
			gettingDate.click();
			System.out.println("Select the year");
			driver.findElement(By.xpath("//*[@aria-label='Choose month and year']")).click();
			WebElement fromyear= driver.findElement(By.xpath("//*[starts-with(@class,'mat-calendar-body-cell-container ng-star-inserted')]//*[@aria-label='"+setYear+"']"));
			Wait.elementToBeClickable(driver, fromyear, 3);
			testutil.actionMethodClick(driver, fromyear);
			System.out.println("Select the month");
			WebElement frommonth= driver.findElement(By.xpath("//*[starts-with(@class,'mat-calendar-body-cell-container ng-star-inserted')]//*[@aria-label='"+setMonth+" "+setYear+"']"));
			Wait.elementToBeClickable(driver, frommonth, 3);
			testutil.actionMethodClick(driver, frommonth);
			WebElement fromDate= driver.findElement(By.xpath("//*[starts-with(@class,'mat-calendar-body-cell-container ng-star-inserted')]//*[@aria-label='"+setDate+" " +setMonth+" "+ setYear+"']"));
			System.out.println("Select the date");
			System.out.println("click on date "+fromDate.getText());
			    int SelectedDate = Integer.parseInt(setDate);
				Date currentdate = new Date();
				SimpleDateFormat formatter= new SimpleDateFormat("d");
				int currentday= Integer.parseInt(formatter.format(currentdate));
				String datetoBook = formatter.format(currentdate);
				System.out.println("The current date is "+currentday);
				
				if (SelectedDate >= currentday)
				{
					boolean isdatedisabled=fromDate.getAttribute("class").contains("disabled");
					if(isdatedisabled) {
						System.out.println("The selected date ' "+SelectedDate+"' is disabled and not clickable. ");	
						WebElement CurrentDate=driver.findElement(By.xpath("//*[starts-with(@class,'mat-calendar-body-cell-container ng-star-inserted')]//*[@aria-label='"+currentday+" " +setMonth+" "+ setYear+"']"));
						System.out.println("The selecting the current date");
					//	CurrentDate.click();
						testutil.actionMethodClick(driver, CurrentDate);
					}
					else {
						//fromDate.click();
						testutil.actionMethodClick(driver, fromDate);
						System.out.println("The selected date ' "+SelectedDate+"' is not enable and clickable. ");	
					}
						
					}
					else {
						System.out.println("The selected date fromDate' "+SelectedDate+"' is enable and clickable. ");	
						fromDate.click();
						//testutil.actionMethodClick(driver, fromDate);
					}
				
			
			}
			
		
		public void velidateMsgPop(String success_msg)
		{
			
			
			 util.validatesuccessmsg(driver,usertoastmsg,toastercontainer);
			 System.out.println("Successfully validated the toaster message-  " +success_msg);
		}
		
		public Boolean isFilterFieldDisplayed()throws InterruptedException
		{
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",RiskDetail );
				Boolean isFieldDisplayed=RiskDetail.isDisplayed();
				return isFieldDisplayed;
		}catch(Exception e) {
			return false;
		}
		}
			
		public Map<String,Boolean> isDataFieldDisplayed(DataTable data) throws ElementNotVisibleException {
			System.out.println("Clicking on Demotest" +Demotest.getText());
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Demotest );
			Wait.elementToBeClickable(driver, Demotest, 2);
			//Demotest.click();
			testutil.actionMethodClick(driver, Demotest);
			//util.jsclick(driver, Demotest);
			
			System.out.println("Clicked on Demotest");
			List<String> gridfieldName = data.asList();
			Map<String, Boolean> lstField = new HashMap<>();
			first: for (int i=0 ;i<=gridfieldName.size()-1;i++)
			{
				switch(gridfieldName.get(i))
				{
				case "Details:":
					 System.out.println(gridfieldName.get(i));
					 WebElement objDetails= driver.findElement(By.xpath("//span[contains(text(),'"+gridfieldName.get(i)+"')]"));
					 lstField.put(gridfieldName.get(i),objDetails.isDisplayed() );
					 continue first;
				case "Aggravating Factors:":
					 System.out.println(gridfieldName.get(i));
					 WebElement objAggravatingFactors= driver.findElement(By.xpath("//span[contains(text(),'"+gridfieldName.get(i)+"')]"));
					 lstField.put(gridfieldName.get(i),objAggravatingFactors.isDisplayed() );
					 continue first;
				case "Mitigating Factors:":
					 System.out.println(gridfieldName.get(i));
					 WebElement objMitigatingFactors= driver.findElement(By.xpath("//span[contains(text(),'"+gridfieldName.get(i)+"')]"));
					 lstField.put(gridfieldName.get(i),objMitigatingFactors.isDisplayed() );
					 continue first;
				case "Incidents:":
					 System.out.println(gridfieldName.get(i));
					 WebElement objIncidentsFactors= driver.findElement(By.xpath("//span[contains(text(),'"+gridfieldName.get(i)+"')]"));
					 lstField.put(gridfieldName.get(i),objIncidentsFactors.isDisplayed() );
					 continue first;
				case "Person at Risk:":
					 System.out.println(gridfieldName.get(i));
					 WebElement objPersonRiskFactors= driver.findElement(By.xpath("//span[contains(text(),'"+gridfieldName.get(i)+"')]"));
					 lstField.put(gridfieldName.get(i),objPersonRiskFactors.isDisplayed() );
					 continue first;
				case "Review Date:":
					 System.out.println(gridfieldName.get(i));
					 WebElement objreviewDate= driver.findElement(By.xpath("//span[contains(text(),'"+gridfieldName.get(i)+"')]"));
					 lstField.put(gridfieldName.get(i),objreviewDate.isDisplayed() );
					 continue first;
				case "Active:":
					 System.out.println(gridfieldName.get(i));
					 WebElement objActive= driver.findElement(By.xpath("//span[contains(text(),'"+gridfieldName.get(i)+"')]"));
					 lstField.put(gridfieldName.get(i),objActive.isDisplayed() );
					 continue first;
					default :
						lstField.put(gridfieldName.get(i), false);
						continue first;
				}
			}
			
		return lstField;
}
		public void clickServiceUserthreedots()
		{
			
				Wait.elementToBeClickable(driver, threedotsserviceuser, 3);
				//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",threedotsserviceuser );
				//testutil.actionMethodClick(driver, threedotsserviceuser);
				System.out.println("Successfully clicked in three dots-");
				 try {
					// threedotsserviceuser.click();
					 testutil.actionMethodClick(driver, threedotsserviceuser);
					}catch(Exception e) {
						testutil.jsclick(driver, threedotsserviceuser);
					}

		}
		public void clickDropDownList(String dropname) throws InterruptedException
		{
			WebElement dropdownserviceuser = driver.findElement(By.xpath("//*[contains(@data-placeholder,'"+dropname+"') or contains(@placeholder,'"+dropname+"')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownserviceuser );
			dropdownserviceuser.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			// materialField.clear();
			Wait.elementToBeClickable(driver, dropdownserviceuser, 2);
			testutil.actionMethodClick(driver, dropdownserviceuser);
		}
		public void clickUnderTab(String val,String dropname) throws InterruptedException
		{
			WebElement dropdownserviceuser = driver.findElement(By.xpath("//*[contains(@placeholder,'"+val+"') or contains(@formcontrolname,'"+val+"')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownserviceuser );
			dropdownserviceuser.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			// materialField.clear();
			Wait.elementToBeClickable(driver, dropdownserviceuser, 2);
			testutil.actionMethodClick(driver, dropdownserviceuser);
		}
		public void clickappointmentscreen() throws InterruptedException
		{
			WebElement dropdowappointmenteuser = driver.findElement(By.xpath("//*[starts-with(@class,'mat-select ng-tns')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdowappointmenteuser );
			dropdowappointmenteuser.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			// materialField.clear();
			Wait.elementToBeClickable(driver, dropdowappointmenteuser, 2);
			testutil.actionMethodClick(driver, dropdowappointmenteuser);
		}
		public void clickonOptionDropDown(String options) throws InterruptedException
		{
			
			Wait.untilPageLoadComplete(driver,2);
			//WebElement dropvalue=driver.findElement(By.xpath("//*[starts-with(@class,'mat-option mat-focus')]//*[contains(text(),'"+options+"')]"));
			//testutil.actionMethodClick(driver, dropvalue);
			Boolean flag = false;
			while (!flag) {
				//*[contains(@svgicon,'edit')]
				List<WebElement> dropvalues = driver.findElements(By.xpath("//*[contains(@class,'mat-option') or contains(@role,'menuitem')]//*[contains(text(),'"+options+"')]"));
				for (int i = 0; i < dropvalues.size(); i++) {
					if (isClickable(dropvalues.get(i))) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropvalues.get(i) );
						util.actionMethodClick(driver, dropvalues.get(i));
						flag = true;
						i = dropvalues.size();
						
			System.out.println("User select option: " +options );
			
		}
				}
			}
				

		}
		public void clickonOptionDropDownCalender(String options) throws InterruptedException
		{
			
			Wait.untilPageLoadComplete(driver,2);
			//WebElement dropvalue=driver.findElement(By.xpath("//*[starts-with(@class,'mat-option mat-focus')]//*[contains(text(),'"+options+"')]"));
			//testutil.actionMethodClick(driver, dropvalue);
			Boolean flag = false;
			while (!flag) {
				//*[contains(@svgicon,'edit')]
				List<WebElement> dropvalues = driver.findElements(By.xpath("//*[starts-with(@role,'menu')]//*[contains(text(),'"+options+"')]"));
				for (int i = 0; i < dropvalues.size(); i++) {
					if (isClickable(dropvalues.get(i))) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropvalues.get(i) );
						util.actionMethodClick(driver, dropvalues.get(i));
						flag = true;
						i = dropvalues.size();
						
			System.out.println("User select option: " +options );
			
		}
				}
			}
				

		}
		public void clickOnCheckBox(String chkname) throws InterruptedException
		{
			WebElement chktxt = driver.findElement(By.xpath("//*[contains(text(),'"+ chkname +"') or @class='"+chkname+"']"));
			String Actualtxt= chktxt.getText();
			System.out.println("Actual : " + Actualtxt );
			System.out.println("Expected : " + chkname );
			//assertion.CheckAssertionTrue(Actualtxt.contains(chkname), chkname);
			WebElement chkbox = driver.findElement(By.xpath("//*[@class='mat-checkbox-inner-container']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",chkbox );
			if(chkbox.isDisplayed()) {
				Wait.elementToBeClickable(driver, chkbox, 2);
				testutil.actionMethodClick(driver, chkbox);
				System.out.println("User select option: " +chkname );	
			}
			else {
				System.out.println("Checkbox is not visible, showing error message..");
			}
		}
			public void clicktoUploadFile(String downloadfile) throws InterruptedException, AWTException
			{
				//Wait.untilPageLoadComplete(driver,5);
				Wait.elementToBeClickable(driver, uploadDocument, 3);
				System.out.println(downloadfile);
				//Switch to pop-up window
				String mainWindowHandle = driver.getWindowHandle();
				Set<String> windowHandles = driver.getWindowHandles();
				for(String Handle:windowHandles)
					if(!Handle.equals(mainWindowHandle))
				{
				 driver.switchTo().window(Handle)	;
				}
			
		
				String imagepath= "C:/Users/neha.sain/OneDrive - Mears Group/Desktop/image.jpg";
				Wait.elementToBeClickable(driver, uploadDocument, 3);
				//uploadDocument.sendKeys(imagepath);
				uploadDocument.click();
				/* 
				 * 1) Copy the path
				 * 2) CTRL+V
				 * 3) Enter
				 */
				Robot rb = new Robot();
				rb.delay(5000);
				//Put the path in the clipboard
				StringSelection ss= new StringSelection("C:\\Users\\neha.sain\\OneDrive - Mears Group\\Desktop\\image.jpg");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				//CTRL+V
				rb.keyPress(KeyEvent.VK_CONTROL);// Press On Ctrl Key+ press V
				rb.keyPress(KeyEvent.VK_V);//Press on CTRL key
				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);
				
				// Enter 
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				
				Thread.sleep(4000);
				WebElement Done = driver.findElement(By.xpath("//*[starts-with(@class,'mat-focus-indicator')]//*[contains(text(),'Done')]"));
				Done.click();
				
			}
			public void TaskOutcomeFalse() throws InterruptedException
			{
				 try {
				WebElement outcomeElement = driver.findElement(By.xpath("(//*[@data-mat-icon-name='taskOutcomeFalse'])[1]"));
				// Get the value of the 'data-mat-icon-name' attribute
		        String outcomeAttributeValue = outcomeElement.getAttribute("data-mat-icon-name");

		        // Verify that the attribute value is 'taskOutcomeFalse'
		        if ("taskOutcomeFalse".equalsIgnoreCase(outcomeAttributeValue)) {
		            System.out.println("\u001B[31mTask outcome is marked as false.\u001B[0m");
		          
		            // Your verification passed. You can proceed with further actions or assertions.
		        } else {
		            System.out.println("\u001B[32mTask outcome is not marked as false.\u001B[0m");
		            // Handle the situation if the verification fails (throw an exception, log an error, etc.).
		        }
			
			 } catch (NoSuchElementException e) {
		            System.out.println("\u001B[32mElement not found on the page. Task outcome information is not available.\u001B[0m");
		            // Handle the situation when the element is not present (throw an exception, log an error, etc.).
		        } 
		
			}}


		
		
		
		 
		
		
	
	
