package com.herokuapp.codebreakers.stepDefinition;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.herokuapp.codebreakers.POM.CommonObjects;
import com.herokuapp.codebreakers.POM.UsersObjects;
import com.herokuapp.codebreakers.utilities.TestSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStepDefinition {
	
	TestSetup testsetup;
	WebDriver driver;
	CommonObjects commonobj;
	UsersObjects usersobj;
	List<String> aescendingOriginalList;
	List<String> descendingOriginalList;
	
	
	public UserStepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonObjects();
		usersobj = testsetup.pageobjectmanager.getUsersObjects();
		
	}

//	@Given("Admin is in manage user page")
//	public void admin_is_in_manage_user_page() {
//	    
//	}
	@Given("Admin is on dashboard page after Login and clicks User on the navigation bar")
	public void admin_is_on_dashboard_page_after_login_and_clicks_user_on_the_navigation_bar() {
		commonobj.loginUser();
		 usersobj.clickUserLink();
	}

	

	/*@When("Admin clicks on the {string} sort icon by {int} clicks")
	public void admin_clicks_on_the_sort_icon_by_clicks(String columnHeading, Integer clickCount) {
		usersobj.clickUserLink();
		descendingOriginalList	= usersobj.sorting(columnHeading,clickCount);
	}
	@Then("Admin should see User details are sorted by {string} Descending order")
	public void admin_should_see_user_details_are_sorted_by_descending_order(String string) {
		
		 List<String> sortedDescendingList = descendingOriginalList.stream().sorted(Comparator.reverseOrder())
			        .collect(Collectors.toList());
		 Assert.assertTrue(descendingOriginalList.equals(sortedDescendingList),"Descending Sorted List is not matching");
		 System.out.println("Original List is"+ descendingOriginalList);
		 System.out.println("Sorted List is"+ sortedDescendingList); 
	}

	
	@When("Admin clicks on the {string} sort icon by {int} click")
	public void admin_clicks_on_the_sort_icon_by_one_click(String columnHeading,Integer clickCount) {
		usersobj.clickUserLink();
		aescendingOriginalList =usersobj.sorting(columnHeading,clickCount);
	}
	@Then("Admin should see User details are sorted by {string} Aescending order")
	public void admin_should_see_user_details_are_sorted_by_aescending_order(String string) {
		List<String> aescendingSortedList = aescendingOriginalList.stream().sorted().collect(Collectors.toList());
		 Assert.assertTrue(aescendingOriginalList.equals(aescendingSortedList),"Aescending Sorted List is not matching");
		 System.out.println("Original List is"+ aescendingOriginalList);
		 System.out.println("Sorted List is"+ aescendingSortedList); 
	}*/
	
	
//	Scenario: Validate Row level delete icon on Manage User Page
	@When("Admin clicks the delete icon on row level in Manage User Page")
	public void admin_clicks_the_delete_icon() throws InterruptedException {
	usersobj.clickRowDeleteButton();
	}
	
	@Then("Admin should see a alert open with heading Confirm along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_confirm_along_with_yes_and_no_button_for_deletion() {
		usersobj.validateRowDeleteBtn() ;
		System.out.println("user deleted");
	}
	
//	Scenario: Validate No on Confirm Deletion Window
	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
		System.out.println("Validated");
	}
//	Scenario: Validate Close icon on Confirm Deletion Window
	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
		System.out.println("Validated");
	}
//	 Scenario: Deleting single user at row level
	@When("Admin clicks the row level delete icon after selecting the user and clicks {string} option")
	public void admin_clicks_the_row_level_delete_icon_after_selecting_the_users_and_clicks_option(String deleteAction, List<String> userId) throws InterruptedException {
		usersobj.singleUserDeleteInRow(deleteAction,userId);
	}
	@Then("Admin gets a message <Successful User Deleted> alert and do not see that user in the data table")
	public void admin_gets_a_message_successful_user_deleted_alert_and_do_not_see_that_user_in_the_data_table() {
	    System.out.println("success yes");
	}
