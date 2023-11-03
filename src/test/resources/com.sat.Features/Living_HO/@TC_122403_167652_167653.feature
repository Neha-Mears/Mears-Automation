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

  @TC_122403:Living_HO_Add_alarm_details
  Scenario Outline: Living HO_ Add alarm details
    And user select "Key Details" from drop down List and navigate to "Keys"
    Then user validate below field are displayed under Service User
      | Mears Housing Management Limited | Property | Keys |
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |
    Then user click on the edit icon under "Alarm Details"
    Then user generate the unique number for "Code Access Number"
    Then user click on save button
    And user take the screenshot for confirmation page for Test case "TC_122403"

    Examples: 
      | username           | password          | serviceName | address               | message1                   | message2                        | success_msg                  |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | Valid details are required | A valid review date is required | The operation was successful |

  @TC_167652:Living_HO_Edit_alarm-Alert_Password
  Scenario Outline: Living HO_ Edit alarm - Alert Password
    And user select "Key Details" from drop down List and navigate to "Keys"
    Then user validate below field are displayed under Service User
      | Mears Housing Management Limited | Property | Keys |
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |
    Then user click on the edit icon under "Alarm Details"
    When I set the "Alert Password" to "Generate Alert Password"
    When I set the "False Alarm Password" to "Generate False Alarm Password"
    Then user click on save button
    And user take the screenshot for confirmation page for Test case "TC_167652"

    Examples: 
      | username           | password          | serviceName | address               | message1                   | message2                        | success_msg                  |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | Valid details are required | A valid review date is required | The operation was successful |

  @TC_167653:Living_HO_Edit-alarm-False-Alert_Password
  Scenario Outline: Living HO_ Edit alarm - False Alert Password
    And user select "Key Details" from drop down List and navigate to "Keys"
    Then user validate below field are displayed under Service User
      | Mears Housing Management Limited | Property | Keys |
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |
    Then user click on the edit icon under "Alarm Details"
    When I set the "False Alarm Password" to "Generate False Alarm Password"
    Then user click on save button
    And user take the screenshot for confirmation page for Test case "TC_167653"

    Examples: 
      | username           | password          | serviceName | address               | message1                   | message2                        | success_msg                  |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | Valid details are required | A valid review date is required | The operation was successful |
