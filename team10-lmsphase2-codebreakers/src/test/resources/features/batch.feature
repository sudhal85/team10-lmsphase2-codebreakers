Feature: Batch Page Validation

  Background: 
    Given Logged on the LMS portal

  Scenario: Validate landing in Batch page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the "Manage Batch" in the URL

  Scenario: Validate header in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the "Manage Batch" in the header

  Scenario: Validate pagination in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the pagination controls under the data table

  Scenario: Validate data table headers in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete

  Scenario: Validate Delete button in Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should be able to see the delete icon button that is disabled

  Scenario: Validate "+ A New batch" in Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should be able to see the "A New batch" button

  Scenario: Validate data rows
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Each row in the data table should have a checkbox

  Scenario: Validate data rows
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Each row in the data table should have a edit icon that is enabled

  Scenario: Validate data rows
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Each row in the data table should have a delete icon that is enabled

  Scenario: Validate pop up for adding batch
    Given Admin is on dashboard page after Login
    When Admin clicks "A New Batch" button
    Then A new pop up with Batch details appears

  Scenario: Check if the fields exist in pop up
    Given Admin is on dashboard page and admin clicks on batch and then admin clicks on A New Batch then A new pop up with Batch details appears
    Then The pop up should include the fields Name, Number of classes and Description as text box, Program Name as drop down Status as radio button Number of classes as text box

  Scenario Outline: Check if description is optional field
    Given Admin is on dashboard page and admin clicks on batch and then admin clicks on A New Batch then A new pop up with Batch details appears
    When Fill in all the fields except description with valid values from "<SheetName>" and RowNumber <RowNumber> and click close
    Then The newly added batch should be present in the data table in Manage Batch page

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         0 |

  Scenario Outline: Check if the program details are added in data table
    Given Admin is on dashboard page and admin clicks on batch and then admin clicks on A New Batch then A new pop up with Batch details appears
    When Fill in all the fields except description with valid values from "<SheetName>" and RowNumber <RowNumber> and click save
    Then The newly added batch from "<SheetName>" and RowNumber <RowNumber> should be present in the data table in Manage Batch page and gives "Successful" pop up message

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         1 |
      | Batch     |         2 |
      | Batch     |         3 |
      | Batch     |         4 |
      | Batch     |         5 |

  Scenario Outline: Check for error messages for invalid fields
    Given Admin is on dashboard page and admin clicks on batch and then admin clicks on A New Batch then A new pop up with Batch details appears
    When Fill in any of the fields with invalid values from "<SheetName>" and RowNumber <RowNumber> and click save
    Then Error message should appear

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         6 |

  Scenario Outline: Check for error messages for mandatory fields
    Given Admin is on dashboard page and admin clicks on batch and then admin clicks on A New Batch then A new pop up with Batch details appears
    When Fill in any of the mandatory fields with blank from "<SheetName>" and RowNumber <RowNumber> and click save
    Then Error message should appear and admin validates the error message

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         7 |

  Scenario Outline: Validate row level edit icon
    Given The edit icon on row level in data table is enabled
    When Admin gets the batch name from "<SheetName>" and RowNumber <RowNumber> and clicks the edit icon
    Then A new pop up with Batch details appears

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         1 |

  Scenario Outline: Check if the fields are updated
    Given Admin clicks the edit icon
    When Update the fields with valid values from "<SheetName>" and RowNumber <RowNumber> and click save
    Then The updated batch details from "<SheetName>" and RowNumber <RowNumber> should appear on the data table and gets "Successful" message

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         1 |

  Scenario Outline: Check if the update throws error with invalid values
    Given Admin clicks the edit icon
    When Update the fields with invalid values from "<SheetName>" and RowNumber <RowNumber> and click save
    Then Error messages should appear "This field should start with an alphabet and min 2 character." and "Number of classes is required."

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         2 |

  Scenario Outline: Check if you get error message when mandatory fields are erased
    Given Admin clicks the edit icon
    When admin enters the batch name from "<SheetName>" and RowNumber <RowNumber> to Erase data from mandatory field
    Then Error message "This field should start with an alphabet and min 2 character." should appear

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         2 |

  Scenario Outline: Check if description field is optional in update
    Given Admin clicks the edit icon
    When Erase data from description field passed through "<SheetName>" and RowNumber <RowNumber>
    Then The updated batch details from "<SheetName>" and RowNumber <RowNumber> should appear on the data table

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         2 |

  Scenario Outline: Validate row level delete icon
    Given The delete icon on row level in data table is enabled
    When Admin enters data  from "<SheetName>" and RowNumber <RowNumber> and clicks the delete icon
    Then Alert appears with "Yes" and "No" option

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         1 |

  Scenario Outline: Validate accept alert
    Given Admin enters the data from "<SheetName>" and RowNumber <RowNumber> and clicks the delete icon
    When You click yes option
    Then Batch deleted alert pops "Successful" message and admin enters data from "<SheetName>" and RowNumber <RowNumber> to check batch is no more available in data table

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         1 |

  Scenario Outline: Validate reject alert
    Given Admin enters the data from "<SheetName>" and RowNumber <RowNumber> and clicks the delete icon
    When you click No option
    Then admin enters data from "<SheetName>" and RowNumber <RowNumber> Batch is still listed in data table

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         2 |

  Scenario: Validate the delete icon below the header
    Given None of the checkboxes in data table are selected
    Then The delete icon under the "Manage Batch" header should be disabled

 Scenario Outline: Check for single row delete
    Given admin enters data from "<SheetName>" and RowNumber <RowNumber> One of the checkbox or row is selected
    When Click delete icon below "Manage Batch" header
    Then The respective row in the data table is deleted

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         2 |

  Scenario Outline: Check for multi row delete
    Given admin enters data from "<SheetName>" and RowNumber <RowNumber> Two or more checkboxes or row is selected
    When Click the delete icon below "Manage Batch" header
    Then The respective row from the data table is deleted

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         3 |





