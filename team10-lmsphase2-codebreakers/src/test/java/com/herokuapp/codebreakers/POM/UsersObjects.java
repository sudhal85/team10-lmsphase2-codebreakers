package com.herokuapp.codebreakers.POM;

import java.time.Duration;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UsersObjects {
	WebDriver driver;

	public UsersObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='user']")
	private WebElement userLink;

	@FindBy(xpath = "//th[@psortablecolumn='userId']")
	private WebElement idSort;

	@FindBy(xpath = "//th[@psortablecolumn='userFirstName']")
	private WebElement nameSort;

	@FindBy(xpath = "//th[@psortablecolumn='userLocation']")
	private WebElement locationSort;

	@FindBy(xpath = "//th[@psortablecolumn='userPhoneNumber']")
	private WebElement phoneNoSort;

	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr")
	private WebElement itemsOnPage;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']/..")
	private WebElement nextPageButton;
	//span[@class='p-button-icon pi pi-trash']/.. = rowDeleteButton

	@FindBy(xpath="//span[@class='pi pi-times ng-tns-c133-9']/..")
	WebElement alertCloseBtn;
	
	@FindBy(xpath="//span[normalize-space()='No']")
	WebElement alertNoBtn;
	@FindBy(xpath="//span[normalize-space()='Yes']")
	WebElement alertYesBtn;
	@FindBy(xpath="//div[@class='p-toast-detail ng-tns-c90-10']/..")
	private WebElement msgDeleteSuccess;
	@FindBy(xpath="//div[@class='p-toast-summary ng-tns-c90-10']/..")
	private WebElement msgUserDelete;

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
	@FindBy(xpath="//span[contains(text(),'Yes')]/..")
     private WebElement deleteYesBtn;
	@FindBy(xpath="//span[contains(text(),'No')]/..")
    private WebElement deleteNoBtn;
	@FindBy(xpath="//span[contains(text(),'Confirm')]/..")
    private WebElement deleteConfirmMsg;
	@FindBy(xpath = "//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only'] ")   
	WebElement rowDeleteButton;
	@FindBy(xpath="//p-confirmdialog/div/div/div[1]/div/button")
	private WebElement deleteCloseIcon;
	
	public void clickDeleteCloseIcon() {
		deleteCloseIcon.click();
	}
	public void clickRowDeleteButton() {
		rowDeleteButton.click();
	}
	public void clickNoBtnInDeleteAlert() {
		deleteNoBtn.click();
	}
	public void validateRowDeleteBtn() {
		Assert.assertTrue(deleteYesBtn.isEnabled(), "Yes button is disabled for assign student popup");
		Assert.assertTrue(deleteNoBtn.isEnabled(), "No button is disabled for assign student popup");
		Assert.assertEquals(deleteConfirmMsg.getText(), "Confirm",
				"Confirm heading is not present in the student popup");
		System.out.println("Is  Yes button in Delete popup window enabled? " + deleteYesBtn.isEnabled());
		
	}
	
	
  
	@FindBy(xpath="//p-confirmdialog/div/div")
	private WebElement deletePopupWindow;
	
	public void validateNoBtnInDeletionAlert() {
		clickNoBtnInDeleteAlert();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
		 
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("deletePopupWindow")));
			System.out.println("Deletion alert disappeared successfully");
		}catch (NoSuchElementException  e) {
		    System.out.println("Deletion alert was not found or is stale.");
		}
	}
	
	public void validateCloseIconInDeletionAlert() {
		clickDeleteCloseIcon();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("deletePopupWindow")));
		 if(!popupAlertDeletionExists(driver)) {
			 System.out.println("Popup window closes after clicking No button.");
		 }else {
	            System.out.println("Popup window is still present.");
	        }
	}
	
	public static boolean popupAlertDeletionExists(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//p-confirmdialog/div/div"));
			return true;
		} catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
		
	}
	public List<String> sorting(String columnHeading, int clickCount) {

		int columnIndex = -1;
		List<String> originalList = new ArrayList<>();

		WebElement columnHeadingElement = driver
				.findElement(By.xpath("//th[contains(text(),'" + columnHeading + " ')]"));
		for (int i = 0; i < clickCount; i++) {
			columnHeadingElement.click();
		}

		if (columnHeading.contains("ID")) {
			columnIndex = 2;
		} else if (columnHeading.contains("Name")) {
			columnIndex = 3;
		} else if (columnHeading.contains("Location")) {
			columnIndex = 4;
		} else if (columnHeading.contains("Phone Number")) {
			columnIndex = 5;
		}

		do {
			List<WebElement> itemlist = driver.findElements(By.xpath("//tr/td[" + columnIndex + "]"));
			List<String> pageItems = itemlist.stream().map(a -> a.getText().toLowerCase()).collect(Collectors.toList());
			originalList.addAll(pageItems);

			if (nextPageButton.isEnabled()) {
				nextPageButton.click();
			} else {
				break;
			}

		} while (true);

		return originalList;
	}

	
