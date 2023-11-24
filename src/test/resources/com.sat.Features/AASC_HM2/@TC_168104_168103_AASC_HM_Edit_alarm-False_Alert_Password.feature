#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_168104_168103_AASC_HM_Edit_alarm-False_Alert_Password
Feature: AASC HM_ Edit alarm - False Alert Password

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "Test TOWN" and "Test, Test, Test Test, Test TOWN, TE1 1TE" click on the address details for new version
    Then Click on "Property Details" expansion button
    And user select "Key Details" from drop down List and navigate to "Keys"
    Then user click on the edit icon under "Alarm Details"
    Then user generate the unique number for "Code Access Number"
    When I set the "Alert Password" to "Generate Alert Password"
    When I set the "False Alarm Password" to "Generate False Alarm Password"
    Then user click on "Save" button
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |

  @TC_168104_168103_AASC_HM_Edit_alarm-False_Alert_Password
  Scenario: Living HO_Edit key log - Update booked out by
    Then user click on the edit icon under "Alarm Details"
    Then I reset the content of text box under "Alarm Details" as pre-requist
    When the user checks if the Code Access Number exists for "Code Access Number" under "Alarm Details"
    When I capture the initial value of "Code Access Number" under "Alarm Details"
    Then user click on the edit icon under "Alarm Details"
    Then user generate the unique number for "Code Access Number"
    When I set the "Alert Password" to "Generate Alert Password"
    When I set the "False Alarm Password" to "Generate False Alarm Password"
    Then user click on "Save" button
    When I capture the new updated value of "Alert Password" under "Alarm Details"
    And validate the initial value of "Alert Password" is not same as new value
