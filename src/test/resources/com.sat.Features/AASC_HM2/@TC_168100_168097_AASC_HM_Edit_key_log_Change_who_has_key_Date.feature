#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_168100_168097_AASC_HM_Edit_key_log_Change_who_has_key_Date
Feature: AASC HM_Edit key log - Change who has key & Date

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "Thu Jan 13 2022" and "Thu Jan 13 2022 08:33:08 GMT+0000 (GMT Standard Time) Room , Automated Test Street,  Devon,  Exeter Business Park,  England,  EX1 3UT" click on the address details for new version
    Then Click on "Property Details" expansion button
    And user select "Key Details" from drop down List and navigate to "Keys"
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |

@TC_168100_168097_AASC_HM_Edit_key_log_Change_who_has_key_Date
  Scenario: AASC HM_Edit key log - Change who has key & Date
   Then user click on edit button under icon name "Key Log"
    Then user fill random details for "Who Has Key" as "Generate Keys Owner"
    Then user click the calender and select the slot available "November" "2023" "17"
    Then user click on "Save" button
    When user click on the descending "Who has key" under tab "Key Log"
    When I capture the initial value of "Who has key" under "Who has key"
      When I capture the initial value of "Date" under "Date"
    Then user click on edit button under icon name "Key Log"
    Then user fill random details for "Who Has Key" as "Generate Keys Owner"
    Then user click the calender and select the slot available "November" "2023" "19"
    Then user click on "Save" button
    When user click on the descending "Who has key" under tab "Key Log"
    When I capture the new updated value of "Who has key" under "Who has key"
    When I capture the new updated value of "Date" under "Date"
    And validate the initial value of "Date" is not same as new value
  ##  And user take the screenshot for confirmation page for Test case "TC_167726"
