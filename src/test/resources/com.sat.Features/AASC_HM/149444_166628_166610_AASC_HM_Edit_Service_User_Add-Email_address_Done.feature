#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@149444_166628_166610
Feature: TC_149444: AASC HM_Edit Service User - Add Email address - Done

  Background: 
    Given User Navigate to MCMView App

  @149444_AASC_HM_Edit_Service_User_Add_Email_address_Done
  Scenario Outline: AASC HM_Edit Service User - Add Email address - Done
    # Given user login to Home Mears Page
     And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<username>"
    And user select "View Service User" from drop down List and navigate to "Service User (stuart reteststues. Application Status: )"
    Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
    Then user click on save button

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                |  |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |  |

  @166628_AASC_HM_Add_Service_User_validation_checks_Invalid_telephone_no
  Scenario Outline: AASC HM_Add Service User validation checks - Invalid telephone no
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "AASC_HMexpansion"
    And user select "Add Service User" from drop down List and navigate to "Service User Details"
    Then user click the  calender and select DOB for "<setmonth>" "<setyear>" "<setDate>"
    Then user fill details for "Telephone Number" as "+A745626131"
    Then user click on save button
      Then user validate the Alert message for "Telephone Number"
      | Must be a valid Telephone Number |
     

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                | downloadpath                                                | setmonth  | setyear | setDate | number of option |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. | C:/Users/neha.sain/OneDrive - Mears Group/Desktop/image.jpg | September |    2023 |      19 |                3 |

  @166610_AASC_HM_Edit_Service_User_Add_Tel_No_Done
  Scenario Outline:  AASC HM_Edit Service User - Add Tel No - Done
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "AASC_HMexpansion"
    And user select "Add Service User" from drop down List and navigate to "Service User Details"
    Then user click the  calender and select DOB for "<setmonth>" "<setyear>" "<setDate>"
    Then user fill details for "Telephone Number" as "+A745626131"
    Then user click on save button
      Then user validate the Alert message for "Telephone Number"
      | Must be a valid Telephone Number |
      Then user fill details for "Telephone Number" as "0754626131"
      Then user click on save button

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                | downloadpath                                                | setmonth  | setyear | setDate | number of option |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. | C:/Users/neha.sain/OneDrive - Mears Group/Desktop/image.jpg | September |    2023 |      19 |                3 |
