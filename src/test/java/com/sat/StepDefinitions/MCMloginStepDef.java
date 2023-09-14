package com.sat.StepDefinitions;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;


import com.sat.Pages.MCMviewAppLoginPage;

import com.sat.config.ConfigFileReader;
import com.sat.testbase.Assertions;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MCMloginStepDef {
	public WebDriver driver;
	private MCMviewAppLoginPage MCMviewAppLogin = new MCMviewAppLoginPage(TestBase.getDriver());
	 Assertions assertion = new Assertions(driver);
private ConfigFileReader config = new ConfigFileReader();
	
@Given("user login to Home Mears Page")
public void user_Naviagte_to_MearsHomePage_App() throws InterruptedException {
	TestBase.getDriver().get(config.getMearsHomeUrl());
	
	MCMviewAppLogin.HomeUserName(config.MearsUserName());
	 MCMviewAppLogin.HomePassword(config.MearsHomePassword());
}
	@Given ("User Navigate to MCMView App")
	public void user_Naviagte_to_MCMView_App() throws InterruptedException {
		//MCMviewAppLogin.switchTab();
		TestBase.getDriver().get(config.getMCMApplicationUrl());
	}
	
 @And("user enter valid MCMview {string} and {string}")
 public void enter_valid_MCMview_username_and_password_(String username,String password)
 {
	 MCMviewAppLogin.EnterUserName(config.MCMUserName());
	 MCMviewAppLogin.EnterPassword(config.MCMUserPassword());
 }
 
	
	@And("user enter valid credential {string} and {string}")
	public void user_login_with_valid_username_and_password_(String username,String password)
	 {
		//MCMviewAppLogin.EnterUserName(config.getUserName(username));
		// MCMviewAppLogin.EnterPassword(config.getuserPassword(password));
		 System.out.println("username and password");
		MCMviewAppLogin.User_login_MCMview(config.getUserName(username),config.getuserPassword(password));
	 }
	
 @And("click on LogIn")
 public void Click_on_Login()  throws InterruptedException {
	 MCMviewAppLogin.ClickOnLogIn();
 }
 @Then ("select navapp {string}")
 public void select_navapp(String navelement)
 {
	 MCMviewAppLogin.click_navapp(navelement);
 }
 @And ("user select {string} from drop down List and navigate to {string}")
 public void user_select_from_drop_down_list(String Option,String value ) throws InterruptedException {
	 try {
		 Thread.sleep(1000);
		 MCMviewAppLogin.ClickAllService(Option,value);
		 System.out.println("user select : " + Option +"and navigate to " +value );
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @When ("user search {string} and click on the address details")
 public void click_on_address_details(String addname)
 {
	 try {
		 Thread.sleep(1000);
		 MCMviewAppLogin.ClickAddressname(addname);
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @Then("Scroll down and click on expansion panel header button for {string}")
	public void click_expansion(String option )
	{
	 
	 try {
		 Thread.sleep(5000);
		// MCMviewAppLogin.scrolldown();
		 switch(option)
			{
			case "MCMViewHMUsername":
				    Thread.sleep(1000);
				    MCMviewAppLogin.click_expansionpanel();
				    break;
			case "RLAPMearsuser":
			    Thread.sleep(1000);
			    MCMviewAppLogin.click_expansionpanel();
			    break;
			case "AASC_HMexpansion":
			    Thread.sleep(1000);
			    MCMviewAppLogin.click_ServiceUser_expansionpanel();
			    break;
			case "Living_HO_username":
			    Thread.sleep(1000);
			    MCMviewAppLogin.click_threedotTenancy();
			    break;
			case "AASC_HMusername":
			    Thread.sleep(1000);
			    MCMviewAppLogin.click_threedotTenancy();
			    break;
			    
	 }
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 
 @Then ("Click on {string} expansion button")
 public void click_on_risk_assesment_btn(String option)
 {
	 try {
		 Thread.sleep(2000);
		 switch(option)
			{
			case "Risk Assessments":
				    Thread.sleep(1000);
					MCMviewAppLogin.click_Riskassesmentexpansionbtn();
					System.out.println("user select : " + option );
					break;
			case "Service user":
				 	Thread.sleep(1000);
					MCMviewAppLogin.service_userexpansionbtn();
					System.out.println("user select : " + option );
					break;
			case "Notes":
				 Thread.sleep(1000);
				MCMviewAppLogin.Notesxpansionbtn();
				System.out.println("user select : " + option );
				break;
			case "Incidents":
				 Thread.sleep(1000);
				MCMviewAppLogin.Incidentexpansionbtn();
				System.out.println("user select : " + option );
				break;
			case "Complaints":
				 Thread.sleep(1000);
				MCMviewAppLogin.Incidentexpansionbtn();
				System.out.println("user select : " + option );
				break;
			case "Tenancy Details":
				 Thread.sleep(1000);
				MCMviewAppLogin.click_expansionpaneltenancy();
				System.out.println("user select : " + option );
				break;
		 }
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @Then ("verify all tabs appearing on the Add risk Assessment popup page")
 public void Validate_risk_ass_popup_page(DataTable datatable)
 {
	 MCMviewAppLogin.validate_risk_ass_popuppage(datatable);
 }
 @Then ("varify all the values are prsent under Risk Assessment")
 public void Validate_risk_assessment_page(DataTable datatable)
 {  
	 try {
		 Thread.sleep(2000);
		 MCMviewAppLogin.Validate_risk_assessment_page(datatable);
		 
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
	 
 }
 @Then ("Click on {string} risk expansion button")
 public void click_risk_expensionbtn(String str)
 {
	 try {
		 Thread.sleep(2000);
		 MCMviewAppLogin.click_Riskexpansionbtn();
		 System.out.println("user select : " + str );
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @Then ("user fill details for {string} as {string}")
 public void fill_details_for(String field, String value)throws InterruptedException
 {
	// Thread.sleep(3000);
	 System.out.println("Field : " + field );
		System.out.println("Value : " + field );
	 MCMviewAppLogin.selectAddNewRisk(field,value);
 }
 @Then ("user validate the Alert message {string} and {string} for Add New Risk form")
 public void user_validate_the_Alert_message(String msg1,String msg2) throws InterruptedException
 {
	 MCMviewAppLogin.validate_message_in_textbox(msg1,msg2) ;
 }
 @Then ("user click on save button")
 public void user_click_on_save_button()throws InterruptedException
 {
	 try {
		 Thread.sleep(1000);
		 MCMviewAppLogin.clickOnSave();
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @Then ("user click on Cancel button")
 public void user_click_on_Cancel_button()throws InterruptedException
 {
	 try {
		 Thread.sleep(1000);
		 MCMviewAppLogin.clickOnCancel();
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 
 @Then ("user click on Close button {string}")
 public void user_click_on_Close_button(String expstr)throws InterruptedException
 {
	 try {
		 Thread.sleep(1000);
		 MCMviewAppLogin.clickOnClose(expstr);
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @Then ("user delete {string} content and verify save button is enable")
 public void user_delete_content_savebtl_enable(String value)throws InterruptedException
 {
	 try {
		 Thread.sleep(1000);
		 MCMviewAppLogin.deleteContentverifySavebtnEnable(value);
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @Then ("user click on the edit icon under Risk")
 public void user_click_on_Edit_Icon_button()throws InterruptedException
 {
	 try {
		 Thread.sleep(3000);
		 MCMviewAppLogin.clickOnEditIconRisk();
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @Then ("user click the calender and select the slot {string} {string} {string}")
 public void select_slot_date(String setMonth,String setYear, String setDate) {
	 MCMviewAppLogin.selectSlotDate(setMonth,setYear,setDate);
 }
 @Then ("user able to see {string} toaster")
 public void verify_toaster_message(String success_msg)
 {
	 MCMviewAppLogin.velidateMsgPop(success_msg);
 }
 @Then ("user verify the field are displayed in Risk Details page")
 public void verify_field_displayed_in_Risk_Details_Page(DataTable data) throws InterruptedException
 {
	 try {
		 List<String> actual = data.asList();
		 SoftAssert softAssert= new SoftAssert();
		//Boolean isFilterFieldDisplayed= MCMviewAppLogin.isFilterFieldDisplayed();
		 Map<String, Boolean> map=MCMviewAppLogin.isDataFieldDisplayed(data);
		// assertion.CheckAssertionTrue(isFilterFieldDisplayed, "");
		 for ( int i=0;i<=actual.size()-1;i++)
		 {
			 System.out.println(actual.get(i)+ "=" + map.get(actual.get(i)));
			 assertion.CheckAssertionTrue(map.get(actual.get(i)), "");
			 softAssert.assertAll();
		 }
	 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 } 
 }
		 
	 @Then("user click on three dots in service user")
	 public void user_click_on_threedots_service_user()throws InterruptedException
	 {
		 try {
			 Thread.sleep(2500);
			 MCMviewAppLogin.clickServiceUserthreedots();
		 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
	 }
	 @And ("user click on {string} the Drop Down List")
	 public void user_click_on_drop_down_List(String dropname)
	 {
		 try {
			 Thread.sleep(1500);
			 MCMviewAppLogin.clickDropDownList(dropname);
			 System.out.println("user clicked on drop down" );
		 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
	 }
	 @And ("select the appointment screen is displaying")
	 public void user_select_the_appointment_sreen()
	 {
		 try {
			 Thread.sleep(1500);
			 MCMviewAppLogin.clickappointmentscreen();
			 System.out.println("user clicked on drop down" );
		 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
	 }
	 @And ("user select {string} from dropdown")
		 public void user_select_from_drop_down_List(String option)
		 {
		
			 try {
				 Thread.sleep(1500);
				 MCMviewAppLogin.clickonOptionDropDown(option);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
			 }
		
	 }
	 @Then ("user click on to upload file to Add Document {string}")
	 public void user_click_to_upload_file(String dowmloadfile) throws InterruptedException, AWTException
	 {
		 try {
		
				    Thread.sleep(1500);
					MCMviewAppLogin.clicktoUploadFile(dowmloadfile);
		 }catch(org.openqa.selenium.NoSuchElementException e)
		 {
			 System.out.println("Picture uploaded not found move to next stem in cucumber");
			 return;
		 }
	 }
	 @Then ("User click on check Box for {string}")
	 public void user_click_on_check_box(String str) throws InterruptedException
	 {
		 try {
		
				    Thread.sleep(1500);
					MCMviewAppLogin.clickOnCheckBox(str);
		 }catch(org.openqa.selenium.NoSuchElementException e)
		 {
			 System.out.println("Checkbox element not found move to next stem in cucumber");
			 return;
		 }
			 /*
					try {
						Thread.sleep(1500);
						MCMviewAppLogin.clickOnCheckBox(str);
			 }
			 catch(Exception e) {
				 System.out.println("Exception :"+ e + "has occured" );
				 
			 }
			 */
		 } 
		 
		
	 }
	
 
 

