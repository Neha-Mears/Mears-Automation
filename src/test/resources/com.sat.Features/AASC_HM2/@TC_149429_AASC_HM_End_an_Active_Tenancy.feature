#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_149429:AASC_HM_End_an_Active_Tenancy
Feature: TC_167635:  Mark key as no longer held

  Background: 
    Given User Navigate to MCMView App
     And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
     When user search "SSFA 1 DA" and " SSFA 1 DA , NORTH Road,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version

 @TC_149429:AASC_HM_End_an_Active_Tenancy
  Scenario: Change who has key
  #  Then Validate the "" is added shows as "service-users-list__table" for "Active"
  #  Then Scroll down and click on expansion panel header button for "Tenancy Detail" with ""
  # And user select "End Tenancy" from drop down List and navigate to ""
  #  Then Click on ok pop up window to confirm "RLAPMearsuser"
    Then user click on the Show all checkbox
    Then Validate the "" is added shows as "service-users-list__table" for "Ended"
   
    
   