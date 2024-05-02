package com.herokuapp.codebreakers.stepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.herokuapp.codebreakers.POM.CommonObjects;
import com.herokuapp.codebreakers.POM.HomePageObjects;
import com.herokuapp.codebreakers.utilities.ExcelReader;
import com.herokuapp.codebreakers.utilities.TestSetup;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinition {

	TestSetup testsetup;
	WebDriver driver;
	HomePageObjects homeobj;
	ExcelReader excelreaderobj;
	CommonObjects commonobj;
	
	List<Map<String,String>> testData;
	List<Map<String, String>> excelData = new ArrayList<>();
	
	
	
	String username=null;
	String password= null;
	String testcase= null;
	
public  HomePageStepDefinition(TestSetup testsetup){
		
		this.testsetup = testsetup;
		this.driver= testsetup.drivermanager.driver;
		homeobj =testsetup.pageobjectmanager.getHomePageObject();
		excelreaderobj	=testsetup.pageobjectmanager.getExcelReaderObjects();
		commonobj=testsetup.pageobjectmanager.getCommonObjects();
	}
	 
	
	//@Before
    //public void setupTestData() throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
      //  testData = excelreaderobj.getData("/team10-lmsphase2-codebreakers/src/test/resources/testData/Team10_lms_ui.xlsx","Homepage");
        
    //}
	
	@Given("Admin launches the LMS application")
	public void admin_launches_the_lms_application() 
	{
	    
	}
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
	    
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url(String Url) 
	{
	    driver.get(Url);
	}

	@Then("Admin is on the home page")
	public void admin_is_on_the_home_page() {
		System.out.println(driver.getCurrentUrl());
		
	    
	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {
	    
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
		homeobj.verifySpelling();
	   
	}

	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
		
	    
	}

	@When("Admin is in homepage")
	public void admin_is_in_homepage() 
	{
	
	}
	@When("Admin gives the invalid LMS portal  URL {string}")
	public void admin_gives_the_invalid_lms_portal_url(String URL) {
	    driver.get(URL);
	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) {
		 String Currenturl=driver.getCurrentUrl();
		 if(Currenturl.contains("404"))
		 {
			 System.out.println("Admin received a page 404 error");
		 }else
		 {
			 System.out.println("Admin didnot recieve 404 error");
		 }
	    
	}
	    

	@Then("Text in login section {string} is displayed")
	public void text_in_login_section_is_displayed(String string) 
	{
		homeobj.VerifyTextinloginSection();
	    
	}

	@Then("Username field text {string} is displayed")
	public void username_field_text_is_displayed(String string) {
		homeobj.verifyUsernametext();
	}

	@Given("Admin is in Homepage")
	public void admin_is_in_Homepage() {
	    
	}
	@Then("Admin should see logo on the left  side")
	public void admin_should_see_logo_on_the_left_side() 
	{
		homeobj.verifyimagedisplayed();
	}

	@When("Admin enter invalid username from {string} and {int} and clicks login button")
	public void admin_enter_invalid_username_from_and_and_clicks_login_button(String sheetName, int rownumber) throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException  {
	
//		// Iterate over the data to find matching test case
//        for (Map<String, String> rowData : excelData) {
//            if (rowData.get("TestCase").equals("Invalid username and invalid password")) {
//            	 testcase= rowData.get("TestCase");
//                 username = rowData.get("Username");
//                 password = rowData.get("Password");
//              
//                break; // Assuming there's only one match
//            }
//            System.out.println("Testcase:" +testcase);
//            System.out.println("Username: " + username + ", Password: " + password);
//            homeobj.enterUsername(username);
//            homeobj.enterPassword(password);
//            homeobj.clickLoginButton();
    //    }
	
	ExcelReader excelReader = new ExcelReader();
	  List<Map<String,String>> testData = excelReader.getData("C:\\Users\\kswat\\Desktop\\Team10_lms_ui.xlsx", sheetName);
	  String name = testData.get(rownumber).get("Username");
	  String pwd = testData.get(rownumber).get("Password");	
	  homeobj.entercredentials(name, pwd);
	  homeobj.clickLoginButton();
	  System.out.println("the username is" +name);
	  System.out.println(pwd);
	  
	//  batchobj.getBatchSearchBox().sendKeys(name);
            
	}

	@Then("Error message for invalid username and password {string} is displayed")
	public void error_message_for_invalid_username_and_password_is_displayed(String string) 
	{
	homeobj.verifyinvalidcredentialsErrMsg();
		
	}

	

	@When("Admin enter invalid username from {string} and valid password {int} and clicks login button")
	public void admin_enter_invalid_username_from_and_valid_password_and_clicks_login_button(String sheetName, int rownumber)throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException  {
		ExcelReader excelReader = new ExcelReader();
		  List<Map<String,String>> testData = excelReader.getData("C:\\Users\\kswat\\Desktop\\Team10_lms_ui.xlsx", sheetName);
		  String name = testData.get(rownumber).get("Username");
		  String pwd = testData.get(rownumber).get("Password");	
		  homeobj.entercredentials(name, pwd);
		  homeobj.clickLoginButton();
		  System.out.println("the username is" +name);
		  System.out.println(pwd); 
	}
	@When("Admin enter valid username from {string} invalid password {int} and clicks login button")
	public void admin_enter_valid_username_from_invalid_password_and_clicks_login_button(String sheetName, Integer rownumber) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
		ExcelReader excelReader = new ExcelReader();
		  List<Map<String,String>> testData = excelReader.getData("C:\\Users\\kswat\\Desktop\\Team10_lms_ui.xlsx", sheetName);
		  String name = testData.get(rownumber).get("Username");
		  String pwd = testData.get(rownumber).get("Password");	
		  homeobj.entercredentials(name, pwd);
		  homeobj.clickLoginButton();
		  System.out.println("the username is" +name);
		  System.out.println(pwd); 
	}

	@When("Admin enter valid username {string}, valid password {string} and clicks login button")
	public void admin_enter_valid_username_valid_password_and_clicks_login_button(String string, String string2) {
		commonobj.loginUser();
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
	    
	}
	
	@Then("Error message for invalid username {string} is displayed")
	public void error_message_for_invalid_username_is_displayed(String string) 
	{
		homeobj.verifyUsernameErrMsg();
	}
	
	@Then("Error message for invalid password {string} is displayed")
	public void error_message_for_invalid_password_is_displayed(String string) 
	{
		homeobj.verifyPasswordErrMsg(); 
	}
	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() 
	{
	    homeobj.loginButtoncentered();
	}
	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() 
	{
	    homeobj.verifyloginthroughkeyboard();
	}
	
	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
		homeobj.verifyloginthroughmouse();
	    
	}
	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		homeobj.clickLoginButtondisplayed();
	}


	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
	    //System.out.println(driver.getTitle());
		try {
		Assert.assertTrue(driver.getCurrentUrl().contains("herokuapp"));
		//Assert.assertEquals("LmS",driver.getTitle());
		}
		catch(Exception e)
		{
			
		}
	}

		
	}
	

