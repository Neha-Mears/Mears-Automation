#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@122904_Living_AM-Add_Address-Plexus_MHM
Feature: TC_122387: Living AM- Edit Tenant - Comm details - Add comms type to an address

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "Living_AM_username" and "Living_AMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"

  @122904_Living_AM-Add_Address-Plexus_MHM
  Scenario: Living AM- Edit Tenant - Comm details - Add comms type to an address
    And user select "Add Address" from drop down List and navigate to "Add Property"
    Then user search "101" and "Add Address" for Add Property
    And user click on "Portfolio" the Drop Down List
    And user select "Plexus MHM" from dropdown for "Other"
    Then I click on "5" checkbox for Contract Name
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    Then user fill details for "Room / Building" as "166"
    Then user fill details for "Postcode" as "ex1 3ut"
    Then user fill details for "Location" as "MK"
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    And user click on "Marketing Office" the Drop Down List
    And user select "Plexus - MH Waltham Forest" from dropdown for "Other"
    And user click on "Property Type" the Drop Down List
    And user select " Apartment " from dropdown for "Other"
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    Then user enter the "Wheeler" in "value_2" text box
    Then user click on Find
    Then user click on "Add New" button
    And user click on "Title" the Drop Down List
    And user select "Dr" from dropdown for "Other"
    Then user fill details for "First Name" as "Stu"
    Then user fill details for "Surname" as "Wheeler"
    And I click on checkbox Include closed task under Task for this Address "quick-owner-search-address-card__wrapper"
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    Then Scroll down and click on expansion panel header button for "Communication Details" with ""
    And user select "Add Communication" from drop down List and navigate to "Communication Details"
    And user click on "Type" the Drop Down List
    And user select "Email" from dropdown for "Other"
    Then user fill details for "Detail" as "neha.hitesh@gmail.com"
    Then user click on "Save" button
    Then Validate the "" is added shows as "Communication Details" for "neha.hitesh@gmail.com"
    Then Click on "stepper-buttons__wrapper" the "Next" button in Add Property
    Then user click on "Submit" button
