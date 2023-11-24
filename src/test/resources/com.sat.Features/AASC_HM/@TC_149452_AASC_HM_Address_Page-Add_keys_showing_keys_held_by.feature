#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_149452_AASC_HM_Address_Page-Add_keys_showing_keys_held_by
Feature: AASC HM_Address Page - Add keys showing keys held by

  Background: 
    Given User Navigate to MCMView App

  @TC_149452_AASC_HM_Address_Page-Add_keys_showing_keys_held_by
  Scenario Outline: Make sure User is able to Login
    And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "SSSA10 DA" and "SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version
    Then Click on "Property Details" expansion button
    And user select "Key Details" from drop down List and navigate to "Keys"
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |
    Then user click on plus icon in keys tab
    And user select multiple option "1" for the "default" checkbox
    And user click on "Key Type" the Drop Down List
    And user select "Garage" from dropdown for "Other"
    Then user fill details for "No. of Sets" as "1"
    Then user generate the unique number for "Reference"
    Then user fill details for "Keys Held By" as "Finaltest"
    Then user click on "Save" button

    Examples: 
      | username           | password          | serviceName | address                                                                  |
      | Living_HM_username | Living_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN |
