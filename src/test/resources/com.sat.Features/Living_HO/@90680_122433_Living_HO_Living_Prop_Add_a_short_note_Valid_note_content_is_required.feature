#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@90680_122433:Living_HO_Living_Prop_Add_a_short_note_Valid_note_content_is_required
Feature: TC_90680_122433:: Living HO_Living_Prop_Add a short note & Valid note content is required

  Background: 
    Given User Navigate to MCMView App

 @90680_122433:Living_HO_Living_Prop_Add_a_short_note_Valid_note_content_is_required
  Scenario Outline:  Living HO_Living_Prop_Add a short note & Valid note content is required
      And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Click on "Tenancy Details" expansion button
    And user select "View Tenancy" from drop down List and navigate to "Tenancy"
    Then Click on "Tenancy Details" expansion button
    And user select "Add Note" from drop down List and navigate to "Notes"
    And user click on "Sub Type" the Drop Down List
    And user select "Accounts" from dropdown for "Other"
    And user click on "Type of Note" the Drop Down List
    And user select "Covid" from dropdown for "Other"
   Then user click on "Save" button
    Then user validate the Alert message for "Notes"
      | A valid text entry for the details of the Note is required |
    Then user fill details for "Notes" as "This is Tenancy to Add long Notes from Demo Test for testing purpose"
   Then user click on "Save" button

    Examples: 
      | username           | password          | serviceName | address               | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
