package com.herokuapp.codebreakers.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.herokuapp.codebreakers.POM.CommonObjects;
import com.herokuapp.codebreakers.POM.DashBoardObjects;
import com.herokuapp.codebreakers.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardStepDefinition 
{
	CommonObjects commonobj;
	DashBoardObjects dashboardobj;
	TestSetup testsetup;
	WebDriver driver;
	
public   DashboardStepDefinition(TestSetup testsetup)
{
		
		this.testsetup = testsetup;
		this.driver= testsetup.drivermanager.driver;
		dashboardobj =testsetup.pageobjectmanager.getDashBoardObjects();
		commonobj=testsetup.pageobjectmanager.getCommonObjects();
		//excelreaderobj	=testsetup.pageobjectmanager.getExcelReaderObjects();
	}
	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() 
	{
		
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() 
	{
		commonobj.loginUser();
	}

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() 
	{
		dashboardobj.verifydashboardprogramheader();
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("HTTP response >= {int} .Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) throws Exception 
	{
	   
	
	
		dashboardobj.processLinks(int1);
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		dashboardobj.verifylmstitlealignment();
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() 
	{
		dashboardobj.correctSpelling();
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() 
	{
		dashboardobj.navigationBar();
	}

	@Then("Admin should see program in the 1st place")
	public void admin_should_see_program_in_the_1st_place() {
		dashboardobj.clickprogram();
		dashboardobj.verifydashboardprogramheader();
	}

	@Then("Admin should see batch in the 2st place")
	public void admin_should_see_batch_in_the_2st_place() {
		dashboardobj.clickbatch();
		dashboardobj.verifybatchpageopened();
	}

	@Then("Admin should see user in the 3rd place")
	public void admin_should_see_user_in_the_3rd_place() {
		dashboardobj.clickuser();
		dashboardobj.verifyuserpageopened();
	}
	   

	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
		dashboardobj.logout();
		//dashboardobj.verifylogoutpageopened();
	}
	    

	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() {
		dashboardobj.verifylogoutpageopened();
	}



}
