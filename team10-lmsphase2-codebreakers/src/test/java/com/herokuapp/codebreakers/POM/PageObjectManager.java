package com.herokuapp.codebreakers.POM;

import org.openqa.selenium.WebDriver;

import com.herokuapp.codebreakers.stepDefinition.User1_AddNewUser;

public class PageObjectManager {

	WebDriver driver;
	LoginPageObjects loginobj;
	DashBoardObjects dashboardobj;
	User1PageObject user1obj;
	User1_AddNewUser User1AddNewUser;
	CommonObjects commonobj;
	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public LoginPageObjects getLoginPageObjects() {
		loginobj= new LoginPageObjects();
		return loginobj;
	}
	
	public DashBoardObjects getDashBoardObjects() {
		dashboardobj= new DashBoardObjects(driver);
		return dashboardobj;
	}
	
	public User1PageObject getUser1PageObjects() {
		user1obj= new User1PageObject(driver);
		return user1obj;
	}
	public CommonObjects getCommonObjects() {
		commonobj = new CommonObjects(driver);
		return commonobj;
	}
}

