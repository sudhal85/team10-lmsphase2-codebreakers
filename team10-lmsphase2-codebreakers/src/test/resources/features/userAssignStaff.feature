Feature: Navigation to 'Manage User' and validating its assigning functionality 
As a Admin
I want to able to navigate to the 'Manage User' page 
So that I can access its assigning functionality

Background:
Given Admin is on dashboard page after Login and clicks User on the navigation bar

#Scenario: Validate Assign Student Popup window
#
#When Admin clicks Assign Student button
#Then Admin should see a pop up open for assign student details with empty form along with Save, Cancel button and close icon in the window

#Scenario: Validate input fields and their text boxes in Assign Student form Popup window
#
#When Admin clicks Assign Student button
#Then Admin should see User Role as R03,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes

#Scenario: Validate Assign Student Popup window Form for drop down box ------------------------------

#When Admin clicks Assign Student button
#Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name

#Scenario: Validate Assign Student Popup window Form for Radio buttons
#When Admin clicks Assign Student button
#Then Admin should see two radio button for Status
#
#Scenario: Form Submission for without any data
#Given Admin is in Assign Student details pop up page
#When Admin clicks Save button without entering any data
#Then Admin gets a Error message alert

Scenario Outline: Form Submission for without selecting program
Given Admin is in Assign Student details pop up page
When Admin clicks Save button without selecting Program Name for "<Student_EmailId>"
#|java12@gmail.com|
#|SDET153|
#|Active|
Then Admin gets a Error message alert as Program Name is required
        Examples:
      |Student_EmailId |
      |java12@gmail.com|

#Scenario Outline: Form Submission for without selecting batch
#Given Admin is in Assign Student details pop up page
#When Admin clicks Save button without giving BatchName  for "<Student_EmailId>"
#Then Admin gets a Error message alert as BatchName is required
#     Examples:
#      |Student_EmailId |
#      |java12@gmail.com|
#
#Scenario Outline: Form Submission without status
#Given Admin is in Assign Student details pop up page
#When Admin clicks Save button by giving  "<Student_EmailId>" 
#Then Admin gets a Error message alert as Status is required
#      Examples: 
#      | Student_EmailId|              
#      |java12@gmail.com| 			
      
#             |Program_Name|  |Batch_Name|   
#   		   |Java|                        |SDET153|         
 



# Assign Staff

#Scenario: Empty Form Submission
#When Admin clicks Assign Staff button
#Then Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close (X) icon in the window


#Scenario: Validate the Assign Staff form page without giving Student Email id
#
#Scenario: Validate the Assign Staff form page without giving Skill
#Scenario: Validate the Assign Staff form page without selecting Program
#Scenario: Validate the Assign Staff form page without selecting batch
#Scenario: Validate the Assign Staff form page without giving Status
#Scenario: Validate Cancel/Close(X) icon on Assign Staff form
#Scenario: Validate Save button on Assign Staff form
#Scenario: Validate Cancel button on Assign Staff form
 