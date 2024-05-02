package com.herokuapp.codebreakers.POM;

import org.openqa.selenium.WebDriver;

import com.herokuapp.codebreakers.utilities.ExcelReader;

public class PageObjectManager {

	WebDriver driver;
	HomePageObjects homeobj;
	DashBoardObjects dashboardobj;
	ExcelReader excelreaderobj;
	CommonObjects commonobj;
	
	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public ExcelReader getExcelReaderObjects() {
		excelreaderobj = new ExcelReader();
		return excelreaderobj;
	}
	
	public CommonObjects getCommonObjects() {
		commonobj = new CommonObjects(driver);
		return commonobj;
	}

	public HomePageObjects getHomePageObject() {
		homeobj= new HomePageObjects(driver);
		return homeobj;
	}
	
	public DashBoardObjects getDashBoardObjects() {
		dashboardobj= new DashBoardObjects(driver);
		return dashboardobj;
	}
	
}

