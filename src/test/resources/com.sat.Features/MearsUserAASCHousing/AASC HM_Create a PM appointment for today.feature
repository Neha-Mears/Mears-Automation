#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@150655_149580_AASC_HM_Living_HO_Create_a_PM_appointment_for_today
Feature: TC:AASC HM_Living_RO_Create a PM appointment for today

  Background: 
    Given User Navigate to MCMView App

  @150655_149580_AASC_HM_Living_HO_Create_a_PM_appointment_for_today
  Scenario Outline: AASC HM_Create a PM appointment for today
    # Given user login to Home Mears Page
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    Then select navapp "<serviceName>"
    And user select "Appointment Diary" from drop down List and navigate to "Appointment"
    Then user select the today date for appointment
    And user select the time slot for the appointment "<availableslot>"
    And user select "Create Appointment" from dropdown
    When user search "<address>" and click on the address details
    And user click on "Contract" the Drop Down List for appointment
    And user select "<Contract_name>" from dropdown for appointment
    And user click on "Priority" the Drop Down List for appointment
    And user select "<Priority_value>" from dropdown for appointment
    And user click on "Address" the Drop Down List for appointment
    And user select "<Address_value>" from dropdown for appointment
    Then user fill details for "Description" as "AppointmentTest"
    Then Click on the next button
    And user click on "Trade" the Drop Down List for appointment
    And user select "<Trade_value>" from dropdown for trade value
    And user click on "Client Slot Classification" the Drop Down List for appointment
    And user select "<Client_Slot>" from dropdown for appointment
    And user click on "Appointment Type" the Drop Down List for appointment
    And user select "Ad Hoc Visit" from dropdown for appointment
    Then Click on the next button
    Then Click on ok pop up window to confirm "<username>"
    #  Then Click on the next button
    And user take the screenshot for confirmation page
    And click on the Submit button
    Then user validate the popup "<text>" and popup "<message>"
    And user click on Ok appointment page

    Examples: 
      | username           | password           | serviceName | address                                                                  | Contract_name     | Priority_value                        | Address_value | Client_Slot           | Appointment_Type | Trade_value     | availableslot | text                                 | message                                                |  |
      | MCMViewHMUsername  | MCMAppUserPassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Handy Person      | P2 30 Working Day - Urgent            | Mears         | AM (08:00-13:00)      | Ad Hoc Visit     | Housing Manager | 14:00:00      | New Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |  |
      | RLAPMearsuser      | RLAPMearspassword  | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Handy Person      | P2 30 Working Day - Urgent            | Mears         | AM (08:00-13:00)      | Ad Hoc Visit     | Housing Manager | 14:00:00      | New Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |  |
      | Living_HO_username | Living_HOpassword  | Portal      | Room 16, St Catherine                                                    | Caretaker Repairs | EICR EICR - Electrical Test - Routine | Landlord      | All Day (08:00-18:00) | Inspection       | Housing Officer | 13:00:00      | New Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |  |
