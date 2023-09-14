package com.sat.StepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sat.Pages.AASCHmAddPage;
import com.sat.Pages.MCMviewAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.Assertions;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AASCHMRaiseanIncidentagainstOtherStepDef {
	
	
	TestBase testbase = new TestBase();
	WebDriver driver= TestBase.getDriver();
	private MCMviewAppLoginPage MCMviewAppLogin = new MCMviewAppLoginPage(TestBase.getDriver());
	private AASCHmAddPage aashm= new AASCHmAddPage(TestBase.getDriver());
	 Assertions assertion = new Assertions(driver);
	 private ConfigFileReader config = new ConfigFileReader();
	
	@Then("user varify the following grids is displayed")
	public void verify_grid_displayed(DataTable datatable) throws InterruptedException {
		 try {
			 List<String> actual = datatable.asList();
			 System.out.println("Size of the data table" +actual.size());
			 for(int i=0;i<=actual.size()-1;i++)
			 {
				 Thread.sleep(1000);
				 String expected =driver.findElement(By.xpath("//*[starts-with(@class,'mat-header-row')]//*[contains(text(),'"+actual.get(i)+"')]")).getAttribute("outerText");
				 System.out.println(expected);
				 assertion.CheckAssertionTrue(expected.contains(actual.get(i)), actual.get(i));
				 
			 }
			 
		 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
	}
		 @Then ("user varify the following grids is displayed in Add Incident")
		 public void verify_grid_displayed_Add_Incident(DataTable datatable) throws InterruptedException {
			 try {
				 List<String> actual = datatable.asList();
				 System.out.println("Size of the data table" +actual.size());
				 for(int i=0;i<=actual.size()-1;i++)
				 {
					 Thread.sleep(1000);
					 String expected =driver.findElement(By.xpath("//*[starts-with(@class,'mat-card mat-focus-indicator')]//*[contains(text(),'"+actual.get(i)+"')]")).getAttribute("outerText");
					 System.out.println(expected);
					 assertion.CheckAssertionTrue(expected.contains(actual.get(i)), actual.get(i));
				 }
				 
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
	
	}
		 @Then ("user validate the Alert message for {string}")
		 public void verify_aleartmsg_Add_Incident(String field,DataTable datatable) throws InterruptedException {
			 try {
				 Thread.sleep(3000);
				 aashm.verifyalertmessage(field,datatable);
				 
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }

		  @Then ("user click the calender and select the slot available {string} {string} {string}")
		  public void select_slot(String fmdate ,String fmmonth,String fmyear) throws InterruptedException {
				 try {
					 
					Thread.sleep(3000);
					aashm.selectFromDateAndToDate(fmdate,fmmonth,fmyear);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
		  }
		  @Then ("user click the  calender and select DOB for {string} {string} {string}")
		  public void select_DOB(String fmmonth,String fmyear ,String fmdate) throws InterruptedException {
				 try {
					 
					Thread.sleep(3000);
					aashm.selectDOBInServiceUserDetails(fmmonth,fmyear,fmdate);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
		  }
		  @Then ("user click on cancel button")
		  public void click_on_cancel_btn() throws InterruptedException {
				 try {
					 
					Thread.sleep(3000);
					aashm.clickOnCancel();
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
		  }
		  @Then ("user click on {string} section")
		  public void select_section_under_service_user(String sectionval) throws InterruptedException {
				 try {
					 
					Thread.sleep(3000);
					aashm.clickOnServiceSection(sectionval);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
		  }
		  @And ("user select multiple option {string} for the {string} checkbox")
		  public void select_Dietry_chkbox(String itemcount, String value) throws InterruptedException {
				 try {
					 
					Thread.sleep(3000);
					aashm.clickOnDietchk(itemcount,value);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
		  }
		  @Then ("user varify the following grids and information appears")
		  public void verify_under_grid_data_displayed(DataTable datatable) throws InterruptedException {
				 try {
					 List<String> actual = datatable.asList();
					 System.out.println("Size of the data table" +actual.size());
					 for(int i=1;i<=actual.size();i++)
					 {
						 Thread.sleep(1000);
						 String expdata = driver.findElement(By.xpath("(//*[starts-with(@class,'mat-cell cdk-cell mears-table__cel')])["+i+"]")).getAttribute("innerText");
						 System.out.println(expdata);
					 }
					 
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
			}
		  
		 @Then ("user select the today date for appointment")
		 public void current_date_selection() throws InterruptedException {
			 try {
				 Thread.sleep(5000);
				 aashm.selectcurrentdateforappointment();
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
			 
}
		 @Then ("user select the today date for appointment for day")
		 public void current_date_selection_day() throws InterruptedException {
			 try {
				 Thread.sleep(5000);
				 aashm.selectcurrentdateforappointmentday();
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
			 
}
		 @Then("user select the today date for appointment for tommorow")
		 public void current_date_selection_for_tommorow() throws InterruptedException {
			 try {
				 Thread.sleep(2000);
				 aashm.selectcurrentdatefortommorowappointment();
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @And ("user select the time slot for the appointment {string}")
		 public void select_current_time_slot_for_appointment(String appointment) throws InterruptedException {
			 try {
				 aashm.selectcurrenttimeslotappointment(appointment);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
}
		 @And ("user select the tommorow time slot for the appointment {string}")
		 public void select_tommorow_time_slot_for_appointment(String appointment) throws InterruptedException {
			 try {
				 System.out.println("selecting time slot");
				 aashm.selecttommorowtimeslotappointment(appointment);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
}
		 
		 @And ("user click on {string} the Drop Down List for appointment")
		 public void select_list_for_appointment(String appointment) throws InterruptedException {
			 try {
				 Thread.sleep(1500);
				 aashm.selectlistapppointment(appointment);
			 }
			 catch(org.openqa.selenium.NoSuchElementException e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 return;
			 }

		 }
		 @And ("user select {string} from dropdown for appointment")
		 public void select_list_value_for_trade(String value) throws InterruptedException {
			 try {
				 aashm.selectlistvalueapppointment(value);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @And ("user select {string} from dropdown for trade value")
		 public void select_list_value_for_appointment(String value) throws InterruptedException {
			 try {
				 aashm.selectlistvaluefortrade(value);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }

		 @Then ("Click on the next button")
		 public void user_click_on_next_button()throws InterruptedException
		 {
			 try {
				 Thread.sleep(1500);
				 aashm.clickOnNext();
			 }
			 catch(org.openqa.selenium.NoSuchElementException e)
			 {
				 System.out.println("Element not found move to next stem in cucumber");
				 return;
			 }
		 }
		 @Then ("Click on ok pop up window to confirm {string}")
		 public void user_click_on_cancle_or_Ok_button(String option)throws InterruptedException
		 {
			 
			 switch(option)
				{
				case "MCMViewHMUsername":
						Thread.sleep(1000);
						aashm.clickOnCalcelbtnAndOkbtnappointment();
						System.out.println("user select : " + option );
						Thread.sleep(1500);
						// aashm.clickOnNext();
						break;
				case "RLAPMearsuser":
						Thread.sleep(1000);
						aashm.clickOnCalcelbtnAndOkbtnappointment();
						System.out.println("user select : " + option );
						Thread.sleep(1500);
						// aashm.clickOnNext();
						break;
				case "Living_HO_username":
					
					 System.out.println("Element not found move to next stem in cucumber");
					 return;
				
				}
					 } 
		 @And ("user take the screenshot for confirmation page")
		 public void takes_screenshot_appointment_page()throws InterruptedException
		 {
			 try {
				 //Thread.sleep(1000);
				 System.out.println("Going to take screenshot1");
				 aashm.takescreenshotappointmentpage();
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @And ("click on the Submit button")
		 public void user_click_on_submit_button()throws InterruptedException
		 {
			 try {
				// Thread.sleep(1500);
				 aashm.submitbtnappointmentpage();
				// Thread.sleep(1500);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @Then ("user validate the popup {string} and popup {string}")
		 public void user_validate_popmsg_and_text(String poptext, String popcomment)throws InterruptedException
		 {
			 try {
				 Thread.sleep(5000);
				 aashm.clickOnOkNewAppointment(poptext,popcomment);
			 
		 }catch(org.openqa.selenium.NoSuchElementException e)
		 {
			 System.out.println("Checkbox element not found move to next stem in cucumber");
			 return;
		 }
		 }
		 @And ("user click on Ok appointment page")
		 public void user_click_OK_appointment_page()throws InterruptedException
		 {
			 try {
				 Thread.sleep(1000);
				 aashm.okbtnappointmentpage();
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @Then ("user {string} field in the {string} section")
		 public void user_click_Staff_member_under_Complaint_Made_Against(String field, String under)throws InterruptedException
		 {
			 try {
				 Thread.sleep(1500);
				 aashm.clickstaffMember(field,under);
				 System.out.println("User clicked  " +field+ "  Under  "+ under);	
				 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @Then ("user enter the {string} in {string} text box")
		 public void user_enter_value_in_text_box(String value,String txtfield)
		 {
			 aashm.enterValue(value,txtfield);
		 }
		
		 @Then ("user click on Find")
		 public void click_on_Find()
		 {
			 try {
				 Thread.sleep(1500);
				 aashm.clickFind();
				 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }

		 @Then ("user Select the service user {string} from the list")
		 public void user_select_service_user(String val) throws InterruptedException
		 {
			 aashm.selectserviceuser(val);
		 }
		 @Then ("user validate the Continue button is disabled")
		 public void user_validate_continue_btn_disabled() throws InterruptedException
		 {
			 aashm.Continuebtndisabled();
		 }
		 @Then ("user Select the {string} whom the complaint is against and click {string} button")
		 public void select_the_user_complaint_against_and_click_Continue(String user,String btnname) throws InterruptedException
		 {
			
			 try {
				 Thread.sleep(1500);
				 aashm.Clickonuserclickcontinue(user,btnname);
				 System.out.println("User clicked  " +user+ "  Under  "+ btnname);	
				 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @Then ("user click on the pencil icon")
		 public void user_click_pencil_icon() throws InterruptedException
		 {
			
			 try {
				 Thread.sleep(1500);
				 aashm.clickOnPencilIcon();
				 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @Then ("user validate the fields {string} and {string}")
		 public void validate_fields_disabled(String ComplaintMadeBystr,String ComplaintMadeAgainststr ) throws InterruptedException
		 {
			
			 try {
				 Thread.sleep(1500);
				 aashm.validateComplaintsfieldDisabled(ComplaintMadeBystr,ComplaintMadeAgainststr);
				 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @When ("I verify values under the {string} column")
		 public void iverifyValuesUnderColumn(String Columnname)
		 {
			 try {
				 Thread.sleep(5000);
				 aashm.validatevalueundercolumn(Columnname);
				 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @Then ("I should see the value {string}")
		 public void iverifyValuesUnderrow(String rowname)
		 {
			 try {
				 Thread.sleep(1500);
				 aashm.validatevalueunderrow(rowname);
				 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @Then ("user click on the same client classification slot {string}")
		 public void User_Click_Same_Client_Classification_Slot(String slot)
		 {
			 try {
				 Thread.sleep(1500);
				 aashm.ClickSameClientClassificationSlot(slot);
				 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 } 
		 @Then ("user click on the {string} to view daily appointment")
		 public void user_click_on_view_daily_appointment(String field)
		 {
			 try {
				 Thread.sleep(1500);
				 aashm.clickOnDailyview(field);
				 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 } 
		 @Then ("Click on {string} calender icon")
		 public void click_on_calender(String field)
		 {
			 {
				 try {
					 Thread.sleep(1500);
					 aashm.ClickOnCalenderEditAppointment(field);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
			 } 
		 }
		 @Then ("click on the {string} button")
		 public void click_on_Set_button(String value)
		 {
			 {
				 try {
					 Thread.sleep(1500);
					 aashm.clickOnSet(value);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
			 } 
		 }
		 @Then ("Appointment start at {string}")
		 public void Appointment_start(String time)
		 {
			 {
				 try {
					 Thread.sleep(1500);
					 aashm.EnterStartTime(time);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
			 } 
		 }
		 @Then ("Appointment end at {string}")
		 public void Appointment_end(String time)
		 {
			 {
				 try {
					 Thread.sleep(1500);
					 aashm.EnterEndTime(time);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
			 } 
		 }
		 @And ("user click on the Drop Down List")
		 public void click_on_dropdown()
		 {
			 {
				 try {
					 Thread.sleep(1500);
					 aashm.clickOndropdown();
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
			 } 
		 }
		 @Then ("user generate the unique number for {string}")
		 public void generate_port_reference(String field)
		 {
			 {
				 try {
					 Thread.sleep(1500);
					 aashm.GenerateUniquePortNumber(field);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
			 } 
		 }
}
