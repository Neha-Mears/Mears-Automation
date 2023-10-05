#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_167052_167054_167059_RLAP_Mears_View_Service_User
Feature: RLAP Mears_Edit Service User - Edit Email address_Accomdation status_ Edit Tel No

  Background: 
    Given User Navigate to MCMView App

  @TC_167052_167054_167059_RLAP_Mears_Edit_Service_User-Edit_Email_address_Accomdation_status_Edit_Tel_No
  Scenario Outline: RLAP Mears_Edit Service User - Edit Email address and Accomdation status
  And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "RLAPMearsthreedots"
    And user select "View Service User" from drop down List and navigate to "Service User"
    Then user validate below field are displayed under Service User
      | AASC - Northern Ireland | SSSA10 DA , DA STREET, Gloucester, Gloucestershire, GL13NN, England | Service User (stuart reteststues) |
    Then Scroll down and click on expansion panel header button for "RLAPMearEditServiceUser"
   And user select "Edit Service User" from drop down List and navigate to "Service User Details"
    Then user validate below field are displayed under Service User
     | AASC - Northern Ireland | SSSA10 DA , DA STREET, Gloucester, Gloucestershire, GL13NN, England | Service User ( stuart reteststues) | Edit Service User |
    And user click on "Accommodation Status" the Drop Down List
    And user select "Current" from dropdown
    Then user fill details for "Telephone Number" as "0745626131"
    Then user click on save button
    

    Examples: 
      | username      | password          | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | RLAPMearsuser | RLAPMearspassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
