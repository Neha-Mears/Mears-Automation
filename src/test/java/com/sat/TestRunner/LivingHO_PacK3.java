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
	tags= {	
			"@TC_167651_122406_Living_HO_Edit_alarm-Code_access_details_&_Address_Page-Edit_key_type or \r \n" +
			"@TC_167652_167722_Edit_alarm-Alert_Password_&_edit_notes or \r \n" +
			"@TC_167725_167632_Edit_key_log-Mark_key_as_returned_&_supplier_added or \r \n" +
			"@TC_167726_Living_HO_Edit_key_log-Change_who_has_key or \r \n" +
			"@TC_167727_167634_who_has_key_Update_&_booked_out_by_&_Edit_key_reference" 
			})
	
	public class LivingHO_PacK3 extends AbstractTestNGCucumberTests{
	//	@Override
	      
	    //  @DataProvider(parallel = true) 
	   //  public Object[][] scenarios() { 
		//	 return super.scenarios();
		 
	}
	//}
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
