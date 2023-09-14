#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_90684_122439_Living_HO_Tenancy_Add_a_long_note_validate_note_type_required
Feature: Living-HO - Living HO_Tenancy_Add a long note__A valid Note Type is required

  Background: 
    Given User Navigate to MCMView App

  @TC_90684_122439
  Scenario Outline: Make sure User is able to Login and add a long note and valid note type required
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Propertiy Tab"
    When user search "<address>" and click on the address details
    Then Click on "Tenancy Details" expansion button
    And user select "View Tenancy" from drop down List and navigate to "Tenancy Details screen"
    Then Click on "Tenancy Details" expansion button
    And user select "Add Note" from drop down List and navigate to "Notes header"
    And user click on "Sub Type" the Drop Down List
    And user select "Accounts" from dropdown
    Then user fill details for "Notes" as "This is Tenancy to Add long Notes from Demo Test for testing purpose"
    Then user click on save button
    Then user validate the Alert message for Add Incident
      | A valid Note Type is required |
    And user click on "Type of Note" the Drop Down List
    And user select "Covid" from dropdown
    Then user click on save button

    Examples: 
      | username           | password          | serviceName | address               | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
