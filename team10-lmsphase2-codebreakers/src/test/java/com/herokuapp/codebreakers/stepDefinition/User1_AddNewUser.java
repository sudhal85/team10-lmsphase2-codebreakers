package com.herokuapp.codebreakers.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import com.aventstack.extentreports.util.Assert;
import com.herokuapp.codebreakers.POM.CommonObjects;
import com.herokuapp.codebreakers.POM.User1PageObject;
import com.herokuapp.codebreakers.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class User1_AddNewUser {
	TestSetup testsetup;
	WebDriver driver;
	CommonObjects commonobj;
	User1PageObject user1obj;
	User1_AddNewUser userDetails;
	private int beforeDeleteCount;
	private int afterCount;
	
	public User1_AddNewUser(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonObjects();
		user1obj = testsetup.pageobjectmanager.getUser1PageObjects();
	}


	@SuppressWarnings("deprecation")
	@When("User clicks A Add new user button")
	public void user_clicks_a_add_new_user_button() {
		
		user1obj.clickUserTab();
		user1obj.clickAddNewUserButton();
	}

	
		


	@Then("User should see User details window with heading {string}")
	public void user_should_see_user_details_window_with_heading(String string) {
		Thread.sleep(2000);
		boolean isDisplayed = user1obj.checkUserDetailsDialogBox();
		Assert.assertTrue(isDisplayed);
		Assert.assertTrue(userDetails.validateHeadingInUserDetailsAlert());
	}

	private boolean validateHeadingInUserDetailsAlert() {
		// TODO Auto-generated method stub
		return false;
	}


	@Then("User should see a button with text Cancel in user details window")
	public void user_should_see_a_button_with_text_cancel_in_user_details_window() {
		Thread.sleep(2000);
		boolean isCancelButtonPresentInUserDetails = userDetails.isCancelButtonPresentInUserDetailsAlert();
		Assert.assertTrue(isCancelButtonPresentInUserDetails);
	}

	private boolean isCancelButtonPresentInUserDetailsAlert() {
		// TODO Auto-generated method stub
		return false;
	}


	@When("User clicks A cancel button")
	public void user_clicks_a_cancel_button() {
		Thread.sleep(2000);
		userDetails.clickcancelButtoninUserDetailsAlert();


	@Then("User details window should be closed")
	public void user_details_window_should_be_closed() {
		Thread.sleep(2000);
		boolean value = user1obj.ischeckUserDetailsDialogBoxPresent();
		Assert.assertFalse(value); 
	}

	@Then("User should see a cancel\\(x) in user details window")
	public void user_should_see_a_cancel_x_in_user_details_window() {
		boolean value = userDetails.isCloseButtonOnUserDetailsALertVisible();
		Assert.assertTrue(value);
	}

	private boolean isCloseButtonOnUserDetailsALertVisible() {
		// TODO Auto-generated method stub
		return false;
	}


	@When("User clicks A cancel\\(X) icon")
	public void user_clicks_a_cancel_x_icon() {
		userDetails.clickCancelButtonOnuserDetailsAlert();
	}






	private void clickCancelButtonOnuserDetailsAlert() {
		// TODO Auto-generated method stub
		
	}


	@Then("User should see a button with text Submit in user details window")
	public void user_should_see_a_button_with_text_submit_in_user_details_window() {
		userDetails.isSubmitButtoninUserDetailsAlert();
	}

	private void isSubmitButtoninUserDetailsAlert() {
		// TODO Auto-generated method stub
		
	}


	@Then("User should see the input fields for {string},{string}, Last name\",\"Email adress\",\"Phone no\", \"Address\",\"City\", \"State\",\"Postal Code\".\"Program\",\"UG Program\",\"PG Program\",\"Skill\",\"Experience\",\"User Role\",Visa status\",{string},{string} corresponding to their labels")
	public void user_should_see_the_input_fields_for_last_name_email_adress_phone_no_address_city_state_postal_code_program_ug_program_pg_program_skill_experience_user_role_visa_status_corresponding_to_their_labels(String string, String string2, String string3, String string4) {
		boolean validate = userDetails.validateInputElementsinUserDetailsDialogBox();
		Assert.assertTrue(validate);
	}

	private boolean validateInputElementsinUserDetailsDialogBox() {
		// TODO Auto-generated method stub
		return false;
	}


	@Then("User should see the placeholders with Text")
	public void user_should_see_the_placeholders_with_text() {
		boolean validate = userDetails.validatePlaceHolderInUserDetailsBox();
		Assert.assertTrue(validate);
	}

	private boolean validatePlaceHolderInUserDetailsBox() {
		// TODO Auto-generated method stub
		return false;
	}


	@When("User clicks the drop down icon for state")
	public void user_clicks_the_drop_down_icon_for_state() {
		userDetails.clickDropDownState();
	}

	private void clickDropDownState() {
		// TODO Auto-generated method stub
		
	}


	@Then("User should select from the drop down menu")
	public void user_should_select_from_the_drop_down_menu() {
		userDetails.isDropDownStateListVisible();
	}

	private void isDropDownStateListVisible() {
		// TODO Auto-generated method stub
		
	}


	@When("User clicks the drop down icon for User Role")
	public void user_clicks_the_drop_down_icon_for_user_role() {
		userDetails.clickDropDownState();
	}

	@Then("User should select from the role drop down menu")
	public void user_should_select_from_the_role_drop_down_menu() {
		userDetails.isDropDownRoleListEnabled();
	}

	private void isDropDownRoleListEnabled() {
		// TODO Auto-generated method stub
		
	}


	@When("User clicks Save button by entering all valid values in required fields")
	public void user_clicks_save_button_by_entering_all_valid_values_in_required_fields() {
		Object previousCount = userDetails.findNoOfRecordsInDataTable(); 
		userDetails.enterAllDetails();
	}

	private void enterAllDetails() {
		// TODO Auto-generated method stub
		
	}


	@Then("New User Should be Saved.")
	public void new_user_should_be_saved() {
		 afterCount = (int) userDetails.findNoOfRecordsInDataTable();
		 Assert.assertTrue(afterCount>beforeDeleteCount);
	}

	private Object findNoOfRecordsInDataTable() {
		// TODO Auto-generated method stub
		return null;
	}


	@Then("User should see the button with text {string}")
	public void user_should_see_the_button_with_text(String string) {
		userDetails.isAddress2TextBoxInUserDetailsVisible();
	}

	private boolean isAddress2TextBoxInUserDetailsVisible() {
		// TODO Auto-generated method stub
		
	}


	@When("User clicks the button + Add CO, Apt, Suite, Unit")
	public void user_clicks_the_button_add_co_apt_suite_unit() {
		userDetails.clickAddress2LinkInUserDetails();
	}

	private void clickAddress2LinkInUserDetails() {
		// TODO Auto-generated method stub
		
	}


	@Then("User should see the input field with Label Address2")
	public void user_should_see_the_input_field_with_label_address2() {
		Object userDetails;
		Assert.assertTrue(((User1_AddNewUser) userDetails).isAddress2TextBoxInUserDetailsVisible());
	}
	
	@Given("User is on {string} window")
	public void user_is_on_window(String string) {
		user1obj.clickUserTab();
	}

	@When("User Clicks save button with all the fields empty")
	public void user_clicks_save_button_with_all_the_fields_empty() {
		throw new io.cucumber.java.PendingException();
	}

	@Then("User should see a message {string}")
	public void user_should_see_a_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	

}