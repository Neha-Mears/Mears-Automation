package com.sat.StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sat.Pages.AASCHmAddPage;
import com.sat.Pages.KeysPage;
import com.sat.Pages.MCMviewAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.Assertions;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KeysStepDef {
	
	
	TestBase testbase = new TestBase();
	WebDriver driver= TestBase.getDriver();
	private KeysPage key= new KeysPage(TestBase.getDriver());
	private AASCHmAddPage aashm= new AASCHmAddPage(TestBase.getDriver());
	 Assertions assertion = new Assertions(driver);
	 private ConfigFileReader config = new ConfigFileReader();
	 private MCMviewAppLoginPage MCMviewAppLogin = new MCMviewAppLoginPage(TestBase.getDriver());

	 
	 @Then ("Validate the {string} is added shows as {string} for {string}")
	 public void valdate_key_added_shows_as_default(String Tab,String elementID,String val) throws InterruptedException {
		 
		 switch(elementID)
			{
			case "default":
				 try {
					 Thread.sleep(5000);
					 System.out.println("Validate Checkbox in keys tab");
					 aashm.ValidateKeyAsDefalt(Tab,elementID);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
					break;
			case "Notes":
				 try {
					 Thread.sleep(5000);
					 System.out.println("Validate Checkbox in keys tab");
					 MCMviewAppLogin.ValidateKeyAsNotes(Tab,elementID);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
					break;
			case "notes-panel__wrapper":
				 try {
					 Thread.sleep(5000);
					 System.out.println("Validate Checkbox in keys tab");
					 key.AddNewNotes(Tab,elementID,val);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
	 
			case "Booked Out By":
				 try {
					 Thread.sleep(5000);
					 System.out.println("Validate Checkbox in keys tab");
					 key.ValidateKeyLogBookedOutBy(Tab,elementID,val);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
					break;
			case "service-users-list__table":
				 try {
					 Thread.sleep(5000);
					 System.out.println("Validate Checkbox in keys tab");
					 key.ValidatetenancyStatus(Tab,elementID,val);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
					break;	
			case "tasks-panel__wrapper":
				 try {
					 Thread.sleep(5000);
					 System.out.println("Validate Checkbox in keys tab");
					 key.ClosedTask(Tab,elementID,val);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
					break;	
			case "list__wrapper":
				 try {
					 Thread.sleep(5000);
					 System.out.println("Validate Checkbox in keys tab");
					 key.FilterByUser(Tab,elementID,val);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
					break;	
	 }
}
	 @And ("user select the {string} group from Add Request page")
	 public void user_select_group(String Option) throws InterruptedException {
		 try {
			 Thread.sleep(1000);
			 key.selectGroup(Option);
			 System.out.println("user select : " + Option +"");
		 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
	 }
	 @And ("I click on Filter Tasks in Task Dashboard")
	 public void click_on_Filter_Task_Dashboard() throws InterruptedException {
		 try {
			 Thread.sleep(1000);
			 key.ClickFilterDashboard();
			 
		 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
	 }
	 @Then ("I select the Current Date from calender for Add Request")
	 public void select_slot() throws InterruptedException {
		 try {
			 
			Thread.sleep(1000);
			 key.CalendarDateValidation();
		 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
  }
	 
	 @Then ("user click on the Show all checkbox")
	 public void click_show_all_checkbox() throws InterruptedException {
		 try {
			 Thread.sleep(1000);
			 key.Clickshowallchkbox();
		 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
  }
	 @Then ("user search {string} and {string} for Add Property")
	 public void click_on_Add_address(String add,String option)
	 {
		 try {
			 Thread.sleep(1000);
			 key.ClickAddAdress(add,option);
		 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
	 }
	 @Then ("I click on {string} checkbox for Contract Name")
	 public void click_on_checkbox_under_Contract_Name(String number)
	 {
		 try {
			 Thread.sleep(1000);
			 key.clickOnContractSelectionchk(number);
		 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
	 }
	 @Then ("Click on {string} the {string} button in Add Property")
	 public void click_on_next_under_Add_Property(String option,String val)
	 {
		 try {
			 Thread.sleep(1000);
			 key.clickOnNext(option,val);
		 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
	 }
	  @And ("user select multiple option {string} for the {string} checkbox in Add Property")
	  public void click_on_chk_under_Add_Property(String option,String val)
		 {
			 try {
				 Thread.sleep(1000);
				 key.clickOnchk(option,val);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
	  @Then ("I select the bottom owner {string} under Owner details")
	  public void select_surname(String user)
	  {
	  try {
			 Thread.sleep(1500);
			 key.selectOwnerSurname(user);
			 System.out.println("User clicked  " +user+ "  Under Owner detail");	
			 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
}
	  @And ("I click on checkbox Include closed task under Task for this Address")
	  public void click_on_chk_under_task_for_this_address()
		 {
			 try {
				 Thread.sleep(1000);
				 key.clickchkTask();
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
	  
	  @Then ("I select the service user with {string} application")
	  public void select_active_service_user(String value)
		 {
			 try {
				 Thread.sleep(5000);
				 key.clickActiveServiceUser(value);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
	  @When ("I click on {string} under Association")
	  public void click_service_user_under_association(String value)
		 {
			 try {
				 Thread.sleep(5000);
				 key.ServiceUsertxt(value);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
	  @And ("the user chooses to update the date {string} week later")
	  public void update_calender_week_later(String week) throws InterruptedException {
			Thread.sleep(7000);
			 try {
				 key.UpdateWeekLater(week);
			 
	  }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 } 
			 }

	  @And("user click the calender for {string} for slot available {string} {string} {string}")
	  public void click_calender_under_tab(String field,String fmmonth, String fmyear,String fmdate) throws InterruptedException {
			Thread.sleep(7000);
			 try {
				 key.ClickCalenderUnderTab(field,fmmonth,fmyear,fmdate);
			 
	  }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 } 
			 }
	
		 

	
	  
	  @Then ("user validate the Save button is enabled")
	  public void IsButtonEnable() throws InterruptedException {
			Thread.sleep(7000);
			 try {
				 key.IsButtonEnabled();
			 
	  }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 } 
}
	  @Then ("user verify view application details")
	  public void user_click_view_application_and_verify_search(DataTable datatable) throws InterruptedException {
			Thread.sleep(2000);
			 try {
				 key.localsearch(datatable);
			 
	  }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 } 
}
	  @And ("I click on checkbox Include closed task under Task for this Address {string}")
	  public void click_on_chk_under_task_for_this_address(String val)
		 {
			 try {
				 Thread.sleep(1000);
				 key.clickchkTask(val);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
	  @Then ("user click on pop-up {string} button window")
	  public void click_user_pop_up(String value)
		 {
			 try {
				 Thread.sleep(3000);
				 key.popupwindowOk(value);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
	  @Then("user varify the following grids is displayed under Confirmation Tab")
			public void verify_grid_displayed(DataTable datatable) throws InterruptedException {
				Thread.sleep(8000);
				 try {
					 List<String> actual = datatable.asList();
					 System.out.println("Size of the data table " +actual.size());
					 for(int i=1;i<=actual.size()-1;i++)
					 {
						 Thread.sleep(1000);
						 String expected =driver.findElement(By.xpath("//*[starts-with(@class,'ng-star-inserted')]//*[contains(text(),'"+actual.get(i)+"')]")).getAttribute("outerText");
						 System.out.println(expected);
						 assertion.CheckAssertionTrue(expected.contains(actual.get(i)), actual.get(i));
						 
					 }
				 }
					 catch(Exception e) {
						 System.out.println("Exception :"+ e + "has occured" );
					 } 
		  }
}

