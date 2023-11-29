#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
#Pre-condition - Always provide the new address to run this code.
@TC_168933_168936_RLAP_Mears_Add_Address_with_4_contracts_and_existing_owner_DA_and_SSFA_selected,Mears_Approval_Yes
Feature: Testing of RLAP Mears keys tap

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"

  @TC_168933_168936_RLAP_Mears_Add_Address_with_4_contracts_and_existing_owner_DA_and_SSFA_selected,Mears_Approval_Yes
  Scenario: Living HO_ Edit key log - Add and edit notes
    And user select "Add Address" from drop down List and navigate to "Add Property"
    Then user search "101" and "Add Address" for Add Property
    And user click on "Portfolio" the Drop Down List
    And user select "AASC" from dropdown for "Other"
    Then I click on "4" checkbox for Contract Name
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    Then user fill details for "Room / Building" as "6711"
    Then user fill details for "Postcode" as "ex1 3ut"
    Then user fill details for "Location" as "Exeter"
   Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    And user click on "Marketing Office" the Drop Down List
    And user select "AASC" from dropdown for "Other"
    And user click on "Property Type" the Drop Down List
    And user select " Apartment " from dropdown for "Other"
    And user click on "Property Usage" the Drop Down List
   And user select "SSSA" from dropdown for "Other"
    ##And user select multiple option "1" for the "newHome" checkbox in Add Property
    And user select multiple option "1" for the "da" checkbox in Add Property
    Then user fill details for "Rent" as "1300"
    Then user fill details for "Bed Spaces" as "2"
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    Then user enter the "Wheeler" in "value_2" text box
    Then user click on Find
    Then I select the bottom owner "wheeler" under Owner details
    Then user click on "Select" button
   Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    Then user click on "Submit" button
    #serach
    And Click on the Menu expansion button in Home page
   # Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "6711,  Exeter" and "6711,  Exeter,  Devon,  England,  EX1 3UT" click on the address details for new version
    And I click on checkbox Include closed task under Task for this Address "tasks-panel__wrapper"
    Then Validate the "" is added shows as "tasks-panel__wrapper" for "Open"
    ###correction required compkleyted
    Then user click on "Yes / No" button
    Then user fill details for "Reason notes" as "Yes, property should go for DIO approval"
    Then user click on pop-up "Yes" button window
