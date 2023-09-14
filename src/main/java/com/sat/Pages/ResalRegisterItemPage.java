package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;

import io.cucumber.datatable.DataTable;

public class ResalRegisterItemPage {

	private WebDriver driver;

	Testutil util = new Testutil();

	// Seller registering an item from Resale portal
	
	//@FindBy(xpath = "//div[contains(text(),'Register items & drop off at store')]")
	@FindBy(xpath = "//button[@id='registerAcc']/div/div")
	private WebElement Registeryouritems;
	// @FindAll ({@FindBy (id="storelist")}) private List<WebElement> storelist;
	@FindBy(xpath = "//p[@class='input-group']//select[@id='storelist']")
	private WebElement storelist;

	@FindBy(xpath = "(//a[@title='Show All Items']/parent::span/child::input)[1]") //(//a[@title='Show All Items'])[1]
	private WebElement brandName;
	@FindBy(xpath = "(//a[@title='Show All Items'])[2]")
	private WebElement genderName;

	// @FindAll ({@FindBy (id="categories")}) private List<WebElement> categorylist;

	@FindBy(xpath = "(//a[@title='Show All Items'])[3]")
	private WebElement categorylist;

	@FindBy(xpath = "(//a[@title='Show All Items'])[4]")
	private WebElement conditionlist;

	@FindBy(xpath = "(//a[@title='Show All Items'])[5]")
	private WebElement colorlist;
	@FindBy(xpath = "(//a[@title='Show All Items'])[6]")
	private WebElement patternlist;
	@FindBy(xpath = "(//button[@data-id='multimaterial-1'])[1]")
	private WebElement materiallist;
	@FindBy(xpath = "(//a[@title='Show All Items'])[7]")
	private WebElement Unsolditemlist;
	@FindBy(xpath = "(//input[@placeholder='Material'])[1]")
	private WebElement color;
	@FindBy(xpath = "//input[contains(@data-bind,'value: material,')]")
	private WebElement materialType;
	@FindBy(xpath = "//*[text()='Thanks for register your items. A confirmation mail has been sent to ']")
	private WebElement ThankyouMessage;
	/*@FindBy(xpath = "//div[text()='Register your items']")
	private WebElement Registeryouritems_submit;*/
	@FindBy(xpath = "//div[text()='Save & Continue']")
	private WebElement SaveAndContinueBtn;
	@FindBy(xpath = "//button[@aria-label='Done']")
	private WebElement doneBtn;

	// Seller canceling an item from Resale portal
	@FindBy(xpath = "//div[text()=' My Items']")
	private WebElement MyItems_link;
	// span[not(contains(@style,'display: none;')) and @class='itempreregister']
	// (//span[not(contains(@style,'display: none;')) and
	// @class='itempreregister'])[1]
	// div[not(contains(@style,'display: none;')) and @class='itemcancel']
	@FindBy(xpath = "//button[@id='yesItemBtn']/child::div/child::div[text()='Yes']")
	private WebElement yesBtn;

	//Cancel not possible
	@FindBy(xpath="//div[@id='errorText']")
	private WebElement cancelNotPossible;
	// Personal details tab
	@FindBy(xpath = "(//div[@class='Accountdet'])[2]")
	private WebElement myaccount_link;
	@FindBy(xpath = "(//div[text()='Personal details'])[2]")
	private WebElement personalDetailsTab;
	@FindBy(xpath = "//input[@name='puregistrationname']") // input[@id='puregistrationname']
	private WebElement fname;
	@FindBy(xpath = "//input[@id='puregistrationlastname']")
	private WebElement lname;
	@FindBy(xpath = "//div[@aria-controls='iti-0__country-listbox']")
	private WebElement country_list;
	@FindBy(xpath = "//li[@id='iti-0__item-in']/span")
	private WebElement country_selection;
	@FindBy(xpath = "//input[@id='puregistrationmobile']")
	private WebElement phnmbr;
	@FindBy(xpath = "//input[@id='puregistrationaddress']")
	private WebElement address;
	@FindBy(xpath = "//input[@id='puregistrationpostcode']")
	private WebElement postal_code;
	@FindBy(xpath = "//input[@id='puregistrationtown']")
	private WebElement city;
	@FindBy(xpath = "//button[@id='BtnUpdate']")
	private WebElement updateBtn;
	@FindBy(xpath = "//div[text()='Ok']")
	private WebElement okBtn;

	// Sellers details in App
	@FindBy(xpath = "//input[@appmagic-control='txtFirstNameMIStextbox'] ")
	private WebElement appFname;
	@FindBy(xpath = "//input[@appmagic-control='txtLastNameMIStextbox']")
	private WebElement appLname;
	@FindBy(xpath = "//input[@appmagic-control='txtEmailMIStextbox']")
	private WebElement appEmail;
	@FindBy(xpath = "//input[@data-intl-tel-input-id='0']")
	private WebElement appPhnmbr;
	@FindBy(xpath = "//input[@appmagic-control='txtAddressMIStextbox']")
	private WebElement appAddress;
	@FindBy(xpath = "//input[@appmagic-control='txtPostalCodeMIStextbox']")
	private WebElement appPostalcode;
	@FindBy(xpath = "//input[@appmagic-control='txtTownMIStextbox']")
	private WebElement appCity;
	@FindBy(xpath = "//div[@data-control-name='ddCountryMIS']")
	private WebElement appCountry;

	public ResalRegisterItemPage(WebDriver driver) {
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

	public void registerItem() {
		Wait.elementToBeClickable(driver, Registeryouritems, 5);
		try {
			Thread.sleep(8000);
			util.actionMethodClick(driver, Registeryouritems);
		} catch (InterruptedException e) {
			util.jsclick(driver, Registeryouritems);
			e.printStackTrace();
		}
		//Registeryouritems.click();
		//util.actionMethodClick(driver, Registeryouritems);
		//util.jsclick(driver, Registeryouritems);

	}


	public void selectValues(String Store_Name, String Brand_name, String Gender,String catogeryName,String Listofcondition,
			String Color,String Pattern,String material, String unsolditem) throws InterruptedException {

		Select List_of_stores = new Select(storelist);
		List_of_stores.selectByVisibleText(Store_Name);

		Thread.sleep(2000);

		Wait.elementToBeClickable(driver, brandName, 5);
		brandName.click();
		brandName.sendKeys(Brand_name);
		WebElement List_of_Brand=driver.findElement(By.xpath("//li[text()='"+Brand_name+"']"));
		List_of_Brand.click();

		//gender.sendKeys(gndr);

		Thread.sleep(2000);

		System.out.println("Entered brand name");
		/*
		WebElement brand_name=driver.findElement(By.xpath("//li[text()='"+Brand_name+"']"));
		brand_name.click();
		if(Brand_name.equals("Other"))
		{
		WebElement Other_text=driver.findElement(By.xpath("(//input[@placeholder='Type brand name'])[1]"));
		Other_text.sendKeys(Keys.CONTROL +"A");
		Other_text.sendKeys("Testing");
		}
		 */
		Thread.sleep(2000);

		Wait.elementToBeClickable(driver, genderName, 5);
		genderName.click();
		WebElement Gender_name=driver.findElement(By.xpath("//li[text()='"+Gender+"']"));
		Gender_name.click();
		Wait.elementToBeClickable(driver, categorylist, 5);
		categorylist.click();
		WebElement category_name=driver.findElement(By.xpath("//li[text()='"+catogeryName+"']"));
		category_name.click();

		// Wait.elementToBeClickable(driver, conditionlist, 5);

		//Select conditionList = new Select(conditionlist);
		//conditionList.selectByVisibleText(Listofcondition);

		//color.sendKeys(null);

		Thread.sleep(2000);
		// Wait.elementToBeClickable(driver, materialType, 5);
		//Color
		Wait.elementToBeClickable(driver, conditionlist, 5);
		conditionlist.click();
		//WebElement condition_name=driver.findElement(By.xpath("(//li[text()='"+Listofcondition+"'])[2]"));
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(By.xpath("//li[text()='"+Listofcondition+"']"));
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
		//util.actionMethodClick(driver, condition_name);
		//condition_name.click();
		Thread.sleep(2000);

		Wait.elementToBeClickable(driver, colorlist, 5);
		colorlist.click();
		WebElement Color_name=driver.findElement(By.xpath("//li[text()='"+Color+"']"));
		Color_name.click();
		Thread.sleep(2000);

		Wait.elementToBeClickable(driver, patternlist, 5);
		patternlist.click();
		WebElement Pattern_name=driver.findElement(By.xpath("//li[text()='"+Pattern+"']"));
		Pattern_name.click();
		Thread.sleep(2000);

		Wait.elementToBeClickable(driver, patternlist, 5);
		materiallist.click();
		WebElement material_name=driver.findElement(By.xpath("//span[text()='"+material+"']"));
		material_name.click();
		//util.actionMethodClick(driver, material_name);
		WebElement Click_outside=driver.findElement(By.xpath("(//div[@class='col-md-12 garmentphotos'])[1]"));
		Click_outside.click();
		Thread.sleep(2000);


		Wait.elementToBeClickable(driver, Unsolditemlist, 5);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Unsolditemlist);
		Unsolditemlist.click();
		//util.actionMethodClick(driver, Unsolditemlist);

		WebElement unsolditem_name=driver.findElement(By.xpath("//li[text()='"+unsolditem+"']"));
		unsolditem_name.click();
		Thread.sleep(2000);


		// Wait.elementToBeClickable(driver, Unsolditemlist, 5);


	}

	public void clickonAllAccount(DataTable testdata) throws InterruptedException {
		Wait.untilPageLoadComplete(driver,300);
		List<List<String>> data= testdata.asList(String.class);
		System.out.println(data);
		java.util.Iterator<List<String>> iter=data.iterator();

		while(iter.hasNext())
		{
			//System.out.println(iter.next());
			Thread.sleep(10000);
			WebElement drop_ele=driver.findElement(By.xpath("(//*[text()='"+iter.next()+"'])[1]"));

			util.actionMethodClick(driver, drop_ele);

		}

	}


	public void Submit() {
		//Registeryouritems_submit.click();
		//SaveAndContinueBtn.click();
		Boolean flag = false;
		long startTime = System.currentTimeMillis();// fetch starting time
		System.out.println(startTime);
		while (!flag && (System.currentTimeMillis() - startTime) < 60000) {
			List<WebElement> ele = driver.findElements(By.xpath("(//button[@id='registerBtn']//div)[1]"));
			System.out.println(ele.size());
			for (int i = 0; i < ele.size(); i++){
				if (isClickable(ele.get(i))) {
					util.actionMethodClick(driver, ele.get(i));
					// util.jsclick(driver, ele1);
					flag = true;
					i = ele.size();
				}
				else {
					System.out.println("element is not clickable so executing else of submit  method");
				}

			}

		}
	}

	public void regiseteredMsg() {
		Wait.waitUntilElementVisible(driver, ThankyouMessage);
		/*
		 * boolean verifyTitle = ThankyouMessage.isDisplayed(); assertTrue(verifyTitle);
		 */
		String actual = ThankyouMessage.getText();
		String expected = "Thanks for register your items. A confirmation mail has been sent to";
		// Assert.assertEquals(actual, expected);
		System.out.println(actual);
		System.out.println(expected);
		if (expected.equals(actual)) {
			System.out.println("Both Actual and Expected strings are equal");
		} else {
			System.out.println("Both Actual and Expected strings are not equal");
		}
	}

	public void done() {
		doneBtn.click();

	}

	public void currentTabValidation(String status) {
		WebElement preregItem = driver.findElement(
				By.xpath("(//span[not(contains(@style,'display: none;'))]//div[text()='"+status+"'])[1]"));
		System.out.println(preregItem);
		System.out.println("Currently added item is present in Active tab");
	}

	public void myItemsTab() {
		util.actionMethodClick(driver, MyItems_link);
	}

	public void cancelItems() {
		WebElement cancelBtn = driver
				.findElement(By.xpath("(//div[not(contains(@style,'display: none;')) and @class='itemcancel'])[1]"));
		util.actionMethodClick(driver, cancelBtn);
		util.actionMethodClick(driver, yesBtn);
	}
	public void cancelNotpossibleItems() {
		WebElement cancelBtn = driver
				.findElement(By.xpath("(//div[not(contains(@style,'display: none;')) and @class='itemcancel'])[1]"));
		util.actionMethodClick(driver, cancelBtn);
		System.out.println(cancelNotPossible.getText());
		assertTrue(cancelNotPossible.getAttribute("textContent").contains("Cancel item is not possible."), "Cancel the item is not possible");
		util.actionMethodClick(driver, okBtn);
	}

	public void modifyDetilasInPortal(String firstName, String lastName, String mobNumber, String addressName,
			String pincode, String cityName) {
		util.actionMethodClick(driver, myaccount_link);
		util.actionMethodClick(driver, personalDetailsTab);
		fname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		fname.sendKeys(firstName);
		lname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		lname.sendKeys(lastName);
		phnmbr.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		phnmbr.sendKeys(mobNumber);
		address.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		address.sendKeys(addressName);
		postal_code.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		postal_code.sendKeys(pincode);
		city.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		city.sendKeys(cityName);
		util.actionMethodClick(driver, updateBtn);
		util.actionMethodClick(driver, okBtn);
	}

	public void modifiedDetailsPortalValidation(String firstName, String lastName, String mobNumber, String addressName,
			String pincode, String cityName) {
		Wait.waitUntilElementVisible(driver, fname);
		// System.out.println(fname.getAttribute("value"));
		// System.out.println(firstName);

		assertTrue(fname.getAttribute("value").contains(firstName), "First Name is not same");
		assertTrue(lname.getAttribute("value").contains(lastName), "Last Name is not same");
		assertTrue(phnmbr.getAttribute("value").contains(mobNumber), "Phone number is not same");
		assertTrue(address.getAttribute("value").contains(addressName), "Address is not same");
		assertTrue(postal_code.getAttribute("value").contains(pincode), "Pincode is not same");
		assertTrue(city.getAttribute("value").contains(cityName), "City Name is not same");
	}

	public void modifiedDetailsAppValidation(String firstName, String lastName, String mobNumber, String addressName,
			String pincode, String cityName) {
		assertTrue(appFname.getAttribute("value").contains(firstName), "First Name is not same");
		assertTrue(appLname.getAttribute("value").contains(lastName), "Last Name is not same");
		assertTrue(appPhnmbr.getAttribute("value").contains(mobNumber), "Phone number is not same");
		assertTrue(appAddress.getAttribute("value").contains(addressName), "Address is not same");
		assertTrue(appPostalcode.getAttribute("value").contains(pincode), "Pincode is not same");
		assertTrue(appCity.getAttribute("value").contains(cityName), "City Name is not same");
	}
}