//	checkDelete = driver.findElement(By.xpath(String.format("//tr/td[contains(text(),'%s')]/../td[1]", id)));
	public void delete1(String alertAction, List<String> UserID) throws InterruptedException {
		List<String> ids = new ArrayList<>(UserID);
		Collections.sort(ids);
		idSort.click();
		List<String> originalList =sorting("ID",2);
		int index = 0;
		boolean gotoNextPage = false;
		
		do {
			for (int i = index; i < ids.size(); i++) {
				String id = ids.get(i);
				try {
					System.out.println(id);
					WebElement chkbox=driver.findElement(By.xpath("//tr/td[contains(text(),'" + id + "')]//preceding-sibling::td[1]"));
					chkbox.click();
					WebElement deleteBtn=driver.findElement(By.xpath("//tr/td[contains(text(),'" + id + "')]//following-sibling::td[4]//button[2]"));
					deleteBtn.click();
					if (alertAction.equalsIgnoreCase("yes")) {
						alertYesBtn.click();
						Assert.assertEquals(msgDeleteSuccess.getText(), "Successful","Actual message is not matching with expected");
						Assert.assertEquals(msgUserDelete.getText(),"User Deleted","Actual message is not matching with expected");
						Assert.assertTrue(!originalList.contains(id));
					} else if(alertAction.equalsIgnoreCase("no")) {
	                	alertNoBtn.click();
	                	
	                	
	                	
	                }else if(alertAction.equalsIgnoreCase("close")) {
					    alertCloseBtn.click();
	                }
					
				} catch (NoSuchElementException ex) {
					 gotoNextPage = true;
		                break;
				}
				index++;
			}
			
			 if (gotoNextPage && index< ids.size()) {
		            if (nextPageButton.isEnabled()) {
		            	nextPageButton.click();
		            } else {
		                  break;
		            }
		        }
			 if(index == ids.size())
		        	break;
		    } while (gotoNextPage || !ids.isEmpty());
		
	}

	public void singleUserDeleteInRow1(String alertAction, List<String> UserID) throws InterruptedException {
		List<String> ids = new ArrayList<>(UserID);
		Collections.sort(ids);
		idSort.click();
//		List<String> originalList = sorting("ID", 2);
		int index = 0;
		boolean gotoNextPage = false;
		do {
			for (int i = index; i < ids.size(); i++) {
				String id = ids.get(i);
				try {
					System.out.println(id);
					WebElement chkbox = driver.findElement(By.xpath("//tr/td[contains(text(),'" + id + "')]//preceding-sibling::td[1]"));
					chkbox.click();
					WebElement deleteBtn = driver.findElement(By.xpath("//tr/td[contains(text(),'" + id + "')]//following-sibling::td[4]//button[2]"));
					deleteBtn.click();
					if (alertAction.equalsIgnoreCase("yes")) {
						alertYesBtn.click();
						Assert.assertEquals(msgDeleteSuccess.getText(), "Successful",
								"Actual message is not matching with expected");
						Assert.assertEquals(msgUserDelete.getText(), "User Deleted",
								"Actual message is not matching with expected");
//						Assert.assertTrue(!originalList.contains(id));
					} else if (alertAction.equalsIgnoreCase("no")) {
						alertNoBtn.click();
					} else if (alertAction.equalsIgnoreCase("close")) {
						alertCloseBtn.click();
					}

				} catch (NoSuchElementException ex) {
					gotoNextPage = true;
					break;
				}
				index++;
			}

			if (gotoNextPage && index < ids.size()) {
				if (nextPageButton.isEnabled()) {
					nextPageButton.click();
				} else {
					break;
				}
			}
			if (index == ids.size())
				break;
		} while (gotoNextPage || !ids.isEmpty());

	}
	public void singleUserDeleteInRow(String alertAction, List<String> UserID) throws InterruptedException {
		List<String> ids = new ArrayList<>(UserID);
		List<String> originalList = sorting("ID", 2);
		Collections.sort(ids);
		idSort.click();
		boolean gotoNextPage = false;
		WebElement deleteBtn = null;
		int index =0;
		do {
			for (int i = index; i < ids.size(); i++) {
				String id = ids.get(i);
				try {
					WebElement chkbox=driver.findElement(By.xpath("//tr/td[contains(text(),'" + id + "')]//preceding-sibling::td[1]"));
					chkbox.click();
					deleteBtn=driver.findElement(By.xpath("//tr/td[contains(text(),'" + id + "')]//following-sibling::td[4]//button[2]"));
					deleteBtn.click();
					if (alertAction.equalsIgnoreCase("yes")) {
						alertYesBtn.click();
						System.out.println("msgDeleteSuccess is "+msgDeleteSuccess.getText());
						String actualMsg =msgDeleteSuccess.getText().trim();
						String expectedMessage = "Successful\nUser Deleted".trim();
//						Assert.assertEquals(actualMsg, expectedMessage, "Actual message is not matching with expected");
//						Assert.assertEquals(msgDeleteSuccess.getText(), "Successful\r\n"
//								+ "User Deleted",
//								"Actual message is not matching with expected");
//						Assert.assertEquals(msgUserDelete.getText(), "User Deleted",
//								"Actual message is not matching with expected");
						Assert.assertTrue(!originalList.contains(id));
					} else if (alertAction.equalsIgnoreCase("no")) {
						alertNoBtn.click();
						chkbox.click();
					} else if (alertAction.equalsIgnoreCase("close")) {
						alertCloseBtn.click();
						chkbox.click();
					}
				} catch (NoSuchElementException ex) {
					 gotoNextPage = true;
		                break;
				}
				index++;
			}
			 if (gotoNextPage && index< ids.size()) {
		            if (nextPageButton.isEnabled()) {
		                nextPageButton.click();
		            } else {
		                  break;
		            } 
		        }
			 if(index == ids.size())
		        	break;
		    } while (gotoNextPage || !ids.isEmpty());
		
	}
	
	public void switchToPopupDelete() {
		String parentId = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		if (windowHandles.size() > 1) {
			for (String handle : windowHandles) {
				if (!handle.equals(parentId)) {
					driver.switchTo().window(handle);
					System.out.println("Switched to window: " + driver.getTitle());
					break;
				}
			}
		} else {
			System.err.println("No new window found to switch to.");
		}
	}
	
