#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@168110_168107_AASC_HM_Add_key_log_with_notes
Feature: TC_149444:  AASC HM_View Service User - Done

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "SSSA10 DA" and "SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version

  @168110_168107_AASC_HM_Update_Actual_Departure
  Scenario Outline: AASC HM_Edit Service User - Add Email address - Done
    Then Click on "Property Details" expansion button
    And user select "Key Details" from drop down List and navigate to "Keys"
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |
    Then user click on the plus icon under "Key Log"
    Then user click the calender and select the slot available "October" "2023" "29"
    Then user fill random details for "Notes" as "Generate Random Notes"
    And user click on "Key" the Drop Down List
    And user select "Garage | 120237242" from dropdown for "Other"
    Then user fill details for "Who Has Key" as "Owner"
    Then user fill random details for "Notes" as "Generate Random Notes"
    And user click on "Booked Out By" the Drop Down List
    And user select "aasc HM" from dropdown for "Other"
    Then user click on "Save" button
    When user click on the descending "Returned" under tab "Key Log"
    Then Validate the "Key Log" is added shows as "Booked Out By" for "AASC Client"
    And user take the screenshot for confirmation page for Test case "TC_168110_168107"

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                |  |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |  |
