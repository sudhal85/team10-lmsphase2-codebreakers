

Feature: User page validation
  
 Scenario Outline: Validate landing in User page
 Background:  Logged on the LMS portal as admin
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should see a heading with text "Manage user" on the page
   
 		Scenario Outline: Validate the header in User page
 	 Given Admin is on dashboard page after Login
   When Admin clicks "User" from navigation bar
   Then Admin should see a heading with text "Manage user" on the page
 
 #		Scenario Outline: Validate pagination icon 
    #Given Admin is on dashboard page after Login
    #When Admin clicks "User" from navigation bar
    #Then Admin should see text Showing x to y of z entries along with pagination icon on Manage User page
 
 #	Scenario Outline: Verify pagination has Next page link
    #Given Admin is on dashboard page after Login
    #When Admin clicks "User" from navigation bar
    #Then Admin should see the pagination has Next link on the manage User page
  #
   #Scenario Outline: Verify Next page link is disabled on clicking last page record
   #Given Admin is on dashboard page after Login
   #When Admin clicks "User" from navigation bar
   #Then Admin should see next page link disabled on clicking last page record on the manage User page
  #
   #Scenario Outline: Verify pagination has Previous page link
   #Given Admin is on dashboard page after Login
   #When Admin clicks "User" from navigation bar
   #Then Admin should see the pagination has Previous link on the manage User page
   #
   #Scenario Outline: Verify Admin can see previous link disabled on clicking first page record
   #Given Admin is on dashboard page after Login
   #When Admin clicks "User" from navigation bar
   #Then Admin should see previous page link disabled on clicking first page record on the manage User page
 
   Scenario Outline: Validate data table headers in the User Page
   Given Admin is on dashboard page after Login
   When Admin clicks "User" from navigation bar
   Then Admin Should see the data table with column names Id, Name, location, Phone Number, Edit/Delete
	
		 
 Scenario Outline: Validating the default state of Delete button
 	 Given Admin is on dashboard page after Login
   When Admin clicks "User" from navigation bar
   Then Admin should see disabled delete icon on the manage User page
    
 Scenario Outline: Validate add New user button in User Page
 	  Given Admin is on dashboard page after Login
   When Admin clicks "User" from navigation bar
    Then Admin should see "Add New User" button on the manage User page

  
 Scenario Outline: Validate add Assign Staff button in User Page
 	 Given Admin is on dashboard page after Login
   When Admin clicks "User" from navigation bar
   Then Admin should see "Add New Staff" button on the manage User page
 
   
 Scenario Outline: Validate "+ Assign Student"  button in User page
 	  Given Admin is on dashboard page after Login
   When Admin clicks "User" from navigation bar
    Then Admin should see "Add New Staff" button on the manage User page
  
 Scenario Outline: Validate search box in User page
 	 Given Admin is on dashboard page after Login
   When Admin clicks "User" from navigation bar
  Then Admin should see search bar on the manage User page
  
   
 Scenario Outline: Validate number of data rows in the data table
 	 Given Admin is on dashboard page after Login
   When Admin clicks "User" from navigation bar
   Then Admin should see two  records displayed on the data table
   
 Scenario Outline: Verify Check box on the data table
 	 Given Admin is on dashboard page after Login
   When Admin clicks "User" from navigation bar
    Then Admin should see check box on the left side in all rows of the data table 
   
 Scenario Outline: Verify edit icon on the data table
 	 Given Admin is on dashboard page after Login
   When Admin clicks "User" from navigation bar
   Then Edit Icon in each row of data table only  when entries are available for "User"
   
 Scenario Outline: Verify delete icon on the data table
 	 Given Admin is on dashboard page after Login
   When Admin clicks "User" from navigation bar
  Then Delete Icon in each row of data table only  when entries are available for "User"
   
 Scenario Outline: Verify search user by name
 Background: Admin is on dashboard page after Login and clicks User on the navigation bar
 	 Given Admin is on Manage User Page
   When Admin enters user name into search box.
   Then  Admin should see user displayed with the entered name
   
 Scenario Outline: Verify search user by ID
 Background: Admin is on dashboard page after Login and clicks User on the navigation bar
 	 Given Admin is on Manage User Page
   When Admin enters user ID into search box.
   Then  Admin should see zero entries on the data table
   
 Scenario Outline: Verify search user by Location
 Background: Admin is on dashboard page after Login and clicks User on the navigation bar
 	 Given Admin is on Manage User Page
   When Admin enters user Location into search box.
   Then  Admin should see zero entries on the data table
   
 Scenario Outline: Verify search user by Phone number
 Background: Admin is on dashboard page after Login and clicks User on the navigation bar
 	 Given Admin is on Manage User Page
   When  Admin enters user phone number into search box.
   Then  Admin should see zero entries on the data table
   
 Scenario Outline: Validating the Search with unrelated keyword
 Background: Admin is on dashboard page after Login and clicks User on the navigation bar	
 	 Given Admin is on Manage User Page
   When Admin enters the keywords not present in the data table on the Search box 
   Then  Admin should see zero entries on the data table
   
   
   
   
   
   
   
   
   
   
   
 
