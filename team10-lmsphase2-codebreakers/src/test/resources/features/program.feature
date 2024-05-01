Feature: Manage Program Validation, Add, Edit and Delete Program with pagination and sorting validations

  Background: The Admin is logged in to LMS portal
    Given User is on dashboard page after Login and clicks Program on the navigation bar

  Scenario: Validate landing in Program page
  Given Program_Admin is on dashboard page after Login
  When Program_Admin clicks Program on the navigation bar
  Then Program_Admin should see URL with "Manage Program"
  
  Scenario: Program Validate the heading
  When Program_Admin clicks Program on the navigation bar
  Then Program_Admin should see a heading with text "Manage Program" on the page
  
  Scenario: Validate the text and pagination icon below the data table
  When Program_Admin clicks Program on the navigation bar
  Then Program_Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table.
  
  
  Scenario: Validate the footer
  When Program_Admin clicks Program on the navigation bar
  Then Program_Admin should see the footer as "In total there are z programs".
  
  Scenario: Validating the default state of Delete button
  When Program_Admin clicks Program on the navigation bar
  Then Program_Admin should see a Delete button on the top left hand side as Disabled
  
  Scenario: Validate Add New Program
  When Program_Admin clicks Program on the navigation bar
  Then Program_Admin should see a +A New Program button on the program page above the data table
  
  Scenario: Validate that number of records (rows of data in the table) displayed
  When Program_Admin clicks Program on the navigation bar
  Then Program_Admin should see the number of records (rows of data in the table) displayed on the page are 5
  
  Scenario: Verify data table on the Program page
  When Program_Admin clicks Program on the navigation bar
  Then Program_Admin should see data table on the Manage Program Page with following column headers (Program Name, Program Description, Program Status, Edit,Delete)
  
  Scenario: Verify Sort arrow icon on the data table
  When Program_Admin clicks Program on the navigation bar
  Then Program_Admin should see the sort arrow icon beside to each column header except Edit and Delete
  
  
  
  
  Scenario: Verify Check box on the data table
  When Program_Admin clicks Program on the navigation bar
  Then Program_Admin should see check box on the left side in all rows of the data table
  
  Scenario: Verify Edit and Delete buttons
  When Program_Admin clicks Program on the navigation bar
  Then Program_Admin should see Any Edit and Delete buttons on each row of the data table
  
  Scenario: Verify Search bar on the Program page
  When Program_Admin clicks Program on the navigation bar
  Then Program_Admin should see Search bar with text as "Search..."
  
  
  
  @NewProgram
  
  Scenario: Validate Program Details Popup window
  Given: Admin is on Manage Program Page
  When Admin clicks A New Program Button
  Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
  
  Scenario: Validate input fields and their text boxes in Program details form
  Given: Program_Admin is on Manage Program Page
  When Admin clicks A New Program Button
  Then Admin should see two input fields and their respective text boxes in the program details window
  
  Scenario: Validate radio button for Program Status
  Given: Program_Admin is on Manage Program Page
  When Admin clicks A New Program Button
  Then Admin should see two radio button for Program Status
  
  Scenario: Empty form submission
  Given Admin is on "Program Details" Popup window
  When Admin clicks <Save>button without entering any data
  Then Admin gets a Error message alert
  
  		Scenario: Enter only Program Name
  		Given Admin is on "Program Details" Popup window
  When Admin enters only<Program Name> in text box and clicks Save button
  Then Admin gets a message alert "Description is required."
  
  Scenario: Enter only Program Description
  Given Admin is on "Program Details" Popup window
  When Admin enters only<Program description> in text box and clicks Save button
  Then Admin gets a message alert "Program name is required."
  Scenario: Select Status only
  Given Admin is on "Program Details" Popup window
  When Admin selects only Status and clicks Save button
  Then Admin gets a message alert "Program name is required." and " Description is required."
  Scenario: Validate invalid values on the text column
  Given Admin is on "Program Details" Popup window
  When Admin enters only numbers or special char in name and desc column
  | 1234	 |  567         |
  | %$#^   |  &**         |
  Then Admin gets a Error message alert
  
  Scenario: Validate Cancel/Close(X) icon on Program Details form
  Given Admin is on "Program Details" Popup window
  When Admin clicks Close Icon on Program Details form
  Then Program Details popup window should be closed without saving
  
  #Scenario: Validate Save button on Program Details form
  #Given Admin is on "Program Details" Popup window
  #When Enter all the required fields with valid values and click Save button
  #Then Admin gets a message "Successful Program Created Successfully" alert and able to see the new program added in the data table
  #
  Scenario Outline: Validate Save button on Program Details form
  Given Admin is on "Program Details" Popup window
  When Enter all the required fields with valid values and click Save button "<sheetname>" and <rownumber>
  Then Admin gets a message Successful Program Created Successfully alert and able to see the new program added in the data table "<sheetname>" and <rownumber>
  Examples:
  |sheetname|rownumber|
  | program |   0     |
  #|program  |   1     |
  Scenario: Validate Cancel button on Program Details form
  Given Admin is on "Program Details" Popup window
  When Admin clicks <Cancel>button
  Then Admin can see the Program details popup disappears without creating any program
  #edit program detail
  @Edit_program
  Scenario: Validate Edit Feature
  When Admin clicks <Edit> button on the data table for any row
  Then Admin should see a popup open for Program details to edit
  Scenario: Edit Program Name
  When Admin edits the Name column and clicks save button
  Then Admin gets a message "Successful Program Updated" alert and able to see the updated name in the table for the particular program
  Scenario: Edit Program description
  When Admin edits the Description column and clicks save button
  Then Admin gets a message "Successful Program Updated" alert and able to see the updated description in the table for the particular program
  Scenario: Change Program Status
  When Admin changes the Status and clicks save button
  Then Admin gets a message "Successful Program Updated" alert and able to see the updated status in the table for the particular program
  
  Scenario: Validate invalid values on the text column
  When Admin edits only numbers or special char in name and desc column and clicks save button
  Then Admin gets a Error message alert
  
  Scenario: Validate Cancel button on Edit popup
  When Admin clicks <Cancel>button on edit popup
  Then Admin can see the Program details popup disappears and can see nothing changed for particular program
  
  Scenario: Validate Save button on Edit popup
  When Admin clicks <Save>button on edit popup
  Then Admin gets a message "Successful Program Updated" alert and able to see the updated details in the table for the particular program
 
 # Delete Program
  
  @Delete_Program
  
  
  Scenario Outline: Delete Feature
    When Admin clicks <Delete> button on the data table for any row "<sheetname>" and <rownumber>
    Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion

    Examples: 
      | sheetname | rownumber |
      | program   |         0 |

  Scenario Outline: Validate details for Confirm Deletion form
    When Admin clicks <Delete> button on the data table for any row "<sheetname>" and <rownumber>
    Then Admin should see a message "Are you sure you want to delete <Program name>?"
        Examples: 
      | sheetname | rownumber |
      | program   |         1 |
    
  Scenario: Click Yes on deletion window
  Given Admin is on Confirm Deletion alert
  When Admin clicks <YES> button on the alert
  Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table
  
  Scenario: Click No on deletion window
  Given Admin is on Confirm Deletion alert
  When Admin clicks <NO> button on the alert
  Then Admin can see the deletion alert disappears without deleting
  
  Scenario: Validate Cancel/Close(X) icon on Confirm Deletion alert
  Given Admin is on Confirm Deletion alert
  When Admin clicks Cancel Icon on Deletion alert
  Then Admin can see the deletion alert disappears without any changes
  
   #Multiple Delete
  
  Scenario: Validate Multiple Delete button on header enabled after clicking on any checkbox
When Admin clicks any checkbox in the data table
Then Admin should see common delete option enabled under header Manage Program

Scenario: Validate multiple program deletion by selecting Single checkbox
When Admin clicks <YES> button on the alert for single checkbox select
Then Admin should land on Manage Program page and can see the selected program is deleted from the data table

When Admin clicks <NO> button on the alert for single checkbox select
Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table

Scenario: Validate multiple program deletion by selecting multiple check boxes
When Admin clicks <YES> button on the alert with multi checkbox select
Then Admin should land on Manage Program page and can see the selected program is deleted from the data table

When Admin clicks <NO> button on the alert with multi checkbox select
Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table
  #Pagination

Scenario:  Verify next page link 
When Admin clicks Next page link on the program table 
Then Admin should see the Pagination has Next active link

Scenario: Verify Last page link
When Verify Last page link
Then Admin should see the last page record on the table with Next page link are disabled

Scenario: Verify first page link
When Admin clicks First page link
Then Admin should see the previous page record on the table with pagination has previous page link
#
#Scenario: Verify start page link
#When Admin click Start page link
#Then Admin should see the very first page record on the table with Previous page link are disabled
  
  @sorting
  Scenario Outline: Sorting Programs by "<column>" in Descending order
When Admin clicks on the "<column>" sort icon by 2 clicks
Then Admin should see Program details are sorted by "<column>" Descending order
Examples:
|column|
|Program Name|
|Program Description|
|Program Status|
Scenario Outline: Sorting Programs by "<column>" in Aescending order
When Admin clicks on the "<column>" sort icon by 1 click
Then Admin should see Program details are sorted by "<column>" Aescending order
Examples:
|column|
|Program Name|
|Program Description|
|Program Status|

#Navigation
Scenario: Batch link on navigation bar
When Admin clicks on Batch link on Manage Program page
Then Admin is re-directed to Batch page

Scenario: User link on navigation bar
When Admin clicks on User link on Manage Program page
Then Admin is re-directed to User page

Scenario: Logout link on navigation bar
When Admin clicks on Logout link on Manage Program page
Then Admin is re-directed to Login page