//	 Assign Staff
	@FindBy(xpath="//button[@label='Assign Staff']")
	private WebElement assignStaffLink;
	
	@FindBy(xpath="//button[@label='Cancel']")
	private WebElement CancelButton;
	
	@FindBy(xpath="//button[@label='Save']")
	private WebElement SaveButton;
	
	@FindBy(xpath="//button[@tabindex='-1']")
	private WebElement CloseIcon;
	
	@FindBy(xpath="//input[@id='roleId']")
	private WebElement staffUserRoleInput;
	
	@FindBy(xpath="//span[text()='Select Email Id']/..")
	private WebElement staffEmailDropDown;
	
	@FindBy(xpath="//input[@id='skillName']")
	private WebElement staffSkillInput;
	
	
	@FindBy(xpath="//input[@id='programName']")
	private WebElement staffProgramNameDropDown;
	
	@FindBy(xpath="//input[@id='batchName']")
	private WebElement staffBatchNameDropDown;
	
	@FindBy(xpath="//input[@id='Active']")
	private WebElement activeRadioButton;
	@FindBy(xpath="//input[@id='Inactive']")
	private WebElement inactiveRadioButton;
	
	@FindBy(xpath = "//div[contains(text(),' Status is required. ')]")
	private WebElement stdStatusErrmsg;
	
