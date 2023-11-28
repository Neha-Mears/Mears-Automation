#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_RLAP_148509_Mears_Add_Service_User_note
Feature: Add Service User note

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"

  @TC_RLAP_148509_Mears_Add_Service_User_note
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
     Then user generate the unique number for "UTN"
     And user click on "service" the Drop Down List
   # And user select "Navy" from dropdown for "Other"
   #  And user click on "Assignment Base" the Drop Down List
   # And user select "142 Sqn Banbury, Oxford" from dropdown for "Other"
   # Then user generate the unique number for "UIN"
   #  And user click on "region" the Drop Down List
   # And user select "London" from dropdown for "Other"
  # Then user click on "Save" button
  #  Then Scroll down and click on expansion panel header button for "AllUser" with "notes-panel__wrapper"
   # And user select "Add Note" from drop down List and navigate to "New Note"
   # And user click on "Type of Note" the Drop Down List
  #  And user select "Automate" from dropdown for "Other"
  # And user click on "Sub Type" the Drop Down List
  #  And user select "Appointment" from dropdown for "Other"
   # Then user fill details for "Notes" as "Adding New notes for notes panel for active user for new"
   # Then user validate the "Save" button is enabled
   # Then user click on "Save" button
   # Then user click on "Close" button
  #  Then Validate the "" is added shows as "notes-panel__wrapper" for "Adding New notes for notes panel for active user for new"
