#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :RLAP Mears_Can edit an existing complaint rasied against Other and set it to Complete
#Feature: List of scenarios.
@TC165901_RLAP_Mears_Can_edit_an_existing_complaint_rasied_against_Other_and_set_it_to_Complete
Feature: TC_165901: RLAP Mears_Can edit an existing complaint rasied against Other and set it to Complete

  Background: 
    Given User Navigate to MCMView App

  @TC165901_RLAP_Mears_Can_edit_an_existing_complaint_rasied_against_Other_and_set_it_to_Complete
  Scenario Outline: RLAP Mears_Can edit an existing complaint rasied against Other and set it to Complete
    #Given user login to Home Mears Page
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<username>"
    And user select "View Complaints" from drop down List and navigate to "Complaints"
    Then Click on "Complaints" expansion button
    ############################################
    And user select "Raise Complaint By" from drop down List and navigate to "Add Complaint"
    Then user "Staff Member" field in the "Complaint Made Against" section
    Then user enter the "Stuart Wheeler" in "Name" text box
    Then user click on Find
    Then user validate the Continue button is disabled
    Then user Select the "Stuart Wheeler" whom the complaint is against and click "Continue" button
    Then user click on save button
    And user click on "Status" the Drop Down List
    And user select "Archived" from dropdown
    Then user click the calender and select the slot available "<setmonth>" "<setyear>" "<setDate>"
    And user click on "Category" the Drop Down List
    And user select "Landlord" from dropdown
    Then user fill details for "Complaint Description" as "UserDemotestNotes"
    Then user click on save button
    #############################################
    #  # pre-condition status set to Archived
    Then user click on the pencil icon
    Then user validate the fields "Complaint Made By" and "Complaint Made Against is disabled"
    And user click on "Status" the Drop Down List
    And user select "Complete" from dropdown
    Then user validate the popup "<text>" and popup "<message>"
    Then user click on save button
    Then user fill details for "Outcome" as "ComplaintMadeByUser"
    And user take the screenshot for confirmation page

    Examples: 
      | username      | password          | serviceName | address                                                                  | text                              | message                                                          | setmonth | setyear | setDate | success_msg                  |
      #  | MCMViewHMUsername | MCMAppUserPassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Complaint Status Set to Complete. | Please ensure you have specified an outcome and a resolved date. | August   |    2023 |      29 | The operation was successful |
      | RLAPMearsuser | RLAPMearspassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Complaint Status Set to Complete. | Please ensure you have specified an outcome and a resolved date. | August   |    2023 |      29 | The operation was successful |
