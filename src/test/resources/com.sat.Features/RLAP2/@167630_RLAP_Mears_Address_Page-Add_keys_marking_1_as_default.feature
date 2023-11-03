@167630_RLAP_Mears_Address_Page-Add_keys_marking_1_as_default
Feature: TC_167630: RLAP Mears_Address Page - Add keys marking 1 as default

  Background: 
    Given User Navigate to MCMView App

  @167630_RLAP_Mears_Address_Page-Add_keys_marking_1_as_default
  Scenario Outline: RLAP Mears_Address Page - Add keys marking 1 as default
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    # # When user search "<address>" and click on the address details
    When user search "<partaddress>" and "<address>" click on the address details for new version
    #And user click on Ok appointment page
    Then Click on "Property Details" expansion button
    And user select "Key Details" from drop down List and navigate to "Keys"
    And Verify all the values are present under Keys
      | Alarm Details | Keys | Key Log |
    Then user click on plus icon in keys tab
    Then user generate the unique number for "Reference"
    And user click on "Key Type" the Drop Down List
    And user select "Garage" from dropdown for "Other"
    Then user fill details for "No. of Sets" as "4"
    And user select multiple option "1" for the "default" checkbox
    Then user click on "save" button
   # When I click on "property-keys__wrapper"
    #  And user select "50" from dropdown for "Other"
    When user click on the descending "Default" under tab "Keys"
    Then Validate the "Keys" is added shows as "default" for ""
    And user take the screenshot for confirmation page for Test case "TC_167630"

    Examples: 
      | username      | password          | serviceName | partaddress | address                                   |
      | RLAPMearsuser | RLAPMearspassword | Portal      | Test TOWN   | Test, Test, Test Test, Test TOWN, TE1 1TE |
