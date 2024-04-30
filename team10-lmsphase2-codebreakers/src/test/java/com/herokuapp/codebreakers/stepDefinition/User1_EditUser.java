package com.herokuapp.codebreakers.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.util.Assert;
import com.herokuapp.codebreakers.POM.CommonObjects;
import com.herokuapp.codebreakers.POM.User1PageObject;
import com.herokuapp.codebreakers.utilities.TestSetup;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class User1_EditUser {

	TestSetup testsetup;
	WebDriver driver1;
	CommonObjects commonobj;
	User1PageObject user1obj;
	public User1_EditUser(TestSetup testsetup) throws IOException {
	
	}
		static WebDriver driver;
		static User1PageObject user;
		static User1PageObject deleteuser;
		static User1PageObject userDetails;
		static User1PageObject userID;
		static User1PageObject editOrDelete;
	
		public void initialise() {

			System.out.println("In Given");

			DriverFactory dr = new DriverFactory();
			driver1 = dr.initialiseDriver();
			user= new UserPageObject(driver1);
			//deleteuser= new UserPageDeleteIconPageObject(driver);
			//userID = new UserIDPageObject(driver);
			editOrDelete = new UserEditOrDeletePageObject(driver1);
			user.enterLoginID();
			user.enterLoginPassword();
			user.clickLogin();
			user.clickUserTab();
		}


		
		@Then("User should see the buttons with edit\\/delete icon in each row of Edit\\/Delete coulmn")
		public void user_should_see_the_buttons_with_edit_delete_icon_in_each_row_of_edit_delete_coulmn() {
			initialise();
			Assert.assertTrue(editOrDelete.isEditButtonVisibleInDataTable());
			Assert.assertTrue(editOrDelete.isDeleteButtonVisibleInDataTable());
		}
		//
		//	@When("User clicks delete button")
		//	public void user_clicks_delete_button() {
		//	  user.clickDeleteIconOnRight();
		//	}
		//
		//	@Then("Confirm dialog box should be displayed with Text Are you sure you want to delete \\(selected user name) ? , button with text {string} , the button with text {string} and close\\(X) icon")
		//	public void confirm_dialog_box_should_be_displayed_with_text_are_you_sure_you_want_to_delete_selected_user_name_button_with_text_the_button_with_text_and_close_x_icon(String string, String string2) {
		//	   Assert.assertTrue(user.checkUserDetailsDialogBox());
		//	}
		
//		@Given("User table is displayed in manage user page for EditOrDelete function")
//		public void user_table_is_displayed_in_manage_user_page_() {
//			boolean isCheckDataTablePresent = user.checkDataTableIsPresent();
//			Assert.assertEquals(isCheckDataTablePresent, true);
//		}

		@When("User clicks Edit button")
		public void user_clicks_edit_button() {

			editOrDelete.clickfirstEditButtonOnRight();
		}

		@Then("{string} dialog box should be displayed for editing")
		public void dialog_box_should_be_displayed_for_editing(String string) {
			boolean isCheckUserDetailsDialogBoxPresent = editOrDelete.ischeckUserDetailsDialogBoxPresent();
			Assert.assertTrue(isCheckUserDetailsDialogBoxPresent);
		}