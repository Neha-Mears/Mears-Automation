#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_168109_168101_168111__Add_key_log_Update_booked_out_with_supplier_added
Feature: RLAP Mears_Edit key log - Update booked out by

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "Test TOWN" and "Test, Test, Test Test, Test TOWN, TE1 1TE" click on the address details for new version
    # And user click on Ok appointment page
    Then Click on "Property Details" expansion button
    And user select "Key Details" from drop down List and navigate to "Keys"
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |

  @TC_168101_Living_HO_Edit_key_log-Update_booked_out_by
  Scenario: Living HO_Edit key log - Update booked out by
    Then user click on the plus icon under "Key Log"
    Then user click the calender and select the slot available "October" "2023" "29"
    Then user fill random details for "Notes" as "Generate Random Notes"
    And user click on "Key" the Drop Down List
    And user select "Garage | 1006711858" from dropdown for "Other"
    Then user fill details for "Who Has Key" as "Owner"
    And user click on "Supplier" the Drop Down List
    And user select "Esther, Uriz (J3087L4704-5AA910A7)" from dropdown for "Other"
    And user click on "Booked Out By" the Drop Down List
    And user select "aasc HM" from dropdown for "Other"
    Then user click on "Save" button
    When user click on the descending "Returned" under tab "Key Log"
    Then Validate the "Key Log" is added shows as "Booked Out By" for "aasc HM"
    And user take the screenshot for confirmation page for Test case "TC_167652"
    When user click on the descending "Returned" under tab "Key Log"
    Then user click on edit button under icon name "Key Log"
    And user click on "Booked Out By" the Drop Down List
    And user select "AASC Client" from dropdown for "Other"
    Then user click on "Save" button
    When I click on "mcmview-flex-container property-key-log__container"
    And user select "25" from dropdown for "Other"
    When user click on the descending "Returned" under tab "Key Log"
    Then Validate the "Key Log" is added shows as "Booked Out By" for "AASC Client"
