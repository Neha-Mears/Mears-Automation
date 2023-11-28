package com.sat.testbase;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.sat.testUtil.Log;
import com.sat.testUtil.Testutil;

import io.qameta.allure.Allure;

public class Assertions {
	
	 TestBase testbase = new TestBase();
	 WebDriver driver= TestBase.getDriver();
	 Testutil util = new Testutil();
	 Testutil testutil = new Testutil();
	 
	 public Assertions(WebDriver rdriver) {
		 driver= rdriver;
		 PageFactory.initElements(rdriver,this);
		  }	
	 
	 public void CheckAssertion(String Expected, String Actual) throws IOException {
		 try {
			 if (!Expected.equals(Actual)) {
			 		System.out.println("checking assertion");
			 		System.out.println(Expected + "==" + Actual);
		 } else {
	 			System.out.println(Expected + "==" + Actual);}
                } 
			     catch (Exception e)
		 {
		 } 
	 }
	 public void CheckAssertionTrue(WebElement E,String msg) {
			if (E.isDisplayed() != true) {
		 Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(io.qameta.allure.model.Status.FAILED));
			 Assert.fail(msg + " does not exists");
			}
	 }
	 public void CheckAssertionTrue(Boolean b,String listValue) 
	 {
		 System.out.println("in CheckAssertionTrue is: " + b);
		 try {
		 if (!b) {
 
			 Assert.fail(listValue + " does not exist in the list");
			 Log.error("pass");}
		 } catch (NullPointerException e) {
e.printStackTrace();} }


public void CheckAssertionNull(WebElement E) {
	if (E.getAttribute("innerText") != null) {
			Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(io.qameta.allure.model.Status.FAILED)); } 
 	else {
 //ExtentCucumberAdapter.getCurrentStep().pass("");
}
}

public void CheckAssertion(Integer Expected, Integer Actual) throws Exception {
 System.out.println(Expected + "==" + Actual);
 if (Expected!=Actual) {
	 	System.out.println("in if");

	 		System.out.println("Expected is '" + Expected + "' But Actual got as '" + Actual + "'");
	 		Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(io.qameta.allure.model.Status.FAILED));
	 		System.out.println("Assert failed on :" + Actual);
}
}
}

