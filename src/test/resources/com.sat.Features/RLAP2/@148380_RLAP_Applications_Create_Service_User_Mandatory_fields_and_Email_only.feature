@148380_RLAP_Applications_Create_Service_User_Mandatory_fields_and_Email_only
Feature: TC_148380:   RLAP_Applications_Create Service User_Mandatory fields and Email only

  Background: 
    Given User Navigate to MCMView App

  @148380_RLAP_Applications_Create_Service_User_Mandatory_fields_and_Email_only
  Scenario Outline: RLAP_Applications_Create Service User_Mandatory fields and Email only
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Applications" from drop down List and navigate to "Applications"
    Then user fill details for "enter any part of a name, service number or UTN" as "Wheeler"
    Then user click on Find
    And user select "Add Service User" from drop down List and navigate to "Service User Details"
    Then user click on "Save" button
    Then user validate the Alert message for "Service User Details"
      | A Valid reference is required | A valid Last Name is required | A valid Gender is required |
    Then user generate the unique number for "Service No."
    Then user fill details for "Last Name" as "William"
    And user click on "Gender" the Drop Down List
    And user select "Male" from dropdown for "Other"
    Then user fill details for "Telephone Number" as "0745626131"
    Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
   Then user click on "Save" button

    Examples: 
      | username      | password          | serviceName |  |
      | RLAPMearsuser | RLAPMearspassword | Portal      |  |
