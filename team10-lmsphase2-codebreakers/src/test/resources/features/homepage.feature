Feature: Hompage verification

  Scenario: Verify admin is able to land on home page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin is on the home page

  Scenario Outline: Verify admin is able to land on home page with invalid URL
    Given Admin launch the browser
    When Admin gives the invalid LMS portal  URL "<URL>"
    Then Admin should recieve 404 page not found error

    Examples: 
      | URL                                                           |
      | https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp |

  Scenario: Verify for broken link
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then HTTP response >= 400. Then the link is broken

  Scenario: Verify the text spelling in the page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields

  Scenario: Verify the company logo
    Given Admin launches the LMS application
    When Admin is in homepage
    Then Admin should see logo on the left  side

  Scenario: Verify application name
    Given Admin launches the LMS application
    When Admin is in homepage
    Then Admin should see  LMS - Learning Management System

  Scenario: Verify text displayed in login section in homepage
    Given Admin launches the LMS application
    When Admin is in homepage
    Then Text in login section "Please login to LMS application" is displayed

  Scenario: Verify text above Username field textbox in homepage
    Given Admin launches the LMS application
    When Admin is in homepage
    Then Username field text "User *" is displayed

  Scenario: Verify text above Password field textbox in homepage
    Given Admin launches the LMS application
    When Admin is in homepage
    Then Username field text "Password *" is displayed

  Scenario: Verify alignment of the login button in homepage
    Given Admin launches the LMS application
    When Admin is in homepage
    Then Admin should see login button on the centre of the page

  Scenario: Verify Login is present
    Given Admin launches the LMS application
    When Admin is in homepage
    Then Admin should see login button

  Scenario: verify login button action through keyboard
    Given Admin is in homepage
    When Admin enter valid credentials  and clicks login button through keyboard
    Then Admin should land on dashboard page

  Scenario: verify login button action through mouse
    Given Admin is in homepage
    When Admin enter valid credentials  and clicks login button through mouse
    Then Admin should land on dashboard page

  Scenario Outline: Validate login with invalid credentials- invalid username, invalid password
    Given Admin is in Homepage
    When Admin enter invalid username from "<sheetName>" and <rownumber> and clicks login button
    Then Error message for invalid username and password "please check username/password" is displayed

    Examples: 
      | sheetName | rownumber |
      | Homepage  |         0 |

  Scenario Outline: Validate login with invalid credentials- invalid username, valid password
    Given Admin is in Homepage
    When Admin enter invalid username from "<sheetName>" and valid password <rownumber> and clicks login button
    Then Error message for invalid username "please check username/password" is displayed

    Examples: 
      | sheetName | rownumber |
      | Homepage  |         1 |

  Scenario Outline: Validate login with invalid credentials- valid username, invalid password
    Given Admin is in Homepage
    When Admin enter valid username from "<sheetName>" invalid password <rownumber> and clicks login button
    Then Error message for invalid password "please check username/password" is displayed
    
    Examples: 
      | sheetName | rownumber |
      | Homepage  |         2 |
