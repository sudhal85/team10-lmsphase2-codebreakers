package com.herokuapp.codebreakers.POM;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	WebDriver driver;
	LoginPageObjects loginobj;
	DashBoardObjects dashboardobj;
	
	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public LoginPageObjects getLoginPageObjects() {
		loginobj= new LoginPageObjects();
		return loginobj;
	}
	
	public DashBoardObjects getDashBoardObjects() {
		dashboardobj= new DashBoardObjects();
		return dashboardobj;
	}
	
}

