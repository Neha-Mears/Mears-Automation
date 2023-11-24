####Do not run this 
 ##@168527_RLAP_Mears_End_an_Active_Tenancy
Feature: TC_167630: RLAP Mears_Address Page - Add keys marking 1 as default

  Background: 
    Given User Navigate to MCMView App

  @168527_RLAP_Mears_End_an_Active_Tenancy
  Scenario Outline: RLAP Mears_Address Page - Add keys marking 1 as default
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And I click on Mear Logo home Page
    When user search "<partaddress>" and "<address>" click on the address details for new version
  #  Then Validate the "" is added shows as "service-users-list__table" for "Active"
  #  Then Scroll down and click on expansion panel header button for "Tenancy Detail" with ""
  # And user select "End Tenancy" from drop down List and navigate to ""
  #  Then Click on ok pop up window to confirm "RLAPMearsuser"
    Then user click on the Show all checkbox
    Then Validate the "" is added shows as "service-users-list__table" for "Ended"

   
    Examples: 
      | username      | password          | serviceName | partaddress | address                                                                  |
      | RLAPMearsuser | RLAPMearspassword | Portal      | SSFA 1 DA   | SSFA 1 DA , NORTH Road,  Gloucester,  Gloucestershire,  England,  GL13NN |
