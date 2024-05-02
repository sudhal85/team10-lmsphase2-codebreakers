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
	    
	}

	@Then("The user should be redirected to user page")
	public void the_user_should_be_redirected_to_user_page() {
	   
	}
	
}
