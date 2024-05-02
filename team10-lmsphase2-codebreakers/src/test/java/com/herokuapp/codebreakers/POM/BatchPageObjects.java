package com.herokuapp.codebreakers.POM;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.herokuapp.codebreakers.utilities.Constants;
import com.herokuapp.codebreakers.utilities.ElementUtils;

public class BatchPageObjects 
{
	WebDriver driver;

	public BatchPageObjects(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@id='batch']")
	WebElement batchBtn;

	@FindBy(xpath="//div[text()=' Manage Batch']")
	WebElement batchHeader;

	@FindBy(xpath="//button[@class='p-paginator-first p-paginator-element p-link p-disabled p-ripple ng-star-inserted']")
	WebElement pag_First;

	@FindBy(xpath="//button[@class='p-paginator-prev p-paginator-element p-link p-disabled p-ripple']")
	WebElement pag_Second;

	@FindBy(xpath="//button[@class='p-paginator-next p-paginator-element p-link p-ripple']")
	WebElement pag_Third;

	@FindBy(xpath="//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']")
	WebElement pag_Fourth;

	@FindBy(xpath="//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']")
	WebElement pagination;

	@FindBy(xpath="//thead[@class='p-datatable-thead']")
	WebElement table_Header;

	@FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	WebElement delete_all;

	@FindBy(xpath="//span[text()='A New Batch']")
	WebElement newBatchBtn;

	@FindBy(xpath="//span[text()='Batch Details']")
	WebElement batchDetails;

	@FindBy(xpath="//input[@id='batchName']")
	WebElement batchNameTextBox;

	@FindBy(xpath="//input[@id='batchDescription']")
	WebElement batchDescriptionTextBox;

	@FindBy(xpath="//input[@placeholder='Select a Program name']")
	WebElement programNameDropDown;

	@FindBy(xpath="//div[@class='radio ng-star-inserted']")
	WebElement batchStatusRadioBtn;

	@FindBy(xpath="//input[@id='batchNoOfClasses']")
	WebElement batchNoOfClassesTextBox;

	@FindBy(xpath="//div[@role='button']")
	WebElement DropDown;

	@FindBy(xpath="//*[@id=\"batchStatus\"]/div/div[2]")
	WebElement activeRadioBtn;

	@FindBy(xpath="//button[@label='Save']")
	WebElement addBatchSaveBtn;

	@FindBy(xpath="//p-dialog/div/div/div[1]/div/button")
	WebElement addBatchCloseBtn;

	@FindBy(xpath="//input[@id='filterGlobal']")
	WebElement batchSearchBox;

	@FindBy(xpath="//p-paginator/div/span[1]")
	WebElement batchPaginationDetails;

	@FindBy(xpath="//p-toastitem/div/div/div/div[1]")
	WebElement batchSuccessMessage;

	@FindBy(xpath="//p-toast//div")
	WebElement batchFailedMessage;

	@FindBy(xpath="//p-dialog/div/div/div[2]/div[1]/small")
	WebElement batchNameErrMsg;

	@FindBy(xpath="//p-dialog/div/div/div[2]/div[2]/small")
	WebElement batchDescriptionErrMsg;

	@FindBy(xpath="//*[@id='text-danger']")
	WebElement batchNoOfClassesErrMsg;

	@FindBy(xpath="//span[@class='p-button-icon pi pi-pencil']")
	WebElement batchRowEdit;

	@FindBy(xpath="//*[@id='batchDescription']")
	WebElement batchDescriptionEdit;

	@FindBy(xpath="//input[@id='batchNoOfClasses']")
	WebElement batchNoOfClassesEdit;

	@FindBy(xpath="//span[text()='Save']")
	WebElement batchEditSaveBtn;
	
	@FindBy(xpath="//small[text()='This field should start with an alphabet and min 2 character.']")
	WebElement batchEditDescriptionErrMsg;
	
	@FindBy(xpath="//small[text()='Number of classes is required.']")
	WebElement batchEditNoOfClassesErrMsg;
	
	@FindBy(xpath="//span[text()='Cancel']")
	WebElement batchEditCancelBtn;
	
