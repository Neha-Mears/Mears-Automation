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
	tags= {	"@TC_149452_AASC_HM_Address_Page-Add_keys_showing_keys_held_by or \r\n" +
			"@TC_149480_167366_AASC_HM-Add_and_Edit_a_Risk-Amend_Review_date_Add_mitigating_factors or \r\n" +
			"@TC_167607_167609_167614_167628_AASC_HM_Address_Page-Add_keys or \r \n" +
			"@TC_146367_Add_risk_assessment_and_risk_and_then_Edit_the_Risk_Add_person_factors or \r \n" +
			"@TC167367_AASC_HM_Address_Page-Add_first_risk_assessment"
			})
	
	public class LivingHM_TestRunner extends AbstractTestNGCucumberTests{
		//@Override
	      
	  //    @DataProvider(parallel = true) 
	 //   public Object[][] scenarios() { 
	//		 return super.scenarios();
		 
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
