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
import org.testng.asserts.SoftAssert;

public class UsersObjects {
	WebDriver driver;

	public UsersObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//Sorting
	
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
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']/..")
	private WebElement nextPageButton;
	//span[@class='p-button-icon pi pi-trash']/.. = rowDeleteButton

	public void clickUserLink() {
		 try {
		        userLink.click();
		    } catch (NoSuchElementException ex) {
		        System.out.println("User link not found: " + ex.getMessage());
		    }
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
		
	public List<String> sorting(String columnHeading, int clickCount) {
		int columnIndex = -1;
		List<String> originalList = new ArrayList<>();
		try {
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
				List<String> pageItems = itemlist.stream().map(a -> a.getText().toLowerCase())
						.collect(Collectors.toList());
				originalList.addAll(pageItems);
				if (nextPageButton.isEnabled()) {
					nextPageButton.click();
				} else {
					break;
				}
			} while (true);
		} catch (NoSuchElementException ex) {
			System.out.println("Element not found: " + ex.getMessage());
		}

		return originalList;
	}
	
//	 Delete User
	@FindBy(xpath="//span[@class='pi pi-times ng-tns-c133-9']/..")
	WebElement alertCloseBtn;
	@FindBy(xpath="//div[@class='p-toast-detail ng-tns-c90-10']/..")
	private WebElement msgDeleteSuccess;
	@FindBy(xpath="//div[@class='p-toast-summary ng-tns-c90-10']/..")
	private WebElement msgUserDelete;
	@FindBy(xpath="//span[contains(text(),'Yes')]/..")
     private WebElement deleteYesBtn;
	@FindBy(xpath="//span[contains(text(),'No')]/..")
    private WebElement deleteNoBtn;
	@FindBy(xpath="//span[contains(text(),'Confirm')]/..")
    private WebElement deleteConfirmMsg;
	@FindBy(xpath = "//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only'] ")   
	WebElement rowDeleteButton;
	@FindBy(xpath="//p-confirmdialog/div/div")
	private WebElement deletePopupWindow;
	
	public void clickRowDeleteButton() {
	    try {
	        rowDeleteButton.click();
	    } catch (NoSuchElementException ex) {
	        System.out.println("Row delete button element not found on the page.");
	    }
	}
	
	public void validateRowDeleteBtn() {
		try {
			Assert.assertTrue(deleteYesBtn.isEnabled(), "Yes button is disabled for assign student popup");
		} catch (NoSuchElementException ex) {
			System.out.println("Yes button element not found on the page.");
		}
		try {
			Assert.assertTrue(deleteNoBtn.isEnabled(), "No button is disabled for assign student popup");
		} catch (NoSuchElementException ex) {
			System.out.println("No button element not found on the page.");
		}
		try {
			Assert.assertEquals(deleteConfirmMsg.getText(), "Confirm",
					"Confirm heading is not present in the student popup");
		} catch (NoSuchElementException ex) {
			System.out.println("Confirm heading element not found on the page.");
		}
		System.out.println("Is  Yes button in Delete popup window enabled? " + deleteYesBtn.isEnabled());
	}
		
	public void validatePopupAlertExists() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("deletePopupWindow")));
			System.out.println("Deletion alert disappeared successfully");
		}catch (NoSuchElementException  e) {
		    System.out.println("Deletion alert was not found or is stale.");
		}
	}
		
//	checkDelete = driver.findElement(By.xpath(String.format("//tr/td[contains(text(),'%s')]/../td[1]", id)));
		public void singleUserDeleteInRow(String alertAction, List<String> UserID) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
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
					WebElement checkbox=driver.findElement(By.xpath("//tr/td[contains(text(),'" + id + "')]//preceding-sibling::td[1]"));
					checkbox.click();
					deleteBtn=driver.findElement(By.xpath("//tr/td[contains(text(),'" + id + "')]//following-sibling::td[4]//button[2]"));
					deleteBtn.click();
					Thread.sleep(1000);
					if (alertAction.equalsIgnoreCase("yes")) {
						deleteYesBtn.click();
						String actualMsg =msgDeleteSuccess.getText().trim();
						System.out.println("actualMsg is "+actualMsg);
						String expectedMessage = "Successful\nUser Deleted".trim();
						Thread.sleep(1000);
						softAssert.assertEquals(actualMsg, expectedMessage, "Actual message is not matching with expected");
						Thread.sleep(1000);
						softAssert.assertTrue(!originalList.contains(id));
						softAssert.assertAll();
					} else if (alertAction.equalsIgnoreCase("no")) {
						deleteNoBtn.click();
						checkbox.click();
						validatePopupAlertExists();
	    			} else if (alertAction.equalsIgnoreCase("close")) {
						alertCloseBtn.click();
						checkbox.click();
						validatePopupAlertExists();
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
//		Delete multiple users
		@FindBy(xpath="//span[@class='p-checkbox-icon']/..")
		private WebElement checkBox;
		@FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']")
		private WebElement headerDeleteBtn;
		
		public void clickCheckBox() {
		    try {
		        checkBox.click();
		    } catch (NoSuchElementException ex) {
		        System.out.println("Checkbox element not found on the page.");
		    }
		}
		
		public void validateHeaderDelete() {
			try {
				boolean isheaderDeleteBtn = headerDeleteBtn.isEnabled();
				if (isheaderDeleteBtn) {
				    System.out.println("Delete button is enabled after clicking the checkbox.");
				} else {
				    System.out.println("Delete button is not enabled after clicking the checkbox.");
				}
			} 	catch (NoSuchElementException e) {
		        System.out.println("Delete button not found on the page.");
		    }
		}
		
		public void multipleUserDelete(String alertAction, List<String> UserID) throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			List<String> ids = new ArrayList<>(UserID);
			List<String> originalList = sorting("ID", 2);
			Collections.sort(ids);
			idSort.click();
			boolean gotoNextPage = false;
			WebElement deleteBtn = null;
			int index = 0;
			String id = "";
			do {
				for (int i = index; i < ids.size(); i++) {
					id = ids.get(i);
					try {
						WebElement checkbox = driver.findElement(
								By.xpath("//tr/td[contains(text(),'" + id + "')]//preceding-sibling::td[1]"));
						checkbox.click();
						Thread.sleep(500);
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
			headerDeleteBtn.click();
			Thread.sleep(1000);
			if (alertAction.equalsIgnoreCase("yes")) {
				deleteYesBtn.click();
				String actualMsg = msgDeleteSuccess.getText().trim();
				System.out.println("actualMsg is " + actualMsg);
				String expectedMessage = "Successful\nUsers Deleted".trim();
				Thread.sleep(1000);
				softAssert.assertEquals(actualMsg, expectedMessage, "Actual message is not matching with expected");
				Thread.sleep(1000);
				softAssert.assertTrue(!originalList.contains(id));
				softAssert.assertAll();
			} else if (alertAction.equalsIgnoreCase("no")) {
				deleteNoBtn.click();
				validatePopupAlertExists();
			} else if (alertAction.equalsIgnoreCase("close")) {
				alertCloseBtn.click();
				validatePopupAlertExists();
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
		try {
		assignStudentLink.click();
		}catch (NoSuchElementException ex) {
	        System.out.println("Assign Student link element not found: " + ex.getMessage());
	    }
	}
	
	public void buttonValidation() {
		try {
		Assert.assertTrue(SaveButton.isEnabled(),"Save button is disabled for assign student popup");
		}catch (NoSuchElementException ex) {
	        System.out.println("Save button element not found: " + ex.getMessage());
	    }
		try {
		Assert.assertTrue(CancelButton.isEnabled(), "Cancel button is disabled for assign student popup");
		}catch (NoSuchElementException ex) {
	        System.out.println("Cancel button element not found: " + ex.getMessage());
	    }
		try {
		Assert.assertTrue(CloseIcon.isEnabled(), "Close button is disabled for assign student popup");
		}catch (NoSuchElementException ex) {
	        System.out.println("Close button element not found: " + ex.getMessage());
	    }
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
		try {
		Assert.assertTrue(emailIdErrMsg.getText().contains("User Email Id is required.") , "Invalid Error msg for emaild id");
		}catch (NoSuchElementException ex) {
	        System.out.println("User Email Id error message element not found: " + ex.getMessage());
	    }
		try {
		Assert.assertTrue(programNameErrMsg.getText().equals("Program Name is required.") , "Invalid Error msg for Program Name");
		}catch (NoSuchElementException ex) {
	        System.out.println("Program Name error message element not found: " + ex.getMessage());
	    }
		try {
		Assert.assertTrue(batchNameErrMsg.getText().equals("Batch Name is required.") , "Invalid Error msg for Batch name");
		}catch (NoSuchElementException ex) {
	        System.out.println("Batch Name error message element not found: " + ex.getMessage());
	    }
		try {
		Assert.assertTrue(statusErrMsg.getText().equals("Status is required.") , "Invalid Error msg for status");
		}catch (NoSuchElementException ex) {
	        System.out.println("Status error message element not found: " + ex.getMessage());
		}
	}
	
	public void dropDownValidation() {
		
	}
	
	public void radioButtonValidation() {
		try {
		Assert.assertTrue(activeRadioButton.isEnabled(), "Active Radio Button is not Enbled");
		}catch (NoSuchElementException ex) {
	        System.out.println("Active Radio Button element not found: " + ex.getMessage());
	    }
		try {
		Assert.assertTrue(inactiveRadioButton.isEnabled(), "Inactive Radio Button is not Enbled");
		}catch (NoSuchElementException ex) {
	        System.out.println("Inactive Radio Button element not found: " + ex.getMessage());
	    }
	}
	
	public void clickSaveButton() {
		try {
		SaveButton.click();
		}catch (NoSuchElementException ex) {
	        System.out.println("Save button element not found: " + ex.getMessage());
	    }
	}
	
	public void validateInputfields() {
	    SoftAssert softAssert = new SoftAssert();
	    try {
	        softAssert.assertEquals(staffUserRoleInput.getAttribute("value"), "R03", "Default value of UserRole is not valid");
	        softAssert.assertEquals(staffEmailDropDown.getText(), "Select Email ID", "Default value of Email Id field is not valid");
	        softAssert.assertEquals(staffProgramNameDropDown.getText(), "", "Default value of Program Name field is not valid");
	        softAssert.assertEquals(staffBatchNameDropDown.getText(), "", "Default value of Batch Name field is not valid");
	    } catch (AssertionError e) {
	        System.out.println("Assertion error occurred: " + e.getMessage());
	        e.printStackTrace();
	    } catch (Exception ex) {
	        System.out.println("An unexpected error occurred: " + ex.getMessage());
	        ex.printStackTrace();
	    } finally {
	        softAssert.assertAll();
	    }
	}
	
	public void validateErrMsgAssignStdtWithOutStatus()
	{
		try {
		Assert.assertTrue(stdStatusErrmsg.getText().equals("Status is required.") , "Invalid Error msg for status");
		}catch (Exception ex) {
	        System.out.println("An unexpected error occurred: " + ex.getMessage());
	        ex.printStackTrace();
		}
	}

	@FindBy(xpath="//div[@role='button']")
	private WebElement emailDropDown;
	//  //*[@id='userId']//ul/p-dropdownitem/li[@aria-label='java12@gmail.com']

	@FindBy(xpath="(//div[@role='button'])[2]")
	WebElement prognameDropDown;
	@FindBy(xpath="//*[@id='batchName']")
	WebElement batchDropDown;
	
	
	public void validateAssignStdtWithOutStatus(String emailid){
	try {
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
	} catch (Exception e) {
        e.printStackTrace();
       }
	}
	
	
	
//	@FindBy(xpath="//input[@id='programName']")
//	private WebElement programNameInput;
//	@FindBy(xpath="//input[@id='batchName']")
//	private WebElement batchNameInput;
	
		
	public void validateAssignStdtWithOutBatch(String emailid) {
	 try {
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
	 } catch (Exception e) {
	        e.printStackTrace();
	       }
	}
	
	public void validateErrMsgAssignStdtWithOutProgram()
	{
		try {
		Assert.assertTrue(programNameErrMsg.getText().equals("Program Name is required.") , "Invalid Error msg for Program Name");
		} catch(AssertionError e) {
			e.printStackTrace();
		}
	}
	
	
	public void validateAssignStdtWithOutProgram(String emailid){
	try {
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
	 } catch (Exception e) {
	        e.printStackTrace();
	       }
	}
	
	public void validateErrMsgAssignStdtWithOutBatch(){
	 try {
		Assert.assertTrue(programNameErrMsg.getText().equals("Batch Name is required.") , "Invalid Error msg for Batch name");
	 }  catch(AssertionError e) {
		e.printStackTrace();
	 }
    }
	
}
