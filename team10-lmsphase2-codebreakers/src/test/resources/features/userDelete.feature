Feature: Navigation to 'Manage User' and validating its deleting functionality 
As a Admin
I want to able to navigate to the 'Manage User' page 
So that I can access its deleting functionality

Background:
Given Admin is on dashboard page after Login and clicks User on the navigation bar

Scenario: Validate Row level delete icon on  Manage User Page
When Admin clicks the delete icon on row level in Manage User Page
Then Admin should see a alert open with heading Confirm along with  <YES> and <NO> button for deletion

Scenario: Validate No on Confirm Deletion Window
When Admin clicks the row level delete icon after selecting the user and clicks "no" option
    | U100 |
Then Admin can see the deletion alert disappears without deleting user

Scenario: Validate Close icon on Confirm Deletion Window
When Admin clicks the row level delete icon after selecting the user and clicks "close" option
  | U100 |
Then Admin can see the deletion alert disappears without any changes in Manage Users

 Scenario:  Validate Yes on Confirm Deletion Window
When Admin clicks the row level delete icon after selecting the user and clicks "yes" option
    | U100 |
 Then Admin gets a message <Successful User Deleted> alert and do not see that the user in the data table

#------------------------------------------------------------------------------------------------------------------------------------------
Scenario: Validate Delete button on header enabled
When Admin clicks any checkbox in the data table in Manage User
Then Admin should see common delete option enabled under header in Manage Program

Scenario: Validate No on Confirm Deletion Window for muliple user deletion
When Admin clicks the delete icon under header after selecting the multiple user and clicks "no" option
    | U100 |
|U106|
Then Admin can see the deletion alert disappears without deleting user

Scenario: Validate Yes on Confirm Deletion Window for muliple user deletion
When Admin clicks the delete icon under header after selecting the multiple user and clicks "yes" option
|U100 |
|U106|
Then Admin gets a message <Successful User Deleted> alert and do not see that user in the data table

Scenario: Validate Close icon on Confirm Deletion Window for muliple user deletion
When Admin clicks the delete icon under header after selecting the multiple user and clicks "close" option
|U100 |
|U106|
Then Admin gets a message <Successful User Deleted> alert and do not see that user in the data table











