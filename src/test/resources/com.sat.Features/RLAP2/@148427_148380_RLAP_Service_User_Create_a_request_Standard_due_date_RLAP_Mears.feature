@148427_148380_RLAP_Service_User_Create_a_request_Standard_due_date_RLAP_Mears
Feature: TC_167630: RLAP Mears_Address Page - Add keys marking 1 as default

  Background: 
    Given User Navigate to MCMView App

  @148427_148380_RLAP_Service_User_Create_a_request_Standard_due_date_RLAP_Mears
  Scenario Outline: RLAP Mears_Address Page - Add keys marking 1 as default
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And I click on Mear Logo home Page
    When user search "<partaddress>" and "<address>" click on the address details for new version
    Then Scroll down and click on expansion panel header button for "RLAPMearsthreedots" with ""
    And user select "View Service User" from drop down List and navigate to "Service User"
    Then Scroll down and click on expansion panel header button for "RLAPMearEditServiceUser" with ""
    And user select "Add Request" from drop down List and navigate to "Add Request"
    And user select the "Standard" group from Add Request page
    Then user fill details for "Description" as "Demo test for Add request"
    Then user click the calender and select the slot available "October" "2023" "27"
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
 
    Examples: 
      | username      | password          | serviceName | partaddress | address                                                                  |
      | RLAPMearsuser | RLAPMearspassword | Portal      | SSFA 1 DA   | SSFA 1 DA , NORTH Road,  Gloucester,  Gloucestershire,  England,  GL13NN |
