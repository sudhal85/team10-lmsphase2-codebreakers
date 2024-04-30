package com.herokuapp.codebreakers.POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User1_EditUser {
	WebDriver driver;

	public User1_EditUser(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	

	@FindBy(xpath="//button[@class='p-button-rounded p-button-success p-button p-component p-button-icon-only']")
	List<WebElement> editButtonInDataTable;
	
	@FindBy(xpath="//tr[1]//button[@class='p-button-rounded p-button-success p-button p-component p-button-icon-only']")
	WebElement firstEditInDataTable;
	
	@FindBy(xpath="//button[@class=\"p-button-rounded p-button-danger p-button p-component p-button-icon-only\"]")
	List<WebElement> deleteButtonInDataTable;
	
	@FindBy(xpath="//div[@class='ng-tns-c132-6 p-dialog-content']")
	WebElement dialogBoxUserDetails;
	
	public boolean isEditButtonVisibleInDataTable() {
	
		int count=0;
		for(WebElement i : editButtonInDataTable) {
				if(i.isDisplayed())  {
					count++;
				}
				
		}
		if(count==editButtonInDataTable.size())
			return true;
		else
			return false;
					
	}
	
	public boolean isDeleteButtonVisibleInDataTable() {
		
		int count=0;
		for(WebElement i : deleteButtonInDataTable) {
				if(i.isDisplayed())  {
					count++;
				}
				
		}
		if(count==deleteButtonInDataTable.size())
			return true;
		else
			return false;
					
	}
	
	public boolean ischeckUserDetailsDialogBoxPresent() {
	//	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(2000));
//        w.until(ExpectedConditions.visibilityOf(dialogBoxUserDetails));
		boolean isPresent = false;
		try {
			isPresent = dialogBoxUserDetails.isDisplayed();
		} catch (Exception e) {
			isPresent = false;
		}
		return isPresent;
	}
	
	public void clickfirstEditButtonOnRight() {
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(2000));
		w.until(ExpectedConditions.visibilityOf(firstEditInDataTable));
		firstEditInDataTable.click();
	}
}
