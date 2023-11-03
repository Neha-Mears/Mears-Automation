#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :AASC HM| Can edit an existing complaint rasied by Staff member and set it to Escalated to AIRE
#Feature: List of scenarios.
@TC146120_166007_AASC_HM_&_RLAP_Can_edit_an_existing_complaint_rasied_by_Staff_member_and_set_it_to_Escalated_to_AIRE
Feature: TC_146120: AASC HM| Can edit an existing complaint rasied by Staff member and set it to Escalated to AIRE

  Background: 
    Given User Navigate to MCMView App

  @TC146120_166007_AASC_HM_&_RLAP_Can_edit_an_existing_complaint_rasied_by_Staff_member_and_set_it_to_Escalated_to_AIRE
  Scenario Outline: ser is on the address page of a property with an existing tenancy and existing complaint raised by Staff member which is not at "Escalated to AIRE or Complete" status
    #Given user login to Home Mears Page
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<ExpansionPanel>" with "Service User Support"
    And user select "View Complaints" from drop down List and navigate to "Complaints"
    Then Click on "Complaints" expansion button
    And user select "Raise Complaint By" from drop down List and navigate to "Add Complaint"
    Then user "Staff Member" field in the "Complaint Made Against" section
    Then user enter the "Stuart Wheeler" in "Name" text box
    Then user click on Find
    Then user validate the Continue button is disabled
    Then user Select the "Stuart Wheeler" whom the complaint is against and click "Continue" button
     Then user click on "Save" button
    And user click on "Status" the Drop Down List
    And user select "Archived" from dropdown for "Other"
    Then user click the calender and select the slot available "<setmonth>" "<setyear>" "<setDate>"
    And user click on "Category" the Drop Down List
    And user select "Landlord" from dropdown for "Other"
    Then user fill details for "Complaint Description" as "UserDemotestNotes"
    Then user click on "Save" button
    #  # pre-condition status set to Archived
    Then user click on the pencil icon
    Then user validate the fields "Complaint Made By" and "Complaint Made Against is disabled"
    And user click on "Status" the Drop Down List
    And user select "Escalated to AIRE" from dropdown for "Other"
     Then user click on "Save" button

    #When I verify values under the "Status" column
    #Then I should see the value "Escalated to AIRE"
    #And user take the screenshot for confirmation page
    Examples: 
      | username        | password          | serviceName | ExpansionPanel   | address                                                                  | text                              | message                                                          | setmonth | setyear | setDate | success_msg                  |  |
      | AASC_HMusername | AASC_HMpassword   | Portal      | AASC_HMexpansion | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Complaint Status Set to Complete. | Please ensure you have specified an outcome and a resolved date. | August   |    2023 |      18 | The operation was successful |  |
      | RLAPMearsuser   | RLAPMearspassword | Portal      | RLAPMearsuser    | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Complaint Status Set to Complete. | Please ensure you have specified an outcome and a resolved date. | August   |    2023 |      29 | The operation was successful |  |
