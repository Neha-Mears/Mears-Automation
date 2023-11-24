#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@164833_165331_165902_AASC_HM_&_RLAP_Raise_an_Incident_against_Other_&_AASC_HM_Can_edit_an_existing_incident_raised_by_SU_and_set_it_to_Complete
Feature: TC_164833_165331: AASC HM  Raise an Incident against Other and an existing incident raised

  Background: 
    Given User Navigate to MCMView App

  @164833_165331_165902_AASC_HM_&_RLAP_Raise_an_Incident_against_Other_&_AASC_HM_Can_edit_an_existing_incident_raised_by_SU_and_set_it_to_Complete
  Scenario Outline: AASC HM  Raise an Incident against Other and an existing incident raised
    # Given user login to Home Mears Page
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<ExpansionPanel>" with "Service User Support"
    And user select "View Incidents" from drop down List and navigate to "Incident"
    ##pre-condition
    Then user varify the following grids is displayed
      | Reference | Status | Category | Date of Incident | Date of Outcome |
    Then Click on "Incidents" expansion button
    And user select "Raise Incident Against" from drop down List and navigate to "Add Incident"
    Then user varify the following grids is displayed in Add Incident
      | Add Incident | Incident Raised By | Incident Raised Against | Date of Incident | Status | Date of Incident | Category | Incident Description |
    Then user click on "Save" button
    Then user validate the Alert message for 'Add Incident'
      | Valid incident raised by required | A valid date of incident is required | A valid category is required | A valid incident description is required | A valid status is required |
    Then user fill details for "Other" as "test"
    And user click on "Category" the Drop Down List
    And user select "ASB by SU" from dropdown for "Other"
    Then user click the calender and select the slot available "<setmonth>" "<setyear>" "<setDate>"
    And user click on "Status" the Drop Down List
    And user select "Active" from dropdown for "Other"
    Then user fill details for "Incident Description" as "testingDemo"
    Then user click on "Save" button
    Then user varify the following grids is displayed
      | Reference | Status | Category | Date of Incident | Date of Outcome |
    Then user varify the following grids and information appears
      | Reference | Status | Category | Date of Incident | Date of Outcome |
    ##pre-condition
    Then user click on the pencil icon
    Then user validate the fields "Incident Raised By" and "Incident Raised Against"
    And user click on "Status" the Drop Down List
    And user select "Complete" from dropdown for "Other"
    And user click on Ok appointment page
    Then user validate the popup "<text>" and popup "<message>"
    Then user click on "Save" button
    Then user validate the Alert message for 'Add Incident'
      | A valid outcome is required |
    Then user fill details for "Outcome" as "IncidentUserDemo"
    Then user click on "Save" button
    When I verify values under the "Status" column
    Then I should see the value "Complete"
    When I verify values under the "Category" column
    Then I should see the value "ASB by SU"
    When I verify values under the "Date of Incident" column
    Then I should see the value "04/10/2023"
    And user take the screenshot for confirmation page for Test case "TC_164833_165331_165902"

    Examples: 
      | username        | password          | serviceName | ExpansionPanel   | address                                      | text                               | message                                                          | setmonth | setyear | setDate | success_msg                  |
      | AASC_HMusername | AASC_HMpassword   | Portal      | AASC_HMexpansion | Room 3, 1 Agincourt Avenue, Belfast, BT7 1QA | Incident Status Set to Completed.. | Please ensure you have specified an outcome and a resolved date. | October  |    2023 |       4 | The operation was successful |
      | RLAPMearsuser   | RLAPMearspassword | Portal      | RLAPMearsuser    | Room 3, 1 Agincourt Avenue, Belfast, BT7 1QA | Incident Status Set to Completed.. | Please ensure you have specified an outcome and a resolved date. | October  |    2023 |       4 | The operation was successful |
