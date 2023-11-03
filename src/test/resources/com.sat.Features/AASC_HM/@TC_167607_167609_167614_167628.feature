#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_167607_167609_167614_167628
Feature: AASC HM_Address Page - Add keys 

  Background: 
    Given User Navigate to MCMView App

 @TC_167607_167609_167614_167628_AASC_HM_Address_Page-Add_keys 
  Scenario Outline: Make sure User is able to Login
    And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "SSSA10 DA" and "SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version
    Then Click on "Property Details" expansion button
    And user select "Key Details" from drop down List and navigate to "Keys"
    Then user validate below field are displayed under Service User
      | AASC - Northern Ireland | SSSA10 DA , DA STREET, Gloucester, Gloucestershire, GL13NN, England | Property | Keys |
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |
    Then user click on the edit icon under "Alarm Details"
    Then user generate the unique number for "Code Access Number"
    When I set the "Alert Password" to "Generate Alert Password"
    When I set the "False Alarm Password" to "Generate False Alarm Password"
    Then user click on "Save" button
    Then user click on plus icon in keys tab
    Then user fill details for "Keys Held By" as "Finaltest"
    Then user click on "Save" button
    Then user validate the Alert message for "Add Key"
      | A valid key type is required | Number of sets is required | A valid reference is required |
    And user select multiple option "1" for the "default" checkbox
    And user select multiple option "1" for the "noLongerHeld" checkbox
    Then user generate the unique number for "Reference"
    And user click on "Key Type" the Drop Down List
    And user select "Garage" from dropdown for "Other"
    Then user fill details for "No. of Sets" as "1"
   Then user click on "Save" button
    Examples: 
      | username           | password          | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | Living_HM_username | Living_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |