#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@150541_166626
Feature: TC_150541: AASC HM_Add Service User - Port ref - Done

  Background: 
    Given User Navigate to MCMView App

  @150541_AASC_HM_Add_Service_User_Port_ref-Done
  Scenario Outline: AASC HM_Add Service User - Port ref - Done
    Given User Navigate to MCMView App
    And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "SSSA10 DA" and "SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version
    Then Scroll down and click on expansion panel header button for "AASC_HMexpansion" with "Service Users"
    And user select "Add Service User" from drop down List and navigate to "Service User Details"
    Then user fill details for "Last Name" as "William"
    And user click on "Gender" the Drop Down List
    And user select "Male" from dropdown for "Other"
    Then user generate the unique number for "Port Reference"
    And user click on "Title" the Drop Down List
    And user select "Mrs" from dropdown for "Other"
    Then user fill details for "First Name" as "Riya"
    Then user click the  calender and select DOB for "<setmonth>" "<setyear>" "<setDate>"
    And user click on "Country of Origin" the Drop Down List
    And user select "United States of America" from dropdown for "Other"
    And user click on "Language" the Drop Down List
    And user select "Armenian" from dropdown for "Other"
    And user click on "Religion" the Drop Down List
    And user select "Buddhism" from dropdown for "Other"
    Then user fill details for "Telephone Number" as "0745626131"
    Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
    And user click on "Application Status" the Drop Down List
    And user select "Approved" from dropdown for "Other"
    And user click on "Accommodation Status" the Drop Down List
    And user select "Current" from dropdown for "Other"
    And user select multiple option "1" for the "foodPacks" checkbox
    Then user click on "Vulnerabilities" section
    And user select multiple option "<number of option>" for the "vulnerabilities" checkbox
    Then user click on "Disabilities" section
    And user select multiple option "<number of option>" for the "disabilities" checkbox
    Then user click on "Save" button
    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                | downloadpath                                                | setmonth | setyear | setDate | number of option |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. | C:/Users/neha.sain/OneDrive - Mears Group/Desktop/image.jpg | April    |    2023 |      19 |                3 |

  @166626_AASC_HM_Add_Service_User_validation_checks_Date_of_birth_cant_be_in_the_future
  Scenario Outline: AASC HM_Add Service User validation checks - Date of birth cant be in the future
    Given User Navigate to MCMView App
    And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "SSSA10 DA" and "SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version
    Then Scroll down and click on expansion panel header button for "AASC_HMexpansion" with "Service Users"
    And user select "Add Service User" from drop down List and navigate to "Service User Details"
    Then user click the  calender and select DOB for "<setmonth>" "<setyear>" "<setDate>"

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                | downloadpath                                                | setmonth  | setyear | setDate | number of option |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. | C:/Users/neha.sain/OneDrive - Mears Group/Desktop/image.jpg | September |    2023 |      12 |                3 |
