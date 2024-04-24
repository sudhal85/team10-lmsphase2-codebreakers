package com.herokuapp.codebreakers.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashBoardObjects {

WebDriver driver;
	
	public DashBoardObjects() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
