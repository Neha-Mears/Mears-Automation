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
   Given User Navigate to MCMView App
    And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
  #  When user search "SSSA2 DA" and "SSSA2 DA , STREETS STUFF,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version
  When user search "SSSA10 DA" and "SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version
    Then Scroll down and click on expansion panel header button for "<username>" with "Service User Support"
    And user select "Edit Service User" from drop down List and navigate to "Service User Details"
    Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
    Then user click on save button

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                |  |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |  |

  