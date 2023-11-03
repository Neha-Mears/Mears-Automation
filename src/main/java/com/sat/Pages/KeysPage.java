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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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




public class KeysPage {
	private WebDriver driver;
	
	
	@FindBy(xpath = "//*[@role='button']//*[contains(@class,'mat-expansion-panel-header-title expansion_panel__header-title')]") 
	private WebElement Filteratask;
	
	WebElement Iconeditbtn;
	Testutil testutil = new Testutil();
	Wait waits = new Wait();
	Testutil util = new Testutil();
    Assertions assertion = new Assertions(driver);
   // private static String actualref;
    private static String expectedval;
	public KeysPage(WebDriver driver) {
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
	public void ValidateKeyLogBookedOutBy(String Tab,String elementID, String val) throws InterruptedException {
	 	
	 	expectedval=val;
	 	System.out.println("\u001B[32mExpected value: .\u001B[0m"+expectedval);
	 		List<WebElement> cells = driver.findElements(By.xpath("//*[@title='"+Tab+"']//*[ contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-bookedOutBy mat-column-bookedOutBy ng-star-inserted')]"));
	 		System.out.println("\u001B[32mNumber of Row present in Table : .\u001B[0m"+cells.size());
	 		for(int i=0;i<=cells.size()-1;i++)
	 		{
	 			Thread.sleep(7000);
	 			String actualtext=cells.get(i).getText();
	 			
	 			System.out.println(actualtext);
	 			//System.out.println("\u001B[32mActual value.\u001B[0m"+actualtext);
	 			if(cells.get(i).getText().equals(expectedval))
	 			{
	 				System.out.println("\u001B[32mExpected value :.\u001B[0m"+expectedval+ "=="+"\u001B[32mActual Value.\u001B[0m" +actualtext);
	 				//System.out.println("\u001B[32mBooked Out By user by.\u001B[0m"+expectedval);
	 				List<WebElement> cellVal = driver.findElements(By.xpath("//*[@class='service-users-list__table']//*[ contains(@class,'mat-row cdk-row mears-table__data-row mears-table__data-row')]"));
					
	 			//	##################new way####################################################
	 				String cell1value= cellVal.get(i).getText();
	 				String input = cell1value;
	 				System.out.println(input);
	 		
	 				// Define regular expressions for matching the required information
	 		        String dateRegex = "\\d{1,2}/\\d{1,2}/\\d{4}";
	 		        String keyRegex = "Garage \\| \\d+";
	 		        String whoHasKeyRegex = "Owner";
	 		        String bookedOutByRegex = "   (\\w+ \\w+)"; // Capture "aasc HM"
	 		        String supplierRegex = "\\w+, \\w+";

	 		        // Compile regular expressions
	 		        Pattern datePattern = Pattern.compile(dateRegex);
	 		        Pattern keyPattern = Pattern.compile(keyRegex);
	 		       Pattern whoHasKeyPattern = Pattern.compile(whoHasKeyRegex);
	 		        Pattern bookedOutByPattern = Pattern.compile(bookedOutByRegex);
	 		        Pattern supplierPattern = Pattern.compile(supplierRegex);

	 		        // Use Matchers to find matches in the input string
	 		        Matcher dateMatcher = datePattern.matcher(input);
	 		        Matcher keyMatcher = keyPattern.matcher(input);
	 		        Matcher whoHasKeyMatcher = whoHasKeyPattern.matcher(input);
	 		        Matcher bookedOutByMatcher = bookedOutByPattern.matcher(input);
	 		        Matcher supplierMatcher = supplierPattern.matcher(input);

	 		        // Extract and print the information
	 		        if (dateMatcher.find()) {
	 		            System.out.println("Date: " + dateMatcher.group());
	 		        }
	 		        if (keyMatcher.find()) {
	 		            System.out.println("Key : " + keyMatcher.group());
	 		        }
	 		        if (whoHasKeyMatcher.find()) {
	 		            System.out.println("Who has Key : " + whoHasKeyMatcher.group());
	 		        }
	 		        if (bookedOutByMatcher.find()) {
	 		            System.out.println("Booked Out By : " + bookedOutByMatcher.group());
	 		        }
	 		        if (supplierMatcher.find()) {
	 		            System.out.println("Supplier : " + supplierMatcher.group());
	 		        }
	 		    
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
	 				System.out.println("\u001B[32mExpected value :.\u001B[0m"+expectedval+ " does not match "+"\u001B[32mActual Value.\u001B[0m" +actualtext);
	 			}
	 		
	 		}
	 			}
	
public void ValidatetenancyStatus(String Tab,String elementID, String val) throws InterruptedException {
	 	
	 	expectedval=val;
	 	System.out.println("\u001B[32mExpected value: .\u001B[0m"+expectedval);
	 		List<WebElement> cells = driver.findElements(By.xpath("//*[@class='service-users-list__table']//*[ contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-tenancyStatus mat-column-tenancyStatus ng-star-inserted')]"));
	 		System.out.println("\u001B[32mNumber of Row present in Table : .\u001B[0m"+cells.size());
	 		for(int i=0;i<cells.size();i++)
	 		{
	 			Thread.sleep(7000);
	 			String actualtext=cells.get(i).getText();
	 			
	 			System.out.println(actualtext);
	 			//System.out.println("\u001B[32mActual value.\u001B[0m"+actualtext);
	 			if(cells.get(i).getText().equals(expectedval))
	 			{
	 				System.out.println("\u001B[32mExpected value :.\u001B[0m"+expectedval+ "=="+"\u001B[32mActual Value.\u001B[0m" +actualtext);
	 				//System.out.println("\u001B[32mBooked Out By user by.\u001B[0m"+expectedval);
	 				List<WebElement> cellVal = driver.findElements(By.xpath("//*[@class='service-users-list__table']//*[ contains(@class,'mat-row cdk-row mears-table__data-row mears-table__data-row')]"));
	 				String cell1value= cellVal.get(i).getText();
					String[] substring = cell1value.split(" ");
	 				String input = cell1value;
	 				System.out.println(input);
	 					
	 					    System.out.println("Tenancy Status: " + substring[0]);
	 					    System.out.println("Name: " + substring[1]);
	 					    System.out.println("Service: " + substring[2]);
	 					    System.out.println("SU Type: " + substring[3]);
	 				
	 			}
	 		}
	 		
	 		}

public void ClosedTask(String Tab,String elementID, String val) throws InterruptedException {
 	
 	expectedval=val;
 	System.out.println("\u001B[32mExpected value: .\u001B[0m"+expectedval);
 		List<WebElement> cells = driver.findElements(By.xpath("//*[@class='tasks-panel__wrapper']//*[ contains(@class,'mat-cell cdk-cell mears-table__cell mears-table__cell-date-time cdk-column-status mat-column-status ng')]"));
 		System.out.println("\u001B[32mNumber of Row present in Table : .\u001B[0m"+cells.size());
 		for(int j=0;j<cells.size();j++)
 		{
 			Thread.sleep(7000);
 			String actualtext=cells.get(j).getText();
 			
 			System.out.println(actualtext);
 			//System.out.println("\u001B[32mActual value.\u001B[0m"+actualtext);
 			if(cells.get(j).getText().equals(expectedval))
 			{
 				System.out.println("\u001B[32mExpected value :.\u001B[0m"+expectedval+ "=="+"\u001B[32mActual Value.\u001B[0m" +actualtext);
 				//System.out.println("\u001B[32mBooked Out By user by.\u001B[0m"+expectedval);
 				List<WebElement> cellVal = driver.findElements(By.xpath("//*[@class='tasks-panel__wrapper']//*[ contains(@class,'mat-row cdk-row')]"));
 				String cell1value= cellVal.get(j).getText();
 				String[] words = cell1value.split(" ");
                
 		        // Initialize variables to hold the extracted values
 		        String title = "";
 		        String description = "";
 		        String status = "";
 		        String date = "";

 		        for (int i = 0; i < words.length; i++) {
 		            if (i == 0) {
 		                title = "Title: " + words[i];
 		            } else if (words[i].equals("Please")) {
 		                description = "Description: " + "Please provide approval decision for this property";
 		            } else if (words[i].equals("Closed")) {
 		                status = "Status: " + "Closed";
 		            } else if (words[i].matches("\\d{2}/\\d{2}/\\d{4}")) {
 		                date = "Date: " + words[i];
 		            }
 		        }

 		        // Print the formatted output
 		        System.out.println(title);
 		        System.out.println(description);
 		        System.out.println(status);
 		        System.out.println(date);
 		    }
 				
 			}
 		}
 		
public void FilterByUser(String Tab,String elementID, String val) throws InterruptedException {
 	
 	expectedval=val;
 	System.out.println("\u001B[32mExpected value: .\u001B[0m"+expectedval);
 		List<WebElement> cells = driver.findElements(By.xpath("//*[contains(@class,'list__wrapper')]//*[text()=' Complete Request ']"));
 		System.out.println("\u001B[32mNumber of Row present in Table : .\u001B[0m"+cells.size());
 		for(int j=0;j<cells.size();j++)
 		{
 			Thread.sleep(7000);
 			String actualtext=cells.get(j).getText();
 			
 			System.out.println(actualtext);
 			//System.out.println("\u001B[32mActual value.\u001B[0m"+actualtext);
 			if(cells.get(j).getText().equals(expectedval))
 			{
 				System.out.println("\u001B[32mExpected value :.\u001B[0m"+expectedval+ "=="+"\u001B[32mActual Value.\u001B[0m" +actualtext);
 				//System.out.println("\u001B[32mBooked Out By user by.\u001B[0m"+expectedval);
 				List<WebElement> cellVal = driver.findElements(By.xpath("//*[contains(@class,'list__wrapper')]//*[ contains(@class,'mat-row cdk-row')]"));
 				String cell1value= cellVal.get(j).getText();
				String[] substring = cell1value.split(" ");
 				String input = cell1value;
 				 String[] words = input.split(" ");
 				 System.out.println(input);
 				// Initialize variables to hold the extracted values
 		        String title = "Title: Request";
 		        String description = "Description: ";
 		        String status = "Status: ";
 		        String createdOn = "CreatedOn: ";
 		        String dueBy = "Due By: ";
 		        String completeRequest = "";

 		        boolean completeRequestFlag = false;

 		        for (int i = 1; i < words.length - 1; i++) {
 		            if (words[i].equals("Open") || words[i].equals("Complete")) {
 		                // Extract the status part
 		                status = "Status: " + words[i];
 		            } else if (words[i].matches("\\d{2}/\\d{2}/\\d{4}")) {
 		                // Extract date parts
 		                createdOn = "CreatedOn: " + words[i];
 		                dueBy = "Due By: " + words[i];
 		                completeRequest = "Complete Request";
 		                completeRequestFlag = true;
 		            } else {
 		                // Extract the description part
 		                description += words[i] + " ";
 		            }
 		        }

 		        // Print the formatted output
 		        System.out.println(title);
 		        System.out.println(description.trim());
 		        System.out.println(status);
 		        System.out.println(createdOn);
 		        System.out.println(dueBy);
 		        if (completeRequestFlag) {
 		            System.out.println(completeRequest);
 		        }
 		    }
 		}
 			}
 		
	public void selectGroup(String option) throws InterruptedException {
	 			
		Wait.untilPageLoadComplete(driver);
		WebElement groupoption = driver.findElement(By.xpath("//*[@role='group']//*[contains(text(),'"+option+"')]"));
		 try {
				
				groupoption.click();
		 	}
		 catch(Exception e)
		 {
				util.actionMethodClick(driver, groupoption);
			}
 		
}
	public void ClickFilterDashboard() throws InterruptedException {
			
		Wait.untilPageLoadComplete(driver);
		 try {
				
			 Filteratask.click();
		 	}
		 catch(Exception e)
		 {
				util.actionMethodClick(driver, Filteratask);
			}
 		
}
	
	public void Clickshowallchkbox() throws InterruptedException {
		
		 WebElement checkbox= driver.findElement(By.xpath("(//*[@class='mat-checkbox mat-accent']//*[contains(@class,'mat-checkbox-frame')])[1]"));
	   		 Wait.elementToBeClickable(driver, checkbox, 3);
	   		 util.actionMethodClick(driver, checkbox);
 		
}   
	public void ClickAddAdress(String add,String option) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-placeholder='enter any part of an address']")).sendKeys(add,Keys.ENTER);
		 WebElement Addaddress= driver.findElement(By.xpath("//*[@class='mat-option-text']//span[contains(text(),'"+option+"')]"));
	   		 Wait.elementToBeClickable(driver, Addaddress, 3);
	   		 util.actionMethodClick(driver, Addaddress);
		
}   
	public void CalendarDateValidation() throws InterruptedException {
		 WebElement calendar = driver.findElement(By.xpath("//*[contains(@formcontrolname,'dueDate')]"));
	        calendar.click();
	        driver.findElement(By.xpath("//*[@aria-label='Choose month and year']")).click();
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
			 System.out.println("Select the Today Year");
			WebElement fromyear= driver.findElement(By.xpath("//*[starts-with(@class,'mat-calendar-body-cell-container ng-star-inserted')]//*[@aria-label='"+yearToSelect+"']"));
			Wait.elementToBeClickable(driver, fromyear, 3);
			testutil.actionMethodClick(driver, fromyear);
				Thread.sleep(2000);
				//System.out.println("Select the Today month");
				 String monthsubstring = fullMonth.substring(0,3);
				// System.out.println("Sub string  "+monthsubstring);
						//WebElement monthselected = driver.findElement(By.xpath("(//*[contains(text(),'"+monthsubstring+"')])[2]"));
				 WebElement frommonth= driver.findElement(By.xpath("//*[starts-with(@class,'mat-calendar-body-cell-container ng-star-inserted')]//*[@aria-label='"+fullMonth+" "+yearToSelect+"']"));
					Wait.elementToBeClickable(driver, frommonth, 3);
					testutil.actionMethodClick(driver, frommonth);
							
		//System.out.println("Select the Today date");
		 Wait.untilPageLoadComplete(driver,2000);	
		 WebElement CurrentDate=driver.findElement(By.xpath("//*[starts-with(@class,'mat-calendar-body-cell-container ng-star-inserted')]//*[@aria-label='"+dayToSelect+" " +fullMonth+" "+ yearToSelect+"']"));
			Wait.elementToBeClickable(driver, CurrentDate, 3);
			testutil.actionMethodClick(driver, CurrentDate);
			System.out.println("Select the Today date "+CurrentDate.getText());
			CurrentDate.click();
			
}
	 public void clickOnContractSelectionchk(String Itemcount) throws InterruptedException
	    {
	    	int item = Integer.parseInt(Itemcount);
	   	 System.out.println("Number of item to be selected is "+item);
	   	 for(int i=0;i<item;i++)
	   	 {
	   		 int a=i+1;
	   		 WebElement checkbox= driver.findElement(By.xpath("(//*[@class='table-container']//*[contains(@class,'mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin')])["+a+"]"));
	   		// System.out.println(a);
	   		// Wait.elementToBeClickable(driver, checkbox, 3);
	   		 Thread.sleep(1000);
	   	    // util.actionMethodClick(driver, checkbox);
	   		checkbox.click();
	   	 }
	    	
	    }
	 public void clickOnNext(String option,String val) throws InterruptedException
	    {
	    	try {
	    		Thread.sleep(2000);
	    		// WebElement nextbtn= driver.findElement(By.xpath("//*[@class='"+option+"']//span[normalize-space()='"+val+"']"));
	    		 Boolean flag = false;
	 			while (!flag) {
	 				List<WebElement> nextbtn = driver.findElements(By.xpath("//*[@class='"+option+"']//span[normalize-space()='"+val+"']"));
	 				for (int i = 0; i < nextbtn.size(); i++) {
	 					if (isClickable(nextbtn.get(i))) {
	 						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",nextbtn.get(i) );
	 						util.actionMethodClick(driver, nextbtn.get(i));
	 						flag = true;
	 						i = nextbtn.size();
	 						
	 			System.out.println("User select option: " +option );
	 			
	 		}
	    	}
	 			}
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	 public void clickOnchk(String Itemcount, String value) throws InterruptedException
	    {
	    	int item = Integer.parseInt(Itemcount);
	   	 System.out.println("Number of item to be selected is "+item);
	   	 for(int i=0;i<item;i++)
	   	 {
	   		 int a=i+1;
	   		 WebElement checkbox= driver.findElement(By.xpath("(//*[starts-with(@formcontrolname,'"+value+"')]//*[starts-with(@class,'mat-checkbox-inner-container')])["+a+"]"));
	   		// System.out.println(a);
	   		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",checkbox );
	   		 Wait.elementToBeClickable(driver, checkbox, 3);
	   		// util.actionMethodClick(driver, checkbox);
	   		try {
	   		 util.actionMethodClick(driver, checkbox);
	   		//checkbox.click();
	   	    	}
	   	    	catch(Exception e)
	   	    	{
	   	    		util.actionMethodClick(driver, checkbox);
	   	}
	   	 }
	    	
	    }
	 public void selectOwnerSurname(String user) throws InterruptedException
	    {
	    	try {
	    		Wait.untilPageLoadComplete(driver);
	    		System.out.println(user);
	    		WebElement ContinuebtnDisable = driver.findElement(By.xpath("(//*[contains(text(),'"+user +"')])[last()]"));
	    		util.actionMethodClick(driver, ContinuebtnDisable);
	    	}
	    	catch (Exception e)
	    	{
	    		
	    	}
}
	 public void clickchkTask() throws InterruptedException
	    {
	    	try {
	    		Wait.untilPageLoadComplete(driver);
	    		
	    		WebElement Checkboxtask= driver.findElement(By.xpath("//*[@class='tasks-panel__wrapper']//*[starts-with(@class,'mat-checkbox-inner-container')]"));
	    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Checkboxtask);
	    		util.actionMethodClick(driver, Checkboxtask);
	    	}
	    	catch (Exception e)
	    	{
	    	    e.printStackTrace();	
	    	}
	    }
	    	 public void clickActiveServiceUser(String Value) throws InterruptedException
	 	    {
	 	    
	 	    		Wait.untilPageLoadComplete(driver);
	 	    		WebElement Activebtn= driver.findElement(By.xpath("(//*[@matsortactive='staffName']//*[contains(@class,'mat-row cdk-row mears-table__data-row mears-table__data-row--hover ng-star-inserted')]//*[contains(text(),'Active')])[1]"));
	 	    		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Activebtn);
	 	    		try {
	 	    			util.actionMethodClick(driver, Activebtn);
	 	  	   	    	}
	 	  	   	    	catch(Exception e)
	 	  	   	    	{
	 	  	   	    	Activebtn.click();
	 	  	   	    	}
	 	    		}
	    	 public void ServiceUsertxt(String Value) throws InterruptedException
		 	    {
		 	    
		 	    		Wait.untilPageLoadComplete(driver);
		 	    		WebElement Serviceusertxt= driver.findElement(By.xpath("(//*[@class='mat-card-content']//*[contains(@data-placeholder,'Service User') ])[2]"));
		 	    		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Activebtn);
		 	    		try {
		 	    			util.actionMethodClick(driver, Serviceusertxt);
		 	  	   	    	}
		 	  	   	    	catch(Exception e)
		 	  	   	    	{
		 	  	   	    	Serviceusertxt.click();
		 	  	   	    	}
		 	    		}
		 	    	
	 	    	
}




    	
    	
    	

	
	

	


	
	
		


		
		
		
		 
		
		
	
	
