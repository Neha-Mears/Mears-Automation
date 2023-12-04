#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_149410_RLAP_Mears_User_is_able_to_view_Address_documents_and_download_JPG
Feature: RLAP Mears | User is able to view Address documents and download JPG

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "Test TOWN" and "Test, Test, Test Test, Test TOWN, TE1 1TE" click on the address details for new version

 @TC_149410_RLAP_Mears_User_is_able_to_view_Address_documents_and_download_JPG
  Scenario: RLAP Mears | User is able to view Address documents and download JPG
    Then Click on "Property Details" expansion button
    And user select "View Property" from drop down List and navigate to "Property"
   
     Then Scroll down and click on expansion panel header button for "AllUser" with "previous-work-panel__wrapper"
    And user select "Add Work Order" from drop down List and navigate to "Add New Work Order"
   
