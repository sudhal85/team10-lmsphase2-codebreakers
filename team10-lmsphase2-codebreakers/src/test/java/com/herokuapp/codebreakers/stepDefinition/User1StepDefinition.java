package com.herokuapp.codebreakers.stepDefinition;


import java.io.IOException;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import com.herokuapp.codebreakers.POM.CommonObjects;
import com.herokuapp.codebreakers.POM.User1PageObject;
import com.herokuapp.codebreakers.utilities.TestSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class User1StepDefinition {
	TestSetup testsetup;
	WebDriver driver;
	CommonObjects commonobj;
	User1PageObject user1obj;
	public User1StepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonObjects();
		user1obj = testsetup.pageobjectmanager.getUser1PageObjects();
		
	}
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		commonobj.loginUser();
		
	}
	
	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) {
		user1obj.user1PageLink();
	}

	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String string) {
		
		user1obj.ManageUser();
	}
	@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, Edit\\/Delete")
	public void admin_should_see_the_data_table_with_column_names_id_name_location_phone_number_edit_delete() {
		boolean isCheckDataTablePresent = user1obj.checkDataTableIsPresent();
		Assert.assertEquals(isCheckDataTablePresent, true);
	}

	@Then("Admin should see disabled delete icon on the manage User page")
	public void admin_should_see_disabled_delete_icon_on_the_manage_user_page() {
		boolean isDeleteIconDisabled = user1obj.isDeleteIconIsDisabled();
		Assert.assertTrue(isDeleteIconDisabled);
	}

	@Then("Admin should see {string} button on the manage User page")
	public void admin_should_see_button_on_the_manage_user_page(String string) {
		user1obj.clickUserTab();
		//Thread.sleep(3000);
		Assert.assertTrue(user1obj.clickAddNewUserButton());
	}

	@Then("Admin should see search bar on the manage User page")
	public void admin_should_see_search_bar_on_the_manage_user_page() {
		//initialise();
		boolean result = user1obj.isSearchBoxVisible();
		Assert.assertTrue(result);
	}


	
//	@Then("Admin should see two  records displayed on the data table")
//	public void admin_should_see_two_records_displayed_on_the_data_table() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

//	@Then("Admin should see check box in the all rows  of data table when entries available")
//	public void admin_should_see_check_box_in_the_all_rows_of_data_table_when_entries_available() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

//	@Then("Edit Icon in each row of data table only  when entries are available for {string}")
//	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available_for(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Delete Icon in each row of data table only  when entries are available for {string}")
//	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available_for(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
		
			user1obj.clickUserTab();
	}
	@When("Admin enters user name into search box.")
	public void admin_enters_user_name_into_search_box() {
		Object search = null;
		((User1PageObject) search).enterSearchText("John Matthew");
	}
	@Then("Admin should see user displayed with the entered name")
	public void admin_should_see_user_displayed_with_the_entered_name() {
		Object search;
	
		String actual = ((User1PageObject) search).checkUserNameMatchingTheSearch();
		String expected = "John Matthew";
		Assert.assertEquals(expected,actual);
	}
	@When("Admin enters user ID into search box.")
	public void admin_enters_user_id_into_search_box() {
		Object search = null;
		((User1PageObject) search).enterSearchText("U01");
	}

	@When("Admin enters user Location into search box.")
	public void admin_enters_user_location_into_search_box() {
		Object search = null;
		((User1PageObject) search).enterSearchText("New Jersey");
	}

	@When("Admin enters user phone number into search box.")
	public void admin_enters_user_phone_number_into_search_box() {
		Object search = null;
		((User1PageObject) search).enterSearchText("123456789");
	}

	
	@When("Admin enters the keywords not present in the data table on the Search box")
	public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box() {
		Object search = null;
		((User1PageObject) search).enterSearchText("@#$%");
	}

	@SuppressWarnings("null")
	@Then("Admin should see zero entries on the data table")
	public void admin_should_see_zero_entries_on_the_data_table() {
		Object search = null;
		((User1PageObject) search).checkIfNoResultsForSearch();
	}

	
	
	
	
	
	
	
	
}
