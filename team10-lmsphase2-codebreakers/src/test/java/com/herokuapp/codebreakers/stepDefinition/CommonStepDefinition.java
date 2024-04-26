package com.herokuapp.codebreakers.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.herokuapp.codebreakers.POM.CommonObjects;
import com.herokuapp.codebreakers.utilities.TestSetup;

import io.cucumber.java.en.Given;

public class CommonStepDefinition {
	TestSetup testsetup;
	WebDriver driver;
	CommonObjects commonobj;
	
	
	public CommonStepDefinition(TestSetup testsetup) throws IOException {
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonObjects();
		
	}
	
	
	
}
