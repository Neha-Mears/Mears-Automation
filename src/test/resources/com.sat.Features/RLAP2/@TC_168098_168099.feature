#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_168098_168099
Feature: Testing of RLAP Mears keys tap

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "Thu Jan 06" and " Thu Jan 06 2022 08:59:09 GMT+0000 (GMT Standard Time) Room , Automated Test Street,  Devon,  Exeter Business Park,  England,  EX1 3UT " click on the address details for new version
    And user click on Ok appointment page
    Then Click on "Property Details" expansion button
    And user select "Key Details" from drop down List and navigate to "Keys"
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |

  @TC_168098_RLAP_Mears_Edit_key_log-_Add_and_edit_notes
  Scenario: Living HO_ Edit key log - Add and edit notes
    Then user click on the plus icon under "Key Log"
    Then user click the calender and select the slot available "October" "2023" "27"
    Then user fill random details for "Notes" as "Generate Random Notes"
    And user click on "Key" the Drop Down List
    And user select "Front Door | 677676" from dropdown for "Other"
    Then user fill details for "Who Has Key" as "Owner"
    And user click on "Booked Out By" the Drop Down List
    And user select "Adam Lucas" from dropdown for "Other"
    Then user click on "Save" button
    When user click on the descending "Returned" under tab "Key Log"
    Then Validate the "Key Log" is added shows as "Notes" for ""
    And user take the screenshot for confirmation page for Test case "TC_167652"
     When user click on the descending "Returned" under tab "Key Log"
    Then user click on edit button under icon name "Key Log"
    Then user fill random details for "Notes" as "Generate Random Notes"
     Then user click on "Save" button
    # When I click on "mcmview-flex-container property-key-log__container"
    # And user select "25" from dropdown for "Other"
     When user click on the descending "Returned" under tab "Key Log"
    Then Validate the "Key Log" is added shows as "Notes" for ""

  @TC_168099_RLAP_Mears_Edit_key_log-Mark_key_as_returned
  Scenario: Living HO_ Edit key log - Add and edit notes
    When user click on the descending "Returned" under tab "Key Log"
    Then user verify checkbox is checked under Returned "Key Log"
    Then user click on edit button under icon name "Key Log"
    And user select multiple option "1" for the "returned" checkbox
    Then user click on "Save" button
    Then user verify checkbox is checked under Returned "Key Log"
    And user take the screenshot for confirmation page for Test case "TC_167652"
