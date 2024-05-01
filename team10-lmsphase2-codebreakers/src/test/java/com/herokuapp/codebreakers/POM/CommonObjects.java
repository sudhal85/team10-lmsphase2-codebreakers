package com.herokuapp.codebreakers.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.codebreakers.utilities.ConfigReader;

public class CommonObjects {

	WebDriver driver;
	
	public CommonObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='username']")
	WebElement usernameTxtBox;
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordTxtBox;
	@FindBy(xpath="//button[@id='login']")
	WebElement loginBtn;
	@FindBy(xpath="//*[@id=\"program\"]/span[1]")
	WebElement programLink;

	public void loginUser() {
		String username=ConfigReader.getProperty("username");
		String password=ConfigReader.getProperty("password");
		usernameTxtBox.sendKeys(username);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
			
	}
	public void manageProgram()
	{
		programLink.click();
	}
}
