package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.sat.testUtil.*;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;

public class ResaleAppLoginPage {
	private WebDriver driver;
	Wait waits = new Wait();
	Testutil util = new Testutil();

	// Login to the Resale app
	@FindBy(name = "loginfmt")
	private WebElement app_emailID;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Nextbtn;
	@FindBy(name = "passwd") // xpath = "//*[@name='passwd']
	private WebElement app_password;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Signin;
	@FindBy(name = "DontShowAgain")
	private WebElement DontShowcheckbox;
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement yesbtn;

	// Search for existing seller
	@FindBy(xpath = "//div[text()='ADD']")
	private WebElement addbtn;
	@FindBy(xpath = "//input[@appmagic-control='txtSearchSellerMIStextbox']")
	private WebElement existingUser;
	/*
	 * @FindBy(xpath =
	 * "//input[@appmagic-control='txtSearchPRStextbox' or @appmagic-control='txtSearchMSS_1textbox' or @appmagic-control='txtSearchPFStextbox']"
	 * ) private WebElement searchbox;
	 */
	@FindBy(xpath = "//div[contains(@data-control-name,'lblSellerPRS') or contains(@data-control-name,'lblGallerySellerNameMSS')]/descendant::div[@class='appmagic-borderfill-container']")
	private WebElement sellerSelection;


	@FindBy(xpath = "//*[@id='toast-container']")
	private List<WebElement> toasteContainer;

	@FindBy(xpath = "//*[text()='ACTIVATE']")
	private WebElement activatebtn;
	/*
	 * @FindBy(xpath = "//div[text()='sriswathianusha.nulu@hcl.com']") //
	 * div[text()='sriswathianusha.nulu@hcl.com'] private WebElement
	 * selectExistingUser1;
	 */
	// Adding iban number to the new seller
	@FindBy(xpath = "//*[text()='HM Group employee']/preceding-sibling::div[@class='appmagic-checkbox-placeholder']") // div[@class='appmagic-checkbox-placeholder']
	private WebElement employeeChkbox;
	@FindBy(xpath = "//*[text()='ENTER BANK ACCOUNT']")
	private WebElement bankaccChkbox;
	@FindBy(xpath = "//input[contains(@appmagic-control,'txtAccountNumberM')]") // input[@appmagic-control='txtAccountNumberMIStextbox']  --- //input[contains(@appmagic-control,'txtAccountNumberM')]
	private WebElement IBANnumfield;
	//input[@appmagic-control='txtAccountNumberMSStextbox']

	@FindBy(xpath = "//div[text()='SAVE']/parent::div") // div[contains(@data-control-name,'btnSaveExistingItemDetailsMIS')]
	private WebElement IBANsavebtn;

	@FindBy(xpath = "//div[text()='ACTIVATE']/parent::div") // div[text()='Activate']/parent::div
	private WebElement activateBtn;
	@FindBy(xpath = "//div[@data-control-name='icnBankBackMSS']")
	private WebElement backBtn;
	@FindBy(xpath = "//div[@class='toast-message']")
	private List<WebElement> Successmessage;
	
	
	
	@FindBy(xpath = "//div[@class='Item details updated successfully']")
	private List<WebElement> saveSuccessmessage;
	
	@FindBy(xpath = "//div[text()='B2B Seller added successfully']")
	private List<WebElement> b2bsavesussmsg;
	// *[contains(text(),'Your IBAN seems invalid')]
	// Your IBAN seems invalid, please check all information is entered correctly]
	// Adding item to the existing seller account
	@FindBy(xpath = "//div[text()='Items']/parent::div")
	private WebElement items;
	@FindBy(xpath = "(//*[@data-control-name='lblUnsoldAddedByCustomerMIS_1'])[1]") // div[contains(@aria-label,'Status.// Selected:')]
	//div[contains(@data-control-name,'cbExistingItemStatusMIS')]
	private WebElement displayStatusOfItem;
	@FindBy(xpath = "(//div[text()='Pre registered']/parent::div//ancestor::div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')])[1]")
	// *[text()='Pre registered']
	// div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')]//*[text()='Pre
	// registered']/parent::div
	private WebElement preregstatus;
	@FindBy(xpath = "//div[text()='ADD ID' or text()='EDIT ID']/parent::div")
	private WebElement ADD_ID;
	@FindBy(xpath = "//div[contains(@data-control-name,'icnSelectAllOptionsSS_2')]//div[@class='powerapps-icon no-focus-outline']")
	private WebElement threedotsitemtab;
	@FindBy(xpath = "//div[text()='Add item ID manually']")
	private WebElement addItemIdManually;
	@FindBy(xpath = "//*[@appmagic-control='txtAddItemIdMIStextbox']")
	private WebElement itemNumber;
	@FindBy(xpath = "//div[text()='OK']/ancestor::div[@data-control-name='btnOkItemIdPopUpMIS']")
	private WebElement itemIdOk;

	// Adding new item- Pending
	@FindBy(xpath = "//div[text()='ADD ITEM']")
	private WebElement addItem;
	/*
	 * @FindBy(xpath =
	 * "//div[contains(@data-control-name,'ddExistingItemConditionMIS')]//div[contains(@class,'appmagic-dropdownLabelText')]")
	 * private WebElement unsoldItemdropdown;
	 */// div[@class='appmagic-dropdownLabelArrow']
	@FindBy(xpath = "//*[text()='NEXT']/parent::div ") // *[text()='Next']/parent::div
	private WebElement nextBtnforNewItem;
	@FindBy(xpath = "(//div[text()='SAVE']/parent::div)[4]")
	private WebElement saveBtnNewItem;
	@FindBy(xpath = "//div[text()='DONE']/parent::div[@class='appmagic-button middle center']")
	private WebElement doneBtn;
	@FindBy(xpath = "//*[text()='Seller details updated successfully']")
	private List<WebElement> usersavedmsg;

	// div[@data-control-name='icnRefreshMSS']
	// Item changing from Preregistered to Instore

	/*
	 * @FindBy(xpath =
	 * "//div[text()='In Store']/parent::div//ancestor::div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')]"
	 * ) // *[text()='Pre private WebElement instoreStatus;
	 */
	@FindBy(xpath = "//div[@data-control-name='cbExistingTopBrandsMIS']")
	private WebElement brandList;
	@FindBy(xpath = "//div[contains(@aria-label,'Gender. ')]") // div[@aria-label='Gender. ']
	private WebElement genderList;
	@FindBy(xpath = "//div[@data-control-name='cbExistingItemCategoryMIS']")
	private WebElement categoryList;
	@FindBy(xpath = "//div[@data-control-name='cbExistingItemSizeMIS']") // span[text()='Select size ']
	private WebElement sizelist;
	@FindBy(xpath = "//div[@data-control-name='ddExistingItemConditionMIS']")
	private WebElement conditionList;
	@FindBy(xpath = "//div[@data-control-name='cbMaterialSelection']")
	private WebElement materialField;
	//div[@data-control-name='cbColorSelection']
	@FindBy(xpath = "//div[@data-control-name='cbColorSelection']")
	private WebElement colorField;
	@FindBy(xpath = "//div[contains(@aria-label,'Price. ')]") // div[@aria-label='Price. ']
	private WebElement pricelist;
	@FindBy(xpath = "//div[@data-control-name='ddStore_3']//*[@class='appmagic-dropdownLabelArrow']") // div[@data-control-name='lblNewStore_3']
	private WebElement storelist;
	@FindBy(xpath = "//div[@data-control-name='dpExistingPickUpDateMIS']//input[@class='datepicker-textbox']")
	private WebElement openCalendar;
	@FindBy(xpath = "//select[@class='pika-select pika-select-month']")
	private WebElement selectMonth;
	@FindBy(xpath = "//select[@class='pika-select pika-select-year']")
	private WebElement selectYear;
	@FindBy(xpath = "//button[text()='Ok']")
	private WebElement okBtn;

	@FindBy(xpath = "//div[text()='SAVE']")
	private WebElement saveBtn;

	private By saveButton = By.xpath("//div[text()='SAVE']");

	// Sign the agreement
	@FindBy(xpath = "(//div[text()='SAVE'])[2]")
	private WebElement save;
	@FindBy(xpath = "//div[text()='ID Verified']") // *[text()='ID Verified']/preceding-sibling::div/../..
	private WebElement verify;
	//div[@data-control-name='cbIsIDVerifiedMSS']//*[@class='appmagic-checkbox-placeholder']
	@FindBy(xpath = "//*[text()='I AGREE']")
	private WebElement agree;
	@FindBy(xpath = "//*[@class='appmagic-inkControl-draw-canvas']")
	private WebElement signature_box;


	@FindBy(xpath = "(//div[text()='SAVE']/parent::div)[2]") // (//div[text()='SAVE'])[3]
	private WebElement save_btn;

	@FindBy(xpath = "//div[contains(@data-control-name,'icnCancelExistingItemDetailsMIS')]//*[@class='powerapps-icon no-focus-outline']")
	private WebElement Cancel_btn;
	// (//div[contains(@data-control-name,'icnCancelExistingItemDetailsMIS')]
	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement close_icon;

	// Status Change to Expired
	@FindBy(xpath = "//div[contains(@aria-label,'Status. Selected:')]")
	private WebElement statusDropdwon;
	@FindBy(xpath = "//button[contains(@aria-label,'Remove')]")
	private WebElement xicon;

	// Refresh at left tab
	@FindBy(xpath = "//div[@data-control-name='icnRefreshCounts']")
	private WebElement refreshBtn;

	// refresh at Right window
	@FindBy(xpath = "(//div[contains(@data-control-name,'icnRefresh')])[4]")
	private WebElement refreshBtnatRighttab;

	// Cross symbol in dropdowns
	/*
	 * @FindBy(xpath = "//button[contains(@class,'buttonReset')]") private
	 * WebElement cancelIcon;
	 */

	// Declining item
	@FindBy(xpath = "//div[text()='DECLINE ITEM']/ancestor::button")
	private WebElement declineBtn;
	@FindBy(xpath = "(//div[text()='DECLINE ITEM']/ancestor::button)[2]")
	private WebElement declineBtnInPopup;

	// Order the sellers
	@FindBy(xpath = "//div[text()='SHOW ALL SELLERS']")
	private WebElement showAllSellersLink;
	@FindBy(xpath = "//div[@data-control-name='icnSortSellerNameMSS']")
	private WebElement sellerField;
	/*
	 * @FindBy(xpath=
	 * "//div[contains(@data-control-name,'lblGallerySellerNameMSS')]") private
	 * WebElement listOfItems;
	 */
	@FindBy(xpath = "//div[@data-control-name='btnNextMSS']")
	private WebElement nextBtn;
	@FindBy(xpath = "//*[contains(text(),\"Item status updated to 'Broken'\")]")
     private List<WebElement> updatesucessmsg;
	// Adding B2B seller
	@FindBy(xpath = "//div[text()='ADD B2B SELLER']/parent::div")
	private WebElement addB2BBtn;
	@FindBy(xpath = "//input[contains(@appmagic-control,'txtB2BSellerName')]")
	private WebElement nameField;

	// Add agreement
	@FindBy(xpath = "//div[text()='ADD AGREEMENT']/parent::div")
	private WebElement addAgrmentBtn;
	@FindBy(xpath = "//div[@data-control-name='cbBrandMAS']")
	private WebElement brandropdownVal;

	// sing agreement for Pre-Register item
	@FindBy(xpath = "(//div[text()='Pre registered']/ancestor::div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')]//following-sibling::div[contains(@data-control-name,'cbSelectItemMIS')])[1]")
	private WebElement chkboxPreregItem;
	@FindBy(xpath = "//div[@data-control-name='btnSignPreRegItemsMIS']//div[@class='appmagic-button middle center']")
	private WebElement signInPreRegisterBtn;

	// Change the store
	@FindBy(xpath = "(//input[contains(@appmagic-control,'cbSelectItemMIS')])[1]")
	private WebElement chkboxForItem;
	@FindBy(xpath = "//div[contains(@data-control-name,'icnSelectAllOptionsSS_1')]//div[@class='powerapps-icon no-focus-outline']")
	private WebElement thressdots;
	@FindBy(xpath = "//div[contains(@data-control-name,'icnSelectAllOptionsSS_IST')]//div[@class='powerapps-icon no-focus-outline']")
	private WebElement thressdotsExpiredScreen;
	@FindBy(xpath = "//div[text()='Broken']")
	private WebElement chngStore;
	@FindBy(xpath = "//div[text()='Södra Larmgatan 12(SE0650)']")
	private WebElement storeSelection;
	@FindBy(xpath = "//*[text()='Are you sure you want to remove?']")
	private WebElement areYouSureYouWantToRemove;
	@FindBy(xpath = "//input[contains(@appmagic-control,'txtSearchSellerMIS_2_1textbox')]")
	private WebElement Search_Itemtxt;
	@FindBy(xpath = "//div[contains(text(),'ADD NEW BRAND')]")
	private WebElement AddNewBrand;
	
	@FindBy(xpath = "//input[contains(@appmagic-control,'txtAddNewBrandtextbox')]")
	private WebElement AddBrand;
	
	@FindBy(xpath = "//div[@data-control-name='btnOkItemIdPopUpMIS_10']//div[text()='ADD']")
	private WebElement AddBtn;
	
	@FindBy(xpath = "//*[text()='New brand Elizabeth ArdenI has been created']")
	private List<WebElement> NewBrandAddToastMsg;
	
	@FindBy(xpath = "(//div[@data-control-name='icnSelectExistingItemMIS_2'])[1]")
	private WebElement openItemInstore;
	
	@FindBy(xpath = "//input[@appmagic-control='txtEmailMSStextbox']")
	private WebElement sellertabSellerEmail;
	
	
	
	
	public Map<String, String> statusOfItem = new HashMap<>();

	public ResaleAppLoginPage(WebDriver driver) {
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

	ResaleAdminPage admin = new ResaleAdminPage(TestBase.getDriver());

	public void resaleAppLogin(String userid, String password) throws InterruptedException {
		app_emailID.sendKeys(userid);
		Nextbtn.click();
		Wait.elementToBeClickable(driver, app_password, 2);
		app_password.sendKeys(password);
		Wait.elementToBeClickable(driver, Signin, 2);
		Signin.click();
		Wait.untilPageLoadComplete(driver, 10);
		/*
		 * DontShowcheckbox.click(); yesbtn.click();
		 */
		Wait.untilPageLoadComplete(driver, 30);
		//close_icon.click();
		TargetLocator currentFrame = driver.switchTo();
		currentFrame.frame("fullscreen-app-host");
	}
	public void switchToFrame() {
		TargetLocator currentFrame = driver.switchTo();
		currentFrame.frame("fullscreen-app-host");
	}
	
	public void ClickOnCancelCross()
	{
		WebElement tab = driver.findElement(By.xpath("//div[@data-control-name='btnCancelExistingItemDetailsMIS']//div[text()='CANCEL']"));
		tab.click();
		Alert alert = driver.switchTo().alert();   
		  alert.dismiss();
	}

	public void selectExistingSeller(String existingUserName, String tabSelection) throws InterruptedException {
		//Wait.untilPageLoadComplete(driver);
		WebElement tab = driver.findElement(By.xpath("//div[text()='" + tabSelection + "' and @class='appmagic-button-label no-focus-outline']"));
		//div[text()='" + tabSelection + "']/parent::div[@class='appmagic-button middle left']
		//div[text()='" + tabSelection + "' and @class='appmagic-button-label no-focus-outline']
		Wait.elementToBeClickable(driver, tab, 2);
		util.actionMethodClick(driver, tab);
		String tabName = tab.getText();
		if (tabName.equals("All Items")) {
			Wait.elementToBeClickable(driver, addbtn, 2);
			// addbtn.click();
			try {
				util.actionMethodClick(driver, addbtn);
			} catch (Exception e) {
				util.actionMethodClick(driver, addbtn);
			}
			Wait.waitForVisibilityOfElementLocated(driver, existingUser, 10);
			Wait.elementToBeClickable(driver, existingUser, 10);
			//existingUser.click();
			util.actionMethodClick(driver, existingUser);
			existingUser.sendKeys(existingUserName, Keys.ENTER);
			WebElement we = driver.findElement(By.xpath("//div[text()='" + existingUserName + "']/parent::div"));
			// div[contains(@data-control-name,'lblFirstnameGalSellerMIS')] --> Tester
			// swathi
			util.actionMethodClick(driver, we);
		} else {

			if (tabName.equals("All Sellers") || tabName.equals("Pre-Register") || tabName.equals("Payout failed")) {
				String txtxpath = getSearchXpath(tabSelection);
				WebElement searchbox = driver
						.findElement(By.xpath("//input[contains(@appmagic-control,'" + txtxpath + "')]"));
				Wait.elementToBeClickable(driver, searchbox, 3);
				searchbox.sendKeys(existingUserName, Keys.ENTER);
				long startTime = System.currentTimeMillis();// fetch starting time
				System.out.println(startTime);
				boolean condition = true;
				while (condition && (System.currentTimeMillis() - startTime) < 3600) {
					List<WebElement> clickOnSeller = driver.findElements(By.xpath(
							"//div[contains(@data-control-name,'lblSellerPRS') or contains(@data-control-name,'lblGallerySellerNameMSS')]/descendant::div[@class='appmagic-borderfill-container']"));
					if (!clickOnSeller.isEmpty()) {
						Wait.elementToBeClickable(driver, sellerSelection, 10);
						new WebDriverWait(driver, 6).ignoring(StaleElementReferenceException.class)
						.until(ExpectedConditions.elementToBeClickable(sellerSelection));
						util.actionMethodClick(driver, sellerSelection);
						condition = false;
					} else {
						Wait.elementToBeClickable(driver, refreshBtnatRighttab, 10);
						if(refreshBtnatRighttab.isDisplayed()) {
							refreshBtnatRighttab.click();
						}
					}
				}

			} else {
				String status = getStatus(tabSelection);
				selectExistingItem(status);
			}

		}
	}
	public void selectpendingscreen(String tabSelection) throws InterruptedException {
		WebElement tab = driver.findElement(By.xpath("//div[text()='" + tabSelection + "' and @class='appmagic-button-label no-focus-outline']"));
		Wait.elementToBeClickable(driver, tab, 2);
		util.actionMethodClick(driver, tab);
		String tabName = tab.getText();
		System.out.println(tabName);
	}
	
	public void ValidatealltabPending(String Coldata,DataTable datatable) {
	
		List<String> actual= datatable.asList();
		System.out.println(actual);
		try {
			for(int i=0;i<actual.size();i++) {
				System.out.println(actual.get(i));
				//List<WebElement> element =driver.findElements(By.xpath("//div[@data-control-name='contGalHeaderMIS_2']//div[text()='"+actual.get(i)+"']"));
				WebElement element =driver.findElement(By.xpath("//div[@data-control-name='contGalHeaderMIS_2']"));
				//System.out.println(element);
				Assert.assertFalse(element.getAttribute("textContent").contains(actual.get(i)));
			}
		}catch(Exception e) {
			System.out.println("Exception:"+e+"has occurered");
		}
	}
	public void OpenTab_verifyfields(String opentab) {
		
	
		Wait.elementToBeClickable(driver, openItemInstore, 4);
		util.actionMethodClick(driver, openItemInstore);
		System.out.println(opentab);
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + opentab + "')]"));
		//Assert.assertTrue(list.size() < 0, "Text not found!");
		System.out.println(list.size());
		if (list.isEmpty()) {
		  Assert.assertEquals(0, list.size());
		  System.out.println("Element is not present");	//condition = false;  
		}
		  else
		  {
			  System.out.println("Element is present");
			  WebElement unsold_item = driver.findElement(By.xpath("//*[contains(text(),'" + opentab + "')]"));
			  System.out.println(unsold_item.getText());
			  WebElement Pickup = driver.findElement(By.xpath("//input[@value='Pickup']"));
			  WebElement Charity = driver.findElement(By.xpath("//input[@value='Charity']"));
			 System.out.println(Pickup.getText());
			 System.out.println(Charity.getText()); 
	}
	}
	public void selectExistingItem(String status) throws InterruptedException {
		Wait.untilPageLoadComplete(driver);
		WebElement item = driver.findElement(By.xpath(
				"(//div[contains(@data-control-name,'lblStatusMIS_')]//*[text()='" + status + "']/parent::div)[1]"));
		if (isClickable(item)) {
			util.actionMethodClick(driver, item);
		}
	}

	public void selectMultipleItem()  {
		Wait.untilPageLoadComplete(driver);

		//System.out.print(checkboxes.size());
		//driver.findElement(By.xpath("//input[@appmagic-control='txtSearchAIS_ISTtextbox']")).sendKeys("Neha");
		for(int i=0;i<3;i++) {
			int a=i+1;
			WebElement checkboxes= driver.findElement(By.xpath("(//input[@appmagic-control='cbSelectItemMIS_2'])["+a+"]"));
			Wait.elementToBeClickable(driver, checkboxes, 5);
			util.actionMethodClick(driver, checkboxes);
			//checkboxes.click();
			//util.jsclick(driver, chk);
		}

	}



	public void itemsCount(String tab) throws InterruptedException {
		Wait.untilPageLoadComplete(driver);
		Thread.sleep(20000);
		String itemXpath = getItemXpath(tab);
		System.out.println("item xpath is : " + itemXpath);

		WebElement itemCount = driver.findElement(By.xpath("//div[contains(@data-control-name,'" + itemXpath
				+ "')]//div[@class='appmagic-label-text appmagic-label-single-line']"));
		// div[contains(@data-control-name,'lblExpiredCount')]//div[@class='appmagic-label-text
		// appmagic-label-single-line']
		String itemsCountValue = itemCount.getAttribute("textContent");
		System.out.println("Items count value " + itemsCountValue);

	}
	public void clickOnActivate() {
		activatebtn.click();
	}

	public void signAgreement() {

		// save.click();
		Wait.elementToBeClickable(driver, verify, 4);
		// verify.click();
		util.actionMethodClick(driver, verify);
		Wait.elementToBeClickable(driver, agree, 4);
		agree.click();
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(signature_box, 135, 0).build().perform();
		Wait.elementToBeClickable(driver, save_btn, 2);
		//save_btn.click();
		Boolean flag = false;
		while (!flag) {

			List<WebElement> ele = driver.findElements(saveButton);
			for (int i = 0; i < ele.size(); i++)
			{
				if (isClickable(ele.get(i))) {
					System.out.println("click on Store Settings");
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele.get(i));
					// ele.get(i).click();
					// testutil.jsclick(driver,ele.get(i));
					util.actionMethodClick(driver, ele.get(i));
					System.out.println("clicked on Store Settings");
					flag = true;
					i = ele.size();
				}

			}

		}
		//Wait.waitUntilElementVisible(driver, IBANsavebtn);
		//util.actionMethodClick(driver, IBANsavebtn);
		/*
		 * driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		 * driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
		 * 
		 * Wait.elementToBeClickable(driver, Cancel_btn, 2); Cancel_btn.click();
		 */

		/*
		 * String fontWeight =
		 * driver.findElement(By.className("classname")).getCssValue("font-weight");
		 * 
		 * boolean isBold = "bold".equals(fontWeight) || "bolder".equals(fontWeight) ||
		 * Integer.parseInt(fontWeight) >= 700;
		 */

	}

	public void empAndBankChkbox() {
		util.actionMethodClick(driver, employeeChkbox);
		Wait.elementToBeClickable(driver, bankaccChkbox, 2);
		util.actionMethodClick(driver, bankaccChkbox);
	}

	public void fillingIBANNumber(String ibanNbr) throws InterruptedException {
		IBANnumfield.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		IBANnumfield.sendKeys(ibanNbr);
		Thread.sleep(2000);
		IBANnumfield.sendKeys(Keys.ENTER);
		List<WebElement> IBANbtnDisabled = driver
				.findElements(By.xpath("//div[text()='SAVE']/parent::div[contains(@class,'disabled')]"));

		if (IBANbtnDisabled.isEmpty()) {
			System.out.println("Save button is enabled. so entered IBAN number is valid");
			Wait.elementToBeClickable(driver, IBANsavebtn, 5);
			IBANsavebtn.click();
			System.out.println("need to click on activate btn");
			try{
				Thread.sleep(3000);
				Wait.elementToBeClickable(driver, activateBtn, 5);
				activateBtn.click();
			}catch(Exception e) {
				Wait.elementToBeClickable(driver, activateBtn, 5);
				util.actionMethodClick(driver, activateBtn);
				//activateBtn.click();
				}

		} else {
			System.out.println("Save button is disabled. so entered IBAN number is not valid");
			long startTime = System.currentTimeMillis(); // fetch starting time
			boolean condition = true;
			while (condition && (System.currentTimeMillis() - startTime) < 2000) { // 10000
				List<WebElement> val = driver.findElements(By.xpath(
						"//*[text()='Your IBAN seems invalid, please check all information is entered correctly']"));
				if (!val.isEmpty()) {
					Assert.assertTrue(val.size() != 0, "WebElement not found");
					condition = false;
				}
			}

		}
	}

	public void backBtnClick() {
		Wait.elementToBeClickable(driver, backBtn, 2);
		backBtn.click();
	}

	public void IBANnumValidation(String ibanNbr) {
		// String IBANNumber = ibanNbr.getText();
		String ISO_code = ibanNbr.substring(0, 2);// Country Code
		System.out.println(ISO_code);
		System.out.println("ISO code is : " + isNumeric(ISO_code));

		String IBANDigit = ibanNbr.substring(2, 4);// Check number
		System.out.println(IBANDigit + "--> IBAN digit is " + isNumeric(IBANDigit));

		String swiftCode = ibanNbr.substring(5, 8);// Bank code
		System.out.println(swiftCode + "-->Swift code is : " + isNumeric(swiftCode));

		String accNumber = ibanNbr.substring(9, 24);// account number
		System.out.println(accNumber + "-->Account numberr is : " + isNumeric(accNumber));

	}

	public static boolean isNumeric(final String str) {

		// null or empty
		if (str == null || str.length() == 0) {
			return false;
		}

		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		return true;

	}

	public void clickOnCalcelbtnAndOk() {
		
		Boolean flag = false;
		while (!flag) {
			List<WebElement> cancleBtn = driver.findElements(By.xpath(
					"//div[contains(@data-control-name,'icnCancelExistingItemDetailsMIS')]//*[@class='powerapps-icon no-focus-outline']"));
			for (int i = 0; i < cancleBtn.size(); i++) {
				if (isClickable(cancleBtn.get(i))) {
					//cancleBtn.get(i).click();
					util.actionMethodClick(driver, cancleBtn.get(i));
					flag = true;
					i = cancleBtn.size();
				}
			}

		}
		Boolean flag1= false;
		while (!flag1) {
			List<WebElement> okBtn = driver.findElements(By.xpath("//div[text()='OK']"));
			for (int i = 0; i < okBtn.size(); i++) {
				if (isClickable(okBtn.get(i))) {
					okBtn.get(i).click();
					flag1 = true;
					i = okBtn.size();
				}
			}

		}
		//driver.findElement(By.xpath("(//div[text()='OK'])[2]")).click();
	}
	public void clickOnAddNewBrand(String poptext, String popcomment)
	{
		// AddNewBrand.click();
		 Wait.elementToBeClickable(driver, AddNewBrand, 5);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("going to click on Add New Brand");
			try {
				util.actionMethodClick(driver, AddNewBrand);
			}catch(Exception e) {
				util.actionMethodClick(driver, AddNewBrand);
			}

			System.out.println("clicked on ADD NEW BRAND");
			System.out.println("Validate the popup msg");
			
			WebElement text = driver.findElement(By.xpath("//div[contains(text(),'Type the brand that you want to add.')]"));
			System.out.println(text.getText());
			
			WebElement comment = driver.findElement(By.xpath("//div[contains(text(),'Comment from seller')]"));
			System.out.println(comment.getText());
			try {
				assertTrue(text.getText().contains(poptext), "Status is not same");
			} catch (Exception e) {
				assertTrue(text.getText().contains(poptext), "Status is not same");
			}
			try {
				assertTrue(comment.getText().contains(popcomment), "Status is not same");
			} catch (Exception e) {
				assertTrue(comment.getText().contains(popcomment), "Status is not same");
			}
		}
	
	public boolean EnterNewBrand(String NewBand)
	{ 
		System.out.println("Enter the"+NewBand+ "in txtbox");
		AddBrand.sendKeys(NewBand, Keys.ENTER);
		System.out.println("going to click on ADD Button");
		try {
			util.actionMethodClick(driver, AddBtn);
			System.out.println("Click on ADD button");
		}catch(Exception e) {
			util.actionMethodClick(driver, AddBtn);
		}
		List<WebElement> additem = driver.findElements(By.xpath("//div[text()='Brand "+NewBand+" already exists.']"));
		System.out.println(additem.size());
		if(additem.size()!=0)
		{
			return true;
		}
		return false;
	
	}
	public void UnsoldTabhidden(String unsolditem)
	{
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + unsolditem + "')]"));
		//Assert.assertTrue(list.size() < 0, "Text not found!");
		System.out.println(list.size());
		
		if (list.isEmpty()) {
		  Assert.assertEquals(0, list.size());
		  System.out.println("Element is not present");	//condition = false;
		  
		}
		  else
		  {
			  System.out.println("Element is present");
			  WebElement unsold_item = driver.findElement(By.xpath("//*[contains(text(),'" + unsolditem + "')]"));
			  System.out.println(unsold_item.getText());
			  WebElement Pickup = driver.findElement(By.xpath("//input[@value='Pickup']"));
			  WebElement Charity = driver.findElement(By.xpath("//input[@value='Charity']"));
			 System.out.println(Pickup.getText());
			 System.out.println(Charity.getText()); 
	}
	}

	public void ValidateSeller()
	{
		WebElement seller = driver.findElement(By.xpath("//div[contains(text(),'Comment from seller')]"));
		seller.getText();
		 System.out.println("Comment from seller"+seller.getText());
		WebElement seller_comment = driver.findElement(By.xpath("//input[@appmagic-control='txtAddNewBrand_1textbox']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String sellercomment = (String) jsExecutor.executeScript("return arguments[0].value", seller_comment);
		System.out.println(sellercomment);
	//	seller_comment.getText();
	//	 System.out.println("Comment given by seller"+seller_comment.getText());
		//input[@appmagic-control="txtAddNewBrand_1textbox"]
	}
	public void validateTextExist(String textAC) {
		SoftAssert softassert = new SoftAssert();
	     List<WebElement> actualText = driver.findElements(By.xpath("//div[text()='Brand "+textAC+" already exists.']"));
		 Wait.untilPageLoadComplete(driver);
    softassert.assertEquals(actualText, textAC);
    System.out.println("Item already exists.");
    }
	
	public void validateNewBrandAddedMsg() {
		// List<WebElement> we =
		// driver.findElements(By.xpath("//*[text()='"+Successmsg+"']"));
		util.validatesuccessmsg(driver, NewBrandAddToastMsg, toasteContainer);
		
	}
	public void ClickCancelItem()
	{	
		//Wait.untilPageLoadComplete(driver,200);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> Cancelitembtn = driver.findElements(By.xpath("//div[@data-control-name='btnCancelExistingItemDetailsMIS']//div[text()='CANCEL']"));
			for (int i = 0; i < Cancelitembtn.size(); i++) {
				if (isClickable(Cancelitembtn.get(i))) {
					//cancleBtn.get(i).click();
					Actions actions= new Actions(driver);
					actions.sendKeys(Keys.PAGE_DOWN).perform();
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
			//Cancelitembtn.get(i).sendKeys(Keys.TAB,Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);
					util.actionMethodClick(driver, Cancelitembtn.get(i));
					flag = true;
					i = Cancelitembtn.size();
				}
			}
		}

		
		}
	public void itemsTab() {
		Wait.elementToBeClickable(driver, items, 5);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("going to click on Items tab");
		try {
			util.actionMethodClick(driver, items);
		}catch(Exception e) {
			util.actionMethodClick(driver, items);
		}

		System.out.println("clciked on Items tab");
	}

	public void displayStatus(String status) {
		Wait.elementToBeClickable(driver, displayStatusOfItem, 5);
		try {
			/*
			 * String statusOfItem = displayStatusOfItem.getAttribute("textContent");
			 * System.out.println("Item status is :" + statusOfItem);
			 */
			String statusOfItem = displayStatusOfItem.getText();
			System.out.println("Item status is :" + statusOfItem);
			assertTrue(statusOfItem.contains(status), "Status is not same");
		} catch (Exception e) {
			/*
			 * String statusOfItem = displayStatusOfItem.getAttribute("textContent");
			 * System.out.println("Item status is :" + statusOfItem);
			 */
			String statusOfItem = displayStatusOfItem.getText();
			System.out.println("Item status is :" + statusOfItem);
			assertTrue(statusOfItem.contains(status), "Status is not same");
		}
	}

	public void validateStatusOfItem(String statusOfItem) {
		WebElement status = driver.findElement(By.xpath(
				"(//div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')]/descendant::div[@class='appmagic-label no-focus-outline middle'])[1]"));
		System.out.println(status.getText());
		try {
			assertTrue(status.getText().contains(statusOfItem), "Status is not same");
		} catch (Exception e) {
			assertTrue(status.getText().contains(statusOfItem), "Status is not same");
		}
	}

	public void openItem(String status) throws InterruptedException {
		System.out.println("open ite method started");
		// WebElement item
		// =driver.findElement(By.xpath("(//div[text()='"+status+"']/parent::div)[1]"));
		// WebElement item = driver.findElement(By.xpath("(//div[text()='" + status+
		// "']/parent::div//ancestor::div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')])[1]"));
		// Thread.sleep(4000);
		WebElement allStatus = driver.findElement(By
				.xpath("//div[text()='Status']/parent::div[@class='appmagic-label no-focus-outline middle readOnly']"));
		Wait.waitUntilElementVisible(driver, allStatus);
		Wait.elementToBeClickable(driver, allStatus, 5);
		// util.actionMethodClick(driver, allStatus);
		util.jsclick(driver, allStatus);
		WebElement item = driver
				.findElement(By.xpath("(//div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')]//*[text()='"
						+ status + "']/parent::div)[1]"));
		Wait.elementToBeClickable(driver, item, 2);
		util.jsclick(driver, item);
		System.out.println("Clicked on item 2");
		// item.click();
		// util.actionMethodClick(driver, item);
		// util.jsclick(driver, item);
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
		util.actionMethodClick(driver, item);
      System.out.println("Clicked on All Status");
	}
	public void changeStatusOfItem(String status, String updatedStatus) {
		WebElement more = driver.findElement(By.xpath("//*[text()='"+status+"']/ancestor::div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')]/following-sibling::div[@data-control-name='icnMoreOptionsItemsAddedByCustomerMIS_1']"));
		Wait.elementToBeClickable(driver, more, 5);
		more.click();
		WebElement itemStatus = driver.findElement(By.xpath("//div[@data-control-name='btnSoldMIS_2']//*[text()='"+updatedStatus+"']"));
		Wait.elementToBeClickable(driver, itemStatus, 5);
		itemStatus.click();
	}
	public void getSizeListValidation() {
		sizelist.click();
		WebElement sizeList = driver.findElement(By.xpath("//ul[@aria-label='Size items']"));
		//sizeList.getText();
		String sizes = sizeList.getText();
		List<String> Size = Arrays.asList(sizes.split(" "));
		List<String> Size1 = Size;
		Collections.sort(Size1);
		Assert.assertTrue(Size.equals(Size1), "Size is not in ascending order");
		System.out.println(Size);
	}

	public void idGeneration() throws InterruptedException {
		// System.out.println("trying to create unique id");
		Wait.elementToBeClickable(driver, ADD_ID, 5);
		util.actionMethodClick(driver, ADD_ID);
	     util.actionMethodClick(driver, addItemIdManually);
		// int randomNumber=ThreadLocalRandom.current().nextInt();
		int number = ThreadLocalRandom.current().nextInt();
		System.out.println("random  number before absolute:" + number);
		int randomNumber = Math.abs(number);
		System.out.println("random number is:" + randomNumber);
		// String.valueOf(randomNumber);
		Wait.waitUntilElementVisible(driver, itemNumber);
		itemNumber.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		itemNumber.sendKeys(String.valueOf(randomNumber));
		itemIdOk.click();
		Wait.waitForInvisibilityOfElement(driver, itemIdOk, 200);
	}

	public void addPendingItem(String noOfItems, String unsoldItem) throws InterruptedException {
		Wait.elementToBeClickable(driver, addItem, 5);
		try{
			addItem.click();
		}catch(Exception e) {
			util.actionMethodClick(driver, addItem);
		}
		WebElement numberOfItems = driver
				.findElement(By.xpath("//input[contains(@appmagic-control,'txtBatchItemsCountAIS')]"));
		numberOfItems.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)); // + noOfItems + "']
		numberOfItems.sendKeys(noOfItems);
		List<WebElement> unsoldItemdropdown = driver.findElements(By.xpath(
				"//div[contains(@data-control-name,'ddExistingItemConditionMIS')]//div[contains(@class,'appmagic-dropdownLabelText')]"));
		Boolean flag = false;
		while (!flag) {
			for (int i = 0; i < unsoldItemdropdown.size(); i++) {
				// Wait.elementToBeClickable(driver, ele.get(i), 3);
				if (isClickable(unsoldItemdropdown.get(i))) {
					System.out.println("Going to click on ok button");
					unsoldItemdropdown.get(i).click();
					System.out.println("clicked on ok button");
					flag = true;
					i = unsoldItemdropdown.size();
				}
			}
		}
		WebElement unsoldItems = driver.findElement(
				By.xpath("//*[text()='" + unsoldItem + "' and contains(@class,'appmagic-dropdownListItem')]")); // + "']
		unsoldItems.click();
		nextBtnforNewItem.click();
		Actions actions = new Actions(driver);
		//actions.dragAndDropBy(signature_box, 135, 0).build().perform();
		Boolean flag1 = false;
		while (!flag1) {
			List<WebElement> sign_Box = driver.findElements(By.xpath("//*[@class='appmagic-inkControl-draw-canvas']"));
			for (int i = 0; i < sign_Box.size(); i++) {

				if (isClickable(sign_Box.get(i))) {
					System.out.println("need to do sign");
					// ele.get(i).click();
					// testutil.jsclick(driver,ele.get(i));
					//util.actionMethodClick(driver, sign_Box.get(i));
					actions.dragAndDropBy(sign_Box.get(i), 135, 0).build().perform();
					System.out.println("Signaturing is completed");
					flag1 = true;
					i = sign_Box.size();
				}

			}

		}
		Wait.elementToBeClickable(driver, save_btn, 2);
		saveBtn();
		util.validatesuccessmsg(driver, Successmessage, toasteContainer);
		// Thread.sleep(5000);
		Wait.untilPageLoadComplete(driver, 10);

	}

	public void signForPreregItem() {
		chkboxPreregItem.click();
		Wait.waitUntilElementVisible(driver, signInPreRegisterBtn);
		Wait.elementToBeClickable(driver, signInPreRegisterBtn, 5);
		signInPreRegisterBtn.click();
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(signature_box, 135, 0).build().perform();
		Wait.elementToBeClickable(driver, save_btn, 2);
		saveBtn();
		util.validatesuccessmsg(driver, Successmessage, toasteContainer);
	}

	public void preregToInstore(String gender, String size, String price) throws InterruptedException {
		/*
		 * Wait.untilPageLoadComplete(driver, 2); Wait.elementToBeClickable(driver,
		 * preregstatus, 3); System.out.println("jsclick on preregester");
		 * util.jsclick(driver, preregstatus);
		 * System.out.println("js clicked and need to perform mouseover");
		 * util.actionMethodClick(driver, preregstatus);
		 * System.out.println("mouse over clicked on preregeste");
		 */
		// openItem(status);
		util.actionMethodClick(driver, genderList);
		WebElement genderSelection = driver.findElement(By.xpath("//div[text()='" + gender + "']"));
		genderSelection.click();
		sizelist.click();
		WebElement sizeSelection = driver.findElement(By.xpath("//span[text()='" + size + "']"));
		sizeSelection.click();
		pricelist.click();
		WebElement priceSelection = driver.findElement(By.xpath("//div[text()='" + price + "']"));
		priceSelection.click();
		Wait.untilPageLoadComplete(driver, 5);
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		// util.actionMethodClick(driver, IBANsavebtn);
		// util.jsclick(driver, IBANsavebtn);
		save.click();
	}

	public void pendingToInstore(String brand, String gender, String category, String size, String condition,
			String material, String year, String month, String date, String unsoldItem) throws InterruptedException {
		Wait.elementToBeClickable(driver, brandList, 3);
		util.actionMethodClick(driver, brandList);
		WebElement brandSelection = driver.findElement(By.xpath("//span[text()='" + brand + "']"));
		util.actionMethodClick(driver, brandSelection);

		util.actionMethodClick(driver, genderList);
		WebElement genderSelection = driver.findElement(By.xpath("//div[text()='" + gender + "']"));
		util.actionMethodClick(driver, genderSelection);

		util.actionMethodClick(driver, categoryList);
		WebElement categorySelection = driver.findElement(By.xpath("//span[text()='" + category + "']"));
		util.actionMethodClick(driver, categorySelection);

		sizelist.click();
		WebElement sizeSelection = driver.findElement(By.xpath("//span[text()='" + size + "']"));
		util.actionMethodClick(driver, sizeSelection);

		util.actionMethodClick(driver, conditionList);
		WebElement conditionSelection = driver.findElement(By.xpath("//div[text()='" + condition + "']"));
		util.actionMethodClick(driver, conditionSelection);

		util.actionMethodClick(driver, materialField);
		// materialField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		// materialField.clear();
		materialField.sendKeys(material);

		/*
		 * pricelist.click(); WebElement priceSelection =
		 * driver.findElement(By.xpath("//div[text()='" + price + "']"));
		 * util.actionMethodClick(driver, priceSelection);
		 */

		// div[text()='Götgatan 21']/ancestor::div[@class='drop drop-element
		// drop-open-transitionend drop-pinned drop-pinned-left drop-enabled
		// drop-element-attached-top drop-target-attached-bottom drop-open
		// drop-after-open']
		// @class='drop drop-element drop-open-transitionend drop-pinned
		// drop-pinned-left drop-element-attached-top drop-target-attached-bottom
		// drop-enabled drop-open drop-after-open'
		util.actionMethodClick(driver, openCalendar);
		util.actionMethodClick(driver, selectYear);
		selectYear.sendKeys(year, Keys.ENTER);
		util.actionMethodClick(driver, selectMonth);
		selectMonth.sendKeys(month, Keys.ENTER);
		// Thread.sleep(2000);
		WebElement dateVal = driver
				.findElement(By.xpath("//button[@class='pika-button pika-day' and  @data-pika-day  ='" + date + "']"));
		dateVal.click();
		Wait.elementToBeClickable(driver, okBtn, 2);
		okBtn.click();
		WebElement unsoldItemValue = driver.findElement(
				By.xpath("//input[@class='appmagic-radio-input']/parent::label[@value='" + unsoldItem + "']"));
		util.actionMethodClick(driver, unsoldItemValue);

		// waits.untilPageLoadComplete(driver, 5);

		// div[@aria-disabled='true']/ancestor::div//div[@aria-label='Price. ']
	}

	public void donePendingItem() {
		Wait.elementToBeClickable(driver, doneBtn, 2);
		util.actionMethodClick(driver, doneBtn);
		util.validatesuccessmsg(driver, Successmessage, toasteContainer);
		System.out.println("completed done pending item method");
	}

	public void brandSelection(String brand) throws InterruptedException {
		Wait.elementToBeClickable(driver, brandList, 7);
		util.actionMethodClick(driver, brandList);
		/*
		 * List<WebElement> cancelIcon =
		 * driver.findElements(By.xpath("//button[contains(@class,'buttonReset')]")); if
		 * (!cancelIcon.isEmpty()) { for (int i = 0; i < cancelIcon.size(); i++) {
		 * cancelIcon.get(i).click(); } }
		 */
		WebElement brandClick = driver.findElement(By.xpath("//div[contains(@class,'searchContainer')]//input"));
		// div[contains(@class,'searchContainer')]//input
		// input[@placeholder='Search Brand *']
		// brandClick.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		brandClick.sendKeys(brand);
		WebElement brandSelection = driver.findElement(By.xpath("//span[text()='" + brand + "']"));
		util.actionMethodClick(driver, brandSelection);
	}

	public void genderSelection(String gender) {
		Wait.elementToBeClickable(driver, genderList, 2);
		util.actionMethodClick(driver, genderList);
		WebElement genderSelection = driver.findElement(By.xpath("//div[text()='" + gender + "']"));
		util.actionMethodClick(driver, genderSelection);
	}

	public void categorySelection(String category) {
		Wait.elementToBeClickable(driver, categoryList, 2);
		util.actionMethodClick(driver, categoryList);
		WebElement categorySelection = driver.findElement(By.xpath("//span[text()='" + category + "']"));
		util.actionMethodClick(driver, categorySelection);
	}

	public void sizeSelection(String size) {
		Wait.elementToBeClickable(driver, sizelist, 2);
		sizelist.click();
		WebElement sizeSelection = driver.findElement(By.xpath("//span[text()='" + size + "']"));
		util.actionMethodClick(driver, sizeSelection);
	}

	public void conditionSelection(String condition) {
		Wait.elementToBeClickable(driver, conditionList, 2);
		util.actionMethodClick(driver, conditionList);
		WebElement conditionSelection = driver.findElement(By.xpath("//div[@class='itemMeasurer_1mfsr54']//div[contains(text(),'" + condition + "')]"));
		util.actionMethodClick(driver, conditionSelection);
	}

	public void materialSelection(String material) {
		Wait.elementToBeClickable(driver, materialField, 2);
		util.actionMethodClick(driver, materialField);
		//materialField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		//materialField.sendKeys(material);
		WebElement conditionSelection = driver.findElement(By.xpath("//span[text()='" + material + "']"));
		util.actionMethodClick(driver, conditionSelection);
		/*
		 * pricelist.click(); WebElement priceSelection =
		 * driver.findElement(By.xpath("//div[text()='" + price + "']"));
		 * util.actionMethodClick(driver, priceSelection);
		 */
	}
	
	
	public void colorSelection(String color) {
		Wait.elementToBeClickable(driver, colorField, 2);
		util.actionMethodClick(driver, colorField);
		//materialField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		//materialField.sendKeys(material);
		WebElement colorSelection = driver.findElement(By.xpath("//span[text()='" + color + "']"));
		util.actionMethodClick(driver, colorSelection);
		/*
		 * pricelist.click(); WebElement priceSelection =
		 * driver.findElement(By.xpath("//div[text()='" + price + "']"));
		 * util.actionMethodClick(driver, priceSelection);
		 */
	}
	public void calendarSelection(String year, String month, String date) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",openCalendar );
		Wait.elementToBeClickable(driver, openCalendar, 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		util.actionMethodClick(driver, openCalendar);
		util.actionMethodClick(driver, selectYear);
		selectYear.sendKeys(year, Keys.ENTER);
		Wait.elementToBeClickable(driver, selectMonth, 3);
		util.actionMethodClick(driver, selectMonth);
		selectMonth.sendKeys(month, Keys.ENTER);
		WebElement dateVal = driver
				.findElement(By.xpath("//button[@class='pika-button pika-day' and  @data-pika-day  ='" + date + "']"));
		dateVal.click();
		System.out.println("Going to click on okbtn");
		Wait.elementToBeClickable(driver, okBtn, 2);
		okBtn.click();
	}

	public void unsoldItemSelection(String unsoldItem) {
		WebElement unsoldItemValue = driver.findElement(
				By.xpath("//input[@class='appmagic-radio-input']/parent::label[@value='" + unsoldItem + "']"));
		Wait.elementToBeClickable(driver, unsoldItemValue, 2);
		try {
			util.actionMethodClick(driver, unsoldItemValue);
		} catch (Exception e) {
			util.actionMethodClick(driver, unsoldItemValue);
		}
	}

	public void priceSelection(String price) {

		// List<WebElement> pricelistDisabled = driver
		// .findElements(By.xpath("//div[@aria-label='Price. ']/parent::div"));
		//// div[@aria-label='Price. ']/parent::div[contains(@class,'disabled')]
		WebElement pricelistDisabled = driver
				.findElement(By.xpath("//div[contains(@aria-label,'Price. ')]/parent::div"));
		if (!(pricelistDisabled.getAttribute("class").contains("disabled"))) {
			System.out.println("price list is enabled. so enter the value from dropdown");
			pricelist.click();
			WebElement priceSelection = driver.findElement(By.xpath("//div[text()='" + price + "']"));
			Wait.elementToBeClickable(driver, priceSelection, 2);
			util.actionMethodClick(driver, priceSelection);
		} else {
			System.out.println("price list is diaabled. so we cannt enter value in that field");
		}
	}

	public void storeSelection(String store) {
		Wait.elementToBeClickable(driver, storelist, 2);
		// util.actionMethodClick(driver, storelist);
		long startTime = System.currentTimeMillis();// fetch starting time
		Boolean flag1 = false;
		while (!flag1 && (System.currentTimeMillis() - startTime) < 60000) {
			List<WebElement> ele1 = driver.findElements(
					By.xpath("//div[contains(@data-control-name,'ddStore')]//*[@class='appmagic-dropdownLabelArrow']"));
			for (int i = 0; i < ele1.size(); i++) {
				Wait.elementToBeClickable(driver, ele1.get(i), 3);
				if (isClickable(ele1.get(i))) {
					// ele.get(i).click();
					util.actionMethodClick(driver, ele1.get(i));
					flag1 = true;
					i = ele1.size();
				}
			}
		}

		/*
		 * WebElement storeSelection = driver.findElement( By.xpath("//div[text()='" +
		 * store + "' and contains(@class,'appmagic-dropdownListItem')]"));
		 * //(//div[text()='" + store + "' and
		 * contains(@class,'appmagic-dropdownListItem')])[2]
		 * util.actionMethodClick(driver, storeSelection);
		 */
		long startTime1 = System.currentTimeMillis();// fetch starting time
		Boolean flag = false;
		while (!flag && (System.currentTimeMillis() - startTime1) < 60000) {
			List<WebElement> ele = driver.findElements(
					By.xpath("//div[contains(text(),'" + store + "') and contains(@class,'appmagic-dropdownListItem')]"));
			for (int i = 0; i < ele.size(); i++) {
				Wait.elementToBeClickable(driver, ele.get(i), 5);
				if (isClickable(ele.get(i))) {
					ele.get(i).click();
					flag = true;
					i = ele.size();
				}
			}
		}
	}

	public void pendingSave() {

		long startTime = System.currentTimeMillis();// fetch starting time
		Boolean flag = false;
		while (!flag && (System.currentTimeMillis() - startTime) < 60000) {
			List<WebElement> ele = driver.findElements(By.xpath("//div[text()='SAVE']/parent::div"));
			
			for (int i = 0; i < ele.size(); i++) {
				if (isClickable(ele.get(i))) {
					Actions action = new Actions(driver);
					action.moveToElement(ele.get(i)).perform();
					ele.get(i).click();
					flag = true;
					i = ele.size();
				}
			}
		}
		// save_btn.click();
		//util.validatesuccessmsg(driver, Successmessage, toasteContainer);
		Wait.untilPageLoadComplete(driver, 3);
	}
	

	public void updateStatus(String status, String updatedstatus) {
		System.out.println("about to click on Pending dots");
		WebElement dots = driver.findElement(By.xpath("(//div[text()='" + status
				+ "']/parent::div//ancestor::div[contains(@data-control-name,'lblUnsoldA')]/following-sibling::div)[1]"));
		// (//div[text()='In
		// Store']/parent::div//ancestor::div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')]/following-sibling::div[@data-control-name='icnMoreOptionsItemsAddedByCustomerMIS_1'])[1]
		//
		dots.click();
		System.out.println("clicked on Pending dots");
		List<WebElement> statusChange = driver.findElements(By.xpath(
				"//div[text()='" + updatedstatus + "']/parent::div[contains(@class,'appmagic-button middle left')]"));
		System.out.println("store user checking");
		System.out.println("statusChange " + statusChange);
		// (//div[text()='Sold']/parent::div[@class='appmagic-button middle left'])[2]
		/*
		 * Boolean flag = false; while (!flag) { for (int i = 0; i <
		 * statusChange.size(); i++) { if (isClickable(statusChange.get(i)) &&
		 * (statusChange.size()) != 0) { statusChange.get(i).click(); flag = true; i =
		 * statusChange.size();
		 * System.out.println("For Brand user/Admin able to see the " + updatedstatus +
		 * " item"); break; } else {
		 * System.out.println("For Store user not able to see the " + updatedstatus +
		 * " item"); }
		 * 
		 * } }
		 */
		Boolean flag = false;
		while (!flag) {
			if ((statusChange.size()) != 0) {
				System.out.println("entered 1st if loop");
				for (int i = 0; i < statusChange.size(); i++) {
					System.out.println("entered for loop");
					if (isClickable(statusChange.get(i))) {
						statusChange.get(i).click();
						flag = true;
						i = statusChange.size();
						System.out.println("For Brand user/Admin able to see the " + updatedstatus + " item");
					}
				}
			} else {
				System.out.println("For Store user not able to see the " + updatedstatus + " item");
				flag = true;
			}

		}

		/*
		 * if ((statusChange.size()) == 0) {
		 * System.out.println("For Store user not able to see the " + updatedstatus +
		 * " item");
		 * 
		 * } else { statusChange.get(0).click(); //
		 * util.actionMethodClick(driver,statusChange.get(0));
		 * System.out.println("For Brand user/Admin able to see the " + updatedstatus +
		 * " item"); }
		 */
	}

	public void refresh() {
		Wait.elementToBeClickable(driver, refreshBtn, 15);
		System.out.println("going to click on refresh button");
		for (int i = 0; i <= 10; i++) {
			util.actionMethodClick(driver, refreshBtn);
		}
		System.out.println("clicked on refresh button");

	}

	public void refreshRightSideScreen() {
		Wait.elementToBeClickable(driver, refreshBtnatRighttab, 5);
		System.out.println("going to click on refresh button");
		long startTime = System.currentTimeMillis();// fetch starting time
		Boolean flag = false;
		while (!flag && (System.currentTimeMillis() - startTime) < 60000) {
			List<WebElement> ele = driver.findElements(By.xpath("//div[contains(@data-control-name,'icnRefresh')]"));
			for (int i = 0; i < ele.size(); i++) {
				if (isClickable(ele.get(i))) {
					util.actionMethodClick(driver, ele.get(i));
					System.out.println("click on refresh");
					flag = true;
					i = ele.size();
				}
			}
		}
	}

	public void updateStatusFrmDropdown(String updateStatus) {
		statusDropdwon.click();
		xicon.click();
		WebElement dropdownValue = driver
				.findElement(By.xpath("//div[@aria-label='Status items']//span[text()='" + updateStatus + "']"));
		dropdownValue.click();

	}

	public void declineAnItem() {
		declineBtn.click();
		declineBtnInPopup.click();
	}

	public void tabSelection(String tabSelection) {
		WebElement tab = driver.findElement(
				By.xpath("//div[text()='" + tabSelection + "']/parent::div[@class='appmagic-button middle left']"));
		Wait.elementToBeClickable(driver, tab, 2);
		util.actionMethodClick(driver, tab);
	}

	public void orderSellers() {
		System.out.println("show all sellers link is there under Quick Search: " + showAllSellersLink.getText());
		showAllSellersLink.click();
		System.out.println("click on sort");
		sellerField.click();
		System.out.println("clicked on sort");
		List<WebElement> beforeFilter = driver
				.findElements(By.xpath("//div[contains(@data-control-name,'lblGallerySellerNameMSS')]"));
		WebElement beforeFilter1 = driver
				.findElement(By.xpath("//div[contains(@data-control-name,'lblGallerySellerNameMSS')]"));
		System.out.println(beforeFilter1);
		List<String> beforeFilterSellerName = new ArrayList<>();

		/*
		 * for(WebElement p:beforeFilter) { nextBtn.click();
		 * beforeFilterSellerName.add(beforeFilterSellerName)); }
		 */
		boolean flag = true;
		while (flag) {
			Wait.elementToBeClickable(driver, refreshBtnatRighttab, 5);
			System.out.println("click on refresh");
			// driver.findElement(By.xpath("//div[@data-control-name='icnRefreshMSS']")).click();
			refreshBtnatRighttab.click();
			System.out.println("clicked on refresh");
			System.out.println(beforeFilter.size());
			for (int i = 0; i < beforeFilter.size(); i++) {
				// System.out.println(beforeFilter.get(i));
				String s1 = beforeFilter.get(i).getText();
				System.out.println(s1);
				beforeFilterSellerName.add(beforeFilter.get(i).getText());
			}
			// System.out.println(beforeFilterSellerName);
			if (isClickable(nextBtn)) {
				System.out.println("click on next btn");
				nextBtn.click();
				System.out.println("clicked on next btn");
			} else {
				flag = false;
			}
		}

	}

	public boolean validatesuccessmsg(WebDriver driver, List<WebElement> validationpath) {
		long startTime = System.currentTimeMillis();// fetch starting time
		System.out.println(startTime);
		boolean condition = true;
		while (condition && (System.currentTimeMillis() - startTime) < 3600) {
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
		return !condition;
	}

	public void addB2BSeller(String name) {
		addB2BBtn.click();
		System.out.println("clicked on Add button");
		nameField.sendKeys(name);
		System.out.println("Enter name");
		IBANsavebtn.click();
		System.out.println("clicked on save button");
		Boolean msg = validatesuccessmsg(driver, b2bsavesussmsg);
		if (msg == true) {

			System.out.println("B2B seller added successfully");
		} else {
			// B2B Seller name already exists
			System.out.println("B2B Seller name already exists");
		}

	}

	public void displayBrand(String brand) {
		WebElement ele = driver.findElement(By.xpath("//div[@data-control-name='lblBrandMAS']"));
		String brandName = ele.getText();
		int i = 0;
		if (brandName.equals(brand)) {
			i++;
			System.out.println("Brand is matching with the selected one");
		} else {
			System.out.println("brand is not matching");
		}
		System.out.println(i);
	}

	public void agreement() {
		util.actionMethodClick(driver, addAgrmentBtn);
		System.out.println("brand value is :" + brandropdownVal.getText());
	}

	public void changeStore(String store) {
		util.actionMethodClick(driver, thressdots);
		util.actionMethodClick(driver, chngStore);
		/*
		 * WebElement storeSelection = driver
		 * .findElement(By.xpath("//div[@aria-label =' items']//*[contains(text(),'" +
		 * store + "')]")); util.actionMethodClick(driver, storeSelection);
		 */
		storeSelection(store);
		saveBtn();
		/*
		 * Wait.untilPageLoadComplete(driver, 10); try { Thread.sleep(5000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	public String getItemId(String status) {
		WebElement itemOfParticularstatus = driver.findElement(By.xpath("(//div[text()='" + status
				+ "']/parent::div//ancestor::div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')]/preceding-sibling::div[@data-control-name='lblItemIdAddedByCustomerMIS_1'])[1]"));
		String itemId = itemOfParticularstatus.getText();
		return itemId;
	}

	public Map<String, String> listOfStatus(DataTable testdata) {
		List<String> datadetails = testdata.asList(String.class);
		for (int i = 0; i < datadetails.size(); i++) {
			String strngId = getItemId(datadetails.get(i));
			System.out.println(strngId);
			statusOfItem.put(datadetails.get(i), strngId);
			System.out.println(statusOfItem);
		}
		return statusOfItem;
	}
	public Map<String, String> list_of_Item_Id() {
		return statusOfItem;
	}
	
	public void selectmultipleitemTab(String itemcount,String tab)
	{
		int  item=  Integer.parseInt(itemcount);
		System.out.println(item);
		switch(tab) {
		case "All Items":
			for (int i=0;i<item;i++)
		{
			int a=i+1;
			WebElement checkbox=driver.findElement(By.xpath("(//input[@appmagic-control='cbSelectItemMIS_1'])["+a+"]"));
			System.out.println(a);
			Wait.elementToBeClickable(driver, checkbox, 5);
			util.actionMethodClick(driver, checkbox);
		}
		case "Expired":
			for (int i=0;i<item;i++)
			{
				int a=i+1;
				WebElement checkbox=driver.findElement(By.xpath("(//div[@data-control-name='cbSelectItemMIS_2']//input[@data-control-part='input'])["+a+"]"));
			
				System.out.println(a);
				Wait.elementToBeClickable(driver, checkbox, 5);
				util.actionMethodClick(driver, checkbox);
			}
		}
			
	}
	public void for_change_expired_status(String store)
	{
		util.actionMethodClick(driver, threedotsitemtab);
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(By.xpath("//div[text()='"+store+"']"));	
			if ((ele.size()!=0)) {
				System.out.println("entered 1st if loop");	
			for (int i = 0; i < ele.size(); i++){
				System.out.println("entered for loop");	
				if (isClickable(ele.get(i))) {
					 ele.get(i).click();
					//util.actionMethodClick(driver, ele.get(i));
					flag=true;
					i=ele.size();
					System.out.println("For Brand user/admin able to see the "+store+" item");	
				}
			}
			}
		}
		util.validatesuccessmsg(driver, updatesucessmsg, toasteContainer);
			
	}

	public void Click_SearchItem(String tab) throws InterruptedException {
		{
			try {

				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='" + tab + "']"))));
				WebElement Search_Item= driver.findElement(By.xpath("(//div[text()='" + tab + "'])[1]"));
				util.actionMethodClick(driver, Search_Item);
				Map<String, String> item_data = statusOfItem;
				//System.out.println(" this is from Click Search item  " + statusOfItem);
				// System.out.println(" this is from Click Search item for item data " + item_data);
				String Actual_Item_ID = null;
				for (Map.Entry<String, String> entry : item_data.entrySet()) {
					Actual_Item_ID = entry.getValue();
					//System.out.println("This is item"+item_data);
				}
				Search_Itemtxt.sendKeys(Actual_Item_ID,Keys.ENTER);
				WebElement Item_ID = driver.findElement(By.xpath("//div[@data-control-name='lblItemIdMIS']//div[@class='appmagic-label-text appmagic-label-single-line']"));
				System.out.println(Item_ID.getAttribute("innerText"));
				String expected_Item_ID = Item_ID.getAttribute("innerText");
				Assert.assertTrue(Actual_Item_ID.equalsIgnoreCase(expected_Item_ID), "Both the Item id Are Not Same");
				if(Actual_Item_ID.equalsIgnoreCase(expected_Item_ID))
				{
					System.out.println("User Generated Id above "+Actual_Item_ID +" == "+" Expected value pass "+expected_Item_ID);
				}
				else{
					System.out.println("Value do not match");
				}
				// util.jsclick(driver, Find_Seller);

				//Find_Sellertxt.sendKeys(Keys.ENTER);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				//  e.printStackTrace();
			}
		}
	}

	public void multiStatusSelection(DataTable testdata) throws InterruptedException {
		Map<String, String> statusID = listOfStatus(testdata);
		Cancel_btn.click();
		// click and enter the value in the search box
		for (Map.Entry<String, String> entry : statusID.entrySet()) {
			WebElement chkboxForItem = driver.findElement(By.xpath("//div[text()='" + entry.getValue()
			+ "']/ancestor::div[@data-control-name='lblItemIdMIS']/following-sibling::div[@data-control-name='cbSelectItemMIS']//child::label"));
			chkboxForItem.click();
		}
		/*
		 * Boolean flag = false; while (!flag) { for (int i = 0; i < ele.size(); i++) {
		 * Wait.elementToBeClickable(driver, ele.get(i), 3); if
		 * (isClickable(ele.get(i))) { // ele.get(i).click();
		 * util.actionMethodClick(driver, ele.get(i));
		 * ele.get(i).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		 * System.out.println("Key = " + entry.getKey() + " Value = " +
		 * entry.getValue()); ele.get(i).sendKeys(entry.getValue(), Keys.ENTER);
		 * util.actionMethodClick(driver, chkboxForItem); flag = true; i = ele.size(); }
		 * } } }
		 */

	}

	// div[text()='1381476406']/ancestor::div[@data-control-name='lblItemIdMIS']/following-sibling::div[@data-control-name='cbSelectItemMIS']//child::label
	public void singleStatusSelection(String store, DataTable testdata) throws InterruptedException {
		Map<String, String> statusID = listOfStatus(testdata);
		Cancel_btn.click();
		// click and enter the value in the search box
		List<WebElement> ele = driver.findElements(By.xpath(
				"//*[contains(@data-control-name,'txtSearch')]//input[contains(@appmagic-control,'txtSearch')]"));
		for (Map.Entry<String, String> entry : statusID.entrySet()) {
			Boolean flag = false;
			while (!flag) {
				for (int i = 0; i < ele.size(); i++) {
					Wait.elementToBeClickable(driver, ele.get(i), 3);
					if (isClickable(ele.get(i))) { // ele.get(i).click();
						util.actionMethodClick(driver, ele.get(i));
						ele.get(i).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
						System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
						ele.get(i).sendKeys(entry.getValue(), Keys.ENTER);
						try {
							util.actionMethodClick(driver, chkboxForItem);
						}
						catch(Exception e){
							util.actionMethodClick(driver, chkboxForItem);	
						}
						changeStore(store);
						clickOnCancel();
						flag = true;
						i = ele.size();
					}
				}
			}
		}

	}

	public void okBtn() {
		/*
		 * List<WebElement> ele = driver .findElements(By.
		 * xpath("//div[text()='OK']/parent::div[@class='appmagic-button middle center']"
		 * ));
		 */
		long startTime = System.currentTimeMillis();// fetch starting time
		Boolean flag = false;
		while (!flag && (System.currentTimeMillis() - startTime) < 60000) {
			List<WebElement> ele = driver
					.findElements(By.xpath("//div[text()='OK']/parent::div[@class='appmagic-button middle center']"));
			for (int i = 0; i < ele.size(); i++) {
				// Wait.elementToBeClickable(driver, ele.get(i), 3);
				if (isClickable(ele.get(i))) {
					System.out.println("Going to click on ok button");
					Wait.elementToBeClickable(driver, ele.get(i), 20);
					ele.get(i).click();
					System.out.println("clicked on ok button");
					flag = true;
					i = ele.size();
				}
			}
		}
	}

	public void validationOfStores(String brand, String country, String store) throws InterruptedException {
		Map<String, String> statusID = statusOfItem;
		System.out.println("im printing inside validationOfStores method" + statusID);
		admin.selectedStore(brand, country, store);
		List<WebElement> ele = driver.findElements(By.xpath(
				"//*[contains(@data-control-name,'txtSearch')]//input[contains(@appmagic-control,'txtSearch')]"));
		for (Map.Entry<String, String> entry : statusID.entrySet()) {
			Boolean flag = false;
			while (!flag) {
				for (int i = 0; i < ele.size(); i++) {
					Wait.elementToBeClickable(driver, ele.get(i), 3);
					if (isClickable(ele.get(i))) {
						// ele.get(i).click();
						util.actionMethodClick(driver, ele.get(i));
						ele.get(i).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
						System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
						ele.get(i).sendKeys(entry.getValue(), Keys.ENTER);
						WebElement itemId = driver.findElement(By.xpath("//div[@data-control-name='lblItemIdMIS']"));
						System.out.println("looking for item id getetxt");
						String itemIDNumber = itemId.getText();
						assertTrue(itemIDNumber.equals(entry.getValue()), "Item id not found" + entry.getValue());
						flag = true;
						i = ele.size();
					}
				}
			}
		}
	}

	public void saveBtn() {

		long startTime = System.currentTimeMillis();// fetch starting time
		Boolean flag = false;
		while (!flag && (System.currentTimeMillis() - startTime) < 60000) {
			List<WebElement> ele = driver.findElements(By.xpath("//div[text()='SAVE']"));
			for (int i = 0; i < ele.size(); i++) {
				// Wait.elementToBeClickable(driver, ele.get(i), 3);
				if (isClickable(ele.get(i))) {
					System.out.println("Going to click on ok button");
					ele.get(i).click();
					System.out.println("clicked on ok button");
					flag = true;
					i = ele.size();
				}
			}
		}
	}

	public void clickOnCancel() {
		long startTime = System.currentTimeMillis();// fetch starting time
		Boolean flag = false;
		while (!flag && (System.currentTimeMillis() - startTime) < 60000){
			List<WebElement> ele = driver.findElements(By.xpath(
					"//div[(contains(@data-control-name,'icnCancelExistingItemDetailsMIS') or contains(@data-control-name,'icnCancelSearchMIS'))]//*[@class='powerapps-icon no-focus-outline']"));
			for (int i = 0; i < ele.size(); i++) {
				Wait.elementToBeClickable(driver, ele.get(i), 3);
				if (isClickable(ele.get(i))) {
					System.out.println("Going to click on cancel button");
					// ele.get(i).click();
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele.get(i));
					// ele.get(i).click();
					util.actionMethodClick(driver, ele.get(i));
					// ele.get(i).click();
					System.out.println("clicked on cancel button");
					flag = true;
					i = ele.size();
				}
			}
		}
	}

	public void clickOnDone() {
		// doneBtn.click();
		// util.actionMethodClick(driver, doneBtn);
		Wait.elementToBeClickable(driver, doneBtn, 2);
		// util.jsclick(driver, doneBtn);
		util.actionMethodClick(driver, doneBtn);
		System.out.println("clicked on windows");

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

	public void switchToActiveTab() {
		// driver.get("http://yahoo.com");
		JavascriptExecutor we = ((JavascriptExecutor) driver);
		we.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size());
		System.out.println(tabs.size() - 1);
		driver.switchTo().window(tabs.get(tabs.size() - 1));
	}

	public void Deleteallitems() throws AWTException {
		Robot robot = new Robot();
		System.out.println("About to zoom in");
		for (int k = 0; k < 4; k++) {
			System.out.println("executing for loop");
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		WebElement selectAllCheckbox = driver
				.findElement(By.xpath("//input[contains(@appmagic-control,'cbSelectAllSS_2')]"));
		boolean checkbtn = true;
		while(checkbtn){
			//isClickable(selectAllCheckbox)
			util.actionMethodClick(driver, selectAllCheckbox);
			WebElement dots = driver.findElement(By.xpath("//div[contains(@data-control-name,'icnSelectAllOptionsSS_2')]"));
			util.actionMethodClick(driver, dots);
			long startTime = System.currentTimeMillis();// fetch starting time
			Boolean flag = false;
			while (!flag && (System.currentTimeMillis() - startTime) < 60000) {
				List<WebElement> RemoveBtn = driver.findElements(
						By.xpath("//div[text()='Remove' and @class='appmagic-button-label no-focus-outline']"));
				for (int j = 0; j < RemoveBtn.size(); j++) {
					if (isClickable(RemoveBtn.get(j))) {
						new WebDriverWait(driver, 6).ignoring(StaleElementReferenceException.class)
						.until(ExpectedConditions.elementToBeClickable(RemoveBtn.get(j)));
						util.jsclick(driver, RemoveBtn.get(j));
						okBtn();
						flag = true;
						j = RemoveBtn.size();
					}
				}
			}
			System.out.println("validating removed success message ");
			Wait.waitForInvisibilityOfElement(driver, areYouSureYouWantToRemove, 200);
			/*long startTime1 = System.currentTimeMillis();// fetch starting time
			System.out.println(startTime);
			boolean condition = true;

			while (condition && (System.currentTimeMillis() - startTime1) < 30000) {	
				List<WebElement> success_msg = driver.findElements(By.xpath("//*[text()='Item deleted successfully']"));
				System.out.println("size of success msg is " + success_msg.size());
				if(success_msg.size()!=0) {
					System.out.println("validating success msg popup");
					System.out.println(success_msg.size());
					assertTrue(success_msg.size() !=0, "didn't find success message");
					condition = false;
				}
			}*/
			List<WebElement> checkboxs = driver.findElements(By.xpath("//*[@data-control-name='cbSelectItemMIS_1']"));
			if((checkboxs.size())==0) {
				System.out.println("No items are in the list");
				checkbtn = false;
			}

		}
	}
	public void uploadImageInItemPage() {
		System.out.println("upload pic");
		//div[@data-control-name='AddExistingItemPhotoMIS']//div[text()='Add Photo']
		WebElement addPhoto = driver.findElement(By.xpath("//input[@aria-label='Add Photo']"));
		Actions action = new Actions(driver);
		action.moveToElement(addPhoto).perform();
		Wait.elementToBeClickable(driver, addPhoto, 5);
		String imagePath = 	System.getProperty("user.dir");
		String image1 = imagePath + "/src/test/resources/com.sat.image/Screenshot.png";		
		addPhoto.sendKeys(image1);
	}
	public void signAgreementForPreregstr(String status) {
		WebElement checkBox = driver.findElement(By.xpath("//*[text()='"+ status +"']/ancestor::div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')]//following-sibling::div[@data-control-name='cbSelectItemMIS_1']"));
		checkBox.click();
		WebElement signInPrergstr = driver.findElement(By.xpath("//div[@data-control-name='btnSignPreRegItemsMIS']"));
		//signInPrergstr.click();
		try {
			//signInPrergstr.click();
			util.actionMethodClick(driver, signInPrergstr);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			signInPrergstr.click();
			e.printStackTrace();
		}
		Boolean flag1 = false;
		while (!flag1) {

			List<WebElement> singBox = driver.findElements(By.xpath("//*[@class='appmagic-inkControl-draw-canvas']"));
			for (int i = 0; i < singBox.size(); i++)
			{
				if (isClickable(singBox.get(i))) {
					System.out.println("click on Store Settings");
					Actions actions = new Actions(driver);
					actions.dragAndDropBy(singBox.get(i), 135, 0).build().perform();
					Wait.elementToBeClickable(driver, save_btn, 2);
					System.out.println("clicked on Store Settings");
					flag1 = true;
					i = singBox.size();
				}

			}

		}

		//save_btn.click();
		Boolean flag = false;
		while (!flag) {

			List<WebElement> ele = driver.findElements(saveButton);
			for (int i = 0; i < ele.size(); i++)
			{
				if (isClickable(ele.get(i))) {
					System.out.println("click on Store Settings");
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele.get(i));
					// ele.get(i).click();
					// testutil.jsclick(driver,ele.get(i));
					util.actionMethodClick(driver, ele.get(i));
					System.out.println("clicked on Store Settings");
					flag = true;
					i = ele.size();
				}

			}

		}

	}

	public void switchToOriginal() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));

		driver.switchTo().frame("fullscreen-app-host");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void switchToChild() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	public void switchToParent() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}

	public String getSearchXpath(String tab) {
		String xpath = null;
		switch (tab) {
		case "All Sellers":
			xpath = "txtSearchMSS";
			break;
		case "Pre-Register":
			xpath = "txtSearchPRS";
			break;
		case "Payout failed":
			xpath = "txtSearchPFS";
			break;

		}
		return xpath;

	}

	private String getStatus(String tab) {
		String status = null;
		switch (tab) {
		case "In-Store":
			status = "In Store";
			break;
		case "In-Store 2nd Try":
			status = "In Store 2nd try";
			break;
		case "Pending":
			status = "Pending";
			break;
		case "Storage":
			status = "Storage";
			break;
		case "Expired":
			status = "Expired";
			break;

		}
		return status;
	}

	public String getItemXpath(String tab) {
		String itemXpath = null;
		switch (tab) {
		case "Pre-Register":
			itemXpath = "lblPreRegCount";
			break;
		case "In-Store":
			itemXpath = "lblInStrCount";
			break;
		case "In-Store 2nd Try":
			itemXpath = "lblInStrCount_1";
			break;
		case "Pending":
			itemXpath = "lblPendingCount";
			break;
		case "Storage":
			itemXpath = "lblStorageCount";
			break;
		case "Expired":
			itemXpath = "lblExpiredCount";
			break;
		case "Payout failed":
			itemXpath = "lblPayoutFailedCount";
			break;

		}
		return itemXpath;

	}
	public void verifyCommissionField() {
		Boolean flag = false;
		while (!flag) {
			List<WebElement> validateField1 = driver.findElements(By.xpath("//div[text()='Commission % *']"));
			for (int i = 0; i < validateField1.size(); i++) {
				if (isClickable(validateField1.get(i))) {
					Actions action = new Actions(driver);
					action.moveToElement(validateField1.get(i)).click().perform();
					Assert.assertTrue((validateField1.get(i).isDisplayed()), "Commission % field is not displayed");
					flag = true;
					i = validateField1.size();
				}
			}

		}
	}
	public void updateSellerComission(String cmsnpercentage) {
		//sellerComission.click();
		//sellerComission.sendKeys(cmsnpercentage);
	}
	public void validateCommissionField(String status) {
		//Status is enabled or Disabled
		String validateField = driver.findElement(By.xpath("//input[@appmagic-control='lblCommissionPercentMSStextbox']")).getAttribute("disabled");
		System.out.println(validateField);
		if(status.equalsIgnoreCase("Disabled")) {
			Assert.assertTrue(validateField.equalsIgnoreCase("true"), "Commission % field is not Disabled");
		}
		else {
			Assert.assertTrue(validateField.equalsIgnoreCase("false"), "Commission % field is not Enabled");

		}

	}
	public void validateComissionFiledInItemPage(String status) {
		//Status is enabled or Disabled
		String validateField = driver.findElement(By.xpath("//input[@appmagic-control='txtExistingItemCommissionMSStextbox']")).getAttribute("disabled");
		System.out.println(validateField);
		if(status.equalsIgnoreCase("Disabled")) {
			Assert.assertTrue(validateField.equalsIgnoreCase("true"), "Commission % field is not Disabled");
		}
		else {
			Assert.assertTrue(validateField.equalsIgnoreCase("false"), "Commission % field is not Enabled");

		}
	}
	
	
	public void validate_sellerTab_Email(String newSeller) {
		String sellerEmail = sellertabSellerEmail.getAttribute("value");
		System.out.println(sellerEmail);
		assertTrue(sellerEmail.equalsIgnoreCase(newSeller));
	}

}
