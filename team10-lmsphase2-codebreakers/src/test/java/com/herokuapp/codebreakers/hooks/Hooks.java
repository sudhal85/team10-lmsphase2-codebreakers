package com.herokuapp.codebreakers.hooks;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.herokuapp.codebreakers.utilities.TestSetup;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {

	private WebDriver driver;
	public TestSetup testup;
	Properties prop;

	public Hooks(TestSetup testup) throws IOException {

		this.testup = testup;
		this.driver = testup.drivermanager.getDriverManager();
	}


	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

}
