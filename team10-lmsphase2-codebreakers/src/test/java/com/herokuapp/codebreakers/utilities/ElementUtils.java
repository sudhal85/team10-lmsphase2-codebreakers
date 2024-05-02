package com.herokuapp.codebreakers.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils 
{
	public static WebElement waitForElementClickable(WebDriver driver, WebElement element, long durationInSeconds) 
	{
		WebElement webElement = null;
		try
		{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
				webElement=wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e) 
		{
				LoggerLoad.error("The element "+element.toString() +" may not be clickable. Exception is: "+e.getMessage());
		}		
			return webElement;
	}
	
	public static WebElement waitForElementVisibility(WebDriver driver, WebElement element, long durationInSeconds) 
	{
		WebElement webElement = null;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement=wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e) 
		{
				LoggerLoad.error("The element "+element.toString() +" may not be visible. Exception is: "+e.getMessage());
		}		
			return webElement;
	}
	
	public static void implicitPageWait(WebDriver driver)
	{	

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.IMPLICIT_PAGE_LOAD));

    }
	
	public static WebElement moveToElementAndClick(WebDriver driver, WebElement element, long durationInSeconds)
	{
		WebElement webElement = null;
		Actions action = new Actions(driver);
		action.moveToElement(element).click();
		return webElement;
	}
	
	public static void explicitPageWait(WebDriver driver)
	{	

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.EXPLICIT_ELEMENT_WAIT_TIME));

    }
	
}
