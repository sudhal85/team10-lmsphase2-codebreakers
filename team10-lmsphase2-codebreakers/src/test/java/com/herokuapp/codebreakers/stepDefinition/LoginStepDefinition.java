package com.herokuapp.codebreakers.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.herokuapp.codebreakers.POM.LoginPageObjects;
import com.herokuapp.codebreakers.utilities.TestSetup;

public class LoginStepDefinition {

	TestSetup testsetup;
	WebDriver driver;
	LoginPageObjects loginobj;
	
	public LoginStepDefinition(TestSetup testsetup){
		
		this.testsetup = testsetup;
		this.driver= testsetup.drivermanager.driver;
		loginobj = testsetup.pageobjectmanager.getLoginPageObjects();
		
	}
	
}
