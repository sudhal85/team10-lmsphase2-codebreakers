package com.herokuapp.codebreakers.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	WebDriver driver;
	
	public LoginPageObjects() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
