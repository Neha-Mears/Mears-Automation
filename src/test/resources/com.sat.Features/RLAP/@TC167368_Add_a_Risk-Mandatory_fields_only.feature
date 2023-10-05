#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC167368_Add_a_Risk-Mandatory_fields_only
Feature: AASC HM & RLAP & Living-HO - Add a Risk - Mandatory fields only

  Background: 
    Given User Navigate to MCMView App

@TC167368_Add_a_Risk-Mandatory_fields_only
  Scenario Outline: Make sure User is able to Login
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<username>"
    And user select "View Risk Assessments" from drop down List and navigate to "Risk Assessments"
    Then Click on "Risk Assessments" expansion button
    And user select "Add Risk Assessment" from drop down List and navigate to "Add New Risk Assessment"
    Then user click on save button
    Examples: 
      | username           | password           | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | RLAPMearsuser      | RLAPMearspassword  | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
