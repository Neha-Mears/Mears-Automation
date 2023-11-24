#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_168528_168530_RLAP_Mears_Update_Planned_and_Actual_Arrival_Update_Planned_Departure
Feature: RLAP Mears_Update Planned and Actual Arrival

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "SSSA10 DA" and "SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version

@TC_168528_168530_RLAP_Mears_Update_Planned_and_Actual_Arrival_Update_Planned_Departure
  Scenario: RLAP Mears_Update Planned and Actual Arrival
    Then Scroll down and click on expansion panel header button for "Tenancy Detail" with ""
    And user select "Update Planned Arrival" from drop down List and navigate to ""
    And the user chooses to update the date "one" week later
    And user click on Ok appointment page
    Then Scroll down and click on expansion panel header button for "Tenancy Detail" with ""
     And user select "Update Actual Arrival" from drop down List and navigate to ""
    And the user chooses to update the date "two" week later 
    And user click on Ok appointment page
    Then Scroll down and click on expansion panel header button for "Tenancy Detail" with ""
   And user select "Update Planned Departure" from drop down List and navigate to ""
   And the user chooses to update the date "one" week later
    And user click on Ok appointment page
    
