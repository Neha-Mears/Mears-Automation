@168928_RLAP_Service_User_Complete_a_request_Standard_due_date_RLAP_Mears
Feature: TC_167630: RLAP Mears_Address Page - Add keys marking 1 as default

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn
    And I click on Mear Logo home Page

  @168928_RLAP_Service_User_Complete_a_request_Standard_due_date_RLAP_Mears
  Scenario Outline: RLAP Mears_Address Page - Add keys marking 1 as default
    When user search "<partaddress>" and "<address>" click on the address details for new version
    Then Scroll down and click on expansion panel header button for "RLAPMearsthreedots" with ""
    And user select "View Service User" from drop down List and navigate to "Service User"
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Task Dashboard" from drop down List and navigate to "Task Dashboard"
    And I click on Filter Tasks in Task Dashboard
    When I click on "Service User" under Association
    Then user enter the "wheelerfrrri" in "value_1" text box
    Then user enter the "testing12344555" in "value_2" text box
    Then user click on Find
    Then I select the bottom owner "wheelerfrrri" under Owner details
    Then user click on "Continue" button
    Then user click on "Apply" button
    Then Validate the "" is added shows as "list__wrapper" for "Complete Request"
    And user take the screenshot for confirmation page for Test case "148445"


    Examples: 
      | username      | password          | serviceName | partaddress                | address                                      |
      | RLAPMearsuser | RLAPMearspassword | Portal      | Room 2, 1 Agincourt Avenue | Room 2, 1 Agincourt Avenue, Belfast, BT7 1QA |
