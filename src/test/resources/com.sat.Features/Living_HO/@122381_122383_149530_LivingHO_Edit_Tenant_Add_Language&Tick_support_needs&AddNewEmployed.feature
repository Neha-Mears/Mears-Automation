#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@122381_122383_149530_LivingHO_Edit_Tenant_Add_Language&Tick_support_needs&AddNewEmployed
Feature: TC_122381_122383: Living HO - Edit Tenant - Add Language_Google Chrome and Tick_support_needs

  Background: 
    Given User Navigate to MCMView App

  @122381_122383_149530_LivingHO_Edit_Tenant_Add_Language-Tick_support_needs-Add_How_employed
  Scenario Outline: Living HO - Edit Tenant - Add Language_Google Chrome and Tick_support_needs and Add How employed
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "<address>" and click on the address details
    Then Scroll down and click on expansion panel header button for "Living_HO_username"
    And user select "Edit Tenant" from drop down List and navigate to "Edit Tenant Details"
    Then user fill details for "Language" as "English"
    And user select "English" from dropdown
    And user select multiple option "1" for the "supportNeeds" checkbox
    And user click on "How Employed?" the Drop Down List
    And user select "Full Time" from dropdown
    Then user click on save button

    Examples: 
      | username           | password          | serviceName | address               | message1                   | message2                        | setmonth | setyear | setDate | success_msg                  |
      | Living_HO_username | Living_HOpassword | Portal      | Room 16, St Catherine | Valid details are required | A valid review date is required | August   |    2023 |      29 | The operation was successful |
