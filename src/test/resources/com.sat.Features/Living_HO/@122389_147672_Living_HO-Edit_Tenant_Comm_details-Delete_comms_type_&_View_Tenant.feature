#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@122389_147672_Living_HO-Edit_Tenant_Comm_details-Delete_comms_type_&_View_Tenant
Feature: TC_122389: Living HO- Edit Tenant - Comm details - Delete comms type

  Background: 
    Given User Navigate to MCMView App

  @122389_Living_HO-Edit_Tenant_Comm_details-Delete_comms_type
  Scenario Outline: Living HO- Edit Tenant - Comm details - Delete comms type
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "Living_HO_username"
    And user select "Edit Tenant" from drop down List and navigate to "Edit Tenant Details"
    Then user scroll to "Communication Details" and click on delete

    Examples: 
      | username           | password          | serviceName | address               | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |

  @147672_Living_HO-View_Tenant
  Scenario Outline: Living HO - View Tenant
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "Living_HO_username"
    And user select "View Tenant" from drop down List and navigate to "Tenant"

    Examples: 
      | username           | password          | serviceName | address               | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
