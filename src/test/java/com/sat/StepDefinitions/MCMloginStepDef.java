package com.sat.StepDefinitions;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.junit.Assume;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;


import com.sat.Pages.MCMviewAppLoginPage;

import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Wait;
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
 @And ("I click on Mear Logo home Page")
 public void Click_on_Mears_Logo()  throws InterruptedException {
	 MCMviewAppLogin.ClickOnMearLogo();
 }
 @And ("Click on the Menu expansion button in Home page")
 public void Click_on_Menu_expansion_btn()  throws InterruptedException {
	 Thread.sleep(3000);
	 MCMviewAppLogin.MainMenuExpansionbtn();
 }
 @Then ("select navapp {string}")
 public void select_navapp(String navelement)
 {
	 MCMviewAppLogin.click_navapp(navelement);
 }
 @Then ("user validate red triangle warning on Tenancy detail")
 public void validate_redtriangle() throws InterruptedException
 {
	 Thread.sleep(3000);
	 MCMviewAppLogin.validateRedTriangle();
 }
 @And ("user select {string} from drop down List and navigate to {string}")
 public void user_select_from_drop_down_list(String Option,String value ) throws InterruptedException {
	 try {
		 Thread.sleep(7000);
		 MCMviewAppLogin.ClickAllService(Option,value);
		 System.out.println("user select : " + Option +"and navigate to " +value );
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @And ("user select the site for {string}")
 public void user_select_site_drop_down_list(String value ) throws InterruptedException {
	 try {
		 MCMviewAppLogin.Clickthesite(value);
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }

 @Then ("user click on red triangle warning button")
 public void user_click_red_triangle_button() throws InterruptedException {
	 try {
		 Thread.sleep(1000);
		 MCMviewAppLogin.ClickOnRedWarningButton();
		
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 
 @When ("the user checks for the message {string}")
 public void user_validate_message_under_communication(String msg) throws InterruptedException {
	
	 try {
		 Thread.sleep(1000);
		 MCMviewAppLogin.validatecommunicatiotest(msg);
		// MCMviewAppLogin.validatecommunicationmsg(msg);
		
	 }
	 catch(Exception e) {
		 
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 
 @Then ("user validate Tenancy warning containing the VF added is displayed")
 public void user_validate_warning_msg() throws InterruptedException {
	 try {
		 Thread.sleep(1000);
		 MCMviewAppLogin.ValidateWarningMsg();
		
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @Then ("user scroll to {string} and click on delete")
 public void user_click_on_delete(String value ) throws InterruptedException {
	 try {
		 Thread.sleep(1000);
		 MCMviewAppLogin.Scroll_down_to_click_delete(value);
		 
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
 
 @When ("user search {string} and {string} click on the address details for new version")
 public void click_on_address_details_new_version(String partadd,String addname)
 {
	 try {
		 Thread.sleep(1000);
		 MCMviewAppLogin.ClickAddressnamenewVerion(partadd,addname);
		 
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @Then("Scroll down and click on expansion panel header button for {string} with {string}")
	public void click_expansion(String option,String Value )
	{
	 
	 try {
		 Thread.sleep(5000);
		// MCMviewAppLogin.scrolldown();
		 switch(option)
			{
			case "MCMAppUserName":
				    Thread.sleep(1000);
				    MCMviewAppLogin.click_expansionpanel();
				    break;
			case "AllUser":
			    Thread.sleep(1000);
			    MCMviewAppLogin.click_ExpansionButtonAllUser(Value);
			    break;
			case "RLAPMearsuser":
			    Thread.sleep(1000);
			    MCMviewAppLogin.click_expansionpanel();
			    break;
			case "RLAPMearEditServiceUser":
			    Thread.sleep(1000);
			    MCMviewAppLogin.click_EditServiceUserexpansionpanel();
			    break;  
			case "Living_HM_username":
			    Thread.sleep(1000);
			    MCMviewAppLogin.click_expansionpanel();
			    break;
			case "AASC_HMexpansion":
			    Thread.sleep(5000);
			    MCMviewAppLogin.click_AASCHM_panel(Value);
			    break;
			case "Tenancy Detail":
			    Thread.sleep(1000);
			    MCMviewAppLogin.click_TenancyDetailexpamsionbtn();
			    break;
			case "Communication Details":
			    Thread.sleep(5000);
			    MCMviewAppLogin. click_CommunicationDetail_expansionpanel();
			    break;
			case "Application Details":
			    Thread.sleep(5000);
			    MCMviewAppLogin. ApplicationDetailexpbtn();
			    break;
			case "Living_HOexpansion":
			    Thread.sleep(5000);
			    MCMviewAppLogin. click_LivingHO_expansionpanel();
			    break;
			case "Living_HOThreeDots":
			    Thread.sleep(5000);
			    MCMviewAppLogin.click_threedotTenancy();
			    break;
			case "AASC_HMusername": 
			    Thread.sleep(5000);
			    MCMviewAppLogin.click_threedotTenancy();
			    break;
			case "RLAPMearsthreedots":
			    Thread.sleep(5000);
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
				 Thread.sleep(9000);
				MCMviewAppLogin.Notesxpansionbtn();
				System.out.println("user select : " + option );
				break;
			case "Note Documents":
				 Thread.sleep(9000);
				MCMviewAppLogin.NoteDocumentsxpansionbtn();
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
			case "Property Details":
				 Thread.sleep(1000);
				MCMviewAppLogin.click_expansionPropertyDetails();
				System.out.println("user select : " + option );
				break;
		 }
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @Then ("verify all tabs appearing on the Add risk Assessment popup page")
 public void Validate_risk_ass_popup_page(DataTable datatable) throws InterruptedException
 {
	 Thread.sleep(2000);
	 MCMviewAppLogin.validate_risk_ass_popuppage(datatable);
 }
 @Then ("varify all the values are prsent under Risk Assessment")
 public void Validate_risk_assessment_page(DataTable datatable)
 {  
	 try {
		 Thread.sleep(7000);
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
	 Thread.sleep(8000);
	 System.out.println("Field : " + field );
		System.out.println("Value : " + value );
	 MCMviewAppLogin.selectAddNewRisk(field,value);
 }
 @When ("I set the {string} to {string}")
 public void generate_value_for_txt(String field, String value)throws InterruptedException
 {
	// Thread.sleep(3000);
	 System.out.println("Field : " + field );
		System.out.println("Value : " + field );
	 MCMviewAppLogin.generatePasswordValue(field,value);
 }
 @Then ("user fill random details for {string} as {string}")
 public void generate_random_txt(String field, String value)throws InterruptedException
 {
	// Thread.sleep(3000);
	 System.out.println("Field : " + field );
		System.out.println("Value : " + field );
	 MCMviewAppLogin.generateRandomtxt(field,value);
 }
 @Then ("user validate the Alert message {string} and {string} for Add New Risk form")
 public void user_validate_the_Alert_message(String msg1,String msg2) throws InterruptedException
 {
	 MCMviewAppLogin.validate_message_in_textbox(msg1,msg2) ;
 }
 @Then ("user click on {string} button")
 public void user_click_on_save_button(String option)throws InterruptedException
 {
	 try {
		 Thread.sleep(5000);
		 MCMviewAppLogin.clickOnSave(option);
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @Then ("validate the last entry default checkbox is selected")
 public void user_validate_last_chkbox_selected()throws InterruptedException
 {
	 try {
		 Thread.sleep(1000);
		 MCMviewAppLogin.validate_lst_chkbox_isselected();
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @And("user delete the content {string} from the Drop Down List")
 public void clear_the_content(String txt)throws InterruptedException
 {
	 
		 MCMviewAppLogin.deletetxtvalue(txt);
	
 }
 @Then ("user click on {string}")
 public void user_click_on_txt(String txt)throws InterruptedException
 {
	 
		 MCMviewAppLogin.clickOntxt(txt);
	
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
 
 
 
 @Then ("user click on the edit icon under {string}")
 public void user_click_on_Edit_Icon_button(String str)throws InterruptedException
 {
	 try {
		 Thread.sleep(6000);
		 MCMviewAppLogin.clickOnEditIconRisk(str);
	 }
	 catch(Exception e) {
		 System.out.println("Exception :"+ e + "has occured" );
	 }
 }
 @Then ("user click on the plus icon under {string}")
 public void user_click_on_plus_Icon_button(String str)throws InterruptedException
 {
	 try {
		 Thread.sleep(6000);
		 MCMviewAppLogin.clickOnplusIconRisk(str);
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
			 Thread.sleep(1000);
			 MCMviewAppLogin.clickDropDownList(dropname);
			 System.out.println("user clicked on drop down" );
		 }
		 catch(Exception e) {
			 System.out.println("Exception :"+ e + "has occured" );
		 }
	 }
	 @And ("user click on {string} under {string}")
	 public void click_under_tab(String val,String dropname)
	 {
		 try {
			 Thread.sleep(1500);
			 MCMviewAppLogin.clickUnderTab(val,dropname);
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
	 @And ("user select {string} from dropdown for {string}")
		 public void user_select_from_drop_down_List(String option,String value)
		 {
		
				 try {
					 Thread.sleep(2000);
					 switch(value)
						{
						case "Calender":
							    Thread.sleep(1000);
								MCMviewAppLogin.clickonOptionDropDownCalender(option);
								System.out.println("user select : " + option );
								break;
						case "Other":
						    Thread.sleep(1000);
						    MCMviewAppLogin.clickonOptionDropDown(option);
							System.out.println("user select : " + option );
							break;
			 }
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
		 
     @Then ("Validate the task outcome is false")
    	 public void validate_taskOutcome_is_false() throws InterruptedException, AWTException
    	 {
    		 try {
    				    Thread.sleep(1500);
    					MCMviewAppLogin.TaskOutcomeFalse();
    		 }catch(org.openqa.selenium.NoSuchElementException e)
    		 {
    			 System.out.println("Move to next stem in cucumber");
    			 return;
    		 }
    	 }
     }
	 
	
 
 

