#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@122387_Living_AM-Edit_Tenant-Comm_details-Add_comms_type_to_an_address
Feature: TC_122387: Living AM- Edit Tenant - Comm details - Add comms type to an address

  Background: 
    Given User Navigate to MCMView App

@122387_Living_AM-Edit_Tenant-Comm_details-Add_comms_type_to_an_address
  Scenario Outline: Living AM- Edit Tenant - Comm details - Add comms type to an address
     And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "Living_HOThreeDots" with ""
    And user select "Edit Tenant" from drop down List and navigate to "Edit Tenant Details"
      Then Scroll down and click on expansion panel header button for "Communication Details" with ""
      And user select "Add Communication" from drop down List and navigate to "Communication Details"
      And user click on "Type" the Drop Down List
    And user select "Email" from dropdown for "Other"
    Then user fill details for "Detail" as "neha.hitesh@gmail.com"
    And I click on checkbox Include closed task under Task for this Address "mat-column-default"
     Then user click on "Save" button
      Then Validate the "" is added shows as "Communication Details" for "neha.hitesh@gmail.com"
   # Then user scroll to "Communication Details" and click on delete
   # When the user checks for the message "-- No communication details found --"

    Examples: 
      | username           | password          | serviceName | address               | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | Living_AM_username | Living_AMpassword | Portal      | Room 16, St Catherine | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
