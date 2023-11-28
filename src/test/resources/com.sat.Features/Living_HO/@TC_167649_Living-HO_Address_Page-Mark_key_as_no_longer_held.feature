#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_167649_Living-HO_Address_Page-Mark_key_as_no_longer_held
Feature: TC_167635:   Living HO_Address Page - Mark key as no longer held

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
    Then user click on plus icon in keys tab
    Then user generate the unique number for "Reference"
    And user click on "Key Type" the Drop Down List
    And user select "Garage" from dropdown for "Other"
    Then user fill details for "No. of Sets" as "1"
    Then user click on "Save" button

  @TC_167649_Living-HO_Address_Page-Mark_key_as_no_longer_held
  Scenario Outline: Mark key as no longer held
    When user click on the descending "Not Held" under tab "Keys"
    Then the checkbox should not be checked
    Then user click on edit button under icon name "Keys"
    And user select multiple option "1" for the "noLongerHeld" checkbox
   Then user click on "Save" button
    Then the checkbox should be checked

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |
