package com.herokuapp.codebreakers.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.herokuapp.codebreakers.utilities.TestSetup;

public class User1PageObject {
WebDriver driver;
	public User1PageObject(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}
	@FindBy(xpath="//span[text()='User']")
		WebElement user1PageLink;
	@FindBy(xpath="//div[text()='Manage User']")
		WebElement ManageUser;
	@FindBy(xpath="//p-table[@datakey='user_id']")
	    WebElement dataTableInUser;
	@FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']")
		WebElement ifDeleteIconIsDisabled;
	@FindBy(xpath="//button[@id='new']//span[@class='p-button-label']")
		WebElement locateAddNewUser;
	@FindBy(xpath="//input[@class='p-inputtext p-component']")
		WebElement searchBox;
	@FindBy(xpath="//table/tbody/tr[1]/td[3]")
		WebElement userNameOnTheResult;
	@FindBy(xpath="//thead//th[4]")
		WebElement tableHeader;


	public void user1PageLink() {
		try {
			user1PageLink.click();
			Assert.assertTrue(driver.getCurrentUrl().contains("user"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	public String assertUserPage() {
		WebElement asserUserPage = null;
		@SuppressWarnings("null")
		String text = asserUserPage.getText();
		return text;
	}
	
	
	public void ManageUser() {
		try {
			user1PageLink.click();
			Assert.assertTrue(driver.getCurrentUrl().contains("manage user"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean checkDataTableIsPresent() {
		boolean isDataTablePresent = dataTableInUser.isDisplayed();
		return isDataTablePresent;
	}
	public boolean isDeleteIconIsDisabled() {
		String value = ifDeleteIconIsDisabled.getAttribute("disabled");
		return value != null;
	}
	
	
	public void clickUserTab() {
	locateAddNewUser.click();
	
}
	public Object clickAddNewUserButton() {
		locateAddNewUser.click();
		return null;
	}
	public boolean isSearchBoxVisible() {
		return searchBox.isDisplayed();
	}
	public String checkUserNameMatchingTheSearch() {
		 return userNameOnTheResult.getText();
	}
	public String enterSearchText(String string) {
		 return userNameOnTheResult.getText();
	}
	public Object checkIfNoResultsForSearch() {
		
		return null;
	}
	public boolean checkUserDetailsDialogBox() {
		
		return null != null;
	}
	public boolean checkTableHeader() {
		
		System.out.println(tableHeader.getText());
		return tableHeader.isDisplayed();
	}
	public boolean ischeckUserDetailsDialogBoxPresent() {
		// TODO Auto-generated method stub
		return false;
	}
	public void clickLogin() {
		WebElement loginBtn = null;
		loginBtn.click();
		
	}
	public void enterLoginPassword() {
		WebElement passwordTxtBox = null;
		CharSequence password = null;
		passwordTxtBox.sendKeys(password);
		
	}
	public void enterLoginID() {
		WebElement usernameTxtBox = null;
		CharSequence username = null;
		usernameTxtBox.sendKeys(username);
		
	}
		
	}

	
	
	
	
