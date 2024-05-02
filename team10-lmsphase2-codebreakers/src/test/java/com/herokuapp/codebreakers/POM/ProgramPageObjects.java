package com.herokuapp.codebreakers.POM;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.herokuapp.codebreakers.utilities.LoggerLoad;

import io.cucumber.java.lu.wann;
import net.bytebuddy.asm.Advice.This;

import com.herokuapp.codebreakers.utilities.Constants;
import com.herokuapp.codebreakers.utilities.ElementUtils;


public class ProgramPageObjects {
WebDriver driver;
	ElementUtils eUtils=new ElementUtils();
	public ProgramPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"program\"]/span[1]") WebElement programLink;
	@FindBy(xpath = "/html/body/app-root/app-program/div/mat-card/mat-card-title/div[1]") WebElement programHeader;
	@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/p-paginator/div") WebElement entries;
	@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[2]/div") WebElement footer;
	@FindBy(xpath="//*[@id=\"new\"]/span[2]") WebElement newProgram;
	// Data Table xpaths
	@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-title/div[2]/div[1]/button") WebElement mulDeleteButton;
	@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table") WebElement fullTable;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']") WebElement table;
	@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead") WebElement columnHeaders;
	@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[2]/td[1]/p-tablecheckbox/div/div[2]") WebElement checkboxTable;
	@FindBy(xpath="//button[@id='editProgram']") WebElement editProgram;
	@FindBy(xpath="//button[@id='deleteProgram']") WebElement deleteProgram;
	@FindBy(xpath="//input[@id='filterGlobal']") WebElement searchbox;
	@FindBy(xpath=" //*[@class=\"p-sortable-column-icon pi pi-fw pi-sort-alt\"]") WebElement sortButton;
	@FindBy(xpath="//div[@role='dialog']") WebElement NewProgramWindow;
	
	@FindBy(xpath = "//span[contains(text(),'Program Details')]") WebElement pgmDetailsHeaderElement;
	// Program details window xpaths
	@FindBy(xpath="//input[@id='programName']") WebElement programName;
	@FindBy(xpath="//input[@id='programDescription']") WebElement programDesc;
	@FindBy(xpath="//button[@id='saveProgram']") WebElement saveButton;
	@FindBy(xpath="//button[@tabindex='-1']") WebElement XButton;
	@FindBy(xpath="//span[contains(text(),'Cancel')]") WebElement cancelButton;
	@FindBy(xpath="//span[@class='p-radiobutton-icon']") WebElement radioButton;
	@FindBy(xpath="//input[@id=\"Active\"]") WebElement actRadioBtnElement;
	@FindBy(xpath="//input[@id=\"Inactive\"]") WebElement inactRadioBtnElement;
	//  next page
	@FindBy(xpath = "//button[@class=\"p-paginator-next p-paginator-element p-link p-ripple\"]") WebElement page_next;
	@FindBy(xpath = "//div[@class=\"p-toast-message-text ng-tns-c90-5 ng-star-inserted\"]") WebElement alertmsg;
	
	// Delete Program
	@FindBy(xpath = "//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only'] ")   
	WebElement rowDeleteButton;
	@FindBy(xpath="//span[contains(text(),'Yes')]/..")
     WebElement deleteYesBtn;
	@FindBy(xpath="//span[contains(text(),'No')]/..")
    WebElement deleteNoBtn;
	@FindBy(xpath="//span[contains(text(),'Confirm')]/..")
    WebElement deleteConfirmMsg;
	@FindBy(xpath = "//div[@class='ng-trigger ng-trigger-animation ng-tns-c133-4 p-dialog p-confirm-dialog p-component ng-star-inserted']") 
		WebElement deleteAlertBoxElement;
	@FindBy(xpath="//span[@class='pi pi-times ng-tns-c133-4']/..")
	WebElement alertCloseBtn;
	@FindBy(xpath="//span[@class=\"p-confirm-dialog-message ng-tns-c133-4\"]")
	WebElement confirmMessage;
	@FindBy(xpath="//div[@class='p-toast-detail ng-tns-c90-10']/..")
	 WebElement msgDeleteSuccess;
	//Pagination
	@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[3]")
	WebElement nextbutton;
	@FindBy(xpath="//div/span[2]/button[2]")
	WebElement active_link;
	@FindBy(xpath="//button[@class=\"p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted\"]")
	WebElement lastbutton ;
	@FindBy(xpath="//div/p-paginator/div/span[2]/button[5]")
	WebElement endofpage;
	@FindBy(xpath="//div/button[2]")
	WebElement firstlink;
	@FindBy(xpath="//div/span[2]/button[4]")
	WebElement previousbutton;
	//Mul delete and navigation
	@FindBy(xpath="//*[@id=\"batch\"]")
	WebElement batchlink;
	@FindBy(xpath="//*[@id=\"user\"]")
	WebElement userlink;
	@FindBy(xpath="//*[@id=\"logout\"]")
	WebElement logout;
	@FindBy(xpath="//*[@id=\"program\"]")
	WebElement programlink;
	@FindBy(xpath="//th[@psortablecolumn=\"programName\"]")
	WebElement  programnameIcon;
	@FindBy(xpath="//th[@psortablecolumn=\"programDescription\"]")
	WebElement programdescriptionIcon;
	@FindBy(xpath="//th[@psortablecolumn=\"programStatus\"]")
	WebElement ProgramStatusIcon;
	@FindBy(xpath="//div/p-paginator/div/button[3]")
 	WebElement nextBtn;
	@FindBy(xpath="//div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]")
 	WebElement commondeleteBtn;
	@FindBy(xpath="//*[@class=\"p-checkbox-box p-component\"]")
 	WebElement checkboxes;
	@FindBy(xpath="//div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]")
	WebElement checkbox1;
	@FindBy(xpath="//div/div[1]/table/tbody/tr[2]/td[1]/p-tablecheckbox/div/div[2]")
	WebElement checkbox2;
	@FindBy(xpath="//div/div[1]/table/tbody/tr[3]/td[1]/p-tablecheckbox/div/div[2]")
	WebElement checkbox3;
	@FindBy(xpath="//div/div[1]/table/tbody/tr[4]/td[1]/p-tablecheckbox/div/div[2]")
	WebElement checkbox4;

	// Manage Program Validation
	public void manageProgram()
{
	programLink.click();
	LoggerLoad.info("Program page");
}
public void ManageprogramUrl() {
	String Url= driver.getCurrentUrl(); 
	Assert.assertEquals("ManageProgram",Url.contains("ManageProgram"));
}
public void verifyHeaderText(String expHeaderTxt) {
	LoggerLoad.info("The header Text");

	assertEquals(programHeader.getText(), expHeaderTxt);
}
public void verifyEntries() {
	LoggerLoad.info("Text along with pagination");
	System.out.println("Entries below the table:" +entries.getText());
	
}
public void verifyFooter() {
	LoggerLoad.info("Text along with pagination");
	System.out.println("Entries below the table:"+footer.getText());
	
}
public void delDisabled() {
	  if (mulDeleteButton.getAttribute("disabled") != null) {
	         System.out.println("----*Button is disabled**-----");
	     } else {
	         System.out.println("------*Button is enabled*-----");
	     }
}
public void totalRows() {
	List<WebElement> rows = table.findElements(By.tagName("tr"));

	if (rows.size() == 5) {
	  System.out.println("-------*Table has 5 rows**---------");
	} else {
	  System.out.println("Table does not have 5 rows.");
	}
}
	public void validateNewProgramBtn() {

		newProgram.click();
		
		System.out.println("----New Program window is opened----");
			
	}
	public void checkHeaderText() {
		String expHeaderTxt=("Program Name Program Description Program Status Edit / Delete");
		//System.out.println("Header text:" +columnHeaders.getText());
		Assert.assertEquals(expHeaderTxt, columnHeaders.getText());
	}
	public void validateCheckboxes() {
	Boolean isCheckbox=false;
	List<WebElement> rows=fullTable.findElements(By.xpath("//table//tbody//tr"));
	for (WebElement row1 : rows)
	{
		isCheckbox=false;
		if(row1.findElement(By.xpath("//div[@role='checkbox']")).isEnabled())
		{
			isCheckbox=true;
			if(isCheckbox==true)
			{
				System.out.println("----There are checkboxes on left side of each row-----");
			}
		}
	}
	
}
	public void validateEditDelete() {
		List<WebElement> rows=fullTable.findElements(By.xpath("//table//tbody//tr"));
		int rowsize=rows.size();
		int count=0;
		for (WebElement row1 : rows)
		{
			if(editProgram.isEnabled()&&deleteProgram.isEnabled())
			{
				count++;
			}
			if(count==rowsize)
			{
				System.out.println(("-----Each row contains Edit and Delete buttons----"));
			}
		}
	}
	public void validateSearch() {
		String expText="Search...";
		String actText=searchbox.getAttribute("placeholder");
		System.out.println("Placeholder value:"+actText);
		if(searchbox.isDisplayed())
				{
			System.out.println("-----Search Box validated  -----");
				}
		
		Assert.assertEquals(actText, expText);
	}
	public void validateSortButton() {
//		List<WebElement> cells=driver.findElements(By.xpath("//table//thead//tr//th"));
//	for (WebElement cell : cells)
//	{
//		if(sortButton.isDisplayed())
//		{
//			System.out.println("-----Sort button is enabled for:"+cell.getText()+"------");
//		}
//		else
//			System.out.println("----Sort button is not enabled for:"+cell.getText()+"-------");
//	}
	WebElement programName = driver.findElement(By.xpath("//table//thead//tr//th[@psortablecolumn=\"programName\"]"));

	programName.click();

	System.out.println("Sleeping for milis");

	System.out.println(programName.getAttribute("aria-sort"));

	Assert.assertTrue(programName.getAttribute("aria-sort").contains("ascending"));

	System.out.println("-----Sort button is enabled for: ascending ------");

	programName.click();

	System.out.println(programName.getAttribute("aria-sort"));

	Assert.assertTrue(programName.getAttribute("aria-sort").contains("descending"));

	System.out.println("-----Sort button is enabled for: descending ------");

	WebElement programDescription = driver.findElement(By.xpath("//table//thead//tr//th[@psortablecolumn=\"programDescription\"]"));

	programDescription.click();

	System.out.println("Sleeping for milis");

	System.out.println(programDescription.getAttribute("aria-sort"));

	Assert.assertTrue(programDescription.getAttribute("aria-sort").contains("ascending"));

	System.out.println("-----Sort button is enabled for: ascending ------");

	programDescription.click();

	System.out.println(programDescription.getAttribute("aria-sort"));

	Assert.assertTrue(programDescription.getAttribute("aria-sort").contains("descending"));

	System.out.println("-----Sort button is enabled for: descending ------");

	WebElement programStatus = driver.findElement(By.xpath("//table//thead//tr//th[@psortablecolumn=\"programStatus\"]"));

	programStatus.click();

	System.out.println("Sleeping for milis");

	System.out.println(programStatus.getAttribute("aria-sort"));

	Assert.assertTrue(programStatus.getAttribute("aria-sort").contains("ascending"));

	System.out.println("-----Sort button is enabled for: ascending ------");

	programStatus.click();

	System.out.println(programStatus.getAttribute("aria-sort"));

	Assert.assertTrue(programStatus.getAttribute("aria-sort").contains("descending"));

	System.out.println("-----Sort button is enabled for: descending ------");
	}
	public void newProgramClick() {
		 newProgram.click();
	}
	// New Program Validation
	public void validateNewProgram() {
	String pDetailsWindow=driver.getWindowHandle();
	System.out.println("---Window Handle for program Details form:"+pDetailsWindow);
		 Assert.assertTrue(programName.isEnabled());
		 Assert.assertTrue(programDesc.getAttribute("value").isEmpty()); 
		 Assert.assertTrue(programDesc.isEnabled());
		 Assert.assertTrue(programDesc.getAttribute("value").isEmpty());
		Assert.assertTrue(radioButton.isEnabled());	
		//Assert.assertTrue(radioButton.getAttribute("value").isEmpty());
		//ElementUtils.waitForElementClickable(driver,cancelButton,20);
		//eUtils.waitForElementVisibility(driver, cancelButton, 20);
		Assert.assertTrue(cancelButton.isEnabled());
		Assert.assertTrue(XButton.isEnabled());
		Assert.assertTrue(saveButton.isEnabled());
		
	 }
	public void validateTextboxes() {
		
		List<WebElement> textboxcount=driver.findElements(By.xpath("//div/input[@type=\"text\"]"));
		System.out.println("----TextBox count:"+textboxcount.size()+"------");
		Assert.assertEquals(textboxcount.size(), 2);
		Assert.assertTrue(programName.isEnabled());
		 Assert.assertTrue(programDesc.isEnabled());
	}
	public void validateRadioButton() {
		List<WebElement> radiobuttonCount=driver.findElements(By.xpath("//span[@class=\"p-radiobutton-icon\"]"));
		System.out.println("----Number of Radio buttons:"+radiobuttonCount.size()+"----");
		Assert.assertEquals(radiobuttonCount.size(), 2);
		Assert.assertTrue(radioButton.isEnabled());
	}
	public void clickSaveBtn() {
		saveButton.click();
	}
	public void errorMsg(String ExpMsg) {
		
		List<WebElement> messageElements=driver.findElements(By.xpath("//small"));
		List<String> errorMsgList=new ArrayList<String>();
		for(WebElement msg:messageElements)
		{
			errorMsgList.add(msg.getText());
		}
		System.out.println("---- Error Messages:"+errorMsgList+"----");
		System.out.println("---Expected msg:"+ExpMsg);
		Assert.assertTrue(errorMsgList.contains(ExpMsg));
	}
	public void errorStatus(String exp1,String exp2) {
		List<WebElement> messageElements=driver.findElements(By.xpath("//small"));
		List<String> errorMsgList=new ArrayList<String>();
		for(WebElement msg:messageElements)
		{
			errorMsgList.add(msg.getText());
		}
		System.out.println("---- Error Messages:"+errorMsgList+"----");
		System.out.println("---Expected msg:"+exp1+","+exp2);
		
		
	}
