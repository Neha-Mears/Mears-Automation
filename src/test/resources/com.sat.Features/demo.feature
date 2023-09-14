#Author:Neha Sain
#Keywords Summary :living_ho@mearsgroup.co.uk
#Feature: Living HO - PM Appt - Drag to AM in a different client classification slot
@90583_Living_HO_PM_Appt_Drag_to_AM_in-a_different_client_classification_slot
Feature: TC_90608:Living HO - PM Appt - Drag to AM in a different client classification slot

  Background: 
    Given User Navigate to MCMView App

  @90583_Living_HO_PM_Appt_Drag_to_AM_in-a_different_client_classification_slot
  Scenario Outline: Living HO - PM Appt - Drag to AM in a different client classification slot
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    Then select navapp "<serviceName>"
    And user select "Appointment Diary" from drop down List and navigate to "Appointment"
    Then user click on the "Day" to view daily appointment
    Then user select the today date for appointment for day
     And user select the tommorow time slot for the appointment "<availableslot>"
    #########################################################
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
       And user take the screenshot for confirmation page
     And click on the Submit button
     Then user validate the popup "<text>" and popup "<message>"
    And user click on Ok appointment page
    ###################################################################
   And user select "Edit Appointment" from dropdown
   Then Click on "Appointment Start Date" calender icon
    Then Appointment start at "<start_time>"
   Then click on the "Set" button
  #  And user click on the Drop Down List
 #   And user select "Materials not available" from dropdown
 #  Then click on the "OK" button
    Then Click on "Appointment End Date" calender icon
  Then Appointment end at "<end_time>"
   Then click on the "Set" button
     Then user fill details for "Appointment Notes" as "Due to busy schedule and bad climate"
    Then user click on save button
    Then user validate the popup "<updatedtext>" and popup "<message>"
    And user click on Ok appointment page
    And user take the screenshot for confirmation page

    Examples: 
      | username           | password           | serviceName | address                                                                  | Contract_name     | Priority_value                        | Address_value | Client_Slot           | Appointment_Type | Trade_value     | availableslot | text                                 | message                                                | start_time | end_time |
     # | MCMViewHMUsername  | MCMAppUserPassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Handy Person      | P2 30 Working Day - Urgent            | Mears         | AM (08:00-13:00)      | Ad Hoc Visit     | Housing Manager | 14:00:00      | New Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |         12 |       14 |
     # | RLAPMearsuser      | RLAPMearspassword  | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Handy Person      | P2 30 Working Day - Urgent            | Mears         | AM (08:00-13:00)      | Ad Hoc Visit     | Housing Manager | 14:00:00      | New Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |         12 |       14 |
      | Living_HO_username | Living_HOpassword  | Portal      |82 Blenheim Court                                                   | Appliances and Soft Furnishing |  C3 C3 - Routine - 28 Calendar Days - Routine  | Landlord      | All Day (08:00-18:00) | Inspection       | Housing Officer | 16:00:00      | New Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |        10 |       11 |
