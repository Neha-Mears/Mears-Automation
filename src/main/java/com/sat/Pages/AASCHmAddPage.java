package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.joda.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.Assertions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;



public class AASCHmAddPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@aria-label='Open calendar']") 
	private WebElement gettingDate;
	
	@FindBy(xpath = "//*[@type='submit']//span[normalize-space()='Next']") 
	private WebElement Nextbtn;
	
	@FindBy(xpath = "//*[@class='mat-focus-indicator mat-button mat-button-base mat-save']")
	private WebElement Submitbtn;
	
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	private WebElement OKbtn;
	
	@FindBy(xpath = "//span[normalize-space()='Save']") 
	private WebElement Savebtn;
	
	@FindBy(xpath = "//*[starts-with(@class,'mat-focus-indicator mears-form')]//*[contains(text(),'Find')]")
	private WebElement Findbtn;
	
	@FindBy(xpath = "(//*[starts-with(@class,'mat-cell cdk-cell risks')]//*[contains(@aria-label,'row icon')])[1]")
	private WebElement pencilIcon;
	
	WebElement Iconeditbtn;
	Testutil testutil = new Testutil();
	Wait waits = new Wait();
	Testutil util = new Testutil();
    Assertions assertion = new Assertions(driver);
    WebElement Defaultchk;
    private static String actualref;

	
 	 
	public AASCHmAddPage(WebDriver driver) {
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
	
	public void verifyalertmessage(String field,DataTable datatable) throws InterruptedException {
		
		List<String> actual = datatable.asList();
		System.out.println("Size = "+ actual.size());
		System.out.println("Validation is for "+field );
		for (int i = 0; i <= actual.size()-1; i++) {
        	
            int j =i + 1;
            Thread.sleep(2000);
            WebElement ele= driver.findElement(By.xpath("//*[contains(text(),'"+actual.get(i)+"')]"));
            System.out.println(driver.findElement(By.xpath("//*[contains(text(),'"+actual.get(i)+"')]"))
            		.getAttribute("innerText")+ "==" + actual.get(i));
          String data= driver.findElement(By.xpath("//*[contains(text(),'"+actual.get(i)+"')]")).getAttribute("innerText");
         // System.out.println(data);
          Wait.waitUntilElementVisible(driver, ele);
         Assert.assertEquals(ele.getText(), actual.get(i));
	}
				}
	public void verifyKeysheader(DataTable datatable) throws InterruptedException {
		
		List<String> actual = datatable.asList();
		System.out.println("Size = "+ actual.size());
		for (int i = 0; i <= actual.size()-1; i++) {
            int j =i + 1;
            Thread.sleep(2000);
            WebElement ele= driver.findElement(By.xpath("(//*[contains(@title,'"+actual.get(i)+"')]//*[contains(text(),'"+actual.get(i)+"')])[1]"));
            System.out.println(driver.findElement(By.xpath("(//*[contains(@title,'"+actual.get(i)+"')]//*[contains(text(),'"+actual.get(i)+"')])[1]"))
            		.getAttribute("innerText")+ "==" + actual.get(i));
          String data= driver.findElement(By.xpath("(//*[contains(@title,'"+actual.get(i)+"')]//*[contains(text(),'"+actual.get(i)+"')])[1]")).getAttribute("innerText");
         // System.out.println(data);
          Wait.waitUntilElementVisible(driver, ele);
         Assert.assertEquals(ele.getText(), actual.get(i));
	}
				}
public void verifyserviceuserheader(String field,DataTable datatable) throws InterruptedException {
		
		List<String> actual = datatable.asList();
		System.out.println("Size = "+ actual.size());
		System.out.println("Validation is for "+field );
		for (int i = 0; i <= actual.size()-1; i++) {
        	
            int j =i + 1;
            Thread.sleep(2000);
            WebElement ele= driver.findElement(By.xpath("//*[contains(text(),'"+actual.get(i)+"')]"));
            System.out.println(driver.findElement(By.xpath("//*[contains(text(),'"+actual.get(i)+"')]"))
            		.getAttribute("innerText")+ "==" + actual.get(i));
          String data= driver.findElement(By.xpath("//*[contains(text(),'"+actual.get(i)+"')]")).getAttribute("innerText");
         // System.out.println(data);
          Wait.waitUntilElementVisible(driver, ele);
         Assert.assertEquals(ele.getText(), actual.get(i));
	}
				}
	public void selectFromDateAndToDate(String setMonth, String setYear, String setDate) throws ParseException {
		
		gettingDate.click();
		//System.out.println("Select the year");
		driver.findElement(By.xpath("//*[@aria-label='Choose month and year']")).click();
		WebElement fromyear= driver.findElement(By.xpath("//*[starts-with(@class,'mat-calendar-body-cell-container ng-star-inserted')]//*[@aria-label='"+setYear+"']"));
		Wait.elementToBeClickable(driver, fromyear, 3);
		testutil.actionMethodClick(driver, fromyear);
		//System.out.println("Select the year" +fromyear);
		//System.out.println("Select the month");
		WebElement frommonth= driver.findElement(By.xpath("//*[starts-with(@class,'mat-calendar-body-cell-container ng-star-inserted')]//*[@aria-label='"+setMonth+" "+setYear+"']"));
		Wait.elementToBeClickable(driver, frommonth, 3);
		//System.out.println("Select the month" +frommonth);
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
			
			if (SelectedDate > currentday)
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
					
					System.out.println("The selected date ' "+SelectedDate+"' is not enable and clickable. ");	
					fromDate.click();
				}
					
				}
				else {
					System.out.println("The selected date fromDate' "+SelectedDate+"' is enable and clickable. ");	
					fromDate.click();
					//testutil.actionMethodClick(driver, fromDate);
				}
			}
		
		
	 public void clickOnCancel() throws InterruptedException
	    {
	    	try {
	    	Thread.sleep(1000);
	    	WebElement clearbtn = driver.findElement(By.xpath("//*[starts-with(@aria-label,'Open calendar')]//*[contains(text(),'clear')]"));
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",clearbtn );
	    	util.actionMethodClick(driver, clearbtn);
	    	
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	 public void clickOnDetail(String option) throws InterruptedException
	    {
	    	
	    	 switch(option)
				{
				case "Risk Details":
					try {
				    	Thread.sleep(1000);
				    	WebElement riskbtn = driver.findElement(By.xpath("//*[@class='risks-panel__wrapper ng-star-inserted']//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column')]"));
				    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",riskbtn );
				    	util.actionMethodClick(driver, riskbtn);
				    	  break;
				    	}
		 
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
				}
	    }
	 public void clickOnplusIcon() throws InterruptedException
	    {
	    	try {
	    	Thread.sleep(1000);
	    	WebElement plusbtn = driver.findElement(By.xpath("(//*[starts-with(@class,'mat-expansion-panel-header')]//*[contains(@svgicon,'add')])[1]"));
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",plusbtn );
	    	util.actionMethodClick(driver, plusbtn);
	    	
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	public void selectDOBInServiceUserDetails(String setMonth, String setYear, String setDate) throws ParseException {
		System.out.println("Clicking on Calender");
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
	//	Wait.elementToBeClickable(driver, fromDate, 3);
	//	testutil.actionMethodClick(driver, fromDate);	
		System.out.println("Select the date");
		System.out.println("click on From date "+fromDate.getText());
		    int SelectedDate = Integer.parseInt(setDate);
		    System.out.println("click on Selected date "+SelectedDate);
			Date currentdate = new Date();
			SimpleDateFormat formatter= new SimpleDateFormat("d");
			int currentday= Integer.parseInt(formatter.format(currentdate));
			String datetoBook = formatter.format(currentdate);
			System.out.println("The current date is "+currentday);
			
		//	if (SelectedDate > currentday)
				
			//{
				//System.out.println("Inside condition if");
				boolean isdatedisabled=fromDate.getAttribute("class").contains("disabled");
				if(isdatedisabled) {
					System.out.println("The selected date ' "+SelectedDate+"' is disabled and not clickable. ");	
					System.out.println("Error: Future birthday selected");	
					Actions actions= new Actions(driver);
					WebElement clickout=driver.findElement(By.xpath("//*[contains(text(),'Service User Details')]"));
					actions.moveToElement(clickout);
					testutil.actionMethodClick(driver, clickout);
					clickout.click();
				}
				
				else {
					System.out.println("Inside condition else");
					System.out.println("The selected date ' "+SelectedDate+"' is  enable and clickable. ");	
					System.out.println("The selected date fromDate' "+SelectedDate+"' is enable and clickable. ");	
					WebElement DateToSelect=driver.findElement(By.xpath("//*[starts-with(@class,'mat-calendar-body-cell-container ng-star-inserted')]//*[@aria-label='"+SelectedDate+" " +setMonth+" "+ setYear+"']"));
					testutil.actionMethodClick(driver, DateToSelect);
				}
		//	}
			//	else {
					//System.out.println("The selected date fromDate' "+SelectedDate+"' is enable and clickable. ");	
				//	WebElement DateToSelect=driver.findElement(By.xpath("//*[starts-with(@class,'mat-calendar-body-cell-container ng-star-inserted')]//*[@aria-label='"+SelectedDate+" " +setMonth+" "+ setYear+"']"));
				//	testutil.actionMethodClick(driver, DateToSelect);
					//fromDate.click();
				}
			//	}
			 
				
				
			
	
	
	
	public void selectcurrentdateforappointment() throws InterruptedException
	{
		//Locate the calender element
		WebElement calenderElement = driver.findElement((By.xpath("//*[@class='jqx-max-size jqx-position-relative']")));
		Wait.elementToBeClickable(driver, calenderElement, 2);
		calenderElement.click();
		
		// Get the current date
		Date currentDate= new Date();
		Calendar calender= Calendar.getInstance();
		calender.setTime(currentDate);
		
		int yearToSelect = calender.get(Calendar.YEAR);
		int monthToSelect =  calender.get(Calendar.MONTH);
		//for month
		LocalDate currentD= LocalDate.now();
		int currentMon= currentD.getMonthOfYear();
		Month month = Month.of(currentMon);
		String fullMonth = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int dayToSelect =  calender.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today's Year "+yearToSelect);
		System.out.println("Today's Month "+fullMonth);
		System.out.println("Today's Date  "+dayToSelect);
		//Find the year, month and date cells and click them
		 driver.findElement(By.xpath("//*[starts-with(@id,'calendarTitleHeaderViewinnerCalendarjqxWidget')]//*[contains(text(),'"+fullMonth+" "+yearToSelect+"')]")).click();
		 System.out.println("Select the Today Year");
		 Wait.untilPageLoadComplete(driver,2000);	
		 Boolean flag = false;
			while (!flag) {
				List<WebElement> ele = driver.findElements(By.xpath("//*[starts-with(@class,'jqx-calendar-title-content')]"));
				System.out.println(ele.size());
				//System.out.println(ele);
				if(ele.size() != 0) {
					for (int i = 0; i < ele.size(); i++){
						if (isClickable(ele.get(i))) {
							testutil.actionMethodClick(driver, ele.get(i));
							//testutil.jsclick(driver, Service.get(i));
							flag = true;
							i = ele.size();
						}
						else {
							System.out.println("element is not clickable so executing else");
						}
					}
					}
				}		
			Thread.sleep(2000);
			//System.out.println("Select the Today month");
			 String monthsubstring = fullMonth.substring(0,3);
			// System.out.println("Sub string  "+monthsubstring);
					//WebElement monthselected = driver.findElement(By.xpath("(//*[contains(text(),'"+monthsubstring+"')])[2]"));
			 WebElement monthselected = driver.findElement(By.xpath("//*[starts-with(@class,'jqx-calendar-view')]//*[contains(text(),'"+monthsubstring+"')]"));
			 Wait.elementToBeClickable(driver, monthselected, 3);
					testutil.actionMethodClick(driver, monthselected);	
						
						
	//System.out.println("Select the Today date");
	 Wait.untilPageLoadComplete(driver,2000);	
		WebElement date= driver.findElement(By.xpath("(//*[starts-with(@class,'jqx-rc-all jqx-item jqx-calendar-cell jqx-calendar-cell-month')])["+dayToSelect+"]"));
		Wait.elementToBeClickable(driver, date, 3);
		testutil.actionMethodClick(driver, date);
		System.out.println("Select the Today date "+date.getText());
		date.click();
		
	}
	public void selectcurrentdateforappointmentday() throws InterruptedException
	{
		//Locate the calender element
		WebElement calenderElement = driver.findElement((By.xpath("//*[@class='jqx-max-size jqx-position-relative']")));
		Wait.elementToBeClickable(driver, calenderElement, 2);
		calenderElement.click();
		
		// Get the tommorow date
		Date currentDate= new Date();
		Calendar calender= Calendar.getInstance();
		calender.setTime(currentDate);
		
		int yearToSelect = calender.get(Calendar.YEAR);
		int monthToSelect =  calender.get(Calendar.MONTH);
		//for month
		LocalDate currentD= LocalDate.now();
		LocalDate tommorowDate = currentD.plusDays(1);
		int currentMon= currentD.getMonthOfYear();
		Month month = Month.of(currentMon);
		String fullMonth = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int tommorowDay =  tommorowDate.getDayOfMonth();
		int correctdate=tommorowDay-1;
		System.out.println("Current Year "+yearToSelect);
		System.out.println("Current Month "+fullMonth);
		System.out.println("Tommorows's Date  "+tommorowDay);
		//Find the year, month and date cells and click them
		WebElement monthyear= driver.findElement(By.xpath("//*[starts-with(@id,'calendarTitleHeaderViewinnerCalendarjqxWidget')]//*[contains(text(),'"+fullMonth+" "+yearToSelect+"')]"));
		monthyear.click();
	//	System.out.println("Select the Today Year"+monthyear.getText());
		 Wait.untilPageLoadComplete(driver,2000);	
		 Boolean flag = false;
			while (!flag) {
				List<WebElement> ele = driver.findElements(By.xpath("//*[starts-with(@class,'jqx-calendar-title-content')]"));
				System.out.println(ele.size());
				//System.out.println(ele);
				if(ele.size() != 0) {
					for (int i = 0; i < ele.size(); i++){
						if (isClickable(ele.get(i))) {
							testutil.actionMethodClick(driver, ele.get(i));
							//testutil.jsclick(driver, Service.get(i));
							System.out.println("Today year is selected");
							flag = true;
							i = ele.size();
						}
						else {
							System.out.println("element is not clickable so executing else");
						}
					}
					}
				}		
			Thread.sleep(2000);
			//System.out.println("Select the Today month");
			 String monthsubstring = fullMonth.substring(0,3);
			 System.out.println("Sub string  "+monthsubstring);
					WebElement monthselected = driver.findElement(By.xpath("(//*[contains(text(),'"+monthsubstring+"')])[2]"));
					Wait.elementToBeClickable(driver, monthselected, 3);
					testutil.actionMethodClick(driver, monthselected);	
						
						
	//System.out.println("Select the Tommorow date");
	 Wait.untilPageLoadComplete(driver,2000);	
		WebElement date= driver.findElement(By.xpath("(//*[starts-with(@class,'jqx-rc-all jqx-item jqx-calendar-cell jqx-calendar-cell-month')])["+correctdate+"]"));
		//String dateclick =  date.getText().toString();
		//int correctdate = Integer.parseInt(dateclick)-1;
		Wait.elementToBeClickable(driver, date, 3);
		testutil.actionMethodClick(driver, date);
		System.out.println("Date selected "+date.getText());
		date.click();
						
				
			}
					

						
				
			
			
	
	public void selectcurrentdatefortommorowappointment() throws InterruptedException
	{
		//Locate the calender element
		WebElement calenderElement = driver.findElement((By.xpath("//*[@class='jqx-max-size jqx-position-relative']")));
		Wait.elementToBeClickable(driver, calenderElement, 2);
		calenderElement.click();
		
		// Get the tommorow date
		Date currentDate= new Date();
		Calendar calender= Calendar.getInstance();
		calender.setTime(currentDate);
		
		int yearToSelect = calender.get(Calendar.YEAR);
		int monthToSelect =  calender.get(Calendar.MONTH);
		//for month
		LocalDate currentD= LocalDate.now();
		LocalDate tommorowDate = currentD.plusDays(1);
		int currentMon= currentD.getMonthOfYear();
		Month month = Month.of(currentMon);
		String fullMonth = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int tommorowDay =  tommorowDate.getDayOfMonth();
		int correctdate=tommorowDay-1;
		System.out.println("Current Year "+yearToSelect);
		System.out.println("Current Month "+fullMonth);
		System.out.println("Tommorows's Date  "+tommorowDay);
		//Find the year, month and date cells and click them
		WebElement monthyear= driver.findElement(By.xpath("//*[starts-with(@id,'calendarTitleHeaderViewinnerCalendarjqxWidget')]//*[contains(text(),'"+fullMonth+" "+yearToSelect+"')]"));
		monthyear.click();
	//	System.out.println("Select the Today Year"+monthyear.getText());
		 Wait.untilPageLoadComplete(driver,2000);	
		 Boolean flag = false;
			while (!flag) {
				List<WebElement> ele = driver.findElements(By.xpath("//*[starts-with(@class,'jqx-calendar-title-content')]"));
				System.out.println(ele.size());
				//System.out.println(ele);
				if(ele.size() != 0) {
					for (int i = 0; i < ele.size(); i++){
						if (isClickable(ele.get(i))) {
							testutil.actionMethodClick(driver, ele.get(i));
							//testutil.jsclick(driver, Service.get(i));
							System.out.println("Today year is selected");
							flag = true;
							i = ele.size();
						}
						else {
							System.out.println("element is not clickable so executing else");
						}
					}
					}
				}		
			Thread.sleep(2000);
			//System.out.println("Select the Today month");
			 String monthsubstring = fullMonth.substring(0,3);
			 System.out.println("Sub string  "+monthsubstring);
					WebElement monthselected = driver.findElement(By.xpath("(//*[contains(text(),'"+monthsubstring+"')])[2]"));
					Wait.elementToBeClickable(driver, monthselected, 3);
					testutil.actionMethodClick(driver, monthselected);	
						
						
	//System.out.println("Select the Tommorow date");
	 Wait.untilPageLoadComplete(driver,2000);	
		WebElement date= driver.findElement(By.xpath("(//*[starts-with(@class,'jqx-rc-all jqx-item jqx-calendar-cell jqx-calendar-cell-month')])["+correctdate+"]"));
		//String dateclick =  date.getText().toString();
		//int correctdate = Integer.parseInt(dateclick)-1;
		Wait.elementToBeClickable(driver, date, 3);
		testutil.actionMethodClick(driver, date);
		System.out.println("Date selected "+date.getText());
		date.click();
		
	}
	public void selectcurrenttimeslotappointment(String appointment) throws InterruptedException
	{
		Date currentDate= new Date();
		
		SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate= formatter.format(currentDate);
		System.out.println("Current date  "+formattedDate);
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);  
		WebElement slotTime= driver.findElement(By.xpath("(//*[starts-with(@data-date,'"+formattedDate+" "+appointment+"')][last()])[1]"));
		new Actions(driver).moveToElement(slotTime).perform(); 
		System.out.println("Slot time  "+slotTime.getText());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",slotTime );
		Wait.elementToBeClickable(driver, slotTime, 3);
		testutil.actionMethodClick(driver, slotTime);
		System.out.println("System date  "+slotTime.getText());
		//right click slottime
		Actions actions= new Actions(driver);
		actions.contextClick(slotTime).perform();
		
	}
	public void selecttommorowtimeslotappointment(String appointment) throws InterruptedException
	{
		try {
		//LocalDate currentD= LocalDate.now();
		LocalDate tommorowDate = LocalDate.now().plusDays(1);
		System.out.println("Date display to select  "+tommorowDate);
		//DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("Next Current date  "+tommorowDate);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);  
		Thread.sleep(3000);
		WebElement slotTime= driver.findElement(By.xpath("(//*[starts-with(@data-date,'"+tommorowDate+" "+appointment+"')][last()])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",slotTime );
		Wait.elementToBeClickable(driver, slotTime, 3);
		testutil.actionMethodClick(driver, slotTime);
		//System.out.println("System date  "+slotTime.getText());
		//right click slottime
		Actions actions= new Actions(driver);
		actions.contextClick(slotTime).perform();
		
	}catch(Exception e) {
	
		System.out.println("inside catch");
		
		
	}
}
	public void selecttEditappointment(String appointment) throws InterruptedException
	{
		try {
		//LocalDate currentD= LocalDate.now();
		LocalDate tommorowDate = LocalDate.now().plusDays(1);
		System.out.println("Date display to select  "+tommorowDate);
		//DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//System.out.println("Next Current date  "+formattedDate);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);  
		Thread.sleep(3000);
		WebElement slotTime= driver.findElement(By.xpath("(//*[contains(@class,'jqx-scheduler-appointment jqx-rc-all')])[last()]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",slotTime );
		Wait.elementToBeClickable(driver, slotTime, 3);
		testutil.actionMethodClick(driver, slotTime);
		//System.out.println("System date  "+slotTime.getText());
		//right click slottime
		Actions actions= new Actions(driver);
		actions.contextClick(slotTime).perform();
		
	}catch(Exception e) {
	
		System.out.println("inside catch");
		
		
	}
}
		
	
	public void selectlistapppointment(String value) 
	{
		WebElement dropdownappointmentuser = driver.findElement(By.xpath("//*[contains(@placeholder,'"+value+"')]"));
		System.out.println(dropdownappointmentuser.getText());
	//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownappointmentuser );
		Wait.elementToBeClickable(driver, dropdownappointmentuser, 2);
		System.out.println("going to click on "+value);
		try {
			//dropdownappointmentuser.click();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownappointmentuser );
			System.out.println("inside try");
			//dropdownappointmentuser.click();
			testutil.jsclick(driver,dropdownappointmentuser);
			//util.actionMethodClick(driver, dropdownappointmentuser);
		}catch(Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownappointmentuser );
			System.out.println("inside catch");
			//util.actionMethodClick(driver, dropdownappointmentuser);
			dropdownappointmentuser.click();
		}

	}
	public void selectlistvalueapppointment(String value) 
	{
				Boolean flag = false;
				while (!flag) {
					List<WebElement> dropdownappointmentvalue = driver.findElements(By.xpath("//*[starts-with(@class,'cdk-overlay-pane')]//*[contains(text(),'"+value+"')]"));
						for (int i = 0; i < dropdownappointmentvalue.size(); i++) {
							if (isClickable(dropdownappointmentvalue.get(i))) {
							
								try {
									//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownappointmentvalue.get(i));
									System.out.println("inside try");
									dropdownappointmentvalue.get(i).click();
									//testutil.jsclick(driver,dropdownappointmentvalue.get(i));
								}catch(Exception e) {
								//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownappointmentvalue.get(i) );
									System.out.println("inside catch");
									util.actionMethodClick(driver,dropdownappointmentvalue.get(i));
									//dropdownappointmentvalue.get(i).click();
								}
								System.out.println("clicked on "+ value);
								flag = true;
								i = dropdownappointmentvalue.size();
				}

			}
	
	}
	}
	public void selectlistvaluefortrade(String value) 
	{
				Boolean flag = false;
				while (!flag) {
					List<WebElement> dropdownappointmentvalue = driver.findElements(By.xpath("//*[starts-with(@class,'mat-option mat-focus-indicator')]//*[contains(text(),'"+value+"')]"));
					//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownappointmentvalue );
						for (int i = 0; i < dropdownappointmentvalue.size(); i++) {
							if (isClickable(dropdownappointmentvalue.get(i))) {
								
								try {
									//dropdownappointmentuser.click();
									((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownappointmentvalue.get(i) );
									System.out.println("inside try");
									dropdownappointmentvalue.get(i).click();
									System.out.println("clicked on "+ value);
									flag = true;
									i = dropdownappointmentvalue.size();
									//testutil.jsclick(driver,dropdownappointmentuser);
									//util.actionMethodClick(driver, dropdownappointmentuser);
								}catch(Exception e) {
									((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownappointmentvalue.get(i) );
									System.out.println("inside catch");
									util.actionMethodClick(driver, dropdownappointmentvalue.get(i));
									//dropdownappointmentuser.click();
								// ele.get(i).click();
								// testutil.jsclick(driver,dropdownappointmentvalue.get(i));
								/*
								util.actionMethodClick(driver, dropdownappointmentvalue.get(i));
								System.out.println("clicked on "+ value);
								flag = true;
								i = dropdownappointmentvalue.size();
								*/
				}

			}
	
						}
				}
				
	}
	public void clickOnNext()throws InterruptedException
	{
		 //testutil.jsclick(driver, Nextbtn);
		 //System.out.println("User Clicked on the  Button");
		 Boolean flag = false;
			while (!flag) {
				List<WebElement> Nextbtn = driver.findElements(By.xpath("//*[@type='submit']//span[normalize-space()='Next']"));
				
				
					for (int i = 0; i < Nextbtn.size(); i++) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Nextbtn.get(i) );
						if (isClickable(Nextbtn.get(i))) {
							System.out.println("click on Next");
							util.actionMethodClick(driver, Nextbtn.get(i));
							System.out.println("clicked on next");
							flag = true;
							i = Nextbtn.size();
			}
		
					}
			}
	}
public void clickOnCalcelbtnAndOkbtnappointment() {
		
		Boolean flag1= false;
		while (!flag1) {
			List<WebElement> okBtn = driver.findElements(By.xpath("//*[contains(@class,'mat-focus-indicator mat-button mat-button-base mat-save')]//*[contains(text(),'OK')]"));
			for (int i = 0; i < okBtn.size(); i++) {
				if (isClickable(okBtn.get(i))) {
					okBtn.get(i).click();
					flag1 = true;
					i = okBtn.size();
				}
			}
		}
	}
    public void takescreenshotappointmentpage(String testcase) throws IOException
    {
    	/*
    	System.out.println("Going to take screenshot");
    	//Take Screenshot
    	File screenshotfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	
    		//screenshotBytes = Files.readAllBytes(screenshotFile.toPath());
    		String screenshotImagepath= "C:\\Users\\neha.sain\\OneDrive - Mears Group\\Pictures\\Screenshots.png";
    		try {
    			ImageIO.write(ImageIO.read(screenshotfile), "png", new File(screenshotImagepath));
    			System.out.println("Screenshot saved to : "+screenshotImagepath);
    		}catch(IOException e)
    		{
    			e.printStackTrace();
    		}
    	*/
    	
    	/////////////
    	
    	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    	String timestamp= sdf.format(new Date());
    	//Define the file path and name
    	String testCaseName= testcase;
    	String screenshotName = testCaseName+ "_"+ timestamp+".png";
    	String screenshotDirectory= "C:\\Users\\neha.sain\\OneDrive - Mears Group\\Pictures\\TestCasesScreenShot";
    	String filePath= screenshotDirectory + File.separator+screenshotName;
    	//Take the screenshot and save it
    	File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileHandler.copy(screenshotFile, new File(filePath));
    	System.out.println("Screenshot saved: "+filePath);
    }
    public void submitbtnappointmentpage()
    {
    Wait.elementToBeClickable(driver, Submitbtn, 3);
    //Submitbtn.click();
    try {
    	new Actions(driver).moveToElement(Submitbtn).perform(); 
    	Submitbtn.click();
    //	testutil.jsclick(driver, Submitbtn);
	//	util.actionMethodClick(driver, Submitbtn);
	}catch(Exception e) {
		//testutil.jsclick(driver, Submitbtn);
		//Submitbtn.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Submitbtn);
		util.actionMethodClick(driver, Submitbtn);
	}
	
}
    
    
    public void ClickRecentEditButtonOnLastPage()
    {
    	boolean isLastPage = false;
    	while(!isLastPage)
    	{
    		if(isOnLastPage())
    		{
    			isLastPage=true;
    		}
    	else
    	{
    		navigateToNextPage(driver);
    	}
    }
    }
    public void EditbtunderIcon(String underIcon)
    {
    	
    	try {
	    	Thread.sleep(1000);
	    	Iconeditbtn = driver.findElement(By.xpath("//*[contains(@title,'"+underIcon+"')]//*[@data-mat-icon-name='edit'][1]"));
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Iconeditbtn );
	    	util.actionMethodClick(driver, Iconeditbtn);
	    	
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	
    }

    public void icheckTheStateOfTheCheckbox()
    {
    	
    	try {
	    	Thread.sleep(1000);
		    List<WebElement> checkboxes= driver.findElements(By.xpath("(//*[contains(@title,'Keys')]//*[contains(@class,'mat-checkbox-checked')])[last()]"));
	    	if(!checkboxes.isEmpty())
	    	{
	    		System.out.println("\u001B[32mCheckbox is checked.\u001B[0m");
	    		
	    	}
	    	else
	    	{
	    		System.out.println("\u001B[32mCheckbox is not checked.\u001B[0m");
	    	}
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	
    }
   
    public void Clickdecending(String column,String Tab)
    {
    	System.out.println("going to click decending arrow");
    	Wait.untilPageLoadComplete(driver,500);
    	   Actions actions= new Actions(driver);
    	WebElement descbutton= driver.findElement(By.xpath("//*[@title='"+Tab+"'or @matsortactive='"+Tab+"']//*[contains(text(),'"+column+"')]"));
    	actions.moveToElement(descbutton);
    	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",descbutton );
    	try {
    		util.actionMethodClick(driver, descbutton);
    		//descbutton.click();
    		
    	}catch(Exception e) {
    		//descbutton.click();
    		//testutil.jsclick(driver, descbutton);
    		((JavascriptExecutor) driver).executeScript("arguments[0].click();", descbutton);
    	}
    }
   
    public  boolean isOnLastPage()
    {
    	WebElement nextbutton= driver.findElement(By.xpath("(//*[@aria-label='Next page'])[2]"));
    	if(nextbutton.isDisplayed() && nextbutton.isEnabled() )
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    public void navigateToNextPage(WebDriver driver)
    {
    	WebElement nextbutton= driver.findElement(By.xpath("(//*[@aria-label='Next page'])[2]"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",nextbutton );
    	if(nextbutton.isDisplayed() && nextbutton.isEnabled() )
    	{
    		//nextbutton.click();
    		try {
				testutil.jsclick(driver, nextbutton);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else
    	{
    		throw new NoSuchElementException("Next Button not found or not enabled");
    	}
    }
    public void clickOnOkNewAppointment(String poptext, String popcomment)
	{
    Wait.untilPageLoadComplete(driver,500);
    WebElement text = driver.findElement(By.xpath("//*[contains(text(),'"+poptext+"')]"));
	System.out.println(text.getText());
	
	WebElement comment = driver.findElement(By.xpath("//*[contains(text(),'"+popcomment+"')]"));
	System.out.println(comment.getText());
	try {
		assertTrue(text.getText().contains(poptext), "Status is same");
	} catch (Exception e) {
		assertTrue(text.getText().contains(poptext), "Status is not same");
	}
	try {
		assertTrue(comment.getText().contains(popcomment), "Status is same");
	} catch (Exception e) {
		assertTrue(comment.getText().contains(popcomment), "Status is not same");
	}
	
	
}
    public void okbtnappointmentpage()
    {
    	System.out.println("going to click on ok button");
    	Wait.untilPageLoadComplete(driver,500);
    	try {
    		util.actionMethodClick(driver, OKbtn);
    	}catch(Exception e) {
    		util.actionMethodClick(driver, OKbtn);
    	}
    }
    public void clickstaffMember(String field, String under) throws InterruptedException
    {
    	try {
    	Thread.sleep(1000);
    	WebElement ele = driver.findElement(By.xpath("//*[@class='add-edit-complaint-user-form__fieldset']//*[text()='"+field+"']"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
    	util.actionMethodClick(driver, ele);
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public void enterValue(String value,String txtfield) 
    {
    	switch(txtfield)
		{
		case "value_1":
				 	Wait.untilPageLoadComplete(driver,500);
			    	WebElement txt=driver.findElement(By.xpath("(//*[starts-with(@class,'search-form__row')]//*[@formcontrolname='value'])[1]"));
			    	txt.click();
			    	Wait.untilPageLoadComplete(driver,500);
			    	txt.sendKeys(value);
			    	break;
			 
		case "value_2":
			    
			    	WebElement txt2=driver.findElement(By.xpath("(//*[starts-with(@class,'search-form__row')]//*[@formcontrolname='value'])[2]"));
			    	Wait.elementToBeClickable(driver, txt2, 2);
			    	txt2.click();
			    	Wait.untilPageLoadComplete(driver,500);
			    	txt2.sendKeys(value);
			    	break;
			
			 }	
    	
    	
    }
    public void clickFind() throws InterruptedException
    {
    	Thread.sleep(1000);
    	util.actionMethodClick(driver, Findbtn);
    	
    }
    public void selectserviceuser(String value) throws InterruptedException
    {
    	Thread.sleep(1000);
    	WebElement tab= driver.findElement(By.xpath("(//*[starts-with(@class,'mat-row cdk-row mears')]//*[contains(text(),'"+value+"')])[1]"));
    	Wait.elementToBeClickable(driver, tab, 2);
    	System.out.println("User Name Selected "+tab.getText());
    	try {
    	util.actionMethodClick(driver, tab);
    	}
    	catch(Exception e)
    	{
    		util.actionMethodClick(driver, tab);
}
    	
    }
    public void clickOnServiceSection(String sectionvalue) throws InterruptedException
    {
    	Thread.sleep(1000);
    	WebElement section = driver.findElement(By.xpath("//*[contains(text(),'"+sectionvalue+"')]"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", section);
    	util.actionMethodClick(driver, section);
    	
    }
    public void clickOnDietchk(String Itemcount, String value) throws InterruptedException
    {
    	int item = Integer.parseInt(Itemcount);
   	 System.out.println("Number of item to be selected is "+item);
   	 for(int i=0;i<item;i++)
   	 {
   		 int a=i+1;
   		 WebElement checkbox= driver.findElement(By.xpath("(//*[starts-with(@formarrayname,'"+value+"') or starts-with(@formcontrolname,'"+value+"')]//*[starts-with(@class,'mat-checkbox-background')])["+a+"]"));
   		// System.out.println(a);
   		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",checkbox );
   		 Wait.elementToBeClickable(driver, checkbox, 3);
   		// util.actionMethodClick(driver, checkbox);
   		try {
   		 util.actionMethodClick(driver, checkbox);
   	    	}
   	    	catch(Exception e)
   	    	{
   	    		util.actionMethodClick(driver, checkbox);
   	}
   	 }
    	
    }
    public void verifyReturnedchk(String value) throws InterruptedException
    {
    	
    		 WebElement checkbox= driver.findElement(By.xpath("(//*[contains(@title,'"+value+"')]//*[@type='checkbox'])[1]"));
    		 Wait.elementToBeClickable(driver, checkbox, 7);
    		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",checkbox );
    		 boolean ischecked = (Boolean)((JavascriptExecutor) driver).executeScript("return arguments[0].checked", checkbox);
    		// boolean isChecked =checkbox.isSelected();
    		 
    		System.out.println("Validate Checkbox is selected "+ischecked);
    	if(ischecked)
    	{
    		System.out.println("\u001B[32mReturned Checkbox is checked\u001B[0m");
    	}
    	else
    	{
    		System.out.println("\u001B[32mReturned Checkbox is not checked\u001B[0m");
    	}
    	 }
    	
    
    public void Continuebtndisabled() throws InterruptedException
    {
    	WebElement ContinuebtnDisable = driver.findElement(By.xpath("//*[contains(@class,'mat-button-base mat-save mat-button-disabled')]"));
		//Assert.assertEquals(countryDisable,false);
    	Boolean isDisabled= (Boolean)((JavascriptExecutor) driver).executeScript("return arguments[0].hasAttribute('disabled');", ContinuebtnDisable);
    	//Boolean Disclass= ContinuebtnDisable.getAttribute("class").contains("disabled");
    	
    	if(isDisabled){
	        System.out.println("Continue button is not clickable or disabled. ");
	  }else{
	        System.out.println("Continue button is clickable and enabled.");
	  }

    	
    }
    public void Clickonuserclickcontinue(String user,String btnname) throws InterruptedException
    {
    	try {
    		Wait.untilPageLoadComplete(driver);
    		System.out.println(user);
    		WebElement ContinuebtnDisable = driver.findElement(By.xpath("(//*[contains(text(),'"+user +"')])[1]"));
    		util.actionMethodClick(driver, ContinuebtnDisable);
    		Thread.sleep(1000);
    		WebElement Continuebtn = driver.findElement(By.xpath("//span[normalize-space()='"+btnname+"']"));
        util.actionMethodClick(driver, Continuebtn);
    		
    	}
    	catch (Exception e)
    	{
    		
    	}
}
     public void clickOnPencilIcon() throws InterruptedException
     {
    	 Thread.sleep(1000);
     	
    	try {
        	util.actionMethodClick(driver, pencilIcon);
        	}
        	catch(Exception e)
        	{
        		util.actionMethodClick(driver, pencilIcon);
     }
     }
     public void validateComplaintsfieldDisabled(String ComplaintMadeBystr,String ComplaintMadeAgainststr) throws InterruptedException
     {
    	
     WebElement ComplaintMadeBy = driver.findElement(By.xpath("(//*[starts-with(@class,'add-edit-complaint-user-form__fieldset add-edit-complaint-user-form__fieldset-disabled')])[1]"));
		//Assert.assertEquals(countryDisable,false);
 	//Boolean isDisabled= (Boolean)((JavascriptExecutor) driver).executeScript("return arguments[0].hasAttribute('disabled');", ComplaintMadeBy);
 	Boolean Disclass= ComplaintMadeBy.getAttribute("class").contains("disabled");
 	System.out.println(Disclass) ;
 	if(Disclass){
	        System.out.println(ComplaintMadeBystr +" Complaint Made By is not clickable or disabled. ");
	  }else{
	        System.out.println(ComplaintMadeBystr +" Complaint Made By  is clickable and enabled.");
	  }
 	 WebElement ComplaintMadeAgainst = driver.findElement(By.xpath("(//*[starts-with(@class,'add-edit-complaint-user-form__fieldset add-edit-complaint-user-form__fieldset-disabled')])[2]"));
		//Assert.assertEquals(countryDisable,false);
	//Boolean isDisabled= (Boolean)((JavascriptExecutor) driver).executeScript("return arguments[0].hasAttribute('disabled');", ComplaintMadeBy);
	Boolean isDisabled= ComplaintMadeAgainst.getAttribute("class").contains("disabled");
	System.out.println(Disclass) ;
	if(isDisabled){
	        System.out.println(ComplaintMadeAgainststr+" is not clickable or disabled. ");
	  }else{
	        System.out.println(ComplaintMadeAgainststr+ " Complaint Made Against  is clickable and enabled.");
	  }
}
     public void validatevalueundercolumn(String Columnname) throws InterruptedException
     {
    	WebElement table= driver.findElement(By.xpath("(//*[starts-with(@class,'mat-table cdk-table mat-sort mears-table')])[1]"));
    	List<WebElement> rows= table.findElements(By.xpath("(//*[@class='mat-header-row cdk-header-row ng-star-inserted'])[1]"));
    	rows.get(0).click();
    	boolean found=false;
    	for(WebElement row : rows) {
    		List<WebElement> columns = row.findElements(By.xpath("//*[starts-with(@class,'mat-sort-header mat-header-cell cdk-header-cell mears-table__column-header ng-tns')]"));
    		for(int i=0;i<columns.size();i++)
    		{
    		if(columns.size()>0 && columns.get(i).getText().equals(Columnname))
    		{
    			found=true;
    			break;
    		}
    	}
    	}
    	if(found) {
    		System.out.println("Name '"+Columnname+"'found in the table.");
    	}
    	else {
    		System.out.println("Name '"+Columnname+"' not found in the table.");
    	}
     }
     public void validatevalueundercolumnRisk(String Columnname) throws InterruptedException
     {
    	WebElement table= driver.findElement(By.xpath("//*[@class='risks-panel__wrapper ng-star-inserted']//*[starts-with(@class,'mat-table cdk-table mat-sort mears-table')]"));
    	List<WebElement> rows= table.findElements(By.xpath("//*[@class='risks-panel__wrapper ng-star-inserted']//*[@class='mat-header-row cdk-header-row ng-star-inserted']"));
    	
    	boolean found=false;
    	for(WebElement row : rows) {
    		List<WebElement> columns = row.findElements(By.xpath("//*[@class='risks-panel__wrapper ng-star-inserted']//*[starts-with(@class,'mat-sort-header mat-header-cell cdk-header-cell')]"));
    		for(int i=0;i<columns.size();i++)
    		{
    		if(columns.size()>0 && columns.get(i).getText().equals(Columnname))
    		{
    			found=true;
    			break;
    		}
    	}
    	}
    	if(found) {
    		System.out.println("Name '"+Columnname+"'found in the table.");
    	}
    	else {
    		System.out.println("Name '"+Columnname+"' not found in the table.");
    	}
    	
     }
     public void validatevalueunderrowRisk(String rowname) throws InterruptedException
     {
    	WebElement table= driver.findElement(By.xpath("//*[@class='risks-panel__wrapper ng-star-inserted']//*[starts-with(@class,'mat-table cdk-table mat-sort mears-table')]"));
    	List<WebElement> rows= table.findElements(By.xpath("//*[@class='risks-panel__wrapper ng-star-inserted']//*[starts-with(@class,'mat-cell cdk-cell mea')]"));
    	
    	boolean found=false;
    	for(WebElement row : rows) {
    		List<WebElement> rowsval = row.findElements(By.xpath("//*[@class='risks-panel__wrapper ng-star-inserted']//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column')]"));
    		//List<WebElement> rowsval = row.findElements(By.xpath("//*[contains(text(),'"+rowname+"')]"));
    		for(int i=0;i<rowsval.size();i++)
    		{
    		if(rowsval.size()>0 && rowsval.get(i).getText().equals(rowname))
    		{
    			found=true;
    			break;
    		}
    	}
    	}
    	if(found) {
    		System.out.println("Name '"+rowname+"'found in the table. Value matches with the data entered ");
    	}
    	else {
    		System.out.println("Name '"+rowname+"' not found in the table. Value not matches with the data entered");
    	}
     }
     public void validatevalueunderrow(String rowname) throws InterruptedException
     {
    	 
    	 WebElement table= driver.findElement(By.xpath("//*[starts-with(@class,'mat-table cdk-table mat-sort mears-table')]"));
    	List<WebElement> rows= table.findElements(By.xpath("//*[starts-with(@class,'mat-row cdk-row mears-table__data-row mears-table__data-row--hover ng-star-inserted')]"));
    	
    	boolean found=false;
    	for(WebElement row : rows) {
    		List<WebElement> rowsval = row.findElements(By.xpath("//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column')]"));
    		//List<WebElement> rowsval = row.findElements(By.xpath("//*[contains(text(),'"+rowname+"')]"));
    		for(int i=0;i<rowsval.size();i++)
    		{
    		if(rowsval.size()>0 && rowsval.get(i).getText().equals(rowname))
    		{
    			found=true;
    			break;
    		}
    	}
    	}
    	if(found) {
    		System.out.println("Name '"+rowname+"'found in the table. Value matches with the data entered ");
    	}
    	else {
    		System.out.println("Name '"+rowname+"' not found in the table. Value not matches with the data entered");
    	}
    	
     }
     public void ClickSameClientClassificationSlot(String appointment) throws InterruptedException
 	{
 		//LocalDate currentD= LocalDate.now();
 		LocalDate tommorowDate = LocalDate.now().plusDays(1);
 		System.out.println("Date display to select  "+tommorowDate);
 		//DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
 		//System.out.println("Next Current date  "+formattedDate);
 		driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);  
 		Thread.sleep(3000);
 		
 		WebElement slotTime= driver.findElement(By.xpath("(//*[starts-with(@data-date,'"+tommorowDate+" "+appointment+"')][last()])[1]"));
 		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",slotTime );
 		Wait.elementToBeClickable(driver, slotTime, 5);
 		testutil.actionMethodClick(driver, slotTime);
 		//System.out.println("System date  "+slotTime.getText());
 		//right click slottime
 		Actions actions= new Actions(driver);
 		actions.contextClick(slotTime).perform();
 		
 		
 	}
     public void ClickOnCalenderEditAppointment(String field) throws InterruptedException
  	{
  		switch(field) {
  		case "Appointment Start Date": 
  			System.out.println("Appointment Start Date  ");
  			 Boolean flag= false;
   	 		while (!flag) {
   	 			List<WebElement> okBtn = driver.findElements(By.xpath("//*[@placeholder='Appointment Start Date']//*[starts-with(@class,'mat-focus-indicator mat-menu-trigger')][1]"));
   	 			for (int i = 0; i < okBtn.size(); i++) {
   	 				if (isClickable(okBtn.get(i))) {
   	 				
   	 				try {
   	 				Wait.elementToBeClickable(driver, okBtn.get(i), 10);
   	 			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",okBtn.get(i) );	
   	 					okBtn.get(i).click();
   	 			
   	 					flag = true;
   	 					i = okBtn.size();
   	 				} catch(ElementClickInterceptedException e)
   	 				{
   	 					
   	 				}
   	 			}
   	 			}
   	 		/*
   	 		WebElement upbuttonStartDate = driver.findElement(By.xpath("(//*[starts-with(@class,'mat-focus-indicator number-input__button mat-button mat-icon-button mat-button-base')]//*[@data-mat-icon-name='down'])[1]"));
   	 	   Wait.elementToBeClickable(driver, upbuttonStartDate, 5);
   	 		util.actionMethodClick(driver, upbuttonStartDate);
    		//upbuttonStartDate.click();
    	*/
    		
   	 			break;
   		}
  		case "Appointment End Date": 
			 Boolean flag1= false;
	 		while (!flag1) {
	 			List<WebElement> okBtn = driver.findElements(By.xpath("(//*[starts-with(@class,'mat-focus-indicator mat-menu-trigger')])[2]"));
	 			for (int i = 0; i < okBtn.size(); i++) {
	 				if (isClickable(okBtn.get(i))) {
	 					Wait.elementToBeClickable(driver, okBtn.get(i), 3);
	 					okBtn.get(i).click();
	 					flag1 = true;
	 					i = okBtn.size();
	 				}
	 			}
	 			//Changed code
	 			//WebElement upbuttonEndDate = driver.findElement(By.xpath("(//*[starts-with(@class,'mat-focus-indicator number-input__button mat-button mat-icon-button mat-button-base')]//*[@data-mat-icon-name='down'])[1]"));
	    		//util.actionMethodClick(driver, upbuttonEndDate);
	    		//break;
		}
	 		
	}
}
     public void clickOnDailyview(String value) throws InterruptedException
     {
     	Thread.sleep(1000);
    	WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]"));
     	util.actionMethodClick(driver, element);
     	
     }
     public void clickOnSet(String value) throws InterruptedException
     {
     	Thread.sleep(1000);
    	WebElement element = driver.findElement(By.xpath("//*[starts-with(@class,'mat-focus-indicator')]//*[contains(text(),'"+value+"')]"));
     	util.actionMethodClick(driver, element);
     	
     }
     public void EnterStartTime(String value) throws InterruptedException
     {
     	Thread.sleep(1000);
    	WebElement stime = driver.findElement(By.xpath("(//*[starts-with(@class,'number-input')]//input[@type='number'])[1]"));
    	stime.click();
    	stime.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    	Wait.untilPageLoadComplete(driver,500);
    	char[] digits= value.toCharArray();
    	stime.sendKeys(String.valueOf(digits[0]));
    	stime.sendKeys(String.valueOf(digits[1]));
     	
     }
     public void EnterEndTime(String value) throws InterruptedException
     {
    	 Thread.sleep(1000);
     	WebElement stime = driver.findElement(By.xpath("(//*[starts-with(@class,'number-input')]//input[@type='number'])[1]"));
     	stime.click();
     	stime.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
     	Wait.untilPageLoadComplete(driver,500);
     	char[] digits= value.toCharArray();
     	stime.sendKeys(String.valueOf(digits[0]));
     	stime.sendKeys(String.valueOf(digits[1]));
     	
     }
     public void clickOndropdown() throws InterruptedException
     {
     	Thread.sleep(1000);
    	WebElement elementdropdown = driver.findElement(By.xpath("(//*[starts-with(@aria-labelledby,'mat-select-value')])[2]"));
     	util.actionMethodClick(driver, elementdropdown);
     	
     }
     public void iClickItemPerPage(String val) throws InterruptedException
     {
    	try {
    	 Thread.sleep(1000);
     	WebElement ItemPage = driver.findElement(By.xpath("(//*[@class='"+val+"']//*[@aria-label='Items per page:'])[1]//*[contains(@class,'mat-select-value ng-tns')]"));
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ItemPage);
     System.out.println("The Work Order display before change is: "+ItemPage.getText());
     util.actionMethodClick(driver, ItemPage);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
     	
     }
     public String GenerateUniquePortNumber(String txtfeild) throws InterruptedException
     {
    	 if(! Savebtn.isEnabled())
			{
				System.out.println("Save button is initially disable.");
			}
			else
			{
				System.out.println("Save button is not initially disable.");
			}
    	 WebElement portno = driver.findElement(By.xpath("//*[contains(@data-placeholder,'"+txtfeild+"') or contains(@formcontrolname,'"+txtfeild+"')]"));
     	System.out.println("Trying to create unique port Number");
     	int number= ThreadLocalRandom.current().nextInt();
     	//util.actionMethodClick(driver, portno);
     	//int number= ThreadLocalRandom.current().nextInt();
     	System.out.println("Random number before absolute: "+number);
     	 int randomnumber = Math.abs(number);
     	System.out.println("Random number is: "+randomnumber);
     	Wait.waitUntilElementVisible(driver, portno);
     	actualref=String.valueOf(randomnumber);
     	System.out.println("Random number is from reference: "+actualref);
     	portno.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
     	portno.sendKeys(String.valueOf(randomnumber));
     	portno.sendKeys(Keys.ENTER);
     	portno.click();
     	Wait.waitForInvisibilityOfElement(driver, portno, 5);
     	if(Savebtn.isEnabled())
		{
			System.out.println("Save button is enable after filling out the field.");
		}
		else
		{
			System.out.println("Save button is not enable after filling out the field.");
		}
     	return actualref;
     	
     }
     
     public void ValidateKeyAsDefalt(String Tab,String elementID) throws InterruptedException {
 		
     	boolean found=false;
     	String expectedval= String.valueOf(actualref);
     	System.out.println("Random number is in string: "+expectedval);
     		List<WebElement> cells = driver.findElements(By.xpath("//*[@title='"+Tab+"']//*[ contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-reference mat-column-reference ng-star-inserted')]"));
     		System.out.println("Number of Row present in Table : "+cells.size());
     		for(int i=0;i<=cells.size()-1;i++)
     		{
     			Thread.sleep(7000);
     			String actualtext=cells.get(i).getText();
     			//System.out.println(actualtext);
     			if(cells.get(i).getText().equals(actualref))
     			{
     				//System.out.println("\u001B[32mValue is added.\u001B[0m");
     				List<WebElement> cellVal = driver.findElements(By.xpath("//*[@title='Keys']//*[ contains(@class,'mat-row cdk-row mears-table__data-row ng-star-inserted')]"));
     				
     				String cell1value= cellVal.get(i).getText();
     				String[] substring = cell1value.split(" ");
         	
         			System.out.println("Keys Type :"+substring[0]);
         			System.out.println("Reference :"+substring[1]);
         			System.out.println("No of Sets :"+substring[2]);
         			//System.out.println("Keys Held By :"+substring[4]);
         			  List<WebElement> checkboxes= driver.findElements(By.xpath("(//*[contains(@title,'Keys')]//*[contains(@class,'mat-checkbox-checked')])[last()]"));
         		    	if(!checkboxes.isEmpty())
         		    	{
         		    		System.out.println("\u001B[32mDefault Checkbox is checked.\u001B[0m");
         		    		
         		    	}
         		    	else
         		    	{
         		    		System.out.println("\u001B[32mDefault Checkbox is not checked.\u001B[0m");
         		    	}
         		    	
     			}
     		}
     		
     		}
     		
    
     public void validatetitleService(DataTable datatable) throws InterruptedException
     {
    	 
    	List<String> actual = datatable.asList();
    	System.out.println("Size :" + datatable.asList().size());
    	
    	
    	for (int i = 0; i <= actual.size()-1; i++) {
            int j =i + 1;
            Thread.sleep(2000);
            WebElement ele= driver.findElement(By.xpath("//*[starts-with(@class,'breadcrumb hidden-print')]//*[starts-with(text(),'"+actual.get(i)+"')]"));
            System.out.println(driver.findElement(By.xpath("//*[starts-with(@class,'breadcrumb hidden-print')]//*[contains(text(),'"+actual.get(i)+"')]"))
            		.getAttribute("innerText")+ "==" + actual.get(i));
          String data= driver.findElement(By.xpath("//*[contains(text(),'"+actual.get(i)+"')]")).getAttribute("innerText");
         // System.out.println(data);
          Wait.waitUntilElementVisible(driver, ele);
         Assert.assertEquals(ele.getText(), actual.get(i));
    	}
 
     }  	
}



    	
    	
    	

	
	

	


	
	
		


		
		
		
		 
		
		
	
	