public void errorMsg() {
		
		List<WebElement> messageElements=driver.findElements(By.xpath("//small"));
		List<String> errorMsgList=new ArrayList<String>();
		for(WebElement msg:messageElements)
		{
			errorMsgList.add(msg.getText());
		}
		System.out.println("---- Error Messages:"+errorMsgList+"----");
		
	}
	public void alertMsg() {
		String actmessage=alertmsg.getText();
		System.out.println("----Alert message-----"+actmessage);
	}
	public void saveWithOnlyProgramName() {
		programName.sendKeys("SQL");
		
	}
	public void onlyProgramDesc() {
		programDesc.sendKeys("Testing");
	}
	public void onlyStatus()  {
		
	
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", actRadioBtnElement);
	}
	public void clickClose() {
		XButton.click();
	}
	public void clickcancel() {
		cancelButton.click();
	}
	public void validateCancel() {
		
		String expHeader = "LMS";
		System.out.println("---Current Page Title"+driver.getTitle());
		Assert.assertEquals(expHeader, driver.getTitle());
	}
	public void validateclose() {
		
		String expHeader = "LMS";
		System.out.println("---Current Page Title"+driver.getTitle());
		Assert.assertEquals(expHeader, driver.getTitle());
		
	}
	public void savepgmFromExcel(String pname,String pDesc)
	{
		programName.click();
		programName.sendKeys(pname);
		programDesc.click();
		programDesc.sendKeys(pDesc);
		ElementUtils.moveToElementAndClick(driver, actRadioBtnElement, Constants.IMPLICIT_ELEMENT_WAIT_TIME);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", actRadioBtnElement);
		
	}
	public void savePgmWithvalidData() throws InterruptedException {
		
		
		ElementUtils.moveToElementAndClick(driver, programName, Constants.IMPLICIT_ELEMENT_WAIT_TIME);
		programName.sendKeys("SDET001");
		ElementUtils.moveToElementAndClick(driver, programDesc, Constants.IMPLICIT_ELEMENT_WAIT_TIME);
		programDesc.sendKeys("Testing");
		ElementUtils.moveToElementAndClick(driver, actRadioBtnElement, Constants.IMPLICIT_ELEMENT_WAIT_TIME);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", actRadioBtnElement);
	}
	public void validateProgramAdded(String pname) {
		List<WebElement> body = table.findElements(By.xpath("//table[@role='grid']/tbody"));

		ElementUtils.explicitPageWait(driver);
		boolean ispageexists =false;
		boolean isprogramexists = false;

		while(!isprogramexists) 
		{
			// Print data from current page
			for (WebElement rows : body) 
			{
				System.out.println(rows.getText());	

				isprogramexists = rows.getText().contains("pname");

				if(isprogramexists)
				{
					System.out.println("=============The program exists=========");
				}
			}	

			try 
			{
				ispageexists = false;
				ispageexists = page_next.isEnabled();
			}
			catch (Exception e)
			{
			}
			ElementUtils.explicitPageWait(driver);
			//Thread.sleep(1000);
			// Check if there is a next page
			if (ispageexists) 
			{
				page_next.click();
			}
			else
			{
				ElementUtils.explicitPageWait(driver);
				break; 
			}

		}
	}
	public void alertMsg(String expmsg) {
		String actmessage=alertmsg.getText();
		System.out.println("----Alert message-----"+actmessage);
		Assert.assertEquals(actmessage, expmsg);
	}
	
	// Edit Program
	public void clickEdit() {
		
			List<WebElement> rows=fullTable.findElements(By.xpath("//table//tbody//tr"));
			int rowsize=rows.size();
			int count=0;
			for (WebElement row1 : rows)
			{
				if(editProgram.isEnabled())
				{
					count++;
				}
				if(count==rowsize-1)
				{
					editProgram.click();
				}
			}
		}
	
	public void validateEdit() {
		
		String expHeader = "Program Details";
		String headerElement=driver.findElement(By.xpath("//*[@role=\"dialog\"]")).getText();
		System.out.println("---Current Page data"+headerElement);
		Assert.assertTrue(headerElement.contains(expHeader));
	}
	public void editPgmName() {
		programName.clear();
		programName.sendKeys("SDET");
		saveButton.click();
	}
	public void programEdited(String data) {
		List<WebElement> body = table.findElements(By.xpath("//table[@role='grid']/tbody"));

		ElementUtils.explicitPageWait(driver);
		boolean ispageexists =false;
		boolean isprogramexists = false;

		while(!isprogramexists) 
		{
			// Print data from current page
			for (WebElement rows : body) 
			{
				System.out.println(rows.getText());	

				isprogramexists = rows.getText().contains(data);

				if(isprogramexists)
				{
					System.out.println("=============The program exists with edited data=========");
				}
			}	

			try 
			{
				ispageexists = false;
				ispageexists = page_next.isEnabled();
			}
			catch (Exception e)
			{
			}
			ElementUtils.explicitPageWait(driver);
			//Thread.sleep(1000);
			// Check if there is a next page
			if (ispageexists) 
			{
				page_next.click();
			}
			else
			{
				ElementUtils.explicitPageWait(driver);
				break; 
			}

		}
		
	}
	public void validateNameEdit() {
		
		String actmessage=alertmsg.getText();
		System.out.println("----Alert message-----"+actmessage);
		searchbox.sendKeys("SDET");
		List<WebElement> body = table.findElements(By.xpath("//table[@role='grid']/tbody"));

		ElementUtils.explicitPageWait(driver);
		//boolean ispageexists =false;
		boolean isprogramexists = false;

		while(!isprogramexists) 
		{
			// Print data from current page
			for (WebElement rows : body) 
			{
				System.out.println(rows.getText());	

				isprogramexists = rows.getText().contains("SDET");

				if(isprogramexists)
				{
					System.out.println("=============The program exists=========");
				}
			}
		}

			
	}
	public void editPgmDesc() {
		programDesc.clear();
		programDesc.sendKeys("TestingEdit");
		clickSaveBtn();
	}
	public void validateDescEdit() {
		String pgmDescString = "TestingEdit";
		String actmessage=alertmsg.getText();
		System.out.println("----Alert message-----"+actmessage);
		searchbox.sendKeys(pgmDescString);
		programEdited(pgmDescString);
	}
	public void editPgmStatus() {
		String pgmname=programName.getText();
		boolean selectState=actRadioBtnElement.isSelected();
		if(selectState==true)
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", inactRadioBtnElement);
		else {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", actRadioBtnElement);
		}
		//String statuString = radioButton.getAttribute("value");
		clickSaveBtn();
		String actmessage=alertmsg.getText();
		System.out.println("----Alert message-----"+actmessage);
		searchbox.sendKeys(pgmname);
		programEdited(pgmname);
		//System.out.println("Edited Status"+statuString);
		
	}
	public void editInvalid() {
		programName.clear();
		programName.sendKeys("1234");
		programDesc.clear();
		programDesc.sendKeys("&**^^");
		clickSaveBtn();
		
	}
	public void getEditValues() {
		String valueString = NewProgramWindow.getText();
String nameString=	programName.getText();
		System.out.println("----Program details:"+ valueString+"----");
		clickcancel();
		programEdited(nameString);

	}
	public void editSave() {
		
		String actmessage=alertmsg.getText();
		System.out.println("----Alert message-----"+actmessage);
	}
	
	// Sorting
	
	public List<String> sorting(String columnHeading,int clickCount) {
		
		int columnIndex = -1;
		List<String> originalList = new ArrayList<>();
						
		WebElement columnHeadingElement = driver.findElement(By.xpath("//th[contains(text(),'"+columnHeading  +" ')]"));
		for(int i =0; i<clickCount;i++) {
			columnHeadingElement.click();
		}
		
						
		if(columnHeading.contains("Program Name")) {
			 columnIndex = 2 ;
		} else if (columnHeading.contains("Program Description")){
			columnIndex = 3;
		}else if (columnHeading.contains("Program Status")) {
			columnIndex = 4;
		
		}			
		 do {
		 List<WebElement> itemlist = driver.findElements(By.xpath("//tr/td["+ columnIndex +"]"));
		 List<String> pageItems = itemlist.stream().map(a->a.getText().toLowerCase()).collect(Collectors.toList());
		 originalList.addAll(pageItems);
		 ElementUtils.waitForElementVisibility(driver, page_next, Constants.EXPLICIT_ELEMENT_WAIT_TIME);
	boolean result=false;
	
	    try {
	        if (result = page_next.isEnabled()) {
	            page_next.click();
	        } else {
	            break;
	        }
	    } catch (Exception e) {
	        // Handle the exception here
	        System.out.println("An exception occurred: " + e.getMessage());
	        break;
	    }
	} while (true);
		
		 return originalList;
}
	//Delete Program
	 
	public void clickRowDelButton(String pname)  {
		String beforedel=entries.getText();
		System.out.println("Total programs before deletion:"+ beforedel);
		searchbox.click();
		searchbox.sendKeys(pname);
		rowDeleteButton.click();
	}
	public void confirmBoxText() { 	
		String cnbtn = deleteConfirmMsg.getText();
			System.out.println("-----Confirm-----"+cnbtn);
			String ybtn=deleteYesBtn.getText();		
			System.out.println("----Yes Button----"+ybtn);
			String Nbtn= deleteNoBtn.getText();
			System.out.println("----No button----"+Nbtn); 
				
	}
	public void confirmDeleteValidation() {
		
		String messageString=confirmMessage.getText();
		System.out.println("---Confirmation Message:"+messageString+"-----");
		
		System.out.println("Total programs after deletion:"+ entries.getText());
	}
	public void clickYes() {
		deleteYesBtn.click();
	}
	public void clickdeleteBtn() {
		rowDeleteButton.click();
	}
	public void clickNo() {
		deleteNoBtn.click();
	}
	public void clickclose() {
		alertCloseBtn.click();
	}
	public void noConfirmAlert() {
		assertEquals(programHeader.getText(), "Manage Program");
	}
	//Multiple Delete
	public void validateCommonDelete() {
		checkbox1.click();
		boolean enabled=commondeleteBtn.isEnabled();
		System.out.println("---------Common Delete Button is Enabled-------"+enabled);
	}
	public void validateSingleDeleteYes() {
		checkbox2.click();
		String row2Txt=driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[2]")).getText();
		System.out.println("------Data in Rows:"+row2Txt+"--------");
		commondeleteBtn.click();
		deleteYesBtn.click();
		System.out.println("----------Selected programs are Successfully deleted ------"+ alertmsg.getText());
		System.out.println("------Data in Rows:"+row2Txt+"--------");
	}
	
	public void validateSingleDeleteNo() {
		checkbox2.click();
		String row2Txt=driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[2]")).getText();
		System.out.println("------Data in Rows:"+row2Txt+"--------");
		commondeleteBtn.click();
		deleteNoBtn.click();
		System.out.println("------Data in Rows:"+row2Txt+"--------");
	}
		public void validateMulDeletionYes() {
		checkbox2.click();
		checkbox3.click();
		String row2Txt=driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[2]")).getText();
		String row3Txt=driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]")).getText();
		System.out.println("------Data in Rows:"+row2Txt+row3Txt+"--------");
			commondeleteBtn.click();
			deleteYesBtn.click();
			System.out.println("----------Selected programs are Successfully deleted ------"+alertmsg.getText());
			System.out.println("------Data in Rows:"+row2Txt+row3Txt+"--------");
		}
		
		public void validateMulDeleteNo() {
			checkbox2.click();
			checkbox3.click();
			String row2Txt=driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[2]")).getText();
			String row3Txt=driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]")).getText();
			System.out.println("------Data in Rows:"+row2Txt+row3Txt+"--------");
			commondeleteBtn.click();
			deleteNoBtn.click();
			System.out.println("------Data in Rows:"+row2Txt+row3Txt+"--------");
		}

	// Pagination
	public void validate_next_pagelink() {
		page_next.click();
		boolean isNextPageLinkActive = active_link.isEnabled();
		if (isNextPageLinkActive) {
			System.out.println("---Next page link is active---");
		} else {
			System.out.println("----Next page link is inactive----");
		}
	}
	public void validate_last_pagelink() {
		lastbutton.click();
		String pageno=endofpage.getText();
			System.out.println("---End Page Number--"+pageno);
			boolean isNextPageLinkActive = nextbutton.isEnabled();
		if (isNextPageLinkActive) {
			System.out.println("---Next Button is Enabled---");
		} else {
			System.out.println("----Next Button is Disabled----");
		}
	}
	public void validate_first_pagelink() {
		lastbutton.click();
		firstlink.click();
		String pageno1=previousbutton.getText();
			System.out.println("---previous page--"+pageno1);
			boolean isNextPageLinkActive = previousbutton.isEnabled();
		if (isNextPageLinkActive) {
			System.out.println("---Previous Next Button is Enabled---");
		} else {
			System.out.println("----Previous Next Button is Disabled----");
		}
	}
	// Navigation
	public void clickBatchLink() {
		batchlink.click();
		String BatchUrl= driver.getCurrentUrl(); 
	 System.out.println("---Url of home page----"+ BatchUrl);
		Assert.assertTrue(BatchUrl.contains("batch"));
			}
	public void clickUserLink() {
		userlink.click();
		String userurl = driver.getCurrentUrl();
		System.out.println("---Url of user page---"+userurl);
		Assert.assertTrue(userurl.contains("user"));
		}
	 public void clickLogout() {
		logout.click();
		String logouturl = driver.getCurrentUrl();
		System.out.println("---Url of user page---"+logouturl);
		Assert.assertTrue(logouturl.contains("login"));
		}

	
	
}
