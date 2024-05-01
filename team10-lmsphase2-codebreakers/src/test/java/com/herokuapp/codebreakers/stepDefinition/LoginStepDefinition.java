package com.herokuapp.codebreakers.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.herokuapp.codebreakers.POM.LoginPageObjects;
import com.herokuapp.codebreakers.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	TestSetup testsetup;
	WebDriver driver;
	LoginPageObjects loginobj;
	
	public LoginStepDefinition(TestSetup testsetup){
		
		this.testsetup = testsetup;
		this.driver= testsetup.drivermanager.driver;
		loginobj = testsetup.pageobjectmanager.getLoginPageObjects();
		
	}
	

	@When("The user select Get Started button in user panel")
	public void the_user_select_get_started_button_in_user_panel() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should be redirected to user page")
	public void the_user_should_be_redirected_to_user_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
