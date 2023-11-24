#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_149572_167631_Living_HO_Add_key_log
Feature: TC_167725:   Living HO_Add key log

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
    And user click on "Key Type" the Drop Down List
    And user select "File Reference" from dropdown for "Other"
    Then user generate the unique number for "Reference"
    Then user fill details for "No. of Sets" as "100"
    Then user fill details for "Keys Held By" as "keystest"
    Then user click on "Save" button

  @TC_149572_Living_HO_Add_key_log
  Scenario Outline: Change who has key
    Then user click on the plus icon under "Key Log"
    Then user click the calender and select the slot available "October" "2023" "11"
    Then user fill details for "Who Has Key" as "Owner"
    And user click on "Booked Out By" the Drop Down List
    And user select "Adam Lucas" from dropdown for "Other"
    And user click on "Key" the Drop Down List
    And user select "File Reference | 478219211" from dropdown for "Other"
    Then user fill details for "Supplier" as "Accounts Payable Section (WALFSTC&F)"
    And user click on "Supplier" the Drop Down List
    And user select "Accounts Payable Section (WALFSTC&F)" from dropdown for "Other"
    Then user click on "Save" button

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |

  @TC_167631_Living_HO_Add_key_log_with_notes
  Scenario Outline: Living HO_Add key log with notes
    Then user click on the plus icon under "Key Log"
    Then user click the calender and select the slot available "October" "2023" "11"
    Then user fill details for "Who Has Key" as "Owner"
    And user click on "Booked Out By" the Drop Down List
    And user select "Adam Lucas" from dropdown for "Other"
    And user click on "Key" the Drop Down List
    And user select "File Reference | 478219211" from dropdown for "Other"
    And user select multiple option "1" for the "returned" checkbox
    Then user fill random details for "Notes" as "Generate Random Notes"
    Then user click on "Save" button

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |
