#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_167651_122406_Living_HO_Edit_alarm-Code_access_details_&_Address_Page-Edit_key_type
Feature: TC_167651: Living HO_ Edit alarm - Code access details

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "Living_HO_username" and "Living_HOpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "Room 16, St Catherine" and click on the address details
    Then Click on "Property Details" expansion button

  @TC_167651_Living_HO_Edit_alarm-Code_access_details
  Scenario Outline: Living HO_ Edit alarm - Code access details
    And user select "Key Details" from drop down List and navigate to "Keys"
    Then user validate below field are displayed under Service User
      | Mears Housing Management Limited | Property | Keys |
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |
    When I capture the initial value of "Code Access Number" under "Alarm Details"
    Then user click on the edit icon under "Alarm Details"
    Then user generate the unique number for "Code Access Number"
   Then user click on "Save" button
    When I capture the new updated value of "Code Access Number" under "Alarm Details"
    And validate the initial value of "Code Access Number" is not same as new value
    And user take the screenshot for confirmation page for Test case "TC_167651"

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      10 |

  @TC_122406_Living_HO_Address_Page-Edit_key_type
  Scenario Outline: Living HO_Address Page - Edit key type
    And user select "Key Details" from drop down List and navigate to "Keys"
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |
    When I capture the initial value of "Key Type" under "Keys"
    Then user click on edit button under icon name "Keys"
    And user click on "Key Type" the Drop Down List
    And user select "Garage" from dropdown for "Other"
    Then user click on "Save" button
    When I capture the new updated value of "Key Type" under "Keys"
    And validate the initial value of "Key Type" is not same as new value
    And user take the screenshot for confirmation page for Test case "TC_122406"

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      10 |
