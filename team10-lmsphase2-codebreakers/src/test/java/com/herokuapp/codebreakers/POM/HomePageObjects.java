package com.herokuapp.codebreakers.POM;

import static org.testng.Assert.assertEquals;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.herokuapp.codebreakers.utilities.ConfigReader;

public class HomePageObjects {

	WebDriver driver;
	
	public HomePageObjects(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
//************************************Username*************************************************************
	@FindBy(xpath="//input[@id='username']") 
	WebElement usernameTxtBox;
	@FindBy(id="mat-form-field-label-1") 
	WebElement usernametext;
	@FindBy(id="mat-error-0") WebElement 
	errMsgUsernameField;
	
	

	//Enter values in username field
	public void enterUsername(String Username){
		usernameTxtBox.click();
		usernameTxtBox.sendKeys(Username);
	}
	//Locator for error message
	@FindBy(id="errormessage") WebElement invalidCredentialsErrMsg;
	
	//locator for image
	@FindBy(xpath="//img[@class='images']")
	WebElement image;
	
	//Verify the image diplayed on leftside
	public void verifyimagedisplayed() 
	{
		System.out.println(image.isDisplayed());
	}

	//Verifying the text above username field
	public void verifyUsernametext(){
		usernameTxtBox.click();
		String actualUsernametext=usernametext.getText();
		System.out.println("Verifying the User* text above username field: " +actualUsernametext);
		String expectedUsernameText= "User *";
		assertEquals(expectedUsernameText, actualUsernametext);	
	}


	//Verifying the error message below the username field
	public void verifyUsernameErrMsg(){
            
			String actualErrMsgUsernameField=errMsgUsernameField.getText();
			System.out.println("Verifying the error message below the username field: " +actualErrMsgUsernameField);
			String expectedErrMsgUsernamefield= "Please enter your user name";
			assertEquals(expectedErrMsgUsernamefield, actualErrMsgUsernameField);
	}


//************************************Password*******************************************************************
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordTxtBox;
		@FindBy(id="mat-form-field-label-3") WebElement passwordtext;
		@FindBy(id="mat-error-0") WebElement errMsgPasswordField;
		
	//Enter values in password field
	public void enterPassword( String Password)
	{
		passwordTxtBox.click();
		passwordTxtBox.sendKeys(Password);
	}
		
	//Verifying the text above password field
	public void verifyPasswordtext(){		
			passwordTxtBox.click();
		String actualpasswordtext= passwordtext.getText();
		System.out.println("Verifying the Password* text above username field: " +actualpasswordtext);
		    String expectedpasswordText= "Password *";
		    assertEquals(expectedpasswordText, actualpasswordtext);		
	}
		
		
	//Verifying the error message below the password field
	public void verifyPasswordErrMsg(){
			
		String actualErrMsgPasswordField= errMsgPasswordField.getText();
			System.out.println("Verifying the error message below the username field: " +actualErrMsgPasswordField);
		String expectedErrMsgPasswordfield= "Please enter your password";
		assertEquals(expectedErrMsgPasswordfield, actualErrMsgPasswordField);		
	}	
	
	
//************************************Login Button*******************************************************
	
	@FindBy(xpath="//button[@id='login']") 
	WebElement loginButton ;
	
	//verify if the login button is displayed
	//assertTrue("Login button is not displayed",loginButton.isDisplayed());
	//Click on login button
	public void clickLoginButton(){
		loginButton.click();
	}
	public void entercredentials(String name,String pwd) 
	{
		usernameTxtBox.click();
		usernameTxtBox.sendKeys(name);
		passwordTxtBox.click();
		passwordTxtBox.sendKeys(pwd);
		
		
	}
	public void clickLoginButtondisplayed(){
		boolean b=loginButton.isDisplayed();
		System.out.println(b);
	}
	public void loginButtoncentered() 
	{
		String actaulbuttonposition=loginButton.getCssValue("position");
		System.out.println("button position is: "+actaulbuttonposition);
		String Expectedposition="center";
		assertEquals(Expectedposition,actaulbuttonposition);
		
	}
	
	
	
//**********************************Please login to LMS application-Text************************************
		
	@FindBy(xpath="//p[text()='Please login to LMS application']") 
	WebElement displaytextLoginSection ;
				
	//Verifying the text
	public void VerifyTextinloginSection(){
		String ActualText=displaytextLoginSection.getText();
		String ExpectedText="Please login to LMS application";
		assertEquals(ExpectedText,ActualText);
	}
	//**************************Invalid username and invalid password************************
	public void verifyinvalidcredentialsErrMsg(){
		String ActualInvalidCredErrMsg=invalidCredentialsErrMsg.getText();
			String ExpectedInvalidCredErrMsg="Invalid username and password Please try again";
			assertEquals(ExpectedInvalidCredErrMsg, ActualInvalidCredErrMsg);

		}
	public void verifyloginthroughkeyboard()
	{
		String username=ConfigReader.getProperty("username");
		String password=ConfigReader.getProperty("password");
		usernameTxtBox.sendKeys(username);
		passwordTxtBox.sendKeys(password);
		passwordTxtBox.sendKeys(Keys.ENTER);
	}
	public void verifyloginthroughmouse()
	{
		String username=ConfigReader.getProperty("username");
		String password=ConfigReader.getProperty("password");
		usernameTxtBox.sendKeys(username);
		passwordTxtBox.sendKeys(password);
		Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).click().perform();
	}
	
	//*******************************verifybroken links***********************
//	@FindBy(tagName="span") 
//	List<WebElement> links;
// 
//	public void verifyBrokenLinks()
//	{ 
//		
//	 for (WebElement link : links) {
//	            String url = link.getAttribute("href");
//	            if (url != null) {
//	                try {
//	                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//	                    connection.setRequestMethod("HEAD");
//	                    connection.connect();
//	                    int responseCode = connection.getResponseCode();
//	                    if (responseCode >= 400) {
//	                        System.out.println("Broken link found: " + url);
//	                    }
//	                } catch (Exception e) {
//	                    e.printStackTrace();
//	                }
//	}
	//***********************************************verify spelling***********************************
	@FindBy(tagName = "body")
	WebElement completebody;
	
	public void verifySpelling(){
	try {	
	String pageText	=completebody.getText();
	String expectedWord="program";
	boolean spellingcorrect=pageText.contains(expectedWord);
	assertEquals(true,spellingcorrect);
	}catch(Exception e)
	{
		
	}
}
 
}
