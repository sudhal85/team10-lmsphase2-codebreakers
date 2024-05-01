package com.herokuapp.codebreakers.stepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.herokuapp.codebreakers.POM.BatchPageObjects;
import com.herokuapp.codebreakers.POM.CommonObjects;
import com.herokuapp.codebreakers.utilities.Constants;
import com.herokuapp.codebreakers.utilities.ExcelReader;
import com.herokuapp.codebreakers.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchStepDefinition 
{
	TestSetup testsetup;
	WebDriver driver;
	CommonObjects commonobj;
	BatchPageObjects batchobj;
	
	public BatchStepDefinition (TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonObjects();
		batchobj = testsetup.pageobjectmanager.getBatchObjects();
		
	}
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login()
	{
		Assert.assertEquals(Constants.DASHBOARD_PAGE_TITLE, batchobj.getDashboardTitle());
	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String text) 
	{
		batchobj.clickOnBatch(text);
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String text) 
	{
		Assert.assertTrue(driver.getCurrentUrl().contains(text));
	}
	
	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String text) 
	{
		Assert.assertEquals(text, batchobj.getBatchHeader());
	}
	
	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() throws InterruptedException
	{
		Assert.assertTrue(batchobj.getFirstPagination().isDisplayed());
		Assert.assertTrue(batchobj.getSecondPagination().isDisplayed());
		Assert.assertTrue(batchobj.getThirdPagination().isEnabled());
		Assert.assertTrue(batchobj.getFourthPagination().isEnabled());
		batchobj.getPagination();
	}
	
	@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() 
	{
		Assert.assertEquals(batchobj.getTableHeader().getText(), batchobj.saveTableHeader());
	}
	
	@Then("Admin should be able to see the delete icon button that is disabled")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled() 
	{
		Assert.assertTrue(batchobj.getDeleteAllDisabled().isDisplayed());
	}
	
	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_button(String text) 
	{
		if(text.equals(batchobj.getANewBatchButton().getText()))
		{
			Assert.assertEquals(batchobj.getANewBatchButton().getText(), text);
		}
	}
	
	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() throws InterruptedException 
	{
		Assert.assertTrue(batchobj.verifyCheckBoxes().TRUE);
	}
	
	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled()
	{
		Assert.assertTrue(batchobj.verifyEditButtons().TRUE);
	}
	
	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() 
	{
		Assert.assertTrue(batchobj.verifyDeleteButtons().TRUE);
	}
	
	@When("Admin clicks {string} button")
	public void admin_clicks_button(String text) 
	{
		
		batchobj.clickOnANewBatch(text);
		Assert.assertEquals(batchobj.getANewBatchButton().getText(), text);
	}

	@Then("A new pop up with Batch details appears")
	public void a_new_pop_up_with_batch_details_appears() throws InterruptedException 
	{
		Assert.assertEquals(batchobj.getBatchDetailsHeader().getText(), batchobj.popUpBatchDetails());
	}
	
	@Given("Admin is on dashboard page and admin clicks on batch and then admin clicks on A New Batch then A new pop up with Batch details appears")
	public void admin_is_on_dashboard_page_and_admin_clicks_on_batch_and_then_admin_clicks_on_a_new_batch_then_a_new_pop_up_with_batch_details_appears() 
	{
		batchobj.afterClickingAddBatch();
	}
	
	@Then("The pop up should include the fields Name, Number of classes and Description as text box, Program Name as drop down Status as radio button Number of classes as text box")
	public void the_pop_up_should_include_the_fields_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button_number_of_classes_as_text_box()
	{
	    Assert.assertTrue(batchobj.getBatchNameTextBox().isEnabled());
	    Assert.assertTrue(batchobj.getBatchDescriptionTextBox().isEnabled());
	    Assert.assertTrue(batchobj.getProgramNameDropDown().isEnabled());
	    Assert.assertTrue(batchobj.getBatchRadioBtn().isEnabled());
	    Assert.assertTrue(batchobj.getBatchNoOfClassesTextBox().isEnabled());
	}
	
	@When("Fill in all the fields except description with valid values from {string} and RowNumber {int} and click close")
	public void fill_in_all_the_fields_except_description_with_valid_values_from_and_row_number_and_click_close(String SheetName, int RowNumber) throws InvalidFormatException, IOException 
	{
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		String description = testData.get(RowNumber).get("Description");
		String programName = testData.get(RowNumber).get("ProgramName");
		String numberOfClasses = testData.get(RowNumber).get("NumberOfClasses");
		batchobj.enterBatchDetails(name, description, programName, numberOfClasses);
		batchobj.clickOnCloseBtn();
		
		Actions action = new Actions(driver);
		batchobj.getBatchSearchBox().sendKeys(name);
	}

	@Then("The newly added batch should be present in the data table in Manage Batch page")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() throws InterruptedException 
	{
		Thread.sleep(1000);
		Assert.assertTrue(batchobj.getPaginationDetails());
	}
	
	@When("Fill in all the fields except description with valid values from {string} and RowNumber {int} and click save")
	public void fill_in_all_the_fields_except_description_with_valid_values_from_and_row_number_and_click_save(String SheetName, int RowNumber) throws InvalidFormatException, IOException, InterruptedException 
	{
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		String description = testData.get(RowNumber).get("Description");
		String programName = testData.get(RowNumber).get("ProgramName");
		String numberOfClasses = testData.get(RowNumber).get("NumberOfClasses");
		batchobj.enterBatchDetails(name, description, programName, numberOfClasses);
		
	}
	
	@Then("The newly added batch from {string} and RowNumber {int} should be present in the data table in Manage Batch page and gives {string} pop up message")
	public void the_newly_added_batch_from_and_row_number_should_be_present_in_the_data_table_in_manage_batch_page_for_validation(String SheetName, int RowNumber, String msg) throws InvalidFormatException, IOException, InterruptedException 
	{
		Assert.assertEquals(batchobj.getSuccessMsg().getText(), msg);
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		batchobj.checkDataIsPresent(name);
	}
	
	@When("Fill in any of the fields with invalid values from {string} and RowNumber {int} and click save")
	public void fill_in_any_of_the_fields_with_invalid_values_from_and_row_number_and_click_save(String SheetName, int RowNumber) throws InvalidFormatException, IOException 
	{
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		String description = testData.get(RowNumber).get("Description");
		String programName = testData.get(RowNumber).get("ProgramName");
		String numberOfClasses = testData.get(RowNumber).get("NumberOfClasses");
		batchobj.enterBatchDetails(name, description, programName, numberOfClasses);
	}

	@Then("Error message should appear")
	public void error_message_should_appear() 
	{
		Assert.assertEquals(Constants.BATCH_FIELD_ERR_MSG, batchobj.getBatchNameErrMsg().getText());
		Assert.assertEquals(Constants.BATCH_FIELD_ERR_MSG, batchobj.getBatchDescriptionErrMsg().getText());
	}
	
	@When("Fill in any of the mandatory fields with blank from {string} and RowNumber {int} and click save")
	public void fill_in_any_of_the_mandatory_fields_with_blank_from_and_row_number_and_click_save(String SheetName, int RowNumber) throws InvalidFormatException, IOException 
	{
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		String description = testData.get(RowNumber).get("Description");
		String programName = testData.get(RowNumber).get("ProgramName");
		String numberOfClasses = testData.get(RowNumber).get("NumberOfClasses");
		batchobj.enterBatchDetails(name, description, programName, numberOfClasses);
	}

	@Then("Error message should appear and admin validates the error message")
	public void error_message_should_appear_and_admin_validates_the_error_message() 
	{
		Assert.assertEquals(Constants.BATCH_NAME_FIELD_REQUIRED_ERR_MSG, batchobj.getBatchNameErrMsg().getText());
		Assert.assertEquals(Constants.BATCH_DESCRIPTION_FIELD_REQUIRED_ERR_MSG, batchobj.getBatchDescriptionErrMsg().getText());
		Assert.assertEquals(Constants.BATCH_NOOFCLASSES_FIELD_REQUIRED_ERR_MSG, batchobj.getBatchNoOfClassesErrMsg().getText());
	}
	
	@Given("The edit icon on row level in data table is enabled")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled() 
	{
		batchobj.clickOnBatch();
	}

	@When("Admin gets the batch name from {string} and RowNumber {int} and clicks the edit icon")
	public void admin_gets_the_batch_name_from_and_row_number_and_clicks_the_edit_icon(String SheetName, int RowNumber) throws InvalidFormatException, IOException, InterruptedException
	{
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		batchobj.getBatchSearchBox().sendKeys(name);
		Thread.sleep(1000);
		batchobj.clickOnEdit();
	}
	
	@Given("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() 
	{
		batchobj.clickOnBatch();
	}

	@When("Update the fields with valid values from {string} and RowNumber {int} and click save")
	public void update_the_fields_with_valid_values_from_and_row_number_and_click_save(String SheetName, int RowNumber) throws InvalidFormatException, IOException, InterruptedException 
	{
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		batchobj.getBatchSearchBox().sendKeys(name);
		Thread.sleep(1000);
		batchobj.clickOnEdit();
		
		
		String edit_description = testData.get(RowNumber).get("edit_Description");
		String edit_numberOfClasses = testData.get(RowNumber).get("edit_NumberOfClasses");
		batchobj.updateBatchDetails(edit_description, edit_numberOfClasses);
	}

	@Then("The updated batch details from {string} and RowNumber {int} should appear on the data table and gets {string} message")
	public void the_updated_batch_details_from_and_row_number_should_appear_on_the_data_table(String SheetName, int RowNumber, String msg) throws InvalidFormatException, IOException, InterruptedException 
	{
		Assert.assertEquals(batchobj.getSuccessMsg().getText(), msg);
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		batchobj.checkDataIsPresent(name);
	}
	
	@When("Update the fields with invalid values from {string} and RowNumber {int} and click save")
	public void update_the_fields_with_invalid_values_from_and_row_number_and_click_save(String SheetName, int RowNumber) throws InvalidFormatException, IOException, InterruptedException 
	{
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		batchobj.getBatchSearchBox().sendKeys(name);
		Thread.sleep(1000);
		batchobj.clickOnEdit();
		
		String edit_description = testData.get(RowNumber).get("edit_Description");
		String edit_numberOfClasses = testData.get(RowNumber).get("edit_NumberOfClasses");
		batchobj.updateBatchDetails(edit_description, edit_numberOfClasses);
	}

	@Then("Error messages should appear {string} and {string}")
	public void error_messages_should_appear_and(String msg1, String msg2) 
	{
	   Assert.assertEquals(msg1, batchobj.getEditBatchDescriptionErrMsg().getText());
	   Assert.assertEquals(msg2, batchobj.getEditBatchNoOfClassesErrMsg().getText());
	}
	
	@When("admin enters the batch name from {string} and RowNumber {int} to Erase data from mandatory field")
	public void admin_enters_the_batch_name_from_and_row_number_row_number_to_erase_data_from_mandatory_field(String SheetName, int RowNumber) throws InvalidFormatException, IOException, InterruptedException 
	{
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		batchobj.getBatchSearchBox().sendKeys(name);
		Thread.sleep(1000);
		batchobj.clickOnEdit();
		batchobj.eraseData();
	}

	@Then("Error message {string} should appear")
	public void error_message_should_appear(String msg) 
	{
	   Assert.assertEquals(msg, batchobj.getEditBatchDescriptionErrMsg().getText());
	}
	
	@When("Erase data from description field passed through {string} and RowNumber {int}")
	public void erase_data_from_description_field_passed_through_and_row_number(String SheetName, int RowNumber) throws InvalidFormatException, IOException, InterruptedException 
	{
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		batchobj.getBatchSearchBox().sendKeys(name);
		Thread.sleep(1000);
		batchobj.clickOnEdit();
		batchobj.eraseBatchDescription();
		batchobj.clickEditBatchCancelBtn().click();
	}

	@Then("The updated batch details from {string} and RowNumber {int} should appear on the data table")
	public void the_updated_batch_details_from_and_row_number_should_appear_on_the_data_table(String SheetName, int RowNumber) throws InvalidFormatException, IOException, InterruptedException 
	{
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		batchobj.getBatchSearchBox().sendKeys(Keys.COMMAND+"A");
		batchobj.getBatchSearchBox().sendKeys(Keys.DELETE);
		batchobj.getBatchSearchBox().sendKeys(name);
		Thread.sleep(1000);
		Assert.assertTrue(batchobj.getBatchEditDescriptionValue().getText().isEmpty());
	}
	
	@Given("The delete icon on row level in data table is enabled")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled() 
	{
		batchobj.clickOnBatch();
		Assert.assertTrue(batchobj.verifyDeleteBtns().TRUE);
	}
	
	@When("Admin enters data  from {string} and RowNumber {int} and clicks the delete icon")
	public void admin_enters_data_from_and_row_number_and_clicks_the_delete_icon(String SheetName, int RowNumber) throws InvalidFormatException, IOException, InterruptedException 
	{
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		batchobj.getBatchSearchBox().sendKeys(name);
		Thread.sleep(1000);
		batchobj.clickOnDelete();
	}

	@Then("Alert appears with {string} and {string} option")
	public void alert_appears_with_yes_and_no_option(String text1, String text2) throws InterruptedException 
	{
		Assert.assertTrue(batchobj.deleteSwitchAlert().getText().contains(text1) && batchobj.deleteSwitchAlert().getText().contains(text1));
	}
	
	@Given("Admin enters the data from {string} and RowNumber {int} and clicks the delete icon")
	public void admin_enters_the_data_from_and_row_number_and_clicks_the_delete_icon(String SheetName, int RowNumber) throws InvalidFormatException, IOException, InterruptedException 
	{
		batchobj.clickOnBatch();
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		batchobj.getBatchSearchBox().sendKeys(name);
		Thread.sleep(1000);
		batchobj.clickOnDelete();
	}

	@When("You click yes option")
	public void you_click_yes_option() 
	{
		batchobj.clickOnYesInDelete();
	}

	@Then("Batch deleted alert pops {string} message and admin enters data from {string} and RowNumber {int} to check batch is no more available in data table")
	public void batch_deleted_alert_pops_message_and_admin_enters_data_from_and_row_number_to_check_batch_is_no_more_available_in_data_table(String msg, String SheetName, int RowNumber) throws InvalidFormatException, IOException, InterruptedException 
	{
		
		Assert.assertEquals(batchobj.getSuccessMsg().getText(), msg);
		
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		batchobj.getBatchSearchBox().sendKeys(Keys.COMMAND+"A");
		batchobj.getBatchSearchBox().sendKeys(Keys.DELETE);
		batchobj.getBatchSearchBox().sendKeys(name);
		Thread.sleep(1000);
		Assert.assertEquals(batchobj.batchPaginationDetails().getText(), Constants.PAGINATION_DETAILS);
	}
	
	@When("you click No option")
	public void you_click_no_option() 
	{
		batchobj.clickOnNoInDelete();
	}

	@Then("admin enters data from {string} and RowNumber {int} Batch is still listed in data table")
	public void admin_enters_data_from_and_row_number_batch_is_still_listed_in_data_table(String SheetName, int RowNumber) throws InvalidFormatException, IOException 
	{
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader.getData("./src/test/resources/TestData/Data1.xlsx", SheetName);
		String name = testData.get(RowNumber).get("Name");
		Assert.assertTrue(batchobj.batchSearchAfterClickingNo().getText().contains(name));
	}

	@Given("None of the checkboxes in data table are selected")
	public void none_of_the_checkboxes_in_data_table_are_selected() 
	{
	   
	}

	@Then("The delete icon under the {string} header should be disabled")
	public void the_delete_icon_under_the_header_should_be_disabled(String header) 
	{
	   
	}


		

}
