package com.herokuapp.codebreakers.stepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.Validate;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.herokuapp.codebreakers.POM.CommonObjects;
import com.herokuapp.codebreakers.POM.ProgramPageObjects;
import com.herokuapp.codebreakers.utilities.ExcelReader;
import com.herokuapp.codebreakers.utilities.TestSetup;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramStepDefnition {
	TestSetup testsetup;
	WebDriver driver;
	ProgramPageObjects programobj;
	CommonObjects commonobj;
	List<String> descendingOriginalList;
	 List<String> aescendingOriginalList;
	public ProgramStepDefnition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		programobj = testsetup.pageobjectmanager.getProgramPageObjects();
		commonobj = testsetup.pageobjectmanager.getCommonObjects();
		 
	}
	
	@Given("User is on dashboard page after Login and clicks Program on the navigation bar")
	public void user_is_on_dashboard_page_after_login_and_clicks_program_on_the_navigation_bar() {
		commonobj.loginUser();
	}

	@Given("Program_Admin is on dashboard page after Login")
	public void program_admin_is_on_dashboard_page_after_login() {
		 
	}

	@When("Program_Admin clicks Program on the navigation bar")
	public void program_admin_clicks_program_on_the_navigation_bar() {
		 programobj.manageProgram();
	   
	}

	@Then("Program_Admin should see URL with {string}")
	public void program_admin_should_see_url_with(String string) {
	    programobj.ManageprogramUrl();
	   
	}

	@Then("Program_Admin should see a heading with text {string} on the page")
	public void program_admin_should_see_a_heading_with_text_on_the_page(String string) {
	    programobj.verifyHeaderText("Manage Program");
	   
	}

	@Then("Program_Admin should see the text as {string} along with Pagination icon below the table.")
	public void program_admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) {
	    
	   programobj.verifyEntries();
	}

	@Then("Program_Admin should see the footer as {string}.")
	public void program_admin_should_see_the_footer_as(String string) {
	    
	   programobj.verifyFooter();
	}

	@Then("Program_Admin should see a Delete button on the top left hand side as Disabled")
	public void program_admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
	    programobj.delDisabled();
	   
	}

	@Then("Program_Admin should see a +A New Program button on the program page above the data table")
	public void program_admin_should_see_a_a_new_program_button_on_the_program_page_above_the_data_table() {
	    
	   programobj.validateNewProgramBtn();
	}

	@Then("Program_Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
	public void program_admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) {
	    
	   programobj.totalRows();
	}

	@Then("Program_Admin should see data table on the Manage Program Page with following column headers \\(Program Name, Program Description, Program Status, Edit,Delete)")
	public void program_admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_program_name_program_description_program_status_edit_delete() {
	    programobj.checkHeaderText();
	    
	   
	}

	@Then("Program_Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void program_admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
	    programobj.validateSortButton();
	   
	}

	@Then("Program_Admin should see check box on the left side in all rows of the data table")
	public void program_admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
	    programobj.validateCheckboxes();
	   
	}

	@Then("Program_Admin should see Any Edit and Delete buttons on each row of the data table")
	public void program_admin_should_see_any_edit_and_delete_buttons_on_each_row_of_the_data_table() {
	    programobj.validateEditDelete();
	   
	}

	@Then("Program_Admin should see Search bar with text as {string}")
	public void program_admin_should_see_search_bar_with_text_as(String string) {
	    programobj.validateSearch();
	   
	}
	@When("Admin clicks A New Program Button")
	public void admin_clicks_a_new_program_button() {
	    
	    programobj.newProgramClick();
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
	    
	    programobj.validateNewProgram();
	}

	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
	    
	    programobj.validateTextboxes();
	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {
	    programobj.validateRadioButton();
	    
	}

	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String string) {
	    
	    programobj.newProgramClick();
	   
	}

	@When("Admin clicks <Save>button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() {
		programobj.clickSaveBtn();
	    
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
		 programobj.errorMsg();
		//programobj.alertMsg();
	    
	}

	@When("Admin enters only<Program Name> in text box and clicks Save button")
	public void admin_enters_only_program_name_in_text_box_and_clicks_save_button() {
	    programobj.saveWithOnlyProgramName();
	    programobj.clickSaveBtn();
	    
	}

	@Then("Admin gets a message alert {string}")
	public void admin_gets_a_message_alert(String Expmsg) {
		 programobj.errorMsg(Expmsg);
	   // programobj.alertMsg();
	   
	    
	}

	@When("Admin enters only<Program description> in text box and clicks Save button")
	public void admin_enters_only_program_description_in_text_box_and_clicks_save_button() {
	    programobj.onlyProgramDesc();
	    programobj.clickSaveBtn();
	    
	}

	@When("Admin selects only Status and clicks Save button")
	public void admin_selects_only_status_and_clicks_save_button() {
	    
	    programobj.onlyStatus();
	    programobj.clickSaveBtn();
	}
	@Then("Admin gets a message alert {string} and {string}")
	public void admin_gets_a_message_alert(String Expmsg1,String expmsg2) {
		 programobj.errorStatus(Expmsg1, expmsg2);
	   
	   
	    
	}

	@When("Admin enters only numbers or special char in name and desc column")
	public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column(DataTable data) {
	   //ExcelReader reader = new ExcelReader();
	 //  List<Map<String, String>> testdata=reader.getData(".\\src\\test\\resources\\Exceldata\\data.xlsx", sheetname);
	//String programName = testdata.get(rownumber).get("programname");
	//String programDesc = testdata.get(rownumber).get("programdescription");
		
	List<List<String>> valuesList = data.cells();
	driver.findElement(By.xpath("//input[@id='programName']")).sendKeys(valuesList.get(0).get(0));
	driver.findElement(By.xpath("//input[@id='programDescription']")).sendKeys(valuesList.get(0).get(1));
	programobj.onlyStatus();
	programobj.clickSaveBtn();
programobj.clickcancel();
programobj.newProgramClick();
	driver.findElement(By.xpath("//input[@id='programName']")).sendKeys(valuesList.get(1).get(0));
	driver.findElement(By.xpath("//input[@id='programDescription']")).sendKeys(valuesList.get(1).get(1));
	programobj.onlyStatus();
	programobj.clickSaveBtn();
	
	}

	@When("Admin clicks Close Icon on Program Details form")
	public void admin_clicks_cancel_close_x_icon_on_program_details_form() {
	    programobj.clickClose();
	    
	}

	@Then("Program Details popup window should be closed without saving")
	public void program_details_popup_window_should_be_closed_without_saving() {
	    programobj.validateclose();
	    
	}

	@When("Enter all the required fields with valid values and click Save button")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button() throws InterruptedException {
	   programobj.savePgmWithvalidData();
	   programobj.clickSaveBtn();
	}



	@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String expmsg) {
	    //programobj.validateProgramAdded();
	   
	    
	}


		@When("Enter all the required fields with valid values and click Save button {string} and {int}")
		public void enter_all_the_required_fields_with_valid_values_and_click_save_button_and(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		    
			 ExcelReader reader = new ExcelReader();
		   List<Map<String, String>> testdata=reader.getData(".\\src\\test\\resources\\Exceldata\\data.xlsx", sheetname);
		String pname = testdata.get(rownumber).get("programname");
		String pDesc = testdata.get(rownumber).get("programdescription");
			programobj.savepgmFromExcel(pname, pDesc);
			programobj.clickSaveBtn();
			programobj.alertMsg();
		}
		@Then("Admin gets a message Successful Program Created Successfully alert and able to see the new program added in the data table {string} and {int}")
		public void admin_gets_a_message_successful_program_created_successfully_alert_and_able_to_see_the_new_program_added_in_the_data_table_and(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			   List<Map<String, String>> testdata=reader.getData(".\\src\\test\\resources\\Exceldata\\data.xlsx", sheetname);
		String pname= testdata.get(rownumber).get("programname");
		programobj.validateProgramAdded(pname);
		
		}
	@When("Admin clicks <Cancel>button")
	public void admin_clicks_cancel_button() {
	    programobj.clickcancel();
	    
	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {
	    programobj.validateCancel();
	    
	}

	@When("Admin clicks <Edit> button on the data table for any row")
	public void admin_clicks_edit_button_on_the_data_table_for_any_row() {
	    programobj.clickEdit();
	    
	}

	@Then("Admin should see a popup open for Program details to edit")
	public void admin_should_see_a_popup_open_for_program_details_to_edit() {
	    programobj.validateEdit();
	    
	}

	@When("Admin edits the Name column and clicks save button")
	public void admin_edits_the_name_column_and_clicks_save_button() {
	    
	    programobj.clickEdit();
	    programobj.editPgmName();
	}

	@Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String string) {
	    programobj.validateNameEdit();
	    
	}

	@When("Admin edits the Description column and clicks save button")
	public void admin_edits_the_description_column_and_clicks_save_button() {
	    programobj.clickEdit();
	    programobj.editPgmDesc();
	    
	}

	@Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String string) {
	    
	    programobj.validateDescEdit();
	}

	@When("Admin changes the Status and clicks save button")
	public void admin_changes_the_status_and_clicks_save_button() {
	    programobj.clickEdit();
	    programobj.editPgmStatus();
	    
	}

	@Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String string) {
	    
	    
	}
	@When("Admin edits only numbers or special char in name and desc column and clicks save button")
	public void admin_edits_only_numbers_or_special_char_in_name_and_desc_column_and_clicks_save_button() {
	    programobj.clickEdit();
	    programobj.editInvalid();
	}


	@When("Admin clicks <Cancel>button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
	    
	    programobj.clickEdit();
	    //programobj.clickcancel();
	}

	@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
	public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {
	    programobj.getEditValues();
	    
	}

	@When("Admin clicks <Save>button on edit popup")
	public void admin_clicks_save_button_on_edit_popup() {
	    programobj.clickEdit();
	    programobj.clickSaveBtn();
	    
	}

	@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String string) {
	    programobj.editSave();
	    
	}

	@When("Admin clicks <Delete> button on the data table for any row")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row() {
	    
	    
	}
	@When("Admin clicks <Delete> button on the data table for any row {string} and {int}")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row_and(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		   List<Map<String, String>> testdata=reader.getData("C:\\Users\\azam_\\git\\team10-lmsphase2-codebreakers\\team10-lmsphase2-codebreakers\\src\\test\\resources\\Exceldata\\data.xlsx", sheetname);
		String pname = testdata.get(rownumber).get("programname");
			programobj.clickRowDelButton(pname);
	    
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
	programobj.confirmBoxText();
	}

	@Then("Admin should see a message {string}")
	public void admin_should_see_a_message(String string) {
	    programobj.confirmDeleteValidation();
	    
	}

	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
	    programobj.clickdeleteBtn();
	    
	}

	@When("Admin clicks <YES> button on the alert")
	public void admin_clicks_yes_button_on_the_alert() {
	    programobj.clickYes();
	    
	}

	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String string) {
	    programobj.confirmDeleteValidation();
	   // programobj.programEdited(string);
	    
	}

	@When("Admin clicks <NO> button on the alert")
	public void admin_clicks_no_button_on_the_alert() {
	    programobj.clickNo();
	    
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
	    programobj.noConfirmAlert();
	    
	}

	@When("Admin clicks Cancel Icon on Deletion alert")
	public void admin_clicks_cancel_close_x_icon_on_deletion_alert() {
	    
	    programobj.clickclose();
	    
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
	    programobj.noConfirmAlert();
	    
	}
	
	// Multiple delete
	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() {
	    programobj.validateCommonDelete();
	}

	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
	    
	}

	@When("Admin clicks <YES> button on the alert for single checkbox select")
	public void admin_clicks_yes_button_on_the_alert_for_single_checkbox_select() {
	   programobj.validateSingleDeleteYes();
	}

	@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() {
	    
	}

	@When("Admin clicks <NO> button on the alert for single checkbox select")
	public void admin_clicks_no_button_on_the_alert_for_single_checkbox_select() {
	    programobj.validateSingleDeleteNo();
	}

	@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() {
	    
	}

	@When("Admin clicks <YES> button on the alert with multi checkbox select")
	public void admin_clicks_yes_button_on_the_alert_with_multi_checkbox_select() {
	    programobj.validateMulDeletionYes();
	}

	@When("Admin clicks <NO> button on the alert with multi checkbox select")
	public void admin_clicks_no_button_on_the_alert_with_multi_checkbox_select() {
	    programobj.validateMulDeleteNo();
	}

	
	
	// Sorting
	@When("Admin clicks on the {string} sort icon by {int} clicks")
	public void admin_clicks_on_the_sort_icon_by_clicks(String columnHeading, Integer clickCount) {
	    programobj.manageProgram();
	   descendingOriginalList=programobj.sorting(columnHeading, clickCount);
	}

	@Then("Admin should see Program details are sorted by {string} Descending order")
	public void admin_should_see_program_details_are_sorted_by_descending_order(String string) {
		
		List<String> sortedDescendingList = descendingOriginalList.stream().sorted(Comparator.reverseOrder())
			        .collect(Collectors.toList());
		 Assert.assertTrue(descendingOriginalList.equals(sortedDescendingList),"Descending Sorted List is not matching");
		 System.out.println("Original List is"+ descendingOriginalList);
		 System.out.println("Sorted List is"+ sortedDescendingList);
	}

	@When("Admin clicks on the {string} sort icon by {int} click")
	public void admin_clicks_on_the_sort_icon_by_click(String columnHeading, Integer clickCount) {
		programobj.manageProgram();
		   aescendingOriginalList=programobj.sorting(columnHeading, clickCount);
	}

	@Then("Admin should see Program details are sorted by {string} Aescending order")
	public void admin_should_see_program_details_are_sorted_by_aescending_order(String string) {
		List<String> aescendingSortedList = aescendingOriginalList.stream().sorted().collect(Collectors.toList());
		 Assert.assertTrue(aescendingOriginalList.equals(aescendingSortedList),"Aescending Sorted List is not matching");
		 System.out.println("Original List is"+ aescendingOriginalList);
		 System.out.println("Sorted List is"+ aescendingSortedList);
	}

	//Pagination
	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
	    programobj.validate_next_pagelink();
	}

	@Then("Admin should see the Pagination has Next active link")
	public void admin_should_see_the_pagination_has_next_active_link() {
	    System.out.println("the Pagination has Next active link");
	}
	@When("Verify Last page link")
	public void verify_last_page_link() {
	    programobj.validate_last_pagelink();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
		 System.out.println("the last page record on the table with Next page link are disabled");
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
	    programobj.validate_first_pagelink();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
	    System.out.println("the previous page record on the table with pagination has previous page link");
	}
	
	// Navigation
	@When("Admin clicks on Batch link on Manage Program page")
	public void admin_clicks_on_batch_link_on_manage_program_page() {
	   programobj.clickBatchLink();
	}

	@Then("Admin is re-directed to Batch page")
	public void admin_is_re_directed_to_batch_page() {
	   
	}

	@When("Admin clicks on User link on Manage Program page")
	public void admin_clicks_on_user_link_on_manage_program_page() {
	    programobj.clickUserLink();
	}

	@Then("Admin is re-directed to User page")
	public void admin_is_re_directed_to_user_page() {
	    
	}

	@When("Admin clicks on Logout link on Manage Program page")
	public void admin_clicks_on_logout_link_on_manage_program_page() {
	    programobj.clickLogout();
	}

	@Then("Admin is re-directed to Login page")
	public void admin_is_re_directed_to_login_page() {
	    
	}


}
