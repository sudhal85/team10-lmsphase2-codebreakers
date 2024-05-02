Feature: Navigation to 'Manage User' and validating its 'Assign Staff'  functionality 
As a Admin
I want to able to navigate to the 'Manage User' page 
So that I can access its 'Assign Staff' functionality

Background:
Given Admin is on dashboard page after Login and clicks User on the navigation bar

Scenario: Navigation to Assign Staff Form and Validate Assign Student Popup window
When Admin clicks Assign Staff button
Then Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close <X> icon in the window

 Scenario: Validate input fields and their text boxes in Assign Staff form Popup window
 When Admin clicks Assign Staff button
Then Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.
   
Scenario: Validate Assign Staff Popup window Form for Radio button
When Admin clicks Assign Staff button
Then Admin should see two radio button for Status
     
Scenario: Form Submission for without any data
Given Admin is in Assign Staff details pop up page
When Admin clicks Save button with entering any data
Then Admin gets a Error message alert for assign staff

Scenario: Validate the Assign Staff form page without giving Student Email id
Given Admin is in Assign Staff details pop up page
 When Admin clicks Save button without giving Email ID
 Then Admin gets a Error message alert as Email ID  is required

Scenario Outline: Validate the Assign Staff form page without selecting Program Name
 Given Admin is in Assign Staff details pop up page
 When Admin clicks save button without giving Program Name  for "<student>"
 Then Admin gets a Error message alert as Program Name is required
     Examples: 
      | student | 
      |rRam@gmail.com| 
      
Scenario Outline: Validate the Assign Staff form page without selecting batch
 Given Admin is in Assign Staff details pop up page
 When Admin clicks save button without giving BatchName  for "<student>" Assign Staff
 Then Admin gets a Error message alert as BatchName is required 
#  
#
     Examples: 
     | student | 
      |rRam@gmail.com| 

Scenario Outline: Validate the Assign Staff form page without selecting status
 Given Admin is in Assign Staff details pop up page
 When Admin clicks Save button without giving Status for "<student>"
 Then Admin gets a Error message alert as Status is required
     Examples: 
      | student | 
      |rRam@gmail.com|
      
Scenario Outline: Form Submission by closing wihtout saving the Form
Given Admin is in Assign Staff details pop up page
When Admin clicks "Close" Icon on Assign Staff form for "<student>"
Then Assign Student popup window should be closed without saving
 Examples: 
  | student | 
  |rRam@gmail.com| 

 Scenario Outline: Form Submission by cancelling wihtout saving the Form
Given Admin is in Assign Staff details pop up page
When Admin clicks "Cancel" Icon on Assign Staff form for "<student>"
Then Assign Student popup window should be closed without saving
	 Examples: 
	  | student | 
	  |rRam@gmail.com| 

