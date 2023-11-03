#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_167727_167634_who_has_key_Update_&_booked_out_by_&_Edit_key_reference
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
    Then user click the calender and select the slot available "October" "2023" "11"
    Then user fill details for "Who Has Key" as "Owner"
    And user click on "Booked Out By" the Drop Down List
    And user select "Adam Lucas" from dropdown for "Other"
    And user click on "Key" the Drop Down List
    And user select "File Reference | 478219211" from dropdown for "Other"
    Then user fill random details for "Notes" as "Generate Random Notes"
   Then user click on "Save" button

  @TC_167634_Living_HO_Address_Page-Edit_key_reference
  Scenario Outline: Edit key reference
    When I capture the initial value of "Reference" under "Reference"
    Then user click on edit button under icon name "Keys"
    Then user generate the unique number for "Reference"
   Then user click on "Save" button
    When I capture the new updated value of "Reference" under "Reference"
    And validate the initial value of "Reference" is not same as new value
    And user take the screenshot for confirmation page for Test case "TC_167634"

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |

  @TC_167727_Living_HO_Edit_key_log-Update_booked_out_by
  Scenario Outline: Living HO_Edit key log - Update booked out by
    Then user click on the plus icon under "Key Log"
    Then user click the calender and select the slot available "October" "2023" "19"
    And user click on "Key" the Drop Down List
    And user select "File Reference | 478219211" from dropdown for "Other"
    Then user fill details for "Who Has Key" as "TenantNew"
    And user click on "Booked Out By" the Drop Down List
    And user select "Adam Lucas" from dropdown for "Other"
    Then user click on "Save" button
    When user click on the descending "Booked Out By" under tab "Key Log"
    When I capture the initial value of "Returned" under "Key Log"
    When user click on the descending "Returned" under tab "Key Log"
    Then user click on edit button under icon name "Key Log"
    And user click on "Booked Out By" the Drop Down List
    And user select "Call Centre" from dropdown for "Other"
   Then user click on "Save" button
    When I capture the new updated value of "Key Log" under "Key Log"
    And validate the initial value of "Booked Out By" is not same as new value
    And user take the screenshot for confirmation page for Test case "TC_1677327"

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |
