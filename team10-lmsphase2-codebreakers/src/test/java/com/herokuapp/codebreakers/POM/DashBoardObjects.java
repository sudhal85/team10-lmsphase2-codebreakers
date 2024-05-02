package com.herokuapp.codebreakers.POM;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashBoardObjects {

WebDriver driver;
	
	public DashBoardObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//**************Manageprogram as header*********************
	@FindBy(xpath="//div[contains(text(),'Manage Program')]")
	WebElement mangeprogram;
	
	public void verifydashboardprogramheader()
	{
		System.out.println(mangeprogram.isDisplayed());
	}
	//******************learning management system***************
	@FindBy(xpath="/html/body/app-root/app-header/mat-toolbar/span[1]")
	WebElement lms;
	
	//*******************************verify the links***************************
	//List <WebElement>links =  
			@FindBy(tagName="span")
			List<WebElement> links;
			//Getting alllinks in one list
			public void processLinks(Integer int1) throws Exception
			{
				int i=0;
				for(WebElement all:links)
				{
					WebElement element = links.get(i);
					
					String url = element.getAttribute("href");
					URL link = new URL(url); 
				      HttpURLConnection httpConn =  
				        (HttpURLConnection) link.openConnection(); 
				      httpConn.connect(); 
				      
				      int code = httpConn.getResponseCode(); 
			          
				      // If The Number Is Greater Than 400,  
				      // Then It Is Broken Link 
				      if(code >= 400) 
				      { 
				        System.out.println("Broken Link: " +  
				                            url); 
				      } 
				      else
				      { 
				        System.out.println("Valid Link: " + url);
				      }
				}
				                
					
			        
			    
				}
			
			
	
	
	public void verifylmstitlealignment() 
	{
		//WebElement titleElement = driver.findElement(By.xpath("/html/body/app-root/app-header/mat-toolbar/span[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println(js.executeScript("arguments[0].style.textAlign ='left';", lms));
		//Assert.assertEquals(lms, center);
	}
	
	//*************************
	@FindBy(xpath="/html/body/app-root/app-header/mat-toolbar" )
	WebElement navigationbar;
	public void navigationBar() 
	{
		System.out.println(navigationbar.getText());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String alignment = (String) js.executeScript("return window.getComputedStyle(arguments[0]).getPropertyValue('text-align');", navigationbar);
		if (alignment.equals("right")) {
            System.out.println("Navigation bar is aligned to the right.");
        } else {
            System.out.println("Navigation bar is not aligned to the right.");
        }

	}
	//
	@FindBy(xpath="/html/body/app-root/app-header/mat-toolbar" )
	WebElement navigationbarspelling;
	public void correctSpelling()
	{
		try {
		String navigationBarText = navigationbarspelling.getText();
		 String expectedSpelling = "LMS,program,batch,user,logout"
		 		+ "";
		 assert navigationBarText.contains(expectedSpelling) : "Navigation bar text does not have correct spelling.";

         System.out.println("Navigation bar text has correct spelling.");
     } catch (AssertionError e) {
         System.out.println(e.getMessage());
     } catch (Exception e) {
         System.out.println("An error occurred: " + e.getMessage());
     } 
	}
	
	
	//****************Program*********************
	@FindBy(xpath="//*[@id='program]")
	WebElement pgm;
	
	public void  clickprogram()
	{
		pgm.click();
	}
	public void  verifyprogrampageopened() 
	{
		System.out.println("program page url" + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("program"));
	
	}
	
	//***********************Batch**********************
	@FindBy(xpath="//*[@id='batch']")
	WebElement bat;
	public void  clickbatch()
	{
		bat.click();
	}
	public void  verifybatchpageopened() 
	{
		System.out.println("batch page url" + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("batch"));
	
	}
	//*****************User**************
	@FindBy(xpath="//*[@id=\"user\"]")
	WebElement usr;
	
	public void  clickuser()
	{
		usr.click();
	}
	public void  verifyuserpageopened() 
	{
		System.out.println("user page url" + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("user"));
	
	}
	
	
	//******************Logout********************
	@FindBy(xpath="//*[@id=\"logout\"]/span[1]")
	WebElement lgout;
	
	public void  logout()
	{
		lgout.click();
	}
	public void  verifylogoutpageopened() 
	{
		System.out.println("logout page url" + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	
	}
	
	
}
