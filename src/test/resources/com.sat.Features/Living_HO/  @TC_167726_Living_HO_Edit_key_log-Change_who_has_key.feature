#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_167726_Living_HO_Edit_key_log-Change_who_has_key
Feature: TC_167725:  Living HO_Edit key log - Change who has key

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
    Then user click on the plus icon under "Key Log"
    Then user click the calender and select the slot available "October" "2023" "19"
    Then user fill details for "Who Has Key" as "OwnerMo"
    And user click on "Booked Out By" the Drop Down List
    And user select "Adam Lucas" from dropdown for "Other"
    And user click on "Key" the Drop Down List
    And user select "File Reference | 478219211" from dropdown for "Other"
    Then user fill random details for "Notes" as "Generate Random Notes"
   Then user click on "Save" button
  @TC_167726_Living_HO_Edit_key_log-Change_who_has_key
  Scenario Outline: Living HO_Edit key log - Update booked out by
    When user click on the descending "Who has key" under tab "Key Log"
    When I capture the initial value of "Who has key" under "Who has key"
    Then user click on edit button under icon name "Key Log"
    Then user fill random details for "Who Has Key" as "Generate Keys Owner"
    Then user click on "Save" button
     When user click on the descending "Who has key" under tab "Key Log"
    When I capture the new updated value of "Who has key" under "Who has key"
    And validate the initial value of "Who has key" is not same as new value
    And user take the screenshot for confirmation page for Test case "TC_167726"

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |
