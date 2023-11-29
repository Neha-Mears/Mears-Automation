#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_149288_149293_RLAP_Start_conversation-View_application_Unable_to_contact_1st_time
Feature: Add Service User note

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"

 @TC_149288_149293_RLAP_Start_conversation-View_application_Unable_to_contact_1st_time
  Scenario: Add Service User note
      And user select "Applications" from drop down List and navigate to "Applications"
      Then user fill details for "enter any part of a name, service number or UTN" as "Wheeler"
      Then user click on Find
    And user select "Add Service User" from drop down List and navigate to "Service User Details"
    Then user generate the unique number for "Service No."
    Then user fill details for "Last Name" as "William"
     Then user fill details for "Telephone Number" as "0745626131"
    Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
     And user click on "Gender" the Drop Down List
    And user select "Female" from dropdown for "Other"
     Then user click on "Save" button
     Then user validate the Save button is enabled
     Then user fill details for "Other Preferences" as "Preference enter to enable save"
     Then user validate the Save button is enabled
     And user click on "Application Type" the Drop Down List
     And user select "SSFA" from dropdown for "Other"
     Then user generate the unique number for "utn"
     And user click on "Service" under "Application"
     And user select "Navy" from dropdown for "Other"
     And user click on "Assignment Base" the Drop Down List
     And user select "142 Sqn Banbury, Oxford" from dropdown for "Other"
     Then user generate the unique number for "UIN"
    And user click on "Region" the Drop Down List
     And user select "London" from dropdown for "Other"
    And user click the calender for "dateRequired" for slot available "December" "2023" "14"
    And user click on "Property Band" the Drop Down List
    And user select "B" from dropdown for "Other"
    Then user click on "Save" button
     And Click on the Menu expansion button in Home page
     And user select "Task Dashboard" from drop down List and navigate to "Task Dashboard"
    Then user click on "Contact Service User" button
    Then user fill details for "Notes" as "Notes for Contact Service User"
    Then user click on "Unable To Contact" button
    Then User click on check Box for "mat-checkbox-frame"
    Then Validate the task outcome is false
    Then User click on check Box for "mat-checkbox-frame"
    Then Validate the task outcome is false
  #  And user select "Task Dashboard" from drop down List and navigate to "Task Dashboard"
    Then Scroll down and click on expansion panel header button for "RLAPMearsthreedots" with ""
    And user select "View Application" from drop down List and navigate to "Applications"
    Then user verify view application details
      | Service No | FirstName | Surname | Base Location |
    Then user verify view application details
      | Navy | neha.sain@mearsgroup.co.uk | 142 Sqn Banbury, Oxford | London |
  