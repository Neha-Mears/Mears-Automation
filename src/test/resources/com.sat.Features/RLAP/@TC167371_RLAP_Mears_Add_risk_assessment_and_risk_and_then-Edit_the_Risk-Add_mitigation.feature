#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC167371_RLAP_Mears_Add_risk_assessment_and_risk_and_then-Edit_the_Risk-Add_mitigation
Feature: RLAP Mears_Add risk assessment and risk and then Edit the Risk - Add mitigation

  Background: 
    Given User Navigate to MCMView App

  @TC167371_RLAP_Mears_Add_risk_assessment_and_risk_and_then-Edit_the_Risk-Add_mitigation
  Scenario Outline: Make sure User is able to Login
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<username>" with ""
    And user select "View Risk Assessments" from drop down List and navigate to "Risk Assessments"
    Then Click on "Risk Assessments" expansion button
    And user select "Add Risk Assessment" from drop down List and navigate to "Add New Risk Assessment"
    Then verify all tabs appearing on the Add risk Assessment popup page
      | Risk associated tenancy | Created On | Completed On |
    Then Click on "Risk" risk expansion button
    And user select "Add Risk" from drop down List and navigate to "Add Risk"
    Then user fill details for "Aggravating Factors" as "Stutest"
    Then user fill details for "Details" as "Demotestformandatoryfield"
    Then user click the calender and select the slot "<setmonth>" "<setyear>" "<setDate>"
    Then user click on "Save" button
    Then user click on the edit icon under 'Risk'
    Then user delete "Details" content and verify save button is enable
    Then user fill details for "Mitigating Factors" as "Emergency factor"
    Then user fill details for "Incidents" as "Immediate"
   Then user click on "Save" button

    Examples: 
      | username      | password          | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | RLAPMearsuser | RLAPMearspassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
