#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_149267_149254:Living_HO_Active_Work_Orders_&_Notes_Change_from_10_to_25_items_per_page
Feature: TC_167635:  Mark key as no longer held

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "Living_HO_username" and "Living_HOpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "Room 16, St Catherine" and click on the address details

  @TC_149267:Living_HO_Active_Work_Orders_Change_from_10_to_25_items_per_page
  Scenario Outline: Change who has key
    Then Click on "Property Details" expansion button
    And user select "View Property" from drop down List and navigate to "Property"
    When I click on "previous-work-details__job-detail"
    And user select "25" from dropdown for "Other"

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |

  @TC_149254:Living_HO_Notes_Change_from_10_to_25_items_per_page
  Scenario Outline: Change who has key
    Then Click on "Property Details" expansion button
    And user select "View Property" from drop down List and navigate to "Property"
    When I click on "notes-panel__wrapper"
    And user select "25" from dropdown for "Other"

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |
