package com.sat.TestRunner;

import org.openqa.selenium.WebDriver;
import org.slf4j.helpers.Util;
import org.testng.annotations.DataProvider;

import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;

import io.cucumber.core.gherkin.Scenario;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



//	@RunWith(Cucumber.class)
	@CucumberOptions(
			features={"src/test/resources/com.sat.Features"},
			glue={"com.sat.StepDefinitions","com.sat.AppHooks"},
			monochrome=true,
			strict = true,
			plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
			//plugin={"pretty","json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/cucumber-reports/report.html"},
			//tags=("@AdminTool_And_Click&Meet"))
			//tags ={"@ResalRegistration or @ResalForgotpassword or @RegisteringItem"})//@ResalForgotpassword //@RegisteringItem //@ResalRegistration
	tags= {	"@150655_149580_AASC_HM_Living_HO_Create_a_PM_appointment_for_today or \r\n" +
			"@150655_165905_RLAP_AASC_HM_Create_a_AM_appointment_for_today or \r \n" +
			"@150658_AASC_HM_Add_a_Complaint_Made_By_the_Service_User_against_a_staff_member or \r \n" +
			"@TC146120_166007_AASC_HM_&_RLAP_Can_edit_an_existing_complaint_rasied_by_Staff_member_and_set_it_to_Escalated_to_AIRE or \r \n" +
			"@TC146193_166006_AASC_HM_and_RLAP_Mears_Can_edit_an_existing_incident_raised_against_Other_and_set_it_to_Monitoring or \r \n" +
	    	"@150658_165903_AASC_HM_RLAP_Mears_Add_a_Complaint_Made_By_the_Service_User_against_a_staff_member or \r \n" +
			"@TC165901_RLAP_Mears_Can_edit_an_existing_complaint_rasied_against_Other_and_set_it_to_Complete or \r \n" +
			"@TC71632_TC146366_166005_149542 or \r \n" +
			"@TC_90608_AASC_HM_Edit_PM-Appt_Change_to_an_hour_earlier_within_same_client_classification_slot or \r \n" +
			"@TC_150656_165906_165904_AASC_HM_Add_an_sensitive_note or \r \n" +
			"@TC_90684_122439_Living_HO_Tenancy_Add_a_long_note_validate_note_type_required or \r \n" +
			"@TC164833_165331_165900_RLAP_Mears_Can_edit_an_existing_incident_raised_by_SU_and_set_it_to_Complete or \r \n" +
			"@164833_165331_165902_AASC_HM_&_RLAP_Raise_an_Incident_against_Other_&_AASC_HM_Can_edit_an_existing_incident_raised_by_SU_and_set_it_to_Complete or \r \n" +
			"@TC_71632_146366_166005_149542_122393_149543_Add_a_Risk_and_delete_the_details"
			})
	
	public class RegressionSutie_TestRunner extends AbstractTestNGCucumberTests{
	//	@Override
	      
	   //   @DataProvider(parallel = true) 
	      //public Object[][] scenarios() { 
			// return super.scenarios();
		 
	}
//	}
		/*
		@After
		public void afterScenario(Scenario scenario) {
			TestBase testbase = new TestBase();
			WebDriver driver = TestBase.getDriver();
			byte[] screenshot= Testutil.takesscreenshot(driver);
			scenario.attach( "image/png", scenario.getName());
	}
	}
	*/
		/*@BeforeStep
		public void beforeStep() {
		}

		@AfterStep
		public void afterStep() {
		}

		@Before
		public void beforeScenario() {
		}

		@After
		public void afterScenario(Scenario scenario) {
//			scenario.attach(Util.takeScreenShot(), "image/png", scenario.getName());
		}*/
	
	
	//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//	import cucumber.api.CucumberOptions;
//	import cucumber.api.testng.AbstractTestNGCucumberTests;
//	@CucumberOptions(features="src/test/resources/features",glue="stepDefinitions",tags="@Test01",plugin= {"pretty", "html:target/cucumber-reports" },monochrome=true)

//public class TestRunner {
//    private TestNGCucumberRunner testNGCucumberRunner;
// 
//    @BeforeClass(alwaysRun = true)
//    public void setUpClass() throws Exception {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
// 
//    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
//    public void feature(CucumberFeatureWrapper cucumberFeature) {
//        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//    }
// 
//    @DataProvider
//    public Object[][] scenarios() {
//        return testNGCucumberRunner.provideScenarios();
//    }
// 
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() throws Exception {
//        testNGCucumberRunner.finish();
//    }
//}	
//	
//		
//	
