#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@150542_AASC_HM_Add_Service_User_validation_checks
Feature: TC_166626:   AASC HM_Add Service User validation checks - Saving when no fields completed (Edit last)

  Background: 
    Given User Navigate to MCMView App

  @150542_AASC_HM_Add_Service_User_validation_checks
  Scenario Outline:  AASC HM_Add Service User validation checks - Saving when no fields completed (Edit last)
      And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "AASC_HMexpansion"
    And user select "Add Service User" from drop down List and navigate to "Service User Details"
    Then user click on save button
    Then user validate the Alert message for "Service User Details"
      | A Valid Nass Reference OR Port Reference is required | A Valid Nass Reference OR Port Reference is required | A valid Last Name is required | A valid Gender is required |
    Then user fill details for "Last Name" as "William"
    And user click on "Gender" the Drop Down List
    And user select "Female" from dropdown
    Then user click the  calender and select DOB for "<setmonth>" "<setyear>" "<setDate>"
    Then user click on save button
    Then user validate the Alert message for "NASS Reference"
      | A Valid Nass Reference OR Port Reference is required |
    Then user validate the Alert message for "Port Reference"
      | A Valid Nass Reference OR Port Reference is required |
    And user select multiple option "1" for the "underSixWeeksOld" checkbox
    Then user click on save button
    Then user validate the Alert message for "Date of Birth"
      | User is older than 6 weeks |
    Then user generate the unique number for "NASS Reference"
    And user click on "Country of Origin" the Drop Down List
    And user select "United States of America" from dropdown
    Then user fill details for "Telephone Number" as "+A745626131"
    Then user validate the Alert message for "Telephone Number"
      | Must be a valid Telephone Number |
    Then user click on "Vulnerabilities" section
    And user select multiple option "<number of option>" for the "vulnerabilities" checkbox
    Then user click on save button
    Then user validate the Alert message for "Telephone Number"
      | Must be a valid Telephone Number |
    Then user validate the Alert message for "Date of Birth"
      | User is older than 6 weeks |

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                | downloadpath                                                | setmonth | setyear | setDate | number of option |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. | C:/Users/neha.sain/OneDrive - Mears Group/Desktop/image.jpg | May      |    2023 |      19 |                3 |
