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
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonObjects();
		
	}
	
	
	@Given("User is on dashboard page after Login and clicks User on the navigation bar")
	public void user_is_on_dashboard_page_after_login_and_clicks_user_on_the_navigation_bar() {
		commonobj.loginUser();
	}
}
