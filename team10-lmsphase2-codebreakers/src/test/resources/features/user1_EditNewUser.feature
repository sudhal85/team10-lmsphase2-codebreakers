
	Feature: Valiidate Edit User 
	Background: Admin is on dashboard page after Loginvand clicks User on the navigation bar

	Scenario: Verify the presence of Edit/Delete icon	
		Given: User is on any page after Login	
		When User is on the Manage user page after clicking User Tab	
		Then User should see the buttons with edit/delete icon in each row of Edit/Delete coulmn


	Scenario: Updating with Edit button	
		Given: User table is displayed in manage user page	
		When User clicks Edit button	
		Then "User Details" dialog box should be displayed for editing
    
 
  