	@FindBy(xpath="//table/tbody/tr/td[3]")
	WebElement batchEditDescriptionvalue;
	
	@FindBy(xpath="//tr//span[@class='p-button-icon pi pi-trash']")
	WebElement batchDeleteRowBtn;
	
	@FindBy(xpath="//div[@class='ng-trigger ng-trigger-animation ng-tns-c133-7 p-dialog p-confirm-dialog p-component ng-star-inserted']")
	WebElement batchDeleteAlertMsg;
	
	@FindBy(xpath="//span[text()='Yes']")
	WebElement batchDeleteYesBtn;
	
	@FindBy(xpath="//span[text()='No']")
	WebElement batchDeleteNoBtn;
	
	@FindBy(xpath="//table//tbody//tr")
	WebElement batchSearch;
	
	public String getDashboardTitle()
	{
		return driver.getTitle();
	}
	public void clickOnBatch(String text)
	{
		if(text.equals(batchBtn.getText()))
		{
			ElementUtils.waitForElementClickable(driver, batchBtn, Constants.EXPLICIT_ELEMENT_WAIT_TIME);
			batchBtn.click();
		}
	}

	public String getBatchHeader()
	{
		return batchHeader.getText();
	}

	public WebElement getFirstPagination()
	{
		return pag_First;
	}

	public WebElement getSecondPagination()
	{
		return pag_Second;
	}
	public WebElement getThirdPagination()
	{
		return pag_Third;
	}

	public WebElement getFourthPagination()
	{
		return pag_Fourth;
	}

	public WebElement getTableHeader()
	{
		return table_Header;
	}

	public void getPagination()
	{
		System.out.println("Pagination: "+pagination.getText());
	}

	public String saveTableHeader()
	{
		String header = "Batch Name Batch Description Batch Status No Of Classes Program Name Edit / Delete";
		return header;
	}

	public WebElement getDeleteAllDisabled()
	{
		return delete_all;
	}

	public WebElement getANewBatchButton()
	{
		return newBatchBtn;
	}

	public Boolean verifyCheckBoxes()
	{
		Boolean isCheckbox = false;
		WebElement table = driver.findElement(By.xpath ("//table[@role='grid']"));

		// Find all rows in the table
		List<WebElement> rows = table.findElements(By.xpath("//table//tbody//tr"));
		for (WebElement row : rows) 
		{
			if(isCheckbox = row.findElement(By.tagName("input")).getAttribute("type").equals("checkbox"))
			{
				System.out.println("The Boolean value is: "+isCheckbox);
			}
		}
		return isCheckbox;
	}

	public Boolean verifyEditButtons()
	{
		Boolean isEditBtn = false;
		WebElement table = driver.findElement(By.xpath ("//table[@role='grid']"));

		// Find all rows in the table
		List<WebElement> rows = table.findElements(By.xpath("//table//tbody//tr"));
		for (WebElement row : rows) 
		{
			if(isEditBtn = row.findElement(By.xpath("//span[@class='p-button-icon pi pi-pencil']")).isEnabled())
			{
				System.out.println("The Boolean value is: "+isEditBtn);
			}
		}
		return isEditBtn;
	}

	public Boolean verifyDeleteButtons()
	{
		Boolean isDeleteBtn = false;
		WebElement table = driver.findElement(By.xpath ("//table[@role='grid']"));

		// Find all rows in the table
		List<WebElement> rows = table.findElements(By.xpath("//table//tbody//tr"));
		for (WebElement row : rows) 
		{
			if(isDeleteBtn = row.findElement(By.xpath("//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']")).isEnabled())
			{
				System.out.println("The Boolean value is: "+isDeleteBtn);
			}
		}
		return isDeleteBtn;
	}

	public void clickOnANewBatch(String text)
	{
		batchBtn.click();
		newBatchBtn.click();
	}

	public WebElement getBatchDetailsHeader()
	{
		return batchDetails;
	}

	public String popUpBatchDetails()
	{
		String bDetails = "Batch Details";
		return bDetails;
	}

	public WebElement getBatchNameTextBox()
	{
		return batchNameTextBox;
	}

