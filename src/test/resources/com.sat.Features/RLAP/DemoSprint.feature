#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_Demo
Feature: RLAP Mears_Edit Service User - Edit Email address

  Background: 
    Given User Navigate to MCMView App

  @TC_167052_167054_167059_RLAP_Mears_Edit_Service_User-Edit_Email_address_Accomdation_status_Edit_Tel_No
  Scenario Outline: RLAP Mears_Edit Service User - Edit Email address and Accomdation status
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "RLAPMearsthreedots"
    And user select "View Service User" from drop down List and navigate to "Service User"
    Then user validate below field are displayed under Service User
      | AASC - Northern Ireland | SSSA10 DA , DA STREET, Gloucester, Gloucestershire, GL13NN, England | Service User (stuart reteststues) |
    Then Scroll down and click on expansion panel header button for "RLAPMearEditServiceUser"
    And user select "Edit Service User" from drop down List and navigate to "Service User Details"
    Then user validate below field are displayed under Service User
      | AASC - Northern Ireland | SSSA10 DA , DA STREET, Gloucester, Gloucestershire, GL13NN, England | Service User ( stuart reteststues) | Edit Service User |
    And user click on "Accommodation Status" the Drop Down List
    And user select "Current" from dropdown
    Then user fill details for "Telephone Number" as "0745626131"
    Then user click on save button

    Examples: 
      | username      | password          | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | RLAPMearsuser | RLAPMearspassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |

  @149444_149445
  Scenario Outline: AASC HM_Edit Service User - Add Email address - Done
    # Given user login to Home Mears Page
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<username>"
    And user select "Edit Service User" from drop down List and navigate to "Service User Details"
    Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
    Then user click on save button

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                |  |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. |  |

  @150537_150538
  Scenario Outline: AASC HM_Service User View and Edit a secondary (Non-Primary) Service User - Done and Religion and Safeguarding -Done
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "<username>"
    And user select "Edit Service User" from drop down List and navigate to "Service User Details"
    Then user fill details for "Email Address" as "neha.sain@mearsgroup.co.uk"
    And user click on "Ethnicity" the Drop Down List
    And user select "Asian" from dropdown
    Then user click on cancel button
    Then user click the  calender and select DOB for "<setmonth>" "<setyear>" "<setDate>"
    And user click on "Religion" the Drop Down List
    And user select "Hinduism" from dropdown
    Then user click on "Dietary Requirements" section
    And user select multiple option "<number of option>" for the "dietaryRequirements" checkbox
    Then user click on "Safeguarding Notes" section
    And user select multiple option "<number of option>" for the "safeGuardingNotes" checkbox
    Then user click on save button

    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                | downloadpath                                                | setmonth | setyear | setDate | number of option |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. | C:/Users/neha.sain/OneDrive - Mears Group/Desktop/image.jpg | May    |    2023 |      19 |                3 |

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
      | username           | password           | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
     # | MCMAppUserName     | MCMAppUserPassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      18 | The operation was successful |
     # | RLAPMearsuser      | RLAPMearspassword  | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
      | Living_HO_username | Living_HOpassword  | Portal      | Room 16, St Catherine                                                    | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |

  @TC_167607_167609_167614_167628_AASC_HM_Address_Page-Add_keys
  Scenario Outline: Make sure User is able to Login
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Click on "Property Details" expansion button
    And user select "Key Details" from drop down List and navigate to "Keys"
    Then user validate below field are displayed under Service User
      | AASC - Northern Ireland | SSSA10 DA , DA STREET, Gloucester, Gloucestershire, GL13NN, England | Property | Keys |
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |
    Then user click on the edit icon under "Alarm Details"
    Then user generate the unique number for "Code Access Number"
    When I set the "Alert Password" to "Generate Alert Password"
    When I set the "False Alarm Password" to "Generate False Alarm Password"
    Then user click on save button
    Then user click on plus icon in keys tab
    Then user fill details for "Keys Held By" as "Finaltest"
    Then user click on save button
    Then user validate the Alert message for "Add Key"
      | A valid key type is required | Number of sets is required | A valid reference is required |
    And user select multiple option "1" for the "default" checkbox
    And user select multiple option "1" for the "noLongerHeld" checkbox
    Then user generate the unique number for "Reference"
    And user click on "Key Type" the Drop Down List
    And user select "Garage" from dropdown
    Then user fill details for "No. of Sets" as "1"
    Then user click on save button
    And user take the screenshot for confirmation page

    Examples: 
      | username           | password          | serviceName | address                                                                  | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | Living_HM_username | Living_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
