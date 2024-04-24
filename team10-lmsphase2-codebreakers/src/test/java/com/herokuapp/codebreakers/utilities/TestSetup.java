package com.herokuapp.codebreakers.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.herokuapp.codebreakers.POM.PageObjectManager;
import com.herokuapp.codebreakers.driverManger.DriverManager;

public class TestSetup {

	public WebDriver driver;
	public DriverManager drivermanager;
	public PageObjectManager pageobjectmanager;

	public TestSetup() throws IOException {
		
		drivermanager = new DriverManager();
		pageobjectmanager = new PageObjectManager(drivermanager.getDriverManager());
	}
	
}
