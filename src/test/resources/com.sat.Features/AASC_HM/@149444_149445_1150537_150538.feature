#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@149444_149445_1150537_150538
Feature: TC_149444:  AASC HM_View Service User - Done

  Background: 
    Given User Navigate to MCMView App

  @149444_149445
  Scenario Outline: AASC HM_Edit Service User - Add Email address - Done
    # Given user login to Home Mears Page
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<username>"
    And user select "Edit Service User" from drop down List and navigate to "Service User Details"
    Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
    Then user click on save button

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                |  |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |  |

  @150537_150538
  Scenario Outline: AASC HM_Service User View and Edit a secondary (Non-Primary) Service User - Done and Religion and Safeguarding -Done
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<username>"
    And user select "Edit Service User" from drop down List and navigate to "Service User Details"
    Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
    And user click on "Ethnicity" the Drop Down List
    And user select "Asian" from dropdown
    Then user click on cancel button
    Then user click the  calender and select DOB for "<setmonth>" "<setyear>" "<setDate>"
    And user click on "Religion" the Drop Down List
    And user select "Hinduism" from dropdown
    Then user click on "Dietary Requirements" section
    And user select multiple option "<number of option>" for the "dietaryRequirements" checkbox
    Then user click on "Safeguarding Notes" section
    And user select multiple option "<number of option>" for the "safeGuardingNotes" checkbox
    Then user click on save button

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                | downloadpath                                                | setmonth | setyear | setDate | number of option |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. | C:/Users/neha.sain/OneDrive - Mears Group/Desktop/image.jpg | April    |    2023 |      19 |                3 |
