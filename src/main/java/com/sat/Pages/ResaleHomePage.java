package com.sat.Pages;



import static org.testng.Assert.assertTrue;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;

import io.cucumber.datatable.DataTable;

public class ResaleHomePage {
	private WebDriver driver;
	Wait waits = new Wait();
	Testutil util = new Testutil();

	@FindBy(xpath = "//div[@data-control-name='txtSlrCommissionCSS']//input[@appmagic-control='txtSlrCommissionCSStextbox']")
	private WebElement countrySellerCommission;

	@FindBy(xpath = "//*[@appmagic-control='txtSlrCommissionBSStextbox']")
	private WebElement brandCommission;

	@FindBy(xpath = "//*[@appmagic-control='txtSendGridFromEmailBSStextbox']")
	private WebElement brandSendGridEmail;

	@FindBy(xpath="//*[name() = 'svg'][contains(@data-appmagic-icon-name, 'Basel_ArrowLeft')]")
	private WebElement NewHomeBackButton;

	@FindBy(xpath = "//div[text()='SAVE SETTINGS']")
	private WebElement saveSettings;

	@FindBy(xpath = "//div[text()='Updated successfully']")
	private List<WebElement> updatedSuccesfully;

	@FindBy(xpath = "//*[@id='toast-container']")
	private List<WebElement> toasteContainer;

	@FindBy(xpath = "//input[contains(@appmagic-control,'lblCommissionPercentM')]")
	private WebElement sellerTabCommission;
	//input[@appmagic-control='lblCommissionPercentMIStextbox']

	@FindBy(xpath = "//input[contains(@appmagic-control,'txtExistingItemCommissionM')]")
	private WebElement Itemcommission;


	public ResaleHomePage(WebDriver driver) {
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
	public void saveBtn() {
		Boolean flag = false;
		while (!flag) {
			List<WebElement> save_btn = driver.findElements(By.xpath("//div[text()='SAVE']"));
			for (int i = 0; i < save_btn.size(); i++) {

				if (isClickable(save_btn.get(i))) {
					System.out.println("click on save");
					// ele.get(i).click();
					// testutil.jsclick(driver,ele.get(i));
					util.actionMethodClick(driver, save_btn.get(i));
					System.out.println("clicked on save");
					flag = true;
					i = save_btn.size();

				}

			}

		}


	}
	public void ClickHomeResaleBackButton(){
		List<WebElement> yellowpopup = driver.findElements(By.xpath("//button[@aria-label='Close']"));
		if (yellowpopup.size() == 0) {
			System.out.println("no popups so clicking on back button ");
			Wait.elementToBeClickable(driver,NewHomeBackButton , 5);
			//bookingportalBackButton.click();
			util.actionMethodClick(driver, NewHomeBackButton);
		}
		else {
			System.out.println("popup");
			WebElement yelowPopUp= driver.findElement(By.xpath("//button[@aria-label='Close']"));
			yelowPopUp.click();
			TargetLocator currentFrame = driver.switchTo();
			currentFrame.frame("fullscreen-app-host");
			Wait.elementToBeClickable(driver,NewHomeBackButton , 5);
			util.actionMethodClick(driver, NewHomeBackButton);
		}
	}

	public void clickOK() {
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ok_btn = driver.findElements(By.xpath("//div[text()='OK']"));
			for (int i = 0; i < ok_btn.size(); i++) {

				if (isClickable(ok_btn.get(i))) {
					System.out.println("click on ok");
					// ele.get(i).click();
					// testutil.jsclick(driver,ele.get(i));
					util.actionMethodClick(driver, ok_btn.get(i));
					System.out.println("clicked on ok");
					flag = true;
					i = ok_btn.size();
				}

			}

		}

	}

	public void addCommissionInCountry(String countryComision) {
		Boolean flag = false;
		while (!flag) {
			List<WebElement> countrySettings = driver.findElements(By.xpath("//div[text()='Country settings']"));
			for (int i = 0; i < countrySettings.size(); i++) {

				if (isClickable(countrySettings.get(i))) {
					System.out.println("click on Country settings");
					// ele.get(i).click();
					// testutil.jsclick(driver,ele.get(i));
					util.actionMethodClick(driver, countrySettings.get(i));
					System.out.println("clicked on Country settings");
					flag = true;
					i = countrySettings.size();
				}

			}

		}
		Wait.elementToBeClickable(driver, countrySellerCommission, 5);
		countrySellerCommission.clear();
		countrySellerCommission.sendKeys(countryComision);
		saveSettings.click();
		clickOK();
		util.validatesuccessmsg(driver, updatedSuccesfully, toasteContainer);
	}
	public void addCommissionInBrandStng(String brandComision){
		Boolean flag = false;
		while (!flag) {
			List<WebElement> brandSettings = driver.findElements(By.xpath("//div[text()='Brand settings']"));
			for (int i = 0; i < brandSettings.size(); i++) {

				if (isClickable(brandSettings.get(i))) {
					System.out.println("click on Country settings");
					// ele.get(i).click();
					// testutil.jsclick(driver,ele.get(i));
					util.actionMethodClick(driver, brandSettings.get(i));
					System.out.println("clicked on Country settings");
					flag = true;
					i = brandSettings.size();
				}

			}

		}
		Wait.elementToBeClickable(driver, brandSendGridEmail, 5);
		brandSendGridEmail.sendKeys("weekday@second.com");
		brandCommission.clear();
		brandCommission.sendKeys(brandComision);
		saveSettings.click();
		clickOK();
		util.validatesuccessmsg(driver, updatedSuccesfully, toasteContainer);
	}
	public void ValidateCommissionInBrandStng(DataTable table) throws InterruptedException {
		List<String>  l1 = table.asList();
		System.out.println(l1);
		Iterator<String> it = l1.iterator();
		while (it.hasNext()) {
			//System.out.println(it.next());
			brandCommission.clear();
			brandCommission.sendKeys(it.next());
			Thread.sleep(2000);
			brandCommission.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			//String commissionValue = Itemcommission.getText();
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String commissionValue = (String) jsExecutor.executeScript("return arguments[0].value", brandCommission);
			System.out.println(commissionValue);
			int number = Integer.parseInt(commissionValue);
			System.out.println(number  + "  number");
			if(number>0 && number<=100) {
				System.out.println("Valid Item Commission");
			} else {
				System.out.println("Not Valid Item Commission");
			}
		}
		saveSettings.click();
		clickOK();
		util.validatesuccessmsg(driver, updatedSuccesfully, toasteContainer);
	}
	public void validateSellerCommission(String countryComision) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String serrlercommission = (String) jsExecutor.executeScript("return arguments[0].value", sellerTabCommission);
		System.out.println(serrlercommission + "  Seller");
		System.out.println(countryComision + " Country");
		Assert.assertTrue(serrlercommission.equalsIgnoreCase(countryComision), "Seller commission and contry setting Commission are not same");

		//assertTrue("Seller commission and contry setting Commission are not same", serrlercommission.equalsIgnoreCase(countryComision));


	}
	public void updateSellerCommission(String sellerCommission) {
		sellerTabCommission.clear();
		sellerTabCommission.sendKeys(sellerCommission);
		saveBtn();
	}
	public void validateItemCommission(String countryComision) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String serrlercommission = (String) jsExecutor.executeScript("return arguments[0].value", Itemcommission);
		System.out.println(Itemcommission + "  Seller");
		System.out.println(countryComision + " Country");

		Assert.assertTrue(serrlercommission.equalsIgnoreCase(countryComision), "Seller commission and contry setting Commission are not same");
	

		try {
			Assert.assertTrue(serrlercommission.equalsIgnoreCase(countryComision),"Seller commission and contry/brand setting Commission are not same");
		}catch(Exception e){
			System.out.println( e);
		}
		}

	public void updateAndValidateItemCommission(DataTable table) throws InterruptedException {
		List<String>  l1 = table.asList();
		System.out.println(l1);
		Iterator<String> it = l1.iterator();
		while (it.hasNext()) {
			//System.out.println(it.next());
			Itemcommission.clear();
			Itemcommission.sendKeys(it.next());
			Thread.sleep(5000);
			Itemcommission.sendKeys(Keys.ENTER);
			Thread.sleep(10000);
			//String commissionValue = Itemcommission.getText();
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String commissionValue = (String) jsExecutor.executeScript("return arguments[0].value", Itemcommission);
			System.out.println(commissionValue);
			int number = Integer.parseInt(commissionValue);
			System.out.println(number  + "  number");
			if(number>0 && number<=100) {
				System.out.println("Valid Item Commission");
			} else {
				System.out.println("Not Valid Item Commission");
			}
		}
	}
	
	
}
