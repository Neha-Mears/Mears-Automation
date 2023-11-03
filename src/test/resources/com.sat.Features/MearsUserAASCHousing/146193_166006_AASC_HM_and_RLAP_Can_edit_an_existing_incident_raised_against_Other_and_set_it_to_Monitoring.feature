#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :AASC HM| Can edit an existing complaint rasied by Staff member and set it to Escalated to AIRE
#Feature: List of scenarios.
@TC146193_166006_AASC_HM_and_RLAP_Mears_Can_edit_an_existing_incident_raised_against_Other_and_set_it_to_Monitoring
Feature: TC_146193:AASC HM and RLAP_Mears | Can edit an existing incident raised against Other and set it to Monitoring

  Background: 
    Given User Navigate to MCMView App

  @TC146193_166006_AASC_HM_and_RLAP_Mears_Can_edit_an_existing_incident_raised_against_Other_and_set_it_to_Monitoring
  Scenario Outline: AASC HM and RLAP_Mears| Can edit an existing incident raised against Other and set it to Monitoring
    #Given user login to Home Mears Page
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<ExpansionPanel>" with "Service User Support"
    And user select "View Incidents" from drop down List and navigate to "Incidents"
    Then Click on "Incidents" expansion button
    And user select "Raise Incident Against" from drop down List and navigate to "Add Incident"
    Then user fill details for "Other" as "test"
    And user click on "Category" the Drop Down List
    And user select "ASB by SU" from dropdown for "Other"
    Then user click the calender and select the slot available "<setmonth>" "<setyear>" "<setDate>"
    And user click on "Status" the Drop Down List
    And user select "Active" from dropdown for "Other"
    Then user fill details for "Incident Description" as "testingDemo"
    Then user click on save button
    # # pre-condition status set to Archived
    Then user click on the pencil icon
    Then user validate the fields "Incident Raised By" and "Incident Raised Against"
    And user click on "Status" the Drop Down List
    And user select "<Status_update>" from dropdown for "Other"
    Then user click on save button
    #  When I verify values under the "Status" column
    #  Then I should see the value "<Status_update>"
    And user take the screenshot for confirmation page for Test case "TC146193_166006"

    Examples: 
      | username        | password          | serviceName | ExpansionPanel   | address                                                                  | text                              | message                                                          | setmonth | setyear | setDate | success_msg                  | Status_update |
      | AASC_HMusername | AASC_HMpassword   | Portal      | AASC_HMexpansion | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Complaint Status Set to Complete. | Please ensure you have specified an outcome and a resolved date. | August   |    2023 |      25 | The operation was successful | Monitoring    |
      | RLAPMearsuser   | RLAPMearspassword | Portal      | RLAPMearsuser    | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Complaint Status Set to Complete. | Please ensure you have specified an outcome and a resolved date. | August   |    2023 |      29 | The operation was successful | Monitoring    |
