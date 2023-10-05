#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@150658_165903_AASC_HM_RLAP_Mears_Add_a_Complaint_Made_By_the_Service_User_against_a_staff_member
Feature: TC_150658_165903: AASC HM_Add a Complaint Made By the Service User against a staff member

  Background: 
    Given User Navigate to MCMView App

  @150658_165903_AASC_HM_RLAP_Mears_Add_a_Complaint_Made_By_the_Service_User_against_a_staff_membe
  Scenario Outline: Make sure User is able to Login
    #Given user login to Home Mears Page
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property"
    When user search "<address>" and click on the address details
   # Then Scroll down and click on expansion panel header button for "<username>"
     Then Scroll down and click on expansion panel header button for "<username>" with "Service User Support"
    And user select "View Complaints" from drop down List and navigate to "Complaints"
    Then user varify the following grids is displayed
      | Reference | Registered Date | Category | Status | Acknowledged | Resolved |
    Then Click on "Complaints" expansion button
    And user select "Raise Complaint By" from drop down List and navigate to "Add Complaint"
    Then user "Staff Member" field in the "Complaint Made Against" section
    Then user enter the "Stuart Wheeler" in "Name" text box
    Then user click on Find
    Then user validate the Continue button is disabled
    Then user Select the "Stuart Wheeler" whom the complaint is against and click "Continue" button
    Then user click on save button
    Then user validate the Alert message for "Add Incident"
      | A valid status is required | A valid complaint received is required | A valid category is required | A valid complaint description is required |
    And user click on "Status" the Drop Down List
    And user select "Archived" from dropdown
    Then user click the calender and select the slot available "<setmonth>" "<setyear>" "<setDate>"
    And user click on "Category" the Drop Down List
    And user select "Landlord" from dropdown
    Then user fill details for "Complaint Description" as "UserDemotestNotes"
    Then user click on save button
    Then Click on "Notes" expansion button
   And user select "Add Note" from drop down List and navigate to "Notes"
    And user click on "Type of Note" the Drop Down List
    And user select "Covid" from dropdown
    And user click on "Sub Type" the Drop Down List
    And user select "Absence" from dropdown
    Then user fill details for "Notes" as "DemotestNotes"
    Then User click on check Box for "Enhanced Confidential Matter"
    Then user click on save button
    #When I verify values under the "Status" column
   # Then I should see the value "<Status_update>"
    And user take the screenshot for confirmation page for Test case "TC150658_165903"

    Examples: 
      | username      | password          | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      #  | MCMViewHMUsername | MCMAppUserPassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |       21 | The operation was successful |
      | RLAPMearsuser | RLAPMearspassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
