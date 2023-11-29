#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@150658_AASC_HM_Add_a_Complaint_Made_By_the_Service_User_against_a_staff_member
Feature: TC_150658: AASC HM_Add a Complaint Made By the Service User against a staff member

  Background: 
    Given User Navigate to MCMView App

  @TC_150658_AASC_HM_Add_a_Complaint_Made_By_the_Service_User_against_a_staff_member
  Scenario Outline: Make sure User is able to Login
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "AASC_HMexpansion" with "Service User Support"
    And user select "View Complaints" from drop down List and navigate to "Complaints"
    Then user varify the following grids is displayed
      |  | Reference | Registered Date | Category | Status | Acknowledged | Resolved |
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
    Then user click on the pencil icon
    Then user validate the fields "Complaint Made By" and "Complaint Made Against is disabled"
    And user click on "Status" the Drop Down List
    And user select "Complete" from dropdown for "Other"
    Then user validate the popup "<text>" and popup "<message>"
     Then user click on "Save" button
    And user click on Ok appointment page
    Then user validate the Alert message for "Edit Complaint"
      | A valid outcome is required |
    Then user fill details for "Outcome" as "ComplaintMadeByUser"
    Then user click on "Save" button
  #  When I verify values under the "Registered Date" column
   # Then I should see the value "04/10/2023"
 #   When I verify values under the "Category" column
  #  Then I should see the value "Landlord"
  #  When I verify values under the "Status" column
    #Then I should see the value "Complete"
   # When I verify values under the "Resolved" column
    #Then I should see the value "04/10/2023"
    And user take the screenshot for confirmation page for Test case "TC_150658"

    Examples: 
      | username        | password        | serviceName | address                                                                  | text                              | message                                                          | setmonth | setyear | setDate | success_msg                  |  |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Complaint Status Set to Complete. | Please ensure you have specified an outcome and a resolved date. | August   |    2023 |      29 | The operation was successful |  |
