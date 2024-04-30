package com.herokuapp.codebreakers.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;

public class user1_AddNewUser {
	WebDriver driver;
	public user1_AddNewUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//button[@label='Add New User']")
		WebElement locateAddNewUser;
	@FindBy(xpath="//div[@class='ng-tns-c132-6 p-dialog-content']")
		WebElement dialogBoxUserDetails;
	@FindBy(xpath="//mat-card-actions//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-warn']")
		WebElement cancelButtoninUserDetailsAlert;
	@FindBy(xpath = "//span[@class='p-dialog-title ng-tns-c132-6 ng-star-inserted']")
		WebElement headinginUserDetails;
	@FindBy(xpath="//div[@class='ng-trigger ng-trigger-animation ng-tns-c132-37 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']")
		WebElement userDetailsALertBox;
	@FindBy(xpath="//button[@class='ng-tns-c132-6 p-dialog-header-icon p-dialog-header-close p-link p-ripple ng-star-inserted']")
		WebElement closeButtonOnUserDetailsALert;
	@FindBy(xpath="//mat-card-actions//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']")
		WebElement submitButtoninUserDetailsAlert;
	@FindBy(xpath = "//div[@class='ng-trigger ng-trigger-animation ng-tns-c132-6 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']//input")
		List<WebElement> inputElementsInUserDetailsBox;
	@FindBy(xpath = "//div[@class='ng-trigger ng-trigger-animation ng-tns-c132-6 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']")
		WebElement userDetailsDialogBox;
	@FindBy(xpath="//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c148-17 ng-star-inserted']")
		WebElement dropDownState;
	@FindBy(xpath="//div[@role='listbox']")
		WebElement dropDownStateList;
	@FindBy(xpath="//div[@role='listbox']")
		WebElement dropDownRoleList;
	@FindBy(xpath="//form/mat-card/mat-card-content/div[4]/div/button")
		WebElement address2ButtonInUserDetailsAlert;
	@FindBy(xpath="//mat-card-content/div[4]/div/button/span[1]")
		WebElement address2TextBoxInUserDetailsAlert;
	
	
	public boolean checkPresenceOfAddNewUserButton() {
		return locateAddNewUser.isDisplayed();
	}

	public void clickAddNewUserButton() {
		
		locateAddNewUser.click();
	}
	
	public boolean checkUserDetailsDialogBox() {
		
		return dialogBoxUserDetails.isDisplayed();
	}

	public boolean ischeckUserDetailsDialogBoxPresent() {
	//	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		boolean isPresent = false;
		try {
			isPresent = dialogBoxUserDetails.isDisplayed();
		} catch (Exception e) {
			isPresent = false;
		}
		return isPresent;
	}
	
	
	
	public boolean isCancelButtonPresentInUserDetailsAlert() {
		boolean isVisible = cancelButtoninUserDetailsAlert.isDisplayed();
		return isVisible;
	}
	
	public boolean validateHeadingInUserDetailsAlert() {
		boolean isVisible = headinginUserDetails.isDisplayed();
		return isVisible;
	}
	
	public void clickCancelButtonOnuserDetailsAlert() {
		cancelButtoninUserDetailsAlert.click();
	}
	
	public boolean isUserDetailsVisible() {
		boolean value = userDetailsALertBox.isDisplayed();
		return value;
	}
	
	
	@SuppressWarnings("deprecation")
	public boolean isCloseButtonOnUserDetailsALertVisible() {
	//WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2000))
				//.until(ExpectedConditions.visibilityOf(closeButtonOnUserDetailsALert));
		//driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		boolean value = false;
		try {
			Thread.sleep(2000);
			value = closeButtonOnUserDetailsALert.isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return value;
		
	}
	
	public void clickCloseButtononUserDetailsAlert()
	
	{
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2000))
				.until(ExpectedConditions.visibilityOf(closeButtonOnUserDetailsALert));
		element.click();
	}
	
	public boolean isSubmitButtoninUserDetailsAlert() {
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2000))
				.until(ExpectedConditions.visibilityOf(submitButtoninUserDetailsAlert));
		boolean value = element.isDisplayed();
		return value; 
	}
	
	public boolean validateInputElementsinUserDetailsDialogBox() throws Exception {
		//WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2000))
				//.until(ExpectedConditions.visibilityOf(inputElementsInUserDetailsBox.get(0)));
		Thread.sleep(2000);
		int size = inputElementsInUserDetailsBox.size();
		int elementsToBePresent = 0;
		if(size == elementsToBePresent)
			return true;
		else
			return false;
	}
	
	
	public boolean validatePlaceHolderInUserDetailsBox() {
		
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3000))
				.until(ExpectedConditions.visibilityOf(userDetailsDialogBox));
		
	String placeHolder =inputElementsInUserDetailsBox.get(0).getAttribute("ng-reflect-placeholder");
	if(placeHolder.equals("First name")){
		return true;
	}
	
	else
		return false;
	}
	
	public void clickDropDownState() {
		dropDownState.click();
	}
	public boolean isDropDownStateListVisible() {
		boolean value = dropDownStateList.isDisplayed();
		return value;
	}
	
	public void clickDropDownRoleList() {
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3000))
				.until(ExpectedConditions.visibilityOf(dropDownRoleList));
		
		element.click();
	}
	
	public boolean isDropDownRoleListEnabled() {
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2000))
				.until(ExpectedConditions.visibilityOf(dropDownRoleList));
		
		boolean value = element.isEnabled();
		return value;
	}
	
	public boolean isAddress2TextBoxInUserDetailsVisible() {
		//WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2000))
				//.until(ExpectedConditions.visibilityOf(address2TextBoxInUserDetailsAlert));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return address2TextBoxInUserDetailsAlert.isDisplayed();
	}
	
	
	public void clickAddress2LinkInUserDetails() {
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2000))
				.until(ExpectedConditions.visibilityOf(address2ButtonInUserDetailsAlert));
		element.click();
	}
	
	public void enterAllDetails() {
		String[] data = {"David", "D","Morgan","davidmorgan@gmail.com","88888888","1St Street","BD","NJ","a","b","c"};
		int j=0;
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3000))
				.until(ExpectedConditions.visibilityOf(userDetailsDialogBox));
		for(WebElement i:inputElementsInUserDetailsBox ) {
			if(j < data.length) {
				i.sendKeys(data[j]);
			}
			j++;}
		}
	
	}
	
	
	

