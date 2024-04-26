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

	@Given("Admin is on dashboard page after Login and clicks User on the navigation bar")
	public void user_is_on_dashboard_page_after_login_and_clicks_user_on_the_navigation_bar() {
		commonobj.loginUser();
		usersobj.navigateToUser();
	}
	

	@When("Admin clicks on the {string} sort icon by {int} clicks")
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
	}
	
}
