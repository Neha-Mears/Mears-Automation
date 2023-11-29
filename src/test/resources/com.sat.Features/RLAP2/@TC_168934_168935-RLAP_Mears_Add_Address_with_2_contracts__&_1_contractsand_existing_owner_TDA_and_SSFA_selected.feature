#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
#Pre-condition - Always provide the new address to run this code.
@TC_168934_168935-RLAP_Mears_Add_Address_with_2_contracts__&_1_contractsand_existing_owner_TDA_and_SSFA_selected
Feature: Testing of RLAP Mears keys tap

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"

 @TC_168934_168935-RLAP_Mears_Add_Address_with_2_contracts__&_1_contractsand_existing_owner_TDA_and_SSFA_selected
  Scenario: Living HO_ Edit key log - Add and edit notes
    And user select "Add Address" from drop down List and navigate to "Add Property"
    Then user search "101" and "Add Address" for Add Property
    And user click on "Portfolio" the Drop Down List
    And user select "AASC" from dropdown for "Other"
    Then I click on "4" checkbox for Contract Name
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    Then user fill details for "Room / Building" as "1349"
    Then user fill details for "Postcode" as "ex1 3ut"
    Then user fill details for "Location" as "Exeter"
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    And user click on "Marketing Office" the Drop Down List
    And user select "AASC" from dropdown for "Other"
    And user click on "Property Type" the Drop Down List
    And user select " Apartment " from dropdown for "Other"
    And user click on "Property Usage" the Drop Down List
    And user select "SSFA" from dropdown for "Other"
    ##And user select multiple option "1" for the "newHome" checkbox in Add Property
    And user select multiple option "1" for the "tda" checkbox in Add Property
    Then user fill details for "Rent" as "1300"
    Then user fill details for "Bed Spaces" as "2"
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    Then user enter the "Wheeler" in "value_2" text box
    Then user click on Find
    Then I select the bottom owner "wheeler" under Owner details
    Then user click on "Select" button
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    Then user varify the following grids is displayed under Confirmation Tab
      | Contracts | New Address Summary | New Property Summary | Owner Summary | Existing Owner Contact |
    Then user click on "Submit" button
    #search
     And I click on Mear Logo home Page
    When user search "1349,  Exeter" and "1349,  Exeter,  Devon,  England,  EX1 3UT" click on the address details for new version
   And I click on checkbox Include closed task under Task for this Address "mat-checkbox task"
    Then Validate the "" is added shows as "tasks-panel__wrapper" for "Open"
    Then user click on "Yes / No" button
    Then user fill details for "Reason notes" as "Yes, property should go for DIO approval"
   Then user click on pop-up "Yes" button window