//-------------------------------------------------- Multiple user delete
//	Scenario:Validate Delete button on header enabled
	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() {
		usersobj.clickCheckBox();
	}

	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
		usersobj.validateHeaderDelete();
	}
// Scenario: "Yes/No/Close"Confirm Deletion Window for muliple user deletion
	@When("Admin clicks the delete icon under header after selecting the multiple user and clicks {string} option")
	public void admin_clicks_the_delete_icon_under_header_after_selecting_the_multiple_user_and_clicks_option(String deleteAction,List<String> userId) throws InterruptedException {
		usersobj.multipleUserDelete(deleteAction, userId);
	}

//	------------------------Assign student----------------------------------
	

//	Validate Assign Student Popup window
	@When("Admin clicks Assign Student button")
	public void admin_clicks_assign_student_button() {
		usersobj.clickAssignStudentLink();
	}

	@Then("Admin should see a pop up open for assign student details with empty form along with Save, Cancel button and close icon in the window")
	public void admin_should_see_a_pop_up_open_for_assign_student_details_with_empty_form_along_with_save_cancel_button_and_close_icon_in_the_window() {
		usersobj.buttonValidation() ;
	}
//	 Scenario: Validate input fields and their text boxes in Assign Student form Popup window
	@Then("Admin should see User Role as R03,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes")
	public void admin_should_see_user_role_as_r03_and_other_fields_student_email_id_skill_program_name_batch_name_and_status_with_respective_input_boxes() {
		usersobj.validateInputfields();
	}
//	Scenario:Validate Assign Student Popup window Form for Radio buttons
	@Then("Admin should see two radio button for Status")
	public void admin_should_see_two_radio_button_for_status() {
		usersobj.radioButtonValidation();
	}
//Scenario:Empty Form Submission for without any data
	@Given("Admin is in Assign Student details pop up page")
	public void admin_is_in_assign_student_details_pop_up_page() {
		usersobj.clickAssignStudentLink();
	}

	@When("Admin clicks Save button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() {
		usersobj.clickSaveButton();
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
		usersobj.validateEmptyFormErrMsg();
	}
//	 Form Submission for without selecting program
	@When("Admin clicks Save button without selecting Program Name for {string}")
	public void admin_clicks_save_button_without_selecting_program_name_for(String emailId) {
		usersobj.validateAssignStdtWithOutProgram(emailId);
	}

	@Then("Admin gets a Error message alert as Program Name is required")
	public void admin_gets_a_error_message_alert_as_program_name_is_required() {
		usersobj.validateErrMsgAssignStdtWithOutProgram();
	}
//	 Form Submission for without selecting batch
	@When("Admin clicks Save button without giving BatchName  for {string}")
	public void admin_clicks_save_button_without_giving_batch_name_for(String emailId) {
		usersobj.validateAssignStdtWithOutBatch(emailId);
	}

	@Then("Admin gets a Error message alert as BatchName is required")
	public void admin_gets_a_error_message_alert_as_batch_name_is_required() {
		usersobj.validateErrMsgAssignStdtWithOutBatch();
	}
	
	
//	Form Submission without status
//	@When("Admin clicks Save button by giving  {string} {string} {string}")
//	public void admin_clicks_save_button_by_giving(String emailId, String programName, String BatchName) {
//	    System.out.println("Form Submission without status");
//	}

	
	@When("Admin clicks Save button by giving  {string}")
	public void admin_clicks_save_button_by_giving(String emailId) throws InterruptedException {
//		usersobj.validateWithStudentEmailId(emailId);
		usersobj.validateAssignStdtWithOutStatus(emailId);
	}
	@Then("Admin gets a Error message alert as Status is required")
	public void admin_gets_a_error_message_alert_as_status_is_required() {
		usersobj.validateErrMsgAssignStdtWithOutStatus();
		System.out.println("Form Submission without status");
		
	}
	
}