//	 Assgin Student
	@FindBy(xpath="//span[text()='Assign Student']/..")
	private WebElement assignStudentLink;
	
	public void clickAssignStudentLink() {
		assignStudentLink.click();
	}
	
	public void buttonValidation() {
		
		Assert.assertTrue(SaveButton.isEnabled(),"Save button is disabled for assign student popup");
		Assert.assertTrue(CancelButton.isEnabled(), "Cancel button is disabled for assign student popup");
		Assert.assertTrue(CloseIcon.isEnabled(), "Close button is disabled for assign student popup");
	}
	@FindBy(xpath="//div[contains(text(),' User Email Id is required. ')]")
	private WebElement emailIdErrMsg;
	@FindBy(xpath="//div[contains(text(),' Program Name is required. ')]")
	private WebElement programNameErrMsg;
	@FindBy(xpath="//div[contains(text(),' Batch Name is required. ')]")
	private WebElement batchNameErrMsg;
	@FindBy(xpath="//div[contains(text(),' Status is required. ')]")
	private WebElement statusErrMsg;
	
	public void  validateEmptyFormErrMsg() {
		
		Assert.assertTrue(emailIdErrMsg.getText().contains("User Email Id is required.") , "Invalid Error msg for emaild id");
		Assert.assertTrue(programNameErrMsg.getText().equals("Program Name is required.") , "Invalid Error msg for Program Name");
		Assert.assertTrue(batchNameErrMsg.getText().equals("Batch Name is required.") , "Invalid Error msg for Batch name");
		Assert.assertTrue(statusErrMsg.getText().equals("Status is required.") , "Invalid Error msg for status");
		
	}
	
	public void dropDownValidation() {
		
	}
	
	public void radioButtonValidation() {
		Assert.assertTrue(activeRadioButton.isEnabled(), "Active Radio Button is not Enbled");
		Assert.assertTrue(inactiveRadioButton.isEnabled(), "Inactive Radio Button is not Enbled");
	}
	
	public void clickSaveButton() {
		SaveButton.click();
	}
	
	public void validateInputfields() {
		try
		{
	
			Assert.assertTrue(staffUserRoleInput.getAttribute("value").equals("R03") , "Default value of UserRole is not valid");
			Assert.assertTrue(staffEmailDropDown.getText().equals("Select Email ID") , "Default value of Email Id feild is not valid");
			Assert.assertTrue(staffProgramNameDropDown.getText().equals("") , "Default value of Proogram Name feild is not valid");
			Assert.assertTrue(staffBatchNameDropDown.getText().equals("") , "Default value of Batch Name feild is not valid");
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void validateErrMsgAssignStdtWithOutStatus()
	{
		Assert.assertTrue(stdStatusErrmsg.getText().equals("Status is required.") , "Invalid Error msg for status");
	}

	@FindBy(xpath="//div[@role='button']")
	private WebElement emailDropDown;
	//  //*[@id='userId']//ul/p-dropdownitem/li[@aria-label='java12@gmail.com']

	@FindBy(xpath="(//div[@role='button'])[2]")
	WebElement prognameDropDown;
	@FindBy(xpath="//*[@id='batchName']")
	WebElement batchDropDown;
	
	
	public void validateAssignStdtWithOutStatus(String emailid)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		emailDropDown.click();
		List<WebElement>emailidList= driver.findElements(By.xpath("//li"));
		ArrayList<String> StudtEmailids = new ArrayList<>();
		for(WebElement element : emailidList)
		{
			StudtEmailids.add(element.getText());
		}
		for(int i=0;i<StudtEmailids.size();i++)
		{
			if(StudtEmailids.get(i).equals(emailid))
			{
					     executor.executeScript("arguments[0].click();", emailidList.get(i));
			}
		}
		prognameDropDown.click();
		List<WebElement>progList= driver.findElements(By.xpath("//li"));
		progList.get(0).click();
		batchDropDown.click();
		List<WebElement>batchList= driver.findElements(By.xpath("//li"));
		executor.executeScript("arguments[0].click();", batchList.get(0));
		clickSaveButton();
			
	}
	
	
	
//	@FindBy(xpath="//input[@id='programName']")
//	private WebElement programNameInput;
//	@FindBy(xpath="//input[@id='batchName']")
//	private WebElement batchNameInput;
	
	public void validateWithStudentEmailId(String emailid) throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", emailDropDown);
//		emailDropDown.click();
//		Thread.sleep(4000);
		
//		WebElement studentEmailId =driver.findElement(By.xpath(String.format("//*[@id='userId']//ul/p-dropdownitem/li[@aria-label='%s']", emailid)));
//		Thread.sleep(4000);
//		studentEmailId.click();
//		programNameInput.sendKeys("programName");
//		batchNameInput.sendKeys("batchName");
//		clickSaveButton();
	}
	
	public void validateAssignStdtWithOutBatch(String emailid)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		emailDropDown.click();
		List<WebElement>emailidList= driver.findElements(By.xpath("//li"));
		ArrayList<String> StudtEmailids = new ArrayList<>();
		for(WebElement element : emailidList)
		{
			StudtEmailids.add(element.getText());
		}
		for(int i=0;i<StudtEmailids.size();i++)
		{
			if(StudtEmailids.get(i).equals(emailid))
			{
				  executor.executeScript("arguments[0].click();", emailidList.get(i));
			}
		}
		prognameDropDown.click();
		List<WebElement>progList= driver.findElements(By.xpath("//li"));
		progList.get(0).click();
		clickSaveButton();
	}
	
	public void validateErrMsgAssignStdtWithOutProgram()
	{
		Assert.assertTrue(programNameErrMsg.getText().equals("Program Name is required.") , "Invalid Error msg for Program Name");
	}
	
	
	public void validateAssignStdtWithOutProgram(String emailid)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		emailDropDown.click();
		List<WebElement>emailidList= driver.findElements(By.xpath("//li"));
		ArrayList<String> StudtEmailids = new ArrayList<>();
		for(WebElement element : emailidList)
		{
			StudtEmailids.add(element.getText());
		}
		for(int i=0;i<StudtEmailids.size();i++)
		{
			if(StudtEmailids.get(i).equals(emailid))
			{
							     executor.executeScript("arguments[0].click();", emailidList.get(i));
			}
		}
			clickSaveButton();
	}
	
	public void validateErrMsgAssignStdtWithOutBatch()
	{
		Assert.assertTrue(programNameErrMsg.getText().equals("Batch Name is required.") , "Invalid Error msg for Batch name");
	}
	
	
}
