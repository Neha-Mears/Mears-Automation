#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_167725_167632_Edit_key_log-Mark_key_as_returned_&_supplier_added
Feature: TC_167725: Living HO_Edit key log - Mark key as returned

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
    Then user fill random details for "Notes" as "Generate Random Notes"
    And user click on "Key" the Drop Down List
    And user select "File Reference | 478219211" from dropdown for "Other"
    Then user fill details for "Who Has Key" as "Owner"
    And user click on "Booked Out By" the Drop Down List
    And user select "Adam Lucas" from dropdown for "Other"
     Then user fill details for "Supplier" as "Abbotts Estate Agent (C5304D0715)"
    And user click on "Supplier" the Drop Down List
    And user select "Abbotts Estate Agent (C5304D0715)" from dropdown for "Other"
    Then user fill random details for "Notes" as "Generate Random Notes"
    Then user click on "Save" button
    And user take the screenshot for confirmation page for Test case "TC_167652"

  @TC_167725_Edit_key_log-Mark_key_as_returned
  Scenario Outline: Living HO_Edit key log - Mark key as returned
   When user click on the descending "Date" under tab "Key Log"
   Then user verify checkbox is checked under Returned "Key Log"
    Then user click on edit button under icon name "Key Log"
    And user select multiple option "1" for the "returned" checkbox
   Then user click on "Save" button
    Then user verify checkbox is checked under Returned "Key Log"

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |
