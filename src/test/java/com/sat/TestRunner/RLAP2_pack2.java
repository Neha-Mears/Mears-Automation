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
			"@148427_148380_RLAP_Service_User_Create_a_request_Standard_due_date_RLAP_Mears or \r \n" +
			"@148445_168930_168929_RLAP_Application_Add_a_request_Standard_No_due_date_RLAP_Mears or \r \n" +
			"@167630_RLAP_Mears_Address_Page-Add_keys_marking_1_as_default or \r \n" +
			"@168527_RLAP_Mears_End_an_Active_Tenancy or \r \n" +
	    	"@168927_RLAP_Applications_Create_Service_User_Complete_all_fields or \r \n" + 
			"@168928_RLAP_Service_User_Complete_a_request_Standard_due_date_RLAP_Mears or \r \n" +
			"@TC_149318_RLAP_Mears_Add_Address_with_5_contracts_and_existing_owner_DA_and_SSFA_selected,Mears_Approval_Yes" 
		
			
			})
	
	public class RLAP2_pack2 extends AbstractTestNGCucumberTests{
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
