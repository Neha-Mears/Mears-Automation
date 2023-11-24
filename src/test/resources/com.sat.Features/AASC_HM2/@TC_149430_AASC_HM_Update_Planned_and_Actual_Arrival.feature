#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_149430:AASC_HM_Update_Planned_and_Actual_Arrival
Feature: TC_167635:  Mark key as no longer held

  Background: 
    Given User Navigate to MCMView App
     And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
      When user search "SSSA10 DA" and "SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version

  @TC_149430:AASC_HM_Update_Planned_and_Actual_Arrival
  Scenario: Change who has key
   Then Scroll down and click on expansion panel header button for "Tenancy Detail" with ""
    And user select "Update Planned Arrival" from drop down List and navigate to ""
    And the user chooses to update the date "one" week later
    And user click on Ok appointment page
    Then Scroll down and click on expansion panel header button for "Tenancy Detail" with ""
     And user select "Update Actual Arrival" from drop down List and navigate to ""
    And the user chooses to update the date "two" week later 
    And user click on Ok appointment page
   
    
   