Feature: Navigation to 'Manage User' and validating its 'Assign Student' functionality 
As a Admin
I want to able to navigate to the 'Manage User' page 
So that I can access its 'Assign Student' functionality

Background:
Given Admin is on dashboard page after Login and clicks User on the navigation bar

Scenario: Validate Assign Student Popup window
When Admin clicks Assign Student button
Then Admin should see a pop up open for assign student details with empty form along with Save, Cancel button and close icon in the window

Scenario: Validate input fields and their text boxes in Assign Student form Popup window
When Admin clicks Assign Student button
Then Admin should see User Role as R03,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes

Scenario: Validate Assign Student Popup window Form for Radio buttons
When Admin clicks Assign Student button
Then Admin should see two radio button for Status

Scenario: Form Submission for without any data
Given Admin is in Assign Student details pop up page
When Admin clicks Save button without entering any data
Then Admin gets a Error message alert

Scenario Outline: Form Submission for without selecting program
Given Admin is in Assign Student details pop up page
When Admin clicks Save button without selecting Program Name for "<Student_EmailId>"
Then Admin gets a Error message alert as Program Name is required
        Examples:
      |Student_EmailId |
      |arna09@gmail.com|

Scenario Outline: Form Submission for without selecting batch
Given Admin is in Assign Student details pop up page
When Admin clicks Save button without giving BatchName  for "<Student_EmailId>"
Then Admin gets a Error message alert as BatchName is required
     Examples:
      |Student_EmailId |
      |amirkhan@gmail.com|

Scenario Outline: Form Submission without status
Given Admin is in Assign Student details pop up page
When Admin clicks Save button by giving  "<Student_EmailId>" 
Then Admin gets a Error message alert as Status is required
      Examples: 
      | Student_EmailId|              
      |amirkhan@gmail.com| 			
    
      
     Scenario Outline: Form Submission by closing wihtout saving the Form
    Given Admin is in Assign Student details pop up page
    When Admin clicks Close(X) Icon on Assign Student form for "<student>"
    Then Assign Student popup window should be closed without saving
     Examples:
      | student |
      |amirkhan@gmail.com|
     
      
     Scenario Outline: Form Submission by cancelling wihtout saving the Form
    Given Admin is in Assign Student details pop up page
    When Admin clicks Cancel Icon on Assign Student form for "<student>"
    Then Assign Student popup window should be closed without saving
     Examples:
      |student |
      |amirkhan@gmail.com|
 







