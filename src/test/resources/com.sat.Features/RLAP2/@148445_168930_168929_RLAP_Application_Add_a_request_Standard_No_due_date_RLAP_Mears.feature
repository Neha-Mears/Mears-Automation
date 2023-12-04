@148445_168930_168929_RLAP_Application_Add_a_request_Standard_No_due_date_RLAP_Mears
Feature: TC :RLAP_Applications_Create Service User_Mandatory fields and Email only

  Background: 
     Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn

@148445_168930_168929_RLAP_Application_Add_a_request_Standard_No_due_date_RLAP_Mears
  Scenario Outline: RLAP_Applications_Create Service User_Mandatory fields and Email only
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Applications" from drop down List and navigate to "Applications"
    Then user fill details for "enter any part of a name, service number or UTN" as "Wheeler"
    Then user click on Find
    When user click on the descending "Status" under tab "staffName"
    Then I select the service user with "Active" application
    Then Scroll down and click on expansion panel header button for "Application Details" with ""
    And user select "Add Request" from drop down List and navigate to "Add Request"
    And user select the "Standard" group from Add Request page
    Then user fill details for "Description" as "Demo test for Add request"
    Then user click the calender and select the slot available "December" "2023" "27"
    Then I select the Current Date from calender for Add Request
    And user click on "Category" the Drop Down List
    And user select "Appointment" from dropdown for "Other"
    And user click on "Sub-category" the Drop Down List
    And user select "Agree Deductions" from dropdown for "Other"
    And user click on "Assigned Team" the Drop Down List
    And user select "Northern Ireland" from dropdown for "Other"
    And user click on "Assigned Staff Member" the Drop Down List
    And user select "AASC Client" from dropdown for "Other"
    And user click on "Assigned Role" the Drop Down List
    And user select "RLAP Mears" from dropdown for "Other"
    Then user click on "Save" button
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
 
 @168929_RLAP_Prop_Details_Complete_a_request_Standard_due_date_RLAP_Mears_Notify_unticked
  Scenario Outline: RLAP_Prop Details_Complete a request_Standard_due date_RLAP Mears_Notify unticked
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
    Then user click on "Complete Request" button
    Then user fill details for "Reason notes" as "Yes, Agree Deductions - Demo test for Add request"
    Then user click on pop-up "Mark as Complete" button window
    And I click on checkbox Include closed task under Task for this Address "ng-star-inserted"
    Then user click on "View Outcome Notes" button
    Then user validate the popup "Outcome Notes" and popup "Yes, Agree Deductions - Demo test for Add request"
     And user click on Ok appointment page

    Examples: 
      | username      | password          | serviceName |
      | RLAPMearsuser | RLAPMearspassword | Portal      |
