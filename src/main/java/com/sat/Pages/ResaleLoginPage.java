package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;

public class ResaleLoginPage {

	private WebDriver driver;

	private ConfigFileReader config = new ConfigFileReader();
	private ResaleHomePage resaleHomepg = new ResaleHomePage(TestBase.getDriver());
	// Creating account for Reseller user details
	@FindBy(linkText = "Create an account")
	private WebElement createAccount_link;



	@FindBy(xpath = "//*[@id='poregistrationemail']")
	private WebElement email;
	@FindBy(xpath="//*[@id='poregistrationconfirmemail']")
	private WebElement confirmationEmail;
	@FindBy(xpath = "//*[@id='poregisterpassword']")
	private WebElement password;
	@FindBy(xpath = "//*[@id='poregistrationname']")
	private WebElement fname;
	@FindBy(xpath = "//*[@id='poregistrationlastname']")
	private WebElement lname;
	@FindBy(xpath = "//div[@aria-controls='iti-0__country-listbox']") // *[@aria-controls='iti-1__country-listbox']
	private WebElement country_list;
	@FindBy(xpath = "//*[@id='iti-0__item-in']/span") // *[@id='iti-1__item-in']/span
	private WebElement country_selection;
	@FindBy(xpath = "//*[@id='poregistrationmobile']")
	private WebElement phnmbr;
	@FindBy(xpath = "//*[@id='poregistrationaddress']")
	private WebElement address;
	@FindBy(xpath = "//*[@id='poregistrationpostcode']")
	private WebElement postal_code;
	@FindBy(xpath = "//*[@id='poregistrationtown']")
	private WebElement city;
	@FindBy(xpath = "//*[@id='registrationconsent']")
	private WebElement chkbox;
	@FindBy(xpath = "//button[@id='RegisterAcc']//div//div")
	private WebElement continue_btn;
	//*[text()='Continue']
	
	
	@FindBy(xpath = "//*[text()='Registered successfully.']")
	private WebElement Register_success_msg;
	@FindBy(xpath = "//*[text()='Ok' or text()='OK' or text()='ok']")
	private WebElement ok_btn;

	@FindBy(xpath = "(//form[@id='resellregistrationdetails']//div[@class='xrm-editable-html xrm-attribute']//div)[1]")
	private WebElement email_txt;
	//form[@id='resellregistrationdetails']//div[text()='Email *']
	
	@FindBy(xpath = "(//form[@id='resellregistrationdetails']//div[@class='xrm-editable-html xrm-attribute']//div)[2]")
	private WebElement confirmationEmail_txt;
	//form[@id='resellregistrationdetails']//div[text()='Confirm Email *']
	
	@FindBy(xpath = "(//form[@id='resellregistrationdetails']//div[@class='xrm-editable-html xrm-attribute']//div)[3]")
	private WebElement password_txt;
	//form[@id='resellregistrationdetails']//div[text()='Password']
	
	@FindBy(xpath = "(//form[@id='resellregistrationdetails']//div[@class='xrm-editable-html xrm-attribute']//div)[5]")
	private WebElement fname_txt;
	//div[text()='First Name *']
	
	@FindBy(xpath = "(//form[@id='resellregistrationdetails']//div[@class='xrm-editable-html xrm-attribute']//div)[6]")
	private WebElement lname_txt;
	//div[text()='Last Name *']
	
	@FindBy(xpath = "(//form[@id='resellregistrationdetails']//div[@class='xrm-editable-html xrm-attribute']//div)[7]")
	private WebElement mobile_txt;
	//div[text()='Mobile *']
	
	@FindBy(xpath = "(//form[@id='resellregistrationdetails']//div[@class='xrm-editable-html xrm-attribute']//div)[9]")
	private WebElement staddres_txt;
	//div[text()='Street address *']
	
	@FindBy(xpath = "(//form[@id='resellregistrationdetails']//div[@class='xrm-editable-html xrm-attribute']//div)[10]")
	private WebElement postalcode_txt;
	//div[text()='Postal Code *']
	
	@FindBy(xpath = "(//form[@id='resellregistrationdetails']//div[@class='xrm-editable-html xrm-attribute']//div)[11]")
	private WebElement city_txt;
	//div[text()='City *']
	
	@FindBy(xpath = "(//form[@id='resellregistrationdetails']//div[@class='xrm-editable-html xrm-attribute']//div)[12]")
	private WebElement country_txt;
	//div[text()='Country *']
	@FindBy(xpath = "//div[@class='directionlogo']")
	private WebElement sendMeMyDataIcon;
	

	// Deleting a seller
	@FindBy(xpath = "(//div[@class='Accountdet'])[2]")
	private WebElement myaccount_link;
	@FindBy(xpath = "//div[@class='landingitem']//div[text()='My agreement']")
	private WebElement MyAgreement;
	@FindBy(xpath = "//div[@class='register']//div[text()='My agreement']")
	private WebElement myAgreementPage;
	@FindBy(xpath = "//div[@class='landingitem']//div[text()='Terms and conditions']")
	private WebElement termsAndConditions;
	
	@FindBy(xpath = "(//div[@class='landingitem']/child::div/div)[2]")
	private WebElement manageAcc_link;
	@FindBy(xpath = "//div[@class='landingitem']//div[text()='Personal details']")
	private WebElement personalDetails;
	@FindBy(xpath = "//div[@class='register']//div[text()='Personal details']")
	private WebElement personalDetailsPageTitle;
	
	@FindBy(xpath = "//div[@class='removeacc']")
	private WebElement deleteAcc;
	@FindBy(xpath = "//div[@class='xrm-editable-html xrm-attribute']//div[text()='OK' or text()='Yes' or text()='JA']")
	private WebElement yes_btn;

	// Login to Resale portal
	@FindBy(xpath = "//input[@id='pousername']")
	private WebElement emailID;
	@FindBy(xpath = "//input[@id='popassword']")
	private WebElement loginpassword;
	@FindBy(xpath = "//button[@id='signinnextBtn2']")
	private WebElement signin;
	@FindBy(xpath = "//*[@id='landingpageuseremail']")
	private WebElement succLoginmsg;
	
	// Seller forgot the password
	@FindBy(linkText = "Forgotten your password?")
	private WebElement forgotPwd_link;
	@FindBy(id = "poresetusername")
	private WebElement emailid;
	@FindBy(xpath = "//*[text()='Reset']")
	private WebElement Reset_btn;
	@FindBy(xpath = "//*[text()='Back to login']")
	private WebElement backToLogin_btn;
	@FindBy(xpath = "//div[text()='You should receive a link in a few moments. Please open that link to reset your password.']")
	private WebElement confirmation_msg;

	@FindBy(xpath = "//div[@aria-label='Promotions']")
	private WebElement promotionTab;
	@FindBy(xpath="//div[@class='tab' and @style='display: block;']//div[@class='col-xs-3 monback']//div[@class='backicon']")
	private WebElement bookingportalBackButton;

	@FindBy(xpath = "(//div[text()='Book an appointment'])[1]")
	private WebElement BookAppointmentButton;
	
	@FindBy(xpath = "//div[@onclick='SL.Portal.Resale.Main.gotoMyprofile()' and @class='backicon']")
	private List<WebElement> backicon;

	// Seller Reset the password
	/*
	 * @FindBy(xpath = "(//div[@aria-label='Show trimmed content'])[last()]")
	 * private List<WebElement> expanddots;
	 */
	@FindBy(xpath = "//a[text()='Reset Password']")
	private WebElement resetPwdBtn;
	@FindBy(xpath = "//input[@id='ponewpassword']")
	private WebElement newPwd;
	@FindBy(xpath = "//input[@id='poconfirmpassword']")
	private WebElement confirmPwd;
	@FindBy(xpath = "//div[text()='Update password']")
	private WebElement updatePwd;
	@FindBy(xpath = "//div[text()='Ok']")
	private WebElement okBtn;
	
	@FindBy(xpath="//div[@id='errorMessage']//div[@class='modal-itembody']")
	private WebElement unableToDeleteErrorMsg;
	
	@FindBy(xpath = "//div[@id='errorText']")
	private WebElement yourDataHasBeenSent;

	// Book a slot
	@FindBy(xpath = "//*[@id='nextBtn2']/div/div[contains(text(),'Book a time')]")
	private WebElement bookAslotBtn;
	String countryname;
	//country
		@FindBy(xpath = "//div[@class='landingitem']//div[@class='xrm-editable-html xrm-attribute']//div[contains(text(),'Personal details')]")
		private WebElement CountryMyaccount;
		@FindBy(xpath = "//button[@class='btn secondary-btn setmargin'][normalize-space()='Cancel']")
		private WebElement cancel_btn;
		@FindBy(xpath = "(//a[@class='cancelSignIn'][normalize-space()='Cancel'])[2]")
		private WebElement cancel_popbtn;	
		
  @FindBy(xpath = "(//div[@class='cancelrigh product-price-large']//div[@class='xrm-editable-html xrm-attribute']//div[text()='Cancel'])[1]")
	private WebElement ClickPortalCancel;
    
  @FindBy(xpath = "//h4[normalize-space()='Hansa, Malmö']")
 	private WebElement ClickStore;
  @FindBy(xpath = "//div[@class='myprofile']//div[text()='My Profile']")
	private WebElement myProfile;
  @FindBy(xpath = "//div[@class='proHeadblock']//div[text()=' My Items']")
 	private WebElement myItems;

  @FindBy(xpath = "//div[@class='proHeadblock']//div[contains(text(),' My Account')]")
	private WebElement myAccount;
  @FindBy(xpath = "//div[text()='Register items & drop off at store']")
	private WebElement regstrbtn;
  @FindBy(xpath = "//div[text()='Book a store appointment']")
 	private WebElement bookappntbtn;
  @FindBy(xpath = "//div[@id='partialContent']//div[text()='My Appointments']")
	private WebElement myAppointment;
  @FindBy(xpath = "//div[@id='showApp']//div[@class='appointmentList']")
	private WebElement appointmentList;
  @FindBy(xpath = "//table[@id='tabcurrent']//tbody//div[@class='row displayitems']")
	private WebElement itemslistInMyItems;



	Testutil util = new Testutil();

	public ResaleLoginPage(WebDriver driver) {
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
	public void Enterpassword_byEnter()
	{
		loginpassword.sendKeys(Keys.ENTER);
	}
	public void createAccount(String creatAccountlinkName) {
		//Actions action = new Actions(driver);
		//action.moveToElement(createAccount_link).click().build().perform();
		Boolean flag = false;
		while (!flag) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//List<WebElement> createAccout = driver.findElements(By.linkText(creatAccountlinkName));	
			List<WebElement> createAccout = driver.findElements(By.xpath("//div[@class='createlink']//div[contains(text(),'No')]"));	
			System.out.println(createAccout);
			for (int i = 0; i < createAccout.size(); i++){
				if (isClickable(createAccout.get(i))) {
					// ele.get(i).click();
					Wait.elementToBeClickable(driver, createAccout.get(i), 5);
					System.out.println(createAccout.get(i));
					util.actionMethodClick(driver, createAccout.get(i));
					flag = true;
					i = createAccout.size();
				}

			}

		}
	}

	public void scrollDown()
    {
        try {Wait.untilPageLoadComplete(driver,200);
        driver.findElement(By.xpath("//div[text()='Country *']")).click();
        Wait.untilPageLoadComplete(driver,200);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);
    }catch(Exception e) {};
        }
	public void scrollDowntoMyAccount()
    {
        try {Wait.untilPageLoadComplete(driver,200);
    WebElement myacc= driver.findElement(By.xpath("//div[contains(text(),' My Account')]"));
      Wait.untilPageLoadComplete(driver,200);
     driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);
       
     util.jsclick(driver, myacc);
    //   util.actionMethodClick(driver, myacc);
     //  Actions act = new Actions(driver);
     //  myacc.click();
       //act.sendKeys(Keys.ENTER).build().perform();
     //  act.sendKeys(Keys.RETURN).build().perform();
       //myacc.click();
    }catch(Exception e) {};
        }
	 public void user_verifies_countries(String fielddata,DataTable data) throws Exception {
			// List<String> data= testdata.asList(String.class);
				
				 List<String> actual = data.asList();
		        // System.out.println(driver.findElement(By.xpath("//select[@aria-label='Region']")).getAttribute("innerText"));

		       // String Regionvalues = genericCases.read_list_items(fieldName);
		        // System.out.println(Regionvalues);
				 System.out.println("Expected dropdown values for accounts table");
		         
				  for (String expectedOptions : actual) {
				          System.out.println(expectedOptions);
				   }
				  WebElement entriesDropDownLocator = driver.findElement(By.xpath("//select[@id='cntrylist']"));
				  
				  Select entriesDropDown = new Select(entriesDropDownLocator);
				  List<WebElement> actualDropDownValues = entriesDropDown.getOptions();
				  System.out.println("Actual dropdown values from accounts table");
				  for (WebElement actualValues : actualDropDownValues) {
				   System.out.println(actualValues.getText());
				  }
				  System.out.println("Compare the actual values with the expected values for dropdown");
				    
				  for(int i=0;i<actualDropDownValues.size();i++) {
				   
				     if(actualDropDownValues.get(i).getText().equals(actual.get(i).toString())) {
				      
				      System.out.println("Value Matching :"+"Actual List Value="+actualDropDownValues.get(i).getText()+" And Expected Value="+actual.get(i));
				     }else {
				      System.out.println("Value Not Matching :"+"Actual List Value="+actualDropDownValues.get(i).getText()+" And Expected Value="+actual.get(i));
				     }
				  }
				 }
				 
				/* 
		       for (int i = 0; i <= actual.size() - 1; i++) {
		            driver.findElement(By.xpath("//select[@id='cntrylist']")).click();
		            driver.findElement(By.xpath("//select[@id='cntrylist']")).sendKeys(actual.get(i));
		            driver.findElement(By.xpath("//select[@id='cntrylist']")).click();
		            if(actual.get(i).equals(driver.findElement(By.xpath("//select[@id='cntrylist']")).getAttribute("title"))) {
			    	      
			    	      System.out.println("Value Matching :"+"Actual List Value="+actual.get(i)+" And Expected Value=");
			    	     }else {
			    	      System.out.println("Value Not Matching");
			    	     }
		       }
		       System.out.println("Actual dropdown values from accounts table");
		      System.out.println(driver.findElement(By.xpath("//select[@id='cntrylist']")).getText());
		    */
	 public void VerifyCountryDisableMyAccount() {
			util.jsclick(driver, CountryMyaccount);
			//CountryMyaccount.click();
			
			boolean countryDisable = driver.findElement(By.xpath("//input[@id='puregcnt']")).isEnabled();
			//Assert.assertEquals(countryDisable,false);
			if(countryDisable){
		        System.out.println("Country is enabled. ");
		  }else{
		        System.out.println("Country is disabled.");
		  }
			 System.out.println("Country diable name "+countryname);
			WebElement countrylist=driver.findElement(By.xpath("//input[@id='puregcnt']"));
			//System.out.println("This is actual"+).getAttribute("title"));
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String bookingPortaldate = (String) jsExecutor.executeScript("return arguments[0].value", countrylist);
			System.out.println(bookingPortaldate);
			assertTrue(countryname.contains(bookingPortaldate));
			 System.out.println("Value Matching");
			/*
			for(int i=0;i<2;i++) {
				   
			     if(driver.findElement(By.xpath("//select[@id='cntrylist']")).getAttribute("title").equals(countryname)) {
			      
			      System.out.println("Value Matching :"+"Actual List Value="+driver.findElement(By.xpath("//select[@id='cntrylist']")).getAttribute("title")+" And Expected Value="+countryname);
			     }else {
			      System.out.println("Value Not Matching :"+"Actual List Value="+driver.findElement(By.xpath("//select[@id='cntrylist']")).getAttribute("title")+" And Expected Value="+countryname);
			     }
			 }
			 */
		}
	 public void createAccount() {
			Actions action = new Actions(driver);
			action.moveToElement(createAccount_link).click().build().perform();
		}
	 public void verifyFields() throws InterruptedException {

			List<String> list1 = Arrays.asList("Email *","Confirm Email *", "Password", "First Name *", "Last Name *", "Mobile *",
					"Street address *", "Postal Code *", "City *", "Country *");
			List<String> list2 = Arrays.asList(email_txt.getText(),confirmationEmail_txt.getText(), password_txt.getText(), fname_txt.getText(),
					lname_txt.getText(), mobile_txt.getText(), staddres_txt.getText(), postalcode_txt.getText(),
					city_txt.getText(), country_txt.getText());
			for (int i = 0; i < list1.size(); i++) {
				if ((list1.get(i)).equals(list2.get(i)) == true) {
					System.out.println(" Array List are equal     :" + list1.get(i) + "------->" + list2.get(i));
				} else {
					System.out.println(" Array List are not equal");
				}
			}
		}
	 public void cancelPopMsg(String Color1) {
			chkbox.click();
			cancel_popbtn.click();
			WebElement  colorString = driver.findElement(By.xpath("(//div[text()='Are you sure you want to cancel your registration?'])[1]"));
			String rgbFormat = colorString.getCssValue("background-color");
			System.out.println("rgbformat value ="+rgbFormat);
			String hexcolor = Color.fromString(rgbFormat).asHex();
			System.out.println("rgbFormt value as hexcolor = "+hexcolor);
			//String[] arrColor = hexcolor .split("#");
			
			//System.out.println(arrColor.length);
			//System.out.println(arrColor[1]);
			System.out.println(Color1);
			//assertTrue(selenium.isElementPresent("css=td[bgcolor=#000]"));
			//assertTrue(arrColor[0].equals("OOOOOO"));
			//Assert.assertTrue(Color.fromString("#000000").equals(colorString, "Text 'fieldName' color"));
			//System.out.println(Assert.assertEquals(hexcolor,hexcolor));
			if (hexcolor.equals(Color1)) {
				System.out.println("Both Actual and Expected color are equal");
			} else {
				System.out.println("Both Actual and Expected color are not equal");
			}

		}
	 public void cancelPopMsgnext(String Color1) {
			
			//cancel_btn.click();
		    System.out.println("The Expected Color"+Color1);
		    Color BLACK = Color.fromString("black");
			WebElement  colorString = driver.findElement(By.xpath("(//div[text()='Are you sure you want to cancel your registration?'])[1]"));
			String rgbFormat = colorString.getCssValue("background-color");
			System.out.println("rgbformat value ="+rgbFormat);
			String hexcolor = Color.fromString(rgbFormat).asHex();
			System.out.println("rgbFormt value as hexcolor = "+hexcolor);
			
			//System.out.println(arrColor.length);
			
			if (hexcolor.equals(Color1)) {
				System.out.println("Both Actual and Expected color are equal");
			} else {
				System.out.println("Both Actual and Expected color are not equal");
			}

		}
		

	public void verifyFields(String LanguageName) throws InterruptedException {
		List<String> expectedList = null;
		switch (LanguageName) {
		case "English":
			 expectedList = Arrays.asList("Email *","Confirm Email *", "Password", "First Name *", "Last Name *", "Mobile *",
					"Street address *", "Postal Code *", "City *", "Country *");
			break;
		case "Dutch":
			expectedList= Arrays.asList("Emailadres *","Bevestig Email *", "Paswoord", "Voornaam *", "Achternaam *", "Straatnaam *",
					"Potscode *", "Stad *", "Stad *", "Land *");
			break;
		case "German":
			expectedList = Arrays.asList("E-Mail *","Bestätigungs-E-Mail *", "Passwort", "Vor name *", "Nach name *", "Telefonnummer *",
					"Straße, Hausnummer *", "Postleitzahl *", "Ort *", "Land *");
			break;
		}
		/*List<String> list1 = Arrays.asList("Email *","Confirm Email *", "Password", "First Name *", "Last Name *", "Mobile *",
				"Street address *", "Postal Code *", "City *", "Country *");*/
	
		List<String> list2 = Arrays.asList(email_txt.getText(),confirmationEmail_txt.getText(), password_txt.getText(), fname_txt.getText(),
				lname_txt.getText(), mobile_txt.getText(), staddres_txt.getText(), postalcode_txt.getText(),
				city_txt.getText(), country_txt.getText());
		for (int i = 0; i < expectedList.size(); i++) {
			if ((expectedList.get(i)).equals(list2.get(i)) == true) {
				System.out.println(" Array List are equal     :" + expectedList.get(i) + "------->" + list2.get(i));
			} else {
				System.out.println(" Array List are not equal");
			}
		}
			
		
	}

	public void fillRegistrationFormDetails(String emailaddress, String firstname, String lastname, String phnbr,
			String Address, String pincode, String cityname) {
		// String pwd=config.getResalePortalpassword(emailaddress);

		email.sendKeys(emailaddress);
		confirmationEmail.sendKeys(emailaddress);
		//password.sendKeys(config.getTemporaryPassword());
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		country_list.click();
		country_selection.click();
		phnmbr.sendKeys(phnbr);
		address.sendKeys(Address);
		postal_code.sendKeys(pincode);
		city.sendKeys(cityname);
	}

	public void continuetonextpage(String Success_msg) {
		chkbox.click();
		continue_btn.click();
		WebElement SuccessTxt = driver.findElement(By.xpath("//*[text()='"+Success_msg+"']"));
		boolean verifyTitle = SuccessTxt.isDisplayed();
		//Register_success_msg
		assertTrue(verifyTitle);
		ok_btn.click();
	}
	public void ClickPortalCancelbutton ()
	{
		Wait.elementToBeClickable(driver,ClickPortalCancel , 5);
		//BookAppointmentButton.click();
		//util.actionMethodClick(driver, BookAppointmentButton);
		util.jsclick(driver, ClickPortalCancel);
	}
public void cancelPopMsgClickMeet(String Color1) {
		
		ClickPortalCancelbutton();
		WebElement  colorString = driver.findElement(By.xpath("//div[contains(text(),'Are you sure?')]"));
		String rgbFormat = colorString.getCssValue("background-color");
		System.out.println("rgbformat value ="+rgbFormat);
		String hexcolor = Color.fromString(rgbFormat).asHex();
		System.out.println("rgbFormt value as hexcolor = "+hexcolor);
		//String[] arrColor = hexcolor .split("#");
		
		//System.out.println(arrColor.length);
		//System.out.println(arrColor[1]);
		System.out.println(Color1);
		//assertTrue(selenium.isElementPresent("css=td[bgcolor=#000]"));
		//assertTrue(arrColor[0].equals("OOOOOO"));
		//Assert.assertTrue(Color.fromString("#000000").equals(colorString, "Text 'fieldName' color"));
		//System.out.println(Assert.assertEquals(hexcolor,hexcolor));
		if (hexcolor.equals(Color1)) {
			System.out.println("Both Actual and Expected color are equal");
		} else {
			System.out.println("Both Actual and Expected color are not equal");
		}

	}

	public void loginResalePortal(String userid, String pwd) throws InterruptedException {
		emailID.sendKeys(userid);
		loginpassword.sendKeys(pwd);
	}

	public String clickonsignin() {
		signin.click();
		return driver.getTitle();
	}
	public void validateResalePortalHomePage() throws InterruptedException {
		Thread.sleep(2000);
		assertTrue(myProfile.isDisplayed(), "My profile not displayed in home page");
		Thread.sleep(2000);
		assertTrue(myItems.isDisplayed(), "My Items not displayed in home page");
		Thread.sleep(2000);
		assertTrue(myAccount.isDisplayed(), "My Account not displayed in home page");
		Thread.sleep(2000);
		assertTrue(regstrbtn.isDisplayed(), "Register items & drop off at store button not displayed in home page");
		Thread.sleep(2000);
		assertTrue(bookappntbtn.isDisplayed(), "Book a store appointment button is not displayed in home page");
		Thread.sleep(2000);
		
	}
	public void validatMyAppointment() throws InterruptedException {
		Thread.sleep(2000);
		assertTrue(myAppointment.isDisplayed(), "My Appointment section is not shown on the resale page");
		Thread.sleep(2000);
		assertTrue(appointmentList.isDisplayed(), "My Appointment list is not shown on the resale page");
		
		
	}
	public void clickOnMyItem() {
		myItems.click();
	}
	public void validateItem_in_myItems() throws InterruptedException {
		Thread.sleep(2000);
		assertTrue(itemslistInMyItems.isDisplayed(), "Item is not in the list of Active Items");
	}

	public void validateLoginSuccMsg(String expected) {
		String actual = succLoginmsg.getText();
		// String expected = "You should receive a link in a few moments. Please open
		// that link to reset your password.";
		// Assert.assertEquals(actual, expected);
		if (expected.equals(actual)) {
			System.out.println("Both Actual and Expected strings are equal");
		} else {
			System.out.println("Both Actual and Expected strings are not equal");
		}
		System.out.println("actual : " + actual);
		System.out.println("expected : " + expected);
	}

	public void clickOnforgotPassword() {
		forgotPwd_link.click();
	}

	public void validateResetbtn(String email) {

		emailid.sendKeys(email);
		Reset_btn.click();

	}
	
	public void ClickPortallink ()
	{
		Wait.elementToBeClickable(driver,ClickStore , 5);
		//BookAppointmentButton.click();
		//util.actionMethodClick(driver, BookAppointmentButton);
		util.jsclick(driver, ClickStore);
	}

	public void validateSuccessMessage() {
		String actual = confirmation_msg.getText();
		String expected = "You should receive a link in a few moments. Please open that link to reset your password.";
		// Assert.assertEquals(actual, expected);
		if (expected.equals(actual)) {
			System.out.println("Both Actual and Expected strings are equal");
		} else {
			System.out.println("Both Actual and Expected strings are not equal");
		}
	}

	public void promotionTab() {
		promotionTab.click();
	}
	public void continuetonextpage() {
		chkbox.click();
		continue_btn.click();

		boolean verifyTitle = Register_success_msg.isDisplayed();
		assertTrue(verifyTitle);
		ok_btn.click();
	}
	public void validateCountry() {
		countryname =driver.findElement(By.xpath("//select[@id='cntrylist']")).getText();
	}
	
	public void ClickBookingBackButton()
	{
		//Wait.elementToBeClickable(driver,bookingportalBackButton , 5);
		//bookingportalBackButton.click();
		//util.actionMethodClick(driver, bookingportalBackButton);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> bckbtn= driver.findElements(By.xpath("//div[@class='backicon']"));
			for (int i = 0; i < bckbtn.size(); i++){
				if (isClickable(bckbtn.get(i))) {
					Wait.elementToBeClickable(driver, bckbtn.get(i), 5);
					util.actionMethodClick(driver, bckbtn.get(i));
					flag = true;
					i = bckbtn.size();
				}
			}
		}
		
	}
	public void BookingAnAppointment()
	{
		
		Wait.elementToBeClickable(driver,BookAppointmentButton , 5);
		//BookAppointmentButton.click();
		//util.actionMethodClick(driver, BookAppointmentButton);
		util.jsclick(driver, BookAppointmentButton);
	}


	public void deleteSeller() throws InterruptedException {
		System.out.println("Clickin on Delete Button");
		util.jsclick(driver, myaccount_link);
		util.jsclick(driver, manageAcc_link);
		Wait.elementToBeClickable(driver, deleteAcc, 0);
		util.jsclick(driver, deleteAcc);
		/* Ask swetha about this code as it dont work with this
		List<WebElement> ok = driver.findElements(By.xpath("//div[text()='OK']"));
		List<WebElement> errorPopup = driver.findElements(By.xpath("//div[@id='errorText' and contains(text(),'Syntax')]"));
		System.out.println("size of error " + errorPopup.size());
		if(ok.size()!=0) {
			System.out.println("closing the error popup");
			//ok_btn.click();
			//util.actionMethodClick(driver, ok_btn);
			resaleHomepg.clickOK();
			System.out.println("clicked on Ok");
			//util.jsclick(driver, deleteAcc);
			util.actionMethodClick(driver, deleteAcc);
		}
		*/
		Wait.elementToBeClickable(driver, yes_btn, 5);
		//util.jsclick(driver, yes_btn);
		//util.actionMethodClick(driver, yes_btn);
		// driver.navigate().refresh();
		Boolean flag = false;
		while (!flag) {
			List<WebElement> yesbtn= driver.findElements(By.xpath("//button[@id='yesItemBtn']//div[@class='xrm-attribute-value']"));
			for (int i = 0; i < yesbtn.size(); i++){
				if (isClickable(yesbtn.get(i))) {
					// ele.get(i).click();
					Wait.elementToBeClickable(driver, yesbtn.get(i), 5);
					System.out.println("Going to click on Pop up");
					Actions actions= new Actions(driver);
					actions.moveToElement(yesbtn.get(i)).click().build().perform();
					System.out.println(yesbtn.get(i));
					//util.actionMethodClick(driver, yesbtn.get(i));
					//util.jsclick(driver, yesbtn.get(i));
					//yesbtn.get(i).click();
					flag = true;
					i = yesbtn.size();
				}

			}
		}
			
		}
	
	public void goToManageAccount() {
		util.jsclick(driver, myaccount_link);
		util.jsclick(driver, manageAcc_link);
	}
	public void goToMyAgreement() {
		util.jsclick(driver, myaccount_link);
		MyAgreement.click();
		assertTrue(myAgreementPage.isDisplayed(),"Not landing on My Agreement Page");
	}
	
	
	public void clickOnDeleteSeller() throws InterruptedException {
		//util.jsclick(driver, deleteAcc);
		util.actionMethodClick(driver, deleteAcc);
		/*List<WebElement> errorPopup = driver.findElements(By.xpath("//div[@id='errorText']"));
		System.out.println("size of error " + errorPopup.size());
		if(errorPopup.size()!=0) {
			System.out.println("if block");
			//ok_btn.click();
			//util.actionMethodClick(driver, ok_btn);
			resaleHomepg.clickOK();

		}*/
		
		//util.jsclick(driver, yes_btn);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> yesbtn = driver.findElements(By.xpath("//div[@class='xrm-editable-html xrm-attribute']//div[text()='OK' or text()='Yes' or text()='JA']"));
			for (int i = 0; i < yesbtn.size(); i++){
				if (isClickable(yesbtn.get(i))) {
					// ele.get(i).click();
					Wait.elementToBeClickable(driver, yesbtn.get(i), 5);
					System.out.println(yesbtn.get(i));
					util.actionMethodClick(driver, yesbtn.get(i));
					flag = true;
					i = yesbtn.size();
				}

			}

		}
		
		
	}
	public void check_error_msg_unable_to_delete() {
		boolean errorPopUp = unableToDeleteErrorMsg.isDisplayed();
		Assert.assertTrue(errorPopUp, "Unable to deleate my data and account");
		ok_btn.click();
	}
	public void clickOnBackIcon() {
		Boolean flag = false;
		while (!flag) {
			List<WebElement> bckicon= driver.findElements(By.xpath("//div[@class='backicon']"));
			//div[@onclick='SL.Portal.Resale.Main.gotoMyprofile()' and @class='backicon']
			
			for (int i = 0; i < bckicon.size(); i++){
				if (isClickable(bckicon.get(i))) {
					// ele.get(i).click();
					Wait.elementToBeClickable(driver, bckicon.get(i), 5);
					System.out.println(bckicon.get(i));
					util.actionMethodClick(driver, bckicon.get(i));
					flag = true;
					i = bckicon.size();
				}

			}

		}

	}
	public void sendMeMyData() {
		sendMeMyDataIcon.click();
		yourDataHasBeenSent.isDisplayed();
		ok_btn.click();
	}
	public void deleteMyData() {
		deleteAcc.click();
		deleteAcc.isDisplayed();
		deleteAcc.click();
	}
	public void goToPersonalDetails() {
		util.jsclick(driver, myaccount_link);
		util.jsclick(driver, personalDetails);
		String s1 = personalDetailsPageTitle.getText();
		System.out.println(s1);
		assertTrue(s1.equalsIgnoreCase("Personal details"), "Not landing on the personal details page");
	}

	public void resetPwd() {
		List<WebElement> expanddots = driver
				.findElements(By.xpath("(//div[@aria-label='Show trimmed content'])[last()]"));
		if (!expanddots.isEmpty()) {
			if (expanddots.get(0).isDisplayed()) {
				expanddots.get(0).click();
			} else {
				System.out.println("element not visible");
			}
		}
		Wait.elementToBeClickable(driver, resetPwdBtn, 5);
		util.jsclick(driver, resetPwdBtn);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));		
		Wait.elementToBeClickable(driver, newPwd, 3);

	//	newPwd.sendKeys(config.getTemporaryPassword());
	//	confirmPwd.sendKeys(config.getTemporaryPassword());
		util.jsclick(driver, updatePwd);
		util.jsclick(driver, okBtn);
	}

	public void bookASlot() {
		util.jsclick(driver, bookAslotBtn);
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

	public void switchToOriginal() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));

	}
}
