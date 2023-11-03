#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_122403_167652_167653
Feature: TC_122403:Living HO_ Add alarm details

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "Living_HO_username" and "Living_HOpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "Room 16, St Catherine" and click on the address details
    Then Click on "Property Details" expansion button
    And user select "Key Details" from drop down List and navigate to "Keys"


   @TC_167637_Living_HO_Address_Page-Edit_keys_held_by
  Scenario Outline: Living HO_Address Page - Edit keys held by
    When I capture the initial value of "Keys Held By" under "Keys Held By"
    Then user click on edit button under icon name "Keys"
    #Then user fill details for "Keys Held By" as "EditKeyTester"
     Then user fill random details for "Keys Held By" as "Generate Keys Held By"
    Then user click on save button
    When I capture the new updated value of "Keys Held By" under "Keys Held By"
 #   And validate the initial value of "Keys Held By" is not same as new value

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |
