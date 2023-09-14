#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@166624_166622_AASC_HM_Add_Service_User_and_edit_Nass
Feature: TC_166624:  AASC HM_Add Service User and edit - Nass re

  Background: 
    Given User Navigate to MCMView App

  @166624_AASC_HM_Add_Service_User_and_edit_Nass
  Scenario Outline: AASC HM_Add Service User and edit - Nass re
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    Then select navapp "<serviceName>"
    When user search "<address>" and click on the address details
    ########################################################################
    Then Scroll down and click on expansion panel header button for "AASC_HMexpansion"
    And user select "Add Service User" from drop down List and navigate to "Service User Details"
    Then user fill details for "Last Name" as "William"
    And user click on "Gender" the Drop Down List
    And user select "Female" from dropdown
    Then user generate the unique number for "Port Reference"
    Then user click the  calender and select DOB for "<setmonth>" "<setyear>" "<setDate>"
    And user click on "Country of Origin" the Drop Down List
    And user select "United States of America" from dropdown
    Then user fill details for "Telephone Number" as "0745626131"
    Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
    Then user click on "Vulnerabilities" section
    And user select multiple option "<number of option>" for the "vulnerabilities" checkbox
    Then user click on "Disabilities" section
    And user select multiple option "<number of option>" for the "disabilities" checkbox
    Then user click on save button
    ###########2############################################
    Then Scroll down and click on expansion panel header button for "AASC_HMexpansion"
    And user select "Edit Service User" from drop down List and navigate to "Edit Service User"
    Then user fill details for "Telephone Number" as "0747626031"
    Then user click on save button

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                | downloadpath                                                | setmonth | setyear | setDate | number of option |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. | C:/Users/neha.sain/OneDrive - Mears Group/Desktop/image.jpg | May      |    2023 |      19 |                3 |

  @166622_AASC_HM_Add_Service_User_and_edit_Nass
  Scenario Outline: AASC HM_Add Service User and edit - Nass re
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    Then select navapp "<serviceName>"
    When user search "<address>" and click on the address details
    ########################################################################
    Then Scroll down and click on expansion panel header button for "AASC_HMexpansion"
    And user select "Add Service User" from drop down List and navigate to "Service User Details"
    Then user fill details for "Last Name" as "William"
    And user click on "Gender" the Drop Down List
    And user select "Female" from dropdown
    Then user generate the unique number for "Port Reference"
    Then user click the  calender and select DOB for "<setmonth>" "<setyear>" "<setDate>"
    And user click on "Country of Origin" the Drop Down List
    And user select "United States of America" from dropdown
    Then user fill details for "Telephone Number" as "0745626131"
    Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
    Then user click on "Vulnerabilities" section
    And user select multiple option "<number of option>" for the "vulnerabilities" checkbox
    Then user click on "Disabilities" section
    And user select multiple option "<number of option>" for the "disabilities" checkbox
    Then user click on save button
    ###########2############################################
    Then Scroll down and click on expansion panel header button for "AASC_HMexpansion"
    And user select "Edit Service User" from drop down List and navigate to "Edit Service User"
     Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
    Then user click on save button

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                | downloadpath                                                | setmonth | setyear | setDate | number of option |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. | C:/Users/neha.sain/OneDrive - Mears Group/Desktop/image.jpg | May      |    2023 |      19 |                3 |
