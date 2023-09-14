#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@164833_165331_165902_AASC_HM_&_RLAP_Raise_an_Incident_against_Other_&_AASC_HM_Can_edit_an_existing_incident_raised_by_SU_and_set_it_to_Complete
Feature: TC_164833_165331: AASC HM  Raise an Incident against Other and an existing incident raised

  @164833_165331_165902_AASC_HM_&_RLAP_Raise_an_Incident_against_Other_&_AASC_HM_Can_edit_an_existing_incident_raised_by_SU_and_set_it_to_Complete
  Scenario Outline: AASC HM  Raise an Incident against Other and an existing incident raised
    # Given user login to Home Mears Page
    Given User Navigate to MCMView App
    And user enter valid MCMview "<username>" and "<password>"
    And click on LogIn
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Propertiy Tab"
    When user search "<address>" and click on the address details
     Then Scroll down and click on expansion panel header button for "<username>"
    And user select "View Incidents" from drop down List and navigate to "Incident Tab"
      ##pre-condition
       Then user varify the following grids is displayed
      | Reference | Status | Category | Date of Incident | Date of Outcome |
    Then Click on "Incidents" expansion button
    And user select "Raise Incident Against" from drop down List and navigate to "Add Incident"
    Then user varify the following grids is displayed in Add Incident
      | Add Incident | Incident Raised By | Incident Raised Against | Date of Incident | Status | Date of Incident | Category | Incident Description |
    Then user click on save button
    Then user validate the Alert message for Add Incident
      | Valid incident raised by required | A valid date of incident is required | A valid category is required | A valid incident description is required | A valid status is required |
    Then user fill details for "Other" as "test"
    And user click on "Category" the Drop Down List
    And user select "ASB by SU" from dropdown
    Then user click the calender and select the slot available "<setmonth>" "<setyear>" "<setDate>"
    And user click on "Status" the Drop Down List
    And user select "Active" from dropdown
    Then user fill details for "Incident Description" as "testingDemo"
    Then user click on save button
    Then user varify the following grids is displayed
      | Reference | Status | Category | Date of Incident | Date of Outcome |
    Then user varify the following grids and information appears
      | Reference | Status | Category | Date of Incident | Date of Outcome |
    ##pre-condition
    Then user click on the pencil icon
    Then user validate the fields "Incident Raised By" and "Incident Raised Against"
    And user click on "Status" the Drop Down List
    And user select "Complete" from dropdown
    Then user validate the popup "<text>" and popup "<message>"
    Then user click on save button
    Then user validate the Alert message for Add Incident
      | A valid outcome is required |
    Then user fill details for "Outcome" as "IncidentUserDemo"
    Then user click on save button
    When I verify values under the "Status" column
    Then I should see the value "Complete"
    When I verify values under the "Category" column
    Then I should see the value "ASB by SU"
    When I verify values under the "Date of Incident" column
    Then I should see the value "25/08/2023"
    And user take the screenshot for confirmation page

    Examples: 
      | username          | password           | serviceName | address                                                                  | text                               | message                                                          | setmonth | setyear | setDate | success_msg                  |
    #  | MCMViewHMUsername | MCMAppUserPassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Incident Status Set to Completed.. | Please ensure you have specified an outcome and a resolved date. | August   |    2023 |      25 | The operation was successful |
      | RLAPMearsuser     | RLAPMearspassword  | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Incident Status Set to Completed.. | Please ensure you have specified an outcome and a resolved date. | August   |    2023 |      29 | The operation was successful |
