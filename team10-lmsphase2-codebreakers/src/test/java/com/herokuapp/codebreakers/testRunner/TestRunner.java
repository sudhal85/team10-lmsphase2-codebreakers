package com.herokuapp.codebreakers.testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

			features = "src/test/resources/features/userDelete.feature",
			glue = {"com.herokuapp.codebreakers.stepDefinition","com.herokuapp.codebreakers.hooks"},
			monochrome = true
//			plugin = {"pretty", "html:target/cucumber.html","json:target/cucumber.json",
//	       		       "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
//			           "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
			)

	public class TestRunner extends AbstractTestNGCucumberTests{
			
			@Override       
			@DataProvider(parallel = false)
			public Object[][] scenarios() {
				return super.scenarios();
			}
}
