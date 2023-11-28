#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@166627_AASC_HM_Add_Service_User_validation_checks_Country_of_Origin_validation
Feature: TC_166627: AASC HM_Add Service User validation checks - Country of Origin validation

  Background: 
    Given User Navigate to MCMView App

  @166627_AASC_HM_Add_Service_User_validation_checks_Country_of_Origin_validation
  Scenario Outline: AASC HM_Edit Service User - Add Email address - Done
    # Given user login to Home Mears Page
     And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "SSSA10 DA" and "SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version
     Then Scroll down and click on expansion panel header button for "AASC_HMexpansion" with "Service Users"
    And user select "Add Service User" from drop down List and navigate to "Service User Details"
    Then user click on "Save" button
    Then user validate the Alert message for "Service User Details"
      | A Valid Nass Reference OR Port Reference is required | A Valid Nass Reference OR Port Reference is required | A valid Last Name is required | A valid Gender is required |
    Then user fill details for "Last Name" as "William"
    And user click on "Gender" the Drop Down List
    And user select "Female" from dropdown for "Other"
    Then user fill details for "Country of Origin" as "Scotland"
    Then user click on "Save" button
    Then user validate the Alert message for "Country of origin"
      | A valid Country of Origin is required |

   
    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                |  |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |  |
