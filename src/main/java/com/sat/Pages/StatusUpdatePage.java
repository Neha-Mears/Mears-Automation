package com.sat.Pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;

public class StatusUpdatePage {
	private WebDriver driver;
	Wait waits = new Wait();
	Testutil util = new Testutil();
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());


	@FindBy(xpath = "//div[@data-control-name='txtSearchSUS']//following::input")
	private WebElement searchItemID;

	@FindBy(xpath = "//div[text()='UPDATE']")
	private WebElement update;

	public static List<String> statusOfItems = new ArrayList<>();

	public StatusUpdatePage(WebDriver driver) {
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

	public void clickOnStatusTab() {
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(By.xpath("//div[text()='Status update' and @class='appmagic-button-label no-focus-outline']"));
			for (int i = 0; i < ele.size(); i++) {
				if (isClickable(ele.get(i))) {
					util.actionMethodClick(driver, ele.get(i));
					flag = true;
					i = ele.size();
				}
			}
		}
	}
	public void searchforItemID(String itemID){
		searchItemID.click();
		searchItemID.clear();
		searchItemID.sendKeys(itemID);
		searchItemID.sendKeys(Keys.ENTER);
	}
	public void openIteminStatusPage(String itemID) {
		searchforItemID(itemID);
		WebElement item = driver.findElement(By.xpath("//div[@data-control-name='lblItemIdMIS_1']//div[text()='"+itemID+"']"));
		util.actionMethodClick(driver, item);
	}
	public void changeStatus(String changeToStatus) {
		//List<String> itemsStatus = changeToStatus.asList(String.class);
		//for (int i = 0; i < itemsStatus.size(); i++) {
		WebElement statusDropdown= driver.findElement(By.xpath("//div[@data-control-name='cbNewItemStatus']//span[text()='Select status']"));
		statusDropdown.click();
		WebElement statustoBeChange = driver.findElement(By.xpath("//ul[@role='listbox' and @aria-label='Status items']//following::span[text()='"+changeToStatus+"']"));
		util.actionMethodClick(driver, statustoBeChange);
		//}

	}
	public void clickOnUpdate() {
		util.actionMethodClick(driver, update);
	}

	public List<String> getItemIdsForSameStatusItem(String no_ofitr, String status) {
		int itr = Integer.parseInt(no_ofitr);
		for (int i = 0; i < itr; i++) {
			System.out.println(i);
			int a =i+1;
			System.out.println(a);
			WebElement itemOfParticularstatus = driver.findElement(By.xpath("(//div[text()='" +status+ "']/parent::div//ancestor::div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')]/preceding-sibling::div[@data-control-name='lblItemIdAddedByCustomerMIS_1'])["+a+"]"));
			String itemId = itemOfParticularstatus.getAttribute("innerText");
			//String strngId = getItemId(datadetails.get(i));
			System.out.println(itemId);
			statusOfItems.add(itemId);
			System.out.println(statusOfItems);
		}
		return statusOfItems;
	}
	public void changingTheStatus(String no_ofitr,String status, DataTable changeToStatus) {
		List<String> itemsStatus = changeToStatus.asList(String.class);
		List<String> statusID = getItemIdsForSameStatusItem(no_ofitr, status);
		Map<String,String> itemMap = new LinkedHashMap<String,String>();
		for (int i=0; i<itemsStatus.size(); i++) {
			itemMap.put(itemsStatus.get(i), statusID.get(i));
		}
		resalelogin.clickOnCancel();
		resalelogin.okBtn();
		clickOnStatusTab();
		for (Map.Entry<String, String> itrmap : itemMap.entrySet()) {
			openIteminStatusPage(itrmap.getValue());
			changeStatus(itrmap.getKey());
			clickOnUpdate();
		}
	}
}
