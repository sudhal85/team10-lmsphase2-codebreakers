Feature: Navigation to 'Manage User' and validating its sorting functionality 
As a Admin
I want to able to navigate to the 'Manage User' page 
So that I can access its sorting, deleting, and assigning functionalities

Background:
Given Admin is on dashboard page after Login and clicks User on the navigation bar

Scenario Outline: Sorting Users by "<column>" in Descending order
When Admin clicks on the "<column>" sort icon by 2 clicks in Manage user
Then Admin should see User details are sorted by "<column>" Descending order

Examples:
|column|
|ID|
|Name|
|Location|
|Phone Number|

Scenario Outline: Sorting Users by "<column>" in Aescending order

When Admin clicks on the "<column>" sort icon by 1 click in Manage User
Then Admin should see User details are sorted by "<column>" Aescending order

Examples:
|column|
|ID|
|Name|
|Location|
|Phone Number|


