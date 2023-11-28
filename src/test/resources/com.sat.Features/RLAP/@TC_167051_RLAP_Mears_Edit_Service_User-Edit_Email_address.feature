#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_167051_RLAP_Mears_Edit_Service_User-Edit_Email_address
Feature: RLAP Mears_Edit Service User - Edit Email address

  Background: 
    Given User Navigate to MCMView App

  @TC_167051_RLAP_Mears_Edit_Service_User-Edit_Email_address
  Scenario Outline: RLAP Mears_Edit Service User - Edit Email address
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "RLAPMearsthreedots" with ""
    And user select "Edit Service User" from drop down List and navigate to "Service User Details"
    Then user fill details for "Email Address" as "nehaH.sain@mearsgroup.co.uk"
    Then user click on "Save" button

    Examples: 
      | username      | password          | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | RLAPMearsuser | RLAPMearspassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
