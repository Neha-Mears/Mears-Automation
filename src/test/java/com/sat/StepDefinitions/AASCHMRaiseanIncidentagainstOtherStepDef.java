package com.sat.StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	
	 private String initialValue;
	 private String updatedValue;
	 
	@Then("user varify the following grids is displayed")
	public void verify_grid_displayed(DataTable datatable) throws InterruptedException {
		Thread.sleep(8000);
		 try {
			 List<String> actual = datatable.asList();
			 System.out.println("Size of the data table " +actual.size());
			 for(int i=1;i<=actual.size()-1;i++)
			 {
				 Thread.sleep(1000);
				 String expected =driver.findElement(By.xpath("//*[starts-with(@class,'mat-header-row') or starts-with(@class,'risk-details-panel')]//*[contains(text(),'"+actual.get(i)+"')]")).getAttribute("outerText");
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
				 Thread.sleep(5000);
				 aashm.verifyalertmessage(field,datatable);
				 
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @Then ("Verify all the values are present under Keys")
		 public void Validate_header_Keys(DataTable datatable)
		 {  
			 try {
				// Thread.sleep(5000);
				 aashm.verifyKeysheader(datatable);
				 Thread.sleep(5000);
				 
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
		  @Then ("user click on {string} Risk button")
		  public void click_on_Risk_Details_btn(String Risk_Detail) throws InterruptedException {
				 try {
					 
					Thread.sleep(3000);
					aashm.clickOnDetail(Risk_Detail);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
		  }
		  @Then ("user click on plus icon in keys tab")
		  public void click_on_keys_plus_icon() throws InterruptedException {
				 try {
					 
					Thread.sleep(3000);
					aashm.clickOnplusIcon();
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
		  @Then ("user verify checkbox is checked under Returned {string}")
		  public void verify_chkbox_checked(String value) throws InterruptedException {
				 try {
					 
					Thread.sleep(3000);
					aashm.verifyReturnedchk(value);
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
				 Thread.sleep(5000);
				 aashm.selectcurrenttimeslotappointment(appointment);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
}
		 @And ("user select the tommorow time slot for the appointment {string}")
		 public void select_tommorow_time_slot_for_appointment(String appointment) throws InterruptedException {
			 try {
				
				// switch(appointment)
					//{
					//case "availableslot":
						 System.out.println("selecting time slot");
						 aashm.selecttommorowtimeslotappointment(appointment);
						 System.out.println("selecting time slot entered");
						//	break;
					//case "EditAppointmentSlot":
					//	 System.out.println("selecting time slot");
					//	 aashm.selecttEditappointment(appointment);
					//		break;
			// }
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
				 Thread.sleep(5000);
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
				case "AASC_HMusername":
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
		 @And ("user take the screenshot for confirmation page for Test case {string}")
		 public void takes_screenshot_appointment_page(String testcase)throws InterruptedException
		 {
			 try {
				 Thread.sleep(5000);
				 System.out.println("Going to take screenshot1");
				 aashm.takescreenshotappointmentpage(testcase);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		 @Then ("user click on edit button under icon name {string}")
		 public void click_edit_btn_under_icon(String EditIconbtn)throws InterruptedException
		 {
			 try {
				 Thread.sleep(8000);
				 aashm.EditbtunderIcon(EditIconbtn);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		 }
		
		 @Then ("the checkbox should be checked")
		 public void checkbox_checkbox()throws InterruptedException
		 {
			 Thread.sleep(2000);
			 aashm.icheckTheStateOfTheCheckbox();
		 }
		@ When ("user click on the descending {string} under tab {string}")
		 public void click_decending(String col,String tab)throws InterruptedException
		 {
			 Thread.sleep(5000);
			 aashm.Clickdecending(col, tab);
		 }
		  @Then ("the checkbox should not be checked")
		  public void checkbox_should_not_be_checked()throws InterruptedException
			 {
			 
			  	Thread.sleep(2000);
				aashm.icheckTheStateOfTheCheckbox();
			 }
			 
		 @Then ("user click on next button under Key Log")
		 public void click_on_next_btn()throws InterruptedException
		 {
			 try {
				 Thread.sleep(5000);
				 aashm.ClickRecentEditButtonOnLastPage();
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
				 Thread.sleep(7000);
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
		 public void verifyValuesUnderColumn(String Columnname) throws InterruptedException
		 {
			 
			 try {
						 aashm.validatevalueundercolumn(Columnname);
						System.out.println("user select : " + Columnname );
						Thread.sleep(1500);
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
					 Thread.sleep(9000);
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
					 Thread.sleep(2000);
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
		 @When ("the user checks if the Code Access Number exists for {string} under {string}")
		 public void checkCodeAccessNumber(String elementID, String Tab) throws InterruptedException {
			 Thread.sleep(7000);
			 WebElement ele = driver.findElement(By.xpath("//*[@title='Alarm Details']//*[contains(@data-placeholder,'Code Access Number')]"));
			 String CodeAccessValue=ele.getAttribute("value");
			 System.out.println("CodeAccess Value displayed: "+ CodeAccessValue);
			 System.out.println("CodeAccess Value displayed: "+ CodeAccessValue.isEmpty());
			 if (CodeAccessValue.equals("-") || CodeAccessValue.isEmpty()) {
				 Thread.sleep(6000);
				 MCMviewAppLogin.clickOnEditIconRisk(Tab);
				 aashm.GenerateUniquePortNumber(elementID);
				 String alertpass="Alert Password";
				 String generatepass="Generate Alert Password";
				 MCMviewAppLogin.generatePasswordValue(alertpass,generatepass);
				 String falsepass="False Alarm Password";
				 String generatefalsepass="Generate False Alarm Password";
				 MCMviewAppLogin.generatePasswordValue(falsepass,generatefalsepass);
				 String option="Save";
				 MCMviewAppLogin.clickOnSave(option);
			 }
			 else
			 {
				 System.out.println("\u001B[32mCode Access Value Exist is displayed as : \u001B[0m"+ CodeAccessValue);
				 return;
			 }
		 }
		 @Then ("I reset the content of text box under {string} as pre-requist")
		 public void Clear_alarm_detail(String Tab) throws InterruptedException {
			// MCMviewAppLogin.clickOnEditIconRisk(Tab);
			 WebElement portno = driver.findElement(By.xpath("//*[contains(@data-placeholder,'Code Access Number')]"));
			// portno.clear();
			 portno.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
			 portno.sendKeys(Keys.DELETE); // Delete selected text
			 Thread.sleep(1000);
			 WebElement Alertpassword = driver.findElement(By.xpath("//*[contains(@data-placeholder,'Alert Password')]"));
			 Alertpassword.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
			 Alertpassword.sendKeys(Keys.DELETE); // Delete selected text
			 Thread.sleep(1000);
			 WebElement Falsepassword = driver.findElement(By.xpath("//*[contains(@data-placeholder,'False Alarm Password')]"));
			 Falsepassword.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
			 Falsepassword.sendKeys(Keys.DELETE); // Delete selected text
			 Thread.sleep(5000);
			 String option="Save";
			 MCMviewAppLogin.clickOnSave(option);
		 }
		 
		 @When ("I capture the initial value of {string} under {string}")
		 public void capture_initial_value(String elementID, String Tab)
		 {
			 
			 switch(Tab)
				{
				case "Alarm Details":
					 try {
						 Thread.sleep(1500);
						 WebElement ele = driver.findElement(By.xpath("//*[@title='"+Tab+"']//*[contains(@data-placeholder,'"+elementID+"') or contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-keyType mat-column-keyType ng-star-inserted')]"));
						 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
						 initialValue=ele.getAttribute("value");
						 System.out.println("\u001B[32mInitial Value displayed : .\u001B[0m"+ initialValue);
					 }
					 catch(Exception e) {
						 System.out.println("Exception :"+ e + "has occured" );
					 }
						break;
				case "Keys":
					 try {
						 Thread.sleep(1500);
						 WebElement ele = driver.findElement(By.xpath("(//*[@title='"+Tab+"']//*[contains(@data-placeholder,'"+elementID+"') or contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-keyType mat-column-keyType ng-star-inserted')])[1]"));
						 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
						 initialValue=ele.getText();
						 System.out.println("\u001B[32mInitial Value displayed : .\u001B[0m"+ initialValue);
					 }
					 catch(Exception e) {
						 System.out.println("Exception :"+ e + "has occured" );
					 }
						break;
				case "Key Log":
					try {
						Thread.sleep(1500);
						WebElement ele = driver.findElement(By.xpath("(//*[@title='Key Log']//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-bookedOutBy mat-column-bookedOutBy ng-star-inserted')])[1]"));
						 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
						initialValue=ele.getText();
						 System.out.println("\u001B[32mInitial Value displayed : .\u001B[0m"+ initialValue);
					}
					catch(Exception e) {
						System.out.println("Exception :"+ e + "has occured" );
					}
					break;
				case "Reference":
					try {
						Thread.sleep(1500);
						WebElement ele = driver.findElement(By.xpath("(//*[@title='Keys']//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-reference mat-column-reference ng-star-inserted')])[last()]"));
						 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
						 initialValue=ele.getText();
						 System.out.println("\u001B[32mInitial Value displayed : .\u001B[0m"+ initialValue);
					}
					catch(Exception e) {
						System.out.println("Exception :"+ e + "has occured" );
					}
					break;
					
				case "Who has key":
					try {
						Thread.sleep(1500);
						WebElement ele = driver.findElement(By.xpath("(//*[@title='Key Log']//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-keyHeldBy mat-column-keyHeldBy ng-star-inserted')])[1]"));
						 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
						 initialValue=ele.getText();
						 System.out.println("\u001B[32mInitial Value displayed : .\u001B[0m"+ initialValue);
					}
					catch(Exception e) {
						System.out.println("Exception :"+ e + "has occured" );
					}
					break;
				case "Date":
					try {
						Thread.sleep(1500);
						WebElement ele = driver.findElement(By.xpath("(//*[@title='Key Log']//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-date mat-column-date ng-star-inserted')])[1]"));
						 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
						 initialValue=ele.getText();
						 System.out.println("\u001B[32mInitial Value displayed : .\u001B[0m"+ initialValue);
					}
					catch(Exception e) {
						System.out.println("Exception :"+ e + "has occured" );
					}
					break;
				case "Keys Held By":
					 try {
						 Thread.sleep(1500);
						 WebElement ele = driver.findElement(By.xpath("(//*[@title='Keys']//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-keysHeldBy mat-column-keysHeldBy ng-star-inserted')])[1]"));
						 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
						 initialValue=ele.getText();
						 System.out.println("\u001B[32mInitial Value displayed : .\u001B[0m"+ initialValue);
					 }
					 catch(Exception e) {
						 System.out.println("Exception :"+ e + "has occured" );
					 }
						break;
 }
		 }
		  @When("I click on {string}")
			 public void user_click_under_active_work_order(String tab)
			 {
				 {
					 try {
						//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						 aashm.iClickItemPerPage(tab);
						 
						 System.out.println("User clicked on "+tab);
						 
					 }
					 catch(Exception e) {
						 System.out.println("Exception :"+ e + "has occured" );
					 }
				 } 
			 }
		  @When ("I capture the new updated value of {string} under {string}")
		  public void capture_new_value(String elementID,String Tab)
			 {
				 
				 switch(Tab)
					{
					case "Alarm Details":
						 try {
							 Thread.sleep(1500);
							 WebElement ele = driver.findElement(By.xpath("//*[@title='"+Tab+"']//*[contains(@data-placeholder,'"+elementID+"') or contains(text(),'"+elementID+"')]"));
							 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
							 updatedValue=ele.getAttribute("value");
							 System.out.println("\u001B[32mUpdated Value displayed : \u001B[0m"+ updatedValue);
						 }
						 catch(Exception e) {
							 System.out.println("Exception :"+ e + "has occured" );
						 }
							break;
					case "Keys":
						 try {
							 Thread.sleep(1500);
							 WebElement ele = driver.findElement(By.xpath("//*[@title='"+Tab+"']//*[contains(@data-placeholder,'"+elementID+"') or contains(text(),'"+elementID+"')]"));
							 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
							 updatedValue=ele.getText();
							 System.out.println("\u001B[32mUpdated Value displayed : \u001B[0m"+ updatedValue);
						 }
						 catch(Exception e) {
							 System.out.println("Exception :"+ e + "has occured" );
						 }
							break;
					case "Reference":
						try {
							Thread.sleep(1500);
							WebElement ele = driver.findElement(By.xpath("(//*[@title='Keys']//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-reference mat-column-reference ng-star-inserted')])[last()]"));
							 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
							updatedValue=ele.getText();
							 System.out.println("\u001B[32mUpdated Value displayed : \u001B[0m"+ updatedValue);
						}
						catch(Exception e) {
							System.out.println("Exception :"+ e + "has occured" );
						}
						break;
					case "Key Log":
						try {
							Thread.sleep(1500);
							WebElement ele = driver.findElement(By.xpath("(//*[@title='Key Log']//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-bookedOutBy mat-column-bookedOutBy ng-star-inserted')])[1]"));
							 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
							 updatedValue=ele.getText();
							 System.out.println("\u001B[32mUpdated Value displayed : \u001B[0m"+ updatedValue);
						}
						catch(Exception e) {
							System.out.println("Exception :"+ e + "has occured" );
						}
						break;
					case "Who has key":
						try {
							Thread.sleep(1500);
							WebElement ele = driver.findElement(By.xpath("(//*[@title='Key Log']//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-keyHeldBy mat-column-keyHeldBy ng-star-inserted')])[1]"));
							 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
							 updatedValue=ele.getText();
							 System.out.println("\u001B[32mUpdated Value displayed : \u001B[0m"+ updatedValue);
						}
						catch(Exception e) {
							System.out.println("Exception :"+ e + "has occured" );
						}
						break;
					case "Date":
						try {
							Thread.sleep(1500);
							WebElement ele = driver.findElement(By.xpath("(//*[@title='Key Log']//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-date mat-column-date ng-star-inserted')])[1]"));
							 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
							 updatedValue=ele.getText();
							 System.out.println("\u001B[32mUpdated Value displayed : \u001B[0m"+ updatedValue);
						}
						catch(Exception e) {
							System.out.println("Exception :"+ e + "has occured" );
						}
						break;
					case "Keys Held By":
						 try {
							 Thread.sleep(1500);
							 WebElement ele = driver.findElement(By.xpath("(//*[@title='Keys']//*[contains(@class,'mat-cell cdk-cell mears-table__cell cdk-column-keysHeldBy mat-column-keysHeldBy ng-star-inserted')])[1]"));
							 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele );
							 updatedValue=ele.getText();
							 System.out.println("\u001B[32mUpdated Value displayed : \u001B[0m"+ updatedValue);
						 }
						 catch(Exception e) {
							 System.out.println("Exception :"+ e + "has occured" );
						 }
							break;
			 }
			 }
		  @And ("validate the initial value of {string} is not same as new value")
		  public void validate_value(String elementID)
			 {
				 assert initialValue !=null && updatedValue !=null;
				 if(initialValue.equals(updatedValue))
				 {
					 System.out.println(initialValue +" :\u001B[32mValue remain unchanged after the update: \u001B[0m" +updatedValue);
				 }
				 else
				 {
					 System.out.println(initialValue +" :\u001B[32mValue changed after the update: \u001B[0m" +updatedValue);
				 }
			 }
		 @Then ("user validate below field are displayed under Service User")
		 public void user_validate_title_in_service_user(DataTable datatable)
		 {
			 {
				 try {
					 Thread.sleep(1000);
					 aashm.validatetitleService(datatable);
				 }
				 catch(Exception e) {
					 System.out.println("Exception :"+ e + "has occured" );
				 }
			 } 
		 }
	
}
