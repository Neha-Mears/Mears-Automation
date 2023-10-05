#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC167367_AASC_HM_Address_Page-Add_first_risk_assessment
Feature: AASC HM_Address Page - Add first risk assessment

  Background: 
    Given User Navigate to MCMView App

@TC167367_AASC_HM_Address_Page-Add_first_risk_assessment
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
    Then verify all tabs appearing on the Add risk Assessment popup page
      | Risk associated tenancy | Created On | Completed On |
    Then varify all the values are prsent under Risk Assessment
      | Active | Address | Created On | Completed By | Completed On | Completed By |
   # And user take the screenshot for confirmation page

    Examples: 
      | username      | password          | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
       | Living_HM_username | Living_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
