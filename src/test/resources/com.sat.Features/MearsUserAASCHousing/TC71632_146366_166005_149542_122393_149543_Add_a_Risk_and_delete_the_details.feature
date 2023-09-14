#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_71632_146366_166005_149542_122393_149543_Add_a_Risk_and_delete_the_details
Feature: AASC HM_&_RLAP_Living-HO - Add a Risk

  Background: 
    Given User Navigate to MCMView App

  @TC_149542_149543
  Scenario Outline: Make sure User is able to Login and add mandatory field
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Propertiy Tab"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<username>"
    And user select "View Risk Assessments" from drop down List and navigate to "Risk Assessments"
    Then Click on "Risk Assessments" expansion button
    And user select "Add Risk Assessment" from drop down List and navigate to "Add Risk Tab"
    Then verify all tabs appearing on the Add risk Assessment popup page
      | Add New Risk Assessment | Risk associated tenancy | Created On |
    Then varify all the values are prsent under Risk Assessment
      | Active | Address | Created On | Completed By | Completed On | Completed By |
    Then Click on "Risk" risk expansion button
    And user select "Add Risk" from drop down List and navigate to "Add Risk Tab"
    Then user fill details for "Aggravating Factors" as "Stutest"
    Then user fill details for "Details" as "Demotestformandatoryfield"
    Then user click the calender and select the slot "<setmonth>" "<setyear>" "<setDate>"
    Then user click on save button
    ## Then user able to see "<success_msg>" toaster
    # Then user verify the field are displayed in Risk Details page
    #   | Details: | Aggravating Factors: | Mitigating Factors: | Incidents: | Person at Risk: | Review Date: | Active: |
    Then user click on the edit icon under Risk
    Then user delete "Details" content and verify save button is enable
    Then user click on save button
    Then user validate the Alert message for Add Incident
      | Valid details are required |

    Examples: 
      | username           | password           | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | MCMViewHMUsername  | MCMAppUserPassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      18 | The operation was successful |
      | RLAPMearsuser      | RLAPMearspassword  | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
      | Living_HO_username | Living_HOpassword  | Portal      | Room 16, St Catherine                                                    | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |

  @TC_122393_149543
  Scenario Outline: Make sure User is able to Login and add all field
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Propertiy Tab"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<username>"
    And user select "View Risk Assessments" from drop down List and navigate to "Risk Assessments"
    Then Click on "Risk Assessments" expansion button
    And user select "Add Risk Assessment" from drop down List and navigate to "Add Risk Tab"
    Then verify all tabs appearing on the Add risk Assessment popup page
      | Add New Risk Assessment | Risk associated tenancy | Created On |
    Then varify all the values are prsent under Risk Assessment
      | Active | Address | Created On | Completed By | Completed On | Completed By |
    Then Click on "Risk" risk expansion button
    And user select "Add Risk" from drop down List and navigate to "Add Risk Tab"
    Then user fill details for "Aggravating Factors" as "Stutest"
    Then user fill details for "Incidents" as "Broken"
    Then user fill details for "Person at Risk" as "test1"
    Then user click on save button
    ## Then user able to see "<success_msg>" toaster
    Then user validate the Alert message "<message1>" and "<message2>" for Add New Risk form
    Then user fill details for "Details" as "Demotestforallfield"
    Then user fill details for "Mitigating Factors" as "Risktest"
    Then user click the calender and select the slot "<setmonth>" "<setyear>" "<setDate>"
    Then user click on save button
    ## Then user able to see "<success_msg>" toaster
    # Then user verify the field are displayed in Risk Details page
    #   | Details: | Aggravating Factors: | Mitigating Factors: | Incidents: | Person at Risk: | Review Date: | Active: |
    Then user click on the edit icon under Risk
    Then user delete "Details" content and verify save button is enable
    Then user click on save button
    Then user validate the Alert message for Add Incident
      | Valid details are required |

    Examples: 
      | username           | password           | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | MCMViewHMUsername  | MCMAppUserPassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      18 | The operation was successful |
      | RLAPMearsuser      | RLAPMearspassword  | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
      | Living_HO_username | Living_HOpassword  | Portal      | Room 16, St Catherine                                                    | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
