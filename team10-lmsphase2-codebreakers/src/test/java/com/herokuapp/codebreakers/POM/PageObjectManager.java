package com.herokuapp.codebreakers.POM;

import org.openqa.selenium.WebDriver;


public class PageObjectManager {

	WebDriver driver;
	LoginPageObjects loginobj;
	DashBoardObjects dashboardobj;
	CommonObjects commonobj;

	BatchPageObjects batchobj;

	UsersObjects usersobj;

	
	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public LoginPageObjects getLoginPageObjects() {
		loginobj= new LoginPageObjects(driver);
		return loginobj;
	}
	
	public DashBoardObjects getDashBoardObjects() {
		dashboardobj= new DashBoardObjects(driver);
		return dashboardobj;
	}
	public CommonObjects getCommonObjects() {
		commonobj = new CommonObjects(driver);
		return commonobj;
	}

	public BatchPageObjects getBatchObjects() {
		batchobj = new BatchPageObjects(driver);
		return batchobj;
	}
	

	public UsersObjects getUsersObjects() {
		usersobj = new UsersObjects(driver);
		return usersobj;
	}

}

