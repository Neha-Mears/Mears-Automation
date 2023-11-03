#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_167652_167722_Edit_alarm-Alert_Password_&_edit_notes

Feature: TC_167652:Living HO_ Add alarm details

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "Living_HO_username" and "Living_HOpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "Room 16, St Catherine" and click on the address details
    Then Click on "Property Details" expansion button

  @TC_167652:Living_HO_Edit_alarm-Alert_Password
  Scenario Outline: Living HO_ Edit alarm - Alert Password
    And user select "Key Details" from drop down List and navigate to "Keys"
   # Then user validate below field are displayed under Service User
     # | Mears Housing Management Limited | Room 16, St Catherine's House, 2 Hanworth Road, Feltham, Middlesex, TW13 5AB | Property | Keys |
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |
    Then user click on the edit icon under "Alarm Details"
    When I set the "Alert Password" to "Generate Alert Password"
    Then user click on "Save" button
    And user take the screenshot for confirmation page for Test case "TC_167652"
    Then user click on the plus icon under "Key Log"
    Then user click the calender and select the slot available "<setmonth>" "<setyear>" "<setDate>"
   Then user click on "Save" button

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      10 |

  @TC_167722::Living_HO_Edit_Edit_key_log-Add_and-edit_notes
  Scenario Outline: Living HO_ Edit key log - Add and edit notes
    And user select "Key Details" from drop down List and navigate to "Keys"
    #Then user validate below field are displayed under Service User
    # | Mears Housing Management Limited | Room 16, St Catherine | Property | Keys |
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |
    Then user click on the edit icon under "Alarm Details"
    When I set the "Alert Password" to "Generate Alert Password"
   Then user click on "Save" button
    And user take the screenshot for confirmation page for Test case "TC_167652"
    Then user click on the plus icon under "Key Log"
    Then user click the calender and select the slot available "<setmonth>" "<setyear>" "<setDate>"
    Then user fill random details for "Notes" as "Generate Random Notes"
    And user click on "Key" the Drop Down List
    And user select "File Reference | 478219211" from dropdown for "Other"
    Then user fill details for "Who Has Key" as "Owner"
    And user click on "Booked Out By" the Drop Down List
    And user select "Adam Lucas" from dropdown for "Other"
    Then user click on "Save" button
    And user take the screenshot for confirmation page for Test case "TC_167652"
    Then user click on edit button under icon name "Key Log"
    Then user fill random details for "Notes" as "Generate Random Notes"
   Then user click on "Save" button

    Examples: 
      | username           | password          | serviceName | address               | setmonth | setyear | setDate |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | October  |    2023 |      11 |