	public void afterClickingAddBatch()
	{
		batchBtn.click();
		newBatchBtn.click();
	}

	public WebElement getBatchDescriptionTextBox()
	{
		return batchDescriptionTextBox;
	}

	public WebElement getProgramNameDropDown()
	{
		return programNameDropDown;
	}

	public WebElement getBatchRadioBtn()
	{
		return batchStatusRadioBtn;
	}

	public WebElement getBatchNoOfClassesTextBox()
	{
		return batchNoOfClassesTextBox;
	}

	public void enterBatchDetails(String name, String description, String programName, String numberOfClasses)
	{
		ElementUtils.moveToElementAndClick(driver, batchNameTextBox, Constants.IMPLICIT_ELEMENT_WAIT_TIME);
		batchNameTextBox.sendKeys(name);

		ElementUtils.explicitPageWait(driver);
		batchDescriptionTextBox.sendKeys(description);

		ElementUtils.moveToElementAndClick(driver, batchNameTextBox, Constants.IMPLICIT_ELEMENT_WAIT_TIME);
		DropDown.click();

		Actions a = new Actions(driver);
		a.sendKeys(programName).click().perform();
		activeRadioBtn.click();
		ElementUtils.explicitPageWait(driver);
		batchNoOfClassesTextBox.sendKeys(numberOfClasses);
		addBatchSaveBtn.click();
	}

	public void clickOnCloseBtn()
	{
		addBatchCloseBtn.click();
	}

	public WebElement getBatchSearchBox()
	{
		return batchSearchBox;
	}

	public Boolean getPaginationDetails()
	{
		boolean details = true;
		if(batchPaginationDetails.getText().equals(Constants.PAGINATION_DETAILS))
		{
			details = false;
		}
		return details;
	}

	public void checkDataIsPresent(String name) throws InterruptedException 
	{	
		ElementUtils.explicitPageWait(driver);
		WebElement table = driver.findElement(By.xpath ("//table[@role='grid']"));
		ElementUtils.waitForElementVisibility(driver, batchPaginationDetails, Constants.IMPLICIT_ELEMENT_WAIT_TIME);

		// Find all rows in the table

		List<WebElement> body = table.findElements(By.xpath("//table[@role='grid']/tbody"));

		ElementUtils.explicitPageWait(driver);
		boolean ispageexists =false;
		boolean isbatchexists = false;

		while(!isbatchexists) 
		{
			// Print data from current page
			for (WebElement rows : body) 
			{
				System.out.println(rows.getText());	

				isbatchexists = rows.getText().contains(name);

				if(isbatchexists)
				{
					System.out.println("=============The batch exists");
				}
			}	

			try 
			{
				ispageexists = false;
				ispageexists = pag_Third.isEnabled();
			}
			catch (Exception e)
			{
			}
			ElementUtils.explicitPageWait(driver);
			//Thread.sleep(1000);
			// Check if there is a next page
			if (ispageexists) 
			{
				pag_Third.click();
			}
			else
			{
				ElementUtils.explicitPageWait(driver);
				break; 
			}

		}
	}

	public WebElement getSuccessMsg()
	{
		ElementUtils.explicitPageWait(driver);
		System.out.println("============The success message is: "+batchSuccessMessage.getText());
		return batchSuccessMessage;
	}

	public WebElement getFailedMsg()
	{
		ElementUtils.explicitPageWait(driver);
		System.out.println("============The failed message is: "+batchFailedMessage.getText());
		return batchFailedMessage;
	}

	public WebElement getBatchNameErrMsg()
	{
		System.out.println("============The batch name error message is: "+batchNameErrMsg.getText());
		return batchNameErrMsg;
	}

	public WebElement getBatchDescriptionErrMsg()
	{
		System.out.println("============The batch description error message is: "+batchDescriptionErrMsg.getText());
		return batchDescriptionErrMsg;
	}
	public WebElement getBatchNoOfClassesErrMsg()
	{
		System.out.println("============The batch no of classes error message is: "+batchNoOfClassesErrMsg.getText());
		return batchNoOfClassesErrMsg;
	}

	public void clickOnBatch()
	{
		batchBtn.click();
	}

	public void clickOnEdit()
	{
		ElementUtils.explicitPageWait(driver);
		batchRowEdit.click();
	}

	public void updateBatchDetails(String edit_description, String edit_numberOfClasses)
	{
		ElementUtils.moveToElementAndClick(driver, batchDescriptionEdit, Constants.IMPLICIT_ELEMENT_WAIT_TIME);
		batchDescriptionEdit.clear();
		batchDescriptionEdit.sendKeys(edit_description);

		ElementUtils.moveToElementAndClick(driver, batchNoOfClassesEdit, Constants.IMPLICIT_ELEMENT_WAIT_TIME);
		batchNoOfClassesEdit.sendKeys(Keys.COMMAND+"A");
		batchNoOfClassesEdit.sendKeys(Keys.DELETE);

		ElementUtils.explicitPageWait(driver);
		batchNoOfClassesEdit.sendKeys(edit_numberOfClasses);
		ElementUtils.explicitPageWait(driver);
		batchEditSaveBtn.click();
	}
	
	public WebElement getEditBatchDescriptionErrMsg()
	{
		ElementUtils.explicitPageWait(driver);
		System.out.println("============The batch description error message is: "+batchEditDescriptionErrMsg.getText());
		return batchEditDescriptionErrMsg;
	}
	
	public WebElement getEditBatchNoOfClassesErrMsg()
	{
		ElementUtils.explicitPageWait(driver);
		System.out.println("============The batch no of classes error message is: "+batchEditNoOfClassesErrMsg.getText());
		return batchEditNoOfClassesErrMsg;
	}
	
	public void eraseData() 
	{
		ElementUtils.moveToElementAndClick(driver, batchDescriptionEdit, Constants.IMPLICIT_ELEMENT_WAIT_TIME);
		batchDescriptionEdit.sendKeys(Keys.COMMAND+"A");
		batchDescriptionEdit.sendKeys(Keys.DELETE);

		ElementUtils.moveToElementAndClick(driver, batchNoOfClassesEdit, Constants.IMPLICIT_ELEMENT_WAIT_TIME);
		batchNoOfClassesEdit.sendKeys(Keys.COMMAND+"A");
		batchNoOfClassesEdit.sendKeys(Keys.DELETE);
		ElementUtils.explicitPageWait(driver);
	}
	
	public void eraseBatchDescription()
	{
		ElementUtils.moveToElementAndClick(driver, batchDescriptionEdit, Constants.IMPLICIT_ELEMENT_WAIT_TIME);
		batchDescriptionEdit.sendKeys(Keys.COMMAND+"A");
		batchDescriptionEdit.sendKeys(Keys.DELETE);

	}
	
	public WebElement clickEditBatchCancelBtn()
	{
		return batchEditCancelBtn;
	}
	
	public WebElement getBatchEditDescriptionValue()
	{
		return batchEditDescriptionvalue;
	}
	
	public Boolean verifyDeleteBtns()
	{
		Boolean isDeleteBtn = false;
		WebElement table = driver.findElement(By.xpath ("//table[@role='grid']"));

		// Find all rows in the table
		List<WebElement> rows = table.findElements(By.xpath("//table//tbody//tr"));
		for (WebElement row : rows) 
		{
			if(isDeleteBtn = row.findElement(By.xpath("//span[@class='p-button-icon pi pi-trash']")).isEnabled())
			{
				System.out.println("The Boolean value is: "+isDeleteBtn);
			}
		}
		return isDeleteBtn;
	}
	
	public void clickOnDelete()
	{
		ElementUtils.explicitPageWait(driver);
		batchDeleteRowBtn.click();
	}
	
	public WebElement deleteSwitchAlert()
	{
		return batchDeleteAlertMsg;
	}
	
	public void clickOnYesInDelete()
	{
		batchDeleteYesBtn.click();
	}

	public WebElement batchPaginationDetails()
	{
		return batchPaginationDetails;
	}
	
	public void clickOnNoInDelete()
	{
		batchDeleteNoBtn.click();
	}
	
	public WebElement batchSearchAfterClickingNo()
	{
		return batchSearch;
	}
	

}




