package com.herokuapp.codebreakers.POM;

import org.openqa.selenium.WebDriver;


import com.herokuapp.codebreakers.utilities.ExcelReader;


public class PageObjectManager {

	WebDriver driver;
	HomePageObjects homeobj;
	DashBoardObjects dashboardobj;
	LoginPageObjects loginobj;

	ExcelReader excelreaderobj;
	CommonObjects commonobj;

	ProgramPageObjects programobj;


	BatchPageObjects batchobj;

	UsersObjects usersobj;

	
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
	public LoginPageObjects getLoginPageObjects() {
		loginobj= new LoginPageObjects(driver);
		return loginobj;

	}
	
	public DashBoardObjects getDashBoardObjects() {
		dashboardobj= new DashBoardObjects(driver);
		return dashboardobj;
	}


	public ProgramPageObjects getProgramPageObjects() {
		
		programobj = new ProgramPageObjects(driver);
		return programobj;
	}


	public BatchPageObjects getBatchObjects() {
		batchobj = new BatchPageObjects(driver);
		return batchobj;

	}
	

	public UsersObjects getUsersObjects() {
		usersobj = new UsersObjects(driver);
		return usersobj;
	}

}

