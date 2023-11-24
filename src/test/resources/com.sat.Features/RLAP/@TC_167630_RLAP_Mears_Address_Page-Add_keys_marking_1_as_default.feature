#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_167630_RLAP_Mears_Address_Page-Add_keys_marking_1_as_default
Feature: RLAP Mears_Address Page - Add keys marking 1 as default

  Background: 
    Given User Navigate to MCMView App

  @TC_167630_RLAP_Mears_Address_Page-Add_keys_marking_1_as_default
  Scenario Outline: Make sure User is able to Login
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And I click on Mear Logo home Page
    When user search "Test TOWN" and "Test, Test, Test Test, Test TOWN, TE1 1TE" click on the address details for new version
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
    Then validate the last entry default checkbox is selected

    Examples: 
      | username      | password          | serviceName | address                                                                  |
      | RLAPMearsuser | RLAPMearspassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN |
