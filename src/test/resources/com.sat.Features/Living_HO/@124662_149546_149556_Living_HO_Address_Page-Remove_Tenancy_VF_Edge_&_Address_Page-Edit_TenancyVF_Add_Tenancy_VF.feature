#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@124662_149546_149556_Living_HO_Address_Page-Remove_Tenancy_VF_Edge_&_Address_Page-Edit_TenancyVF_Add_Tenancy_VF
Feature: TC_124662: Living HO_Address Page - Remove Tenancy VF_Edge and Address Page - Edit Tenancy VF & Add Tenancy VF

  Background: 
    Given User Navigate to MCMView App

  @124662_149546_149556_Living_HO_Address_Page-Remove_Tenancy_VF_Edge_&_Address_Page-Edit_TenancyVF_Add_Tenancy_VF
  Scenario Outline: Living HO_Address Page - Remove Tenancy VF_Edge and Address Page - Edit Tenancy VF & Add Tenancy VF
     And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "Living_HOexpansion" with ""
    And user select "Edit Tenancy" from drop down List and navigate to "Edit Tenancy"
    And user click on "(Tenancy) Vulnerability Flags" the Drop Down List
    And user select "02. Child under 12 months old in the household" from dropdown for "Other"
   Then user click on "Save" button
    Then user validate red triangle warning on Tenancy detail
    Then user click on red triangle warning button
    Then user validate Tenancy warning containing the VF added is displayed
    Then Scroll down and click on expansion panel header button for "Living_HOexpansion" with ""
    And user select "Edit Tenancy" from drop down List and navigate to "Edit Tenancy"
   And user click on "(Tenancy) Vulnerability Flags" the Drop Down List
    And user delete the content "(Tenancy) Vulnerability Flags" from the Drop Down List
    Then user click on "Save" button
    Then user validate red triangle warning on Tenancy detail

    Examples: 
      | username           | password          | serviceName | address               | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
