#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_167635_167654_167637_Living_HO_Address_Page-Edit_keys-No_of_sets__key_log_Date
Feature: TC_167635:  Living HO_Address Page - Edit keys - No of sets

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

  @TC_167635_Living_HO_Address_Page-Edit_keys-No_of_sets
  Scenario Outline: Change who has key
    Then user click on edit button under icon name "Keys"
    Then user fill details for "No. of Sets" as "150"
    Then user click on "Save" button

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |

  @TC_167654_Living_HO_Edit_key_log_Date
  Scenario Outline: Change who has key
   When user click on the descending "Date" under tab "Key Log"
    When I capture the initial value of "Date" under "Date"
    Then user click on edit button under icon name "Key Log"
    Then user click the calender and select the slot available "October" "2023" "19"
    Then user click on "Save" button
    When I capture the new updated value of "Date" under "Date"
    And validate the initial value of "Date" is not same as new value

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |

  @TC_167637_Living_HO_Address_Page-Edit_keys_held_by
  Scenario Outline: Living HO_Address Page - Edit keys held by
    When I capture the initial value of "Keys Held By" under "Keys Held By"
    Then user click on edit button under icon name "Keys"
    Then user fill random details for "Keys Held By" as "Generate Keys Held By"
    #Then user fill details for "Keys Held By" as "EditKeyTester"
   Then user click on "Save" button
    When I capture the new updated value of "Keys Held By" under "Keys Held By"
    And validate the initial value of "Keys Held By" is not same as new value

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |
