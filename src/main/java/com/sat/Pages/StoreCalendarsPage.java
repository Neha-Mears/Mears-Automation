package com.sat.Pages;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class StoreCalendarsPage {

	//StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	private WebDriver driver;
	Testutil util = new Testutil();
	//private ConfigFileReader config = new ConfigFileReader();
	private By storeCalendar = By.xpath(("//div[text()='Store Calendars']"));
	@FindBy(xpath = "//div[@title='Store Calendars']") // div[text()='Store Calendars']
	private WebElement StoreCalendar;
	@FindBy(xpath = "//div[@data-control-name='icnNextTypeSSVS']")
	private WebElement bookingNextBtn;

	@FindBy(xpath = "//*[@aria-label='. No store selected']")
	private WebElement StoreCalendarDropDown;

	@FindBy(xpath = "//*[text()='NEXT']")
	private WebElement Next;

	@FindBy(xpath = "//*[@data-control-name='togStoreStatusSSVS']/div/div/div/div/div/div[2]")
	private WebElement ToggleButton;

	@FindBy(xpath = "//*[text()='Store Open']")
	private WebElement StoreOpen;
	// *[text()='Store Open' and @id='toggleSwitch_siena_3ca3eb4fab356c4_label']
	// *[@id='toggleSwitch_siena_3ca3eb4fab356c4_label']

	@FindBy(xpath = "//*[text()='Store Close']")
	private WebElement StoreClose;

	@FindBy(xpath = "//*[@data-control-name='togStoreStatusSSVS']/div/div/div/div/div/div[1]")
	private WebElement StoreState;

	@FindBy(xpath = "//*[text()='APPLY']/parent::div[@class='appmagic-button middle center']")
	private WebElement ApplyButton;
	private By ApplyButton1 = By.xpath(("//*[text()='APPLY']/parent::div[@class='appmagic-button middle center']"));

	@FindBy(xpath = "//*[contains(@appmagic-control,'txtEnableStoreDefaultAllowedSSVStextbox')]")
	private WebElement DefaultVisitors;
	// *[text()='DefaultVisitorsAllowed']

	@FindBy(xpath = "//*[text()='YES']")
	private WebElement Yes;

	@FindBy(xpath = "//*[text()='Store closed successfully']")
	private List<WebElement> StoreClosedMSG;

	@FindBy(xpath = "//*[text()='Store opened successfully']")
	private List<WebElement> StoreOpenedMSG;

	@FindBy(xpath = "//div[@data-control-name='icnEditCountrySelect']//div[@class='powerapps-icon no-focus-outline']")
	private WebElement penIcon;
	private By penIcon1 = By.xpath(("//div[@data-control-name='icnEditCountrySelect']//div[@class='powerapps-icon no-focus-outline']"));

	@FindBy(xpath = "(//*[@data-control-name='ddCountry']//child::div)[7]")
	private WebElement countrySelection;

	@FindBy(xpath = "(//*[@data-control-name='ddBrand']//child::div)[7]")
	private WebElement brandSelection;

	@FindBy(xpath = "//*[text()='OK']")
	private WebElement OKbtn;

	@FindBy(xpath = "(//*[@class='appmagic-datepicker-icon'])[1]")
	private WebElement fromCalendar;

	@FindBy(xpath = "(//*[@class='appmagic-datepicker-icon'])[2]")
	private WebElement toCalendar;

	@FindBy(xpath = "//*[@class='appmagic-datepicker-ok-button' and text()='Ok']")
	private WebElement fromDateOk;

	@FindBy(xpath = "(//*[@class='appmagic-datepicker-ok-button' and text()='Ok'])[2]")
	private WebElement toDateOk;

	@FindBy(xpath = "//*[text()='GENERATE CALENDAR']")
	private WebElement generateCalendar;

	@FindBy(xpath = "//*[text()='Country selector']")
	private WebElement countrySelectorwindowpopup;

	@FindBy(xpath = "//*[text()='Bookings']")
	private WebElement bookingTab;

	@FindBy(xpath = "//div[contains(@data-control-name,'TogEditServiceStatus')]//div[@class='appmagic-toggleSwitch no-focus-outline right']//div[@class='appmagic-toggleSwitch-handle']")
	private WebElement serviceStatustogglebtn;
	//(//*[@class='appmagic-toggleSwitch-off'])[3]

	@FindBy(xpath = "//div[@data-control-name='TogEditServiceStatusSSVS' or @data-control-name='TogEditServiceStatusSSS']//div[@class='appmagic-toggleSwitch-label left']")
	private WebElement serviceStatus;
	//(//*[@class='appmagic-toggleSwitch-label left'])[3]
	//div[contains(@data-control-name,'TogEditServiceStatusSSVS')]//div[@class='appmagic-toggleSwitch-label left']
	//div[@data-control-name='TogEditServiceStatusSSVS']//div[@class='appmagic-toggleSwitch-label left']
	//div[@data-control-name='TogEditServiceStatusSSVS' or @data-control-name='TogEditServiceStatusBSS' or @data-control-name='TogEditServiceStatusCSS' or @data-control-name='TogEditServiceStatusSSS']//div[@class='appmagic-toggleSwitch-label left']
	@FindBy(xpath = "//*[text()='APPLY']")
	private WebElement applyBtn;

	@FindBy(xpath = "//*[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "//*[text()='Service updated successfully']")
	private List<WebElement> serviceUpdatedmsg;

	@FindBy(xpath = "//div[@data-control-name='txtEditServiceCloseMessageSSVS']//div//div//div//div//div//input")
	private WebElement customMessage;

	@FindBy(xpath = "//input[contains(@appmagic-control,'txtEditServiceDefaultAllowed')]")
	private WebElement allowedVisitors;
	//*[@data-control-name='txtEditServiceDefaultAllowedSSVS']//div//div//div//div//div//input

	@FindBy(xpath = "//*[@data-control-name='cbSelectAllDaysSlotsHeaderSVS']//ancestor::div[@class='appmagic-checkbox-placeholder']")
	private WebElement selectAlltheslots;

	@FindBy(xpath = "//*[text()='EDIT SELECTED SLOT']")
	private WebElement editSelectedSlot;

	@FindBy(xpath = "//*[@data-control-name='togWeekStatusSVS']//following-sibling::div[@class='appmagic-toggleSwitch no-focus-outline right']")
	private WebElement openToggle;

	@FindBy(xpath = "//*[text()='SAVE']")
	private WebElement save;

	@FindBy(xpath = "//*[@data-control-name='icnBackSVS']//ancestor::div[@class='icon-svg-container']")
	private WebElement back;

	@FindBy(xpath = "//*[text()='Service Open']")
	private WebElement open;

	@FindBy(xpath = "//*[@id='toast-container']")
	private List<WebElement> toasteContainer;

	@FindBy(tagName = "Body")
	private WebElement newTab;

	public StoreCalendarsPage(WebDriver driver) {
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

	public void clickOnCalendar() {
		Wait.elementToBeClickable(driver, StoreCalendar, 5);
		// StoreCalendar.click();
		// util.jsclick(driver, StoreCalendar);
		// util.actionMethodClick(driver, StoreCalendar);
		//List<WebElement> ele = driver.findElements(storeCalendar);
		//System.out.println(ele);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(storeCalendar);
			System.out.println(ele);
			for (int i = 0; i < ele.size(); i++)

			{
				if (isClickable(ele.get(i))) {
					// ele.get(i).click();
					Wait.elementToBeClickable(driver, ele.get(i), 5);
					System.out.println(ele.get(i));
					util.actionMethodClick(driver, ele.get(i));
					flag = true;
					i = ele.size();
				}

			}

		}
	}

	public void newTabTab() {
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		// newTab.sendKeys(Keys.CONTROL + "t");
		// driver.switchTo().newWindow(WindowType.TAB);
		// WebDriver driver = new ChromeDriver();
		driver.get("http://yahoo.com");
		JavascriptExecutor we = ((JavascriptExecutor) driver);
		we.executeScript("window.open()");
		// ((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("http://google.com");
		System.out.println("in new tab method");
	}

	public void selectStoreAndClickNext(String nameOfTheStore) {
		Wait.elementToBeClickable(driver, StoreCalendarDropDown, 5);
		StoreCalendarDropDown.click();
		// Actions action = new Actions(driver);
		// WebElement StoreName =
		// driver.findElement(By.xpath("//*[contains(text(),'"+nameOfTheStore+"')]"));
		// System.out.println(StoreName);
		//List<WebElement> ele = driver.findElements(By.xpath("//*[contains(text(),'" + nameOfTheStore + "')]"));
		Boolean flag = false;
		while (!flag) {
			System.out.println("need to click on the store");
			List<WebElement> ele = driver.findElements(By.xpath("//*[contains(text(),'"+nameOfTheStore+"')]"));
			System.out.println("clicked on the store");
			for (int i = 0; i < ele.size(); i++)

			{
				if (isClickable(ele.get(i))) {
					String storeName = ele.get(i).getText();
					System.out.println(storeName);
					System.out.println(nameOfTheStore);
					Assert.assertTrue(storeName.contains(nameOfTheStore), " Store Name and store code are not as Expected");
					ele.get(i).click();
					flag = true;
					i = ele.size();
				}

			}

		}
		// Wait.elementToBeClickable(driver, StoreName, 5);
		// action.moveToElement(StoreName).click().perform();
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		Next.click();
	}

	public void clickOnToggle() {
		Wait.elementToBeClickable(driver, ToggleButton, 5);
		// SToggleButton.click();
		util.actionMethodClick(driver, ToggleButton);
		Wait.untilPageLoadComplete(driver, 20);

	}

	public void enterDefaultVisitor(String defaultAlowedVisitor) {
		Wait.elementToBeClickable(driver, DefaultVisitors, 5);
		DefaultVisitors.sendKeys(defaultAlowedVisitor);
	}

	public void selectApplyhAndVerifySuccessMsg() {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,1000)", "");
		// js.executeScript(script, args);
		Wait.untilPageLoadComplete(driver, 300);
		Wait.elementToBeClickable(driver, ApplyButton, 5);
		// ApplyButton.click();
		//List<WebElement> ele = driver.findElements(ApplyButton1);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(ApplyButton1);
			for (int i = 0; i < ele.size(); i++)

			{
				if (isClickable(ele.get(i))) {
					ele.get(i).click();
					flag = true;
					i = ele.size();
				}

			}

		}
		Wait.untilPageLoadComplete(driver, 20);
		util.validatesuccessmsg(driver, StoreClosedMSG, toasteContainer);

	}

	public void selectYesAndVerifySuccessOpenMsg() {
		Wait.elementToBeClickable(driver, Yes, 5);
		Yes.click();
		Wait.untilPageLoadComplete(driver, 300);
		util.validatesuccessmsg(driver, StoreOpenedMSG, toasteContainer);
		// Wait.elementToBeClickable(driver, StoreOpenedMSG, 300);
		// boolean verifyTitle = StoreOpenedMSG.isDisplayed();
		// assertTrue(verifyTitle);

	}

	public void storeName(String nameOfTheStore) {
		System.out.println("Store name");
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		Wait.elementToBeClickable(driver, StoreCalendarDropDown, 5);
		StoreCalendarDropDown.click();
		//util.actionMethodClick(driver, StoreCalendarDropDown);
		//List<WebElement> ele = driver.findElements(By.xpath("//*[contains(text(),'" + nameOfTheStore + "')]"));
		//System.out.println(ele);
		Boolean flag = false;
		while (!flag) {
			System.out.println(nameOfTheStore);
			List<WebElement> ele = driver.findElements(By.xpath("//*[contains(text(),'" + nameOfTheStore + "')]"));
			System.out.println(ele);
		//	WebElement element = driver.findElement(By.xpath("//li[text()='Validation Finalized - Workflow Closed']"));
			
			for (int i = 0; i < ele.size(); i++)

			{
				if (isClickable(ele.get(i))) {
					WebElement ele1 = ele.get(i);
					// util.jsclick(driver, ele1);
					//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
					util.actionMethodClick(driver, ele1);
					flag = true;
					i = ele.size();
				}

			}

		}
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		Next.click();
	}

	public void storeIsOpenOrClose(String storeState, String nameOfTheStore) {
		System.out.println("Store is open or close");
		//Wait.elementToBeClickable(driver, StoreCalendar, 5);
		// StoreCalendar.click();
		// @@@@@@@@@@@@@@@ Store Calendar @@@@@@@@@@@@@@@@@@@@@@@@
		System.out.println("click on store calendar");
		//List<WebElement> ele = driver.findElements(storeCalendar);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(storeCalendar);
			for (int i = 0; i < ele.size(); i++)

			{
				if (isClickable(ele.get(i))) {
					WebElement ele1 = ele.get(i);
					// util.jsclick(driver, ele1);
					util.actionMethodClick(driver, ele1);
					flag = true;
					i = ele.size();
				}

			}

		}
		// @@@@@@@@@@@@@@@ Store Calendar @@@@@@@@@@@@@@@@@@@@@@@@
		storeName(nameOfTheStore);
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		String StoreCondition = StoreState.getText();
		System.out.println("current condition " + StoreCondition);
		if (StoreCondition.equals(storeState)) {
			System.out.println("Store status is same");
		} else {
			System.out.println("outer else");
			if (storeState.equals("Store Open")) {
				System.out.println("current condition is " + StoreCondition
						+ " and store state should be changed to open so i am executing this block");
				Wait.elementToBeClickable(driver, ToggleButton, 5);
				ToggleButton.click();
				Wait.elementToBeClickable(driver, DefaultVisitors, 5);
				System.out.println("click on allowed visitor");
				DefaultVisitors.click();
				Wait.elementToBeClickable(driver, DefaultVisitors, 5);
				System.out.println("enter allowed visitor");
				DefaultVisitors.sendKeys("10");
				System.out.println("entered allowed visitor");
				Wait.elementToBeClickable(driver, Yes, 5);
				Yes.click();
				System.out.println("clicked on Yes");
				// Wait.untilPageLoadComplete(driver, 300);
				// util.validatesuccessmsg(driver, StoreOpenedMSG);
				util.validatesuccessmsg(driver, StoreOpenedMSG, toasteContainer);
				// WebDriverWait w = new WebDriverWait(driver,300);
				// Thread.sleep(240000);
				// presenceOfElementLocated condition
				// w.until(ExpectedConditions.presenceOfElementLocated (StoreOpenedMSG);
				// w.until(ExpectedConditions.visibilityOfElementLocated
				// (By.xpath("//*[text()='Store opened successfully']")));
				// List<WebElement> elen = driver.findElements(By.xpath("//*[text()='Store
				// opened successfully']"));
				// Assert.assertTrue(elen.size()!=0, "WebElement not found");
				// String s1 = "Store opened successfully"
				// String s2 = StoreOpenedMSG.getText()
				// boolean verifyTitle = StoreOpenedMSG.isDisplayed();
				// assertTrue(verifyTitle);

			} else {
				System.out.println("current condition is " + StoreCondition
						+ " and store status should be changed to close so i am executing else block");
				Wait.elementToBeClickable(driver, ToggleButton, 5);
				ToggleButton.click();
				Wait.elementToBeClickable(driver, ApplyButton, 5);
				// ApplyButton.click();
				//List<WebElement> ele1 = driver.findElements(ApplyButton1);
				Boolean flag1 = false;
				while (!flag1) {
					List<WebElement> ele1 = driver.findElements(ApplyButton1);
					for (int i = 0; i < ele1.size(); i++){
						if (isClickable(ele1.get(i))) {
							//WebElement ele2 = ele1.get(i);
							// util.jsclick(driver, ele1);
							util.actionMethodClick(driver, ele1.get(i));
							flag1 = true;
							i = ele1.size();
						}

					}

				}
				Wait.untilPageLoadComplete(driver, 20);
				util.validatesuccessmsg(driver, StoreClosedMSG, toasteContainer);
				// Wait.elementToBeClickable(driver, StoreClosedMSG, 10);
				// boolean verifyTitle = StoreClosedMSG.isDisplayed();
				// assertTrue(verifyTitle);
				// Wait.elementToBeClickable(driver, StoreClosedMSG, 10);
				// System.out.println("Store opened successfully");

			}
		}
	}

	public void setCountryAndBrand(String selectCountry, String selectBrand) {
		Wait.untilPageLoadComplete(driver, 20);
		Wait.elementToBeClickable(driver, penIcon, 3);
		// penIcon.click();
		//List<WebElement> ele = driver.findElements(penIcon1);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(penIcon1);
			for (int i = 0; i < ele.size(); i++)

			{
				if (isClickable(ele.get(i))) {
					WebElement ele1 = ele.get(i);
					util.actionMethodClick(driver, ele1);
					// util.jsclick(driver, ele1);
					flag = true;
					i = ele.size();
				}

			}

		}
		Wait.elementToBeClickable(driver, countrySelection, 3);
		countrySelection.click();
		WebElement we = driver
				.findElement(By.xpath("//*[@role='listbox']//child::div[text()='" + selectCountry + "']"));
		Wait.elementToBeClickable(driver, we, 3);
		util.actionMethodClick(driver, we);
		Wait.elementToBeClickable(driver, brandSelection, 3);
		brandSelection.click();
		WebElement we1 = driver.findElement(By.xpath("//*[@role='listbox']//div[text()='" + selectBrand + "']"));
		Wait.elementToBeClickable(driver, we1, 3);
		util.actionMethodClick(driver, we1);
		Wait.elementToBeClickable(driver, OKbtn, 3);
		OKbtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOf(countrySelectorwindowpopup));
		Wait.untilPageLoadComplete(driver, 10);
		Wait.untilPageLoadComplete(driver);
	}

	public void verificationOfCalender(String statusOfCalender) {
		System.out.println("Executing verification of calender method");
		String services = driver.findElement(By.xpath(
				"//div[@data-control-name='lblCountRowsSSVS']//div[contains(text(),'Page')][contains(text(),'services')]"))
				.getText();
		System.out.println(services);
		String no_OfService = services.split("of ")[1].split("service")[0].trim();
		System.out.println(no_OfService);
		int no_of_services = Integer.parseInt(no_OfService);
		List<WebElement> statusOfCalenders = driver
				.findElements(By.xpath("//div[@data-control-name='lblServiceStatusSSVS']//div[@class='appmagic-label no-focus-outline middle readOnly']//div[text()='"+statusOfCalender+"']"));
		//div[@data-control-name='lblServiceStatusSSVS']//div[text()='"+statusOfCalender+"']
		//div[@data-control-name='lblServiceStatusSSVS']
		System.out.println(statusOfCalenders);
		Assert.assertTrue(no_of_services == statusOfCalenders.size(),
				"The number of services is not the same as the expected " + statusOfCalender + " Status");
	}

	public void checkCalendarForService(String serviceName, String fmDate, String fmYear, String fmMonth, String tDate,
			String tYear, String tMonth) {
		WebElement Calendar = driver.findElement(By.xpath("//*[contains(text(),'"+serviceName+"')]/ancestor::div[@data-control-name='lblServiceSSVS']//following-sibling::div[@data-control-name='lblServiceStartDateSSVS']//div[@class='appmagic-label-text appmagic-label-single-line']"));
		//*[contains(text(),'" + serviceName+ "')]//parent::div[@class='appmagic-label no-focus-outline middle readOnly']//parent::div//parent::div//parent::div//parent::div[@data-control-name='lblServiceSSVS']//following-sibling::div[@data-control-name='lblServiceStartDateSSVS']//div[@class='appmagic-label-text appmagic-label-single-line']

		// *[contains(text(),'test')]//parent::div[@class='appmagic-label
		// no-focus-outline middle
		// readOnly']//parent::div//parent::div//parent::div//parent::div[@data-control-name='lblServiceSSVS']//following-sibling::div[@data-control-name='lblServiceStartDateSSVS']//div[@class='appmagic-label-text
		// appmagic-label-single-line']
		String Calendar1 = Calendar.getText();
		System.out.println(Calendar1);
		if (Calendar1.equalsIgnoreCase("No calendar")) {
			WebElement addCalendar = driver.findElement(By.xpath("//*[contains(text(),'" + serviceName+ "')]//parent::div[@class='appmagic-label no-focus-outline middle readOnly']//parent::div//parent::div//parent::div//parent::div[@data-control-name='lblServiceSSVS']//following-sibling::div[@data-control-name='btnicnAddCalendarSSVS']"));
			addCalendar.click();
			ganerateCalendar(fmDate, fmYear, fmMonth, tDate, tYear, tMonth);
		} else {
			System.out.println("calendar is ganerated");
		}
		// *[contains(text(),'Automation Service
		// Test')]//parent::div[@class='appmagic-label no-focus-outline middle
		// readOnly']//parent::div//parent::div//parent::div//parent::div[@data-control-name='lblServiceSSVS']//following-sibling::div[@data-control-name='lblServiceStartDateSSVS']
	}
	
	public Boolean checkNoCalendarForService(String serviceName)
	{
	WebElement Calendar = driver.findElement(By.xpath("//*[contains(text(),'"+serviceName+"')]/ancestor::div[@data-control-name='lblServiceSSVS']//following-sibling::div[@data-control-name='lblServiceStartDateSSVS']//div[@class='appmagic-label-text appmagic-label-single-line']"));
	String Calendar1 = Calendar.getText();
	System.out.println(Calendar1);
	Boolean Calenderdisplayed =Calendar1.contains("No calendar");
	System.out.println(Calenderdisplayed);
	return Calenderdisplayed;
	//if (Calenderdisplayed=='True') {
		//System.out.println("No Calendar dates");
		//return Calenderdisplayed;
		/*
		} 
	else {
		System.out.println("calendar is ganerated");
		return false;
		}
		*/
	}
	
	public boolean checkEndDateForService(String serviceName) 
	{
		WebElement EndD = driver.findElement(By.xpath("//*[contains(text(),'"+serviceName+"')]/ancestor::div[@data-control-name='lblServiceSSVS']//following-sibling::div[@data-control-name='lblServiceEndDateSSVS']//div[@class='appmagic-label-text appmagic-label-single-line']"));
		String EdDate = EndD.getText();
		System.out.println("The Date from page "+EdDate);
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd MMM yyyy");  
		Date today = new Date(); 
		String currDate = formatter1.format(today); 
		System.out.println("The Current date from system "+currDate); 
		System.out.println("Date conversion");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		Date Enddate;
		Date Currentdate;
		try {
			 Enddate = sdf.parse(EdDate);
			 Currentdate = sdf.parse(currDate);
			System.out.println("The End date is: "+Enddate);
			System.out.println("The current date is: "+Currentdate);
			//System.out.println(Enddate.before(Currentdate));
			System.out.println( Enddate + " is before " + Currentdate + " = " + Enddate.before(Currentdate));
			return true;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
		
		//System.out.println("Date conversion");
		//DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");  
		//String strDate = dateFormat.format(today);  
		//System.out.println(strDate);
        }
	

	public void editSelectedSlot(String serviceName) {
		util.actionMethodClick(driver, bookingTab);
		Wait.untilPageLoadComplete(driver, 30);
		
		boolean flags = true;
		while(flags) {
			List<WebElement> clickOnService1 = driver.findElements(By.xpath("//*[@data-container-name='galTypeHeaderSSVS-container']//following-sibling::div//following-sibling::div[text()='"+serviceName+"']"));
			if(clickOnService1.size()!= 0) {
				WebElement clickOnService = driver.findElement(By.xpath("//*[@data-container-name='galTypeHeaderSSVS-container']//following-sibling::div//following-sibling::div[text()='"+serviceName+"']"));
				Wait.elementToBeClickable(driver, clickOnService, 5);
				Wait.untilPageLoadComplete(driver, 10);
				Wait.elementToBeClickable(driver, clickOnService, 10);
				util.actionMethodClick(driver, clickOnService);
				flags = false;
			}
			else {
				bookingNextBtn.click();
			}
	}
	
			Wait.untilPageLoadComplete(driver, 30);
			Wait.elementToBeClickable(driver, selectAlltheslots, 10);
			/*try {
			selectAlltheslots.click();
			System.out.println("clicking on all slots in try");
		}catch(Exception e) {
		selectAlltheslots.click();
		System.out.println("clicking on all slots in catch");
		}*/
			Boolean flag = false;
			while (!flag) {
				List<WebElement> ele = driver.findElements(By.xpath("//*[@data-control-name='cbSelectAllDaysSlotsHeaderSVS']//ancestor::div[@class='appmagic-checkbox-placeholder']"));
				for (int i = 0; i < ele.size(); i++)

				{
					if (isClickable(ele.get(i))) {
						//ele.get(i).click();
						//util.actionMethodClick(driver, ele.get(i));
						util.jsclick(driver, ele.get(i));
						flag = true;
						i = ele.size();
					}
				}
			}
			Wait.elementToBeClickable(driver, editSelectedSlot, 10);
			editSelectedSlot.click();
			String s1 = open.getText();
			if(!s1.equalsIgnoreCase("Service Open")) {
				openToggle.click();
			}
		  save.click();
		}

		public void removeRegestredVisitor(String serviceName) {
			util.actionMethodClick(driver, bookingTab);
			Wait.untilPageLoadComplete(driver, 30);
			WebElement clickOnService = driver.findElement(By.xpath("//*[@data-container-name='galTypeHeaderSSVS-container']//following-sibling::div//following-sibling::div[text()='"+serviceName+"']"));
			util.actionMethodClick(driver, clickOnService);
			Wait.untilPageLoadComplete(driver, 30);
		}

		public void ganerateCalendar(String fmDate, String fmYear, String fmMonth, String tDate, String tYear,
				String tMonth) {
			fromCalendar.click();
			Select dropYear = new Select(driver.findElement(By.xpath("//*[@class='pika-select pika-select-year']")));
			dropYear.selectByValue(fmYear);
			WebElement ee = driver.findElement(By.xpath("//*[@class='pika-select pika-select-month']"));
			Select dropMonth = new Select(ee);
			dropMonth.selectByVisibleText(fmMonth);
			WebElement we = driver
					.findElement(By.xpath("//*[@class='pika-single is-bound']//td[@data-day='" + fmDate + "']"));
			we.click();
			fromDateOk.click();
			System.out.println("clicked on from date");
			toCalendar.click();
			Select dropYear2 = new Select(driver.findElement(By.xpath("(//*[@class='pika-select pika-select-year'])[2]")));
			dropYear2.selectByValue(tYear);
			WebElement ee1 = driver.findElement(By.xpath("(//*[@class='pika-select pika-select-month'])[2]"));
			Select dropMonth2 = new Select(ee1);
			dropMonth2.selectByVisibleText(tMonth);
			WebElement we1 = driver
					.findElement(By.xpath("//*[@class='pika-single is-bound']//td[@data-day='" + tDate + "']"));
			we1.click();
			Wait.elementToBeClickable(driver, toDateOk, 2);
			toDateOk.click();
			Wait.elementToBeClickable(driver, generateCalendar, 2);
			generateCalendar.click();
			back.click();
			Wait.untilPageLoadComplete(driver, 30);
		}

		public void validateListOfServices(String serviceName) {
			System.out.println("validating service");
			Wait.untilPageLoadComplete(driver, 10);
			WebElement we = driver
					.findElement(By.xpath("//*[@data-control-name='lblServiceSSVS']//div[text()='" + serviceName + "']"));
			Wait.waitUntilElementVisible(driver, we);
			System.out.println(we);
			String s1 = we.getText();
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String bookingPortaldate = (String) jsExecutor.executeScript("return arguments[0].value", we);
			System.out.println(bookingPortaldate);
			System.out.println(s1);
			assertTrue(s1.equalsIgnoreCase(serviceName), serviceName + " sevice is not listed under the store");

		}

		public void clickOnBookingTabAndValidateService(String serviceName) {
			//bookingTab.click();
			util.actionMethodClick(driver, bookingTab);
			WebElement we = driver.findElement(By.xpath("//*[@data-container-name='galTypeHeaderSSVS-container']//following-sibling::div//following-sibling::div[text()='"+serviceName+"']"));
			String string1 = we.getText();
			Assert.assertNotEquals(string1.equalsIgnoreCase(serviceName),  "Booking slots are available for the selected service");
			System.out.println("successfully validated the slot");
		}

		public void selectService(String service) {
			//List<WebElement> ele = driver.findElements(By.xpath("//div[text()='" + service + "']"));
			//System.out.println(ele.size());
			Boolean flag = false;
			while (!flag) {
				List<WebElement> ele = driver.findElements(By.xpath("//div[text()='" + service + "']"));
				System.out.println(ele.size());
				for (int i = 0; i < ele.size(); i++)
				{
					if (isClickable(ele.get(i))) {
						WebElement ele1 = ele.get(i);
						util.actionMethodClick(driver, ele1);
						// util.jsclick(driver, ele1);
						flag = true;
						i = ele.size();
						System.out.println(i);
					}

				}

			}
		}
		public void clickOnApply() {
			Wait.untilPageLoadComplete(driver, 5);
			//List<WebElement> ele = driver.findElements(By.xpath("//*[text()='APPLY']"));
			//System.out.println(ele.size());
			long startTime = System.currentTimeMillis();// fetch starting time
			Boolean flag = false;
			while (!flag && (System.currentTimeMillis() - startTime) < 60000) {
				List<WebElement> ele = driver.findElements(By.xpath("//*[text()='APPLY']"));
				System.out.println(ele.size());
				for (int i = 0; i < ele.size(); i++)

				{
					if (isClickable(ele.get(i))) {
						util.actionMethodClick(driver, ele.get(i));
						// util.jsclick(driver, ele1);
						flag = true;
						i = ele.size();
					}
					else {
						System.out.println("element is not clickable so executing else of apply");
					}

				}

			}	
		}
		public void clickOnOk() {
			Wait.untilPageLoadComplete(driver, 5);
			//List<WebElement> ele = driver.findElements(By.xpath("//*[text()='OK']"));
			//System.out.println(ele.size());
			Boolean flag = false;
			long startTime = System.currentTimeMillis();// fetch starting time
			System.out.println(startTime);
			while (!flag && (System.currentTimeMillis() - startTime) < 60000) {
				List<WebElement> ele = driver.findElements(By.xpath("//*[text()='OK']"));
				System.out.println(ele.size());
				for (int i = 0; i < ele.size(); i++){
					if (isClickable(ele.get(i))) {
						util.actionMethodClick(driver, ele.get(i));
						// util.jsclick(driver, ele1);
						flag = true;
						i = ele.size();
					}
					else {
						System.out.println("element is not clickable so executing else of ok");
					}

				}

			}

		}
		public void setServiceStatus(String viewStatus,String noOfdefaultvisitors) {
			Wait.untilPageLoadComplete(driver, 10);
			Wait.elementToBeClickable(driver, serviceStatus, 5);
			Wait.untilPageLoadComplete(driver, 5);
			Wait.elementToBeClickable(driver, serviceStatus, 5);

			/*JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String serviceStatus_1 = (String) jsExecutor.executeScript("return arguments[0].value", serviceStatus);
		System.out.println(serviceStatus_1 + " this is js status");

		Wait.elementToBeClickable(driver, serviceStatus, 10);
		String itemsCountValue = serviceStatus.getAttribute("textContent");
		System.out.println(itemsCountValue+" attribute");*/

			String Status = serviceStatus.getText();
			System.out.println(Status +"  this is the status of the service ");
			System.out.println(viewStatus +"  parameter status");
			if(Status.equals(viewStatus)) {
				clickOnApply();
				clickOnOk();
			}else {
				if (viewStatus.equals("Enable")) {
					//applyBtn.click();
					//util.actionMethodClick(driver, serviceStatustogglebtn);
					Boolean flag = false;
					while (!flag) {
						List<WebElement> ele = driver.findElements(By.xpath("//div[contains(@data-control-name,'TogEditServiceStatus')]//div[@class='appmagic-toggleSwitch no-focus-outline right']//div[@class='appmagic-toggleSwitch-handle']"));
						System.out.println(ele.size());
						for (int i = 0; i < ele.size(); i++)

						{
							if (isClickable(ele.get(i))) {
								util.actionMethodClick(driver, ele.get(i));
								// util.jsclick(driver, ele1);
								flag = true;
								i = ele.size();
							}
							else {
								System.out.println("service Status toggle element is not clickable so executing else ");
							}

						}

					}
					allowedVisitors.click();
					allowedVisitors.sendKeys(noOfdefaultvisitors);
					clickOnApply();
					clickOnOk();
					util.validatesuccessmsg(driver, serviceUpdatedmsg, toasteContainer);
				} else {
					// toggleBtn.click();
					//util.jsclick(driver, serviceStatustogglebtn);
					//applyBtn.click();
					Boolean flag = false;
					while (!flag) {
						List<WebElement> ele = driver.findElements(By.xpath("//div[contains(@data-control-name,'TogEditServiceStatus')]//div[@class='appmagic-toggleSwitch no-focus-outline right']//div[@class='appmagic-toggleSwitch-handle']"));
						System.out.println(ele.size());
						for (int i = 0; i < ele.size(); i++)

						{
							if (isClickable(ele.get(i))) {
								util.actionMethodClick(driver, ele.get(i));
								// util.jsclick(driver, ele1);
								flag = true;
								i = ele.size();
							}
							else {
								System.out.println("service Status toggle element is not clickable so executing else ");
							}

						}

					}
					clickOnApply();
					//okBtn.click();
					clickOnOk();
					util.validatesuccessmsg(driver, serviceUpdatedmsg, toasteContainer);
				}
			}
		}
		public void enterCustomMessage(String customMsg) {
			customMessage.click();
			customMessage.sendKeys(customMsg);
		}
		public void defaultAllowedVisitor(String noOfdefaultvisitors) {
			allowedVisitors.click();
			allowedVisitors.sendKeys(noOfdefaultvisitors);
		}

	}
