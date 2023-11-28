#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@TC_90608_AASC_HM_Edit_PM-Appt_Change_to_an_hour_earlier_within_same_client_classification_slot
Feature: TC_90608: AASC HM -Edit PM Appt - Change to an hour earlier within same client classification slot

  Background: 
    Given User Navigate to MCMView App

  @90608_AASC_HM_Edit_PM-Appt_Change_to_an_hour_earlier_within_same_client_classification_slot
  Scenario Outline: AASC HM -Edit PM Appt - Change to an hour earlier within same client classification slot
    # Given user login to Home Mears Page
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Appointment Diary" from drop down List and navigate to "Appointment"
    Then user select the today date for appointment for tommorow
    And user select the tommorow time slot for the appointment "<availableslot>"
    #pre condition after 2
    And user select "Create Appointment" from dropdown for "Calender"
    When user search "<address>" and click on the address details
    And user click on "Contract" the Drop Down List for appointment
    And user select "Handy Person" from dropdown for appointment
    And user click on "Priority" the Drop Down List for appointment
    And user select "P2 30 Working Day - Urgent" from dropdown for appointment
    And user click on "Address" the Drop Down List for appointment
    And user select "Mears" from dropdown for appointment
    Then user fill details for "Description" as "AppointmentTest"
    Then Click on the next button
    And user click on "Trade" the Drop Down List for appointment
    And user select "Housing Manager" from dropdown for appointment
    And user click on "Client Slot Classification" the Drop Down List for appointment
    And user select "AM (08:00-13:00)" from dropdown for appointment
    And user click on "Appointment Type" the Drop Down List for appointment
    And user select "Ad Hoc Visit" from dropdown for appointment
    Then Click on the next button
    ##  # Then Click on ok pop up window to confirm "<username>"
    ## #  Then Click on the next button
    And click on the Submit button
    Then user validate the popup "<text>" and popup "<message>"
    Then click on the "OK" button
    #####################pre-condition over################################
    And user select the tommorow time slot for the appointment "<availableslot>"
    And user select "Edit Appointment" from dropdown for "Calender"
    Then Click on "Appointment Start Date" calender icon
    Then Appointment start at "<start_time>"
    Then click on the "Set" button
    ##  # And user click on the Drop Down List
    ## # And user select "Materials not available" from dropdown
    ## # Then click on the "OK" button
    Then Click on "Appointment End Date" calender icon
    Then Appointment end at "<end_time>"
    Then click on the "Set" button
    Then user click on save button
    Then user validate the popup "<text>" and popup "<message>"
    Then click on the "OK" button

    # #  And user take the screenshot for confirmation page for Test case "TC_90608"
    Examples: 
      | username        | password          | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                |  |
      | AASC_HMusername | AASC_HMpassword   | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 10:00:00      |         10 |       11 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |  |
      | RLAPMearsuser   | RLAPMearspassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 10:00:00      |         12 |       13 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |  |
