@168927_RLAP_Applications_Create_Service_User_Complete_all_fields
Feature: TC_168927: RLAP_Applications_Create Service User_Complete all fields

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn

  @168927_RLAP_Applications_Create_Service_User_Complete_all_fields
  Scenario Outline: RLAPApplications Create Service User_Complete all fields
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Applications" from drop down List and navigate to "Applications"
    Then user fill details for "enter any part of a name, service number or UTN" as "Wheeler"
    Then user click on Find
    Then user click on "Add Service User" button
    Then user generate the unique number for "Service No."
    Then user fill details for "Last Name" as "William"
    And user click on "Gender" the Drop Down List
    And user select "Male" from dropdown for "Other"
    And user click on "Title" the Drop Down List
    And user select "Mrs" from dropdown for "Other"
    Then user fill details for "First Name" as "Riya"
    Then user fill details for "Telephone Number" as "0745626131"
    Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
    Then user click on "Vulnerabilities" section
    And user select multiple option "3" for the "vulnerabilities" checkbox
    Then user click on "Disabilities" section
    And user select multiple option "<number of option>" for the "disabilities" checkbox
    Then user click on "Dietary Requirements" section
    And user select multiple option "2" for the "dietaryRequirements" checkbox
    Then user click on "Safeguarding Notes" section
    And user select multiple option "2" for the "safeGuardingNotes" checkbox
    Then user click on "Special Requirements & Medical Needs" section
    And user select multiple option "1" for the "specialRequirements" checkbox
    Then user click on "Vulnerability Flags" section
    And user select multiple option "2" for the "vulnerabilityFlags" checkbox
    Then user click on "Save" button
   And user take the screenshot for confirmation page for Test case "TC_168927"
    Examples: 
      | username      | password          | serviceName | partaddress                | address                                      |
      | RLAPMearsuser | RLAPMearspassword | Portal      | Room 2, 1 Agincourt Avenue | Room 2, 1 Agincourt Avenue, Belfast, BT7 1QA |
