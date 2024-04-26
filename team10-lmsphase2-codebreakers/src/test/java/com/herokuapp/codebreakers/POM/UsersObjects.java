package com.herokuapp.codebreakers.POM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UsersObjects {
WebDriver driver;
	
	public UsersObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@id='user']")
	private WebElement userLink;
	
	@FindBy(xpath="//th[@psortablecolumn='userId']")
	private WebElement idSort;
	
	@FindBy(xpath="//th[@psortablecolumn='userFirstName']")
	private WebElement nameSort;
	
	
	@FindBy(xpath="//th[@psortablecolumn='userLocation']")
	private WebElement locationSort;
	
	@FindBy(xpath="//th[@psortablecolumn='userPhoneNumber']")
	private WebElement phoneNoSort;
	
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']/tr")
	private WebElement itemsOnPage;
	
	String paginationXpath ="//span[@class='p-paginator-pages ng-star-inserted']/button";
	
	@FindBy(xpath="//p-paginator[@styleclass='p-paginator-bottom']/div/span[2]/button")
	private WebElement pagination;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-right']/..")
	private WebElement nextPageButton;
	
	public void clickUserLink() {
		userLink.click();
	}
	
	public void navigateToUser() {
		try {
			userLink.click();
			Assert.assertTrue(driver.getCurrentUrl().contains("user"));
//			LOG.info("Admin has landded on Manage User Page");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//		 public List<String> sortingAescending(String columnHeading) {
//				
//				int columnIndex = -1;
//				List<String> aescendingOriginalList = new ArrayList<>();
//								 
//				WebElement columnHeadingElement = driver.findElement(By.xpath("//th[contains(text(),'"+columnHeading  +" ')]"));
//				columnHeadingElement.click();
//				
//				if(columnHeading.contains("ID")) {
//					 columnIndex = 2 ;
//				} else if (columnHeading.contains("Name")){
//					columnIndex = 3;
//				}else if (columnHeading.contains("Location")){
//					columnIndex = 4;
//				}else if(columnHeading.contains("Phone Number")){
//					columnIndex = 5;
//				}
//								 
//				 do {
//				 List<WebElement> itemlist = driver.findElements(By.xpath("//tr/td["+ columnIndex +"]"));
//				 List<String> pageItems = itemlist.stream().map(a->a.getText().toLowerCase()).collect(Collectors.toList());
//				 aescendingOriginalList.addAll(pageItems);
//		
//				 if(nextPageButton.isEnabled()) {
//					 nextPageButton.click();
//				 } else {
//					 break;
//				 }
//
//				 } while (true);
//				 
//				 return aescendingOriginalList;
//	}	 
//	
//		 public List<String> sortingDescending(String columnHeading) {
//				
//				int columnIndex = -1;
//				List<String> descendingOriginalList = new ArrayList<>();
//								 
//				WebElement columnHeadingElement = driver.findElement(By.xpath("//th[contains(text(),'"+columnHeading  +" ')]"));
//				columnHeadingElement.click();
//				columnHeadingElement.click();
//				
//				if(columnHeading.contains("ID")) {
//					 columnIndex = 2 ;
//				} else if (columnHeading.contains("Name")){
//					columnIndex = 3;
//				}else if (columnHeading.contains("Location")){
//					columnIndex = 4;
//				}else if(columnHeading.contains("Phone Number")){
//					columnIndex = 5;
//				}
//								 
//				 do {
//				 List<WebElement> itemlist = driver.findElements(By.xpath("//tr/td["+ columnIndex +"]"));
//				 List<String> pageItems = itemlist.stream().map(a->a.getText().toLowerCase()).collect(Collectors.toList());
//				 descendingOriginalList.addAll(pageItems);
//		
//				 if(nextPageButton.isEnabled()) {
//					 nextPageButton.click();
//				 } else {
//					 break;
//				 }
//
//				 } while (true);
//				 
//				 return descendingOriginalList;
//	}	 
	
		 public List<String> sorting(String columnHeading,int clickCount) {
				
				int columnIndex = -1;
				List<String> originalList = new ArrayList<>();
								 
				WebElement columnHeadingElement = driver.findElement(By.xpath("//th[contains(text(),'"+columnHeading  +" ')]"));
				for(int i =0; i<clickCount;i++) {
					columnHeadingElement.click();
				}
				
								
				if(columnHeading.contains("ID")) {
					 columnIndex = 2 ;
				} else if (columnHeading.contains("Name")){
					columnIndex = 3;
				}else if (columnHeading.contains("Location")){
					columnIndex = 4;
				}else if(columnHeading.contains("Phone Number")){
					columnIndex = 5;
				}
								 
				 do {
				 List<WebElement> itemlist = driver.findElements(By.xpath("//tr/td["+ columnIndex +"]"));
				 List<String> pageItems = itemlist.stream().map(a->a.getText().toLowerCase()).collect(Collectors.toList());
				 originalList.addAll(pageItems);
		
				 if(nextPageButton.isEnabled()) {
					 nextPageButton.click();
				 } else {
					 break;
				 }

				 } while (true);
				 
				 return originalList;
	}	 
}
