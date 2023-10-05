#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@150655_165905_RLAP_AASC_HM_Create_a_AM_appointment_for_today
Feature: TC_150655:AASC HM_Create a AM appointment for today

  Background: 
    Given User Navigate to MCMView App

  @150655_AASC_HM_Create_a_AM_appointment_for_today
  Scenario Outline: AASC HM_Create a PM appointment for today
    # Given user login to Home Mears Page
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Appointment Diary" from drop down List and navigate to "Appointment"
    And select the appointment screen is displaying
    And user select "30" from dropdown
    Then user select the today date for appointment
    And user select the time slot for the appointment "<availableslot>"
    And user select "Create Appointment" from dropdown
    #####################################
    When user search "<address>" and click on the address details
    And user click on "Contract" the Drop Down List for appointment
    And user select "Handy Person" from dropdown for appointment
    And user click on "Priority" the Drop Down List for appointment
    And user select "P2 30 Working Day - Urgent" from dropdown for appointment
    And user click on "Address" the Drop Down List for appointment
    And user select "Mears" from dropdown for appointment
    Then user fill details for "Description" as "AppointmentTest"
    Then Click on the next button
    ###############################################
    And user click on "Client Slot Classification" the Drop Down List for appointment
    And user select "AM (08:00-13:00)" from dropdown for appointment
    And user click on "Trade" the Drop Down List for appointment
    And user select "Housing Manager" from dropdown for appointment
    And user click on "Appointment Type" the Drop Down List for appointment
   And user select "Ad Hoc Visit" from dropdown for appointment
    Then Click on the next button
   # # Then Click on ok pop up window to confirm
   # #Then Click on the next button
   And user take the screenshot for confirmation page
    And click on the Submit button
    Then user validate the popup "<text>" and popup "<message>"
     And user click on Ok appointment page

    ## When user search "<address>" and click on the address details
    Examples: 
      | username      | password          | serviceName | address                                                                  | availableslot | text                                 | message                                                |
      #| MCMViewHMUsername | MCMAppUserPassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 16:00:00      | New Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |
      | RLAPMearsuser | RLAPMearspassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 12:00:00      | New Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |
