package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
import org.testng.asserts.Assertion;

import com.sat.testUtil.*;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;

public class ResaleAppNewHomeLoginPage {
	private WebDriver driver;
	Wait waits = new Wait();
	Testutil util = new Testutil();
	ResaleAppLoginPage resaleapplgn = new ResaleAppLoginPage(driver);

	// Login to the Resale app
	


	@FindBy(xpath = "//*[@data-control-name='dateCtrlTimeSlots']//input")
	private WebElement gettingDate;
	@FindBy(xpath = "//input[contains(@placeholder,'Search for name, email or mobile number')]")
	private WebElement Find_Sellertxt;
	//input[contains(@appmagic-control,'txtSearchAIStextbox')]
	@FindBy(xpath = "//input[contains(@appmagic-control,'txtSearchSellerMIS_2_1textbox')]")
	private WebElement Search_Itemtxt;
	
	@FindBy(xpath="//*[name() = 'svg'][contains(@data-appmagic-icon-name, 'Basel_ArrowLeft')]")
	private WebElement NewHomeBackButton;
	
	@FindBy(xpath="//div[@data-control-name='imgStorelensLogo']//*[name() = 'img'][contains(@class,'appmagic-image-inner')]")
	private WebElement WeekDayImg;
	
	@FindBy(xpath = "//div[@data-control-name='lblFirstNameMIS_1']")
	private WebElement newappFname;

	public static Map<String, String> statusOfItem = new HashMap<>();

	public ResaleAppNewHomeLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyalltab(DataTable datatable) throws InterruptedException {
		{
			List<String> actual = datatable.asList();
			System.out.println("Size = "+ actual.size());
			for (int i = 0; i <= actual.size()-1; i++) {
	        	
	            int j =i + 1;
	            Thread.sleep(2000);
	            System.out.println(driver.findElement(By.xpath("(//div[contains(@data-control-name,'lblCustomerServicePhoneBSS')])["+j+"]"))
	            		.getAttribute("innerText")+ "==" + actual.get(i));
	          String data= driver.findElement(By.xpath("(//div[contains(@data-control-name,'lblCustomerServicePhoneBSS')])["+j+"]")).getAttribute("innerText");
	         // System.out.println(data);
             Assert.assertEquals(data, actual.get(i));
		}
	}
	}
		public void verifynexttab(DataTable datatable) throws InterruptedException {
			{
				List<String> actual = datatable.asList();
				System.out.println("Size = "+ actual.size());
				//List<WebElement> Expected_List=driver.findElements(By.xpath("//div[contains(@data-control-name,'lblCustomerServicePhoneBSS')]"));
		        
				for (int i = 0; i <= actual.size()-1; i++) {
		        	
		           String Size = actual.get(i);
		            	Thread.sleep(2000);
		            	WebElement data=driver.findElement(By.xpath("//div[text()='"+Size+"']"));
		            	System.out.println("Data Contain : "+data.getText());
		            	////div[text()='+i+']
		            	//  System.out.println("This is Expected  "+element.get(i).getText());
		            	//System.out.println("This is Expected  "+data.getText());
		            	//System.out.println("This is Actual  "+actual.get(i));
		            	
		            	if(actual.get(i).equalsIgnoreCase(data.getText()))
		            	{
		            		System.out.println("This is Expected: "+ data.getText()+" == "+" This is Actual:  "+actual.get(i));
		            	}
		            	else
		            	{
		            		System.out.println("This is Expected  "+data.getText()+" is not equal "+"This is Actual  "+actual.get(i));
		            	}
		              //  Assert.assertEquals(actual.get(i).equalsIgnoreCase(data.getText()) , "Element is Displayed");
		            }
			}
		}

		public void verifydatettab() throws InterruptedException {
			{
				System.out.println("started validating");
				Thread.sleep(3000);
				Wait.elementToBeClickable(driver, gettingDate, 2);
				//Wait.waitUntilElementVisible(driver, gettingDate);
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				String NewHomePagedate = (String) jsExecutor.executeScript("return arguments[0].value", gettingDate);
				System.out.println(NewHomePagedate);
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("E, MMM d, yyyy");
				String strDate = formatter.format(date);
				// System.out.println("Date Format with E, MMMM dd, yyyy : "+strDate);
				System.out.println(strDate);
				assertTrue(strDate.contains(NewHomePagedate), "Time formate is not as expected");
				System.out.println("completed validation");
	}
			}
		public void Click_FindSeller(String tab) throws InterruptedException {
			{
				try {
		            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='" + tab + "']"))));
		           WebElement Find_Seller= driver.findElement(By.xpath("//div[text()='" + tab + "']"));
		           // util.jsclick(driver, Find_Seller);
		            util.actionMethodClick(driver, Find_Seller);
		         Find_Sellertxt.sendKeys("testerswathi135@gmail.com",Keys.ENTER);
		           Find_Sellertxt.sendKeys(Keys.ENTER);
		            
		        } catch (Exception e) {
		            // TODO Auto-generated catch block
		          //  e.printStackTrace();
		        }
		}
			
		}
		public void Click_SearchItem(String tab) throws InterruptedException {
			{
				try {
					
		            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='" + tab + "']"))));
		           WebElement Search_Item= driver.findElement(By.xpath("(//div[text()='" + tab + "'])[1]"));
					util.actionMethodClick(driver, Search_Item);
					 Map<String, String> item_data = resaleapplgn.list_of_Item_Id();
					 System.out.println(" this is from Click Search item  " + statusOfItem);
					 System.out.println(" this is from Click Search item for item data " + item_data);
						String Actual_Item_ID = null;
						for (Map.Entry<String, String> entry : item_data.entrySet()) {
						Actual_Item_ID = entry.getValue();
						System.out.println("This is item"+item_data);
						}
		            Search_Itemtxt.sendKeys(Actual_Item_ID,Keys.ENTER);
				WebElement Item_ID = driver.findElement(By.xpath("//div[@data-control-name='lblItemIdMIS']//div[@class='appmagic-label-text appmagic-label-single-line']"));
				System.out.println(Item_ID.getAttribute("innerText"));
				String expected_Item_ID = Item_ID.getAttribute("innerText");
				Assert.assertTrue(Actual_Item_ID.equalsIgnoreCase(expected_Item_ID), "Both the Item id Are Not Same");
		           // util.jsclick(driver, Find_Seller);
		            
		            //Find_Sellertxt.sendKeys(Keys.ENTER);
		            
		        } catch (Exception e) {
		            // TODO Auto-generated catch block
		          //  e.printStackTrace();
		        }
		}
		}

		public void validateSellerField(String customerName) {
			try {
			WebElement seller = driver.findElement(By.xpath("(//div[@data-control-name='lblLastnameGalSellerMIS_1'])[1]"));
			Wait.untilPageLoadComplete(driver);
			Assert.assertEquals(seller.getText(), customerName);
			if(seller.getText().equalsIgnoreCase(customerName))
			{
				System.out.println("User is able to find the seller in the home page");
			}
			else
			{
				System.out.println("User is unable to find the seller in the home page");
			}
			
		
		  } catch (Exception e) {
	        }
	        ;
	    }
		
		public void validateSearchItem() {
			try {
				Map<String, String> item = resaleapplgn.statusOfItem;
				System.out.println(item);
			WebElement Item_Detail = driver.findElement(By.xpath("//div[@data-control-name='lblItemIdMIS']//div[@class='appmagic-label-text appmagic-label-single-line']"));
			System.out.println(Item_Detail.getAttribute("innerText"));
						
			
			
		  } catch (Exception e) {
		  
	        
	        
		}
		}
		
		public void validateSField(String customerName) {
			try {
			WebElement seller = driver.findElement(By.xpath("(//div[@data-control-name='lblLastnameGalSellerMIS_1'])[1]"));
			Wait.untilPageLoadComplete(driver);
			Assert.assertEquals(seller.getText(), customerName);
			if(seller.getText().equalsIgnoreCase(customerName))
			{
				System.out.println("User is able to find the seller in the home page");
			}
			else
			{
				System.out.println("User is unable to find the seller in the home page");
			}
			
		
		  } catch (Exception e) {
	        }
	        ;
	    }

		public void ClickHomeResaleBackButton()
		{
			System.out.println("no popups so clicking on back button ");
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
		
		public void ClickOnWeekDay()
		{
			Wait.elementToBeClickable(driver,WeekDayImg , 5);
			//bookingportalBackButton.click();
			//util.actionMethodClick(driver, WeekDayImg);
			Actions act = new Actions(driver);
			//Double click on element
			act.doubleClick(WeekDayImg).perform();
			util.actionMethodClick(driver, WeekDayImg);
			System.out.println("Double click operation performed");
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
	

		public void AdminFieldverify(DataTable datatable) throws InterruptedException {
			
			List<String> actual = datatable.asList();
			System.out.println("Size = "+ actual.size());
			//List<WebElement> Expected_List=driver.findElements(By.xpath("//div[contains(@data-control-name,'lblCustomerServicePhoneBSS')]"));
	        
			for (int i = 0; i < actual.size(); i++) {	        	
	           String Size = actual.get(i);
	           System.out.println(Size);
	            	Thread.sleep(2000);
	            	Boolean flag = false;
	        		while (!flag) {
	        			List<WebElement> data=driver.findElements(By.xpath("//div[normalize-space(text())='"+Size+"']"));
	        			////div[contains(text(),'Town')]
	        			////div[contains(text(),'"+Size+"')]
	        			System.out.println(data.size());
	        			for (int j = 0; j < data.size(); j++){
	        				if (isClickable(data.get(j))) {
	        					//System.out.println(Size +"Size of element string of data table");
	        					Wait.elementToBeClickable(driver, data.get(j), 5);
	        					String expectedString = data.get(j).getText().trim();
	        					System.out.println("Data Contain : "+data.get(j).getText());
	        					if(actual.get(i).equalsIgnoreCase(expectedString))
	        	            	{
	        	            		System.out.println("This is Expected:"+expectedString+" == "+" This is Actual:"+actual.get(i));
	        	            	}
	        	            	else
	        	            	{
	        	            		System.out.println("This is Expected:"+expectedString+" is not equal "+"This is Actual:"+actual.get(i));
	        	            	}
	        					flag = true;
	        				j = data.size();
	        				}
	        			}
	        		}
			}
	        		}

	        			
	        		public void SellerFieldverify(DataTable datatable) throws InterruptedException {
	        			
	        			List<String> actual = datatable.asList();
	        			System.out.println("Size = "+ actual.size());
	        			//List<WebElement> Expected_List=driver.findElements(By.xpath("//div[contains(@data-control-name,'lblCustomerServicePhoneBSS')]"));
	        	        
	        			for (int i = 0; i < actual.size(); i++) {	        	
	        	           String Size = actual.get(i);
	        	            	Thread.sleep(2000);
	        	            	Boolean flag = false;
	        	        		while (!flag) {
	        	        			List<WebElement> data=driver.findElements(By.xpath("//div[text()='"+Size+"']"));
	        	        			System.out.println(data.size());
	        	        			for (int j = 0; j < data.size(); j++){
	        	        				if (isClickable(data.get(j))) {
	        	        					System.out.println(Size +"Size of element string of data table");
	        	        					Wait.elementToBeClickable(driver, data.get(j), 5);
	        	        					String expectedString = data.get(j).getText();
	        	        					System.out.println("Data Contain : "+data.get(j).getText());
	        	        					if(actual.get(i).equalsIgnoreCase(expectedString))
	        	        	            	{
	        	        	            		System.out.println("This is Expected: "+ expectedString+" == "+" This is Actual:  "+actual.get(i));
	        	        	            	}
	        	        	            	else
	        	        	            	{
	        	        	            		System.out.println("This is Expected  "+expectedString+" is not equal "+"This is Actual  "+actual.get(i));
	        	        	            	}
	        	        					flag = true;
	        	        				j = data.size();
	        	        				}
	        	        			}
	            }
		}    
			        }
}


			
		

		






