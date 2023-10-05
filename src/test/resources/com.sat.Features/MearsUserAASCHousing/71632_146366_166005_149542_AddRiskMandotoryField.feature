#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC71632_TC146366_166005_149542
Feature: AASC HM & RLAP & Living-HO - Add a Risk - Mandatory fields only

  Background: 
    Given User Navigate to MCMView App

  @Verify_Staff_user_is_able_to_Login_and_AASC_HM_Rlap_Living_HO_Add_a_Risk_Mandatory_fields_only
  Scenario Outline: Make sure User is able to Login
    # Given user login to Home Mears Page
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<ExpansionPanel>" with "Service User Support"
    And user select "View Risk Assessments" from drop down List and navigate to "Risk Assessments"
    Then Click on "Risk Assessments" expansion button
    And user select "Add Risk Assessment" from drop down List and navigate to "Add Risk"
    Then verify all tabs appearing on the Add risk Assessment popup page
      | Add New Risk Assessment | Risk associated tenancy | Created On |
    Then varify all the values are prsent under Risk Assessment
      | Active | Address | Created On | Completed By | Completed On | Completed By |
    Then Click on "Risk" risk expansion button
    And user select "Add Risk" from drop down List and navigate to "Add Risk"
    Then user fill details for "Aggravating Factors" as "Stutest"
    Then user fill details for "Incidents" as "Broken"
    Then user fill details for "Person at Risk" as "test1"
    Then user click on save button
    # ## Then user able to see "<success_msg>" toaster
    Then user validate the Alert message "<message1>" and "<message2>" for Add New Risk form
    Then user fill details for "Details" as "Demotest"
    Then user click the calender and select the slot "<setmonth>" "<setyear>" "<setDate>"
    Then user click on save button
    Then user click on "Risk Details" button
    ## Then user able to see "<success_msg>" toaster
    Then user verify the field are displayed in Risk Details page
      | Details: | Aggravating Factors: | Mitigating Factors: | Incidents: | Person at Risk: | Review Date: | Active: |
    And user take the screenshot for confirmation page for Test case "TC_71632_TC146366_166005_149542"

    Examples: 
      | username           | password          | serviceName | ExpansionPanel     | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | AASC_HMusername    | AASC_HMpassword   | Portal      | AASC_HMexpansion   | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      18 | The operation was successful |
      | RLAPMearsuser      | RLAPMearspassword | Portal      | RLAPMearsuser      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
      | Living_HO_username | Living_HOpassword | Portal      | Living_HO_username | Room 16, St Catherine                                                    | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
