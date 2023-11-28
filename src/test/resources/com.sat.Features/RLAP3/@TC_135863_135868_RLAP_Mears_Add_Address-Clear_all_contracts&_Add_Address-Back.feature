#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_135863_135868_RLAP_Mears_Add_Address-Clear_all_contracts&_Add_Address-Back
Feature: RLAP Mears_Add Address - Clear all contracts & Add adress-Back

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"

  @TC_135863_135868_RLAP_Mears_Add_Address-Clear_all_contracts&_Add_Address-Back
  Scenario: RLAP Mears_Add Address - Clear all contracts & Add adress-Back
    And user select "Add Address" from drop down List and navigate to "Add Property"
    Then user search "101" and "Add Address" for Add Property
    And user click on "Portfolio" the Drop Down List
    And user select "AASC" from dropdown for "Other"
    Then user click on "Select All" button
    Then user click on "Clear All" button
    Then user validate the Alert message for 'Add Incident'
      | Please select one or more contracts |
    Then I click on "2" checkbox for Contract Name
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    Then user fill details for "Room / Building" as "56"
    Then user fill details for "Postcode" as "MK8 8JA"
    Then user fill details for "Location" as "MK"
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    And user click on "Marketing Office" the Drop Down List
    And user select "AASC" from dropdown for "Other"
    And user click on "Property Type" the Drop Down List
    And user select " Apartment " from dropdown for "Other"
    And user click on "Property Usage" the Drop Down List
    And user select "SSFA" from dropdown for "Other"
    And user select multiple option "1" for the "da" checkbox in Add Property
    Then user fill details for "Rent" as "1500"
    Then user fill details for "Bed Spaces" as "3"
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    Then Click on "stepper-buttons__wrapper" the "Back" button in Add Property
    Then user validate the Alert message for 'Add Incident'
      | Please enter owner details |
  
