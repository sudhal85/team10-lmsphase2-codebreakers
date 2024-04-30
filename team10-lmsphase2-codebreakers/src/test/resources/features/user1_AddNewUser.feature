
Feature: User Details
Scenario: Verify the heading of User details window	 	

Given: User is on Manage user page	
When User clicks A Add new user button	
Then User should see User details window with heading "User Details"

Scenario: Verify the presence of Cancel button in user detais window	
Given: User is on Manage user page	
When User clicks A Add new user button	
Then User should see a button with text Cancel in user details window

Scenario: Fucntionality of Cancel button	
Given: User is on User details window	
When User clicks A cancel button	
Then User details window should be closed

Scenario: Verify the presence of Cancel(x) icon in user detais window	
Given: User is on Manage user page	
When User clicks A Add new user button	
Then User should see a cancel(x) in user details window
#5
Scenario: Fucntionality of Cancel(x) icon
Given:User is on User details window	
When User clicks A cancel(X) icon	
Then User details window should be closed


Scenario: Verify the presence of Submit button in user detais window	
Given: User is on Manage user page	
When User clicks A Add new user button	
Then User should see a button with text Submit in user details window


Scenario: Verify the presence of input fields
Given:	User lands on Manage user page	
When User clicks A Add new user button	
Then User should see the input fields for "First name","Middle name", Last name","Email adress","Phone no", "Address","City", "State","Postal Code"."Program","UG Program","PG Program","Skill","Experience","User Role",Visa status","Batch","Comments" corresponding to their labels

Scenario: Verify the presence of Label Texts
Given: User lands on Manage user page	
When User clicks A Add new user button	
Then User should see the placeholders with Text

Scenario: verify drop down menu	State
Given: User is on "User details" window	
When User clicks the drop down icon for state	
Then User should select from the drop down menu


Scenario: verify drop down menu Role
Given: User is on "User details" window	
When User clicks the drop down icon for User Role	
Then User should select from the role drop down menu

Scenario: Adding new User	
Given: User is on "User details" window	
When User clicks Save button by entering all valid values in required fields	
Then New User Should be Saved. 


Scenario: Validating the presence of Address2 button	
Given: User is on the Manage user page after clicking User Tab
When User clicks A Add new user button	
Then User should see the button with text "+ Add C/O, Apt, Suite, Unit"


Scenario: Validating Address2 in User details window	
Given: User is on "User details" window	
When User clicks the button + Add CO, Apt, Suite, Unit	
Then User should see the input field with Label Address2

Scenario: Validating Empty form submission
Given User is on "User details" window
When User Clicks save button with all the fields empty
Then User should see a message "Mandatory Fields cannot be empty"
    
    
    
    