#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_150656_165904AASC_HM_Add_an_sensitive_note
Feature: AASC HM_&_RLAP_Add an sensitive note

  Background: 
    Given User Navigate to MCMView App

  @TC_150656_165904
  Scenario Outline: AASC HM_&_RLAP_Add an sensitive note with sub-type
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Propertiy Tab"
    When user search "<address>" and click on the address details
    Then user click on three dots in service user
    And user select "View Service User" from drop down List and navigate to "Service User"
    Then Click on "Notes" expansion button
    And user select "Add Note" from drop down List and navigate to "Notes header"
    And user click on "Type of Note" the Drop Down List
    And user select "Covid" from dropdown
    And user click on "Sub Type" the Drop Down List
    And user select "Absence" from dropdown
    Then user fill details for "Notes" as "DemotestNotes"
    Then User click on check Box for "Enhanced Confidential Matter"
    Then user click on save button
 Examples: 
      | username          | password           | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
   #   | MCMViewHMUsername | MCMAppUserPassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | July     |    2023 |      28 | The operation was successful |
      | RLAPMearsuser     | RLAPMearspassword  | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | July     |    2023 |      28 | The operation was successful |

  @TC_165906
  Scenario Outline: AASC HM_&_RLAP_Add an sensitive note without sub-type
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Propertiy Tab"
    When user search "<address>" and click on the address details
    Then user click on three dots in service user
    And user select "View Service User" from drop down List and navigate to "Service User"
    Then Click on "Notes" expansion button
    And user select "Add Note" from drop down List and navigate to "Notes header"
    And user click on "Type of Note" the Drop Down List
    And user select "Covid" from dropdown
    Then user fill details for "Notes" as "DemotestNotes"
    Then User click on check Box for "Enhanced Confidential Matter"
    Then user click on save button

  Examples: 
      | username          | password           | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
    #  | MCMViewHMUsername | MCMAppUserPassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | July     |    2023 |      28 | The operation was successful |
      | RLAPMearsuser     | RLAPMearspassword  | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | July     |    2023 |      29 | The operation was successful |
