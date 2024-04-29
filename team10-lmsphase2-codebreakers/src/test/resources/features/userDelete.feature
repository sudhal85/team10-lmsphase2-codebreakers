Feature: Navigation to 'Manage User' and validating its sorting functionality 
As a Admin
I want to able to navigate to the 'Manage User' page 
So that I can access its sorting, deleting, and assigning functionalities

Background:
Given Admin is on dashboard page after Login and clicks User on the navigation bar

#Scenario: Validate Row level delete icon on  Manage User Page
#When Admin clicks the delete icon on row level in Manage User Page
#Then Admin should see a alert open with heading Confirm along with  <YES> and <NO> button for deletion

#Scenario: Validate No on Confirm Deletion Window
#When Admin is on Confirm Deletion alert and clicks <No> option
#Then Admin can see the deletion alert disappears without deleting

#Scenario: Validate Close icon on Confirm Deletion Window
#When Admin is on Confirm Deletion alert and clicks Close icon
#Then Admin can see the deletion alert disappears without any changes

 Scenario: Deleting single user at row level
    When Admin clicks the row level delete icon after selecting the user and clicks "yes" option
    | U105 |
   
    Then Admin gets a message <Successful User Deleted> alert and do not see that user in the data table

# Scenario: Deleting single user at a time
#    When Admin clicks the delete icon after selecting the users and clicks "yes" option
#      | U58 |
#      | U57 |
#    Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
#    When Admin clicks "Yes" option
#    Then Admin gets a message "Successful User Deleted" alert and do not see that user in the data table