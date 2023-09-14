package com.sat.Pages;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;



public class StoreSettingsPage {
	private WebDriver driver;

	Testutil testutil = new Testutil();
	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());

	@FindBy(xpath = "(//div[text()='Settings'])[2]") // div[text()='Settings']
	private WebElement Settings2;
	private By Settings1 = By.xpath("//div[text()='Settings']");
	@FindBy(xpath = "//div[text()='Settings']") // div[text()='Settings']
	private WebElement Settings;
	// div[@title='Settings']

	@FindBy(xpath = "(//div[@title='Store Calendars'])[2]") // div[text()='Store Calendars']
	private WebElement StoreCalendar;

	@FindBy(xpath = "//*[text()='Store Settings']")
	private WebElement StoreSettings;
	private By StoreSettings1 = By.xpath("//*[text()='Store Settings']");

	@FindBy(xpath = "(//*[contains(@id,'react-combobox-view')]//div//ul//li[@class='selectedItem_7e8qnb'])[1]")
	private WebElement BrandName;
	// (//*[@class='selectedItem_7e8qnb'])[3]

	@FindBy(xpath = "//button[contains(@class,'buttonReset')]")
	private WebElement Cancleicon;

	@FindBy(xpath = "//*[@aria-label='Brand']")
	private WebElement BrandEntryBox;

	@FindBy(xpath = "//*[@data-control-name='cbCountrySSS']//*[@class='selectedItem_7e8qnb']")
	private WebElement CountryName;

	@FindBy(xpath = "//*[contains(text(),'Hansa')]")
	private WebElement HansaStore;

	@FindBy(xpath = "(//*[@class='appmagic-checkbox-placeholder'])[10]")
	private WebElement hansacheckbox;
	// *[@appmagic-control='cbSelectStoreSSS'])[3]
	// *[@class='checkmark'])[9]

	@FindBy(xpath = "(//*[contains(text(),'Kungsgatan 52')]/parent::div/parent::div/parent::div/parent::div/parent::div)[1]/following-sibling::div[5]")
	private WebElement storeCheckBox;
	// (//*[contains(text(),'Kungsgatan
	// 52')]/parent::div/parent::div/parent::div/parent::div/parent::div)[1]/following-sibling::div[5]

	@FindBy(xpath = "//*[@data-control-name='icnSelectAllOptionsSSS']")
	private WebElement moreoption;

	@FindBy(xpath = "(//*[@class='appmagic-text mousetrap block-undo-redo'])[5]")
	private WebElement defaultVisitor;

	@FindBy(xpath = "(//*[text()='OK'])[2]")
	private WebElement Okbtn;

	@FindBy(xpath = "//*[text()='YES']")
	private WebElement Yes;

	@FindBy(xpath = "//*[@class='appmagic-label no-focus-outline middle']//*[contains(text(),'Hansa')]")
	private WebElement hansaStore;

	@FindBy(xpath = "//div[@data-control-name='TogEditServiceDisplayPortalViewSSS']//*[@class='appmagic-toggleSwitch-label left']")
	private WebElement displayInPortalView;

	@FindBy(xpath = "//*[text()='APPLY']")
	private WebElement applyBtn;

	@FindBy(xpath = "//div[@data-control-name='TogEditServiceDisplayPortalViewSSS']//*[contains(@class,'appmagic-toggleSwitch no-focus-outline right')]")
	private WebElement toggleBtn;
	//(//*[@class='appmagic-toggleSwitch-off'])[2]

	@FindBy(xpath = "//*[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "//*[@data-control-name='icnEditCountrySelect']")
	private WebElement penIcon;

	@FindBy(xpath = "//*[text()='Services updated successfully']")
	private List<WebElement> serviceUpdatedmsg;

	@FindBy(xpath = "//*[text()='Service added successfully']")
	private List<WebElement> ServiceAddedSuccessfully;

	@FindBy(xpath = "//*[text()='View store settings']")
	private WebElement viewStoreSettings;

	@FindBy(xpath = "//div[@data-control-name='excelexportSSS']//following-sibling::div//button[text()='EXPORT TO EXCEL']")
	private WebElement exportToExcel;

	@FindBy(xpath = "//*[@id='toast-container']")
	private List<WebElement> toasteContainer;

	@FindBy(xpath = "//*[text()='Remove']")
	private WebElement remove;

	@FindBy(xpath = "//*[text()='Time period']")
	private WebElement timePeriod;

	@FindBy(xpath = "//*[@class='pika-select pika-select-year']")
	private WebElement selectFromYear;

	@FindBy(xpath = "(//*[@class='pika-select pika-select-year'])[2]")
	private WebElement selectToYear;

	@FindBy(xpath = "//*[@class='pika-select pika-select-month']")
	private WebElement selectFromMonth;

	@FindBy(xpath = "(//*[@class='pika-select pika-select-month'])[2]")
	private WebElement selectToMonth;

	@FindBy(xpath = "//div[@data-control-name='dpEditFromDateBSS' or @data-control-name='dpFromDateCSS' or @data-control-name='dpExportFromDateSSS']/div/div/div/div/div/div")
	private WebElement fromDate;

	@FindBy(xpath = "//div[@data-control-name='dpEditToDateBSS' or @data-control-name='dpToDateCSS' or @data-control-name='dpExportToDateSSS']/div/div/div/div/div/div")
	private WebElement toDate;

	@FindBy(xpath = "//*[@class='appmagic-datepicker-ok-button' and text()='Ok']")
	private WebElement fromDateOk;

	@FindBy(xpath = "(//*[@class='appmagic-datepicker-ok-button' and text()='Ok'])[2]")
	private WebElement toDateOk;

	@FindBy(xpath = "//div[text()='NEXT 🡺']")
	private List<WebElement> nextBtn;

	public StoreSettingsPage(WebDriver driver) {
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

	public void clickOnStoreSettings() {
		Wait.elementToBeClickable(driver, StoreSettings, 1);
		// StoreSettings.click();
		// testutil.jsclick(driver, StoreSettings);
		//testutil.actionMethodClick(driver, StoreSettings);
		//List<WebElement> ele = driver.findElements(StoreSettings1);
		Boolean flag = false;
		while (!flag) {

			List<WebElement> ele = driver.findElements(StoreSettings1);
			for (int i = 0; i < ele.size(); i++)
			{
				if (isClickable(ele.get(i))) {
					System.out.println("click on Store Settings");
					//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele.get(i));
					// ele.get(i).click();
					// testutil.jsclick(driver,ele.get(i));
					testutil.actionMethodClick(driver, ele.get(i));
					System.out.println("clicked on Store Settings");
					flag = true;
					i = ele.size();
				}

			}
		}
		System.out.println("Clicked on Store settings");
	}

	public void clickOnSettings() {
		Wait.untilPageLoadComplete(driver);
		Wait.elementToBeClickable(driver, Settings, 2);
		// Settings.click();
		// testutil.jsclick(driver, Settings);
		// testutil.actionMethodClick(driver, Settings);
		//List<WebElement> ele = driver.findElements(Settings1);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(Settings1);
			for (int i = 0; i < ele.size(); i++)
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele.get(i));
				if (isClickable(ele.get(i))) {
					System.out.println("click on Settings");
					// ele.get(i).click();
					// testutil.jsclick(driver,ele.get(i));
					testutil.actionMethodClick(driver, ele.get(i));
					System.out.println("clicked on Settings");
					flag = true;
					i = ele.size();
				}

			}

		}
	}

	public void clickOnStore(String storeName) {
		//WebElement we = driver.findElement(By.xpath("//*[@class='appmagic-label no-focus-outline middle']//*[contains(text(),'" + storeName + "')]"));
		//Wait.elementToBeClickable(driver, we, 5);
		//Wait.untilPageLoadComplete(driver, 10);
		// we.click();
		//testutil.actionMethodClick(driver, we);
		//List<WebElement> ele = driver.findElements(By.xpath("//*[@class='appmagic-label no-focus-outline middle']//*[contains(text(),'" + storeName + "')]"));
		//System.out.println(ele.size());
		Boolean flag = false;
		while (!flag) {
			List<WebElement> Service = driver.findElements(By.xpath("//*[@class='appmagic-label no-focus-outline middle']//*[contains(text(),'" + storeName + "')]"));
			System.out.println(Service.size());
			System.out.println(Service);
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
			else {
				for (int i = 0; i < nextBtn.size(); i++){
					if (isClickable(nextBtn.get(i))) {
						testutil.actionMethodClick(driver, nextBtn.get(i));
						// util.jsclick(driver, ele1);
						i = nextBtn.size();
					}
					else {
						System.out.println("Next Button is not clickable so executing else");
					}

				}
			}
		}
	}

	public void clickOnService(String serviceName) {
		WebElement we = driver.findElement(By.xpath(
				"//div[@class='virtualized-gallery-item galleryCanvasContentDiv transforms_3hmsj']//div//div[contains(text(),'"
						+ serviceName
						+ "')]//parent::div//parent::div//parent::div//parent::div//parent::div//following-sibling::div[@data-control-name='icnSettingsSSS']"));
		// div[@class='virtualized-gallery-item galleryCanvasContentDiv
		// transforms_3hmsj']//div//div[contains(text(),'Auto')]//parent::div//parent::div//parent::div//parent::div//parent::div//ancestor::div[@class='appmagic-content-control-nam']
		Wait.elementToBeClickable(driver, we, 3);
		// we.click();
		testutil.actionMethodClick(driver, we);
	}

	public void displayInPortalView(String viewStatus) {
		String Status = displayInPortalView.getText();
		System.out.println("in the method displayInPortalView printing the status of toggle btn ---" + Status);
		if (Status.equals(viewStatus)) {
			//applyBtn.click();
			Boolean flag = false;
			while (!flag) {
				List<WebElement> ele = driver.findElements(By.xpath("//*[text()='APPLY']"));
				for (int i = 0; i < ele.size(); i++)
				{

					if (isClickable(ele.get(i))) {
						System.out.println("click on Apply");
						// ele.get(i).click();
						// testutil.jsclick(driver,ele.get(i));
						testutil.actionMethodClick(driver, ele.get(i));
						System.out.println("clicked on Apply");
						flag = true;
						i = ele.size();
					}

				}
				//okBtn.click();
				//StoreCalendars.clickOnApply();
				Wait.elementToBeClickable(driver, okBtn, 3);
				StoreCalendars.clickOnOk();
				// testutil.validatesuccessmsg(driver, serviceUpdatedmsg);
			}
		}
		else {
			// toggleBtn.click();
			testutil.actionMethodClick(driver, toggleBtn);
			Wait.elementToBeClickable(driver, applyBtn, 10);

			// applyBtn.click();
			Boolean flag = false;
			while (!flag) {
				List<WebElement> ele = driver.findElements(By.xpath("//*[text()='APPLY']"));
				for (int i = 0; i < ele.size(); i++)
				{

					if (isClickable(ele.get(i))) {
						System.out.println("click on Apply");
						// ele.get(i).click();
						// testutil.jsclick(driver,ele.get(i));
						testutil.actionMethodClick(driver, ele.get(i));
						System.out.println("clicked on Apply");
						flag = true;
						i = ele.size();
					}

				}
				Wait.elementToBeClickable(driver, okBtn, 3);
				//okBtn.click();
				//StoreCalendars.clickOnApply();
				StoreCalendars.clickOnOk();
				// testutil.validatesuccessmsg(driver, serviceUpdatedmsg);
			}
		}
	}

	public void testAssertExpextedText(String ExpectedString)
	{
		System.out.println("ExpectedString is: " + ExpectedString);
		String[] parts = ExpectedString.split(	"[.]", 0) ;
		List<String> parts1 = Arrays.asList(parts);
		Iterator<String> iterator = parts1.iterator(); 
		String t = iterator.next();
		String t1 = t +".";
		String Title1= driver.findElement(By.xpath("//div[@class='xrm-attribute-value'][normalize-space()='"+t1+"']")).getAttribute("textContent");
		//div[@class='xrm-attribute-value'][normalize-space()='Unfortunately, we do not have any available times on this day.']
		System.out.println("Title 1"+Title1);
		String Title2= driver.findElement(By.xpath("//div[contains(text(),'"+iterator.next()+"')]")).getAttribute("textContent");
		System.out.println("Title 2"+Title2);
		String actualString= Title1 +Title2;
		System.out.println(actualString);
		Assert.assertEquals(ExpectedString, actualString);
	}
	public void testAssertClicknext(String ExpectedString, String splitStrng)
	{
		String[] parts = splitStrng.split(	"[.]", 0) ;
		List<String> parts1 = Arrays.asList(parts);
		Iterator<String> iterator = parts1.iterator(); 
		System.out.println(iterator.next());
		driver.findElement(By.xpath("//div[contains(text(),'"+iterator.next()+"')]")).click();
		String String1= driver.findElement(By.xpath("//div[@id='noAvailable-slots']//div[@class='xrm-attribute-value']")).getAttribute("textContent");
		String actualString= String1.trim();
		System.out.println("This is Actual text:"+actualString);
		System.out.println("This is Expected text:"+ExpectedString);
		//Assert.assertEquals(ExpectedString, actualString);

	}
	public void ValidateNoSlotMsg(String ExpectedString, String ExpectedString2)
	{
		
		String Actual1=driver.findElement(By.xpath("//div[contains(text(),'"+ExpectedString+"')]")).getText();
		System.out.println("The Actual Text"+Actual1);
	    Assert.assertEquals(ExpectedString, Actual1);
	    String Actual2=driver.findElement(By.xpath("//div[contains(text(),'"+ExpectedString2+"')]")).getText();
		System.out.println("This is Actual next text:"+Actual2);
		Assert.assertEquals(ExpectedString2, Actual2);

	}


	public void clickOnAvailableStore() {
		penIcon.click();
	}
	public void clickOnPenIcon() {
		penIcon.click();
	}

	public void selectStoreSettingBrand(String NameOfTheBrand) throws InterruptedException {
		Thread.sleep(3000);
		Wait.untilPageLoadComplete(driver, 10);
		Wait.elementToBeClickable(driver, BrandName, 3);
		//BrandName.click();
		//testutil.actionMethodClick(driver, BrandName);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(By.xpath("//*[contains(@id,'react-combobox-view')]//div//ul//li[@class='selectedItem_7e8qnb']"));
			for (int i = 0; i < ele.size(); i++)
			{

				if (isClickable(ele.get(i))) {
					System.out.println("click on Brand");
					// ele.get(i).click();
					// testutil.jsclick(driver,ele.get(i));
					testutil.actionMethodClick(driver, ele.get(i));
					System.out.println("clicked on Brandname");
					flag = true;
					i = ele.size();
				}

			}

		}
		Wait.elementToBeClickable(driver, Cancleicon, 3);
		Wait.elementToBeClickable(driver, Cancleicon, 3);
		testutil.actionMethodClick(driver, Cancleicon);
		Actions action = new Actions(driver);
		WebElement we = driver
				.findElement(By.xpath("//span[text()='" + NameOfTheBrand + "' and @class='itemTemplateLabel_dqr75c']"));
		Wait.elementToBeClickable(driver, we, 3);
		// Wait.waitUntilElementVisible(driver, we);
		action.moveToElement(we).click().build().perform();
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		System.out.println("Selected Brand");
	}

	public void selectStoreSettingCountry(String NameOfTheCountry) {
		Wait.elementToBeClickable(driver, CountryName, 2);
		System.out.println("Select country");
		CountryName.click();
		System.out.println("Selected country");
		Wait.elementToBeClickable(driver, Cancleicon, 2);
		Cancleicon.click();
		System.out.println("clicked on cancle icon");
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(
				By.xpath("//*[@class='itemTemplateLabel_dqr75c' and contains(text(),'" + NameOfTheCountry + "')]"));
		Wait.elementToBeClickable(driver, we, 2);
		Wait.waitUntilElementVisible(driver, we);
		action.moveToElement(we).click().perform();
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		System.out.println("Selected Country");
	}

	/*
	 * public void storeEnableorDisable(String NameOfTheBrand, String
	 * NameOfTheCountry, String serviceStatus, String ServiceName) throws
	 * InterruptedException { // Wait.waitUntilElementVisible(driver, Settings);
	 * Wait.elementToBeClickable(driver, Settings2, 10);
	 * testutil.actionMethodClick(driver, Settings2);
	 * Wait.elementToBeClickable(driver, StoreSettings, 1); StoreSettings.click();
	 * System.out.println("Clicked on Store settings");
	 * Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
	 * Wait.elementToBeClickable(driver, BrandName, 2);
	 * selectStoreSettingBrand(NameOfTheBrand);
	 * selectStoreSettingCountry(NameOfTheCountry); //
	 * Wait.elementToBeClickable(driver, hansacheckbox, 1); //
	 * hansacheckbox.click(); WebElement storeCheckBox =
	 * driver.findElement(By.xpath("(//*[contains(text(),'" + ServiceName +
	 * "')]/parent::div/parent::div/parent::div/parent::div/parent::div)[1]/following-sibling::div[5]"
	 * )); // Wait.untilPageLoadComplete(driver, 10);
	 * Wait.elementToBeClickable(driver, storeCheckBox, 2);
	 * testutil.actionMethodClick(driver, storeCheckBox); //
	 * testutil.jsclick(driver, storeCheckBox); Wait.elementToBeClickable(driver,
	 * moreoption, 2); moreoption.click(); WebElement status =
	 * driver.findElement(By.xpath("//*[text()='" + serviceStatus + "']")); if
	 * (serviceStatus == "Enable selected") { // Enable selected status.click(); }
	 * else { // Disable selected status.click(); }
	 * Wait.elementToBeClickable(driver, defaultVisitor, 2); defaultVisitor.click();
	 * defaultVisitor.sendKeys("15"); Wait.elementToBeClickable(driver, Okbtn, 2);
	 * Okbtn.click(); WebDriverWait w = new WebDriverWait(driver, 10); //
	 * w.until(ExpectedConditions.visibilityOfElementLocated //
	 * (By.xpath("//*[text()='Store opened successfully']"))); // List<WebElement>
	 * ele = driver.findElements(By.xpath("//*[text()='Store opened //
	 * successfully']")); // Assert.assertTrue("WebElement not found",
	 * ele.size()!=0); // *[text()='Services updated successfully'] }
	 */
	public void storeServicesEnableorDisable(String serviceStatus, String storeName) {
		selectStoreCheckBox(storeName);
		Wait.elementToBeClickable(driver, moreoption, 2);
		moreoption.click();
		WebElement status = driver.findElement(By.xpath("//*[text()='" + serviceStatus + "']"));
		System.out.println(serviceStatus);
		if (serviceStatus.equals("Enable selected")) {
			// Enable selected
			System.out.println("Enable selected");
			System.out.println("executing enable block");
			status.click();
			Wait.elementToBeClickable(driver, defaultVisitor, 2);
			System.out.println("click on default visitor");
			defaultVisitor.click();
			System.out.println("clicked on default visitor");
			defaultVisitor.sendKeys("15");
			System.out.println("completed enable block");
		} else {
			// Disable selected
			Wait.elementToBeClickable(driver, status, 2);
			status.click();
		}
		Wait.elementToBeClickable(driver, Okbtn, 2);
		//Okbtn.click();
		//List<WebElement> ele = driver.findElements(By.xpath("//*[text()='OK']"));
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(By.xpath("//*[text()='OK']"));
			for (int i = 0; i < ele.size(); i++)
			{

				if (isClickable(ele.get(i))) {
					System.out.println("click on OK");
					// ele.get(i).click();
					// testutil.jsclick(driver,ele.get(i));
					testutil.actionMethodClick(driver, ele.get(i));
					System.out.println("clicked on OK");
					flag = true;
					i = ele.size();
				}

			}

		}
		testutil.validatesuccessmsg(driver, serviceUpdatedmsg, toasteContainer);
	}


	/* Select the check box of Service in the Store Settings page */
	public void selectStoreCheckBox(String storeName) {
		boolean flag = true;
		while(flag) {
			//driver.navigate().refresh();
			//TargetLocator currentFrame = driver.switchTo();
			//currentFrame.frame("fullscreen-app-host");
			List<WebElement> storeCheckBox1 = driver.findElements(
					By.xpath("//*[@class='appmagic-label no-focus-outline middle']//*[contains(text(),'" + storeName
							+ "')]//parent::div//parent::div//parent::div//parent::div//parent::div//following-sibling::div[@data-control-name='cbSelectStoreSSS']"));
			System.out.println(storeCheckBox1);
			for(int j =0; j<storeCheckBox1.size();j++) {
				if (storeCheckBox1.size() != 0 & isClickable(storeCheckBox1.get(j))) {
					WebElement storeCheckBox = driver.findElement(
							By.xpath("//*[@class='appmagic-label no-focus-outline middle']//*[contains(text(),'" + storeName
									+ "')]//parent::div//parent::div//parent::div//parent::div//parent::div//following-sibling::div[@data-control-name='cbSelectStoreSSS']"));
					//if (isClickable(storeCheckBox)){
					Wait.elementToBeClickable(driver, storeCheckBox, 2);
					testutil.actionMethodClick(driver, storeCheckBox);
					flag = false;
					storeCheckBox1.clear();
					storeCheckBox1.removeAll(storeCheckBox1);
				}
			}

			for (int i = 0; i < nextBtn.size(); i++){
				if (isClickable(nextBtn.get(i))) {
					testutil.actionMethodClick(driver, nextBtn.get(i));
					// util.jsclick(driver, ele1);
					i = nextBtn.size();
				}
				else {
					System.out.println("Next Button is not clickable so executing else");

				}
			}
		}
	}

	public void validateServiceAddedMsgInStoreLevel() {
		// List<WebElement> we =
		// driver.findElements(By.xpath("//*[text()='"+Successmsg+"']"));
		testutil.validatesuccessmsg(driver, ServiceAddedSuccessfully, toasteContainer);
	}
	public void clickOnStoreMoreOption(String storeName) {
		//		WebElement we = driver.findElement(By.xpath("//*[contains(text(),'"+storeName+"')]/ancestor::div[@data-control-name='lblStoreSSS']/following-sibling::div[@data-control-name='icnMoreOptionsStoreSSS']//div[@class='powerapps-icon no-focus-outline']"));
		//		testutil.actionMethodClick(driver, we);
		//		Wait.elementToBeClickable(driver, we, 5);
		//		we.click();
		boolean flag = true;
		while(flag) {
			List<WebElement> moreOptionList = driver.findElements(By.xpath("//*[contains(text(),'"+storeName+"')]/ancestor::div[@data-control-name='lblStoreSSS']/following-sibling::div[@data-control-name='icnMoreOptionsStoreSSS']//div[@class='powerapps-icon no-focus-outline']"));
			for(int j =0; j<moreOptionList.size();j++) {
				if (moreOptionList.size() != 0 & isClickable(moreOptionList.get(j))) {
					WebElement moreOptionList1 = driver.findElement(By.xpath("//*[contains(text(),'"+storeName+"')]/ancestor::div[@data-control-name='lblStoreSSS']/following-sibling::div[@data-control-name='icnMoreOptionsStoreSSS']//div[@class='powerapps-icon no-focus-outline']"));
					Wait.elementToBeClickable(driver, moreOptionList1, 2);
					testutil.actionMethodClick(driver, moreOptionList1);
					flag = false;
					moreOptionList.clear();
					moreOptionList.removeAll(moreOptionList);
					break;
				}
			}
			for (int i = 0; i < nextBtn.size(); i++){
				if (isClickable(nextBtn.get(i))) {
					testutil.actionMethodClick(driver, nextBtn.get(i));
					// util.jsclick(driver, ele1);
					i = nextBtn.size();
				}
				else {
					System.out.println("Next Button is not clickable so executing else");
				}
			}	
		}
	}
	public void clickOnViewStoreSettings() {
		//WebElement we = driver.findElement(By.xpath("//*[@class='appmagic-label no-focus-outline middle']//*[contains(text(),'Hansa')]//parent::div//parent::div//parent::div//parent::div//parent::div//following-sibling::div[@data-control-name='icnMoreOptionsStoreSSS']"));
		//testutil.actionMethodClick(driver, we);
		//we.click();
		viewStoreSettings.click();
	}
	public void clickOnExportToExcel() {
		exportToExcel.click();
		Wait.untilPageLoadComplete(driver, 10);
		Wait.elementToBeClickable(driver, exportToExcel, 5);
		//testutil.actionMethodClick(driver, exportToExcel);

	}
	/*public boolean validateDownloadedFile(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		          // File has been found, it can now be deleted:
		          dirContents[i].delete();
		          return true;
		      }
		          }
		      return false;
		  }
	}*/
	public void validateDownloadedFile(String downloadedPath, String fileName) {
		File file = new File(downloadedPath);
		System.out.println(file);
		File[] dirContents = file.listFiles();
		System.out.println(dirContents.length);
		for (int i = 0; i < dirContents.length; i++) {
			System.out.println(dirContents[i].getName());
			if (dirContents[i].getName().contains(fileName)){
				// File has been found, it can now be deleted:
				//dirContents[i].delete();
				break;
			}
			else {
				System.out.println("file not found");
			}
		}
	}
	public void selectFromDateAndToDate(String fmDate, String fmYear, String fmMonth, String tDate, String tYear,
			String tMonth) {
		System.out.println("click on from date");
		fromDate.click();
		// Select dropYear = new
		// Select(driver.findElement(By.xpath("//*[@class='pika-select
		// pika-select-year']")));
		// dropYear.selectByValue(fmYear);
		testutil.actionMethodClick(driver, selectFromYear);
		selectFromYear.sendKeys(fmYear, Keys.ENTER);

		// WebElement ee = driver.findElement(By.xpath("//*[@class='pika-select
		// pika-select-month']"));
		// Select dropMonth = new Select(ee);
		// dropMonth.selectByVisibleText(fmMonth);
		testutil.actionMethodClick(driver, selectFromMonth);
		selectFromMonth.sendKeys(fmMonth, Keys.ENTER);

		WebElement we = driver
				.findElement(By.xpath("//*[@class='pika-single is-bound']//td[@data-day='" + fmDate + "']"));
		we.click();
		fromDateOk.click();
		//StoreCalendars.clickOnOk();
		System.out.println("clicked on from date");

		toDate.click();
		// Select dropYear2 = new
		// Select(driver.findElement(By.xpath("//*[@class='pika-select
		// pika-select-year']")));
		// dropYear2.selectByValue(tYear);
		/*Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = selectToYear;
			System.out.println(ele.size());
			for (int i = 0; i < ele.size(); i++)

			{
				if (isClickable(ele.get(i))) {
					Wait.elementToBeClickable(driver, ele.get(i), 5);
					testutil.actionMethodClick(driver, ele.get(i));
					Wait.waitUntilElementVisible(driver, ele.get(i));
					ele.get(i).sendKeys(tYear, Keys.ENTER);
					// util.jsclick(driver, ele1);
					flag = true;
					i = ele.size();
				}
				else {
					System.out.println("element is not clickable so executing else");
				}

			}

		}*/
		testutil.actionMethodClick(driver, selectToYear);
		selectToYear.sendKeys(tYear, Keys.ENTER);

		// WebElement ee1 = driver.findElement(By.xpath("//*[@class='pika-select
		// pika-select-month']"));
		// Wait.elementToBeClickable(driver, ee1, 2);
		// Select dropMonth2 = new Select(ee1);
		// Wait.elementToBeClickable(driver, ee1, 3);
		// dropMonth2.selectByVisibleText(tMonth);
		// dropMonth2.selectByValue(tMonth);
		testutil.actionMethodClick(driver, selectToMonth);
		selectToMonth.sendKeys(tMonth, Keys.ENTER);

		WebElement we1 = driver
				.findElement(By.xpath("//*[@class='pika-single is-bound']//td[@data-day='" + tDate + "']"));
		we1.click();
		Wait.elementToBeClickable(driver, toDateOk, 2);
		toDateOk.click();
		//StoreCalendars.clickOnOk();
	}

}