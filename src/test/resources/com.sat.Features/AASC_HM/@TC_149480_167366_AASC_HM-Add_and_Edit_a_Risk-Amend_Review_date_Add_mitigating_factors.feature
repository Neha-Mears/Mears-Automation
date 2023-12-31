#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_149480_167366_AASC_HM-Add_and_Edit_a_Risk-Amend_Review_date_Add_mitigating_factors
Feature: TC_146367: AASC HM- Add risk assessment and risk and then Edit the Risk - Add person at risk

  Background: 
    Given User Navigate to MCMView App

  @TC_149480_167366_AASC_HM-Add_and_Edit_a_Risk-Amend_Review_date_Add_mitigating_factors
  Scenario Outline: Living HO - Edit Tenant - Add Language_Google Chrome and Tick_support_needs and Add How employed
     And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "SSSA10 DA" and "SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version
    Then Scroll down and click on expansion panel header button for "<username>" with "Service User Support"
    And user select "View Risk Assessments" from drop down List and navigate to "Risk Assessments"
    Then Click on "Risk Assessments" expansion button
    And user select "Add Risk Assessment" from drop down List and navigate to "Add Risk"
    Then verify all tabs appearing on the Add risk Assessment popup page
      | Add New Risk Assessment | Risk associated tenancy | Created On |
    Then Click on "Risk" risk expansion button
    And user select "Add Risk" from drop down List and navigate to "Add New Risk"
    Then user fill details for "Aggravating Factors" as "Stutest"
    Then user fill details for "Details" as "Demotestformandatoryfield"
    Then user click the calender and select the slot "<setmonth>" "<setyear>" "<setDate>"
    Then user click on "Save" button
    Then user click on the edit icon under "Risk"
    Then user delete "Details" content and verify save button is enable
    Then user fill details for "Details" as "Demotestformandatoryfield"
    Then user fill details for "Mitigating Factors" as "Emergency factor"
    Then user fill details for "Incidents" as "Immediate"
    Then user fill details for "Person at Risk" as "Prisk"
     Then user click on "Save" button
    Then user click on "Risk Details" button
    Then user varify the following grids is displayed
      | Details: | Aggravating Factors: | Mitigating Factors: | Incidents: | Review Date: |
    Then user varify the following grids is displayed
      | Demotestformandatoryfield | Stutest | Emergency factor | Immediate | 29/08/2023 |

    # When I set the "Details" to "Generate Details"
    Examples: 
      | username           | password          | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | Living_HM_username | Living_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
